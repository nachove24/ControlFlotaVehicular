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
import com.vendrellignacio.controlflotavehicular.logic.Viaje;
import com.vendrellignacio.controlflotavehicular.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nacho
 */
public class ViajeJpaController implements Serializable {

    public ViajeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public ViajeJpaController() {
        emf = Persistence.createEntityManagerFactory("flotaPU");
    }

    public void create(Viaje viaje) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Acoplado unAcoplado = viaje.getUnAcoplado();
            if (unAcoplado != null) {
                unAcoplado = em.getReference(unAcoplado.getClass(), unAcoplado.getId_acoplado());
                viaje.setUnAcoplado(unAcoplado);
            }
            Chasis unChasis = viaje.getUnChasis();
            if (unChasis != null) {
                unChasis = em.getReference(unChasis.getClass(), unChasis.getId_chasis());
                viaje.setUnChasis(unChasis);
            }
            em.persist(viaje);
            if (unAcoplado != null) {
                unAcoplado.getListaViajes().add(viaje);
                unAcoplado = em.merge(unAcoplado);
            }
            if (unChasis != null) {
                unChasis.getListaViajes().add(viaje);
                unChasis = em.merge(unChasis);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Viaje viaje) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Viaje persistentViaje = em.find(Viaje.class, viaje.getId_viaje());
            Acoplado unAcopladoOld = persistentViaje.getUnAcoplado();
            Acoplado unAcopladoNew = viaje.getUnAcoplado();
            Chasis unChasisOld = persistentViaje.getUnChasis();
            Chasis unChasisNew = viaje.getUnChasis();
            if (unAcopladoNew != null) {
                unAcopladoNew = em.getReference(unAcopladoNew.getClass(), unAcopladoNew.getId_acoplado());
                viaje.setUnAcoplado(unAcopladoNew);
            }
            if (unChasisNew != null) {
                unChasisNew = em.getReference(unChasisNew.getClass(), unChasisNew.getId_chasis());
                viaje.setUnChasis(unChasisNew);
            }
            viaje = em.merge(viaje);
            if (unAcopladoOld != null && !unAcopladoOld.equals(unAcopladoNew)) {
                unAcopladoOld.getListaViajes().remove(viaje);
                unAcopladoOld = em.merge(unAcopladoOld);
            }
            if (unAcopladoNew != null && !unAcopladoNew.equals(unAcopladoOld)) {
                unAcopladoNew.getListaViajes().add(viaje);
                unAcopladoNew = em.merge(unAcopladoNew);
            }
            if (unChasisOld != null && !unChasisOld.equals(unChasisNew)) {
                unChasisOld.getListaViajes().remove(viaje);
                unChasisOld = em.merge(unChasisOld);
            }
            if (unChasisNew != null && !unChasisNew.equals(unChasisOld)) {
                unChasisNew.getListaViajes().add(viaje);
                unChasisNew = em.merge(unChasisNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = viaje.getId_viaje();
                if (findViaje(id) == null) {
                    throw new NonexistentEntityException("The viaje with id " + id + " no longer exists.");
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
            Viaje viaje;
            try {
                viaje = em.getReference(Viaje.class, id);
                viaje.getId_viaje();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viaje with id " + id + " no longer exists.", enfe);
            }
            Acoplado unAcoplado = viaje.getUnAcoplado();
            if (unAcoplado != null) {
                unAcoplado.getListaViajes().remove(viaje);
                unAcoplado = em.merge(unAcoplado);
            }
            Chasis unChasis = viaje.getUnChasis();
            if (unChasis != null) {
                unChasis.getListaViajes().remove(viaje);
                unChasis = em.merge(unChasis);
            }
            em.remove(viaje);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Viaje> findViajeEntities() {
        return findViajeEntities(true, -1, -1);
    }

    public List<Viaje> findViajeEntities(int maxResults, int firstResult) {
        return findViajeEntities(false, maxResults, firstResult);
    }

    private List<Viaje> findViajeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Viaje.class));
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

    public Viaje findViaje(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Viaje.class, id);
        } finally {
            em.close();
        }
    }

    public int getViajeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Viaje> rt = cq.from(Viaje.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}