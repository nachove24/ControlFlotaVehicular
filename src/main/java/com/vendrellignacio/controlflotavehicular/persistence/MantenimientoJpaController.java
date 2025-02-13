/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vendrellignacio.controlflotavehicular.persistence;

import com.vendrellignacio.controlflotavehicular.logic.Mantenimiento;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.vendrellignacio.controlflotavehicular.logic.Patente;
import com.vendrellignacio.controlflotavehicular.persistence.exceptions.NonexistentEntityException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nacho
 */
public class MantenimientoJpaController implements Serializable {

    public MantenimientoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public MantenimientoJpaController() {
        emf = Persistence.createEntityManagerFactory("flotaPU");
    }

    public void create(Mantenimiento mantenimiento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Patente unPatente = mantenimiento.getUnPatente();
            if (unPatente != null) {
                unPatente = em.getReference(unPatente.getClass(), unPatente.getId_patente());
                mantenimiento.setUnPatente(unPatente);
            }
            em.persist(mantenimiento);
            if (unPatente != null) {
                unPatente.getListaMantenimiento().add(mantenimiento);
                unPatente = em.merge(unPatente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mantenimiento mantenimiento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mantenimiento persistentMantenimiento = em.find(Mantenimiento.class, mantenimiento.getId_mantenimiento());
            Patente unPatenteOld = persistentMantenimiento.getUnPatente();
            Patente unPatenteNew = mantenimiento.getUnPatente();
            if (unPatenteNew != null) {
                unPatenteNew = em.getReference(unPatenteNew.getClass(), unPatenteNew.getId_patente());
                mantenimiento.setUnPatente(unPatenteNew);
            }
            mantenimiento = em.merge(mantenimiento);
            if (unPatenteOld != null && !unPatenteOld.equals(unPatenteNew)) {
                unPatenteOld.getListaMantenimiento().remove(mantenimiento);
                unPatenteOld = em.merge(unPatenteOld);
            }
            if (unPatenteNew != null && !unPatenteNew.equals(unPatenteOld)) {
                unPatenteNew.getListaMantenimiento().add(mantenimiento);
                unPatenteNew = em.merge(unPatenteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = mantenimiento.getId_mantenimiento();
                if (findMantenimiento(id) == null) {
                    throw new NonexistentEntityException("The mantenimiento with id " + id + " no longer exists.");
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
            Mantenimiento mantenimiento;
            try {
                mantenimiento = em.getReference(Mantenimiento.class, id);
                mantenimiento.getId_mantenimiento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mantenimiento with id " + id + " no longer exists.", enfe);
            }
            Patente unPatente = mantenimiento.getUnPatente();
            if (unPatente != null) {
                unPatente.getListaMantenimiento().remove(mantenimiento);
                unPatente = em.merge(unPatente);
            }
            em.remove(mantenimiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mantenimiento> findMantenimientoEntities() {
        return findMantenimientoEntities(true, -1, -1);
    }

    public List<Mantenimiento> findMantenimientoEntities(int maxResults, int firstResult) {
        return findMantenimientoEntities(false, maxResults, firstResult);
    }

    private List<Mantenimiento> findMantenimientoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mantenimiento.class));
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

    public Mantenimiento findMantenimiento(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mantenimiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getMantenimientoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mantenimiento> rt = cq.from(Mantenimiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
     public List<Mantenimiento> buscarPorRangoFechas(Date fechaInicial, Date fechaLimite) {
        EntityManager em = getEntityManager();
        try {
            String query = "SELECT m FROM Mantenimiento m WHERE m.fecha BETWEEN :fechaInicial AND :fechaLimite ORDER BY m.fecha DESC";
            
            return em.createQuery(query, Mantenimiento.class)
                .setParameter("fechaInicial", fechaInicial)
                .setParameter("fechaLimite", fechaLimite)
                .getResultList();
        } finally {
            em.close();
        }
    }
     
     public List<Mantenimiento> buscarPorKmMenor(int km) {
    EntityManager em = getEntityManager();
    try {
        String query = "SELECT m FROM Mantenimiento m WHERE m.km < :km ORDER BY m.fecha DESC";
        return em.createQuery(query, Mantenimiento.class)
            .setParameter("km", km)
            .getResultList();
    } finally {
        em.close();
    }
}

public List<Mantenimiento> buscarPorKmMayor(int km) {
    EntityManager em = getEntityManager();
    try {
        String query = "SELECT m FROM Mantenimiento m WHERE m.km > :km ORDER BY m.fecha DESC";
        return em.createQuery(query, Mantenimiento.class)
            .setParameter("km", km)
            .getResultList();
    } finally {
        em.close();
    }
}

public List<Mantenimiento> buscarPorRangoKm(int kmInicial, int kmFinal) {
    EntityManager em = getEntityManager();
    try {
        String query = "SELECT m FROM Mantenimiento m WHERE m.km BETWEEN :kmInicial AND :kmFinal ORDER BY m.fecha DESC";
        return em.createQuery(query, Mantenimiento.class)
            .setParameter("kmInicial", kmInicial)
            .setParameter("kmFinal", kmFinal)
            .getResultList();
    } finally {
        em.close();
    }
}
    
}
