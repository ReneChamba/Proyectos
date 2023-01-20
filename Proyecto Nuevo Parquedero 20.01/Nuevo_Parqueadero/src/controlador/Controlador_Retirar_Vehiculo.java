package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import modelo.Crud_Primero;
import modelo.Modelo_Nuevo;
import vista.Retirar_Vehiculo;
import mensajes.Joption;
import modelo.Fuentes_Y_Mas;
import modelo.Iconos;
import modelo.Transparente;

public class Controlador_Retirar_Vehiculo implements ActionListener, KeyListener {

    private Modelo_Nuevo modelo_nuevo;
    private Crud_Primero crud_primero;
    private Retirar_Vehiculo retirar_vehiculo;
    private Fuentes_Y_Mas fuentes_Y_Mas;
    private Joption mensaje;
    private Iconos iconos;
    private Controlador_Sms controlador_sms;
    private Controlador_Menu_Principal controlador_menu_principal;

    public Controlador_Retirar_Vehiculo() {

    }

    public void setRetirar_Vehiculo(Retirar_Vehiculo retirar_vehiculo) {
        this.retirar_vehiculo = retirar_vehiculo;
    }

    public void setModelo_nuevo(Modelo_Nuevo modelo_nuevo) {
        this.modelo_nuevo = modelo_nuevo;
    }

    public void setCrud_Primero(Crud_Primero crud_primero) {
        this.crud_primero = crud_primero;
    }

    public void setIconos(Iconos iconos) {
        this.iconos = iconos;
    }

    public void setMensajes(Joption mensajes_2) {
        this.mensaje = mensajes_2;
    }

    public void setFuentes_Y_Mas(Fuentes_Y_Mas fuentes_Y_Mas) {
        this.fuentes_Y_Mas = fuentes_Y_Mas;
    }

    public void setLanzar_Mensaje(Controlador_Sms controlador_sms) {
        this.controlador_sms = controlador_sms;
    }

    public void setControlador_Menu_Principal(Controlador_Menu_Principal controlador_menu_principal) {
        this.controlador_menu_principal = controlador_menu_principal;
    }

    public void Estados_Contructor() {
        retirar_vehiculo.btn_limpiar.addActionListener(this);
        retirar_vehiculo.btn_cobrar.addActionListener(this);
        retirar_vehiculo.txt_buscar_placa.addKeyListener(this);
        Transparente txt_placa = new Transparente("Ingrese placa y presione Enter para buscar ", retirar_vehiculo.txt_buscar_placa, Transparente.Show.ALWAYS);
        retirar_vehiculo.setResizable(false);
        retirar_vehiculo.setTitle(fuentes_Y_Mas.getTitulo());
        Ocultar_Controlea(false);
        Deshabilitar_Cajas();
        Evento_Ventana();
        Diseno();

    }

