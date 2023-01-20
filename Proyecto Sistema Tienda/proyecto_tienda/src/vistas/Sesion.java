package vistas;

public class Sesion extends javax.swing.JDialog {

    public Sesion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        btn_ingresar = new javax.swing.JButton();
        label_recuperar_pass = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        label_pass = new javax.swing.JLabel();
        label_usuario_vacio = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        label_titulo = new javax.swing.JLabel();
        label_usuario = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_ingresar.setText("Ingresar");
        getContentPane().add(btn_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 270, 50));

        label_recuperar_pass.setText("¿Olvidaste tu contraseña?");
        getContentPane().add(label_recuperar_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 160, -1));

        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });
        getContentPane().add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 250, 35));
        getContentPane().add(label_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 60, 30));

        label_usuario_vacio.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        label_usuario_vacio.setText("*Campos Vacios");
        getContentPane().add(label_usuario_vacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 170, -1));
        getContentPane().add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 250, 35));

        label_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo.setText("Inicio de Sesión");
        getContentPane().add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 340, 28));

        label_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_usuario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        label_usuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_usuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(label_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 70, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_ingresar;
    private javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JLabel label_pass;
    public javax.swing.JLabel label_recuperar_pass;
    public javax.swing.JLabel label_titulo;
    public javax.swing.JLabel label_usuario;
    public javax.swing.JLabel label_usuario_vacio;
    public javax.swing.JPasswordField txt_pass;
    public javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
