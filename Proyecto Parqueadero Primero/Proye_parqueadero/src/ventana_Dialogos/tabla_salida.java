package ventana_Dialogos;

import Logica.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.sql.Date;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;

public class tabla_salida extends javax.swing.JDialog {

    private Tabla_Listar datos_salida;
    private Intruccion_sql intruccios_sql;
    private Logica_Colores colores;
    private int num_filas;

    public tabla_salida(JFrame parent, boolean modal) {
        super(parent, modal);
        Estado_inicial_contructor();

    }

    private void Estado_inicial_contructor() {
        initComponents();
        this.setLocationRelativeTo(null);
        intruccios_sql = new Intruccion_sql();
        Modelo_Tabla(2, null);
        Cargar_Colores();
        panel_tabla.setFocusable(true);
        label_registros_fecha.setVisible(false);
        label_placa_desconocida.setVisible(false);
        Actualizar_Fecha();

    }

    private void Modelo_Tabla(int operacion, Date sql_fecha) {

        ArrayList datos_text = new ArrayList();// le páso el aarray para que lo llene con las placas de autso salidsp

        datos_salida = new Tabla_Listar(tabla_salida, false, datos_text, operacion, sql_fecha, null,"si", txt_buscar_cedula, "");

        num_filas = datos_salida.getNumero_filas_regi();
        if (num_filas > 0) {
            label_numer_vehiculos.setText("" + num_filas); ///NUMERO DE FILAS QUE TRAE LA CONSULTA
            label_suma_totales.setText("" + datos_salida.getTotal_tabla_ing_salida()); //TOTAL COBRADO
            label_registros_fecha.setVisible(false);

        } else {
            label_registros_fecha.setVisible(true);
            label_numer_vehiculos.setText("0");
            label_suma_totales.setText("0.00");

        }

        AutoCompleteDecorator.decorate(txt_buscar_cedula, datos_text, false, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);

        Trasparente pl = new Trasparente("Ingresa placa a buscar", txt_buscar_cedula, Trasparente.Show.ALWAYS);

        /*
        Traigo el tipo_usuario  de la consulta que realize en  Tabla_listar , y dependiendo de que lo devuelve 
        muestro o no el botón
         */
        if (!datos_salida.getTipo_usuario_2().equals("Admin")) {
            btn_vaciar_tabla.setVisible(false);
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

        ////////////////////Color del borde///////////////////////////////////////
        colores.get_Colores(borde, true, 0, 0, 0);
        LineBorder color_bordes = new LineBorder(new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul()), 3, true);
        panel_tabla.setBorder(color_bordes);
        label_titulo.setBorder(color_bordes);
        ///////////////////Color de fondo///////////////////////////////////////////////
        colores.get_Colores(fondo, true, 0, 0, 0);
        Color color_fondo = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        panel_tabla.setBackground(color_fondo);
        ////////////////Color letra titulos///////////////////////////////////////////
        colores.get_Colores(letra_titulos, true, 0, 0, 0);
        Color color_letra_titulos = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        label_titulo.setForeground(color_letra_titulos);

        ////////////////Color fondo titulos///////////////////////////////////////////
        colores.get_Colores(fondo_titulos, true, 0, 0, 0);
        Color color_fondo_titulos = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        label_titulo.setBackground(color_fondo_titulos);

    }

    private void Eliminar() {

        int row = tabla_salida.getSelectedRow();
        String placa = tabla_salida.getValueAt(row, 1).toString();
        String placa_joption = tabla_salida.getValueAt(row, 1).toString();
        String nombre_joption = tabla_salida.getValueAt(row, 2).toString();
        String opciones[] = {"Eliminar", "Cancelar"};

        int res = JOptionPane.showOptionDialog(this, "Seguro desea eliminar el registro" + "\n\n Placa: " + placa_joption + "\nPropietario: " + nombre_joption, "Sistema de Parqueo", 0, 0,  new ImageIcon("src/Image_Sms/eliminar_auto_Salida.png"), opciones, opciones[1]);

        if (res == 0) {
            // el 2 le paso para que solo elimine un registro de la tabla////// el null es de la fecha , y los dos 0 siguientes no hacen nada no afecta en  nada no son parte del metodo , si le paso false hay si //

            intruccios_sql.setIngresar_vehiculo_Adminis(true, null, 0, 0, 0, 2, placa, "", "", 0, "", "", 0, 0, 0, 0, 0);

            JOptionPane.showMessageDialog(this, "Registro Eliminado Correctamente");
            Modelo_Tabla(2, null);
            Actualizar_Fecha();
        }

    }

