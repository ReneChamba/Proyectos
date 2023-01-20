package controlador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import modelo.Crud_Nuevo;
import modelo.Modelo_Nuevo;
import vistas.Colores;
import vistas.Menu_Principal;
import static javax.swing.JOptionPane.*;

public class Controlador_Colores implements ActionListener {

    private Modelo_Nuevo modelo_nuevo;
    private Crud_Nuevo crud_nuevo;
    private Colores colores;
    private Menu_Principal menu_principal;

    public Controlador_Colores(Modelo_Nuevo modelo_nuevo, Crud_Nuevo crud_nuevo, Colores colores, Menu_Principal menu_principal) {
        this.modelo_nuevo = modelo_nuevo;
        this.crud_nuevo = crud_nuevo;
        this.colores = colores;
        this.menu_principal = menu_principal;
        /////////////////////////////////////////////////////////////////////////////////////////
        letras_botones = new Font("Dialog", Font.BOLD, 20);
        color_botones = new Color(30, 138, 137);//color de los botones y del titulo
        letras_label = new Font("Dialog", Font.BOLD, 14);
        letra_txt = new Font("Dialog", Font.BOLD + Font.ITALIC, 13);
        icono_pregunta = new ImageIcon("src/Image_Sms/icono_pregunta_nuevo.png");
        icono_prod_vacio = new ImageIcon("src/Image_Sms/admiracion_nueva.png");
        icono_bien = new ImageIcon("src/Image_Sms/visto_bien.png");
        cursor_mano = new Cursor(Cursor.HAND_CURSOR);

        ////////////////////////////////////////////////////////////////////////////////////////////
        this.colores.btn_guardar_cambios.addActionListener(this);
        this.colores.btn_restablecer_letras.addActionListener(this);
        this.colores.btn_apli_color.addActionListener(this);
        this.colores.btn_restablecer_color.addActionListener(this);
        this.colores.btn_cancelar.addActionListener(this);
        this.colores.btn_cancelar_letras.addActionListener(this);
        ///////////////////////////////////////////////////////////////////////////////////////////////

        this.colores.combo_item_padre.addActionListener(this);
        this.colores.combo_item_hijos.addActionListener(this);
        this.colores.combo_fondo.addActionListener(this);
        this.colores.combo_barra.addActionListener(this);
        ///////////////////////////////////////////////////////////////////////////////////////////////
        this.colores.radio_buton_colores.addActionListener(this);
        this.colores.radio_buton_letras.addActionListener(this);

        /////////////////////////////////////////////////////////////////////////////////////////////////
        opciones = new String[2];
        opciones[0] = "Aplicar Cambios";
        opciones[1] = "Cancelar";
        
        /////////////////////////////////////////////////////////////////////////////////////////////////
        Poner_Nombre_Letras();
        Cargar_Colores();
        Cargar_Nombre_Activado();
        Grupo_Botones();
        Asignar_Letra_Color();
        Asignar_Cursor();
        Evento_Ventana();
    }

    public void Iniciar_Componentes() {
        colores.setLocationRelativeTo(null);
        Poner_Inicio();
        Estados_Panel_Letras(true);
        Estados_Panel_Colores(false);

        colores.radio_buton_letras.setSelected(true);
        colores.setVisible(true);

    }

    private void Grupo_Botones() {

        colores.grupo_botones.add(colores.radio_buton_colores);
        colores.grupo_botones.add(colores.radio_buton_letras);

    }

    private void Estados_Panel_Letras(boolean estado) {

        colores.txt_titulo.setEditable(estado);
        colores.txt_inicio.setEditable(estado);
        colores.txt_tienda.setEditable(estado);
        colores.txt_configuracion.setEditable(estado);
        colores.txt_estadisticas.setEditable(estado);

        colores.btn_restablecer_letras.setEnabled(estado);
        colores.btn_guardar_cambios.setEnabled(estado);
        colores.btn_cancelar_letras.setEnabled(estado);

    }

