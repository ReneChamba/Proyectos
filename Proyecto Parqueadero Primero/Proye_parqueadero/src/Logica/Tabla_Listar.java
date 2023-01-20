package Logica;

import Conexion.Conectar_base;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class Tabla_Listar {

    private DefaultTableModel dt;
    private TableRowSorter rowSorter;
    private JTable tabla;
    private Conectar_base cn;
    private PreparedStatement pr;

    private Validacion_txt validar_txt;
    private ResultSet resultado;

    private Intruccion_sql traer_datos;

    public Tabla_Listar(JTable tabla, boolean elegir_tabla, ArrayList lista, int operacion, Date fecha_sql, Date fecha_final, String pregunta, JTextField txt_buscar, String tabla_cancelada) {
        this.tabla = tabla;
        this.txt_buscar = txt_buscar;
        this.elegir_tabla = elegir_tabla;
        this.lista = lista;
        this.pregunta = pregunta;
        this.tabla_cancelada = tabla_cancelada;
        ///////////////////////////////////////////////////////

        /*
        cuando grafique los ingresos actualmente po fecha 
        
         */
        this.fecha_final = fecha_final; // utilzot tambien la fecha que esta abajo , fecha_sql

        //////////////////////////////////////////////////////////////
        /////////Estos dos son cuando aplasto buscar por fecha ////////////
        this.operacion = operacion;
        this.fecha_sql = fecha_sql;

        ///actu_tipo_vehicu= null;
        estados_Contructo(); /// estados compartidos por los dos contructores
        Llenar_tablas_sali_entra(); // metodo que generara las tablas  de ingreso y salida de vehiculos

    }

    public Tabla_Listar(JTable tabla, JTextField txt_buscar, int elegir_tipo_usu) { //Constructor para listar Tabla_Usuarios

        this.tabla = tabla;
        this.txt_buscar = txt_buscar;
        this.elegir_tipo_usu = elegir_tipo_usu;

        estados_Contructo();/// estados compartidos por los dos contructores
        tabla_Usua_Admin();  // metodo que generara la tabla de USUARIO y ADMIN
    }

    private void estados_Contructo() {

        cn = new Conectar_base();
        pr = null;
        resultado = null;
        validar_txt = new Validacion_txt();

    }

    public Tabla_Listar(JTable tabla) { // para la tabla tipo de vehiculo

        this.tabla = tabla;
        estados_Contructo();
        Llenar_tabla_tipo_Vehiculo();
    }

    private void Llenar_tablas_sali_entra() { ///tablas  de ingreso y salida de vehiculos

        try {

            if (pregunta.equalsIgnoreCase("Si")) {

                String icono = "src/Image_2/elimina_1.png";

                int longitud_datos = 8;
                if (tabla != null) {

                    /*
                        valido esto ya que cuando voy a graficar por los autos ingresados actualmente el parametro de txt , le  paso  es null,  entonces  valido que
                        solo cuando le pase un objeto de tipo JTIELDS HAGA lo de abjo el KEYlISTENER , CASO CONTRARIO  NO HAGA NADA y no me arroje un error
                    
                        valido esto ya que cuando voy a graficar por los autos ingresados actualmente el parametro de  tabla el parametro que le  paso  es null,  entonces  valido que
                        solo cuando le pase un objeto de tipo JTABLE  HAGA lo d abajo , CASO CONTRARIO  NO HAGA NADA y no me arroje un error
                            
                    
                     */
                    dt = new DefaultTableModel() {

                        public boolean isCellEditable(int filas, int columnas) {
                            return false;
                        }
                    };
                    dt.addColumn("#");
                    dt.addColumn("Placa");
                    dt.addColumn("Propietario");
                    dt.addColumn("Tipo Vehiculo");
                    if (elegir_tabla) { /// campos para la tabla_ingreso  
                        /*
                    
                     encabezado para las tabla_ingreso y autos cancelados
                         */

                        dt.addColumn("Fecha_Ingreso");
                        if (tabla_cancelada.equals("")) {
                            icono = "src/Image_2/cobrar.png";
                            dt.addColumn("Pagado");
                            dt.addColumn("Total_Cobrar");
                            dt.addColumn("Cobrar");

                        } else {
                            dt.addColumn("Fecha_Cancelada");
                            longitud_datos = 6;

                            ///ME conecto a la base para saber que tipo de usuario es , y segun eso agregar el POPmenu a la tabla cancelados
                            pr = cn.getConnection().prepareStatement("SELECT * FROM tipo_usuario"); // me conecto a la tabla tipo
                            //usuario, para traer tipo de usuario, y segun  eso para  crear el boton eleminar  y una columna mass
                            resultado = pr.executeQuery();

                            while (resultado.next()) {
                                tipo_usuario_2 = resultado.getString("Tipo_Usuario");
                            }

                        }

                    } else { //campos para la tabla_salida

                        dt.addColumn("Costo");
                        dt.addColumn("Fecha_Ingreso");
                        dt.addColumn("Fecha_Salida");
                        dt.addColumn("Dias");
                        dt.addColumn("Horas");
                        dt.addColumn("Minutos");
                        dt.addColumn("T_Horas");
                        dt.addColumn("Cobrado");

                        pr = cn.getConnection().prepareStatement("SELECT * FROM tipo_usuario"); // me conecto a la tabla tipo
                        //usuario, para traer tipo de usuario, y segun  eso para  crear el boton eleminar  y una columna mass
                        resultado = pr.executeQuery();

                        while (resultado.next()) {
                            tipo_usuario_2 = resultado.getString("Tipo_Usuario");
                        }

                        ///VALIDO QUE TIPO USUARIO ES DE LA TABLA_SALIDA
                        if (tipo_usuario_2.equals("Admin")) {
                            longitud_datos = 13;
                            dt.addColumn("Eliminar"); // agg una columnas mas ya que es adminitrador
                        } else if (tipo_usuario_2.equals("Empleado")) {
                            longitud_datos = 12;
                        }
//                    cn = null; /// no ubiccar eso pór que sale null
//                    resultado = null;

                    }

                    String sm_enviar_render = "";
                    JTableHeader encabezado = tabla.getTableHeader();

                    encabezado.setDefaultRenderer(new render_encabezado(true));
                    tabla.setTableHeader(encabezado);
                    if (!tabla_cancelada.equals("")) {
                        sm_enviar_render = "tabla_autos_cancelar";
                    }

                    tabla.setDefaultRenderer(Object.class, new renderizar_tablas(elegir_tabla, longitud_datos, "vamos_tablas", sm_enviar_render));
                    //en el render le paso que tabla va a renderizar, y cuantas columnas tiene la tabla 

                    tabla.getTableHeader().setReorderingAllowed(false);
                    ////////////////////////////////////////////7

                    try {/// NO ES NECEARIO ,  LO PUSE PARA ENCONTRAR UN ERROR QUE TENIA  ,PERO YA LO ENCONTRE
                        rowSorter = new TableRowSorter(dt);
                        tabla.setRowSorter(rowSorter);

                        txt_buscar.addKeyListener(new KeyListener() {
                            @Override
                            public void keyTyped(KeyEvent e) {
                            }

                            @Override
                            public void keyPressed(KeyEvent e) {
                            }

                            @Override
                            public void keyReleased(KeyEvent e) {

                                rowSorter.setRowFilter(RowFilter.regexFilter(txt_buscar.getText(), 1));
                                ///  rowSorter.setRowFilter(RowFilter.regexFilter(jTextField1.getText().toUpperCase(), IDBUSQUEDA));

                            }
                        });

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "erro filtrar_" + e.getMessage());
                        // System.out.println("erro filtrar_ " + e.getMessage());

                    }

                }

                /////////////////////////////////////////////////////////////
                //tabla.setModel(dt);
                if (elegir_tabla) {
                    ///NO puedo ordenarlo  por el numero de  registro porque cuando el  mismo auto se vuelve a ingresar el  numero de registro se mantiene(Primary Key) 

                    switch (operacion) {
                        case 1:
                            sql_select = "SELECT  Placa,Nombre_Propietario,Tipo_Vehiculo,Fecha_Ingreso,Pagado  FROM autos_ingreso WHERE Fecha_Date =? AND Pagado ='NO' ORDER BY Fecha_Date DESC, Hora_Entrada DESC, Minutos DESC, Segundos DESC ";
                            break;
                        case 2:
                     
                            sql_select = "SELECT  Placa,Nombre_Propietario,Tipo_Vehiculo,Fecha_Ingreso,Pagado  FROM autos_ingreso WHERE Pagado ='NO' ORDER BY Fecha_Date DESC, Hora_Entrada DESC, Minutos DESC, Segundos DESC ";

                            break;

                        case 3:
                            //para llenar la tabla autos cancelados
                            sql_select = "SELECT  Placa,Nombre_Propietario,Tipo_Vehiculo,Fecha_Ingreso,Fecha_Cancelada FROM autos_cancelados  ORDER BY Fecha_Date DESC,hora DESC, minutos DESC, segundos DESC";
                            break;

                        case 4:
                            //para llenar la tabla autos cancelados buscando por la fecha
                            sql_select = "SELECT  Placa,Nombre_Propietario,Tipo_Vehiculo,Fecha_Ingreso,Fecha_Cancelada FROM autos_cancelados WHERE  Fecha_Date =? ORDER BY Fecha_Date DESC,hora DESC, minutos DESC, segundos DESC";
                            break;
                            
                        case 5:
                     
                            //graficar por fecha los autos ingreso pero para obtener el dinero 
                            
                            sql_select = "SELECT  Placa,Nombre_Propietario,Tipo_Vehiculo,Fecha_Ingreso,Pagado  FROM autos_ingreso WHERE Pagado ='NO' AND  Fecha_Date BETWEEN '"+ fecha_sql+ "' AND  '"+ fecha_final + "' ORDER BY Fecha_Date DESC, Hora_Entrada DESC, Minutos DESC, Segundos DESC ";

                            break;

                    }

                } else {

                    switch (operacion) {

                        case 1:
                            //esta es del boton listar por fechas///////////////////////
                            sql_select = "SELECT * FROM auto_salida  WHERE Fecha_Date =? ORDER BY Fecha_Date DESC,Hora_Salida DESC, Minutos_Salida DESC, Segundos_Salida DESC";

                            break;
                        case 2:
                            //listar todos los registros//////////////////////////////
                            sql_select = "SELECT * FROM auto_salida ORDER BY Fecha_Date DESC,Hora_Salida DESC, Minutos_Salida DESC, Segundos_Salida DESC";

                            break;
                    }

                }

                pr = cn.getConnection().prepareStatement(sql_select);

                if (!elegir_tabla && operacion == 1) { //tabla salida para que liste x la fecha pasada
                    pr.setDate(1, fecha_sql);

                }

                if (elegir_tabla && (operacion == 1 || operacion == 4)) { //tabla ingreso(1) o tabla autos cancelados(4) para que liste x la fecha pasada
                    pr.setDate(1, fecha_sql);
                }

                resultado = pr.executeQuery();

                int indice_filas = 0; //agregar un indice en la columnas #0
                while (resultado.next()) {
                    indice_filas += 1;
                    Object datos[] = new Object[longitud_datos];
                    JButton btn_eli_cobrar = null;
                    if (tabla_cancelada.equals("")) { //en el caso que desee llenar las tablas ingreso o salida de vehiculos
                        btn_eli_cobrar = new JButton(new ImageIcon(icono));

                        LineBorder border = new LineBorder(Color.ORANGE, 1, true);
                        btn_eli_cobrar.setBorder(border);
                    }

                    datos[0] = String.valueOf(indice_filas);
                    if (elegir_tabla) {

                        if (tabla_cancelada.equals("")) { //en el caso que desee llenar las tablas ingreso 
                            traer_datos = new Intruccion_sql();
                        }

                        datos[1] = (resultado.getString("Placa"));
                        datos[2] = (resultado.getString("Nombre_Propietario"));

                        datos[3] = (resultado.getString("Tipo_Vehiculo"));
                        datos[4] = (resultado.getString("Fecha_Ingreso"));
                        if (tabla_cancelada.equals("")) { //tabla autos ingreso
                            datos[5] = (resultado.getString("Pagado"));
                            traer_datos.Retirar_Vehiculo((String) datos[1]);

                            if (lista != null) { // valido para cuando vala a graficar , yo le paso null
                                lista.add(resultado.getString("Placa"));
                            }

                            datos[6] = traer_datos.getTotal_cobrar();

                            datos[longitud_datos - 1] = btn_eli_cobrar;
                            total_tabla_ing_salida += traer_datos.getTotal_cobrar(); //el dinero que hay por cobrar  por los vehiculos que estan ingresados actualmente
                        } else { //tabla autos cancelados
                            datos[longitud_datos - 1] = (resultado.getString("Fecha_Cancelada"));
                        }

                    } else {
                        datos[1] = resultado.getString("Placa");
                        datos[2] = resultado.getString("Nombre_Propietario");
                        datos[3] = resultado.getString("Tipo_Vehiculo");
                        datos[4] = resultado.getString("Costo_Vehiculo");
                        datos[5] = resultado.getString("Fecha_Ingreso");
                        datos[6] = resultado.getString("Fecha_Salida");
                        datos[7] = resultado.getString("Total_Dias");
                        datos[8] = resultado.getString("Total_Horas");
                        datos[9] = resultado.getString("Total_Minutos");
                        datos[10] = resultado.getString("Tota_en_Horas");
                        datos[11] = resultado.getString("Total_Cobrar");
                        lista.add(resultado.getString("Placa"));

                        total_tabla_ing_salida += resultado.getDouble("Total_Cobrar"); //el dinero cobrado por los vehiculos retirados

                        if (tipo_usuario_2.equals("Admin")) { /// si llega admin que agregue un boton  a la tabla
                            datos[longitud_datos - 1] = btn_eli_cobrar;
                        }

                    }

                    if (tabla != null) {
                        dt.addRow(datos);
                        numero_filas_regi = dt.getRowCount(); /// VARIABLE DE RETORNO , 

                        if (numero_filas_regi > 0) {

                            tabla.setModel(dt); /// me ayuda a controlar la consulta del boton por fechas

                        }
                    }

                }
            } /// llave de cierre del if de la pregunta

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo llenar  la tabla " + e.getMessage());
            /// System.out.println("No se pudo llenar  la tabla " + e.getMessage());
        }

    }

    public int total_filas(boolean filas_segun_tabla) {
        int cantidad_filas = 0;

        try {

            String sql_selected = "SELECT Placa FROM autos_ingreso WHERE Pagado = 'NO'"; //total de filas de la tabla ingreso que no ahn pagado
            if (!filas_segun_tabla) {
                sql_selected = ("SELECT Placa FROM auto_salida"); //total de filas de la tabla salida
            }
            pr = cn.getConnection().prepareStatement(sql_selected);
            resultado = pr.executeQuery();
            while (resultado.next()) {
                cantidad_filas += 1;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo traer el total de las filas " + "\nde la tabla salida" + e.getCause());
        }

        return cantidad_filas;
    }

    private void tabla_Usua_Admin() {

        try {

            switch (elegir_tipo_usu) {
                case 1:
                    sql_select = "SELECT * FROM  usuarios ORDER BY Tipo_Usuario"; //selecciona todas las cuenta
                    break;
                case 2:
                    sql_select = "SELECT * FROM  usuarios  WHERE Tipo_Usuario = 'Admin'"; // selecciona solo los Admin
                    break;
                case 3:
                    sql_select = "SELECT * FROM  usuarios  WHERE Tipo_Usuario = 'Empleado'"; //selecciona solo los Empleados
                    break;
                default:
                    break;
            }

            dt = new DefaultTableModel() {

                public boolean isCellEditable(int filas, int columnas) {

                    if (columnas > 3 && columnas < 9) {
                        return true;
                    } else {
                        return false;
                    }
                }

            };

            dt.addColumn("#");
            dt.addColumn("Cédula");
            dt.addColumn("Nombres");
            dt.addColumn("Apellidos");
            dt.addColumn("Teléfono");
            dt.addColumn("Dirección");
            dt.addColumn("Correo");
            dt.addColumn("Usuario");
            dt.addColumn("Contraseña");
            dt.addColumn("T_Usuario");
            dt.addColumn("Estado");

            pr = cn.getConnection().prepareStatement(sql_select);
            resultado = pr.executeQuery();

            ResultSetMetaData rsm = resultado.getMetaData();
            int cantidas_columnas = (rsm.getColumnCount() - 1) + 2;

            JTableHeader encabezado = tabla.getTableHeader();
            encabezado.setDefaultRenderer(new render_encabezado(true));
            tabla.setTableHeader(encabezado);

            tabla.setDefaultRenderer(Object.class, new renderizar_tablas(cantidas_columnas, "dale"));
            //en el render le paso que tabla va a renderizar, y cuantas columnas tiene la tabla 
            tabla.getTableHeader().setReorderingAllowed(false);

            rowSorter = new TableRowSorter(dt);
            tabla.setRowSorter(rowSorter);

            txt_buscar.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char tipo_letra = e.getKeyChar();

                    if (tipo_letra < '0' || tipo_letra > '9') {
                        e.consume();

                    }
                }

                @Override
                public void keyPressed(KeyEvent e) {
                }

                @Override
                public void keyReleased(KeyEvent e) {

                    rowSorter.setRowFilter(RowFilter.regexFilter(txt_buscar.getText(), 1));
                    ///  rowSorter.setRowFilter(RowFilter.regexFilter(jTextField1.getText().toUpperCase(), IDBUSQUEDA));

                }
            });

            int indice = 0;
            while (resultado.next()) { // RECORRER EL RESULSET

                indice += 1;
                Object datos_usuario[] = new Object[cantidas_columnas];
                ///JButton btn_boton = new JButton("Acción");
                JCheckBox mi_ckec = new JCheckBox();

                mi_ckec.setHorizontalAlignment(0);

                datos_usuario[0] = String.valueOf(indice);
                String traer_estado = null;
                for (int i = 1; i < cantidas_columnas - 1; i++) { // LLENAR EL VECTOR CON LOS DATOS TRAIDOS

                    datos_usuario[i] = resultado.getString(i);

                    if (i == 8) {
                        traer_estado = resultado.getString("Estado");
                    }

                }
                if (traer_estado.equals("AC")) {
                    mi_ckec.setSelected(true);
                }
                datos_usuario[cantidas_columnas - 1] = mi_ckec;
                dt.addRow(datos_usuario);
            }

            ///////////////////////////////////////////////////////////////////////////////
            /*
            Este metodo es  para Actualizar 
             */
            dt.addTableModelListener(new TableModelListener() {
                @Override
                public void tableChanged(TableModelEvent e) {
                    if (e.getType() == TableModelEvent.UPDATE) {
                        String colname = null;
                        String valor_campo = null;
                        int columna_valor = 0;

                        //Obtengo que columa se va actulizar  e para colname poner el  nombre tal y como esta el campo en
                        //la base de datos, ya que no puedo tomar como referncia el nombre de la columna de la tabla porque
                        //no estan igual al nombre  de las columnas de la base de datos
                        switch (e.getColumn()) {
                            case 4:
                                colname = "Telefono";
                                columna_valor = 4;
                                break;
                            case 5:
                                colname = "Direccion";
                                columna_valor = 5;
                                break;
                            case 6:
                                colname = "Correo_electronico";
                                columna_valor = 6;
                                break;
                            case 7:
                                colname = "Usuario";
                                columna_valor = 7;
                                break;
                            case 8:
                                colname = "Contrasena";
                                columna_valor = 8;
                                break;
                            default:
                                break;
                        }

                        valor_campo = dt.getValueAt(e.getFirstRow(), columna_valor).toString(); // tengo el valor de la celda despues

                        String sql_sentencia = null;

                        try {

                            if (!valor_campo.isEmpty()) {
                                sql_sentencia = "UPDATE usuarios SET " + colname + "='" + dt.getValueAt(e.getFirstRow(), e.getColumn()) + "' WHERE Cedula= " + dt.getValueAt(e.getFirstRow(), 1);

                            } else { // si el valor a actualizar es vacio que vuelva a poner le valor que tenia                      
                                //sql = "SELECT '" + colname + "' FROM usuarios WHERE  Cedula = '" + dt.getValueAt(e.getFirstRow(), 1) + "'";
                                sql_sentencia = "SELECT  *  FROM usuarios WHERE  Cedula = '" + dt.getValueAt(e.getFirstRow(), 1) + "'";

                            }
                            /*
                            este variable "tomar_otro_select" , me sirve en caso que  la celda sea diferente de vacio PERO  no cumpla los parametros establecidos
                            por ejemplo que #telefono sea >10 o con los usuarios, etc, en ese caso  reincio el pr = null, y  hago una nueva consulta a la base de datos y 
                           traigo el valor que estaba anterior , (haci com hago cuando el celda es vacia), osea  el dato no se actualizo , por eso traigo el valor que esta en la base de datos 
                            
                             */
                            String tomar_otro_select = "SELECT  *  FROM usuarios WHERE  Cedula = '" + dt.getValueAt(e.getFirstRow(), 1) + "'"; // auxiliar

                            pr = cn.getConnection().prepareStatement(sql_sentencia);

                            if (valor_campo.isEmpty()) { // en el caso de que sea vacio
                                resultado = pr.executeQuery();

                                while (resultado.next()) { // en el caso que el dato que se ingresa para actualizar es vacio (Deja la celda vacia y aplasta ENTER) , no se actulizara el campo , y volvera a poner
                                    //automaticamente el valor que tenia 

                                    dt.setValueAt(resultado.getString(colname), e.getFirstRow(), e.getColumn()); //pongo el valor en la celda  que tenia , este dato lo traigo desde la base de datos 
                                }

                            } else if (!valor_campo.isEmpty()) { //En el caso que el dato a actualizar  sea DIFERENTE A VACIO (tenga caracteres)

                                /*
                                Antes de actulizar , hace validiaciones de las celdas, dependiendo la celda  que se  va actualizar
                                CAMPOS QUE TIENEN VALIDACIONES-------------------------------
                                1: que el # telefono a actualizr no tenga mas de 10 caracteress y no tenga letras ni espacios en blanco
                                2: que al cambiar la contraseña , esta cumpla con los parametros establecidos
                                3: Usuarios cumpla con los parametros establecidos
                                4:Todas estas validaciones estan en la clase, Validacion_txt.
                                5: Todas estas validaciones son las misma que  utilze para las validaciones en el formulario de Registrar.                        
                                 */
                                boolean estado = true;
                                int r = 2;
                                String sms = "      Dato No Actualizado\n"; /// sms que se mostrara en el JOPTIONPane en el caso que el dato
                                //a actualizar no cumpla con los parametros de cada campo
                                ///Validaciones antes de actualizar
                                switch (colname) {
                                    case "Telefono":
                                        r = validar_txt.Longitud_numero_tlf_tabla(valor_campo); //  tomo el  numero del telefono ingresado para actulizar
                                        //y  verifico que no tenga mas de 10 numeros  ni espacion en blanco ni letras, si retorna 2  , hago la actualizacion , caso contrario , hago un select y vuelvo
                                        // a poner el valor que tenia antes.
                                        //en el caso que retorne 1 quiere decir que hay letra o espacion en blanco
                                        if (r == 1) {
                                            sms += "\nNúmero de teléfono no puede contener letras" + "\nni espacios en blanco";

                                        } else if (r == 3) {
                                            sms += "\nNúmero de teléfono debe tener 10 digitos";
                                        }
                                        break;

                                    case "Correo_electronico":
                                        estado = validar_txt.validar_correo(valor_campo);
                                        if (!estado) {
                                            sms += "\nCorreo Electronico  Incorrecto";
                                        }
                                        break;
                                    case "Usuario":
                                        r = validar_txt.Validar_Usuario_contrase(valor_campo);
                                        if (r != 2) {
                                            sms += "\nNota:Usuario debe tener un  minimo de" + "\n10 caracteres,asi como  3 letras y 3 números";
                                        }
                                        break;
                                    case "Contrasena":
                                        r = validar_txt.Validar_Usuario_contrase(valor_campo);
                                        sms += "\nNota:La contraseña debe tener un  minimo de" + "\n10 caracteres,asi como  3 letras y 3 números";
                                        break;
                                    default:
                                        break;

                                    ///FIN DE LAS VALIDACIONES DE LAS CELDAS///////////////////////////////
                                }

                                //////////////////////////////////////////////////////////////////////////////
                                if (estado && r == 2) {
                                    pr.executeUpdate();
                                } else {

                                    JOptionPane.showMessageDialog(null, sms, "Sistema De Parqueo", -1, new ImageIcon("src/Image_Sms/error.png"));
                                    /*
                                    en el caso que el dato actualizar no cumplio los paramentro  me conecto a la base de datos y traigo el valor de ese campo y
                                    lo vuelvo a poner .
                                     */
                                    pr = null;
                                    pr = cn.getConnection().prepareStatement(tomar_otro_select);
                                    resultado = pr.executeQuery();

                                    while (resultado.next()) {

                                        dt.setValueAt(resultado.getString(colname), e.getFirstRow(), e.getColumn()); //PONER DE NUEVO EL VALOR
                                    }

                                }

                            }//Llave de cierra en el caso que sea diferente de VACIO

                        } catch (SQLException ex) {

                            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR " + ex);
                        }
                    }

                }

            });
            tabla.setModel(dt);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede llenar la tabla usuarioss");
        }

    }

    private void Llenar_tabla_tipo_Vehiculo() {

        try {

            dt = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

            };
            dt.addColumn("Vehiculo");
            dt.addColumn("Precio");

            JTableHeader encabezado = tabla.getTableHeader();
            encabezado.setDefaultRenderer(new render_encabezado(false));
            tabla.setTableHeader(encabezado);

            tabla.setDefaultRenderer(Object.class, new renderizar_tablas(0, "tabla_vehiculos"));
            //en el render le paso que tabla va a renderizar, y cuantas columnas tiene la tabla 
            tabla.getTableHeader().setReorderingAllowed(false);

            pr = cn.getConnection().prepareStatement("SELECT * FROM tipo_de_vehiculo ORDER BY Valor_Vahiculo ");

            resultado = pr.executeQuery();

            while (resultado.next()) {

                Object lista[] = new Object[2];

                for (int i = 0; i < 2; i++) {

                    lista[i] = resultado.getString(i + 1);

                }

                dt.addRow(lista);

            }
            numero_filas_regi = dt.getRowCount();
            tabla.setModel(dt);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo llenar la tabla de vehiculos " + e.getMessage());
        }

    }

    public int getNumero_filas_regi() {
        return numero_filas_regi;
    }

    public double getTotal_tabla_ing_salida() {
        return total_tabla_ing_salida;
    }

    public String getTipo_usuario_2() {
        return tipo_usuario_2;
    }

    private boolean elegir_tabla;
    private int operacion;
    private Date fecha_sql;
    private Date fecha_final;
    private int numero_filas_regi;
    private String sql_select = "";
    private ArrayList lista;
    private String pregunta;
    private String tipo_usuario_2;
    private JTextField txt_buscar;
    private double total_tabla_ing_salida; ///devuelve e total  de la tabla_salida e ingreso
    private int elegir_tipo_usu;

    private String tabla_cancelada = ""; // para la validacion cuadno la llame desde la tabla de autos cancelados

}
