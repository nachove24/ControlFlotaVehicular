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
import com.vendrellignacio.controlflotavehicular.logic.Acoplado;
import com.vendrellignacio.controlflotavehicular.logic.Chasis;
import com.vendrellignacio.controlflotavehicular.logic.Neumatico;
import com.vendrellignacio.controlflotavehicular.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nacho
 */
public class NeumaticoJpaController implements Serializable {

    public NeumaticoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public NeumaticoJpaController() {
        emf = Persistence.createEntityManagerFactory("flotaPU");
    }

    public void create(Neumatico neumatico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Acoplado unAcoplado = neumatico.getUnAcoplado();
            if (unAcoplado != null) {
                unAcoplado = em.getReference(unAcoplado.getClass(), unAcoplado.getId_acoplado());
                neumatico.setUnAcoplado(unAcoplado);
            }
            Chasis unChasis = neumatico.getUnChasis();
            if (unChasis != null) {
                unChasis = em.getReference(unChasis.getClass(), unChasis.getId_chasis());
                neumatico.setUnChasis(unChasis);
            }
            em.persist(neumatico);
            if (unAcoplado != null) {
                unAcoplado.getListaNeumatico().add(neumatico);
                unAcoplado = em.merge(unAcoplado);
            }
            if (unChasis != null) {
                unChasis.getListaNeumaticos().add(neumatico);
                unChasis = em.merge(unChasis);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Neumatico neumatico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Neumatico persistentNeumatico = em.find(Neumatico.class, neumatico.getId_neumatico());
            Acoplado unAcopladoOld = persistentNeumatico.getUnAcoplado();
            Acoplado unAcopladoNew = neumatico.getUnAcoplado();
            Chasis unChasisOld = persistentNeumatico.getUnChasis();
            Chasis unChasisNew = neumatico.getUnChasis();
            if (unAcopladoNew != null) {
                unAcopladoNew = em.getReference(unAcopladoNew.getClass(), unAcopladoNew.getId_acoplado());
                neumatico.setUnAcoplado(unAcopladoNew);
            }
            if (unChasisNew != null) {
                unChasisNew = em.getReference(unChasisNew.getClass(), unChasisNew.getId_chasis());
                neumatico.setUnChasis(unChasisNew);
            }
            neumatico = em.merge(neumatico);
            if (unAcopladoOld != null && !unAcopladoOld.equals(unAcopladoNew)) {
                unAcopladoOld.getListaNeumatico().remove(neumatico);
                unAcopladoOld = em.merge(unAcopladoOld);
            }
            if (unAcopladoNew != null && !unAcopladoNew.equals(unAcopladoOld)) {
                unAcopladoNew.getListaNeumatico().add(neumatico);
                unAcopladoNew = em.merge(unAcopladoNew);
            }
            if (unChasisOld != null && !unChasisOld.equals(unChasisNew)) {
                unChasisOld.getListaNeumaticos().remove(neumatico);
                unChasisOld = em.merge(unChasisOld);
            }
            if (unChasisNew != null && !unChasisNew.equals(unChasisOld)) {
                unChasisNew.getListaNeumaticos().add(neumatico);
                unChasisNew = em.merge(unChasisNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = neumatico.getId_neumatico();
                if (findNeumatico(id) == null) {
                    throw new NonexistentEntityException("The neumatico with id " + id + " no longer exists.");
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
            Neumatico neumatico;
            try {
                neumatico = em.getReference(Neumatico.class, id);
                neumatico.getId_neumatico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The neumatico with id " + id + " no longer exists.", enfe);
            }
            Acoplado unAcoplado = neumatico.getUnAcoplado();
            if (unAcoplado != null) {
                unAcoplado.getListaNeumatico().remove(neumatico);
                unAcoplado = em.merge(unAcoplado);
            }
            Chasis unChasis = neumatico.getUnChasis();
            if (unChasis != null) {
                unChasis.getListaNeumaticos().remove(neumatico);
                unChasis = em.merge(unChasis);
            }
            em.remove(neumatico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Neumatico> findNeumaticoEntities() {
        return findNeumaticoEntities(true, -1, -1);
    }

    public List<Neumatico> findNeumaticoEntities(int maxResults, int firstResult) {
        return findNeumaticoEntities(false, maxResults, firstResult);
    }

    private List<Neumatico> findNeumaticoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Neumatico.class));
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

    public Neumatico findNeumatico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Neumatico.class, id);
        } finally {
            em.close();
        }
    }

    public int getNeumaticoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Neumatico> rt = cq.from(Neumatico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
