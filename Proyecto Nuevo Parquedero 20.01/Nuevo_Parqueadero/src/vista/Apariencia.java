
package vista;

public class Apariencia extends javax.swing.JDialog {


    public Apariencia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_titulo = new javax.swing.JLabel();
        panel_fondos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combo_fondo_pantalla = new javax.swing.JComboBox<>();
        combo_fondo_menu = new javax.swing.JComboBox<>();
        combo_fondo_herramientas = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        combo_fondo_estado = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        combo_fondo_fun_herramientas = new javax.swing.JComboBox<>();
        combo_fondo_fun_estado = new javax.swing.JComboBox<>();
        btn_fondos = new javax.swing.JButton();
        panel_TextoColores = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        combo_txt_menu = new javax.swing.JComboBox<>();
        combo_txt_submenu = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        combo_txt_empresa = new javax.swing.JComboBox<>();
        btn_texto = new javax.swing.JButton();
        panel_bordes = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        combo_borde_herramientas = new javax.swing.JComboBox<>();
        combo_borde_estado = new javax.swing.JComboBox<>();
        btn_bordes = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_resetear = new javax.swing.JButton();
        btn_aplicar_cambios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_titulo.setText("Configurar Apariencia ");
        jPanel1.add(lb_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 8, 320, 30));

        panel_fondos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Pantalla:");
        panel_fondos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 150, 30));

        jLabel3.setText("Barra Menú:");
        panel_fondos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 200, 30));

        jLabel4.setText("Barra de Herramientas:");
        panel_fondos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 170, 30));

        panel_fondos.add(combo_fondo_pantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 190, 30));

        panel_fondos.add(combo_fondo_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 190, 30));

        panel_fondos.add(combo_fondo_herramientas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 190, 30));

        jLabel8.setText("Barra de Estado:");
        panel_fondos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 170, 30));

        panel_fondos.add(combo_fondo_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 190, 30));

        jLabel12.setText("Fun Barra Herramientas:");
        panel_fondos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 190, 30));

        jLabel13.setText("Fun Barra Estado:");
        panel_fondos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 170, 30));

        combo_fondo_fun_herramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_fondo_fun_herramientasActionPerformed(evt);
            }
        });
        panel_fondos.add(combo_fondo_fun_herramientas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 190, 30));

        panel_fondos.add(combo_fondo_fun_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 190, 30));
        panel_fondos.add(btn_fondos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 60, 40));

        jPanel1.add(panel_fondos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 420, 380));

        panel_TextoColores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Menú:");
        panel_TextoColores.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 100, 30));

        jLabel6.setText("SubMenú:");
        panel_TextoColores.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 30));

        panel_TextoColores.add(combo_txt_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 190, 30));

        panel_TextoColores.add(combo_txt_submenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 190, 30));

        jLabel9.setText("Empresa:");
        panel_TextoColores.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 100, 30));

        combo_txt_empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_txt_empresaActionPerformed(evt);
            }
        });
        panel_TextoColores.add(combo_txt_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 190, 30));
        panel_TextoColores.add(btn_texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 60, 40));

        jPanel1.add(panel_TextoColores, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 360, 210));

        panel_bordes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setText("Barra Herramientas:");
        panel_bordes.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 150, 30));

        jLabel11.setText("Barra Estado:");
        panel_bordes.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 103, 30));

        panel_bordes.add(combo_borde_herramientas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 29, 170, 30));

        panel_bordes.add(combo_borde_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 170, 30));
        panel_bordes.add(btn_bordes, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 110, 60, 40));

        jPanel1.add(panel_bordes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 360, 160));

        btn_cancelar.setText("Cancelar");
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 215, 50));

        btn_resetear.setText("Predeterminado");
        jPanel1.add(btn_resetear, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, 240, 50));

        btn_aplicar_cambios.setText("Aplicar Cambios");
        jPanel1.add(btn_aplicar_cambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 230, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_txt_empresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_txt_empresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_txt_empresaActionPerformed

    private void combo_fondo_fun_herramientasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_fondo_fun_herramientasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_fondo_fun_herramientasActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_aplicar_cambios;
    public javax.swing.JButton btn_bordes;
    public javax.swing.JButton btn_cancelar;
    public javax.swing.JButton btn_fondos;
    public javax.swing.JButton btn_resetear;
    public javax.swing.JButton btn_texto;
    public javax.swing.JComboBox<String> combo_borde_estado;
    public javax.swing.JComboBox<String> combo_borde_herramientas;
    public javax.swing.JComboBox<String> combo_fondo_estado;
    public javax.swing.JComboBox<String> combo_fondo_fun_estado;
    public javax.swing.JComboBox<String> combo_fondo_fun_herramientas;
    public javax.swing.JComboBox<String> combo_fondo_herramientas;
    public javax.swing.JComboBox<String> combo_fondo_menu;
    public javax.swing.JComboBox<String> combo_fondo_pantalla;
    public javax.swing.JComboBox<String> combo_txt_empresa;
    public javax.swing.JComboBox<String> combo_txt_menu;
    public javax.swing.JComboBox<String> combo_txt_submenu;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lb_titulo;
    public javax.swing.JPanel panel_TextoColores;
    public javax.swing.JPanel panel_bordes;
    public javax.swing.JPanel panel_fondos;
    // End of variables declaration//GEN-END:variables
}
