
package com.vendrellignacio.controlflotavehicular.igu;



import com.vendrellignacio.controlflotavehicular.logic.Controladora;
import com.vendrellignacio.controlflotavehicular.logic.Viaje;
//import java.awt.BorderLayout;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
//import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


public class MenuViaje extends javax.swing.JFrame {

    Controladora control;
    /*Usuario usr;
    public MenuAcoplado(Controladora control, Usuario usr) {
        initComponents();
        this.control = control;
        this.usr = usr;
    }*/
    SimpleDateFormat formatoFecha;
    public MenuViaje() {
        initComponents();
        control = new Controladora();
        formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVia = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("Viajes");

        btnCrear.setText("Registrar Viaje");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar Viaje");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar Viaje");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(440, 440, 440)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //this.txtNombreUser.setText(usr.getNombre());
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose(); 
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
         cargarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        AltaViaje altaVia = new AltaViaje(control);
        altaVia.setVisible(true);
        altaVia.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        //verifico si hay registros
        if (tablaVia.getRowCount()>0){
            //verifico si se seleccionó una celda
            if (tablaVia.getSelectedRow()!=-1){
                /*//obtengo el valor de una columna q fue seleccionada*/
                int idVia = Integer.parseInt(String.valueOf(tablaVia.getValueAt(tablaVia.getSelectedRow(),0)));
                
                //llamo al metodo borrar de controladora
                control.borrarVia(idVia);
                //muestro msj usando el metodo creado
                mostrarMensaje("Se borro correctamente","info","Eliminado con exito");
                cargarTabla();
            }else{
                //al haber apretado el boton eliminar sin seleccionar nada, le avisaremos q no ha seleccionado nada
                mostrarMensaje("No ha selecciono ninguna celda","error","Error al Eliminar");
            }
        }else{
            mostrarMensaje("No hay ningun resgistro todavia","error","Error al Eliminar");
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tablaVia.getRowCount()>0){
            //verifico si se seleccionó una celda
            if (tablaVia.getSelectedRow()!=-1){
                /*//obtengo el valor de una columna q fue seleccionada*/
                int idVia = Integer.parseInt(String.valueOf(tablaVia.getValueAt(tablaVia.getSelectedRow(),0)));
                //MOSTRAMOS la pantala para modificar
                ModificarVia pantallaModificar = new ModificarVia (idVia,control); 
                pantallaModificar.setVisible(true); 
                pantallaModificar.setLocationRelativeTo(null);
                
        }else{
                //al haber apretado el boton eliminar sin seleccionar nada, le avisaremos q no ha seleccionado nada
                mostrarMensaje("No ha selecciono ninguna celda","error","Error al Editar");
            }
        }else{
            mostrarMensaje("No hay ningun resgistro todavia","error","Error al Editar");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaVia;
    // End of variables declaration//GEN-END:variables

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
        List <Viaje> listaVia = control.traerViajes();
        if (listaVia != null){
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
                    via.getUnGasto().getComida()};
                
                model.addRow(obj);
            }
        }
        tablaVia.setModel(model);
        ///////////////////////////////////////////////
        /*JFrame frame = new JFrame("Tabla con Scroll y Ajuste de Columnas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());*/
         // Ajustar automáticamente el ancho de las columnas
        ajustarAnchoColumnas(tablaVia);

        // Agregar la tabla a un JScrollPane para las barras de scroll
        //JScrollPane scrollPane = new JScrollPane(tablaVia);
        //MenuViaje.add(scrollPane, BorderLayout.CENTER);

        // Configuración final del frame
        /*tablaVia.setSize(400, 200);
        tablaVia.setVisible(true);*/
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

    private void ajustarAnchoColumnas(JTable tablaVia) {
         TableColumnModel columnModel = tablaVia.getColumnModel();
        
        for (int col = 0; col < tablaVia.getColumnCount(); col++) {
            int anchoMaximo = 0;
            // Iterar sobre todas las filas para encontrar la celda más ancha
            for (int fila = 0; fila < tablaVia.getRowCount(); fila++) {
                TableCellRenderer renderer = tablaVia.getCellRenderer(fila, col);
                Component comp = tablaVia.prepareRenderer(renderer, fila, col);
                anchoMaximo = Math.max(comp.getPreferredSize().width + 10, anchoMaximo);
            }

            // Ajustar el ancho de la columna
            columnModel.getColumn(col).setPreferredWidth(anchoMaximo);
        
    }
    }
}
