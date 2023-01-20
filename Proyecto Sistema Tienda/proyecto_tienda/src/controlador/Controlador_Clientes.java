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

import modelo.Crud_Nuevo;

import modelo.Modelo_Nuevo;
import modelo.Validacion_txt;
import vistas.Clientes;
import vistas.Vender_Producto;
import static javax.swing.JOptionPane.*;
import javax.swing.RowFilter;
import modelo.Trasparente;

public class Controlador_Clientes implements ActionListener, MouseListener, KeyListener {
    
    private Modelo_Nuevo modelo_nuevo;
    private Clientes clientes;
    private Crud_Nuevo crud_nuevo;
    private Vender_Producto vender_producto; // tambien recibe este objeto para poder poner el cliente el formulario vender prodiucto
    private Validacion_txt validacion_txt;
    private int validar_llamado_click;
    
    public Controlador_Clientes(Modelo_Nuevo modelo_nuevo, Clientes clientes, Crud_Nuevo crud_nuevo, Vender_Producto vender_producto, Validacion_txt validacion_txt) {
        this.modelo_nuevo = modelo_nuevo;
        this.clientes = clientes;
        this.vender_producto = vender_producto;
        this.crud_nuevo = crud_nuevo;
        this.validacion_txt = validacion_txt;
        ////////////////////////////////////////////////////////////////////////
        letras_botones = new Font("Dialog", Font.BOLD, 20);
        color_botones = new Color(30, 138, 137);//color de los botones y del titulo
        letras_label = new Font("Dialog", Font.BOLD, 14);
        letra_txt = new Font("Dialog", Font.BOLD + Font.ITALIC, 13);
        cursor_mano = new Cursor(Cursor.HAND_CURSOR);
        icono_nuevo_cliente = new ImageIcon("src/Image_2/cliente_nuevo.png");
        icono_guardar = new ImageIcon("src/Image_2/guardar_cambios.png");
        icono_cancelar = new ImageIcon("src/Imagenes/cancelar.png");
        icono_pregunta = new ImageIcon("src/Image_Sms/icono_pregunta_nuevo.png");
        icono_bien = new ImageIcon("src/Image_Sms/visto_bien.png");
        icono_admiracion = new ImageIcon("src/Image_Sms/admiracion_nueva.png");

        /////////////////////////////////////////////////////////////////////////
        this.clientes.btn_nuevo.addActionListener(this);
        this.clientes.btn_generar_codigo.addActionListener(this);
        this.clientes.btn_guardar.addActionListener(this);
        this.clientes.btn_cancelar.addActionListener(this);
        //////////////////////////////////////////////////////////////////7

        this.clientes.tabla_clientes.addMouseListener(this);
        ////////////////////////////////////////////////////////////////////////////
        this.clientes.txt_buscar_cliente.addKeyListener(this);
        this.clientes.txt_ingresar_abono.addKeyListener(this);
        this.clientes.txt_cedula.addKeyListener(this);
        this.clientes.txt_nombre_cliente.addKeyListener(this);
        this.clientes.txt_celular.addKeyListener(this);
        ///////////////////////////////////////////////////////////////////////////
        this.clientes.setResizable(false);
        
        Evento_Cerrar_Ventana();
        
        Asignar_Letra_Color();
        
        Asignar_Cursor();

        ///////////////////////////////////////////////////////////////////////////////777
        this.clientes.txt_codigo.setEditable(false);
        
    }
    
    public void Iniciar_Componentes(int validar_llamado_click) {
        this.validar_llamado_click = validar_llamado_click;
        //cuando le llegue el uno quiere decri quye lo llame desde el dialog
        //cuando le llegue el dos lo llame desde el item cliente del menu principal

        clientes.setLocationRelativeTo(null);
        Modelo_Tabla_Clientes();
        
        Bloquear(true);
        Txt_Editable(true);
        clientes.setVisible(true);
        
    }
    
    private void Modelo_Tabla_Clientes() {
        
        modelo_nuevo.setTabla(clientes.tabla_clientes);
        
        if (!crud_nuevo.Tabla_Clientes(modelo_nuevo)) {
            showMessageDialog(clientes, "Error al cargar los clientes a tabla");
        }
        
    }
    
    private void Bloquear(boolean estado) {
        
        clientes.btn_nuevo.setEnabled(estado);
        clientes.btn_generar_codigo.setEnabled(!estado);
        clientes.btn_guardar.setEnabled(!estado);
        clientes.btn_cancelar.setEnabled(!estado);
    }
    
