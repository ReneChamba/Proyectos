package vista;

public class Exportar_Base extends javax.swing.JDialog {

    public Exportar_Base(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_titulo = new javax.swing.JLabel();
        txt_ruta = new javax.swing.JTextField();
        btn_seleccion_ruta = new javax.swing.JButton();
        btn_guardar_base = new javax.swing.JButton();
        ch_Tabla_usuarios = new javax.swing.JCheckBox();
        ch_Tabla_tipo_vehiculo = new javax.swing.JCheckBox();
        ch_Tabla_conf_sistema = new javax.swing.JCheckBox();
        ch_Tabla_veh_ingresados = new javax.swing.JCheckBox();
        ch_Tabla_vehi_retirados = new javax.swing.JCheckBox();
        ch_Tabla_name_funciones = new javax.swing.JCheckBox();
        ch_Tabla_colores = new javax.swing.JCheckBox();
        btn_habilitar = new javax.swing.JButton();
        num_tablas = new javax.swing.JLabel();
        lb_name_tablas = new javax.swing.JLabel();
        check_tabla_lavado = new javax.swing.JCheckBox();
        check_tabla_parqueo_mas_lavado = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_titulo.setText("Respaldar Información");
        jPanel1.add(lb_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 300, 30));

        txt_ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rutaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_ruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 336, 40));
        jPanel1.add(btn_seleccion_ruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 70, 40));

        btn_guardar_base.setText("Generar Respaldo");
        jPanel1.add(btn_guardar_base, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 453, 269, 47));

        ch_Tabla_usuarios.setText("Tabla Usuarios ");
        jPanel1.add(ch_Tabla_usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 250, 30));

        ch_Tabla_tipo_vehiculo.setText("Tabla Tipo Vehículos");
        jPanel1.add(ch_Tabla_tipo_vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 250, 30));

        ch_Tabla_conf_sistema.setText("Tabla Configuración Sistema");
        jPanel1.add(ch_Tabla_conf_sistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 250, 30));

        ch_Tabla_veh_ingresados.setText("Tabla Vehículos Ingresados");
        jPanel1.add(ch_Tabla_veh_ingresados, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 250, 30));

        ch_Tabla_vehi_retirados.setText("Tabla Vehículos Retirados Parqueo");
        jPanel1.add(ch_Tabla_vehi_retirados, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 340, 30));

        ch_Tabla_name_funciones.setText("Tabla Colores  Funciones");
        jPanel1.add(ch_Tabla_name_funciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 250, 30));

        ch_Tabla_colores.setText("Tabla Colores");
        jPanel1.add(ch_Tabla_colores, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 250, 30));

        btn_habilitar.setText("Seleccionar Todo");
        jPanel1.add(btn_habilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 170, -1));

        num_tablas.setText("0");
        jPanel1.add(num_tablas, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 405, 60, 31));

        lb_name_tablas.setText(" Número de tablas selecciondas:");
        jPanel1.add(lb_name_tablas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 320, 40));

        check_tabla_lavado.setText("Tabla Vehículos Retirados Lavado");
        jPanel1.add(check_tabla_lavado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, 30));

        check_tabla_parqueo_mas_lavado.setText("Tabla Vehículos Retirados Parqueo + Lavado");
        jPanel1.add(check_tabla_parqueo_mas_lavado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 360, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rutaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_guardar_base;
    public javax.swing.JButton btn_habilitar;
    public javax.swing.JButton btn_seleccion_ruta;
    public javax.swing.JCheckBox ch_Tabla_colores;
    public javax.swing.JCheckBox ch_Tabla_conf_sistema;
    public javax.swing.JCheckBox ch_Tabla_name_funciones;
    public javax.swing.JCheckBox ch_Tabla_tipo_vehiculo;
    public javax.swing.JCheckBox ch_Tabla_usuarios;
    public javax.swing.JCheckBox ch_Tabla_veh_ingresados;
    public javax.swing.JCheckBox ch_Tabla_vehi_retirados;
    public javax.swing.JCheckBox check_tabla_lavado;
    public javax.swing.JCheckBox check_tabla_parqueo_mas_lavado;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lb_name_tablas;
    public javax.swing.JLabel lb_titulo;
    public javax.swing.JLabel num_tablas;
    public javax.swing.JTextField txt_ruta;
    // End of variables declaration//GEN-END:variables
}
