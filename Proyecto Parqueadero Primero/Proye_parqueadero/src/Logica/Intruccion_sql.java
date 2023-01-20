package Logica;

import Conexion.Conectar_base;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import javax.swing.*;

import static javax.swing.JOptionPane.*;

public class Intruccion_sql {

    private ArrayList lista;

    public Intruccion_sql() {
        cn = new Conectar_base();
        pr = null;
        resultado = null;
        lista = new ArrayList();

    }

    public int setInsertar(String cedula, String nombre, String apellido, String telefono, String domicilio, String correo, String usuario, String pass, String tipo_usuario, int elegir, String estado_2, String parame_cedu) {
        String sql_insertar = null;
        switch (elegir) {
            case 1:
                sql_insertar = "UPDATE usuarios  SET Estado= '" + estado_2 + "' WHERE Cedula = '" + parame_cedu + "'";
                break;
            case 2:
                sql_insertar = "INSERT INTO usuarios VALUES(?,?,?,?,?,?,?,?,?,?)";
                break;
            case 3:
                sql_insertar = "DELETE FROM usuarios WHERE Cedula = '" + parame_cedu + "'";
                break;
            default:
                break;
        }

        int res = 0;

        try {

            /// (Cedula,Nombres,Apellidos,Telefono,Direccion,Correo_electronico,Usuario,Contrasena,Tipo_Usuario)
            pr = cn.getConnection().prepareStatement(sql_insertar);

            if (elegir == 2) {
                pr.setString(1, cedula);
                pr.setString(2, nombre.toUpperCase());
                pr.setString(3, apellido.toUpperCase());
                pr.setString(4, telefono);
                pr.setString(5, domicilio.toUpperCase());
                pr.setString(6, correo);
                pr.setString(7, usuario);
                pr.setString(8, pass);
                pr.setString(9, tipo_usuario);
                pr.setString(10, "AC"); /// estado
            }

            pr.executeUpdate();
            res = 1;

        } catch (Exception e) {
            showMessageDialog(null, "no se pudo  crear usuario  " + e.getMessage());
            ///System.out.println("no se pudo  crear usuario  " + e.getMessage());

        } finally {
            cn.getDesconectar();
            pr = null;
        }

        return res;
    }

    public int Ingresar(String usuario, String pass, String Tipo_Usuario) {
        String ingresar = "SELECT  Usuario,Contrasena,Tipo_Usuario FROM usuarios  Where Usuario =? and Contrasena =? and Tipo_Usuario =? and Estado = 'AC'";
        int ret = 0;
        try {
            pr = cn.getConnection().prepareStatement(ingresar);
            pr.setString(1, usuario);
            pr.setString(2, pass);
            pr.setString(3, Tipo_Usuario);
            resultado = pr.executeQuery();

            if (resultado.next()) {

                ///ESTO AYUDA A VALIDAR QUE EL USUARIO ESTE ESCRITO TAL Y COMO ESTE,  DIFERENCIA MAYUSCULAS Y MINUSCULAS
                //YA QUE TENIA EL PROBLEMA QUE  EL USUARIO O LA CONTRASEÑA PODIAN ESCRIBIRLA EN MAYUSCULAS Y MINUSCULA , E IGUAL 
                //INGRESABA.
                if (usuario.equals(resultado.getString("Usuario")) && pass.equals(resultado.getString("Contrasena"))) {
                    ret = 1;
                }

            }

        } catch (Exception e) {
            showMessageDialog(null, "Error al ingresar " + e.getMessage());

            //System.out.println("Error al ingresar " + e.getMessage());
        } finally {

            cn.getDesconectar();
            pr = null;
            resultado = null;
        }

        return ret;
    }

    public void setIngresar_vehiculo(String placa, String nombre, String tipo_vehiculo, boolean act_ingres, JDialog dialo, int actu_ya_ingresado, String otra_pla_comofe) {
        String sql_insertar = "";

        ///////Obtener la fecha////////////////////////////
        Calendar calendario = Calendar.getInstance();
        java.util.Date fecha = calendario.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy   hh:mm:ss a");
        String fecha_registro = dateFormat.format(fecha);

        //////////// Separar datos de fecha y hora en variables/////////////////////////////////
        int anno = calendario.get(Calendar.YEAR);
        int mes = (calendario.get(Calendar.MONTH) + 1);
        int dia = calendario.get(Calendar.DATE);
        int hora_ac = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);