    private void Diseno() {
        retirar_vehiculo.lb_titulo.setFont(fuentes_Y_Mas.getLetra_Titulos());
        retirar_vehiculo.lb_tota_horas.setFont(fuentes_Y_Mas.getLetra_label());
        retirar_vehiculo.lb_tot_minu.setFont(fuentes_Y_Mas.getLetra_label());
        retirar_vehiculo.lb_tipo_vhiculo.setFont(fuentes_Y_Mas.getLetra_label());
        retirar_vehiculo.lb_propietario.setFont(fuentes_Y_Mas.getLetra_label());
        retirar_vehiculo.lb_placa.setFont(fuentes_Y_Mas.getLetra_label());
        retirar_vehiculo.lb_fe_salida.setFont(fuentes_Y_Mas.getLetra_label());
        retirar_vehiculo.lb_fe_ingreso.setFont(fuentes_Y_Mas.getLetra_label());
        retirar_vehiculo.lb_costo.setFont(fuentes_Y_Mas.getLetra_label());
        retirar_vehiculo.lb_name_lavado.setFont(fuentes_Y_Mas.getLetra_label());
        retirar_vehiculo.lb_name_motivo.setFont(fuentes_Y_Mas.getLetra_label());
        retirar_vehiculo.lb_name_parqueo.setFont(fuentes_Y_Mas.getLetra_label());

        retirar_vehiculo.lb_total_lavado.setFont(fuentes_Y_Mas.getLetra_Txt());

        retirar_vehiculo.lb_total_parqueo.setFont(fuentes_Y_Mas.getLetra_Txt());
        retirar_vehiculo.lb_motivo.setFont(fuentes_Y_Mas.getLetra_Txt());

        //=======================================================================
        retirar_vehiculo.txt_buscar_placa.setFont(fuentes_Y_Mas.getLetra_Txt());
        retirar_vehiculo.txt_cobrar.setFont(fuentes_Y_Mas.getLetra_Titulos());
        retirar_vehiculo.txt_fecha_ingreso.setFont(fuentes_Y_Mas.getLetra_Txt());
        retirar_vehiculo.txt_fecha_salida.setFont(fuentes_Y_Mas.getLetra_Txt());
        retirar_vehiculo.txt_horas.setFont(fuentes_Y_Mas.getLetra_Txt());
        retirar_vehiculo.txt_minutos.setFont(fuentes_Y_Mas.getLetra_Txt());
        retirar_vehiculo.txt_precio.setFont(fuentes_Y_Mas.getLetra_Txt());
        retirar_vehiculo.txt_propietario.setFont(fuentes_Y_Mas.getLetra_Txt());
        retirar_vehiculo.txt_tipo.setFont(fuentes_Y_Mas.getLetra_Txt());

        retirar_vehiculo.txt_buscar_placa.setHorizontalAlignment(fuentes_Y_Mas.getHorientacion());
        retirar_vehiculo.txt_cobrar.setHorizontalAlignment(fuentes_Y_Mas.getHorientacion());
        retirar_vehiculo.txt_fecha_ingreso.setHorizontalAlignment(fuentes_Y_Mas.getHorientacion());
        retirar_vehiculo.txt_fecha_salida.setHorizontalAlignment(fuentes_Y_Mas.getHorientacion());
        retirar_vehiculo.txt_horas.setHorizontalAlignment(fuentes_Y_Mas.getHorientacion());
        retirar_vehiculo.txt_minutos.setHorizontalAlignment(fuentes_Y_Mas.getHorientacion());
        retirar_vehiculo.txt_precio.setHorizontalAlignment(fuentes_Y_Mas.getHorientacion());
        retirar_vehiculo.txt_propietario.setHorizontalAlignment(fuentes_Y_Mas.getHorientacion());
        retirar_vehiculo.txt_tipo.setHorizontalAlignment(fuentes_Y_Mas.getHorientacion());

        //==================================================================
        retirar_vehiculo.btn_cobrar.setFont(fuentes_Y_Mas.getLetra_btn());
        retirar_vehiculo.btn_cobrar.setCursor(fuentes_Y_Mas.getCursor());
        retirar_vehiculo.btn_limpiar.setCursor(fuentes_Y_Mas.getCursor());
        retirar_vehiculo.panel_datos.setBorder(fuentes_Y_Mas.getBorder("Datos Vehiculo", Color.BLACK));
        retirar_vehiculo.panel_valores.setBorder(fuentes_Y_Mas.getBorder("Valores A Cobrar", Color.BLACK));

        retirar_vehiculo.lb_titulo.setForeground(fuentes_Y_Mas.getColor_titulo());
        retirar_vehiculo.btn_cobrar.setForeground(fuentes_Y_Mas.getColor_letra_btn());
        retirar_vehiculo.btn_cobrar.setBackground(fuentes_Y_Mas.getColor_Fondo_btn());

        retirar_vehiculo.btn_limpiar.setForeground(fuentes_Y_Mas.getColor_letra_btn());
        retirar_vehiculo.btn_limpiar.setBackground(fuentes_Y_Mas.getColor_Fondo_btn());

        retirar_vehiculo.txt_cobrar.setBorder(fuentes_Y_Mas.getBorderlinea(fuentes_Y_Mas.getColor_Bien()));

    }

