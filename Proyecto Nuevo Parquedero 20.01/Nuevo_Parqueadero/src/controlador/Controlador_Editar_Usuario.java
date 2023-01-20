package controlador;

import java.awt.Color;
import vista.Editar_Usuario;
import modelo.Crud_Primero;
import modelo.Modelo_Nuevo;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import mensajes.Joption;
import modelo.Fuentes_Y_Mas;
import modelo.Iconos;

public class Controlador_Editar_Usuario implements ActionListener, KeyListener {

    private Editar_Usuario editar_usuario;
    private Crud_Primero crud_primero;
    private Modelo_Nuevo modelo_nuevo;
    private Controlador_Menu_Principal controlador_menu_principal;

    private Iconos iconos;
    private Joption mensajes;
    private Fuentes_Y_Mas fuentes_Y_mas;
    private Controlador_Sms controlador_sms;

    public Controlador_Editar_Usuario(Editar_Usuario editar_usuario, Crud_Primero crud_primero, Modelo_Nuevo modelo_nuevo) {

    }

    public void setEditar_Usuario(Editar_Usuario editar_usuario) {
        this.editar_usuario = editar_usuario;
    }

    public void setModelo_nuevo(Modelo_Nuevo modelo_nuevo) {
        this.modelo_nuevo = modelo_nuevo;

    }

    public void setCrud_Primero(Crud_Primero crud_primero) {
        this.crud_primero = crud_primero;
    }

    public void setFuentes_Y_Mas(Fuentes_Y_Mas fuentes_Y_Mas) {
        this.fuentes_Y_mas = fuentes_Y_Mas;
    }

    public void setMensajes(Joption mensajes_2) {
        this.mensajes = mensajes_2;
    }

    public void setIconos(Iconos iconos) {
        this.iconos = iconos;
    }

    public void Controlador_Menu_Principal(Controlador_Menu_Principal controlador_menu_principal) {
        this.controlador_menu_principal = controlador_menu_principal;

    }

    public void setLanzar_Mensaje(Controlador_Sms controlador_sms) {
        this.controlador_sms = controlador_sms;
    }

    public void Estado_Constructor() {

        controlar = 0;
        ///---------------Poner a la escucha los botones----------------
        editar_usuario.btn_cancelar.addActionListener(this);
        editar_usuario.btn_contrasena.addActionListener(this);
        editar_usuario.btn_usuario.addActionListener(this);
        editar_usuario.btn_guardar.addActionListener(this);
        editar_usuario.btn_nombre.addActionListener(this);

        /////////////////////////////////////////////////////////////////////////
        editar_usuario.txt_confirmar.addKeyListener(this);
        editar_usuario.txt_nuevo_dato.addKeyListener(this);
        editar_usuario.setResizable(false);
        editar_usuario.setTitle(fuentes_Y_mas.getTitulo());

        Deshabilitar_Text();
        Evento_Ventana();
        Diseno();

    }

    private void Diseno() {

        editar_usuario.lb_titulo.setFont(fuentes_Y_mas.getLetra_Titulos());

        editar_usuario.lb_id.setFont(fuentes_Y_mas.getLetra_Txt());
        editar_usuario.lb_id.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        editar_usuario.lb_cedula.setFont(fuentes_Y_mas.getLetra_label());
        editar_usuario.lb_confirmar.setFont(fuentes_Y_mas.getLetra_label());
        editar_usuario.lb_contrasena.setFont(fuentes_Y_mas.getLetra_label());

        editar_usuario.lb_name_id.setFont(fuentes_Y_mas.getLetra_label());
        editar_usuario.lb_nombre.setFont(fuentes_Y_mas.getLetra_label());
        editar_usuario.lb_nuevo_dato.setFont(fuentes_Y_mas.getLetra_label());
        editar_usuario.lb_usuario.setFont(fuentes_Y_mas.getLetra_label());
        editar_usuario.lb_tipo_cuenta.setFont(fuentes_Y_mas.getLetra_label());

        editar_usuario.txt_cedula.setFont(fuentes_Y_mas.getLetra_Txt());
        editar_usuario.txt_confirmar.setFont(fuentes_Y_mas.getLetra_Txt());
        editar_usuario.txt_contrasena.setFont(fuentes_Y_mas.getLetra_Txt());
        editar_usuario.txt_nombre.setFont(fuentes_Y_mas.getLetra_Txt());
        editar_usuario.txt_nuevo_dato.setFont(fuentes_Y_mas.getLetra_Txt());
        editar_usuario.txt_tipoCuenta.setFont(fuentes_Y_mas.getLetra_Txt());
        editar_usuario.txt_usuario.setFont(fuentes_Y_mas.getLetra_Txt());

        editar_usuario.txt_cedula.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        editar_usuario.txt_confirmar.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        editar_usuario.txt_contrasena.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        editar_usuario.txt_nombre.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        editar_usuario.txt_nuevo_dato.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        editar_usuario.txt_tipoCuenta.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        editar_usuario.txt_usuario.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());

