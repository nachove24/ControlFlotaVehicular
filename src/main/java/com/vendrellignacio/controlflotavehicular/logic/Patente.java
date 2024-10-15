
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
    @OneToMany(mappedBy = "unPatente")
    private List<Tecnica> listaTecnicas;
    @OneToMany(mappedBy = "unPatente")
    private List<Impuesto> listaImpuestos;
    @OneToMany(mappedBy = "unPatente")
    private List<Mantenimiento> listaMantenimiento;
    @OneToMany(mappedBy = "unPatente")
    private List<Seguro> listaSeguros;
    
    
    
    public Patente() {
    }

    public Patente(int id_patente, String codigoPatente, List<Neumatico> listaNeumaticos, List<Tecnica> listaTecnicas, List<Impuesto> listaImpuestos, List<Mantenimiento> listaMantenimiento, List<Seguro> listaSeguros) {
        this.id_patente = id_patente;
        this.codigoPatente = codigoPatente;
        this.listaNeumaticos = listaNeumaticos;
        this.listaTecnicas = listaTecnicas;
        this.listaImpuestos = listaImpuestos;
        this.listaMantenimiento = listaMantenimiento;
        this.listaSeguros = listaSeguros;
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

    public List<Tecnica> getListaTecnicas() {
        return listaTecnicas;
    }

    public void setListaTecnicas(List<Tecnica> listaTecnicas) {
        this.listaTecnicas = listaTecnicas;
    }

    public List<Impuesto> getListaImpuestos() {
        return listaImpuestos;
    }

    public void setListaImpuestos(List<Impuesto> listaImpuestos) {
        this.listaImpuestos = listaImpuestos;
    }

    public List<Mantenimiento> getListaMantenimiento() {
        return listaMantenimiento;
    }

    public void setListaMantenimiento(List<Mantenimiento> listaMantenimiento) {
        this.listaMantenimiento = listaMantenimiento;
    }

    public List<Seguro> getListaSeguros() {
        return listaSeguros;
    }

    public void setListaSeguros(List<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
    }
    
    
}
