
package com.vendrellignacio.controlflotavehicular.logic;

import com.vendrellignacio.controlflotavehicular.persistence.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearAcoplado(String tipoAcoplado, String patenteAcoplado) {
        Patente pat = new Patente();
        pat.setCodigoPatente(patenteAcoplado);
        Acoplado aco = new Acoplado();
        aco.setTipo_acoplado(tipoAcoplado);
        aco.setPatente(pat);
        controlPersis.guardar(aco,pat);
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
    
    
    
    
}
