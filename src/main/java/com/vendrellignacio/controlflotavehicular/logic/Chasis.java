package com.vendrellignacio.controlflotavehicular.logic;

//import javax.persistence.Entity;

//@Entity
public class Chasis {
    //ATRIBUTOS
    //@Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected int id_chasis;
    private String marca;
    private String modelo;
    private String num_serie;
    private String color;
    private int ano; 
    private double carga_max;
    private Patente patente; // Foreign key

    public Chasis() {
    }

    public Chasis(int id_chasis, String marca, String modelo, String num_serie, String color, int ano, double carga_max, Patente patente) {
        this.id_chasis = id_chasis;
        this.marca = marca;
        this.modelo = modelo;
        this.num_serie = num_serie;
        this.color = color;
        this.ano = ano;
        this.carga_max = carga_max;
        this.patente = patente;
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

    
    
    
}
