package ventana_Dialogos;

import Atxy2k.CustomTextField.RestrictedTextField;
import Conexion.Conectar_base;
import Logica.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.sql.*;
import java.util.Hashtable;
import javax.swing.*;
import static javax.swing.JOptionPane.*;
import javax.swing.border.LineBorder;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class Ingreso extends JDialog {

    private Intruccion_sql pasar;
    private String actualizar = "";

    public Ingreso(JFrame parent, boolean modal) {
        super(parent, modal);

        /// contrxutor cuando lo llamo desde el frame
        estado();

    }

    public Ingreso(JDialog dialogo, boolean modal, String actulizar) {
        super(dialogo, modal); //// contrxutor cuando lo llamo desde el JDialofg de listar   
        this.actualizar = actulizar;
        estado();

    }

    private void estado() {

        initComponents();
        this.setLocationRelativeTo(null);
        Colores_Controles();
        pasar = new Intruccion_sql();
        panel_principal.setFocusable(true);
        tomar_fecha_actu.setVisible(false);

        pasar.sql_Tabla_Tipo_Vehiculos(combo_vehi_carga, "", 0, true, 1);

        if (!actualizar.equals("")) { // en el caso que lo llame desde el doble click en la tabla 

            label_titulo.setText("Editar Datos Vehiculos");
            pasar.setIngresar_vehiculo(actualizar, "", "", false, this, 1, "");
            tomar_fecha_actu.setText(pasar.getFecha_in());
            btn_ingresar.setVisible(false);
            txt_placa.setText(pasar.getReturn_placa());
            ////aCTUALIZA EL COMBO  DESPUES DE CERRAR EL JDIaLOG AGREGAR Vehiculo/////

            txt_propietario.setText(pasar.getNombre_propietario());
            combo_vehi_carga.setSelectedItem(pasar.getTipo_vehi());

        } else {
            btn_actulizar_2.setVisible(false);
        }

        label_sms.setVisible(false);
        btn_actualizar.setVisible(false);
        cn = new Conectar_base();
        txt_segundo_nombres.setVisible(false);
       
        label_nombre.setVisible(false);

        if (actualizar.equals("")) {
            Restricciones();
        }

        pasar.getCedula_Existe("", 4,""); ///llamo a un metodo q llenar el arraList 

        AutoCompleteDecorator.decorate(txt_placa, pasar.getLista(), false);

        ////////////////////////////////////////////////////////////////////////////
        combo_vehi_carga.setUI(new Personalizar_combo(0)); //Pernalizacion del combo

    }

    private void Colores_Controles() {

        Logica_Colores colores = new Logica_Colores();

        // datos.sql_Tabla_Tipo_Vehiculos(combo_cargar_vehiculos, "", 0, true, 0);
        String color_fondo = "";///
        String color_letra_titulos = "";////
        String color_letra_funciones = "";////
        String color_borde = "";//
        String color_fondo_titulos = "";

        int recibir = colores.nombres_Color_funciones(true, "", "", "", "", "");

        if (recibir != 0) {

            color_borde = colores.getColor_borde();
            color_fondo = colores.getColor_fondo();
            color_letra_funciones = colores.getColor_letra_funciones();
            color_letra_titulos = colores.getColor_letra_titulos();
            color_fondo_titulos = colores.getColor_fondo_titulos();

            //////////////////////////////////////////////////////////////////////////////////////
            colores.get_Colores(color_borde, true, 0, 0, 0);
            Color color_1 = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());

            LineBorder border = new LineBorder(color_1, 3, true);
            panel_principal.setBorder(border);

            label_titulo.setBorder(border);
            btn_ingresar.setBorder(border);
            btn_actulizar_2.setBorder(border);

            combo_vehi_carga.setBorder(border);

            /////////////////////////////////////////////////////////////////////////////////////////
            colores.get_Colores(color_fondo, true, 0, 0, 0);
            Color color_2 = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());

            panel_principal.setBackground(color_2);

            ///////////////////////////////////////////////////////////////
            colores.get_Colores(color_letra_titulos, true, 0, 0, 0);
            Color color_4 = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
            label_titulo.setForeground(color_4);

            /////////////////////////////////////////////////////////////////////////////////////////
            colores.get_Colores(color_fondo_titulos, true, 0, 0, 0);
            Color color_5 = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
            label_titulo.setBackground(color_5);

//            /////////////////////////////////////////////////////////////////////////////////////////
            colores.get_Colores(color_letra_funciones, true, 0, 0, 0);
            Color color_3 = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());

            btn_ingresar.setForeground(color_3);
            btn_actulizar_2.setForeground(color_3);

