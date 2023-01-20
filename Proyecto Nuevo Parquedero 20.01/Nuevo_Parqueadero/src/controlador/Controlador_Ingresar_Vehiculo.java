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
import vista.Ingresar_Vehiculo;
import mensajes.Joption;
import modelo.Fuentes_Y_Mas;
import modelo.Iconos;
import modelo.Transparente;

public class Controlador_Ingresar_Vehiculo implements ActionListener, KeyListener {

    private Ingresar_Vehiculo ingresar_vehiculo;
    private Modelo_Nuevo modelo_nuevo;
    private Crud_Primero crud_primero;
    private Iconos iconos;
    private Joption mensajes;
    private Fuentes_Y_Mas fuentes_Y_mas;
    private Controlador_Sms controlador_sms;
    private Controlador_Menu_Principal controlador_menu_principal;

    public Controlador_Ingresar_Vehiculo() {

    }

    public void setIngresar_Vehiculo(Ingresar_Vehiculo ingresar_vehiculo) {
        this.ingresar_vehiculo = ingresar_vehiculo;
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
        this.mensajes = mensajes_2;
    }

    public void setFuentes_Y_Mas(Fuentes_Y_Mas fuentes_Y_Mas) {
        this.fuentes_Y_mas = fuentes_Y_Mas;
    }

    public void setLanzar_Mensaje(Controlador_Sms controlador_sms) {
        this.controlador_sms = controlador_sms;
    }

    public void setControlador_Menu_Principal(Controlador_Menu_Principal controlador_menu_principal) {
        this.controlador_menu_principal = controlador_menu_principal;
    }

    public void Iniciar_Constructor() {

        ingresar_vehiculo.grupo_botones.add(ingresar_vehiculo.check_lavado);
        ingresar_vehiculo.grupo_botones.add(ingresar_vehiculo.check_parqueo);
        ingresar_vehiculo.grupo_botones.add(ingresar_vehiculo.check_todo);
        ingresar_vehiculo.check_parqueo.setSelected(true);

        ingresar_vehiculo.btn_iregistrar_vehiculo.addActionListener(this);
        ingresar_vehiculo.check_lavado.addActionListener(this);
        ingresar_vehiculo.check_parqueo.addActionListener(this);
        ingresar_vehiculo.check_todo.addActionListener(this);

        ingresar_vehiculo.txt_propietario.addKeyListener(this);
        ingresar_vehiculo.txt_placa.addKeyListener(this);
        ingresar_vehiculo.txt_precio_lavado.addKeyListener(this);
        ingresar_vehiculo.setResizable(false);
        ingresar_vehiculo.setTitle(fuentes_Y_mas.getTitulo());
        ingresar_vehiculo.txt_precio_lavado.setVisible(false);
        ingresar_vehiculo.btn_iregistrar_vehiculo.setEnabled(false);
        Evento_Ventana();
        Diseno();

    }

    private void Diseno() {

        ingresar_vehiculo.lb_titulo.setFont(fuentes_Y_mas.getLetra_Titulos());
        ingresar_vehiculo.lb_placa.setFont(fuentes_Y_mas.getLetra_label());
        ingresar_vehiculo.lb_propietario.setFont(fuentes_Y_mas.getLetra_label());
        ingresar_vehiculo.lb_tipo.setFont(fuentes_Y_mas.getLetra_label());
        ingresar_vehiculo.lb_motivo.setFont(fuentes_Y_mas.getLetra_label());
        //===========================================================
        ingresar_vehiculo.txt_placa.setFont(fuentes_Y_mas.getLetra_Txt());
        ingresar_vehiculo.txt_propietario.setFont(fuentes_Y_mas.getLetra_Txt());
        ingresar_vehiculo.txt_precio_lavado.setFont(fuentes_Y_mas.getLetra_Txt());
        ingresar_vehiculo.combo_vehiculos.setFont(fuentes_Y_mas.getLetra_Txt());

        ingresar_vehiculo.check_lavado.setFont(fuentes_Y_mas.getLetra_Txt());
        ingresar_vehiculo.check_parqueo.setFont(fuentes_Y_mas.getLetra_Txt());
        ingresar_vehiculo.check_todo.setFont(fuentes_Y_mas.getLetra_Txt());
        ingresar_vehiculo.txt_propietario.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        ingresar_vehiculo.txt_placa.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        ingresar_vehiculo.txt_precio_lavado.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());

