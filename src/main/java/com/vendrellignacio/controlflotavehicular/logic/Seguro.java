
package com.vendrellignacio.controlflotavehicular.logic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Seguro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_seguro;
    private String aseguradora;
    @Column(unique = true)
    private int poliza;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVenc;
    private double importe;
    //private String estado;
    private String tipo;
    @ManyToOne
    @JoinColumn(name = "fk_patente")
    private Patente unPatente;

    public Seguro() {
    }

    public Seguro(int id_seguro, String aseguradora, int poliza, Date fechaInicio, Date fechaVenc, double importe, String estado, String tipo, Patente unPatente) {
        this.id_seguro = id_seguro;
        this.aseguradora = aseguradora;
        this.poliza = poliza;
        this.fechaInicio = fechaInicio;
        this.fechaVenc = fechaVenc;
        this.importe = importe;
        //this.estado = estado;
        this.tipo = tipo;
        this.unPatente = unPatente;
    }

    public int getId_seguro() {
        return id_seguro;
    }

    public void setId_seguro(int id_seguro) {
        this.id_seguro = id_seguro;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    public int getPoliza() {
        return poliza;
    }

    public void setPoliza(int poliza) {
        this.poliza = poliza;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(Date fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    /*public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }*/

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Patente getUnPatente() {
        return unPatente;
    }

    public void setUnPatente(Patente unPatente) {
        this.unPatente = unPatente;
    }
    
    
}