//            
//             /////////////////////////////////////////////////////////////////////////////////////////
//         
//        }   
        }

    }

    private void Restricciones() {
        RestrictedTextField placa = new RestrictedTextField(txt_placa);
        placa.setLimit(8);

        RestrictedTextField nombre = new RestrictedTextField(txt_propietario);
        nombre.setLimit(30);
        nombre.setAcceptSpace(true);
        nombre.setOnlyText(true);
        /////////////////////////////////////////////////////////////////////////////////////

        Trasparente pl = new Trasparente("********", txt_placa, Trasparente.Show.ALWAYS);
        Trasparente con = new Trasparente("********", txt_propietario, Trasparente.Show.ALWAYS);
    }

    private void Actualizar_Datos() {

        if (!txt_placa.getText().isEmpty() && !txt_propietario.getText().isEmpty()) {

            String[] opciones = {"Si,Actualizar ", "Cancelar"};

            int pregunta = JOptionPane.showOptionDialog(this, "¿Actualizar Datos?", "Sistema de Parqueo", 0, 0, null, opciones, opciones[1]);

            if (pregunta == 0) {

                String placa_actulizar = txt_placa.getText();
                String nombre_actualizar = txt_propietario.getText();
                String tipo_veh_actualizar = (String) combo_vehi_carga.getSelectedItem();

                pasar.setIngresar_vehiculo(tomar_fecha_actu.getText(), nombre_actualizar, tipo_veh_actualizar, false, this, 3, placa_actulizar);

                Limpiar_Cajas();
            }

        } else if (txt_placa.getText().isEmpty()) {

            label_sms.setVisible(true);

        } else if (txt_propietario.getText().isEmpty()) {
            label_nombre.setVisible(true);

        }

    }

    private void Limpiar_Cajas() {
        txt_placa.setText("");
        txt_propietario.setText("");
        txt_segundo_nombres.setText("");
        combo_vehi_carga.setSelectedIndex(0);
        btn_actualizar.setVisible(false);
        label_sms.setVisible(false);
        combo_vehi_carga.setEnabled(true);
        txt_placa.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        panel_principal = new javax.swing.JPanel();
        label_titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_ingresar = new javax.swing.JButton();
        txt_propietario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_placa = new javax.swing.JTextField();
        label_sms = new javax.swing.JLabel();
        btn_actualizar = new javax.swing.JButton();
        txt_segundo_nombres = new javax.swing.JTextField();
        label_nombre = new javax.swing.JLabel();
        combo_vehi_carga = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btn_actulizar_2 = new javax.swing.JButton();
        tomar_fecha_actu = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setUndecorated(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        panel_principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 51), 2));
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
        panel_principal.setLayout(null);

        label_titulo.setBackground(new java.awt.Color(204, 255, 204));
        label_titulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo.setText("Ingreso de Vehiculos");
        label_titulo.setOpaque(true);
        panel_principal.add(label_titulo);
        label_titulo.setBounds(2, 2, 491, 30);

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
        panel_principal.add(jLabel2);
        jLabel2.setBounds(495, 6, 20, 20);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Nombre Propietario");
        panel_principal.add(jLabel3);
        jLabel3.setBounds(160, 180, 171, 24);

        btn_ingresar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_ingresar.setText("Ingresar Vehiculo");
        btn_ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });
        panel_principal.add(btn_ingresar);
        btn_ingresar.setBounds(120, 400, 246, 48);

        txt_propietario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_propietario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_propietario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_propietarioFocusGained(evt);
            }
        });
        txt_propietario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_propietarioKeyTyped(evt);
            }
        });
        panel_principal.add(txt_propietario);
        txt_propietario.setBounds(120, 220, 260, 35);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Placa");
        panel_principal.add(jLabel5);
        jLabel5.setBounds(228, 52, 47, 33);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Tipo de Vehiculo");
        panel_principal.add(jLabel4);
        jLabel4.setBounds(170, 290, 147, 24);

        txt_placa.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        txt_placa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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
        panel_principal.add(txt_placa);
        txt_placa.setBounds(130, 100, 232, 40);

        label_sms.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        label_sms.setForeground(new java.awt.Color(0, 0, 255));
        label_sms.setText("Ingresa placa");
        panel_principal.add(label_sms);
        label_sms.setBounds(130, 150, 211, 14);

        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        btn_actualizar.setBorder(null);
        btn_actualizar.setContentAreaFilled(false);
        btn_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        panel_principal.add(btn_actualizar);
        btn_actualizar.setBounds(380, 100, 42, 40);

        txt_segundo_nombres.setEditable(false);
        txt_segundo_nombres.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_segundo_nombres.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_segundo_nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_segundo_nombresKeyTyped(evt);
            }
        });
        panel_principal.add(txt_segundo_nombres);
        txt_segundo_nombres.setBounds(120, 220, 260, 35);

        label_nombre.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        label_nombre.setForeground(new java.awt.Color(0, 0, 255));
        label_nombre.setText("Ingresa nombre");
        panel_principal.add(label_nombre);
        label_nombre.setBounds(120, 260, 200, 14);

        combo_vehi_carga.setBackground(new java.awt.Color(204, 255, 204));
        combo_vehi_carga.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        combo_vehi_carga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        combo_vehi_carga.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        combo_vehi_carga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_vehi_cargaActionPerformed(evt);
            }
        });
        panel_principal.add(combo_vehi_carga);
        combo_vehi_carga.setBounds(120, 320, 240, 30);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_principal.add(jButton1);
        jButton1.setBounds(360, 330, 90, 21);

        btn_actulizar_2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_actulizar_2.setText("Guardar Cambios");
        btn_actulizar_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_actulizar_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actulizar_2ActionPerformed(evt);
            }
        });
        panel_principal.add(btn_actulizar_2);
        btn_actulizar_2.setBounds(120, 400, 246, 48);

        tomar_fecha_actu.setText("jLabel1");
        panel_principal.add(tomar_fecha_actu);
        tomar_fecha_actu.setBounds(40, 50, 170, 16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        this.dispose();


    }//GEN-LAST:event_jLabel2MouseClicked

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        // TODO add your handling code here:
        String tipo_vehiculo = combo_vehi_carga.getSelectedItem().toString();
        if (!txt_placa.getText().isEmpty() && !txt_propietario.getText().isEmpty()) {

            // falta el icono
            String opciones[] = {"Registrar", "CANCELAR"};
            int con = showOptionDialog(this, "         Guardar Vehiculo", "Sistema de Ingreso Vehiculos", 1, 1,  new ImageIcon("src/Image_Sms/carro_ingreso_1.png"), opciones, opciones[1]);
            if (con == 0) {

                pasar.setIngresar_vehiculo(txt_placa.getText(), txt_propietario.getText(), tipo_vehiculo, true, this, 0, "");//
                
                Limpiar_Cajas();
            }

        } else if (txt_placa.getText().isEmpty()) {

            label_sms.setVisible(true);

        } else if (txt_propietario.getText().isEmpty()) {

            label_nombre.setVisible(true);
        }
