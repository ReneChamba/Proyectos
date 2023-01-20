package controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mensajes.Joption;
import modelo.Crud_Primero;
import modelo.Fuentes_Y_Mas;
import modelo.Iconos;
import modelo.Modelo_Nuevo;

import vista.Estadisticas;

public class Controlador_Estadisticas implements ActionListener {

    private Estadisticas estadisticas;
    private Modelo_Nuevo modelo_nuevo;
    private Crud_Primero crud_primero;
    private Iconos iconos;
    private Joption mensajes;
    private Fuentes_Y_Mas fuentes_Y_mas;

    public Controlador_Estadisticas() {

    }

    public void setEstadisticas(Estadisticas estadisticas) {
        this.estadisticas = estadisticas;
    }

    public void setCrud_Primero(Crud_Primero crud_primero) {
        this.crud_primero = crud_primero;
    }

    public void setModelo_Nuevo(Modelo_Nuevo modelo_nuevo) {
        this.modelo_nuevo = modelo_nuevo;
    }

    public void setFuentes_Y_Mas(Fuentes_Y_Mas fuentes_Y_Mas) {
        this.fuentes_Y_mas = fuentes_Y_Mas;
    }

    public void setMensajes(Joption mensajes_2) {
        this.mensajes = mensajes_2;
    }

    public void setIconos(Iconos iconos) {
        this.iconos = iconos;
    }

    public void Estado_Constructor() {

        estadisticas.btn_generar_grafico.addActionListener(this);
        estadisticas.btn_verPantallaCompleta.addActionListener(this);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        label_sms_panel = new JLabel("Aquí se generara el gráfico", 0);
        label_sms_panel.setFont(fuentes_Y_mas.getLetra_Titulos());
        panel.add(label_sms_panel, "Center");
        estadisticas.frame_interno.setContentPane(panel);
        estadisticas.panel_gesti_grafico.setBorder(fuentes_Y_mas.getBorder("Datos  Grafico", Color.black));
        estadisticas.panel_bus_fecha.setBorder(fuentes_Y_mas.getBorderlinea(Color.DARK_GRAY));

        estadisticas.btn_verPantallaCompleta.setEnabled(false);

        estadisticas.combo_tipo.addActionListener(this);
        estadisticas.check_habil_panel.addActionListener(this);
        estadisticas.setResizable(false);
        estadisticas.setTitle(fuentes_Y_mas.getTitulo());
        Evento_Ventana_Closing();
        Diseno();
        Actualizar_Fecha();
    }

    private void Diseno() {

        estadisticas.label_titulo.setFont(fuentes_Y_mas.getLetra_Titulos());
        estadisticas.label_modelo.setFont(fuentes_Y_mas.getLetra_label());
        estadisticas.label_parametrpo.setFont(fuentes_Y_mas.getLetra_label());
        estadisticas.label_tipo.setFont(fuentes_Y_mas.getLetra_label());

        estadisticas.combo_Horientacion.setFont(fuentes_Y_mas.getLetra_Txt());
        estadisticas.combo_modelo.setFont(fuentes_Y_mas.getLetra_Txt());
        estadisticas.combo_parametro.setFont(fuentes_Y_mas.getLetra_Txt());
        estadisticas.combo_tipo.setFont(fuentes_Y_mas.getLetra_Txt());
        estadisticas.check_habil_panel.setFont(fuentes_Y_mas.getLetra_Txt());
        estadisticas.btn_verPantallaCompleta.setFont(fuentes_Y_mas.getLetra_label());

        estadisticas.btn_generar_grafico.setFont(fuentes_Y_mas.getLetra_btn());
        estadisticas.btn_generar_grafico.setCursor(fuentes_Y_mas.getCursor());
        estadisticas.combo_Horientacion.setCursor(fuentes_Y_mas.getCursor());
        estadisticas.combo_modelo.setCursor(fuentes_Y_mas.getCursor());
        estadisticas.combo_parametro.setCursor(fuentes_Y_mas.getCursor());
        estadisticas.combo_tipo.setCursor(fuentes_Y_mas.getCursor());
        estadisticas.btn_verPantallaCompleta.setCursor(fuentes_Y_mas.getCursor());
        estadisticas.label_titulo.setForeground(fuentes_Y_mas.getColor_titulo());

        estadisticas.btn_generar_grafico.setForeground(fuentes_Y_mas.getColor_letra_btn());
        estadisticas.btn_verPantallaCompleta.setForeground(fuentes_Y_mas.getColor_letra_btn());
        estadisticas.btn_generar_grafico.setBackground(fuentes_Y_mas.getColor_Fondo_btn());
        estadisticas.btn_verPantallaCompleta.setBackground(fuentes_Y_mas.getColor_Fondo_btn());

    }