        editar_usuario.btn_nombre.setIcon(iconos.getIcono_editar());
        editar_usuario.btn_usuario.setIcon(iconos.getIcono_editar());
        editar_usuario.btn_contrasena.setIcon(iconos.getIcono_editar());

        editar_usuario.btn_guardar.setIcon(iconos.getIcono_guardar());
        editar_usuario.btn_cancelar.setIcon(iconos.getIcono_cancelar());

        editar_usuario.btn_cancelar.setCursor(fuentes_Y_mas.getCursor());
        editar_usuario.btn_contrasena.setCursor(fuentes_Y_mas.getCursor());
        editar_usuario.btn_guardar.setCursor(fuentes_Y_mas.getCursor());
        editar_usuario.btn_nombre.setCursor(fuentes_Y_mas.getCursor());
        editar_usuario.btn_usuario.setCursor(fuentes_Y_mas.getCursor());

        editar_usuario.lb_titulo.setForeground(fuentes_Y_mas.getColor_titulo());

        editar_usuario.btn_cancelar.setForeground(fuentes_Y_mas.getColor_letra_btn());
        editar_usuario.btn_guardar.setForeground(fuentes_Y_mas.getColor_letra_btn());
        
        editar_usuario.btn_guardar.setBackground(fuentes_Y_mas.getColor_Fondo_btn());
        editar_usuario.btn_cancelar.setBackground(fuentes_Y_mas.getColor_Fondo_btn());
        editar_usuario.btn_contrasena.setBackground(fuentes_Y_mas.getColor_Fondo_btn());
        editar_usuario.btn_nombre.setBackground(fuentes_Y_mas.getColor_Fondo_btn());
        editar_usuario.btn_usuario.setBackground(fuentes_Y_mas.getColor_Fondo_btn());

        editar_usuario.panel_Datos.setBorder(fuentes_Y_mas.getBorder("Datos Personales", Color.BLACK));
        editar_usuario.panel_actualizar.setBorder(fuentes_Y_mas.getBorder("Datos Actualizar", Color.BLACK));
        
