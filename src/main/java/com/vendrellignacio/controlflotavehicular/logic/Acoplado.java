package com.vendrellignacio.controlflotavehicular.logic;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Acoplado implements Serializable {
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_acoplado;
    private String tipo_acoplado;
    //RELACIONES
    @OneToOne
    private Patente patente; // Foreign key
    //Un acoplado tiene muchos viajes
    @OneToMany(mappedBy = "unAcoplado")
    private List<Viaje> listaViajes;
    
    public Acoplado() {
    }

    public Acoplado(int id_acoplado, String tipo_acoplado, Patente patente, List<Viaje> listaViajes) {
        this.id_acoplado = id_acoplado;
        this.tipo_acoplado = tipo_acoplado;
        this.patente = patente;
        this.listaViajes = listaViajes;
    }

    
    

    public int getId_acoplado() {
        return id_acoplado;
    }

    public void setId_acoplado(int id_acoplado) {
        this.id_acoplado = id_acoplado;
    }

    public String getTipo_acoplado() {
        return tipo_acoplado;
    }

    public void setTipo_acoplado(String tipo_acoplado) {
        this.tipo_acoplado = tipo_acoplado;
    }

    public Patente getPatente() {
        return patente;
    }

    public void setPatente(Patente patente) {
        this.patente = patente;
    }

    public List<Viaje> getListaViajes() {
        return listaViajes;
    }

    public void setListaViajes(List<Viaje> listaViajes) {
        this.listaViajes = listaViajes;
    }
    
    
    
}