    private void Txt_Editable(boolean estado) {
        
        clientes.txt_nombre_cliente.setEditable(!estado);
        clientes.txt_cedula.setEditable(!estado);
        clientes.txt_celular.setEditable(!estado);
        clientes.txt_ingresar_abono.setEditable(!estado);
        
    }
    
    private void Poner_Datos_En_Vender_Producto(String nombre, String cedula, String telefono, String saldo) {
        
        vender_producto.txt_cliente.setText(nombre);
        vender_producto.txt_cedula.setText(cedula);
        vender_producto.txt_telefono.setText(telefono);
        vender_producto.label_saldo_pendiente.setText(saldo);
        
    }
    
    private void Poner_Datos_Para_Actualizar(String codigo_cliente, String nombre, String cedula, String telefono, String saldo, String abono) {
        
        clientes.txt_codigo.setText(codigo_cliente);
        clientes.txt_nombre_cliente.setText(nombre);
        clientes.txt_cedula.setText(cedula);
        clientes.txt_celular.setText(telefono);
        clientes.txt_ingresar_abono.setText(abono);
        clientes.label_saldo_pendiente.setText(saldo);
        
    }
    
    private void Actualizar_Y_Seleccionr_Cliente(boolean elegir_operacion) {
        
        int fila_seleccioda = clientes.tabla_clientes.getSelectedRow();
        String codigo_cliente = clientes.tabla_clientes.getValueAt(fila_seleccioda, 1).toString();
        String nombre = clientes.tabla_clientes.getValueAt(fila_seleccioda, 2).toString();
        String cedula = clientes.tabla_clientes.getValueAt(fila_seleccioda, 3).toString();
        String telefono = clientes.tabla_clientes.getValueAt(fila_seleccioda, 4).toString();
        String saldo_pendiente = clientes.tabla_clientes.getValueAt(fila_seleccioda, 5).toString();
        
        if (elegir_operacion) {
            Poner_Datos_Para_Actualizar(codigo_cliente, nombre, cedula, telefono, saldo_pendiente, "");
            Txt_Editable(false);
            Bloquear(false);
            clientes.btn_generar_codigo.setEnabled(false);
            clientes.btn_guardar.setText("Guardar Cambios");
        } else {
            Poner_Datos_En_Vender_Producto(nombre, cedula, telefono, saldo_pendiente);
        }
        
    }
    
