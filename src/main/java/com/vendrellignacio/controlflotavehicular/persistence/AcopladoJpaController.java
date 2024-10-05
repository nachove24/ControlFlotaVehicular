/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vendrellignacio.controlflotavehicular.persistence;

import com.vendrellignacio.controlflotavehicular.logic.Acoplado;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.vendrellignacio.controlflotavehicular.logic.Neumatico;
import java.util.ArrayList;
import java.util.List;
import com.vendrellignacio.controlflotavehicular.logic.Viaje;
import com.vendrellignacio.controlflotavehicular.persistence.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author nacho
 */
public class AcopladoJpaController implements Serializable {

    public AcopladoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public AcopladoJpaController() {
        emf = Persistence.createEntityManagerFactory("flotaPU");
    }

    

    public void create(Acoplado acoplado) {
        if (acoplado.getListaNeumatico() == null) {
            acoplado.setListaNeumatico(new ArrayList<Neumatico>());
        }
        if (acoplado.getListaViajes() == null) {
            acoplado.setListaViajes(new ArrayList<Viaje>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Neumatico> attachedListaNeumatico = new ArrayList<Neumatico>();
            for (Neumatico listaNeumaticoNeumaticoToAttach : acoplado.getListaNeumatico()) {
                listaNeumaticoNeumaticoToAttach = em.getReference(listaNeumaticoNeumaticoToAttach.getClass(), listaNeumaticoNeumaticoToAttach.getId_neumatico());
                attachedListaNeumatico.add(listaNeumaticoNeumaticoToAttach);
            }
            acoplado.setListaNeumatico(attachedListaNeumatico);
            List<Viaje> attachedListaViajes = new ArrayList<Viaje>();
            for (Viaje listaViajesViajeToAttach : acoplado.getListaViajes()) {
                listaViajesViajeToAttach = em.getReference(listaViajesViajeToAttach.getClass(), listaViajesViajeToAttach.getId_viaje());
                attachedListaViajes.add(listaViajesViajeToAttach);
            }
            acoplado.setListaViajes(attachedListaViajes);
            em.persist(acoplado);
            for (Neumatico listaNeumaticoNeumatico : acoplado.getListaNeumatico()) {
                Acoplado oldUnAcopladoOfListaNeumaticoNeumatico = listaNeumaticoNeumatico.getUnAcoplado();
                listaNeumaticoNeumatico.setUnAcoplado(acoplado);
                listaNeumaticoNeumatico = em.merge(listaNeumaticoNeumatico);
                if (oldUnAcopladoOfListaNeumaticoNeumatico != null) {
                    oldUnAcopladoOfListaNeumaticoNeumatico.getListaNeumatico().remove(listaNeumaticoNeumatico);
                    oldUnAcopladoOfListaNeumaticoNeumatico = em.merge(oldUnAcopladoOfListaNeumaticoNeumatico);
                }
            }
            for (Viaje listaViajesViaje : acoplado.getListaViajes()) {
                Acoplado oldUnAcopladoOfListaViajesViaje = listaViajesViaje.getUnAcoplado();
                listaViajesViaje.setUnAcoplado(acoplado);
                listaViajesViaje = em.merge(listaViajesViaje);
                if (oldUnAcopladoOfListaViajesViaje != null) {
                    oldUnAcopladoOfListaViajesViaje.getListaViajes().remove(listaViajesViaje);
                    oldUnAcopladoOfListaViajesViaje = em.merge(oldUnAcopladoOfListaViajesViaje);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Acoplado acoplado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Acoplado persistentAcoplado = em.find(Acoplado.class, acoplado.getId_acoplado());
            List<Neumatico> listaNeumaticoOld = persistentAcoplado.getListaNeumatico();
            List<Neumatico> listaNeumaticoNew = acoplado.getListaNeumatico();
            List<Viaje> listaViajesOld = persistentAcoplado.getListaViajes();
            List<Viaje> listaViajesNew = acoplado.getListaViajes();
            List<Neumatico> attachedListaNeumaticoNew = new ArrayList<Neumatico>();
            for (Neumatico listaNeumaticoNewNeumaticoToAttach : listaNeumaticoNew) {
                listaNeumaticoNewNeumaticoToAttach = em.getReference(listaNeumaticoNewNeumaticoToAttach.getClass(), listaNeumaticoNewNeumaticoToAttach.getId_neumatico());
                attachedListaNeumaticoNew.add(listaNeumaticoNewNeumaticoToAttach);
            }
            listaNeumaticoNew = attachedListaNeumaticoNew;
            acoplado.setListaNeumatico(listaNeumaticoNew);
            List<Viaje> attachedListaViajesNew = new ArrayList<Viaje>();
            for (Viaje listaViajesNewViajeToAttach : listaViajesNew) {
                listaViajesNewViajeToAttach = em.getReference(listaViajesNewViajeToAttach.getClass(), listaViajesNewViajeToAttach.getId_viaje());
                attachedListaViajesNew.add(listaViajesNewViajeToAttach);
            }
            listaViajesNew = attachedListaViajesNew;
            acoplado.setListaViajes(listaViajesNew);
            acoplado = em.merge(acoplado);
            for (Neumatico listaNeumaticoOldNeumatico : listaNeumaticoOld) {
                if (!listaNeumaticoNew.contains(listaNeumaticoOldNeumatico)) {
                    listaNeumaticoOldNeumatico.setUnAcoplado(null);
                    listaNeumaticoOldNeumatico = em.merge(listaNeumaticoOldNeumatico);
                }
            }
            for (Neumatico listaNeumaticoNewNeumatico : listaNeumaticoNew) {
                if (!listaNeumaticoOld.contains(listaNeumaticoNewNeumatico)) {
                    Acoplado oldUnAcopladoOfListaNeumaticoNewNeumatico = listaNeumaticoNewNeumatico.getUnAcoplado();
                    listaNeumaticoNewNeumatico.setUnAcoplado(acoplado);
                    listaNeumaticoNewNeumatico = em.merge(listaNeumaticoNewNeumatico);
                    if (oldUnAcopladoOfListaNeumaticoNewNeumatico != null && !oldUnAcopladoOfListaNeumaticoNewNeumatico.equals(acoplado)) {
                        oldUnAcopladoOfListaNeumaticoNewNeumatico.getListaNeumatico().remove(listaNeumaticoNewNeumatico);
                        oldUnAcopladoOfListaNeumaticoNewNeumatico = em.merge(oldUnAcopladoOfListaNeumaticoNewNeumatico);
                    }
                }
            }
            for (Viaje listaViajesOldViaje : listaViajesOld) {
                if (!listaViajesNew.contains(listaViajesOldViaje)) {
                    listaViajesOldViaje.setUnAcoplado(null);
                    listaViajesOldViaje = em.merge(listaViajesOldViaje);
                }
            }
            for (Viaje listaViajesNewViaje : listaViajesNew) {
                if (!listaViajesOld.contains(listaViajesNewViaje)) {
                    Acoplado oldUnAcopladoOfListaViajesNewViaje = listaViajesNewViaje.getUnAcoplado();
                    listaViajesNewViaje.setUnAcoplado(acoplado);
                    listaViajesNewViaje = em.merge(listaViajesNewViaje);
                    if (oldUnAcopladoOfListaViajesNewViaje != null && !oldUnAcopladoOfListaViajesNewViaje.equals(acoplado)) {
                        oldUnAcopladoOfListaViajesNewViaje.getListaViajes().remove(listaViajesNewViaje);
                        oldUnAcopladoOfListaViajesNewViaje = em.merge(oldUnAcopladoOfListaViajesNewViaje);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = acoplado.getId_acoplado();
                if (findAcoplado(id) == null) {
                    throw new NonexistentEntityException("The acoplado with id " + id + " no longer exists.");
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
            Acoplado acoplado;
            try {
                acoplado = em.getReference(Acoplado.class, id);
                acoplado.getId_acoplado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The acoplado with id " + id + " no longer exists.", enfe);
            }
            List<Neumatico> listaNeumatico = acoplado.getListaNeumatico();
            for (Neumatico listaNeumaticoNeumatico : listaNeumatico) {
                listaNeumaticoNeumatico.setUnAcoplado(null);
                listaNeumaticoNeumatico = em.merge(listaNeumaticoNeumatico);
            }
            List<Viaje> listaViajes = acoplado.getListaViajes();
            for (Viaje listaViajesViaje : listaViajes) {
                listaViajesViaje.setUnAcoplado(null);
                listaViajesViaje = em.merge(listaViajesViaje);
            }
            em.remove(acoplado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Acoplado> findAcopladoEntities() {
        return findAcopladoEntities(true, -1, -1);
    }

    public List<Acoplado> findAcopladoEntities(int maxResults, int firstResult) {
        return findAcopladoEntities(false, maxResults, firstResult);
    }

    private List<Acoplado> findAcopladoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Acoplado.class));
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

    public Acoplado findAcoplado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Acoplado.class, id);
        } finally {
            em.close();
        }
    }

    public int getAcopladoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Acoplado> rt = cq.from(Acoplado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public Integer findAcoIdByPatente(String acoViaje) {
    EntityManager em = getEntityManager();
    try {
        // Se utiliza un alias "c" para la entidad Chasis y "p" para la entidad Patente
        TypedQuery<Integer> q = em.createQuery("SELECT c.id_acoplado FROM Acoplado c JOIN c.patente p WHERE p.codigoPatente = :patente", Integer.class);
        q.setParameter("patente", acoViaje); // Asigna el parámetro como String
        return q.getSingleResult();
    } catch (NoResultException e) {
        return null; // Devuelve null si no se encuentra ningún chasis con esa patente
    } finally {
        em.close();
    }
}
    
}
