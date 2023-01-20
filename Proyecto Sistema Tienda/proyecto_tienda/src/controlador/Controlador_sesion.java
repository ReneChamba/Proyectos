package controlador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.font.TextAttribute;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import static javax.swing.JOptionPane.*;
import javax.swing.SwingConstants;
import modelo.*;
import vistas.*;

public class Controlador_sesion implements ActionListener, FocusListener, KeyListener, MouseListener {

    private Modelo modelo;
    private Sesion sesion;
    private Crud_Cuentas crud_cuentas;
    private Menu_Principal menu;
    private Controlador_Recuperar_Pass controlador_recuperar_pass;

    public Controlador_sesion(Modelo modelo, Sesion sesion, Crud_Cuentas crud_cuentas, Menu_Principal menu,
            Controlador_Recuperar_Pass controlador_recuperar_pass) {
        this.modelo = modelo;
        this.sesion = sesion;
        this.crud_cuentas = crud_cuentas;
        this.menu = menu;
        this.controlador_recuperar_pass = controlador_recuperar_pass;
        ///////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////77
        this.sesion.btn_ingresar.addActionListener(this);
        this.sesion.txt_usuario.addFocusListener(this);
        this.sesion.txt_pass.addFocusListener(this);
        this.sesion.txt_usuario.addKeyListener(this);
        this.sesion.txt_pass.addKeyListener(this);
        this.sesion.label_recuperar_pass.addMouseListener(this);
        this.sesion.btn_ingresar.addMouseListener(this);
        this.sesion.btn_ingresar.addMouseListener(this);
        Transparente_Txt();
        Asignar_Fuente_Letra();
        Evento_Closing();
        Asignar_Colores_Letra();
        this.sesion.setResizable(false);
    }

    public void Iniciar_Componentes() {

        sesion.setLocationRelativeTo(null);

        sesion.label_usuario_vacio.setVisible(false);

        sesion.setVisible(true);

    }

    private void Asignar_Fuente_Letra() {

        sesion.label_titulo.setFont(new Font("Dialog", Font.BOLD, 20));
        sesion.btn_ingresar.setFont(new Font("Dialog", Font.BOLD, 23));
        /////////////////////Iconos///////////////////////////////////////////////////

        sesion.label_usuario.setIcon(new ImageIcon("src/Image_2/usuario_poner.png"));
        sesion.label_pass.setIcon(new ImageIcon("src/Image_2/icono-password_2.png"));

        //////////////////////////////////////////////////////////////////////////////////////////
        //      sesion.btn_ingresar.setBorder( new Border ());
        /////////////////////////////////////////////////////////////////////////////////////////
        sesion.label_recuperar_pass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sesion.btn_ingresar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ///////////////////////////////////////////////////////////////////////////////////////////
        sesion.txt_usuario.setFont(new Font("Dialog", Font.BOLD, 15));
        sesion.txt_usuario.setHorizontalAlignment(0);

        sesion.txt_pass.setHorizontalAlignment(SwingConstants.CENTER);
        sesion.txt_pass.setFont(new Font("Dialog", Font.BOLD, 15));
        ////////////////////////////////////////////////////////////////////////////////////////////////////

    }

    private void Asignar_Colores_Letra() {

        sesion.label_titulo.setForeground(new Color(30, 138, 137));
        sesion.btn_ingresar.setForeground(Color.BLACK);
        sesion.label_usuario_vacio.setForeground(Color.red);

        sesion.btn_ingresar.setBackground(new Color(30, 138, 137));

    }

    private void Transparente_Txt() {

        Trasparente usuario = new Trasparente("Ingrese su usuario", sesion.txt_usuario, Trasparente.Show.ALWAYS);
        Trasparente pass = new Trasparente("Ingrese su contraseña", sesion.txt_pass, Trasparente.Show.ALWAYS);

    }