    public void Iniciar_Componentes(boolean doble_click, String placa) {

        retirar_vehiculo.setLocation(fuentes_Y_Mas.centrar_Pantalla(retirar_vehiculo.getWidth()), 130);
        retirar_vehiculo.btn_limpiar.setEnabled(false);
        retirar_vehiculo.btn_cobrar.setEnabled(false);

        if (!doble_click) {
            Buscar_Placa(placa);
            retirar_vehiculo.txt_buscar_placa.setText(placa);
            retirar_vehiculo.btn_limpiar.setEnabled(true);

        }

        retirar_vehiculo.setVisible(true);
    }

    private void Ocultar_Controlea(boolean visible) {

        retirar_vehiculo.lb_costo.setVisible(visible);
        retirar_vehiculo.txt_precio.setVisible(visible);

        retirar_vehiculo.lb_tota_horas.setVisible(visible);
        retirar_vehiculo.txt_horas.setVisible(visible);

        retirar_vehiculo.lb_tot_minu.setVisible(visible);
        retirar_vehiculo.txt_minutos.setVisible(visible);

    }

    private void Asignar_Limpiar(String propietaro, String tipo, String fecha_ingreso, String fecha_Salida, String precio,
            String t_horas, String t_minutos, String cobrar, String motivo, String precio_lavado, String precio_parqueo, boolean limpiar_placa) {

        retirar_vehiculo.txt_propietario.setText(propietaro);
        retirar_vehiculo.txt_tipo.setText(tipo);
        retirar_vehiculo.txt_fecha_ingreso.setText(fecha_ingreso);
        retirar_vehiculo.txt_fecha_salida.setText(fecha_Salida);
        retirar_vehiculo.txt_precio.setText(precio);

        retirar_vehiculo.txt_horas.setText(t_horas);
        retirar_vehiculo.txt_minutos.setText(t_minutos);
        retirar_vehiculo.lb_motivo.setText(motivo);
        retirar_vehiculo.lb_total_lavado.setText(precio_lavado);

        if (limpiar_placa) {

            //PONE DIRECTAMENTE LO QUE LE LLEGA  , SOLO LIMPIA 
            retirar_vehiculo.txt_buscar_placa.setText("");
            retirar_vehiculo.lb_total_parqueo.setText(precio_parqueo);
            retirar_vehiculo.txt_cobrar.setText(cobrar);
            Ocultar_Controlea(false);

        } else {

            //CUANDO VA A COBRAR DEBE DE PARSEAR CIEERTO VALORES
            if (!motivo.equalsIgnoreCase("Lavado")) {//  cuando es parqueo o lavado + parqueo

                retirar_vehiculo.lb_total_parqueo.setText(cobrar); //cobrar el precio del parqueo
                Ocultar_Controlea(true);
            } else {
                retirar_vehiculo.lb_total_parqueo.setText("Ninguna");
            }

            double total_cobrarb = 0;

            if (motivo.equalsIgnoreCase("Lavado")) {

                total_cobrarb = Double.parseDouble(precio_lavado);

            } else if (motivo.equalsIgnoreCase("Parqueo")) {

                total_cobrarb = Double.parseDouble(cobrar);

            } else {

                total_cobrarb = Double.parseDouble(precio_lavado) + Double.parseDouble(cobrar);
            }

            retirar_vehiculo.txt_cobrar.setText("" + total_cobrarb);
        }

    }

