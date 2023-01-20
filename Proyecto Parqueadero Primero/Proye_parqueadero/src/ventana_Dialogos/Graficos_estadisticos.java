package ventana_Dialogos;

import Logica.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import javax.swing.border.LineBorder;

public class Graficos_estadisticos extends javax.swing.JDialog {

    private Logica_Colores colores;

    public Graficos_estadisticos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        combo_Horientacion.setVisible(false);
        frame_interno.setVisible(false);
        combo_tabla.setUI(new Personalizar_combo(0));  // le paso 0 para que no aguegue imagenes a los combos
        combo_modelo.setUI(new Personalizar_combo(0));
        combo_normal_3D.setUI(new Personalizar_combo(0));
        combo_Horientacion.setUI(new Personalizar_combo(0));
        Cargar_Colores();
        Actualizar_Fecha();
        panel_principal.setFocusable(true);

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
        ////////////////Color letra titulos///////////////////////////////////////////
        colores.get_Colores(letra_titulos, true, 0, 0, 0);
        Color color_letra_titulos = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        label_titulo.setForeground(color_letra_titulos);

        ////////////////////Color del borde///////////////////////////////////////
        colores.get_Colores(borde, true, 0, 0, 0);
        LineBorder color_bordes = new LineBorder(new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul()), 3, true);
        panel_principal.setBorder(color_bordes);
        panel_gesti_grafico.setBorder(color_bordes);
        label_titulo.setBorder(color_bordes);
        btn_generar_grafico.setBorder(color_bordes);
        frame_interno.setBorder(color_bordes);

        combo_tabla.setBorder(color_bordes);
        combo_modelo.setBorder(color_bordes);
        combo_normal_3D.setBorder(color_bordes);
        combo_Horientacion.setBorder(color_bordes);

        ///////////////////Color de fondo///////////////////////////////////////////////
        colores.get_Colores(fondo, true, 0, 0, 0);
        Color color_fondo = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        panel_principal.setBackground(color_fondo);
        panel_gesti_grafico.setBackground(color_fondo);
        panel_bus_fecha.setBackground(color_fondo);

        ////////////////Color fondo titulos///////////////////////////////////////////
        colores.get_Colores(fondo_titulos, true, 0, 0, 0);
        Color color_fondo_titulos = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        label_titulo.setBackground(color_fondo_titulos);

        ////////////////////Color letra funciones///////////////////////  
        colores.get_Colores(color_funciones, true, 0, 0, 0);
        Color letra_funciones_color = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        btn_generar_grafico.setForeground(letra_funciones_color);

    }

    private void Actualizar_Fecha() {

        ////////restablece la fecha actual al calendario/////////////////////
        Calendar fecha = Calendar.getInstance();

        calendario_Inicio.setDate(new java.sql.Date((fecha.get(Calendar.YEAR) - 1900), fecha.get(Calendar.MONTH), fecha.get(Calendar.DATE)));
        calendario_final.setDate(new java.sql.Date((fecha.get(Calendar.YEAR) - 1900), fecha.get(Calendar.MONTH), fecha.get(Calendar.DATE)));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        frame_interno = new javax.swing.JInternalFrame();
        label_titulo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panel_gesti_grafico = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        combo_tabla = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        combo_modelo = new javax.swing.JComboBox<>();
        combo_normal_3D = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        combo_Horientacion = new javax.swing.JComboBox<>();
        check_habil_panel = new javax.swing.JCheckBox();
        panel_bus_fecha = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        calendario_Inicio = new com.toedter.calendar.JDateChooser();
        calendario_final = new com.toedter.calendar.JDateChooser();
        btn_generar_grafico = new javax.swing.JButton();

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

        frame_interno.setClosable(true);
        frame_interno.setVisible(true);

        javax.swing.GroupLayout frame_internoLayout = new javax.swing.GroupLayout(frame_interno.getContentPane());
        frame_interno.getContentPane().setLayout(frame_internoLayout);
        frame_internoLayout.setHorizontalGroup(
            frame_internoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 778, Short.MAX_VALUE)
        );
        frame_internoLayout.setVerticalGroup(
            frame_internoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );

        panel_principal.add(frame_interno, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 780, 580));

        label_titulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo.setText("Gestionar Graficos Estadisticos");
        label_titulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        label_titulo.setOpaque(true);
        panel_principal.add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 35));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("X");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        panel_principal.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1294, 4, 20, 30));

        panel_gesti_grafico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_gesti_grafico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Parametro:");
        panel_gesti_grafico.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 90, 30));

        combo_tabla.setBackground(new java.awt.Color(204, 255, 204));
        combo_tabla.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        combo_tabla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "# Vehiculos Ingresados Actualmente", "Dolares Cobrados X Vehiculos Retirados", "#Horas  X Vehiculos Cobrados" }));
        combo_tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_gesti_grafico.add(combo_tabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 360, 40));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Tipo:");
        panel_gesti_grafico.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 90, 30));

        combo_modelo.setBackground(new java.awt.Color(204, 255, 204));
        combo_modelo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        combo_modelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grafico Pastel", "Grafico Barra" }));
        combo_modelo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        combo_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_modeloActionPerformed(evt);
            }
        });
        panel_gesti_grafico.add(combo_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 200, 40));

        combo_normal_3D.setBackground(new java.awt.Color(204, 255, 204));
        combo_normal_3D.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        combo_normal_3D.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "3D" }));
        combo_normal_3D.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        combo_normal_3D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_normal_3DActionPerformed(evt);
            }
        });
        panel_gesti_grafico.add(combo_normal_3D, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 200, 40));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Modelo");
        panel_gesti_grafico.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 80, 30));

        combo_Horientacion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        combo_Horientacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horizontal", "Vertical" }));
        combo_Horientacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_gesti_grafico.add(combo_Horientacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 200, 40));

        check_habil_panel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        check_habil_panel.setText("Habilitar Busqueda  Por Fecha");
        check_habil_panel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_habil_panelActionPerformed(evt);
            }
        });
        panel_gesti_grafico.add(check_habil_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 270, -1));

        panel_bus_fecha.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray, 2));
        panel_bus_fecha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Fecha Inicio:");
        panel_bus_fecha.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Fecha Final:");
        panel_bus_fecha.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 100, 30));

        calendario_Inicio.setDateFormatString("MMMMM d,yyyy");
        panel_bus_fecha.add(calendario_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 250, 30));

        calendario_final.setDateFormatString("MMMMM d,yyyy");
        panel_bus_fecha.add(calendario_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 250, 30));

        panel_gesti_grafico.add(panel_bus_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 400, 140));

        btn_generar_grafico.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_generar_grafico.setText("Generar Grafico");
        btn_generar_grafico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_generar_grafico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_generar_graficoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_generar_graficoMouseExited(evt);
            }
        });
        btn_generar_grafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generar_graficoActionPerformed(evt);
            }
        });
        panel_gesti_grafico.add(btn_generar_grafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 190, 60));

        panel_principal.add(panel_gesti_grafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, 480, 570));

        getContentPane().add(panel_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_generar_graficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generar_graficoActionPerformed
        // TODO add your handling code here:

        int elegir_tablla = combo_tabla.getSelectedIndex();
        int elegir_modelo = combo_modelo.getSelectedIndex();
        int elegir_perso_pastel_barra = 0;///combo_normal_3D.getSelectedIndex();
        ///int elegir_person_barra = combo_Horientacion.getSelectedIndex();

        if (combo_normal_3D.isVisible()) {
            elegir_perso_pastel_barra = combo_normal_3D.getSelectedIndex();

        } else if (combo_Horientacion.isVisible()) {
            elegir_perso_pastel_barra = combo_Horientacion.getSelectedIndex();
        }

        //Objetos para  crear fechas ///////////////////////////////
        long fecha_calen_inicio = 0;
        java.sql.Date fecha_sql_inicio = null;

        long fecha_calen_final = 0;
        java.sql.Date fecha_sql_final = null;
        if (check_habil_panel.isSelected()) {

            ///Obtengo la fecha de inicio // para la consulta
            fecha_calen_inicio = calendario_Inicio.getDate().getTime();
            fecha_sql_inicio = new java.sql.Date(fecha_calen_inicio);

            ///Obtengo la fecha de inicio // para la consulta
            fecha_calen_final = calendario_final.getDate().getTime();
            fecha_sql_final = new java.sql.Date(fecha_calen_final);

        }

        Dibujar_Graficos panel_grafico = new Dibujar_Graficos();

        try {
            frame_interno.setContentPane(panel_grafico.getGrafica(combo_tabla.getSelectedIndex(), combo_modelo.getSelectedIndex(), elegir_perso_pastel_barra, fecha_sql_inicio, fecha_sql_final));
            frame_interno.setVisible(true);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btn_generar_graficoActionPerformed

    private void check_habil_panelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_habil_panelActionPerformed

        if (!check_habil_panel.isSelected()) {

            LineBorder color_bordes = new LineBorder(Color.GRAY, 3, true);
            Actualizar_Fecha();
            panel_bus_fecha.setBorder(color_bordes);

        } else {
            LineBorder color_bordes = new LineBorder(label_titulo.getBackground(), 3, true);
            panel_bus_fecha.setBorder(color_bordes);

        }


    }//GEN-LAST:event_check_habil_panelActionPerformed

    private void combo_normal_3DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_normal_3DActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_combo_normal_3DActionPerformed

    private void combo_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_modeloActionPerformed
        // TODO add your handling code here:
        if (combo_modelo.getSelectedIndex() == 0) {

            combo_Horientacion.setVisible(false);
            combo_Horientacion.setSelectedIndex(0);
            combo_normal_3D.setVisible(true);

        } else if (combo_modelo.getSelectedIndex() == 1) {
            combo_normal_3D.setVisible(false);
            combo_normal_3D.setSelectedIndex(0);
            combo_Horientacion.setVisible(true);
        }
    }//GEN-LAST:event_combo_modeloActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void btn_generar_graficoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_generar_graficoMouseEntered
        // TODO add your handling code here:

        btn_generar_grafico.setBorder(new LineBorder(label_titulo.getBackground(), 3, true));
    }//GEN-LAST:event_btn_generar_graficoMouseEntered

    private void btn_generar_graficoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_generar_graficoMouseExited
        // TODO add your handling code here:
        btn_generar_grafico.setBorder(label_titulo.getBorder());
    }//GEN-LAST:event_btn_generar_graficoMouseExited

    private void panel_principalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panel_principalKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            this.dispose();

        }

    }//GEN-LAST:event_panel_principalKeyPressed

    private void panel_principalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_principalMouseEntered
        // TODO add your handling code here:
        panel_principal.requestFocusInWindow();
    }//GEN-LAST:event_panel_principalMouseEntered

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
            java.util.logging.Logger.getLogger(Graficos_estadisticos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graficos_estadisticos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graficos_estadisticos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graficos_estadisticos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Graficos_estadisticos dialog = new Graficos_estadisticos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_generar_grafico;
    private com.toedter.calendar.JDateChooser calendario_Inicio;
    private com.toedter.calendar.JDateChooser calendario_final;
    private javax.swing.JCheckBox check_habil_panel;
    private javax.swing.JComboBox<String> combo_Horientacion;
    private javax.swing.JComboBox<String> combo_modelo;
    private javax.swing.JComboBox<String> combo_normal_3D;
    private javax.swing.JComboBox<String> combo_tabla;
    private javax.swing.JInternalFrame frame_interno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JPanel panel_bus_fecha;
    private javax.swing.JPanel panel_gesti_grafico;
    private javax.swing.JPanel panel_principal;
    // End of variables declaration//GEN-END:variables
}
