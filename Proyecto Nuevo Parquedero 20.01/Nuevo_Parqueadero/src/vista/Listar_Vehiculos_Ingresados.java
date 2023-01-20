
package vista;

public class Listar_Vehiculos_Ingresados extends javax.swing.JDialog {

    public Listar_Vehiculos_Ingresados(java.awt.Frame parent, boolean modal) {
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
        lb_name_registros = new javax.swing.JLabel();
        lb_poner_numero = new javax.swing.JLabel();
        panel_funciones = new javax.swing.JPanel();
        lb_fec_inicial = new javax.swing.JLabel();
        lb_fec_final = new javax.swing.JLabel();
        calendario_inicio = new com.toedter.calendar.JDateChooser();
        calendario_final = new com.toedter.calendar.JDateChooser();
        btn_filtrar = new javax.swing.JButton();
        btn_reiniciar = new javax.swing.JButton();
        txt_listar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_titulo.setText("Vehículos Ingresados Actualmente");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.setRowHeight(30);
        jScrollPane1.setViewportView(tabla);

        lb_name_registros.setText("# Registros:");

        lb_poner_numero.setText("0.0");

        panel_funciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_fec_inicial.setText("Fecha Inicio");
        panel_funciones.add(lb_fec_inicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 21, 167, 30));

        lb_fec_final.setText("Fecha Final");
        panel_funciones.add(lb_fec_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 161, 30));
        panel_funciones.add(calendario_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 250, 48));
        panel_funciones.add(calendario_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 250, 48));

        btn_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtrarActionPerformed(evt);
            }
        });
        panel_funciones.add(btn_filtrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 80, 48));
        panel_funciones.add(btn_reiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 80, 48));
        panel_funciones.add(txt_listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, 510, 48));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(331, 331, 331))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_name_registros, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_poner_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 922, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(panel_funciones, javax.swing.GroupLayout.DEFAULT_SIZE, 1254, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lb_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_funciones, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_name_registros, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_poner_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_filtrarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_filtrar;
    public javax.swing.JButton btn_reiniciar;
    public com.toedter.calendar.JDateChooser calendario_final;
    public com.toedter.calendar.JDateChooser calendario_inicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_fec_final;
    private javax.swing.JLabel lb_fec_inicial;
    public javax.swing.JLabel lb_name_registros;
    public javax.swing.JLabel lb_poner_numero;
    public javax.swing.JLabel lb_titulo;
    public javax.swing.JPanel panel_funciones;
    public javax.swing.JTable tabla;
    public javax.swing.JTextField txt_listar;
    // End of variables declaration//GEN-END:variables
}
