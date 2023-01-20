package controlador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.font.TextAttribute;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;
import javax.swing.JButton;
import modelo.Crud_Cuentas;
import modelo.Modelo;
import vistas.Compras;
import static javax.swing.JOptionPane.*;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import modelo.Trasparente;

import vistas.Menu_Principal;

public class Controlador_Compras implements MouseListener, ActionListener, FocusListener, WindowListener, KeyListener {

    private Modelo modelo;
    private Compras compras;
    private Crud_Cuentas crud_cuentas;

    public Controlador_Compras(Modelo modelo, Compras compras, Crud_Cuentas crud_cuentas) {
        this.modelo = modelo;
        this.compras = compras;
        this.crud_cuentas = crud_cuentas;

        // Modelo_Tabla();
        this.compras.btn_cancelar.setEnabled(false);
        this.compras.panel_principal_compras.setFocusable(true);;

        this.compras.btn_agregar_producto.addActionListener(this);

        this.compras.btn_cancelar.addActionListener(this);
        this.compras.addWindowListener(this);
        this.compras.txt_producto.addFocusListener(this);

        this.compras.txt_buscar_producto.addKeyListener(this);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7
        this.compras.label_campo_oblig_precio.setVisible(false);
        this.compras.label_campo_obliga_producto.setVisible(false);
        this.compras.label_fecha_axiliar.setVisible(false);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Trasparente txt_buscar = new Trasparente("Buscar Producto Registrado", this.compras.txt_buscar_producto, Trasparente.Show.ALWAYS);
        Trasparente txt_agregar_producto = new Trasparente("Nombre Producto", this.compras.txt_producto, Trasparente.Show.ALWAYS);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        this.compras.btn_agregar_producto.addMouseListener(this);
        this.compras.btn_cancelar.addMouseListener(this);

        this.compras.label_nueva_categoria.addMouseListener(this);

        this.compras.spiner_precio.addMouseListener(this);
        this.compras.tabla_compras.addMouseListener(this);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        this.compras.setResizable(false);
        Asignar_Fuente_Letra();
        Asignar_Mouse();
        Asignar_Colores();

    }

    public void Iniciar_Componentes() {
        this.compras.setLocationRelativeTo(null);
        this.compras.setTitle("Sistema de Ventas");
        Modelo_Tabla();
        Cargar_Combos();

        compras.setVisible(true);
    }

    private void Asignar_Fuente_Letra() {

        Font letras_titu_btn = new Font("Dialog", Font.BOLD, 20);
        Font letras_label = new Font("Dialog", Font.BOLD, 13);
        compras.label_titulo.setFont(letras_titu_btn);
        compras.label_titulo.setHorizontalAlignment(0);

        ///////////////////////////////////////////////////////////////////////////////
        compras.label_categoria.setFont(letras_label);
        compras.label_proveedor.setFont(letras_label);
        compras.label_producto.setFont(letras_label);
        compras.label_cantidad.setFont(letras_label);
        compras.label_precio.setFont(letras_label);
        compras.label_egresos_compras.setFont(letras_label);
        compras.label_campo_oblig_precio.setFont(letras_label);
        compras.label_campo_obliga_producto.setForeground(Color.red);
        compras.label_campo_oblig_precio.setForeground(Color.red);

        ///////////////////////////////////////////////////////////////////////////////
        compras.combo_categoria.setFont(letras_label);
        compras.combo_proveedor.setFont(letras_label);
        ///////////////////////////////////////////////////////////////////////////////

        compras.btn_agregar_producto.setFont(letras_titu_btn);
        compras.btn_cancelar.setFont(letras_titu_btn);

        /////////////////////////////////////////////////////////////////////////////
        compras.txt_producto.setHorizontalAlignment(0);
        compras.txt_producto.setFont(letras_label);
        compras.txt_buscar_producto.setHorizontalAlignment(0);
        compras.txt_buscar_producto.setFont(letras_label);
        ///////////////////////////////////////////////
        
         

    }