        Date fecha_enviar = new Date(anno - 1900, mes - 1, dia);
        double cobrar = 0.00;
        String cancelar = "NO";
        String sms = "Vehiculo Ingresado Correctamente";

        //////////// Hacer un Update o un Insert ///pregunta de control
        if (act_ingres) {
            sql_insertar = "Insert Into autos_ingreso  Values(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        } else {

            switch (actu_ya_ingresado) {

                case 0:
                    sql_insertar = "UPDATE  autos_ingreso   SET Fecha_Date = '" + fecha_enviar + "' , Fecha_Ingreso = '" + fecha_registro + "',Agno ='" + anno + "',Mes= '" + mes + "', Dia = '" + dia + "', Hora_Entrada ='" + hora_ac + "',Minutos = '" + minutos + "' ,Total_Cobrar= '" + cobrar + "',Segundos = '" + segundos + "',Pagado = '" + cancelar + "'  Where Placa =?";
                    /// sms = "Ingreso Actulizado";
                    break;

                case 1:

                    sql_insertar = "SELECT  Placa,Nombre_Propietario,Tipo_Vehiculo,Fecha_Ingreso FROM autos_ingreso WHERE Placa =? AND Pagado ='NO'";

                    break;

                case 3:
                    sql_insertar = "UPDATE   autos_ingreso   SET Placa = '" + otra_pla_comofe + "',Nombre_Propietario = '" + nombre + "', Tipo_Vehiculo = '" + tipo_vehiculo + "' WHERE Fecha_Ingreso =? ";

                    sms = "Datos Actulizados Correctamente";
                    /*
                    El paramentro de la clausula where en este caso (3) va hacer la fecha que ingreso, 
                     */
                    break;
            }

        }

        try {

            pr = cn.getConnection().prepareStatement(sql_insertar);
            if (act_ingres) {
                pr.setString(1, placa);
                pr.setString(2, nombre);
                pr.setString(3, tipo_vehiculo);
                pr.setDate(4, fecha_enviar);
                pr.setString(5, fecha_registro);
                pr.setInt(6, anno);
                pr.setInt(7, mes);
                pr.setInt(8, dia);
                pr.setInt(9, hora_ac);
                pr.setInt(10, minutos);
                pr.setInt(11, segundos);
                pr.setDouble(12, cobrar);
                pr.setString(13, cancelar);

            } else {
                pr.setString(1, placa);

            }

            if (actu_ya_ingresado != 0 && actu_ya_ingresado != 3) {

                resultado = pr.executeQuery();
                while (resultado.next()) {
                    nombre_propietario = resultado.getString("Nombre_Propietario");
                    tipo_vehi = resultado.getString("Tipo_Vehiculo");

                    return_placa = resultado.getString("Placa");
                    fecha_in = resultado.getString("Fecha_Ingreso");

                }

            } else {
                int r = pr.executeUpdate();
            }

            if (actu_ya_ingresado == 0 || actu_ya_ingresado == 3) {
                showMessageDialog(dialo, sms, " Sistema de Parqueo", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/Image_Sms/vehiculo_ingresado_cor.png"));
            }

        } catch (Exception e) {
            showMessageDialog(dialo, "¡Sucedio un error! , no se pudo guardar el registro" + e.getMessage(), "Sistema de Parqueo", -1, null);

        } finally {
            cn.getDesconectar();
            pr = null;
        }

    }

