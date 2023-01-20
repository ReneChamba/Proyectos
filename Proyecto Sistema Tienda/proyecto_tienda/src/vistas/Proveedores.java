
package vistas;


public class Proveedores extends javax.swing.JDialog {

    public Proveedores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_datos = new javax.swing.JPanel();
        label_cedula = new javax.swing.JLabel();
        label_codigo = new javax.swing.JLabel();
        label_nombre = new javax.swing.JLabel();
        label_direccion = new javax.swing.JLabel();
        label_provincia = new javax.swing.JLabel();
        label_correo = new javax.swing.JLabel();
        label_telefono_fijo = new javax.swing.JLabel();
        label_celular = new javax.swing.JLabel();
        label_empresa = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        txt_nombre_provee = new javax.swing.JTextField();
        txt_empresa = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_telefono_fijo = new javax.swing.JTextField();
        txt_celular = new javax.swing.JTextField();
        combo_provincia = new javax.swing.JComboBox<>();
        btn_registrar_proveedor = new javax.swing.JButton();
        btn_generar_codigo = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        label_cedula_error = new javax.swing.JLabel();
        label_error_correo = new javax.swing.JLabel();
        btn_esconder = new javax.swing.JButton();
        panel_deslizable = new javax.swing.JPanel();
        btn_agregar = new javax.swing.JButton();
        btn_actualizar_proveedor = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_listar = new javax.swing.JButton();
        label_titulo = new javax.swing.JLabel();
        panel_tabla = new javax.swing.JPanel();
        btn_bajar_tabla = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_proveedor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_datos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Datos Proveedor", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        panel_datos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_cedula.setText("Cedúla:");
        panel_datos.add(label_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, 150, 30));

        label_codigo.setText("Codigo: ");
        panel_datos.add(label_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 150, 30));

        label_nombre.setText("Nombre Proveedor:  ");
        panel_datos.add(label_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, 150, 30));

        label_direccion.setText("Dirección");
        panel_datos.add(label_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 190, 150, 30));

        label_provincia.setText("Provincia");
        panel_datos.add(label_provincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 230, 150, 30));

        label_correo.setText("Correo:");
        panel_datos.add(label_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 270, 150, 30));

        label_telefono_fijo.setText("Teléfono fijo:");
        panel_datos.add(label_telefono_fijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 310, 150, 30));

        label_celular.setText("Celular");
        panel_datos.add(label_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 350, 150, 30));

        label_empresa.setText("Empresa:");
        panel_datos.add(label_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 150, 150, 30));

        txt_codigo.setFocusCycleRoot(true);
        panel_datos.add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 120, 30));
        panel_datos.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 250, 30));
        panel_datos.add(txt_nombre_provee, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 250, 30));
        panel_datos.add(txt_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 250, 30));
        panel_datos.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 250, 30));
        panel_datos.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 250, 30));
        panel_datos.add(txt_telefono_fijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 250, 30));
        panel_datos.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 250, 30));

        combo_provincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Azuay", "Bolívar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", "El Oro", "Esmeraldas", "Galápagos", "Guayas", "Imbabura", "Loja", "Los Ríos", "Manabí", "Morona Santiago", "Napo", "Orellana", "Pastaza", "Pichincha", "Santa Elena", "Santo Domingo de los Tsáchilas", "Sucumbíos", "Tungurahua", "Zamora Chinchipe" }));
        panel_datos.add(combo_provincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 250, 30));

        btn_registrar_proveedor.setText("Registrar Proveedor");
        panel_datos.add(btn_registrar_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 230, 50));

        btn_generar_codigo.setText("Generar Codigo");
        panel_datos.add(btn_generar_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 180, -1));

        btn_cancelar.setText("Cancelar");
        panel_datos.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 402, 180, 50));

        label_cedula_error.setText("Incorrecto");
        panel_datos.add(label_cedula_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        label_error_correo.setText("Incorrecto");
        panel_datos.add(label_error_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, -1, -1));

        getContentPane().add(panel_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 570, 470));

        btn_esconder.setContentAreaFilled(false);
        btn_esconder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_esconderMouseEntered(evt);
            }
        });
        btn_esconder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_esconderActionPerformed(evt);
            }
        });
        getContentPane().add(btn_esconder, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 66, 60));

        panel_deslizable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        panel_deslizable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_agregar.setText("Nuevo ");
        panel_deslizable.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 60));

        btn_actualizar_proveedor.setText("Actualizar");
        panel_deslizable.add(btn_actualizar_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 200, 60));

        btn_eliminar.setText("Eliminar");
        panel_deslizable.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 200, 60));

        btn_listar.setText("Listar ");
        panel_deslizable.add(btn_listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 200, 60));

        getContentPane().add(panel_deslizable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 220, 470));

        label_titulo.setText("jLabel1");
        getContentPane().add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 380, -1));

        panel_tabla.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Proveedores Registrados", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        panel_tabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_bajar_tabla.setText("Ocultar");
        panel_tabla.add(btn_bajar_tabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 130, 50));

        tabla_proveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_proveedor.setRowHeight(28);
        jScrollPane1.setViewportView(tabla_proveedor);

        panel_tabla.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1040, 270));

        getContentPane().add(panel_tabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 195, 1070, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_esconderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_esconderMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_esconderMouseEntered

    private void btn_esconderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_esconderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_esconderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_actualizar_proveedor;
    public javax.swing.JButton btn_agregar;
    public javax.swing.JButton btn_bajar_tabla;
    public javax.swing.JButton btn_cancelar;
    public javax.swing.JButton btn_eliminar;
    public javax.swing.JButton btn_esconder;
    public javax.swing.JButton btn_generar_codigo;
    public javax.swing.JButton btn_listar;
    public javax.swing.JButton btn_registrar_proveedor;
    public javax.swing.JComboBox<String> combo_provincia;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel label_cedula;
    public javax.swing.JLabel label_cedula_error;
    public javax.swing.JLabel label_celular;
    public javax.swing.JLabel label_codigo;
    public javax.swing.JLabel label_correo;
    public javax.swing.JLabel label_direccion;
    public javax.swing.JLabel label_empresa;
    public javax.swing.JLabel label_error_correo;
    public javax.swing.JLabel label_nombre;
    public javax.swing.JLabel label_provincia;
    public javax.swing.JLabel label_telefono_fijo;
    public javax.swing.JLabel label_titulo;
    public javax.swing.JPanel panel_datos;
    public javax.swing.JPanel panel_deslizable;
    public javax.swing.JPanel panel_tabla;
    public javax.swing.JTable tabla_proveedor;
    public javax.swing.JTextField txt_cedula;
    public javax.swing.JTextField txt_celular;
    public javax.swing.JTextField txt_codigo;
    public javax.swing.JTextField txt_correo;
    public javax.swing.JTextField txt_direccion;
    public javax.swing.JTextField txt_empresa;
    public javax.swing.JTextField txt_nombre_provee;
    public javax.swing.JTextField txt_telefono_fijo;
    // End of variables declaration//GEN-END:variables
}
