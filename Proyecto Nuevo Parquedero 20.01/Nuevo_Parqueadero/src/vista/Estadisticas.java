package vista;

public class Estadisticas extends javax.swing.JDialog {

    public Estadisticas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel_gesti_grafico = new javax.swing.JPanel();
        label_parametrpo = new javax.swing.JLabel();
        combo_parametro = new javax.swing.JComboBox<>();
        label_tipo = new javax.swing.JLabel();
        combo_tipo = new javax.swing.JComboBox<>();
        combo_modelo = new javax.swing.JComboBox<>();
        label_modelo = new javax.swing.JLabel();
        combo_Horientacion = new javax.swing.JComboBox<>();
        check_habil_panel = new javax.swing.JCheckBox();
        panel_bus_fecha = new javax.swing.JPanel();
        label_fecha_inicio = new javax.swing.JLabel();
        label_fecha_final = new javax.swing.JLabel();
        calendario_Inicio = new com.toedter.calendar.JDateChooser();
        calendario_final = new com.toedter.calendar.JDateChooser();
        btn_generar_grafico = new javax.swing.JButton();
        frame_interno = new javax.swing.JInternalFrame();
        label_titulo = new javax.swing.JLabel();
        btn_verPantallaCompleta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_gesti_grafico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_parametrpo.setText("Parámetro:");
        panel_gesti_grafico.add(label_parametrpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 90, 30));

        combo_parametro.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        combo_parametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vehículos Ingresados Actualmente", "Vehículos Retirados Parqueo", "Vehículos Retirados Lavado", "Vehículos Retirados Parqueo + Lavado" }));
        panel_gesti_grafico.add(combo_parametro, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 290, 40));

        label_tipo.setText("Tipo:");
        panel_gesti_grafico.add(label_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        combo_tipo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        combo_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gráfico Pastel", "Gráfico Barra" }));
        combo_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tipoActionPerformed(evt);
            }
        });
        panel_gesti_grafico.add(combo_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 200, 40));

        combo_modelo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        combo_modelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "3D" }));
        combo_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_modeloActionPerformed(evt);
            }
        });
        panel_gesti_grafico.add(combo_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 200, 40));

        label_modelo.setText("Modelo:");
        panel_gesti_grafico.add(label_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 80, 30));

        combo_Horientacion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        combo_Horientacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horizontal", "Vertical" }));
        combo_Horientacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_gesti_grafico.add(combo_Horientacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 200, 40));

        check_habil_panel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        check_habil_panel.setText("Habilitar Busqueda  Por Fecha");
        check_habil_panel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_habil_panelActionPerformed(evt);
            }
        });
        panel_gesti_grafico.add(check_habil_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 270, -1));

        panel_bus_fecha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_fecha_inicio.setText("Fecha Inicio:");
        panel_bus_fecha.add(label_fecha_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 30));

        label_fecha_final.setText("Fecha Final:");
        panel_bus_fecha.add(label_fecha_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 100, 30));

        calendario_Inicio.setDateFormatString("yyyy/MM/dd ");
        panel_bus_fecha.add(calendario_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 250, 30));

        calendario_final.setDateFormatString("yyyy/MM/dd ");
        panel_bus_fecha.add(calendario_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 250, 30));

        panel_gesti_grafico.add(panel_bus_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 400, 140));

        btn_generar_grafico.setText("Generar Gráfico");
        btn_generar_grafico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_generar_graficoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_generar_graficoMouseExited(evt);
            }
        });
        btn_generar_grafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generar_graficoActionPerformed(evt);
            }
        });
        panel_gesti_grafico.add(btn_generar_grafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 190, 40));

        jPanel1.add(panel_gesti_grafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 423, 430));

        frame_interno.setVisible(true);

        javax.swing.GroupLayout frame_internoLayout = new javax.swing.GroupLayout(frame_interno.getContentPane());
        frame_interno.getContentPane().setLayout(frame_internoLayout);
        frame_internoLayout.setHorizontalGroup(
            frame_internoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 838, Short.MAX_VALUE)
        );
        frame_internoLayout.setVerticalGroup(
            frame_internoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        jPanel1.add(frame_interno, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 840, 430));

        label_titulo.setText("Formulario Estadísticas");
        jPanel1.add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 340, 30));

        btn_verPantallaCompleta.setText("Ver Pantalla Completa ");
        jPanel1.add(btn_verPantallaCompleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1063, 35, 250, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 510));
        jPanel1.getAccessibleContext().setAccessibleParent(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tipoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_combo_tipoActionPerformed

    private void combo_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_modeloActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_combo_modeloActionPerformed

    private void check_habil_panelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_habil_panelActionPerformed


    }//GEN-LAST:event_check_habil_panelActionPerformed

    private void btn_generar_graficoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_generar_graficoMouseEntered
        // TODO add your handling code here:


    }//GEN-LAST:event_btn_generar_graficoMouseEntered

    private void btn_generar_graficoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_generar_graficoMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_generar_graficoMouseExited

    private void btn_generar_graficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generar_graficoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_generar_graficoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_generar_grafico;
    public javax.swing.JButton btn_verPantallaCompleta;
    public com.toedter.calendar.JDateChooser calendario_Inicio;
    public com.toedter.calendar.JDateChooser calendario_final;
    public javax.swing.JCheckBox check_habil_panel;
    public javax.swing.JComboBox<String> combo_Horientacion;
    public javax.swing.JComboBox<String> combo_modelo;
    public javax.swing.JComboBox<String> combo_parametro;
    public javax.swing.JComboBox<String> combo_tipo;
    public javax.swing.JInternalFrame frame_interno;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel label_fecha_final;
    public javax.swing.JLabel label_fecha_inicio;
    public javax.swing.JLabel label_modelo;
    public javax.swing.JLabel label_parametrpo;
    public javax.swing.JLabel label_tipo;
    public javax.swing.JLabel label_titulo;
    public javax.swing.JPanel panel_bus_fecha;
    public javax.swing.JPanel panel_gesti_grafico;
    // End of variables declaration//GEN-END:variables
}
