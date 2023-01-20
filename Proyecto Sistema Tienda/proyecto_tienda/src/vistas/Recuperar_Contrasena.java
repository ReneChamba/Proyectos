package vistas;

import javax.swing.JDialog;

public class Recuperar_Contrasena extends JDialog {

    public Recuperar_Contrasena(JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_titulo = new javax.swing.JLabel();
        txt_ingresar_correo = new javax.swing.JTextField();
        btn_enviar_solicitud = new javax.swing.JButton();
        label_correo_mal = new javax.swing.JLabel();
        label_ingresar_correo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_titulo.setText("Recuperar Contraseña");
        jPanel1.add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 330, 30));
        jPanel1.add(txt_ingresar_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 330, 40));

        btn_enviar_solicitud.setText("Enviar Solicitud");
        jPanel1.add(btn_enviar_solicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 200, 40));

        label_correo_mal.setText("Correo incorrecto");
        jPanel1.add(label_correo_mal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 320, -1));

        label_ingresar_correo.setText("Digita correo electronico:");
        jPanel1.add(label_ingresar_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 180, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_enviar_solicitud;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel label_correo_mal;
    public javax.swing.JLabel label_ingresar_correo;
    public javax.swing.JLabel label_titulo;
    public javax.swing.JTextField txt_ingresar_correo;
    // End of variables declaration//GEN-END:variables
}