    private void Cargar_Combos() {

        /*
        cargo los combos categoria y proveedor 
         */
        modelo.setCombo_cliente(compras.combo_categoria); // combo utilixo para la categoria
        modelo.setCombo_productos(compras.combo_proveedor);//utilizo para el proveedor

        compras.combo_categoria.removeAllItems();
        compras.combo_proveedor.removeAllItems();
        crud_cuentas.Llenar_Combo_Categoria(modelo);
        crud_cuentas.Llenar_Combo_Proveedor(modelo);

    }

    private void Asignar_Colores() {

        Color color_letras = new Color(100, 50, 25);
        Color color_botones = new Color(30, 138, 137);

        compras.btn_agregar_producto.setForeground(color_botones);
        compras.btn_cancelar.setForeground(color_botones);

        compras.label_titulo.setForeground(color_botones);
        compras.combo_categoria.setForeground(color_letras);
        compras.combo_proveedor.setForeground(color_letras);
        compras.txt_producto.setForeground(color_letras);
        compras.txt_buscar_producto.setForeground(color_letras);

        compras.label_nueva_categoria.setForeground(new Color(218, 165, 32));

        ////////////////////////////////////////////////////////////////////////////////////
        /*
        color de fondo botones
         */
        compras.btn_agregar_producto.setBackground(color_fondo_btn);
        compras.btn_cancelar.setBackground(color_fondo_btn);
        ////////////////////////////////////////////////////////////////////7
         LineBorder linea = new LineBorder(color_botones, 2, true);
         
         compras.txt_buscar_producto.setBorder(linea);
         compras.txt_producto.setBorder(linea);

    }

    private void Asignar_Mouse() {

        Cursor cursor_mano = new Cursor(Cursor.HAND_CURSOR);
        compras.btn_agregar_producto.setCursor(cursor_mano);
        compras.btn_cancelar.setCursor(cursor_mano);

        compras.combo_categoria.setCursor(cursor_mano);
        compras.combo_proveedor.setCursor(cursor_mano);
        compras.label_nueva_categoria.setCursor(cursor_mano);

    }

    private void Volver_Estados_Iniciales() {
        compras.combo_categoria.setSelectedIndex(0);
        compras.combo_proveedor.setSelectedIndex(0);

        compras.txt_producto.setText("");
        compras.spiner_cantidad.setValue(1);
        compras.spiner_precio.setValue(0);
        compras.spiner_egresos_compra.setValue(1);
        compras.spiner_cantidad.setEnabled(true);
        compras.spiner_egresos_compra.setEnabled(true);
        compras.spiner_precio.setEnabled(true);

        compras.btn_agregar_producto.setText("Agregar Producto");
        compras.label_fecha_axiliar.setText("poner_fecha_auxiliar");
        compras.btn_cancelar.setEnabled(false);

    }

    private void Modelo_Tabla() {

        modelo.setTabla(compras.tabla_compras);

        crud_cuentas.Modelo_Tabla_Compras(modelo);

    }

