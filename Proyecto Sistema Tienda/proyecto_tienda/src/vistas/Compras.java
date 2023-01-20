
package vistas;

public class Compras extends javax.swing.JDialog {

    public Compras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal_compras = new javax.swing.JPanel();
        label_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_compras = new javax.swing.JTable();
        label_fecha_axiliar = new javax.swing.JLabel();
        txt_buscar_producto = new javax.swing.JTextField();
        panel_Agg_Productos = new javax.swing.JPanel();
        label_categoria = new javax.swing.JLabel();
        combo_categoria = new javax.swing.JComboBox<>();
        label_nueva_categoria = new javax.swing.JLabel();
        combo_proveedor = new javax.swing.JComboBox<>();
        label_proveedor = new javax.swing.JLabel();
        txt_producto = new javax.swing.JTextField();
        label_producto = new javax.swing.JLabel();
        label_campo_obliga_producto = new javax.swing.JLabel();
        label_cantidad = new javax.swing.JLabel();
        spiner_cantidad = new javax.swing.JSpinner();
        spiner_precio = new javax.swing.JSpinner();
        label_precio = new javax.swing.JLabel();
        label_campo_oblig_precio = new javax.swing.JLabel();
        btn_agregar_producto = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        label_egresos_compras = new javax.swing.JLabel();
        spiner_egresos_compra = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_principal_compras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_titulo.setText("Registro De Productos");
        panel_principal_compras.add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 5, 350, 40));

        tabla_compras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_compras.setRowHeight(25);
        jScrollPane1.setViewportView(tabla_compras);

        panel_principal_compras.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 1310, 290));

        label_fecha_axiliar.setText("poner_fecha_auxiliar");
        panel_principal_compras.add(label_fecha_axiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, -1, -1));
        panel_principal_compras.add(txt_buscar_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 280, 460, 40));

        panel_Agg_Productos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 0), 2), "Registrar Productos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        panel_Agg_Productos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_categoria.setText("Categoria:");
        panel_Agg_Productos.add(label_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, 30));

        panel_Agg_Productos.add(combo_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 250, 30));

        label_nueva_categoria.setText("+ categoria");
        panel_Agg_Productos.add(label_nueva_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 100, 40));

        panel_Agg_Productos.add(combo_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 250, 30));

        label_proveedor.setText("Proveedor:");
        panel_Agg_Productos.add(label_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 70, 30));
        panel_Agg_Productos.add(txt_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 250, 30));

        label_producto.setText("Producto:");
        panel_Agg_Productos.add(label_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 80, 30));

        label_campo_obliga_producto.setText("* Campo Obligatorio");
        panel_Agg_Productos.add(label_campo_obliga_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 210, 30));

        label_cantidad.setText("Cantidad Productos:");
        panel_Agg_Productos.add(label_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 140, 30));

        spiner_cantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        panel_Agg_Productos.add(spiner_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 150, 30));

        spiner_precio.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.5d));
        panel_Agg_Productos.add(spiner_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 150, 30));

        label_precio.setText("Precio Venta  C/U:");
        panel_Agg_Productos.add(label_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 140, 30));

        label_campo_oblig_precio.setText("* Campo Obligatorio");
        panel_Agg_Productos.add(label_campo_oblig_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 170, -1));

        btn_agregar_producto.setText("Agregar Producto");
        panel_Agg_Productos.add(btn_agregar_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 250, 50));

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        panel_Agg_Productos.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, 250, 50));

        label_egresos_compras.setText("Egresos X Compra:");
        panel_Agg_Productos.add(label_egresos_compras, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 140, 30));

        spiner_egresos_compra.setModel(new javax.swing.SpinnerNumberModel(1.0d, 1.0d, null, 0.5d));
        panel_Agg_Productos.add(spiner_egresos_compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 150, 30));

        panel_principal_compras.add(panel_Agg_Productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 43, 1310, 230));

        getContentPane().add(panel_principal_compras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cancelarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_agregar_producto;
    public javax.swing.JButton btn_cancelar;
    public javax.swing.JComboBox<String> combo_categoria;
    public javax.swing.JComboBox<String> combo_proveedor;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel label_campo_oblig_precio;
    public javax.swing.JLabel label_campo_obliga_producto;
    public javax.swing.JLabel label_cantidad;
    public javax.swing.JLabel label_categoria;
    public javax.swing.JLabel label_egresos_compras;
    public javax.swing.JLabel label_fecha_axiliar;
    public javax.swing.JLabel label_nueva_categoria;
    public javax.swing.JLabel label_precio;
    public javax.swing.JLabel label_producto;
    public javax.swing.JLabel label_proveedor;
    public javax.swing.JLabel label_titulo;
    public javax.swing.JPanel panel_Agg_Productos;
    public javax.swing.JPanel panel_principal_compras;
    public javax.swing.JSpinner spiner_cantidad;
    public javax.swing.JSpinner spiner_egresos_compra;
    public javax.swing.JSpinner spiner_precio;
    public javax.swing.JTable tabla_compras;
    public javax.swing.JTextField txt_buscar_producto;
    public javax.swing.JTextField txt_producto;
    // End of variables declaration//GEN-END:variables
}
