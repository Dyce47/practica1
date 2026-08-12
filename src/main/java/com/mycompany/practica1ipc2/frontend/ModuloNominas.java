package com.mycompany.practica1ipc2.frontend;

import acceso.NominaAcceso;
import entidades.Nomina;
import estructuras.ListaDinamica;
import javax.swing.table.DefaultTableModel;


public class ModuloNominas extends javax.swing.JInternalFrame {


    public ModuloNominas() {
        initComponents();

        NominaAcceso acceso = new NominaAcceso();
        acceso.verificarYGenerarNominasAutomaticas();
        cargarTablaPendientes();
        cargarTablaHistorial(null);
    }
    
    
    private void cargarTablaPendientes() {
        DefaultTableModel modelo = (DefaultTableModel) tablaNominasPendientes.getModel();
        modelo.setRowCount(0); 
        
        NominaAcceso acceso = new NominaAcceso();
        ListaDinamica<Object[]> lista = acceso.listarPendientesVisual();
        
        for (int i = 0; i < lista.getTamaño(); i++) {
            modelo.addRow(lista.obtener(i));
        }
    }

    private void cargarTablaHistorial(String dpiFiltro) {
        DefaultTableModel modelo = (DefaultTableModel) tablaHistorial.getModel();
        modelo.setRowCount(0);
        
        NominaAcceso acceso = new NominaAcceso();
        ListaDinamica<Object[]> lista = acceso.listarHistorialVisual(dpiFiltro);
        
        for (int i = 0; i < lista.getTamaño(); i++) {
            modelo.addRow(lista.obtener(i));
        }
    }


    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaNominasPendientes = new javax.swing.JTable();
        btnPagar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarDPI = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        btnActualizar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        tablaNominasPendientes.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        tablaNominasPendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod. Nomina", "DPI Empleado", "Nombre", "Rol", "Fecha de Emision", "Tipo de Pago", "Monto", "Estado"
            }
        ));
        jScrollPane2.setViewportView(tablaNominasPendientes);

        btnPagar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnPagar.setText("Pagar Nomina");
        btnPagar.addActionListener(this::btnPagarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(btnPagar)
                .addContainerGap(315, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPagar)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Gestion de pagos", jPanel1);

        tablaHistorial.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        tablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod. Nomina", "DPI Empleado", "Nombre", "Rol", "Fecha de Emision", "Tipo de Pago", "Monto", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tablaHistorial);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Buscar por numero de DPI :");

        btnBuscar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarDPI, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnBuscar)
                .addGap(185, 310, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscarDPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Historial de Nominas", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarTablaPendientes();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        int filaSeleccionada = tablaNominasPendientes.getSelectedRow();
    
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecciona una nómina pendiente para procesar el pago.", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        int codNomina = Integer.parseInt(tablaNominasPendientes.getValueAt(filaSeleccionada, 0).toString());
        String dpi = tablaNominasPendientes.getValueAt(filaSeleccionada, 1).toString();
        String monto = tablaNominasPendientes.getValueAt(filaSeleccionada, 6).toString();
    
        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Confirmar la emisión del pago por Q" + monto + " al empleado con DPI: " + dpi + "?", "Pagar Nómina", javax.swing.JOptionPane.YES_NO_OPTION);
            
        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
            NominaAcceso acceso = new NominaAcceso();
            Nomina nominaAPagar = new Nomina();
            nominaAPagar.setCodigoNomina(codNomina); 
        
            if (acceso.actualizar(nominaAPagar)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Pago registrado exitosamente en el sistema.", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                cargarTablaPendientes();
                cargarTablaHistorial(null);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al procesar el pago en la base de datos.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String dpi = txtBuscarDPI.getText().trim();
    
        if (dpi.isEmpty()) {
            cargarTablaHistorial(null);
        } else {
            cargarTablaHistorial(dpi);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed


    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaHistorial;
    private javax.swing.JTable tablaNominasPendientes;
    private javax.swing.JTextField txtBuscarDPI;
    // End of variables declaration//GEN-END:variables
}
