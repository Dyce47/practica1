
package com.mycompany.practica1ipc2.frontend;

import acceso.CuentaAcceso;
import acceso.ProductoAcceso;
import entidades.Producto;
import estructuras.ListaDinamica;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModuloCuentas extends javax.swing.JInternalFrame {

    public ModuloCuentas() {
        initComponents();
        jTabbedPane1.setEnabledAt(1, false); 
        jTabbedPane1.setEnabledAt(2, false);
        
        cargarTablaCuentas();
    }
    
    
    private void cargarTablaCuentas() {
        DefaultTableModel modelo = (DefaultTableModel) tablaCuentasActivas.getModel();
        modelo.setRowCount(0);
        
        CuentaAcceso accesoCuenta = new CuentaAcceso();
        ListaDinamica<Object[]> lista = accesoCuenta.listarCuentasAbiertasVisual();
        
        for (int i = 0; i < lista.getTamaño(); i++) {
            modelo.addRow(lista.obtener(i));
        }
    }


    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCuentasActivas = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnAñadirProducto = new javax.swing.JButton();
        btnRealizarPago = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCuenta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblNumeroMesa = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPropina = new javax.swing.JTextField();
        btnPagar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblNumeroCuenta = new javax.swing.JLabel();
        lblNombreMesero = new javax.swing.JLabel();
        lblDPIMesero = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCuentaActual = new javax.swing.JTable();
        lblNoCuenta = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblNoMesa = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblMesero = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaBusqueda = new javax.swing.JTable();
        btnAñadir = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        tablaCuentasActivas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No. Mesa", "Mesero", "DPI", "No. Cuenta", "Total"
            }
        ));
        jScrollPane1.setViewportView(tablaCuentasActivas);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnAñadirProducto.setText("Añadir Producto");
        btnAñadirProducto.addActionListener(this::btnAñadirProductoActionPerformed);

        btnRealizarPago.setText("Realizar Pago");
        btnRealizarPago.addActionListener(this::btnRealizarPagoActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 178, Short.MAX_VALUE)
                .addComponent(btnAñadirProducto)
                .addGap(89, 89, 89)
                .addComponent(btnRealizarPago)
                .addGap(146, 146, 146))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRealizarPago)
                    .addComponent(btnAñadirProducto)))
        );

        jTabbedPane1.addTab("Cuentas activas", jPanel1);

        tablaCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Cantidad", "Precio", "Subtotal"
            }
        ));
        jScrollPane2.setViewportView(tablaCuenta);

        jLabel1.setText("Mesa numero :");

        lblNumeroMesa.setText("12");

        jLabel3.setText("Mesero a cargo :");

        jLabel4.setText("Total Cuenta :");

        lblTotal.setText("1500");

        jLabel6.setText("Agregar Propina :");

        txtPropina.setText("10");
        txtPropina.addActionListener(this::txtPropinaActionPerformed);

        btnPagar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(this::btnPagarActionPerformed);

        jLabel7.setText("Numero de cuenta :");

        lblNumeroCuenta.setText("A2");

        lblNombreMesero.setText("Juan Perez");

        lblDPIMesero.setText("1234567891234");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPropina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lblNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDPIMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPagar)
                .addGap(270, 270, 270))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroMesa)
                    .addComponent(lblNumeroCuenta)
                    .addComponent(lblNombreMesero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDPIMesero)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtPropina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lblTotal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnPagar)
                .addGap(62, 62, 62))
        );

        jTabbedPane1.addTab("Pago de cuenta", jPanel2);

        jLabel11.setText("No. Cuenta :");

        tablaCuentaActual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Cantidad", "Precio", "Subtotal"
            }
        ));
        jScrollPane3.setViewportView(tablaCuentaActual);

        lblNoCuenta.setText("123456");

        jLabel13.setText("No. Mesa :");

        lblNoMesa.setText("15");

        jLabel15.setText("Mesero :");

        lblMesero.setText("Guillermo Emanuel Montejo Martinez");

        jLabel17.setText("Busca y añade productos a la cuenta seleccionada");

        tablaBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Categoria", "Precio"
            }
        ));
        jScrollPane5.setViewportView(tablaBusqueda);

        btnAñadir.setText("Añadir");
        btnAñadir.addActionListener(this::btnAñadirActionPerformed);

        jLabel18.setText("Buscar producto por nombre :");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane5)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarProducto)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(42, 42, 42))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNoCuenta)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNoMesa)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(btnAñadir)))
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(157, 157, 157))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(38, 38, 38)
                        .addComponent(btnGuardar)
                        .addGap(223, 223, 223))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblNoCuenta)
                    .addComponent(jLabel13)
                    .addComponent(lblNoMesa)
                    .addComponent(jLabel15)
                    .addComponent(lblMesero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAñadir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)))
        );

        jTabbedPane1.addTab("Añadir producto", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void txtPropinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPropinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPropinaActionPerformed

    
    
    
    
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarTablaCuentas();
    }//GEN-LAST:event_btnActualizarActionPerformed

    
    private void btnRealizarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPagoActionPerformed

        int filaSeleccionada = tablaCuentasActivas.getSelectedRow(); 
    
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecciona una cuenta de la lista para pagarla.", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
   
        String noMesa = tablaCuentasActivas.getValueAt(filaSeleccionada, 0).toString();
        String nombreMesero = tablaCuentasActivas.getValueAt(filaSeleccionada, 1).toString();
        String dpiMesero = tablaCuentasActivas.getValueAt(filaSeleccionada, 2).toString();
        String noCuenta = tablaCuentasActivas.getValueAt(filaSeleccionada, 3).toString();
        String total = tablaCuentasActivas.getValueAt(filaSeleccionada, 4).toString();
    
        lblNumeroMesa.setText(noMesa);
        lblNumeroCuenta.setText(noCuenta);
        lblNombreMesero.setText(nombreMesero);
        lblDPIMesero.setText(dpiMesero);
        lblTotal.setText(total);
    
        DefaultTableModel modeloDetalle = (DefaultTableModel) tablaCuenta.getModel(); 
        modeloDetalle.setRowCount(0);
    
        CuentaAcceso accesoCuenta = new CuentaAcceso();
        ListaDinamica<Object[]> detalles = accesoCuenta.obtenerDetallesCuenta(Integer.parseInt(noCuenta));
    
        for (int i = 0; i < detalles.getTamaño(); i++) {
            modeloDetalle.addRow(detalles.obtener(i));
        }
    
        jTabbedPane1.setEnabledAt(0, false); 
        jTabbedPane1.setEnabledAt(1, true); 
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnRealizarPagoActionPerformed

    
    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed

        String propinaStr = txtPropina.getText().trim();
        double propina = 0.0;
    
        if (!propinaStr.isEmpty()) {
            try {
                propina = Double.parseDouble(propinaStr);
                if (propina < 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "La propina no puede ser un valor negativo.", "Valor Inválido", javax.swing.JOptionPane.WARNING_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingresa un valor numérico válido para la propina.", "Error de Formato", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    
        int idCuenta = Integer.parseInt(lblNumeroCuenta.getText().trim());
        int numeroMesa = Integer.parseInt(lblNumeroMesa.getText().trim());    
        double totalOriginal = Double.parseDouble(lblTotal.getText().trim());
       
        double totalFinal = totalOriginal + propina;
    
        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this, "Monto de Consumo: Q" + totalOriginal + "\nPropina: Q" + propina + "\n\nTOTAL A COBRAR: Q" + totalFinal + "\n\n¿Confirmar pago y liberar la mesa?", "Confirmar Cobro", javax.swing.JOptionPane.YES_NO_OPTION,  javax.swing.JOptionPane.QUESTION_MESSAGE);
            
        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
        
            CuentaAcceso acceso = new acceso.CuentaAcceso();
            boolean exito = acceso.pagarCuentaTransaccional(idCuenta, numeroMesa, totalFinal, propina);
        
            if (exito) {
                javax.swing.JOptionPane.showMessageDialog(this, "¡Pago procesado exitosamente! La mesa ha quedado libre.", "Operación Exitosa", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                txtPropina.setText("");                
                cargarTablaCuentas(); 
                jTabbedPane1.setEnabledAt(1, false);
                jTabbedPane1.setEnabledAt(0, true);
                jTabbedPane1.setSelectedIndex(0);
            
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error en el servidor al intentar procesar el pago.", "Error Crítico", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    
    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        int filaSeleccionada = tablaBusqueda.getSelectedRow(); 
    
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un producto de la tabla de búsqueda.", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        String codigo = tablaBusqueda.getValueAt(filaSeleccionada, 0).toString();
        String nombre = tablaBusqueda.getValueAt(filaSeleccionada, 1).toString();
        double precioUnitario = Double.parseDouble(tablaBusqueda.getValueAt(filaSeleccionada, 3).toString());

        String input = javax.swing.JOptionPane.showInputDialog(this, "¿Cuántas unidades extra de '" + nombre + "'?", "Cantidad", javax.swing.JOptionPane.QUESTION_MESSAGE);
        if (input == null || input.trim().isEmpty()){
            return;
        }

        try {
            int cantidadNueva = Integer.parseInt(input.trim());
            if (cantidadNueva <= 0) return;

            javax.swing.table.DefaultTableModel modeloCarrito = (javax.swing.table.DefaultTableModel) tablaCuentaActual.getModel();
        
            int cantidadTotalDeseada = cantidadNueva;
            int filaExistente = -1; 
        
            for (int i = 0; i < modeloCarrito.getRowCount(); i++) {
                Object valorCelda = modeloCarrito.getValueAt(i, 0);
                if (valorCelda != null && valorCelda.toString().equals(codigo)) {
                    int cantidadAnterior = Integer.parseInt(modeloCarrito.getValueAt(i, 2).toString());
                    cantidadTotalDeseada = cantidadAnterior + cantidadNueva;
                    filaExistente = i;
                    break; 
                }
            }

            ProductoAcceso accesoProd = new ProductoAcceso(); 
            String errorStock = accesoProd.verificarStockParaProducto(codigo, cantidadTotalDeseada);
        
            if (errorStock != null) {
                javax.swing.JOptionPane.showMessageDialog(this, errorStock, "Inventario Insuficiente", javax.swing.JOptionPane.ERROR_MESSAGE);
                return; 
            }

            if (filaExistente != -1) {
                double nuevoSubtotal = cantidadTotalDeseada * precioUnitario;
                modeloCarrito.setValueAt(cantidadTotalDeseada, filaExistente, 2);
                modeloCarrito.setValueAt(nuevoSubtotal, filaExistente, 4);
            } else {
                double subtotal = cantidadNueva * precioUnitario;
                modeloCarrito.addRow(new Object[]{codigo, nombre, cantidadNueva, precioUnitario, subtotal});
            }
        
            tablaBusqueda.clearSelection();

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingresa un número entero.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAñadirActionPerformed

    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String nombreBusqueda = txtBuscarProducto.getText().trim();
    
        DefaultTableModel modelo = (DefaultTableModel) tablaBusqueda.getModel();
        modelo.setRowCount(0); 
    
        ProductoAcceso accesoProd = new ProductoAcceso();
        ListaDinamica<Producto> lista;
    
        if (nombreBusqueda.isEmpty()) {
            lista = accesoProd.listarTodos();
        } else {
            lista = accesoProd.buscarPorNombre(nombreBusqueda);
        }
    
        for (int i = 0; i < lista.getTamaño(); i++) {
            entidades.Producto p = lista.obtener(i);
            modelo.addRow(new Object[]{p.getCodigoProducto(), p.getNombre(), p.getCategoria().name(), p.getPrecioVenta()});
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    
    private void btnAñadirProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirProductoActionPerformed
        int filaSeleccionada = tablaCuentasActivas.getSelectedRow(); 
    
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecciona una cuenta de la lista para añadirle productos.", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        String noMesa = tablaCuentasActivas.getValueAt(filaSeleccionada, 0).toString();
        String mesero = tablaCuentasActivas.getValueAt(filaSeleccionada, 1).toString();
        String noCuenta = tablaCuentasActivas.getValueAt(filaSeleccionada, 3).toString();
    
        lblNoCuenta.setText(noCuenta);
        lblNoMesa.setText(noMesa);
        lblMesero.setText(mesero);
    
        ((javax.swing.table.DefaultTableModel) tablaCuentaActual.getModel()).setRowCount(0);
        ((javax.swing.table.DefaultTableModel) tablaBusqueda.getModel()).setRowCount(0);
        txtBuscarProducto.setText("");
    
        jTabbedPane1.setEnabledAt(0, false); 
        jTabbedPane1.setEnabledAt(2, true);  
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnAñadirProductoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        DefaultTableModel modeloExtra = (DefaultTableModel) tablaCuentaActual.getModel();    
        if (modeloExtra.getRowCount() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "La lista está vacía. Añade al menos un producto antes de guardar.", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idCuenta = Integer.parseInt(lblNoCuenta.getText().trim());
    
        double totalExtra = 0.0;
        ListaDinamica<Object[]> productosExtra = new ListaDinamica<>();

        for (int i = 0; i < modeloExtra.getRowCount(); i++) {
            String codProducto = modeloExtra.getValueAt(i, 0).toString();
            int cantidad = Integer.parseInt(modeloExtra.getValueAt(i, 2).toString());
            double subtotal = Double.parseDouble(modeloExtra.getValueAt(i, 4).toString());
        
            totalExtra += subtotal;
        
            productosExtra.agregar(new Object[]{codProducto, cantidad, subtotal});
        }

        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Estás seguro de agregar estos productos a la cuenta?\n\nSe sumarán Q" + totalExtra + " al total a pagar.", "Confirmar productos extra", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE);
            
        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
        
            CuentaAcceso acceso = new CuentaAcceso();
            boolean exito = acceso.agregarProductosExtraTransaccional(idCuenta, totalExtra, productosExtra);
        
            if (exito) {
                javax.swing.JOptionPane.showMessageDialog(this, "¡Productos agregados y stock descontado con éxito!", "Operación Exitosa", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
                 modeloExtra.setRowCount(0);
                ((javax.swing.table.DefaultTableModel) tablaBusqueda.getModel()).setRowCount(0);
                txtBuscarProducto.setText("");
            
                cargarTablaCuentas();             
                jTabbedPane1.setEnabledAt(2, false);
                jTabbedPane1.setEnabledAt(0, true);
                jTabbedPane1.setSelectedIndex(0);
            
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error en la base de datos al guardar los productos.", "Error Crítico", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        ((javax.swing.table.DefaultTableModel) tablaCuentaActual.getModel()).setRowCount(0);
        ((javax.swing.table.DefaultTableModel) tablaBusqueda.getModel()).setRowCount(0);
        txtBuscarProducto.setText("");
    
        jTabbedPane1.setEnabledAt(2, false);
        jTabbedPane1.setEnabledAt(0, true);
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnCancelarActionPerformed


    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnAñadirProducto;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRealizarPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable4;
    private javax.swing.JLabel lblDPIMesero;
    private javax.swing.JLabel lblMesero;
    private javax.swing.JLabel lblNoCuenta;
    private javax.swing.JLabel lblNoMesa;
    private javax.swing.JLabel lblNombreMesero;
    private javax.swing.JLabel lblNumeroCuenta;
    private javax.swing.JLabel lblNumeroMesa;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tablaBusqueda;
    private javax.swing.JTable tablaCuenta;
    private javax.swing.JTable tablaCuentaActual;
    private javax.swing.JTable tablaCuentasActivas;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtPropina;
    // End of variables declaration//GEN-END:variables
}
