package controlador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import vistas.Menu_Principal;

public class Controlador_Menu_Principal implements ActionListener, MouseListener, MenuListener {

    private Menu_Principal menu;

    private Controlador_sesion controlador_sesion;
    private Controlador_Registrar registrar_controlador;

    private Controlador_Productos_Vendidos controlador_ventas;
    private Controlador_Compras controlador_compras;
    private Controlador_Vender_Producto controlador_Vender_Producto;
    private Controlador_Proveedor controlador_proveedor;
    private Controlador_Cuentas controlador_cuentas;
    private Controlador_Configura_Cuenta controlador_Configura_cuenta;

    private Controlador_Clientes controlador_clientes;
    private Controlador_Estadisticas controlador_estadisticas;
    private Controlador_Colores controlador_colores;

    public Controlador_Menu_Principal(Menu_Principal menu, Controlador_sesion controlador_sesion,
            Controlador_Registrar registrar_controlador, Controlador_Productos_Vendidos controlador_ventas,
            Controlador_Compras controlador_compras, Controlador_Vender_Producto controlador_Vender_Producto,
            Controlador_Proveedor controlador_proveedor, Controlador_Cuentas controlador_cuentas, Controlador_Configura_Cuenta controlador_Configura_cuenta,
            Controlador_Clientes controlador_clientes, Controlador_Estadisticas controlador_estadisticas, Controlador_Colores controlador_colores) {
        this.menu = menu;
        this.controlador_sesion = controlador_sesion;
        this.registrar_controlador = registrar_controlador;

        this.controlador_ventas = controlador_ventas;
        this.controlador_compras = controlador_compras;
        this.controlador_proveedor = controlador_proveedor;
        this.controlador_Vender_Producto = controlador_Vender_Producto;
        this.controlador_cuentas = controlador_cuentas;
        this.controlador_Configura_cuenta = controlador_Configura_cuenta;

        this.controlador_clientes = controlador_clientes;
        this.controlador_estadisticas = controlador_estadisticas;
        this.controlador_colores = controlador_colores;

        ///////////////////////////////////////////////////////////////////////////////////
        curso_mano = new Cursor(Cursor.HAND_CURSOR);

        ///////////////////////////////////////////////////////////////////////////////////////
        this.menu.item_sesion.addActionListener(this);
        this.menu.item_registrar.addActionListener(this);

        this.menu.item_registro_de_ventas.addActionListener(this);
        this.menu.item_compras.addActionListener(this);
        this.menu.item_cuentas_usuarios.addActionListener(this);
        this.menu.item_vender.addActionListener(this);
        this.menu.item_cerrar_sesion.addActionListener(this);
        this.menu.item_conf_proveedores.addActionListener(this);
        this.menu.item_configu_cuenta.addActionListener(this);

        this.menu.item_Inicio.addMouseListener(this);

        this.menu.item_clientes.addActionListener(this);
        this.menu.item_estadisticas.addActionListener(this);
        this.menu.item_sistema.addActionListener(this);
        ////////////////////////////////////////////////////////////////////////////
        opciones = new String[2];
        opciones[0] = "Salir";
        opciones[1] = "Cancelar";
        icono_pregunta = new ImageIcon("src/Image_Sms/icono_pregunta_nuevo.png");
        icono_prod_vacio = new ImageIcon("src/Image_Sms/admiracion_nueva.png");

        /////////////////////////////////////////////////////////////////////////////////////////////////
        this.menu.item_Inicio.addMenuListener(this);
        ////////////////////////////////////////////////////////////////////

        this.menu.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Image_2/logo.png"));
        /// this.menu.setResizable(false);

        /////////////////////////////////////////////////////////////////////////////// 
        Asignar_Cursor();
        bloquearItems();
        Asignar_Imagenes_Items();
        Ocultar_Panel_y_Labels();
        Editar_letra_Colores();
        Atajos();
        Evento_Closing();
        Timer tiempo = new Timer(100, new horas());
        tiempo.start();

    }

    public void EstadosIniciales() {
        menu.setExtendedState(6);

    }

