package controlador;

import java.awt.Color;
import modelo.Crud_Primero;
import modelo.Modelo_Nuevo;
import vista.Configurar_Tipo_Vehiculos;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import mensajes.Joption;
import modelo.Fuentes_Y_Mas;
import modelo.Iconos;

public class Controlador_Confi_Vehiculos implements ActionListener, KeyListener, MouseListener {

    private Modelo_Nuevo modelo_nuevo;
    private Crud_Primero crud_primero;
    private Configurar_Tipo_Vehiculos configurar_tipo_vehiculos;
    private Fuentes_Y_Mas fuentes_Y_mas;
    private Joption mensajes;
    private Iconos iconos;
    private Controlador_Sms controlador_sms;
    private Controlador_Sms_Pregunta controlador_sms_pregunta;

    public Controlador_Confi_Vehiculos() {

    }

    public void setConfigurar_Tipo_Vehiculo(Configurar_Tipo_Vehiculos configurar_tipo_vehiculos) {
        this.configurar_tipo_vehiculos = configurar_tipo_vehiculos;
    }

    public void setModelo_nuevo(Modelo_Nuevo modelo_nuevo) {
        this.modelo_nuevo = modelo_nuevo;
    }

    public void setCrud_Primero(Crud_Primero crud_primero) {
        this.crud_primero = crud_primero;
    }

    public void setFuentes_Y_Mas(Fuentes_Y_Mas fuentes_Y_Mas) {
        this.fuentes_Y_mas = fuentes_Y_Mas;
    }

    public void setMensajes(Joption mensajes_2) {
        this.mensajes = mensajes_2;
    }

    public void setIconos(Iconos iconos) {
        this.iconos = iconos;
    }

    public void setLanzar_Mensaje(Controlador_Sms controlador_sms) {
        this.controlador_sms = controlador_sms;
    }

    public void setcontrolador_Sms_Pregunta(Controlador_Sms_Pregunta controlador_Sms_Pregunta) {
        this.controlador_sms_pregunta = controlador_Sms_Pregunta;
    }

    public void Estados_Constructor() {

        configurar_tipo_vehiculos.btn_agregar.addActionListener(this);

        configurar_tipo_vehiculos.txt_precio.addKeyListener(this);
        configurar_tipo_vehiculos.txt_nombre_vehiculo.addKeyListener(this);
        configurar_tipo_vehiculos.tabla.addMouseListener(this);
        configurar_tipo_vehiculos.tabla.addKeyListener(this);

        configurar_tipo_vehiculos.lb_nombre_vehi.setVisible(false);
        configurar_tipo_vehiculos.lb_precio.setVisible(false);

        configurar_tipo_vehiculos.txt_nombre_vehiculo.setVisible(false);
        configurar_tipo_vehiculos.txt_codigo.setEditable(false);
        configurar_tipo_vehiculos.txt_precio.setEditable(false);

        configurar_tipo_vehiculos.setResizable(false);
        configurar_tipo_vehiculos.setTitle(fuentes_Y_mas.getTitulo());
        Diseno();
        Evento_Ventana();
    }

    private void Diseno() {

        configurar_tipo_vehiculos.lb_titulo.setFont(fuentes_Y_mas.getLetra_Titulos());
        configurar_tipo_vehiculos.lb_codigo.setFont(fuentes_Y_mas.getLetra_label());
        configurar_tipo_vehiculos.lb_name_precio.setFont(fuentes_Y_mas.getLetra_label());
        configurar_tipo_vehiculos.lb_tipo_vehiculo.setFont(fuentes_Y_mas.getLetra_label());
        configurar_tipo_vehiculos.lb_name_cantidad.setFont(fuentes_Y_mas.getLetra_label());
        configurar_tipo_vehiculos.lb_cantidad.setFont(fuentes_Y_mas.getLetra_Txt());

        configurar_tipo_vehiculos.txt_codigo.setFont(fuentes_Y_mas.getLetra_Txt());
        configurar_tipo_vehiculos.txt_nombre_vehiculo.setFont(fuentes_Y_mas.getLetra_Txt());
        configurar_tipo_vehiculos.txt_precio.setFont(fuentes_Y_mas.getLetra_Txt());

        configurar_tipo_vehiculos.txt_codigo.setHorizontalAlignment(0);
        configurar_tipo_vehiculos.txt_nombre_vehiculo.setHorizontalAlignment(0);
        configurar_tipo_vehiculos.txt_precio.setHorizontalAlignment(0);

        configurar_tipo_vehiculos.combo_tipo.setFont(fuentes_Y_mas.getLetra_Txt());
        configurar_tipo_vehiculos.btn_agregar.setCursor(fuentes_Y_mas.getCursor());
        configurar_tipo_vehiculos.combo_tipo.setCursor(fuentes_Y_mas.getCursor());

        configurar_tipo_vehiculos.lb_titulo.setForeground(fuentes_Y_mas.getColor_titulo());
        configurar_tipo_vehiculos.btn_agregar.setForeground(fuentes_Y_mas.getColor_letra_btn());
        configurar_tipo_vehiculos.btn_agregar.setBackground(fuentes_Y_mas.getColor_Fondo_btn());
        configurar_tipo_vehiculos.txt_codigo.setBorder(fuentes_Y_mas.getBorderlinea(fuentes_Y_mas.getColor_Bien()));

    }

