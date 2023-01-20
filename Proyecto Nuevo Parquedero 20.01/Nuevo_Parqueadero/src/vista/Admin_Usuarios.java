package vista;

public class Admin_Usuarios extends javax.swing.JDialog {

    public Admin_Usuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lb_titulo = new javax.swing.JLabel();
        lb_name_codigo = new javax.swing.JLabel();
        lb_cuenta = new javax.swing.JLabel();
        lb_role = new javax.swing.JLabel();
        lb_codigo = new javax.swing.JLabel();
        txt_role = new javax.swing.JTextField();
        txt_cuenta = new javax.swing.JTextField();
        combo_tipo_cuenta = new javax.swing.JComboBox<>();
        lb_nuevo_role = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.setRowHeight(30);
        jScrollPane1.setViewportView(tabla);

        panel_principal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 710, 270));

        lb_titulo.setText("Administrar Usuarios");
        panel_principal.add(lb_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 15, 300, 30));

        lb_name_codigo.setText("Código:");
        panel_principal.add(lb_name_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 100, 30));

        lb_cuenta.setText("Cuenta:");
        panel_principal.add(lb_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 100, 30));

        lb_role.setText("Role:");
        panel_principal.add(lb_role, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 100, 30));

        lb_codigo.setText("###");
        panel_principal.add(lb_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 70, 30));
        panel_principal.add(txt_role, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 210, 30));

        txt_cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cuentaActionPerformed(evt);
            }
        });
        panel_principal.add(txt_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 210, 30));

        combo_tipo_cuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Empleado" }));
        combo_tipo_cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tipo_cuentaActionPerformed(evt);
            }
        });
        panel_principal.add(combo_tipo_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 210, 30));

        lb_nuevo_role.setText("Nuevo role:");
        panel_principal.add(lb_nuevo_role, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 100, 30));

        btn_cancelar.setText("Cancelar");
        panel_principal.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 170, 50));

        btn_guardar.setText("Aplicar");
        panel_principal.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 170, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cuentaActionPerformed

    private void combo_tipo_cuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tipo_cuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_tipo_cuentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_cancelar;
    public javax.swing.JButton btn_guardar;
    public javax.swing.JComboBox<String> combo_tipo_cuenta;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lb_codigo;
    public javax.swing.JLabel lb_cuenta;
    public javax.swing.JLabel lb_name_codigo;
    public javax.swing.JLabel lb_nuevo_role;
    public javax.swing.JLabel lb_role;
    public javax.swing.JLabel lb_titulo;
    private javax.swing.JPanel panel_principal;
    public javax.swing.JTable tabla;
    public javax.swing.JTextField txt_cuenta;
    public javax.swing.JTextField txt_role;
    // End of variables declaration//GEN-END:variables
}
