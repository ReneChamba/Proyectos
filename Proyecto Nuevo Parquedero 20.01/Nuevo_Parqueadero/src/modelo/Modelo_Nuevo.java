package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Modelo_Nuevo {

    private Renderizar_Tablas renderizar_tablas;
    private Render_Encabezado render_encabezado;
    private Iconos iconos;
    private Constantes constantes;

    public Modelo_Nuevo() {

    }

    public void setRenderizar_Tablas(Renderizar_Tablas renderizar_tablas) {
        this.renderizar_tablas = renderizar_tablas;
    }

    public void setRenderizar_Encabezado(Render_Encabezado render_encabezado) {
        this.render_encabezado = render_encabezado;
    }

    public void setIconos(Iconos iconos) {

        this.iconos = iconos;
    }

    public void Iniciar_Componentes() {
        dialogReporte = new JDialog(new JFrame(), "RR 20.01", true);
        dialogReporte.setSize(1377, 710);
        dialogReporte.setLocation(-5, 23);
        dialogReporte.setResizable(false);
        panel_retorno_grafica = new JPanel();
        //   panel_frame = new JPanel();

        this.btn_cancelar = new JButton("Cancelar", iconos.getIcono_eliminar());
        this.btn_cancelar.setName("Cancelar");
        this.btn_editar = new JButton("Editar", iconos.getIcono_editar());

        this.btn_editar.setName("Editar");

        contador_registro = 0;
        dolares_ingresados = 0;

    }
    //=============================================================

    public String getMotivo_Ingreso() {
        return motivo_Ingreso;
    }

    public void setMotivo_Ingreso(String motivo_Ingreso) {
        this.motivo_Ingreso = motivo_Ingreso;
    }

    public String getPrecio_lavado() {
        return precio_lavado;
    }

    public void setPrecio_lavado(String precio_lavado) {
        this.precio_lavado = precio_lavado;
    }

    public String getPrecio_parqueo() {
        return precio_parqueo;
    }

    public void setPrecio_parqueo(String precio_parqueo) {
        this.precio_parqueo = precio_parqueo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public JComboBox getCombo_tipo() {
        return combo_tipo;
    }

    public void setCombo_tipo(JComboBox combo_tipo) {
        this.combo_tipo = combo_tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getEstado_vehiculo() {
        return estado_vehiculo;
    }

    public void setEstado_vehiculo(String estado_vehiculo) {
        this.estado_vehiculo = estado_vehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public int getContador_Registros() {

        return contador_registro;
    }

    public double getDolares_ingresados() {

        return dolares_ingresados;
    }

    public void setConstantes(Constantes constantes) {
        this.constantes = constantes;
    }

    public void setResulset_Datos(ResultSet resultado, int elegir) {

        this.resultado_datos = resultado;

        if (elegir == 1) {
            Tabla_Autos_Ingresados();

        }

        if (elegir == 2) {
            Tabla_Tipo_Vehiculo();

        }

        if (elegir == 3) {
            Tabla_Autos_Parqueo();

        }

        if (elegir == 4) {
            Tabla_Cuenta_Usuarios();

        }

        if (elegir == 5) {
            Graficar_Estadisticas();

        }

        if (elegir == 6) {
            Tabla_Autos_Lavado();

        }

        if (elegir == 7) {
            Tabla_Autos_Parqueo_Lavado();

        }
        if (elegir == 10) {

            Numero_Registro_Vehiculos_Ingresados();
        }

    }

    public void Numero_Registro_Vehiculos_Ingresados() {

        try {

            contador_registro = 0;

            while (resultado_datos.next()) {

                //Solo es para conocer el numero de vehiculos ingresados 
                // despeus de haver iniciado sesión
                contador_registro++;

            }

        } catch (Exception e) {
        }

    }

    public TableRowSorter getFiltrar_filas() {
        return this.rowSorter_filas;
    }

    public void setTabla(JTable tabla) {

        this.tabla = tabla;

    }

    //##################################################################CONTRUIR TABLAS##########################################################
    private void Tabla_Autos_Ingresados() {

        try {
            DefaultTableModel dt = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int columnas) {

                    return false;

                }

            };

            dt.addColumn("Código");
            dt.addColumn("Fecha_Ingreso");
            dt.addColumn("Propietario");
            dt.addColumn("Placa");
            dt.addColumn("Tipo");

            dt.addColumn("Motivo");
            dt.addColumn("$ Lavado");
            dt.addColumn("$ Parqueo");

            /// dt.addColumn("Precio");
            dt.addColumn("Cancelar");
            dt.addColumn("Editar");

            this.tabla.setModel(dt);

            this.renderizar_tablas.Seleccionar_Tabla("tb_ingresados");
            this.tabla.setDefaultRenderer(Object.class, renderizar_tablas);

            render_encabezado.Ejegir_tabla(true);
            encabezado = tabla.getTableHeader();
            encabezado.setDefaultRenderer(render_encabezado);
            tabla.setTableHeader(encabezado);

            rowSorter_filas = new TableRowSorter(dt);
            tabla.setRowSorter(rowSorter_filas);

            contador_registro = 0;
            while (this.resultado_datos.next()) {

                Object datos[] = new Object[dt.getColumnCount()];

                // datos[0] = contador;
                for (int i = 0; i < 8; i++) {

                    datos[i] = this.resultado_datos.getString(i + 1);

                }
                datos[8] = btn_cancelar;
                datos[9] = btn_editar;

                dt.addRow(datos);

                contador_registro++;

            }
        } catch (SQLException ex) {

            System.out.println("error al llenar la tabla " + ex);
        }

    }

    private void Tabla_Tipo_Vehiculo() {

        try {
            DefaultTableModel dt = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int columnas) {

                    return false;

                }

            };

            dt.addColumn("Código");
            dt.addColumn("Tipo");
            dt.addColumn("Precio");
            dt.addColumn("Eliminar");
            this.tabla.setModel(dt);

            renderizar_tablas.Seleccionar_Tabla("tb_confi_vehiculos");
            this.tabla.setDefaultRenderer(Object.class, renderizar_tablas);

            render_encabezado.Ejegir_tabla(true);
            encabezado = tabla.getTableHeader(); //tomar el modelo del encabezado de la tabla

            encabezado.setDefaultRenderer(render_encabezado);
            tabla.setTableHeader(encabezado);

            rowSorter_filas = new TableRowSorter(dt);
            tabla.setRowSorter(rowSorter_filas);
            contador_registro = 0;

            while (this.resultado_datos.next()) {

                Object datos[] = new Object[4];

                // datos[0] = contador;
                for (int i = 0; i < 4 - 1; i++) {

                    datos[i] = this.resultado_datos.getString(i + 1);

                }
                datos[3] = btn_cancelar;
                contador_registro++;

                dt.addRow(datos);

            }
        } catch (SQLException ex) {

            System.out.println("error al llenar la tabla " + ex);
        }

    }

    private void Tabla_Autos_Parqueo() {

        try {
            DefaultTableModel dt = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int columnas) {

                    return false;

                }

            };

            dt.addColumn("Fe_Ingreso");
            dt.addColumn("Fe_Salida");
            dt.addColumn("Placa");
            dt.addColumn("Tipo");
            dt.addColumn("P_Hora");
            dt.addColumn("T_Horas");
            dt.addColumn("T_Min");
            dt.addColumn("Cobrado");

            this.tabla.setModel(dt);

            renderizar_tablas.Seleccionar_Tabla("tb_salidos");
            this.tabla.setDefaultRenderer(Object.class, renderizar_tablas);

            render_encabezado.Ejegir_tabla(true);
            encabezado = tabla.getTableHeader();
            encabezado.setDefaultRenderer(render_encabezado);
            tabla.setTableHeader(encabezado);

            rowSorter_filas = new TableRowSorter(dt);
            tabla.setRowSorter(rowSorter_filas);

            contador_registro = 0;
            dolares_ingresados = 0;
            while (this.resultado_datos.next()) {

                Object datos[] = new Object[dt.getColumnCount()];

                for (int i = 0; i < 8; i++) {

                    if (i == 0 || i == 1) {
                        datos[i] = resultado_datos.getString(i + 3).substring(0, 19); //para que no muestre los milisegundos

                    } else {

                        datos[i] = this.resultado_datos.getString(i + 3);

                    }
                }

                dolares_ingresados += resultado_datos.getDouble("COBRADO");
                contador_registro++;

                dt.addRow(datos);

            }
        } catch (SQLException ex) {

            System.out.println("error al llenar la tabla autos retirados , modelo " + ex);
        }

    }

    private void Tabla_Autos_Parqueo_Lavado() {

        try {
            DefaultTableModel dt = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int columnas) {

                    return false;

                }

            };

            dt.addColumn("Fe_Ingreso");
            dt.addColumn("Fe_Salida");
            dt.addColumn("Placa");
            dt.addColumn("Tipo");
            dt.addColumn("P_Hora");
            dt.addColumn("T_Horas");
            dt.addColumn("T_Min");
            dt.addColumn("$ Parqueo");
            dt.addColumn("$ Lavado");
            dt.addColumn("Cobrado");

            this.tabla.setModel(dt);

            renderizar_tablas.Seleccionar_Tabla("tb_salidos_lavado_parqueo");
            this.tabla.setDefaultRenderer(Object.class, renderizar_tablas);

            render_encabezado.Ejegir_tabla(true);
            encabezado = tabla.getTableHeader();
            encabezado.setDefaultRenderer(render_encabezado);
            tabla.setTableHeader(encabezado);

            rowSorter_filas = new TableRowSorter(dt);
            tabla.setRowSorter(rowSorter_filas);

            contador_registro = 0;
            dolares_ingresados = 0;
            while (this.resultado_datos.next()) {

                Object datos[] = new Object[dt.getColumnCount()];

                for (int i = 0; i < 10; i++) {

                    if (i == 0 || i == 1) {
                        datos[i] = resultado_datos.getString(i + 3).substring(0, 19); //para que no muestre los milisegundos

                    } else {

                        datos[i] = this.resultado_datos.getString(i + 3);

                    }
                }

                dolares_ingresados += resultado_datos.getDouble("COBRADO");
                contador_registro++;

                dt.addRow(datos);

            }
        } catch (SQLException ex) {

            System.out.println("error al llenar la tabla autos retirados lavado mas parqueo ,  clase modelo nuevo " + ex);
        }

    }

    private void Tabla_Autos_Lavado() {

        try {
            DefaultTableModel dt = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int columnas) {

                    return false;

                }

            };

            dt.addColumn("Fecha Registro");
            dt.addColumn("Placa");
            dt.addColumn("Tipo");
            dt.addColumn("Cobrado");

            this.tabla.setModel(dt);

            renderizar_tablas.Seleccionar_Tabla("tb_salidos_lavado");
            this.tabla.setDefaultRenderer(Object.class, renderizar_tablas);

            render_encabezado.Ejegir_tabla(true);
            encabezado = tabla.getTableHeader();
            encabezado.setDefaultRenderer(render_encabezado);
            tabla.setTableHeader(encabezado);

            rowSorter_filas = new TableRowSorter(dt);
            tabla.setRowSorter(rowSorter_filas);

            contador_registro = 0;
            dolares_ingresados = 0;
            while (this.resultado_datos.next()) {

                Object datos[] = new Object[dt.getColumnCount()];

                for (int i = 0; i < 4; i++) {

                    if (i == 0) {
                        datos[i] = resultado_datos.getString(i + 3).substring(0, 19); //para que no muestre los milisegundos

                    } else {

                        datos[i] = this.resultado_datos.getString(i + 3);

                    }
                }

                dolares_ingresados += resultado_datos.getDouble("COBRADO");
                contador_registro++;

                dt.addRow(datos);

            }
        } catch (SQLException ex) {

            System.out.println("error al llenar la tabla autos retirados lavado mas parqueo ,  clase modelo nuevo " + ex);
        }

    }

    private void Tabla_Cuenta_Usuarios() {

        try {
            DefaultTableModel dt = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int columnas) {

                    return false;

                }

            };

            dt.addColumn("Código");
            dt.addColumn("Cédula");
            dt.addColumn("Nombre");
            dt.addColumn("Cuenta");
            dt.addColumn("Tipo_Cuenta");

            this.tabla.setModel(dt);

            renderizar_tablas.Seleccionar_Tabla("tb_admin_usuarios");
            this.tabla.setDefaultRenderer(Object.class, renderizar_tablas);

            render_encabezado.Ejegir_tabla(true);
            encabezado = tabla.getTableHeader();
            encabezado.setDefaultRenderer(render_encabezado);
            tabla.setTableHeader(encabezado);
            rowSorter_filas = new TableRowSorter(dt);
            tabla.setRowSorter(rowSorter_filas);

            while (this.resultado_datos.next()) {

                Object datos[] = new Object[5];

                // datos[0] = contador;
                for (int i = 0; i < 5; i++) {

                    if (i == 4) {
                        // para saltarse la columna del password
                        datos[i] = this.resultado_datos.getString(i + 2);
                    } else {
                        datos[i] = this.resultado_datos.getString(i + 1);
                    }

                }

                dt.addRow(datos);

            }
        } catch (SQLException ex) {

            System.out.println("error al llenar la tabla  usuaios" + ex);
        }

    }

    //###########################################################################################3#########################################

    /*
    ########################################################################################################################################3
     */
    //##############################3CALCULOS  Y PROCESOS------------------------------------------------------------------------------
    public Date getFecha_Date() {
        // para el calendario inicio
        // HH MAYUSCULAS son horas de 24 horas , las minusculas hh son de 12 horsas
        return Calendar.getInstance().getTime();
    }

    public Date getFecha_Date_2() {
        // para el calendario final 
        return Calendar.getInstance().getTime();
    }

    public String getFecha_Ingresar_Actual(boolean formFecha) {

        Date cale = Calendar.getInstance().getTime();
        String formato = "YYYY/MM/dd";
        if (formFecha) {

            formato += " HH:mm:ss";
        }
        return new SimpleDateFormat(formato).format(cale);
    }

    public void setFecha__Date(Date fecha_inicio) {//plz kkkkkk

        this.fecha_inicio = fecha_inicio;

    }

    public String getFecha__String_Inicio() {

        SimpleDateFormat dfr = new SimpleDateFormat("YYYY/MM/dd"); // HH MAYUSCULAS son horas de 24 horas , las minusculas hh son de 12 horsas

        return dfr.format(fecha_inicio);
    }

    public void setFecha__Date_Final(Date fecha_final) {//pl kkkk
        this.fecha_final = fecha_final;

    }

    public String getFecha__String_Final() {

        SimpleDateFormat dfr = new SimpleDateFormat("YYYY/MM/dd"); // HH MAYUSCULAS son horas de 24 horas , las minusculas hh son de 12 horsas

        return dfr.format(fecha_final);
    }

    public String getOperacion_Fecha(String fecha_operacion) {//le llega la fech de registro 

        // llega en esta forma YYYY-MM-dd HH:mm:ss // convierto o cambio  el caracter '-' por el '/' hay si puede trabajar x fecha_inicio por
        // eso hago el prroceso de abajo
        int anio = Integer.parseInt(fecha_operacion.substring(0, 4).trim());

        int mes = Integer.parseInt(fecha_operacion.substring(5, 7).trim());
        int dia = Integer.parseInt(fecha_operacion.substring(8, 10).trim());
        int hora = Integer.parseInt(fecha_operacion.substring(11, 13).trim());
        int minutos = Integer.parseInt(fecha_operacion.substring(14, 16).trim());
        int segundos = Integer.parseInt(fecha_operacion.substring(17, 19).trim());

        Construir_Fechas(anio, mes, dia, hora, minutos, segundos); // ESTO ES UN METODO

        String fecha_regis = anio + "/" + fecha_operacion.substring(5, 7).trim()
                + "/" + fecha_operacion.substring(8, 10).trim() + "  " + fecha_operacion.substring(11, fecha_operacion.trim().length() - 2).trim();

        return fecha_regis;
    }

    public void Construir_Fechas(int annio, int mes, int dia, int hora, int minutos, int segudos) {

        Calendar calendario = Calendar.getInstance();
        long fecha_actual = calendario.getTimeInMillis();
        calendario.set(annio, mes - 1, dia, hora, minutos, segudos); // creo una fecha_inicio con la fecha_inicio de ingreso
        long fecha_ingreso = calendario.getTimeInMillis();
        ///  int total_dias = (int) (Math.abs(fecha_actual - fecha_ingreso) / (1000 * 60 * 60 * 24));
        int total_minutos_ = (int) (Math.abs(fecha_actual - fecha_ingreso) / (1000 * 60));
        int horas_2 = total_minutos_ / 60;
        total_minutos_ = total_minutos_ % 60; // el residuo de las horas

        double precio = Double.parseDouble(this.precio_hora);
        if (horas_2 < 1 && total_minutos_ < 60) {

            this.total_Cobrar = String.valueOf(precio);
        }

        if (horas_2 >= 1 && total_minutos_ < 15) {

            this.total_Cobrar = String.valueOf((horas_2 * precio) + (precio / 4));
        }

        if (horas_2 >= 1 && (total_minutos_ >= 15 && total_minutos_ <= 35)) {

            this.total_Cobrar = String.valueOf((precio * horas_2) + (precio / 2));
        }

        if (horas_2 >= 1 && (total_minutos_ > 35 && total_minutos_ < 60)) {

            this.total_Cobrar = String.valueOf((precio * horas_2) + precio);
        }

        this.numero_horas = String.valueOf(horas_2);
        this.numero_minutos = String.valueOf(total_minutos_);

    }

    public String getTotal_Cobrar() {
        return total_Cobrar;
    }

    public void setTotal_Cobrar(String total_Cobrar) {
        this.total_Cobrar = total_Cobrar;
    }

    public String getPrecio_hora() {
        return precio_hora;
    }

    public void setPrecio_hora(String precio_hora) {
        this.precio_hora = precio_hora;
    }

    public String getNumero_horas() {
        return numero_horas;
    }

    public void setNumero_horas(String numero_horas) {
        this.numero_horas = numero_horas;
    }

    public String getNumero_minutos() {
        return numero_minutos;
    }

    public void setNumero_minutos(String numero_minutos) {
        this.numero_minutos = numero_minutos;
    }

    public JDialog getDialogReporte() {

        // dialogReporte.setContentPane(new JPanel());
        return dialogReporte;
    }

    //==========METODOS PARA LOS GRAFICAS LAS ESTADISTICAS=================
    //RECIBE LOS PARAMETROS ENVIADOS DESDE EL CONTROLADOR DE LAS ESTADISTICAS
    public void setParametros_Graficos(int parametro, int tipo, int modelo, boolean filtrar) {

        this.parametro_grafico = String.valueOf(parametro);
        this.tipo_grafico = String.valueOf(tipo);
        this.modelo_grafico = String.valueOf(modelo);
        this.filtrar = filtrar;

    }

    public String getGenerar_Quey_Graficar() {

        /*
        ESTE METODO SOLO PREPARA EL QUERY CON EL SE VA A GRAFICAR, RETORNA ESA
        CONSULTA QUE SE EJECUTARA  EN CRUD
        
         */
        String sql_query_final = "SELECT TIPO_VEHICULO  ,COUNT";
        String sql_filtrar_fecha = " WHERE ";

        //===DETERMINAR LA TABLA QUE VA A REALIZAR LA CONSULTA=================
        switch (parametro_grafico) {

            case "0":
                sql_query_final += "(ID_INGRESOS) AS CANTIDAD_VEHICULOS FROM " + constantes.getTabla_autos_ingresos();
                sql_filtrar_fecha += " DATE_REGISTRO ";

                break;
            case "1":
                sql_query_final += "(ID_REGISTRO) AS CANTIDAD_VEHICULOS, SUM(COBRADO) AS SUMA_VEHICULOS FROM  " + constantes.getTabla_autos_salidos();
                sql_filtrar_fecha += " SALIDA_DATE ";
                break;
            case "2":
                sql_query_final += "(ID_LAVADO) AS CANTIDAD_VEHICULOS, SUM(COBRADO) AS SUMA_VEHICULOS FROM  " + constantes.getTabla_lavado();

                sql_filtrar_fecha += " FECHA_DATE ";
                break;
            case "3":
                sql_query_final += "(ID_REGISTRO) AS CANTIDAD_VEHICULOS, SUM(COBRADO) AS SUMA_VEHICULOS FROM  " + constantes.getTabla_lavado_Mas_Parqueo();
                sql_filtrar_fecha += " SALIDA_DATE ";
                break;

        }

        //filtrar true: filtrar por fecha
        //filtrar false: filtrr todo 
        if (filtrar) {
            sql_query_final += sql_filtrar_fecha + " BETWEEN  '" + getFecha__String_Inicio() + "' AND '" + getFecha__String_Final() + "'  ";

        }

        sql_query_final += " GROUP BY TIPO_VEHICULO";

        //RETORNO EL QUERY QUE SE EJECUTA EN CRUD
        return sql_query_final;
    }

    private String getTipo_Modelo_Grafica() {
        /*ESTE METODO SE ENCARGA DE DETERMINAR EL TIPO Y MODELO DE LA GRAFICA, ES LLAMADO DESDES EL METODO 
            GRAFCIAR ESTADISTICAS
         *DETERMINAR EL TIPO GRAFICO: 
              - BARRA : vertical - horizontal 
              - PASTEL : normal - 3d
         */
        String seleccion_tipo_modelo = "";
        if (tipo_grafico.equals("0")) {//pastel

            switch (modelo_grafico) {
                case "0":
                    seleccion_tipo_modelo = "PASTEL,NORMAL";
                    break;
                case "1":
                    seleccion_tipo_modelo = "PASTEL,3D";
                    break;

            }

        }
        if (tipo_grafico.equals("1")) {//barra

            switch (modelo_grafico) {
                case "0":
                    seleccion_tipo_modelo = "BARRA,HORIZONTAL";
                    break;
                case "1":
                    seleccion_tipo_modelo = "BARRA,VERTICAL";
                    break;

            }

        }
        return seleccion_tipo_modelo;

    }

    private void Graficar_Estadisticas() {

        DefaultPieDataset modelo_pastel = new DefaultPieDataset();///grafico pastel
        DefaultCategoryDataset modelo_barra = new DefaultCategoryDataset(); ///grafico de barras
        grafico_barras = null;
        String tipo_modelo = getTipo_Modelo_Grafica();
        String titulo = "Vehículos Ingresados Actualmente #";

        int total_num_vehiculos = 0;
        double dinero_cobrado = 0;
        try {

            while (resultado_datos.next()) {

                if (parametro_grafico.equalsIgnoreCase("0")) {

                    switch (tipo_grafico) {//AUTOS INGRESADOS ACTUELMENTE

                        case "0":
                            //SEGUNDO PARAMETRO DEL setValue(Dataset) ES EL QUE SE TOMA EN CUENTA PARA GRAFICA, EL QUE VA SOLITO
                            modelo_pastel.setValue(resultado_datos.getString("TIPO_VEHICULO") + " # " + resultado_datos.getString("CANTIDAD_VEHICULOS"), resultado_datos.getInt("CANTIDAD_VEHICULOS"));
                            break;

                        case "1":
                            //EL PRIMER PARAMETRO DEL setValue(dataset) ES QUE SE TOMA PARA GRAFICAR
                            modelo_barra.setValue(resultado_datos.getInt("CANTIDAD_VEHICULOS"), resultado_datos.getString("TIPO_VEHICULO"), resultado_datos.getString("TIPO_VEHICULO") + " # " + resultado_datos.getString("CANTIDAD_VEHICULOS"));
                            break;

                    }
                    //VA SUMANDO EL TOTAL DE VEHICULO DE CADA CATEGORIA O AGRUPACION DE VEHICULOS INGRESADOS
                    total_num_vehiculos += resultado_datos.getInt("CANTIDAD_VEHICULOS");

                } else {

                    //CASO CONTRARIO TANTO PARA LOS VEHICULOS SALIDOS DEL PARQUEO, LAVADO , PARQUEO + LAVADO SON LOS MISMOS DATOS , YA EN
                    //QUERY DE LA CONSULTA SE DETERMINARON LOS RESULTADOS, LOS CAMPOS QUE RETORNA EL RESULSET PARA LAS 3 TABLAS SE LLAMAN DE LA MISMA MANERA
                    titulo = "Vehículos Retirados ";

                    //SWITCH PARA DETERMINAR EL TITULO DEL GRAFICO
                    switch (parametro_grafico) {

                        case "1":
                            titulo += "Parqueo";
                            break;

                        case "2":
                            titulo += "Lavado";
                            break;
                        case "3":
                            titulo += "Parqueo + Lavado";
                            break;
                    }
                    titulo += " #";

                    //SWICHT PARA DETERMINAR EL MODELO
                    switch (tipo_grafico) {

                        case "0"://PASTEL

                            //SEGUNDO PARAMETRO  del setValue (data set)ES EL QUE SE TOMA EN CUENTA PARA GRAFICA, EL QUE VA SOLITO
                            modelo_pastel.setValue(resultado_datos.getString("TIPO_VEHICULO") + " # " + resultado_datos.getInt("CANTIDAD_VEHICULOS"), resultado_datos.getInt("CANTIDAD_VEHICULOS"));

                            break;
                        case "1":
                            //EL PRIMER PARAMETRO DEL setValue(dataset)ES QUE SE TOMA PARA GRAFICAR
                            modelo_barra.setValue(resultado_datos.getInt("CANTIDAD_VEHICULOS"), resultado_datos.getString("TIPO_VEHICULO") + " $ " + resultado_datos.getDouble("SUMA_VEHICULOS"), resultado_datos.getString("TIPO_VEHICULO") + " #  " + resultado_datos.getInt("CANTIDAD_VEHICULOS"));

                            break;
                    }
                    //VA SUMANDO EL NUMERO DE VEHICULO DE CADA CATEGORIA O AGRUPACION DE VEHICULOS INGRESADOS
                    total_num_vehiculos += resultado_datos.getInt("CANTIDAD_VEHICULOS");
                    //VA SUMANDO EL TOTAL COBRADO DE VEHICULO DE CADA CATEGORIA O AGRUPACION DE VEHICULOS RETIRADOS
                    dinero_cobrado += resultado_datos.getDouble("SUMA_VEHICULOS");

                }

            }
            titulo += " " + total_num_vehiculos;

            //SOLO SI EL PARAMETRO ES DE VEHICULOS RETIRADO(1) DONDE SUMO EL DINERO , HAY Y SOLO HAY CONCATENO ESO AL TITULO
            if (!parametro_grafico.equals("0")) {

                titulo += "   $ " + dinero_cobrado;
            }

            switch (tipo_grafico) {

                case "0": //PASTEL

                    switch (tipo_modelo) {
                        case "PASTEL,NORMAL": // NORMAL

                            grafico_barras = ChartFactory.createPieChart(titulo, modelo_pastel, true, true, true);

                            break;
                        case "PASTEL,3D": //3D

                            grafico_barras = ChartFactory.createPieChart3D(titulo, modelo_pastel, true, true, true);

                            break;

                    }

                    break;

                case "1": //BARRA

                    switch (tipo_modelo) {
                        case "BARRA,HORIZONTAL": // HORIZONTAL

                            grafico_barras = ChartFactory.createBarChart3D(titulo, "Tipo Vehículo", "Rango", modelo_barra, PlotOrientation.HORIZONTAL, true, true, true);

                            break;
                        case "BARRA,VERTICAL": //VERTICAL

                            grafico_barras = ChartFactory.createBarChart3D(titulo, "Tipo Vehículo", "Rango", modelo_barra, PlotOrientation.VERTICAL, true, true, true);

                            break;

                    }

                    break;

            }

            ChartPanel panel = new ChartPanel(grafico_barras, true);
            setPanel_retorno_grafica(panel);

        } catch (Exception e) {

            System.out.println("error la graficas: " + e.getMessage());
        }

    }

    public JPanel getPanel_retorno_grafica() {
        return panel_retorno_grafica;
    }

    public void setPanel_retorno_grafica(JPanel panel_retorno_grafica) {
        /// this.panel_frame = panel_retorno_grafica; //plz con este , se lo pongo al dialogo cuando pongo ven en pantalla completa
        //revisar , antes le pasaba el mismo panel
        this.panel_retorno_grafica = panel_retorno_grafica;
    }

