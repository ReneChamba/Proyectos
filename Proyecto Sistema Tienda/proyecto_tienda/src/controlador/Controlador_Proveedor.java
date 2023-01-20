package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.*;
import vistas.Proveedores;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import static javax.swing.JOptionPane.*;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Controlador_Proveedor implements ActionListener, KeyListener, MouseListener, FocusListener {

    private Modelo_Nuevo modelo_nuevo;
    private Crud_Nuevo crud_nuevo;
    private Proveedores proveedor;
    private Controlador_Productos_Proveedores controlador_productos_proveedores;
    private Validacion_txt validacion_txt;

    public Controlador_Proveedor(Modelo_Nuevo modelo_nuevo, Crud_Nuevo crud_nuevo, Proveedores proveedor, Controlador_Productos_Proveedores controlador_productos_proveedores, Validacion_txt validacion_txt) {
        this.modelo_nuevo = modelo_nuevo;
        this.crud_nuevo = crud_nuevo;
        this.proveedor = proveedor;
        this.validacion_txt = validacion_txt;
        ////////////////////////////////////////////////////////////////////////////////////////
        this.controlador_productos_proveedores = controlador_productos_proveedores;
        this.proveedor.btn_esconder.addActionListener(this);
        this.proveedor.btn_registrar_proveedor.addActionListener(this);
        this.proveedor.btn_agregar.addActionListener(this);
        this.proveedor.btn_generar_codigo.addActionListener(this);
        this.proveedor.btn_actualizar_proveedor.addActionListener(this);
        this.proveedor.btn_cancelar.addActionListener(this);
        this.proveedor.btn_eliminar.addActionListener(this);
        this.proveedor.btn_listar.addActionListener(this);
        this.proveedor.btn_bajar_tabla.addActionListener(this);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////7
        this.proveedor.tabla_proveedor.addMouseListener(this);
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        this.proveedor.txt_cedula.addFocusListener(this);
        this.proveedor.txt_correo.addFocusListener(this);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        color_botones = new Color(30, 138, 137);//color de los botones y del titulo
        icono_nuevo_cliente = new ImageIcon("src/Image_2/cliente_nuevo.png");
        icono_guardar = new ImageIcon("src/Image_2/guardar_cambios.png");
        icono_cancelar = new ImageIcon("src/Imagenes/cancelar.png");
        icono_pregunta = new ImageIcon("src/Image_Sms/icono_pregunta_nuevo.png");
        icono_bien = new ImageIcon("src/Image_Sms/visto_bien.png");
        icono_admiracion = new ImageIcon("src/Image_Sms/admiracion_nueva.png");
        eliminar = new ImageIcon("src/Image_2/eliminar_2.png");
        listar = new ImageIcon("src/Image_2/lista_nueva.png");

        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        this.proveedor.txt_codigo.addKeyListener(this);
        this.proveedor.txt_cedula.addKeyListener(this);
        this.proveedor.txt_nombre_provee.addKeyListener(this);
        this.proveedor.txt_codigo.addKeyListener(this);
        this.proveedor.txt_empresa.addKeyListener(this);
        this.proveedor.txt_correo.addKeyListener(this);
        this.proveedor.txt_telefono_fijo.addKeyListener(this);
        this.proveedor.txt_celular.addKeyListener(this);
        this.proveedor.combo_provincia.setSelectedIndex(20);
        this.proveedor.txt_codigo.setEditable(false);
        this.proveedor.setResizable(false);
        Ocultar_Label();
        Evento_Cerrar_Ventana();
        Asignar_Fuente();

        Asignar_Tipo_Cursor();
        Asignar_Imagenes();

    }

    public void Iniciar_Componentes() {
        proveedor.panel_tabla.setVisible(false);
        // Animacion.Animacion.bajar(310, 680, 2, 2, proveedor.panel_tabla);

        proveedor.setSize(950, 620);
        Estados_Enabled_Y_True(false);
        proveedor.setLocationRelativeTo(null);
        proveedor.setVisible(true);
    }

    private void Ocultar_Label() {
        proveedor.label_cedula_error.setVisible(false);

        proveedor.label_error_correo.setVisible(false);
    }

    private void Esconder() {

        int posicion = proveedor.btn_esconder.getX();

        if (posicion > 10) {
            Animacion.Animacion.mover_izquierda(230, 5, 2, 2, proveedor.btn_esconder);
            Animacion.Animacion.mover_izquierda(5, -230, 2, 2, proveedor.panel_deslizable);
            proveedor.btn_esconder.setIcon(new ImageIcon("src/Image_2/derecho.png"));
        } else {
            Animacion.Animacion.mover_derecha(5, 230, 2, 2, proveedor.btn_esconder);
            Animacion.Animacion.mover_derecha(-230, 5, 2, 2, proveedor.panel_deslizable);
            proveedor.btn_esconder.setIcon(new ImageIcon("src/Image_2/izquierda.png"));

        }

    }

    private void Mover_Panel_Datos() {
//
//        Animacion.Animacion.mover_derecha(730, 1265, 2, 2, proveedor.panel_datos);
//        System.out.println("");
//
//        //proveedor.panel_datos.setVisible(false);
        modelo_nuevo.setTabla(proveedor.tabla_proveedor);

        if (!crud_nuevo.Tabla_Proveedor(modelo_nuevo)) {
            showMessageDialog(proveedor, "Surgio un error al listar los proveedores", "Sistema de Ventas", 0, eliminar);
        } else {
            proveedor.panel_tabla.setVisible(true);
            proveedor.panel_datos.setVisible(false);
//            Animacion.Animacion.subir(680, 310, 3, 2, proveedor.panel_tabla);

        }

    }

    private void Bajar_Panel_Tabla() {

//        Animacion.Animacion.bajar(310, 680, 2, 2, proveedor.panel_tabla);
//        Animacion.Animacion.mover_izquierda(1265, 730, 2, 2, proveedor.panel_datos);
        proveedor.panel_tabla.setVisible(false);
        proveedor.panel_datos.setVisible(true);

    }

    private void Asignar_Imagenes() {
        proveedor.btn_esconder.setIcon(new ImageIcon("src/Image_2/izquierda.png"));

        proveedor.btn_agregar.setIcon(icono_nuevo_cliente);
        proveedor.btn_actualizar_proveedor.setIcon(icono_guardar);
        proveedor.btn_eliminar.setIcon(eliminar);
        proveedor.btn_cancelar.setIcon(icono_cancelar);
        proveedor.btn_listar.setIcon(listar);

    }

    private void Boton_Para_Actualizar(String Poner_texto) {

        proveedor.txt_codigo.setEditable(true);
        proveedor.btn_generar_codigo.setText("Buscar Proveedor");
        //proveedor.btn_registrar_proveedor.setText("Actualizar Datos");
        proveedor.btn_registrar_proveedor.setText(Poner_texto);
        proveedor.btn_generar_codigo.setEnabled(true);
        proveedor.btn_cancelar.setEnabled(true);
        proveedor.txt_codigo.requestFocus();

    }

    private void Asignar_Tipo_Cursor() {

        Cursor cursor_mano = new Cursor(12);

        proveedor.btn_agregar.setCursor(cursor_mano);
        proveedor.btn_actualizar_proveedor.setCursor(cursor_mano);
        proveedor.btn_cancelar.setCursor(cursor_mano);
        proveedor.btn_eliminar.setCursor(cursor_mano);
        proveedor.btn_esconder.setCursor(cursor_mano);
        proveedor.btn_listar.setCursor(cursor_mano);
        proveedor.btn_registrar_proveedor.setCursor(cursor_mano);
        proveedor.btn_generar_codigo.setCursor(cursor_mano);
        proveedor.combo_provincia.setCursor(cursor_mano);
        proveedor.btn_bajar_tabla.setCursor(cursor_mano);

    }

    private void Asignar_Fuente() {

        Font letra_label = new Font("Dialog", 1, 15);
        Font letra_txt = new Font("Dialog", Font.BOLD + Font.ITALIC, 15);
        Font letra_botones = new Font("Dialog", Font.BOLD, 17);
        /*
        Letra para los Jlabel
         */

        proveedor.label_cedula_error.setForeground(Color.red);
        proveedor.label_error_correo.setForeground(Color.red);
        proveedor.label_titulo.setForeground(color_botones);

        proveedor.label_titulo.setText("Configuración de Proveedores");
        proveedor.label_titulo.setFont(new Font("Dialog", Font.BOLD, 20));
        proveedor.label_cedula.setFont(letra_label);
        proveedor.label_nombre.setFont(letra_label);
        proveedor.label_codigo.setFont(letra_label);
        proveedor.label_celular.setFont(letra_label);
        proveedor.label_correo.setFont(letra_label);
        proveedor.label_empresa.setFont(letra_label);
        proveedor.label_provincia.setFont(letra_label);
        proveedor.label_direccion.setFont(letra_label);
        proveedor.label_telefono_fijo.setFont(letra_label);

        /*
        Letra para los txt 
         */
        proveedor.txt_codigo.setFont(letra_txt);
        proveedor.txt_cedula.setFont(letra_txt);
        proveedor.txt_nombre_provee.setFont(letra_txt);
        proveedor.txt_empresa.setFont(letra_txt);
        proveedor.txt_direccion.setFont(letra_txt);
        proveedor.txt_telefono_fijo.setFont(letra_txt);
        proveedor.txt_celular.setFont(letra_txt);
        proveedor.txt_correo.setFont(letra_txt);
        proveedor.combo_provincia.setFont(letra_txt);
        /*
        Asiganr_Horientacion Horizontal
         */

        proveedor.txt_codigo.setHorizontalAlignment(0);
        proveedor.txt_cedula.setHorizontalAlignment(0);
        proveedor.txt_nombre_provee.setHorizontalAlignment(0);
        proveedor.txt_empresa.setHorizontalAlignment(0);
        proveedor.txt_direccion.setHorizontalAlignment(0);
        proveedor.txt_telefono_fijo.setHorizontalAlignment(0);
        proveedor.txt_celular.setHorizontalAlignment(0);
        proveedor.txt_correo.setHorizontalAlignment(0);
        proveedor.label_titulo.setHorizontalAlignment(0);

        /*
        Letra para los Botones
         */
        proveedor.btn_actualizar_proveedor.setFont(letra_botones);
        proveedor.btn_agregar.setFont(letra_botones);
        proveedor.btn_cancelar.setFont(letra_botones);
        proveedor.btn_eliminar.setFont(letra_botones);
        proveedor.btn_listar.setFont(letra_botones);
        proveedor.btn_registrar_proveedor.setFont(letra_botones);
        proveedor.btn_generar_codigo.setFont(letra_label);

    }

    private void Limpiar_Solo_Cajas() {
        proveedor.txt_codigo.setText("");
        proveedor.txt_cedula.setText("");
        proveedor.txt_nombre_provee.setText("");
        proveedor.txt_empresa.setText("");
        proveedor.txt_direccion.setText("");
        proveedor.txt_telefono_fijo.setText("");
        proveedor.txt_celular.setText("");
        proveedor.txt_correo.setText("");
        proveedor.combo_provincia.setSelectedIndex(20);
    }

    private void Limpiar_Cajas_Y_Mas() {

        Limpiar_Solo_Cajas();

        proveedor.btn_generar_codigo.setText("Generar Codigo");
        proveedor.btn_registrar_proveedor.setText("Registrar Proveedor");

    }

    private void Evento_Cerrar_Ventana() {

        WindowListener evento_Cerrar = new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                Limpiar_Cajas_Y_Mas();
                Habiliar_Solo_Botones();
                Ocultar_Label();
                proveedor.panel_tabla.setVisible(false);
                proveedor.panel_datos.setVisible(true);

            }

        };
        proveedor.addWindowListener(evento_Cerrar);

    }

    private void Generar_Codigo_Buscar_Proveedor() {

        String tomar_texto_btn = proveedor.btn_generar_codigo.getText();

        if (tomar_texto_btn.equals("Generar Codigo")) {
            String tomar_codigo = crud_nuevo.getCodigo_Registro_Proveedor(true);
            proveedor.txt_codigo.setText(tomar_codigo);
            proveedor.btn_generar_codigo.setEnabled(false);

        } else if (tomar_texto_btn.equals("Buscar Proveedor")) {

            String codigo = proveedor.txt_codigo.getText();

            if (!codigo.isEmpty()) {

                modelo_nuevo.setCodigo(codigo);

                if (crud_nuevo.Buscar_Proveedor(modelo_nuevo)) {

                    proveedor.txt_cedula.setText(modelo_nuevo.getCedula());
                    proveedor.txt_nombre_provee.setText(modelo_nuevo.getNombre_proveedor());
                    proveedor.txt_empresa.setText(modelo_nuevo.getEmpresa());
                    proveedor.txt_direccion.setText(modelo_nuevo.getDireccion());
                    proveedor.txt_telefono_fijo.setText(modelo_nuevo.getTlf_fijo());
                    proveedor.txt_celular.setText(modelo_nuevo.getCelular());
                    proveedor.txt_correo.setText(modelo_nuevo.getCorreo());
                    proveedor.combo_provincia.setSelectedItem(modelo_nuevo.getProvincia());

                    String tomar_nombre_boton = proveedor.btn_registrar_proveedor.getText();
                    /// esto es para validar si esque es para actualizar que habilite los controles para editar , pero si  busca para eliminar , que no
                    ///no hablite los controles.
                    if (tomar_nombre_boton.equals("Eliminar Proveedor")) {

                        // Estados_Enabled_False();
                        Estados_Enabled_Y_True(false);
                        proveedor.btn_registrar_proveedor.setEnabled(true);
                        proveedor.btn_cancelar.setEnabled(true);
                        proveedor.btn_generar_codigo.setEnabled(true);
                    } else {
                        // Estados_Enabled_True();
                        Estados_Enabled_Y_True(true);
                    }

                    proveedor.txt_codigo.setEditable(false);
                    proveedor.btn_generar_codigo.setText("Nuevo");

                } else {
                    showMessageDialog(proveedor, "Proveedor No registrado", "Sistema de Ventas", 0, icono_admiracion);
                    proveedor.txt_codigo.setText("");
                    proveedor.txt_codigo.requestFocus();

                }

            } else {
                showMessageDialog(proveedor, "Ingresa el codigo del Proveedor", "Sistema de Ventas", 0, icono_admiracion);
            }
        } else if (tomar_texto_btn.equals("Nuevo")) {

            String sms_poner_boton = proveedor.btn_registrar_proveedor.getText();

            Boton_Para_Actualizar(sms_poner_boton);
            Limpiar_Solo_Cajas();
            // Estados_Enabled_False();
            Estados_Enabled_Y_True(false);
            proveedor.btn_registrar_proveedor.setEnabled(false);
            proveedor.btn_cancelar.setEnabled(true);
            proveedor.btn_generar_codigo.setEnabled(true);
            proveedor.txt_codigo.setEditable(true);
        }

    }

    private void Boton_Cancelar() {
        Limpiar_Cajas_Y_Mas();
        //Estados_Enabled_False();
        Estados_Enabled_Y_True(false);

    }

    private void Registrar_Proveedor() {

        String codigo = proveedor.txt_codigo.getText().trim();
        String cedula = proveedor.txt_cedula.getText().trim();
        String nombre = proveedor.txt_nombre_provee.getText().trim();
        String empresa = proveedor.txt_empresa.getText().trim();
        String direccion = proveedor.txt_direccion.getText().trim();
        String provincia = proveedor.combo_provincia.getSelectedItem().toString();
        String correo = proveedor.txt_correo.getText().trim();
        String tlf_fijo = proveedor.txt_telefono_fijo.getText().trim();
        String celular = proveedor.txt_celular.getText().trim();

        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (!codigo.isEmpty() && !cedula.isEmpty() && !nombre.isEmpty() && !empresa.isEmpty() && !direccion.isEmpty()
                && !correo.isEmpty() && !tlf_fijo.isEmpty() && !celular.isEmpty()) {

            String nombre_boton = proveedor.btn_registrar_proveedor.getText();

            String opcion_1 = "Registrar";
            String opcion_2 = "Cancelar";
            String sms = "¿Registrar Proveedor?";
            int elegir_operacion_boton = 1;
            /*
            
            1 = registrar un nuevo proveedor
            2= atualizar datos 
            3 = eliminar un proveedor
             */
            if (nombre_boton.equals("Actualizar Datos")) {
                opcion_1 = "Actualizar";
                opcion_2 = "Olvidar";
                sms = "¿Actualizar Datos?";

                elegir_operacion_boton = 2;

            }

            if (nombre_boton.equals("Eliminar Proveedor")) {
                opcion_1 = "Eliminar";
                elegir_operacion_boton = 3;
                sms = "¿Eliminar Proveedor?";

            }

            String opciones[] = {opcion_1, opcion_2};
            ///////////////////////////////////////////////////Aqui me kede////////////////////////

            int respuesta = showOptionDialog(proveedor, sms, "Sistema de Ventas", 0, 0, icono_pregunta, opciones, opciones[1]);

            if (respuesta == 0) {
                modelo_nuevo.setCodigo(codigo);

                if (elegir_operacion_boton != 3) {
                    Calendar fecha_hora = Calendar.getInstance();

                    int anio = fecha_hora.get(Calendar.YEAR);
                    int mes = fecha_hora.get(Calendar.MONTH);
                    int dia = fecha_hora.get(Calendar.DATE);

                    Date fecha_nueva = new Date(anio - 1900, mes, dia);

                    modelo_nuevo.setFecha_registro(fecha_nueva);

                    modelo_nuevo.setCedula(cedula);
                    modelo_nuevo.setNombre_proveedor(nombre);
                    modelo_nuevo.setEmpresa(empresa);
                    modelo_nuevo.setDireccion(direccion);
                    modelo_nuevo.setProvincia(provincia);
                    modelo_nuevo.setCorreo(correo);
                    modelo_nuevo.setTlf_fijo(tlf_fijo);
                    modelo_nuevo.setCelular(celular);

                }

                String sms_2 = "Proveedor Registrado Correctamente";
                icono_bien = new ImageIcon("src/Image_Sms/visto_bien.png");

                switch (elegir_operacion_boton) {

                    case 1:
                        if (!crud_nuevo.Ingresar_Nuevo_Proveedor(modelo_nuevo)) {
                            sms_2 = "No se pudo Registrar el proveedor";
                            icono_bien = new ImageIcon("src/Image_Sms/admiracion_nueva.png");//si sucede un erro cambia el incon

                        }
                        Limpiar_Solo_Cajas();
                        proveedor.btn_generar_codigo.setEnabled(true);
                        break;
                    case 2:
                        sms_2 = "Proveedor Actualizado Correctamente";
                        if (!crud_nuevo.Actualizar_Proveedor(modelo_nuevo)) {
                            sms_2 = "No se pudo Actualizar  el Proveedor";
                            icono_bien = new ImageIcon("src/Image_Sms/admiracion_nueva.png");

                        }

                        break;
                    case 3:
                        sms_2 = "Proveedor Eliminado Correctamente";
                        if (!crud_nuevo.Eliminar_Proveedor(modelo_nuevo)) {
                            sms_2 = "No se pudo Eliminar Proveedor";
                            icono_bien = new ImageIcon("src/Image_Sms/admiracion_nueva.png");
                        }

                        break;
                    default:
                        break;
                }

                showMessageDialog(proveedor, sms_2);

                if (elegir_operacion_boton == 2 || elegir_operacion_boton == 3) {
                    /*
                    para actualizar y eliminar hacen esto lo mismo
                     */
                    Limpiar_Solo_Cajas();
                    //Estados_Enabled_False();
                    Estados_Enabled_Y_True(false);
                    proveedor.btn_generar_codigo.setText("Buscar Proveedor");
                    proveedor.txt_codigo.setEditable(true);
                    proveedor.btn_generar_codigo.setEnabled(true);
                    proveedor.btn_cancelar.setEnabled(true);
                }

            }

        } else {
            showMessageDialog(proveedor, "Hay campos vacios , completa todos los datos", "Sistema de Ventas", 0, icono_admiracion);

        }
    }

    private void Desahabiliar_Solo_Botones() {

        proveedor.btn_agregar.setEnabled(false);
        proveedor.btn_actualizar_proveedor.setEnabled(false);
        proveedor.btn_eliminar.setEnabled(false);
        proveedor.btn_listar.setEnabled(false);
    }

    private void Habiliar_Solo_Botones() {

        proveedor.btn_agregar.setEnabled(true);
        proveedor.btn_actualizar_proveedor.setEnabled(true);
        proveedor.btn_eliminar.setEnabled(true);
        proveedor.btn_listar.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == proveedor.btn_esconder) {

            Esconder();

        }
        if (e.getSource() == proveedor.btn_registrar_proveedor) {

            Registrar_Proveedor();

            proveedor.btn_agregar.setEnabled(false);
            proveedor.btn_actualizar_proveedor.setEnabled(false);

        }
        if (e.getSource() == proveedor.btn_agregar) {

            //Estados_Enabled_True();
            Estados_Enabled_Y_True(true);
            Desahabiliar_Solo_Botones();

        }
        if (e.getSource() == proveedor.btn_generar_codigo) {

            Generar_Codigo_Buscar_Proveedor();

        }
        if (e.getSource() == proveedor.btn_actualizar_proveedor) {

            Boton_Para_Actualizar("Actualizar Datos");
            Desahabiliar_Solo_Botones();

        }
        if (e.getSource() == proveedor.btn_cancelar) {

            Boton_Cancelar();
            Habiliar_Solo_Botones();

        }
        if (e.getSource() == proveedor.btn_eliminar) {

            Boton_Para_Actualizar("Eliminar Proveedor");
            Desahabiliar_Solo_Botones();

        }

        if (e.getSource() == proveedor.btn_listar) {
            proveedor.setSize(1330, 620);

            proveedor.setLocationRelativeTo(null);

            Mover_Panel_Datos();
            Desahabiliar_Solo_Botones();

        }

        if (e.getSource() == proveedor.btn_bajar_tabla) {

            proveedor.setSize(950, 620);
            proveedor.setLocationRelativeTo(null);
            Bajar_Panel_Tabla();

            Habiliar_Solo_Botones();

        }

    }

    private void Estados_Enabled_Y_True(boolean estado) {

        proveedor.txt_codigo.setEditable(false);//consttante no combia   

        proveedor.txt_cedula.setEditable(estado);
        proveedor.txt_nombre_provee.setEditable(estado);
        proveedor.txt_empresa.setEditable(estado);
        proveedor.txt_celular.setEditable(estado);
        proveedor.txt_direccion.setEditable(estado);
        proveedor.txt_correo.setEditable(estado);
        proveedor.txt_telefono_fijo.setEditable(estado);
        proveedor.combo_provincia.setEnabled(estado);
        proveedor.btn_registrar_proveedor.setEnabled(estado);
        proveedor.btn_generar_codigo.setEnabled(estado);
        proveedor.btn_cancelar.setEnabled(estado);

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7
    @Override
    public void keyTyped(KeyEvent e) {
        Object objeto = e.getSource();

        if (objeto == proveedor.txt_codigo || objeto == proveedor.txt_nombre_provee || objeto == proveedor.txt_empresa) {
            char tecla = e.getKeyChar();

            if (Character.isLowerCase(tecla)) {
                String miniscula = ("" + tecla).toUpperCase();
                tecla = miniscula.charAt(0);
                e.setKeyChar(tecla);

            }
        }
        if (objeto == proveedor.txt_cedula || objeto == proveedor.txt_celular || objeto == proveedor.txt_telefono_fijo) {

            char letra = e.getKeyChar();

            if (letra < '0' || letra > '9') {
                e.consume();
            }

        }

        if (objeto == proveedor.txt_nombre_provee) {

            char letra = e.getKeyChar();
            if ((letra < 'A' || letra > 'Z') && (letra != ' ')) {
                e.consume();
            }

        }

        if (objeto == proveedor.txt_correo) {

            char letra = e.getKeyChar();
            if ((letra == ' ')) {
                e.consume();
            }

        }

        if (objeto == proveedor.txt_cedula) {
            int longitud = proveedor.txt_cedula.getText().length();

            if (longitud > 9) {
                e.consume();
            }

        }

        if (objeto == proveedor.txt_celular) {
            int longitud = proveedor.txt_celular.getText().length();

            if (longitud > 9) {
                e.consume();
            }

        }

        if (objeto == proveedor.txt_telefono_fijo) {
            int longitud = proveedor.txt_telefono_fijo.getText().length();

            if (longitud > 9) {
                e.consume();
            }

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyChar() == KeyEvent.VK_ENTER) {

            Object tomar_evento = e.getSource();

            if (tomar_evento == proveedor.txt_codigo) {

                proveedor.txt_cedula.requestFocus();

            }

            if (tomar_evento == proveedor.txt_cedula) {

                proveedor.txt_nombre_provee.requestFocus();

            }

            if (tomar_evento == proveedor.txt_nombre_provee) {

                proveedor.txt_empresa.requestFocus();

            }

            if (tomar_evento == proveedor.txt_empresa) {

                proveedor.txt_direccion.requestFocus();

            }

            if (tomar_evento == proveedor.txt_correo) {

                proveedor.txt_telefono_fijo.requestFocus();

            }
            if (tomar_evento == proveedor.txt_telefono_fijo) {

                proveedor.txt_celular.requestFocus();

            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == proveedor.tabla_proveedor) {

            int columnas = proveedor.tabla_proveedor.getColumnModel().getColumnIndexAtX(e.getX());

            if (proveedor.tabla_proveedor.getRowCount() >= 0) {
                int filas = e.getY() / proveedor.tabla_proveedor.getRowHeight();
                if (filas < proveedor.tabla_proveedor.getRowCount() && filas >= 0 && columnas < proveedor.tabla_proveedor.getColumnModel().getColumnCount() && columnas >= 0) {
                    Object value = proveedor.tabla_proveedor.getValueAt(filas, columnas);

                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        String codigo = proveedor.tabla_proveedor.getValueAt(proveedor.tabla_proveedor.getSelectedRow(), 2).toString();
                        String nombre_proveedor = proveedor.tabla_proveedor.getValueAt(proveedor.tabla_proveedor.getSelectedRow(), 4).toString();
                        String empresa = proveedor.tabla_proveedor.getValueAt(proveedor.tabla_proveedor.getSelectedRow(), 5).toString();

                        controlador_productos_proveedores.Iniciar_Componentes(codigo, nombre_proveedor, empresa);

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

    @Override
    public void focusGained(FocusEvent e) {
        Ocultar_Label();
    }

    @Override
    public void focusLost(FocusEvent e) {

        try {
            if (e.getSource() == proveedor.txt_cedula) {
                String nombre = proveedor.txt_cedula.getText();
                if (!nombre.isEmpty()) {

                    if (!validacion_txt.Validar_cedula(nombre)) {
                        proveedor.label_cedula_error.setVisible(true);

                    }

                }

            }

            if (e.getSource() == proveedor.txt_correo) {
                String correo = proveedor.txt_correo.getText();
                if (!correo.isEmpty()) {
                    if (!validacion_txt.validar_correo(correo)) {
                        proveedor.label_error_correo.setVisible(true);

                    }

                }

            }
        } catch (Exception ex) {
            System.out.println("erro el evento focus  lost");
        }

    }
    private final Color color_botones;
    private final ImageIcon icono_nuevo_cliente;
    private final ImageIcon icono_guardar;
    private final ImageIcon icono_cancelar;
    private final ImageIcon icono_pregunta;
    private final ImageIcon eliminar;
    private ImageIcon icono_bien;
    private final ImageIcon icono_admiracion;
    private final ImageIcon listar;

}
