package controlador;

import java.awt.Color;
import java.awt.Font;
import vista.Menu_Principal;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import mensajes.Joption;
import modelo.Crud_Primero;
import modelo.Fuentes_Y_Mas;
import modelo.Iconos;
import modelo.Iconos_Menu_Principal;
import modelo.Modelo_Colores;
import modelo.Modelo_Sistema;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Modelo_Nuevo;

public class Controlador_Menu_Principal implements ActionListener, MouseListener {
    
    private Controlador_Sesion controlador_sesion;
    private Menu_Principal menu_principal;
    private Controlador_Registrar controlador_registrar;
    private Controlador_Ingresar_Vehiculo controlador_ingresar_vehiculo;
    private Controlador_Retirar_Vehiculo controlador_retirar_vehiculo;
    private Controlador_Listar_Ingresos controlador_listar_ingresos;
    private Controlador_Confi_Vehiculos controlador_confi_vehiculos;
    private Controlador_Listar_Salidas controlador_listar_salidas;
    private Controlador_Editar_Usuario controlador_editar_usuario;
    private Controlador_Admin_Usuarios controlador_admin_usuarios;
    private Controlador_Apariencia controlador_apariencia;
    private Controlador_Reportes controlador_reportes;
    private Controlador_Base_Datos controlador_base_datos;
    private Controlador_Estadisticas controlador_estadisticas;
    private Controlador_Sms_Pregunta controlador_sms_pregunta;
    
    private Controlador_Sistema controlador_sistema;
    private Modelo_Colores modelo_colores;
    private Modelo_Sistema modelo_sistema;
    private Crud_Primero crud_primero;
    private Joption mensajes;
    private Iconos iconos;
    private Modelo_Nuevo modelo_Nuevo;
    private Iconos_Menu_Principal iconos_menu_principal;
    private Fuentes_Y_Mas fuentes_Y_mas;
    
    public Controlador_Menu_Principal() {
        
    }
    
    public void setControlador_Sistema(Controlador_Sistema controlador_sistema) {
        this.controlador_sistema = controlador_sistema;
        
    }
    
    public void setControlador_Reportes(Controlador_Reportes controlador_reportes) {
        this.controlador_reportes = controlador_reportes;
    }
    
    public void setControlador_Base_Datos(Controlador_Base_Datos controlador_base_datos) {
        
        this.controlador_base_datos = controlador_base_datos;
    }
    
    public void setControlador_Estadisticas(Controlador_Estadisticas controlador_estadisticas) {
        this.controlador_estadisticas = controlador_estadisticas;
    }
    
    public void setMenu_Principal(Menu_Principal menu_principal) {
        
        this.menu_principal = menu_principal;
    }
    
    public void setControlador_Sesion(Controlador_Sesion controlador_sesion) {
        this.controlador_sesion = controlador_sesion;
    }
    
    public void setControlador_Registrar(Controlador_Registrar controlador_registrar) {
        this.controlador_registrar = controlador_registrar;
    }
    
    public void setControlador_Ingresar_Vehiculo(Controlador_Ingresar_Vehiculo controlador_ingresar_vehiculo) {
        this.controlador_ingresar_vehiculo = controlador_ingresar_vehiculo;
    }
    
    public void setControlador_Listar_Ingresos(Controlador_Listar_Ingresos controlador_Listar_Ingresos) {
        this.controlador_listar_ingresos = controlador_Listar_Ingresos;
    }
    
    public void setControlador_Configurar_Vehicu(Controlador_Confi_Vehiculos controlador_confi_vehiculos) {
        this.controlador_confi_vehiculos = controlador_confi_vehiculos;
    }
    
    public void setControlador_Listar_Salidas(Controlador_Listar_Salidas controlador_listar_salidas) {
        this.controlador_listar_salidas = controlador_listar_salidas;
    }
    
    public void setControlador_Editar_Usuario(Controlador_Editar_Usuario controlador_editar_usuario) {
        this.controlador_editar_usuario = controlador_editar_usuario;
    }
    
    public void setControlador_Admin_Usuario(Controlador_Admin_Usuarios controlador_admin_usuarios) {
        this.controlador_admin_usuarios = controlador_admin_usuarios;
    }
    
    public void setControlador_Apariencia(Controlador_Apariencia controlador_apariencia) {
        this.controlador_apariencia = controlador_apariencia;
    }
    
    public void setModelo_Colores(Modelo_Colores modelo_colores) {
        this.modelo_colores = modelo_colores;
    }
    