    private void Buscar_Placa(String placa) {

        if (placa.isEmpty()) {// esto casi nunca va a pasar, metodo  validado en el keyReleased
            mensaje.getAceptar(retirar_vehiculo, "Ingrese la  placa..", iconos.getIcono_alerta());

        } else {
            modelo_nuevo.setPlaca(placa);

            if (crud_primero.Buscar_PLaca(modelo_nuevo, true)) {

                Asignar_Limpiar(modelo_nuevo.getPropietario(), modelo_nuevo.getTipo_vehiculo(), modelo_nuevo.getFecha_registro(), modelo_nuevo.getFecha_Ingresar_Actual(true),
                        modelo_nuevo.getPrecio_hora(), modelo_nuevo.getNumero_horas(), modelo_nuevo.getNumero_minutos(), modelo_nuevo.getTotal_Cobrar(), modelo_nuevo.getMotivo_Ingreso(),
                        modelo_nuevo.getPrecio_lavado(), modelo_nuevo.getPrecio_parqueo(), false);

                //btn limpiar esta validado en el key Released para que se active
                retirar_vehiculo.btn_cobrar.setEnabled(true);
                retirar_vehiculo.txt_buscar_placa.setEditable(false);
                //mando el foco para ese texto , para que el evento cobrar que tiene el key pressed del txt placa
                retirar_vehiculo.txt_cobrar.requestFocus();

            } else {
                controlador_sms.Iniciar_Componentes("Placa no está registrada", fuentes_Y_Mas.getColor_Mal());
            }
        }

    }

    private void Deshabilitar_Cajas() {

        retirar_vehiculo.txt_propietario.setEditable(false);
        retirar_vehiculo.txt_fecha_ingreso.setEditable(false);
        retirar_vehiculo.txt_fecha_salida.setEditable(false);
        retirar_vehiculo.txt_precio.setEditable(false);
        retirar_vehiculo.txt_tipo.setEditable(false);
        retirar_vehiculo.txt_horas.setEditable(false);
        retirar_vehiculo.txt_minutos.setEditable(false);
        retirar_vehiculo.txt_cobrar.setEditable(false);

    }

    /**
     * Metodo para cobrar el parqueadero Primero Elimina ese ingreso, luego
     * insertar los datos recuperado de las cajas de textto , en la tabla
     * correspondientes de salida,
     */
    private void Cobrar_Parqueadero() {

        String placa = retirar_vehiculo.txt_buscar_placa.getText().trim();
        modelo_nuevo.setPlaca(placa);
        String sms = "Surguio un error al eliminar el registro";
        Color color = Color.GREEN;

        //Si retorna true , elimino el registro correctamente y prosigo a guardar los datos en las tablas de salida
        if (crud_primero.Eliminar_Ingreso(modelo_nuevo)) { // plz , podria ser al revez , primero que inserte y al ultmo que elimine

            sms = "Vehiculo Cobrado con exito";
            String motivo = retirar_vehiculo.lb_motivo.getText().trim();
            //REALIZAR LOS DIFERENTE INSERT EN LAS TABLAS CORRESPONDIENTES DEPENDIENTE  EL MOTIVO
            //TABLA DE PARQUEO
            //TABLA DE LAVADO
            //TABLA PARQUEO + LAVADO

            //estos tres parametro mas la placa que ya le pase mas arriba,  son compartidas paras las tres tablas
            String tipo_vehiculo = retirar_vehiculo.txt_tipo.getText();
            String fecha_registro = retirar_vehiculo.txt_fecha_ingreso.getText();
            String cobrado = retirar_vehiculo.txt_cobrar.getText();

            modelo_nuevo.setTipo_vehiculo(tipo_vehiculo);
            modelo_nuevo.setFecha_registro(fecha_registro);
            modelo_nuevo.setTotal_Cobrar(cobrado);

            if (motivo.equalsIgnoreCase("Lavado")) {

                if (!crud_primero.Ingresar_tabla_Lavado(modelo_nuevo)) {

                    sms = "Surguio un error! .....intentenlo de nuevo";
                    color = Color.ORANGE;
                }

            } else {

                String fecha_salida = retirar_vehiculo.txt_fecha_salida.getText();
                String precio_hora = retirar_vehiculo.txt_precio.getText();
                String t_horas = retirar_vehiculo.txt_horas.getText();
                String t_minutos = retirar_vehiculo.txt_minutos.getText();
                modelo_nuevo.setFecha_salida(fecha_salida);
                modelo_nuevo.setPrecio_hora(precio_hora);
                modelo_nuevo.setNumero_horas(t_horas);
                modelo_nuevo.setNumero_minutos(t_minutos);

                switch (motivo.trim()) {

                    case "Parqueo":

                        if (!crud_primero.Ingresar_tabla_salidos(modelo_nuevo)) {
                            sms = "Surguio un error.....";
                            color = Color.ORANGE;
                        }
                        break;

                    case "Lavado + Parqueo":

                        /*
                          PARA LA TABLA LAVADO MAS PARQUEO
                    
                          el total a cobrar para el parqueo + lavado va a estar en el txt cobrar , que ya lo pase mas arriba
                         */
                        String solo_lavado = retirar_vehiculo.lb_total_lavado.getText().trim();
                        String solo_parqueo = retirar_vehiculo.lb_total_parqueo.getText().trim();
                        modelo_nuevo.setPrecio_lavado(solo_lavado);
                        modelo_nuevo.setPrecio_parqueo(solo_parqueo);

                        if (!crud_primero.Ingresar_tabla_Lavado_Parqueo(modelo_nuevo)) {
                            sms = "Surguio un error.....";
                            color = Color.ORANGE;

                        }

                        break;

                }

            }

            //Actualizar el valor del btn en la barra de estado del menu principal
            crud_primero.Numero_Vehiculos_Ingresados(modelo_nuevo);
            controlador_menu_principal.Poner_Cantidad_Vehiculos("" + modelo_nuevo.getContador_Registros());

            Asignar_Limpiar("", "", "", "", "",
                    "", "", "0.00", "Ninguna", "0", "0", true);
            retirar_vehiculo.txt_buscar_placa.setEditable(true);
            retirar_vehiculo.btn_limpiar.setEnabled(false);
            retirar_vehiculo.btn_cobrar.setEnabled(false);
            retirar_vehiculo.txt_buscar_placa.requestFocus();
        }
        controlador_sms.Iniciar_Componentes(sms, color);
    }

