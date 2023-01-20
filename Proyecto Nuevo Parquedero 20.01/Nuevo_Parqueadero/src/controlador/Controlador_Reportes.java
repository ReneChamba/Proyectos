package controlador;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.Map;
import mensajes.Joption;
import modelo.Coneccion;
import modelo.Crud_Primero;
import modelo.Fuentes_Y_Mas;
import modelo.Iconos;
import modelo.Modelo_Nuevo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

import vista.Reportes;

public class Controlador_Reportes implements ActionListener {

    private Reportes reportes;
    private Modelo_Nuevo modelo_nuevo;
    private Crud_Primero crud_primero;
    private Fuentes_Y_Mas fuentes_Y_Mas;
    private Joption mensaje;
    private Iconos iconos;

    public Controlador_Reportes(Reportes reportes, Modelo_Nuevo modelo_nuevo, Crud_Primero crud_primero) {

    }

    public void setCrud_Primero(Crud_Primero crud_primero) {

        this.crud_primero = crud_primero;
    }

    public void setFuentes_Y_Mas(Fuentes_Y_Mas fuentes_Y_Mas) {
        this.fuentes_Y_Mas = fuentes_Y_Mas;
    }

    public void setMensajes(Joption mensajes_2) {
        this.mensaje = mensajes_2;
    }

    public void setIconos(Iconos iconos) {

        this.iconos = iconos;
    }

    public void setModelo_Nuevo(Modelo_Nuevo modelo_nuevo) {
        this.modelo_nuevo = modelo_nuevo;
    }

    public void setReportes(Reportes reportes) {
        this.reportes = reportes;
    }

    public void Estado_Constructor() {
        reportes.btn_generar_rpt.addActionListener(this);
        reportes.combo_parametros.addActionListener(this);
        reportes.setResizable(false);
        reportes.setTitle(fuentes_Y_Mas.getTitulo());
        Diseno();
        Evento_Ventana();
        Restablecer_Fecha();
    }

    private void Diseno() {

        reportes.lb_titulo.setFont(fuentes_Y_Mas.getLetra_Titulos());
        reportes.jLabel2.setFont(fuentes_Y_Mas.getLetra_label());
        reportes.jLabel3.setFont(fuentes_Y_Mas.getLetra_label());
        reportes.jLabel4.setFont(fuentes_Y_Mas.getLetra_label());

        reportes.check_fecha.setFont(fuentes_Y_Mas.getLetra_Txt());
        reportes.combo_parametros.setFont(fuentes_Y_Mas.getLetra_Txt());
        reportes.btn_generar_rpt.setFont(fuentes_Y_Mas.getLetra_btn());
        reportes.btn_generar_rpt.setCursor(fuentes_Y_Mas.getCursor());

        reportes.btn_generar_rpt.setIcon(iconos.getIcono_guardar_archivo());

        reportes.lb_titulo.setForeground(fuentes_Y_Mas.getColor_titulo());
        reportes.panelFecha.setBorder(fuentes_Y_Mas.getBorder("Busqueda Por Fecha", Color.BLACK));
        reportes.btn_generar_rpt.setForeground(fuentes_Y_Mas.getColor_letra_btn());
        reportes.btn_generar_rpt.setBackground(fuentes_Y_Mas.getColor_Fondo_btn());

    }

    public void Iniciar_Componentes() {
        reportes.setLocation(fuentes_Y_Mas.centrar_Pantalla(reportes.getWidth()), 130);
        reportes.setVisible(true);

    }

    private void Restablecer_Fecha() {

        reportes.calendario_inicio.setDate(modelo_nuevo.getFecha_Date());
        reportes.calendario_final.setDate(modelo_nuevo.getFecha_Date_2());
    }

    private void Generar_Grafico() {

        //0: reporte vehiculos ingresados
        //1: reporte vehiculos retirados
        //2: reporte de tipo de vehiculos
        //3: reporte de usuarios
        int parametro = reportes.combo_parametros.getSelectedIndex();

        String ruta_archivo = "";
        boolean seleccion_check = reportes.check_fecha.isSelected();

        switch (parametro) {

            case 0:
                ruta_archivo = "src\\reportes\\rpt_Ingresados.jasper";

                break;
            case 1:
                ruta_archivo = "src\\reportes\\rpt_Salidos.jasper";

                break;
            case 2:
                ruta_archivo = "src\\reportes\\rpt_SalidosLavado.jasper";

                break;
            case 3:
                ruta_archivo = "src\\reportes\\rpt_Salidos_ParqueoLavado.jasper";

                break;

            case 4:
                ruta_archivo = "src\\reportes\\rpt_Tipo_Vehiculo.jasper";
                break;

            case 5:
                ruta_archivo = "src\\reportes\\rpt_Usuarios.jasper";
                break;

        }

        if (seleccion_check) { // si  el check esta seleccionado , se filtra por la fecha

            modelo_nuevo.setFecha__Date(reportes.calendario_inicio.getDate());
            modelo_nuevo.setFecha__Date_Final(reportes.calendario_final.getDate());

        }

        Seleccionar_Reporte(parametro, ruta_archivo, seleccion_check);
    }

