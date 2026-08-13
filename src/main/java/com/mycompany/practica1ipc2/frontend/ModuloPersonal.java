package com.mycompany.practica1ipc2.frontend;

import acceso.EmpleadoAcceso;
import entidades.Empleado;
import entidades.Jornada;
import entidades.RolEmpleado;
import estructuras.ListaDinamica;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

public class ModuloPersonal extends javax.swing.JInternalFrame {

    public ModuloPersonal() {
        initComponents();
        cargarTablaEmpleados();
    }
    
    private void limpiarFormulario() {
        txtDPI.setText("");
        txtNombre.setText("");
        txtCorreo.setText("");
        txtSalario.setText("");
        txtFechaContratacion.setText("");
    
        comboRol.setSelectedIndex(0);
        comboJornada.setSelectedIndex(0);
    
        chkEstado.setSelected(false);
    }
    
    private void cargarTablaEmpleados() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaEmpleados.getModel();   
        modeloTabla.setRowCount(0);
    
        EmpleadoAcceso acceso = new EmpleadoAcceso();
        ListaDinamica<Empleado> lista = acceso.listarTodos();
    
        for (int i = 0; i < lista.getTamaño(); i++) {
            entidades.Empleado emp = lista.obtener(i);
        
            String textoEstado = (emp.getEstado() == 1) ? "Activo" : "Inactivo";
        
            Object[] fila = {
                textoEstado, emp.getNombreCompleto(), emp.getDpi(), emp.getRol().name(), emp.getJornada().name(), emp.getFechaContratacion(), emp.getSalario()
            };
        
            modeloTabla.addRow(fila);
        }
        
        tablaEmpleados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        tablaEmpleados.getColumnModel().getColumn(0).setPreferredWidth(60);

        tablaEmpleados.getColumnModel().getColumn(1).setPreferredWidth(250);

        tablaEmpleados.getColumnModel().getColumn(2).setPreferredWidth(120);
        
        tablaEmpleados.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        tablaEmpleados.getColumnModel().getColumn(4).setPreferredWidth(100);
        
        tablaEmpleados.getColumnModel().getColumn(5).setPreferredWidth(100);
        
        tablaEmpleados.getColumnModel().getColumn(6).setPreferredWidth(80);

    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPestanas = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDPI = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtSalario = new javax.swing.JTextField();
        txtFechaContratacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        comboRol = new javax.swing.JComboBox<>();
        comboJornada = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        chkEstado = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtBusquedaDPI = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        cbCriterio = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        cbValor = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setText("Ingresar los siguientes datos para añadir un nuevo empleado al sistema");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Nombre completo :");

        txtNombre.setText("empleado");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("Documento de identificacion (DPI) :");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("Correo Electronico :");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setText("Rol del empleado :");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setText("Jornada :");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel7.setText("Salario :");

        txtCorreo.setText("@gmail.com");

        txtFechaContratacion.setText("aaaa/mm/dd");
        txtFechaContratacion.addActionListener(this::txtFechaContratacionActionPerformed);

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel8.setText("Fecha de contratacion :");

        comboRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mesero", "Cocina", "Barista", "Administrador" }));

        comboJornada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutina", "Vespertina", "Nocturna" }));

