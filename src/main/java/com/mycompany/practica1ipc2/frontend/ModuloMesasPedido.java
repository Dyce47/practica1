package com.mycompany.practica1ipc2.frontend;

import acceso.CuentaAcceso;
import acceso.EmpleadoAcceso;
import acceso.MesaAcceso;
import acceso.ProductoAcceso;
import entidades.Empleado;
import entidades.Mesa;
import entidades.Producto;
import estructuras.ListaDinamica;
import javax.swing.table.DefaultTableModel;
import utilidades.PintorMesas;


public class ModuloMesasPedido extends javax.swing.JInternalFrame {

    public ModuloMesasPedido() {
        initComponents();
        cargarTablaMesas();
        jTabbedPane1.setEnabledAt(1, false);
        cargarComboMeseros();
    }

    
    private void cargarTablaMesas() {
        
        DefaultTableModel modelo = (DefaultTableModel) tablaMesas.getModel();      
        modelo.setRowCount(0); 
        
 
        MesaAcceso accesoMesa = new MesaAcceso();
        ListaDinamica<Mesa> lista = accesoMesa.listarTodos();
        

        for (int i = 0; i < lista.getTamaño(); i++) {
            entidades.Mesa m = lista.obtener(i);
            
            modelo.addRow(new Object[]{m.getNumeroMesa(), m.getCapacidad(), m.getEstado().name()});
        }
        

        PintorMesas pintor = new PintorMesas();
        for (int i = 0; i < tablaMesas.getColumnCount(); i++) {
            tablaMesas.getColumnModel().getColumn(i).setCellRenderer(pintor);
        }
    }
    
    
    private void cargarComboMeseros() {
        comboMeseros.removeAllItems(); 
        comboMeseros.addItem("Seleccione un mesero..."); 
        
        EmpleadoAcceso accesoEmp = new EmpleadoAcceso();
        ListaDinamica<Empleado> lista = accesoEmp.listarMeserosActivos();
        
        for (int i = 0; i < lista.getTamaño(); i++) {
            Empleado emp = lista.obtener(i);
            String item = emp.getDpi() + " - " + emp.getNombreCompleto();
            comboMeseros.addItem(item);
        }
    }
    
    
    private void buscarProductosParaPedido(String nombreBusqueda) {
        DefaultTableModel modelo = (DefaultTableModel) tablaProductos.getModel();
        modelo.setRowCount(0); 
        
        ProductoAcceso accesoProd = new ProductoAcceso();
        ListaDinamica<Producto> lista;
        
        if (nombreBusqueda.trim().isEmpty()) {
            lista = accesoProd.listarTodos();
        } else {
            lista = accesoProd.buscarPorNombre(nombreBusqueda.trim());
        }
        
        for (int i = 0; i < lista.getTamaño(); i++) {
            entidades.Producto p = lista.obtener(i);
            
            modelo.addRow(new Object[]{p.getCodigoProducto(), p.getNombre(), p.getCategoria().name(), p.getPrecioVenta()});
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMesas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNumeroMesa = new javax.swing.JTextField();
        spinerCapacidad = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnTomarPedido = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        txtBuscarProducto = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnAgregarProducto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCuenta = new javax.swing.JTable();
        btnEliminarProductos = new javax.swing.JButton();
        btnLevantarCuenta = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblMesaSeleccionada = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboMeseros = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();

        tablaMesas.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        tablaMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Numero de Mesa", "Capacidad ", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tablaMesas);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setText("Añadir nueva mesa|");

        txtNumeroMesa.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txtNumeroMesa.setText("NNN");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel2.setText("Capacidad :");

        btnGuardar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnActualizar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnTomarPedido.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnTomarPedido.setText("Tomar Pedido");
        btnTomarPedido.addActionListener(this::btnTomarPedidoActionPerformed);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel3.setText("Numero de mesa :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActualizar)
                .addGap(131, 131, 131)
                .addComponent(btnTomarPedido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinerCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinerCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnGuardar)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnTomarPedido))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Gestion de mesas ", jPanel1);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("Busca y seleeciona los productos para añadir a la cuenta");

        tablaProductos.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaProductos);

        txtBuscarProducto.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        btnAgregarProducto.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnAgregarProducto.setText("Añadir a la cuenta");
        btnAgregarProducto.addActionListener(this::btnAgregarProductoActionPerformed);

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setText("Productos añadidos a la cuenta");