    private void Asignar_Imagenes_Items() {

        /*
        Boton Inicio
         */
        menu.item_Inicio.setIcon(new ImageIcon("src/Image_2/linea_22.png"));
        menu.item_sesion.setIcon(new ImageIcon("src/Image_2/icono-iniciar-sesion_2.png"));
        menu.item_registrar.setIcon(new ImageIcon("src/Imagenes/regi_usua.png"));
        menu.item_cerrar_sesion.setIcon(new ImageIcon("src/Image_2/salir _left.png"));

        /*
        Boton tienda
         */
        menu.item_tienda.setIcon(new ImageIcon("src/Image_2/tienda_1_nuev.png"));
        menu.item_vender.setIcon(new ImageIcon("src/Image_2/ventas.png"));
        menu.item_registro_de_ventas.setIcon(new ImageIcon("src/Image_2/listar_ingresos.png"));
        menu.item_compras.setIcon(new ImageIcon("src/Image_2/inventario_poner.png"));
        menu.item_conf_proveedores.setIcon(new ImageIcon("src/Image_2/icono_prover.png"));

        /*
        configuraciones
         */
        menu.item_configuracion.setIcon(new ImageIcon("src/Image_2/configura.png"));
        menu.item_cuentas_usuarios.setIcon(new ImageIcon("src/Image_2/admin_usuarios.png"));
        menu.item_configu_cuenta.setIcon(new ImageIcon("src/Image_2/configura_cuenta.png"));
        menu.item_clientes.setIcon(new ImageIcon("src/Image_2/cliente_nuevoo.png"));
        menu.item_sistema.setIcon(new ImageIcon("src/Image_2/congi_sinfondo.png"));

        /*
         estadisticas
         */
        menu.item_menu_estadisticas.setIcon(new ImageIcon("src/Image_2/estadisticas.png"));
        menu.item_estadisticas.setIcon(new ImageIcon("src/Image_2/estadisticass.png"));

    }

    private void Editar_letra_Colores() {

        Font letras_Item_principal = new Font("Dialog", Font.BOLD, 20);
        Font letras_Item_hijos = new Font("Dialog", Font.BOLD, 14);
        Color color_item_principal = new Color(0, 255, 0);
        Color color_item_hijos = new Color(226, 137, 48);

        menu.label_fecha.setFont(letras_Item_hijos);
        /*
        items principales
         */
        menu.item_Inicio.setFont(letras_Item_principal);
        menu.item_tienda.setFont(letras_Item_principal);

        menu.item_configuracion.setFont(letras_Item_principal);
        menu.item_menu_estadisticas.setFont(letras_Item_principal);
        menu.label_usu_activado.setFont(letras_Item_principal);

        /*
         items hijos Inicio
         */
        menu.item_sesion.setFont(letras_Item_hijos);
        menu.item_registrar.setFont(letras_Item_hijos);
        menu.item_cerrar_sesion.setFont(letras_Item_hijos);


        /*
        items hijos tienda
         */
        menu.item_compras.setFont(letras_Item_hijos);
        menu.item_registro_de_ventas.setFont(letras_Item_hijos);
        menu.item_vender.setFont(letras_Item_hijos);
        menu.item_conf_proveedores.setFont(letras_Item_hijos);

        menu.item_cuentas_usuarios.setFont(letras_Item_hijos);
        menu.item_configu_cuenta.setFont(letras_Item_hijos);
        menu.item_clientes.setFont(letras_Item_hijos);
        menu.item_sistema.setFont(letras_Item_hijos);

        /*
        items hijos de estadisticas
        
         */
        menu.item_estadisticas.setFont(letras_Item_hijos);
        //////////////////////////////////////////////////////////////////////////////////////////

    }

