package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class Validacion_txt {

    public Validacion_txt() {

    }

    public boolean validar_correo(String correo) {

        boolean correo_correcto = false;

        ///char dominio[] = {'@', 'h', 'o', 't', 'm', 'a', 'i', 'l', '.', 'c', 'o', 'm'};
          char dominio[] = {'@', 'g', 'm', 'a', 'i', 'l','.', 'c', 'o', 'm'};

        int indice = 0;
        int r = 0;
        int contador = 0;
        boolean prm_letra = false;
        boolean arroba = false;

        for (int i = 0; i < correo.length(); i++) {

            if (i == 0) {

                if (Character.isDigit(correo.charAt(i))) {
                    prm_letra = true;

                }
            }
            if (correo.charAt(i) == ' ') {
                prm_letra = true;
            }

            if (correo.charAt(i) == '@') {
                arroba = true;

                r = correo.length() - i;

                almacer = new char[r];
                for (int j = i; j < correo.length(); j++) {

                    almacer[indice] = correo.charAt(j);
                    indice++;

                }
                //  i = i + correo.length();

            }

        }

        ////////////////////////////////////////
        boolean erro = false;
        try {

            for (int i = 0; i < almacer.length; i++) {

                if (dominio[i] == almacer[i]) {
                    contador++;

                }

            }

        } catch (Exception e) {
            erro = true;

        }
        if (contador == 10 && correo.length() - r >= 5 && !erro && !prm_letra && arroba) {
            correo_correcto = true;

        }
        return correo_correcto;
    }

    public boolean Validar_cedula(String cedula) {
        boolean ver = false;
        int valores[] = new int[cedula.length()];
        int ced_numero = Integer.parseInt(cedula);

        int c, acumulador = 0;
        for (int i = 0; i < valores.length; i++) {
            c = ced_numero % 10;
            ced_numero = ced_numero / 10;
            valores[valores.length - (i + 1)] = c;/// rl ultimo numero lo guardo en la primera posicion
        }
        for (int i = 0; i < valores.length - 1; i++) {

            if (i % 2 == 0) {

                valores[i] = valores[i] * 2;

                if (valores[i] > 9) {
                    valores[i] = valores[i] - 9;
                }
            }

            acumulador = acumulador + valores[i];

        }

        acumulador = acumulador % 10;
        if (acumulador > 0) {
            acumulador = 10 - acumulador;
        }

        if (acumulador == valores[valores.length - 1]) {
            ver = true;
        }

        return ver;
    }

    public int Validar_Usuario_contrase(String usuario) {
        int dato = 0;
        int longitud = usuario.length();
        int letras = 0;
        int numeros = 0;
        boolean primero = true;

        if (longitud >= 10) {
            for (int i = 0; i < longitud; i++) {

                if (i == 0) {
                    if (Character.isDigit(usuario.charAt(i))) {
                        primero = false;
                    }
                }

                if (Character.isDigit(usuario.charAt(i))) {
                    numeros++;
                } else {
                    letras++;
                }

            }

            if (numeros >= 3 && letras >= 3 && primero) {
                dato = 2;
            }

        }

        return dato;

    }

    
    /*
    public void getBarra_progres(JProgressBar barra, JLabel Lbmostrar, JLabel dato, JDialog dialog, JTextField usu, JTextField con, JTextField confir) {

        barra.setUI(new BasicProgressBarUI() {
            @Override
            protected void paintDeterminate(Graphics g, JComponent c) {

                Graphics2D g2d = (Graphics2D) g;

                int alto = barra.getHeight();
                int ancho = barra.getWidth();
                int entre_ancho = ancho - 20;
                int entre_alto = alto - 20;
                Color color;
                ImageIcon ima = null;

                double porcentaje = barra.getPercentComplete();
                ///  System.out.println(porcentaje);
                entre_ancho = (int) (entre_ancho * porcentaje);

                if (x <= 25) {
                    color = new Color(102, 221, 193);
                } else if (x <= 50) {
                    color = new Color(102, 234, 151);
                } else if (x <= 75) {
                    color = new Color(102, 241, 104);
                } else {
                    color = new Color(102, 246, 23);
                }

                if (x <= 50) {
                    ima = new ImageIcon("src/Imagenes/notas_2.png");
                } else if (x >= 51) {
                    ima = new ImageIcon("src/Imagenes/contra.png");
                }
                g2d.drawImage(ima.getImage(), entre_ancho - 15, 45, null);
                g2d.setColor(color);

                RoundRectangle2D redondear = new RoundRectangle2D.Double(0, 1, entre_ancho + 20, entre_alto - 20, entre_alto - 20, entre_alto - 10);
                g2d.fill(redondear);

            }

        });

        ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = x + 1;
                barra.setValue(x);

                Lbmostrar.setText("" + x + "%");
                if (x <= 8) {
                    dato.setText("Registrando Cedula..");

                } else if (x <= 16) {
                    dato.setText("Registrando Nombres..");

                } else if (x <= 24) {
                    dato.setText("Registrando Apellidos..");
                } else if (x <= 32) {
                    dato.setText("Registrando Teléfono..");
                } else if (x <= 40) {
                    dato.setText("Registrando Dirección..");
                } else if (x <= 49) {
                    dato.setText("Registrando Correo..");
                } else if (x == 50) {
                    usu.setEditable(true);
                    con.setEditable(true);
                    confir.setEditable(true);

                    usu.requestFocus();
                    dato.setText("Datos Personales Guardados");
                    dato.setForeground(Color.ORANGE);

                    t.stop();
                } /////////////////////////////////////////////////////////////////////////////////
                else if (x <= 60) {
                    dato.setText("Conectando con el Servidor....");
                    dato.setForeground(Color.BLACK);

                } else if (x <= 75) {
                    dato.setText("Registrando Usuario..");

                } else if (x <= 85) {
                    dato.setText("Registrando Contraseña..");

                } else if (x == 99) {
                    dato.setText("Datos Cuenta Guardados");
                    dato.setForeground(Color.ORANGE);
                }

                if (x == 100) {
                    JOptionPane.showMessageDialog(dialog, "Registro Creado");
                    dialog.dispose();
                    t.stop();

                }

            }
        };

        t = new Timer(100, ac);

        t.start();

    }
*/

    public int Longitud_numero_tlf_tabla(String telefono) {

      
        int retorno = 2;

        if (telefono.length() == 10) {
            for (int i = 0; i < telefono.length(); i++) {

                if (Character.isAlphabetic(telefono.charAt(i)) || telefono.charAt(i) == ' ') {
                    retorno = 1;
                    break;
                }

            }

        } else {
            retorno = 3;

        }

        return retorno;

    }

    char almacer[];
    private Timer t;
    private ActionListener ac;
    int x = 0;
}
