
package com.vendrellignacio.controlflotavehicular.logic;

import com.vendrellignacio.controlflotavehicular.persistence.ControladoraPersistencia;
import com.vendrellignacio.controlflotavehicular.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
/////////////////////////////ACOPLADO//////////////////////////////////////////////////////////////////////7
    public void crearAcoplado(String tipoAcoplado, String patenteAcoplado) {
        Patente pat = new Patente();
        pat.setCodigoPatente(patenteAcoplado);
        Acoplado aco = new Acoplado();
        aco.setTipo_acoplado(tipoAcoplado);
        aco.setPatente(pat);
        controlPersis.guardarAco(aco,pat);
    }

    public List<Acoplado> traerAcos() {
        return controlPersis.traerAcos();
    }

    public void borrarAco(int idAco) {
        controlPersis.borrarAco(idAco);
    }
    

    public Acoplado traerAco(int idAco) {
        return controlPersis.traerAco(idAco);
    }

    public void modificarAco(Acoplado aco, Patente pat, String patente, String tipoAco) {
       
        pat.setCodigoPatente(patente);

        aco.setTipo_acoplado(tipoAco);
        aco.setPatente(pat);
        controlPersis.modificarAco(aco,pat);
    }

    public Patente traerPatAco(int id_patente) {
        return controlPersis.traerPatAco(id_patente);
    }
///////////////////////////////CHASIS/////////////////////////////////////////////////////////////////////////
    public List<Chasis> traerChas() {
        return controlPersis.traerChas();
    }

    public void crearCha(String anoChasis, String cargaMaxChasis, String colorChasis, String marcaChasis, String modeloChasis, String numSerieChasis, String patenteChasis) {
        Patente pat = new Patente();
        pat.setCodigoPatente(patenteChasis);
        Chasis cha = new Chasis();
        cha.setMarca(marcaChasis);
        cha.setModelo(modeloChasis);
        cha.setAno(Integer.parseInt(anoChasis));
        cha.setCarga_max(Double.parseDouble(cargaMaxChasis));
        cha.setColor(colorChasis);
        cha.setNum_serie(numSerieChasis);
        cha.setPatente(pat);
        controlPersis.guardarCha(cha,pat);
    }

    public void borrarCha(int idCha) {
        try {
            controlPersis.borrarCha(idCha);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Chasis traerCha(int idCha) {
        return controlPersis.traerCha(idCha);
    }

    public void modificarCha(Chasis cha, Patente pat, String patente, String anoChasis, String cargaMaxChasis, String colorChasis, String marcaChasis, String modeloChasis, String numSerieChasis) throws Exception {
        pat.setCodigoPatente(patente);
        cha.setAno(Integer.parseInt(anoChasis));
        cha.setCarga_max(Double.parseDouble(cargaMaxChasis));
        cha.setColor(colorChasis);
        cha.setMarca(marcaChasis);
        cha.setModelo(modeloChasis);
        cha.setNum_serie(numSerieChasis);
        cha.setPatente(pat);
        controlPersis.editarCha(pat,cha);
    }
    
    
    
    
}