    private void Atajos() {
        /*
        CREAR ATAJOS PARA LOS JMENU , metodo  setMnemonic('parametro char o int')
          CREA O ASOCIA PARA ACCEDER( UN ATAJO) unicamente a los  JMENU ,
        crea el atajo ALT+ 'objeto character'  :  (siempre asociara la tecla alt)
         */

        menu.item_Inicio.setMnemonic('I'); //quedario ALT +A
        menu.item_tienda.setMnemonic('T');//QUEDARIA ALT + W 
        menu.item_configuracion.setMnemonic('C');//
        menu.item_menu_estadisticas.setMnemonic('E');

        /*
        Atajos para acceder a los JMenuItem
        utiliza metodo setAccelerator( KeyStroke.getKeyStroke ( letra de atajo , la letra especial , x ejemplo ctrl , alt , ect));
         
        los parametros que van dentro , son constante,  yo estoy utilizando los campos de clase de esas constantes xq no me se bien
        
        InputEvent.CTRL_MASK , la constante es : 2 y asi 
         */
        menu.item_sesion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK)); //CREA UN ATAJO
        menu.item_registrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
        menu.item_cerrar_sesion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK)); //

        menu.item_vender.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        menu.item_compras.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
        menu.item_conf_proveedores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
        menu.item_registro_de_ventas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));

        menu.item_cuentas_usuarios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK));
        menu.item_configu_cuenta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
        menu.item_clientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        menu.item_sistema.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

        menu.item_estadisticas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));

    }

    private void Asignar_Cursor() {

        menu.item_Inicio.setCursor(curso_mano);
        menu.item_tienda.setCursor(curso_mano);

        //////////////////////////////////////////////////////////////////
        menu.item_sesion.setCursor(curso_mano);
        menu.item_registrar.setCursor(curso_mano);
        menu.item_cerrar_sesion.setCursor(curso_mano);

        menu.item_compras.setCursor(curso_mano);
        menu.item_registro_de_ventas.setCursor(curso_mano);
        menu.item_vender.setCursor(curso_mano);
        menu.item_conf_proveedores.setCursor(curso_mano);

        menu.item_configuracion.setCursor(curso_mano);
        menu.item_configu_cuenta.setCursor(curso_mano);
        menu.item_cuentas_usuarios.setCursor(curso_mano);
        menu.item_clientes.setCursor(curso_mano);
        menu.item_sistema.setCursor(curso_mano);

        menu.item_menu_estadisticas.setCursor(curso_mano);
        menu.item_estadisticas.setCursor(curso_mano);

    }

    private void Ocultar_Panel_y_Labels() {

        menu.panel_principal.setVisible(false); //dentro de este panel estan lo label , a excepcion de uno 
        menu.label_usu_activado.setVisible(false); // este label esta fuera dek panel , es donde se muestra el nombre y apellido del usuario 
        //cuando inice sesion correctamente

    }

    private void bloquearItems() {

        menu.label_cuenta.setText("h");
        menu.label_apellido.setText("h");
        menu.label_nombre.setText("h");
        menu.label_poner_cedula.setText("h");
        menu.label_correo.setText("h");
        menu.label_contrasena.setText("h");

        menu.item_tienda.setEnabled(false);
        menu.item_registrar.setEnabled(false);
        menu.item_cerrar_sesion.setEnabled(false);
        menu.item_configuracion.setEnabled(false);
        menu.item_menu_estadisticas.setEnabled(false);
        menu.label_usu_activado.setVisible(false);

    }

    private void Evento_Closing() {

        WindowListener ventana = new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                if (menu.item_cerrar_sesion.isEnabled()) {

                    JOptionPane.showMessageDialog(menu, "¡Finaliza sesión antes de salir!", "Sistema de Ventas", 0, icono_prod_vacio);
                } else {

                    int respuesta = JOptionPane.showOptionDialog(menu, "¿Seguro desea salir?", "Sistema de Ventas", 0, 0, icono_pregunta, opciones, opciones[0]);

                    if (respuesta == 0) {
                        System.exit(0);
                    }
                }

            }

        };
        menu.addWindowListener(ventana);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == menu.item_sesion) {
            controlador_sesion.Iniciar_Componentes();

        }
        if (e.getSource() == menu.item_registrar) {

            registrar_controlador.Estados_Iniciales();

        }

        if (e.getSource() == menu.item_registro_de_ventas) {
            controlador_ventas.Iniciar_Componentes();

        }
        if (e.getSource() == menu.item_compras) {

            controlador_compras.Iniciar_Componentes();
        }
        if (e.getSource() == menu.item_vender) {
            controlador_Vender_Producto.Estados_Iniciales();

        }
        if (e.getSource() == menu.item_cerrar_sesion) {
            bloquearItems();
            menu.item_sesion.setEnabled(true);

        }
        if (e.getSource() == menu.item_conf_proveedores) {

            controlador_proveedor.Iniciar_Componentes();
        }
        if (e.getSource() == menu.item_cuentas_usuarios) {
            controlador_cuentas.Iniciar_Componentes();

        }

        if (e.getSource() == menu.item_configu_cuenta) {
            controlador_Configura_cuenta.Iniciar_Componentes(menu.label_poner_cedula.getText(), menu.label_nombre.getText(), menu.label_apellido.getText(), menu.label_cuenta.getText(),
                    menu.label_contrasena.getText(), menu.label_correo.getText());
            //le envio  todos los datos de la cuenta que esta logeada

        }

        if (e.getSource() == menu.item_clientes) {
            controlador_clientes.Iniciar_Componentes(2);

        }
        if (e.getSource() == menu.item_estadisticas) {
            controlador_estadisticas.Iniciar_Componentes();

        }
        if (e.getSource() == menu.item_sistema) {
            controlador_colores.Iniciar_Componentes();

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
    public void menuSelected(MenuEvent e) {

    }

    @Override
    public void menuDeselected(MenuEvent e) {
    }

    @Override
    public void menuCanceled(MenuEvent e) {
    }

    private class horas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            java.util.Date sistHora = new java.util.Date();
            String pmAm = "yyyy/MM/dd   hh:mm:ss a";
            SimpleDateFormat format = new SimpleDateFormat(pmAm);
            Calendar hoy = Calendar.getInstance();
            menu.label_fecha.setText((String.format(format.format(sistHora), hoy)));

        }
    }
    private final Cursor curso_mano;
    private final String opciones[];
    private final ImageIcon icono_pregunta;
    private final ImageIcon icono_prod_vacio;

}
