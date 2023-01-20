package vistas;

public class Registrar extends javax.swing.JDialog {

    public Registrar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_botones = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        label_titulo = new javax.swing.JLabel();
        btn_registrar = new javax.swing.JButton();
        panel_datos_personales = new javax.swing.JPanel();
        label_cedula = new javax.swing.JLabel();
        label_nombre = new javax.swing.JLabel();
        label_apellido = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        btn_continuar = new javax.swing.JButton();
        label_cedula_incorrecta = new javax.swing.JLabel();
        label_correo = new javax.swing.JLabel();
        txt_correo_electronico = new javax.swing.JTextField();
        label_correo_incorrecto = new javax.swing.JLabel();
        panel_datos_cuenta = new javax.swing.JPanel();
        label_crear_usuario = new javax.swing.JLabel();
        txt_usuario_reegis = new javax.swing.JTextField();
        label_crear_pas = new javax.swing.JLabel();
        txt_pass_reegis = new javax.swing.JTextField();
        label_repeat_pass = new javax.swing.JLabel();
        txt_confirmar_pass = new javax.swing.JTextField();
        label_usuario_no_cumple = new javax.swing.JLabel();
        label_pass_no_cumple = new javax.swing.JLabel();
        label_tipo_cuenta = new javax.swing.JLabel();
        chech_empleado = new javax.swing.JCheckBox();
        chech_admin = new javax.swing.JCheckBox();
        btn_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_titulo.setText("Formulario De Registro");
        jPanel1.add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 220, -1));

        btn_registrar.setText("Crear Cuenta");
        jPanel1.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, 250, 50));

        panel_datos_personales.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "DATOS PERSONALES", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(102, 102, 0))); // NOI18N
        panel_datos_personales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_cedula.setText("Cédula: ");
        panel_datos_personales.add(label_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 30));

        label_nombre.setText("Nombre:");
        panel_datos_personales.add(label_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 120, 30));

        label_apellido.setText("Apellido:");
        panel_datos_personales.add(label_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 100, 30));
        panel_datos_personales.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 300, 30));

        txt_nombre.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        panel_datos_personales.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 300, 30));
        panel_datos_personales.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 300, 30));

        btn_continuar.setText("Continuar");
        panel_datos_personales.add(btn_continuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 200, 50));

        label_cedula_incorrecta.setText("cedula incorrecta");
        panel_datos_personales.add(label_cedula_incorrecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 220, -1));

        label_correo.setText("Correo ( gmail ):");
        panel_datos_personales.add(label_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 140, 30));
        panel_datos_personales.add(txt_correo_electronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 300, 30));

        label_correo_incorrecto.setText("Correo electronico incorrecto");
        panel_datos_personales.add(label_correo_incorrecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 240, -1));

        jPanel1.add(panel_datos_personales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 740, 260));

        panel_datos_cuenta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "DATOS CUENTA", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(102, 102, 0))); // NOI18N
        panel_datos_cuenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_crear_usuario.setText("Crear Usuario: ");
        panel_datos_cuenta.add(label_crear_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, 30));

        txt_usuario_reegis.setToolTipText("<html>\n<head>\n\t<style >\n\t\theader {\n\t\t\ttext-align: center;\n\t\t\tbackground-color: red;\n\t\t}\n\n\n\t</style>\n\n\n</head>\n<body>\n\t<header >\n\t\t<h4 lign =\"center\">  Parametros De Usuarios</h4>\n\t\t\n\t</header>\n\t<ul>\n\t\t\t<li>\n\t\t\t\tCuenta debe contener minimo 10 caracteres\n\t\t\t</li>\n\t\t\t<li>\n\t\t\t\tCuenta debe contener almenos 3 letras y 3 números\n\t\t\t</li>\n\t\t\t<li>\n\t\t\t\tCuenta y contraseña NO pueden comenzar con un número\n\t\t\t</li>\n\n\n\t\t</ul>\n\n</body>\n</html>");
        panel_datos_cuenta.add(txt_usuario_reegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 90, 300, 30));

        label_crear_pas.setText("Crear Contraseña:");
        panel_datos_cuenta.add(label_crear_pas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 160, 30));

        txt_pass_reegis.setToolTipText("<html>\n<head>\n\t<style >\n\t\theader {\n\t\t\ttext-align: center;\n\t\t\tbackground-color: red;\n\t\t}\n\n\n\t</style>\n\n\n</head>\n<body>\n\t<header >\n\t\t<h4 lign =\"center\">  Parametros De Contraseña</h4>\n\t\t\n\t</header>\n\t<ul>\n\t\t\t<li>\n\t\t\t\tContraseña debe contener minimo 10 caracteres\n\t\t\t</li>\n\t\t\t<li>\n\t\t\t\tContraseña debe contener almenos 3 letras y 3 números\n\t\t\t</li>\n\t\t\t<li>\n\t\t\t\tCuenta y contraseña NO pueden comenzar con un número\n\t\t\t</li>\n\n\n\t\t</ul>\n\n</body>\n</html>");
        txt_pass_reegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pass_reegisActionPerformed(evt);
            }
        });
        panel_datos_cuenta.add(txt_pass_reegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 140, 300, 30));

        label_repeat_pass.setText("Repetir Contraseña: ");
        panel_datos_cuenta.add(label_repeat_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 160, 30));
        panel_datos_cuenta.add(txt_confirmar_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 190, 300, 30));

        label_usuario_no_cumple.setText("Usuario NO cumple los parametros establecidos");
        panel_datos_cuenta.add(label_usuario_no_cumple, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 120, 300, -1));

        label_pass_no_cumple.setText("Contraseña  NO cumple los parametros establecidos");
        panel_datos_cuenta.add(label_pass_no_cumple, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 170, 310, -1));

        label_tipo_cuenta.setText("Tipo de Cuenta:");
        panel_datos_cuenta.add(label_tipo_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, 30));

        chech_empleado.setText("Empleado");
        panel_datos_cuenta.add(chech_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 40, -1, -1));

        chech_admin.setText("Administrador");
        panel_datos_cuenta.add(chech_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 130, -1));

        jPanel1.add(panel_datos_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 740, 240));

        btn_cancelar.setText("Cancelar");
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 610, 250, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_pass_reegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pass_reegisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pass_reegisActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_cancelar;
    public javax.swing.JButton btn_continuar;
    public javax.swing.JButton btn_registrar;
    public javax.swing.JCheckBox chech_admin;
    public javax.swing.JCheckBox chech_empleado;
    public javax.swing.ButtonGroup grupo_botones;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel label_apellido;
    public javax.swing.JLabel label_cedula;
    public javax.swing.JLabel label_cedula_incorrecta;
    public javax.swing.JLabel label_correo;
    public javax.swing.JLabel label_correo_incorrecto;
    public javax.swing.JLabel label_crear_pas;
    public javax.swing.JLabel label_crear_usuario;
    public javax.swing.JLabel label_nombre;
    public javax.swing.JLabel label_pass_no_cumple;
    public javax.swing.JLabel label_repeat_pass;
    public javax.swing.JLabel label_tipo_cuenta;
    public javax.swing.JLabel label_titulo;
    public javax.swing.JLabel label_usuario_no_cumple;
    public javax.swing.JPanel panel_datos_cuenta;
    public javax.swing.JPanel panel_datos_personales;
    public javax.swing.JTextField txt_apellido;
    public javax.swing.JTextField txt_cedula;
    public javax.swing.JTextField txt_confirmar_pass;
    public javax.swing.JTextField txt_correo_electronico;
    public javax.swing.JTextField txt_nombre;
    public javax.swing.JTextField txt_pass_reegis;
    public javax.swing.JTextField txt_usuario_reegis;
    // End of variables declaration//GEN-END:variables
}
