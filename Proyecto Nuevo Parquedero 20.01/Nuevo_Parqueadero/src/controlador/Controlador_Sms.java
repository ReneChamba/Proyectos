package controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import vista.MensajeLanzar;

public class Controlador_Sms {

    private MensajeLanzar mensajeLanzar;

    public Controlador_Sms() {

    }

    public void setMensaje_Lanzar(MensajeLanzar mensajeLanzar) {

        this.mensajeLanzar = mensajeLanzar;

    }

    public void Iniciar_Componentes(String sms, Color color) {

        //DIMENSION DE LA PANTALLA TOMANDO EN CUENTA LA BARRA DE TAREAS, PANTALLA COMPLETA
        Dimension screwPantalla = Toolkit.getDefaultToolkit().getScreenSize();
       
        //OBTENER LA DIMENSION DE LA PANTALLA, PERO NO TOMA EN CUENTA LA BARRA DE TAREA , OSEA SALE MENOS EL HEIGTH DE LA PANTALLA
        //DEPENDE SI HAY UNA BARRA DE TAREAS 
        Rectangle winze = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

         //mensaje que aparecera en el sms          
         mensajeLanzar.txt_mensaje.setText(sms);
         mensajeLanzar.txt_mensaje.setBackground(color);
        
        //OBTENGO EL TAMANO DE LA BARRA DE TAREAS
        tamano_barra_tareas = screwPantalla.height - winze.height;//tamano height total - heigth sin barras
        
        // OBTENER ALTO Y ANCHO DE LA VENTANA
        pantallaWidth = (int) screwPantalla.getWidth();
        pantallaHeight = (int) screwPantalla.getHeight();

        //SIEMPRE  INICIALIZA COMO TRUE , es para que ingrese a la primera a lo ingrese al timer
        apareciendo = true;
        
        //INICIALIZAR TIEMPO DE ESPERA, tiempo que espera el sms para regresar  a la x derecha
        tiempo_espera = 0;

        //POSICION INICIAL X DEL MENSAJE
        posX = pantallaWidth;

        //DIMENSIONES DE LA VENTANA
        formularioHeigth = mensajeLanzar.getHeight();
        formularioWidth = mensajeLanzar.getWidth();

        //POSICION Y 
        posY = pantallaHeight - formularioHeigth - tamano_barra_tareas;

        LocationFormulario(posX, posY);

        //OBTENER LA POSICION FINAL HASTA DONDE SE DESPLAZARA EL DIALOGO
        posX_Final = pantallaWidth - formularioWidth;

        //INICIALIZO EL TIMER
        timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //INGRESA POR PRIMERA VEZ AQUI
                if (apareciendo) {

                    //VERIFICA SI TODAVIA NO SE ALCANZA LA POSICION FINAL , 
                    if (posX > posX_Final) {

                        //VWERIFICA SI LA DIFERENCIA AUN ES MAYOR QUE 50 , va movieto sms de 50 en 50
                        if (posX - posX_Final > 50) {

                            posX -= 50;

                        } else {

                            //SI YA NO ES  >50 PASO DIRECTA  LA POSX A LA POSICION FINAL
                            posX = posX_Final;
                            //CAMBIO EL VALOR PARA QUE ENTRE AL ESLSE Y MUEVE LA VENTANA HACIA LA DERECHA
                            apareciendo = false;
                        }
                        LocationFormulario(posX, posY);

                    }

                } else if (apareciendo == false) {

                    //LA POSICION ACTUAL X DEL FORMULARIO CON RESPECTO AL ANCHO DE LA PANTALLA,
                    if (posX < pantallaWidth) {

                        //TIEMPO QUE SE DETENDRA EL SMS CUANDO LLEGUE A LA POSCION FINALX 
                        if (tiempo_espera > 70) {

                            posX += 50;

                        } else {

                            tiempo_espera++;
                        }

                        LocationFormulario(posX, posY);

                    } else {

                        //DETENER EL TIMER
                        timer.stop();
                        //LIBERAR LA VENTANA
                        mensajeLanzar.dispose();

                    }

                }

            }
        });
        timer.start();
        
        
         mensajeLanzar.setVisible(true);
    }

    private void LocationFormulario(int x, int y) {

        mensajeLanzar.setLocation(x, y);

    }

    private Timer timer;
    private int posX;
    private int posY;
    private int pantallaWidth;
    private int pantallaHeight;
    private int formularioWidth;
    private int formularioHeigth;
    private int tamano_barra_tareas;
    private int posX_Final;
    private boolean apareciendo;
    private int tiempo_espera;

    /*
    public static void main(String[] args) {
        
        
        
        
        MensajeLanzar mensaje  = new MensajeLanzar(null, true);
        
         Controlador_Sms sms = new Controlador_Sms();
         sms.setMensaje_Lanzar(mensaje);
         sms.Iniciar_Componentes("BIENVENIDO");
         mensaje.setVisible(true);
        
        
    }*/
    
    
}
