
package vistas;
import javax.swing.JDialog;

public class Clientes extends javax.swing.JDialog {

   
    public Clientes(JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        label_seleccionar_cliente = new javax.swing.JLabel();
        txt_buscar_cliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_clientes = new javax.swing.JTable();
        panel_funciones = new javax.swing.JPanel();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label_codigo = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        btn_generar_codigo = new javax.swing.JButton();
        label_nombre_cliente = new javax.swing.JLabel();
        txt_nombre_cliente = new javax.swing.JTextField();
        label_cedula = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        label_telefono = new javax.swing.JLabel();
        txt_celular = new javax.swing.JTextField();
        label_nombre_saldo_pendiente = new javax.swing.JLabel();
        label_saldo_pendiente = new javax.swing.JLabel();
        label_agregar_bono = new javax.swing.JLabel();
        txt_ingresar_abono = new javax.swing.JTextField();
        check_aumentae = new javax.swing.JCheckBox();
        label_titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_seleccionar_cliente.setText("Seleccionar Cliente: ");
        panel_principal.add(label_seleccionar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 150, 30));
        panel_principal.add(txt_buscar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 370, 30));

        tabla_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_clientes.setRowHeight(28);
        jScrollPane1.setViewportView(tabla_clientes);

        panel_principal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 870, 130));

        panel_funciones.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "FUNCIONES", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(30, 138, 137))); // NOI18N
        panel_funciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_guardar.setText("Guardar Cliente");
        panel_funciones.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 210, 50));

        btn_cancelar.setText("Cancelar");
        panel_funciones.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 180, 50));

        btn_nuevo.setText("Nuevo");
        panel_funciones.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 180, 50));

        panel_principal.add(panel_funciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 840, 100));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "DATOS CLIENTES", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(30, 138, 137))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(30, 138, 137));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_codigo.setText("Codigo:");
        jPanel1.add(label_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 70, 30));
        jPanel1.add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 200, 30));

        btn_generar_codigo.setText("Generar Codigo");
        jPanel1.add(btn_generar_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 170, 30));

        label_nombre_cliente.setText("Nombre del Cliente:");
        jPanel1.add(label_nombre_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 30));
        jPanel1.add(txt_nombre_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 200, 30));

        label_cedula.setText("Cedula:");
        jPanel1.add(label_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 100, 30));
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 200, 30));

        label_telefono.setText("Telefono: ");
        jPanel1.add(label_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 30));
        jPanel1.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 200, 30));

        label_nombre_saldo_pendiente.setText("Saldo Pendiente: ");
        jPanel1.add(label_nombre_saldo_pendiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 200, 30));

        label_saldo_pendiente.setText("0.00");
        jPanel1.add(label_saldo_pendiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 70, 30));

        label_agregar_bono.setText("Agregar Abono");
        jPanel1.add(label_agregar_bono, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 130, 30));
        jPanel1.add(txt_ingresar_abono, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 130, 30));

        check_aumentae.setText("+ Aumentar");
        jPanel1.add(check_aumentae, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 110, -1));

        panel_principal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 840, 300));

        label_titulo.setText("Formulario Clientes");
        panel_principal.add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 230, -1));

        getContentPane().add(panel_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_cancelar;
    public javax.swing.JButton btn_generar_codigo;
    public javax.swing.JButton btn_guardar;
    public javax.swing.JButton btn_nuevo;
    public javax.swing.JCheckBox check_aumentae;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel label_agregar_bono;
    public javax.swing.JLabel label_cedula;
    public javax.swing.JLabel label_codigo;
    public javax.swing.JLabel label_nombre_cliente;
    public javax.swing.JLabel label_nombre_saldo_pendiente;
    public javax.swing.JLabel label_saldo_pendiente;
    public javax.swing.JLabel label_seleccionar_cliente;
    public javax.swing.JLabel label_telefono;
    public javax.swing.JLabel label_titulo;
    public javax.swing.JPanel panel_funciones;
    private javax.swing.JPanel panel_principal;
    public javax.swing.JTable tabla_clientes;
    public javax.swing.JTextField txt_buscar_cliente;
    public javax.swing.JTextField txt_cedula;
    public javax.swing.JTextField txt_celular;
    public javax.swing.JTextField txt_codigo;
    public javax.swing.JTextField txt_ingresar_abono;
    public javax.swing.JTextField txt_nombre_cliente;
    // End of variables declaration//GEN-END:variables
}
