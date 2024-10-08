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
import com.vendrellignacio.controlflotavehicular.logic.Neumatico;
import com.vendrellignacio.controlflotavehicular.logic.Patente;
import com.vendrellignacio.controlflotavehicular.persistence.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        if (patente.getListaNeumaticos() == null) {
            patente.setListaNeumaticos(new ArrayList<Neumatico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Neumatico> attachedListaNeumaticos = new ArrayList<Neumatico>();
            for (Neumatico listaNeumaticosNeumaticoToAttach : patente.getListaNeumaticos()) {
                listaNeumaticosNeumaticoToAttach = em.getReference(listaNeumaticosNeumaticoToAttach.getClass(), listaNeumaticosNeumaticoToAttach.getId_neumatico());
                attachedListaNeumaticos.add(listaNeumaticosNeumaticoToAttach);
            }
            patente.setListaNeumaticos(attachedListaNeumaticos);
            em.persist(patente);
            for (Neumatico listaNeumaticosNeumatico : patente.getListaNeumaticos()) {
                Patente oldUnPatenteOfListaNeumaticosNeumatico = listaNeumaticosNeumatico.getUnPatente();
                listaNeumaticosNeumatico.setUnPatente(patente);
                listaNeumaticosNeumatico = em.merge(listaNeumaticosNeumatico);
                if (oldUnPatenteOfListaNeumaticosNeumatico != null) {
                    oldUnPatenteOfListaNeumaticosNeumatico.getListaNeumaticos().remove(listaNeumaticosNeumatico);
                    oldUnPatenteOfListaNeumaticosNeumatico = em.merge(oldUnPatenteOfListaNeumaticosNeumatico);
                }
            }
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
            Patente persistentPatente = em.find(Patente.class, patente.getId_patente());
            List<Neumatico> listaNeumaticosOld = persistentPatente.getListaNeumaticos();
            List<Neumatico> listaNeumaticosNew = patente.getListaNeumaticos();
            List<Neumatico> attachedListaNeumaticosNew = new ArrayList<Neumatico>();
            for (Neumatico listaNeumaticosNewNeumaticoToAttach : listaNeumaticosNew) {
                listaNeumaticosNewNeumaticoToAttach = em.getReference(listaNeumaticosNewNeumaticoToAttach.getClass(), listaNeumaticosNewNeumaticoToAttach.getId_neumatico());
                attachedListaNeumaticosNew.add(listaNeumaticosNewNeumaticoToAttach);
            }
            listaNeumaticosNew = attachedListaNeumaticosNew;
            patente.setListaNeumaticos(listaNeumaticosNew);
            patente = em.merge(patente);
            for (Neumatico listaNeumaticosOldNeumatico : listaNeumaticosOld) {
                if (!listaNeumaticosNew.contains(listaNeumaticosOldNeumatico)) {
                    listaNeumaticosOldNeumatico.setUnPatente(null);
                    listaNeumaticosOldNeumatico = em.merge(listaNeumaticosOldNeumatico);
                }
            }
            for (Neumatico listaNeumaticosNewNeumatico : listaNeumaticosNew) {
                if (!listaNeumaticosOld.contains(listaNeumaticosNewNeumatico)) {
                    Patente oldUnPatenteOfListaNeumaticosNewNeumatico = listaNeumaticosNewNeumatico.getUnPatente();
                    listaNeumaticosNewNeumatico.setUnPatente(patente);
                    listaNeumaticosNewNeumatico = em.merge(listaNeumaticosNewNeumatico);
                    if (oldUnPatenteOfListaNeumaticosNewNeumatico != null && !oldUnPatenteOfListaNeumaticosNewNeumatico.equals(patente)) {
                        oldUnPatenteOfListaNeumaticosNewNeumatico.getListaNeumaticos().remove(listaNeumaticosNewNeumatico);
                        oldUnPatenteOfListaNeumaticosNewNeumatico = em.merge(oldUnPatenteOfListaNeumaticosNewNeumatico);
                    }
                }
            }
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
            List<Neumatico> listaNeumaticos = patente.getListaNeumaticos();
            for (Neumatico listaNeumaticosNeumatico : listaNeumaticos) {
                listaNeumaticosNeumatico.setUnPatente(null);
                listaNeumaticosNeumatico = em.merge(listaNeumaticosNeumatico);
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
