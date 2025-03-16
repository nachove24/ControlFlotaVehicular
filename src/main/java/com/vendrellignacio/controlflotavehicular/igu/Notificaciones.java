
package com.vendrellignacio.controlflotavehicular.igu;

import com.vendrellignacio.controlflotavehicular.logic.Controladora;
import com.vendrellignacio.controlflotavehicular.logic.Multa;
import com.vendrellignacio.controlflotavehicular.logic.Neumatico;
import com.vendrellignacio.controlflotavehicular.logic.Seguro;
import com.vendrellignacio.controlflotavehicular.logic.Tecnica;
import java.awt.Color;
import java.awt.Component;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class Notificaciones extends javax.swing.JFrame {

    Controladora control;
    //Formato para que se vea de forma simple
    SimpleDateFormat formatoFecha;
    public Notificaciones() {
        initComponents();
        control = new Controladora();
        formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTec = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaSeg = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaNeu = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaMulta = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tablaTec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaTec);

        jLabel2.setText("Tecnica");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );

        tablaSeg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tablaSeg);

        jLabel3.setText("Seguro");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

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
        jScrollPane7.setViewportView(tablaNeu);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        tablaMulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tablaMulta);

        jLabel5.setText("Neumatico");

        jLabel4.setText("Multa");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(213, 213, 213))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel1.setText("Notificaciones");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTablaTecnica();
        cargarTablaSeguros();
        cargarTablaMultas();
        cargarTablaNeumaticos();
    }//GEN-LAST:event_formWindowOpened

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarTablaTecnica();
        cargarTablaSeguros();
        cargarTablaMultas();
        cargarTablaNeumaticos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void cargarTablaTecnica() {
    // Crear modelo de tabla no editable
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    // Definir columnas incluyendo los días restantes
    String titulos[] = {"Id", "Vencimiento VTV", "Año", "Patente", "Días restantes", "Estado"};
    model.setColumnIdentifiers(titulos);
    tablaTec.setModel(model);
    
    // Obtener fecha actual
    Date fechaActual = new Date();
    //Formato para que se vea de forma simple
    //SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    // Período de alerta (15 días)
    final long MILLIS_POR_DIA = 24 * 60 * 60 * 1000;
    
    // Traer los registros desde la BD
    List<Tecnica> listaTec = control.traerTecs();
    if (listaTec != null) {
        for (Tecnica tec : listaTec) {
            // Calcular días restantes
            long diferenciaMilis = tec.getVencVTV().getTime() - fechaActual.getTime();
            int diasRestantes = (int) (diferenciaMilis / MILLIS_POR_DIA);
            
            // Determinar el estado
            String estado;
            if (diasRestantes < 0) {
                estado = "VENCIDO";
            } else if (diasRestantes <= 15) {
                estado = "PRÓXIMO A VENCER";
            } else {
                // Si no está por vencer ni vencido, continuar con el siguiente registro
                continue;
            }
            
            // Agregar solo los registros relevantes (vencidos o próximos a vencer)
            Object[] obj = {
                tec.getId_tecnica(),
                formatoFecha.format(tec.getVencVTV()),
                tec.getAno(),
                tec.getUnPatente().getCodigoPatente(),
                diasRestantes < 0 ? "VENCIDO" : diasRestantes,
                estado
            };
            
            model.addRow(obj);
        }
    }
    
    // Aplicar renderizador personalizado para colorear las filas según su estado
    tablaTec.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            String estado = (String) table.getModel().getValueAt(row, 5);
            if (null == estado) {
                c.setBackground(table.getBackground());
                c.setForeground(table.getForeground());
            } else switch (estado) {
                case "VENCIDO" -> {
                    c.setBackground(Color.RED);
                    c.setForeground(Color.WHITE);
                }
                case "PRÓXIMO A VENCER" -> {
                    c.setBackground(Color.YELLOW);
                    c.setForeground(Color.BLACK);
                }
                default -> {
                    c.setBackground(table.getBackground());
                    c.setForeground(table.getForeground());
                }
            }
            
            return c;
        }
    });
}
    private void cargarTablaSeguros() {
    // Crear modelo de tabla no editable
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    // Definir columnas incluyendo solamente los campos solicitados
    String titulos[] = {"Id", "Fecha Inicio", "Fecha Vencimiento", "Días restantes", "Alerta"};
    model.setColumnIdentifiers(titulos);
    tablaSeg.setModel(model);
    
    // Obtener fecha actual
    Date fechaActual = new Date();
    // Período de alerta (15 días)
    final long MILLIS_POR_DIA = 24 * 60 * 60 * 1000;
    
    // Traer los registros desde la BD
    List<Seguro> listaSeguros = control.traerSegs();
    if (listaSeguros != null) {
        for (Seguro seguro : listaSeguros) {
            // Calcular días restantes
            long diferenciaMilis = seguro.getFechaVenc().getTime() - fechaActual.getTime();
            int diasRestantes = (int) (diferenciaMilis / MILLIS_POR_DIA);
            
            // Determinar el estado de alerta
            String alerta;
            if (diasRestantes < 0) {
                alerta = "VENCIDO";
            } else if (diasRestantes <= 15) {
                alerta = "PRÓXIMO A VENCER";
            } else {
                // Si no está por vencer ni vencido, continuar con el siguiente registro
                continue;
            }
            
            // Agregar solo los registros relevantes (vencidos o próximos a vencer)
            Object[] obj = {
                seguro.getId_seguro(),
                formatoFecha.format(seguro.getFechaInicio()),
                formatoFecha.format(seguro.getFechaVenc()),
                
                diasRestantes < 0 ? "VENCIDO" : diasRestantes,
                alerta
            };
            
            model.addRow(obj);
        }
    }
    
    // Aplicar renderizador personalizado para colorear las filas según su estado
    tablaSeg.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            String alerta = (String) table.getModel().getValueAt(row, 4);
            if (null == alerta) {
                c.setBackground(table.getBackground());
                c.setForeground(table.getForeground());
            } else switch (alerta) {
                case "VENCIDO" -> {
                    c.setBackground(Color.RED);
                    c.setForeground(Color.WHITE);
                }
                case "PRÓXIMO A VENCER" -> {
                    c.setBackground(Color.YELLOW);
                    c.setForeground(Color.BLACK);
                }
                default -> {
                    c.setBackground(table.getBackground());
                    c.setForeground(table.getForeground());
                }
            }
            
            return c;
        }
    });
}
    private void cargarTablaMultas() {
    // Crear modelo de tabla no editable
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    // Definir columnas
    String titulos[] = {"Id", "Infracción", "Importe Total", "Importe Pagado", "Importe Pendiente", "Estado"};
    model.setColumnIdentifiers(titulos);
    tablaMulta.setModel(model);
    
    // Traer los registros desde la BD
    List<Multa> listaMultas = control.traerMultas();
    if (listaMultas != null) {
        for (Multa multa : listaMultas) {
            // Calcular importe pendiente
            double importePendiente = multa.getImporte() - multa.getImpPagado();
            
            // Filtrar solo las multas que no fueron totalmente pagadas
            if (importePendiente > 0) {
                Object[] obj = {
                    multa.getId_multa(),
                    multa.getInfraccion(),
                    multa.getImporte(),
                    multa.getImpPagado(),
                    importePendiente,
                    multa.getEstado()
                };
                
                model.addRow(obj);
            }
        }
    }
    
    // Aplicar renderizador personalizado para colorear las filas según el monto pendiente
    tablaMulta.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            // Obtener el importe pendiente de la columna 4
            double importePendiente = (Double) table.getModel().getValueAt(row, 4);
            double importeTotal = (Double) table.getModel().getValueAt(row, 2);
            
            // Calcular el porcentaje pendiente
            double porcentajePendiente = (importePendiente / importeTotal) * 100;
            
            // Establecer colores según el porcentaje pendiente
            if (porcentajePendiente >= 75) {
                c.setBackground(Color.RED);
                c.setForeground(Color.WHITE);
            } else if (porcentajePendiente >= 50) {
                c.setBackground(new Color(255, 165, 0)); // Naranja
                c.setForeground(Color.BLACK);
            } else if (porcentajePendiente >= 25) {
                c.setBackground(Color.YELLOW);
                c.setForeground(Color.BLACK);
            } else {
                c.setBackground(new Color(144, 238, 144)); // Verde claro
                c.setForeground(Color.BLACK);
            }
            
            if (isSelected) {
                c.setBackground(table.getSelectionBackground());
                c.setForeground(table.getSelectionForeground());
            }
            
            return c;
        }
    });
    
    // Configurar formato para mostrar valores monetarios con dos decimales
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    TableColumnModel columnModel = tablaMulta.getColumnModel();
    
    // Aplicar formato de moneda a las columnas de importes (índices 2, 3 y 4)
    for (int i = 2; i <= 4; i++) {
        columnModel.getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
            {
                setHorizontalAlignment(SwingConstants.RIGHT);
            }
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                if (value instanceof Double) {
                    setText(currencyFormat.format((Double) value));
                }
                
                // Mantener el color de fondo según el renderizador principal
                if (!isSelected) {
                    double importePendiente = (Double) table.getModel().getValueAt(row, 4);
                    double importeTotal = (Double) table.getModel().getValueAt(row, 2);
                    double porcentajePendiente = (importePendiente / importeTotal) * 100;
                    
                    if (porcentajePendiente >= 75) {
                        c.setBackground(Color.RED);
                        c.setForeground(Color.WHITE);
                    } else if (porcentajePendiente >= 50) {
                        c.setBackground(new Color(255, 165, 0)); // Naranja
                        c.setForeground(Color.BLACK);
                    } else if (porcentajePendiente >= 25) {
                        c.setBackground(Color.YELLOW);
                        c.setForeground(Color.BLACK);
                    } else {
                        c.setBackground(new Color(144, 238, 144)); // Verde claro
                        c.setForeground(Color.BLACK);
                    }
                }
                
                return c;
            }
        });
    }
}
    private void cargarTablaNeumaticos() {
    // Crear modelo de tabla no editable
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    // Definir columnas
    String titulos[] = {"ID", "Código", "Fecha de Uso", "Kilómetros Totales", "Marca", "Estado"};
    model.setColumnIdentifiers(titulos);
    tablaNeu.setModel(model);
    
    // Obtener fecha actual para calcular días en uso
    Date fechaActual = new Date();
    final long MILLIS_POR_DIA = 24 * 60 * 60 * 1000;
    
    // Traer los registros desde la BD
    List<Neumatico> listaNeumaticos = control.traerNeus();
    if (listaNeumaticos != null) {
        for (Neumatico neumatico : listaNeumaticos) {
            // Filtrar solo los neumáticos en uso
            if ("En Uso".equals(neumatico.getEstado())) {
                // Calcular días en uso
                long diasEnUso = 0;
                if (neumatico.getFechaUso() != null) {
                    long diferenciaMilis = fechaActual.getTime() - neumatico.getFechaUso().getTime();
                    diasEnUso = diferenciaMilis / MILLIS_POR_DIA;
                }
                
                Object[] obj = {
                    neumatico.getId_neumatico(),
                    neumatico.getCod_neumatico(),
                    formatoFecha.format(neumatico.getFechaUso()),
                    neumatico.getKmTotal(),
                    neumatico.getMarca(),
                    diasEnUso + " días en uso"
                };
                
                model.addRow(obj);
            }
        }
    }
    
    // Aplicar renderizador personalizado para colorear las filas según los km recorridos
    tablaNeu.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            // Obtener los kilómetros totales de la columna 3
            Double kmTotal = (Double) table.getModel().getValueAt(row, 3);
            
            // Establecer colores según los kilómetros totales
            // Los umbrales dependen del tipo de neumático y condiciones de uso
            // Aquí se usan valores genéricos que puedes ajustar
            if (kmTotal >= 70000) {
                c.setBackground(Color.RED);
                c.setForeground(Color.WHITE);
            } else if (kmTotal >= 50000) {
                c.setBackground(new Color(255, 165, 0)); // Naranja
                c.setForeground(Color.BLACK);
            } else if (kmTotal >= 30000) {
                c.setBackground(Color.YELLOW);
                c.setForeground(Color.BLACK);
            } else {
                c.setBackground(new Color(144, 238, 144)); // Verde claro
                c.setForeground(Color.BLACK);
            }
            
            if (isSelected) {
                c.setBackground(table.getSelectionBackground());
                c.setForeground(table.getSelectionForeground());
            }
            
            return c;
        }
    });
    
    // Formato para la columna de kilómetros
    NumberFormat numberFormat = NumberFormat.getNumberInstance();
    TableColumnModel columnModel = tablaNeu.getColumnModel();
    
    // Aplicar formato a la columna de kilómetros (índice 3)
    columnModel.getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
        {
            setHorizontalAlignment(SwingConstants.RIGHT);
        }
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            if (value instanceof Double) {
                setText(numberFormat.format((Double) value) + " km");
            }
            
            // Mantener el color de fondo según el renderizador principal
            if (!isSelected) {
                Double kmTotal = (Double) table.getModel().getValueAt(row, 3);
                
                if (kmTotal >= 70000) {
                    c.setBackground(Color.RED);
                    c.setForeground(Color.WHITE);
                } else if (kmTotal >= 50000) {
                    c.setBackground(new Color(255, 165, 0));
                    c.setForeground(Color.BLACK);
                } else if (kmTotal >= 30000) {
                    c.setBackground(Color.YELLOW);
                    c.setForeground(Color.BLACK);
                } else {
                    c.setBackground(new Color(144, 238, 144));
                    c.setForeground(Color.BLACK);
                }
            }
            
            return c;
        }
    });
    
    // Formato para la columna de fecha
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    columnModel.getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
        {
            setHorizontalAlignment(SwingConstants.CENTER);
        }
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            if (value instanceof Date) {
                setText(dateFormat.format((Date) value));
            }
            
            // Mantener el color de fondo según el renderizador principal
            if (!isSelected) {
                Double kmTotal = (Double) table.getModel().getValueAt(row, 3);
                
                if (kmTotal >= 70000) {
                    c.setBackground(Color.RED);
                    c.setForeground(Color.WHITE);
                } else if (kmTotal >= 50000) {
                    c.setBackground(new Color(255, 165, 0));
                    c.setForeground(Color.BLACK);
                } else if (kmTotal >= 30000) {
                    c.setBackground(Color.YELLOW);
                    c.setForeground(Color.BLACK);
                } else {
                    c.setBackground(new Color(144, 238, 144));
                    c.setForeground(Color.BLACK);
                }
            }
            
            return c;
        }
    });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tablaMulta;
    private javax.swing.JTable tablaNeu;
    private javax.swing.JTable tablaSeg;
    private javax.swing.JTable tablaTec;
    // End of variables declaration//GEN-END:variables
}
