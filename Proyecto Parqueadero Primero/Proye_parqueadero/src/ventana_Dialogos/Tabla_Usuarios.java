package ventana_Dialogos;

import Diseno.Registrarse;
import Logica.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Tabla_Usuarios extends javax.swing.JDialog {

    private Intruccion_sql datos_sql;
    private Logica_Colores colores;

    public Tabla_Usuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        datos_sql = new Intruccion_sql();
        combo_tipo_usua.setUI(new Personalizar_combo(0));
        Tabla_Usuarios(1);
        panel_usuarios.setFocusable(true);

    }

    private void Tabla_Usuarios(int cargar_tipo_usuario) { //el parametro marca que tipo de usuario mostrar
        Tabla_Listar pasar = new Tabla_Listar(tabla_usu_admin, txt_buscar, cargar_tipo_usuario);

        JPopupMenu Objeto_menu = new JPopupMenu();
        /// Objeto_menu.setBackground(Color.GREEN);

        JMenuItem item1 = new JMenuItem("Eliminar Cuenta", new ImageIcon("src/Image_2/eliminar_rcuenta.png"));
        //JMenuItem estado = new JMenuItem("ES", new ImageIcon("src/Image_2/ELIMINAR.png"));

        // item1.setBackground(Color.red);
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Elimnar_Usuario();

            }
        });

        Objeto_menu.add(item1);

        tabla_usu_admin.setComponentPopupMenu(Objeto_menu);

        Trasparente clave_actual = new Trasparente("Digita número de  cédula", txt_buscar, Trasparente.Show.ALWAYS);

        Cargar_Colores();

    }

    private void Elimnar_Usuario() {
        String opciones[] = {"Si,Eliminar", "Cancelar"};

        String cedula = tabla_usu_admin.getValueAt(tabla_usu_admin.getSelectedRow(), 1).toString();
        String cuenta = tabla_usu_admin.getValueAt(tabla_usu_admin.getSelectedRow(), 7).toString();
        String nombre = tabla_usu_admin.getValueAt(tabla_usu_admin.getSelectedRow(), 2).toString();

        int resp = JOptionPane.showOptionDialog(this, "     Eliminar Cuenta" + "\n\nCédula:   " + cedula + "\nNombre: " + nombre + "\nCuenta:   " + cuenta, "Sistema de Parqueo", 0, 0, new ImageIcon("src/Image_2/eliminar_rcuenta.png"), opciones, opciones[1]);

        if (resp == 0) {

            int re = datos_sql.setInsertar("", "", "", "", "", "", "", "", "", 3, "", tabla_usu_admin.getValueAt(tabla_usu_admin.getSelectedRow(), 1).toString());
            if (re != 0) {
                JOptionPane.showMessageDialog(this, "Cuenta Elminada Correctamente" , "Sistema de Parqueo",-1, new ImageIcon("src/Image_Sms/visto_bien.png"));
                Tabla_Usuarios(1);
            }

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
        String color_funciones = colores.getColor_letra_funciones();
        /////////////////////////////////////////////////////////////////////////////
        ////////////////Color letra titulos///////////////////////////////////////////
        colores.get_Colores(letra_titulos, true, 0, 0, 0);
        Color color_letra_titulos = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        label_titulo.setForeground(color_letra_titulos);

        ////////////////////Color del borde///////////////////////////////////////
        colores.get_Colores(borde, true, 0, 0, 0);
        LineBorder color_bordes = new LineBorder(new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul()), 3, true);
        panel_usuarios.setBorder(color_bordes);
        label_titulo.setBorder(color_bordes);
        combo_tipo_usua.setBorder(color_bordes);
        ///btn_operaciones.setBorder(color_bordes);

        ///////////////////Color de fondo///////////////////////////////////////////////
        colores.get_Colores(fondo, true, 0, 0, 0);
        Color color_fondo = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        panel_usuarios.setBackground(color_fondo);
        ///label_titulo.setBackground(color_fondo);

        ////////////////Color fondo titulos///////////////////////////////////////////
        colores.get_Colores(fondo_titulos, true, 0, 0, 0);
        Color color_fondo_titulos = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        label_titulo.setBackground(color_fondo_titulos);
        ///////////COLOR LETRA FUNCIONES/ BTN/////////////////////////////
        colores.get_Colores(color_funciones, true, 0, 0, 0);
        Color co_funciones = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());

        ///  btn_operaciones.setForeground(co_funciones);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_usuarios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_usu_admin = new javax.swing.JTable();
        label_titulo = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        combo_tipo_usua = new javax.swing.JComboBox<>();
        label_enlace = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_usuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        panel_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_usuariosMouseEntered(evt);
            }
        });
        panel_usuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panel_usuariosKeyPressed(evt);
            }
        });
        panel_usuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_usu_admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_usu_admin.setRowHeight(35);
        tabla_usu_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_usu_adminMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_usu_adminMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_usu_admin);

        panel_usuarios.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 297, 1220, 180));

        label_titulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo.setText("USUARIOS Y ADMINISTRADORES");
        label_titulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        label_titulo.setOpaque(true);
        panel_usuarios.add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 1200, 35));

        txt_buscar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_buscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panel_usuarios.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 320, 40));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setText("X");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_usuarios.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, -8, -1, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bus_nueaaa.png"))); // NOI18N
        panel_usuarios.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 240, 50, 40));

        combo_tipo_usua.setBackground(new java.awt.Color(204, 255, 204));
        combo_tipo_usua.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        combo_tipo_usua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Admin", "Empleado" }));
        combo_tipo_usua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        combo_tipo_usua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        combo_tipo_usua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tipo_usuaActionPerformed(evt);
            }
        });
        panel_usuarios.add(combo_tipo_usua, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 180, 40));

        label_enlace.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_enlace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_enlace.setText("Crear Nueva Cuenta");
        label_enlace.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_enlace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_enlaceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_enlaceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_enlaceMouseExited(evt);
            }
        });
        panel_usuarios.add(label_enlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 80, 210, -1));

        getContentPane().add(panel_usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_usu_adminMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_usu_adminMousePressed
        // TODO add your handling code here:
        int columnas = tabla_usu_admin.getColumnModel().getColumnIndexAtX(evt.getX());
        if (tabla_usu_admin.getRowCount() >= 0) {
            int filas = evt.getY() / (tabla_usu_admin.getRowHeight());
            if (filas < tabla_usu_admin.getRowCount() && filas >= 0 && columnas < tabla_usu_admin.getColumnModel().getColumnCount() && columnas >= 0) {
                Object value = tabla_usu_admin.getValueAt(filas, columnas);

                if (value instanceof JCheckBox) {
                    ((JCheckBox) value).doClick();
                    ImageIcon icono = null;
                    JCheckBox checc = (JCheckBox) value;

                    String activar = null;
                    String palabra = null;
                    if (checc.isSelected()) {
                        activar = "Activar Cuenta";
                        palabra = "AC";
                          icono = new ImageIcon("src/Image_Sms/cuenta_habilitar.png");
                    } else {
                        activar = "Desactivar  Cuenta";
                        palabra = "DC";
                        icono = new ImageIcon("src/Image_Sms/cuenta_desabili.png");
                    }
                    String opciones[] = {activar, "Cancelar"};

                

                    /*
                    Control de la pregunta activar o descativar
                     */
                    int res = JOptionPane.showOptionDialog(this, "Seguro (a) desea " + activar, "Sistema de Parqueo", 0, 0, icono, opciones, opciones[1]);

                    if (res == 0) {

                        datos_sql.setInsertar("", "", "", "", "", "", "", "", "", 1, palabra, tabla_usu_admin.getValueAt(tabla_usu_admin.getSelectedRow(), 1).toString());

                        //Los ultimo tres parametros son  los importantes
                    } else if (res == 1) {

                        if (activar.equals("Activar Cuenta")) {
                            checc.setSelected(false);
                        } else {
                            checc.setSelected(true);
                        }
                    }

                }

            }

        }
    }//GEN-LAST:event_tabla_usu_adminMousePressed

    private void tabla_usu_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_usu_adminMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_usu_adminMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void combo_tipo_usuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tipo_usuaActionPerformed
        // TODO add your handling code here:
        int opciones = combo_tipo_usua.getSelectedIndex();
        int valor = 0;
        switch (opciones) {
            case 0:
                valor = 1;
                break;
            case 1:
                valor = 2;
                break;
            case 2:
                valor = 3;
                break;
            default:
                break;
        }

        Tabla_Usuarios(valor);

    }//GEN-LAST:event_combo_tipo_usuaActionPerformed

    private void panel_usuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_usuariosMouseEntered
        // TODO add your handling code here:
        panel_usuarios.requestFocusInWindow();
    }//GEN-LAST:event_panel_usuariosMouseEntered

    private void panel_usuariosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panel_usuariosKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            this.dispose();

        }
    }//GEN-LAST:event_panel_usuariosKeyPressed

    private void label_enlaceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_enlaceMouseEntered
        // TODO add your handling code here

        Font font = label_enlace.getFont();

        Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();

        map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        font = font.deriveFont(map);

        label_enlace.setFont(font);

    }//GEN-LAST:event_label_enlaceMouseEntered

    private void label_enlaceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_enlaceMouseExited
        // TODO add your handling code here:
        Font font = label_enlace.getFont();

        Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();

        map.put(TextAttribute.UNDERLINE, -1);
        font = font.deriveFont(map);

        label_enlace.setFont(font);
    }//GEN-LAST:event_label_enlaceMouseExited

    private void label_enlaceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_enlaceMouseClicked
        // TODO add your handling code here:

        Registrarse pasar = new Registrarse(this, true);
        this.dispose();
        pasar.setVisible(true);


    }//GEN-LAST:event_label_enlaceMouseClicked

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
            java.util.logging.Logger.getLogger(Tabla_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tabla_Usuarios dialog = new Tabla_Usuarios(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> combo_tipo_usua;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_enlace;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JPanel panel_usuarios;
    private javax.swing.JTable tabla_usu_admin;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
