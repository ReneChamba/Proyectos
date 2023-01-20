package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import vista.Admin_Usuarios;
import modelo.Crud_Primero;
import modelo.Modelo_Nuevo;
import mensajes.Joption;
import modelo.Fuentes_Y_Mas;
import modelo.Iconos;

public class Controlador_Admin_Usuarios implements ActionListener {

    private Admin_Usuarios admin_usuarios;
    private Crud_Primero crud_primero;
    private Modelo_Nuevo modelo_nuevo;
    private Fuentes_Y_Mas fuentes_Y_mas;
    private Joption mensajes;
    private Iconos iconos;
    private Controlador_Sms controlador_sms;
    private Controlador_Sms_Pregunta controlador_sms_pregunta;

    public Controlador_Admin_Usuarios(Admin_Usuarios admin_usuarios, Crud_Primero crud_primero, Modelo_Nuevo modelo_nuevo) {

    }

    public void setAdmin_Usuarios(Admin_Usuarios admin_usuarios) {
        this.admin_usuarios = admin_usuarios;
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

    public void setLanzar_Mensaje(Controlador_Sms controlador_sms) {
        this.controlador_sms = controlador_sms;
    }

    public void setControlador_Sms_Pregunta(Controlador_Sms_Pregunta controlador_Sms_Pregunta) {
        this.controlador_sms_pregunta = controlador_Sms_Pregunta;
    }

    public void Estado_Constructor() {
        habilitar = 0;

        ///////////////////////////////////////////////////
        admin_usuarios.btn_cancelar.addActionListener(this);
        admin_usuarios.btn_guardar.addActionListener(this);
        admin_usuarios.combo_tipo_cuenta.addActionListener(this);
        admin_usuarios.setResizable(false);
        admin_usuarios.setTitle(fuentes_Y_mas.getTitulo());
        Diseno();

        Enabled_txt(false);

        AgregarPopopMenu();
        Habilitar_Botones(false);
        Evento_Ventana();
        ClickTabla();

    }

    private void Diseno() {

        admin_usuarios.lb_titulo.setFont(fuentes_Y_mas.getLetra_Titulos());
        admin_usuarios.lb_codigo.setFont(fuentes_Y_mas.getLetra_Txt());
        admin_usuarios.lb_name_codigo.setFont(fuentes_Y_mas.getLetra_label());
        admin_usuarios.lb_cuenta.setFont(fuentes_Y_mas.getLetra_label());
        admin_usuarios.lb_role.setFont(fuentes_Y_mas.getLetra_label());
        admin_usuarios.lb_nuevo_role.setFont(fuentes_Y_mas.getLetra_label());

        admin_usuarios.txt_cuenta.setFont(fuentes_Y_mas.getLetra_Txt());
        admin_usuarios.txt_role.setFont(fuentes_Y_mas.getLetra_Txt());
        admin_usuarios.lb_codigo.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        admin_usuarios.txt_cuenta.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        admin_usuarios.txt_role.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());

        admin_usuarios.combo_tipo_cuenta.setFont(fuentes_Y_mas.getLetra_Txt());
        admin_usuarios.combo_tipo_cuenta.setCursor(fuentes_Y_mas.getCursor());
        admin_usuarios.btn_cancelar.setCursor(fuentes_Y_mas.getCursor());
        admin_usuarios.btn_guardar.setCursor(fuentes_Y_mas.getCursor());
        admin_usuarios.btn_cancelar.setFont(fuentes_Y_mas.getLetra_btn());
        admin_usuarios.btn_guardar.setFont(fuentes_Y_mas.getLetra_btn());

        admin_usuarios.btn_cancelar.setIcon(iconos.getIcono_cancelar());
        admin_usuarios.btn_guardar.setIcon(iconos.getIcono_guardar());

        admin_usuarios.btn_cancelar.setForeground(fuentes_Y_mas.getColor_letra_btn());
        admin_usuarios.btn_guardar.setForeground(fuentes_Y_mas.getColor_letra_btn());
        admin_usuarios.btn_cancelar.setBackground(fuentes_Y_mas.getColor_Fondo_btn());
        admin_usuarios.btn_guardar.setBackground(fuentes_Y_mas.getColor_Fondo_btn());

        admin_usuarios.lb_titulo.setForeground(fuentes_Y_mas.getColor_titulo());
        admin_usuarios.lb_codigo.setBorder(fuentes_Y_mas.getBorderlinea(fuentes_Y_mas.getColor_Bien()));

    }

    public void Iniciar_Componentes() {

        admin_usuarios.setLocation(fuentes_Y_mas.centrar_Pantalla(admin_usuarios.getWidth()), 130);
        Cargar_Modelo();
        admin_usuarios.setVisible(true);
    }

    private void Cargar_Modelo() {

        modelo_nuevo.setTabla(admin_usuarios.tabla);

        if (!crud_primero.Cargar_Tabla_Usuario(modelo_nuevo)) {
            System.out.println("error ffff");

        }

    }

