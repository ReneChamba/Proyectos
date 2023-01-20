package controlador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import modelo.*;
import vistas.Productos_Vendidos;
import static javax.swing.JOptionPane.*;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Controlador_Productos_Vendidos implements ActionListener, KeyListener {

    private Modelo_Nuevo modelo_nuevo;
    private Productos_Vendidos ventas;
    private Crud_Nuevo crud_nuevo;

    public Controlador_Productos_Vendidos(Modelo_Nuevo modelo_nuevo, Productos_Vendidos ventas, Crud_Nuevo crud_nuevo) {
        this.modelo_nuevo = modelo_nuevo;
        this.ventas = ventas;
        this.crud_nuevo = crud_nuevo;
        ////////////////////////////////////////////////////////////////////////////////////
        this.ventas.txt_buscar_productos_vendidos.addKeyListener(this);
        this.ventas.btn_filtrar_fecha.addActionListener(this);
        this.ventas.btn_restablecer.addActionListener(this);
        this.ventas.btn_saldo_cliente.addActionListener(this);

        ////////////////////////////////////////////////////////////////////////////////////
        Trasparente txt_buscar = new Trasparente("Buscar Producto Vendido", this.ventas.txt_buscar_productos_vendidos, Trasparente.Show.ALWAYS);

        Asignar_Letra();
         Evento_Ventana();

        this.ventas.setTitle("Ventas");
        this.ventas.setResizable(false);

    }

    public void Iniciar_Componentes() {
        ventas.setLocationRelativeTo(null);
        Cargar_Modelo_Tabla(true);

        Actualizar_Fecha();
     
        ventas.setVisible(true);
    }

    private void Asignar_Letra() {
        ventas.label_titulo.setFont(letra_titulo_label);

        ventas.label_total.setFont(letra_botones);
        ventas.label_nombre_total.setFont(letra_botones);

        ventas.label_numero_productos.setFont(letra_label);
        ventas.label_cantidad_productos.setFont(letra_label);
        ventas.label_inicio.setFont(letra_label);
        ventas.label_final.setFont(letra_label);
        ventas.txt_buscar_productos_vendidos.setFont(letra_label);

        ventas.calendario.setFont(letra_label);
        ventas.fecha_final.setFont(letra_label);

        ventas.btn_filtrar_fecha.setFont(letra_botones);

        ventas.label_titulo.setHorizontalAlignment(0);
        ventas.label_nombre_total.setHorizontalAlignment(SwingConstants.CENTER);
        ventas.txt_buscar_productos_vendidos.setHorizontalAlignment(0);

        //////////////////////////////////////////////////////////////////
        ventas.label_titulo.setForeground(titulo_Dos_labeles);

        ventas.label_nombre_total.setForeground(new Color(0, 153, 102));
        /////////////////////////////////////////////////////////////////////////////////
        LineBorder linea = new LineBorder(titulo_Dos_labeles, 2, true);
        ventas.txt_buscar_productos_vendidos.setBorder(linea);
        /////////CURSOR
        ventas.btn_filtrar_fecha.setCursor(cursor_mano);

        ventas.calendario.setCursor(cursor_mano);
        ventas.btn_saldo_cliente.setCursor(cursor_mano);

    }

    private void Actualizar_Fecha() {

        ////////restablece la fecha actual al calendario/////////////////////
        Calendar fecha = Calendar.getInstance();
        ventas.calendario.setDate(fecha.getTime());
        ventas.fecha_final.setDate(fecha.getTime());

    }

    private void Filtrar_Por_Fecha() {

        long fecha_inicio = ventas.calendario.getDate().getTime();
        long fecha_final = ventas.fecha_final.getDate().getTime();
        ///////////////////////////////////////////////////////////////////////
        java.sql.Date fecha_sql_enviar = new java.sql.Date(fecha_inicio);
        java.sql.Date fecha_sql_final = new java.sql.Date(fecha_final);
        ////////////////////////////////////////////////
        String format_hora = "yyyy/MM/dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format_hora);
        String fecha_formato_inicio = dateFormat.format(fecha_sql_enviar);

        String fecha_formato_final = dateFormat.format(fecha_sql_final);

        modelo_nuevo.setFecha(fecha_formato_inicio);
        modelo_nuevo.setFecha_final(fecha_formato_final);

        Cargar_Modelo_Tabla(false);

    }

    private void Cargar_Modelo_Tabla(boolean elegir) {

        modelo_nuevo.setTabla(ventas.tabla);

        if (crud_nuevo.Modelo_Tabla_Ventas(modelo_nuevo, elegir)) {

            ventas.label_numero_productos.setText("" + modelo_nuevo.getCantidad_productos());
            ventas.label_total.setText("" + modelo_nuevo.getTotal_cobrar());
        }

    }

    private void Evento_Ventana() {

        WindowAdapter evento = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                Enabled(true);
                ventas.btn_saldo_cliente.setText("Ver Saldos Pendientes");
                ventas.txt_buscar_productos_vendidos.setText("");
                 ventas.jScrollPane1.setVisible(true);
                ventas.jScrollPane2.setVisible(false);
                
             
                
            }

        };
        ventas.addWindowListener(evento);

    }

    private void Enabled(boolean bloquear) {

        ventas.btn_filtrar_fecha.setEnabled(bloquear);
        ventas.btn_restablecer.setEnabled(bloquear);

    }

    private void Cargar_Modelo_Saldo_Pendientes() {
        modelo_nuevo.setTabla(ventas.tabla_nueva);

        if (crud_nuevo.tabla_Saldo_Cliente(modelo_nuevo)) {
            ventas.label_numero_productos.setText("NA");
            ventas.label_total.setText("" + modelo_nuevo.getTotal_cobrar());
            ventas.label_nombre_total.setText("Saldos Pendientes:");
            ventas.btn_saldo_cliente.setText("Volver");
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventas.btn_filtrar_fecha) {

            Filtrar_Por_Fecha();
        }
        if (e.getSource() == ventas.btn_restablecer) {

            Cargar_Modelo_Tabla(true);
            Actualizar_Fecha();
        }
        if (e.getSource() == ventas.btn_saldo_cliente) {

            String nombre = ventas.btn_saldo_cliente.getText().trim();

            if (nombre.equalsIgnoreCase("Volver")) {
                ventas.jScrollPane1.setVisible(true);
                ventas.jScrollPane2.setVisible(false);
                Enabled(true);

                Cargar_Modelo_Tabla(true);
                ventas.label_nombre_total.setText("Ingresos:");
                ventas.btn_saldo_cliente.setText("Ver Saldos Pendientes");

            } else if (nombre.equalsIgnoreCase("Ver Saldos Pendientes")) {
                ventas.jScrollPane2.setVisible(true);
                ventas.jScrollPane1.setVisible(false);
                Enabled(false);

                Cargar_Modelo_Saldo_Pendientes();
            }

        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////777
    @Override
    public void keyTyped(KeyEvent e) {

        if (e.getSource() == ventas.txt_buscar_productos_vendidos) {

            char tecla = e.getKeyChar();
            if (Character.isLowerCase(tecla)) {
                String miniscula = ("" + tecla).toUpperCase();
                tecla = miniscula.charAt(0);
                e.setKeyChar(tecla);

            }
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == ventas.txt_buscar_productos_vendidos) {

            modelo_nuevo.getRowSorter().setRowFilter(RowFilter.regexFilter(ventas.txt_buscar_productos_vendidos.getText(), 2));
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private final Font letra_titulo_label = new Font("Dialog", Font.BOLD, 20);
    private final Font letra_label = new Font("Dialog", Font.BOLD, 14);
    private final Cursor cursor_mano = new Cursor(12);
    private final Font letra_botones = new Font("Dialog", Font.BOLD, 16);
    private final Color titulo_Dos_labeles = new Color(30, 138, 137);

}
