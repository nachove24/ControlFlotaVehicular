
package com.vendrellignacio.controlflotavehicular.igu;

import com.vendrellignacio.controlflotavehicular.logic.Controladora;
import com.vendrellignacio.controlflotavehicular.logic.Neumatico;
import com.vendrellignacio.controlflotavehicular.logic.Patente;
import com.vendrellignacio.controlflotavehicular.logic.Seguro;
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
//import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class BuscarSeg extends javax.swing.JFrame {

    Controladora control;
    SimpleDateFormat formatoFecha;
    public BuscarSeg() {
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
        txtBuscarPoliza = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaNeu = new javax.swing.JTable();
        btnExportar = new javax.swing.JButton();
        btnImportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel1.setText("Neumático");

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabel2.setText("Buscar por:");

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Id/Aseguradora", "Fecha Inicio", "Fecha Vencimiento", "Poliza" }));

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

        jLabel5.setText("Poliza:");

        jLabel6.setText("Id/Aseguradora:");

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(65, 65, 65)))
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
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(141, 141, 141))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtBuscarPoliza, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap()))))))
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
                    .addComponent(txtBuscarPoliza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
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

        tablaNeu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaNeu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaNeu);

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
                .addGap(162, 162, 162)
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
        
if(null != filtro)switch (filtro) {
    case "Id/Aseguradora" -> {
        String texto = txtBuscar.getText().trim();
        if (texto.isEmpty()) {
            mostrarMensaje("Ingrese un ID o código para buscar", "error", "Campo vacío");
            return;
        }   
        try {
            // Intentar buscar por ID (número)
            int idBuscado = Integer.parseInt(texto);
            Seguro seguro = control.traerSeg(idBuscado);
            
            if (seguro == null) {
                // Si no se encuentra por ID, mostrar mensaje
                mostrarMensaje("No se encontró seguro con el ID ingresado.", "error", "ID NO EXISTE");
                txtBuscar.setText("");
                txtBuscar.requestFocus();
            } else {
                // Mostrar resultado único
                mostrarRegistroUnico(seguro);
            }
        } catch (NumberFormatException e) {
                List<Seguro> listaSeguros = control.buscarSegurosPorAseguradora(texto);
                if (listaSeguros == null || listaSeguros.isEmpty()) {
                mostrarMensaje("No se encontraron seguros con la aseguradora ingresada.", "error", "ASEGURADORA NO EXISTE");
                txtBuscar.setText("");
                txtBuscar.requestFocus();
                return;
                }else{mostrarSegurosFiltrados(listaSeguros);}
        }
    }
    case "Fecha Vencimiento" -> {
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
        List<Seguro> listaSeguros = control.buscarSegurosPorFechaVencimiento(fechaInicial, fechaLimite);
        if (listaSeguros == null || listaSeguros.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No se encontraron seguros entre las fechas seleccionadas",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
            return;
        }   
        mostrarSegurosFiltrados(listaSeguros);
    }
    case "Fecha Inicio" -> {
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
        List<Seguro> listaSeguros = control.buscarSegurosPorFechaInicio(fechaInicial, fechaLimite);
        if (listaSeguros == null || listaSeguros.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No se encontraron seguros entre las fechas seleccionadas",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
            return;
        }   
        mostrarSegurosFiltrados(listaSeguros);
    }
    case "Poliza" -> {
            String texto = txtBuscarPoliza.getText();
         // Si no es un número, buscar por número de póliza
            Seguro seguro = control.buscarSeguroPorPoliza(texto);
            
            if (seguro == null) {
                mostrarMensaje("No se encontraron seguros con la poliza ingresada.", "error", "POLIZA NO EXISTE");
                } else {
                mostrarRegistroUnico(seguro);
            }
    }
    default -> {
        cargarTabla();
    }
}
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        cargarTabla();
        cmbFiltro.setSelectedIndex(0);
        txtBuscarPoliza.setText("");
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
                pw.println("id,codigo,fecha,kmTotal,marca,estado,patente");
                
                // Obtener los datos actuales
                List<Neumatico> listaNeumaticos = control.traerNeus();
                
                // Escribir cada registro
                for (Neumatico neumatico : listaNeumaticos) {
                    pw.println(
                        neumatico.getId_neumatico() + "," +
                        neumatico.getCod_neumatico() + "," +
                        formatoFecha.format(neumatico.getFechaUso()) + "," +
                        neumatico.getKmTotal() + "," +
                        neumatico.getMarca().replace(",", ";") + "," +
                        neumatico.getEstado() + "," +
                        (neumatico.getUnPatente() != null ? neumatico.getUnPatente().getCodigoPatente() : "N/A")
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
        fileChooser.setDialogTitle("Seleccionar archivo");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos CSV (*.csv)", "csv"));
        
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                // Saltar la primera línea (encabezados)
                br.readLine();
                
                List<Neumatico> neumaticosImportados = new ArrayList<>();
                SimpleDateFormat formatoFechaImport = new SimpleDateFormat("dd/MM/yyyy");
                
                while ((line = br.readLine()) != null) {
                    String[] datos = line.split(",");
                    if (datos.length >= 6) {
                        try {
                            // Convertir datos a un objeto Neumatico
                            Neumatico neumatico = new Neumatico();
                            
                            // Código del neumático
                            neumatico.setCod_neumatico(datos[1]);
                            
                            // Convertir fecha de String a Date
                            try {
                                Date fecha = formatoFechaImport.parse(datos[2]);
                                neumatico.setFechaUso(fecha);
                            } catch (ParseException e) {
                                System.out.println("Error al parsear la fecha: " + datos[2]);
                                e.printStackTrace();
                                continue;
                            }
                            
                            // Convertir kmTotal
                            try {
                                Double kmTotal = Double.valueOf(datos[3]);
                                neumatico.setKmTotal(kmTotal);
                            } catch (NumberFormatException e) {
                                System.out.println("Error al parsear kilómetros: " + datos[3]);
                                continue;
                            }
                            
                            // Marca
                            neumatico.setMarca(datos[4]);
                            
                            // Estado
                            neumatico.setEstado(datos[5]);
                            
                            // Patente (si existe)
                            if (datos.length > 6 && !datos[6].equals("N/A")) {
                                Patente vehiculo = control.buscarPorPatente(datos[6]);
                                if (vehiculo == null) {
                                    System.out.println("No se encontró vehículo con patente: " + datos[6]);
                                    // Continuar sin asignar vehículo
                                } else {
                                    neumatico.setUnPatente(vehiculo);
                                }
                            }
                            
                            neumaticosImportados.add(neumatico);
                            
                        } catch (Exception e) {
                            System.out.println("Error procesando línea: " + line);
                            e.printStackTrace();
                        }
                    }
                }
                
                // Confirmar importación
                if (!neumaticosImportados.isEmpty()) {
                    int respuesta = JOptionPane.showConfirmDialog(
                        this, 
                        "Se importarán " + neumaticosImportados.size() + " registros. ¿Desea continuar?",
                        "Confirmar importación",
                        JOptionPane.YES_NO_OPTION);
                        
                    if (respuesta == JOptionPane.YES_OPTION) {
                        // Guardar en la base de datos
                        boolean exito = control.guardarNeumaticosImportados(neumaticosImportados);
                        
                        if (exito) {
                            mostrarMensaje("Importación completada con éxito", "info", "Importación");
                            // Recargar tabla
                            cargarTabla();
                        } else {
                            mostrarMensaje("Ocurrió un error durante la importación", "error", "Error");
                        }
                    }
                } else {
                    mostrarMensaje("No se encontraron registros válidos para importar", "error", "Sin registros");
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
        
        String titulos[] = {"Id", "Aseguradora", "Poliza", "Fecha Inicio", "Fecha Vencimiento", "Importe", "Tipo", "Patente"};
        model.setColumnIdentifiers(titulos);
        tablaNeu.setModel(model);
        
        //traer los registros desde la bd
        List<Seguro> listaSeguros = control.traerSegs();
        if (listaSeguros != null && !listaSeguros.isEmpty()) {
            // Ordenar la lista por fecha en orden descendente (más reciente primero)
            Collections.sort(listaSeguros, (Seguro s1, Seguro s2) -> 
                 s2.getFechaInicio().compareTo(s1.getFechaInicio())
             );

            // Agregar los datos ordenados al modelo de la tabla
            for (Seguro seguro : listaSeguros) {
                Object[] obj = {
                    seguro.getId_seguro(),
                    seguro.getAseguradora(),
                    seguro.getPoliza(),
                    formatoFecha.format(seguro.getFechaInicio()),
                    formatoFecha.format(seguro.getFechaVenc()),
                    seguro.getImporte(),
                    seguro.getTipo(),
                    seguro.getUnPatente() != null ? seguro.getUnPatente().getCodigoPatente() : "N/A"
                };
                model.addRow(obj);
            }
        }
        tablaNeu.setModel(model);
    }
     private void mostrarRegistroUnico(Seguro seguro) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        String titulos[] = {"Id", "Aseguradora", "Poliza", "Fecha Inicio", "Fecha Vencimiento", "Importe", "Tipo", "Patente"};
        model.setColumnIdentifiers(titulos);
        
        Object[] obj = {
            seguro.getId_seguro(),
            seguro.getAseguradora(),
            seguro.getPoliza(),
            formatoFecha.format(seguro.getFechaInicio()),
            formatoFecha.format(seguro.getFechaVenc()),
            seguro.getImporte(),
            seguro.getTipo(),
            seguro.getUnPatente() != null ? seguro.getUnPatente().getCodigoPatente() : "N/A"
        };
        
        model.addRow(obj);
        tablaNeu.setModel(model);
    }
    
    private void mostrarSegurosFiltrados(List<Seguro> listaSeg) {
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    String titulos[] = {"Id", "Aseguradora", "Poliza", "Fecha Inicio", "Fecha Vencimiento", "Importe", "Tipo", "Patente"};
    model.setColumnIdentifiers(titulos);
    
    for (Seguro seg : listaSeg) {
        Object[] obj = {
            seg.getId_seguro(),
            seg.getAseguradora(),
            seg.getPoliza(),
            formatoFecha.format(seg.getFechaInicio()),
            formatoFecha.format(seg.getFechaVenc()),
            seg.getImporte(),
            seg.getTipo(),
            seg.getUnPatente() != null ? seg.getUnPatente().getCodigoPatente() : "N/A"
        };
        model.addRow(obj);
    }
    
    tablaNeu.setModel(model);
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
    private javax.swing.JTable tablaNeu;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscarPoliza;
    // End of variables declaration//GEN-END:variables
}
