
package vistas;

public class Configuracion_Cuenta extends javax.swing.JDialog {

    public Configuracion_Cuenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        label_titulo = new javax.swing.JLabel();
        panel_cambiar_pas_cuenta = new javax.swing.JPanel();
        label_nuevo_usuario = new javax.swing.JLabel();
        label_pregun_segurid = new javax.swing.JLabel();
        txt_nuevo_usuario = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        txt_pregunta_Segurida = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        label_cedula = new javax.swing.JLabel();
        label_nombre = new javax.swing.JLabel();
        label_apellido = new javax.swing.JLabel();
        label_correo = new javax.swing.JLabel();
        label_cuenta = new javax.swing.JLabel();
        label_contrasena = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_cuenta = new javax.swing.JTextField();
        txt_pass = new javax.swing.JPasswordField();
        btn_editar_correo = new javax.swing.JButton();
        btn_editar_cuenta = new javax.swing.JButton();
        btn_editar_pass = new javax.swing.JButton();
        label_ayuda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_titulo.setText("Configuracion Cuenta");
        panel_principal.add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 250, -1));

        panel_cambiar_pas_cuenta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Panel Actualización", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(30, 138, 137))); // NOI18N
        panel_cambiar_pas_cuenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_nuevo_usuario.setText("Ingrese nuevo  valor:");
        panel_cambiar_pas_cuenta.add(label_nuevo_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 200, 30));

        label_pregun_segurid.setText("Ingrese su contraseña:");
        panel_cambiar_pas_cuenta.add(label_pregun_segurid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 210, 30));
        panel_cambiar_pas_cuenta.add(txt_nuevo_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 290, 30));

        btn_cancelar.setText("Cancelar");
        panel_cambiar_pas_cuenta.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 230, 50));

        btn_actualizar.setText("Guardar Cambios");
        panel_cambiar_pas_cuenta.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 240, 50));
        panel_cambiar_pas_cuenta.add(txt_pregunta_Segurida, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 290, 30));

        panel_principal.add(panel_cambiar_pas_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 570, 210));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Datos Cuenta", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(30, 138, 137))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_cedula.setText("Cedula:");
        jPanel1.add(label_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 60, 30));

        label_nombre.setText("Nombre:");
        jPanel1.add(label_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 30));

        label_apellido.setText("Apellido:");
        jPanel1.add(label_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 30));

        label_correo.setText("Correo:");
        jPanel1.add(label_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 50, 30));

        label_cuenta.setText("Cuenta:");
        jPanel1.add(label_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 50, 30));

        label_contrasena.setText("Contraseña:");
        jPanel1.add(label_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 90, 30));
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 250, 30));
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 250, 30));
        jPanel1.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 250, 30));
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 250, 30));
        jPanel1.add(txt_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 250, 30));

        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });
        jPanel1.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 250, 30));

        btn_editar_correo.setText("Editar");
        jPanel1.add(btn_editar_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 130, 30));

        btn_editar_cuenta.setText("Editar");
        jPanel1.add(btn_editar_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 130, 30));

        btn_editar_pass.setText("Editar");
        jPanel1.add(btn_editar_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 130, 30));

        label_ayuda.setText("USUARIO");
        jPanel1.add(label_ayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 80, -1));

        panel_principal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 570, 320));

        getContentPane().add(panel_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_actualizar;
    public javax.swing.JButton btn_cancelar;
    public javax.swing.JButton btn_editar_correo;
    public javax.swing.JButton btn_editar_cuenta;
    public javax.swing.JButton btn_editar_pass;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel label_apellido;
    public javax.swing.JLabel label_ayuda;
    public javax.swing.JLabel label_cedula;
    public javax.swing.JLabel label_contrasena;
    public javax.swing.JLabel label_correo;
    public javax.swing.JLabel label_cuenta;
    public javax.swing.JLabel label_nombre;
    public javax.swing.JLabel label_nuevo_usuario;
    public javax.swing.JLabel label_pregun_segurid;
    public javax.swing.JLabel label_titulo;
    public javax.swing.JPanel panel_cambiar_pas_cuenta;
    public javax.swing.JPanel panel_principal;
    public javax.swing.JTextField txt_apellido;
    public javax.swing.JTextField txt_cedula;
    public javax.swing.JTextField txt_correo;
    public javax.swing.JTextField txt_cuenta;
    public javax.swing.JTextField txt_nombre;
    public javax.swing.JTextField txt_nuevo_usuario;
    public javax.swing.JPasswordField txt_pass;
    public javax.swing.JPasswordField txt_pregunta_Segurida;
    // End of variables declaration//GEN-END:variables
}
