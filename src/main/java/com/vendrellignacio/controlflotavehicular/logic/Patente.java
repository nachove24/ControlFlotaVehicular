
package com.vendrellignacio.controlflotavehicular.logic;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_patente;
    @Column(unique = true)
    private String codigoPatente;

    public Patente() {
    }

    public Patente(int id_patente, String dominio) {
        this.id_patente = id_patente;
        this.codigoPatente = dominio;
    }

    public int getId_patente() {
        return id_patente;
    }

    public void setId_patente(int id_patente) {
        this.id_patente = id_patente;
    }

    public String getCodigoPatente() {
        return codigoPatente;
    }

    public void setCodigoPatente(String codigoPatente) {
        this.codigoPatente = codigoPatente;
    }
    
    
}
