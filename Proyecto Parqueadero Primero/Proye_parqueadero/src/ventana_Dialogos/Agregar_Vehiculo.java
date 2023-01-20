package ventana_Dialogos;

import Logica.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import javax.swing.border.LineBorder;

public class Agregar_Vehiculo extends javax.swing.JDialog {
    
    private Intruccion_sql datos;
    private Logica_Colores colores;
    private Tabla_Listar listar_datos;
    
    public Agregar_Vehiculo(java.awt.Frame parent, boolean modal) { //cuando lo llame desde un frame MENU
        super(parent, modal);
        Estados_Contructor();
        
    }
    
    public Agregar_Vehiculo(JDialog Agrear_vehi, boolean modal) { //cuando lo llame desde un Jdialog INGRESO
        super(Agrear_vehi, modal);
        Estados_Contructor();
        
    }
    
    private void Estados_Contructor() {
        initComponents();;
        datos = new Intruccion_sql();
        txt_agre_vehiculo.setVisible(false);
        label_txt_vacio.setVisible(false);
        btn_operaciones.setEnabled(false);
        Cargar_Colores();
        combo_operaciones.setUI(new Personalizar_combo(1));
        combo_cargar_vehiculos.setUI(new Personalizar_combo(0));
        ///combo_precios.setUI(new Personalizar_combo(0));
        Panel_actualizar.setFocusable(true);
        Llenar_tabla();
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
        String color_funciones = colores.getColor_letra_funciones();
        /////////////////////////////////////////////////////////////////////////////
        ////////////////Color letra titulos///////////////////////////////////////////
        colores.get_Colores(letra_titulos, true, 0, 0, 0);
        Color color_letra_titulos = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        label_titulo_confi_vehicu.setForeground(color_letra_titulos);

        ////////////////////Color del borde///////////////////////////////////////
        colores.get_Colores(borde, true, 0, 0, 0);
        LineBorder color_bordes = new LineBorder(new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul()), 3, true);
        Panel_actualizar.setBorder(color_bordes);
        label_titulo_confi_vehicu.setBorder(color_bordes);
        btn_operaciones.setBorder(color_bordes);
        combo_operaciones.setBorder(color_bordes);
        combo_cargar_vehiculos.setBorder(color_bordes);

        ///////////////////Color de fondo///////////////////////////////////////////////
        colores.get_Colores(fondo, true, 0, 0, 0);
        Color color_fondo = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        Panel_actualizar.setBackground(color_fondo);