    public int Retirar_Vehiculo(String placa) {

        //   String consu_agrupar_grafico="SELECT Tipo_Vehiculo ,SUM() FROM autos_ingreso GROUP BYTipo_Vehiculo WHERE Pagado='NO' ";
        String seleccionar = "SELECT Nombre_Propietario,Tipo_Vehiculo,Fecha_ingreso,Agno,Mes,Dia,Hora_Entrada,Minutos  FROM autos_ingreso Where Placa =?";
        String sele_valor_tabla_ve = "SELECT  Valor_Vahiculo From tipo_de_vehiculo WHERE Nombre_Vehiculo =?";

        int re = 0;

        try {
            pr = cn.getConnection().prepareStatement(seleccionar);
            pr.setString(1, placa);
            resultado = pr.executeQuery();

            while (resultado.next()) {// aqui cambie antes estaba el if

                //////////////////// ///Traer hora de ingreso ///////////////////////////////////
                Calendar hora_ingreso = Calendar.getInstance();
                int rr = resultado.getInt("Mes") - 1;

                hora_ingreso.set(resultado.getInt("Agno"), rr, resultado.getInt("Dia"), resultado.getInt("Hora_Entrada"), resultado.getInt("Minutos"));
                /////////////HOra de salida/////////////////////////
                Calendar hora_salida = Calendar.getInstance();

                long h_ingreso = hora_ingreso.getTimeInMillis();
                long h_salida = hora_salida.getTimeInMillis();

                dias = (int) (Math.abs(h_salida - h_ingreso) / (1000 * 60 * 60 * 24));
//                System.out.println( dias +"  ");
                minutos = (int) (Math.abs(h_salida - h_ingreso) / (1000 * 60));

                while (minutos >= 60) {

                    minutos = minutos - 60;
                    horas += 1;

                }

                total_en_horas = horas; /// total en horas // horas despues mas abajo lo transformo en dias si pasa de 24 horas
//                
//                System.out.println(horas);

                ////Asignación de valores ////////////////////////
                nombre_propietario = resultado.getString("Nombre_Propietario");
                tipo_vehi = resultado.getString("Tipo_Vehiculo");
                fecha_in = resultado.getString("Fecha_ingreso");
            }
            //////////Traer el precio del vehiculo de la tabla_vehiculos
            /*
              hago primero  una consulta para traer todos los datos , y de hay traigo el  tipo de vehiculo y
             con ese dato hago otra consulta a la tabla_tipo_vehiculos para traer solo el precio del vehiculo
             */

            ///Consulta a la tabla Vehiculos
            resultado = null;
            pr = cn.getConnection().prepareStatement(sele_valor_tabla_ve);
            pr.setString(1, tipo_vehi);
            resultado = pr.executeQuery();

            if (resultado.next()) {

                costo_vehiculo = resultado.getDouble("Valor_Vahiculo"); //traer  el valor del auto 

                if (horas == 0 && minutos <= 60) {
                    total_cobrar = costo_vehiculo;
                } else if (horas != 0 && (minutos <= 10)) {
                    total_cobrar = costo_vehiculo * horas;
                } else if (horas != 0 && (minutos > 10 || minutos <= 40)) {
                    total_cobrar = (costo_vehiculo * horas) + (costo_vehiculo / 2);
                } else if (horas != 0 && minutos > 40) {
                    total_cobrar = (costo_vehiculo * horas) + costo_vehiculo;
                }

            }

            while (horas >= 24) {
                horas -= 24;
            }

            re = 1;
        } catch (Exception e) {
            System.out.println("No se pudo buscar la placa...  " + e.getMessage());
        } finally {
            cn.getDesconectar();
            pr = null;
            resultado = null;
        }
        return re;

    }

    public int setActualizar_estado_ingreso(String placa, String estado, double cobrar, int oper, java.sql.Date fecha_de_cancelacion, String fecha_cance, String fecha_ingreso_2, String tipo_vehiculo, String nombre_propietario, int hora, int minutos, int segundos) {
        int re = 0;

        String actu_estado = "";

        switch (oper) {
            case 1:
                actu_estado = "Update  autos_ingreso  SET Total_Cobrar = '" + cobrar + "',Pagado ='" + estado + "'   Where Placa =?";
                break;
            case 2:
                actu_estado = "Update  usuarios  SET Contrasena = '" + estado + "'  Where Usuario =?";
                break;
            case 3:
                actu_estado = "INSERT INTO  autos_cancelados VALUES (null,?,?,?,?,?,?,?,?,?)";
                break;
            default:
                break;
        }

        try {
            pr = cn.getConnection().prepareStatement(actu_estado);

            pr.setString(1, placa);
            if (oper == 3) {

                pr.setString(2, nombre_propietario);
                pr.setString(3, tipo_vehiculo);
                pr.setString(4, fecha_ingreso_2);
                pr.setString(5, fecha_cance);
                pr.setDate(6, fecha_de_cancelacion);
                pr.setInt(7, hora);
                pr.setInt(8, minutos);
                pr.setInt(9, segundos);

            }
            re = pr.executeUpdate();

        } catch (Exception e) {

            showMessageDialog(null, "    Erro al actualizar  " + e.getMessage());
        } finally {
            cn.getDesconectar();
            pr = null;
        }
        return re;
    }