    public void Iniciar_Componentes() {

        configurar_tipo_vehiculos.setLocation(fuentes_Y_mas.centrar_Pantalla(configurar_tipo_vehiculos.getWidth()), 130);
        Cargar_Combo();
        Cargar_Tabla();
        configurar_tipo_vehiculos.setVisible(true);

    }

    private void Cargar_Combo() {
        configurar_tipo_vehiculos.combo_tipo.removeAllItems();
        modelo_nuevo.setCombo_tipo(configurar_tipo_vehiculos.combo_tipo);

        if (!crud_primero.Llenar_Combo_tipo_Vehiculo(modelo_nuevo)) {

            mensajes.getAceptar(configurar_tipo_vehiculos, "Surguio un error al cargar el combo", iconos.getIcono_alerta());
        }

    }

    private void Cargar_Tabla() {
        modelo_nuevo.setTabla(configurar_tipo_vehiculos.tabla);

        if (!crud_primero.Cargar_Tabla_Tipo_Vehiculo(modelo_nuevo)) {

            mensajes.getAceptar(configurar_tipo_vehiculos, "Surguio un error al cargaar la tabla", iconos.getIcono_alerta());

        }
        configurar_tipo_vehiculos.lb_cantidad.setText("" + modelo_nuevo.getContador_Registros());

    }

    private boolean Validar_Tipo_Repetido() {

        String nombre_vehiculo = configurar_tipo_vehiculos.txt_nombre_vehiculo.getText().trim();
        int cantidad_filas = configurar_tipo_vehiculos.tabla.getRowCount();

        if (cantidad_filas > 0) {

            //validar que no se repite le tipo de vehiculo que se desea agrefar
            for (int i = 0; i < cantidad_filas; i++) {

                String nombre_tabla = configurar_tipo_vehiculos.tabla.getValueAt(i, 1).toString();

                if (nombre_vehiculo.equalsIgnoreCase(nombre_tabla)) {

                    i = i + cantidad_filas;
                    return true;

                }

            }

        }

        return false;
    }

    private void Agregar_Tipo() {

        String nombre_vehiculo = configurar_tipo_vehiculos.txt_nombre_vehiculo.getText().trim();
        String precio = configurar_tipo_vehiculos.txt_precio.getText().trim();

        if (nombre_vehiculo.isEmpty() || precio.isEmpty()) {

            if (nombre_vehiculo.isEmpty()) {
                configurar_tipo_vehiculos.lb_nombre_vehi.setVisible(true);

            }
            if (precio.isEmpty()) {
                configurar_tipo_vehiculos.lb_precio.setVisible(true);

            }

        } else if (!nombre_vehiculo.isEmpty() && !precio.isEmpty()) {
            Color color = fuentes_Y_mas.getColor_Mal();

            String sms_aparecer = "Tipo de Vehículo " + nombre_vehiculo + " ya existe!";
            if (Validar_Tipo_Repetido() == false) {//metoodo que retorna true si el tipo a agregar ya existe
                modelo_nuevo.setTipo_vehiculo(nombre_vehiculo);
                modelo_nuevo.setPrecio_hora(precio);

                sms_aparecer = "Surguio un error ";

                if (crud_primero.Crud_Tipo_Vehiculo(modelo_nuevo, 1)) {
                    Cargar_Combo();
                    Cargar_Tabla();
                    configurar_tipo_vehiculos.txt_nombre_vehiculo.setText("");
                    configurar_tipo_vehiculos.txt_precio.setText("");

                    sms_aparecer = "Tipo Vehiculo Agregado con exito";
                    Habilitar(false, "", "Nuevo");
                    color = fuentes_Y_mas.getColor_Bien();
                }

            }

            controlador_sms.Iniciar_Componentes(sms_aparecer, color);

        }

    }