    public void Seleccionar_Reporte(int parametro, String ruta_archivo, boolean seleccionFecha) {

        String sms = "Surguio un problema... intentelo mas tarde";

        try {
            /*RLoader.loadObject() solamente se puede usar con un archivo
                file o un inputstream asi que no intentes pasarle la direccion
             */

            boolean verifiRegistros = true;
            if (parametro != 4 && parametro != 5) {// solo para ingresos y salidas(parqueo, lavado, parqueo + lavado) verifico si hay registros para 
                //realizar el reporte

                verifiRegistros = crud_primero.Validar_Reportes(modelo_nuevo, parametro, seleccionFecha);

            }

            if (verifiRegistros) {
                //crear el reporte, o leer desde la ruta de ubicacion
                JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta_archivo);

                Coneccion cn = new Coneccion();
                //mapeo para pasarle los parametros
                Map param = new HashMap();

                if (seleccionFecha) {

                    /*
                    la variable de parametro para filtrar tanto para ingresos como salidas
                    se llaman iguales = filtrar_fecha
                     */
                    String query_Filtrar = "";

                    switch (parametro) {

                        case 0:

                            query_Filtrar = " WHERE  DATE_REGISTRO  ";

                            break;

                        case 1:

                            query_Filtrar = " WHERE  SALIDA_DATE  ";

                            break;

                        case 2:

                            query_Filtrar = " WHERE  FECHA_DATE  ";
                            break;

                        case 3:

                            query_Filtrar = " WHERE  SALIDA_DATE  ";
                            break;
                    }

                    query_Filtrar += "BETWEEN  '" + modelo_nuevo.getFecha__String_Inicio() + "' AND   '" + modelo_nuevo.getFecha__String_Final() + "'";

                    //1 parametro: nombre del parametro
                    //2: valor para el paremetro
                    param.put("filtrar_fecha", query_Filtrar);

                } else {
                    // le paso vacio para que no filtre por la fecha, a los items 4 o 5 no afecta en nada, ellos 
                    //no tiene un parametro definido en la consultar del jasper, asi que ingnoraran ese parametro

                    param.put("filtrar_fecha", "");
                }

                //recibe 3 parametro, el reporte, los parametros (si esq los hay) y la conneccion
                JasperPrint jprin = JasperFillManager.fillReport(reporte, param, cn.getConnection());

                //Genera la vista del reporte
                JRViewer jrv = new JRViewer(jprin);

                //CENTRO EL FORMULARIO
                // modelo_nuevo.getDialogReporte().setLocation(fuentes_Y_Mas.centrar_Pantalla(modelo_nuevo.getDialogReporte().getWidth()), 30);
                // Agrego la vista al dialogo 
                modelo_nuevo.getDialogReporte().setContentPane(jrv);

                //reportes.dispose();
               
                modelo_nuevo.getDialogReporte().setVisible(true);
                 Volver_Estados();
            } else {

                sms = "No hay datos para generar el reporte";
                mensaje.getAceptar(reportes, sms, iconos.getIcono_alerta());

            }

        } catch (JRException | HeadlessException e) {
            mensaje.getAceptar(reportes, sms, iconos.getIcono_alerta());

        }

    }

    private void Volver_Estados() {

        reportes.combo_parametros.setSelectedIndex(0);

        Restablecer_Fecha();
        reportes.check_fecha.setSelected(false);

    }

    private void Evento_Ventana() {

        WindowListener evento = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                Volver_Estados();

            }

        };
        reportes.addWindowListener(evento);

    }

    private void habiliarFecha() {

        //Metodo para habilitar o desabilitar  el panel de los calendarios
        int index = reportes.combo_parametros.getSelectedIndex();

        boolean habilitar = false;
        if (index < 4) {// Solo para el indez 0, 1, 2 y 3 habilita el panel para filtrar 
            habilitar = true;

        }
        reportes.calendario_inicio.setEnabled(habilitar);
        reportes.calendario_final.setEnabled(habilitar);
        reportes.check_fecha.setEnabled(habilitar);
        reportes.check_fecha.setSelected(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == reportes.btn_generar_rpt) {
            Generar_Grafico();
        }

        if (e.getSource() == reportes.combo_parametros) {

            habiliarFecha();
        }

    }

}
