
package com.vendrellignacio.controlflotavehicular.persistence;

import com.vendrellignacio.controlflotavehicular.logic.Acoplado;
import com.vendrellignacio.controlflotavehicular.logic.Chasis;
import com.vendrellignacio.controlflotavehicular.logic.Gasto;
import com.vendrellignacio.controlflotavehicular.logic.Impuesto;
import com.vendrellignacio.controlflotavehicular.logic.Mantenimiento;
import com.vendrellignacio.controlflotavehicular.logic.Multa;
import com.vendrellignacio.controlflotavehicular.logic.Neumatico;
import com.vendrellignacio.controlflotavehicular.logic.Patente;
import com.vendrellignacio.controlflotavehicular.logic.Seguro;
import com.vendrellignacio.controlflotavehicular.logic.Tecnica;
import com.vendrellignacio.controlflotavehicular.logic.Viaje;
import com.vendrellignacio.controlflotavehicular.persistence.exceptions.NonexistentEntityException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    AcopladoJpaController acopladoJpa = new AcopladoJpaController();
    ChasisJpaController chasisJpa = new ChasisJpaController();
    GastoJpaController gastoJpa = new GastoJpaController();
    PatenteJpaController patenteJpa = new PatenteJpaController();
    ViajeJpaController viajeJpa = new ViajeJpaController();
    NeumaticoJpaController neumaticoJpa = new NeumaticoJpaController();
    SeguroJpaController seguroJpa = new SeguroJpaController();
    MultaJpaController multaJpa = new MultaJpaController();
    MantenimientoJpaController mantenimientoJpa = new MantenimientoJpaController();
    ImpuestoJpaController impuestoJpa = new ImpuestoJpaController();
    TecnicaJpaController tecnicaJpa = new TecnicaJpaController();

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
///////////////////////////////////////NEUMATICO///////////////////////////////////////////////////
    public List<Neumatico> traerNeus() {
        return neumaticoJpa.findNeumaticoEntities();
    }

    public void borrarNeu(int idNeu) {
        try {
            neumaticoJpa.destroy(idNeu);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Patente traerPatbyPatente(String codigo) {
        int idPat = patenteJpa.obtenerIdPorCodigo(codigo);
        return patenteJpa.findPatente(idPat);
    }

    public void crearNeumatico(Neumatico neu) {
        neumaticoJpa.create(neu);
    }

    public Neumatico traerNeu(int idNeu) {
        return neumaticoJpa.findNeumatico(idNeu);
    }

    public void editarNeu(Neumatico neu) throws Exception {
        neumaticoJpa.edit(neu);
    }
    
    
//////////////////////////////////TECNICA//////////////////////////////////////////////////
    public List<Tecnica> traerTecs() {
        return tecnicaJpa.findTecnicaEntities();
    }

    public void borrarTec(int idTec) {
        try {
            tecnicaJpa.destroy(idTec);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarTec(Tecnica tec) {
        tecnicaJpa.create(tec);
    }

    public Tecnica traerTec(int idTec) {
        return tecnicaJpa.findTecnica(idTec);
    }

    public void editarTec(Tecnica tec) {
        try {
            tecnicaJpa.edit(tec);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//////////////////////////SEGURO/////////////////////////////////////////////////////////////////
    public void borrarSeg(int idSeg) {
        try {
            seguroJpa.destroy(idSeg);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarSeg(Seguro seg) {
        seguroJpa.create(seg);
    }

    public List<Seguro> traerSegs() {
        return seguroJpa.findSeguroEntities();
    }

    public Seguro traerSeg(int idSeg) {
        return seguroJpa.findSeguro(idSeg);
    }

    public void editarSeg(Seguro seg) {
        try {
            seguroJpa.edit(seg);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//////////////////MULTA////////////////////////////////
    public List<Multa> traerMultas() {
        return multaJpa.findMultaEntities();
    }

    public void crearMulta(Multa mul) {
        multaJpa.create(mul);
    }

    public void borrarMul(int idMul) {
        try {
            multaJpa.destroy(idMul);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Multa traerMul(int idMul) {
        return multaJpa.findMulta(idMul);
    }

    public void editarMul(Multa mul) {
        try {
            multaJpa.edit(mul);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
////////////////////////////////MANTENIMIENTO///////////////////////////////////////////////////
    public void crearMan(Mantenimiento man) {
        mantenimientoJpa.create(man);
    }

    public List<Mantenimiento> traerMans() {
        return mantenimientoJpa.findMantenimientoEntities();
    }

    public void borrarMan(int idMan) {
        try {
            mantenimientoJpa.destroy(idMan);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mantenimiento traerMan(int idMan) {
        return mantenimientoJpa.findMantenimiento(idMan);
    }

    public void editarMan(Mantenimiento man) {
        try {
            mantenimientoJpa.edit(man);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/////////////////////////////IMPUESTO/////////////////////////////////////////////////////////
    public void borrarImp(int idImp) {
        try {
            impuestoJpa.destroy(idImp);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearImp(Impuesto imp) {
        impuestoJpa.create(imp);
    }

    public List<Impuesto> traerImps() {
        return impuestoJpa.findImpuestoEntities();
    }

    public Impuesto traerImp(int idImp) {
        return impuestoJpa.findImpuesto(idImp);
    }

    public void editarImp(Impuesto imp) {
        try {
            impuestoJpa.edit(imp);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /////////////////MANTENIMIENTO BUSCAR/////////////////////////////////
    public List<Mantenimiento> traerMantenimientosPorFecha(Date fechaInicial, Date fechaLimite) {
        try {
            return mantenimientoJpa.buscarPorRangoFechas(fechaInicial, fechaLimite);
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Mantenimiento> traerMantenimientosPorKmMenor(int km) {
    try {
        return mantenimientoJpa.buscarPorKmMenor(km);
    } catch (Exception e) {
        return null;
    }
}

public List<Mantenimiento> traerMantenimientosPorKmMayor(int km) {
    try {
        return mantenimientoJpa.buscarPorKmMayor(km);
    } catch (Exception e) {
        return null;
    }
}

public List<Mantenimiento> traerMantenimientosPorRangoKm(int kmInicial, int kmFinal) {
    try {
        return mantenimientoJpa.buscarPorRangoKm(kmInicial, kmFinal);
    } catch (Exception e) {
        return null;
    }
}
//////////////////////BUSCAR NEUMATICO////////////////////////////////////
    public Neumatico buscarNeumaticoPorCodigo(String texto) {
        return neumaticoJpa.buscarPorCodigo(texto);
    }

    public List<Neumatico> traerNeumaticoPorFecha(Date fechaInicial, Date fechaLimite) {
        try {
            return neumaticoJpa.buscarPorRangoFechas(fechaInicial, fechaLimite);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Neumatico> traerNeumaticoPorKmMenor(double km) {
        try {
            return neumaticoJpa.buscarPorKmMenor(km);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Neumatico> traerNeumaticoPorKmMayor(double km) {
        try {
            return neumaticoJpa.buscarPorKmMayor(km);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Neumatico> traerNeumaticoPorRangoKm(double kmInicial, double kmFinal) {
        try {
        return neumaticoJpa.buscarPorRangoKm(kmInicial, kmFinal);
        } catch (Exception e) {
            return null;
        }
    }
    
    
    
    
    

    
}
