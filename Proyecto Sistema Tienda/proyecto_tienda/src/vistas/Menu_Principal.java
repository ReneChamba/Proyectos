package vistas;

public class Menu_Principal extends javax.swing.JFrame {

    public Menu_Principal() {
        initComponents();
       
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel_principal = new javax.swing.JPanel();
        label_poner_cedula = new javax.swing.JLabel();
        label_apellido = new javax.swing.JLabel();
        label_contrasena = new javax.swing.JLabel();
        label_correo = new javax.swing.JLabel();
        label_cuenta = new javax.swing.JLabel();
        label_nombre = new javax.swing.JLabel();
        label_fecha = new javax.swing.JLabel();
        label_usu_activado = new javax.swing.JLabel();
        barra_menu = new javax.swing.JMenuBar();
        item_Inicio = new javax.swing.JMenu();
        item_sesion = new javax.swing.JMenuItem();
        item_registrar = new javax.swing.JMenuItem();
        item_cerrar_sesion = new javax.swing.JMenuItem();
        item_tienda = new javax.swing.JMenu();
        item_vender = new javax.swing.JMenuItem();
        item_compras = new javax.swing.JMenuItem();
        item_conf_proveedores = new javax.swing.JMenuItem();
        item_registro_de_ventas = new javax.swing.JMenuItem();
        item_configuracion = new javax.swing.JMenu();
        item_cuentas_usuarios = new javax.swing.JMenuItem();
        item_configu_cuenta = new javax.swing.JMenuItem();
        item_clientes = new javax.swing.JMenuItem();
        item_sistema = new javax.swing.JMenuItem();
        item_menu_estadisticas = new javax.swing.JMenu();
        item_estadisticas = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenu4.setText("File");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar1.add(jMenu5);

        jLabel2.setText("jLabel2");

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        panel_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_poner_cedula.setText("cedula");
        panel_principal.add(label_poner_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 50, 30));

        label_apellido.setText("apellido");
        panel_principal.add(label_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        label_contrasena.setText("contrasena");
        panel_principal.add(label_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        label_correo.setText("correo");
        panel_principal.add(label_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        label_cuenta.setText("cuenta");
        panel_principal.add(label_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 70, -1));

        label_nombre.setText("nombre");
        panel_principal.add(label_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 60, -1));

        getContentPane().add(panel_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 380, 190));

        label_fecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_fecha.setText("jLabel3");
        getContentPane().add(label_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 210, 30));

        label_usu_activado.setText("uuyu");
        getContentPane().add(label_usu_activado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 550, 350, 35));

        barra_menu.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                barra_menuVetoableChange(evt);
            }
        });

        item_Inicio.setText("Inicio");
        item_Inicio.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                item_InicioHierarchyChanged(evt);
            }
        });
        item_Inicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                item_InicioFocusGained(evt);
            }
        });
        item_Inicio.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
                item_InicioMenuDeselected(evt);
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                item_InicioMenuSelected(evt);
            }
        });
        item_Inicio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                item_InicioPropertyChange(evt);
            }
        });

        item_sesion.setText("Iniciar Sesión");
        item_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_sesionActionPerformed(evt);
            }
        });
        item_Inicio.add(item_sesion);

        item_registrar.setText("Registrar");
        item_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_registrarActionPerformed(evt);
            }
        });
        item_Inicio.add(item_registrar);

        item_cerrar_sesion.setText("Cerrar Sesion");
        item_Inicio.add(item_cerrar_sesion);

        barra_menu.add(item_Inicio);

        item_tienda.setText("Tienda");

        item_vender.setText("Vender");
        item_tienda.add(item_vender);

        item_compras.setText("Inventario");
        item_compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_comprasActionPerformed(evt);
            }
        });
        item_tienda.add(item_compras);

        item_conf_proveedores.setText("Proveedores");
        item_tienda.add(item_conf_proveedores);

        item_registro_de_ventas.setText("Registro Ventas");
        item_tienda.add(item_registro_de_ventas);

        barra_menu.add(item_tienda);

        item_configuracion.setText("Configuración");

        item_cuentas_usuarios.setText("Administrar Usuarios");
        item_configuracion.add(item_cuentas_usuarios);

        item_configu_cuenta.setText("Configuración Cuenta");
        item_configuracion.add(item_configu_cuenta);

        item_clientes.setText("Clientes");
        item_configuracion.add(item_clientes);

        item_sistema.setText("Sistema");
        item_configuracion.add(item_sistema);

        barra_menu.add(item_configuracion);

        item_menu_estadisticas.setText("Estadísticas");

        item_estadisticas.setText("Graficar  ");
        item_menu_estadisticas.add(item_estadisticas);

        barra_menu.add(item_menu_estadisticas);

        setJMenuBar(barra_menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void item_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_sesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_item_sesionActionPerformed

    private void item_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_registrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_item_registrarActionPerformed

    private void item_comprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_comprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_item_comprasActionPerformed

    private void item_InicioMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_item_InicioMenuSelected
        // TODO add your handling code here:
        


    }//GEN-LAST:event_item_InicioMenuSelected

    private void item_InicioMenuDeselected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_item_InicioMenuDeselected
        // TODO add your handling code here:

    }//GEN-LAST:event_item_InicioMenuDeselected

    private void item_InicioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_item_InicioPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_item_InicioPropertyChange

    private void barra_menuVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_barra_menuVetoableChange
        // TODO add your handling code here:

    }//GEN-LAST:event_barra_menuVetoableChange

    private void item_InicioHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_item_InicioHierarchyChanged
        // TODO add your handling code here:


    }//GEN-LAST:event_item_InicioHierarchyChanged

    private void item_InicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_item_InicioFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_item_InicioFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuBar barra_menu;
    public javax.swing.JMenu item_Inicio;
    public javax.swing.JMenuItem item_cerrar_sesion;
    public javax.swing.JMenuItem item_clientes;
    public javax.swing.JMenuItem item_compras;
    public javax.swing.JMenuItem item_conf_proveedores;
    public javax.swing.JMenuItem item_configu_cuenta;
    public javax.swing.JMenu item_configuracion;
    public javax.swing.JMenuItem item_cuentas_usuarios;
    public javax.swing.JMenuItem item_estadisticas;
    public javax.swing.JMenu item_menu_estadisticas;
    public javax.swing.JMenuItem item_registrar;
    public javax.swing.JMenuItem item_registro_de_ventas;
    public javax.swing.JMenuItem item_sesion;
    public javax.swing.JMenuItem item_sistema;
    public javax.swing.JMenu item_tienda;
    public javax.swing.JMenuItem item_vender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JLabel label_apellido;
    public javax.swing.JLabel label_contrasena;
    public javax.swing.JLabel label_correo;
    public javax.swing.JLabel label_cuenta;
    public javax.swing.JLabel label_fecha;
    public javax.swing.JLabel label_nombre;
    public javax.swing.JLabel label_poner_cedula;
    public javax.swing.JLabel label_usu_activado;
    public javax.swing.JPanel panel_principal;
    // End of variables declaration//GEN-END:variables
}
