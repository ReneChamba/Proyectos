package controlador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.RowFilter;
import modelo.Crud_Cuentas;
import modelo.Modelo;

import vistas.Vender_Producto;
import static javax.swing.JOptionPane.*;
import javax.swing.border.LineBorder;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import modelo.Trasparente;
import vistas.Detalle_Venta;

public class Controlador_Vender_Producto implements ActionListener, KeyListener, ChangeListener, MouseListener {

    private Modelo modelo;
    private Vender_Producto vender_Producto;
    private Crud_Cuentas crud_cuentas;
    private Detalle_Venta detalle_venta;
    private Controlador_Clientes controlador_clientes;

    public Controlador_Vender_Producto(Modelo modelo, Vender_Producto vender_Producto, Crud_Cuentas crud_cuentas,
            Detalle_Venta detalle_venta, Controlador_Clientes controlador_clientes) {
        this.opciones = new String[]{"Eliminar", "Cancelar"};
        this.modelo = modelo;
        this.vender_Producto = vender_Producto;
        this.crud_cuentas = crud_cuentas;

        this.detalle_venta = detalle_venta;
        this.controlador_clientes = controlador_clientes;
        //////////////////////////////////////////////////////////////////////////////////////
        letras_botones = new Font("Dialog", Font.BOLD, 20);
        color_botones = new Color(30, 138, 137);//color de los botones y del titulo
        letras_label = new Font("Dialog", Font.BOLD, 14);
        letra_txt = new Font("Dialog", Font.BOLD + Font.ITALIC, 13);
        cursor_mano = new Cursor(Cursor.HAND_CURSOR);
        linea = new LineBorder(color_botones, 2, true);
        icono_bien = new ImageIcon("src/Image_Sms/visto_bien.png");
        icono_prod_vacio = new ImageIcon("src/Image_Sms/admiracion_nueva.png");
        icono_pregunta = new ImageIcon("src/Image_Sms/icono_pregunta_nuevo.png");
        icono_cobrar = new ImageIcon("src/Image_2/dinero_nuevo.png");
        /////////////////////////////////////////////////////////////////////////////////////////7
        this.vender_Producto.txt_producto.addKeyListener(this);
        this.vender_Producto.tabla_ventas_productos.addKeyListener(this);
        this.detalle_venta.btn_cobrar_detalle_venta.addKeyListener(this);
        this.detalle_venta.txt_precio_venta.addKeyListener(this);
        //  this.vender_Producto.addKeyListener(this);
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        this.detalle_venta.spiner_cantidad.addChangeListener(this);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        this.detalle_venta.btn_agregar_lista.addActionListener(this);
        this.vender_Producto.btn_elegir_cliente.addActionListener(this);
        this.vender_Producto.btn_cancelar.addActionListener(this);
        this.vender_Producto.btn_limpiar.addActionListener(this);
        this.vender_Producto.btn_cobrar.addActionListener(this);

        this.vender_Producto.btn_credito.addActionListener(this);

        this.detalle_venta.btn_cobrar_detalle_venta.addActionListener(this);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        this.vender_Producto.tabla_lista_agregados.addMouseListener(this);
        this.vender_Producto.tabla_ventas_productos.addMouseListener(this);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        this.detalle_venta.txt_producto_detalle_venta.setEditable(false);
        this.detalle_venta.label_codigo_proveedor.setVisible(false);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        this.detalle_venta.setResizable(false);
        this.vender_Producto.setResizable(false);
        ///////////////////////////////////////////////////////////////////////////////////

        Editable();
        Asignar_Letra();
        Letra_Detalle_Venta();
        Asignar_Cursor();
        Evento_Ventana();

    }

    public void Estados_Iniciales() {

        //  llenar_Txt();
        vender_Producto.setLocationRelativeTo(null);
        vender_Producto.txt_producto.setText("");
        Modelo_Tabla();
        Llenar_Tabla_Lista_Productos();
        vender_Producto.setVisible(true);

    }

    private void Modelo_Tabla() {

        modelo.setTabla(vender_Producto.tabla_ventas_productos);

        crud_cuentas.Modelo_Tabla_Venta_Productos(modelo);

    }

    ////////////////////CODIGO FORMULARIO DETALLE VENTA////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void Estados_Iniciales_Detalle_Venta() {

        detalle_venta.setLocationRelativeTo(null);

