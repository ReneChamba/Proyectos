package ventana_Dialogos;

import Logica.Intruccion_sql;
import Logica.Logica_Colores;
import Logica.Tabla_Listar;
import Logica.Trasparente;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;

public class Tabla_Auto_Cancelados extends javax.swing.JDialog {

    private Tabla_Listar datos_tabla;
    private Logica_Colores colores;
    private Intruccion_sql sql_datos;

    public Tabla_Auto_Cancelados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Cargar_Colores();
        label_registros_fecha.setVisible(false);
        btn_vaciar_lista.setVisible(false);
        Asignar_Modelo_tabla(3, null);
        panel_principal.setFocusable(true);
        Actualizar_Fecha();
        Trasparente pl = new Trasparente("Ingresa placa a buscar", txt_buscar, Trasparente.Show.ALWAYS);

    }

    private void popMenu() {

        JPopupMenu Objeto_menu = new JPopupMenu();

        JMenuItem item1 = new JMenuItem("Eliminar  Registro", new ImageIcon("src/Imagenes/cancelar.png"));

        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opciones[] = {"Eliminar", "Cancelar"};

                int res = JOptionPane.showOptionDialog(null, "¿  Eliminar Registro ?" + "\n\nPlaca: " +  tabla_vh_cancelados.getValueAt(tabla_vh_cancelados.getSelectedRow(), 1) + "\n"
                        + "Propietario: " + tabla_vh_cancelados.getValueAt(tabla_vh_cancelados.getSelectedRow(), 2) + "\nTipo: " + tabla_vh_cancelados.getValueAt(tabla_vh_cancelados.getSelectedRow(), 3)   , "Sistema de Parqueo", 0, 0, new ImageIcon("src/Image_Sms/eliminar_auto_Salida.png"), opciones, opciones[1]);

                if (res == 0) {
                    Eliminar_Registro(true);
                }

            }

        });

        Objeto_menu.add(item1);

        tabla_vh_cancelados.setComponentPopupMenu(Objeto_menu);

    }

    private void Eliminar_Registro(boolean elegir_eliminar) {

        String placa = "";
        if (elegir_eliminar) {
            placa = tabla_vh_cancelados.getValueAt(tabla_vh_cancelados.getSelectedRow(), 1).toString(); // para el popmenu
        }

        sql_datos = new Intruccion_sql();
        int retorno = 0;
        if (elegir_eliminar) {
            retorno = sql_datos.Actualizar_Tipo_Usuario(placa, false, 1); //si es necesario pasarle la placa xq eliminar solo un registro
            placa = "Registro Eliminado";
        } else {
            retorno = sql_datos.Actualizar_Tipo_Usuario(placa, false, 2);// la placa le paso vacia, no es necesario pasarle, xq va elimina todos los registro
            placa = "Tabla Vaciada correcatamente";
        }

        if (retorno != 0) {
            Asignar_Modelo_tabla(3, null);
            JOptionPane.showMessageDialog(this, placa);
        }

    }

    private void Asignar_Modelo_tabla(int operacion, java.sql.Date sql_fecha) { ///ver en  el metodo cobrar vehiculo
        //en el ultimo parametro , el String , solo es necesario pasarle algo que sea diferente de vacio

        datos_tabla = new Tabla_Listar(tabla_vh_cancelados, true, null, operacion, sql_fecha,null, "Si", txt_buscar, "Tabla cancelada");

        la_num_vehicul.setText("" + datos_tabla.getNumero_filas_regi());

        String tipo_usuario = datos_tabla.getTipo_usuario_2(); // si retorna Admin agrego el popmenu
        if (tipo_usuario.equals("Admin")) {
            btn_vaciar_lista.setVisible(true);
            popMenu();
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
        panel_principal.setBorder(color_bordes);
        label_titulo.setBorder(color_bordes);
        ///////////////////Color de fondo///////////////////////////////////////////////
        colores.get_Colores(fondo, true, 0, 0, 0);
        Color color_fondo = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        panel_principal.setBackground(color_fondo);
        ////////////////Color letra titulos///////////////////////////////////////////
        colores.get_Colores(letra_titulos, true, 0, 0, 0);
        Color color_letra_titulos = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        label_titulo.setForeground(color_letra_titulos);

        ////////////////Color fondo titulos///////////////////////////////////////////
        colores.get_Colores(fondo_titulos, true, 0, 0, 0);
        Color color_fondo_titulos = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        label_titulo.setBackground(color_fondo_titulos);

    }

    private void Actualizar_Fecha() {

        ////////restablece la fecha actual al calendario/////////////////////
        Calendar fecha = Calendar.getInstance();

        calendario.setDate(new java.sql.Date((fecha.get(Calendar.YEAR) - 1900), fecha.get(Calendar.MONTH), fecha.get(Calendar.DATE)));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_vh_cancelados = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();
        label_titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        btn_restablecer = new javax.swing.JButton();
        label_registros_fecha = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        la_num_vehicul = new javax.swing.JLabel();
        calendario = new com.toedter.calendar.JDateChooser();
        btn_vaciar_lista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        tabla_vh_cancelados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_vh_cancelados.setRowHeight(35);
        jScrollPane1.setViewportView(tabla_vh_cancelados);

        panel_principal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 840, 260));

        txt_buscar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_buscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buscarKeyTyped(evt);
            }
        });
        panel_principal.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 150, 290, 40));

        label_titulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo.setText("Ingresos Cancelados");
        label_titulo.setOpaque(true);
        panel_principal.add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 35));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("X");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        panel_principal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(826, 4, -1, 30));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_2/buscar_salidapng.png"))); // NOI18N
        btn_buscar.setContentAreaFilled(false);
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_buscarMouseExited(evt);
            }
        });
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        panel_principal.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 60, 60));

        btn_restablecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_2/cargar_Tabla_2.png"))); // NOI18N
        btn_restablecer.setContentAreaFilled(false);
        btn_restablecer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_restablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restablecerActionPerformed(evt);
            }
        });
        panel_principal.add(btn_restablecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 60, 60));

        label_registros_fecha.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        label_registros_fecha.setForeground(new java.awt.Color(255, 0, 0));
        label_registros_fecha.setText("No hay registros en la fecha especificada");
        panel_principal.add(label_registros_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 197, 300, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("#Vehiculos: ");
        panel_principal.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 110, 30));

        la_num_vehicul.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        la_num_vehicul.setText("0.00");
        panel_principal.add(la_num_vehicul, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 70, 30));

        calendario.setDateFormatString("MMMMM d,yyyy");
        panel_principal.add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 310, 40));

        btn_vaciar_lista.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_vaciar_lista.setText("Vaciar Tabla");
        btn_vaciar_lista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_vaciar_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vaciar_listaActionPerformed(evt);
            }
        });
        panel_principal.add(btn_vaciar_lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 200, 60));

        getContentPane().add(panel_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyTyped
        // TODO add your handling code here:
        char tecla = evt.getKeyChar();

        if (Character.isLowerCase(tecla)) {
            String mayuscula = ("" + tecla).toUpperCase();
            tecla = mayuscula.charAt(0);
            evt.setKeyChar(tecla);

        }

        if (evt.getKeyChar() == '+') {
            evt.consume();
        }
    }//GEN-LAST:event_txt_buscarKeyTyped

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btn_buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseExited
        // TODO add your handling code here:
        label_registros_fecha.setVisible(false);
    }//GEN-LAST:event_btn_buscarMouseExited

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:

        long fecha_calen = calendario.getDate().getTime();
        java.sql.Date fecha_sql_enviar = new java.sql.Date(fecha_calen);

        Asignar_Modelo_tabla(4, fecha_sql_enviar);

        if (tabla_vh_cancelados.getRowCount() == 0) {
            label_registros_fecha.setVisible(true);
        }

    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_restablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restablecerActionPerformed
        // TODO add your handling code here:

        Asignar_Modelo_tabla(3, null);

        Actualizar_Fecha();
    }//GEN-LAST:event_btn_restablecerActionPerformed

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

    private void btn_vaciar_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaciar_listaActionPerformed
        // TODO add your handling code here:

        if (tabla_vh_cancelados.getRowCount() > 0) {

            String opciones[] = {"Si,Eliminar Todo", "Cancelar"};

            int res = JOptionPane.showOptionDialog(null, "¿Vaciar Lista?", "Sistema de Parqueo", 0, 0, new ImageIcon("src/Image_Sms/eliminar_auto_Salida.png"), opciones, opciones[1]);

            if (res == 0) {
                Eliminar_Registro(false);
            }

        }


    }//GEN-LAST:event_btn_vaciar_listaActionPerformed

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
            java.util.logging.Logger.getLogger(Tabla_Auto_Cancelados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla_Auto_Cancelados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla_Auto_Cancelados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla_Auto_Cancelados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tabla_Auto_Cancelados dialog = new Tabla_Auto_Cancelados(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_restablecer;
    private javax.swing.JButton btn_vaciar_lista;
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel la_num_vehicul;
    private javax.swing.JLabel label_registros_fecha;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JTable tabla_vh_cancelados;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
