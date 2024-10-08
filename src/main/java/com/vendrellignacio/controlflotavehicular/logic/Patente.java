
package com.vendrellignacio.controlflotavehicular.logic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_patente;
    @Column(unique = true)
    private String codigoPatente;
    @OneToMany(mappedBy = "unPatente")
    private List<Neumatico> listaNeumaticos;
    

    public Patente() {
    }

    public Patente(int id_patente, String codigoPatente, List<Neumatico> listaNeumaticos) {
        this.id_patente = id_patente;
        this.codigoPatente = codigoPatente;
        this.listaNeumaticos = listaNeumaticos;
    }

    
    public int getId_patente() {
        return id_patente;
    }

    public void setId_patente(int id_patente) {
        this.id_patente = id_patente;
    }

    public String getCodigoPatente() {
        return codigoPatente;
    }

    public void setCodigoPatente(String codigoPatente) {
        this.codigoPatente = codigoPatente;
    }

    public List<Neumatico> getListaNeumaticos() {
        return listaNeumaticos;
    }

    public void setListaNeumaticos(List<Neumatico> listaNeumaticos) {
        this.listaNeumaticos = listaNeumaticos;
    }
    
    
}
