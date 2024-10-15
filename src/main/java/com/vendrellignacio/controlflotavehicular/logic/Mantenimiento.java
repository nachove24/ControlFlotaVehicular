
package com.vendrellignacio.controlflotavehicular.logic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Mantenimiento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_mantenimiento;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private double km;
    private String obsv;
    @ManyToOne
    @JoinColumn(name = "fk_patente")
    private Patente unPatente;

    public Mantenimiento() {
    }

    public Mantenimiento(int id_mantenimiento, Date fecha, double km, String obsv, Patente unPatente) {
        this.id_mantenimiento = id_mantenimiento;
        this.fecha = fecha;
        this.km = km;
        this.obsv = obsv;
        this.unPatente = unPatente;
    }

    public int getId_mantenimiento() {
        return id_mantenimiento;
    }

    public void setId_mantenimiento(int id_mantenimiento) {
        this.id_mantenimiento = id_mantenimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public String getObsv() {
        return obsv;
    }

    public void setObsv(String obsv) {
        this.obsv = obsv;
    }

    public Patente getUnPatente() {
        return unPatente;
    }

    public void setUnPatente(Patente unPatente) {
        this.unPatente = unPatente;
    }
    
    
}