        btnGuardar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        chkEstado.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        chkEstado.setText("Empleado Activo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDPI, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 57, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtFechaContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(chkEstado)
                                            .addGap(14, 14, 14))))))))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(279, 279, 279))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFechaContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(44, 44, 44))
        );

        panelPestanas.addTab("Registro de Empleado", jPanel1);

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel9.setText("Buscar empleado por DPI :");

        txtBusquedaDPI.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txtBusquedaDPI.setText("13 digitos");

        btnFiltrar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(this::btnFiltrarActionPerformed);

        cbCriterio.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        cbCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado", "Rol", "Jornada", " " }));
        cbCriterio.addActionListener(this::cbCriterioActionPerformed);

        tablaEmpleados.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Estado", "Nombre", "DPI", "Rol", "Jornada", "Contratacion", "Salario"
            }
        ));
        jScrollPane1.setViewportView(tablaEmpleados);

        btnEditar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnEditar.setText("Editar Empleado Seleccionado");
        btnEditar.addActionListener(this::btnEditarActionPerformed);

        btnBuscar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        cbValor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Esperando" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusquedaDPI, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnFiltrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(205, 205, 205))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtBusquedaDPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFiltrar)
                            .addComponent(btnBuscar)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPestanas.addTab("Listado de Personal", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPestanas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPestanas)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaContratacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaContratacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaContratacionActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        int filaSeleccionada = tablaEmpleados.getSelectedRow();

        if (filaSeleccionada == -1) {
           
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecciona un empleado de la tabla primero.", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            return; 
        }

        String estadoFila = tablaEmpleados.getValueAt(filaSeleccionada, 0).toString();
        String nombre = tablaEmpleados.getValueAt(filaSeleccionada, 1).toString();
        String dpi = tablaEmpleados.getValueAt(filaSeleccionada, 2).toString();
        String rol = tablaEmpleados.getValueAt(filaSeleccionada, 3).toString();
        String jornada = tablaEmpleados.getValueAt(filaSeleccionada, 4).toString();
        String fecha = tablaEmpleados.getValueAt(filaSeleccionada, 5).toString();
        String salario = tablaEmpleados.getValueAt(filaSeleccionada, 6).toString();

       
        txtDPI.setText(dpi);
        txtNombre.setText(nombre);
        txtSalario.setText(salario);
        txtFechaContratacion.setText(fecha);

        comboRol.setSelectedItem(rol);
        comboJornada.setSelectedItem(jornada);
        chkEstado.setSelected(estadoFila.equals("Activo"));


        txtDPI.setEnabled(false);
        panelPestanas.setSelectedIndex(0);        
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            String dpi = txtDPI.getText();
            String nombre = txtNombre.getText();
            String correo = txtCorreo.getText();
    
            RolEmpleado rol = RolEmpleado.valueOf(comboRol.getSelectedItem().toString().toUpperCase());
            Jornada jornada = Jornada.valueOf(comboJornada.getSelectedItem().toString().toUpperCase());
    
            double salario = Double.parseDouble(txtSalario.getText());
            Date fechaContratacion = Date.valueOf(txtFechaContratacion.getText()); 
    
            int estado = chkEstado.isSelected() ? 1 : 0;
    
            Empleado empleadoProcesado = new Empleado(dpi, nombre, correo, rol, jornada, salario, fechaContratacion, estado);
            EmpleadoAcceso empleadoAcceso = new EmpleadoAcceso();
    
            //Añadir nuevos empleados
            if (txtDPI.isEnabled()) {
                
                if (empleadoAcceso.insertar(empleadoProcesado)) {
                    javax.swing.JOptionPane.showMessageDialog(this, "¡Empleado registrado con éxito en el sistema!");
                    limpiarFormulario();
                    cargarTablaEmpleados();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "No se pudo registrar el empleado en la base de datos.", "Error SQL", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            //Modificar empleados    
            } else {
                if (empleadoAcceso.actualizar(empleadoProcesado)) {
                    javax.swing.JOptionPane.showMessageDialog(this, "¡Empleado actualizado correctamente!");
                    txtDPI.setEnabled(true);
                    limpiarFormulario();
                    cargarTablaEmpleados();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "No se pudo actualizar el empleado en la base de datos.", "Error SQL", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
            
    
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingresa un valor numérico válido para el salario.", "Dato Inválido", javax.swing.JOptionPane.WARNING_MESSAGE);
        } catch (IllegalArgumentException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Verifica que la fecha tenga el formato AAAA-MM-DD y que las selecciones sean correctas.", "Dato Inválido", javax.swing.JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error del Sistema", javax.swing.JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String dpiBuscado = txtBusquedaDPI.getText().trim();

        if (dpiBuscado.isEmpty()) {          
            cargarTablaEmpleados();
        } else {
            EmpleadoAcceso acceso = new EmpleadoAcceso();
            Empleado emp = acceso.buscarPorDpi(dpiBuscado);
    
            
            javax.swing.table.DefaultTableModel modeloTabla = (javax.swing.table.DefaultTableModel) tablaEmpleados.getModel();
            modeloTabla.setRowCount(0); 
    
            if (emp != null) {
                String textoEstado = (emp.getEstado() == 1) ? "Activo" : "Inactivo";
        
                Object[] fila = {textoEstado, emp.getNombreCompleto(), emp.getDpi(), emp.getRol().name(), emp.getJornada().name(), emp.getFechaContratacion(), emp.getSalario()
                };
                
                modeloTabla.addRow(fila);
        
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No se encontró ningún empleado con el DPI: " + dpiBuscado, "Búsqueda sin resultados", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                cargarTablaEmpleados();
                txtBusquedaDPI.setText(""); 
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCriterioActionPerformed

        cbValor.removeAllItems();

       
        String criterioSeleccionado = cbCriterio.getSelectedItem().toString();

      
        switch (criterioSeleccionado) {
            case "Rol":
                cbValor.addItem("MESERO");
                cbValor.addItem("COCINA");
                cbValor.addItem("BARISTA");// 
                cbValor.addItem("ADMINISTRADOR");
                break;
            case "Jornada":
                cbValor.addItem("MATUTINA");
                cbValor.addItem("VESPERTINA");
                cbValor.addItem("NOCTURNA");
                break;
            case "Estado":
                cbValor.addItem("Activo");
                cbValor.addItem("Inactivo");
                break;
        }
    }//GEN-LAST:event_cbCriterioActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
     
        String criterio = cbCriterio.getSelectedItem().toString();
        String valor = cbValor.getSelectedItem().toString();

        if (criterio.equals("Rol") || criterio.equals("Jornada")) {
            
        } else if (criterio.equals("Estado")) {
            valor = valor.equals("Activo") ? "1" : "0";
        }

        
        EmpleadoAcceso acceso = new EmpleadoAcceso();
        ListaDinamica<Empleado> lista = acceso.filtrarEmpleados(criterio, valor);

        
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaEmpleados.getModel();
        modeloTabla.setRowCount(0); 

        for (int i = 0; i < lista.getTamaño(); i++) {
            entidades.Empleado emp = lista.obtener(i);
    
            String textoEstado = (emp.getEstado() == 1) ? "Activo" : "Inactivo";
    
            Object[] fila = {
                textoEstado, emp.getNombreCompleto(), emp.getDpi(), emp.getRol().name(), emp.getJornada().name(), emp.getFechaContratacion(), emp.getSalario()
            };
            modeloTabla.addRow(fila);
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed


    
    
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbCriterio;
    private javax.swing.JComboBox<String> cbValor;
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JComboBox<String> comboJornada;
    private javax.swing.JComboBox<String> comboRol;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane panelPestanas;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txtBusquedaDPI;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDPI;
    private javax.swing.JTextField txtFechaContratacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}
