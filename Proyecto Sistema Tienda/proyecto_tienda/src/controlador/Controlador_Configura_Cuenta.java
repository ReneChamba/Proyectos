package controlador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;

import modelo.*;
import vistas.Configuracion_Cuenta;
import static javax.swing.JOptionPane.*;
import javax.swing.SwingConstants;
import vistas.Menu_Principal;

public class Controlador_Configura_Cuenta implements ActionListener, WindowListener, KeyListener {

    private Crud_Nuevo crud_nuevo;
    private Modelo_Nuevo modelo_nuevo;
    private Configuracion_Cuenta configuracion_cuenta;
    private Validacion_txt validar_txt;
    private Menu_Principal menu;

    public Controlador_Configura_Cuenta(Crud_Nuevo crud_nuevo, Modelo_Nuevo modelo_nuevo, Configuracion_Cuenta configuracion_cuenta,
            Validacion_txt validar_txt, Menu_Principal menu_principal) {
        this.crud_nuevo = crud_nuevo;
        this.modelo_nuevo = modelo_nuevo;
        this.configuracion_cuenta = configuracion_cuenta;
        this.validar_txt = validar_txt;
        this.menu = menu_principal;
        ////////////////////////////////////////////////////////////////////////
        color_botones = new Color(30, 138, 137);//color de los botones y del titulo
        icono_guardar = new ImageIcon("src/Image_2/guardar_cambios.png");
        icono_cancelar = new ImageIcon("src/Imagenes/cancelar.png");
        icono_admiracion = new ImageIcon("src/Image_Sms/admiracion_nueva.png");
         letra_txt = new Font("Dialog", Font.BOLD + Font.ITALIC, 13);
        //////////////////////////////////////////////////////////////77
        this.configuracion_cuenta.btn_editar_cuenta.addActionListener(this);
        this.configuracion_cuenta.btn_editar_pass.addActionListener(this);
        this.configuracion_cuenta.btn_actualizar.addActionListener(this);
        this.configuracion_cuenta.btn_cancelar.addActionListener(this);
        this.configuracion_cuenta.btn_editar_correo.addActionListener(this);
        //////////////////////////////////////////////////////////////////////////////////////7
        this.configuracion_cuenta.addWindowListener(this);
        ////////////////////////////////////////////////////////////////////////////////////////////
        this.configuracion_cuenta.txt_nuevo_usuario.addKeyListener(this);
        this.configuracion_cuenta.txt_pregunta_Segurida.addKeyListener(this);
        ////////////////////////////////////////////////////////////////////////////////////////
        this.configuracion_cuenta.setResizable(false);
        txt_Editable();
        Asignar_Letra();
        Asignar_Cursor_Agregar_Imagen();

    }

    public void Iniciar_Componentes(String cedula, String nombre, String apellido, String cuenta, String contrasena, String correo) {
        configuracion_cuenta.txt_cedula.setText(cedula);
        configuracion_cuenta.txt_nombre.setText(nombre);
        configuracion_cuenta.txt_apellido.setText(apellido);
        configuracion_cuenta.txt_cuenta.setText(cuenta);
        configuracion_cuenta.txt_pass.setText(contrasena);
        configuracion_cuenta.txt_correo.setText(correo);
        Estado_Enabled(true);
        txt_Actualizacion(false);

        configuracion_cuenta.setLocationRelativeTo(null);
        configuracion_cuenta.setVisible(true);

    }

    private void Asignar_Letra() {

        configuracion_cuenta.label_titulo.setFont(letras_titu_btn);
        configuracion_cuenta.label_apellido.setFont(letras_label);
        configuracion_cuenta.label_cedula.setFont(letras_label);
        configuracion_cuenta.label_contrasena.setFont(letras_label);
        configuracion_cuenta.label_correo.setFont(letras_label);
        configuracion_cuenta.label_nombre.setFont(letras_label);
        configuracion_cuenta.label_cuenta.setFont(letras_label);
        configuracion_cuenta.label_nuevo_usuario.setFont(letras_label);
        configuracion_cuenta.label_pregun_segurid.setFont(letras_label);
        //////////////////////////////////////////////////////////////////////////////////////////////
        configuracion_cuenta.label_ayuda.setVisible(false);
        ////////////////////////////////////////////////////////////////////////////////////////

        configuracion_cuenta.txt_cedula.setFont(letra_txt);
        configuracion_cuenta.txt_apellido.setFont(letra_txt);
        configuracion_cuenta.txt_pass.setFont(letra_txt);
        configuracion_cuenta.txt_correo.setFont(letra_txt);
        configuracion_cuenta.txt_nombre.setFont(letra_txt);
        configuracion_cuenta.txt_cuenta.setFont(letra_txt);
        configuracion_cuenta.txt_nuevo_usuario.setFont(letra_txt);
        configuracion_cuenta.txt_pregunta_Segurida.setFont(letra_txt);
        ///////////////////////////////////////////////////////////////////////////////////////////////

        configuracion_cuenta.txt_cedula.setHorizontalAlignment(0);
        configuracion_cuenta.txt_apellido.setHorizontalAlignment(0);
        configuracion_cuenta.txt_pass.setHorizontalAlignment(0);
        configuracion_cuenta.txt_correo.setHorizontalAlignment(0);
        configuracion_cuenta.txt_nombre.setHorizontalAlignment(0);
        configuracion_cuenta.txt_cuenta.setHorizontalAlignment(0);
        configuracion_cuenta.txt_nuevo_usuario.setHorizontalAlignment(0);
        configuracion_cuenta.txt_pregunta_Segurida.setHorizontalAlignment(0);
        ///////////////////////////////////////////////////////////////////////////////
        configuracion_cuenta.btn_actualizar.setFont(letras_titu_btn);
        configuracion_cuenta.btn_cancelar.setFont(letras_titu_btn);
        configuracion_cuenta.btn_editar_correo.setFont(letras_label);
        configuracion_cuenta.btn_editar_cuenta.setFont(letras_label);
        configuracion_cuenta.btn_editar_pass.setFont(letras_label);
        /////COLORES//////////////////////////////////////////////////////////
        configuracion_cuenta.label_titulo.setForeground(color_botones);

    }

