/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vendrellignacio.controlflotavehicular.persistence;

import com.vendrellignacio.controlflotavehicular.logic.Patente;
import com.vendrellignacio.controlflotavehicular.persistence.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author nacho
 */
public class PatenteJpaController implements Serializable {

    public PatenteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public PatenteJpaController() {
        emf = Persistence.createEntityManagerFactory("flotaPU");
    }

    public void create(Patente patente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(patente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Patente patente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            patente = em.merge(patente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = patente.getId_patente();
                if (findPatente(id) == null) {
                    throw new NonexistentEntityException("The patente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Patente patente;
            try {
                patente = em.getReference(Patente.class, id);
                patente.getId_patente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The patente with id " + id + " no longer exists.", enfe);
            }
            em.remove(patente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Patente> findPatenteEntities() {
        return findPatenteEntities(true, -1, -1);
    }

    public List<Patente> findPatenteEntities(int maxResults, int firstResult) {
        return findPatenteEntities(false, maxResults, firstResult);
    }

    private List<Patente> findPatenteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Patente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Patente findPatente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Patente.class, id);
        } finally {
            em.close();
        }
    }

    public int getPatenteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Patente> rt = cq.from(Patente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
