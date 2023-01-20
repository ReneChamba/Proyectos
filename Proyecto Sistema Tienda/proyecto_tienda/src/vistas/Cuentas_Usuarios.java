package vistas;

public class Cuentas_Usuarios extends javax.swing.JDialog {

    public Cuentas_Usuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        label_titulo = new javax.swing.JLabel();
        txt_buscar_usuario = new javax.swing.JTextField();
        combo_cuentas_usuarios = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_cuentas_usuarios = new javax.swing.JTable();
        label_buscar_usuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_titulo.setText("Cuentas De Usuarios");
        panel_principal.add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 298, 45));
        panel_principal.add(txt_buscar_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 396, 40));

        combo_cuentas_usuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Administrador", "Empleado" }));
        panel_principal.add(combo_cuentas_usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 180, 40));

        tabla_cuentas_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_cuentas_usuarios.setRowHeight(25);
        jScrollPane1.setViewportView(tabla_cuentas_usuarios);

        panel_principal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 1130, 230));

        label_buscar_usuario.setText("Buscar Usuario");
        panel_principal.add(label_buscar_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 200, -1));

        getContentPane().add(panel_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> combo_cuentas_usuarios;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel label_buscar_usuario;
    public javax.swing.JLabel label_titulo;
    public javax.swing.JPanel panel_principal;
    public javax.swing.JTable tabla_cuentas_usuarios;
    public javax.swing.JTextField txt_buscar_usuario;
    // End of variables declaration//GEN-END:variables
}
