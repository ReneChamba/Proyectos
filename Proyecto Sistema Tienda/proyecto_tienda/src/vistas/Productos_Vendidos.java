
package vistas;

public class Productos_Vendidos extends javax.swing.JDialog {

    public Productos_Vendidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        label_cantidad_productos = new javax.swing.JLabel();
        label_numero_productos = new javax.swing.JLabel();
        txt_buscar_productos_vendidos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        calendario = new com.toedter.calendar.JDateChooser();
        fecha_final = new com.toedter.calendar.JDateChooser();
        btn_filtrar_fecha = new javax.swing.JButton();
        label_inicio = new javax.swing.JLabel();
        label_final = new javax.swing.JLabel();
        btn_restablecer = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label_nombre_total = new javax.swing.JLabel();
        label_total = new javax.swing.JLabel();
        btn_saldo_cliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_nueva = new javax.swing.JTable();
        label_titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_cantidad_productos.setText("#Productos: ");
        panel_principal.add(label_cantidad_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, 100, -1));

        label_numero_productos.setText("jLabel4");
        panel_principal.add(label_numero_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 470, 80, -1));
        panel_principal.add(txt_buscar_productos_vendidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 350, 40));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.setRowHeight(25);
        jScrollPane1.setViewportView(tabla);

        panel_principal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 860, 240));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        calendario.setDateFormatString("yyyy/MM/dd ");
        jPanel2.add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 200, 40));

        fecha_final.setDateFormatString("yyyy/MM/dd ");
        jPanel2.add(fecha_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 200, 40));

        btn_filtrar_fecha.setText("Buscar");
        jPanel2.add(btn_filtrar_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 160, 50));

        label_inicio.setText("Fecha Inicio");
        jPanel2.add(label_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, 170, 30));

        label_final.setText("Fecha Final");
        jPanel2.add(label_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 25, 160, 30));

        btn_restablecer.setText("restablecer");
        jPanel2.add(btn_restablecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 110, -1));

        panel_principal.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 850, 140));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 0), 2));

        label_nombre_total.setText("Ingresos:");

        label_total.setText("0.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(label_nombre_total, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(label_total, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nombre_total, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(label_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panel_principal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, 310, 40));

        btn_saldo_cliente.setText("Ver Saldos Pendientes");
        panel_principal.add(btn_saldo_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 180, -1));

        tabla_nueva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_nueva.setRowHeight(25);
        jScrollPane2.setViewportView(tabla_nueva);

        panel_principal.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 860, 240));

        getContentPane().add(panel_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 880, 550));

        label_titulo.setText("REGISTRO  DE VENTAS");
        getContentPane().add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 370, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_filtrar_fecha;
    public javax.swing.JButton btn_restablecer;
    public javax.swing.JButton btn_saldo_cliente;
    public com.toedter.calendar.JDateChooser calendario;
    public com.toedter.calendar.JDateChooser fecha_final;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel label_cantidad_productos;
    public javax.swing.JLabel label_final;
    public javax.swing.JLabel label_inicio;
    public javax.swing.JLabel label_nombre_total;
    public javax.swing.JLabel label_numero_productos;
    public javax.swing.JLabel label_titulo;
    public javax.swing.JLabel label_total;
    public javax.swing.JPanel panel_principal;
    public javax.swing.JTable tabla;
    public javax.swing.JTable tabla_nueva;
    public javax.swing.JTextField txt_buscar_productos_vendidos;
    // End of variables declaration//GEN-END:variables
}