    public int setIngresar_vehiculo_Adminis(boolean eliminar, Date fecha_sql, int hora_salida, int minuto_salida, int segundos_salida, int opc_elim, String placa, String nombre, String tipo_vehiculo, double costo, String fecha_ingreso, String fecha_salida, int dia, int horas, int minu, int to_horas, double total_cobrado) {
        String sql_insertar = "";
        int retu = 0;
        if (eliminar) {

            /////JDIALODO TABLA SALIDA ///
            if (opc_elim == 1) { //Elimina todos los datos de la tabla salida
                sql_insertar = "DELETE FROM auto_salida ";

            } else if (opc_elim == 2) { //Elimina un solo   dato de la tabla salida
                sql_insertar = "DELETE FROM auto_salida WHERE Placa =?";
            }

        } else {
            sql_insertar = "Insert Into auto_salida Values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ///(Placa,Nombre_Propietario,Tipo_Vehiculo,Costo_Vehiculo,Fecha_Ingreso,Fecha_Salida,Total_Dias,Total_Horas,Total_Minutos,Tota_en_Horas,Total_Cobrar)

        }

        try {

            ////////////////////////////////////////
            pr = cn.getConnection().prepareStatement(sql_insertar);
            if (opc_elim == 2) {
                pr.setString(1, placa);
            }

            if (!eliminar) {

                ///pr.setString(1, placa);
                pr.setString(1, placa);
                pr.setString(2, nombre);
                pr.setString(3, tipo_vehiculo);
                pr.setDouble(4, costo);
                pr.setDate(5, fecha_sql);
                pr.setInt(6, hora_salida);
                pr.setInt(7, minuto_salida);
                pr.setInt(8, segundos_salida);

                pr.setString(9, fecha_ingreso);
                pr.setString(10, fecha_salida);
                pr.setInt(11, dia);
                pr.setInt(12, horas);
                pr.setInt(13, minu);
                pr.setInt(14, to_horas);
                pr.setDouble(15, total_cobrado);
            }

            retu = pr.executeUpdate();

        } catch (Exception e) {
            ///showMessageDialog(null, "No se pudo guardar  tabla autos_salida " + e.getMessage());
            //cada que lo llamo a este metodo trato con un sms  la excepcion que puede dar , x eso lo comente aqui

        } finally {
            cn.getDesconectar();
            pr = null;
        }
        return retu;

    }

    public int setPlaca_Cancelada(String placa, boolean elegir) {

        String placa_pagada = "";
        String parametro = "Placa =?";

        if (!elegir) {
            parametro = "Tipo_Vehiculo=?  AND Pagado= 'NO'";
        }

        placa_pagada = "SELECT  Placa,Pagado,Nombre_Propietario,Tipo_Vehiculo  FROM autos_ingreso WHERE " + parametro;

        int verificar = 0;
        try {

            pr = cn.getConnection().prepareStatement(placa_pagada);
            pr.setString(1, placa);
            resultado = pr.executeQuery();

            if (resultado.next()) {
                if (elegir) {
                    boolean estado = resultado.getString("Pagado").equals("SI");

                    if (estado) {
                        verificar = 1;
                    } else {
                        verificar = 2;
                    }

                    nombre_propietario = resultado.getString("Nombre_Propietario");
                    tipo_vehi = resultado.getString("Tipo_Vehiculo");
                } else {

                    verificar = 1;
                }

            }

        } catch (Exception e) {
            showMessageDialog(null, "Erro al controlar  placa cancelada " + e.getMessage());
            //System.out.println("Erro al controlar  placa cancelada " + e.getMessage());
        } finally {

            cn.getDesconectar();
            pr = null;
            resultado = null;

        }
        return verificar;
    }