    private void Actualizar_Fecha() {

        ////////restablece la fecha actual al calendario/////////////////////
        Calendar fecha = Calendar.getInstance();

        calendario.setDate(new Date((fecha.get(Calendar.YEAR) - 1900), fecha.get(Calendar.MONTH), fecha.get(Calendar.DATE)));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_tabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_salida = new javax.swing.JTable();
        label_titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_buscar_cedula = new javax.swing.JTextField();
        btn_imprimir = new javax.swing.JButton();
        btn_vaciar_tabla = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        label_registros_fecha = new javax.swing.JLabel();
        btn_restablecer = new javax.swing.JButton();
        label_placa_desconocida = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        label_suma_totales = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        label_numer_vehiculos = new javax.swing.JLabel();
        calendario = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        panel_tabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        panel_tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_tablaMouseEntered(evt);
            }
        });
        panel_tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panel_tablaKeyPressed(evt);
            }
        });
        panel_tabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_salida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51)));
        tabla_salida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_salida.setRowHeight(35);
        tabla_salida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_salidaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabla_salidaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tabla_salidaMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_salida);

        panel_tabla.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 1330, 260));

        label_titulo.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        label_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo.setText("Vehiculos  Retirados ");
        label_titulo.setOpaque(true);
        panel_tabla.add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("X");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel2KeyReleased(evt);
            }
        });
        panel_tabla.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1304, 5, 30, 30));

        txt_buscar_cedula.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_buscar_cedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_buscar_cedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_buscar_cedulaFocusGained(evt);
            }
        });
        txt_buscar_cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscar_cedulaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscar_cedulaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buscar_cedulaKeyTyped(evt);
            }
        });
        panel_tabla.add(txt_buscar_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 185, 350, 40));

        btn_imprimir.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btn_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_2/impresora.png"))); // NOI18N
        btn_imprimir.setText("Imprimir ");
        btn_imprimir.setBorder(null);
        btn_imprimir.setContentAreaFilled(false);
        btn_imprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_imprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_imprimir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_imprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_imprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_imprimirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_imprimirMouseExited(evt);
            }
        });
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });
        panel_tabla.add(btn_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 90, 80));

        btn_vaciar_tabla.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btn_vaciar_tabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_2/Elimi_nar.png"))); // NOI18N
        btn_vaciar_tabla.setText("Vaciar Tabla");
        btn_vaciar_tabla.setContentAreaFilled(false);
        btn_vaciar_tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_vaciar_tabla.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_vaciar_tabla.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btn_vaciar_tabla.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_vaciar_tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_vaciar_tablaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_vaciar_tablaMouseExited(evt);
            }
        });
        btn_vaciar_tabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vaciar_tablaActionPerformed(evt);
            }
        });
        panel_tabla.add(btn_vaciar_tabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 50, 120, 80));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_2/buscar_salidapng.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_tabla.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 60, 60));

        label_registros_fecha.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        label_registros_fecha.setForeground(new java.awt.Color(255, 0, 0));
        label_registros_fecha.setText("No hay registros en la fecha especificada");
        panel_tabla.add(label_registros_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 227, 300, -1));

        btn_restablecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_2/cargar_Tabla_2.png"))); // NOI18N
        btn_restablecer.setContentAreaFilled(false);
        btn_restablecer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_restablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restablecerActionPerformed(evt);
            }
        });
        panel_tabla.add(btn_restablecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 60, 60));

        label_placa_desconocida.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        label_placa_desconocida.setForeground(new java.awt.Color(204, 0, 0));
        label_placa_desconocida.setText("Placa desconocida");
        panel_tabla.add(label_placa_desconocida, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 227, 300, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setText("Total Ingresos: ");
        panel_tabla.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 120, 30));

        label_suma_totales.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        label_suma_totales.setText("0.00");
        panel_tabla.add(label_suma_totales, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 110, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setText("# Vehiculos: ");
        panel_tabla.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        label_numer_vehiculos.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        label_numer_vehiculos.setText("0.00");
        panel_tabla.add(label_numer_vehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 80, -1));

        calendario.setDateFormatString("MMMMM d,yyyy");
        panel_tabla.add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 185, 310, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(panel_tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 1342, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_salidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_salidaMouseClicked
        // TODO add your handling code here:
        int columnas = tabla_salida.getColumnModel().getColumnIndexAtX(evt.getX());

        int filas = evt.getY() / tabla_salida.getRowHeight();
        if (filas < tabla_salida.getRowCount() && filas >= 0 && columnas < tabla_salida.getColumnModel().getColumnCount() && columnas >= 0) {
            Object value = tabla_salida.getValueAt(filas, columnas);

            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
                Eliminar();

            }

        }


    }//GEN-LAST:event_tabla_salidaMouseClicked

    private void tabla_salidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_salidaMouseEntered


    }//GEN-LAST:event_tabla_salidaMouseEntered

    private void tabla_salidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_salidaMouseExited
        // TODO add your handling code here:


    }//GEN-LAST:event_tabla_salidaMouseExited

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_formMouseEntered

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_buscar_cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_cedulaKeyTyped
        // TODO add your handling code here:
        char tecla = evt.getKeyChar();

        if (Character.isLowerCase(tecla)) {
            String mayuscula = ("" + tecla).toUpperCase();
            tecla = mayuscula.charAt(0);
            evt.setKeyChar(tecla);

        }
    }//GEN-LAST:event_txt_buscar_cedulaKeyTyped

    private void txt_buscar_cedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_cedulaKeyPressed
        // TODO add your handling code here:
        if (!txt_buscar_cedula.getText().isEmpty() && tabla_salida.getRowCount() >= 0) {

            if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
                String nombre = txt_buscar_cedula.getText();
                boolean es = true;
                int to_fil = tabla_salida.getRowCount();
                while (es) {
                    to_fil--;
                    String nombre_placa = tabla_salida.getValueAt(to_fil, 1).toString();

                    if (nombre.equals(nombre_placa)) {

                        tabla_salida.setRowSelectionInterval(to_fil, to_fil);///

                        es = false;
                    }

                    if (to_fil == 0 && es) {
                        es = false;
                        label_placa_desconocida.setVisible(true);
                    }
                }
            }

        }
    }//GEN-LAST:event_txt_buscar_cedulaKeyPressed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        // TODO add your handling code here:
        try {

            if (tabla_salida.getRowCount() > 0) {
                tabla_salida.print();
            } else {
                JOptionPane.showMessageDialog(this, "No Hay Registro A Imprimir");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ha surguido un error en este momento " + e.getMessage());
        }
    }//GEN-LAST:event_btn_imprimirActionPerformed

    private void btn_vaciar_tablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaciar_tablaActionPerformed
        // TODO add your handling code here:

        if (tabla_salida.getRowCount() > 0) {

            String opciones[] = {"Vaciar Tabla", "Cancelar"};

            int res = JOptionPane.showOptionDialog(this, "Seguro desea  Vaciar Toda la tabla", "Sistema de Parqueo", 0, 0, null, opciones, opciones[1]);

            if (res == 0) {
                // el 1 le paso para que elimine todos los datos de la tabla// los dos 0 no afecta en  nada no son parte del metodo , si le paso false hay si //

                intruccios_sql.setIngresar_vehiculo_Adminis(true, null, 0, 0, 0, 1, "", "", "", 0, "", "", 0, 0, 0, 0, 0);

                JOptionPane.showMessageDialog(this, "Tabla Vaciada Correctamente");
                Modelo_Tabla(2, null);
                Actualizar_Fecha();
            }

        } else {
            JOptionPane.showMessageDialog(this, "La Tabla Se Encuentra Vacia Actualmente");
        }


    }//GEN-LAST:event_btn_vaciar_tablaActionPerformed

    private void jLabel2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        /////////////////////////Fecha hoy ////////////////////////////////////////////////////
