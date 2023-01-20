package vista;

public class Reportes extends javax.swing.JDialog {

    public Reportes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        combo_parametros = new javax.swing.JComboBox<>();
        btn_generar_rpt = new javax.swing.JButton();
        panelFecha = new javax.swing.JPanel();
        calendario_inicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        calendario_final = new com.toedter.calendar.JDateChooser();
        check_fecha = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_titulo.setText("Generar  Reportes");
        jPanel1.add(lb_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 216, 36));

        jLabel2.setText("Seleccionar  Parámetro:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 100, 180, 30));

        combo_parametros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vehículos Ingresados", "Vehículos Retirados Parqueo", "Vehículos Retirados Lavado", "Vehículos Retirados Parqueo + Lavado", "Tipo Vehículos", "Cuentas Usuarios" }));
        jPanel1.add(combo_parametros, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 100, 240, 30));

        btn_generar_rpt.setText("Generar Reporte");
        jPanel1.add(btn_generar_rpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 361, 254, 59));

        panelFecha.setToolTipText("<html>\n<head>\n</head>\n<body>\n       <p> habilita el control</p>\n\n</body>\n</html>");

        calendario_inicio.setToolTipText("");

        jLabel3.setText("Fecha Inicio:");

        jLabel4.setText("Fecha Final:");

        check_fecha.setText("Habilitar busqueda");

        javax.swing.GroupLayout panelFechaLayout = new javax.swing.GroupLayout(panelFecha);
        panelFecha.setLayout(panelFechaLayout);
        panelFechaLayout.setHorizontalGroup(
            panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(calendario_final, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(calendario_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(panelFechaLayout.createSequentialGroup()
                .addComponent(check_fecha)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelFechaLayout.setVerticalGroup(
            panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check_fecha)
                .addGap(16, 16, 16)
                .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calendario_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calendario_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel1.add(panelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 148, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_generar_rpt;
    public com.toedter.calendar.JDateChooser calendario_final;
    public com.toedter.calendar.JDateChooser calendario_inicio;
    public javax.swing.JCheckBox check_fecha;
    public javax.swing.JComboBox<String> combo_parametros;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lb_titulo;
    public javax.swing.JPanel panelFecha;
    // End of variables declaration//GEN-END:variables
}
