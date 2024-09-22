
package com.vendrellignacio.controlflotavehicular.igu;

public class Registros extends javax.swing.JFrame {

    
    public Registros() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAgregarChasis = new javax.swing.JButton();
        btnRegistrarViaje = new javax.swing.JButton();
        btnAgregarAcoplado = new javax.swing.JButton();
        btnNeumatico = new javax.swing.JButton();
        btnTecnica = new javax.swing.JButton();
        btnMulta = new javax.swing.JButton();
        btnImpuesto = new javax.swing.JButton();
        btnSeguro = new javax.swing.JButton();
        btnMantenimiento = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\nacho\\Downloads\\registro.jpg")); // NOI18N
        jButton3.setText("Registrar Técnica");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel1.setText("Cargar Datos");

        btnAgregarChasis.setIcon(new javax.swing.ImageIcon("C:\\Users\\nacho\\Downloads\\chasis.jpg")); // NOI18N
        btnAgregarChasis.setText("Agregar Chasis");
        btnAgregarChasis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarChasisActionPerformed(evt);
            }
        });

        btnRegistrarViaje.setIcon(new javax.swing.ImageIcon("C:\\Users\\nacho\\Downloads\\camion-viajando.jpg")); // NOI18N
        btnRegistrarViaje.setText("Registrar Viaje");
        btnRegistrarViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarViajeActionPerformed(evt);
            }
        });

        btnAgregarAcoplado.setIcon(new javax.swing.ImageIcon("C:\\Users\\nacho\\Downloads\\acoplado.png")); // NOI18N
        btnAgregarAcoplado.setText("Agregar Acoplado");
        btnAgregarAcoplado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAcopladoActionPerformed(evt);
            }
        });

        btnNeumatico.setIcon(new javax.swing.ImageIcon("C:\\Users\\nacho\\Downloads\\neumatico.png")); // NOI18N
        btnNeumatico.setText("Agregar Neumatico");
        btnNeumatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNeumaticoActionPerformed(evt);
            }
        });

        btnTecnica.setIcon(new javax.swing.ImageIcon("C:\\Users\\nacho\\Downloads\\registro.jpg")); // NOI18N
        btnTecnica.setText("Registrar Técnica");
        btnTecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTecnicaActionPerformed(evt);
            }
        });

        btnMulta.setIcon(new javax.swing.ImageIcon("C:\\Users\\nacho\\Downloads\\multa.png")); // NOI18N
        btnMulta.setText("Registrar Multa");
        btnMulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultaActionPerformed(evt);
            }
        });

        btnImpuesto.setIcon(new javax.swing.ImageIcon("C:\\Users\\nacho\\Pictures\\Screenshots\\Captura de pantalla 2024-06-28 221135.png")); // NOI18N
        btnImpuesto.setText("Registrar Impuesto");
        btnImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpuestoActionPerformed(evt);
            }
        });

        btnSeguro.setIcon(new javax.swing.ImageIcon("C:\\Users\\nacho\\Downloads\\impuesto.png")); // NOI18N
        btnSeguro.setText("Añadir Seguro");
        btnSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeguroActionPerformed(evt);
            }
        });

        btnMantenimiento.setIcon(new javax.swing.ImageIcon("C:\\Users\\nacho\\Downloads\\mantenimiento-logo.png")); // NOI18N
        btnMantenimiento.setText("Mantenimiento");
        btnMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenimientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTecnica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarChasis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarAcoplado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImpuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSeguro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNeumatico, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(btnRegistrarViaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarChasis, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarViaje, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarAcoplado, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNeumatico, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTecnica, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
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

    private void btnAgregarChasisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarChasisActionPerformed
         //Correspondiente a la pantalla principal, es decir, "Principal.java": 
        Chasis menu = new Chasis();
        //Lo hacemos visible:
        menu.setVisible(true);
        //Lo centramos
        menu.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAgregarChasisActionPerformed

    private void btnNeumaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNeumaticoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNeumaticoActionPerformed

    private void btnTecnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTecnicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTecnicaActionPerformed

    private void btnMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMultaActionPerformed

    private void btnRegistrarViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarViajeActionPerformed
        Viaje menu = new Viaje();
        //Lo hacemos visible:
        menu.setVisible(true);
        //Lo centramos
        menu.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegistrarViajeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImpuestoActionPerformed

    private void btnSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeguroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeguroActionPerformed

    private void btnMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMantenimientoActionPerformed

    private void btnAgregarAcopladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAcopladoActionPerformed
        MenuAcoplado menu = new MenuAcoplado();
        //Lo hacemos visible:
        menu.setVisible(true);
        //Lo centramos
        menu.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAgregarAcopladoActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAcoplado;
    private javax.swing.JButton btnAgregarChasis;
    private javax.swing.JButton btnImpuesto;
    private javax.swing.JButton btnMantenimiento;
    private javax.swing.JButton btnMulta;
    private javax.swing.JButton btnNeumatico;
    private javax.swing.JButton btnRegistrarViaje;
    private javax.swing.JButton btnSeguro;
    private javax.swing.JButton btnTecnica;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}