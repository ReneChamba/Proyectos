package vista;

public class Editar_Ingreso extends javax.swing.JDialog {

    public Editar_Ingreso(javax.swing.JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_propietario = new javax.swing.JLabel();
        lb_titulo = new javax.swing.JLabel();
        lb_placa = new javax.swing.JLabel();
        lb_tipo = new javax.swing.JLabel();
        txt_propietario = new javax.swing.JTextField();
        txt_placa = new javax.swing.JTextField();
        combo_vehiculos = new javax.swing.JComboBox<>();
        btn_actualizar_vehiculo = new javax.swing.JButton();
        lb_codigo = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        btn_regresar = new javax.swing.JButton();
        lb_motivo = new javax.swing.JLabel();
        combo_motivo = new javax.swing.JComboBox<>();
        txt_precio_lavado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_propietario.setText("Propietario:");
        jPanel1.add(lb_propietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 100, 30));

        lb_titulo.setText("Editar Ingreso Vehículo");
        jPanel1.add(lb_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 16, 290, 30));

        lb_placa.setText("Placa:");
        jPanel1.add(lb_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 100, 30));

        lb_tipo.setText("Tipo:");
        jPanel1.add(lb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 100, 30));
        jPanel1.add(txt_propietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 250, 30));
        jPanel1.add(txt_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 250, 30));

        combo_vehiculos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_vehiculosItemStateChanged(evt);
            }
        });
        jPanel1.add(combo_vehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 250, 30));

        btn_actualizar_vehiculo.setText("Actualizar");
        jPanel1.add(btn_actualizar_vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 190, 50));

        lb_codigo.setText("Código:");
        jPanel1.add(lb_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 30));

        txt_codigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        txt_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 120, 30));

        btn_regresar.setText("Regresar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 190, 50));

        lb_motivo.setText("Motivo");
        jPanel1.add(lb_motivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 100, 30));

        combo_motivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Parqueo", "Lavado", "Lavado + Parqueo" }));
        jPanel1.add(combo_motivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 240, -1));
        jPanel1.add(txt_precio_lavado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 100, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 515));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void combo_vehiculosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_vehiculosItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_vehiculosItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_actualizar_vehiculo;
    public javax.swing.JButton btn_regresar;
    public javax.swing.JComboBox<String> combo_motivo;
    public javax.swing.JComboBox<String> combo_vehiculos;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lb_codigo;
    public javax.swing.JLabel lb_motivo;
    public javax.swing.JLabel lb_placa;
    public javax.swing.JLabel lb_propietario;
    public javax.swing.JLabel lb_tipo;
    public javax.swing.JLabel lb_titulo;
    public javax.swing.JTextField txt_codigo;
    public javax.swing.JTextField txt_placa;
    public javax.swing.JTextField txt_precio_lavado;
    public javax.swing.JTextField txt_propietario;
    // End of variables declaration//GEN-END:variables
}