    private void Estados_Panel_Colores(boolean estado) {

        colores.combo_item_padre.setEnabled(estado);
        colores.combo_item_hijos.setEnabled(estado);
        colores.combo_fondo.setEnabled(estado);
        colores.combo_barra.setEnabled(estado);

        colores.btn_restablecer_color.setEnabled(estado);
        colores.btn_apli_color.setEnabled(estado);
        colores.btn_cancelar.setEnabled(estado);

    }

    private void Asignar_Letra_Color() {

        colores.label_titulo.setFont(letras_botones);
        colores.jLabel2.setFont(letras_label);
        colores.jLabel3.setFont(letras_label);
        colores.jLabel4.setFont(letras_label);
        colores.jLabel5.setFont(letras_label);
        colores.jLabel6.setFont(letras_label);
        colores.jLabel7.setFont(letras_label);
        colores.jLabel8.setFont(letras_label);
        colores.jLabel9.setFont(letras_label);
        colores.fondo.setFont(letras_label);
        ////////////////////////////////////////////////////////////////////////////////////////////
        colores.txt_titulo.setFont(letra_txt);
        colores.txt_tienda.setFont(letra_txt);
        colores.txt_inicio.setFont(letra_txt);
        colores.txt_configuracion.setFont(letra_txt);
        colores.txt_estadisticas.setFont(letra_txt);
        ////////////////////////////////////////////////////////////////////////////////////////////
        colores.btn_apli_color.setFont(letras_label);
        colores.btn_cancelar.setFont(letras_label);
        colores.btn_cancelar_letras.setFont(letras_label);
        colores.btn_guardar_cambios.setFont(letras_label);
        colores.btn_restablecer_color.setFont(letras_label);
        colores.btn_restablecer_letras.setFont(letras_label);
        ////////////////////////////////////////////////////////////////////////////////////////////

        colores.combo_item_padre.setFont(letra_txt);
        colores.combo_item_hijos.setFont(letra_txt);
        colores.combo_fondo.setFont(letra_txt);
        colores.combo_barra.setFont(letra_txt);

        //////////////////////////////////////////////////////////////////////////////////////////////
        colores.radio_buton_letras.setFont(letras_label);
        colores.radio_buton_colores.setFont(letras_label);
        /////////////////////////////////////////////////////////////////////////////////////////////////
        colores.txt_titulo.setHorizontalAlignment(0);
        colores.txt_tienda.setHorizontalAlignment(0);
        colores.txt_inicio.setHorizontalAlignment(0);
        colores.txt_configuracion.setHorizontalAlignment(0);
        colores.txt_estadisticas.setHorizontalAlignment(0);
        /////////////////////////////////////////////////////////////////////////////////////////////////
        colores.label_titulo.setForeground(color_botones);
        colores.radio_buton_letras.setForeground(color_botones);
        colores.radio_buton_colores.setForeground(color_botones);

    }

    private void Asignar_Cursor() {

        colores.btn_apli_color.setCursor(cursor_mano);
        colores.btn_cancelar.setCursor(cursor_mano);
        colores.btn_cancelar_letras.setCursor(cursor_mano);
        colores.btn_guardar_cambios.setCursor(cursor_mano);
        colores.btn_restablecer_color.setCursor(cursor_mano);
        colores.btn_restablecer_letras.setCursor(cursor_mano);

    }

