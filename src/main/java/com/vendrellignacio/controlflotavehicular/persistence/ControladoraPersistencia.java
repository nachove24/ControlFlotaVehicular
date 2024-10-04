
package com.vendrellignacio.controlflotavehicular.persistence;

import com.vendrellignacio.controlflotavehicular.logic.Acoplado;
import com.vendrellignacio.controlflotavehicular.logic.Chasis;
import com.vendrellignacio.controlflotavehicular.logic.Gasto;
import com.vendrellignacio.controlflotavehicular.logic.Patente;
import com.vendrellignacio.controlflotavehicular.logic.Viaje;
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

    public Integer traerIdAco(String acoViaje) {
        return acopladoJpa.findAcoIdByPatente(acoViaje);
    }

    public Integer traerIdCha(String chaViaje) {
        return chasisJpa.findChaIdByPatente(chaViaje);
    }
    
///////////////////////////VIAJE//////////////////////////////////////////////////////////////////77
    public void crearViaje(Viaje via, Gasto gas) {
        gastoJpa.create(gas); 
        viajeJpa.create(via);
        System.out.println("Persistencia CREARVIAJE");
    }

    public List<Viaje> traerViajes() {
        return viajeJpa.findViajeEntities();
    }

    public void borrarVia(int idVia) {
        try {
            viajeJpa.destroy(idVia);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Viaje traerVia(int idVia) {
        return viajeJpa.findViaje(idVia);
    }

    public Gasto traerGas(int id_gasto) {
        return gastoJpa.findGasto(id_gasto);
    }

    public void editarVia(Gasto gas, Viaje via) {
        try {
            gastoJpa.edit(gas);
            viajeJpa.edit(via);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
}
