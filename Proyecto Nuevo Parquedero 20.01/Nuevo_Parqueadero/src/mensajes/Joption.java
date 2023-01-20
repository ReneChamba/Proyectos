package mensajes;

import java.awt.Component;
import javax.swing.ImageIcon;
import static javax.swing.JOptionPane.*;

public class Joption {

    private final String titulo;

    public Joption() {

        titulo = "Sistema RR 20.01";
    }

    public void getAceptar(Component parent, String sms, ImageIcon icono) {
        showMessageDialog(parent, sms, titulo, 0, icono);

    }

    public int getOptionDialog(Component parent, String sms, ImageIcon icono, String[] opciones) {

        int repuesta = showOptionDialog(parent, sms, titulo, 0, 0, icono, opciones, opciones[0]);

        return repuesta;
    }

    public static void main(String[] args) {

    }

}
