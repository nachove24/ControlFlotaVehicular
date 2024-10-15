
package com.vendrellignacio.controlflotavehicular.logic;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Multa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_multa;
    private String infraccion;
    private double importe;
    private double impPagado;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "fk_viaje")
    private Viaje unViaje;

    public Multa() {
    }

    public Multa(int id_multa, String infraccion, double importe, double impPagado, String estado, Viaje unViaje) {
        this.id_multa = id_multa;
        this.infraccion = infraccion;
        this.importe = importe;
        this.impPagado = impPagado;
        this.estado = estado;
        this.unViaje = unViaje;
    }

    public int getId_multa() {
        return id_multa;
    }

    public void setId_multa(int id_multa) {
        this.id_multa = id_multa;
    }

    public String getInfraccion() {
        return infraccion;
    }

    public void setInfraccion(String infraccion) {
        this.infraccion = infraccion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getImpPagado() {
        return impPagado;
    }

    public void setImpPagado(double impPagado) {
        this.impPagado = impPagado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Viaje getUnViaje() {
        return unViaje;
    }

    public void setUnViaje(Viaje unViaje) {
        this.unViaje = unViaje;
    }
    
    
}
