package vistas;
import javax.swing.JDialog;

public class Detalle_Venta extends javax.swing.JDialog {

    public Detalle_Venta(JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_prinicipal_detalle_venta = new javax.swing.JPanel();
        label_titulo = new javax.swing.JLabel();
        label_producto = new javax.swing.JLabel();
        label_precio_venta = new javax.swing.JLabel();
        label_codigo = new javax.swing.JLabel();
        label_nombre_disponibles = new javax.swing.JLabel();
        label_disponibles = new javax.swing.JLabel();
        txt_producto_detalle_venta = new javax.swing.JTextField();
        label_codigo_producto = new javax.swing.JLabel();
        label_cantidad = new javax.swing.JLabel();
        spiner_cantidad = new javax.swing.JSpinner();
        btn_agregar_lista = new javax.swing.JButton();
        txt_precio_venta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        label_codigo_proveedor = new javax.swing.JLabel();
        label_total = new javax.swing.JLabel();
        btn_cobrar_detalle_venta = new javax.swing.JButton();
        label_nombre_total = new javax.swing.JLabel();
        label_simbolo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_prinicipal_detalle_venta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_titulo.setText("Detalle De  Venta");
        panel_prinicipal_detalle_venta.add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 470, 40));

        label_producto.setText("Producto:");
        panel_prinicipal_detalle_venta.add(label_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, 30));

        label_precio_venta.setText("Precio de Venta :");
        panel_prinicipal_detalle_venta.add(label_precio_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 130, 30));

        label_codigo.setText("Codigo Producto:");
        panel_prinicipal_detalle_venta.add(label_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, 30));

        label_nombre_disponibles.setText("Disponibles # ");
        panel_prinicipal_detalle_venta.add(label_nombre_disponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 100, 30));

        label_disponibles.setText("0");
        panel_prinicipal_detalle_venta.add(label_disponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 40, 30));
        panel_prinicipal_detalle_venta.add(txt_producto_detalle_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 150, 30));

        label_codigo_producto.setText("codigo");
        panel_prinicipal_detalle_venta.add(label_codigo_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 150, 30));

        label_cantidad.setText("Cantidad:");
        panel_prinicipal_detalle_venta.add(label_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 100, 30));

        spiner_cantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        panel_prinicipal_detalle_venta.add(spiner_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 150, 30));

        btn_agregar_lista.setText("Agregar");
        panel_prinicipal_detalle_venta.add(btn_agregar_lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 160, 40));
        panel_prinicipal_detalle_venta.add(txt_precio_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 150, 30));
        panel_prinicipal_detalle_venta.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 100, -1));

        label_codigo_proveedor.setText("codigo_proveddor");
        panel_prinicipal_detalle_venta.add(label_codigo_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 70, 30));

        label_total.setText("total");
        panel_prinicipal_detalle_venta.add(label_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 60, 40));

        btn_cobrar_detalle_venta.setText("Cobrar");
        panel_prinicipal_detalle_venta.add(btn_cobrar_detalle_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 160, 40));

        label_nombre_total.setText("Total:");
        panel_prinicipal_detalle_venta.add(label_nombre_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 100, 30));

        label_simbolo.setText("$");
        panel_prinicipal_detalle_venta.add(label_simbolo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 20, 40));

        getContentPane().add(panel_prinicipal_detalle_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_agregar_lista;
    public javax.swing.JButton btn_cobrar_detalle_venta;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JLabel label_cantidad;
    public javax.swing.JLabel label_codigo;
    public javax.swing.JLabel label_codigo_producto;
    public javax.swing.JLabel label_codigo_proveedor;
    public javax.swing.JLabel label_disponibles;
    public javax.swing.JLabel label_nombre_disponibles;
    public javax.swing.JLabel label_nombre_total;
    public javax.swing.JLabel label_precio_venta;
    public javax.swing.JLabel label_producto;
    public javax.swing.JLabel label_simbolo;
    public javax.swing.JLabel label_titulo;
    public javax.swing.JLabel label_total;
    public javax.swing.JPanel panel_prinicipal_detalle_venta;
    public javax.swing.JSpinner spiner_cantidad;
    public javax.swing.JTextField txt_precio_venta;
    public javax.swing.JTextField txt_producto_detalle_venta;
    // End of variables declaration//GEN-END:variables
}