    public boolean getCedula_Existe(String parametro, int elegir, String pregu_cuen_activa) { //consulta si la cedula o si el correo o si el usuario ya existe
        boolean validar = false;

        String opciones_correo_cue_activa = "Correo_electronico,Estado,Contrasena ";
        String cedula_correo = "";
        switch (elegir) {
            case 1:
                cedula_correo = "SELECT Cedula FROM  usuarios WHERE Cedula =?";
                break;
            case 2:
                if (pregu_cuen_activa.equals("")) {

                    opciones_correo_cue_activa = "Correo_electronico ";
                }
                cedula_correo = "SELECT  " + opciones_correo_cue_activa + " FROM usuarios  WHERE Correo_electronico =? ";
                ///cedula_correo = "SELECT Correo_electronico FROM usuarios  WHERE Correo_electronico =? '" + correo_cuenta_activa + "'";
                break;
            case 3:

                cedula_correo = "SELECT Usuario FROM usuarios  WHERE Usuario =? ";
                break;

            case 4:
                cedula_correo = "SELECT Placa FROM autos_ingreso "; /// Se Instancia desde el JTextfiel del JDialog Salida y desde el JDialog Ingreso
                break;
            default:

                break;
        }

        try {

            pr = cn.getConnection().prepareStatement(cedula_correo);
            if (elegir != 4) {
                pr.setString(1, parametro);
            }
            resultado = pr.executeQuery();

            while (resultado.next()) {
                validar = true;
                if (elegir == 4) {
                    lista.add(resultado.getString("Placa"));
                }
                if (elegir == 2 && !pregu_cuen_activa.isEmpty()) {
                    String estado = resultado.getString("Estado");
                    nombre_propietario = resultado.getString("Contrasena"); // este es una variable que la utizon en otro metodo
                    //pero la utlize aqui   para no crear otra variable

                    if (estado.equals("AC")) {
                        estado_recu_contra = true;

                    }

                }

            }

        } catch (Exception e) {
            showMessageDialog(null, "Erro al verificar  : clase , Intru_sql , metodo getCedula_Existe " + e.getMessage());

        } finally {
            cn.getConnection();
            pr = null;
        }

        return validar;
    }

    ////////////////METODO PARA LA TABLA TIPO DE VEHICULO///////////////////////////////////////////////
    public int sql_Tabla_Tipo_Vehiculos(JComboBox combo_tipo_vehi, String nombre, double valor, boolean opera, int estado) {

        int rene = 0;
        String sq_seleccionar_tipo = "";
        /////////////Si le  pasamos False  ,  podra hacer un update, delete o un insert///////////////////////////////////
        if (opera) {

            switch (estado) {
                case 1:
                    sq_seleccionar_tipo = "SELECT Nombre_Vehiculo FROM tipo_de_vehiculo";
                    break;
                case 2:
                    sq_seleccionar_tipo = "SELECT Nombre_Vehiculo FROM tipo_de_vehiculo WHERE  Nombre_Vehiculo =?";
                    break;

            }

        } else {
            switch (estado) {

                case 1:
                    sq_seleccionar_tipo = "INSERT INTO tipo_de_vehiculo  VALUES(?,?)";

                    break;

                case 2:
                    sq_seleccionar_tipo = "UPDATE  tipo_de_vehiculo  SET Valor_Vahiculo='" + valor + "' WHERE Nombre_Vehiculo =?";

                    break;
                case 3:
                    sq_seleccionar_tipo = "DELETE FROM tipo_de_vehiculo  WHERE Nombre_Vehiculo =?";

                    break;

                default:
                    System.out.println("OPeracion  incorrecta...............");
                    break;

            }

        }

        try {
            pr = cn.getConnection().prepareStatement(sq_seleccionar_tipo);

            if (opera) {

                if (estado == 2) {
                    pr.setString(1, nombre);

                }
                resultado = pr.executeQuery();

            } else if (!opera) {
                if (estado == 1) {
                    pr.setString(1, nombre);
                    pr.setDouble(2, valor);
                } else if (estado == 2 || estado == 3) {
                    pr.setString(1, nombre);
                }

            }

            if (opera) {

                while (resultado.next()) {
                    if (estado == 1) {
                        combo_tipo_vehi.addItem(resultado.getString("Nombre_Vehiculo"));

                    }

                    rene = 1;

                    ///nombre_propietario = resultado.getString("Nombre_Vehiculo"); // est variable  la tomo asi, para  no crear otra variable, utilzo esta variable
                    //que la utilizo en un metodo de por arriba
                }
               
                

            } else {

                rene = pr.executeUpdate();
                rene = 1;
            }

            if (opera) {
                resultado.close(); /// solo cuando hago un select que limpie  el resultado
            }

        } catch (Exception e) {
            showMessageDialog(null, "no se pudo listar los nombre de vehiculo " + e.getMessage());
            //System.out.println("no se pudo listar los nombre de vehiculo " + e.getMessage());
        } finally {
            cn.getDesconectar();
            pr = null;

        }
        return rene;
    }