    private void Actualizar_Tipo() {

        String codigo = configurar_tipo_vehiculos.txt_codigo.getText();
        String tipo = configurar_tipo_vehiculos.combo_tipo.getSelectedItem().toString();
        String precio = configurar_tipo_vehiculos.txt_precio.getText().trim();
        boolean visible = true;
        if (precio.isEmpty() == false) {
            visible = false;
            Color color = fuentes_Y_mas.getColor_Mal();
            modelo_nuevo.setCodigo(codigo);
            modelo_nuevo.setTipo_vehiculo(tipo);
            modelo_nuevo.setPrecio_hora(precio);

            String sms = "Error , intentelo nuevamente";
            if (crud_primero.Crud_Tipo_Vehiculo(modelo_nuevo, 2)) {
                Cargar_Combo();
                Cargar_Tabla();
                sms = "Vehículo Actualizado con con exito";
                color = fuentes_Y_mas.getColor_Bien();
                Habilitar(false, "", "Nuevo");

            }
            controlador_sms.Iniciar_Componentes(sms, color);

        }
        configurar_tipo_vehiculos.lb_precio.setVisible(visible);

    }

    private void Eliminar_Tipo() {

        String sms = "¿Eliminar Tipo Vehículo "
                + configurar_tipo_vehiculos.tabla.getValueAt(configurar_tipo_vehiculos.tabla.getSelectedRow(), 1) + " ?";

        controlador_sms_pregunta.Iniciar_Componenentes(sms, "Eliminar ", "Cancelar", iconos.getIcono_eliminar_pregunta(), iconos.getIcono_actualizar());

        if (controlador_sms_pregunta.getAccion() == 0) {

            Color color = fuentes_Y_mas.getColor_Mal();
            String codigo = configurar_tipo_vehiculos.tabla.getValueAt(configurar_tipo_vehiculos.tabla.getSelectedRow(), 0).toString();
            modelo_nuevo.setCodigo(codigo);
            sms = "Error, intentelo mas tarde";
            if (crud_primero.Crud_Tipo_Vehiculo(modelo_nuevo, 3)) {
                Cargar_Combo();
                Cargar_Tabla();
                color = fuentes_Y_mas.getColor_Bien();

                sms = "Tipo Vehículo eliminado con exito";

            }
            controlador_sms.Iniciar_Componentes(sms, color);

        }

    }

    private void Poner_Datos() {

        int fila = configurar_tipo_vehiculos.tabla.getSelectedRow();
        String codigo = configurar_tipo_vehiculos.tabla.getValueAt(fila, 0).toString();
        String tipo = configurar_tipo_vehiculos.tabla.getValueAt(fila, 1).toString();
        String precio = configurar_tipo_vehiculos.tabla.getValueAt(fila, 2).toString();

        configurar_tipo_vehiculos.txt_codigo.setText(codigo);
        configurar_tipo_vehiculos.combo_tipo.setSelectedItem(tipo);
        configurar_tipo_vehiculos.txt_precio.setText(precio);
        configurar_tipo_vehiculos.btn_agregar.setText("Cancelar");
        configurar_tipo_vehiculos.txt_precio.setEditable(true);

    }

    private void Btn_Agregar() {

        String operacion = configurar_tipo_vehiculos.btn_agregar.getText().trim();

        if (operacion.equalsIgnoreCase("Nuevo")) {

            Habilitar(true, "", "Cancelar");

        }

        if (operacion.equalsIgnoreCase("Cancelar")) {
            Habilitar(false, "", "Nuevo");

        }

    }

    private void Habilitar(boolean estado, String texto, String nombre_btn) {
        configurar_tipo_vehiculos.combo_tipo.setVisible(!estado);
        configurar_tipo_vehiculos.txt_nombre_vehiculo.setVisible(estado);
        configurar_tipo_vehiculos.txt_precio.setEditable(estado);
        configurar_tipo_vehiculos.txt_nombre_vehiculo.setText(texto);
        configurar_tipo_vehiculos.txt_codigo.setText(texto);
        configurar_tipo_vehiculos.txt_precio.setText(texto);
        configurar_tipo_vehiculos.btn_agregar.setText(nombre_btn);

        if (!estado) {

            configurar_tipo_vehiculos.lb_precio.setVisible(estado);
            configurar_tipo_vehiculos.lb_nombre_vehi.setVisible(estado);
        }

    }