    public void setCrud_Primero(Crud_Primero crud_primero) {
        this.crud_primero = crud_primero;
    }
    
    public void setModelo_Sistema(Modelo_Sistema modelo_sistema) {
        
        this.modelo_sistema = modelo_sistema;
    }
    
    public void setControlador_Retirar_Vehiculo(Controlador_Retirar_Vehiculo controlador_retirar_vehiculo) {
        this.controlador_retirar_vehiculo = controlador_retirar_vehiculo;
    }
    
    public void setIconos_Menu_Principal(Iconos_Menu_Principal iconos_menu_principal) {
        this.iconos_menu_principal = iconos_menu_principal;
    }
    
    public void setMensaje(Joption mensajes_2) {
        this.mensajes = mensajes_2;
    }
    
    public void setIconos(Iconos iconos) {
        this.iconos = iconos;
    }
    
    public void setFuentes_Y_Mas(Fuentes_Y_Mas fuentes_Y_Mas) {
        this.fuentes_Y_mas = fuentes_Y_Mas;
    }
    
    public void setModelo_Nuevo(Modelo_Nuevo modelo_nuevo) {
        this.modelo_Nuevo = modelo_nuevo;
    }
    
    public void setControlador_Sms_Pregunta(Controlador_Sms_Pregunta controlador_Sms_Pregunta) {
        this.controlador_sms_pregunta = controlador_Sms_Pregunta;
    }
    
    public void Estado_Constructor() {
        
        menu_principal.setTitle(fuentes_Y_mas.getTitulo());
        
        Inicializar_Variables_Color_Funciones();
        
        addAtajos();
        Agregar_Iconos_Menus();
        Agregar_Iconos_Items();
        Asignar_Cursor_Mano();
        Poner_Tooltik();
        
        Poner_Colores(true, true, true);
        Consulta_Nombres_Menus();
        Evento_Ventana();

        //////////////////////////////////////////////////////////////
        this.cedula = "";
        this.usuario = "";
        this.nombre = "";
        this.contrasena = "";
        this.id_usuario = "";
        this.tipo_cuenta = "";

        // this.menu_principal.jToolBar1.setVisible(false);
        //##################################################################################################
        menu_principal.item_sesion.addActionListener(this);
        menu_principal.item_registrar.addActionListener(this);
        menu_principal.item_confi_vehiculos.addActionListener(this);
        menu_principal.item_Listar_Ingresos.addActionListener(this);
        menu_principal.item_Listar_Salidas.addActionListener(this);
        menu_principal.item_admin_Usuarios.addActionListener(this);
        menu_principal.item_apariencia.addActionListener(this);
        menu_principal.item_cuenta.addActionListener(this);
        menu_principal.item_cerrar_sesion.addActionListener(this);
        menu_principal.item_regis_V.addActionListener(this);
        menu_principal.item_sistema.addActionListener(this);
        menu_principal.item_retirarV.addActionListener(this);
        menu_principal.item_reportes.addActionListener(this);
        menu_principal.item_back_base.addActionListener(this);
        menu_principal.item_estadisticas.addActionListener(this);
        
        menu_principal.btn_ingresarV.addActionListener(this);
        menu_principal.btn_editar_Usuario.addActionListener(this);
        menu_principal.btn_cerrar_sesion.addActionListener(this);
        menu_principal.btn_registrar.addActionListener(this);
        menu_principal.btn_retirar_V.addActionListener(this);
        menu_principal.btn_listar_Ingresos.addActionListener(this);
        menu_principal.btn_listar_salidas.addActionListener(this);
        menu_principal.btn_configur_V.addActionListener(this);
        menu_principal.btn_administrar_Usua.addActionListener(this);
        menu_principal.btn_apariencia.addActionListener(this);
        menu_principal.btn_confi_Sistema.addActionListener(this);
        menu_principal.btn_respaldos.addActionListener(this);
        menu_principal.btn_reportes.addActionListener(this);
        menu_principal.btn_estadistica.addActionListener(this);
        menu_principal.btn_salir.addActionListener(this);
        
    }
    
    public void Iniciar_Componentes() {
        
        menu_principal.setExtendedState(6);
        menu_principal.setVisible(true);
    }
    
