
package com.vendrellignacio.controlflotavehicular.logic;

import com.vendrellignacio.controlflotavehicular.persistence.ControladoraPersistencia;
import com.vendrellignacio.controlflotavehicular.persistence.exceptions.NonexistentEntityException;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
/////////////////////////////ACOPLADO//////////////////////////////////////////////////////////////////////7
    public void crearAcoplado(String tipoAcoplado, String patenteAcoplado) {
        Patente pat = new Patente();
        pat.setCodigoPatente(patenteAcoplado);
        Acoplado aco = new Acoplado();
        aco.setTipo_acoplado(tipoAcoplado);
        aco.setPatente(pat);
        controlPersis.guardarAco(aco,pat);
    }

    public List<Acoplado> traerAcos() {
        return controlPersis.traerAcos();
    }

    public void borrarAco(int idAco) {
        controlPersis.borrarAco(idAco);
    }
    

    public Acoplado traerAco(int idAco) {
        return controlPersis.traerAco(idAco);
    }

    public void modificarAco(Acoplado aco, Patente pat, String patente, String tipoAco) {
       
        pat.setCodigoPatente(patente);

        aco.setTipo_acoplado(tipoAco);
        aco.setPatente(pat);
        controlPersis.modificarAco(aco,pat);
    }

    public Patente traerPatAco(int id_patente) {
        return controlPersis.traerPatAco(id_patente);
    }