    private void Evento_Closing() {

        WindowListener evento_Ventana = new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                sesion.txt_usuario.setText("");
                sesion.txt_pass.setText("");

            }

        };
        sesion.addWindowListener(evento_Ventana);

    }

    private void Iniciar_Sesiones() {
        boolean habilitar_items = false;

        String usuario = sesion.txt_usuario.getText();
        String pass = sesion.txt_pass.getText();
        boolean estado = true;

        if (!usuario.isEmpty() && !pass.isEmpty()) {
            modelo.setUsuario(usuario);
            modelo.setContasena(pass);

            String sms = "Bienvenido";

            if (!crud_cuentas.Iniciar_Sesion(modelo)) {
                estado = false;
                sms = "Incorrecto";
                icono_bien = new ImageIcon("src/Image_Sms/admiracion_nueva.png");

            } else {
                icono_bien = new ImageIcon("src/Image_Sms/visto_bien.png");
            }
            boolean recorrer = false;
            if (estado) {

                String tipo_cuenta = modelo.getTipo_cuenta();
                String estado_cuenta = modelo.getEstado_Cuenta();

                if (!estado_cuenta.equals("AC")) {
                    sms = "Su cuenta se encuentra desactivada";
                    icono_bien = new ImageIcon("src/Image_Sms/admiracion_nueva.png");

                } else {
                    recorrer = true;

                    menu.item_tienda.setEnabled(true);
                    menu.item_sesion.setEnabled(false);
                    menu.item_cerrar_sesion.setEnabled(true);
                    menu.item_configuracion.setEnabled(true);

                    // ponga la cedula  de la cuenta que se logeo, que me ayudara en 
                    // el formulairo configuracion de la cuenta.
                    menu.label_poner_cedula.setText(modelo.getCedula());
                    menu.label_apellido.setText(modelo.getApellido());
                    menu.label_nombre.setText(modelo.getNombre());
                    menu.label_correo.setText(modelo.getCorreo());
                    menu.label_contrasena.setText(pass);
                    menu.label_cuenta.setText(usuario);
                    menu.label_usu_activado.setText("Usuario: " + menu.label_nombre.getText() + " "
                            + menu.label_apellido.getText()); //label q sirve para que salga el nombre del usuario en el menu 
                    //principal
                    menu.label_usu_activado.setForeground(menu.item_clientes.getForeground()); //le pongo le color de cualquiera de los items hjos
                    menu.label_usu_activado.setVisible(true);//lo hago visible a ese label

                    if (!tipo_cuenta.equalsIgnoreCase("Empleado")) {
                        habilitar_items = true;

                    }
                    menu.item_cuentas_usuarios.setEnabled(habilitar_items);
                    menu.item_menu_estadisticas.setEnabled(habilitar_items);
                    menu.item_registrar.setEnabled(habilitar_items);

                }

            }

            showMessageDialog(sesion, sms, "Sistema de Ventas", 0, icono_bien);  // primero muestre el sms para que no tenga un moviimiento brusco
            if (estado && recorrer) {
                sesion.dispose();

            }
            sesion.txt_usuario.setText("");
            sesion.txt_pass.setText("");
            sesion.txt_usuario.requestFocus();

        } else {
            sesion.label_usuario_vacio.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Iniciar_Sesiones();
    }

    @Override
    public void focusGained(FocusEvent e) {

        sesion.label_usuario_vacio.setVisible(false);
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyChar() == KeyEvent.VK_ENTER) {

            if (e.getSource() == sesion.txt_usuario) {

                sesion.txt_pass.requestFocus();

            } else if (e.getSource() == sesion.txt_pass) {
                Iniciar_Sesiones();
            }
        }

    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == sesion.label_recuperar_pass) {

            controlador_recuperar_pass.Iniciar_Componentes();

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == sesion.label_recuperar_pass) {
            Font font = sesion.label_recuperar_pass.getFont();

            Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();

            map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            font = font.deriveFont(map);

            sesion.label_recuperar_pass.setFont(font);
            sesion.label_recuperar_pass.setForeground(new Color(30, 138, 137));

        } else if (e.getSource() == sesion.btn_ingresar) {
            //sesion.btn_ingresar.setForeground(new Color(30, 138, 137));
            sesion.btn_ingresar.setBackground(new Color(100, 80, 250));

        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == sesion.label_recuperar_pass) {
            Font font = sesion.label_recuperar_pass.getFont();

            Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();

            map.put(TextAttribute.UNDERLINE, -1);
            font = font.deriveFont(map);

            sesion.label_recuperar_pass.setFont(font);
            sesion.label_recuperar_pass.setForeground(Color.BLACK);

        } else if (e.getSource() == sesion.btn_ingresar) {
            sesion.btn_ingresar.setForeground(Color.BLACK);

            sesion.btn_ingresar.setBackground(new Color(30, 138, 137));
        }

    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private ImageIcon icono_bien;
}