    private void Agregar_Iconos_Menus() {
        
        menu_principal.btn_cerrar_sesion.setIcon(iconos_menu_principal.getIcono_cerrarSesion());
        menu_principal.btn_iniciar_sesion.setIcon(iconos_menu_principal.getIcono_iniciarSesion());
        menu_principal.btn_registrar.setIcon(iconos_menu_principal.getIcono_registrar());
        menu_principal.btn_ingresarV.setIcon(iconos_menu_principal.getIcono_ingresarVehiculo());
        menu_principal.btn_retirar_V.setIcon(iconos_menu_principal.getIcono_retirarVehiculo());
        menu_principal.btn_listar_Ingresos.setIcon(iconos_menu_principal.getIcono_listarIngresos());
        menu_principal.btn_listar_salidas.setIcon(iconos_menu_principal.getIcono_listarSalidas());
        
        menu_principal.btn_configur_V.setIcon(iconos_menu_principal.getIcono_cofiguVehiculos());
        menu_principal.btn_editar_Usuario.setIcon(iconos_menu_principal.getIcono_editarCuenta());
        menu_principal.btn_administrar_Usua.setIcon(iconos_menu_principal.getIcono_adminUsuarios());
        menu_principal.btn_apariencia.setIcon(iconos_menu_principal.getIcono_apariencia());
        menu_principal.btn_confi_Sistema.setIcon(iconos_menu_principal.getIcono_sistema());
        menu_principal.btn_respaldos.setIcon(iconos_menu_principal.getIcono_respaldos());
        menu_principal.btn_reportes.setIcon(iconos_menu_principal.getIcono_reportes());
        menu_principal.btn_estadistica.setIcon(iconos_menu_principal.getIcono_estadisticas());
        menu_principal.btn_salir.setIcon(iconos_menu_principal.getIcono_salir());

        //AGREGAR ICONO AL PANEL PRINCIPAL
        menu_principal.lb_icono.setIcon(iconos_menu_principal.getIcono_titulo());

        ///BARRA DE ESTADO
        menu_principal.btn_calendario.setIcon(iconos_menu_principal.getIcono_calendario());
        menu_principal.btn_name_usuario.setIcon(iconos_menu_principal.getIcono_editarCuenta());
        menu_principal.btn_num_vehi_ingresados.setIcon(iconos_menu_principal.getIcono_ingresarVehiculo());
        
        menu_principal.btn_calendario.setText(modelo_Nuevo.getFecha_Ingresar_Actual(false));
        
    }
    
    public void Poner_Cantidad_Vehiculos(String numero) {
        
        menu_principal.btn_num_vehi_ingresados.setText("Vehículos: " + numero);
    }
    
    private void Agregar_Iconos_Items() {
        
        menu_principal.item_cerrar_sesion.setIcon(iconos_menu_principal.getIcono_cerrarSesion());
        menu_principal.item_sesion.setIcon(iconos_menu_principal.getIcono_iniciarSesion());
        menu_principal.item_registrar.setIcon(iconos_menu_principal.getIcono_registrar());
        menu_principal.item_regis_V.setIcon(iconos_menu_principal.getIcono_ingresarVehiculo());
        menu_principal.item_retirarV.setIcon(iconos_menu_principal.getIcono_retirarVehiculo());
        menu_principal.item_Listar_Ingresos.setIcon(iconos_menu_principal.getIcono_listarIngresos());
        menu_principal.item_Listar_Salidas.setIcon(iconos_menu_principal.getIcono_listarSalidas());
        
        menu_principal.item_confi_vehiculos.setIcon(iconos_menu_principal.getIcono_cofiguVehiculos());
        menu_principal.item_cuenta.setIcon(iconos_menu_principal.getIcono_editarCuenta());
        menu_principal.item_admin_Usuarios.setIcon(iconos_menu_principal.getIcono_adminUsuarios());
        menu_principal.item_apariencia.setIcon(iconos_menu_principal.getIcono_apariencia());
        menu_principal.item_sistema.setIcon(iconos_menu_principal.getIcono_sistema());
        menu_principal.item_back_base.setIcon(iconos_menu_principal.getIcono_respaldos());
        menu_principal.item_reportes.setIcon(iconos_menu_principal.getIcono_reportes());
        menu_principal.item_estadisticas.setIcon(iconos_menu_principal.getIcono_estadisticas());
        
    }
    
