/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vendrellignacio.controlflotavehicular.persistence;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.vendrellignacio.controlflotavehicular.logic.Patente;
import com.vendrellignacio.controlflotavehicular.logic.Tecnica;
import com.vendrellignacio.controlflotavehicular.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author nacho
 */
public class TecnicaJpaController implements Serializable {

    public TecnicaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tecnica tecnica) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Patente unPatente = tecnica.getUnPatente();
            if (unPatente != null) {
                unPatente = em.getReference(unPatente.getClass(), unPatente.getId_patente());
                tecnica.setUnPatente(unPatente);
            }
            em.persist(tecnica);
            if (unPatente != null) {
                unPatente.getListaTecnicas().add(tecnica);
                unPatente = em.merge(unPatente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tecnica tecnica) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tecnica persistentTecnica = em.find(Tecnica.class, tecnica.getId_tecnica());
            Patente unPatenteOld = persistentTecnica.getUnPatente();
            Patente unPatenteNew = tecnica.getUnPatente();
            if (unPatenteNew != null) {
                unPatenteNew = em.getReference(unPatenteNew.getClass(), unPatenteNew.getId_patente());
                tecnica.setUnPatente(unPatenteNew);
            }
            tecnica = em.merge(tecnica);
            if (unPatenteOld != null && !unPatenteOld.equals(unPatenteNew)) {
                unPatenteOld.getListaTecnicas().remove(tecnica);
                unPatenteOld = em.merge(unPatenteOld);
            }
            if (unPatenteNew != null && !unPatenteNew.equals(unPatenteOld)) {
                unPatenteNew.getListaTecnicas().add(tecnica);
                unPatenteNew = em.merge(unPatenteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tecnica.getId_tecnica();
                if (findTecnica(id) == null) {
                    throw new NonexistentEntityException("The tecnica with id " + id + " no longer exists.");
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
            Tecnica tecnica;
            try {
                tecnica = em.getReference(Tecnica.class, id);
                tecnica.getId_tecnica();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tecnica with id " + id + " no longer exists.", enfe);
            }
            Patente unPatente = tecnica.getUnPatente();
            if (unPatente != null) {
                unPatente.getListaTecnicas().remove(tecnica);
                unPatente = em.merge(unPatente);
            }
            em.remove(tecnica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tecnica> findTecnicaEntities() {
        return findTecnicaEntities(true, -1, -1);
    }

    public List<Tecnica> findTecnicaEntities(int maxResults, int firstResult) {
        return findTecnicaEntities(false, maxResults, firstResult);
    }

    private List<Tecnica> findTecnicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tecnica.class));
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

    public Tecnica findTecnica(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tecnica.class, id);
        } finally {
            em.close();
        }
    }

    public int getTecnicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tecnica> rt = cq.from(Tecnica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