    private void Poner_Datos_Actualizar() {

        String tomar_cantidad = compras.tabla_compras.getValueAt(compras.tabla_compras.getSelectedRow(), 10).toString();
        String tomar_producto = compras.tabla_compras.getValueAt(compras.tabla_compras.getSelectedRow(), 6).toString();

        if (!tomar_cantidad.equals("VACIA")) { // solo si es diferente de vacio pone los valores para actualizar

            String tomar_codigo = compras.tabla_compras.getValueAt(compras.tabla_compras.getSelectedRow(), 1).toString();
            String tomar_categoria = compras.tabla_compras.getValueAt(compras.tabla_compras.getSelectedRow(), 3).toString();
            String tomar_proveedor = compras.tabla_compras.getValueAt(compras.tabla_compras.getSelectedRow(), 4).toString().trim();
            String tomar_codigo_proveedor = compras.tabla_compras.getValueAt(compras.tabla_compras.getSelectedRow(), 5).toString().trim();
            double egresos = Double.parseDouble(compras.tabla_compras.getValueAt(compras.tabla_compras.getSelectedRow(), 8).toString().trim());
            double precio_cada_uno = Double.parseDouble(compras.tabla_compras.getValueAt(compras.tabla_compras.getSelectedRow(), 9).toString().trim());

            //String tomar_producto = compras.tabla_compras.getValueAt(compras.tabla_compras.getSelectedRow(), 6).toString();
            compras.combo_categoria.setSelectedItem(tomar_categoria);
            compras.combo_proveedor.setSelectedItem(tomar_proveedor + "  :" + tomar_codigo_proveedor);

            compras.txt_producto.setText(tomar_producto);

            compras.label_fecha_axiliar.setText(tomar_codigo);

            compras.spiner_precio.setValue(precio_cada_uno);
            compras.spiner_egresos_compra.setValue(egresos);

            compras.spiner_cantidad.setValue(Integer.parseInt(tomar_cantidad));
            compras.btn_agregar_producto.setText("Actualizar Producto");

            compras.btn_cancelar.setEnabled(true);

            compras.spiner_cantidad.setEnabled(false);
            compras.spiner_egresos_compra.setEnabled(false);
            compras.spiner_precio.setEnabled(false);

        } else {

            Volver_Estados_Iniciales(); //si es vacio pone los estados iniciales
            showMessageDialog(compras, "Producto " + tomar_producto.toUpperCase() + "  se ah terminado \nAgrega un nuevo registro");
        }

    }

