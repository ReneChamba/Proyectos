package principal;

import controlador.*;
import modelo.*;
import vistas.*;

public class Principal {

    public static void main(String[] args) {
        // TODO code application logic here

        Modelo modelo = new Modelo();
        Modelo_Nuevo modelo_nuevo = new Modelo_Nuevo();
        Crud_Cuentas crud_cuentas = new Crud_Cuentas();
        Crud_Nuevo crud_nuevo = new Crud_Nuevo();
        Menu_Principal menu = new Menu_Principal();
        Registrar registrar = new Registrar(menu, true);
        Sesion sesion = new Sesion(menu, true);

        Productos_Vendidos ventas = new Productos_Vendidos(menu, true);
        Compras compras = new Compras(menu, true);
        Cuentas_Usuarios cuentas_usuarios = new Cuentas_Usuarios(menu, true);
        Configuracion_Cuenta configuracion_cuenta = new Configuracion_Cuenta(menu, true);

        Vender_Producto vender_Producto = new Vender_Producto(menu, true);
        Clientes clientes = new Clientes(vender_Producto, true);//       
        Detalle_Venta detalle_venta = new Detalle_Venta(vender_Producto, true);
        Colores colores = new Colores(menu, true);

        Validacion_txt validacion_txt = new Validacion_txt();
        Personalizar_combo personalizar_combo = new Personalizar_combo();
        Correo correo = new Correo();
        Proveedores proveedor = new Proveedores(menu, true);
        Estadisticas estadisticas = new Estadisticas(menu, true);
        Recuperar_Contrasena recuperar_Contrasena = new Recuperar_Contrasena(sesion, true);

        Productos_Proveedores productos_proveedores = new Productos_Proveedores(proveedor, true);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7
        Controlador_Recuperar_Pass controlador_recuperar_pass = new Controlador_Recuperar_Pass(crud_nuevo, modelo_nuevo, recuperar_Contrasena, validacion_txt, correo);
        Controlador_sesion controlador_sesion = new Controlador_sesion(modelo, sesion, crud_cuentas, menu, controlador_recuperar_pass);

        Controlador_Registrar registrar_controlador = new Controlador_Registrar(modelo, registrar, crud_cuentas, validacion_txt);
        Controlador_Productos_Vendidos controlador_ventas = new Controlador_Productos_Vendidos(modelo_nuevo, ventas, crud_nuevo);
        Controlador_Clientes controlador_clientes = new Controlador_Clientes(modelo_nuevo, clientes, crud_nuevo, vender_Producto, validacion_txt);

        Controlador_Vender_Producto controlador_Vender_Producto = new Controlador_Vender_Producto(modelo, vender_Producto, crud_cuentas, detalle_venta, controlador_clientes);

        Controlador_Cuentas controlador_cuentas = new Controlador_Cuentas(modelo_nuevo, crud_nuevo, cuentas_usuarios);
        Controlador_Configura_Cuenta controlador_Configura_cuenta = new Controlador_Configura_Cuenta(crud_nuevo, modelo_nuevo, configuracion_cuenta, validacion_txt, menu);
        Controlador_Estadisticas controlador_estadisticas = new Controlador_Estadisticas(estadisticas, modelo_nuevo, crud_nuevo, personalizar_combo);
        /////////////////////////////7Estos dos contraladores se relacionan
        Controlador_Productos_Proveedores controlador_productos_proveedores = new Controlador_Productos_Proveedores(productos_proveedores, modelo_nuevo, crud_nuevo);
        Controlador_Proveedor controlador_proveedor = new Controlador_Proveedor(modelo_nuevo, crud_nuevo, proveedor, controlador_productos_proveedores, validacion_txt);

        Controlador_Compras controlador_compras = new Controlador_Compras(modelo, compras, crud_cuentas);

        Controlador_Colores controlador_colores = new Controlador_Colores(modelo_nuevo, crud_nuevo, colores, menu);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        Controlador_Menu_Principal menu_contralador = new Controlador_Menu_Principal(menu, controlador_sesion, registrar_controlador, controlador_ventas, controlador_compras, controlador_Vender_Producto, controlador_proveedor, controlador_cuentas,
                controlador_Configura_cuenta, controlador_clientes, controlador_estadisticas, controlador_colores);

        menu_contralador.EstadosIniciales();
        menu.setVisible(true);

    }

}