        tablaCuenta.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        tablaCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Cantidad", "Precio", "Subtotal"
            }
        ));
        jScrollPane3.setViewportView(tablaCuenta);

        btnEliminarProductos.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnEliminarProductos.setText("Eliminar producto");
        btnEliminarProductos.addActionListener(this::btnEliminarProductosActionPerformed);

        btnLevantarCuenta.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnLevantarCuenta.setText("Levantar Cuenta");
        btnLevantarCuenta.addActionListener(this::btnLevantarCuentaActionPerformed);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setText("Buscar producto por nombre :");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel7.setText("Numero de mesa :");

        lblMesaSeleccionada.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lblMesaSeleccionada.setText("Mesa 3 (4 personas)");

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel9.setText("Mesero :");

        comboMeseros.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        comboMeseros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCancelar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar ");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMesaSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboMeseros, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(42, 42, 42))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(131, 131, 131)
                .addComponent(btnLevantarCuenta)
                .addGap(93, 93, 93))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(btnAgregarProducto))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(btnEliminarProductos)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboMeseros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMesaSeleccionada))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnBuscar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarProducto)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarProductos)
                        .addGap(26, 82, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLevantarCuenta)
                            .addComponent(btnCancelar))
                        .addGap(14, 14, 14))))
        );

        jTabbedPane1.addTab("Ordenar pedido", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            String numMesa = txtNumeroMesa.getText().trim(); 
        
            if (numMesa.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingresa el número de mesa.", "Campo vacío", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }
            int numeroMesa = Integer.parseInt(numMesa);
            int capacidad = (Integer) spinerCapacidad.getValue(); 

            
            if (capacidad <= 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "La capacidad de la mesa debe ser de al menos 1 persona.", "Capacidad inválida", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            Mesa nuevaMesa = new Mesa(numeroMesa, capacidad, entidades.EstadoMesa.LIBRE);

            MesaAcceso accesoMesa = new MesaAcceso();
        
            if (accesoMesa.insertar(nuevaMesa)) {
                javax.swing.JOptionPane.showMessageDialog(this, "¡Mesa número " + numeroMesa + " registrada con éxito en el sistema!", "Registro Exitoso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
                txtNumeroMesa.setText("");
                spinerCapacidad.setValue(0); 

                cargarTablaMesas();
            
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al registrar. Verifica que el número de mesa no se encuentre ya registrado.", "Error SQL", javax.swing.JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "El número de mesa debe ser un valor numérico entero (Ej. 1, 2, 10).", "Error de Formato", javax.swing.JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarTablaMesas();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnTomarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomarPedidoActionPerformed

        int filaSeleccionada = tablaMesas.getSelectedRow();
    
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecciona una mesa de la lista primero.", "Mesa no seleccionada", javax.swing.JOptionPane.WARNING_MESSAGE);
            return; 
        }
    
        String estado = tablaMesas.getValueAt(filaSeleccionada, 2).toString();
    
        if (estado.equals("OCUPADA")) {
            javax.swing.JOptionPane.showMessageDialog(this, "La mesa seleccionada ya se encuentra OCUPADA. Elige una mesa LIBRE para tomar un nuevo pedido.", "Acción Denegada", javax.swing.JOptionPane.ERROR_MESSAGE);
            return; 
        }
    
        String numMesa = tablaMesas.getValueAt(filaSeleccionada, 0).toString();
        String capacidad = tablaMesas.getValueAt(filaSeleccionada, 1).toString();
    
        lblMesaSeleccionada.setText("Mesa " + numMesa + " (" + capacidad + " personas)");
        
        jTabbedPane1.setEnabledAt(1, true);
    
        jTabbedPane1.setEnabledAt(0, false);
    
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnTomarPedidoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String textoBusqueda = txtBuscarProducto.getText();
        buscarProductosParaPedido(textoBusqueda);
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        
        int filaSeleccionada = tablaProductos.getSelectedRow(); 
    
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto de la lista superior primero.", "Producto no seleccionado", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }


        String codigo = tablaProductos.getValueAt(filaSeleccionada, 0).toString();
        String nombre = tablaProductos.getValueAt(filaSeleccionada, 1).toString();
        double precioUnitario = Double.parseDouble(tablaProductos.getValueAt(filaSeleccionada, 3).toString());

        String Cantidad = javax.swing.JOptionPane.showInputDialog(this, "¿Cuántas unidades de '" + nombre + "' deseas ordenar?", "Cantidad", javax.swing.JOptionPane.QUESTION_MESSAGE);

        if (Cantidad == null || Cantidad.trim().isEmpty()) {
            return;
        }

        try {
            int cantidadNueva = Integer.parseInt(Cantidad.trim());
        
            if (cantidadNueva <= 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero.", "Cantidad Inválida", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            DefaultTableModel modeloCarrito = (DefaultTableModel) tablaCuenta.getModel();
            
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
                return; // 
            }

            if (filaExistente != -1) {
             
                double nuevoSubtotal = cantidadTotalDeseada * precioUnitario;
                modeloCarrito.setValueAt(cantidadTotalDeseada, filaExistente, 2);
                modeloCarrito.setValueAt(nuevoSubtotal, filaExistente, 4);
            } else {
                double subtotal = cantidadNueva * precioUnitario;
                modeloCarrito.addRow(new Object[]{codigo, nombre,cantidadNueva, precioUnitario, subtotal});
            }
        
            tablaProductos.clearSelection();
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingresa un número entero válido (Ej. 1, 2, 3).", "Error de Formato", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnEliminarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductosActionPerformed

        int filaSeleccionada = tablaCuenta.getSelectedRow(); 

        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecciona el producto que deseas eliminar de la cuenta.", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            return; 
        }

        String nombreProducto = tablaCuenta.getValueAt(filaSeleccionada, 1).toString();

        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas quitar '" + nombreProducto + "' de la orden?", "Confirmar eliminación", javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
            
            DefaultTableModel modeloCarrito = (DefaultTableModel) tablaCuenta.getModel();
            modeloCarrito.removeRow(filaSeleccionada);
 
            tablaCuenta.clearSelection();
        }
    }//GEN-LAST:event_btnEliminarProductosActionPerformed

    private void btnLevantarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLevantarCuentaActionPerformed

        javax.swing.table.DefaultTableModel modeloCarrito = (javax.swing.table.DefaultTableModel) tablaCuenta.getModel();
    
        if (modeloCarrito.getRowCount() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "La cuenta está vacía. Añade al menos un producto antes de levantar la cuenta.", "Cuenta Vacía", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (comboMeseros.getSelectedIndex() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, asigna un mesero a esta cuenta.", "Mesero no asignado", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        String seleccionMesero = comboMeseros.getSelectedItem().toString();
        String dpiMesero = seleccionMesero.split(" - ")[0].trim();

        int filaMesaSeleccionada = tablaMesas.getSelectedRow();
        int numeroMesa = Integer.parseInt(tablaMesas.getValueAt(filaMesaSeleccionada, 0).toString());

        
        double totalAPagar = 0.0;
        ListaDinamica<Object[]> detallesCarrito = new estructuras.ListaDinamica<>();

        for (int i = 0; i < modeloCarrito.getRowCount(); i++) {
            String codProducto = modeloCarrito.getValueAt(i, 0).toString();
            int cantidad = Integer.parseInt(modeloCarrito.getValueAt(i, 2).toString());
            double subtotal = Double.parseDouble(modeloCarrito.getValueAt(i, 4).toString());
        
            totalAPagar += subtotal;
        
            detallesCarrito.agregar(new Object[]{codProducto, cantidad, subtotal});
        }

        CuentaAcceso accesoCuenta = new CuentaAcceso();
        boolean exito = accesoCuenta.levantarCuentaTransaccional(numeroMesa, dpiMesero, totalAPagar, detallesCarrito);

        if (exito) {
            javax.swing.JOptionPane.showMessageDialog(this, "¡Cuenta levantada con éxito! La mesa ha sido marcada como OCUPADA.", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        
            modeloCarrito.setRowCount(0); 
            comboMeseros.setSelectedIndex(0); 
            txtBuscarProducto.setText(""); 
        
            cargarTablaMesas(); 
        
            jTabbedPane1.setEnabledAt(0, true);  
            jTabbedPane1.setEnabledAt(1, false); 
            jTabbedPane1.setSelectedIndex(0); 

        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al procesar la orden. Ningún cambio fue guardado.", "Error de Transacción", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLevantarCuentaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Estás seguro de cancelar esta orden? Se borrarán los productos que hayas añadido.", "Cancelar Orden", javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
        
            DefaultTableModel modeloCarrito = (DefaultTableModel) tablaCuenta.getModel();
            modeloCarrito.setRowCount(0); 
        
            comboMeseros.setSelectedIndex(0); 
            txtBuscarProducto.setText(""); 
        
            jTabbedPane1.setEnabledAt(0, true); 
            jTabbedPane1.setEnabledAt(1, false); 
            jTabbedPane1.setSelectedIndex(0); 
    }
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarProductos;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLevantarCuenta;
    private javax.swing.JButton btnTomarPedido;
    private javax.swing.JComboBox<String> comboMeseros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblMesaSeleccionada;
    private javax.swing.JSpinner spinerCapacidad;
    private javax.swing.JTable tablaCuenta;
    private javax.swing.JTable tablaMesas;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtNumeroMesa;
    // End of variables declaration//GEN-END:variables
}
