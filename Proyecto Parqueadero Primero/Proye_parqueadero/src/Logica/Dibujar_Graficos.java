package Logica;

import Conexion.Conectar_base;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.sql.*;
import java.sql.Date;

import javax.swing.*;
import javax.swing.border.LineBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.data.general.DefaultPieDataset;

public class Dibujar_Graficos extends JDialog {

    private Conectar_base cn;
    private PreparedStatement pr;
    private ResultSet resultado;

    public Dibujar_Graficos() {

        cn = new Conectar_base();
        pr = null;
        resultado = null;

    }

    public JPanel getGrafica(int tabla, int modelo, int elegir_tipo_modelo, Date fecha_inicio, Date fecha_final) {

         
        String fecha_valida = "si";
        String sql_query = null;//consulta que ejecuto en  el Prepare
        String nombre_titulo = "Número de Vehiculos Ingresados Actualmente";
        String elegir_modelo = null;
        String texto_bajo_titulo = "# Número Vehiculos";

        String filtar_x_fecha_tb_ingreso = " AND  Fecha_Date BETWEEN '" + fecha_inicio + "' AND  '" + fecha_final + "'";
        String filtar_x_fecha_tb_salida = " WHERE Fecha_Date BETWEEN '" + fecha_inicio + "' AND  '" + fecha_final + "'";

        if (fecha_inicio == null || fecha_final == null) {///filtrar mediante fecha 
            filtar_x_fecha_tb_ingreso = ""; // si llega null limpio  el texto de los dos String para que la consulta ya no sea x fecha
            filtar_x_fecha_tb_salida = "";
            fecha_valida = "";
        }

        switch (tabla) {
            case 0:
                //sentencia pra la tabla autos ingresados
                sql_query = "SELECT Tipo_Vehiculo ,COUNT(Registro) AS CANTIDAD_VEHICULOS FROM autos_ingreso  WHERE Pagado ='NO'" + filtar_x_fecha_tb_ingreso + " GROUP BY Tipo_Vehiculo ORDER BY  CANTIDAD_VEHICULOS  DESC";
                break;
            case 1:
                //sentencia pra la tabla autos  retirados
                sql_query = "SELECT Tipo_Vehiculo ,COUNT(Registro) AS NUMERO_VEH_SALIDA,SUM(Total_Cobrar) AS Suma_vehiculos FROM auto_salida" + filtar_x_fecha_tb_salida + "  GROUP BY Tipo_Vehiculo ORDER BY  Suma_vehiculos DESC";
                nombre_titulo = "Dolares Ingresados por  Vehiculos Retirados";
                texto_bajo_titulo = "Dolares Ingresados";
                break;
            case 2:
                //PLZ Que con esta consulta  solo tomo en cuenta  el campo de las horas , ejemplo si un vehiculo ah permanecido "0 "horas pero 58 minutos  , NO LO TOMA EN CUENTA AL MOMENTO DE GRAFICAR , SOLO TOMA
                //LOS TIPO DE VEHICULOS CUYO CAMPO TOTAL HORAS SEA >0 , REVISAR ESTA CONSULTA HABER SI PUEDO MEJORARLA.
                sql_query = "SELECT Tipo_Vehiculo ,SUM(Tota_en_Horas) AS HORAS_VEHICULOS FROM auto_salida  WHERE Tota_en_Horas >0" + filtar_x_fecha_tb_ingreso + " GROUP BY Tipo_Vehiculo ORDER BY  HORAS_VEHICULOS  DESC";
                nombre_titulo = "Número De Horas Cobradas";
                texto_bajo_titulo = "# Horas ";
                break;
            default:
                break;
        }

        ///////////////////////////////////////////////////////////////////
        if (modelo == 0 && elegir_tipo_modelo == 0) {
            elegir_modelo = "Pastel,normal";

        } else if (modelo == 0 && elegir_tipo_modelo == 1) {
            elegir_modelo = "Pastel,3D";
        } else if (modelo == 1 && elegir_tipo_modelo == 0) {
            elegir_modelo = "Barra,Ho";

        } else if (modelo == 1 && elegir_tipo_modelo == 1) {
            elegir_modelo = "Barra,Ver";
        }
        /////////////////////////////////////////////////////////

        int total_vehi_salidos = 0;//esta variable es pára el  total de vehiculos  por los dolares cobrados, 
        // se mostra al lado  del titulo, solo en el  grafico de barras, y solo si seleccina la tabla 1
        try {

            pr = cn.getConnection().prepareStatement(sql_query);
            resultado = pr.executeQuery();
            ///Crear objetos pástel y de barra 
            DefaultPieDataset modelo_pastel = new DefaultPieDataset();///grafico pastel
            DefaultCategoryDataset modelo_barra = new DefaultCategoryDataset(); ///grafico de barras

            double cantidad_vehiculo = 0; //Sumo todos las cantidad de los vehiculos ingresados actualmente agrupados , para mostrarlo a lado del titulo y ademas esta 
            //mismo variable tambien la utilizo  para la  suma del total de los valores cobrados de autos salidos
            String signo = "  #"; // signo pára  numero de vehiculos

            String dinero = "";
            while (resultado.next()) {

                switch (tabla) {
                    case 0: //PARAMETRO AUTOS INGRESADOS
                        /////////////////Traer ek dinero que  hay por cobrar por los ingresos////////////////////////////////////////////////
                        Tabla_Listar dinero_por_cobrar = null;

                        if (!fecha_valida.isEmpty()) { //consulto por la fecha , para  traer el dinero que esta por cobrar x los ingresos.
                            dinero_por_cobrar = new Tabla_Listar(null, true, null, 5, fecha_inicio, fecha_final, "si", null, ""); // Consulta  por la fecha
                        } else {
                            dinero_por_cobrar = new Tabla_Listar(null, true, null, 2, null, null, "si", null, ""); // consulta  sin la fecha.
                        }

                       
                        /*
                         Traigo el dinero por cobrar de los vehiculos ingresos, los parametros que paso como null , son objetos que no son necesario, por que  solo quiero
                         saber el dinero que hay x cobrar , las validaciones en la clase Tabla_Listar ya estan hechas, cuando le pasos los parametro null.
                         */
                        dinero = " ; $" + String.valueOf(dinero_por_cobrar.getTotal_tabla_ing_salida()); //retorno del dinero por cobrar de los autos ingresados actualmente

                        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        
                        
                        if (modelo == 0) {
                            ///1: nombre_vehiculo,2:  valor
                            modelo_pastel.setValue(resultado.getString("Tipo_Vehiculo") + " :# " + resultado.getInt("CANTIDAD_VEHICULOS"), resultado.getInt("CANTIDAD_VEHICULOS"));

                            //
                        } else if (modelo == 1) {
                            modelo_barra.setValue(resultado.getInt("CANTIDAD_VEHICULOS"), resultado.getString("Tipo_Vehiculo"), resultado.getString("Tipo_Vehiculo") + " :# " + resultado.getInt("CANTIDAD_VEHICULOS"));
                        }
                        cantidad_vehiculo += resultado.getInt("CANTIDAD_VEHICULOS"); // obtengo el totol  de vehiculos ingresados actualmente
                        break;
                    /////////
                    case 1: //PARAMETRO AUTOS RETIRADOS Y DINERO COBRADO O GANADO
                        signo = "  $"; // si  la consulta es por los valores ingresados o ganados el  signo  cambia a Dolar "$ "
                        if (modelo == 0) {
                            ///1: nombre_vehiculo,2:  valor
                            modelo_pastel.setValue(resultado.getString("Tipo_Vehiculo") + " :" + resultado.getDouble("Suma_vehiculos") + " $", resultado.getDouble("Suma_vehiculos"));

                            //
                        } else if (modelo == 1) {
                            modelo_barra.setValue(resultado.getDouble("Suma_vehiculos"), resultado.getString("Tipo_Vehiculo") + " #" + resultado.getString("NUMERO_VEH_SALIDA") + " ", resultado.getString("Tipo_Vehiculo") + " : " + resultado.getDouble("Suma_vehiculos") + " $");
                        }
                        cantidad_vehiculo += resultado.getDouble("Suma_vehiculos");//Obtengo el total de dolares que han generado  los vehiculos retirados
                        total_vehi_salidos += resultado.getInt("NUMERO_VEH_SALIDA"); /// total de vehiculos salidos , se muetra al lado del titulo 
                        break;
                    case 2: //PARAMETRODE HORAS COBRADAS.
                        if (modelo == 0) {

                            ///1: nombre_vehiculo,2:  valor
                            modelo_pastel.setValue(resultado.getString("Tipo_Vehiculo") + " :" + resultado.getInt("HORAS_VEHICULOS") + " Hrs", resultado.getInt("HORAS_VEHICULOS"));

                            //
                        } else if (modelo == 1) {
                            /// modelo_barra.setValue(resultado.getInt("HORAS_VEHICULOS"), resultado.getString("Tipo_Vehiculo") + " #" + resultado.getString("HORAS_VEHICULOS") + " ", resultado.getString("Tipo_Vehiculo") + " : " + resultado.getInt("HORAS_VEHICULOS"));
                            modelo_barra.setValue(resultado.getInt("HORAS_VEHICULOS"), resultado.getString("Tipo_Vehiculo") + " ", resultado.getString("Tipo_Vehiculo") + " : " + resultado.getInt("HORAS_VEHICULOS") + " Hrs");
                        }
                        cantidad_vehiculo += resultado.getDouble("HORAS_VEHICULOS");
                        break;
                    default:
                        break;
                }

            }

            String convertir_double_suma = String.valueOf(cantidad_vehiculo);// Convierto a String la suma de dolares de la tabla salida

            /*
            si la tabla es "0 " le va a quitar los decimales , ya que solo quiero los numero enteros
             */
            if (tabla == 0 || tabla == 2) {
                /*
                "cantidad_vehiculos" es de tipo double  , suma la cantidad de vehiculos de la tabla ingreso y si ingresa en la tabla salida  suma el dinero de los vehiculos salidos.
                lo convierto a String para quitarle los decimales o los 0 ya que la cantidad de vehiculos quiero que 
                muestrre en entero pero utlizando la misma variable que utlizo para sumar  los ingresos de doalres de la tabla salida.
                ya que al mostrar  ene l grafico estoy utizando la misma variable  .
                 */

                convertir_double_suma = cantidad_vehiculo + "";
                int indice = convertir_double_suma.indexOf(".");
                convertir_double_suma = convertir_double_suma.substring(0, indice);  // tomo solo los numero antes del punto

            }

            //JFreeChart chart_grafico = null;
            chart_grafico = null;
            // String hora_vehi = null;

            if (tabla == 1 || tabla == 2) {

                if (tabla == 1) {
                    convertir_double_suma += " ; #" + total_vehi_salidos + " VH"; //agrego el total de vehiculos que han generado el dinero de los vehiculos retirados

                    // hora_vehi = " Vh";
                } else {

                    convertir_double_suma += " Horas"; //agrego el total de vehiculos que han generado el dinero de los vehiculos retirados
                    //hora_vehi = "  Horas";

                }

            }
            if (tabla == 0) {
                convertir_double_suma += " VH";
                

            }

            if (modelo == 0) { /////////////GRAFICA DE PASTEL///////////////////////////////

                if (elegir_modelo.equals("Pastel,normal")) {
                    chart_grafico = ChartFactory.createPieChart(nombre_titulo + signo + convertir_double_suma + dinero, modelo_pastel, true, true, true);

                } else if (elegir_modelo.equals("Pastel,3D")) {
                    chart_grafico = ChartFactory.createPieChart3D(nombre_titulo + signo + convertir_double_suma + dinero, modelo_pastel, true, true, true);
                }

            } else if (modelo == 1) {  /////////////////GRAFICA DE BARRAS

                if (elegir_modelo.equals("Barra,Ho")) {
                    chart_grafico = ChartFactory.createBarChart3D(nombre_titulo + signo + convertir_double_suma + dinero, "Tipo_Vehiculos", texto_bajo_titulo, modelo_barra, PlotOrientation.HORIZONTAL, true, true, true);

                } else if (elegir_modelo.equals("Barra,Ver")) {
                    chart_grafico = ChartFactory.createBarChart3D(nombre_titulo + signo + convertir_double_suma + dinero, "Tipo_Vehiculos", texto_bajo_titulo, modelo_barra, PlotOrientation.VERTICAL, true, true, true);

                }

            }

            if ((tabla == 0 || tabla == 1 || tabla == 2) && elegir_modelo.equals("Pastel,3D")) {

                final PiePlot3D pie_plot = (PiePlot3D) chart_grafico.getPlot();
                pie_plot.setForegroundAlpha(0.69f); // Configuracion del grafico 3D.             
            }

            /*
            Instanciar un boton para agregar al panel 
            
            Cree un Jpanel, el ChartPanel lo agg a este panel nuevo q cree y boton tambien.
            Le aplico un BorderLayout Al panel nuevo  ( ChartPanel en en centro y el boton en South);
             */
            btn_guardar = new JButton("Guardar Grafica");
            btn_guardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn_guardar.setFont(new Font("Arial", Font.BOLD, 16));

            btn_guardar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        String nombre_archivo = JOptionPane.showInputDialog(null, "Ingrese nombre del archivo", "Sistema de Parqueo", JOptionPane.QUESTION_MESSAGE);
                        ChartRenderingInfo informacion = new ChartRenderingInfo(new StandardEntityCollection());

                        if (nombre_archivo != null && !nombre_archivo.isEmpty()) { // solo guarda si el  nombre es diferente de vacio y

                            nombre_archivo += ".png";
                            String direccion_ruta = "C:\\Users\\user\\Desktop\\" + nombre_archivo;

                            File archivo = new File(direccion_ruta);

                            ChartUtilities.saveChartAsPNG(archivo, chart_grafico, 700, 600, informacion);
                            JOptionPane.showMessageDialog(null, "  Grafico Guardado Correctamente" + "\n\n  Ruta: Escritorio", "Sistema de Parqueo", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "No se pudo Guardar el Grafico  " + ex.getMessage());
                    }

                }
            });

            ChartPanel panel = new ChartPanel(chart_grafico, true);
            panel.setBorder(new LineBorder(Color.yellow, 1));
//////////////////////////////////////////////////////////////////////////////////////////////////////
            JPanel nuevo = new JPanel(); //Panel Principal donde ira el CHARTPANEL , EL BOTON 
            nuevo.setLayout(new BorderLayout());

            ///////////AGREGAR  AL PANEL PRINCIPAL NUEVO/////////////////////
            nuevo.add(panel, BorderLayout.CENTER); //agg el CharPanel en el centro del Panel nuevo
            nuevo.add(btn_guardar, BorderLayout.SOUTH);

            return nuevo; //Retorno el panel nuevo , //para agg en el FrameInterno 

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgio un error al  intentar crear el grafico " + e.getMessage());
        }

        return null;
    }

    JFreeChart chart_grafico = null;
    private JButton btn_guardar;

}
