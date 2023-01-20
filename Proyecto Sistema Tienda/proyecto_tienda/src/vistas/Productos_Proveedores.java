package vistas;

import javax.swing.JDialog;

public class Productos_Proveedores extends javax.swing.JDialog {

    public Productos_Proveedores(JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_productos_proveedores = new javax.swing.JTable();
        label_titulo = new javax.swing.JLabel();
        label_nombre_proveedor = new javax.swing.JLabel();
        label_codigo = new javax.swing.JLabel();
        txt_nombre_proveedor = new javax.swing.JTextField();
        txt_codigo_proveedor = new javax.swing.JTextField();
        label_empresa = new javax.swing.JLabel();
        txt_empresa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 160, 350, 30));

        tabla_productos_proveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_productos_proveedores.setRowHeight(28);
        jScrollPane1.setViewportView(tabla_productos_proveedores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 1160, 210));

        label_titulo.setText("Productos Registrados");
        getContentPane().add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 350, -1));

        label_nombre_proveedor.setText("Nombre Proveedor:");
        getContentPane().add(label_nombre_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 150, 30));

        label_codigo.setText("Codigo:");
        getContentPane().add(label_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 150, 30));
        getContentPane().add(txt_nombre_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 260, 30));
        getContentPane().add(txt_codigo_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 260, 30));

        label_empresa.setText("Distribuidora: ");
        getContentPane().add(label_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 150, 30));
        getContentPane().add(txt_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 260, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel label_codigo;
    public javax.swing.JLabel label_empresa;
    public javax.swing.JLabel label_nombre_proveedor;
    public javax.swing.JLabel label_titulo;
    public javax.swing.JTable tabla_productos_proveedores;
    public javax.swing.JTextField txt_buscar;
    public javax.swing.JTextField txt_codigo_proveedor;
    public javax.swing.JTextField txt_empresa;
    public javax.swing.JTextField txt_nombre_proveedor;
    // End of variables declaration//GEN-END:variables
}
