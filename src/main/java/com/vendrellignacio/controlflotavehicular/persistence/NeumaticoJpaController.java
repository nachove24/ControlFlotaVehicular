/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vendrellignacio.controlflotavehicular.persistence;

import com.vendrellignacio.controlflotavehicular.logic.Neumatico;
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
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
            Patente unPatente = neumatico.getUnPatente();
            if (unPatente != null) {
                unPatente = em.getReference(unPatente.getClass(), unPatente.getId_patente());
                neumatico.setUnPatente(unPatente);
            }
            em.persist(neumatico);
            if (unPatente != null) {
                unPatente.getListaNeumaticos().add(neumatico);
                unPatente = em.merge(unPatente);
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
            Patente unPatenteOld = persistentNeumatico.getUnPatente();
            Patente unPatenteNew = neumatico.getUnPatente();
            if (unPatenteNew != null) {
                unPatenteNew = em.getReference(unPatenteNew.getClass(), unPatenteNew.getId_patente());
                neumatico.setUnPatente(unPatenteNew);
            }
            neumatico = em.merge(neumatico);
            if (unPatenteOld != null && !unPatenteOld.equals(unPatenteNew)) {
                unPatenteOld.getListaNeumaticos().remove(neumatico);
                unPatenteOld = em.merge(unPatenteOld);
            }
            if (unPatenteNew != null && !unPatenteNew.equals(unPatenteOld)) {
                unPatenteNew.getListaNeumaticos().add(neumatico);
                unPatenteNew = em.merge(unPatenteNew);
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
            Patente unPatente = neumatico.getUnPatente();
            if (unPatente != null) {
                unPatente.getListaNeumaticos().remove(neumatico);
                unPatente = em.merge(unPatente);
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

    public Neumatico buscarPorCodigo(String codigo) {
     EntityManager em = getEntityManager();
    try {
        String query;
        TypedQuery<Neumatico> typedQuery;

        if (codigo.matches("\\d+")) { // Verifica si el código es solo números
            query = "SELECT n FROM Neumatico n WHERE CAST(n.cod_neumatico AS string) = :codigo";
        } else {
            query = "SELECT n FROM Neumatico n WHERE n.cod_neumatico = :codigo";
        }

        typedQuery = em.createQuery(query, Neumatico.class).setParameter("codigo", codigo);

        return typedQuery.getSingleResult();
    } catch (NoResultException e) {
        return null;
    } finally {
        em.close();
    }
}

    List<Neumatico> buscarPorRangoFechas(Date fechaInicial, Date fechaLimite) {
        EntityManager em = getEntityManager();
    try {
        String query = "SELECT n FROM Neumatico n WHERE n.fechaUso BETWEEN :fechaInicial AND :fechaLimite ORDER BY n.fechaUso DESC";
        
        return em.createQuery(query, Neumatico.class)
            .setParameter("fechaInicial", fechaInicial)
            .setParameter("fechaLimite", fechaLimite)
            .getResultList();
    } finally {
        em.close();
    }
    }

    List<Neumatico> buscarPorKmMenor(double km) {
        EntityManager em = getEntityManager();
    try {
        String query = "SELECT n FROM Neumatico n WHERE n.kmTotal < :km ORDER BY n.kmTotal DESC";
        
        return em.createQuery(query, Neumatico.class)
            .setParameter("km", km)
            .getResultList();
    } finally {
        em.close();
    }
    }

    List<Neumatico> buscarPorKmMayor(double km) {
        EntityManager em = getEntityManager();
    try {
        String query = "SELECT n FROM Neumatico n WHERE n.kmTotal > :km ORDER BY n.kmTotal ASC";
        
        return em.createQuery(query, Neumatico.class)
            .setParameter("km", km)
            .getResultList();
    } finally {
        em.close();
    }
    }

    List<Neumatico> buscarPorRangoKm(double kmInicial, double kmFinal) {
          EntityManager em = getEntityManager();
    try {
        String query = "SELECT n FROM Neumatico n WHERE n.kmTotal BETWEEN :kmInicial AND :kmFinal ORDER BY n.kmTotal ASC";
        
        return em.createQuery(query, Neumatico.class)
            .setParameter("kmInicial", kmInicial)
            .setParameter("kmFinal", kmFinal)
            .getResultList();
    } finally {
        em.close();
    }
    }
    
}
