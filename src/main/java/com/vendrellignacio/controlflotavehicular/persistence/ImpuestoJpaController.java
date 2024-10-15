/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vendrellignacio.controlflotavehicular.persistence;

import com.vendrellignacio.controlflotavehicular.logic.Impuesto;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.vendrellignacio.controlflotavehicular.logic.Patente;
import com.vendrellignacio.controlflotavehicular.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author nacho
 */
public class ImpuestoJpaController implements Serializable {

    public ImpuestoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Impuesto impuesto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Patente unPatente = impuesto.getUnPatente();
            if (unPatente != null) {
                unPatente = em.getReference(unPatente.getClass(), unPatente.getId_patente());
                impuesto.setUnPatente(unPatente);
            }
            em.persist(impuesto);
            if (unPatente != null) {
                unPatente.getListaImpuestos().add(impuesto);
                unPatente = em.merge(unPatente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Impuesto impuesto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Impuesto persistentImpuesto = em.find(Impuesto.class, impuesto.getId_impuesto());
            Patente unPatenteOld = persistentImpuesto.getUnPatente();
            Patente unPatenteNew = impuesto.getUnPatente();
            if (unPatenteNew != null) {
                unPatenteNew = em.getReference(unPatenteNew.getClass(), unPatenteNew.getId_patente());
                impuesto.setUnPatente(unPatenteNew);
            }
            impuesto = em.merge(impuesto);
            if (unPatenteOld != null && !unPatenteOld.equals(unPatenteNew)) {
                unPatenteOld.getListaImpuestos().remove(impuesto);
                unPatenteOld = em.merge(unPatenteOld);
            }
            if (unPatenteNew != null && !unPatenteNew.equals(unPatenteOld)) {
                unPatenteNew.getListaImpuestos().add(impuesto);
                unPatenteNew = em.merge(unPatenteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = impuesto.getId_impuesto();
                if (findImpuesto(id) == null) {
                    throw new NonexistentEntityException("The impuesto with id " + id + " no longer exists.");
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
            Impuesto impuesto;
            try {
                impuesto = em.getReference(Impuesto.class, id);
                impuesto.getId_impuesto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The impuesto with id " + id + " no longer exists.", enfe);
            }
            Patente unPatente = impuesto.getUnPatente();
            if (unPatente != null) {
                unPatente.getListaImpuestos().remove(impuesto);
                unPatente = em.merge(unPatente);
            }
            em.remove(impuesto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Impuesto> findImpuestoEntities() {
        return findImpuestoEntities(true, -1, -1);
    }

    public List<Impuesto> findImpuestoEntities(int maxResults, int firstResult) {
        return findImpuestoEntities(false, maxResults, firstResult);
    }

    private List<Impuesto> findImpuestoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Impuesto.class));
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

    public Impuesto findImpuesto(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Impuesto.class, id);
        } finally {
            em.close();
        }
    }

    public int getImpuestoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Impuesto> rt = cq.from(Impuesto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
