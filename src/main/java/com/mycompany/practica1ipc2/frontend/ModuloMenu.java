package com.mycompany.practica1ipc2.frontend;

import acceso.InsumoAcceso;
import acceso.ProductoAcceso;
import entidades.CategoriaProducto;
import entidades.Insumo;
import entidades.Producto;
import entidades.Receta;
import estructuras.ListaDinamica;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class ModuloMenu extends javax.swing.JInternalFrame {

    private String rutaImagenActual = "";

    public ModuloMenu() {
        initComponents();
        dibujarTablaProductos(new ProductoAcceso().listarTodos());
        moduloMenu.setEnabledAt(2, false);
    }
    
    
    private void cargarTablaBusquedaInsumos(String nombreBuscado) {
        
        DefaultTableModel modelo = (DefaultTableModel) tablaBusquedaInsumo.getModel();
        modelo.setRowCount(0); 
        
        InsumoAcceso accesoInsumo = new InsumoAcceso();
        ListaDinamica<Insumo> lista;
        
        if (nombreBuscado.isEmpty()) {
            lista = accesoInsumo.listarTodos();
        } else {
            lista = accesoInsumo.buscarPorNombre(nombreBuscado); 
        }
        
        for (int i = 0; i < lista.getTamaño(); i++) {
            entidades.Insumo insumo = lista.obtener(i);
            
            modelo.addRow(new Object[]{
                insumo.getCodigoInsumo(),
                insumo.getNombre(),
                insumo.getUnidadMedida()
            });
        }
    }
    
    private void limpiarFormulariosMenu() {

        txtProducto.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        comboCategoria.setSelectedIndex(0);
        lblFoto.setIcon(null);
        lblFoto.setText("Sin Imagen");
        rutaImagenActual = ""; 
        
        txtProducto.setEnabled(true);
        
        DefaultTableModel modeloReceta = (DefaultTableModel) tablaIngredientes.getModel();
        modeloReceta.setRowCount(0);
        
        txtBuscarInsumo.setText("");
    }
    

    private void dibujarTablaProductos(ListaDinamica<Producto> lista) {
        DefaultTableModel modelo = (DefaultTableModel) tablaProductos.getModel();
        modelo.setRowCount(0); 
        
        for (int i = 0; i < lista.getTamaño(); i++) {
            entidades.Producto p = lista.obtener(i);
            
            modelo.addRow(new Object[]{p.getCodigoProducto(), p.getNombre(), p.getCategoria().name(), p.getPrecioVenta()});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        moduloMenu = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarNombre = new javax.swing.JTextField();
        comboCategoria = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboCategoria2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        btnPasarReceta = new javax.swing.JButton();
        btnCargarImagen = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtBuscarInsumo = new javax.swing.JTextField();
        btnBuscar2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBusquedaInsumo = new javax.swing.JTable();
        btnAgregarInsumo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaIngredientes = new javax.swing.JTable();
        btnQuitarInsumo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

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

        btnModificar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(this::btnModificarActionPerformed);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setText("Busqueda por nombre:");

        comboCategoria.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bebida caliente", "Bebida fria", "Postre", "Comida" }));

        btnFiltrar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(this::btnFiltrarActionPerformed);

        btnBuscar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addGap(245, 245, 245))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiltrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        moduloMenu.addTab("Listado del menu", jPanel3);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Ingresa los siguientes datos para añadir un nuevo producto al menu");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("Codigo de producto:");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("Nombre de producto :");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setText("Categoria :");

        comboCategoria2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BEBIDA_CALIENTE", "BEBIDA_FRIA", "POSTRE", "COMIDA" }));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setText("Precio de venta :");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel7.setText("Imagen de referencia :");

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnPasarReceta.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnPasarReceta.setText("Pasar a receta");
        btnPasarReceta.addActionListener(this::btnPasarRecetaActionPerformed);

        btnCargarImagen.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnCargarImagen.setText("Cargar Imagen");
        btnCargarImagen.addActionListener(this::btnCargarImagenActionPerformed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel2))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(313, 313, 313)
                                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 35, Short.MAX_VALUE)))
                .addGap(33, 33, 33))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(btnPasarReceta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCargarImagen)
                .addGap(103, 103, 103))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(comboCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCargarImagen)
                        .addGap(36, 36, 36)
                        .addComponent(btnPasarReceta)
                        .addGap(22, 22, 22))))
        );

        moduloMenu.addTab("Agregar nuevo producto", jPanel4);

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel9.setText("Busca e ingresa los insumos necesarios para la elaboracion del producto ");

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel10.setText("Busqueda por nombre :");

        txtBuscarInsumo.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        btnBuscar2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBuscar2.setText("Buscar");
        btnBuscar2.addActionListener(this::btnBuscar2ActionPerformed);

        tablaBusquedaInsumo.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        tablaBusquedaInsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Unidad de medida"
            }
        ));
        jScrollPane1.setViewportView(tablaBusquedaInsumo);

        btnAgregarInsumo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnAgregarInsumo.setText("Agregar insumo a la receta");
        btnAgregarInsumo.addActionListener(this::btnAgregarInsumoActionPerformed);

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel11.setText("Listado de insumos agregados a la receta del producto ");

        tablaIngredientes.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        tablaIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Cantidad requerida", "Unidad de medida"
            }
        ));
        jScrollPane3.setViewportView(tablaIngredientes);

        btnQuitarInsumo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnQuitarInsumo.setText("Quitar insumo");
        btnQuitarInsumo.addActionListener(this::btnQuitarInsumoActionPerformed);

        btnGuardar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar Producto");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscarInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar2))
                            .addComponent(jLabel9))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnQuitarInsumo)
                        .addGap(226, 226, 226))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(218, 218, 218))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnAgregarInsumo)
                        .addGap(179, 179, 179))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar2))
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarInsumo)
                .addGap(26, 26, 26)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuitarInsumo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(17, 17, 17))
        );

        moduloMenu.addTab("Receta", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(moduloMenu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(moduloMenu)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPasarRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarRecetaActionPerformed
        
    moduloMenu.setEnabledAt(2, true);    
    String codigo = txtProducto.getText().trim();
    String nombre = txtNombre.getText().trim();
    String precioStr = txtPrecio.getText().trim();

    if (codigo.isEmpty() || nombre.isEmpty() || precioStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, completa los datos principales del producto.", "Datos Incompletos", JOptionPane.WARNING_MESSAGE);
        return; 
    }

    
    if (btnPasarReceta.getText().equals("Guardar Cambios")) {

        try {
            double precio = Double.parseDouble(precioStr);
            String categoriaStr = comboCategoria2.getSelectedItem().toString();
            CategoriaProducto categoriaEnum = CategoriaProducto.valueOf(categoriaStr);
            
            Producto productoModificado = new Producto(codigo, nombre, categoriaEnum, precio, rutaImagenActual);
            
            ProductoAcceso accesoProd = new ProductoAcceso();
            
            if (accesoProd.actualizar(productoModificado)) {
                JOptionPane.showMessageDialog(this, "¡Producto actualizado correctamente!");
                
                limpiarFormulariosMenu();
                
                btnPasarReceta.setText("Pasar a receta");
                
                dibujarTablaProductos(accesoProd.listarTodos());
                moduloMenu.setSelectedIndex(0);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar en la base de datos.", "Error SQL", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "El precio ingresado no es válido.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    } else {

        if (rutaImagenActual.isEmpty()) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "No has seleccionado una imagen para este producto. ¿Deseas continuar a la receta sin imagen?", "Falta Fotografía", JOptionPane.YES_NO_OPTION);
                
            if (confirmacion != JOptionPane.YES_OPTION) {
                return;
            }
        }
        
        moduloMenu.setSelectedIndex(2);
    }
    }//GEN-LAST:event_btnPasarRecetaActionPerformed

    private void btnCargarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImagenActionPerformed
       
        JFileChooser explorador = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Imagen", "jpg", "jpeg", "png");
        explorador.setFileFilter(filtro);
    
        int resultado = explorador.showOpenDialog(this);
    
        if (resultado == JFileChooser.APPROVE_OPTION) {
        
            File archivoOrigen = explorador.getSelectedFile();
       
            String nombreCarpeta = "imagenes_menu";
            File directorioDestino = new File(nombreCarpeta);
                  
            if (!directorioDestino.exists()) {
                directorioDestino.mkdirs();
            }
                 
            File archivoDestino = new File(directorioDestino, archivoOrigen.getName());
        
            try {
  
                Files.copy(archivoOrigen.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
            
                rutaImagenActual = nombreCarpeta + "/" + archivoOrigen.getName();
            
                ImageIcon iconoOriginal = new ImageIcon(archivoDestino.getAbsolutePath());
                Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), java.awt.Image.SCALE_SMOOTH);
                lblFoto.setIcon(new ImageIcon(imagenEscalada));
                lblFoto.setText(""); 
            
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al copiar la imagen al proyecto: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCargarImagenActionPerformed

    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed

        String textoBuscado = txtBuscarInsumo.getText().trim();
    
        cargarTablaBusquedaInsumos(textoBuscado);
    
        if (tablaBusquedaInsumo.getRowCount() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "No se encontró ningún insumo con ese nombre en el almacén.", "Búsqueda sin resultados", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscar2ActionPerformed

    private void btnAgregarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarInsumoActionPerformed

        int filaSeleccionada = tablaBusquedaInsumo.getSelectedRow();
    
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un insumo de la tabla superior para agregarlo a la receta.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        String codigo = tablaBusquedaInsumo.getValueAt(filaSeleccionada, 0).toString();
        String nombre = tablaBusquedaInsumo.getValueAt(filaSeleccionada, 1).toString();
        String unidad = tablaBusquedaInsumo.getValueAt(filaSeleccionada, 2).toString();
    
        DefaultTableModel modeloReceta = (DefaultTableModel) tablaIngredientes.getModel();
    
        for (int i = 0; i < modeloReceta.getRowCount(); i++) {
            Object valorCelda = modeloReceta.getValueAt(i, 0); 
        
            if (valorCelda != null) { 
                String codigoExistente = valorCelda.toString();
            
                if (codigo.equals(codigoExistente)) {
                    JOptionPane.showMessageDialog(this, "El insumo [" + nombre + "] ya está en la receta. Si deseas cambiar la cantidad, quítalo y vuelve a agregarlo.", "Insumo Duplicado", JOptionPane.ERROR_MESSAGE);
                    return; 
                }
            }
        }
    
        String input = JOptionPane.showInputDialog(this, "¿Qué cantidad de [" + nombre + "] en " + unidad + " requiere este producto?", "Cantidad de Insumo", JOptionPane.QUESTION_MESSAGE);
            
        if (input != null && !input.trim().isEmpty()) {
            try {
                double cantidadRequerida = Double.parseDouble(input.trim());
            
                if (cantidadRequerida <= 0) {
                    JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero.", "Dato Inválido", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            
                modeloReceta.addRow(new Object[]{codigo, nombre, cantidadRequerida, unidad});
            
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa una cantidad numérica válida (ej. 1.5, 200).", "Dato Inválido", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAgregarInsumoActionPerformed

    private void btnQuitarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarInsumoActionPerformed
        int filaReceta = tablaIngredientes.getSelectedRow();
    
        if (filaReceta == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un insumo de la tabla inferior (Receta) para quitarlo.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        DefaultTableModel modeloReceta = (DefaultTableModel) tablaIngredientes.getModel();
        modeloReceta.removeRow(filaReceta);
    }//GEN-LAST:event_btnQuitarInsumoActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed

        String categoriaSeleccionada = comboCategoria.getSelectedItem().toString();
    
        ProductoAcceso acceso = new ProductoAcceso();
        ListaDinamica<Producto> resultadosFiltrados = acceso.filtrarPorCategoria(categoriaSeleccionada);
    
        dibujarTablaProductos(resultadosFiltrados);
    
        if (resultadosFiltrados.getTamaño() == 0) {
            JOptionPane.showMessageDialog(this, "Aún no hay productos registrados en esta categoría.");
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String textoBuscado = txtBuscarNombre.getText().trim(); 
        ProductoAcceso acceso = new ProductoAcceso();
    
        ListaDinamica<Producto> resultados;
    
        if (textoBuscado.isEmpty()) {
            resultados = acceso.listarTodos();
        } else {
            resultados = acceso.buscarPorNombre(textoBuscado);
        }
    
        dibujarTablaProductos(resultados);
    
        if (resultados.getTamaño() == 0) {
            JOptionPane.showMessageDialog(this, "No se encontraron productos con ese nombre.");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        moduloMenu.setEnabledAt(2, false);
        moduloMenu.setEnabledAt(0, true);
        try {

            String codigo = txtProducto.getText().trim();
            String nombre = txtNombre.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
        
            String categoriaStr = comboCategoria2.getSelectedItem().toString();
            CategoriaProducto categoriaEnum = CategoriaProducto.valueOf(categoriaStr);
        
            Producto nuevoProducto = new Producto(codigo, nombre, categoriaEnum, precio, rutaImagenActual);
        
            DefaultTableModel modeloReceta = (DefaultTableModel) tablaIngredientes.getModel();
            ListaDinamica<Receta> listaReceta = new ListaDinamica<>();
        
            for (int i = 0; i < modeloReceta.getRowCount(); i++) {
                String codInsumo = modeloReceta.getValueAt(i, 0).toString();
                String nomInsumo = modeloReceta.getValueAt(i, 1).toString();
                double cantidad = Double.parseDouble(modeloReceta.getValueAt(i, 2).toString());
                String unidad = modeloReceta.getValueAt(i, 3).toString();
            
                Receta ingrediente = new Receta(codigo, codInsumo, nomInsumo, unidad, cantidad);
                listaReceta.agregar(ingrediente);
            }
        
            ProductoAcceso accesoProd = new ProductoAcceso();
        
            if (accesoProd.registrarProductoConReceta(nuevoProducto, listaReceta)) {
            
                JOptionPane.showMessageDialog(this, "¡Producto y receta guardados con éxito en la base de datos!", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
                limpiarFormulariosMenu();
            
                moduloMenu.setSelectedIndex(0);
            
                dibujarTablaProductos(new ProductoAcceso().listarTodos());
            
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar. La transacción fue cancelada.", "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Asegúrate de que el precio del producto sea un número válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
             
            int fila = tablaProductos.getSelectedRow();
    
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto de la tabla para modificar.", "Atención", JOptionPane.WARNING_MESSAGE);
                return;
            }
    
            String codigo = tablaProductos.getValueAt(fila, 0).toString();
            String nombre = tablaProductos.getValueAt(fila, 1).toString();
            String categoria = tablaProductos.getValueAt(fila, 2).toString();
            String precio = tablaProductos.getValueAt(fila, 3).toString();
    

            txtProducto.setText(codigo);
            txtNombre.setText(nombre);
            comboCategoria.setSelectedItem(categoria);
            txtPrecio.setText(precio);
    
            ProductoAcceso accesoProd = new ProductoAcceso();
            String rutaGuardada = accesoProd.obtenerRutaImagen(codigo);
    
            rutaImagenActual = rutaGuardada; 
    
            if (rutaGuardada != null && !rutaGuardada.trim().isEmpty()) {
                try {
                    ImageIcon iconoOriginal = new ImageIcon(rutaGuardada);
                    Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), java.awt.Image.SCALE_SMOOTH);
                    lblFoto.setIcon(new ImageIcon(imagenEscalada));
                    lblFoto.setText("");
                } catch (Exception e) {
                    lblFoto.setIcon(null);
                    lblFoto.setText("Imagen no encontrada");
                }
            } else {
                lblFoto.setIcon(null);
                lblFoto.setText("Sin Imagen");
            }
    
            txtProducto.setEnabled(false);
            btnPasarReceta.setText("Guardar Cambios");
    
            moduloMenu.setSelectedIndex(1);
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarInsumo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnCargarImagen;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnPasarReceta;
    private javax.swing.JButton btnQuitarInsumo;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboCategoria2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTabbedPane moduloMenu;
    private javax.swing.JTable tablaBusquedaInsumo;
    private javax.swing.JTable tablaIngredientes;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBuscarInsumo;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
