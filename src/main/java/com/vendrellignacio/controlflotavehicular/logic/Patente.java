
package com.vendrellignacio.controlflotavehicular.logic;


public class Patente {
    private int id_patente;
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
