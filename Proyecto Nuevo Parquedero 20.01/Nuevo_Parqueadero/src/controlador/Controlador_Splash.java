package controlador;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComponent;
import javax.swing.Timer;
import modelo.Crud_Primero;
import vista.Splash;
import javax.swing.plaf.basic.BasicProgressBarUI;
import mensajes.Joption;
import modelo.Iconos;

public class Controlador_Splash {

    Timer timer;
    Integer contador = 0;
    private Splash splash;
    private Crud_Primero crud_primero;
    private Joption mensaje;
    private Iconos iconos;
    private Controlador_Sms_Pregunta controlador_sms_pregunta;

    public Controlador_Splash() {

    }

    public void setSplash(Splash splash) {

        this.splash = splash;
    }

    public void setCrud_primero(Crud_Primero crud_Primero) {

        this.crud_primero = crud_Primero;
    }

    public void setMensajes(Joption mensaje) {
        this.mensaje = mensaje;
    }

    public void setIconos(Iconos iconos) {
        this.iconos = iconos;
    }

    public void setcontrolador_Sms_Pregunta(Controlador_Sms_Pregunta controlador_Sms_Pregunta) {
        this.controlador_sms_pregunta = controlador_Sms_Pregunta;
    }

    public void Iniciar_Splash() {

        splash.setModal(true);

        this.splash.setLocationRelativeTo(null);
        this.splash.setResizable(false);
        this.splash.lb_imagen.setIcon(iconos.getIcono_splash());

        iniciar_Splash();
        Evento_Ventana();

    }

    private void Evento_Ventana() {

        WindowListener evento = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {

                timer.stop();
                controlador_sms_pregunta.Iniciar_Componenentes("¿Seguro desea salir?", "Salir", "Continuar", iconos.getIcono_eliminar_pregunta(),
                        iconos.getIcono_continuar());

                if (controlador_sms_pregunta.getAccion() == 0) {
                    System.exit(0);

                } else {

                    timer.start();
                }//
            }

        };
        splash.addWindowListener(evento);

    }

    public void iniciar_Splash() {

        try {

            splash.barra_progreso.setUI(new BasicProgressBarUI() {
                @Override
                protected void paintDeterminate(Graphics g, JComponent c) {

                    Graphics2D g2d = (Graphics2D) g;
                    Color color_2 = new Color(0, 255, 0);
                    int alto = splash.barra_progreso.getHeight();
                    int ancho = splash.barra_progreso.getWidth();
                    int entre_ancho = ancho - 20;
                    int entre_alto = alto - 2;

                    double porcentaje = splash.barra_progreso.getPercentComplete();
                    entre_ancho = (int) (entre_ancho * porcentaje);

                    /*if (x <= 25) {
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
                g2d.drawImage(ima.getImage(), entre_ancho - 15, 45, null);*/
                    g2d.setColor(color_2);

                    RoundRectangle2D redondear = new RoundRectangle2D.Double(0, 2, entre_ancho + 20, entre_alto, entre_alto, entre_alto);
                    // RoundRectangle2D ff  = new RoundRectangle2D.Double
                    g2d.fill(redondear);

                }

            });

            //===================================================================
            timer = new Timer(20, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    ///String sms ="";
                    contador++;
                    splash.barra_progreso.setValue(contador);

                    if (contador < 10) {

                        sms = "Iniciando componentes........";
                    }

                    if (contador == 10) {

                        sms = " Comprobando requisitos....";

                    }

                    if (contador == 50) {

                        sms = "Verificando conexión con el serivdor ....";
                        Validar_Datos();

                        sms = "Servidor conectado con exito ....";

                        try {
                            Thread.sleep(1000);
                        } catch (Exception ex) {

                        }

                    }

                    if (contador == 52) {

                        sms = "Cargando librerias......";

                    }

                    if (contador == 100) {
                        sms = "Requisitos cargados con exito......";

                    }

                    if (contador == 102) {

                        timer.stop();

                        try {
                            Thread.sleep(1000);

                            splash.dispose();
                        } catch (InterruptedException ex) {
                        }

                    }
                    splash.lb_sms.setText(sms);

                    splash.lb_porcentaje.setText((contador - 1) + " %");

                }
            });

            timer.start();

        } catch (Exception exe) {
            System.out.println("revisar barra");

        }

    }

    private void Validar_Datos() {

        try {
            Thread.sleep(70);

        } catch (InterruptedException ex) {
        }

        String sms_alerta = "Error, no se pudo cargar todos las herramientas necesarias";

        //0 : error en la conexion con la bd
        // 
        int retorno = crud_primero.Verificar_Tablas();
        boolean ocular = false;
        if (retorno == 0) {

            //NO se conecto al servidor
            sms_alerta = "Surguio un problema , al conectarse al servidor, intentelo  mas tarde";
        } else if (retorno == cantidad_columnas) {
            ocular = true;

        }
        if (!ocular) {
            // si falla allgo sale del programa
            mensaje.getAceptar(splash, sms_alerta, iconos.getIcono_alerta());
            System.exit(0);

        }

    }

    public void String_datos(int cantidad_columnas) {

        this.cantidad_columnas = cantidad_columnas;

    }
    private int cantidad_columnas;
    private String sms = "";

}
