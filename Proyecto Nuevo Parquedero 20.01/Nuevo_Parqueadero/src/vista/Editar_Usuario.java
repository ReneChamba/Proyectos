
package vista;


public class Editar_Usuario extends javax.swing.JDialog {


    public Editar_Usuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel_Datos = new javax.swing.JPanel();
        lb_name_id = new javax.swing.JLabel();
        lb_nombre = new javax.swing.JLabel();
        lb_contrasena = new javax.swing.JLabel();
        lb_usuario = new javax.swing.JLabel();
        lb_tipo_cuenta = new javax.swing.JLabel();
        lb_id = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_tipoCuenta = new javax.swing.JTextField();
        txt_contrasena = new javax.swing.JPasswordField();
        btn_nombre = new javax.swing.JButton();
        btn_usuario = new javax.swing.JButton();
        btn_contrasena = new javax.swing.JButton();
        txt_cedula = new javax.swing.JTextField();
        lb_cedula = new javax.swing.JLabel();
        panel_actualizar = new javax.swing.JPanel();
        lb_nuevo_dato = new javax.swing.JLabel();
        lb_confirmar = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        txt_nuevo_dato = new javax.swing.JTextField();
        txt_confirmar = new javax.swing.JPasswordField();
        lb_titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout(2, 2));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_Datos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_name_id.setText("Id: ");
        panel_Datos.add(lb_name_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 100, 30));

        lb_nombre.setText("Nombre:");
        panel_Datos.add(lb_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 100, 30));

        lb_contrasena.setText("Contraseña:");
        panel_Datos.add(lb_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 100, 30));

        lb_usuario.setText("Usuario:");
        panel_Datos.add(lb_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 100, 30));

        lb_tipo_cuenta.setText("Tipo Cuenta:");
        panel_Datos.add(lb_tipo_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 100, 30));

        lb_id.setText("0");
        panel_Datos.add(lb_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 70, 30));

        txt_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuarioActionPerformed(evt);
            }
        });
        panel_Datos.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 260, 30));
        panel_Datos.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 260, 30));

        txt_tipoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tipoCuentaActionPerformed(evt);
            }
        });
        panel_Datos.add(txt_tipoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 260, 30));
        panel_Datos.add(txt_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 260, 30));
        panel_Datos.add(btn_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 80, 30));
        panel_Datos.add(btn_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 80, 30));
        panel_Datos.add(btn_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 80, 30));
        panel_Datos.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 260, 30));

        lb_cedula.setText("Cédula:");
        panel_Datos.add(lb_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 30));

        jPanel1.add(panel_Datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 44, 530, 270));

        panel_actualizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_nuevo_dato.setText("Ingrese nuevo Dato:");
        panel_actualizar.add(lb_nuevo_dato, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 30));

        lb_confirmar.setText("Ingrese  contraseña actual:");
        panel_actualizar.add(lb_confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 200, 30));

        btn_cancelar.setText("Cancelar");
        panel_actualizar.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 160, 50));

        btn_guardar.setText("Guardar");
        panel_actualizar.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 180, 50));
        panel_actualizar.add(txt_nuevo_dato, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 260, 30));
        panel_actualizar.add(txt_confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 260, 30));

        jPanel1.add(panel_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 320, 530, 190));

        lb_titulo.setText("Configurar Cuenta");
        jPanel1.add(lb_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 10, 280, 30));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuarioActionPerformed

    private void txt_tipoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tipoCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tipoCuentaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_cancelar;
    public javax.swing.JButton btn_contrasena;
    public javax.swing.JButton btn_guardar;
    public javax.swing.JButton btn_nombre;
    public javax.swing.JButton btn_usuario;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lb_cedula;
    public javax.swing.JLabel lb_confirmar;
    public javax.swing.JLabel lb_contrasena;
    public javax.swing.JLabel lb_id;
    public javax.swing.JLabel lb_name_id;
    public javax.swing.JLabel lb_nombre;
    public javax.swing.JLabel lb_nuevo_dato;
    public javax.swing.JLabel lb_tipo_cuenta;
    public javax.swing.JLabel lb_titulo;
    public javax.swing.JLabel lb_usuario;
    public javax.swing.JPanel panel_Datos;
    public javax.swing.JPanel panel_actualizar;
    public javax.swing.JTextField txt_cedula;
    public javax.swing.JPasswordField txt_confirmar;
    public javax.swing.JPasswordField txt_contrasena;
    public javax.swing.JTextField txt_nombre;
    public javax.swing.JTextField txt_nuevo_dato;
    public javax.swing.JTextField txt_tipoCuenta;
    public javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