    private void Asignar_Cursor_Agregar_Imagen() {

        configuracion_cuenta.btn_actualizar.setCursor(curso_mano);
        configuracion_cuenta.btn_cancelar.setCursor(curso_mano);
        configuracion_cuenta.btn_editar_correo.setCursor(curso_mano);
        configuracion_cuenta.btn_editar_cuenta.setCursor(curso_mano);
        configuracion_cuenta.btn_editar_pass.setCursor(curso_mano);
        ///////////////////////////////////////////////////////////////////////////////////////////////////

        configuracion_cuenta.btn_editar_correo.setIcon(imagen);
        configuracion_cuenta.btn_editar_cuenta.setIcon(imagen);
        configuracion_cuenta.btn_editar_pass.setIcon(imagen);
        configuracion_cuenta.btn_actualizar.setIcon(icono_guardar);
        configuracion_cuenta.btn_cancelar.setIcon(icono_cancelar);
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        configuracion_cuenta.btn_editar_correo.setHorizontalAlignment(SwingConstants.LEFT);
        configuracion_cuenta.btn_editar_cuenta.setHorizontalAlignment(SwingConstants.LEFT);
        configuracion_cuenta.btn_editar_pass.setHorizontalAlignment(SwingConstants.LEFT);

    }

    private void Bloquear_Items() {

        menu.label_cuenta.setText("h");
        menu.label_apellido.setText("h");
        menu.label_nombre.setText("h");
        menu.label_poner_cedula.setText("h");
        menu.label_correo.setText("h");
        menu.label_contrasena.setText("h");
        menu.item_sesion.setEnabled(true);
       
        menu.item_tienda.setEnabled(false);
        menu.item_registrar.setEnabled(false);
        menu.item_cerrar_sesion.setEnabled(false);

    }

    private void txt_Editable() {

        configuracion_cuenta.txt_cedula.setEditable(false);
        configuracion_cuenta.txt_nombre.setEditable(false);
        configuracion_cuenta.txt_apellido.setEditable(false);
        configuracion_cuenta.txt_cuenta.setEditable(false);
        configuracion_cuenta.txt_pass.setEditable(false);
        configuracion_cuenta.txt_correo.setEditable(false);

    }

    private void txt_Actualizacion(boolean elegir) {

        configuracion_cuenta.txt_nuevo_usuario.setEditable(elegir);
        configuracion_cuenta.txt_pregunta_Segurida.setEditable(elegir);
    }

    private void Estado_Enabled(boolean elegir) {

        configuracion_cuenta.btn_editar_cuenta.setEnabled(elegir);
        configuracion_cuenta.btn_editar_pass.setEnabled(elegir);
        configuracion_cuenta.btn_editar_correo.setEnabled(elegir);

        configuracion_cuenta.btn_actualizar.setEnabled(!elegir);
        configuracion_cuenta.btn_cancelar.setEnabled(!elegir);

    }

    private void limpiar_Cajas() {
        configuracion_cuenta.txt_nuevo_usuario.setText("");
        configuracion_cuenta.txt_pregunta_Segurida.setText("");
    }

