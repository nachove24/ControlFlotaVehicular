
package com.vendrellignacio.controlflotavehicular.igu;

import com.vendrellignacio.controlflotavehicular.logic.Controladora;
import com.vendrellignacio.controlflotavehicular.logic.Mantenimiento;
import com.vendrellignacio.controlflotavehicular.logic.Patente;
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


public class BuscarMan extends javax.swing.JFrame {

    Controladora control;
    SimpleDateFormat formatoFecha;
    public BuscarMan() {
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
        cmbKm = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMan = new javax.swing.JTable();
        btnExportar = new javax.swing.JButton();
        btnImportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel1.setText("Mantenimiento");

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabel2.setText("Buscar por:");

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Id", "Fecha", "Kilometros" }));

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

        cmbKm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<100", "100-500", "500-1000", ">1000", ">2000" }));

        jLabel5.setText("Kilometros:");

        jLabel6.setText("Id:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dcFechaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRestaurar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dcFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbKm, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(176, 176, 176)
                                .addComponent(jLabel3))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(79, 79, 79)
                        .addComponent(jLabel5)
                        .addGap(96, 96, 96))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
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

        tablaMan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaMan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaMan);

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(147, 147, 147)
                .addComponent(btnExportar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImportar)
                .addGap(25, 25, 25))
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
        
        if("Id".equals(filtro)){
            String texto = txtBuscar.getText();

            try {
                int idBuscado = Integer.parseInt(txtBuscar.getText());
                Mantenimiento man = control.traerMan(idBuscado);
    
                if (man == null) {
                    mostrarMensaje("Ingrese otro ID, el ID ingresado no existe.", "error","EL ID NO EXISTE");
                    txtBuscar.setText("");
                    txtBuscar.requestFocus();
                } else {
                    mostrarRegistroUnico(man);
                }
            } catch (NumberFormatException e) {
                // No es un número entero válido
                JOptionPane.showMessageDialog(this, 
                "Por favor ingrese un número entero válido", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
                txtBuscar.setText(""); // Opcional: limpiar el campo
                txtBuscar.requestFocus(); // Opcional: devolver el foco al campo
                return; // Salir del método
              }
        }if("Fecha".equals(filtro)){
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
            //LLAMAR METODO PARA BUSCAR REGISTROS DE FECHA
            List<Mantenimiento> listaMan = control.buscarMantenimientosPorFecha(fechaInicial, fechaLimite);
    
            if (listaMan == null || listaMan.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "No se encontraron registros entre las fechas seleccionadas",
                    "Información",
                JOptionPane.INFORMATION_MESSAGE);
                cargarTabla();
                return;
            }

            mostrarMantenimientosFiltrados(listaMan);
            
            
            
            
        } if("Kilometros".equals(filtro)) {
            buscarPorKilometros();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        cargarTabla();
        cmbFiltro.setSelectedIndex(0);
        cmbKm.setSelectedIndex(0);
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
            pw.println("id,fecha,kilometros,observaciones,patente");
            
            // Obtener los datos actuales (los que están en la tabla o todos)
            List<Mantenimiento> listaMan = control.traerMans();
            
            // Escribir cada registro
            for (Mantenimiento man : listaMan) {
                pw.println(
                    man.getId_mantenimiento() + "," +
                    formatoFecha.format(man.getFecha()) + "," +
                    man.getKm() + "," +
                    man.getObsv().replace(",", ";") + "," +  // Reemplazar comas para evitar conflictos CSV
                    man.getUnPatente().getCodigoPatente()
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
            
            List<Mantenimiento> mantenimientosImportados = new ArrayList<>();
            // Asegurarnos que usamos el formato correcto para parsear fechas
            SimpleDateFormat formatoFechaImport = new SimpleDateFormat("dd/MM/yyyy");
            
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length >= 5) {
                    try {
                        // Convertir datos a un objeto Mantenimiento
                        Mantenimiento man = new Mantenimiento();
                        
                        // Convertir fecha de String a Date
                        try {
                            Date fecha = formatoFechaImport.parse(datos[1]);
                            man.setFecha(fecha);
                            System.out.println("Fecha en string: " + datos[1]);
                            System.out.println("Fecha parseada: " + fecha);
                        } catch (ParseException e) {
                            System.out.println("Error al parsear la fecha: " + datos[1]);
                            e.printStackTrace();
                            continue;
                        }
                        
                        // Convertir km - SOLUCIÓN PARA MANEJAR DECIMALES
                        try {
                            double kmDouble = Double.parseDouble(datos[2]);
                            int km = (int)kmDouble; // Convierte a entero descartando decimales
                            man.setKm(km);
                            System.out.println("Km parseados correctamente: " + km);
                        } catch (NumberFormatException e) {
                            System.out.println("Error al parsear kilómetros: " + datos[2]);
                            continue;
                        }
                        
                        // Observaciones
                        man.setObsv(datos[3]);
                        
                        // Buscar vehículo por patente
                        String patente = datos[4];
                        // Verificar si la patente existe
                        Patente vehiculo = control.buscarPorPatente(patente);
                        if (vehiculo == null) {
                            System.out.println("No se encontró vehículo con patente: " + patente);
                            continue;
                        }
                        man.setUnPatente(vehiculo);
                        
                        mantenimientosImportados.add(man);
                        System.out.println("Registro procesado correctamente: " + line);
                        
                    } catch (Exception e) {
                        System.out.println("Error procesando línea: " + line);
                        e.printStackTrace();
                    }
                }
            }
            
            System.out.println("Total de registros válidos: " + mantenimientosImportados.size());
            
            // Confirmar importación
            if (!mantenimientosImportados.isEmpty()) {
                int respuesta = JOptionPane.showConfirmDialog(
                    this, 
                    "Se importarán " + mantenimientosImportados.size() + " registros. ¿Desea continuar?",
                    "Confirmar importación",
                    JOptionPane.YES_NO_OPTION);
                    
                if (respuesta == JOptionPane.YES_OPTION) {
                    // Guardar en la base de datos
                    boolean exito = control.guardarMantenimientosImportados(mantenimientosImportados);
                    
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

    
    private void cargarTabla() {
    // Create a table model with data
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Make all cells non-editable
        }
    };
    String titulos[] = {"Id", "Fecha", "Kilómetros", "Observaciones", "Patente"};
    model.setColumnIdentifiers(titulos);
    tablaMan.setModel(model);
    
    //traer los registros desde la bd
    List <Mantenimiento> listaMan = control.traerMans();
    if (listaMan != null && !listaMan.isEmpty()) {
        // Ordenar la lista por fecha en orden descendente (más reciente primero)
        Collections.sort(listaMan, (Mantenimiento m1, Mantenimiento m2) -> m2.getFecha().compareTo(m1.getFecha()) // Orden descendente
        );

        // Agregar los datos ordenados al modelo de la tabla
        for (Mantenimiento man : listaMan) {
            Object[] obj = {
                man.getId_mantenimiento(), 
                formatoFecha.format(man.getFecha()), 
                man.getKm(), 
                man.getObsv(), 
                man.getUnPatente().getCodigoPatente()
            };
            model.addRow(obj);
        }
    }
    tablaMan.setModel(model);
} 
    private void mostrarRegistroUnico(Mantenimiento man) {
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    String titulos[] = {"Id", "Fecha", "Kilómetros", "Observaciones", "Patente"};
    model.setColumnIdentifiers(titulos);
    
    Object[] obj = {
        man.getId_mantenimiento(), 
        formatoFecha.format(man.getFecha()), 
        man.getKm(), 
        man.getObsv(), 
        man.getUnPatente().getCodigoPatente()
    };
    
    model.addRow(obj);
    tablaMan.setModel(model);
}
    
    private void mostrarMantenimientosFiltrados(List<Mantenimiento> listaMan) {
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    String titulos[] = {"Id", "Fecha", "Kilómetros", "Observaciones", "Patente"};
    model.setColumnIdentifiers(titulos);
    
    for (Mantenimiento man : listaMan) {
        Object[] obj = {
            man.getId_mantenimiento(), 
            formatoFecha.format(man.getFecha()), 
            man.getKm(), 
            man.getObsv(), 
            man.getUnPatente().getCodigoPatente()
        };
        model.addRow(obj);
    }
    
    tablaMan.setModel(model);
}
    
    private void buscarPorKilometros() {
    String seleccion = cmbKm.getSelectedItem().toString();
    
    List<Mantenimiento> listaMan;
    
    // Analizar la selección del combo
    if (seleccion.startsWith("<")) {
        // Menor que (ejemplo: <100)
        int km = Integer.parseInt(seleccion.substring(1));
        listaMan = control.buscarMantenimientosPorKmMenor(km);
    } 
    else if (seleccion.startsWith(">")) {
        // Mayor que (ejemplo: >1000)
        int km = Integer.parseInt(seleccion.substring(1));
        listaMan = control.buscarMantenimientosPorKmMayor(km);
    }
    else {
        // Rango (ejemplo: 100-500)
        String[] rango = seleccion.split("-");
        int kmInicial = Integer.parseInt(rango[0]);
        int kmFinal = Integer.parseInt(rango[1]);
        listaMan = control.buscarMantenimientosPorRangoKm(kmInicial, kmFinal);
    }
    
    if (listaMan == null || listaMan.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "No se encontraron registros para el rango de kilómetros seleccionado",
            "Información",
            JOptionPane.INFORMATION_MESSAGE);
        cargarTabla();
        return;
    }

    mostrarMantenimientosFiltrados(listaMan);
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
    private javax.swing.JComboBox<String> cmbKm;
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
    private javax.swing.JTable tablaMan;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
