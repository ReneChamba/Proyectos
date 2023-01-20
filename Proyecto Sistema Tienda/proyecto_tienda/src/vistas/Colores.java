
package vistas;

public class Colores extends javax.swing.JDialog {

    public Colores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_botones = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        label_titulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_estadisticas = new javax.swing.JTextField();
        txt_configuracion = new javax.swing.JTextField();
        txt_tienda = new javax.swing.JTextField();
        txt_inicio = new javax.swing.JTextField();
        txt_titulo = new javax.swing.JTextField();
        btn_restablecer_letras = new javax.swing.JButton();
        btn_guardar_cambios = new javax.swing.JButton();
        radio_buton_letras = new javax.swing.JRadioButton();
        btn_cancelar_letras = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        combo_item_padre = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        combo_item_hijos = new javax.swing.JComboBox<>();
        fondo = new javax.swing.JLabel();
        combo_fondo = new javax.swing.JComboBox<>();
        btn_apli_color = new javax.swing.JButton();
        btn_restablecer_color = new javax.swing.JButton();
        radio_buton_colores = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        combo_barra = new javax.swing.JComboBox<>();
        btn_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_titulo.setText("Configuración del Sistema");
        jPanel1.add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 300, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Configuración Nombres", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Titulo:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 30));

        jLabel3.setText("Inicio:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 100, 30));

        jLabel4.setText("Tienda:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 100, 30));

        jLabel5.setText("Cofiguración:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 100, 30));

        jLabel6.setText("Estadisticas:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 100, 30));

        txt_estadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_estadisticasActionPerformed(evt);
            }
        });
        jPanel2.add(txt_estadisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 200, 30));
        jPanel2.add(txt_configuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 200, 30));
        jPanel2.add(txt_tienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 200, 30));
        jPanel2.add(txt_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 200, 30));
        jPanel2.add(txt_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 200, 30));

        btn_restablecer_letras.setText("Predeteminados");
        btn_restablecer_letras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restablecer_letrasActionPerformed(evt);
            }
        });
        jPanel2.add(btn_restablecer_letras, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 160, 40));

        btn_guardar_cambios.setText("Aplicar  Cambios");
        jPanel2.add(btn_guardar_cambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 170, 40));

        radio_buton_letras.setText("Habilitar");
        jPanel2.add(radio_buton_letras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, -1));

        btn_cancelar_letras.setText("Cancelar");
        jPanel2.add(btn_cancelar_letras, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 150, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 520, 350));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Configuración Colores", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Color Menus:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 170, 30));

        jPanel3.add(combo_item_padre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 200, 30));

        jLabel8.setText("Color Submenús:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 170, 30));

        jPanel3.add(combo_item_hijos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 200, 30));

        fondo.setText("Color Fondo:");
        jPanel3.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 170, 30));

        jPanel3.add(combo_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 200, 30));

        btn_apli_color.setText("Aplicar Cambios");
        jPanel3.add(btn_apli_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 170, 40));

        btn_restablecer_color.setText("Predeterminados");
        jPanel3.add(btn_restablecer_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 170, 40));

        radio_buton_colores.setText("Habilitar");
        jPanel3.add(radio_buton_colores, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 30));

        jLabel9.setText("Color Barra Menú");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 170, 30));

        jPanel3.add(combo_barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 200, 30));

        btn_cancelar.setText("Cancelar");
        jPanel3.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 150, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 520, 350));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_estadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_estadisticasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_estadisticasActionPerformed

    private void btn_restablecer_letrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restablecer_letrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_restablecer_letrasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_apli_color;
    public javax.swing.JButton btn_cancelar;
    public javax.swing.JButton btn_cancelar_letras;
    public javax.swing.JButton btn_guardar_cambios;
    public javax.swing.JButton btn_restablecer_color;
    public javax.swing.JButton btn_restablecer_letras;
    public javax.swing.JComboBox<String> combo_barra;
    public javax.swing.JComboBox<String> combo_fondo;
    public javax.swing.JComboBox<String> combo_item_hijos;
    public javax.swing.JComboBox<String> combo_item_padre;
    public javax.swing.JLabel fondo;
    public javax.swing.ButtonGroup grupo_botones;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel label_titulo;
    public javax.swing.JRadioButton radio_buton_colores;
    public javax.swing.JRadioButton radio_buton_letras;
    public javax.swing.JTextField txt_configuracion;
    public javax.swing.JTextField txt_estadisticas;
    public javax.swing.JTextField txt_inicio;
    public javax.swing.JTextField txt_tienda;
    public javax.swing.JTextField txt_titulo;
    // End of variables declaration//GEN-END:variables
}