//    public JPanel getPanel_Frame() {
//
//        return panel_frame;
//    }
    private String usuario;
    private String contrasena;
    private String nombre;
    private String cedula;
    private String tipo_cuenta;
    private String propietario;
    private String placa;
    private String tipo_vehiculo;
    private String estado_vehiculo;
    private String codigo;
    private String precio_hora;
    private String numero_horas;
    private String numero_minutos;
    private String total_Cobrar;

    private String motivo_Ingreso;
    private String precio_lavado;
    private String precio_parqueo;

    private String fecha_registro;
    private String fecha_salida;

    private JComboBox combo_tipo;
    private JTable tabla;
    private ResultSet resultado_datos;
    private JButton btn_cancelar;
    private JButton btn_editar;
    private Date fecha_inicio;
    private Date fecha_final;
    private TableRowSorter rowSorter_filas;
    private JDialog dialogReporte;

    private String parametro_grafico;
    private String tipo_grafico; // barra o pastel
    private String modelo_grafico; // vertical -horizontal / 3d - normal
    private boolean filtrar;

    private int contador_registro;
    private double dolares_ingresados;
    JTableHeader encabezado;

    private JFreeChart grafico_barras;
    private JPanel panel_retorno_grafica;
    //  private JPanel panel_frame;

}