    private void Asignar_Cursor_Mano() {
        
        menu_principal.btn_cerrar_sesion.setCursor(fuentes_Y_mas.getCursor());
        menu_principal.btn_iniciar_sesion.setCursor(fuentes_Y_mas.getCursor());
        menu_principal.btn_registrar.setCursor(fuentes_Y_mas.getCursor());
        menu_principal.btn_ingresarV.setCursor(fuentes_Y_mas.getCursor());
        menu_principal.btn_retirar_V.setCursor(fuentes_Y_mas.getCursor());
        menu_principal.btn_listar_Ingresos.setCursor(fuentes_Y_mas.getCursor());
        menu_principal.btn_listar_salidas.setCursor(fuentes_Y_mas.getCursor());
        
        menu_principal.btn_configur_V.setCursor(fuentes_Y_mas.getCursor());
        menu_principal.btn_editar_Usuario.setCursor(fuentes_Y_mas.getCursor());
        menu_principal.btn_administrar_Usua.setCursor(fuentes_Y_mas.getCursor());
        menu_principal.btn_apariencia.setCursor(fuentes_Y_mas.getCursor());
        menu_principal.btn_confi_Sistema.setCursor(fuentes_Y_mas.getCursor());
        menu_principal.btn_respaldos.setCursor(fuentes_Y_mas.getCursor());
        menu_principal.btn_reportes.setCursor(fuentes_Y_mas.getCursor());
        menu_principal.btn_estadistica.setCursor(fuentes_Y_mas.getCursor());
        menu_principal.btn_salir.setCursor(fuentes_Y_mas.getCursor());
        
    }
    
    public void Datos_Usuarios(String id_usuario, String cedula, String nombre, String usuario, String contrasena, String tipo_cuenta) {
        
        this.cedula = cedula;
        this.usuario = usuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.id_usuario = id_usuario;
        this.tipo_cuenta = tipo_cuenta;
        menu_principal.btn_name_usuario.setText("Usuario: " + nombre);
        
    }
    
    public void Enabled_Botones(boolean estado) {
        
        menu_principal.btn_iniciar_sesion.setEnabled(false);
        menu_principal.item_sesion.setEnabled(false);
        
        menu_principal.btn_registrar.setEnabled(estado);
        menu_principal.item_registrar.setEnabled(estado);
        menu_principal.btn_configur_V.setEnabled(estado);
        menu_principal.btn_administrar_Usua.setEnabled(estado);
        menu_principal.btn_confi_Sistema.setEnabled(estado);
        menu_principal.btn_estadistica.setEnabled(estado);
        menu_principal.btn_listar_salidas.setEnabled(estado);
        menu_principal.item_confi_vehiculos.setEnabled(estado);
        menu_principal.item_Listar_Salidas.setEnabled(estado);
        menu_principal.item_confi_vehiculos.setEnabled(estado);
        menu_principal.item_admin_Usuarios.setEnabled(estado);
        menu_principal.item_sistema.setEnabled(estado);
        menu_principal.item_menu_Respaldos.setEnabled(estado);
        menu_principal.btn_respaldos.setEnabled(estado);
        menu_principal.btn_reportes.setEnabled(estado);
        
    }
    
    public void Inicializar_Variables_Color_Funciones() {
        
        if (crud_primero.Inicializar_Nombre_Funciones(modelo_colores)) {
            
            Asignar_Nombre_Color_Funciones(modelo_colores.getColor_txt_menu(), modelo_colores.getColor_text_submenu(),
                    modelo_colores.getColor_text_empresa(), modelo_colores.getColor_fondo_pantalla(), modelo_colores.getColor_fondo_barra_menu(),
                    modelo_colores.getColor_fondo_barra_herramientas(), modelo_colores.getColor_fondo_barra_estado(), modelo_colores.getColor_fun_barra_herramientas(),
                    modelo_colores.getColor_fun_barra_estado(), modelo_colores.getColor_borde_barra_herramientas(), modelo_colores.getColor_borde_barra_estado());
            
        }
        
    }
    
    public void Asignar_Nombre_Color_Funciones(String color_txt_menu, String color_text_submenu, String color_text_empresa, String color_fondo_pantalla,
            String color_fondo_barra_menu, String color_fondo_barra_herramientas, String color_fondo_barra_estado,
            String color_fun_barra_herramientas, String color_fun_barra_estado, String color_borde_barra_herramientas,
            String color_borde_barra_estado) {
        
        this.color_txt_menu = color_txt_menu;
        this.color_text_submenu = color_text_submenu;
        this.color_text_empresa = color_text_empresa;
        
        this.color_fondo_pantalla = color_fondo_pantalla;
        this.color_fondo_barra_menu = color_fondo_barra_menu;
        this.color_fondo_barra_herramientas = color_fondo_barra_herramientas;
        this.color_fondo_barra_estado = color_fondo_barra_estado;
        this.color_fun_barra_herramientas = color_fun_barra_herramientas;
        this.color_fun_barra_estado = color_fun_barra_estado;
        
        this.color_borde_barra_herramientas = color_borde_barra_herramientas;
        this.color_borde_barra_estado = color_borde_barra_estado;
        
    }
    
