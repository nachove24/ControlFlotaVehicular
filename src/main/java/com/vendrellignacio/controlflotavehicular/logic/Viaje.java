
package com.vendrellignacio.controlflotavehicular.logic;

import java.io.Serializable;
import java.util.Date;
/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;*/

//@Entity
public class Viaje implements Serializable {
    //atributos
    //@Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_viaje;
    //@Temporal(TemporalType.DATE)
    private Date fechaSalida;
    //@Temporal(TemporalType.DATE)
    private Date fechaLlegada;
    private String lugarOrigen;
    private String destino;
    private double kmInicial;
    private double kmFinal;
    private double kmRecorrido;
    private double pesoCarga;
    private double costoCarga;
    private int ctg;
    private int guia;
    private int dte;
    
    //@ManyToOne
    private Acoplado unAcoplado;
    //@ManyToOne
    private Chasis unChasis;
    //@OneToOne
    private Gasto unGasto;
    //constructores

    public Viaje() {
    }

    public Viaje(int id_viaje, Date fechaSalida, Date fechaLlegada, String lugarOrigen, String destino, double kmInicial, double kmFinal, double kmRecorrido, double pesoCarga, double costoCarga, int ctg, int guia, int dte, Acoplado unAcoplado, Chasis unChasis, Gasto unGasto) {
        this.id_viaje = id_viaje;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.lugarOrigen = lugarOrigen;
        this.destino = destino;
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.kmRecorrido = kmRecorrido;
        this.pesoCarga = pesoCarga;
        this.costoCarga = costoCarga;
        this.ctg = ctg;
        this.guia = guia;
        this.dte = dte;
        this.unAcoplado = unAcoplado;
        this.unChasis = unChasis;
        this.unGasto = unGasto;
    }


    public int getId_viaje() {
        return id_viaje;
    }

    public void setId_viaje(int id_viaje) {
        this.id_viaje = id_viaje;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getLugarOrigen() {
        return lugarOrigen;
    }

    public void setLugarOrigen(String lugarOrigen) {
        this.lugarOrigen = lugarOrigen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(double kmInicial) {
        this.kmInicial = kmInicial;
    }

    public double getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(double kmFinal) {
        this.kmFinal = kmFinal;
    }

    public double getKmRecorrido() {
        return kmRecorrido;
    }

    public void setKmRecorrido(double kmRecorrido) {
        this.kmRecorrido = kmRecorrido;
    }

    public double getPesoCarga() {
        return pesoCarga;
    }

    public void setPesoCarga(double pesoCarga) {
        this.pesoCarga = pesoCarga;
    }

    public double getCostoCarga() {
        return costoCarga;
    }

    public void setCostoCarga(double costoCarga) {
        this.costoCarga = costoCarga;
    }

    public int getCtg() {
        return ctg;
    }

    public void setCtg(int ctg) {
        this.ctg = ctg;
    }

    public int getGuia() {
        return guia;
    }

    public void setGuia(int guia) {
        this.guia = guia;
    }

    public int getDte() {
        return dte;
    }

    public void setDte(int dte) {
        this.dte = dte;
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

    public Gasto getUnGasto() {
        return unGasto;
    }

    public void setUnGasto(Gasto unGasto) {
        this.unGasto = unGasto;
    }
    
}
