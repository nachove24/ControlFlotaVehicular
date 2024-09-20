
package com.vendrellignacio.controlflotavehicular.logic;

import com.vendrellignacio.controlflotavehicular.persistence.ControladoraPersistencia;


public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearAcoplado() {
        Patente pat = new Patente();
        pat.setCodigoPatente("AAA-222");
        Acoplado aco = new Acoplado();
        aco.setTipo_acoplado("Cereal");
        aco.setPatente(pat);
        controlPersis.guardar(aco,pat);
    }
    
    
    
    
    
}
