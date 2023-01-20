package controlador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import modelo.Crud_Nuevo;
import modelo.Modelo_Nuevo;
import modelo.Validacion_txt;
import vistas.Recuperar_Contrasena;
import static javax.swing.JOptionPane.*;
import modelo.Correo;
import modelo.Trasparente;

public class Controlador_Recuperar_Pass implements ActionListener, KeyListener {

    private Crud_Nuevo crud_nuevo;
    private Modelo_Nuevo modelo_nuevo;
    private Recuperar_Contrasena recuperar_contrasena;
    private Validacion_txt validacion_txt;
    private Correo correo;

    public Controlador_Recuperar_Pass(Crud_Nuevo crud_nuevo, Modelo_Nuevo modelo_nuevo, Recuperar_Contrasena recuperar_contrasena,
            Validacion_txt validacion_txt, Correo correo) {
        this.crud_nuevo = crud_nuevo;
        this.modelo_nuevo = modelo_nuevo;
        this.recuperar_contrasena = recuperar_contrasena;
        this.validacion_txt = validacion_txt;
        this.correo = correo;
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        this.recuperar_contrasena.btn_enviar_solicitud.addActionListener(this);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////777
        this.recuperar_contrasena.txt_ingresar_correo.addKeyListener(this);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        this.recuperar_contrasena.setResizable(false);
        this.recuperar_contrasena.setTitle("Sistema de Ventas");
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Asignar_Letra();
        Evento_Closing();

    }

    public void Iniciar_Componentes() {
        recuperar_contrasena.setLocationRelativeTo(null);
        recuperar_contrasena.setVisible(true);

    }

    private void Asignar_Letra() {

        recuperar_contrasena.label_titulo.setFont(new Font("Arial Black", Font.BOLD, 18));
        recuperar_contrasena.btn_enviar_solicitud.setFont(new Font("Dialog", Font.BOLD, 15));
        recuperar_contrasena.label_ingresar_correo.setFont(new Font("Dialog", Font.BOLD, 13));
        recuperar_contrasena.txt_ingresar_correo.setFont(new Font("Dialog", Font.BOLD, 13));
        recuperar_contrasena.txt_ingresar_correo.setHorizontalAlignment(0);
        recuperar_contrasena.label_titulo.setForeground(new Color(30, 138, 137));
        recuperar_contrasena.label_ingresar_correo.setForeground(new Color(30, 138, 137));
        recuperar_contrasena.btn_enviar_solicitud.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Trasparente txt = new Trasparente("Correo registrado en tu cuenta", recuperar_contrasena.txt_ingresar_correo, Trasparente.Show.ALWAYS);
        recuperar_contrasena.label_correo_mal.setForeground(Color.red);
        recuperar_contrasena.label_correo_mal.setVisible(false);

    }

    private void Enviar_Solicitud() {

        String tomar_correo = recuperar_contrasena.txt_ingresar_correo.getText().trim();
        if (tomar_correo.isEmpty()) {

            recuperar_contrasena.label_correo_mal.setText("Ingresa tu correo");
            recuperar_contrasena.label_correo_mal.setVisible(true);

        } else if (!tomar_correo.isEmpty()) {
            if (validacion_txt.validar_correo(tomar_correo)) {

                modelo_nuevo.setCorreo(tomar_correo);
                int retornar_verificacion = crud_nuevo.Retornar_Correo(modelo_nuevo);
                String sms = "La solicitud se envio correctamente  \n Revisa la bandeja de mensajes de tu correo  " + tomar_correo;

                icono_bien = new ImageIcon("src/Image_Sms/visto_bien.png");
             
                if (retornar_verificacion == 0) {
                    sms = "Correo no  se encuentra registrado";
                       icono_bien= new ImageIcon("src/Image_Sms/admiracion_nueva.png");

                }
                if (retornar_verificacion == 2) {
                    sms = "Su cuenta se encuentra deshabilita actualmente";
                      icono_bien= new ImageIcon("src/Image_Sms/admiracion_nueva.png");
                }

                if (retornar_verificacion == 1) {

                    if (correo.enviar_Correo(tomar_correo, modelo_nuevo.getCedula(), modelo_nuevo.getCodigo())) {

                    }

                }

                showMessageDialog(recuperar_contrasena, sms,"Sistema de Ventas",0,icono_bien);

            } else {
                recuperar_contrasena.label_correo_mal.setText("Correo Incorrecto");
                recuperar_contrasena.label_correo_mal.setVisible(true);

            }

        }

    }

    private void Evento_Closing() {

        WindowAdapter evento = new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                recuperar_contrasena.txt_ingresar_correo.setText("");
                recuperar_contrasena.label_correo_mal.setVisible(false);

            }

        };
        recuperar_contrasena.addWindowListener(evento);
    }

    //////////////////////////////////////////////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {

        Enviar_Solicitud();

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {

            Enviar_Solicitud();
        }

        if (e.getKeyCode() == 8) { // el 8 es el codigo de la tecla borrar

            recuperar_contrasena.label_correo_mal.setVisible(false);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
   
    private ImageIcon icono_bien;

}
