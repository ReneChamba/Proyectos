
package vista;


public class Retirar_Vehiculo extends javax.swing.JDialog {

    public Retirar_Vehiculo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_titulo = new javax.swing.JLabel();
        panel_valores = new javax.swing.JPanel();
        lb_name_motivo = new javax.swing.JLabel();
        lb_motivo = new javax.swing.JLabel();
        lb_name_lavado = new javax.swing.JLabel();
        lb_name_parqueo = new javax.swing.JLabel();
        lb_total_lavado = new javax.swing.JLabel();
        lb_total_parqueo = new javax.swing.JLabel();
        txt_cobrar = new javax.swing.JTextField();
        lb_tota_horas = new javax.swing.JLabel();
        txt_horas = new javax.swing.JTextField();
        lb_tot_minu = new javax.swing.JLabel();
        txt_minutos = new javax.swing.JTextField();
        btn_cobrar = new javax.swing.JButton();
        panel_datos = new javax.swing.JPanel();
        lb_placa = new javax.swing.JLabel();
        txt_buscar_placa = new javax.swing.JTextField();
        lb_propietario = new javax.swing.JLabel();
        txt_propietario = new javax.swing.JTextField();
        lb_tipo_vhiculo = new javax.swing.JLabel();
        txt_tipo = new javax.swing.JTextField();
        lb_fe_ingreso = new javax.swing.JLabel();
        txt_fecha_ingreso = new javax.swing.JTextField();
        lb_fe_salida = new javax.swing.JLabel();
        txt_fecha_salida = new javax.swing.JTextField();
        btn_limpiar = new javax.swing.JButton();
        lb_costo = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_titulo.setText("Retirar Vehículo");
        jPanel1.add(lb_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 6, 340, 40));

        panel_valores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_name_motivo.setText("Motivo:");
        panel_valores.add(lb_name_motivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 80, 30));

        lb_motivo.setText("Ninguna");
        panel_valores.add(lb_motivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 180, 30));

        lb_name_lavado.setText("Lavado:");
        panel_valores.add(lb_name_lavado, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, 80, 30));

        lb_name_parqueo.setText("Parqueo:");
        panel_valores.add(lb_name_parqueo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, 80, 30));

        lb_total_lavado.setText("0");
        panel_valores.add(lb_total_lavado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 160, 30));

        lb_total_parqueo.setText("0");
        panel_valores.add(lb_total_parqueo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 110, 30));

        txt_cobrar.setText("0.00");
        panel_valores.add(txt_cobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 110, 35));

        lb_tota_horas.setText("H :");
        panel_valores.add(lb_tota_horas, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 30, 30));
        panel_valores.add(txt_horas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 60, 30));

        lb_tot_minu.setText("Min :");
        panel_valores.add(lb_tot_minu, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 50, 30));
        panel_valores.add(txt_minutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 70, 30));

        btn_cobrar.setText("Cobrar Parqueadero");
        panel_valores.add(btn_cobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 210, 40));

        jPanel1.add(panel_valores, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 325, 590, 180));

        panel_datos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_placa.setText("Placa :");
        panel_datos.add(lb_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 30));
        panel_datos.add(txt_buscar_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 270, 30));

        lb_propietario.setText("Propietario:");
        panel_datos.add(lb_propietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, 30));
        panel_datos.add(txt_propietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 270, 30));

        lb_tipo_vhiculo.setText("Tipo :");
        panel_datos.add(lb_tipo_vhiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 100, 30));
        panel_datos.add(txt_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 270, 30));

        lb_fe_ingreso.setText("Fe_Ingreso :");
        panel_datos.add(lb_fe_ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 100, 30));

        txt_fecha_ingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fecha_ingresoActionPerformed(evt);
            }
        });
        panel_datos.add(txt_fecha_ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 270, 30));

        lb_fe_salida.setText("Fe_Salida :");
        panel_datos.add(lb_fe_salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 100, 30));
        panel_datos.add(txt_fecha_salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 270, 30));

        btn_limpiar.setText("Nuevo");
        panel_datos.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 110, 30));

        lb_costo.setText("Costo :");
        panel_datos.add(lb_costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 70, 30));
        panel_datos.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 120, 70, 30));

        jPanel1.add(panel_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 590, 270));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_fecha_ingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fecha_ingresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fecha_ingresoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_cobrar;
    public javax.swing.JButton btn_limpiar;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lb_costo;
    public javax.swing.JLabel lb_fe_ingreso;
    public javax.swing.JLabel lb_fe_salida;
    public javax.swing.JLabel lb_motivo;
    public javax.swing.JLabel lb_name_lavado;
    public javax.swing.JLabel lb_name_motivo;
    public javax.swing.JLabel lb_name_parqueo;
    public javax.swing.JLabel lb_placa;
    public javax.swing.JLabel lb_propietario;
    public javax.swing.JLabel lb_tipo_vhiculo;
    public javax.swing.JLabel lb_titulo;
    public javax.swing.JLabel lb_tot_minu;
    public javax.swing.JLabel lb_tota_horas;
    public javax.swing.JLabel lb_total_lavado;
    public javax.swing.JLabel lb_total_parqueo;
    public javax.swing.JPanel panel_datos;
    public javax.swing.JPanel panel_valores;
    public javax.swing.JTextField txt_buscar_placa;
    public javax.swing.JTextField txt_cobrar;
    public javax.swing.JTextField txt_fecha_ingreso;
    public javax.swing.JTextField txt_fecha_salida;
    public javax.swing.JTextField txt_horas;
    public javax.swing.JTextField txt_minutos;
    public javax.swing.JTextField txt_precio;
    public javax.swing.JTextField txt_propietario;
    public javax.swing.JTextField txt_tipo;
    // End of variables declaration//GEN-END:variables
}
