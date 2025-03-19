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
import com.vendrellignacio.controlflotavehicular.logic.Seguro;
import com.vendrellignacio.controlflotavehicular.persistence.exceptions.NonexistentEntityException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author nacho
 */
public class SeguroJpaController implements Serializable {

    public SeguroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public SeguroJpaController() {
        emf = Persistence.createEntityManagerFactory("flotaPU");
    }

    public void create(Seguro seguro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Patente unPatente = seguro.getUnPatente();
            if (unPatente != null) {
                unPatente = em.getReference(unPatente.getClass(), unPatente.getId_patente());
                seguro.setUnPatente(unPatente);
            }
            em.persist(seguro);
            if (unPatente != null) {
                unPatente.getListaSeguros().add(seguro);
                unPatente = em.merge(unPatente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Seguro seguro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Seguro persistentSeguro = em.find(Seguro.class, seguro.getId_seguro());
            Patente unPatenteOld = persistentSeguro.getUnPatente();
            Patente unPatenteNew = seguro.getUnPatente();
            if (unPatenteNew != null) {
                unPatenteNew = em.getReference(unPatenteNew.getClass(), unPatenteNew.getId_patente());
                seguro.setUnPatente(unPatenteNew);
            }
            seguro = em.merge(seguro);
            if (unPatenteOld != null && !unPatenteOld.equals(unPatenteNew)) {
                unPatenteOld.getListaSeguros().remove(seguro);
                unPatenteOld = em.merge(unPatenteOld);
            }
            if (unPatenteNew != null && !unPatenteNew.equals(unPatenteOld)) {
                unPatenteNew.getListaSeguros().add(seguro);
                unPatenteNew = em.merge(unPatenteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = seguro.getId_seguro();
                if (findSeguro(id) == null) {
                    throw new NonexistentEntityException("The seguro with id " + id + " no longer exists.");
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
            Seguro seguro;
            try {
                seguro = em.getReference(Seguro.class, id);
                seguro.getId_seguro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The seguro with id " + id + " no longer exists.", enfe);
            }
            Patente unPatente = seguro.getUnPatente();
            if (unPatente != null) {
                unPatente.getListaSeguros().remove(seguro);
                unPatente = em.merge(unPatente);
            }
            em.remove(seguro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Seguro> findSeguroEntities() {
        return findSeguroEntities(true, -1, -1);
    }

    public List<Seguro> findSeguroEntities(int maxResults, int firstResult) {
        return findSeguroEntities(false, maxResults, firstResult);
    }

    private List<Seguro> findSeguroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Seguro.class));
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

    public Seguro findSeguro(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Seguro.class, id);
        } finally {
            em.close();
        }
    }

    public int getSeguroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Seguro> rt = cq.from(Seguro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    Seguro buscarPorPoliza(String texto) {
        EntityManager em = getEntityManager();
        int textoInt = Integer.parseInt(texto);
    try {
        String query = "SELECT s FROM Seguro s WHERE s.poliza = :numeroPoliza";
        return em.createQuery(query, Seguro.class)
            .setParameter("numeroPoliza", textoInt)
            .getSingleResult();
    } catch (NoResultException e) {
        return null;
    } finally {
        em.close();
    }
    }

    List<Seguro> buscarPorAseguradora(String texto) {
        EntityManager em = getEntityManager();
    try {
        String query = "SELECT s FROM Seguro s WHERE LOWER(s.aseguradora) LIKE LOWER(:textoAseguradora)";
        return em.createQuery(query, Seguro.class)
            .setParameter("textoAseguradora", "%" + texto + "%")
            .getResultList();
    } finally {
        em.close();
    }
    }
    
    /**
 * Busca seguros cuya fecha de vencimiento esté dentro del rango especificado.
 * 
 * @param fechaInicial fecha inicial del rango de búsqueda
 * @param fechaLimite fecha final del rango de búsqueda
 * @return lista de seguros con vencimiento dentro del rango especificado
 */

    List<Seguro> buscarPorRangoFechas(Date fechaInicial, Date fechaLimite) {
        EntityManager em = getEntityManager();
    try {
        String query = "SELECT s FROM Seguro s WHERE s.fechaVenc BETWEEN :fechaInicial AND :fechaLimite ORDER BY s.fechaVenc ASC";
        
        return em.createQuery(query, Seguro.class)
            .setParameter("fechaInicial", fechaInicial)
            .setParameter("fechaLimite", fechaLimite)
            .getResultList();
    } finally {
        em.close();
    }
    }

    List<Seguro> buscarPorRangoFechas2(Date fechaInicial, Date fechaLimite) {
        EntityManager em = getEntityManager();
    try {
        String query = "SELECT s FROM Seguro s WHERE s.fechaInicio BETWEEN :fechaInicial AND :fechaLimite ORDER BY s.fechaInicio ASC";
        
        return em.createQuery(query, Seguro.class)
            .setParameter("fechaInicial", fechaInicial)
            .setParameter("fechaLimite", fechaLimite)
            .getResultList();
    } finally {
        em.close();
    }
    }

    boolean existePoliza(String poliza) {
         EntityManager em = emf.createEntityManager();
         int polizaInt = Integer.parseInt(poliza);
    try {
        Query query = em.createQuery("SELECT COUNT(s) FROM Seguro s WHERE s.poliza = :poliza");
        query.setParameter("poliza", polizaInt);
        Long count = (Long) query.getSingleResult();
        return count > 0; // Si hay al menos una póliza con ese número, devuelve true
    } finally {
        em.close();
    }
    }
    
}
