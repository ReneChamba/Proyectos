package vista;

public class Listar_Vehiculos_Retirados extends javax.swing.JDialog {

    public Listar_Vehiculos_Retirados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panel_botones = new javax.swing.JPanel();
        btn_parqueo = new javax.swing.JButton();
        btn_lavado = new javax.swing.JButton();
        btn_lavado_mas_parqueo = new javax.swing.JButton();
        panel_funciones = new javax.swing.JPanel();
        lb_fec_inicial = new javax.swing.JLabel();
        lb_fec_final = new javax.swing.JLabel();
        calendario_inicio = new com.toedter.calendar.JDateChooser();
        calendario_final = new com.toedter.calendar.JDateChooser();
        btn_filtrar = new javax.swing.JButton();
        btn_reiniciar = new javax.swing.JButton();
        lb_name_registros = new javax.swing.JLabel();
        lb_poner_numero = new javax.swing.JLabel();
        lb_name_dolares = new javax.swing.JLabel();
        lb_dolares = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_titulo.setText("Registro Vehículos Retirados");
        jPanel1.add(lb_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 340, 30));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.setRowHeight(28);
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1100, 300));

        panel_botones.setLayout(new java.awt.GridLayout(1, 3));

        btn_parqueo.setText("Parqueo ");
        panel_botones.add(btn_parqueo);

        btn_lavado.setText("Lavado");
        btn_lavado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lavadoActionPerformed(evt);
            }
        });
        panel_botones.add(btn_lavado);

        btn_lavado_mas_parqueo.setText("Lavado + Parqueo");
        btn_lavado_mas_parqueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lavado_mas_parqueoActionPerformed(evt);
            }
        });
        panel_botones.add(btn_lavado_mas_parqueo);

        jPanel1.add(panel_botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 87, 420, 48));

        panel_funciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_fec_inicial.setText("Fecha Inicio");
        panel_funciones.add(lb_fec_inicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 167, 30));

        lb_fec_final.setText("Fecha Final");
        panel_funciones.add(lb_fec_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 161, 30));
        panel_funciones.add(calendario_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 235, 48));
        panel_funciones.add(calendario_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 235, 48));

        btn_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtrarActionPerformed(evt);
            }
        });
        panel_funciones.add(btn_filtrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 80, 48));

        btn_reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reiniciarActionPerformed(evt);
            }
        });
        panel_funciones.add(btn_reiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 80, 48));

        jPanel1.add(panel_funciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1100, 110));

        lb_name_registros.setText("# Registros:");
        jPanel1.add(lb_name_registros, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 120, 30));

        lb_poner_numero.setText("0.0");
        jPanel1.add(lb_poner_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 170, 30));

        lb_name_dolares.setText("$ Dolares: ");
        jPanel1.add(lb_name_dolares, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 90, 30));

        lb_dolares.setText("0.00");
        jPanel1.add(lb_dolares, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 470, 100, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_filtrarActionPerformed

    private void btn_lavadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lavadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_lavadoActionPerformed

    private void btn_lavado_mas_parqueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lavado_mas_parqueoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_lavado_mas_parqueoActionPerformed

    private void btn_reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reiniciarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_reiniciarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_filtrar;
    public javax.swing.JButton btn_lavado;
    public javax.swing.JButton btn_lavado_mas_parqueo;
    public javax.swing.JButton btn_parqueo;
    public javax.swing.JButton btn_reiniciar;
    public com.toedter.calendar.JDateChooser calendario_final;
    public com.toedter.calendar.JDateChooser calendario_inicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lb_dolares;
    private javax.swing.JLabel lb_fec_final;
    private javax.swing.JLabel lb_fec_inicial;
    public javax.swing.JLabel lb_name_dolares;
    public javax.swing.JLabel lb_name_registros;
    public javax.swing.JLabel lb_poner_numero;
    public javax.swing.JLabel lb_titulo;
    public javax.swing.JPanel panel_botones;
    public javax.swing.JPanel panel_funciones;
    public javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