        Transparente tx_placa = new Transparente("Ingresa la Placa", ingresar_vehiculo.txt_placa, Transparente.Show.ALWAYS);
        Transparente tx_nombre = new Transparente("Nombre propietario", ingresar_vehiculo.txt_propietario, Transparente.Show.ALWAYS);
        Transparente tx_precio_lavado = new Transparente("Precio Lavado", ingresar_vehiculo.txt_precio_lavado, Transparente.Show.ALWAYS);

        //==================================================================0
        ingresar_vehiculo.btn_iregistrar_vehiculo.setFont(fuentes_Y_mas.getLetra_btn());
        ingresar_vehiculo.btn_iregistrar_vehiculo.setCursor(fuentes_Y_mas.getCursor());
        //=================================================================
        ingresar_vehiculo.combo_vehiculos.setCursor(fuentes_Y_mas.getCursor());

        ingresar_vehiculo.lb_titulo.setForeground(fuentes_Y_mas.getColor_titulo());

        ingresar_vehiculo.btn_iregistrar_vehiculo.setForeground(fuentes_Y_mas.getColor_letra_btn());
        ingresar_vehiculo.btn_iregistrar_vehiculo.setBackground(fuentes_Y_mas.getColor_Fondo_btn());
    }

    public void Iniciar_Componentes() {
        ingresar_vehiculo.setLocation(fuentes_Y_mas.centrar_Pantalla(ingresar_vehiculo.getWidth()), 130);
        Cargar_Combo();

        ingresar_vehiculo.setVisible(true);

    }

    private void Limpiar_Cajas() {

        ingresar_vehiculo.txt_propietario.setText("");
        ingresar_vehiculo.txt_placa.setText("");
        ingresar_vehiculo.txt_precio_lavado.setText("");
        ingresar_vehiculo.txt_precio_lavado.setVisible(false);
        ingresar_vehiculo.check_parqueo.setSelected(true);
        ingresar_vehiculo.combo_vehiculos.setSelectedIndex(0);
    }

    private void Cargar_Combo() {

        ingresar_vehiculo.combo_vehiculos.removeAllItems();

        modelo_nuevo.setCombo_tipo(ingresar_vehiculo.combo_vehiculos);

        if (!crud_primero.Llenar_Combo_tipo_Vehiculo(modelo_nuevo)) {

            mensajes.getAceptar(ingresar_vehiculo, "Surguio un error llenar el combo", iconos.getIcono_alerta());
        }

    }

    private String[] getMotivo_Y_Mas() {

        String[] opciones_ingreso = new String[3];

        String motivo_ingreso = "Parqueo";
        String precio_Lavado = "Ninguna";
        String precio_Parqueo = "Por definir";

        if (ingresar_vehiculo.check_parqueo.isSelected() == false) {

            precio_Lavado = ingresar_vehiculo.txt_precio_lavado.getText().trim();

            motivo_ingreso = "Lavado";
            precio_Parqueo = "Ninguna";

            if (ingresar_vehiculo.check_todo.isSelected()) {
                motivo_ingreso = "Lavado + Parqueo";
                precio_Parqueo = "Por definir";

            }

        }

        opciones_ingreso[0] = motivo_ingreso;
        opciones_ingreso[1] = precio_Lavado;
        opciones_ingreso[2] = precio_Parqueo;

        return opciones_ingreso;

    }

    private void Ingresar_Vehiculo() {

        String txt_propietario = ingresar_vehiculo.txt_propietario.getText().trim().toUpperCase();
        String txt_placa = ingresar_vehiculo.txt_placa.getText().trim();
        String tipo_vehiculo = ingresar_vehiculo.combo_vehiculos.getSelectedItem().toString();

        modelo_nuevo.setPlaca(txt_placa);
        modelo_nuevo.setEstado_vehiculo("NO");
        String sms = "Vehiculo Se encuentra ingresado actualmente";
        Color color = fuentes_Y_mas.getColor_Mal();

        //si retorna true el vehiculo esta ingresado actualmente, // como le paso falso no importa que nuemro le pase , es importante cuando le paso true
        if (crud_primero.Buscar_PLaca(modelo_nuevo, false) == false) {  // si retorna false es una placa nueva

            //ESTE ARRAY DETERMINADA EL MOTIVO DE INGRESO, EL PRECIO LAVADO Y EL PRECIO DEL PARQUEO
            String getOpciones_Ingreso[] = getMotivo_Y_Mas();
            modelo_nuevo.setPropietario(txt_propietario);
            modelo_nuevo.setPlaca(txt_placa);
            modelo_nuevo.setTipo_vehiculo(tipo_vehiculo);
            modelo_nuevo.setMotivo_Ingreso(getOpciones_Ingreso[0]);
            modelo_nuevo.setPrecio_lavado(getOpciones_Ingreso[1]);
            modelo_nuevo.setPrecio_parqueo(getOpciones_Ingreso[2]);

            sms = "Surguio un error , intentelo mas tarde";
            if (crud_primero.Ingresar_Vehiculo(modelo_nuevo)) {
                sms = "Vehiculo Ingresado Correctamente";
                color = fuentes_Y_mas.getColor_Bien();
                //Actualizar el valor de la cantidad de vehiculos ingresados, del boton que esta 
                //en la barra de estado
                crud_primero.Numero_Vehiculos_Ingresados(modelo_nuevo);

                controlador_menu_principal.Poner_Cantidad_Vehiculos("" + modelo_nuevo.getContador_Registros());

            }
        }

        Limpiar_Cajas();

        //pase lo que pase bloqueae el boton....
        ingresar_vehiculo.btn_iregistrar_vehiculo.setEnabled(false);
        controlador_sms.Iniciar_Componentes(sms, color);

    }

    private void Evento_Ventana() {

        WindowListener evento = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {

                Limpiar_Cajas();
                ingresar_vehiculo.btn_iregistrar_vehiculo.setEnabled(false);

            }

        };
        ingresar_vehiculo.addWindowListener(evento);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object control = e.getSource();

        if (control == ingresar_vehiculo.btn_iregistrar_vehiculo) {
            Ingresar_Vehiculo();
        }

        if (control == ingresar_vehiculo.check_parqueo) {

            ingresar_vehiculo.txt_precio_lavado.setText("");

            ingresar_vehiculo.txt_precio_lavado.setVisible(false);
            boolean estado = true;
            if (!Longitud_TX()) {
                estado = false;

            }
            ingresar_vehiculo.btn_iregistrar_vehiculo.setEnabled(estado);

        }

        if (control == ingresar_vehiculo.check_lavado || control == ingresar_vehiculo.check_todo) {
            ingresar_vehiculo.txt_precio_lavado.setText("");
            ingresar_vehiculo.txt_precio_lavado.setVisible(true);

            ingresar_vehiculo.btn_iregistrar_vehiculo.setEnabled(false);

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

        if (e.getSource() == ingresar_vehiculo.txt_propietario) {

            char letra = e.getKeyChar();

            if (Character.isLowerCase(letra)) {

                String mayus = (letra + "").toUpperCase();
                letra = mayus.charAt(0);
                e.setKeyChar(letra);

            }

            if ((letra < 'A' || letra > 'Z') && (letra != ' ')) {
                e.consume();
            }

        }

        if (e.getSource() == ingresar_vehiculo.txt_placa) {

            char letra = e.getKeyChar();

            if (Character.isLowerCase(letra)) {

                String mayus = (letra + "").toUpperCase();
                letra = mayus.charAt(0);
                e.setKeyChar(letra);

            }

            if ((letra == ' ')) {
                e.consume();
            }

        }

        if (e.getSource() == ingresar_vehiculo.txt_precio_lavado) {

            char letra = e.getKeyChar();
            //PARA QUE EL PRIMER CARACTER ESE TEXT NO SEA UN PUNTO
            if (ingresar_vehiculo.txt_precio_lavado.getText().length() == 0 && letra == '.') {

                e.consume();
            }

            if ((letra < '0' || letra > '9') && (letra != '.')) {
                e.consume();
            }

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (e.getSource() == ingresar_vehiculo.txt_placa) {

                ingresar_vehiculo.txt_propietario.requestFocus();

            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (e.getSource() == ingresar_vehiculo.txt_propietario) {

                ingresar_vehiculo.txt_placa.requestFocus();
            }
        }

    }

    private boolean Longitud_TX() {

        return ingresar_vehiculo.txt_placa.getText().trim().length() > 3 && ingresar_vehiculo.txt_propietario.getText().trim().length() > 1;

    }

    @Override
    public void keyReleased(KeyEvent e) {

        boolean estado = true;
        if (!Longitud_TX()) {
            estado = false;

        }
        ingresar_vehiculo.btn_iregistrar_vehiculo.setEnabled(estado);

        //text de ingresar valor lavaado
        if (ingresar_vehiculo.check_lavado.isSelected() || ingresar_vehiculo.check_todo.isSelected()) {

            estado = true;
            if (ingresar_vehiculo.txt_precio_lavado.getText().isEmpty() || Longitud_TX() == false) {

                estado = false;
            }
            ingresar_vehiculo.btn_iregistrar_vehiculo.setEnabled(estado);

        }

    }

}
