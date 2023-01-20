
package vista;

public class Registrar extends javax.swing.JDialog {

    public Registrar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_titulo = new javax.swing.JLabel();
        lb_name_cedula = new javax.swing.JLabel();
        lb_name_nombre = new javax.swing.JLabel();
        lb_name_cuenta = new javax.swing.JLabel();
        lb_name_pass = new javax.swing.JLabel();
        lb_name_tipo_cuenta = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_cuenta = new javax.swing.JTextField();
        txt_contrasena = new javax.swing.JTextField();
        combo_tipos = new javax.swing.JComboBox<>();
        btn_crear_cuenta = new javax.swing.JButton();
        lb_cedula = new javax.swing.JLabel();
        lb_pass = new javax.swing.JLabel();
        lb_cuenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_titulo.setText("Registrar Nuevo Usuario");
        jPanel1.add(lb_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 30, 340, 40));

        lb_name_cedula.setText("Cédula:");
        jPanel1.add(lb_name_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 120, 30));

        lb_name_nombre.setText("Nombre:");
        jPanel1.add(lb_name_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 120, 30));

        lb_name_cuenta.setText("Cuenta:");
        jPanel1.add(lb_name_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 120, 30));

        lb_name_pass.setText("Contraseña:");
        jPanel1.add(lb_name_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 120, 30));

        lb_name_tipo_cuenta.setText("Tipo:");
        jPanel1.add(lb_name_tipo_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 120, 30));
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 280, 30));
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 280, 30));

        txt_cuenta.setToolTipText("<html>\n<head>\n<style>\n\nbody {\nbackground:rgb(13,74,139);\nborder: 2px solid blue;\n\n\n}\nh3 {\nwidth:80%;\nbackground-color:green;\nborder-radius : 20px;\nbox-shadow: rgb(187,70,139)  5px 10px 10px; \npadding: 5px  5px 5px 5px ;\n}\n\n#letra_titulo {\ntext-align: center ;\nfont-size:14px;\nborder-radius : 20px;\n}\np {\nfont-size:12 px ;\ncolor: rgb(255,255,255) \n}\n\n</style>\n</head>\n<body >\n<header>\n<h3 id =\"letra_titulo\">Parametros de Usuario</h3>\n</header>\n<p >1: Usuario no puede comenzar con un digito </p><br>\n<p >2: Tiene que tener almenos 3 letras y 3 números</p><br>\n<p >3: Debe contener minimo 10 caracteres </p>\n</body>\n</html>");
        txt_cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cuentaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 280, 30));

        txt_contrasena.setToolTipText("<html>\n<head>\n<style>\n\nbody {\nbackground:rgb(13,74,139);\nborder: 2px solid blue;\n\n\n}\nh3 {\nwidth:80%;\nbackground-color:green;\nborder-radius : 20px;\nbox-shadow: rgb(187,70,139)  5px 10px 10px; \npadding: 5px  5px 5px 5px ;\n}\n\n#letra_titulo {\ntext-align: center ;\nfont-size:14px;\nborder-radius : 20px;\n}\np {\nfont-size:12 px ;\ncolor: rgb(255,255,255) \n}\n\n</style>\n</head>\n<body >\n<header>\n<h3 id =\"letra_titulo\">Parametros de Contrasena</h3>\n</header>\n<p >1: No puede comenzar con un digito </p><br>\n<p >2: Tiene que tener almenos 3 letras y 3 números</p><br>\n<p >3: Debe contener minimo 10 caracteres </p>\n</body>\n</html>");
        jPanel1.add(txt_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 280, 30));

        combo_tipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empleado", "Admin" }));
        combo_tipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tiposActionPerformed(evt);
            }
        });
        jPanel1.add(combo_tipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 210, 30));

        btn_crear_cuenta.setText("Registrar Cuenta");
        jPanel1.add(btn_crear_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 270, 60));

        lb_cedula.setText("Digita cédula completa");
        jPanel1.add(lb_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 240, -1));

        lb_pass.setText("Constraseña no cumple los parametros establecidos");
        jPanel1.add(lb_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 330, -1));

        lb_cuenta.setText("Cuenta no cumple los parametros establecidos");
        jPanel1.add(lb_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 300, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_tiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_tiposActionPerformed

    private void txt_cuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cuentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_crear_cuenta;
    public javax.swing.JComboBox<String> combo_tipos;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lb_cedula;
    public javax.swing.JLabel lb_cuenta;
    public javax.swing.JLabel lb_name_cedula;
    public javax.swing.JLabel lb_name_cuenta;
    public javax.swing.JLabel lb_name_nombre;
    public javax.swing.JLabel lb_name_pass;
    public javax.swing.JLabel lb_name_tipo_cuenta;
    public javax.swing.JLabel lb_pass;
    public javax.swing.JLabel lb_titulo;
    public javax.swing.JTextField txt_cedula;
    public javax.swing.JTextField txt_contrasena;
    public javax.swing.JTextField txt_cuenta;
    public javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
