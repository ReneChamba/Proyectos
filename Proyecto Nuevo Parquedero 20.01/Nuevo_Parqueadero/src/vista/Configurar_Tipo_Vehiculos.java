
package vista;


public class Configurar_Tipo_Vehiculos extends javax.swing.JDialog {

    public Configurar_Tipo_Vehiculos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_titulo = new javax.swing.JLabel();
        lb_codigo = new javax.swing.JLabel();
        lb_tipo_vehiculo = new javax.swing.JLabel();
        lb_name_precio = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        combo_tipo = new javax.swing.JComboBox<>();
        txt_precio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btn_agregar = new javax.swing.JButton();
        txt_nombre_vehiculo = new javax.swing.JTextField();
        lb_nombre_vehi = new javax.swing.JLabel();
        lb_precio = new javax.swing.JLabel();
        lb_name_cantidad = new javax.swing.JLabel();
        lb_cantidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_titulo.setText("Configurar Vehículos");
        jPanel1.add(lb_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 250, 25));

        lb_codigo.setText("Código:");
        jPanel1.add(lb_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 80, 120, 30));

        lb_tipo_vehiculo.setText("Tipo_Vehículo:");
        jPanel1.add(lb_tipo_vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 130, 120, 30));

        lb_name_precio.setText("Precio:");
        jPanel1.add(lb_name_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 180, 90, 30));
        jPanel1.add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 84, 30));

        jPanel1.add(combo_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 250, 30));
        jPanel1.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 90, 30));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.setRowHeight(30);
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 450, 210));

        btn_agregar.setText("Nuevo");
        jPanel1.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 100, 30));
        jPanel1.add(txt_nombre_vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 250, 30));

        lb_nombre_vehi.setText("Obligatorio");
        jPanel1.add(lb_nombre_vehi, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 161, 110, -1));

        lb_precio.setText("Obligatorio");
        jPanel1.add(lb_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 212, 110, -1));

        lb_name_cantidad.setText("# Tipos de Vehículos:");
        jPanel1.add(lb_name_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 466, 160, 30));

        lb_cantidad.setText("0.00");
        jPanel1.add(lb_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 466, 70, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_agregar;
    public javax.swing.JComboBox<String> combo_tipo;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lb_cantidad;
    public javax.swing.JLabel lb_codigo;
    public javax.swing.JLabel lb_name_cantidad;
    public javax.swing.JLabel lb_name_precio;
    public javax.swing.JLabel lb_nombre_vehi;
    public javax.swing.JLabel lb_precio;
    public javax.swing.JLabel lb_tipo_vehiculo;
    public javax.swing.JLabel lb_titulo;
    public javax.swing.JTable tabla;
    public javax.swing.JTextField txt_codigo;
    public javax.swing.JTextField txt_nombre_vehiculo;
    public javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
