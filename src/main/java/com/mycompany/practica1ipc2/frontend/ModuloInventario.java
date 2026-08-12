package com.mycompany.practica1ipc2.frontend;

import acceso.InsumoAcceso;
import entidades.Insumo;
import estructuras.ListaDinamica;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import utilidades.Pintor;


public class ModuloInventario extends javax.swing.JInternalFrame {


    public ModuloInventario() {
        initComponents();
        cargarTablaInsumos();
        tablaInsumos.setDefaultRenderer(Object.class, new Pintor());
    }
    
    private void cargarTablaInsumos() {
        DefaultTableModel modelo = (DefaultTableModel) tablaInsumos.getModel();
        
        modelo.setRowCount(0); 
        
        acceso.InsumoAcceso acceso = new acceso.InsumoAcceso();
        ListaDinamica<Insumo> lista = acceso.listarTodos();
        
        dibujarTablaResultados(lista);
        
    }
    
    private void dibujarTablaResultados(ListaDinamica<Insumo> lista) {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tablaInsumos.getModel();
        modelo.setRowCount(0); 
        
        for (int i = 0; i < lista.getTamaño(); i++) {
            entidades.Insumo insumo = lista.obtener(i);
            
            Object[] filaDeDatos = new Object[6]; 
            filaDeDatos[0] = insumo.getCodigoInsumo();
            filaDeDatos[1] = insumo.getNombre();
            filaDeDatos[2] = insumo.getUnidadMedida();
            filaDeDatos[3] = insumo.getCosto();
            filaDeDatos[4] = insumo.getStockActual();
            filaDeDatos[5] = insumo.getStockMinimo();

            modelo.addRow(filaDeDatos);
        }
    }
    
