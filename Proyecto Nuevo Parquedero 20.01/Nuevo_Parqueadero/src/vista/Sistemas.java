package vista;

public class Sistemas extends javax.swing.JDialog {

    public Sistemas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_titulo = new javax.swing.JLabel();
        panel_nombres_menu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_inicio = new javax.swing.JTextField();
        txt_funciones = new javax.swing.JTextField();
        txt_configuracion = new javax.swing.JTextField();
        txt_sistema = new javax.swing.JTextField();
        txt_respaldos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_titulo = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        btn_aplicar = new javax.swing.JButton();
        panel_editar_fuente = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        combo_fuente = new javax.swing.JComboBox<>();
        combo_estilo = new javax.swing.JComboBox<>();
        combo_tamano = new javax.swing.JComboBox<>();
        panel_muestra_letra = new javax.swing.JPanel();
        lb_texto_prueba = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_titulo.setText("Configurar Sistema");
        jPanel1.add(lb_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 21, 325, 29));

        panel_nombres_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Menú Inicio:");
        panel_nombres_menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 159, 30));

        jLabel3.setText("Menú Funciones:");
        panel_nombres_menu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 80, 131, 30));

        jLabel4.setText("Menú Configuración:");
        panel_nombres_menu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 130, -1, 30));

        jLabel5.setText("Menú Sistema:");
        panel_nombres_menu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 180, -1, 30));

        jLabel6.setText("Menú Documentos:");
        panel_nombres_menu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 230, 140, 30));
        panel_nombres_menu.add(txt_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 30, 250, 30));
        panel_nombres_menu.add(txt_funciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 80, 250, 30));
        panel_nombres_menu.add(txt_configuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 130, 250, 30));
        panel_nombres_menu.add(txt_sistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 180, 250, 30));
        panel_nombres_menu.add(txt_respaldos, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 230, 250, 30));

        jLabel7.setText("Título:");
        panel_nombres_menu.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 280, 97, 30));
        panel_nombres_menu.add(txt_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 280, 250, 30));

        jPanel1.add(panel_nombres_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 74, 443, 331));

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 240, 50));

        btn_aplicar.setText("Aplicar Cambios");
        jPanel1.add(btn_aplicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 240, 50));

        panel_editar_fuente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Fuente:");
        panel_editar_fuente.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, 100, 30));

        jLabel9.setText("Estilo:");
        panel_editar_fuente.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 80, 100, 30));

        jLabel10.setText("Tamaño:");
        panel_editar_fuente.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 130, 100, 30));

        combo_fuente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Algerian", "Arial", "Arial Black", "Consolas", "Dialog", "DialogInput" }));
        panel_editar_fuente.add(combo_fuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 200, 30));

        combo_estilo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Negrita", "Cursiva", "Negrita + Cursiva" }));
        panel_editar_fuente.add(combo_estilo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 200, 30));

        combo_tamano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8", "10", "12", "14", "16", "18" }));
        panel_editar_fuente.add(combo_tamano, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 200, 30));

        lb_texto_prueba.setText("Texto de prueba: Hola Mundo");

        javax.swing.GroupLayout panel_muestra_letraLayout = new javax.swing.GroupLayout(panel_muestra_letra);
        panel_muestra_letra.setLayout(panel_muestra_letraLayout);
        panel_muestra_letraLayout.setHorizontalGroup(
            panel_muestra_letraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_muestra_letraLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(lb_texto_prueba, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        panel_muestra_letraLayout.setVerticalGroup(
            panel_muestra_letraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_muestra_letraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_texto_prueba, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_editar_fuente.add(panel_muestra_letra, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 181, 380, 120));

        jPanel1.add(panel_editar_fuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 74, 410, 331));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_aplicar;
    public javax.swing.JButton btn_cancelar;
    public javax.swing.JComboBox<String> combo_estilo;
    public javax.swing.JComboBox<String> combo_fuente;
    public javax.swing.JComboBox<String> combo_tamano;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lb_texto_prueba;
    public javax.swing.JLabel lb_titulo;
    public javax.swing.JPanel panel_editar_fuente;
    public javax.swing.JPanel panel_muestra_letra;
    public javax.swing.JPanel panel_nombres_menu;
    public javax.swing.JTextField txt_configuracion;
    public javax.swing.JTextField txt_funciones;
    public javax.swing.JTextField txt_inicio;
    public javax.swing.JTextField txt_respaldos;
    public javax.swing.JTextField txt_sistema;
    public javax.swing.JTextField txt_titulo;
    // End of variables declaration//GEN-END:variables
}