    private void Evento_Ventana() {

        WindowListener evento = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                Asignar_Limpiar("", "", "", "", "",
                        "", "", "0.00", "Ninguna", "0", "0", true);
                retirar_vehiculo.txt_buscar_placa.setEditable(true);
                retirar_vehiculo.btn_cobrar.setEnabled(false);
                retirar_vehiculo.btn_limpiar.setEnabled(false);

            }

        };
        retirar_vehiculo.addWindowListener(evento);

    }

    //###################EVENTOS#############################################################################
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == retirar_vehiculo.btn_limpiar) {
            Asignar_Limpiar("", "", "", "", "",
                    "", "", "0.00", "Ninguna", "0", "0", true);
            retirar_vehiculo.txt_buscar_placa.setEditable(true);
            retirar_vehiculo.txt_buscar_placa.requestFocus();
            retirar_vehiculo.btn_cobrar.setEnabled(false);
            retirar_vehiculo.btn_limpiar.setEnabled(false);
        }

        if (e.getSource() == retirar_vehiculo.btn_cobrar) {
            Cobrar_Parqueadero();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

        char letra = e.getKeyChar();

        if (Character.isLowerCase(letra)) {
            String convertir = ("" + letra).toUpperCase();
            letra = convertir.charAt(0);
            e.setKeyChar(letra);

        }

        if (letra == ' ') {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyChar() == KeyEvent.VK_ENTER) {

            int dis = retirar_vehiculo.txt_buscar_placa.getText().trim().length();

            if (dis > 3) { //valido para que cuando haya almenos  4 caracteres ingresados en txt_placa , recien busque
                Buscar_Placa(retirar_vehiculo.txt_buscar_placa.getText().trim());

            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (retirar_vehiculo.txt_buscar_placa.getText().trim().length() > 0) {
            retirar_vehiculo.btn_limpiar.setEnabled(true);

        } else {
            retirar_vehiculo.btn_limpiar.setEnabled(false);
        }

    }

}
