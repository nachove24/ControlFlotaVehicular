
package com.vendrellignacio.controlflotavehicular.persistence;

import com.vendrellignacio.controlflotavehicular.logic.Acoplado;
import com.vendrellignacio.controlflotavehicular.logic.Patente;


public class ControladoraPersistencia {
    AcopladoJpaController acopladoJpa = new AcopladoJpaController();
    ChasisJpaController chasisJpa = new ChasisJpaController();
    GastoJpaController gastoJpa = new GastoJpaController();
    PatenteJpaController patenteJpa = new PatenteJpaController();
    ViajeJpaController viajeJpa = new ViajeJpaController();

    public void guardar(Acoplado aco, Patente pat) {
        patenteJpa.create(pat);
        acopladoJpa.create(aco);
        
    }
}
