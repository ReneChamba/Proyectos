package controlador;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import static javax.swing.JOptionPane.*;
import javax.swing.SwingConstants;
import modelo.*;
import vistas.Registrar;

public class Controlador_Registrar implements ActionListener, FocusListener, KeyListener {

    private Modelo modelo;
    private Registrar registrar;
    private Crud_Cuentas crud_cuentas;
    private Validacion_txt validacion_txt;

    public Controlador_Registrar(Modelo modelo, Registrar registrar, Crud_Cuentas crud_cuentas, Validacion_txt validacion_txt) {
        this.modelo = modelo;
        this.registrar = registrar;
        this.crud_cuentas = crud_cuentas;
        this.validacion_txt = validacion_txt;
        //////////////////////////////////////////////////////////////////////////////////////////////
        /*
        INICIALIZAR CONSTANTES
         */
        color_botones = new Color(30, 138, 137);//color de los botones y del titulo
        cursor_mano = new Cursor(Cursor.HAND_CURSOR);
        letra_txt = new Font("Dialog", Font.BOLD + Font.ITALIC, 13);
        letras_botones = new Font("Dialog", Font.BOLD, 20);
        letras_label = new Font("Dialog", Font.BOLD, 14);
        icono_prod_vacio = new ImageIcon("src/Image_Sms/admiracion_nueva.png");
        icono_pregunta = new ImageIcon("src/Image_Sms/icono_pregunta_nuevo.png");
        icono_bien = new ImageIcon("src/Image_Sms/visto_bien.png");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        this.registrar.btn_registrar.addActionListener(this);
        this.registrar.btn_continuar.addActionListener(this);
        this.registrar.btn_cancelar.addActionListener(this);
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        this.registrar.label_cedula_incorrecta.setVisible(false);
        this.registrar.label_usuario_no_cumple.setVisible(false);
        this.registrar.label_pass_no_cumple.setVisible(false);
        this.registrar.label_correo_incorrecto.setVisible(false);
        //////////////////////////////////////////////////////////////////////////////////////////////////
        this.registrar.txt_cedula.addFocusListener(this);
        this.registrar.txt_usuario_reegis.addFocusListener(this);
        this.registrar.txt_pass_reegis.addFocusListener(this);
        this.registrar.txt_correo_electronico.addFocusListener(this);
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        this.registrar.txt_cedula.addKeyListener(this);
        this.registrar.txt_nombre.addKeyListener(this);
        this.registrar.txt_apellido.addKeyListener(this);

        this.registrar.txt_usuario_reegis.addKeyListener(this);
        this.registrar.txt_pass_reegis.addKeyListener(this);
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        this.registrar.setResizable(false);
        Grupo_Botones_Check();
        Asignar_Cursor();
        Asignar_Fuente_Controles();
        Centrar_Textto_Txt_Tipo_Letra();
        Evento_Closing();
        Restricciones();//este metodo obliago va antes de asignar_transparente
        Asignar_Transparente();
        Estados_Bloqueados_False_True(false);
        Asignar_Color_Inicial();

    }

    public void Estados_Iniciales() {

        registrar.setLocationRelativeTo(null);
        registrar.chech_empleado.setSelected(true);
        registrar.setVisible(true);
    }

    private void Grupo_Botones_Check() {
        registrar.grupo_botones.add(registrar.chech_empleado);
        registrar.grupo_botones.add(registrar.chech_admin);

    }

    private void Datos_Personales_False_True(boolean elegir_estado) {

        registrar.txt_cedula.setEditable(elegir_estado);
        registrar.txt_nombre.setEditable(elegir_estado);
        registrar.txt_apellido.setEditable(elegir_estado);
        registrar.txt_correo_electronico.setEditable(elegir_estado);
        registrar.btn_continuar.setEnabled(elegir_estado);
    }

    private void Estados_Bloqueados_False_True(boolean elegir_estado) {

        registrar.txt_usuario_reegis.setEditable(elegir_estado);
        registrar.txt_pass_reegis.setEditable(elegir_estado);
        registrar.txt_confirmar_pass.setEditable(elegir_estado);
        registrar.btn_registrar.setEnabled(elegir_estado);
        registrar.btn_cancelar.setEnabled(elegir_estado);
        registrar.chech_admin.setEnabled(elegir_estado);
        registrar.chech_empleado.setEnabled(elegir_estado);

    }

