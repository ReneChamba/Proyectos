package prinncipal;

import vista.*;
import controlador.*;
import mensajes.Joption;
import modelo.*;

public class Principal {

    public static void main(String[] args) {
        // TODO code application logic here

        try {

            //==================Primer Bloque========================
            Menu_Principal menu_principal = new Menu_Principal();
            Constantes constantes = new Constantes();
            Iconos iconos = new Iconos();
            Joption mensajes_2 = new Joption();
            Crud_Primero crud_primero = new Crud_Primero();
            Fuentes_Y_Mas fuentes_Y_Mas = new Fuentes_Y_Mas();
            crud_primero.setConstantes(constantes);

            //===================SPLASH=====================================
            Splash splash = new Splash();

            Sms_Pregunta sms_Pregunta = new Sms_Pregunta(menu_principal, true);
            Controlador_Sms_Pregunta controlador_Sms_Pregunta = new Controlador_Sms_Pregunta();
            controlador_Sms_Pregunta.setSms_Pregunta(sms_Pregunta);
            controlador_Sms_Pregunta.setFuentes_Y_Mas(fuentes_Y_Mas);
            controlador_Sms_Pregunta.Estados_Constructor();

            Controlador_Splash controlador_Splash = new Controlador_Splash();
            controlador_Splash.setcontrolador_Sms_Pregunta(controlador_Sms_Pregunta);

            controlador_Splash.setCrud_primero(crud_primero);
            controlador_Splash.setSplash(splash);
            controlador_Splash.setIconos(iconos);
            controlador_Splash.setMensajes(mensajes_2);
            controlador_Splash.Iniciar_Splash();
            controlador_Splash.String_datos(constantes.getNombreTablas().length);
            splash.setVisible(true);
            //========================================================
            System.out.println("dale que todo cargo ");

            //====================Segundo Bloque============================
            Renderizar_Tablas renderizar_tablas = new Renderizar_Tablas();
            Render_Encabezado render_encabezado = new Render_Encabezado();
            Modelo_Nuevo modelo_nuevo = new Modelo_Nuevo();
            modelo_nuevo.setRenderizar_Tablas(renderizar_tablas);
            modelo_nuevo.setIconos(iconos);
            modelo_nuevo.setConstantes(constantes);
            modelo_nuevo.setRenderizar_Encabezado(render_encabezado);
            modelo_nuevo.Iniciar_Componentes();

            Iconos_Menu_Principal iconos_menu_principal = new Iconos_Menu_Principal();

            //=====================SESION=====================================
            MensajeLanzar mensajeLanzar = new MensajeLanzar(menu_principal, false);
            Controlador_Sms controlador_sms = new Controlador_Sms();
            controlador_sms.setMensaje_Lanzar(mensajeLanzar);

            Sesion sesion = new Sesion(menu_principal, true);
            Controlador_Sesion controlador_sesion = new Controlador_Sesion();
            controlador_sesion.setModelo_Nuevo(modelo_nuevo);
            controlador_sesion.setCrud_Primero(crud_primero);
            controlador_sesion.setSesion(sesion);
            controlador_sesion.setFuentes_Y_Mas(fuentes_Y_Mas);
            controlador_sesion.setMensajes(mensajes_2);
            controlador_sesion.setIconos(iconos);
            controlador_sesion.setControlador_Lanzar_Sms(controlador_sms);
            controlador_sesion.Estado_Constructor();

            //===========================================================================
            //======================REGISTRAR USUARIOS=============================
            Validacion_txt validacion_txt = new Validacion_txt();
            Registrar registrar = new Registrar(menu_principal, true);
            Controlador_Registrar controlador_registrar = new Controlador_Registrar();
            controlador_registrar.setRegistrar(registrar);
            controlador_registrar.setLanzar_Mensaje(controlador_sms);
            controlador_registrar.setModelo_nuevo(modelo_nuevo);
            controlador_registrar.setCrud_Primero(crud_primero);
            controlador_registrar.setValidacion_Txt(validacion_txt);
            controlador_registrar.setIconos(iconos);
            controlador_registrar.setMensajes(mensajes_2);
            controlador_registrar.setFuentes_Y_Mas(fuentes_Y_Mas);
            controlador_registrar.Estados_Constructor(); //estado constructor

            //=================INGRESAR VEHICULO=====================================
            Ingresar_Vehiculo ingresar_vehiculo = new Ingresar_Vehiculo(menu_principal, true);
            Controlador_Ingresar_Vehiculo controlador_ingresar_vehiculo = new Controlador_Ingresar_Vehiculo();
            controlador_ingresar_vehiculo.setIngresar_Vehiculo(ingresar_vehiculo);
            controlador_ingresar_vehiculo.setLanzar_Mensaje(controlador_sms);
            controlador_ingresar_vehiculo.setModelo_nuevo(modelo_nuevo);
            controlador_ingresar_vehiculo.setCrud_Primero(crud_primero);
            controlador_ingresar_vehiculo.setIconos(iconos);
            controlador_ingresar_vehiculo.setMensajes(mensajes_2);
            controlador_ingresar_vehiculo.setFuentes_Y_Mas(fuentes_Y_Mas);
            controlador_ingresar_vehiculo.Iniciar_Constructor(); // estados iniciales como el constructor

            //===================RETIRAR VEHICULO===================================
            Retirar_Vehiculo retirar_vehiculo = new Retirar_Vehiculo(menu_principal, true);
            Controlador_Retirar_Vehiculo controlador_retirar_vehiculo = new Controlador_Retirar_Vehiculo();
            controlador_retirar_vehiculo.setRetirar_Vehiculo(retirar_vehiculo);
            controlador_retirar_vehiculo.setLanzar_Mensaje(controlador_sms);
            controlador_retirar_vehiculo.setModelo_nuevo(modelo_nuevo);
            controlador_retirar_vehiculo.setCrud_Primero(crud_primero);
            controlador_retirar_vehiculo.setIconos(iconos);
            controlador_retirar_vehiculo.setMensajes(mensajes_2);
            controlador_retirar_vehiculo.setFuentes_Y_Mas(fuentes_Y_Mas);
            controlador_retirar_vehiculo.Estados_Contructor(); // estados iniciales como el constructor

            //=====================LISTAR VEHICULOS INGRESADOS========================
            Listar_Vehiculos_Ingresados listar_vehiculos_ingresados = new Listar_Vehiculos_Ingresados(menu_principal, true);
            //---EDITAR INGRESO-----
            Editar_Ingreso editar_ingreso = new Editar_Ingreso(menu_principal, true);
            //----------------------
            Controlador_Listar_Ingresos controlador_listar_ingresos = new Controlador_Listar_Ingresos();
            controlador_listar_ingresos.setListar_Vehiculos(listar_vehiculos_ingresados);

            controlador_listar_ingresos.setModelo_nuevo(modelo_nuevo);
            controlador_listar_ingresos.setCrud_Primero(crud_primero);
            controlador_listar_ingresos.setFuentes_Y_Mas(fuentes_Y_Mas);
            controlador_listar_ingresos.setControlador_Sms_Pregunta(controlador_Sms_Pregunta);
            controlador_listar_ingresos.setLanzar_Mensaje(controlador_sms);
            controlador_listar_ingresos.setControlador_Retirar_Vehiculo(controlador_retirar_vehiculo);
            controlador_listar_ingresos.setEditar_Ingreso(editar_ingreso);
            controlador_listar_ingresos.setMensajes(mensajes_2);
            controlador_listar_ingresos.setIconos(iconos);
            controlador_listar_ingresos.Estados_Constructor();

            //===========================LISTAR VEHICULOS SALIDAS==========================================
            Listar_Vehiculos_Retirados listar_vehiculos_retirados = new Listar_Vehiculos_Retirados(menu_principal, true);
            Controlador_Listar_Salidas controlador_listar_salidas = new Controlador_Listar_Salidas();
            controlador_listar_salidas.setListar_Vehiculos_Salida(listar_vehiculos_retirados);
            controlador_listar_salidas.setModelo_nuevo(modelo_nuevo);
            controlador_listar_salidas.setCrud_Primero(crud_primero);
            controlador_listar_salidas.setFuentes_Y_Mas(fuentes_Y_Mas);
            controlador_listar_salidas.setMensajes(mensajes_2);
            controlador_listar_salidas.setIconos(iconos);
            controlador_listar_salidas.Estados_Constructor();

            //================CONFIGURAR VEHICULOS======================================
            Configurar_Tipo_Vehiculos configurar_tipo_vehiculos = new Configurar_Tipo_Vehiculos(menu_principal, true);
            Controlador_Confi_Vehiculos controlador_confi_vehiculos = new Controlador_Confi_Vehiculos();
            controlador_confi_vehiculos.setConfigurar_Tipo_Vehiculo(configurar_tipo_vehiculos);
            controlador_confi_vehiculos.setModelo_nuevo(modelo_nuevo);
            controlador_confi_vehiculos.setCrud_Primero(crud_primero);
            controlador_confi_vehiculos.setFuentes_Y_Mas(fuentes_Y_Mas);
            controlador_confi_vehiculos.setMensajes(mensajes_2);
            controlador_confi_vehiculos.setLanzar_Mensaje(controlador_sms);
            controlador_confi_vehiculos.setcontrolador_Sms_Pregunta(controlador_Sms_Pregunta);

            controlador_confi_vehiculos.setIconos(iconos);
            controlador_confi_vehiculos.Estados_Constructor();
            //================EDITAR CUENTA DE USUARIO==========================================

            Editar_Usuario editar_usuario = new Editar_Usuario(menu_principal, true);
            Controlador_Editar_Usuario controlador_editar_usuario = new Controlador_Editar_Usuario(editar_usuario, crud_primero, modelo_nuevo);

            controlador_editar_usuario.setEditar_Usuario(editar_usuario);
            controlador_editar_usuario.setModelo_nuevo(modelo_nuevo);
            controlador_editar_usuario.setCrud_Primero(crud_primero);
            controlador_editar_usuario.setLanzar_Mensaje(controlador_sms);
            controlador_editar_usuario.setFuentes_Y_Mas(fuentes_Y_Mas);
            controlador_editar_usuario.setMensajes(mensajes_2);
            controlador_editar_usuario.setIconos(iconos);

            //plz que  a estoy haciendo uso de un objeto de tipo controlador menu pricipal
            controlador_editar_usuario.Estado_Constructor();

            //====================ADMINISTRAR USUARIOS==================================================
            Admin_Usuarios admin_usuarios = new Admin_Usuarios(menu_principal, true);
            Controlador_Admin_Usuarios controlador_admin_usuarios = new Controlador_Admin_Usuarios(admin_usuarios, crud_primero, modelo_nuevo);

            controlador_admin_usuarios.setAdmin_Usuarios(admin_usuarios);
            controlador_admin_usuarios.setModelo_nuevo(modelo_nuevo);
            controlador_admin_usuarios.setControlador_Sms_Pregunta(controlador_Sms_Pregunta);
            controlador_admin_usuarios.setCrud_Primero(crud_primero);
            controlador_admin_usuarios.setLanzar_Mensaje(controlador_sms);
            controlador_admin_usuarios.setFuentes_Y_Mas(fuentes_Y_Mas);
            controlador_admin_usuarios.setMensajes(mensajes_2);
            controlador_admin_usuarios.setIconos(iconos);

            controlador_admin_usuarios.Estado_Constructor();

            //======================CONFIGURAR APARIENCIA==========================
            Modelo_Colores modelo_colores = new Modelo_Colores();

            Apariencia apariencia = new Apariencia(menu_principal, true);
            Controlador_Apariencia controlador_apariencia = new Controlador_Apariencia();
            controlador_apariencia.setApariencia(apariencia);
            controlador_apariencia.setModelo_Colores(modelo_colores);
            controlador_apariencia.setCrud_Primero(crud_primero);
            controlador_apariencia.setLanzar_Mensaje(controlador_sms);
            controlador_apariencia.setFuentes_Y_Mas(fuentes_Y_Mas);
            controlador_apariencia.setMensajes(mensajes_2);
            controlador_apariencia.setIconos(iconos);
            controlador_apariencia.Estados_Contructor();

            //==============CONFIGURAR SISTEMA=============================================
            Modelo_Sistema modelo_sistema = new Modelo_Sistema();
            Sistemas sistemas = new Sistemas(menu_principal, true);
            Controlador_Sistema controlador_sistema = new Controlador_Sistema();

            controlador_sistema.setSistema(sistemas);
            controlador_sistema.setModelo_Sistema(modelo_sistema);
            controlador_sistema.setCrud_Primero(crud_primero);
            controlador_sistema.setLanzar_Mensaje(controlador_sms);
            controlador_sistema.setFuentes_Y_Mas(fuentes_Y_Mas);
            controlador_sistema.setMensajes(mensajes_2);
            controlador_sistema.setIconos(iconos);
            controlador_sistema.Estados_Contructor();

            //=======================GENERAR RESPALDOS==========================================0
            Exportar_Base exportar_base = new Exportar_Base(menu_principal, true);
            Controlador_Base_Datos controlador_base_datos = new Controlador_Base_Datos(exportar_base);
            controlador_base_datos.setExportar_Base(exportar_base);
            controlador_base_datos.setFuentes_Y_Mas(fuentes_Y_Mas);
            controlador_base_datos.setLanzar_Mensaje(controlador_sms);
            controlador_base_datos.setMensajes(mensajes_2);
            controlador_base_datos.setIconos(iconos);
            controlador_base_datos.setConstantes(constantes);
            controlador_base_datos.Estado_Contructor();

            //========================GENERAR REPORES============================== 
            Reportes reportes = new Reportes(menu_principal, true);
            Controlador_Reportes controlador_reportes = new Controlador_Reportes(reportes, modelo_nuevo, crud_primero);
            controlador_reportes.setReportes(reportes);
            controlador_reportes.setModelo_Nuevo(modelo_nuevo);
            controlador_reportes.setCrud_Primero(crud_primero);
            controlador_reportes.setFuentes_Y_Mas(fuentes_Y_Mas);
            controlador_reportes.setMensajes(mensajes_2);
            controlador_reportes.setIconos(iconos);
            controlador_reportes.Estado_Constructor();
            //==============GENERAR ESTADISTICAS=====================================
            Estadisticas estadisticas = new Estadisticas(menu_principal, true);
            Controlador_Estadisticas controlador_estadisticas = new Controlador_Estadisticas();
            controlador_estadisticas.setEstadisticas(estadisticas);
            controlador_estadisticas.setCrud_Primero(crud_primero);
            controlador_estadisticas.setModelo_Nuevo(modelo_nuevo);
            controlador_estadisticas.setFuentes_Y_Mas(fuentes_Y_Mas);
            controlador_estadisticas.setMensajes(mensajes_2);
            controlador_estadisticas.setIconos(iconos);
            controlador_estadisticas.Estado_Constructor();

            //================CONTROLADOR MENU PRINCIPAL===========================
            //La vista del menu principal esta creada  despues del splsh
            Controlador_Menu_Principal controlador_menu_principal = new Controlador_Menu_Principal();

            controlador_menu_principal.setMenu_Principal(menu_principal);
            controlador_menu_principal.setModelo_Colores(modelo_colores);
            controlador_menu_principal.setCrud_Primero(crud_primero);
            controlador_menu_principal.setModelo_Sistema(modelo_sistema);
            controlador_menu_principal.setMensaje(mensajes_2);
            controlador_menu_principal.setIconos(iconos);
            controlador_menu_principal.setModelo_Nuevo(modelo_nuevo);
            controlador_menu_principal.setFuentes_Y_Mas(fuentes_Y_Mas);
            controlador_menu_principal.setControlador_Sms_Pregunta(controlador_Sms_Pregunta);
            controlador_menu_principal.setIconos_Menu_Principal(iconos_menu_principal);

            controlador_menu_principal.setControlador_Sistema(controlador_sistema);
            controlador_menu_principal.setControlador_Reportes(controlador_reportes);
            controlador_menu_principal.setControlador_Base_Datos(controlador_base_datos);
            controlador_menu_principal.setControlador_Estadisticas(controlador_estadisticas);

            controlador_menu_principal.setControlador_Sesion(controlador_sesion);
            controlador_menu_principal.setControlador_Registrar(controlador_registrar);
            controlador_menu_principal.setControlador_Ingresar_Vehiculo(controlador_ingresar_vehiculo);
            controlador_menu_principal.setControlador_Listar_Ingresos(controlador_listar_ingresos);///

            controlador_menu_principal.setControlador_Configurar_Vehicu(controlador_confi_vehiculos);
            controlador_menu_principal.setControlador_Listar_Salidas(controlador_listar_salidas);
            controlador_menu_principal.setControlador_Editar_Usuario(controlador_editar_usuario);
            controlador_menu_principal.setControlador_Admin_Usuario(controlador_admin_usuarios);
            controlador_menu_principal.setControlador_Apariencia(controlador_apariencia);
            controlador_menu_principal.setControlador_Retirar_Vehiculo(controlador_retirar_vehiculo);
            controlador_menu_principal.Estado_Constructor();

            //========================================================================
            controlador_sesion.Recibir_Menu_Principal(controlador_menu_principal);
            controlador_listar_ingresos.setControlador_Menu_Principal(controlador_menu_principal);
            controlador_retirar_vehiculo.setControlador_Menu_Principal(controlador_menu_principal);
            controlador_editar_usuario.Controlador_Menu_Principal(controlador_menu_principal);
            controlador_apariencia.setControlador_Menu_Principal(controlador_menu_principal);
            controlador_sistema.setControlador_Menu_Principal(controlador_menu_principal);
            controlador_ingresar_vehiculo.setControlador_Menu_Principal(controlador_menu_principal);

            sesion.setVisible(true);

        } catch (Exception e) {

        }
    }

}
