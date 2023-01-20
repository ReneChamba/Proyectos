package ventana_Dialogos;

import Logica.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class Recupe_Pass extends javax.swing.JDialog {

    private Validacion_txt validaciones;
    private Intruccion_sql datos_sql;
    private Correo enviar_Correo;
    private Logica_Colores colores;

    public Recupe_Pass(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Cargar_Colores();
        label_err_correo.setVisible(false);
        panel_principal.setFocusable(true);
        Trasparente clave_actual = new Trasparente("Correo  registrado en la cuenta", txt_correo, Trasparente.Show.ALWAYS);
    }

    private void enviar_correo() {
        if (!txt_correo.getText().isEmpty()) {
            validaciones = new Validacion_txt();

            boolean retorno = validaciones.validar_correo(txt_correo.getText());
            if (retorno) {
                datos_sql = new Intruccion_sql();

                //el parametro String solo es necesario que sea diferente de vacio
                boolean correo_existe = datos_sql.getCedula_Existe(txt_correo.getText().trim(), 2, "correo");

                if (correo_existe) { // en el caso que  el correo  si este registrado en la tabla usuarios
                    boolean recibir_estado = datos_sql.getEstado_recu_contra();

                    if (recibir_estado) { // en el caso que este habilitado el usuario
                        String sms_contrase = datos_sql.getNombre_propietario(); //traio la contraseña de la cuenta,
                        //y se la envio como parametro  a la clase correo para que esa contraseña la envie en el sms.
//                          label_err_correo.setText("Enviando solicitud , espere un momento.....");
//                        label_err_correo.setVisible(true);
                        /// System.out.println(sms_contrase);
                        enviar_Correo = new Correo(txt_correo.getText(), sms_contrase);
                      
                        JOptionPane.showMessageDialog(this, "                 Solicitud  Enviada Correctamente " + "\n\nEl Sistema Envio al correo  " + txt_correo.getText() + "\nla contrasaeña de la cuenta","Sistema de Parqueo",-1,new ImageIcon("src/Image_Sms/enviar_correo.png"));
                        this.dispose();

                    } else { // en el caso que la cuenta este desahabilitada
                        JOptionPane.showMessageDialog(this, "Su cuenta se encuentra deshabilitada actualmente","Sistema de Parqueo", -1,new ImageIcon("src/Image_Sms/cuenta_desabili.png"));
                        txt_correo.setText("");

                    }

                } else { // en el caso que el correo  no este registrado en la tabla usuario
                    label_err_correo.setText("Correo no registrado");
                    label_err_correo.setVisible(true);

                }

            } else { // en el caso que no este bien el correo
                label_err_correo.setText("Correo Incorrecto");
                label_err_correo.setVisible(true);
            }

        } else { //en el caso de que  sea vacion el txt
            label_err_correo.setVisible(true);
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
        btn_enviar_solicitud.setBorder(color_bordes);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        label_titulo = new javax.swing.JLabel();
        label_salir = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        btn_enviar_solicitud = new javax.swing.JButton();
        label_err_correo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        label_titulo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo.setText("Recuperar Contraseña");
        label_titulo.setOpaque(true);
        panel_principal.add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 548, 35));

        label_salir.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        label_salir.setForeground(new java.awt.Color(204, 0, 0));
        label_salir.setText("X");
        label_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_salirMouseClicked(evt);
            }
        });
        panel_principal.add(label_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 20, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Digita correo electronico:");
        panel_principal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, 180, 30));

        txt_correo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txt_correo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_correo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_correoFocusGained(evt);
            }
        });
        txt_correo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_correoMouseEntered(evt);
            }
        });
        txt_correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_correoKeyPressed(evt);
            }
        });
        panel_principal.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 290, 30));

        btn_enviar_solicitud.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btn_enviar_solicitud.setText("Enviar Solicitud");
        btn_enviar_solicitud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_enviar_solicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviar_solicitudActionPerformed(evt);
            }
        });
        panel_principal.add(btn_enviar_solicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 230, 50));

        label_err_correo.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        label_err_correo.setForeground(new java.awt.Color(204, 0, 0));
        label_err_correo.setText("Ingresa tú correo");
        panel_principal.add(label_err_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 105, 290, -1));

        getContentPane().add(panel_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_enviar_solicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviar_solicitudActionPerformed

        enviar_correo();

    }//GEN-LAST:event_btn_enviar_solicitudActionPerformed

    private void txt_correoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_correoFocusGained
        // TODO add your handling code here:
        label_err_correo.setVisible(false);
        label_err_correo.setText("Ingresa tú correo");
    }//GEN-LAST:event_txt_correoFocusGained

    private void txt_correoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_correoKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_correoKeyPressed

    private void txt_correoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_correoMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_correoMouseEntered

    private void label_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_salirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_label_salirMouseClicked

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
            java.util.logging.Logger.getLogger(Recupe_Pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recupe_Pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recupe_Pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recupe_Pass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Recupe_Pass dialog = new Recupe_Pass(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_enviar_solicitud;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel label_err_correo;
    private javax.swing.JLabel label_salir;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JTextField txt_correo;
    // End of variables declaration//GEN-END:variables
}