    private void Evento_Cerrar_Ventana() {
        
        WindowAdapter evento_evento = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                
                Bloquear(true);
                Txt_Editable(true);
                clientes.txt_buscar_cliente.setText("");
                Poner_Datos_Para_Actualizar("", "", "", "", "0.00", "");
                clientes.check_aumentae.setSelected(false);
                
            }
            
        };
        clientes.addWindowListener(evento_evento);
        
    }
    
    private void Guardar_Cliente() {
        
        try {
            
            String operacion_boton = clientes.btn_guardar.getText().trim();
            String codigo = clientes.txt_codigo.getText();
            String nombre = clientes.txt_nombre_cliente.getText().trim().toUpperCase();
            String cedula = clientes.txt_cedula.getText().trim();
            String celular = clientes.txt_celular.getText().trim();
            
            double saldo_pendientes = Double.parseDouble(clientes.label_saldo_pendiente.getText());
            String abono = clientes.txt_ingresar_abono.getText().trim();
            boolean controlar_cedula_repetida = false;
            boolean abono_sin_abono = false;
            int opcion_elegir = 2; //guardar cambios

            String opcion_1 = "Guardar Cambios";
            if (!nombre.isEmpty() && !cedula.isEmpty() && !codigo.isEmpty() && !celular.isEmpty()) {
                
                if (validacion_txt.Validar_cedula(cedula)) {
                    
                    if (validacion_txt.Validar_dies_Numeros(celular)) {
                        
                        if (operacion_boton.equalsIgnoreCase("Guardar Cliente")) {
                            modelo_nuevo.setCedula(cedula);
                            
                            controlar_cedula_repetida = crud_nuevo.Retornar_Datos_Clientes(modelo_nuevo);
                            opcion_1 = "Registrar Cliente";
                            opcion_elegir = 1; //registrar

                        } else if (operacion_boton.equalsIgnoreCase("Guardar Cambios")) {
                            
                            if (!abono.isEmpty()) {
                                
                                double abono_parseado = Double.parseDouble(abono);
                                
                                if (clientes.check_aumentae.isSelected()) { //le suma  el abano al saldo pendiente

                                    saldo_pendientes = saldo_pendientes + Double.parseDouble(abono);
                                    
                                } else if (!clientes.check_aumentae.isSelected()) { //le resta  el abono al saldo pendiente

                                    if (abono_parseado > saldo_pendientes) {
                                        
                                        abono_sin_abono = true;
                                    } else {
                                        saldo_pendientes = saldo_pendientes - Double.parseDouble(abono);
                                        
                                    }
                                    
                                }
                                
                            }
                        }
                        
                        if (!abono_sin_abono) {
                            
                            if (!controlar_cedula_repetida) {
                                
                                String opciones[] = {opcion_1, "Cancelar"};
                                
                                int respuesta = showOptionDialog(clientes, "¿Seguro desea " + opcion_1 + "?", "Sistema de ventas", 0, 0, icono_pregunta, opciones, opciones[0]);
                                
                                if (respuesta == 0) {
                                    modelo_nuevo.setCodigo(codigo);
                                    modelo_nuevo.setNombre_proveedor(nombre);
                                    
                                    modelo_nuevo.setCelular(celular);
                                    modelo_nuevo.setSaldo_pendiente(saldo_pendientes);
                                    
                                    String sms = "Cliente Creado con exito";
                                    controlar_cedula_repetida = true;
                                    
                                    switch (opcion_elegir) {
                                        
                                        case 1:
                                            if (!crud_nuevo.Crear_Cliente_Nuevo(modelo_nuevo)) {
                                                sms = "Ocurrio un error al registrar  cliente \nIntentalo nuevamente";
                                                icono_bien = new ImageIcon("src/Image_2/ELIMINAR.png");
                                                controlar_cedula_repetida = false;
                                            }
                                            
                                            break;
                                        case 2:
                                            sms = "Datos Actualizados  con exito";
                                            if (!crud_nuevo.Actualizar_Cliente(modelo_nuevo)) {
                                                sms = "Ocurrio un error al actualizar cliente \nIntentalo nuevamente";
                                                icono_bien = new ImageIcon("src/Image_2/ELIMINAR.png");
                                            }
                                            break;
                                        
                                    }
                                    
                                    if (controlar_cedula_repetida) {
                                        Modelo_Tabla_Clientes(); //cuando se  cree un nuevo cliente o actualize los datos se actualiza la tabl cliente

                                    }
                                    showMessageDialog(clientes, sms, "Sistema de Ventas", 0, icono_bien);
                                    Bloquear(true);
                                    Txt_Editable(true);
                                    Poner_Datos_Para_Actualizar("", "", "", "", "0.00", "");
                                    clientes.check_aumentae.setSelected(false);
                                    clientes.btn_guardar.setText("Guardar Cliente");
                                    
                                }
                                
                            } else {
                                showMessageDialog(clientes, "Cedula ya se encuentra registrada", "Sistema de Ventas", 0, icono_admiracion);
                                
                            }
                            
                        } else {
                            showMessageDialog(clientes, "El Abono ingresado supera la deuda  del cliente", "Sistema de Ventas", 0, icono_admiracion);
                        }
                        
                    } else {
                        showMessageDialog(clientes, "Telefono debe tener 10 numeros", "Sistema de Ventas", 0, icono_admiracion);
                    }
                    
                } else {
                    showMessageDialog(clientes, "Cedula incorrecta", "Sistema de Ventas", 0, icono_admiracion);
                }
                
            } else {
                
                showMessageDialog(clientes, "Tiene Campos Vacios", "Sistema de Ventas", 0, icono_admiracion);
            }
        } catch (NumberFormatException e) {
            showMessageDialog(clientes, "Abono ingresado incorrecto  \nNota: Para expresar  número decimales utliza el '.' \nEjemplo: 12.4");
        }
        
    }
    
    private void Eliminar_Cliente() {
        
        String codigo = clientes.tabla_clientes.getValueAt(clientes.tabla_clientes.getSelectedRow(), 1).toString();
        String saldo = clientes.tabla_clientes.getValueAt(clientes.tabla_clientes.getSelectedRow(), 5).toString();
        String cliente = clientes.tabla_clientes.getValueAt(clientes.tabla_clientes.getSelectedRow(), 2).toString();
        
        String opciones[] = {"Eliminar", "Cancelar"};
        
        int respuesta = showOptionDialog(clientes, "¿Seguro desea eliminar el cliente  " + cliente + " ? \nSaldo Pendiente: " + saldo, "Sistema de Ventas", 0, 0, icono_pregunta, opciones, opciones[0]);
        
        if (respuesta == 0) {
            modelo_nuevo.setCodigo(codigo);
            String sms = "Cliente elminado con exito";
            if (!crud_nuevo.Actualizar_Datos_Clientes(modelo_nuevo, true)) {
                sms = "No se pudo Eliminar el cliente";
                icono_bien = new ImageIcon("src/Image_2/ELIMINAR.png");
            } else {
                Modelo_Tabla_Clientes(); //cargar tabla de nuevo
            }
            showMessageDialog(clientes, sms, "Sistema de Ventas", 0, icono_bien);
        }
        
    }
    
    private void Asignar_Letra_Color() {
        
        Trasparente txt_buscar = new Trasparente("Nombre del Cliente", clientes.txt_buscar_cliente, Trasparente.Show.ALWAYS);
        clientes.label_titulo.setFont(letras_botones);
        clientes.label_saldo_pendiente.setFont(letras_botones);
        clientes.label_nombre_saldo_pendiente.setFont(letras_botones);
        clientes.label_codigo.setFont(letras_label);
        clientes.label_cedula.setFont(letras_label);
        clientes.label_nombre_cliente.setFont(letras_label);
        
        clientes.label_telefono.setFont(letras_label);
        clientes.label_agregar_bono.setFont(letras_label);
        clientes.label_seleccionar_cliente.setFont(letras_label);
        /////////////////////////////////////////////////////////////////

        clientes.txt_codigo.setFont(letra_txt);
        clientes.txt_buscar_cliente.setFont(letra_txt);
        clientes.txt_celular.setFont(letra_txt);
        clientes.txt_ingresar_abono.setFont(letra_txt);
        clientes.txt_nombre_cliente.setFont(letra_txt);
        clientes.txt_cedula.setFont(letra_txt);
        /////////////////////////////////////////////////////////////////////////
        clientes.btn_cancelar.setFont(letras_label);
        clientes.btn_generar_codigo.setFont(letras_label);
        clientes.btn_guardar.setFont(letras_label);
        clientes.btn_nuevo.setFont(letras_label);
        clientes.check_aumentae.setFont(letras_label);

        ///////COLORES///////////////////////////////////////
        clientes.label_titulo.setForeground(color_botones);
        clientes.label_saldo_pendiente.setForeground(color_botones);
        ///////////ORIENTACIÓN///////////////////////////////////
        clientes.label_agregar_bono.setHorizontalAlignment(0);
        
        clientes.label_nombre_saldo_pendiente.setHorizontalAlignment(0);
        clientes.txt_buscar_cliente.setHorizontalAlignment(0);
        clientes.txt_ingresar_abono.setHorizontalAlignment(0);
        clientes.txt_cedula.setHorizontalAlignment(0);
        clientes.txt_celular.setHorizontalAlignment(0);
        clientes.txt_nombre_cliente.setHorizontalAlignment(0);
        clientes.txt_codigo.setHorizontalAlignment(0);
        ////ICONOS ///////////////////////////////////////////////////////////////////////
        clientes.btn_nuevo.setIcon(icono_nuevo_cliente);
        clientes.btn_cancelar.setIcon(icono_cancelar);
        clientes.btn_guardar.setIcon(icono_guardar);
        
    }
    
    private void Asignar_Cursor() {
        
        clientes.btn_cancelar.setCursor(cursor_mano);
        clientes.btn_generar_codigo.setCursor(cursor_mano);
        clientes.btn_guardar.setCursor(cursor_mano);
        clientes.btn_nuevo.setCursor(cursor_mano);
        
    }
    
    private void Eventto_Click(MouseEvent e) {
        int columnas = clientes.tabla_clientes.getColumnModel().getColumnIndexAtX(e.getX());
        
        if (clientes.tabla_clientes.getRowCount() >= 0) {
            int filas = e.getY() / clientes.tabla_clientes.getRowHeight();
            if (filas < clientes.tabla_clientes.getRowCount() && filas >= 0 && columnas < clientes.tabla_clientes.getColumnModel().getColumnCount() && columnas >= 0) {
                Object value = clientes.tabla_clientes.getValueAt(filas, columnas);
                
                if (value instanceof JButton) {
                    ((JButton) value).doClick();
                    JButton boton = (JButton) value;
                    
                    if (!clientes.btn_guardar.isEnabled()) {
                        if (boton.getName().equalsIgnoreCase("Eliminar")) {
                            
                            Eliminar_Cliente();
                        }
                        if (boton.getName().equalsIgnoreCase("Actualizar")) {
                            
                            Actualizar_Y_Seleccionr_Cliente(true);
                            clientes.txt_cedula.setEditable(false);
                            
                        }
                        
                    } else {
                        
                        showMessageDialog(clientes, "Cancela la operacion actual ","Sistema de Ventas",0,icono_admiracion);
                    }
                    
                } else if (e.getClickCount() == 2) {//poner los datos de un cliente para cobrarle o venderle productos

                    if (validar_llamado_click == 1) {//llamado desde el dialogo  vender prosuctos
                        if (!clientes.btn_guardar.isEnabled()) {
                            Actualizar_Y_Seleccionr_Cliente(false);
                            clientes.dispose();
                            
                        } else {
                            showMessageDialog(clientes, "Cancela la operacion actual ","Sistema de Ventas",0,icono_admiracion);
                            
                        }
                        
                    } //caso contrario si le llegue 2 o otro numero quiere decir que lo  stoy llamadno desde el item cliente

                }
                
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == clientes.btn_generar_codigo) {
            
            String codigo_generado = crud_nuevo.getCodigo_Registro_Proveedor(false);
            clientes.txt_codigo.setText(codigo_generado);
            clientes.btn_generar_codigo.setEnabled(false);
            
        }
        
        if (e.getSource() == clientes.btn_guardar) {
            
            Guardar_Cliente();
        }
        if (e.getSource() == clientes.btn_nuevo) {
            
            Bloquear(false);
            Txt_Editable(false);
            clientes.txt_ingresar_abono.setEditable(false);
        }
        if (e.getSource() == clientes.btn_cancelar) {
            
            Bloquear(true);
            Txt_Editable(true);
            Poner_Datos_Para_Actualizar("", "", "", "", "0.00", ""); // tambieb limpi las cajas de texto
            clientes.btn_guardar.setText("Guardar Cliente");
        }
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == clientes.tabla_clientes) {
            
            Eventto_Click(e);
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

    /////////////////////////////////////////////////////////////////////////////////////////////7
    @Override
    public void keyTyped(KeyEvent e) {
        
        if (e.getSource() == clientes.txt_buscar_cliente) {
            
            char letra = e.getKeyChar();
            
            if (Character.isLowerCase(letra)) {
                String minuscula = ("" + letra).toUpperCase();
                letra = minuscula.charAt(0);
                e.setKeyChar(letra);
            }
            
        }
        
        if (e.getSource() == clientes.txt_ingresar_abono) {
            
            char letra = e.getKeyChar();
            
            if ((letra < '0' || letra > '9') && (letra != '.')) {
                e.consume();
            }
            
        }
        
        if (e.getSource() == clientes.txt_cedula || e.getSource() == clientes.txt_celular) {
            
            char letra = e.getKeyChar();
            
            if (letra < '0' || letra > '9') {
                e.consume();
            }
            
        }
        
        if (e.getSource() == clientes.txt_nombre_cliente) {
            
            char letra = e.getKeyChar();
            
            if ((letra < 'a' || letra > 'z') && letra != ' ' && (letra < 'A' || letra > 'Z')) {
                e.consume();
            }
            
        }
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            Object objeto = e.getSource();
            
            if (objeto == clientes.txt_nombre_cliente) {
                clientes.txt_cedula.requestFocus();
            }
            if (objeto == clientes.txt_cedula) {
                clientes.txt_celular.requestFocus();
            }
            
        }
        
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Object objeto = e.getSource();
            
            if (objeto == clientes.txt_nombre_cliente) {
                clientes.txt_cedula.requestFocus();
            }
            if (objeto == clientes.txt_cedula) {
                clientes.txt_celular.requestFocus();
            }
            
        }
        
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            Object objeto = e.getSource();
            
            if (objeto == clientes.txt_cedula) {
                clientes.txt_nombre_cliente.requestFocus();
            }
            if (objeto == clientes.txt_celular) {
                clientes.txt_cedula.requestFocus();
            }
            
        }
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        modelo_nuevo.getRowSorter().setRowFilter(RowFilter.regexFilter(clientes.txt_buscar_cliente.getText(), 2));
    }
    private final Font letras_botones;
    private final Font letras_label;
    private final Color color_botones;
    private final Font letra_txt;
    private final Cursor cursor_mano;
    private final ImageIcon icono_nuevo_cliente;
    private final ImageIcon icono_guardar;
    private final ImageIcon icono_cancelar;
    private final ImageIcon icono_pregunta;
    private ImageIcon icono_bien;
    private final ImageIcon icono_admiracion;
    
}
