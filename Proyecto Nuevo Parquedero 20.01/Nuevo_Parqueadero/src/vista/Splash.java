package vista;

public class Splash extends javax.swing.JDialog {

    public Splash() {
        ///super(parent, modal);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        barra_progreso = new javax.swing.JProgressBar();
        lb_imagen = new javax.swing.JLabel();
        lb_porcentaje = new javax.swing.JLabel();
        lb_sms = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(95, 158, 160));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barra_progreso.setBackground(new java.awt.Color(95, 158, 160));
        barra_progreso.setBorder(null);
        barra_progreso.setBorderPainted(false);
        jPanel1.add(barra_progreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 680, 60));
        jPanel1.add(lb_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 700, 330));

        lb_porcentaje.setFont(new java.awt.Font("Arial Black", 1, 17)); // NOI18N
        lb_porcentaje.setForeground(new java.awt.Color(0, 0, 0));
        lb_porcentaje.setText("0");
        jPanel1.add(lb_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, 100, 30));

        lb_sms.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lb_sms.setForeground(new java.awt.Color(0, 0, 0));
        lb_sms.setText("Iniciando componentes........");
        jPanel1.add(lb_sms, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 435, 450, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JProgressBar barra_progreso;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lb_imagen;
    public javax.swing.JLabel lb_porcentaje;
    public javax.swing.JLabel lb_sms;
    // End of variables declaration//GEN-END:variables
}