    /////////////////////////////Tabla_Tipo de Usuarios/////////////////////////////////////
    //// tambien este metodo lo utilizo para eliminar AUTOS CANCELADOS
    public int Actualizar_Tipo_Usuario(String Tipo_Usuario, boolean elegir, int operacion_eliminar) {

        int ejecutar = 0;
        String sql_consulta = "";

        if (elegir) {
            sql_consulta = "UPDATE tipo_usuario SET  Tipo_Usuario ='" + Tipo_Usuario + "'  WHERE Usuario =?";

        } else {

            switch (operacion_eliminar) {
                case 1:
                    sql_consulta = "DELETE FROM autos_cancelados  WHERE Placa=?";
                    break;

                case 2:
                    sql_consulta = "DELETE FROM autos_cancelados";
                    break;

            }

        }

        try {

            pr = cn.getConnection().prepareStatement(sql_consulta);

            if (elegir) {
                pr.setString(1, "servidor");
            }

            if (!elegir && operacion_eliminar == 1) {
                pr.setString(1, Tipo_Usuario); //el parametro que envio aqui es la placa del auto a eliminar
            }

            ejecutar = pr.executeUpdate();

        } catch (Exception e) {
            showMessageDialog(null, "No se pudo actualizar el registro de tipo_usuario " + e.getMessage());
            // System.out.println("No se pudo actualizar el registro de tipo_usuario " + e.getMessage());
        }

        return ejecutar;

    }

    /////////////////////////METODOS GETTERS //////////////////////////////////////////////////////////////////////////////
    public String getReturn_placa() {
        return return_placa;
    }

    public boolean getEstado_recu_contra() {
        return estado_recu_contra;
    }

    public String getNombre_propietario() {

        return nombre_propietario;
    }

    public String getFecha_in() {
        return fecha_in;
    }

    public String getTipo_vehi() {
        return tipo_vehi;
    }

    public double getCosto_vehiculo() {
        return costo_vehiculo;
    }

    public double getTotal_cobrar() {
        return total_cobrar;
    }

    public String getRetornar_fecha_actual(String fecha_actual) {

        ///////Obtener la fecha////////////////////////////
        Calendar calendario = Calendar.getInstance();
        java.util.Date fecha = calendario.getTime();
        String format_hora = "dd/MM/yyyy";
        if (!fecha_actual.equals("")) {

            format_hora = "dd/MM/yyyy   hh:mm:ss";
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(format_hora);
//        String fecha_registro = dateFormat.format(fecha);

        return dateFormat.format(fecha);
    }

    public int getTotal_en_horas() {
        return total_en_horas;
    }

    public int getDias() {
        return dias;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getHoras() {
        return horas;
    }

    public ArrayList getLista() {
        return lista;
    }

    private Conectar_base cn;
    private PreparedStatement pr;
    private ResultSet resultado;

    private String nombre_propietario = "", fecha_in, tipo_vehi;
    private double costo_vehiculo = 0, total_cobrar = 0;
    private int dias = 0, minutos = 0, horas = 0, total_en_horas = 0;
    // private JLabel hora;
    private String return_placa = "";
    private boolean estado_recu_contra = false;
    private boolean retorno = false;

}
