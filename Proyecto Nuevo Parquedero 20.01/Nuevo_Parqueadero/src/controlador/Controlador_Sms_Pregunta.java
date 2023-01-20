package controlador;

import java.awt.Color;
import modelo.Fuentes_Y_Mas;
import vista.Sms_Pregunta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Controlador_Sms_Pregunta implements ActionListener {

    private Sms_Pregunta sms_Pregunta;
    private Fuentes_Y_Mas fuentes_Y_Mas;

    public Controlador_Sms_Pregunta() {

    }

    public void setSms_Pregunta(Sms_Pregunta sms_pregunta) {
        this.sms_Pregunta = sms_pregunta;

    }

    public void setFuentes_Y_Mas(Fuentes_Y_Mas fuentes_Y_mas) {
        this.fuentes_Y_Mas = fuentes_Y_mas;

    }

    public void Estados_Constructor() {

        /// sms_Pregunta.setUndecorated(true);
        sms_Pregunta.btn_aceptar.addActionListener(this);
        sms_Pregunta.btn_cancelar.addActionListener(this);
        sms_Pregunta.lb_sms.setBackground(Color.WHITE);
        sms_Pregunta.lb_sms.setOpaque(true);
        /// sms_Pregunta.panel_principal.setBorder(fuentes_Y_Mas.getBorderlinea(Color.GREEN));

        sms_Pregunta.panel_principal.setBackground(Color.ORANGE);
        sms_Pregunta.lb_sms.setBorder(fuentes_Y_Mas.getBorderlinea(Color.BLACK));

        sms_Pregunta.btn_aceptar.setFont(fuentes_Y_Mas.getLetra_btn());
        sms_Pregunta.btn_cancelar.setFont(fuentes_Y_Mas.getLetra_btn());
        sms_Pregunta.btn_aceptar.setBackground(fuentes_Y_Mas.getColor_Fondo_btn());
        sms_Pregunta.btn_cancelar.setBackground(fuentes_Y_Mas.getColor_Fondo_btn());

        sms_Pregunta.btn_aceptar.setCursor(fuentes_Y_Mas.getCursor());
        sms_Pregunta.btn_cancelar.setCursor(fuentes_Y_Mas.getCursor());

    }

    public void Iniciar_Componenentes(String sms, String txtBoton, String txt_cancelar, ImageIcon icon_1, ImageIcon icon_2) {

        sms_Pregunta.lb_sms.setText(sms);
        sms_Pregunta.btn_cancelar.setText(txt_cancelar);
        sms_Pregunta.btn_aceptar.setText(txtBoton);
        sms_Pregunta.btn_aceptar.setIcon(icon_1);
        sms_Pregunta.btn_cancelar.setIcon(icon_2);

        sms_Pregunta.setLocationRelativeTo(null);
        sms_Pregunta.setVisible(true);

    }

    private void setValor(int accion) {

        this.accion = accion;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sms_Pregunta.btn_cancelar) {

            setValor(1);

        }
        if (e.getSource() == sms_Pregunta.btn_aceptar) {

            setValor(0);

        }

        sms_Pregunta.dispose();

    }

    public int getAccion() {

        return accion;
    }

    private int accion = 0;

}
