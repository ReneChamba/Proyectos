package modelo;

public class Constantes {

    public Constantes() {
        baseDatos = "nuevo_parqueadero";
        contrasena_Servidor = "losmaspepas23";
        usuarioServidor = "root";
        ///Tablas 
        Autos_cancelados = "autos_cancelados";
        Colores = "colores";
        Colores_nombres_funciones = "colores_nombres_funciones";
        Tabla_autos_ingresos = "tabla_autos_ingresos";
        Tabla_autos_salidos = "tabla_autos_salidos";
        Tabla_tipo_vehiculos = "tabla_tipo_vehiculos";
        Tabla_usuarios = "tabla_usuarios";
        Tabla_sistema = "tabla_sistema";
        Tabla_lavado = "tabla_lavado";
        Tabla_lavado_Mas_Parqueo = "tabla_lavado_mas_parqueo";

        ///Array//
        nombre_tablas = new String[10];

        nombre_tablas[0] = Autos_cancelados;
        nombre_tablas[1] = Colores;
        nombre_tablas[2] = Colores_nombres_funciones;
        nombre_tablas[3] = Tabla_autos_ingresos;
        nombre_tablas[4] = Tabla_autos_salidos;
        nombre_tablas[5] = Tabla_tipo_vehiculos;
        nombre_tablas[6] = Tabla_usuarios;
        nombre_tablas[7] = Tabla_sistema;
        nombre_tablas[8] = Tabla_lavado;
        nombre_tablas[9] = Tabla_lavado_Mas_Parqueo;

    }

    public String getBaseDatos() {
        return baseDatos;
    }

    public String getContrasena_Servidor() {
        return contrasena_Servidor;
    }

    public String getUsuarioServidor() {
        return usuarioServidor;
    }

    public String getAutos_cancelados() {
        return Autos_cancelados;
    }

    public String getColores() {
        return Colores;
    }

    public String getColores_nombres_funciones() {
        return Colores_nombres_funciones;
    }

    public String getTabla_autos_ingresos() {
        return Tabla_autos_ingresos;
    }

    public String getTabla_autos_salidos() {
        return Tabla_autos_salidos;
    }

    public String getTabla_tipo_vehiculos() {
        return Tabla_tipo_vehiculos;
    }

    public String getTabla_usuarios() {
        return Tabla_usuarios;
    }

    public String getTabla_sistema() {
        return Tabla_sistema;
    }

    public String getTabla_lavado() {
        return Tabla_lavado;
    }

    public String getTabla_lavado_Mas_Parqueo() {
        return Tabla_lavado_Mas_Parqueo;
    }
    
    

    public String[] getNombreTablas() {

        return nombre_tablas;
    }

    private final String baseDatos;
    private final String contrasena_Servidor;
    private final String usuarioServidor;

    private final String Autos_cancelados;
    private final String Colores;

    private final String Colores_nombres_funciones;
    private final String Tabla_autos_ingresos;

    private final String Tabla_autos_salidos;
    private final String Tabla_tipo_vehiculos;
    private final String Tabla_usuarios;
    private final String Tabla_sistema;
    private final String Tabla_lavado;
    private final String Tabla_lavado_Mas_Parqueo;
    private final String nombre_tablas[];

}
