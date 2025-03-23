
package com.vendrellignacio.controlflotavehicular.igu;

import com.vendrellignacio.controlflotavehicular.logic.Acoplado;
import com.vendrellignacio.controlflotavehicular.logic.Chasis;
import com.vendrellignacio.controlflotavehicular.logic.Controladora;
import com.vendrellignacio.controlflotavehicular.logic.Impuesto;
import com.vendrellignacio.controlflotavehicular.logic.Patente;
import com.vendrellignacio.controlflotavehicular.logic.Viaje;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class BuscarVia extends javax.swing.JFrame {

    Controladora control;
    SimpleDateFormat formatoFecha;
    public BuscarVia() {
        initComponents();
        control = new Controladora();
        formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        cmbFiltro = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        dcFechaLimite = new com.toedter.calendar.JDateChooser();
        btnRestaurar = new javax.swing.JButton();
        dcFechaInicial = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVia = new javax.swing.JTable();
        btnExportar = new javax.swing.JButton();
        btnImportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel1.setText("Viaje");

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabel2.setText("Buscar por:");

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Id", "Fecha Salida", "Fecha Llegada", "Destino" }));

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnRestaurar.setText("RESTAURAR");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha limite:");

        jLabel4.setText("Fecha inicial:");

        jLabel5.setText("Destino:");

        jLabel6.setText("Id:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(dcFechaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnBuscar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnRestaurar))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dcFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addContainerGap()))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar)
                        .addComponent(btnRestaurar))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dcFechaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
        );

        tablaVia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaVia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaVia);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        btnImportar.setText("Importar");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(193, 193, 193)
                .addComponent(btnExportar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImportar)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExportar)
                            .addComponent(btnImportar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened
 
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       String filtro = (String) cmbFiltro.getSelectedItem();
        
if (null != filtro) switch (filtro) {
    case "Id" -> {
        String texto = txtBuscar.getText().trim();
        if (texto.isEmpty()) {
            mostrarMensaje("Ingrese un ID para buscar", "error", "Campo vacío");
            return;
        }   
        try {
            // Buscar por ID
            int idBuscado = Integer.parseInt(texto);
            Viaje viaje = control.traerVia(idBuscado);
            
            if (viaje == null) {
                mostrarMensaje("No se encontró viaje con el ID ingresado.", "error", "ID NO EXISTE");
                txtBuscar.setText("");
                txtBuscar.requestFocus();
            } else {
                // Mostrar resultado único
                mostrarRegistroUnico(viaje);
            }
        } catch (NumberFormatException e) {
            mostrarMensaje("El ID debe ser un número", "error", "FORMATO INCORRECTO");
            txtBuscar.setText("");
            txtBuscar.requestFocus();
        }
    }
    case "Fecha Salida" -> {
        Date fechaInicial = dcFechaInicial.getDate();
        Date fechaLimite = dcFechaLimite.getDate();
        if (fechaInicial == null || fechaLimite == null) {
            JOptionPane.showMessageDialog(this,
                    "Por favor seleccione ambas fechas",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }   
        // Verificar que la fecha inicial no sea posterior a la fecha límite
        if (fechaInicial.after(fechaLimite)) {
            JOptionPane.showMessageDialog(this,
                    "La fecha inicial no puede ser posterior a la fecha límite",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }   
        List<Viaje> listaViajes = control.buscarViajesPorFechaSalida(fechaInicial, fechaLimite);
        if (listaViajes == null || listaViajes.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No se encontraron viajes entre las fechas de salida seleccionadas",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
            return;
        }   
        mostrarViajesFiltrados(listaViajes);
    }
    case "Fecha Llegada" -> {
        Date fechaInicial = dcFechaInicial.getDate();
        Date fechaLimite = dcFechaLimite.getDate();
        if (fechaInicial == null || fechaLimite == null) {
            JOptionPane.showMessageDialog(this,
                    "Por favor seleccione ambas fechas",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }   
        // Verificar que la fecha inicial no sea posterior a la fecha límite
        if (fechaInicial.after(fechaLimite)) {
            JOptionPane.showMessageDialog(this,
                    "La fecha inicial no puede ser posterior a la fecha límite",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }   
        List<Viaje> listaViajes = control.buscarViajesPorFechaLlegada(fechaInicial, fechaLimite);
        if (listaViajes == null || listaViajes.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No se encontraron viajes entre las fechas de llegada seleccionadas",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
            return;
        }   
        mostrarViajesFiltrados(listaViajes);
    }
    case "Destino" -> {
        String destino = txtBuscar.getText().trim();
        if (destino.isEmpty()) {
            mostrarMensaje("Ingrese un destino para buscar", "error", "Campo vacío");
            return;
        }
        List<Viaje> listaViajes = control.buscarViajesPorDestino(destino);
        if (listaViajes == null || listaViajes.isEmpty()) {
            mostrarMensaje("No se encontraron viajes al destino ingresado.", "error", "DESTINO SIN REGISTROS");
            txtBuscar.setText("");
            txtBuscar.requestFocus();
            return;
        }
        mostrarViajesFiltrados(listaViajes);
    }
    default -> {
        cargarTabla();
    }
}
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        cargarTabla();
        cmbFiltro.setSelectedIndex(0);
        txtDestino.setText("");
        txtBuscar.setText("");
        dcFechaInicial.setDate(null);
        dcFechaLimite.setDate(null);
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
                                               
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Guardar archivo");
    fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos CSV (*.csv)", "csv"));
    
    if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        // Asegurar que tenga extensión .csv
        if (!file.getName().toLowerCase().endsWith(".csv")) {
            file = new File(file.getAbsolutePath() + ".csv");
        }
        
        try (FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw)) {
            
            // Escribir encabezados
            pw.println("id,fechaSalida,fechaLlegada,lugarOrigen,destino,kmInicial,kmFinal,kmRecorrido,pesoCarga,costoCarga,ctg,guia,dte,acoplado,chasis,gasto");
            
            // Obtener los datos actuales
            List<Viaje> listaViajes = control.traerViajes();
            
            // Escribir cada registro
            for (Viaje viaje : listaViajes) {
                pw.println(
                    viaje.getId_viaje() + "," +
                    formatoFecha.format(viaje.getFechaSalida()) + "," +
                    formatoFecha.format(viaje.getFechaLlegada()) + "," +
                    viaje.getLugarOrigen().replace(",", ";") + "," +
                    viaje.getDestino().replace(",", ";") + "," +
                    viaje.getKmInicial() + "," +
                    viaje.getKmFinal() + "," +
                    viaje.getKmRecorrido() + "," +
                    viaje.getPesoCarga() + "," +
                    viaje.getCostoCarga() + "," +
                    viaje.getCtg() + "," +
                    viaje.getGuia() + "," +
                    viaje.getDte() + "," +
                    (viaje.getUnAcoplado() != null ? viaje.getUnAcoplado().getId_acoplado(): "N/A") + "," +
                    (viaje.getUnChasis() != null ? viaje.getUnChasis().getId_chasis(): "N/A") + "," +
                    (viaje.getUnGasto() != null ? viaje.getUnGasto().getId_gasto(): "N/A")
                );
            }
            
            mostrarMensaje("Archivo exportado exitosamente", "info", "Exportación Completa");
            
        } catch (IOException e) {
            mostrarMensaje("Error al exportar: " + e.getMessage(), "error", "Error");
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
    JFileChooser fileChooser = new JFileChooser();
fileChooser.setDialogTitle("Seleccionar archivo de viajes");
fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos CSV (*.csv)", "csv"));

if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
    File file = fileChooser.getSelectedFile();
    
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        // Saltar la primera línea (encabezados)
        br.readLine();
        
        List<Viaje> viajesImportados = new ArrayList<>();
        SimpleDateFormat formatoFechaImport = new SimpleDateFormat("dd/MM/yyyy");
        
        while ((line = br.readLine()) != null) {
            String[] datos = line.split(",");
            if (datos.length >= 13) {
                try {
                    // Convertir datos a un objeto Viaje
                    Viaje viaje = new Viaje();
                    
                    int columna = 1; // Empezamos en 1 para saltar el id que es generado automáticamente
                    
                    // Convertir fecha de salida
                    try {
                        Date fechaSalida = formatoFechaImport.parse(datos[columna++]);
                        viaje.setFechaSalida(fechaSalida);
                    } catch (ParseException e) {
                        System.out.println("Error al parsear la fecha de salida: " + datos[columna-1]);
                        e.printStackTrace();
                        continue;
                    }
                    
                    // Convertir fecha de llegada
                    try {
                        Date fechaLlegada = formatoFechaImport.parse(datos[columna++]);
                        viaje.setFechaLlegada(fechaLlegada);
                    } catch (ParseException e) {
                        System.out.println("Error al parsear la fecha de llegada: " + datos[columna-1]);
                        e.printStackTrace();
                        continue;
                    }
                    
                    // Lugar de origen
                    viaje.setLugarOrigen(datos[columna++]);
                    
                    // Destino
                    viaje.setDestino(datos[columna++]);
                    
                    // Kilómetros iniciales
                    try {
                        double kmInicial = Double.parseDouble(datos[columna++]);
                        viaje.setKmInicial(kmInicial);
                    } catch (NumberFormatException e) {
                        System.out.println("Error al parsear kilómetros iniciales: " + datos[columna-1]);
                        continue;
                    }
                    
                    // Kilómetros finales
                    try {
                        double kmFinal = Double.parseDouble(datos[columna++]);
                        viaje.setKmFinal(kmFinal);
                    } catch (NumberFormatException e) {
                        System.out.println("Error al parsear kilómetros finales: " + datos[columna-1]);
                        continue;
                    }
                    
                    // Kilómetros recorridos (opcional, se puede calcular)
                    try {
                        double kmRecorrido = Double.parseDouble(datos[columna++]);
                        viaje.setKmRecorrido(kmRecorrido);
                    } catch (NumberFormatException e) {
                        // Si no se proporciona, calcularlo a partir de km inicial y final
                        viaje.setKmRecorrido(viaje.getKmFinal() - viaje.getKmInicial());
                        columna++;
                    }
                    
                    // Peso de carga
                    try {
                        double pesoCarga = Double.parseDouble(datos[columna++]);
                        viaje.setPesoCarga(pesoCarga);
                    } catch (NumberFormatException e) {
                        System.out.println("Error al parsear peso de carga: " + datos[columna-1]);
                        continue;
                    }
                    
                    // Costo de carga
                    try {
                        double costoCarga = Double.parseDouble(datos[columna++]);
                        viaje.setCostoCarga(costoCarga);
                    } catch (NumberFormatException e) {
                        System.out.println("Error al parsear costo de carga: " + datos[columna-1]);
                        continue;
                    }
                    
                    // CTG
                    try {
                        int ctg = Integer.parseInt(datos[columna++]);
                        viaje.setCtg(ctg);
                    } catch (NumberFormatException e) {
                        System.out.println("Error al parsear CTG: " + datos[columna-1]);
                        continue;
                    }
                    
                    // Guía
                    try {
                        int guia = Integer.parseInt(datos[columna++]);
                        viaje.setGuia(guia);
                    } catch (NumberFormatException e) {
                        System.out.println("Error al parsear guía: " + datos[columna-1]);
                        continue;
                    }
                    
                    // DTE
                    try {
                        int dte = Integer.parseInt(datos[columna++]);
                        viaje.setDte(dte);
                    } catch (NumberFormatException e) {
                        System.out.println("Error al parsear DTE: " + datos[columna-1]);
                        continue;
                    }
                    
                    // Acoplado (si existe)
                    if (columna < datos.length && !datos[columna].isEmpty() && !datos[columna].equals("N/A")) {
                        // Asumiendo que existe un método para buscar acoplado por un identificador
                        Acoplado acoplado;
                        acoplado = control.traerAco(Integer.parseInt(datos[columna]));
                        if (acoplado == null) {
                            System.out.println("No se encontró acoplado con ID: " + datos[columna]);
                        } else {
                            viaje.setUnAcoplado(acoplado);
                        }
                    }
                    columna++;
                    
                    // Chasis (si existe)
                    if (columna < datos.length && !datos[columna].isEmpty() && !datos[columna].equals("N/A")) {
                        // Asumiendo que existe un método para buscar chasis por un identificador
                        Chasis chasis = control.traerCha(Integer.parseInt(datos[columna]));
                        if (chasis == null) {
                            System.out.println("No se encontró chasis con ID: " + datos[columna]);
                        } else {
                            viaje.setUnChasis(chasis);
                        }
                    }
                    
                    // Nota: No importamos Gasto ni la lista de Multas aquí, ya que son relaciones 
                    // que probablemente se manejarían por separado o después de crear el viaje
                    
                    viajesImportados.add(viaje);
                    
                } catch (Exception e) {
                    System.out.println("Error procesando línea: " + line);
                    e.printStackTrace();
                }
            } else {
                System.out.println("Línea con formato incorrecto (faltan columnas): " + line);
            }
        }
        
        // Confirmar importación
        if (!viajesImportados.isEmpty()) {
            int respuesta = JOptionPane.showConfirmDialog(
                this, 
                "Se importarán " + viajesImportados.size() + " viajes. ¿Desea continuar?",
                "Confirmar importación",
                JOptionPane.YES_NO_OPTION);
                
            if (respuesta == JOptionPane.YES_OPTION) {
                // Guardar en la base de datos
                boolean exito = control.guardarViajesImportados(viajesImportados);
                
                if (exito) {
                    mostrarMensaje("Importación de viajes completada con éxito", "info", "Importación");
                    // Recargar tabla
                    cargarTabla();
                } else {
                    mostrarMensaje("Ocurrió un error durante la importación de viajes", "error", "Error");
                }
            }
        } else {
            mostrarMensaje("No se encontraron registros de viajes válidos para importar", "error", "Sin registros");
        }
        
    } catch (IOException e) {
        mostrarMensaje("Error al leer el archivo: " + e.getMessage(), "error", "Error");
        e.printStackTrace();
    }
}
    }//GEN-LAST:event_btnImportarActionPerformed

    
    // Método para cargar la tabla con todos los neumáticos
    private void cargarTabla() {
        // Create a table model with data
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };
        
        String titulos[] = {"Id", "Fecha Salida", "Fecha Llegada",
            "Pat. Chasis", "Pat. Acoplado",
            "Lugar Origen", "Destino", 
            "CTG", "DTE", "GUIA", 
            "Km Recorrido", "Km Inicial", "Km Final",  
            "Costo Carga", "Peso Carga",
            "Combustible", "Peaje", "Comida"};
        model.setColumnIdentifiers(titulos);
        tablaVia.setModel(model);
        
        //traer los registros desde la bd
        List<Viaje> listaViaje = control.traerViajes();
        if (listaViaje != null && !listaViaje.isEmpty()) {
            // Ordenar la lista por fecha en orden descendente (más reciente primero)
            Collections.sort(listaViaje, (Viaje v1, Viaje v2) -> 
                 v2.getFechaSalida().compareTo(v1.getFechaSalida())
             );

            // Agregar los datos ordenados al modelo de la tabla
            for (Viaje via : listaViaje) {
                Object[] obj = {
                    via.getId_viaje(),
                    formatoFecha.format(via.getFechaSalida()), 
                    formatoFecha.format(via.getFechaLlegada()), 
                    via.getUnChasis().getPatente().getCodigoPatente(), 
                    via.getUnAcoplado().getPatente().getCodigoPatente(), 
                    via.getLugarOrigen(), 
                    via.getDestino(),
                    via.getCtg(), 
                    via.getDte(), 
                    via.getGuia(),
                    via.getKmRecorrido(),
                    via.getKmInicial(),
                    via.getKmFinal(),
                    via.getCostoCarga(),
                    via.getPesoCarga(),
                    via.getUnGasto().getTotalCombus(),
                    via.getUnGasto().getPeaje(),
                    via.getUnGasto().getComida()
                };
                model.addRow(obj);
            }
        }
        tablaVia.setModel(model);
    }
     private void mostrarRegistroUnico(Viaje via) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        String titulos[] = {"Id", "Fecha Salida", "Fecha Llegada",
            "Pat. Chasis", "Pat. Acoplado",
            "Lugar Origen", "Destino", 
            "CTG", "DTE", "GUIA", 
            "Km Recorrido", "Km Inicial", "Km Final",  
            "Costo Carga", "Peso Carga",
            "Combustible", "Peaje", "Comida"};
        model.setColumnIdentifiers(titulos);
        
       
            Object[] obj = {
                    via.getId_viaje(), 
                    formatoFecha.format(via.getFechaSalida()), 
                    formatoFecha.format(via.getFechaLlegada()), 
                    via.getUnChasis().getPatente().getCodigoPatente(), 
                    via.getUnAcoplado().getPatente().getCodigoPatente(), 
                    via.getLugarOrigen(), 
                    via.getDestino(),
                    via.getCtg(), 
                    via.getDte(), 
                    via.getGuia(),
                    via.getKmRecorrido(),
                    via.getKmInicial(),
                    via.getKmFinal(),
                    via.getCostoCarga(),
                    via.getPesoCarga(),
                    via.getUnGasto().getTotalCombus(),
                    via.getUnGasto().getPeaje(),
                    via.getUnGasto().getComida()
            };
        model.addRow(obj);
        tablaVia.setModel(model);
    }
    
    private void mostrarViajesFiltrados(List<Viaje> listaVia) {
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    String titulos[] = {"Id", "Fecha Salida", "Fecha Llegada",
            "Pat. Chasis", "Pat. Acoplado",
            "Lugar Origen", "Destino", 
            "CTG", "DTE", "GUIA", 
            "Km Recorrido", "Km Inicial", "Km Final",  
            "Costo Carga", "Peso Carga",
            "Combustible", "Peaje", "Comida"};
    model.setColumnIdentifiers(titulos);
    
    for (Viaje via : listaVia){
                Object[] obj = {
                    via.getId_viaje(), 
                    formatoFecha.format(via.getFechaSalida()), 
                    formatoFecha.format(via.getFechaLlegada()), 
                    via.getUnChasis().getPatente().getCodigoPatente(), 
                    via.getUnAcoplado().getPatente().getCodigoPatente(), 
                    via.getLugarOrigen(), 
                    via.getDestino(),
                    via.getCtg(), 
                    via.getDte(), 
                    via.getGuia(),
                    via.getKmRecorrido(),
                    via.getKmInicial(),
                    via.getKmFinal(),
                    via.getCostoCarga(),
                    via.getPesoCarga(),
                    via.getUnGasto().getTotalCombus(),
                    via.getUnGasto().getPeaje(),
                    via.getUnGasto().getComida()
                };
        model.addRow(obj);
    }
    
    tablaVia.setModel(model);
}

    
    public void mostrarMensaje (String mensaje, String tipo, String titulo){
	JOptionPane optionPane = new JOptionPane(mensaje);
	if(tipo.equals("info")){
		optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
	}else if(tipo.equals("error")) {
		optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
	}
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnImportar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JComboBox<String> cmbFiltro;
    private com.toedter.calendar.JDateChooser dcFechaInicial;
    private com.toedter.calendar.JDateChooser dcFechaLimite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaVia;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDestino;
    // End of variables declaration//GEN-END:variables
}
