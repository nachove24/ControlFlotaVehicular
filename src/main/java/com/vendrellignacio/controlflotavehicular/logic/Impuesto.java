
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
public class Impuesto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_impuesto;
    private int ano;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPago;
    @ManyToOne
    @JoinColumn(name = "fk_patente")
    private Patente unPatente;

    public Impuesto() {
    }

    public Impuesto(int id_impuesto, int ano, Date fechaPago, Patente unPatente) {
        this.id_impuesto = id_impuesto;
        this.ano = ano;
        this.fechaPago = fechaPago;
        this.unPatente = unPatente;
    }

    public int getId_impuesto() {
        return id_impuesto;
    }

    public void setId_impuesto(int id_impuesto) {
        this.id_impuesto = id_impuesto;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Patente getUnPatente() {
        return unPatente;
    }

    public void setUnPatente(Patente unPatente) {
        this.unPatente = unPatente;
    }
    
    
    
    
}
