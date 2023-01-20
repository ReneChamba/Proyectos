package controlador;

import vista.Sesion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;

import mensajes.Joption;
import modelo.*;

public class Controlador_Sesion implements ActionListener, KeyListener {

    private Sesion sesion;
    private Modelo_Nuevo modelo_nuevo;
    private Crud_Primero crud_primero;
    private Fuentes_Y_Mas fuentes_Y_Mas;
    private Controlador_Menu_Principal controlador_menu_principal;
    private Joption mensaje;
    private Iconos iconos;
    private Controlador_Sms controlador_sms;

    public Controlador_Sesion() {

    }
    //=========================================================================

    public void setFuentes_Y_Mas(Fuentes_Y_Mas fuentes_Y_Mas) {
        this.fuentes_Y_Mas = fuentes_Y_Mas;

    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;

    }

    public void setCrud_Primero(Crud_Primero crud_primero) {
        this.crud_primero = crud_primero;

    }

    public void setModelo_Nuevo(Modelo_Nuevo modelo_nuevo) {
        this.modelo_nuevo = modelo_nuevo;

    }

    public void Recibir_Menu_Principal(Controlador_Menu_Principal controlador_menu_principal) {

        this.controlador_menu_principal = controlador_menu_principal;

    }

    public void setMensajes(Joption mensajes) {
        this.mensaje = mensajes;
    }

    public void setIconos(Iconos iconos) {
        this.iconos = iconos;
    }

    public void setControlador_Lanzar_Sms(Controlador_Sms controlador_sms) {
        this.controlador_sms = controlador_sms;
    }
    //===========================================================================

    public void Iniciar_Componentes() {
        sesion.setLocationRelativeTo(null);
        sesion.setVisible(true);
    }

    public void Estado_Constructor() {
        sesion.btn_ingresar.addActionListener(this);
        sesion.txt_usuario.addKeyListener(this);
        sesion.txt_contrasena.addKeyListener(this);
        sesion.btn_ingresar.setEnabled(false); // una sola ves se bloqueara, de hay lo manejo en el evto ventana

        sesion.setLocationRelativeTo(null);
        sesion.setResizable(false);
        sesion.setTitle(fuentes_Y_Mas.getTitulo());

        Evento_Ventana();
        Diseno();
    }

    private void Limpiar_Txt() {

        sesion.txt_usuario.setText("");
        sesion.txt_contrasena.setText("");

    }

    private void Diseno() {

        sesion.lb_titulo.setHorizontalAlignment(0);
        sesion.lb_titulo.setFont(fuentes_Y_Mas.getLetra_Titulos());

        sesion.txt_usuario.setHorizontalAlignment(fuentes_Y_Mas.getHorientacion());
        sesion.txt_contrasena.setHorizontalAlignment(fuentes_Y_Mas.getHorientacion());
        sesion.txt_usuario.setFont(fuentes_Y_Mas.getLetra_Txt());
        sesion.txt_contrasena.setFont(fuentes_Y_Mas.getLetra_Txt());
        sesion.btn_ingresar.setFont(fuentes_Y_Mas.getLetra_btn());

        //=============================================
        sesion.lb_usuario.setIcon(iconos.getIcono_usuario());
        sesion.lb_contrasena.setIcon(iconos.getIcono_contrasena());
        //===============================================

        Transparente txt_usuario = new Transparente("Ingresa tu usuario", sesion.txt_usuario, Transparente.Show.ALWAYS);
        Transparente txt_contra = new Transparente("Ingresa tu password", sesion.txt_contrasena, Transparente.Show.ALWAYS);

        sesion.lb_titulo.setForeground(fuentes_Y_Mas.getColor_titulo());
        sesion.btn_ingresar.setBackground(fuentes_Y_Mas.getColor_Fondo_btn());
        sesion.btn_ingresar.setForeground(fuentes_Y_Mas.getColor_letra_btn());
        sesion.btn_ingresar.setCursor(fuentes_Y_Mas.getCursor());

    }

    private void Iniciar_Sesion() {
        boolean validar = true;

        String usuario = sesion.txt_usuario.getText().trim();
        String contrasena = sesion.txt_contrasena.getText().trim();

        ImageIcon icono = iconos.getIcono_visto();

        if (usuario.isEmpty() || contrasena.isEmpty()) {

            mensaje.getAceptar(sesion, "Campos Vacios", iconos.getIcono_alerta());

        } else {

            modelo_nuevo.setUsuario(usuario);
            modelo_nuevo.setContrasena(contrasena);
            String sms = "Bienvenido al sistema";

            if (!crud_primero.Iniciar_Sesion(modelo_nuevo, 0)) {
                validar = false;
                sms = "Usuario Incorrecto.....";
                icono = iconos.getIcono_alerta();

            }

            if (validar) {
                sesion.dispose();

                String tipo_cuenta_ = modelo_nuevo.getTipo_cuenta();
                //Inicializar varible de usuario
                controlador_menu_principal.Datos_Usuarios(modelo_nuevo.getCodigo(),
                        modelo_nuevo.getCedula(), modelo_nuevo.getNombre(),
                        modelo_nuevo.getUsuario(), modelo_nuevo.getContrasena(), tipo_cuenta_);

                //Consulta para conocer el numero de vehiculos ingresados actualemnte 
                crud_primero.Numero_Vehiculos_Ingresados(modelo_nuevo);
                // Pasarle al menu principal la cantidad de vehiculos
                controlador_menu_principal.Poner_Cantidad_Vehiculos("" + modelo_nuevo.getContador_Registros());

                boolean tipo = true;
                if (tipo_cuenta_.equalsIgnoreCase("Empleado")) {
                    tipo = false;

                }

                //Habilitar o deshabilitar botones, dependiendo del tipo de usuario
                controlador_menu_principal.Enabled_Botones(tipo);
                //Mostrar sms 
                controlador_sms.Iniciar_Componentes(sms, fuentes_Y_Mas.getColor_Bien());
                // Hacer visible el menu principal
                controlador_menu_principal.Iniciar_Componentes();

            } else {

                controlador_sms.Iniciar_Componentes(sms, fuentes_Y_Mas.getColor_Mal());
            }
            Limpiar_Txt();
            sesion.btn_ingresar.setEnabled(false);

        }

    }

    private void Evento_Ventana() {

        WindowListener evento = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {

                System.exit(0);

            }

        };
        sesion.addWindowListener(evento);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Iniciar_Sesion();

    }

    @Override
    public void keyTyped(KeyEvent e) {

        char letra = e.getKeyChar();

        if (letra == ' ') {
            e.consume();
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

            if (e.getSource() == sesion.txt_usuario) {

                sesion.txt_contrasena.requestFocus();
            }
            if (e.getSource() == sesion.txt_contrasena) {

                if (sesion.btn_ingresar.isEnabled()) {

                    Iniciar_Sesion();
                }

            }

        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {

            if (e.getSource() == sesion.txt_usuario) {

                sesion.txt_contrasena.requestFocus();
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {

            if (e.getSource() == sesion.txt_contrasena) {

                sesion.txt_usuario.requestFocus();
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (sesion.txt_usuario.getText().length() > 5 && sesion.txt_contrasena.getText().length() > 5) {

            sesion.btn_ingresar.setEnabled(true);
        } else {
            sesion.btn_ingresar.setEnabled(false);
        }

    }

}