        detalle_venta.setVisible(true);

    }

    private void Poner_Datos(String codigo_registro, String codigo_proveedor, String producto, String precio_venta,
            String cantidad_disponible) {
        detalle_venta.label_codigo_producto.setText(codigo_registro);
        detalle_venta.label_codigo_proveedor.setText(codigo_proveedor);
        detalle_venta.label_disponibles.setText(cantidad_disponible);
        detalle_venta.txt_producto_detalle_venta.setText(producto);
        detalle_venta.txt_precio_venta.setText(precio_venta);
        detalle_venta.spiner_cantidad.setValue(1);
        Calculo_Inicial();

    }

    private void Limpiar_Texto() {
        vender_Producto.txt_cliente.setText("");
        vender_Producto.txt_cedula.setText("");

        vender_Producto.txt_telefono.setText("");

        vender_Producto.label_saldo_pendiente.setText("0.00");

    }

    private void Calculo_Inicial() {

        try {

            double precio = Double.parseDouble(detalle_venta.txt_precio_venta.getText());
            int cantidad = Integer.parseInt(detalle_venta.spiner_cantidad.getValue().toString());

            double total = cantidad * precio;

            detalle_venta.label_total.setText("" + total);
        } catch (Exception e) {
        }

    }

    private void Cobraar_btn_Detalle_Venta() {

        try {
            boolean esconder = true;
            String codigo = detalle_venta.label_codigo_producto.getText();
            String nombre_producto = detalle_venta.txt_producto_detalle_venta.getText();
            String precio = detalle_venta.txt_precio_venta.getText().trim();

            if (!precio.isEmpty()) {

                double precio_parseado = Double.parseDouble(precio);
                int cantidad = Integer.parseInt(detalle_venta.spiner_cantidad.getValue().toString());
                int disponibles = Integer.parseInt(detalle_venta.label_disponibles.getText());

                if (cantidad <= disponibles) {

                    String sms = "Producto cobrado con exito";
                    double total_venta = precio_parseado * cantidad;
                    modelo.setFecha(modelo.getRetornar_fecha_actual(false)); //true para datetime
                    modelo.setFecha_vendida(modelo.getRetornar_fecha_actual(true)); //true para dat

                    modelo.setCodigo_registro(codigo);
                    modelo.setProducto(nombre_producto);
                    modelo.setCantidad_productos((cantidad));
                    modelo.setPrecio(precio_parseado);
                    modelo.setTotal_cada_producto(total_venta);

                    if (!crud_cuentas.Insertar_Tabla_Nuevo_Ingresos(modelo)) {
                        sms = "Ocurrio un problema, no se cobro el produco";
                        esconder = false;

                    } else {

                        Actualizar_tabla_Compras(cantidad, total_venta, nombre_producto, codigo, true, 1
                        );
                    }

                    showMessageDialog(detalle_venta, sms, "Sistema de Venta", 0, icono_bien);
                    if (esconder) { // si cobra correcto que el detalle venta de oculte caso contrario no 

                        detalle_venta.dispose();
                    }

                } //caso contrario ya mustra el sms que tiene en evento del spinner el changeEvent

            } else {
                showMessageDialog(detalle_venta, "Ingresa el precio");
                detalle_venta.txt_precio_venta.requestFocus();
            }
        } catch (NumberFormatException e) {
            showMessageDialog(detalle_venta, "Precion ingresado incorrecto");

        }

    }

    private boolean Verificar_cantidad() {
        int cantidad_disponible_nueva = Integer.parseInt(detalle_venta.label_disponibles.getText());
        int cantidad = Integer.parseInt(detalle_venta.spiner_cantidad.getValue().toString());
        return cantidad <= cantidad_disponible_nueva;

    }

    private void Asignar_Letra() {
        Trasparente cedula = new Trasparente("Ingresa Nombre Producto", vender_Producto.txt_producto, Trasparente.Show.ALWAYS);
        vender_Producto.label_titulo.setFont(letras_botones);
        vender_Producto.label_mostrar_total_cobrar.setFont(letras_botones);
        vender_Producto.label_productos_registrados.setFont(letras_botones);
        vender_Producto.label_nombre_produc_regi.setFont(letras_botones);

        vender_Producto.label_nombre_total.setFont(letras_botones);
        vender_Producto.label_buscar_produto.setFont(letras_label);
        vender_Producto.label_cliente.setFont(letras_label);
        vender_Producto.label_cedula.setFont(letras_label);
        vender_Producto.label_saldo.setFont(letras_label);
        vender_Producto.label_telefono.setFont(letras_label);
        vender_Producto.label_saldo_pendiente.setFont(letras_botones);

        vender_Producto.btn_cobrar.setFont(letras_label);
        vender_Producto.btn_cancelar.setFont(letras_label);
        vender_Producto.btn_credito.setFont(letras_label);

        /////////////////////////////////////////////////////////////////////////////////////
        vender_Producto.txt_producto.setFont(letra_txt);
        vender_Producto.txt_cedula.setFont(letra_txt);
        vender_Producto.txt_cliente.setFont(letra_txt);
        vender_Producto.txt_telefono.setFont(letra_txt);
        //////////////////////Colores/////////////////////////////////
        vender_Producto.label_titulo.setForeground(color_botones);
        vender_Producto.label_mostrar_total_cobrar.setForeground(color_botones);
        vender_Producto.label_productos_registrados.setForeground(color_botones);
        vender_Producto.label_saldo_pendiente.setForeground(color_botones);

        /////////////ORIENTACIÓN ////////////////////////////////
        vender_Producto.txt_producto.setHorizontalAlignment(0);
        vender_Producto.txt_cedula.setHorizontalAlignment(0);
        vender_Producto.txt_telefono.setHorizontalAlignment(0);
        vender_Producto.txt_cliente.setHorizontalAlignment(0);
        vender_Producto.label_nombre_total.setHorizontalAlignment(4);
        vender_Producto.label_nombre_produc_regi.setHorizontalAlignment(0);
        ////////////////////Imagenes////////////////////////////////////////////////
        vender_Producto.btn_elegir_cliente.setIcon(new ImageIcon("src/Image_Sms/cuenta_habilitar.png"));
        vender_Producto.btn_limpiar.setIcon(new ImageIcon("src/Imagenes/limpiar_texto.png"));
        vender_Producto.btn_cobrar.setIcon(icono_cobrar);
        vender_Producto.btn_credito.setIcon(new ImageIcon("src/Image_2/icono_credito.png"));
        vender_Producto.btn_cancelar.setIcon(new ImageIcon("src/Imagenes/cancelar.png"));
        /////////////////Bordes/////////////////////////////////////////////
        vender_Producto.txt_producto.setBorder(linea);

    }

    private void Asignar_Cursor() {

        vender_Producto.btn_cancelar.setCursor(cursor_mano);
        vender_Producto.btn_cobrar.setCursor(cursor_mano);
        vender_Producto.btn_credito.setCursor(cursor_mano);
        vender_Producto.btn_elegir_cliente.setCursor(cursor_mano);
        vender_Producto.btn_limpiar.setCursor(cursor_mano);
        ///////////////////////////////////////////////////////////////////////////////
        detalle_venta.btn_agregar_lista.setCursor(cursor_mano);
        detalle_venta.btn_cobrar_detalle_venta.setCursor(cursor_mano);
    }

    private void Letra_Detalle_Venta() {

        detalle_venta.label_titulo.setFont(letras_botones);
        detalle_venta.label_total.setFont(letras_botones);
        detalle_venta.label_simbolo.setFont(letras_botones);
        detalle_venta.label_cantidad.setFont(letras_label);
        detalle_venta.label_disponibles.setFont(letras_botones);
        detalle_venta.label_codigo.setFont(letras_label);
        detalle_venta.label_precio_venta.setFont(letras_label);
        detalle_venta.label_nombre_disponibles.setFont(letras_label);
        detalle_venta.label_producto.setFont(letras_label);
        detalle_venta.label_nombre_total.setFont(letras_label);

        //////////////////////////////////////////////////////////////////
        detalle_venta.txt_precio_venta.setFont(letra_txt);
        detalle_venta.txt_producto_detalle_venta.setFont(letra_txt);
        detalle_venta.spiner_cantidad.setFont(letra_txt);
        ///////////////////LETRA BOTONES///////////////////////////////////////////////////////
        detalle_venta.btn_agregar_lista.setFont(letras_botones);
        detalle_venta.btn_cobrar_detalle_venta.setFont(letras_botones);
        /////////////////ORIENTACION//////////////////////////////////
        detalle_venta.label_codigo_producto.setHorizontalAlignment(0);
        detalle_venta.txt_precio_venta.setHorizontalAlignment(0);
        detalle_venta.txt_producto_detalle_venta.setHorizontalAlignment(0);
        detalle_venta.label_nombre_disponibles.setHorizontalAlignment(0);
        detalle_venta.label_total.setHorizontalAlignment(0);
        detalle_venta.label_titulo.setHorizontalAlignment(0);
        ///////////////////COLORES/////////////////////////////////////////////////////
        detalle_venta.label_total.setForeground(color_botones);
        detalle_venta.label_titulo.setForeground(color_botones);

        ////////////BORDE//////////////////////////////
        detalle_venta.txt_producto_detalle_venta.setBorder(linea);
        //////IMAGENES////////////////////////////////////////
        detalle_venta.btn_cobrar_detalle_venta.setIcon(icono_cobrar);
        detalle_venta.btn_agregar_lista.setIcon(new ImageIcon("src/Image_2/lista_nueva.png"));

    }

    private boolean Agregar_Lista() {
        boolean retornar = true;
        try {
            String precio_venta = detalle_venta.txt_precio_venta.getText(); // obtengo nuevamente xq puede que el vendedor aumente el precio que estaba registrado

            int cantidad_spinner = Integer.parseInt(detalle_venta.spiner_cantidad.getValue().toString());
            int cantidad_disponible = Integer.parseInt(detalle_venta.label_disponibles.getText());

            if (cantidad_spinner <= cantidad_disponible) {
                double total = Double.parseDouble(detalle_venta.txt_precio_venta.getText()) * cantidad_spinner;
                //String total_venta = detalle_venta.label_total.getText();
                String producto = detalle_venta.txt_producto_detalle_venta.getText();
                String codigo_registro = detalle_venta.label_codigo_producto.getText();
                String codigo_proveedor = detalle_venta.label_codigo_proveedor.getText();

                modelo.setCodigo_registro(codigo_registro);
                modelo.setCodigo_proveedor(codigo_proveedor);
                modelo.setProducto(producto);
                modelo.setPrecio(Double.parseDouble(precio_venta));
                modelo.setCantidad_productos(cantidad_spinner);
                modelo.setTotal_cada_producto(total);

                if (!crud_cuentas.Insertar_tabla_listar_ventas(modelo, true, 0)) {

                    showMessageDialog(detalle_venta, "Surgio un problema al agregar producto");
                    retornar = false;
                } else {

                    Actualizar_tabla_Compras(cantidad_spinner, total, producto, codigo_registro, true, 1); //despues de agregar , ete metodo
                    //se encarga de actualizar la tabla compras "tabla ventas en la base de datos"
                }
            } else { // se mostrara el sms que tiene el evento change del spinner, x eso no muestro sms aqui
                retornar = false;
            }
        } catch (NumberFormatException e) {
            showMessageDialog(detalle_venta, "Ingresa  precio de venta ");
            retornar = false;
        }

        return retornar;

    }

    ////////////////////CODIGO FORMULARIO VENDER PRODUCTO///////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void Llenar_Tabla_Lista_Productos() {

        modelo.setTabla(vender_Producto.tabla_lista_agregados);

        if (!crud_cuentas.Modelo_Tabla_Listar_Ventas(modelo)) {

            showMessageDialog(detalle_venta, "Surguio un error al agregar a la lista");
        } else {

            vender_Producto.label_mostrar_total_cobrar.setText("" + modelo.getTotal_cobrar());
            vender_Producto.label_productos_registrados.setText("" + modelo.getCantidad_produ_cliente());
        }

    }

    private void Editable() {
        vender_Producto.txt_cliente.setEditable(false);
        vender_Producto.txt_cedula.setEditable(false);
        vender_Producto.txt_telefono.setEditable(false);
        vender_Producto.label_saldo_pendiente.setText("0.00");

    }

    private void Evento_Ventana() {
        WindowAdapter evento = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                Limpiar_Texto();

            }

        };
        vender_Producto.addWindowListener(evento);

    }

    private void Evento_dos_click_Y_enter() {
        int fila_seleccionada = vender_Producto.tabla_ventas_productos.getSelectedRow();
        String cantidad_disponible = vender_Producto.tabla_ventas_productos.getValueAt(fila_seleccionada, 6).toString();
        String producto = vender_Producto.tabla_ventas_productos.getValueAt(fila_seleccionada, 4).toString();

        if (!cantidad_disponible.equalsIgnoreCase("VACIA")) {
            String codigo_registro = vender_Producto.tabla_ventas_productos.getValueAt(fila_seleccionada, 1).toString();
            String codigo_proveedor = vender_Producto.tabla_ventas_productos.getValueAt(fila_seleccionada, 3).toString();
            String precio_venta = vender_Producto.tabla_ventas_productos.getValueAt(fila_seleccionada, 5).toString();

            Poner_Datos(codigo_registro, codigo_proveedor, producto, precio_venta, cantidad_disponible);

            Estados_Iniciales_Detalle_Venta();

        } else {
            showMessageDialog(vender_Producto, "No hay " + producto + "  para vender", "Sistema de Venta", 0, icono_prod_vacio);
        }

    }

    private boolean Cobrar_Y_Dar_Credito() { // este metodo es para insertar  en la tabla ingreso nuevo 
        //se ejecutane en dos botones que hacen lo mismo , boton cobrar y el boton dar credito

        boolean verificar = true;
        String retornar_fecha = modelo.getRetornar_fecha_actual(false);
        String retornar_fecha_date = modelo.getRetornar_fecha_actual(true
        );
        int filas = vender_Producto.tabla_lista_agregados.getRowCount();

        credito = new String[filas][6];

        for (int i = 0; i < filas; i++) { //llenar los datos de la tabla en un array 

            credito[i][0] = retornar_fecha;//fecha
            credito[i][1] = vender_Producto.tabla_lista_agregados.getValueAt(i, 1).toString();//codigo producto
            credito[i][2] = vender_Producto.tabla_lista_agregados.getValueAt(i, 2).toString();//nombre producto
            credito[i][3] = vender_Producto.tabla_lista_agregados.getValueAt(i, 3).toString();//cantidad
            credito[i][4] = vender_Producto.tabla_lista_agregados.getValueAt(i, 4).toString();//precio
            credito[i][5] = vender_Producto.tabla_lista_agregados.getValueAt(i, 5).toString();//total producto

        }

        //INSERTAR EN LA TABLA PRODUCTOS
        String fecha = "";
        String codigo = "";
        String nombre_producto = "";
        String cantidad = "";
        String precio = "";
        String total_producto = "";

        for (int i = 0; i < filas; i++) { //rrecorre el array e ir insetando en la base de datos

            fecha = credito[i][0];
            codigo = credito[i][1];
            nombre_producto = credito[i][2];
            cantidad = credito[i][3];
            precio = credito[i][4];
            total_producto = credito[i][5];
            ////////////////////////////////////////////////////////////////
            //PASARLE LOS DATOS AL MODELO
            modelo.setFecha_vendida(retornar_fecha_date); //es la misma fecha que la de abajo solo que es de tipo date(solo fecha , es string)
            modelo.setFecha(fecha); // es  de tipo datetime ( es tipo string)
            modelo.setCodigo_registro(codigo);
            modelo.setProducto(nombre_producto);
            modelo.setCantidad_productos(Integer.parseInt(cantidad));
            modelo.setPrecio(Double.parseDouble(precio));
            modelo.setTotal_cada_producto(Double.parseDouble(total_producto));

            if (!crud_cuentas.Insertar_Tabla_Nuevo_Ingresos(modelo)) {
                verificar = false;// si cambia a falso quiere decir que ocrrio un problema , entonces que no actualize la tabla 

                break;
            }

            if (verificar) {
                Eliminar_Producto_Ingresado(1); //obligado el uno o >3 para arriba 
                Llenar_Tabla_Lista_Productos();

            }
            Limpiar_Texto();

        }
        return verificar;

    }

    private void Guardar_Credito() {

        String cedula_cliente = vender_Producto.txt_cedula.getText().trim();

        if (!cedula_cliente.isEmpty()) {
            double total = Double.parseDouble(vender_Producto.label_mostrar_total_cobrar.getText());
            double saldo_pendiete = Double.parseDouble(vender_Producto.label_saldo_pendiente.getText());
            double nuevo_saldo_pendiente = total + saldo_pendiete;
            //String sms = "Registros Agregados con exito a cliente";
            String sms = "Ocurrio un problema , no se registraron los productos";

            /*
            luego de agregar un nuevo saldo pendiente de los producto que le vendi , tengo que agrear esos proscutos vendido a una 
            tabla de ingreso .
             */
            modelo.setAbono(nuevo_saldo_pendiente);
            modelo.setCedula(cedula_cliente);

            if (crud_cuentas.Actulizar_Saldo_Pendiente(modelo)) {

                sms = "Registros Agregados con exito a cliente";
                if (!Cobrar_Y_Dar_Credito()) { //metodo para dr credito y cobrar
                    showMessageDialog(detalle_venta, "Ocurrio un error al  registrar en tabla ingresos");
                }

            }
            showMessageDialog(detalle_venta, sms, "Sistema de Ventas", 0, icono_bien);

        } else {
            showMessageDialog(detalle_venta, "¡Selecciona un cliente!", "Sistema de Ventas", 0, icono_prod_vacio);
        }

    }

    private void Eventto_Click(MouseEvent e) {
        int columnas = vender_Producto.tabla_lista_agregados.getColumnModel().getColumnIndexAtX(e.getX());

        if (vender_Producto.tabla_lista_agregados.getRowCount() >= 0) {
            int filas = e.getY() / vender_Producto.tabla_lista_agregados.getRowHeight();
            if (filas < vender_Producto.tabla_lista_agregados.getRowCount() && filas >= 0 && columnas < vender_Producto.tabla_lista_agregados.getColumnModel().getColumnCount() && columnas >= 0) {
                Object value = vender_Producto.tabla_lista_agregados.getValueAt(filas, columnas);

                if (value instanceof JButton) {
                    ((JButton) value).doClick();
                    JButton boton = (JButton) value;
                    Eliminar_Producto_Ingresado(2); //elimina uno solo 

                }
            }
        }
    }

    private void Eliminar_Producto_Ingresado(int delete) {

        int respuesta = 0;
        String datos[][] = null;
        int filas_global = 0;

        if (delete == 2) { //tomar el codigo de un producto para eliminar un unico producto agregado a  la lista
            String id_pro = vender_Producto.tabla_lista_agregados.getValueAt(vender_Producto.tabla_lista_agregados.getSelectedRow(), 0).toString();

            modelo.setCodigo_registro(id_pro);
        }

        if (delete == 0) {// puede ser culquier numero distinto de 2
            //0  = cancelar todo 

            int filas = vender_Producto.tabla_lista_agregados.getRowCount();
            filas_global = filas;

            datos = new String[filas][4];

            for (int i = 0; i < filas; i++) {

                for (int j = 0; j < 1; j++) {

                    datos[i][0] = vender_Producto.tabla_lista_agregados.getValueAt(i, 1).toString(); //codigo registro
                    datos[i][1] = vender_Producto.tabla_lista_agregados.getValueAt(i, 2).toString();//nombre producto
                    datos[i][2] = vender_Producto.tabla_lista_agregados.getValueAt(i, 3).toString();//cantidad
                    datos[i][3] = vender_Producto.tabla_lista_agregados.getValueAt(i, 5).toString();//subtotal

                }
            }

            String sms = "¿Cancelar  Productos Registrados?";
            respuesta = showOptionDialog(detalle_venta, sms, "Sistema de Ventas", 0, 0, icono_pregunta, opciones, opciones[0]);

        }
        /////////////////

        if (respuesta == 0) {

            String sms = "Producto eliminado Correctamente";

            if (delete == 0) { //cancelar todo y volver a meter los datos  al inventario

                String codigo = "";
                String producto = "";
                String cantidad = "";
                String subtotal = "";
                int cantidad_parseada = 0;
                double subtotal_parseado = 0;
                for (int i = 0; i < filas_global; i++) {

                    for (int j = 0; j < 1; j++) {
                        codigo = datos[i][0];
                        producto = datos[i][1];
                        cantidad = datos[i][2];
                        subtotal = datos[i][3];
                        subtotal_parseado = Double.parseDouble(subtotal);
                        cantidad_parseada = Integer.parseInt(cantidad);
                        Actualizar_tabla_Compras(cantidad_parseada, subtotal_parseado, producto, codigo, false, 2); //actualizo la tabla compras de inventario

                    }
                }

                //elimnar todo de tabla lista agregado
                if (crud_cuentas.Insertar_tabla_listar_ventas(modelo, false, 3)) { // distinto de 2 para que elimine todo los registos 
                    Modelo_Tabla();
                    Llenar_Tabla_Lista_Productos(); // actulizo la tabl lista agreado

                }

            } else if (delete == 2 || delete == 1) { //Eliminar un unico producto  o  si le llega 1(esto quiere decir que es dar credito y que elimine todo , NO TOMAR LA FILAS SELECCIONADA)
                if (crud_cuentas.Insertar_tabla_listar_ventas(modelo, false, delete)) { //elimino el registro de la tabla lista agregado

                    if (delete == 2) { //eliminar un unico registro, ncesito la fila seleccionada

                        String codigo_producto = vender_Producto.tabla_lista_agregados.getValueAt(vender_Producto.tabla_lista_agregados.getSelectedRow(), 1).toString();
                        String producto = vender_Producto.tabla_lista_agregados.getValueAt(vender_Producto.tabla_lista_agregados.getSelectedRow(), 2).toString();
                        int cantidad = Integer.parseInt(vender_Producto.tabla_lista_agregados.getValueAt(vender_Producto.tabla_lista_agregados.getSelectedRow(), 3).toString());
                        double total = Double.parseDouble(vender_Producto.tabla_lista_agregados.getValueAt(vender_Producto.tabla_lista_agregados.getSelectedRow(), 5).toString());

                        Actualizar_tabla_Compras(cantidad, total, producto, codigo_producto, false, 1); //actualizo la tabla compras de inventario

                        Llenar_Tabla_Lista_Productos(); // actulizo la tabl lista agreado
                    }

                } else {
                    sms = "Surguio  un error al intentar eliminar el registro";

                }
            }

            if (delete != 1) { //wl uno es d guardar credito
                showMessageDialog(detalle_venta, sms, "Sistema de Ventas", 0, icono_bien);
            }

        }

    }

    private void Actualizar_tabla_Compras(int cantidad, double total, String producto, String codigo_registro, boolean elegir_operacion, int actualizar_tabla) {

        modelo.setProducto(producto);
        modelo.setCodigo_registro(codigo_registro);

        //traer el egreso , cantidad disponible, ganacias para luego actualizar esos campos
        if (crud_cuentas.Ver_Cantidad_Disponible_Tabla_Productos(modelo)) {
            int nueva_cantidad_disponible = modelo.getCantidad_disponibles();
            double ingreso_por_vender_productos = modelo.getTotal_cobrar();
            double egresos_compras = modelo.getEgresos_por_compras();
            double ganancias_tabla_compras = 0;

            if (elegir_operacion) { // descontar de la tabla compras,

                nueva_cantidad_disponible = nueva_cantidad_disponible - cantidad;
                ingreso_por_vender_productos = ingreso_por_vender_productos + total;
                ganancias_tabla_compras = ingreso_por_vender_productos - egresos_compras; // esta es la nueva ganancia
            } else { //volver a ingresar los productos elimininados o cancelados a la tabla compras o inventario
                nueva_cantidad_disponible = nueva_cantidad_disponible + cantidad;
                ingreso_por_vender_productos = ingreso_por_vender_productos - total;
                ganancias_tabla_compras = ingreso_por_vender_productos + egresos_compras; // esta es la nueva ganancia
            }

            //int nueva_cantidad_disponible = modelo.getCantidad_disponibles() - cantidad;
            //  double ingreso_por_vender_productos = modelo.getTotal_cobrar() + total;
            //  double ganancias_tabla_compras = ingreso_por_vender_productos - egresos_compras; // esta es la nueva ganancia
            ////////////ACTUALIZAR  GANANCIAS, DISPONIBLE, INGRESOS TABLA COMPRAS////////////////////////
            modelo.setCantidad_productos(nueva_cantidad_disponible);
            modelo.setTotal_cobrar(ingreso_por_vender_productos);
            modelo.setGanancias_tabla_compras(ganancias_tabla_compras);

            if (!crud_cuentas.Actualizar_Cantidad_Productos(modelo)) {
                showMessageDialog(detalle_venta, "Surguio un problema al actualizar la tabla compras");

            } else if (crud_cuentas.Actualizar_Cantidad_Productos(modelo)) {
                // esto xq cuando cancele todos los registro  voy a recorrer un for , y no quiero que a cada iteracion actualize la tabla
                //si no que actualize cuando ya haya de recorrer todo el for //metodo eliminar opcion 0

                if (actualizar_tabla == 1) {
                    Modelo_Tabla();
                }
            }

        }

    }

    //////////////////////////EVENTOS//////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == detalle_venta.btn_agregar_lista) {

            if (Agregar_Lista()) {
                Llenar_Tabla_Lista_Productos();
                detalle_venta.dispose();

            }

        }

        if (e.getSource() == vender_Producto.btn_elegir_cliente) {

            controlador_clientes.Iniciar_Componentes(1);

        }

        if (e.getSource() == vender_Producto.btn_cancelar) {

            if (vender_Producto.tabla_lista_agregados.getRowCount() > 0) {
                Eliminar_Producto_Ingresado(0); //  tiene q ser dieferente de 2 ,este es para que elimine todo loss registros 

            } else {
                showMessageDialog(detalle_venta, "Lista de productos vacia", "Sistema de Venta ", 0, icono_prod_vacio);
            }

        }

        if (e.getSource() == vender_Producto.btn_credito) {

            if (vender_Producto.tabla_lista_agregados.getRowCount() > 0) {
                Guardar_Credito();
            } else {
                showMessageDialog(detalle_venta, "NO hay productos para agregar a cliente", "Sistema de Venta", 0, icono_prod_vacio);
            }

        }

        if (e.getSource() == vender_Producto.btn_limpiar) {
            Limpiar_Texto();
        }

        if (e.getSource() == vender_Producto.btn_cobrar) {

            if (vender_Producto.tabla_lista_agregados.getRowCount() > 0) {
                if (Cobrar_Y_Dar_Credito()) {
                    showMessageDialog(detalle_venta, "Productos cobrados con exito", "Sistema de Venta ", 0, icono_bien);
                } else {
                    showMessageDialog(detalle_venta, "Ocurrio un problema cobrar, intentalo mas tarde");
                }
            } else {
                showMessageDialog(detalle_venta, "No hay productos para cobrar", "Sistema de Ventas", 0, icono_prod_vacio);
            }

        }

        if (e.getSource() == detalle_venta.btn_cobrar_detalle_venta) {
            Cobraar_btn_Detalle_Venta();

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

        if (e.getSource() == vender_Producto.txt_producto) {

            char letra = e.getKeyChar();

            if (Character.isLowerCase(letra)) {

                String minuscula = ("" + letra).toUpperCase();

                letra = minuscula.charAt(0);

                e.setKeyChar(letra);

            }
        }

        if (e.getSource() == detalle_venta.txt_precio_venta) {

            char letra = e.getKeyChar();

            if ((letra < '0' || letra > '9') && (letra != '.')) {
                e.consume();
            }

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            if (e.getSource() == vender_Producto.tabla_ventas_productos) {

                Evento_dos_click_Y_enter();

            }
            if (e.getSource() == vender_Producto.txt_producto) {

                if (vender_Producto.tabla_ventas_productos.getRowCount() > 0) {
                    vender_Producto.tabla_ventas_productos.setRowSelectionInterval(0, 0);
                    vender_Producto.tabla_ventas_productos.requestFocus();// esto es para que la tabla gane el foco
                }

            }

        }

        if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {

            if (e.getSource() == vender_Producto.tabla_ventas_productos) {

                vender_Producto.txt_producto.setText("");
                vender_Producto.txt_producto.requestFocus();

            }

        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP) {

            vender_Producto.tabla_ventas_productos.requestFocus();

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getSource() == vender_Producto.txt_producto) {

            modelo.getRowSorter().setRowFilter(RowFilter.regexFilter(vender_Producto.txt_producto.getText(), 4));

        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {

        ///detalle venta
        if (Verificar_cantidad()) {
            Calculo_Inicial();
        } else {
            showMessageDialog(detalle_venta, "Sobrepasa la cantidad disponible", "Sistema de Ventas", 0, icono_prod_vacio);
            detalle_venta.spiner_cantidad.setValue(1);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vender_Producto.tabla_lista_agregados) {
            Eventto_Click(e);

        }

        if (e.getSource() == vender_Producto.tabla_ventas_productos) {
            int numero_click = e.getClickCount();

            if (numero_click > 1) {
                Evento_dos_click_Y_enter();
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
//        if (e.getSource() == detalle_venta.panel_prinicipal_detalle_venta) {
//            detalle_venta.panel_prinicipal_detalle_venta.requestFocusInWindow();
//
//        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    private String opciones[];
    private String credito[][];
    private final Font letras_botones;
    private final Font letras_label;
    private final Color color_botones;
    private final Font letra_txt;
    private final Cursor cursor_mano;
    private final LineBorder linea;
    private final ImageIcon icono_prod_vacio;
    private final ImageIcon icono_bien;
    private final ImageIcon icono_pregunta;
    private final ImageIcon icono_cobrar;

}
