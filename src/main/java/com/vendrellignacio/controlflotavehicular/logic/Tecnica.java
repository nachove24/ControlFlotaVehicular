
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
public class Tecnica implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_tecnica;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date vencVTV;
    private int ano;
    @ManyToOne
    @JoinColumn(name = "fk_patente")
    private Patente unPatente;

    public Tecnica() {
    }

    public Tecnica(int id_tecnica, Date vencVTV, int ano, Patente unPatente) {
        this.id_tecnica = id_tecnica;
        this.vencVTV = vencVTV;
        this.ano = ano;
        this.unPatente = unPatente;
    }

    public int getId_tecnica() {
        return id_tecnica;
    }

    public void setId_tecnica(int id_tecnica) {
        this.id_tecnica = id_tecnica;
    }

    public Date getVencVTV() {
        return vencVTV;
    }

    public void setVencVTV(Date vencVTV) {
        this.vencVTV = vencVTV;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Patente getUnPatente() {
        return unPatente;
    }

    public void setUnPatente(Patente unPatente) {
        this.unPatente = unPatente;
    }
    
    
}