    private void Actualizar_Datos() {

        String txt_1 = configuracion_cuenta.txt_nuevo_usuario.getText().trim();
        String txt_pregunta_segu = configuracion_cuenta.txt_pregunta_Segurida.getText().trim();
        String contrasena_antigua = configuracion_cuenta.txt_pass.getText().trim();

        if (!txt_1.isEmpty() && !txt_pregunta_segu.isEmpty()) {

            int retorno = 0;
            boolean correo_correcto = false;
            String elegir_operacion = configuracion_cuenta.label_ayuda.getText().trim();

            if (elegir_operacion.equalsIgnoreCase("USUARIO")) {

                retorno = validar_txt.Validar_Usuario_contrase(txt_1);

            }

            if (elegir_operacion.equalsIgnoreCase("CONTRASENA")) {
                retorno = validar_txt.Validar_Usuario_contrase(txt_1);

            }
            if (elegir_operacion.equalsIgnoreCase("CORREO")) {

                correo_correcto = validar_txt.validar_correo(txt_1);

            }

            if (retorno == 2 || correo_correcto) {

                if (txt_pregunta_segu.equals(contrasena_antigua)) {
                    modelo_nuevo.setTipo_cuenta(txt_1);
                    modelo_nuevo.setCedula(configuracion_cuenta.txt_cedula.getText().trim());
                    crud_nuevo.Actualizar_Datos_Personales(modelo_nuevo, elegir_operacion);
                    showMessageDialog(configuracion_cuenta, elegir_operacion + " Actualizada Correctamente \nInicia Sesion Nuevamente");
                    limpiar_Cajas();
                    configuracion_cuenta.label_nuevo_usuario.setText("Ingrese nuevo valor:");

                    configuracion_cuenta.dispose();
                    Bloquear_Items();

                } else {
                    showMessageDialog(configuracion_cuenta, "Contraseña  de segrudidad incorrecta", "Sistema de ventas", 0, icono_admiracion);
                    limpiar_Cajas();
                }

            } else {
                showMessageDialog(configuracion_cuenta, elegir_operacion + " no cumple con los parametros establecidos", "Sistema de ventas", 0, icono_admiracion);
                limpiar_Cajas();
            }

        } else {
            showMessageDialog(configuracion_cuenta, "Tienes campos vacios", "Sistema de ventas", 0, icono_admiracion);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == configuracion_cuenta.btn_editar_cuenta) {

            configuracion_cuenta.label_nuevo_usuario.setText("Ingrese nuevo usuario:");
            configuracion_cuenta.label_pregun_segurid.setText("Ingrese su contraseña:");
            configuracion_cuenta.label_ayuda.setText("USUARIO");
            txt_Actualizacion(true);
            Estado_Enabled(false);

        }
        if (e.getSource() == configuracion_cuenta.btn_editar_pass) {

            configuracion_cuenta.label_nuevo_usuario.setText("Ingrese nueva contraseña:");
            configuracion_cuenta.label_pregun_segurid.setText("Ingrese su contraseña antigua:");
            configuracion_cuenta.label_ayuda.setText("CONTRASENA");
            txt_Actualizacion(true);
            Estado_Enabled(false);

        }
        if (e.getSource() == configuracion_cuenta.btn_editar_correo) {

            configuracion_cuenta.label_nuevo_usuario.setText("Ingrese nuevo correo:");
            configuracion_cuenta.label_pregun_segurid.setText("Ingrese su contraseña:");
            configuracion_cuenta.label_ayuda.setText("CORREO");
            txt_Actualizacion(true);
            Estado_Enabled(false);

        }

        if (e.getSource() == configuracion_cuenta.btn_cancelar) {

            Estado_Enabled(true);
            txt_Actualizacion(false);
            limpiar_Cajas();
            configuracion_cuenta.label_nuevo_usuario.setText("Ingrese nuevo valor:");
            configuracion_cuenta.label_pregun_segurid.setText("Ingrese su contraseña:");

        }

        if (e.getSource() == configuracion_cuenta.btn_actualizar) {

            Actualizar_Datos();

        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyChar() == KeyEvent.VK_ENTER) {

            if (e.getSource() == configuracion_cuenta.txt_nuevo_usuario) {

                configuracion_cuenta.txt_pregunta_Segurida.requestFocus();
            }
            if (e.getSource() == configuracion_cuenta.txt_pregunta_Segurida) {

                Actualizar_Datos();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Object objeto = e.getSource();

            if (objeto == configuracion_cuenta.txt_nuevo_usuario) {
                configuracion_cuenta.txt_pregunta_Segurida.requestFocus();
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            Object objeto = e.getSource();

            if (objeto == configuracion_cuenta.txt_pregunta_Segurida) {
                configuracion_cuenta.txt_nuevo_usuario.requestFocus();
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        limpiar_Cajas();

        Estado_Enabled(true);
        configuracion_cuenta.label_nuevo_usuario.setText("Ingrese nuevo valor:");
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    private final Font letras_label = new Font("Dialog", Font.BOLD, 13);
    private final Font letras_titu_btn = new Font("Dialog", Font.BOLD, 18);
    private final Font letra_txt;
    private final Cursor curso_mano = new Cursor(Cursor.HAND_CURSOR);
    private final ImageIcon imagen = new ImageIcon("src/Image_2/editar_2.png");
    private final Color color_botones;
    private final ImageIcon icono_guardar;
    private final ImageIcon icono_cancelar;
    private final ImageIcon icono_admiracion;
}