    public void Color_Texto_Menu(String nombre_color) {
        
        modelo_colores.setNombre_Color(nombre_color);
        
        crud_primero.Generar_Color(modelo_colores);
        
        Color color = modelo_colores.getColor();
        
        menu_principal.item_menu_Inicio.setForeground(color);
        menu_principal.item_menu_funciones.setForeground(color);
        menu_principal.item_menu_configuracion.setForeground(color);
        menu_principal.item_menu_Sistema.setForeground(color);
        menu_principal.item_menu_Respaldos.setForeground(color);
        
    }
    
    public void Color_texto_SubMenu(String nombre_color) {
        ///================color submenu
        modelo_colores.setNombre_Color(nombre_color);
        crud_primero.Generar_Color(modelo_colores);
        
        Color color = modelo_colores.getColor();
        
        menu_principal.item_sesion.setForeground(color);
        menu_principal.item_registrar.setForeground(color);
        menu_principal.item_cerrar_sesion.setForeground(color);
        
        menu_principal.item_regis_V.setForeground(color);
        menu_principal.item_retirarV.setForeground(color);
        menu_principal.item_Listar_Ingresos.setForeground(color);
        menu_principal.item_Listar_Salidas.setForeground(color);
        
        menu_principal.item_confi_vehiculos.setForeground(color);
        menu_principal.item_cuenta.setForeground(color);
        menu_principal.item_admin_Usuarios.setForeground(color);
        
        menu_principal.item_apariencia.setForeground(color);
        menu_principal.item_sistema.setForeground(color);
        
        menu_principal.item_reportes.setForeground(color);
        menu_principal.item_estadisticas.setForeground(color);
        
    }
    
    public void Color_texto_Titulo(String nombre_color) {
        ///=================color titulo
        modelo_colores.setNombre_Color(nombre_color);
        crud_primero.Generar_Color(modelo_colores);
        
        Color color = modelo_colores.getColor();
        menu_principal.lb_icono.setForeground(color);
    }
    
    public void Color_FondoPantalla(String nombre_color) {

        ///==================color fondos Pantalla
        modelo_colores.setNombre_Color(nombre_color);
        crud_primero.Generar_Color(modelo_colores);
        
        Color color = modelo_colores.getColor();
        menu_principal.panel_principal.setBackground(color);
        
    }
    
    public void Color_Fondo_Barra_Menu(String nombre_color) {

        ///==================color fondo barra menu
        modelo_colores.setNombre_Color(nombre_color);
        crud_primero.Generar_Color(modelo_colores);
        
        Color color = modelo_colores.getColor();
        menu_principal.barra_menu.setBackground(color);
        
    }
    
    public void Color_Fondo_Barra_Herramientas(String nombre_Color) {

        ///==================color fondo barra  herramientas
        modelo_colores.setNombre_Color(nombre_Color);
        crud_primero.Generar_Color(modelo_colores);
        
        Color color = modelo_colores.getColor();
        menu_principal.barra_herramientas.setBackground(color);
        
    }
    
    public void Color_Fondo_Barra_Estado(String nombre_color) {

        ///==================color fondo barra  estado
        modelo_colores.setNombre_Color(nombre_color);
        crud_primero.Generar_Color(modelo_colores);
        
        Color color = modelo_colores.getColor();
        menu_principal.barra_estado.setBackground(color);
    }
    
    public void Color_Botones_Funciones_Herramienras(String nombre_color) {

        ///==================color fondo botones funciones herramientas
        modelo_colores.setNombre_Color(nombre_color);
        crud_primero.Generar_Color(modelo_colores);
        
        Color color = modelo_colores.getColor();
        
        menu_principal.btn_registrar.setBackground(color);
        menu_principal.btn_iniciar_sesion.setBackground(color);
        menu_principal.btn_cerrar_sesion.setBackground(color);
        menu_principal.btn_ingresarV.setBackground(color);
        menu_principal.btn_retirar_V.setBackground(color);
        menu_principal.btn_listar_Ingresos.setBackground(color);
        menu_principal.btn_listar_salidas.setBackground(color);
        menu_principal.btn_configur_V.setBackground(color);
        menu_principal.btn_editar_Usuario.setBackground(color);
        menu_principal.btn_administrar_Usua.setBackground(color);
        menu_principal.btn_apariencia.setBackground(color);
        menu_principal.btn_confi_Sistema.setBackground(color);
        menu_principal.btn_respaldos.setBackground(color);
        menu_principal.btn_reportes.setBackground(color);
        menu_principal.btn_estadistica.setBackground(color);
        
    }
    
