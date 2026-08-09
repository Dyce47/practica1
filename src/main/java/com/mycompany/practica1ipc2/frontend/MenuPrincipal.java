package com.mycompany.practica1ipc2.frontend;


public class MenuPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPrincipal.class.getName());


    public MenuPrincipal() {
        initComponents();
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu5 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        escritorioPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuAdmin = new javax.swing.JMenu();
        btnGestionPersonal = new javax.swing.JMenuItem();
        btnGestionNominas = new javax.swing.JMenuItem();
        MenuAlmacen = new javax.swing.JMenu();
        btnGestionInventario = new javax.swing.JMenuItem();
        btnGestionMenu = new javax.swing.JMenuItem();
        MenuOperaciones = new javax.swing.JMenu();
        btnControlMesas = new javax.swing.JMenuItem();
        btnGestionCuentas = new javax.swing.JMenuItem();
        MenuReportes = new javax.swing.JMenu();
        btnFlujoCaja = new javax.swing.JMenuItem();
        btnProductosMasVendidos = new javax.swing.JMenuItem();
        btnBajoStock = new javax.swing.JMenuItem();
        btnExportarMenu = new javax.swing.JMenu();
        btnSalir = new javax.swing.JMenu();

        jMenu5.setText("jMenu5");

        jMenuItem8.setText("jMenuItem8");

        jMenu7.setText("jMenu7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioPrincipalLayout = new javax.swing.GroupLayout(escritorioPrincipal);
        escritorioPrincipal.setLayout(escritorioPrincipalLayout);
        escritorioPrincipalLayout.setHorizontalGroup(
            escritorioPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        escritorioPrincipalLayout.setVerticalGroup(
            escritorioPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );

        MenuAdmin.setText("Administracion");

        btnGestionPersonal.setText("Gestion de Personal");
        btnGestionPersonal.addActionListener(this::btnGestionPersonalActionPerformed);
        MenuAdmin.add(btnGestionPersonal);

        btnGestionNominas.setText("Gestion de Nominas");
        MenuAdmin.add(btnGestionNominas);

        jMenuBar1.add(MenuAdmin);

        MenuAlmacen.setText("Almacen");

        btnGestionInventario.setText("Gestion de Inventario");
        btnGestionInventario.addActionListener(this::btnGestionInventarioActionPerformed);
        MenuAlmacen.add(btnGestionInventario);

        btnGestionMenu.setText("Gestion de Menu");
        MenuAlmacen.add(btnGestionMenu);

        jMenuBar1.add(MenuAlmacen);

        MenuOperaciones.setText("Operaciones");

        btnControlMesas.setText("Control de Mesas");
        MenuOperaciones.add(btnControlMesas);

        btnGestionCuentas.setText("Gestion de Cuentas");
        btnGestionCuentas.addActionListener(this::btnGestionCuentasActionPerformed);
        MenuOperaciones.add(btnGestionCuentas);

        jMenuBar1.add(MenuOperaciones);

        MenuReportes.setText("Reportes");

        btnFlujoCaja.setText("Flujo de Caja");
        MenuReportes.add(btnFlujoCaja);

        btnProductosMasVendidos.setText("Productos Mas Vendidos");
        MenuReportes.add(btnProductosMasVendidos);

        btnBajoStock.setText("Insumos con Bajo Stock");
        MenuReportes.add(btnBajoStock);

        jMenuBar1.add(MenuReportes);

        btnExportarMenu.setText("Exportar Menu");
        jMenuBar1.add(btnExportarMenu);

        btnSalir.setText("Salir");
        jMenuBar1.add(btnSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorioPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorioPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionCuentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGestionCuentasActionPerformed

    private void btnGestionPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionPersonalActionPerformed
   
        ModuloPersonal ventanaPersonal = new ModuloPersonal();

        escritorioPrincipal.add(ventanaPersonal);

  
        ventanaPersonal.setVisible(true);
    }//GEN-LAST:event_btnGestionPersonalActionPerformed

    private void btnGestionInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionInventarioActionPerformed
        
        ModuloInventario ventanaInventario = new ModuloInventario();
        
        escritorioPrincipal.add(ventanaInventario);
        
        ventanaInventario.setVisible(true);
    }//GEN-LAST:event_btnGestionInventarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAdmin;
    private javax.swing.JMenu MenuAlmacen;
    private javax.swing.JMenu MenuOperaciones;
    private javax.swing.JMenu MenuReportes;
    private javax.swing.JMenuItem btnBajoStock;
    private javax.swing.JMenuItem btnControlMesas;
    private javax.swing.JMenu btnExportarMenu;
    private javax.swing.JMenuItem btnFlujoCaja;
    private javax.swing.JMenuItem btnGestionCuentas;
    private javax.swing.JMenuItem btnGestionInventario;
    private javax.swing.JMenuItem btnGestionMenu;
    private javax.swing.JMenuItem btnGestionNominas;
    private javax.swing.JMenuItem btnGestionPersonal;
    private javax.swing.JMenuItem btnProductosMasVendidos;
    private javax.swing.JMenu btnSalir;
    private javax.swing.JDesktopPane escritorioPrincipal;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem8;
    // End of variables declaration//GEN-END:variables
}