        ////////////////Color fondo titulos///////////////////////////////////////////
        colores.get_Colores(fondo_titulos, true, 0, 0, 0);
        Color color_fondo_titulos = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        label_titulo_confi_vehicu.setBackground(color_fondo_titulos);
        ///////////COLOR LETRA FUNCIONES/ BTN/////////////////////////////
        colores.get_Colores(color_funciones, true, 0, 0, 0);
        Color co_funciones = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        
        btn_operaciones.setForeground(co_funciones);
        
    }
    
    private void Llenar_tabla() {
        listar_datos = new Tabla_Listar(tabla_vehiculos);
        label_numero.setText("#Vehiculos: " + listar_datos.getNumero_filas_regi());
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_actualizar = new javax.swing.JPanel();
        label_titulo_confi_vehicu = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btn_operaciones = new javax.swing.JButton();
        spiner_valor = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        txt_agre_vehiculo = new javax.swing.JTextField();
        combo_cargar_vehiculos = new javax.swing.JComboBox<>();
        label_txt_vacio = new javax.swing.JLabel();
        combo_operaciones = new javax.swing.JComboBox<>();
        label_salir_pan_vehi = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_vehiculos = new javax.swing.JTable();
        label_numero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Panel_actualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 0), 3, true));
        Panel_actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel_actualizarMouseEntered(evt);
            }
        });
        Panel_actualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Panel_actualizarKeyPressed(evt);
            }
        });
        Panel_actualizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_titulo_confi_vehicu.setBackground(new java.awt.Color(0, 204, 0));
        label_titulo_confi_vehicu.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label_titulo_confi_vehicu.setForeground(java.awt.Color.white);
        label_titulo_confi_vehicu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo_confi_vehicu.setText("Configuración Vehiculos");
        label_titulo_confi_vehicu.setOpaque(true);
        Panel_actualizar.add(label_titulo_confi_vehicu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel12.setText("Tipo_Vehiculo");
        Panel_actualizar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 130, 100, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel13.setText("Valor_Hora");
        Panel_actualizar.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 210, 90, -1));

        btn_operaciones.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        btn_operaciones.setForeground(java.awt.Color.black);
        btn_operaciones.setText("Sin Seleccionar");
        btn_operaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_operaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_operacionesActionPerformed(evt);
            }
        });
        Panel_actualizar.add(btn_operaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 170, 40));

        spiner_valor.setModel(new javax.swing.SpinnerNumberModel(1.0d, 1.0d, 10.0d, 0.5d));
        Panel_actualizar.add(spiner_valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 205, 50, 30));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("Operación");
        Panel_actualizar.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 40, 80, -1));

        txt_agre_vehiculo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txt_agre_vehiculo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_agre_vehiculo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_agre_vehiculoFocusGained(evt);
            }
        });
        txt_agre_vehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_agre_vehiculoActionPerformed(evt);
            }
        });
        Panel_actualizar.add(txt_agre_vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 200, 30));

        combo_cargar_vehiculos.setBackground(new java.awt.Color(204, 255, 204));
        combo_cargar_vehiculos.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        combo_cargar_vehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_cargar_vehiculosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo_cargar_vehiculosMousePressed(evt);
            }
        });
        combo_cargar_vehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_cargar_vehiculosActionPerformed(evt);
            }
        });
        Panel_actualizar.add(combo_cargar_vehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 200, 30));

        label_txt_vacio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_txt_vacio.setForeground(new java.awt.Color(204, 0, 0));
        label_txt_vacio.setText("Ingrese un nombre");
        Panel_actualizar.add(label_txt_vacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 180, -1));

        combo_operaciones.setBackground(new java.awt.Color(204, 255, 204));
        combo_operaciones.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        combo_operaciones.setForeground(new java.awt.Color(0, 0, 0));
        combo_operaciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Agregar", "Actualizar", "Eliminar" }));
        combo_operaciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        combo_operaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        combo_operaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_operacionesActionPerformed(evt);
            }
        });
        combo_operaciones.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                combo_operacionesPropertyChange(evt);
            }
        });
        Panel_actualizar.add(combo_operaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, 190, 30));

        label_salir_pan_vehi.setFont(new java.awt.Font("Dialog", 1, 23)); // NOI18N
        label_salir_pan_vehi.setForeground(new java.awt.Color(255, 0, 0));
        label_salir_pan_vehi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_salir_pan_vehi.setText("X");
        label_salir_pan_vehi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_salir_pan_vehi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label_salir_pan_vehiMousePressed(evt);
            }
        });
        Panel_actualizar.add(label_salir_pan_vehi, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 4, 20, 20));

        tabla_vehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_vehiculos.setRowHeight(20);
        jScrollPane2.setViewportView(tabla_vehiculos);

        Panel_actualizar.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 240, 270));

        label_numero.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_numero.setText("0.00");
        Panel_actualizar.add(label_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_operacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_operacionesActionPerformed
        // TODO add your handling code here:

        ImageIcon sms_Icono = null;
        String texto_combo = (String) combo_operaciones.getSelectedItem();
        String nombre_vehi = combo_cargar_vehiculos.getSelectedItem().toString();
        double valor = Double.parseDouble(spiner_valor.getValue().toString());
        String ope_realizada = "Vehiculo";
        String pregunta = "";
        
        int operacion = 0;
        if (texto_combo.equals("Agregar")) {
            
            operacion = 1;
            ope_realizada += " Agreado Correctamente";
            pregunta = "Agregar";
            nombre_vehi = txt_agre_vehiculo.getText();
            sms_Icono = new ImageIcon("src/Image_Sms/agregar_vehi.png");
        } else if (texto_combo.equals("Actualizar")) {
            operacion = 2;
            pregunta = "Actualizar";
            ope_realizada += " Actualizado Correctamente";
            sms_Icono = new ImageIcon("src/Image_Sms/actualzar_vehi.png");
        } else if (texto_combo.equals("Eliminar")) {
            
            operacion = 3;
            pregunta = "Eliminar";
            ope_realizada += " Eliminado Correctamente";
            sms_Icono = new ImageIcon("src/Image_Sms/eliminar_vehi.png");
        }
        
        String[] opciones = {pregunta, "Cancelar"};
        int elegir = 9;
        if (!nombre_vehi.isEmpty()) {
            elegir = JOptionPane.showOptionDialog(this, "¿Seguro desea " + pregunta + " Vehiculo?", "Sistema  de Parqueo", 0, 0, sms_Icono, opciones, opciones[1]);
            
        } else {
            label_txt_vacio.setVisible(true);
        }
        
        if (elegir == 0) {
            int retorno = 0;
            String sms = null;
            if (operacion == 3) {
                
                retorno = datos.setPlaca_Cancelada(nombre_vehi, false);
                sms =  "                             Vehiculo No Eliminado"+ "\n\nExisten actualmente vehiculos ingresados  de tipo " + "' " +  nombre_vehi.toUpperCase() + " '" + "\nRetire primero los vehiculos  que sean de ese tipo";
                
            }
            
            if (operacion == 1) {
                retorno = datos.sql_Tabla_Tipo_Vehiculos(null, txt_agre_vehiculo.getText(), 0, true, 2);
                sms = "      Vehiculo No Agregado" + "\n\nTipo de Vehiculo ya esta registrado";
                
            }
            
            if (retorno == 1) {
                JOptionPane.showMessageDialog(this, sms);
                txt_agre_vehiculo.setText("");

                ///JOptionPane.showMessageDialog(this, "    Tipo de vehiculo NO se puede Eliminar" + "\n\nExisten vehiculos ingresados actualmente de ese tipo de vehiculo." + "\nRetire primero los vehiculos  que sean de ese tipoo.");
            } else if (retorno == 0) {
                /// Animacion.Animacion.mover_izquierda(290, 290, 2, 2, Panel_actualizar);
                int re = datos.sql_Tabla_Tipo_Vehiculos(null, nombre_vehi, valor, false, operacion);
                
                if (re != 0) {
                    combo_cargar_vehiculos.removeAllItems();
                    
                    int selec = datos.sql_Tabla_Tipo_Vehiculos(combo_cargar_vehiculos, "", 0, true, 1);
                    Llenar_tabla(); // carga nuevamente la tabla, despues d ehacer alguna operacion.

                    if (selec != 0) {
                        
                        JOptionPane.showMessageDialog(this, ope_realizada, "Sistema  de Parqueo", JOptionPane.QUESTION_MESSAGE);
                        /// Animacion.Animacion.mover_izquierda(290, 290, 2, 2, Panel_actualizar);
                    }
                }
                
                txt_agre_vehiculo.setText("");
                combo_operaciones.setSelectedIndex(0); //// si cualquier consulta se realiza
                /// Animacion.Animacion.mover_izquierda(290, 290, 2, 2, Panel_actualizar);

            }
            
        }

    }//GEN-LAST:event_btn_operacionesActionPerformed

    private void txt_agre_vehiculoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_agre_vehiculoFocusGained
        // TODO add your handling code here:
        label_txt_vacio.setVisible(false);
        /// Animacion.Animacion.mover_izquierda(290, 290, 2, 2, Panel_actualizar);
    }//GEN-LAST:event_txt_agre_vehiculoFocusGained

    private void txt_agre_vehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_agre_vehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_agre_vehiculoActionPerformed

    private void combo_cargar_vehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_cargar_vehiculosMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_combo_cargar_vehiculosMouseClicked

    private void combo_cargar_vehiculosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_cargar_vehiculosMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_combo_cargar_vehiculosMousePressed

    private void combo_cargar_vehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_cargar_vehiculosActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_combo_cargar_vehiculosActionPerformed

    private void combo_operacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_operacionesActionPerformed
        // TODO add your handling code here:
        boolean estado = false;
        boolean spiner = false; //activar espiner
        boolean acti_boton = false; ///activar boton
        String name_btn = "";
        
        switch (combo_operaciones.getSelectedIndex()) {
            case 0:
                name_btn = "Sin Seleccionar";
                break;
            case 1:
                name_btn = "Agregar  Vehiculo";
                estado = true;
                spiner = true;
                acti_boton = true;
                break;
            case 2:
                name_btn = "Actualizar Vehiculo";
                spiner = true;
                acti_boton = true;
                break;
            case 3:
                name_btn = "Eliminar Vehiculo";
                acti_boton = true;
                //spiner = true;
                break;
            default:
                break;
        }
        
        btn_operaciones.setText(name_btn);
        txt_agre_vehiculo.setVisible(estado);
        ///spiner_valor.setValue(1);
        spiner_valor.setEnabled(spiner);
        btn_operaciones.setEnabled(acti_boton);
        spiner_valor.setValue(1);
        
        label_txt_vacio.setVisible(false);
        // Animacion.Animacion.mover_izquierda(290, 290, 2, 2, Panel_actualizar);

    }//GEN-LAST:event_combo_operacionesActionPerformed

    private void combo_operacionesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_combo_operacionesPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_combo_operacionesPropertyChange

    private void label_salir_pan_vehiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_salir_pan_vehiMousePressed
        // TODO add your handling code here:

        combo_operaciones.setSelectedIndex(0);
        spiner_valor.setValue(1);
        this.dispose();

    }//GEN-LAST:event_label_salir_pan_vehiMousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        //cargar el combo , actulizar
        datos.sql_Tabla_Tipo_Vehiculos(combo_cargar_vehiculos, "", 0, true, 1);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        ////datos.sql_Tabla_Tipo_Vehiculos(combo_cargar_vehiculos, "", 0, true, 0);
    }//GEN-LAST:event_formWindowActivated

    private void Panel_actualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_actualizarMouseEntered
        // TODO add your handling code here:
        Panel_actualizar.requestFocusInWindow();
    }//GEN-LAST:event_Panel_actualizarMouseEntered

    private void Panel_actualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Panel_actualizarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            this.dispose();
            
        }
        

    }//GEN-LAST:event_Panel_actualizarKeyPressed

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
            java.util.logging.Logger.getLogger(Agregar_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Agregar_Vehiculo dialog = new Agregar_Vehiculo(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel Panel_actualizar;
    private javax.swing.JButton btn_operaciones;
    private javax.swing.JComboBox<String> combo_cargar_vehiculos;
    private javax.swing.JComboBox<String> combo_operaciones;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_numero;
    private javax.swing.JLabel label_salir_pan_vehi;
    private javax.swing.JLabel label_titulo_confi_vehicu;
    private javax.swing.JLabel label_txt_vacio;
    private javax.swing.JSpinner spiner_valor;
    private javax.swing.JTable tabla_vehiculos;
    private javax.swing.JTextField txt_agre_vehiculo;
    // End of variables declaration//GEN-END:variables
}
