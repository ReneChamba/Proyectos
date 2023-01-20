package vista;

public class Sesion extends javax.swing.JDialog {

    public Sesion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_titulo = new javax.swing.JLabel();
        lb_usuario = new javax.swing.JLabel();
        lb_contrasena = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        btn_ingresar = new javax.swing.JButton();
        txt_contrasena = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_titulo.setText("Iniciar Sesión");
        jPanel1.add(lb_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 490, 50));
        jPanel1.add(lb_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 90, 70, 50));
        jPanel1.add(lb_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 100, 40));
        jPanel1.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 300, 35));

        btn_ingresar.setText("Ingresar");
        jPanel1.add(btn_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 250, 50));
        jPanel1.add(txt_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 300, 35));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_ingresar;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lb_contrasena;
    public javax.swing.JLabel lb_titulo;
    public javax.swing.JLabel lb_usuario;
    public javax.swing.JPasswordField txt_contrasena;
    public javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