    private void Eliminar_Compras_Ingresadas() {

        String opciones[] = {"Si, Eliminar", "Cancelar"};

        int opcion = showOptionDialog(compras.tabla_compras, "¿Eliminar Registro?", "Sistema de Tienda", 0, 0, null, opciones, opciones[1]);

        if (opcion == 0) {

            String tomar_codigo = compras.tabla_compras.getValueAt(compras.tabla_compras.getSelectedRow(), 1).toString();

            modelo.setCodigo_registro(tomar_codigo);
            String sms = "Registro eliminado correctamente";
            boolean recibir = crud_cuentas.Eliminar_Tabla_Ventas(modelo);

            if (!recibir) {
                sms = "No se pudo eliminar , surgio un error";
            }

            showMessageDialog(compras.tabla_compras, sms);

            if (recibir) { // solo si elimina el reigstro que se actualize la tabla
                Modelo_Tabla();
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == compras.btn_agregar_producto) {
            String codigo_fecha = "";
            String producto = compras.txt_producto.getText().trim(); // nombre del producto a registrar
            double precio = Double.parseDouble(compras.spiner_precio.getValue().toString());//precio unitario de cada producto
            double egresos_compras = Double.parseDouble(compras.spiner_egresos_compra.getValue().toString()); // costo de las compras
            if (!producto.isEmpty()) {

                if (precio > 0) {

                    boolean elegir = true;
                    ///////Obtener la fecha tipo String////////////////////////////
                    Calendar calendario = Calendar.getInstance();
                    java.util.Date fecha_ingreso = calendario.getTime();
                    String format_hora = "dd/MM/yyyy  hh:mm:ss";
                    SimpleDateFormat dateFormat = new SimpleDateFormat(format_hora);
                    String fecha_agregar_ventas = dateFormat.format(fecha_ingreso);
                    ////////////////////////////////////////////////7
                    String op1 = "Agregar Producto";
                    String sms_jop = "¿ Seguro Desea Agregar Producto? ";

                    if (compras.btn_cancelar.isEnabled()) {
                        op1 = "Actualizar Registros";
                        sms_jop = "¿ Seguro Desea Actulizar  Registro? ";
                        fecha_agregar_ventas = compras.label_fecha_axiliar.getText();
                        elegir = false;

                    }

                    String opciones[] = {op1, "Cancelar"};

                    int res = showOptionDialog(compras, sms_jop, "Sistema de Tienda", 0, 0, null, opciones, opciones[1]);

                    sms_jop = "Registro Actualizado Correctamente";

                    if (res == 0) {

                        String categoria = compras.combo_categoria.getSelectedItem().toString();
                        String proveedor = compras.combo_proveedor.getSelectedItem().toString();
                        int indice_codigo_provedor = proveedor.indexOf(":");
                        String solo_codigo_proveedor = proveedor.substring(indice_codigo_provedor + 1, proveedor.length());
                        String solo_nombre_proveedor = proveedor.substring(0, indice_codigo_provedor - 2);

                        int cantidad = Integer.parseInt(compras.spiner_cantidad.getValue().toString());

                        java.sql.Date fecha_enviar = null;
                        if (!compras.btn_cancelar.isEnabled()) {

                            /////////////////////////////////////////////////////////////////////////
                            /////Construir un objeto tipo date para pasarle a la tabla_ventas/////////////
                            int anno = (calendario.get(Calendar.YEAR) - 1900);
                            int mes = calendario.get(Calendar.MONTH);
                            int dia = calendario.get(Calendar.DATE);
//            int hora_salida = calendario.get(Calendar.HOUR_OF_DAY);
//            int minutos_salida = calendario.get(Calendar.MINUTE);
//            int segundo_salida = calendario.get(Calendar.SECOND);
                            fecha_enviar = new java.sql.Date(anno, mes, dia);
                            sms_jop = "Producto Agregado Correctamente";

                            modelo.setFecha_tipo_date(fecha_enviar);
                            ///////////////////7
                            codigo_fecha = crud_cuentas.getCodigo_Registro_Compras();

                        } else {
                            codigo_fecha = compras.label_fecha_axiliar.getText();
                        }

                        //  String codigo =crud_cuentas.getCodigo_Registro();
                        ///Pasarle al modelo los valore/////////////////////////////////
                        modelo.setCodigo_proveedor(solo_codigo_proveedor);
                        modelo.setFecha(fecha_agregar_ventas);
                        modelo.setCategoria(categoria);
                        modelo.setProveedor(solo_nombre_proveedor);
                        modelo.setProducto(producto.toUpperCase());
                        modelo.setCantidad_productos(cantidad);
                        modelo.setEgresos_por_compras(egresos_compras);

                        modelo.setPrecio(precio);

                        modelo.setTotal_cobrar(0);// cuando registre un nuevo producto el ingreso sera 0
                        modelo.setCantidad_disponibles(cantidad);
                        modelo.setGanancias_tabla_compras(0);//cuando registre  un nuevo producto la ganancia sera 0

                        modelo.setCodigo_registro(codigo_fecha);

                        crud_cuentas.Insertar_Tabla_Ventas(modelo, elegir);

                        Modelo_Tabla();
                        Volver_Estados_Iniciales();

                    }

                } else {
                    compras.label_campo_oblig_precio.setVisible(true);
                }
            } else if (producto.isEmpty()) {
                compras.label_campo_obliga_producto.setVisible(true);
            }

        } else if (e.getSource() == compras.btn_cancelar) {

            Volver_Estados_Iniciales();
        }

    }

    ///////////////Evento de raton//////////////////////////////////
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == compras.label_nueva_categoria) {

            String sms = "Ingrese";
            boolean estado = true;
            String nombre_repetir = "Categoria ";

            int re = 1;
            if (e.getSource() == compras.label_nueva_categoria) {
                sms += " Nueva Categoria";

            }

            String tomar_opcion = showInputDialog(compras, sms, "Sistema de Tienda", QUESTION_MESSAGE);

            if (tomar_opcion != null) {
                if (!tomar_opcion.isEmpty()) {

                    modelo.setCliente(tomar_opcion.toUpperCase()); //le paso el provedor o cliente

                    if (!crud_cuentas.Verificar_No_Repetir_Catego_Pro(modelo, estado)) { // si retorno falso , quiere decir q  la nueva 
                        //categoria o proveedor no esta registrada , osea no es repetido y lo puedo agregar
                        if (crud_cuentas.Insertar_Proveedor(modelo, re)) {
                            sms = "Categoria Agregada Correctamente";
                            if (re == 2) {
                                sms = "Proveedor Agregado Correctamente";
                            }
                            showMessageDialog(compras, sms);
                            Cargar_Combos();//actualizo los combos despues de agregar un nuevo  proveedor o categoria
                        }

                    } else {

                        showMessageDialog(compras, "     " + nombre_repetir + " NO agregada(o)\n\n" + nombre_repetir + tomar_opcion.toUpperCase() + " ya se encuentra registrada(o)");
                    }

                }

            }

        } else if (e.getSource() == compras.tabla_compras) {

            if (e.getClickCount() == 2) { // cuando doy dos click  sobre la tabla , pongo los datos de una filas , en  los campos 

                if (compras.tabla_compras.getRowCount() > 0) {
                    Poner_Datos_Actualizar();

                }

            } else { // para eliminar un registro de compras

                int columnas = compras.tabla_compras.getColumnModel().getColumnIndexAtX(e.getX());

                if (compras.tabla_compras.getRowCount() >= 0) {
                    int filas = e.getY() / compras.tabla_compras.getRowHeight();
                    if (filas < compras.tabla_compras.getRowCount() && filas >= 0 && columnas < compras.tabla_compras.getColumnModel().getColumnCount() && columnas >= 0) {
                        Object value = compras.tabla_compras.getValueAt(filas, columnas);

                        if (value instanceof JButton) {
                            ((JButton) value).doClick();
                            JButton boton = (JButton) value;
                            if (compras.btn_cancelar.isEnabled() == false) {
                                Eliminar_Compras_Ingresadas();
                            } else { // si esta activo para actulizar , no se pora eliminar el producto
                                showMessageDialog(compras.tabla_compras, "Cancela la operacion de actualizar primero");
                            }

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
        this.compras.label_campo_oblig_precio.setVisible(false);

        if (e.getSource() == compras.label_nueva_categoria) {

            compras.label_nueva_categoria.setFont(new Font("Dialog", Font.BOLD, 14));
            Font font = compras.label_nueva_categoria.getFont();

            Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();

            map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

            font = font.deriveFont(map);

            compras.label_nueva_categoria.setFont(font);
            compras.label_nueva_categoria.setForeground(new Color(30, 138, 137));

        }

        if (e.getSource() == compras.btn_agregar_producto) {

            compras.btn_agregar_producto.setBackground(color_fondo_btn_ingresado);
        }
        if (e.getSource() == compras.btn_cancelar && compras.btn_cancelar.isEnabled()) {

            compras.btn_cancelar.setBackground(color_fondo_btn_ingresado);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (e.getSource() == compras.label_nueva_categoria) {

            compras.label_nueva_categoria.setFont(new Font("Dialog", Font.BOLD, 12));

            Font font = compras.label_nueva_categoria.getFont();

            Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();

            map.put(TextAttribute.UNDERLINE, -1);
            font = font.deriveFont(map);

            compras.label_nueva_categoria.setFont(font);
            compras.label_nueva_categoria.setForeground(new Color(218, 165, 32));

        }

        if (e.getSource() == compras.btn_agregar_producto) {

            compras.btn_agregar_producto.setBackground(color_fondo_btn);
        }
        if (e.getSource() == compras.btn_cancelar) {

            compras.btn_cancelar.setBackground(color_fondo_btn);
        }

    }

    ////////////Evento de Foco///////////////////////////////////
    @Override
    public void focusGained(FocusEvent e) {

        this.compras.label_campo_obliga_producto.setVisible(false);

        //Modelo_Tabla();
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    ///////////Evento de ventana /////////////////////////////////
    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Volver_Estados_Iniciales();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    //////////////Evento de teclado/////////////////////////////////////////////////
    @Override
    public void keyTyped(KeyEvent e) {

        char tecla = e.getKeyChar();

        if (Character.isLowerCase(tecla)) {
            String miniscula = ("" + tecla).toUpperCase();
            tecla = miniscula.charAt(0);
            e.setKeyChar(tecla);

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

        //FILTRAN MEDIANTE EL PRODUCTO// el numero 5 es pra indicar la columnas por la cual va a filtrar
        modelo.getRowSorter().setRowFilter(RowFilter.regexFilter(compras.txt_buscar_producto.getText(), 6));
    }
    private Color color_fondo_btn = new Color(230, 230, 250);
    private Color color_fondo_btn_ingresado = new Color(221, 160, 221);

}
