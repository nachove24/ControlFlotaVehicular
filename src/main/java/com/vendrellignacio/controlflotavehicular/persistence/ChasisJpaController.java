/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vendrellignacio.controlflotavehicular.persistence;

import com.vendrellignacio.controlflotavehicular.logic.Chasis;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.vendrellignacio.controlflotavehicular.logic.Viaje;
import com.vendrellignacio.controlflotavehicular.persistence.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author nacho
 */
public class ChasisJpaController implements Serializable {

    public ChasisJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public ChasisJpaController() {
        emf = Persistence.createEntityManagerFactory("flotaPU");
    }
    
    public void create(Chasis chasis) {
        if (chasis.getListaViajes() == null) {
            chasis.setListaViajes(new ArrayList<Viaje>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Viaje> attachedListaViajes = new ArrayList<Viaje>();
            for (Viaje listaViajesViajeToAttach : chasis.getListaViajes()) {
                listaViajesViajeToAttach = em.getReference(listaViajesViajeToAttach.getClass(), listaViajesViajeToAttach.getId_viaje());
                attachedListaViajes.add(listaViajesViajeToAttach);
            }
            chasis.setListaViajes(attachedListaViajes);
            em.persist(chasis);
            for (Viaje listaViajesViaje : chasis.getListaViajes()) {
                Chasis oldUnChasisOfListaViajesViaje = listaViajesViaje.getUnChasis();
                listaViajesViaje.setUnChasis(chasis);
                listaViajesViaje = em.merge(listaViajesViaje);
                if (oldUnChasisOfListaViajesViaje != null) {
                    oldUnChasisOfListaViajesViaje.getListaViajes().remove(listaViajesViaje);
                    oldUnChasisOfListaViajesViaje = em.merge(oldUnChasisOfListaViajesViaje);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Chasis chasis) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Chasis persistentChasis = em.find(Chasis.class, chasis.getId_chasis());
            List<Viaje> listaViajesOld = persistentChasis.getListaViajes();
            List<Viaje> listaViajesNew = chasis.getListaViajes();
            List<Viaje> attachedListaViajesNew = new ArrayList<Viaje>();
            for (Viaje listaViajesNewViajeToAttach : listaViajesNew) {
                listaViajesNewViajeToAttach = em.getReference(listaViajesNewViajeToAttach.getClass(), listaViajesNewViajeToAttach.getId_viaje());
                attachedListaViajesNew.add(listaViajesNewViajeToAttach);
            }
            listaViajesNew = attachedListaViajesNew;
            chasis.setListaViajes(listaViajesNew);
            chasis = em.merge(chasis);
            for (Viaje listaViajesOldViaje : listaViajesOld) {
                if (!listaViajesNew.contains(listaViajesOldViaje)) {
                    listaViajesOldViaje.setUnChasis(null);
                    listaViajesOldViaje = em.merge(listaViajesOldViaje);
                }
            }
            for (Viaje listaViajesNewViaje : listaViajesNew) {
                if (!listaViajesOld.contains(listaViajesNewViaje)) {
                    Chasis oldUnChasisOfListaViajesNewViaje = listaViajesNewViaje.getUnChasis();
                    listaViajesNewViaje.setUnChasis(chasis);
                    listaViajesNewViaje = em.merge(listaViajesNewViaje);
                    if (oldUnChasisOfListaViajesNewViaje != null && !oldUnChasisOfListaViajesNewViaje.equals(chasis)) {
                        oldUnChasisOfListaViajesNewViaje.getListaViajes().remove(listaViajesNewViaje);
                        oldUnChasisOfListaViajesNewViaje = em.merge(oldUnChasisOfListaViajesNewViaje);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = chasis.getId_chasis();
                if (findChasis(id) == null) {
                    throw new NonexistentEntityException("The chasis with id " + id + " no longer exists.");
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
            Chasis chasis;
            try {
                chasis = em.getReference(Chasis.class, id);
                chasis.getId_chasis();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The chasis with id " + id + " no longer exists.", enfe);
            }
            List<Viaje> listaViajes = chasis.getListaViajes();
            for (Viaje listaViajesViaje : listaViajes) {
                listaViajesViaje.setUnChasis(null);
                listaViajesViaje = em.merge(listaViajesViaje);
            }
            em.remove(chasis);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Chasis> findChasisEntities() {
        return findChasisEntities(true, -1, -1);
    }

    public List<Chasis> findChasisEntities(int maxResults, int firstResult) {
        return findChasisEntities(false, maxResults, firstResult);
    }

    private List<Chasis> findChasisEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Chasis.class));
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

    public Chasis findChasis(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Chasis.class, id);
        } finally {
            em.close();
        }
    }

    public int getChasisCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Chasis> rt = cq.from(Chasis.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public Integer findChaIdByPatente(String chaViaje) {
    EntityManager em = getEntityManager();
    try {
        // Se utiliza un alias "c" para la entidad Chasis y "p" para la entidad Patente
        TypedQuery<Integer> q = em.createQuery("SELECT c.id_chasis FROM Chasis c JOIN c.patente p WHERE p.codigoPatente = :patente", Integer.class);
        q.setParameter("patente", chaViaje); // Asigna el parámetro como String
        return q.getSingleResult();
    } catch (NoResultException e) {
        return null; // Devuelve null si no se encuentra ningún chasis con esa patente
    } finally {
        em.close();
    }
}
    
}