    private void Evento_Ventana() {
        WindowListener evento = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                Cargar_Nombre_Activado();

            }

        };
        colores.addWindowListener(evento);

    }

    private void Guadar_Cambios() {

        String nombre_titulo = colores.txt_titulo.getText().trim();
        String nombre_inicio = colores.txt_inicio.getText().trim();
        String nombre_tienda = colores.txt_tienda.getText().trim();
        String nombre_configuracion = colores.txt_configuracion.getText().trim();
        String nombre_estadisticas = colores.txt_estadisticas.getText().trim();

        if (!nombre_titulo.isEmpty() && !nombre_inicio.isEmpty() && !nombre_tienda.isEmpty()
                && !nombre_configuracion.isEmpty() && !nombre_estadisticas.isEmpty()) {

            int respuesta = showOptionDialog(colores, "¿Seguro desea  Conservar Cambios", "Sistema de Ventas", 0, 0, icono_pregunta, opciones, opciones[0]);

            if (respuesta == 0) {
                modelo_nuevo.setCedula(nombre_titulo);
                modelo_nuevo.setNombre_proveedor(nombre_tienda);
                modelo_nuevo.setEmpresa(nombre_inicio);
                modelo_nuevo.setDireccion(nombre_configuracion);
                modelo_nuevo.setProvincia(nombre_estadisticas);
                modelo_nuevo.setEstado_cuenta("ACTIVO");
                if (crud_nuevo.Actualizar_Sistema(modelo_nuevo, 1)) {
                    menu_principal.setTitle(nombre_titulo);
                    menu_principal.item_Inicio.setText(nombre_inicio);
                    menu_principal.item_tienda.setText(nombre_tienda);
                    menu_principal.item_configuracion.setText(nombre_configuracion);
                    menu_principal.item_menu_estadisticas.setText(nombre_estadisticas);
                    showMessageDialog(colores, "Datos Actualizados Correctamente", "Sistema de Ventas", 0, icono_bien);
                    colores.dispose();

                } else {
                    showMessageDialog(colores, "Surguio un error , intentelo mas tarde ");
                }
            }

        } else {
            showMessageDialog(colores, "Tienes campos Vacios", "Sistema de Ventas", 0, icono_prod_vacio);
        }

    }

    private void Poner_Nombre_Letras() {

        if (crud_nuevo.Traer_Datos_Sistema(modelo_nuevo)) {
            menu_principal.setTitle(modelo_nuevo.getCedula());
            menu_principal.item_Inicio.setText(modelo_nuevo.getEmpresa());
            menu_principal.item_tienda.setText(modelo_nuevo.getNombre_proveedor());
            menu_principal.item_configuracion.setText(modelo_nuevo.getDireccion());
            menu_principal.item_menu_estadisticas.setText(modelo_nuevo.getProvincia());
        }

    }

    private void Poner_Inicio() {
        String nombre_titulo = menu_principal.getTitle();
        String nombre_inicio = menu_principal.item_Inicio.getText();
        String nombre_tienda = menu_principal.item_tienda.getText();
        String nombre_configuracion = menu_principal.item_configuracion.getText();
        String nombre_estadisticas = menu_principal.item_menu_estadisticas.getText();

        colores.txt_titulo.setText(nombre_titulo);
        colores.txt_inicio.setText(nombre_inicio);
        colores.txt_tienda.setText(nombre_tienda);
        colores.txt_configuracion.setText(nombre_configuracion);
        colores.txt_estadisticas.setText(nombre_estadisticas);

    }

    private void Btn_Restablecer() {

        int respuesta = showOptionDialog(colores, "¿Restablecer Datos", "Sistema de Ventas", 0, 0, icono_pregunta, opciones, opciones[0]);

        if (respuesta == 0) {
            modelo_nuevo.setEstado_cuenta("DESACTIVADO");

            if (crud_nuevo.Actualizar_Sistema(modelo_nuevo, 2)) {
                Poner_Nombre_Letras();
                showMessageDialog(colores, "Datos Restablecidos con exito", "Sistema de Ventas", 0, icono_bien);

                colores.dispose();
            } else {
                showMessageDialog(colores, "Surguio un problema al restablecer , intentalo mas tarde", "Sistema de Ventas", 0, icono_prod_vacio);

            }
        }

    }

    private void Cargar_Colores() {

        modelo_nuevo.setCombo_color_item_padre(colores.combo_item_padre);
        modelo_nuevo.setCombo_color_item_hijo(colores.combo_item_hijos);
        modelo_nuevo.setCombo_color_fondo(colores.combo_fondo);
        modelo_nuevo.setCombo_color_barra(colores.combo_barra);

        if (!crud_nuevo.Cargar_Combo_Colores(modelo_nuevo)) {
            showMessageDialog(colores, "Surgio un problema ene l formulario Sistema", "Sistema de Ventas", 0, icono_prod_vacio);
        }
    }

    private void Combo_Item_Padre() {

        String nombre_color = colores.combo_item_padre.getSelectedItem().toString();
        modelo_nuevo.setNombre_color(nombre_color);

        if (crud_nuevo.Seleccionar_Color(modelo_nuevo)) {
            color = new Color(modelo_nuevo.getRojo(), modelo_nuevo.getVerde(), modelo_nuevo.getAzul());

            menu_principal.item_Inicio.setForeground(color);
            menu_principal.item_tienda.setForeground(color);
            menu_principal.item_configuracion.setForeground(color);
            menu_principal.item_menu_estadisticas.setForeground(color);
        } else {
            showMessageDialog(colores, "No se puedo crear el color", "Sistema de Ventas", 0, icono_prod_vacio);
        }

    }

    private void Combo_Item_Hijos() {

        String nombre_color = colores.combo_item_hijos.getSelectedItem().toString();
        modelo_nuevo.setNombre_color(nombre_color);

        if (crud_nuevo.Seleccionar_Color(modelo_nuevo)) {
            color = new Color(modelo_nuevo.getRojo(), modelo_nuevo.getVerde(), modelo_nuevo.getAzul());
            menu_principal.item_sesion.setForeground(color);
            menu_principal.item_registrar.setForeground(color);

            menu_principal.item_registro_de_ventas.setForeground(color);
            menu_principal.item_compras.setForeground(color);
            menu_principal.item_cuentas_usuarios.setForeground(color);
            menu_principal.item_vender.setForeground(color);
            menu_principal.item_cerrar_sesion.setForeground(color);
            menu_principal.item_conf_proveedores.setForeground(color);
            menu_principal.item_configu_cuenta.setForeground(color);

            menu_principal.item_clientes.setForeground(color);
            menu_principal.item_estadisticas.setForeground(color);
            menu_principal.item_sistema.setForeground(color);

        } else {
            showMessageDialog(colores, "No se puedo crear el color", "Sistema de Ventas", 0, icono_prod_vacio);
        }

    }

    private void Color_Barra() {
        String nombre_color = colores.combo_barra.getSelectedItem().toString();
        modelo_nuevo.setNombre_color(nombre_color);

        if (crud_nuevo.Seleccionar_Color(modelo_nuevo)) {
            color = new Color(modelo_nuevo.getRojo(), modelo_nuevo.getVerde(), modelo_nuevo.getAzul());

            menu_principal.barra_menu.setBackground(color);
        } else {
            showMessageDialog(colores, "No se puedo crear el color", "Sistema de Ventas", 0, icono_prod_vacio);
        }

    }

    private void Color_Por_Defecto(String Color_e) {
        modelo_nuevo.setNombre_color(Color_e);
        if (crud_nuevo.Seleccionar_Color(modelo_nuevo)) {
            color = new Color(modelo_nuevo.getRojo(), modelo_nuevo.getVerde(), modelo_nuevo.getAzul());
            menu_principal.getContentPane().setBackground(color);

            ///////////////////////////////////////////////////////////////
            menu_principal.item_Inicio.setForeground(color);
            menu_principal.item_tienda.setForeground(color);
            menu_principal.item_configuracion.setForeground(color);
            menu_principal.item_menu_estadisticas.setForeground(color);
            /////////////////////////////////////////////////////
            menu_principal.item_sesion.setForeground(color);
            menu_principal.item_registrar.setForeground(color);

            menu_principal.item_registro_de_ventas.setForeground(color);
            menu_principal.item_compras.setForeground(color);
            menu_principal.item_cuentas_usuarios.setForeground(color);
            menu_principal.item_vender.setForeground(color);
            menu_principal.item_cerrar_sesion.setForeground(color);
            menu_principal.item_conf_proveedores.setForeground(color);
            menu_principal.item_configu_cuenta.setForeground(color);

            menu_principal.item_clientes.setForeground(color);
            menu_principal.item_estadisticas.setForeground(color);
            menu_principal.item_sistema.setForeground(color);
            menu_principal.barra_menu.setBackground(Color.PINK);

            if (crud_nuevo.Aplicar_Cambios_Color(modelo_nuevo, false)) {//actualizar el estado de la tabla funciones
                //cuando se restablece , el ID_DUNCIONES=1 ES ACTIVADO y el ID_FUNCIONES =2 ES DESACTIVADO

            }

        }
    }

    private void Combo_Fondo() {
        String nombre_color = colores.combo_fondo.getSelectedItem().toString();
        modelo_nuevo.setNombre_color(nombre_color);

        if (crud_nuevo.Seleccionar_Color(modelo_nuevo)) {
            color = new Color(modelo_nuevo.getRojo(), modelo_nuevo.getVerde(), modelo_nuevo.getAzul());
            menu_principal.getContentPane().setBackground(color);
        }
    }

    private void Aplicar_Cambio() {

        int respuesta = showOptionDialog(colores, "¿Conservar Cambios?", "Sistema de Ventas", 0, 0, icono_pregunta, opciones, opciones[0]);

        if (respuesta == 0) {
            String nombre_color_items_padre = colores.combo_item_padre.getSelectedItem().toString();
            String nombre_color_items_hijos = colores.combo_item_hijos.getSelectedItem().toString();
            String nombre_color_fondo = colores.combo_fondo.getSelectedItem().toString();
            String nombre_color_barra_menu = colores.combo_barra.getSelectedItem().toString();

            modelo_nuevo.setNombre_color_items_padre(nombre_color_items_padre);
            modelo_nuevo.setNombre_color_items_hijos(nombre_color_items_hijos);
            modelo_nuevo.setNombre_color_fondo(nombre_color_fondo);
            modelo_nuevo.setNombre_color_barra_menul(nombre_color_barra_menu);
            modelo_nuevo.setEstado_cuenta("ACTIVADO");

            if (crud_nuevo.Aplicar_Cambios_Color(modelo_nuevo, true)) {
                showMessageDialog(colores, "Cambios Aplicados con exito", "Sistema de Ventas", 0, icono_bien);

            } else {
                showMessageDialog(colores, "Error al aplicar los cambios", "Sistemas de Ventas", 0, icono_prod_vacio);
            }
        }

    }

    private void Color_Elegido(String nombre_color_items_padre, String nombre_color_items_hijos, String nombre_color_fondo, String nombre_color_barra_menu) {

        /*
        COLOR ITEMS PADRES
         */
        modelo_nuevo.setNombre_color(nombre_color_items_padre);
        if (crud_nuevo.Seleccionar_Color(modelo_nuevo)) {
            color = new Color(modelo_nuevo.getRojo(), modelo_nuevo.getVerde(), modelo_nuevo.getAzul());

            menu_principal.item_Inicio.setForeground(color);
            menu_principal.item_tienda.setForeground(color);
            menu_principal.item_configuracion.setForeground(color);
            menu_principal.item_menu_estadisticas.setForeground(color);

        }
        /*
        COLOR ITEMS HIJOS
         */

        modelo_nuevo.setNombre_color(nombre_color_items_hijos);
        if (crud_nuevo.Seleccionar_Color(modelo_nuevo)) {
            color = new Color(modelo_nuevo.getRojo(), modelo_nuevo.getVerde(), modelo_nuevo.getAzul());

            ///////////////////////////////////////////////////////////////
            menu_principal.item_sesion.setForeground(color);
            menu_principal.item_registrar.setForeground(color);

            menu_principal.item_registro_de_ventas.setForeground(color);
            menu_principal.item_compras.setForeground(color);
            menu_principal.item_cuentas_usuarios.setForeground(color);
            menu_principal.item_vender.setForeground(color);
            menu_principal.item_cerrar_sesion.setForeground(color);
            menu_principal.item_conf_proveedores.setForeground(color);
            menu_principal.item_configu_cuenta.setForeground(color);

            menu_principal.item_clientes.setForeground(color);
            menu_principal.item_estadisticas.setForeground(color);
            menu_principal.item_sistema.setForeground(color);
        }

        /*
        COLOR FONDO
         */
        modelo_nuevo.setNombre_color(nombre_color_fondo);
        if (crud_nuevo.Seleccionar_Color(modelo_nuevo)) {
            color = new Color(modelo_nuevo.getRojo(), modelo_nuevo.getVerde(), modelo_nuevo.getAzul());
            menu_principal.getContentPane().setBackground(color);
        }

        /*
        COLOR BARRA MENU
         */
        modelo_nuevo.setNombre_color(nombre_color_barra_menu);
        if (crud_nuevo.Seleccionar_Color(modelo_nuevo)) {
            color = new Color(modelo_nuevo.getRojo(), modelo_nuevo.getVerde(), modelo_nuevo.getAzul());
            menu_principal.barra_menu.setBackground(color);
        }

    }

    private void Cargar_Nombre_Activado() {

        if (crud_nuevo.Retornar_Nombre_COlor_Funciones(modelo_nuevo)) {
            String nombre_color_items_padre = modelo_nuevo.getNombre_color_items_padre();
            String nombre_color_items_hijos = modelo_nuevo.getNombre_color_items_hijos();
            String nombre_color_fondo = modelo_nuevo.getNombre_color_fondo();
            String nombre_color_barra_menu = modelo_nuevo.getNombre_color_barra_menul();
            String id_funciones = String.valueOf(modelo_nuevo.getId_funciones());

            if (id_funciones.equals("1")) { //color por defecto m1 es el id_fiunciones de la fila donde estan los colores por defecto
                Color_Por_Defecto("Negro");
            } else {//color elegido
                Color_Elegido(nombre_color_items_padre, nombre_color_items_hijos, nombre_color_fondo, nombre_color_barra_menu);
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == colores.btn_guardar_cambios) {
            Guadar_Cambios();
        }
        if (e.getSource() == colores.btn_restablecer_letras) {
            Btn_Restablecer();
        }

        if (e.getSource() == colores.combo_item_padre) {
            Combo_Item_Padre();

        }

        if (e.getSource() == colores.combo_item_hijos) {
            Combo_Item_Hijos();

        }
        if (e.getSource() == colores.combo_fondo) {
            Combo_Fondo();

        }
        if (e.getSource() == colores.combo_barra) {
            Color_Barra();
        }
        if (e.getSource() == colores.btn_apli_color) {
            Aplicar_Cambio();
        }
        if (e.getSource() == colores.btn_restablecer_color) {

            int respuesta = showOptionDialog(colores, "¿Establecer Colores Por Defecto?", "Sistema de Ventas", 0, 0, icono_pregunta, opciones, opciones[0]);

            if (respuesta == 0) {
                Color_Por_Defecto("Negro");
            }

        }

        if (e.getSource() == colores.radio_buton_letras) {
            Estados_Panel_Letras(true);
            Estados_Panel_Colores(false);
        }
        if (e.getSource() == colores.radio_buton_colores) {
            Estados_Panel_Letras(false);
            Estados_Panel_Colores(true);
        }

        if (e.getSource() == colores.btn_cancelar) {
            Cargar_Nombre_Activado();
            //colores.dispose();
        }

        if (e.getSource() == colores.btn_cancelar_letras) {
            Poner_Inicio();

        }

    }
    private final String opciones[];
    private Color color = null;
    private final Font letras_botones;
    private final Font letras_label;
    private final Color color_botones;
    private final Font letra_txt;
    private final Cursor cursor_mano;
    private final ImageIcon icono_prod_vacio;
    private final ImageIcon icono_bien;
    private final ImageIcon icono_pregunta;

}
