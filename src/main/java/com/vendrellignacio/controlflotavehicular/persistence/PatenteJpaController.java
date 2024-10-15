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
import java.util.ArrayList;
import java.util.List;
import com.vendrellignacio.controlflotavehicular.logic.Tecnica;
import com.vendrellignacio.controlflotavehicular.logic.Impuesto;
import com.vendrellignacio.controlflotavehicular.logic.Mantenimiento;
import com.vendrellignacio.controlflotavehicular.logic.Patente;
import com.vendrellignacio.controlflotavehicular.logic.Seguro;
import com.vendrellignacio.controlflotavehicular.persistence.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
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
        if (patente.getListaTecnicas() == null) {
            patente.setListaTecnicas(new ArrayList<Tecnica>());
        }
        if (patente.getListaImpuestos() == null) {
            patente.setListaImpuestos(new ArrayList<Impuesto>());
        }
        if (patente.getListaMantenimiento() == null) {
            patente.setListaMantenimiento(new ArrayList<Mantenimiento>());
        }
        if (patente.getListaSeguros() == null) {
            patente.setListaSeguros(new ArrayList<Seguro>());
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
            List<Tecnica> attachedListaTecnicas = new ArrayList<Tecnica>();
            for (Tecnica listaTecnicasTecnicaToAttach : patente.getListaTecnicas()) {
                listaTecnicasTecnicaToAttach = em.getReference(listaTecnicasTecnicaToAttach.getClass(), listaTecnicasTecnicaToAttach.getId_tecnica());
                attachedListaTecnicas.add(listaTecnicasTecnicaToAttach);
            }
            patente.setListaTecnicas(attachedListaTecnicas);
            List<Impuesto> attachedListaImpuestos = new ArrayList<Impuesto>();
            for (Impuesto listaImpuestosImpuestoToAttach : patente.getListaImpuestos()) {
                listaImpuestosImpuestoToAttach = em.getReference(listaImpuestosImpuestoToAttach.getClass(), listaImpuestosImpuestoToAttach.getId_impuesto());
                attachedListaImpuestos.add(listaImpuestosImpuestoToAttach);
            }
            patente.setListaImpuestos(attachedListaImpuestos);
            List<Mantenimiento> attachedListaMantenimiento = new ArrayList<Mantenimiento>();
            for (Mantenimiento listaMantenimientoMantenimientoToAttach : patente.getListaMantenimiento()) {
                listaMantenimientoMantenimientoToAttach = em.getReference(listaMantenimientoMantenimientoToAttach.getClass(), listaMantenimientoMantenimientoToAttach.getId_mantenimiento());
                attachedListaMantenimiento.add(listaMantenimientoMantenimientoToAttach);
            }
            patente.setListaMantenimiento(attachedListaMantenimiento);
            List<Seguro> attachedListaSeguros = new ArrayList<Seguro>();
            for (Seguro listaSegurosSeguroToAttach : patente.getListaSeguros()) {
                listaSegurosSeguroToAttach = em.getReference(listaSegurosSeguroToAttach.getClass(), listaSegurosSeguroToAttach.getId_seguro());
                attachedListaSeguros.add(listaSegurosSeguroToAttach);
            }
            patente.setListaSeguros(attachedListaSeguros);
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
            for (Tecnica listaTecnicasTecnica : patente.getListaTecnicas()) {
                Patente oldUnPatenteOfListaTecnicasTecnica = listaTecnicasTecnica.getUnPatente();
                listaTecnicasTecnica.setUnPatente(patente);
                listaTecnicasTecnica = em.merge(listaTecnicasTecnica);
                if (oldUnPatenteOfListaTecnicasTecnica != null) {
                    oldUnPatenteOfListaTecnicasTecnica.getListaTecnicas().remove(listaTecnicasTecnica);
                    oldUnPatenteOfListaTecnicasTecnica = em.merge(oldUnPatenteOfListaTecnicasTecnica);
                }
            }
            for (Impuesto listaImpuestosImpuesto : patente.getListaImpuestos()) {
                Patente oldUnPatenteOfListaImpuestosImpuesto = listaImpuestosImpuesto.getUnPatente();
                listaImpuestosImpuesto.setUnPatente(patente);
                listaImpuestosImpuesto = em.merge(listaImpuestosImpuesto);
                if (oldUnPatenteOfListaImpuestosImpuesto != null) {
                    oldUnPatenteOfListaImpuestosImpuesto.getListaImpuestos().remove(listaImpuestosImpuesto);
                    oldUnPatenteOfListaImpuestosImpuesto = em.merge(oldUnPatenteOfListaImpuestosImpuesto);
                }
            }
            for (Mantenimiento listaMantenimientoMantenimiento : patente.getListaMantenimiento()) {
                Patente oldUnPatenteOfListaMantenimientoMantenimiento = listaMantenimientoMantenimiento.getUnPatente();
                listaMantenimientoMantenimiento.setUnPatente(patente);
                listaMantenimientoMantenimiento = em.merge(listaMantenimientoMantenimiento);
                if (oldUnPatenteOfListaMantenimientoMantenimiento != null) {
                    oldUnPatenteOfListaMantenimientoMantenimiento.getListaMantenimiento().remove(listaMantenimientoMantenimiento);
                    oldUnPatenteOfListaMantenimientoMantenimiento = em.merge(oldUnPatenteOfListaMantenimientoMantenimiento);
                }
            }
            for (Seguro listaSegurosSeguro : patente.getListaSeguros()) {
                Patente oldUnPatenteOfListaSegurosSeguro = listaSegurosSeguro.getUnPatente();
                listaSegurosSeguro.setUnPatente(patente);
                listaSegurosSeguro = em.merge(listaSegurosSeguro);
                if (oldUnPatenteOfListaSegurosSeguro != null) {
                    oldUnPatenteOfListaSegurosSeguro.getListaSeguros().remove(listaSegurosSeguro);
                    oldUnPatenteOfListaSegurosSeguro = em.merge(oldUnPatenteOfListaSegurosSeguro);
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
            List<Tecnica> listaTecnicasOld = persistentPatente.getListaTecnicas();
            List<Tecnica> listaTecnicasNew = patente.getListaTecnicas();
            List<Impuesto> listaImpuestosOld = persistentPatente.getListaImpuestos();
            List<Impuesto> listaImpuestosNew = patente.getListaImpuestos();
            List<Mantenimiento> listaMantenimientoOld = persistentPatente.getListaMantenimiento();
            List<Mantenimiento> listaMantenimientoNew = patente.getListaMantenimiento();
            List<Seguro> listaSegurosOld = persistentPatente.getListaSeguros();
            List<Seguro> listaSegurosNew = patente.getListaSeguros();
            List<Neumatico> attachedListaNeumaticosNew = new ArrayList<Neumatico>();
            for (Neumatico listaNeumaticosNewNeumaticoToAttach : listaNeumaticosNew) {
                listaNeumaticosNewNeumaticoToAttach = em.getReference(listaNeumaticosNewNeumaticoToAttach.getClass(), listaNeumaticosNewNeumaticoToAttach.getId_neumatico());
                attachedListaNeumaticosNew.add(listaNeumaticosNewNeumaticoToAttach);
            }
            listaNeumaticosNew = attachedListaNeumaticosNew;
            patente.setListaNeumaticos(listaNeumaticosNew);
            List<Tecnica> attachedListaTecnicasNew = new ArrayList<Tecnica>();
            for (Tecnica listaTecnicasNewTecnicaToAttach : listaTecnicasNew) {
                listaTecnicasNewTecnicaToAttach = em.getReference(listaTecnicasNewTecnicaToAttach.getClass(), listaTecnicasNewTecnicaToAttach.getId_tecnica());
                attachedListaTecnicasNew.add(listaTecnicasNewTecnicaToAttach);
            }
            listaTecnicasNew = attachedListaTecnicasNew;
            patente.setListaTecnicas(listaTecnicasNew);
            List<Impuesto> attachedListaImpuestosNew = new ArrayList<Impuesto>();
            for (Impuesto listaImpuestosNewImpuestoToAttach : listaImpuestosNew) {
                listaImpuestosNewImpuestoToAttach = em.getReference(listaImpuestosNewImpuestoToAttach.getClass(), listaImpuestosNewImpuestoToAttach.getId_impuesto());
                attachedListaImpuestosNew.add(listaImpuestosNewImpuestoToAttach);
            }
            listaImpuestosNew = attachedListaImpuestosNew;
            patente.setListaImpuestos(listaImpuestosNew);
            List<Mantenimiento> attachedListaMantenimientoNew = new ArrayList<Mantenimiento>();
            for (Mantenimiento listaMantenimientoNewMantenimientoToAttach : listaMantenimientoNew) {
                listaMantenimientoNewMantenimientoToAttach = em.getReference(listaMantenimientoNewMantenimientoToAttach.getClass(), listaMantenimientoNewMantenimientoToAttach.getId_mantenimiento());
                attachedListaMantenimientoNew.add(listaMantenimientoNewMantenimientoToAttach);
            }
            listaMantenimientoNew = attachedListaMantenimientoNew;
            patente.setListaMantenimiento(listaMantenimientoNew);
            List<Seguro> attachedListaSegurosNew = new ArrayList<Seguro>();
            for (Seguro listaSegurosNewSeguroToAttach : listaSegurosNew) {
                listaSegurosNewSeguroToAttach = em.getReference(listaSegurosNewSeguroToAttach.getClass(), listaSegurosNewSeguroToAttach.getId_seguro());
                attachedListaSegurosNew.add(listaSegurosNewSeguroToAttach);
            }
            listaSegurosNew = attachedListaSegurosNew;
            patente.setListaSeguros(listaSegurosNew);
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
            for (Tecnica listaTecnicasOldTecnica : listaTecnicasOld) {
                if (!listaTecnicasNew.contains(listaTecnicasOldTecnica)) {
                    listaTecnicasOldTecnica.setUnPatente(null);
                    listaTecnicasOldTecnica = em.merge(listaTecnicasOldTecnica);
                }
            }
            for (Tecnica listaTecnicasNewTecnica : listaTecnicasNew) {
                if (!listaTecnicasOld.contains(listaTecnicasNewTecnica)) {
                    Patente oldUnPatenteOfListaTecnicasNewTecnica = listaTecnicasNewTecnica.getUnPatente();
                    listaTecnicasNewTecnica.setUnPatente(patente);
                    listaTecnicasNewTecnica = em.merge(listaTecnicasNewTecnica);
                    if (oldUnPatenteOfListaTecnicasNewTecnica != null && !oldUnPatenteOfListaTecnicasNewTecnica.equals(patente)) {
                        oldUnPatenteOfListaTecnicasNewTecnica.getListaTecnicas().remove(listaTecnicasNewTecnica);
                        oldUnPatenteOfListaTecnicasNewTecnica = em.merge(oldUnPatenteOfListaTecnicasNewTecnica);
                    }
                }
            }
            for (Impuesto listaImpuestosOldImpuesto : listaImpuestosOld) {
                if (!listaImpuestosNew.contains(listaImpuestosOldImpuesto)) {
                    listaImpuestosOldImpuesto.setUnPatente(null);
                    listaImpuestosOldImpuesto = em.merge(listaImpuestosOldImpuesto);
                }
            }
            for (Impuesto listaImpuestosNewImpuesto : listaImpuestosNew) {
                if (!listaImpuestosOld.contains(listaImpuestosNewImpuesto)) {
                    Patente oldUnPatenteOfListaImpuestosNewImpuesto = listaImpuestosNewImpuesto.getUnPatente();
                    listaImpuestosNewImpuesto.setUnPatente(patente);
                    listaImpuestosNewImpuesto = em.merge(listaImpuestosNewImpuesto);
                    if (oldUnPatenteOfListaImpuestosNewImpuesto != null && !oldUnPatenteOfListaImpuestosNewImpuesto.equals(patente)) {
                        oldUnPatenteOfListaImpuestosNewImpuesto.getListaImpuestos().remove(listaImpuestosNewImpuesto);
                        oldUnPatenteOfListaImpuestosNewImpuesto = em.merge(oldUnPatenteOfListaImpuestosNewImpuesto);
                    }
                }
            }
            for (Mantenimiento listaMantenimientoOldMantenimiento : listaMantenimientoOld) {
                if (!listaMantenimientoNew.contains(listaMantenimientoOldMantenimiento)) {
                    listaMantenimientoOldMantenimiento.setUnPatente(null);
                    listaMantenimientoOldMantenimiento = em.merge(listaMantenimientoOldMantenimiento);
                }
            }
            for (Mantenimiento listaMantenimientoNewMantenimiento : listaMantenimientoNew) {
                if (!listaMantenimientoOld.contains(listaMantenimientoNewMantenimiento)) {
                    Patente oldUnPatenteOfListaMantenimientoNewMantenimiento = listaMantenimientoNewMantenimiento.getUnPatente();
                    listaMantenimientoNewMantenimiento.setUnPatente(patente);
                    listaMantenimientoNewMantenimiento = em.merge(listaMantenimientoNewMantenimiento);
                    if (oldUnPatenteOfListaMantenimientoNewMantenimiento != null && !oldUnPatenteOfListaMantenimientoNewMantenimiento.equals(patente)) {
                        oldUnPatenteOfListaMantenimientoNewMantenimiento.getListaMantenimiento().remove(listaMantenimientoNewMantenimiento);
                        oldUnPatenteOfListaMantenimientoNewMantenimiento = em.merge(oldUnPatenteOfListaMantenimientoNewMantenimiento);
                    }
                }
            }
            for (Seguro listaSegurosOldSeguro : listaSegurosOld) {
                if (!listaSegurosNew.contains(listaSegurosOldSeguro)) {
                    listaSegurosOldSeguro.setUnPatente(null);
                    listaSegurosOldSeguro = em.merge(listaSegurosOldSeguro);
                }
            }
            for (Seguro listaSegurosNewSeguro : listaSegurosNew) {
                if (!listaSegurosOld.contains(listaSegurosNewSeguro)) {
                    Patente oldUnPatenteOfListaSegurosNewSeguro = listaSegurosNewSeguro.getUnPatente();
                    listaSegurosNewSeguro.setUnPatente(patente);
                    listaSegurosNewSeguro = em.merge(listaSegurosNewSeguro);
                    if (oldUnPatenteOfListaSegurosNewSeguro != null && !oldUnPatenteOfListaSegurosNewSeguro.equals(patente)) {
                        oldUnPatenteOfListaSegurosNewSeguro.getListaSeguros().remove(listaSegurosNewSeguro);
                        oldUnPatenteOfListaSegurosNewSeguro = em.merge(oldUnPatenteOfListaSegurosNewSeguro);
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
            List<Tecnica> listaTecnicas = patente.getListaTecnicas();
            for (Tecnica listaTecnicasTecnica : listaTecnicas) {
                listaTecnicasTecnica.setUnPatente(null);
                listaTecnicasTecnica = em.merge(listaTecnicasTecnica);
            }
            List<Impuesto> listaImpuestos = patente.getListaImpuestos();
            for (Impuesto listaImpuestosImpuesto : listaImpuestos) {
                listaImpuestosImpuesto.setUnPatente(null);
                listaImpuestosImpuesto = em.merge(listaImpuestosImpuesto);
            }
            List<Mantenimiento> listaMantenimiento = patente.getListaMantenimiento();
            for (Mantenimiento listaMantenimientoMantenimiento : listaMantenimiento) {
                listaMantenimientoMantenimiento.setUnPatente(null);
                listaMantenimientoMantenimiento = em.merge(listaMantenimientoMantenimiento);
            }
            List<Seguro> listaSeguros = patente.getListaSeguros();
            for (Seguro listaSegurosSeguro : listaSeguros) {
                listaSegurosSeguro.setUnPatente(null);
                listaSegurosSeguro = em.merge(listaSegurosSeguro);
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
    public Integer obtenerIdPorCodigo(String codigo) {
        EntityManager em = getEntityManager();
    try {
        return em.createQuery("SELECT p.id_patente FROM Patente p WHERE p.codigoPatente = :codigo", Integer.class)
                            .setParameter("codigo", codigo)
                            .getSingleResult();
    } catch (NoResultException e) {
        // Manejar caso donde no existe un registro con ese código.
        System.out.println("No se encontró una patente con el código: " + codigo);
        return null;
    }
}

    
}