    public void Color_Botones_Funciones_Estado(String nombre_color) {
        modelo_colores.setNombre_Color(nombre_color);
        crud_primero.Generar_Color(modelo_colores);
        
        Color color = modelo_colores.getColor();
        
        menu_principal.btn_num_vehi_ingresados.setBackground(color);
        menu_principal.btn_calendario.setBackground(color);
        menu_principal.btn_name_usuario.setBackground(color);
        
    }
    
    public void Color_Borde_Herramientas(String nombre_color) {

        ///==================color borde barra herramientas
        modelo_colores.setNombre_Color(nombre_color);
        crud_primero.Generar_Color(modelo_colores);
        
        Color color = modelo_colores.getColor();
        LineBorder borde_herramientas = new LineBorder(color, 2);
        menu_principal.barra_herramientas.setBorder(borde_herramientas);
        
    }
    
    public void COlor_Borde_Estado(String nombre_color) {

        ///==================color borde barra estado
        modelo_colores.setNombre_Color(nombre_color);
        crud_primero.Generar_Color(modelo_colores);
        
        Color color = modelo_colores.getColor();
        LineBorder borde_estado = new LineBorder(color, 2);
        menu_principal.barra_estado.setBorder(borde_estado);
    }
    
    public void Poner_Colores(boolean texto, boolean fondos, boolean bordes) {
        
        if (texto) {
            Color_Texto_Menu(color_txt_menu);
            Color_texto_SubMenu(color_text_submenu);
            Color_texto_Titulo(color_text_empresa);
        }
        
        if (fondos) {
            Color_FondoPantalla(color_fondo_pantalla);
            Color_Fondo_Barra_Menu(color_fondo_barra_menu);
            Color_Fondo_Barra_Herramientas(color_fondo_barra_herramientas);
            Color_Fondo_Barra_Estado(color_fondo_barra_estado);
            Color_Botones_Funciones_Herramienras(color_fun_barra_herramientas);
            Color_Botones_Funciones_Estado(color_fun_barra_estado);
        }
        
        if (bordes) {
            Color_Borde_Herramientas(color_borde_barra_herramientas);
            COlor_Borde_Estado(color_borde_barra_estado);
        }
    }
    
    public void Consulta_Nombres_Menus() {
        
        if (crud_primero.Nombres_Menus_Items(modelo_sistema)) {
            
            Inicializar_Nombres_Menus(modelo_sistema.getMenu_inicio(), modelo_sistema.getMenu_funciones(),
                    modelo_sistema.getMenu_configuracion(), modelo_sistema.getMenu_sistema(),
                    modelo_sistema.getMenu_respaldos(), modelo_sistema.getTitulo(), modelo_sistema.getTipo_letra(), modelo_sistema.getEstilo_fuente(), modelo_sistema.getTamano_fuente());
            
            Poner_Texto();
        }
        
    }
    
    public void Inicializar_Nombres_Menus(String inicio, String funciones, String configuracion, String sistema,
            String reportes, String titulo, String familia_letra, int estilo, int tamano_letra) {
        
        this.inicio = inicio;
        this.funciones = funciones;
        this.configuracion = configuracion;
        this.sistema = sistema;
        this.reportes = reportes;
        this.familia_letra = familia_letra;
        this.estilo = estilo;
        this.tamano_letra = tamano_letra;
        this.titulo = titulo;
        
    }
    