    private void AgregarPopopMenu() {

        JPopupMenu menu = new JPopupMenu("");

        //la inicializacion de este item lo hago en el consttructor , ya que este item tiene alcanse de clase
        configurar = new JMenuItem("Configurar", iconos.getIcono_editar());
        configurar.setFont(fuentes_Y_mas.getLetra_label());
        configurar.setCursor(fuentes_Y_mas.getCursor());
        JMenuItem eliminar = new JMenuItem("Eliminar", iconos.getIcono_eliminar());
        eliminar.setFont(fuentes_Y_mas.getLetra_label());
        eliminar.setCursor(fuentes_Y_mas.getCursor());

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Eliminar();

            }
        });

        configurar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Habilitar_Botones(true);

                habilitar = 1;
                //bloqueo el btn , de nuevo , cuando de click en la tabla
                //lo habilito
                admin_usuarios.btn_guardar.setEnabled(false);
            }
        });

        menu.add(configurar);
        menu.add(eliminar);

        admin_usuarios.tabla.setComponentPopupMenu(menu);

    }

    private void Enabled_txt(boolean estado) {

        admin_usuarios.txt_cuenta.setEditable(estado);
        admin_usuarios.txt_role.setEditable(estado);

    }

    private void Habilitar_Botones(boolean estado) {

        admin_usuarios.btn_cancelar.setEnabled(estado);
        admin_usuarios.btn_guardar.setEnabled(estado);
        admin_usuarios.combo_tipo_cuenta.setEnabled(estado);
        configurar.setEnabled(!estado);

    }

    private void ClickTabla() {

        MouseListener evento = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (habilitar == 1) {

                    int fila = admin_usuarios.tabla.getSelectedRow();
                    String id_usuario = admin_usuarios.tabla.getValueAt(fila, 0).toString();
                    String cuenta = admin_usuarios.tabla.getValueAt(fila, 3).toString();
                    String role = admin_usuarios.tabla.getValueAt(fila, 4).toString();

                    admin_usuarios.txt_cuenta.setText(cuenta);
                    admin_usuarios.txt_role.setText(role);
                    admin_usuarios.lb_codigo.setText(id_usuario);
                    admin_usuarios.btn_guardar.setEnabled(true);

                }

            }

        };
        admin_usuarios.tabla.addMouseListener(evento);

    }

    private void Limpiar_Texto(String texto) {

        admin_usuarios.combo_tipo_cuenta.setSelectedIndex(0);
        admin_usuarios.txt_cuenta.setText(texto);
        admin_usuarios.txt_role.setText(texto);
        admin_usuarios.lb_codigo.setText("###");

    }

    private void Eliminar() {

        // si esta habilitado este btn quiere decir que habilito la edicion , en el caso que quiera eliminar un registro
        //pero este habilitado ese boton, le digo que cancelar primero la edicion y luego si proceda con la eliminacion
        String sms = "Cancela la operación actual";

        Color color = fuentes_Y_mas.getColor_Mal();
        if (admin_usuarios.btn_guardar.isEnabled() == false) {
            int fila = admin_usuarios.tabla.getSelectedRow();

            sms = "Selecciona un registro para eliminar!";
            if (fila >= 0) {

                String id_codigo = admin_usuarios.tabla.getValueAt(fila, 0).toString();
                String cuenta = admin_usuarios.tabla.getValueAt(fila, 3).toString();
                sms = "¿Eliminar está cuenta : " + cuenta + " ?";
                controlador_sms_pregunta.Iniciar_Componenentes(sms, "Eliminar", "Cancelar", iconos.getIcono_eliminar_pregunta(), iconos.getIcono_actualizar());
                if (controlador_sms_pregunta.getAccion() == 0) {

                    sms = "Surguio un problema al Eliminar...";
                    modelo_nuevo.setCodigo(id_codigo);

                    if (crud_primero.Configura_Usuario(modelo_nuevo, false)) {
                        sms = "Cuenta eliminada con exito";
                        color = fuentes_Y_mas.getColor_Bien();
                        Cargar_Modelo();
                    }

                    Cancelar();
                    controlador_sms.Iniciar_Componentes(sms, color);
                }
            } else {
                controlador_sms.Iniciar_Componentes(sms, color);
            }

        } else {
            controlador_sms.Iniciar_Componentes(sms, color);
        }

    }

    private void Guardar_Cambios() {

        String codigo = admin_usuarios.lb_codigo.getText().trim();
        String role_nuevo = admin_usuarios.txt_role.getText().trim();

        modelo_nuevo.setTipo_cuenta(role_nuevo);
        modelo_nuevo.setCodigo(codigo);

        String sms = "Surguio un error, intentelo de nuevo";
        Color color = fuentes_Y_mas.getColor_Mal();
        if (crud_primero.Configura_Usuario(modelo_nuevo, true)) {

            sms = "Datos Actualizados con exito";
            color = fuentes_Y_mas.getColor_Bien();
            Cargar_Modelo();
            Cancelar();
        }
        controlador_sms.Iniciar_Componentes(sms, color);

    }

    private void Evento_Ventana() {

        WindowListener evento = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {

                Cancelar();
            }

        };
        admin_usuarios.addWindowListener(evento);

    }

    private void Cancelar() {

        Limpiar_Texto("");
        Habilitar_Botones(false);
        habilitar = 0;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == admin_usuarios.btn_cancelar) {

            Cancelar();
        }
        if (e.getSource() == admin_usuarios.btn_guardar) {

            Guardar_Cambios();
        }

        if (e.getSource() == admin_usuarios.combo_tipo_cuenta) {

            String nombre = admin_usuarios.combo_tipo_cuenta.getSelectedItem().toString();

            admin_usuarios.txt_role.setText(nombre);

        }
    }

    private int habilitar;
    JMenuItem configurar;

}
