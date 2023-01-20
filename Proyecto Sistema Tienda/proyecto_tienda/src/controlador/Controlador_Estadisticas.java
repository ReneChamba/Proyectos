package controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import modelo.Crud_Nuevo;
import modelo.Modelo_Nuevo;
import modelo.Personalizar_combo;
import vistas.Estadisticas;

public class Controlador_Estadisticas implements ActionListener {

    private Estadisticas estadisticas;
    private Modelo_Nuevo modelo_nuevo;
    private Crud_Nuevo crud_nuevo;
    private Personalizar_combo personalizar_combo;

    public Controlador_Estadisticas(Estadisticas estadisticas, Modelo_Nuevo modelo_nuevo, Crud_Nuevo crud_nuevo, Personalizar_combo personalizar_combo) {
        this.estadisticas = estadisticas;
        this.modelo_nuevo = modelo_nuevo;
        this.crud_nuevo = crud_nuevo;
        this.personalizar_combo = personalizar_combo;
        this.estadisticas.btn_generar_grafico.addActionListener(this);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        label_sms_panel = new JLabel("Aquí se generara el gráfico", 0);
        label_sms_panel.setFont(new Font("Arial Black", Font.BOLD, 25));
        panel.add(label_sms_panel, "Center");
        letras_botones = new Font("Dialog", Font.BOLD, 20);
        color_botones = new Color(30, 138, 137);//color de los botones y del titulo
        letras_label = new Font("Dialog", Font.BOLD, 14);
        cursor_mano = new Cursor(Cursor.HAND_CURSOR);
        /////////////////////////////////////////////////////////////

        this.estadisticas.combo_tipo.addActionListener(this);
        this.estadisticas.check_habil_panel.addActionListener(this);
        Evento_Ventana_Closing();
        Asignar_Letra();
        Asignar_Cursor();

        Personalizar_Combo_tipo();
        this.estadisticas.setResizable(false);
    }

    public void Iniciar_Componentes() {
        estadisticas.setLocationRelativeTo(null);
        Evento_Ventana_Closing();
        Actualizar_Fecha();
        estadisticas.setVisible(true);

    }

    private void Asignar_Letra() {

        estadisticas.label_titulo.setFont(letras_botones);
        estadisticas.label_parametrpo.setFont(letras_label);
        estadisticas.label_tipo.setFont(letras_label);
        estadisticas.label_modelo.setFont(letras_label);
        estadisticas.label_fecha_final.setFont(letras_label);
        estadisticas.label_fecha_inicio.setFont(letras_label);
        estadisticas.btn_generar_grafico.setFont(letras_botones);

        estadisticas.label_titulo.setForeground(color_botones);

    }

    private void Asignar_Cursor() {
        estadisticas.btn_generar_grafico.setCursor(cursor_mano);
        estadisticas.combo_Horientacion.setCursor(cursor_mano);
        estadisticas.combo_modelo.setCursor(cursor_mano);
        estadisticas.combo_parametro.setCursor(cursor_mano);
        estadisticas.combo_tipo.setCursor(cursor_mano);
    }

    private void Personalizar_Combo_tipo() {

        personalizar_combo.Iniciar_Parametro(1);

        estadisticas.combo_tipo.setUI(personalizar_combo);

    }

    private void Tomar_numero_combo_items(boolean elegir_check) {
        try {
            boolean filtrar_fecha = false;
            int combo_parametro = estadisticas.combo_parametro.getSelectedIndex();
            int combo_modelo = estadisticas.combo_modelo.getSelectedIndex();//combo pastel normal o 3d

            int combo_tipo = estadisticas.combo_tipo.getSelectedIndex(); //tipo  pastel o barra

            if (combo_tipo != 0) {
                combo_modelo = estadisticas.combo_Horientacion.getSelectedIndex(); //combo barra horizontal o vertical
            }

            if (elegir_check) {

                if (estadisticas.check_habil_panel.isSelected()) {

                    long fecha_inicio = estadisticas.calendario_Inicio.getDate().getTime();
                    long fecha_final = estadisticas.calendario_final.getDate().getTime();
                    ///////////////////////////////////////////////////////////////////////
                    java.sql.Date fecha_sql_enviar = new java.sql.Date(fecha_inicio);
                    java.sql.Date fecha_sql_final = new java.sql.Date(fecha_final);
                    ////////////////////////////////////////////////
                    String format_hora = "yyyy/MM/dd";
                    SimpleDateFormat dateFormat = new SimpleDateFormat(format_hora);
                    String fecha_formato_inicio = dateFormat.format(fecha_sql_enviar);

                    String fecha_formato_final = dateFormat.format(fecha_sql_final);

                    modelo_nuevo.setFecha(fecha_formato_inicio);
                    modelo_nuevo.setFecha_final(fecha_formato_final);
                    filtrar_fecha = true;

                }
            }

            modelo_nuevo.setParametro(combo_parametro);
            modelo_nuevo.setTipo(combo_tipo);
            modelo_nuevo.setModelo(combo_modelo);
            crud_nuevo.Graficar(modelo_nuevo, filtrar_fecha);
           
                    
            estadisticas.frame_interno.setContentPane(modelo_nuevo.getJpanel());

        } catch (Exception e) {

        }

    }

    private void Evento_Ventana_Closing() {

        modelo_nuevo.setJpanel(panel); //le asigno un panel en blanco  a lo que abra  para que no salga las estadistica anterior
        estadisticas.frame_interno.setContentPane(modelo_nuevo.getJpanel());
        color_bordes = new LineBorder(Color.GRAY, 3, true);
        estadisticas.panel_bus_fecha.setBorder(color_bordes);
        estadisticas.check_habil_panel.setSelected(false);

    }

    private void Actualizar_Fecha() {

        ////////restablece la fecha actual al calendario/////////////////////
        Calendar fecha = Calendar.getInstance();
        estadisticas.calendario_Inicio.setDate(fecha.getTime());
        estadisticas.calendario_final.setDate(fecha.getTime());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == estadisticas.btn_generar_grafico) {
            Tomar_numero_combo_items(true);
        }
        if (e.getSource() == estadisticas.combo_tipo) {

            if (estadisticas.combo_tipo.getSelectedIndex() == 0) {
                estadisticas.combo_modelo.setVisible(true);
                estadisticas.combo_Horientacion.setVisible(false);
            } else {
                estadisticas.combo_modelo.setVisible(false);
                estadisticas.combo_Horientacion.setVisible(true);
            }

        }

        if (e.getSource() == estadisticas.check_habil_panel) {

            if (estadisticas.check_habil_panel.isSelected()) {
                color_bordes = new LineBorder(Color.GREEN, 3, true);

            } else {
                color_bordes = new LineBorder(Color.GRAY, 3, true);
                Tomar_numero_combo_items(false);

                Actualizar_Fecha();

            }
            estadisticas.panel_bus_fecha.setBorder(color_bordes);

        }

    }
    private LineBorder color_bordes;
    private JPanel panel;
    private JLabel label_sms_panel;
    private final Font letras_botones;
    private final Font letras_label;
    private final Color color_botones;
    private final Cursor cursor_mano;
}