    private void addAtajos() {

        //=============JMENU================================
        // ALT + 
        menu_principal.item_menu_Inicio.setMnemonic('I');
        menu_principal.item_menu_funciones.setMnemonic('F');
        menu_principal.item_menu_configuracion.setMnemonic('C');
        menu_principal.item_menu_Sistema.setMnemonic('S');
        menu_principal.item_menu_Respaldos.setMnemonic('D');

        //========JTEMENUITEMS
        /*Atajos para acceder alos JmenuItems
        Utiliza el metodo setAccelerator (KeyStroke.getKeyStroke( letra de atajo , la letra especia , ejemplo ctrol, alt etc))
        
        los parametros que van dentro son constantes, yo estoy utlizando los campos de clase de esas constantes
       
         */
        menu_principal.item_registrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
        menu_principal.item_cerrar_sesion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        
        menu_principal.item_regis_V.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
        menu_principal.item_retirarV.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
        menu_principal.item_Listar_Ingresos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
        menu_principal.item_Listar_Salidas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
        
        menu_principal.item_confi_vehiculos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        menu_principal.item_cuenta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        menu_principal.item_admin_Usuarios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK));
        
        menu_principal.item_apariencia.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        menu_principal.item_sistema.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        
        menu_principal.item_back_base.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
        menu_principal.item_reportes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
        menu_principal.item_estadisticas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        
    }
    
    private String adTooltip(String sms) {
        
        String tooltip = "<html>"
                + "\n<head>"
                + "\n  <style> "
                + "\n   p{ font-size:15px; "
                + "\n    font-family: Consolas;"
                + "\n    color:#1D8015;}"
                + "</style>"
                + "\n</head>"
                + "\n<body>"
                + "  <p>" + sms + " </p>"
                + "\n</body>"
                + "\n</html>";
        
        return tooltip;
    }
    
    private void Poner_Tooltik() {
        
        menu_principal.btn_cerrar_sesion.setToolTipText(adTooltip("Cerrar Sesión"));
        menu_principal.btn_iniciar_sesion.setToolTipText(adTooltip("Iniciar Sesión"));
        menu_principal.btn_registrar.setToolTipText(adTooltip("Nuevo Usuario"));
        menu_principal.btn_ingresarV.setToolTipText(adTooltip("Ingresar Vehículo"));
        menu_principal.btn_retirar_V.setToolTipText(adTooltip("Retirar Vehículo"));
        menu_principal.btn_listar_Ingresos.setToolTipText(adTooltip("Listar V Ingresados"));
        menu_principal.btn_listar_salidas.setToolTipText(adTooltip("Listar V Salidos"));
        
        menu_principal.btn_configur_V.setToolTipText(adTooltip("Config Vehículos"));
        menu_principal.btn_editar_Usuario.setToolTipText(adTooltip("Editar Cuenta"));
        menu_principal.btn_administrar_Usua.setToolTipText(adTooltip("Admin Usuarios"));
        menu_principal.btn_apariencia.setToolTipText(adTooltip("Apariencia"));
        menu_principal.btn_confi_Sistema.setToolTipText(adTooltip("Config Sistema"));
        menu_principal.btn_respaldos.setToolTipText(adTooltip("Respaldos"));
        menu_principal.btn_reportes.setToolTipText(adTooltip("Reportes"));
        menu_principal.btn_estadistica.setToolTipText(adTooltip("Estadísticas"));
        menu_principal.btn_salir.setToolTipText(adTooltip("Salir"));
        
    }
    
    public void Poner_Texto() {
        
        menu_principal.item_menu_Inicio.setText(inicio);
        menu_principal.item_menu_funciones.setText(funciones);
        menu_principal.item_menu_configuracion.setText(configuracion);
        menu_principal.item_menu_Sistema.setText(sistema);
        menu_principal.item_menu_Respaldos.setText(reportes);
        // menu_principal.lb_titulo.setText(titulo);
        menu_principal.lb_icono.setText(titulo);
        
        Font letra = new Font(familia_letra, estilo, tamano_letra);
        
        menu_principal.item_menu_Inicio.setFont(letra);
        menu_principal.item_menu_funciones.setFont(letra);
        menu_principal.item_menu_configuracion.setFont(letra);
        menu_principal.item_menu_Sistema.setFont(letra);
        menu_principal.item_menu_Respaldos.setFont(letra);
        
    }
    
    private void Salir_X() {
        
        controlador_sms_pregunta.Iniciar_Componenentes("¿Seguro desea salir del programa? ", "Salir", "Olvidar", iconos.getIcono_eliminar_pregunta(), iconos.getIcono_continuar());
        if (controlador_sms_pregunta.getAccion() == 0) {
            
            System.exit(0);
            
        }
        
    }
    
    private void Evento_Ventana() {
        
        WindowAdapter evento = new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
                
                Salir_X();
                
            }
            
        };
        menu_principal.addWindowListener(evento);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object evento = e.getSource();
        
        if (evento == menu_principal.item_sesion
                || evento == menu_principal.btn_iniciar_sesion) {
            controlador_sesion.Iniciar_Componentes();
            
        }
        if (evento == menu_principal.item_registrar
                || evento == menu_principal.btn_registrar) {
            controlador_registrar.Iniciar_Componentes();
            
        }
        
        if (evento == menu_principal.item_confi_vehiculos
                || evento == menu_principal.btn_configur_V) {
            controlador_confi_vehiculos.Iniciar_Componentes();
            
        }

        ////////////////////////////////////////////////////////////////////////7
        if (evento == menu_principal.btn_ingresarV
                || evento == menu_principal.item_regis_V) {
            controlador_ingresar_vehiculo.Iniciar_Componentes();
            
        }
        
        if (evento == menu_principal.btn_editar_Usuario
                || evento == menu_principal.item_cuenta) {
            
            controlador_editar_usuario.Datos_Usuarios(id_usuario, cedula, nombre, usuario, contrasena, tipo_cuenta);
            controlador_editar_usuario.Iniciar_Componentes();
            
        }
        
        if (evento == menu_principal.btn_cerrar_sesion
                || evento == menu_principal.item_cerrar_sesion) {
            
            menu_principal.dispose();
            controlador_sesion.Iniciar_Componentes();
            
        }
        
        if (evento == menu_principal.item_retirarV
                || evento == menu_principal.btn_retirar_V) {
            
            controlador_retirar_vehiculo.Iniciar_Componentes(true, "");
        }
        
        if (evento == menu_principal.item_Listar_Ingresos
                || evento == menu_principal.btn_listar_Ingresos) {
            
            controlador_listar_ingresos.Iniciar_Componentes();
        }
        
        if (evento == menu_principal.item_Listar_Salidas
                || evento == menu_principal.btn_listar_salidas) {
            
            controlador_listar_salidas.Iniciar_Componentes();
        }
        
        if (evento == menu_principal.item_admin_Usuarios
                || evento == menu_principal.btn_administrar_Usua) {
            
            controlador_admin_usuarios.Iniciar_Componentes();
        }
        
        if (evento == menu_principal.item_apariencia
                || evento == menu_principal.btn_apariencia) {
            
            controlador_apariencia.Asignar_Nombre_Color_Funciones(color_txt_menu, color_text_submenu, color_text_empresa, color_fondo_pantalla, color_fondo_barra_menu, color_fondo_barra_herramientas, color_fondo_barra_estado, color_fun_barra_herramientas, color_fun_barra_estado, color_borde_barra_herramientas, color_borde_barra_estado);
            controlador_apariencia.Iniciar_Componentes();
            
        }
        
        if (evento == menu_principal.item_sistema || evento == menu_principal.btn_confi_Sistema) {
            
            controlador_sistema.Poner_Nombre_Txt(inicio, funciones, configuracion, sistema, reportes, titulo, familia_letra, estilo, tamano_letra);
            
            controlador_sistema.Iniciar_Componentes();
            
        }
        
        if (evento == menu_principal.item_reportes || evento == menu_principal.btn_reportes) {
            
            controlador_reportes.Iniciar_Componentes();
            
        }
        
        if (evento == menu_principal.item_back_base || evento == menu_principal.btn_respaldos) {
            
            controlador_base_datos.Iniciar_Componentes();
            
        }
        
        if (evento == menu_principal.item_estadisticas || evento == menu_principal.btn_estadistica) {
            
            controlador_estadisticas.Iniciar_Componentes();
            
        }
        
        if (evento == menu_principal.btn_salir) {
            
            Salir_X();
        }
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {

        ///  Object objeto = e.getSource();
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    private String id_usuario;
    private String nombre;
    private String usuario;
    private String cedula;
    private String contrasena;
    private String tipo_cuenta;

    //===================Nombres colores Funciones=================
    private String color_txt_menu;
    private String color_text_submenu;
    private String color_text_empresa;
    
    private String color_fondo_pantalla;
    private String color_fondo_barra_menu;
    private String color_fondo_barra_herramientas;
    private String color_fondo_barra_estado;
    private String color_fun_barra_herramientas;
    private String color_fun_barra_estado;
    
    private String color_borde_barra_herramientas;
    private String color_borde_barra_estado;

    //=======================Funciones================================
    private String inicio;
    private String funciones;
    private String configuracion;
    private String sistema;
    private String reportes;
    private String titulo;
    
    private String familia_letra;
    private int estilo;
    private int tamano_letra;
    
}