        editar_usuario.lb_id.setBorder(fuentes_Y_mas.getBorderlinea(fuentes_Y_mas.getColor_Bien()));

    }

    public void Iniciar_Componentes() {

        editar_usuario.setLocation(fuentes_Y_mas.centrar_Pantalla(editar_usuario.getWidth()), 130);

        editar_usuario.setVisible(true);

    }

    public void Datos_Usuarios(String id_usuario, String cedula, String nombre, String usuario, String contrasena, String tipo_cuenta) {
        editar_usuario.lb_id.setText(id_usuario);
        editar_usuario.txt_nombre.setText(nombre);
        editar_usuario.txt_usuario.setText(usuario);
        editar_usuario.txt_contrasena.setText(contrasena);
        editar_usuario.txt_cedula.setText(cedula);
        editar_usuario.txt_tipoCuenta.setText(tipo_cuenta);

    }

    private void Deshabilitar_Text() {

        editar_usuario.txt_nombre.setEditable(false);
        editar_usuario.txt_usuario.setEditable(false);
        editar_usuario.txt_contrasena.setEditable(false);
        editar_usuario.txt_tipoCuenta.setEditable(false);
        editar_usuario.txt_cedula.setEditable(false);
        Panel_Edicion(false);

    }

    private void Panel_Edicion(boolean estado) {
        editar_usuario.txt_nuevo_dato.setEditable(estado);
        editar_usuario.txt_confirmar.setEditable(estado);
        editar_usuario.btn_cancelar.setEnabled(estado);
        editar_usuario.btn_guardar.setEnabled(estado);

    }

    private void Botones_Editar(boolean estado) {
        editar_usuario.btn_usuario.setEnabled(estado);
        editar_usuario.btn_contrasena.setEnabled(estado);
        editar_usuario.btn_nombre.setEnabled(estado);

    }

    private void Limpiar_Txt(String limpiar, String texto_nuevo) {

        editar_usuario.txt_nuevo_dato.setText(limpiar);
        editar_usuario.txt_confirmar.setText(limpiar);
        editar_usuario.lb_nuevo_dato.setText(texto_nuevo);

    }

    private void Evento_Ventana() {

        WindowListener evento = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                Limpiar_Txt("", "Ingrese nuevo Dato");
                Panel_Edicion(false);
                Botones_Editar(true);

            }

        };
        editar_usuario.addWindowListener(evento);

    }

    private void GuardarCambios() {

        String datoNuevo = editar_usuario.txt_nuevo_dato.getText().trim();
        String confContrasena = editar_usuario.txt_confirmar.getText().trim();
        String contrasena_veri = editar_usuario.txt_contrasena.getText().trim();

        String sms = "Contrasena incorrecta";
        Color color = fuentes_Y_mas.getColor_Mal();
        if (contrasena_veri.equals(confContrasena)) {

            String id_parametro = editar_usuario.lb_id.getText().trim();

            modelo_nuevo.setNombre(datoNuevo);
            modelo_nuevo.setCodigo(id_parametro);

            sms = "No se pudo atualizar el registro";
            if (crud_primero.Actualizar_Datos_Usuario(modelo_nuevo, controlar)) {

                // si se actualiza correcto , actualizo las variable 
                //globales, que se encargan de poner los datos, hago select
                //Ejecutar un select para actualizar los datos                
                crud_primero.Iniciar_Sesion(modelo_nuevo, 1); // 

                controlador_menu_principal.Datos_Usuarios(modelo_nuevo.getCodigo(),
                        modelo_nuevo.getCedula(), modelo_nuevo.getNombre(),
                        modelo_nuevo.getUsuario(), modelo_nuevo.getContrasena(), modelo_nuevo.getTipo_cuenta());

                Limpiar_Txt("", "Ingrese nuevo Dato");
                Panel_Edicion(false);
                Botones_Editar(true);
                sms = "Datos Actualizados Correctamente";
                color = fuentes_Y_mas.getColor_Bien();

            }
            controlador_sms.Iniciar_Componentes(sms, color);
            editar_usuario.dispose();

        } else {
            controlador_sms.Iniciar_Componentes(sms, color);

            editar_usuario.txt_nuevo_dato.setText("");
            editar_usuario.txt_confirmar.setText("");
            editar_usuario.btn_guardar.setEnabled(false);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object boton = e.getSource();

        if (boton == editar_usuario.btn_nombre
                || boton == editar_usuario.btn_usuario
                || boton == editar_usuario.btn_contrasena) {

            String nuevo = "Ingrese nuevo";

            if (boton == editar_usuario.btn_nombre) {
                controlar = 1;
                nuevo += " Nombre:";
            } else if (boton == editar_usuario.btn_usuario) {
                controlar = 0;
                nuevo += " Usuario:";
            } else {
                controlar = 2; // contrasena
                nuevo = "Ingrese nueva Contraseña:";

            }

            editar_usuario.lb_nuevo_dato.setText((nuevo));

            Panel_Edicion(true);
            Botones_Editar(false);
            // los activo y bloqueo de nuevo, lo habilito con el keyReleased
            editar_usuario.btn_guardar.setEnabled(false);
            editar_usuario.txt_nuevo_dato.requestFocus();

        }

        if (boton == editar_usuario.btn_guardar) {
            GuardarCambios();

        }
        if (boton == editar_usuario.btn_cancelar) {
            Limpiar_Txt("", "Ingrese nuevo Dato");
            Panel_Edicion(false);
            Botones_Editar(true);

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

        Object control = e.getSource();

        char letra = e.getKeyChar();

        if (control == editar_usuario.txt_nuevo_dato) {

            if (controlar == 0 | controlar == 2) {

                if (letra == ' ') {
                    e.consume();
                }

            }

            if (controlar == 1) {

                if ((letra < 'a' || letra > 'z') && (letra < 'A' || letra > 'Z')
                        && (letra != ' ')) {
                    e.consume();
                }

            }
        }

        if (control == editar_usuario.txt_confirmar) {

            if (letra == ' ') {

                e.consume();
            }

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DOWN) {

            if (e.getSource() == editar_usuario.txt_nuevo_dato) {
                editar_usuario.txt_confirmar.requestFocus();

            }

        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (e.getSource() == editar_usuario.txt_confirmar) {
                editar_usuario.txt_nuevo_dato.requestFocus();

            }

        }

    }

    private boolean getLongitud() {
        int texto_nuevo = editar_usuario.txt_nuevo_dato.getText().length();
        //.getPassword() retorna un array de char[]
        int texto_confirmar = editar_usuario.txt_confirmar.getPassword().length;
        return texto_nuevo > 2 && texto_confirmar > 2;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        editar_usuario.btn_guardar.setEnabled(getLongitud());

    }

    private int controlar;

}