//        } else  {  esta era una validacion del combo , pero como ya quite  el item de seleccionar ya no es necesario
//            
//            lab_tipo.setVisible(true);
//        }


    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void txt_placaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaKeyReleased
        // TODO add your handling code here:

        if (actualizar.equals("")) { //para que cuando se valla actulizar no salga que los vehiculos estan registrado ya  asi

            if (txt_placa.getText().length() >= 7) {

                String texto_label = "Vehiculo Ingresado Actualmente";
                int r = pasar.setPlaca_Cancelada(txt_placa.getText().trim(),true);

                if (r == 1 || r == 2) {
                    combo_vehi_carga.setSelectedItem(pasar.getTipo_vehi());
                    combo_vehi_carga.setEnabled(false);

                    txt_segundo_nombres.setText(pasar.getNombre_propietario());
                    txt_segundo_nombres.setVisible(true);
                    btn_ingresar.setEnabled(false);
                    txt_propietario.setVisible(false);

                    if (r == 1) {
                        texto_label = "Vehiculo Retirado";
                        btn_actualizar.setVisible(true);
                    }
                    if (r == 2) {
                        txt_propietario.setEditable(false);
                    }
                    label_sms.setText(texto_label);
                    label_sms.setVisible(true);

                }

            } else {
                label_sms.setText("Ingresa placa");
                btn_actualizar.setVisible(false);
                label_sms.setVisible(false);
                txt_segundo_nombres.setVisible(false);
                txt_propietario.setVisible(true);
                txt_propietario.setEditable(true);
                btn_ingresar.setEnabled(true);
                combo_vehi_carga.setSelectedItem("Seleccionar");
                combo_vehi_carga.setEnabled(true);

            }

        }


    }//GEN-LAST:event_txt_placaKeyReleased

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // TODO add your handling code here:
        String opciones[] = {"Registrar", "CANCELAR"};
        int con = showOptionDialog(this, "         Guardar Vehiculo", "Sistema de Ingreso Vehiculos", 1, 1, null, opciones, opciones[1]);
        if (con == 0) {

            pasar.setIngresar_vehiculo(txt_placa.getText(), "", "", false, this, 0, "");//ojo boolean

            Limpiar_Cajas();

            //this.dispose();
        }


    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void txt_placaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaKeyTyped
        // TODO add your handling code here:

        char tecla = evt.getKeyChar();

        if (Character.isLowerCase(tecla)) {
            String mayuscula = ("" + tecla).toUpperCase();
            tecla = mayuscula.charAt(0);
            evt.setKeyChar(tecla);

        }
    }//GEN-LAST:event_txt_placaKeyTyped

    private void txt_segundo_nombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_segundo_nombresKeyTyped
        // TODO add your handling code here:

        char tecla = evt.getKeyChar();

        if (Character.isLowerCase(tecla)) {
            String mayuscula = ("" + tecla).toUpperCase();
            tecla = mayuscula.charAt(0);
            evt.setKeyChar(tecla);

        }

    }//GEN-LAST:event_txt_segundo_nombresKeyTyped

    private void txt_propietarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_propietarioKeyTyped
        // TODO add your handling code here:

        char tecla = evt.getKeyChar();

        if (Character.isLowerCase(tecla)) {
            String mayuscula = ("" + tecla).toUpperCase();
            tecla = mayuscula.charAt(0);
            evt.setKeyChar(tecla);

        }
    }//GEN-LAST:event_txt_propietarioKeyTyped

    private void txt_propietarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_propietarioFocusGained
        // TODO add your handling code here:
        label_nombre.setVisible(false);
    }//GEN-LAST:event_txt_propietarioFocusGained

    private void txt_placaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_placaFocusGained
        // TODO add your handling code here:
        label_sms.setVisible(false);
    }//GEN-LAST:event_txt_placaFocusGained

    private void txt_placaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_txt_placaKeyPressed

    private void panel_principalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panel_principalFocusGained
        // TODO add your handling code here:


    }//GEN-LAST:event_panel_principalFocusGained

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        /// label_hola.setText("hola");


    }//GEN-LAST:event_formFocusGained

    private void combo_vehi_cargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_vehi_cargaActionPerformed
        // TODO add your handling code here:

