
package com.vendrellignacio.controlflotavehicular.persistence;

import com.vendrellignacio.controlflotavehicular.logic.Acoplado;
import com.vendrellignacio.controlflotavehicular.logic.Chasis;
import com.vendrellignacio.controlflotavehicular.logic.Patente;
import com.vendrellignacio.controlflotavehicular.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    AcopladoJpaController acopladoJpa = new AcopladoJpaController();
    ChasisJpaController chasisJpa = new ChasisJpaController();
    GastoJpaController gastoJpa = new GastoJpaController();
    PatenteJpaController patenteJpa = new PatenteJpaController();
    ViajeJpaController viajeJpa = new ViajeJpaController();

    ///////////////ACOPLADO/////////////////////////////////////////////////////////////////////
    
    public void guardarAco(Acoplado aco, Patente pat) {
        patenteJpa.create(pat);
        acopladoJpa.create(aco);
    }

    public List<Acoplado> traerAcos() {
        return acopladoJpa.findAcopladoEntities();
    }

    public void borrarAco(int idAco) {
        try {
            acopladoJpa.destroy(idAco);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Acoplado traerAco(int idAco) {
         return acopladoJpa.findAcoplado(idAco);
    }
    
    public Patente traerPatAco(int id_patente) {
        return patenteJpa.findPatente(id_patente);
    }

    public void modificarAco(Acoplado aco, Patente pat) {
        
        try {
            acopladoJpa.edit(aco);
            patenteJpa.edit(pat);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    ///////////////CHASIS/////////////////////////////////////////////////////////////////////

    public List<Chasis> traerChas() {
        return chasisJpa.findChasisEntities();
    }

    public void guardarCha(Chasis cha, Patente pat) {
        patenteJpa.create(pat);
        chasisJpa.create(cha);
    }

    public void borrarCha(int idCha) throws NonexistentEntityException {
        chasisJpa.destroy(idCha);
    }

    public Chasis traerCha(int idCha) {
        return chasisJpa.findChasis(idCha);
    }

    public void editarCha(Patente pat, Chasis cha) throws Exception {
        patenteJpa.edit(pat);
        chasisJpa.edit(cha);
    }

    
}
