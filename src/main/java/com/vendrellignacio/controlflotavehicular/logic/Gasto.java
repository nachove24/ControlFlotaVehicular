
package com.vendrellignacio.controlflotavehicular.logic;

import java.io.Serializable;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

//@Entity
public class Gasto implements Serializable {
    //@Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_gasto;
    private double totalCombus;
    private double peaje;
    private double comida;

    public Gasto() {
    }

    public Gasto(int id_gasto, double totalCombus, double peaje, double comida) {
        this.id_gasto = id_gasto;
        this.totalCombus = totalCombus;
        this.peaje = peaje;
        this.comida = comida;
    }

    public int getId_gasto() {
        return id_gasto;
    }

    public void setId_gasto(int id_gasto) {
        this.id_gasto = id_gasto;
    }

    public double getTotalCombus() {
        return totalCombus;
    }

    public void setTotalCombus(double totalCombus) {
        this.totalCombus = totalCombus;
    }

    public double getPeaje() {
        return peaje;
    }

    public void setPeaje(double peaje) {
        this.peaje = peaje;
    }

    public double getComida() {
        return comida;
    }

    public void setComida(double comida) {
        this.comida = comida;
    }
    
    
}