//        Calendar fecha = Calendar.getInstance();
//        java.sql.Date fecha_hoy = new java.sql.Date((fecha.get(Calendar.YEAR) - 1900), fecha.get(Calendar.MONTH), fecha.get(Calendar.DATE));
//
//        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//        String fecha_actu = formato.format(fecha_hoy); /// lo paso a ese fomrato para comparar con la hora que esta en el calendario
//        //////////////////////////////////////////////////////////////////////
        long fecha_calen = calendario.getDate().getTime();
        java.sql.Date fecha_sql_enviar = new java.sql.Date(fecha_calen);

        /// HAY Q TRATAR QUE EL TXT SOLO BUSQUE LAS PLACAS QUE SE VEN EN LA TABLA EN ESE MOMENTOS
        /////////////////////////////////////////////////////////////
        ///String fecha_cale = formato.format(fecha_sql_enviar);
        ///Comparo si la fecha de hoy con la fecha del calendar , si son iguales no hago nada , si son diferentes hay si hago q busque
//        if (!fecha_actu.equals(fecha_cale)) {
        Modelo_Tabla(1, fecha_sql_enviar);

//        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        label_registros_fecha.setVisible(false);
    }//GEN-LAST:event_jButton1MouseExited

    private void txt_buscar_cedulaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_buscar_cedulaFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_buscar_cedulaFocusGained

    private void txt_buscar_cedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_cedulaKeyReleased
        // TODO add your handling code here:

        if (evt.getKeyChar() != KeyEvent.VK_ENTER) {
            label_placa_desconocida.setVisible(false);
        }


    }//GEN-LAST:event_txt_buscar_cedulaKeyReleased

    private void btn_restablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restablecerActionPerformed
        // TODO add your handling code here:

        //Tabla_Listar numero_filas = new Tabla_Listar();
        datos_salida = new Tabla_Listar(null, true, null, 0, null,null, "no", txt_buscar_cedula, ""); // le paso el string no paras que no me acarge la tabla , xq solo quiero sabe las filas de la tabla de l base dae datos

        /// solo es importante pasarle al String "no"  q es la pregunta de control
        int retorno_filas = datos_salida.total_filas(false);

        if (tabla_salida.getRowCount() != retorno_filas) {
            Modelo_Tabla(2, null);

        }

        Actualizar_Fecha();

    }//GEN-LAST:event_btn_restablecerActionPerformed

    private void panel_tablaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_tablaMouseEntered
        // TODO add your handling code here:
        panel_tabla.requestFocusInWindow();
    }//GEN-LAST:event_panel_tablaMouseEntered

    private void panel_tablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panel_tablaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_panel_tablaKeyPressed

    private void btn_imprimirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_imprimirMouseEntered
        // TODO add your handling code here:

        Font font = btn_imprimir.getFont();

        Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();

        map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        font = font.deriveFont(map);

        btn_imprimir.setFont(font);

    }//GEN-LAST:event_btn_imprimirMouseEntered

    private void btn_vaciar_tablaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_vaciar_tablaMouseEntered
        // TODO add your handling code here:
        Font font = btn_vaciar_tabla.getFont();

        Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();

        map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        font = font.deriveFont(map);

        btn_vaciar_tabla.setFont(font);
    }//GEN-LAST:event_btn_vaciar_tablaMouseEntered

    private void btn_vaciar_tablaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_vaciar_tablaMouseExited
        // TODO add your handling code here:
           Font font = btn_vaciar_tabla.getFont();

        Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();

        map.put(TextAttribute.UNDERLINE, -1);
        font = font.deriveFont(map);

        btn_vaciar_tabla.setFont(font);

    }//GEN-LAST:event_btn_vaciar_tablaMouseExited

    private void btn_imprimirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_imprimirMouseExited
        // TODO add your handling code here:
        Font font = btn_imprimir.getFont();

        Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();

        map.put(TextAttribute.UNDERLINE, -1);
        font = font.deriveFont(map);

        btn_imprimir.setFont(font);


    }//GEN-LAST:event_btn_imprimirMouseExited

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
            java.util.logging.Logger.getLogger(tabla_salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tabla_salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tabla_salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tabla_salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tabla_salida dialog = new tabla_salida(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_restablecer;
    private javax.swing.JButton btn_vaciar_tabla;
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_numer_vehiculos;
    private javax.swing.JLabel label_placa_desconocida;
    private javax.swing.JLabel label_registros_fecha;
    private javax.swing.JLabel label_suma_totales;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JPanel panel_tabla;
    private javax.swing.JTable tabla_salida;
    private javax.swing.JTextField txt_buscar_cedula;
    // End of variables declaration//GEN-END:variables
}