    private void Evento_Ventana() {

        WindowListener evento = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {

                Habilitar(false, "", "Nuevo");

            }

        };

        configurar_tipo_vehiculos.addWindowListener(evento);

    }

    //#############################################################################################################################
    //##############################################################################################################################   
    @Override
    public void actionPerformed(ActionEvent e) {

        Btn_Agregar();

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyChar() == KeyEvent.VK_ENTER) {

            if (e.getSource() == configurar_tipo_vehiculos.txt_precio) {

                String codigo = configurar_tipo_vehiculos.txt_codigo.getText().trim();

                if (codigo.isEmpty() && configurar_tipo_vehiculos.txt_nombre_vehiculo.isVisible()) {

                    //esto  valida que lo que voy hacer es agregar un nuevo vehivulo
                    Agregar_Tipo();
                }

                if (!codigo.isEmpty() && configurar_tipo_vehiculos.combo_tipo.isVisible()) {

                    //esto  valida que lo que voy hacer es hacer una actualzacion
                    Actualizar_Tipo();
                }

            }

            if (e.getSource() == configurar_tipo_vehiculos.txt_nombre_vehiculo) {

                configurar_tipo_vehiculos.txt_precio.requestFocus();

            }

        }

        if (e.getKeyCode() == KeyEvent.VK_DELETE || e.getKeyCode() == 8) {

            if (e.getSource() == configurar_tipo_vehiculos.tabla) {

                Eliminar_Tipo();

            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyChar() != KeyEvent.VK_ENTER) {

            Object control = e.getSource();

            if (control == configurar_tipo_vehiculos.txt_nombre_vehiculo) {

                configurar_tipo_vehiculos.lb_nombre_vehi.setVisible(false);

            }

            if (control == configurar_tipo_vehiculos.txt_precio) {
                configurar_tipo_vehiculos.lb_precio.setVisible(false);

            }

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

        Object control = e.getSource();
        char letra = e.getKeyChar();

        if (control == configurar_tipo_vehiculos.txt_nombre_vehiculo) {

            if (Character.isAlphabetic(letra) || Character.isSpaceChar(letra)) { //para que ingreso solo cuadno sonl teras

                String mayus = ("" + letra).toUpperCase();

                letra = mayus.charAt(0);
                e.setKeyChar(letra);

            } else {
                e.consume();
            }

        }

        if (control == configurar_tipo_vehiculos.txt_precio) {

            if (!Character.isDigit(letra) && letra != '.') { //para que ingreso solo cuadno sonl teras

                e.consume();

            } else {

                String longitud = configurar_tipo_vehiculos.txt_precio.getText();

                if (longitud.length() == 0 && letra == '.') {

                    e.consume();
                }

            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == configurar_tipo_vehiculos.tabla) {
            int columnas = configurar_tipo_vehiculos.tabla.getColumnModel().getColumnIndexAtX(e.getX());
            if (configurar_tipo_vehiculos.tabla.getRowCount() >= 0) {
                int filas = e.getY() / configurar_tipo_vehiculos.tabla.getRowHeight();
                if (filas < configurar_tipo_vehiculos.tabla.getRowCount() && filas >= 0 && columnas < configurar_tipo_vehiculos.tabla.getColumnModel().getColumnCount() && columnas >= 0) {
                    Object value = configurar_tipo_vehiculos.tabla.getValueAt(filas, columnas);

                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        String nombre_btn = configurar_tipo_vehiculos.btn_agregar.getText().trim();

                        if (nombre_btn.equalsIgnoreCase("Cancelar")) {
                            controlador_sms.Iniciar_Componentes("Cancela la operación Actual", fuentes_Y_mas.getColor_Mal());

                        } else {
                            Eliminar_Tipo();
                        }

                    } else if (e.getClickCount() == 2) {

                        if (configurar_tipo_vehiculos.txt_nombre_vehiculo.isVisible()) {

                            controlador_sms.Iniciar_Componentes("Cancela La operacion Actual", fuentes_Y_mas.getColor_Mal());
                        } else {
                            Poner_Datos();

                        }

                    }

                }
            }

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
