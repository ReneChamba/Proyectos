
package vista;

public class Ingresar_Vehiculo extends javax.swing.JDialog {

    public Ingresar_Vehiculo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_botones = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lb_propietario = new javax.swing.JLabel();
        lb_titulo = new javax.swing.JLabel();
        lb_placa = new javax.swing.JLabel();
        lb_tipo = new javax.swing.JLabel();
        txt_propietario = new javax.swing.JTextField();
        txt_placa = new javax.swing.JTextField();
        combo_vehiculos = new javax.swing.JComboBox<>();
        btn_iregistrar_vehiculo = new javax.swing.JButton();
        lb_motivo = new javax.swing.JLabel();
        check_parqueo = new javax.swing.JRadioButton();
        check_lavado = new javax.swing.JRadioButton();
        check_todo = new javax.swing.JRadioButton();
        txt_precio_lavado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_propietario.setText("Propietario:");
        jPanel1.add(lb_propietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 100, 30));

        lb_titulo.setText("Ingresar Vehículos");
        jPanel1.add(lb_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 320, 30));

        lb_placa.setText("Placa:");
        jPanel1.add(lb_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 100, 30));

        lb_tipo.setText("Tipo:");
        jPanel1.add(lb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 100, 30));
        jPanel1.add(txt_propietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 280, 30));
        jPanel1.add(txt_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 280, 30));

        jPanel1.add(combo_vehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 280, 30));

        btn_iregistrar_vehiculo.setText("Guardar Vehiculo");
        jPanel1.add(btn_iregistrar_vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 240, 50));

        lb_motivo.setText("Motivo");
        jPanel1.add(lb_motivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 100, 30));

        check_parqueo.setText("Parqueo");
        jPanel1.add(check_parqueo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, -1, -1));

        check_lavado.setText("Lavado");
        jPanel1.add(check_lavado, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 90, -1));

        check_todo.setText("Todo");
        jPanel1.add(check_todo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 90, -1));
        jPanel1.add(txt_precio_lavado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 160, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_iregistrar_vehiculo;
    public javax.swing.JRadioButton check_lavado;
    public javax.swing.JRadioButton check_parqueo;
    public javax.swing.JRadioButton check_todo;
    public javax.swing.JComboBox<String> combo_vehiculos;
    public javax.swing.ButtonGroup grupo_botones;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lb_motivo;
    public javax.swing.JLabel lb_placa;
    public javax.swing.JLabel lb_propietario;
    public javax.swing.JLabel lb_tipo;
    public javax.swing.JLabel lb_titulo;
    public javax.swing.JTextField txt_placa;
    public javax.swing.JTextField txt_precio_lavado;
    public javax.swing.JTextField txt_propietario;
    // End of variables declaration//GEN-END:variables
}
