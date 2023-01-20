package vistas;

public class Vender_Producto extends javax.swing.JDialog {

    public Vender_Producto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_buscar_produto = new javax.swing.JLabel();
        txt_producto = new javax.swing.JTextField();
        label_nombre_total = new javax.swing.JLabel();
        label_productos_registrados = new javax.swing.JLabel();
        label_nombre_produc_regi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_ventas_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_lista_agregados = new javax.swing.JTable();
        label_mostrar_total_cobrar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_cobrar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_credito = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        label_cliente = new javax.swing.JLabel();
        label_cedula = new javax.swing.JLabel();
        label_saldo = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        label_saldo_pendiente = new javax.swing.JLabel();
        btn_elegir_cliente = new javax.swing.JButton();
        label_telefono = new javax.swing.JLabel();
        txt_cliente = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        btn_limpiar = new javax.swing.JButton();
        label_titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_buscar_produto.setText("Buscar Producto:");
        jPanel1.add(label_buscar_produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 140, 30));
        jPanel1.add(txt_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 430, 30));

        label_nombre_total.setText("TOTAL $");
        jPanel1.add(label_nombre_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 610, 110, 30));

        label_productos_registrados.setText("NA");
        jPanel1.add(label_productos_registrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 610, 40, 30));

        label_nombre_produc_regi.setText("Cantidad Productos : ");
        jPanel1.add(label_nombre_produc_regi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 220, 30));

        tabla_ventas_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_ventas_productos.setRowHeight(25);
        jScrollPane1.setViewportView(tabla_ventas_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 1270, 200));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Lista Productos Agregados", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(30, 138, 137))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(30, 138, 137));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_lista_agregados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_lista_agregados.setRowHeight(25);
        jScrollPane2.setViewportView(tabla_lista_agregados);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 600, 200));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 620, 240));

        label_mostrar_total_cobrar.setText("0.00");
        jPanel1.add(label_mostrar_total_cobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 610, 50, 30));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Funciones", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(30, 138, 137))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_cobrar.setText("Cobrar ");
        jPanel3.add(btn_cobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 42, 175, 50));

        btn_cancelar.setText("Cancelar");
        jPanel3.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 175, 50));

        btn_credito.setText("Credito");
        jPanel3.add(btn_credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 175, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 200, 240));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Seleccionar Cliente", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(30, 138, 137))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_cliente.setText("Cliente: ");
        jPanel4.add(label_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, 30));

        label_cedula.setText("Cedula:");
        jPanel4.add(label_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, 30));

        label_saldo.setText("Saldo Pendiende $");
        jPanel4.add(label_saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 140, 30));
        jPanel4.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 90, 230, 30));

        label_saldo_pendiente.setText("0.00");
        jPanel4.add(label_saldo_pendiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 90, 30));
        jPanel4.add(btn_elegir_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 30, 80, 70));

        label_telefono.setText("Teléfono:");
        jPanel4.add(label_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 30));
        jPanel4.add(txt_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 40, 230, 30));
        jPanel4.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 140, 230, 30));
        jPanel4.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 120, 80, 50));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 350, 440, 240));

        label_titulo.setText("Formulario de Ventas");
        jPanel1.add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 310, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_cancelar;
    public javax.swing.JButton btn_cobrar;
    public javax.swing.JButton btn_credito;
    public javax.swing.JButton btn_elegir_cliente;
    public javax.swing.JButton btn_limpiar;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel label_buscar_produto;
    public javax.swing.JLabel label_cedula;
    public javax.swing.JLabel label_cliente;
    public javax.swing.JLabel label_mostrar_total_cobrar;
    public javax.swing.JLabel label_nombre_produc_regi;
    public javax.swing.JLabel label_nombre_total;
    public javax.swing.JLabel label_productos_registrados;
    public javax.swing.JLabel label_saldo;
    public javax.swing.JLabel label_saldo_pendiente;
    public javax.swing.JLabel label_telefono;
    public javax.swing.JLabel label_titulo;
    public javax.swing.JTable tabla_lista_agregados;
    public javax.swing.JTable tabla_ventas_productos;
    public javax.swing.JTextField txt_cedula;
    public javax.swing.JTextField txt_cliente;
    public javax.swing.JTextField txt_producto;
    public javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
