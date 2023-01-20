package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Crud_Primero extends Coneccion {

    private Constantes constantes;

    public Crud_Primero() {

        super();

    }

    public void setConstantes(Constantes constantes) {
        this.constantes = constantes;
    }

    public int Verificar_Tablas() {

        int retornar = 0;

        try {

            Connection cn = getConnection();

            if (cn instanceof Connection) {

                PreparedStatement pr = null;
                ResultSet resultado = null;
                pr = cn.prepareStatement("SHOW FULL TABLES FROM " + constantes.getBaseDatos());

                resultado = pr.executeQuery();

                String nombre = "";

                int numero_tablas = 0;
                while (resultado.next()) {

                    nombre = resultado.getString("Tables_in_" + constantes.getBaseDatos());

                    //verificar , tiene que entrar el mismo numero de veces
                    for (String nombreTabla : constantes.getNombreTablas()) {
                        if (nombre.equals(nombreTabla)) {

                            numero_tablas++;
                            break;

                        }

                    }

                }

                //debe retorna el numero de tablas
                retornar = numero_tablas;

            }

        } catch (Exception e) {
            retornar = 1;
        }

        return retornar;

    }

    public boolean Iniciar_Sesion(Modelo_Nuevo modelo_nuevo, int parametro) {

        boolean retorno = false;
        try {

            PreparedStatement pr = null;
            ResultSet resultado = null;

            // 0 iniciar sesion, 
            // 1 luego de actualizar los datos
            String sql_parametros = " CUENTA =? AND CONTRASENA =? ";

            if (parametro == 1) {
                sql_parametros = " ID_USUARIO =?";
            }

            pr = getConnection().prepareStatement("SELECT * FROM " + constantes.getTabla_usuarios() + " WHERE " + sql_parametros);

            if (parametro == 0) {
                pr.setString(1, modelo_nuevo.getUsuario());
                pr.setString(2, modelo_nuevo.getContrasena());
            }

            if (parametro == 1) {
                pr.setString(1, modelo_nuevo.getCodigo());

            }

            resultado = pr.executeQuery();

            if (resultado.next()) {

                modelo_nuevo.setCodigo(resultado.getString("ID_USUARIO"));
                modelo_nuevo.setUsuario(resultado.getString("CUENTA"));
                modelo_nuevo.setContrasena(resultado.getString("CONTRASENA"));
                modelo_nuevo.setCedula(resultado.getString("CEDULA"));
                modelo_nuevo.setNombre(resultado.getString("NOMBRE"));
                modelo_nuevo.setTipo_cuenta(resultado.getString("TIPO_CUENTA"));

                retorno = true;
            }

        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        } finally {
            getDesconectar();
        }

        return retorno;

    }

    public boolean Registrar_Cuenta(Modelo_Nuevo modelo_nuevo) {

        try {

            PreparedStatement pr = null;

            String sql_consulta = "INSERT INTO " + constantes.getTabla_usuarios() + " VALUES (NULL,?,?,?,?,?)";

            pr = getConnection().prepareStatement(sql_consulta);
            pr.setString(1, modelo_nuevo.getCedula());
            pr.setString(2, modelo_nuevo.getNombre());
            pr.setString(3, modelo_nuevo.getUsuario());
            pr.setString(4, modelo_nuevo.getContrasena());
            pr.setString(5, modelo_nuevo.getTipo_cuenta());
            pr.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("ERROR  . registrar cuenta" + e.getMessage());
        } finally {
            getDesconectar();
        }

        return false;

    }

    public boolean Ingresar_Vehiculo(Modelo_Nuevo modelo_nuevo) {

        try {

            PreparedStatement pr = null;
            ResultSet resultado = null;
            /*
            
            Antes de ingresar el vehiculo , consulto el tipo de vehiculo  para traer el precio
             */

            pr = getConnection().prepareStatement("SELECT PRECIO_HORA FROM " + constantes.getTabla_tipo_vehiculos() + " WHERE NOMBRE=?");
            pr.setString(1, modelo_nuevo.getTipo_vehiculo());
            resultado = pr.executeQuery();
            String precio_hora = "";

            if (resultado.next()) {

                precio_hora = resultado.getString("PRECIO_HORA");
            }

            //####################################################################################
            String sql_consulta = "INSERT INTO " + constantes.getTabla_autos_ingresos() + "  VALUES (NULL,?,?,?,?,?,?,?,?,?,?)";

            pr = getConnection().prepareStatement(sql_consulta);

            pr.setString(1, modelo_nuevo.getFecha_Ingresar_Actual(false));
            pr.setString(2, modelo_nuevo.getFecha_Ingresar_Actual(true));
            pr.setString(3, modelo_nuevo.getPropietario());
            pr.setString(4, modelo_nuevo.getPlaca());
            pr.setString(5, modelo_nuevo.getTipo_vehiculo());
            pr.setString(6, modelo_nuevo.getMotivo_Ingreso());
            pr.setString(7, modelo_nuevo.getPrecio_lavado());
            pr.setString(8, modelo_nuevo.getPrecio_parqueo());
            pr.setString(9, precio_hora);
            pr.setString(10, modelo_nuevo.getEstado_vehiculo()); // este es para la columna estado
            pr.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("ERROR  al registrar vehiculo" + e.getMessage());
        } finally {
            getDesconectar();
        }

        return false;

    }

    public boolean Buscar_PLaca(Modelo_Nuevo modelo_nuevo, boolean elegir) {

        try {

            //True es para buscar las placa y todos sus datos para cobrar
            //False es para solo consultar la placa y evitar que un vehiculo que este ingresado actualmente vuelva a ingresarse
            PreparedStatement pr = null;
            ResultSet resultado = null;
            String sql_consulta = "SELECT *  FROM " + constantes.getTabla_autos_ingresos() + " WHERE PLACA =?";

            pr = getConnection().prepareStatement(sql_consulta);
            pr.setString(1, modelo_nuevo.getPlaca());
            resultado = pr.executeQuery();

            if (resultado.next()) {

                if (elegir) { //True par buscar placa y traer datos y cobrar 

                    modelo_nuevo.setPropietario(resultado.getString("PROPIETARIO"));
                    modelo_nuevo.setTipo_vehiculo(resultado.getString("TIPO_VEHICULO"));
                    modelo_nuevo.setPrecio_hora(resultado.getString("PRECIO_HORA"));
                    modelo_nuevo.setMotivo_Ingreso(resultado.getString("MOTIVO"));
                    modelo_nuevo.setPrecio_lavado(resultado.getString("PRECIO_LAVADO"));
                    modelo_nuevo.setPrecio_parqueo(resultado.getString("PRECIO_PARQUEO"));
                    modelo_nuevo.setFecha_registro(modelo_nuevo.getOperacion_Fecha(resultado.getString("FECHA_REGISTRO"))); //recupera fecha_registo

                }

                return true;
            }

        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        } finally {
            getDesconectar();
        }

        return false;

    }

    public boolean Llenar_Combo_tipo_Vehiculo(Modelo_Nuevo modelo_nuevo) {

        try {

            PreparedStatement pr = null;
            ResultSet resultado = null;
            String sql_consulta = "SELECT NOMBRE  FROM " + constantes.getTabla_tipo_vehiculos();

            pr = getConnection().prepareStatement(sql_consulta);

            resultado = pr.executeQuery();

            while (resultado.next()) {

                modelo_nuevo.getCombo_tipo().addItem(resultado.getString("NOMBRE"));

            }

            return true;

        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        } finally {
            getDesconectar();
        }

        return false;

    }

    public boolean Eliminar_Ingreso(Modelo_Nuevo modelo_nuevo) {

        try {

            PreparedStatement pr = null;

            pr = getConnection().prepareStatement("DELETE FROM " + constantes.getTabla_autos_ingresos() + " WHERE PLACA= ?");

            pr.setString(1, modelo_nuevo.getPlaca());

            pr.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("erro al eliminar el registro al retirar el vehiculo");
        }

        return false;

    }

    public boolean Actualizar_Datos_Usuario(Modelo_Nuevo modelo_nuevo, int parametro) {////

        try {
            //#0: editar usuario
            //# 1: nombre
            //# 2: contrasena

            String campo = "CUENTA";
            if (parametro == 1) {
                campo = "NOMBRE";

            }
            if (parametro == 2) {
                campo = "CONTRASENA";

            }

            PreparedStatement pr = null;
            pr = getConnection().prepareStatement("UPDATE  " + constantes.getTabla_usuarios() + "  SET " + campo + " =? WHERE ID_USUARIO =?");

            //getNOmbre():  le puede llegar 3 datos
            pr.setString(1, modelo_nuevo.getNombre());
            pr.setString(2, modelo_nuevo.getCodigo());

            pr.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("erro al actualizar el datos usuarios " + e.getMessage());
        } finally {
            getDesconectar();
        }

        return false;
    }

    public boolean Ingresar_tabla_salidos(Modelo_Nuevo modelo_nuevo) {

        try {

            PreparedStatement pr = null;
            String sql_consulta = "INSERT INTO " + constantes.getTabla_autos_salidos() + "  VALUES (NULL,?,?,?,?,?,?,?,?,?)";

            pr = getConnection().prepareStatement(sql_consulta);
            //Para la fecha date , para ordenar
            pr.setString(1, modelo_nuevo.getFecha_salida());

            pr.setString(2, modelo_nuevo.getFecha_registro());
            pr.setString(3, modelo_nuevo.getFecha_salida());
            pr.setString(4, modelo_nuevo.getPlaca());
            pr.setString(5, modelo_nuevo.getTipo_vehiculo());
            pr.setString(6, modelo_nuevo.getPrecio_hora());
            pr.setString(7, modelo_nuevo.getNumero_horas());
            pr.setString(8, modelo_nuevo.getNumero_minutos());
            pr.setString(9, modelo_nuevo.getTotal_Cobrar());// valor cobrado por le parqueo
            pr.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("ERROR  al registrar vehiculo tabla salida" + e.getMessage());
        } finally {
            getDesconectar();
        }

        return false;

    }

    public boolean Ingresar_tabla_Lavado_Parqueo(Modelo_Nuevo modelo_nuevo) {

        try {

            PreparedStatement pr = null;
            String sql_consulta = "INSERT INTO " + constantes.getTabla_lavado_Mas_Parqueo() + "  VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?)";

            pr = getConnection().prepareStatement(sql_consulta);
            // el 1 ESTE ES PARA EL CAMPO DATE, YO LE PASO UN STRING CON UN FORMATO DATETIME ,
            //PERO DA IGUAL XQ EL CAMPO EN LA BASE DE DATOS ES DATE, Y SOLO TOMA LA FECHA 
            pr.setString(1, modelo_nuevo.getFecha_salida());

            pr.setString(2, modelo_nuevo.getFecha_registro());
            pr.setString(3, modelo_nuevo.getFecha_salida());
            pr.setString(4, modelo_nuevo.getPlaca());
            pr.setString(5, modelo_nuevo.getTipo_vehiculo());
            pr.setString(6, modelo_nuevo.getPrecio_hora());
            pr.setString(7, modelo_nuevo.getNumero_horas());
            pr.setString(8, modelo_nuevo.getNumero_minutos());
            pr.setString(9, modelo_nuevo.getPrecio_parqueo());
            pr.setString(10, modelo_nuevo.getPrecio_lavado());

            pr.setString(11, modelo_nuevo.getTotal_Cobrar());// valor cobrado por le parqueo
            pr.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("ERROR  al registrar vehiculo tabla salida lavado mas parqueo" + e.getMessage());
        } finally {
            getDesconectar();
        }

        return false;

    }

    public boolean Ingresar_tabla_Lavado(Modelo_Nuevo modelo_nuevo) {

        try {

            PreparedStatement pr = null;
            String sql_consulta = "INSERT INTO " + constantes.getTabla_lavado() + "  VALUES (NULL,?,?,?,?,?)";

            pr = getConnection().prepareStatement(sql_consulta);

            // el 1 ESTE ES PARA EL CAMPO DATE, YO LE PASO UN STRING CON UN FORMATO DATETIME ,
            //PERO DA IGUAL XQ EL CAMPO EN LA BASE DE DATOS ES DATE, Y SOLO TOMA LA FECHA 
            pr.setString(1, modelo_nuevo.getFecha_registro());
            //ACA SI TOMA TODO EL DATO XQ EL CAMPO EN LA BASE  DE DATOS ES DATETIME
            pr.setString(2, modelo_nuevo.getFecha_registro());
            pr.setString(3, modelo_nuevo.getPlaca());
            pr.setString(4, modelo_nuevo.getTipo_vehiculo());
            pr.setString(5, modelo_nuevo.getTotal_Cobrar());// valor cobrado por le parqueo
            pr.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("ERROR  al registrar vehiculo tabla lavado" + e.getMessage());
        } finally {
            getDesconectar();
        }

        return false;

    }

    public boolean Crud_Tipo_Vehiculo(Modelo_Nuevo modelo_nuevo, int intruccion) {

        try {

            /*
            1) insertar
            2)actualizar
            3)eliminar
             */
            PreparedStatement pr = null;

            String sql_query = "";

            String tabla = constantes.getTabla_tipo_vehiculos();
            switch (intruccion) {

                case 1:
                    sql_query = "INSERT INTO " + tabla + "  VALUES (NULL,?,?)";
                    break;
                case 2:
                    sql_query = "UPDATE  " + tabla + " SET NOMBRE=?, PRECIO_HORA =?  WHERE ID_TIPO_VEHICULO =?";
                    break;
                case 3:
                    sql_query = "DELETE FROM  " + tabla + "  WHERE ID_TIPO_VEHICULO =?";
                    break;

            }

            pr = getConnection().prepareStatement(sql_query);

            if (intruccion == 1 || intruccion == 2) {
                pr.setString(1, modelo_nuevo.getTipo_vehiculo());
                pr.setString(2, modelo_nuevo.getPrecio_hora());

                if (intruccion == 2) {

                    pr.setString(3, modelo_nuevo.getCodigo());
                }

            } else {
                pr.setString(1, modelo_nuevo.getCodigo());
            }

            pr.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println("error Metodo , insertar,actualizar, eliminar  tipo de vehiculo " + e.getMessage());
        }

        return false;
    }

    public boolean Cargar_Tabla_Ingresos(Modelo_Nuevo modelo_nuevo, int filtrar_fecha) {

        PreparedStatement pr = null;
        ResultSet resultado = null;
        String sql_query = "SELECT  ID_INGRESOS,FECHA_REGISTRO,PROPIETARIO,PLACA,TIPO_VEHICULO,MOTIVO,PRECIO_LAVADO,PRECIO_PARQUEO FROM  " + constantes.getTabla_autos_ingresos();

        //0: filtrar por fecha
        //1: no haga nada, filtrar todos los dats
        if (filtrar_fecha == 0) {
            sql_query += "  WHERE  DATE_REGISTRO BETWEEN  '" + modelo_nuevo.getFecha__String_Inicio() + "'   AND '" + modelo_nuevo.getFecha__String_Final() + "'  ";
        }

        try {
            pr = getConnection().prepareStatement(sql_query + " ORDER BY FECHA_REGISTRO DESC");
            resultado = pr.executeQuery();
            modelo_nuevo.setResulset_Datos(resultado, 1); // le paso el resultSet al modeo , haya hay un metodo que contruye la tabla 
            return true;

        } catch (SQLException ex) {

            System.out.println("erro al cargar tbla ingresos " + ex.getMessage());

        }

        return false;

    }

    public boolean Numero_Vehiculos_Ingresados(Modelo_Nuevo modelo_nuevo) {

        /*
        Este metodo solo es llamado despues de haber iniciado sesión de manera correcta,
        es para traer el numero total de vehiculos ingresados actualmente y ese valor ubicarlo en el btn
        que esta en la barra de estado del menu principal.
        Tomo como referencia cualquier campo de la tabla autos ingresos, ya que solo voy a contar los registros.
             
         */
        PreparedStatement pr = null;
        ResultSet resultado = null;

        try {
            pr = getConnection().prepareStatement("SELECT PLACA FROM " + constantes.getTabla_autos_ingresos());
            resultado = pr.executeQuery();
            modelo_nuevo.setResulset_Datos(resultado, 10); // le paso el resultSet al modeo 
            return true;

        } catch (SQLException ex) {

            System.out.println("erro al cargar tbla ingresos " + ex.getMessage());

        }

        return false;

    }

    public boolean Cargar_Tabla_Tipo_Vehiculo(Modelo_Nuevo modelo_nuevo) {

        PreparedStatement pr = null;
        ResultSet resultado = null;

        String sql_query = "";

        sql_query = "SELECT * FROM " + constantes.getTabla_tipo_vehiculos();

        try {

            pr = getConnection().prepareStatement(sql_query);
            resultado = pr.executeQuery();
            modelo_nuevo.setResulset_Datos(resultado, 2); // le paso el resultSet al modeo , haya hay un metodo que contruye la tabla

            return true;

        } catch (SQLException ex) {

            System.out.println("error al cargar tabl tipo de vehiculo u autos retirados " + ex.getMessage());

        }

        return false;

    }

    public boolean Actulizar_Datos_Ingreso_Vehiculo(Modelo_Nuevo modelo_nuevo) {

        PreparedStatement pr = null;
        ResultSet resultado = null;

        String sql_query = "UPDATE " + constantes.getTabla_autos_ingresos() + "   SET PROPIETARIO =? ,PLACA=?,TIPO_VEHICULO=? ,MOTIVO=?, PRECIO_LAVADO=?,PRECIO_PARQUEO=? ,PRECIO_HORA=?  WHERE ID_INGRESOS=?";
        try {

            pr = getConnection().prepareStatement("SELECT PRECIO_HORA FROM " + constantes.getTabla_tipo_vehiculos() + " WHERE NOMBRE=?");
            pr.setString(1, modelo_nuevo.getTipo_vehiculo());

            resultado = pr.executeQuery();

            if (resultado.next()) {

                modelo_nuevo.setPrecio_hora(resultado.getString("PRECIO_HORA"));

            }
            //####SEGUNDA CONSULTA######################################################################

            pr = getConnection().prepareStatement(sql_query);
            pr.setString(1, modelo_nuevo.getPropietario());
            pr.setString(2, modelo_nuevo.getPlaca());
            pr.setString(3, modelo_nuevo.getTipo_vehiculo());
            pr.setString(4, modelo_nuevo.getMotivo_Ingreso());
            pr.setString(5, modelo_nuevo.getPrecio_lavado());
            pr.setString(6, modelo_nuevo.getPrecio_parqueo());

            pr.setString(7, modelo_nuevo.getPrecio_hora());
            pr.setString(8, modelo_nuevo.getCodigo());
            pr.executeUpdate();

            return true;

        } catch (SQLException ex) {

            System.out.println("error al actualizar los datos del vehiculo " + ex.getMessage());

        }

        return false;

    }

    public boolean Consultar_Cedula(Modelo_Nuevo modelo_nuevo) {

        try {
            PreparedStatement pr = null;
            ResultSet resultado = null;
            pr = getConnection().prepareStatement("SELECT CEDULA FROM " + constantes.getTabla_usuarios() + " WHERE  CEDULA =?");
            pr.setString(1, modelo_nuevo.getCedula());

            resultado = pr.executeQuery();
            if (resultado.next()) {

                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al consultar la cedula " + e.getMessage());
        }

        return false;
    }

    public boolean Cargar_Tabla_Usuario(Modelo_Nuevo modelo_nuevo) {

        try {
            PreparedStatement pr = null;
            ResultSet resultado = null;

            pr = getConnection().prepareStatement("SELECT  * FROM " + constantes.getTabla_usuarios());
            resultado = pr.executeQuery();

            modelo_nuevo.setResulset_Datos(resultado, 4);
            return true;

        } catch (Exception e) {

            System.out.println("fallo al listar tabla usuarios " + e.getMessage());
        }

        return false;
    }

    public boolean Configura_Usuario(Modelo_Nuevo modelo_nuevo, boolean operacion) {////

        try {

            PreparedStatement pr = null;

            // true: upodate
            //false: delete
            String sql_consulta = "UPDATE  " + constantes.getTabla_usuarios() + " SET TIPO_CUENTA= ?";

            if (!operacion) {
                sql_consulta = "DELETE  FROM " + constantes.getTabla_usuarios();

            }
            pr = getConnection().prepareStatement(sql_consulta + "  WHERE ID_USUARIO =? ");

            int numero = 1;
            if (operacion) {

                pr.setString(numero, modelo_nuevo.getTipo_cuenta());
                numero++;
            }

            pr.setString(numero, modelo_nuevo.getCodigo());

            pr.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("erro al configurar usuarios....." + e.getMessage());
        } finally {
            getDesconectar();
        }

        return false;
    }

    public boolean Cargar_Combos_Colores(Modelo_Colores modelo_colores) {

        try {

            PreparedStatement pr = null;
            ResultSet resultado = null;

            pr = getConnection().prepareStatement("SELECT Nombre_Color FROM " + constantes.getColores());
            resultado = pr.executeQuery();

            modelo_colores.setResultado_Colores(resultado, 1);

            return true;

        } catch (Exception e) {
            System.out.println("error al llenar combo colores: " + e.getMessage());
        }

        return false;
    }

    public boolean Inicializar_Nombre_Funciones(Modelo_Colores modelo_colores) {

        try {

            PreparedStatement pr = null;
            ResultSet resultado = null;

            pr = getConnection().prepareStatement("SELECT * FROM " + constantes.getColores_nombres_funciones());
            resultado = pr.executeQuery();
            modelo_colores.setResultado_Colores(resultado, 2);
            return true;

        } catch (Exception e) {
            System.out.println("error al traer nombres colores funciones : " + e.getMessage());
        }

        return false;

    }

    public boolean Actualizar_Colores_Nombres_Funciones(Modelo_Colores modelo_colores, int operacion) {

        try {
            //0: actualizat textos
            //1: fondos 
            //2: bordes

            PreparedStatement pr = null;
            String sql_consultar = "UPDATE " + constantes.getColores_nombres_funciones() + " SET";

            int num_parametro = 0;
            switch (operacion) {

                case 0:
                    sql_consultar += " TEXTO_MENU = ? , TEXTO_SUBMENU = ?,TEXTO_EMPRESA = ? ";

                    break;
                case 1:
                    sql_consultar += " FONDO_PANTALLA = ? ,FONDO_BARRA_MENU = ?,FONDO_BARRA_HERRAMIENTAS  = ?,"
                            + " FONDO_BARRA_ESTADO = ?, FONDO_FUN_BTN_HERRAMIENTAS = ?, FONDO_FUN_BTN_ESTADO = ? ";
                    break;
                case 2:
                    sql_consultar += " BORDE_HERRAMIENTAS = ? , BORDE_ESTADO = ? ";
                    break;

            }

            pr = getConnection().prepareStatement(sql_consultar + " WHERE ID_FUNCIONES =?");

            switch (operacion) {

                case 0:
                    num_parametro++;
                    pr.setString(num_parametro, modelo_colores.getColor_txt_menu());
                    num_parametro++;
                    pr.setString(num_parametro, modelo_colores.getColor_text_submenu());
                    num_parametro++;
                    pr.setString(num_parametro, modelo_colores.getColor_text_empresa());

                    break;
                case 1:
                    num_parametro++;
                    pr.setString(num_parametro, modelo_colores.getColor_fondo_pantalla());
                    num_parametro++;
                    pr.setString(num_parametro, modelo_colores.getColor_fondo_barra_menu());
                    num_parametro++;
                    pr.setString(num_parametro, modelo_colores.getColor_fondo_barra_herramientas());

                    num_parametro++;
                    pr.setString(num_parametro, modelo_colores.getColor_fondo_barra_estado());
                    num_parametro++;
                    pr.setString(num_parametro, modelo_colores.getColor_fun_barra_herramientas());
                    num_parametro++;
                    pr.setString(num_parametro, modelo_colores.getColor_fun_barra_estado());

                    break;

                case 2:
                    num_parametro++;
                    pr.setString(num_parametro, modelo_colores.getColor_borde_barra_herramientas());
                    num_parametro++;
                    pr.setString(num_parametro, modelo_colores.getColor_borde_barra_estado());
                    break;

            }
            num_parametro++;
            pr.setString(num_parametro, "1");
            pr.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("error al actulizar los colores crud primero " + e.getMessage());
        }
        return false;

    }

    public boolean Generar_Color(Modelo_Colores modelo_Colores) {

        try {

            PreparedStatement pr = null;
            ResultSet resultado = null;

            pr = getConnection().prepareStatement("SELECT Rojo,Verde,Azul FROM " + constantes.getColores() + " WHERE Nombre_Color= ?");

            pr.setString(1, modelo_Colores.getNombre_Color());

            resultado = pr.executeQuery();

            if (resultado.next()) {

                modelo_Colores.Valor_Colores(resultado.getInt("Rojo"), resultado.getInt("Verde"), resultado.getInt("Azul"));

            }
            return true;

        } catch (Exception e) {
            System.out.println("error al intentar traer los datos para el color crud primero");
        }
        return false;

    }

    public boolean Nombres_Menus_Items(Modelo_Sistema modelo_sistema) {

        try {
            PreparedStatement pr = null;
            ResultSet resultado = null;

            pr = getConnection().prepareStatement("SELECT * FROM " + constantes.getTabla_sistema());

            resultado = pr.executeQuery();

            modelo_sistema.setResultado_Datos(resultado);
            return true;

        } catch (Exception e) {
        }

        return false;

    }

    public boolean Actualizar_Datos_Sistema(Modelo_Sistema modelo_sistema) {

        try {
            PreparedStatement pr = null;

            pr = getConnection().prepareStatement("UPDATE " + constantes.getTabla_sistema() + " SET MENU_INICIO =?, MENU_FUNCIONES =?,"
                    + " MENU_CONFIGURACION = ?, MENU_SISTEMA = ?, MENU_RESPALDOS = ?, TITULO = ?, LETRA_FAMILIA = ?, ESTILO =? ,"
                    + " TAMANO =? WHERE ID_NOMBRE = ?");

            pr.setString(1, modelo_sistema.getMenu_inicio());
            pr.setString(2, modelo_sistema.getMenu_funciones());
            pr.setString(3, modelo_sistema.getMenu_configuracion());
            pr.setString(4, modelo_sistema.getMenu_sistema());
            pr.setString(5, modelo_sistema.getMenu_respaldos());
            pr.setString(6, modelo_sistema.getTitulo());
            pr.setString(7, modelo_sistema.getTipo_letra());
            pr.setString(8, modelo_sistema.getEstilo_Crud_Apoyo());
            pr.setString(9, String.valueOf(modelo_sistema.getTamano_fuente()));
            pr.setString(10, "1");
            pr.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("error al actualizar los nombres de los menus");
        }

        return false;

    }

    public boolean Validar_Reportes(Modelo_Nuevo modelo_nuevo, int elegir_tabla, boolean seleccionFecha) {

        PreparedStatement pr = null;
        ResultSet resultado = null;
        String tabla = "SELECT PLACA FROM ";
        String queyFiltrar = "";

        switch (elegir_tabla) {

            case 0:
                tabla += constantes.getTabla_autos_ingresos();
                queyFiltrar = " WHERE  DATE_REGISTRO  ";

                break;

            case 1:
                tabla += constantes.getTabla_autos_salidos();
                queyFiltrar = " WHERE  SALIDA_DATE  ";

                break;

            case 2:
                tabla += constantes.getTabla_lavado();
                queyFiltrar = " WHERE  FECHA_DATE  ";
                break;

            case 3:
                tabla += constantes.getTabla_lavado_Mas_Parqueo();
                queyFiltrar = " WHERE  SALIDA_DATE  ";
                break;
        }

        if (seleccionFecha) {
            //filtrar  por fecha vehiculos ingresados y retirados(parqueo, lavado, parqueo + lavado)

            tabla += queyFiltrar + " BETWEEN   '" + modelo_nuevo.getFecha__String_Inicio() + "'  AND '" + modelo_nuevo.getFecha__String_Final() + "'  ";

        }

        try {
            pr = getConnection().prepareStatement(tabla);

            resultado = pr.executeQuery();

            if (resultado.next()) {
                return true;

            }

        } catch (SQLException ex) {

            System.out.println("error al valdiar el reporte" + ex.getMessage());

        }

        return false;

    }

    public void Graficar_Estadisticas(Modelo_Nuevo modelo_Nuevo) {

        try {

            //Este metodo se encarga de ejecutar la consulta para graficar las estadisticas, 
            // en el modelo ya preparo todo para el quey , aqui solo ejecuto eso, y le paso al modelo 
            // el reulset para haya en el modeo graficas las estadisticas
            PreparedStatement pr = null;
            ResultSet resultado = null;
            String query_consulta = modelo_Nuevo.getGenerar_Quey_Graficar();

            pr = getConnection().prepareStatement(query_consulta);
            resultado = pr.executeQuery();
            //5 llamo a un metodo que se encarga de graficar
            modelo_Nuevo.setResulset_Datos(resultado, 5);

        } catch (Exception e) {

            System.out.println("erro al ejecutar el query graficar: " + e.getMessage());
        }

    }

    public boolean Cargar_Tabla_Lavado(Modelo_Nuevo modelo_Nuevo, boolean filtrar_fecha, int selectTabla) {

        try {

            PreparedStatement pr = null;
            ResultSet resultado = null;

            String sql_query = "SELECT * FROM ";
            String nameFecha = " WHERE  SALIDA_DATE";
            String fecha_ordenar = " FECHA_SALIDA DESC";

            /*
             
             3: tabla salidos parqueo
             6:tabla salidos lavado
             7: tabla salidos lavado + parqueo
             */
            switch (selectTabla) {

                case 3:
                    sql_query += constantes.getTabla_autos_salidos();

                    break;
                case 6:
                    sql_query += constantes.getTabla_lavado();
                    nameFecha = "  WHERE FECHA_DATE";
                    fecha_ordenar = " FECHA_REGISTRO DESC";
                    break;

                case 7:
                    sql_query += constantes.getTabla_lavado_Mas_Parqueo();
                    fecha_ordenar = " FECHA_SALIDA DESC";
                    break;

            }

            if (filtrar_fecha) {

                sql_query += nameFecha + " BETWEEN  '" + modelo_Nuevo.getFecha__String_Inicio() + "' AND '" + modelo_Nuevo.getFecha__String_Final() + "' ";
            }

            pr = getConnection().prepareStatement(sql_query + " ORDER BY " + fecha_ordenar);
            resultado = pr.executeQuery();
            modelo_Nuevo.setResulset_Datos(resultado, selectTabla);
            return true;

        } catch (Exception e) {
            System.out.println("error  cargar  ene l metodo que genera las 3 tablas de salidas " + e.getMessage());
        }
        return false;

    }

}
