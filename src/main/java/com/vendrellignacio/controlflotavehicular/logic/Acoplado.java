package com.vendrellignacio.controlflotavehicular.logic;

//import java.io.Serializable;
//import javax.persistence.Entity;

//@Entity
public class Acoplado {
    //ATRIBUTOS
    //@Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_acoplado;
    private String tipo_acoplado;
    private Patente patente; // Foreign key
    
    public Acoplado() {
    }

    public Acoplado(int id_acoplado, String tipo_acoplado, Patente patente) {
        this.id_acoplado = id_acoplado;
        this.tipo_acoplado = tipo_acoplado;
        this.patente = patente;
    }
    

    public int getId_acoplado() {
        return id_acoplado;
    }

    public void setId_acoplado(int id_acoplado) {
        this.id_acoplado = id_acoplado;
    }

    public String getTipo_acoplado() {
        return tipo_acoplado;
    }

    public void setTipo_acoplado(String tipo_acoplado) {
        this.tipo_acoplado = tipo_acoplado;
    }

    public Patente getPatente() {
        return patente;
    }

    public void setPatente(Patente patente) {
        this.patente = patente;
    }
    
    
}