///////////////////////////////CHASIS/////////////////////////////////////////////////////////////////////////
    public List<Chasis> traerChas() {
        return controlPersis.traerChas();
    }

    public void crearCha(String anoChasis, String cargaMaxChasis, String colorChasis, String marcaChasis, String modeloChasis, String numSerieChasis, String patenteChasis) {
        Patente pat = new Patente();
        pat.setCodigoPatente(patenteChasis);
        Chasis cha = new Chasis();
        cha.setMarca(marcaChasis);
        cha.setModelo(modeloChasis);
        cha.setAno(Integer.parseInt(anoChasis));
        cha.setCarga_max(Double.parseDouble(cargaMaxChasis));
        cha.setColor(colorChasis);
        cha.setNum_serie(numSerieChasis);
        cha.setPatente(pat);
        controlPersis.guardarCha(cha,pat);
    }

    public void borrarCha(int idCha) {
        try {
            controlPersis.borrarCha(idCha);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Chasis traerCha(int idCha) {
        return controlPersis.traerCha(idCha);
    }

    public void modificarCha(Chasis cha, Patente pat, String patente, String anoChasis, String cargaMaxChasis, String colorChasis, String marcaChasis, String modeloChasis, String numSerieChasis) throws Exception {
        pat.setCodigoPatente(patente);
        cha.setAno(Integer.parseInt(anoChasis));
        cha.setCarga_max(Double.parseDouble(cargaMaxChasis));
        cha.setColor(colorChasis);
        cha.setMarca(marcaChasis);
        cha.setModelo(modeloChasis);
        cha.setNum_serie(numSerieChasis);
        cha.setPatente(pat);
        controlPersis.editarCha(pat,cha);
    }
/////////////////////////////////////////////VIAJE///////////////////////////////////////////////////////////
    public Integer traerIdAco(String acoViaje) {
        return controlPersis.traerIdAco(acoViaje);
    }

    public Integer traerIdCha(String chaViaje) {
        return controlPersis.traerIdCha(chaViaje);
    }

    public void crearViaje(Date fechaLl, Date fechaSa, String lugOriViaje, String lugDesViaje, String kmInViaje, 
            String kmFiViaje, String pesoCarViaje, String costoCarViaje, String ctgViaje, String dteViaje, 
            String guiaViaje, String acoViaje, String chaViaje, String combGasto, String peaGasto, String comiGasto) {
        System.out.println("Controladora CREARVIAJE");
        
        Viaje via = new Viaje();
        via.setCostoCarga(Integer.parseInt(costoCarViaje));
        via.setCtg(Integer.parseInt(ctgViaje));
        via.setDestino(lugDesViaje);
        via.setDte(Integer.parseInt(dteViaje));
        via.setFechaLlegada(fechaLl);
        via.setFechaSalida(fechaSa);
        via.setGuia(Integer.parseInt(guiaViaje));
        
        via.setKmFinal(Double.parseDouble(kmFiViaje));
        via.setKmInicial(Double.parseDouble(kmInViaje));
        via.setKmRecorrido(via.getKmFinal() - via.getKmInicial());
        
        via.setLugarOrigen(lugOriViaje);
        via.setPesoCarga(Double.parseDouble(pesoCarViaje));
        //REGISTRAR LOS MANY
        Acoplado aco;
        aco = controlPersis.traerAco(Integer.parseInt(acoViaje));
        via.setUnAcoplado(aco);
        Chasis cha;
        cha = controlPersis.traerCha(Integer.parseInt(chaViaje));
        via.setUnChasis(cha);
        /*Rol rol2 = new Rol();
        rol2 = this.traerRol(rol1);
        if(rol2!=null){
            user.setUnRol(rol2);
        }*/
        //REGISTRAR el ONE
        Gasto gas = new Gasto();
        gas.setComida(Double.parseDouble(comiGasto));
        gas.setPeaje(Double.parseDouble(peaGasto));
        gas.setTotalCombus(Double.parseDouble(combGasto));
        via.setUnGasto(gas);
        
        controlPersis.crearViaje(via, gas);
    }

    

    public List<Viaje> traerViajes() {
        return controlPersis.traerViajes();
    }

    public void borrarVia(int idVia) {
        controlPersis.borrarVia(idVia);
    }

    public Viaje traerVia(int idVia) {
        return controlPersis.traerVia(idVia);
    }

    public Gasto traerGas(int id_gasto) {
        return controlPersis.traerGas(id_gasto);
    }

    public void editarViaje(Viaje via, Gasto gas, Date fechaLl, Date fechaSa, String lugOriViaje, 
            String lugDesViaje, String kmInViaje, String kmFiViaje, String pesoCarViaje, String costoCarViaje, 
            String ctgViaje, String dteViaje, String guiaViaje, String acoViaje, String chaViaje, String combGasto, 
            String peaGasto, String comiGasto) {
        gas.setComida(Double.parseDouble(comiGasto));
        gas.setPeaje(Double.parseDouble(peaGasto));
        gas.setTotalCombus(Double.parseDouble(peaGasto));
        via.setUnGasto(gas);
        via.setCostoCarga(Double.parseDouble(costoCarViaje));
        via.setCtg(Integer.parseInt(ctgViaje));
        via.setDestino(lugDesViaje);
        via.setDte(Integer.parseInt(dteViaje));
        via.setFechaLlegada(fechaLl);
        via.setFechaSalida(fechaSa);
        via.setGuia(Integer.parseInt(guiaViaje));
        
        via.setKmFinal(Double.parseDouble(kmFiViaje));
        via.setKmInicial(Double.parseDouble(kmInViaje));
        via.setKmRecorrido(via.getKmFinal() - via.getKmInicial());
        
        via.setLugarOrigen(lugOriViaje);
        via.setPesoCarga(Double.parseDouble(pesoCarViaje));
        
        Acoplado aco;
        aco = controlPersis.traerAco(Integer.parseInt(acoViaje));
        via.setUnAcoplado(aco);
        Chasis cha;
        cha = controlPersis.traerCha(Integer.parseInt(chaViaje));
        via.setUnChasis(cha);
        
        controlPersis.editarVia(gas, via);
        
    }
/////////////////////////////////////////////NEUMATICO///////////////////////////////////////
    public List<Neumatico> traerNeus() {
        return controlPersis.traerNeus();
    }

    public void borrarNeu(int idNeu) {
        controlPersis.borrarNeu(idNeu);
    }

    public void crearNeumatico(Date fechaUso, String codNeum, String kmTotales, 
            String marcaNeum, String estadoNeum, String neuPatente) {
        Neumatico neu = new Neumatico();
        neu.setCod_neumatico(codNeum);
        neu.setEstado(estadoNeum);
        neu.setFechaUso(fechaUso);
        neu.setKmTotal(Double.valueOf(kmTotales));
        neu.setMarca(marcaNeum);
        Patente pat;
        pat = controlPersis.traerPatbyPatente(neuPatente);
        neu.setUnPatente(pat);
        
        controlPersis.crearNeumatico(neu);
    }

    public Neumatico traerNeu(int idNeu) {
        return controlPersis.traerNeu(idNeu);
    }

    public void editarNeumatico(Neumatico neu, Date fechaUso, String codNeum, String kmTotales, 
            String marcaNeum, String estadoNeum, String neuPatente) {
        neu.setCod_neumatico(codNeum);
        neu.setEstado(estadoNeum);
        neu.setFechaUso(fechaUso);
        neu.setKmTotal(Double.valueOf(kmTotales));
        neu.setMarca(marcaNeum);
        Patente pat;
        pat = controlPersis.traerPatbyPatente(neuPatente);
        neu.setUnPatente(pat);
        
        try {
            controlPersis.editarNeu(neu);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Tecnica> traerTecs() {
        return controlPersis.traerTecs();
    }

    public void borrarTec(int idTec) {
        controlPersis.borrarTec(idTec);
    }

    public void crearTecnica(String anoTecnica, String patenteTecnica, Date vencvtv) {
        Patente pat;
        pat = controlPersis.traerPatbyPatente(patenteTecnica);
        Tecnica tec = new Tecnica();
        tec.setAno(Integer.parseInt(anoTecnica));
        tec.setVencVTV(vencvtv);
        tec.setUnPatente(pat);
        controlPersis.guardarTec(tec); 
    }

    public Tecnica traerTec(int idTec) {
        return controlPersis.traerTec(idTec);
    }

    public void editarTecnica(Tecnica tec, String anoTecnica, String patenteTecnica, Date vencvtv) {
        Patente pat;
        pat = controlPersis.traerPatbyPatente(patenteTecnica);
        tec.setAno(Integer.parseInt(anoTecnica));
        tec.setVencVTV(vencvtv);
        tec.setUnPatente(pat);
        controlPersis.editarTec(tec); 
    }

    ////////////////////////////////SEGURO///////////////////////////////////////7
    public void borrarSeg(int idSeg) {
        controlPersis.borrarSeg(idSeg);
    }

    public void crearSeguro(Date fechaVenc, Date fechaInicio, String poliza, String tipo, 
            String importe, String segPatente, String aseguradora) {
        Patente pat;
        pat = controlPersis.traerPatbyPatente(segPatente);
        Seguro seg = new Seguro();
        seg.setImporte(Double.parseDouble(importe));
        seg.setPoliza(poliza);
        seg.setFechaInicio(fechaInicio);
        seg.setFechaVenc(fechaVenc);
        seg.setTipo(tipo);
        seg.setAseguradora(aseguradora);
         // Obtener la fecha actual
        Date fechaActual = new Date();
        // Variable para almacenar el estado
        String estado;
        // Comparación de fechas
        if (fechaActual.after(fechaVenc)) {
            estado = "Vencida";
        } else {
            estado = "Activa";
        }
        seg.setEstado(estado);
        
        seg.setUnPatente(pat);
        controlPersis.guardarSeg(seg); 
    }

    public List<Seguro> traerSegs() {
        return controlPersis.traerSegs();
    }

    public Seguro traerSeg(int idSeg) {
        return controlPersis.traerSeg(idSeg);
    }

    public void editarSeguro(Seguro seg, Date fechaVenc, Date fechaInicio, String poliza, String tipo, String importe, String segPatente, String aseguradora) {
        Patente pat;
        pat = controlPersis.traerPatbyPatente(segPatente);
        
        seg.setImporte(Double.parseDouble(importe));
        seg.setPoliza(poliza);
        seg.setFechaInicio(fechaInicio);
        seg.setFechaVenc(fechaVenc);
        seg.setTipo(tipo);
        seg.setAseguradora(aseguradora);
         // Obtener la fecha actual
        Date fechaActual = new Date();
        // Variable para almacenar el estado
        String estado;
        // Comparación de fechas
        if (fechaActual.after(fechaVenc)) {
            estado = "Vencida";
        } else {
            estado = "Activa";
        }
        seg.setEstado(estado);
        
        seg.setUnPatente(pat);
        controlPersis.editarSeg(seg); 
    }
    
    
    
    
}