//
    }//GEN-LAST:event_combo_vehi_cargaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        Agregar_Vehiculo pasar = new Agregar_Vehiculo(this, true);
        pasar.setLocationRelativeTo(this);
        pasar.setVisible(true);


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:

        Font font = jButton1.getFont();

        Hashtable<TextAttribute, Object> map
                = new Hashtable<TextAttribute, Object>();

        map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        font = font.deriveFont(map);

        jButton1.setFont(font);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:

        Font font = jButton1.getFont();

        Hashtable<TextAttribute, Object> map
                = new Hashtable<TextAttribute, Object>();

        map.put(TextAttribute.UNDERLINE, -1);
        font = font.deriveFont(map);

        jButton1.setFont(font);
    }//GEN-LAST:event_jButton1MouseExited

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:

        ////aCTUALIZA EL COMBO  DESPUES DE CERRAR EL JDIaLOG AGREGAR Vehiculo/////
        combo_vehi_carga.removeAllItems();
        pasar.sql_Tabla_Tipo_Vehiculos(combo_vehi_carga, "", 0, true, 1);


    }//GEN-LAST:event_formWindowActivated

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_formKeyPressed

    private void panel_principalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panel_principalKeyPressed

        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            this.dispose();

        }
    }//GEN-LAST:event_panel_principalKeyPressed

    private void panel_principalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_principalMouseEntered
        // TODO add your handling code here:
        panel_principal.requestFocusInWindow();
    }//GEN-LAST:event_panel_principalMouseEntered

    private void btn_actulizar_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actulizar_2ActionPerformed
        // TODO add your handling code here:
        Actualizar_Datos();

    }//GEN-LAST:event_btn_actulizar_2ActionPerformed

    /**
     * // * @param args the command line arguments //
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
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ingreso dialog = new Ingreso(new javax.swing.JFrame(), true);
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
    private Conectar_base cn;
    private PreparedStatement pr;
    private ResultSet resultado;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_actulizar_2;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JComboBox<String> combo_vehi_carga;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_sms;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JLabel tomar_fecha_actu;
    private javax.swing.JTextField txt_placa;
    private javax.swing.JTextField txt_propietario;
    private javax.swing.JTextField txt_segundo_nombres;
    // End of variables declaration//GEN-END:variables
}