    private void limpiarFormularioInsumos(){
        txtCodigo.setText("");
        txtNombre.setText("");        
        txtMedida.setText("");        
        txtCosto.setText("");
        txtStock.setText("");
        txtStockMinimo.setText("");
        
        txtCodigo.setEnabled(true);
        
        txtCodigo.requestFocus();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        pestañasInsumo = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaInsumos = new javax.swing.JTable();
        btnAbastecer = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBusquedaNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnFiltrar = new javax.swing.JButton();
        comboStock = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtMedida = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtStockMinimo = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        tablaInsumos.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        tablaInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "UM", "Costo", "Stock Actual", "Stock Minimo"
            }
        ));
        jScrollPane2.setViewportView(tablaInsumos);

        btnAbastecer.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnAbastecer.setText("Abastecer");
        btnAbastecer.addActionListener(this::btnAbastecerActionPerformed);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Buscar por nombre :");

        btnBuscar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        btnFiltrar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(this::btnFiltrarActionPerformed);

        comboStock.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        comboStock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mayor", "Menor", "Alerta", " " }));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setText("Filtrar por stock :");

        btnModificar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(this::btnModificarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusquedaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiltrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(btnAbastecer)
                .addGap(39, 39, 39)
                .addComponent(btnModificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusquedaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnBuscar)
                    .addComponent(btnFiltrar)
                    .addComponent(comboStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbastecer)
                    .addComponent(btnModificar))
                .addContainerGap())
        );

        pestañasInsumo.addTab("Almacen", jPanel1);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("Ingresa los siguientes datos para añadir un nuevo insumo a la lista del almacen");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("Codigo :");

        txtCodigo.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setText("Nombre :");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setText("Unidad de medida :");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel7.setText("Cantidad actual en stock :");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel8.setText("Stock minimo :");

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel9.setText("Costo :");

        txtNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        txtMedida.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txtMedida.addActionListener(this::txtMedidaActionPerformed);

        txtCosto.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        txtStock.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        txtStockMinimo.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        btnLimpiar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        btnGuardar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(btnLimpiar)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnGuardar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(77, 77, 77))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGuardar))
                .addGap(82, 82, 82))
        );

        pestañasInsumo.addTab("Registrar nuevo insumo", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pestañasInsumo)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pestañasInsumo)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedidaActionPerformed

    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        try {
        String codigo = txtCodigo.getText().trim();
        String nombre = txtNombre.getText().trim();
        
        String unidad = txtMedida.getText().trim(); 
        
        double costo = Double.parseDouble(txtCosto.getText().trim());
        double stockActual = Double.parseDouble(txtStock.getText().trim());
        double stockMinimo = Double.parseDouble(txtStockMinimo.getText().trim());
        
        Insumo insumoProcesado = new Insumo(codigo, nombre, unidad, costo, stockActual, stockMinimo);
        InsumoAcceso acceso = new InsumoAcceso();
        
        
        if (txtCodigo.isEnabled()) {
            if (acceso.insertar(insumoProcesado)) {
                showMessageDialog(this, "¡Insumo registrado con éxito en el almacén!");
                limpiarFormularioInsumos(); 
                cargarTablaInsumos();       
            } else {
                showMessageDialog(this, "Error al registrar. Verifica que el código del insumo no esté repetido.", "Error SQL", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            if (acceso.actualizar(insumoProcesado)) {
                javax.swing.JOptionPane.showMessageDialog(this, "¡Insumo actualizado correctamente!");
                txtCodigo.setEnabled(true); 
                limpiarFormularioInsumos();
                cargarTablaInsumos();
            } else {
                showMessageDialog(this, "No se pudo actualizar el insumo en la base de datos.", "Error SQL", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
        
    } catch (NumberFormatException e) {
       
        showMessageDialog(this, "Por favor, ingresa únicamente valores numéricos (con o sin decimales) en Costo, Stock Actual y Stock Mínimo.", "Dato Inválido", javax.swing.JOptionPane.WARNING_MESSAGE);
    } catch (Exception ex) {
        
        showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error del Sistema", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    
    private void btnAbastecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbastecerActionPerformed
        
        int filaSeleccionada = tablaInsumos.getSelectedRow();
    
        if (filaSeleccionada == -1) {
           
            showMessageDialog(this, "Por favor, selecciona un insumo de la tabla primero.", "Atención", javax.swing.JOptionPane.WARNING_MESSAGE);
            return; 
        }
    
        
        String codigo = tablaInsumos.getValueAt(filaSeleccionada, 0).toString();
        String nombre = tablaInsumos.getValueAt(filaSeleccionada, 1).toString();
    
   
        String input = showInputDialog(this, "¿Cuántas unidades de [" + nombre + "] deseas ingresar al inventario?", "Abastecer Insumo", javax.swing.JOptionPane.QUESTION_MESSAGE);
            
        if (input != null && !input.trim().isEmpty()) {
            try {
                
                double cantidadComprada = Double.parseDouble(input.trim());
            
                if (cantidadComprada <= 0) {
                    JOptionPane.showMessageDialog(this, "La cantidad a ingresar debe ser mayor a cero.", "Dato Inválido", javax.swing.JOptionPane.WARNING_MESSAGE);
                    return;
                }
            
                InsumoAcceso acceso = new InsumoAcceso();
            
                if (acceso.abastecerInsumo(codigo, cantidadComprada)) {
                    JOptionPane.showMessageDialog(this, "¡Inventario de " + nombre + " actualizado con éxito!");
                
                    cargarTablaInsumos();
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar actualizar el stock en la base de datos.", "Error SQL", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            
            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(this, "Por favor, ingresa una cantidad numérica válida.", "Dato Inválido", javax.swing.JOptionPane.WARNING_MESSAGE);
            }   
        }
    }//GEN-LAST:event_btnAbastecerActionPerformed

    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String textoBuscado = txtBusquedaNombre.getText().trim();
    
        InsumoAcceso acceso = new InsumoAcceso();
        ListaDinamica<Insumo> resultados = acceso.buscarPorNombre(textoBuscado);
    
        dibujarTablaResultados(resultados);
    
        if (resultados.getTamaño() == 0) {
        JOptionPane.showMessageDialog(this, "No se encontró ningún insumo con ese nombre.", "Búsqueda sin resultados", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    
    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        
        String criterioSeleccionado = comboStock.getSelectedItem().toString();
    
        InsumoAcceso acceso = new InsumoAcceso();
        ListaDinamica<Insumo> resultadosOrdenados = acceso.filtrarPorStock(criterioSeleccionado);
    
        dibujarTablaResultados(resultadosOrdenados);
    }//GEN-LAST:event_btnFiltrarActionPerformed

    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        int fila = tablaInsumos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un insumo de la tabla para modificar.", "Atención", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        String codigo = tablaInsumos.getValueAt(fila, 0).toString();
        String nombre = tablaInsumos.getValueAt(fila, 1).toString();
        String unidad = tablaInsumos.getValueAt(fila, 2).toString();
        String costo = tablaInsumos.getValueAt(fila, 3).toString();
        String stockActual = tablaInsumos.getValueAt(fila, 4).toString();
        String stockMinimo = tablaInsumos.getValueAt(fila, 5).toString();
    
        txtCodigo.setText(codigo);
        txtNombre.setText(nombre);
        txtMedida.setText(unidad);
        txtCosto.setText(costo);
        txtStock.setText(stockActual);
        txtStockMinimo.setText(stockMinimo);
    
        txtCodigo.setEnabled(false);
    
        pestañasInsumo.setSelectedIndex(1);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarFormularioInsumos();
    }//GEN-LAST:event_btnLimpiarActionPerformed


    
    
    
    
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbastecer;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> comboStock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane pestañasInsumo;
    private javax.swing.JTable tablaInsumos;
    private javax.swing.JTextField txtBusquedaNombre;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtMedida;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtStockMinimo;
    // End of variables declaration//GEN-END:variables
}