    public void Iniciar_Componentes() {
        estadisticas.setLocation(fuentes_Y_mas.centrar_Pantalla(estadisticas.getWidth()), 130);
        estadisticas.setVisible(true);

    }

    private void Tomar_numero_combo_items(boolean elegir_check) {
        try {
            boolean filtrar_fecha = false;
            int combo_parametro = estadisticas.combo_parametro.getSelectedIndex();

            int combo_modelo = estadisticas.combo_modelo.getSelectedIndex();//combo pastel normal o 3d

            int combo_tipo = estadisticas.combo_tipo.getSelectedIndex(); //tipo  pastel o barra

            if (combo_tipo != 0) {

                //si el combo_tipo cambia a barra, cambio de donde obtengo el modelo
                combo_modelo = estadisticas.combo_Horientacion.getSelectedIndex(); //combo barra horizontal o vertical
            }

            if (elegir_check) {

                if (estadisticas.check_habil_panel.isSelected()) {
                    //SI VOY A FILTRAR POR FECHA

                    modelo_nuevo.setFecha__Date(estadisticas.calendario_Inicio.getDate());
                    modelo_nuevo.setFecha__Date_Final(estadisticas.calendario_final.getDate());

                    filtrar_fecha = true;

                }

            }

            modelo_nuevo.setParametros_Graficos(combo_parametro, combo_tipo, combo_modelo, filtrar_fecha);
            crud_primero.Graficar_Estadisticas(modelo_nuevo);
            //estadisticas.frame_interno.getContentPane(modelo_nuevo.getPanel_retorno_grafica());

            estadisticas.frame_interno.setContentPane(modelo_nuevo.getPanel_retorno_grafica());

        } catch (Exception e) {

        }

    }

    private void Evento_Ventana_Closing() {

        WindowListener evento = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {

                estadisticas.frame_interno.setContentPane(panel);
                estadisticas.panel_bus_fecha.setBorder(fuentes_Y_mas.getBorderlinea(Color.DARK_GRAY));
                estadisticas.check_habil_panel.setSelected(false);
                estadisticas.btn_verPantallaCompleta.setEnabled(false);

            }

        };
        estadisticas.addWindowListener(evento);

    }

    private void Actualizar_Fecha() {

        estadisticas.calendario_Inicio.setDate(modelo_nuevo.getFecha_Date());
        estadisticas.calendario_final.setDate(modelo_nuevo.getFecha_Date_2());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == estadisticas.btn_generar_grafico) {
            Tomar_numero_combo_items(true);
            estadisticas.btn_verPantallaCompleta.setEnabled(true);
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

            Color color = Color.GREEN;

            if (estadisticas.check_habil_panel.isSelected() == false) {
                color = Color.DARK_GRAY;
                Tomar_numero_combo_items(false);
                Actualizar_Fecha();

            }

            estadisticas.panel_bus_fecha.setBorder(fuentes_Y_mas.getBorderlinea(color));

        }

        if (e.getSource() == estadisticas.btn_verPantallaCompleta) {
            modelo_nuevo.getDialogReporte().setContentPane(modelo_nuevo.getPanel_retorno_grafica());
//            modelo_nuevo.getDialogReporte().setSize(1377, 710);
//
//            modelo_nuevo.getDialogReporte().setLocation(-5, 23);

            modelo_nuevo.getDialogReporte().setVisible(true);

        }

    }

    private JPanel panel;
    private JLabel label_sms_panel;

}
