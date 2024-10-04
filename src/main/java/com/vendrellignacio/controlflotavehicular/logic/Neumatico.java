
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
public class Neumatico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_neumatico;
    @Column(unique = true)
    private String cod_neumatico;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaUso;
    private Double kmTotal;
    private String marca;
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "fk_acoplado")
    private Acoplado unAcoplado;
    @ManyToOne
    @JoinColumn(name = "fk_chasis")
    private Chasis unChasis;

    public Neumatico() {
    }

    public Neumatico(int id_neumatico, String cod_neumatico, Date fechaUso, Double kmTotal, String marca, String estado, Acoplado unAcoplado, Chasis unChasis) {
        this.id_neumatico = id_neumatico;
        this.cod_neumatico = cod_neumatico;
        this.fechaUso = fechaUso;
        this.kmTotal = kmTotal;
        this.marca = marca;
        this.estado = estado;
        this.unAcoplado = unAcoplado;
        this.unChasis = unChasis;
    }

    public Acoplado getUnAcoplado() {
        return unAcoplado;
    }

    public void setUnAcoplado(Acoplado unAcoplado) {
        this.unAcoplado = unAcoplado;
    }

    public Chasis getUnChasis() {
        return unChasis;
    }

    public void setUnChasis(Chasis unChasis) {
        this.unChasis = unChasis;
    }

    public int getId_neumatico() {
        return id_neumatico;
    }

    public void setId_neumatico(int id_neumatico) {
        this.id_neumatico = id_neumatico;
    }

    public String getCod_neumatico() {
        return cod_neumatico;
    }

    public void setCod_neumatico(String cod_neumatico) {
        this.cod_neumatico = cod_neumatico;
    }

    public Date getFechaUso() {
        return fechaUso;
    }

    public void setFechaUso(Date fechaUso) {
        this.fechaUso = fechaUso;
    }

    public Double getKmTotal() {
        return kmTotal;
    }

    public void setKmTotal(Double kmTotal) {
        this.kmTotal = kmTotal;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
