package ventana_Dialogos;

import Logica.Intruccion_sql;
import Logica.Logica_Colores;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

import static javax.swing.JOptionPane.showOptionDialog;
import javax.swing.SwingConstants;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class Salida extends javax.swing.JDialog {

    private Intruccion_sql pasar;
    private Logica_Colores colores;

    public Salida(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pasar = new Intruccion_sql();

        ///////////////////////////////////////
        this.setLocationRelativeTo(null);
        label_vaci.setVisible(false);
        btn_retirar.setEnabled(false);
        btn_limpiar.setEnabled(false);
        panel_principal.setFocusable(true);
        // combo_opciones.setVisible(false); ////no  lo puedo elimnar xq me sale error
        Cargar_Colores();

//////////////////////////////////////////////////////////////////////////////////////////
        pasar.getCedula_Existe("", 4,""); ///llamo a un metodo q llenar el arraList 

        AutoCompleteDecorator.decorate(txt_placa, pasar.getLista(), true);
        ////////////////////////////////////////////////////////////////////////////

    }

    private void Buscar_Auto() {

        String placa = txt_placa.getText();

        if (!placa.isEmpty()) {

            int re = pasar.Retirar_Vehiculo(placa);

            if (re == 0) {

                label_vaci.setText("Placa No registrada");
                label_vaci.setVisible(true);

            } else if (re == 1) {

                txt_placa.setEditable(false);
                btn_limpiar.setEnabled(true);
                btn_retirar.setEnabled(true);
                ////////////////////////////////////////////////////
                txt_propietario.setText(pasar.getNombre_propietario());
                txt_fecha.setText(pasar.getFecha_in());
                txt_tipo.setText(pasar.getTipo_vehi());
                label_costo.setText("" + pasar.getCosto_vehiculo());
                label_dias.setText("" + pasar.getDias());
                label_horas.setText("" + pasar.getHoras());
                label_minutos.setText("" + pasar.getMinutos());
                label_total_en_horas.setText("" + pasar.getTotal_en_horas());
                label_total.setText("" + pasar.getTotal_cobrar());

            }

            ///////////////////////////////////
        } else {
            label_vaci.setText("Ingresa nombre de la placa");
            label_vaci.setVisible(true);
        }
    }

    private void Cargar_Colores() {

        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*
       Manejo de Colores
         */
        colores = new Logica_Colores();/////////////////////
        colores.nombres_Color_funciones(true, "", "", "", "", "");
        String borde = colores.getColor_borde();
        String fondo = colores.getColor_fondo();
        String letra_titulos = colores.getColor_letra_titulos();
        String fondo_titulos = colores.getColor_fondo_titulos();
        ////////////////Color letra titulos///////////////////////////////////////////
        colores.get_Colores(letra_titulos, true, 0, 0, 0);
        Color color_letra_titulos = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        label_titulo.setForeground(color_letra_titulos);

        ////////////////////Color del borde///////////////////////////////////////
        colores.get_Colores(borde, true, 0, 0, 0);
        LineBorder color_bordes = new LineBorder(new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul()), 3, true);
        panel_principal.setBorder(color_bordes);
        label_total.setBorder(color_bordes);

        ////crear un title borde para los 2 panel////////////////////////////////////////////////
        TitledBorder borde_titulo = null;

        String sms = "Datos Vehiculo";
        for (int i = 0; i < 2; i++) {
            borde_titulo = new TitledBorder(color_bordes, sms, SwingConstants.SOUTH_EAST, SwingConstants.CENTER, new Font("Dialog", Font.BOLD, 15), Color.BLACK);

            if (i == 0) {
                panel_datos_vehiculo.setBorder(borde_titulo);
                sms = "Valores  a Cobrar";
            }

            if (i == 1) {

                panel_valores_cobrar.setBorder(borde_titulo);
                break;
            }
        }

        ////////////////////////////////////////////////////////////////////////////////
        label_titulo.setBorder(color_bordes);
        ///////////////////Color de fondo///////////////////////////////////////////////
        colores.get_Colores(fondo, true, 0, 0, 0);
        Color color_fondo = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        panel_principal.setBackground(color_fondo);
        panel_datos_vehiculo.setBackground(color_fondo);
        panel_valores_cobrar.setBackground(color_fondo);

        ////////////////Color fondo titulos///////////////////////////////////////////
        colores.get_Colores(fondo_titulos, true, 0, 0, 0);
        Color color_fondo_titulos = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        label_titulo.setBackground(color_fondo_titulos);
        label_digit_placa.setForeground(color_fondo_titulos);

    }

    private void Limpiar() {

        Color color = new Color(51, 51, 255);
        /// combo_opciones.setSelectedIndex(0);
        txt_placa.setText("");

        //btn_buscar.setEnabled(true);
        btn_retirar.setEnabled(false);
        txt_placa.setEditable(true);
        txt_placa.requestFocus();
        txt_propietario.setText("");
        txt_fecha.setText("");
        txt_tipo.setText("");

        label_costo.setText("NA");
        label_dias.setText("NA");
        label_horas.setText("NA");
        label_minutos.setText("NA");
        label_total.setText("0.00");
        label_total_en_horas.setText("NA");
        //////////////////////
        label_costo.setForeground(color);
        label_dias.setForeground(color);
        label_minutos.setForeground(color);
        label_total.setForeground(new Color(153, 0, 102));
        btn_limpiar.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        panel_principal = new javax.swing.JPanel();
        label_titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_placa = new javax.swing.JTextField();
        btn_limpiar = new javax.swing.JButton();
        panel_datos_vehiculo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_propietario = new javax.swing.JTextField();
        txt_fecha = new javax.swing.JTextField();
        txt_tipo = new javax.swing.JTextField();
        panel_valores_cobrar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        label_costo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        label_dias = new javax.swing.JLabel();
        btn_retirar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        label_horas = new javax.swing.JLabel();
        label_minutos = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        label_total = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        label_total_en_horas = new javax.swing.JLabel();
        label_vaci = new javax.swing.JLabel();
        label_digit_placa = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 2));
        panel_principal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panel_principalFocusGained(evt);
            }
        });
        panel_principal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_principalMouseEntered(evt);
            }
        });
        panel_principal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panel_principalKeyPressed(evt);
            }
        });
        panel_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_titulo.setBackground(new java.awt.Color(204, 255, 204));
        label_titulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo.setText("Salida de Vehiculos");
        label_titulo.setOpaque(true);
        panel_principal.add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 494, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        panel_principal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 2, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Parametro a Buscar");
        panel_principal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 52, 165, -1));

        txt_placa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_placa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_placa.setOpaque(false);
        txt_placa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_placaFocusGained(evt);
            }
        });
        txt_placa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_placaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_placaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_placaKeyTyped(evt);
            }
        });
        panel_principal.add(txt_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 89, 199, -1));

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo_texto.png"))); // NOI18N
        btn_limpiar.setContentAreaFilled(false);
        btn_limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        panel_principal.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 70, 50));

        panel_datos_vehiculo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Vehiculo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(153, 255, 0))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Propietario. ");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Fecha Ingreso: ");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Tipo Vehiculo:");

        txt_propietario.setEditable(false);
        txt_propietario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_propietario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_fecha.setEditable(false);
        txt_fecha.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechaActionPerformed(evt);
            }
        });

        txt_tipo.setEditable(false);
        txt_tipo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_tipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout panel_datos_vehiculoLayout = new javax.swing.GroupLayout(panel_datos_vehiculo);
        panel_datos_vehiculo.setLayout(panel_datos_vehiculoLayout);
        panel_datos_vehiculoLayout.setHorizontalGroup(
            panel_datos_vehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_datos_vehiculoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel_datos_vehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(panel_datos_vehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_propietario, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_datos_vehiculoLayout.setVerticalGroup(
            panel_datos_vehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_datos_vehiculoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panel_datos_vehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_propietario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_datos_vehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_datos_vehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_principal.add(panel_datos_vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 500, -1));

        panel_valores_cobrar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valores  a Cobrar", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        panel_valores_cobrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Costo Tipo Vehiculo:");
        panel_valores_cobrar.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 160, 25));

        label_costo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_costo.setForeground(new java.awt.Color(51, 51, 255));
        label_costo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_costo.setText("NA");
        panel_valores_cobrar.add(label_costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 30, 70, 25));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Minutos:");
        panel_valores_cobrar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 97, 25));

        label_dias.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_dias.setForeground(new java.awt.Color(51, 51, 255));
        label_dias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_dias.setText("NA");
        panel_valores_cobrar.add(label_dias, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 70, 70, 25));

        btn_retirar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_retirar.setText("Retirar Vehiculo");
        btn_retirar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retirarActionPerformed(evt);
            }
        });
        panel_valores_cobrar.add(btn_retirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 80, 170, 60));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText(" Dias:");
        panel_valores_cobrar.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 25));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("Horas");
        panel_valores_cobrar.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 25));

        label_horas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_horas.setForeground(new java.awt.Color(51, 51, 255));
        label_horas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_horas.setText("NA");
        panel_valores_cobrar.add(label_horas, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 110, 70, 25));

        label_minutos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_minutos.setForeground(new java.awt.Color(51, 51, 255));
        label_minutos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_minutos.setText("NA");
        panel_valores_cobrar.add(label_minutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 150, 70, 25));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Total a Cobrar");
        panel_valores_cobrar.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 129, -1));

        label_total.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_total.setForeground(new java.awt.Color(153, 0, 102));
        label_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_total.setText("0.00");
        label_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        panel_valores_cobrar.add(label_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 88, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("$");
        panel_valores_cobrar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 25, 28));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Total en horas: ");
        panel_valores_cobrar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 160, -1));

        label_total_en_horas.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label_total_en_horas.setForeground(new java.awt.Color(153, 153, 0));
        label_total_en_horas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_total_en_horas.setText("NA");
        panel_valores_cobrar.add(label_total_en_horas, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 190, 70, -1));

        panel_principal.add(panel_valores_cobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 500, 244));

        label_vaci.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        label_vaci.setForeground(new java.awt.Color(204, 0, 0));
        label_vaci.setText("Ingresa nombre de la placa");
        panel_principal.add(label_vaci, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 122, 182, -1));

        label_digit_placa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_digit_placa.setForeground(new java.awt.Color(0, 0, 0));
        label_digit_placa.setText("Digita Placa: ");
        panel_principal.add(label_digit_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 93, 134, -1));

        jPanel1.add(panel_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fechaActionPerformed

    private void btn_retirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retirarActionPerformed
        // TODO add your handling code here:

        String opciones[] = {"COBRAR", "CANCELAR"};
        int con = showOptionDialog(this, "¿COBRAR PARQUEADERO?" + "\n\nPlaca: " +txt_placa.getText() +"\nCobrar: " + label_total.getText() ,"Sistema de Registro", 1, 1,  new ImageIcon("src/Imagenes/vehi_saliaaa.png"), opciones, opciones[1]);

        if (con == 0) {
            String placa = txt_placa.getText();
            /// System.out.println(placa);
            double cobrar = Double.parseDouble(label_total.getText());
            String Estado = "SI";
            String nombre_pro = txt_propietario.getText();
            String tipo_vehic = txt_tipo.getText();
            String fecha_ingreso = txt_fecha.getText();

            double costo = Double.parseDouble(label_costo.getText());
            int dias = Integer.parseInt(label_dias.getText());
            int horas = Integer.parseInt(label_horas.getText());
            int minu = Integer.parseInt(label_minutos.getText());
            int to_horas = Integer.parseInt(label_total_en_horas.getText());
            double total = Double.parseDouble(label_total.getText());

            pasar.setActualizar_estado_ingreso(placa, Estado, cobrar, 1, null,"", "","","",0,0,0);

            /////////  Llenar Tabla  autos_salida
            Calendar calendario = Calendar.getInstance();
            Date fecha = calendario.getTime(); ///date de la clase util

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy   hh:mm:ss a");
            String fecha_salida = dateFormat.format(fecha);

            /////Construir un objeto tipo date para pasarle a la tabla salida/////////////
            int anno = (calendario.get(Calendar.YEAR) - 1900);
            int mes = calendario.get(Calendar.MONTH);
            int dia = calendario.get(Calendar.DATE);
            int hora_salida = calendario.get(Calendar.HOUR_OF_DAY);
            int minutos_salida = calendario.get(Calendar.MINUTE);
            int segundo_salida = calendario.get(Calendar.SECOND);
            java.sql.Date fecha_enviar = new java.sql.Date(anno, mes, dia);

            int re = pasar.setIngresar_vehiculo_Adminis(false, fecha_enviar, hora_salida, minutos_salida, segundo_salida, 0, placa, nombre_pro, tipo_vehic, costo, fecha_ingreso, fecha_salida, dias, horas, minu, to_horas, total);

            if (re == 0) {
                JOptionPane.showMessageDialog(this, "Surgio un error en la tabla salida de autos , no se pudo agregar" + "\nel registro del auto retirado");
            } else { ///ESTE SMS ES DE LKA TABLA DE ARRIBA
                JOptionPane.showMessageDialog(this, "Vehiculo Retirado Correcamente", "Sistema De Parqueo", JOptionPane.QUESTION_MESSAGE,new ImageIcon("src/Image_Sms/vehiculo_ingresado_cor.png"));
                Limpiar();

            }
            //this.dispose();

        }


    }//GEN-LAST:event_btn_retirarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed

//        Color color = new Color(51, 51, 255);
//        /// combo_opciones.setSelectedIndex(0);
//        txt_placa.setText("");
//
//        //btn_buscar.setEnabled(true);
//        btn_retirar.setEnabled(false);
//        txt_placa.setEditable(true);
//        txt_placa.requestFocus();
//        txt_propietario.setText("");
//        txt_fecha.setText("");
//        txt_tipo.setText("");
//
//        label_costo.setText("NA");
//        label_dias.setText("NA");
//        label_horas.setText("NA");
//        label_minutos.setText("NA");
//        label_total.setText("0.00");
//        label_total_en_horas.setText("NA");
//        //////////////////////
//        label_costo.setForeground(color);
//        label_dias.setForeground(color);
//        label_minutos.setForeground(color);
//        label_total.setForeground(new Color(153, 0, 102));
//        btn_limpiar.setEnabled(false);
        Limpiar();


    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void txt_placaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_placaFocusGained
        // TODO add your handling code here:
        label_vaci.setVisible(false);
    }//GEN-LAST:event_txt_placaFocusGained

    private void txt_placaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaKeyReleased
        // TODO add your handling code here:      

        if (pasar.setPlaca_Cancelada(txt_placa.getText(),true) == 1) {
            label_vaci.setText("Vehiculo ya fue retirado");
            btn_retirar.setEnabled(false);
//                btn_retirar.setEnabled(false);
            label_vaci.setForeground(Color.blue);
            label_vaci.setVisible(true);

        } else if (pasar.setPlaca_Cancelada(txt_placa.getText(),true) == 2) {
            label_vaci.setVisible(false);
            label_vaci.setForeground(Color.red);

        }


    }//GEN-LAST:event_txt_placaKeyReleased

    private void txt_placaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaKeyTyped
        // TODO add your handling code here:
        char tecla = evt.getKeyChar();

        if (Character.isLowerCase(tecla)) {
            String mayuscula = ("" + tecla).toUpperCase();
            tecla = mayuscula.charAt(0);
            evt.setKeyChar(tecla);

        }
    }//GEN-LAST:event_txt_placaKeyTyped

    private void txt_placaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {

            if (txt_propietario.getText().isEmpty()) {
                Buscar_Auto();
            }

        }


    }//GEN-LAST:event_txt_placaKeyPressed

    private void panel_principalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panel_principalFocusGained
        // TODO add your handling code here:


    }//GEN-LAST:event_panel_principalFocusGained

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        //// System.out.println("fooc ganadoooo");
    }//GEN-LAST:event_formFocusGained

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_formKeyPressed

    private void panel_principalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_principalMouseEntered
        // TODO add your handling code here:
        panel_principal.requestFocusInWindow();
    }//GEN-LAST:event_panel_principalMouseEntered

    private void panel_principalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panel_principalKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            this.dispose();

        }
    }//GEN-LAST:event_panel_principalKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Salida dialog = new Salida(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_retirar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel label_costo;
    private javax.swing.JLabel label_dias;
    private javax.swing.JLabel label_digit_placa;
    private javax.swing.JLabel label_horas;
    private javax.swing.JLabel label_minutos;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel label_total;
    private javax.swing.JLabel label_total_en_horas;
    private javax.swing.JLabel label_vaci;
    private javax.swing.JPanel panel_datos_vehiculo;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JPanel panel_valores_cobrar;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_placa;
    private javax.swing.JTextField txt_propietario;
    private javax.swing.JTextField txt_tipo;
    // End of variables declaration//GEN-END:variables

}