    private void Evento_Closing() {

        WindowListener evento_Ventana = new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                Btn_Cancelar();

            }

        };
        registrar.addWindowListener(evento_Ventana);

    }

    private void Asignar_Fuente_Controles() {

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        registrar.btn_continuar.setFont(letras_botones);
        registrar.btn_cancelar.setFont(letras_botones);
        registrar.btn_registrar.setFont(letras_botones);
        registrar.label_titulo.setFont(letras_botones);
        registrar.label_titulo.setHorizontalAlignment(SwingConstants.CENTER);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7
        registrar.label_cedula.setFont(letras_label);
        registrar.label_nombre.setFont(letras_label);
        registrar.label_apellido.setFont(letras_label);
        registrar.label_correo.setFont(letras_label);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7

        registrar.label_tipo_cuenta.setFont(letras_label);
        registrar.label_crear_usuario.setFont(letras_label);
        registrar.label_crear_pas.setFont(letras_label);
        registrar.label_repeat_pass.setFont(letras_label);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        registrar.chech_empleado.setFont(letras_label);
        registrar.chech_admin.setFont(letras_label);
    }

    private void Asignar_Cursor() {

        registrar.btn_continuar.setCursor(cursor_mano);
        registrar.btn_cancelar.setCursor(cursor_mano);
        registrar.btn_registrar.setCursor(cursor_mano);
        registrar.chech_empleado.setCursor(cursor_mano);
        registrar.chech_admin.setCursor(cursor_mano);

    }

    private void Btn_Continuar() {

        String cedula = registrar.txt_cedula.getText();
        String nombre = registrar.txt_nombre.getText();
        String apellido = registrar.txt_apellido.getText();
        String correo = registrar.txt_correo_electronico.getText();

        if (!cedula.isEmpty() && !nombre.isEmpty() && !apellido.isEmpty() && !correo.isEmpty() && !registrar.label_cedula_incorrecta.isVisible() && !registrar.label_correo_incorrecto.isVisible()) {

            Datos_Personales_False_True(false);/// cuando continuo a crar la cuenta , le paso false para los datos personales
            Estados_Bloqueados_False_True(true);
            registrar.txt_usuario_reegis.requestFocus();

        } else if (registrar.label_cedula_incorrecta.isVisible()) {
            showMessageDialog(registrar, "La cedula  ingresada es incorrecta", "Sistema de Ventas", 0, icono_prod_vacio);

        } else if (registrar.label_correo_incorrecto.isVisible()) {
            showMessageDialog(registrar, "El correo ingresado  es incorrecto", "Sistema de Ventas", 0, icono_prod_vacio);
        } else {
            showMessageDialog(registrar, "Tiene campos Vacios", "Sistema de Ventas", 0, icono_prod_vacio);
        }

    }

    private void Limpiar_Cajas() {

        //////////////////////////////////////////////////////////
        registrar.txt_cedula.setText("");
        registrar.txt_nombre.setText("");
        registrar.txt_apellido.setText("");
        registrar.txt_correo_electronico.setText("");
        //////////////////////////////////////////////////////////////
        registrar.txt_pass_reegis.setText("");
        registrar.txt_usuario_reegis.setText("");
        registrar.txt_confirmar_pass.setText("");
        registrar.label_usuario_no_cumple.setVisible(false);
        registrar.label_pass_no_cumple.setVisible(false);
        ///////////////////////////////////////////////////////////////

    }

    private void Btn_Cancelar() {
        Limpiar_Cajas();
        Estados_Bloqueados_False_True(false);
        Datos_Personales_False_True(true);// activo de nuevo los datos personales si cancelo la operación

    }

    private void Asignar_Transparente() {

        Trasparente cedula = new Trasparente("Campo Obligatorio", registrar.txt_cedula, Trasparente.Show.ALWAYS);
        Trasparente nombre = new Trasparente("Campo Obligatorio", registrar.txt_nombre, Trasparente.Show.ALWAYS);
        Trasparente apellido = new Trasparente("Campo Obligatorio", registrar.txt_apellido, Trasparente.Show.ALWAYS);
        Trasparente correo = new Trasparente("Campo Obligatorio", registrar.txt_correo_electronico, Trasparente.Show.ALWAYS);
        Trasparente usuario = new Trasparente("Campo Obligatorio", registrar.txt_usuario_reegis, Trasparente.Show.ALWAYS);
        Trasparente pass = new Trasparente("Campo Obligatorio", registrar.txt_pass_reegis, Trasparente.Show.ALWAYS);
        Trasparente repe_pass = new Trasparente("Campo Obligatorio", registrar.txt_confirmar_pass, Trasparente.Show.ALWAYS);

    }

    private void Restricciones() {
        RestrictedTextField txt_cedula = new RestrictedTextField(registrar.txt_cedula);
        txt_cedula.setLimit(10);
        txt_cedula.setOnlyNums(true);

        RestrictedTextField txt_nombre = new RestrictedTextField(registrar.txt_nombre);
        txt_nombre.setLimit(40);
        txt_nombre.setAcceptSpace(true);
        txt_nombre.setOnlyText(true);

        RestrictedTextField txt_apellido = new RestrictedTextField(registrar.txt_apellido);
        txt_apellido.setLimit(40);
        txt_apellido.setAcceptSpace(true);
        txt_apellido.setOnlyText(true);

        RestrictedTextField txt_correo = new RestrictedTextField(registrar.txt_correo_electronico);
        txt_correo.setLimit(40);

        RestrictedTextField txt_usuario = new RestrictedTextField(registrar.txt_usuario_reegis);
        txt_usuario.setLimit(40);

        RestrictedTextField txt_pass = new RestrictedTextField(registrar.txt_pass_reegis);
        txt_pass.setLimit(40);

        RestrictedTextField txt_confirmar_pass = new RestrictedTextField(registrar.txt_confirmar_pass);
        txt_confirmar_pass.setLimit(40);

    }

    private void Centrar_Textto_Txt_Tipo_Letra() {

        registrar.txt_cedula.setHorizontalAlignment(0);
        registrar.txt_nombre.setHorizontalAlignment(0);
        registrar.txt_apellido.setHorizontalAlignment(0);
        registrar.txt_correo_electronico.setHorizontalAlignment(0);
        registrar.txt_usuario_reegis.setHorizontalAlignment(0);
        registrar.txt_pass_reegis.setHorizontalAlignment(0);
        registrar.txt_confirmar_pass.setHorizontalAlignment(0);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////7

        registrar.txt_cedula.setFont(letra_txt);
        registrar.txt_nombre.setFont(letra_txt);
        registrar.txt_apellido.setFont(letra_txt);
        registrar.txt_correo_electronico.setFont(letra_txt);
        registrar.txt_usuario_reegis.setFont(letra_txt);
        registrar.txt_pass_reegis.setFont(letra_txt);
        registrar.txt_confirmar_pass.setFont(letra_txt);

    }

    private void Asignar_Color_Inicial() {

        registrar.label_titulo.setForeground(color_botones);
        registrar.btn_continuar.setBackground(color_botones);
        registrar.btn_cancelar.setBackground(color_botones);
        registrar.btn_registrar.setBackground(color_botones);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        registrar.label_cedula_incorrecta.setForeground(Color.red);
        registrar.label_correo_incorrecto.setForeground(Color.red);
        registrar.label_usuario_no_cumple.setForeground(Color.red);
        registrar.label_pass_no_cumple.setForeground(Color.red);

    }

    private void Registrar_Cuenta() {
        String usuario = registrar.txt_usuario_reegis.getText().trim();
        String pass = registrar.txt_pass_reegis.getText().trim();
        String repetir_pass = registrar.txt_confirmar_pass.getText().trim();

        if (!usuario.isEmpty() && !pass.isEmpty() && !repetir_pass.isEmpty()) {

            int r = validacion_txt.Validar_Usuario_contrase(usuario);
            int r2 = validacion_txt.Validar_Usuario_contrase(pass);

            if (r == 2 && r2 == 2) {

                if (repetir_pass.equals(pass)) {
                    /*validar  que las contraseñas sean iguales*/

                    String opciones[] = {"Crear Cuenta", "Cancelar"};

                    int respuesta = showOptionDialog(registrar, "        Seguro desea crear la cuenta", "Sistema de Mercado", 0, QUESTION_MESSAGE, icono_pregunta, opciones, opciones[1]);
                    if (respuesta == 0) {

                        /*Confirmar la creacion de la cuenta*/
                        String tipo_cuenta = registrar.chech_empleado.getText();
                        if (registrar.chech_admin.isSelected()) {
                            tipo_cuenta = registrar.chech_admin.getText();

                        }

                        String cedula = registrar.txt_cedula.getText();
                        String nombre = registrar.txt_nombre.getText();
                        String apellido = registrar.txt_apellido.getText();
                        String correo = registrar.txt_correo_electronico.getText();

                        modelo.setCedula(cedula);
                        modelo.setNombre(nombre);
                        modelo.setApellido(apellido);
                        modelo.setCorreo(correo);
                        modelo.setTipo_cuenta(tipo_cuenta);
                        modelo.setUsuario(usuario);
                        modelo.setContasena(pass);
                        modelo.setEstado_Cuenta("AC");//siempre que registre una cuenta nueva el estao sera activa

                        if (crud_cuentas.Registrar(modelo)) {
                            /*si retorna true la cuenta se crea*/
                            showMessageDialog(registrar, "Cuenta Creada", "Sistema de Ventas", 0, icono_bien);
                            Btn_Cancelar();
                            registrar.dispose();

                        } else {
                            showMessageDialog(registrar, "Erro, No se pudo crear la cuenta", "Sistema de Ventas", 0, icono_prod_vacio);
                            registrar.txt_pass_reegis.setText("");
                            registrar.txt_usuario_reegis.setText("");
                        }
                    }

                } else {
                    showMessageDialog(registrar, "Contraseñan no coinciden", "Sistema de Ventas", 0, icono_prod_vacio);
                    registrar.txt_confirmar_pass.setText("");
                    registrar.txt_confirmar_pass.requestFocus();
                }

            } else {
                showMessageDialog(registrar, "Credenciales No cumple con los parametros establecidos", "Sistema de Ventas", 0, icono_prod_vacio);
            }

        } else {
            showMessageDialog(registrar, "Tiene campos Vacios", "Sistema de Ventas", 0, icono_prod_vacio);
        }
    }

    ////////////////EVENTO ACTION PERFORMED/////////////////////////////////////////////////////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == registrar.btn_continuar) {
                Btn_Continuar();

            }

            if (e.getSource() == registrar.btn_registrar) {

                Registrar_Cuenta();
            }
            if (e.getSource() == registrar.btn_cancelar) {
                Btn_Cancelar();

            }

        } catch (Exception ex) {
        }

    }

    /////////////////////////EVENTO DE FOCO//////////////////////////////////////////////////////////////////////////////////////77
    @Override
    public void focusGained(FocusEvent e) {

        Object control = e.getSource();
        if (control == registrar.txt_cedula) {

            registrar.label_cedula_incorrecta.setText("cedula incorrecta");
            registrar.label_cedula_incorrecta.setVisible(false);
        }
        if (control == registrar.txt_correo_electronico) {

            registrar.label_correo_incorrecto.setVisible(false);

        }

        if (control == registrar.txt_usuario_reegis) {

            registrar.label_usuario_no_cumple.setVisible(false);

        }

        if (control == registrar.txt_pass_reegis) {

            registrar.label_pass_no_cumple.setVisible(false);

        }

    }

    @Override
    public void focusLost(FocusEvent e) {

        try {

            Object control = e.getSource();

            if (control == registrar.txt_cedula) {
                String tomar_cedula = registrar.txt_cedula.getText();

                if (!tomar_cedula.isEmpty()) {
                    if (tomar_cedula.length() < 10) {

                        registrar.label_cedula_incorrecta.setText("Digita 10 números");
                        registrar.label_cedula_incorrecta.setVisible(true);

                    } else if (tomar_cedula.length() == 10) {
                        if (!validacion_txt.Validar_cedula(tomar_cedula)) {

                            registrar.label_cedula_incorrecta.setVisible(true);

                        }
                    }

                }

            } else if (control == registrar.txt_usuario_reegis) {
                String tomar_usuario = registrar.txt_usuario_reegis.getText().trim();

                if (!tomar_usuario.isEmpty()) {

                    if (validacion_txt.Validar_Usuario_contrase(tomar_usuario) != 2) {
                        registrar.label_usuario_no_cumple.setVisible(true);

                    }

                }

            } else if (control == registrar.txt_pass_reegis) {
                String tomar_pass = registrar.txt_pass_reegis.getText().trim();

                if (!tomar_pass.isEmpty()) {

                    if (validacion_txt.Validar_Usuario_contrase(tomar_pass) != 2) {
                        registrar.label_pass_no_cumple.setVisible(true);

                    }

                }

            } else if (control == registrar.txt_correo_electronico) {
                String tomar_correo = registrar.txt_correo_electronico.getText().trim();
                if (!tomar_correo.isEmpty()) {

                    if (!validacion_txt.validar_correo(tomar_correo)) {

                        registrar.label_correo_incorrecto.setVisible(true);

                    }
                }

            }

        } catch (Exception ex) {
            System.out.println("error   el evetno focus lost " + ex.getMessage());
        }

    }

    ////////////////////Evento de Tecla/////////////////////////////////////////////////////////////////////////
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        char letra = e.getKeyChar();

        if (letra == KeyEvent.VK_ENTER) {

            Object control_txt = e.getSource();

            if (control_txt == registrar.txt_cedula) {
                registrar.txt_nombre.requestFocus();

            }
            if (control_txt == registrar.txt_nombre) {
                registrar.txt_apellido.requestFocus();

            }

            if (control_txt == registrar.txt_apellido) {
                registrar.txt_correo_electronico.requestFocus();

            }

            if (control_txt == registrar.txt_usuario_reegis) {
                registrar.txt_pass_reegis.requestFocus();

            }
            if (control_txt == registrar.txt_pass_reegis) {
                registrar.txt_confirmar_pass.requestFocus();

            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getSource() == registrar.txt_pass_reegis) {

            String pass = registrar.txt_pass_reegis.getText();

            if (pass.isEmpty()) {

                registrar.txt_confirmar_pass.setText("");

            }

        }

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////7

    private final Cursor cursor_mano;
    private final Font letra_txt;
    private final Font letras_botones;
    private final Font letras_label;
    private final Color color_botones;
    private final ImageIcon icono_bien;
    private final ImageIcon icono_prod_vacio;
    private final ImageIcon icono_pregunta;

}
