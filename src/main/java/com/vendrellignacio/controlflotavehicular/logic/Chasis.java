package com.vendrellignacio.controlflotavehicular.logic;

import java.io.Serializable;
import javax.persistence.Entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Chasis implements Serializable {
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected int id_chasis;
    private String marca;
    private String modelo;
    private String num_serie;
    private String color;
    private int ano; 
    private double carga_max;
    //RELACIONES
    @OneToOne(cascade = CascadeType.REMOVE) // Cascada para eliminar la entidad relacionada
    private Patente patente; // Foreign key
    //Un chasis tiene muchos viajes
    @OneToMany(mappedBy = "unChasis")
    private List<Viaje> listaViajes;
    @OneToMany(mappedBy = "unChasis")
    private List<Neumatico> listaNeumaticos;
    public Chasis() {
    }

    public Chasis(int id_chasis, String marca, String modelo, String num_serie, String color, int ano, double carga_max, Patente patente, List<Viaje> listaViajes, List<Neumatico> listaNeumaticos) {
        this.id_chasis = id_chasis;
        this.marca = marca;
        this.modelo = modelo;
        this.num_serie = num_serie;
        this.color = color;
        this.ano = ano;
        this.carga_max = carga_max;
        this.patente = patente;
        this.listaViajes = listaViajes;
        this.listaNeumaticos = listaNeumaticos;
    }

    

    public List<Viaje> getListaViajes() {
        return listaViajes;
    }

    public void setListaViajes(List<Viaje> listaViajes) {
        this.listaViajes = listaViajes;
    }

    public int getId_chasis() {
        return id_chasis;
    }

    public void setId_chasis(int id_chasis) {
        this.id_chasis = id_chasis;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getCarga_max() {
        return carga_max;
    }

    public void setCarga_max(double carga_max) {
        this.carga_max = carga_max;
    }

    public Patente getPatente() {
        return patente;
    }

    public void setPatente(Patente patente) {
        this.patente = patente;
    }

    public List<Neumatico> getListaNeumaticos() {
        return listaNeumaticos;
    }

    public void setListaNeumaticos(List<Neumatico> listaNeumaticos) {
        this.listaNeumaticos = listaNeumaticos;
    }

    
    
    
}
