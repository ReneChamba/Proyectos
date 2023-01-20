package modelo;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.table.TableRowSorter;

public class Modelo {

    public Modelo() {

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public String getContasena() {
        return contasena;
    }

    public void setContasena(String contasena) {
        this.contasena = contasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getFecha_vendida() {
        return fecha_vendida;
    }

    public void setFecha_vendida(String fecha_vendida) {
        this.fecha_vendida = fecha_vendida;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal_cobrar() {
        return total_cobrar;
    }

    public void setTotal_cobrar(double total_cobrar) {
        this.total_cobrar = total_cobrar;
    }

    public double getTotal_cada_producto() {
        return total_cada_producto;
    }

    public void setTotal_cada_producto(double total_cada_producto) {
        this.total_cada_producto = total_cada_producto;
    }

    public JComboBox getCombo_cliente() {
        return combo_cliente;
    }

    public void setCombo_cliente(JComboBox combo_cliente) {
        this.combo_cliente = combo_cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad_productos() {
        return cantidad_productos;
    }

    public void setCantidad_productos(int cantidad_productos) {
        this.cantidad_productos = cantidad_productos;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JComboBox getCombo_productos() {
        return combo_productos;
    }

    public void setCombo_productos(JComboBox combo_productos) {
        this.combo_productos = combo_productos;
    }

    public int getCantidad_produ_cliente() {
        return cantidad_produ_cliente;
    }

    public void setCantidad_produ_cliente(int cantidad_produ_cliente) {
        this.cantidad_produ_cliente = cantidad_produ_cliente;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFecha_tipo_date() {
        return fecha_tipo_date;
    }

    public void setFecha_tipo_date(Date fecha_tipo_date) {
        this.fecha_tipo_date = fecha_tipo_date;
    }

    public JComboBox getCombo_filtar_por_categoria() {
        return combo_filtar_por_categoria;
    }

    public void setCombo_filtar_por_categoria(JComboBox combo_filtar_por_categoria) {
        this.combo_filtar_por_categoria = combo_filtar_por_categoria;
    }

    public String getCodigo_registro() {
        return codigo_registro;
    }

    public void setCodigo_registro(String codigo_registro) {
        this.codigo_registro = codigo_registro;
    }

    public int getNumero_codigo() {
        return numero_codigo;
    }

    public void setNumero_codigo(int numero_codigo) {
        this.numero_codigo = numero_codigo;
    }

    public int getNumero_auxiliar_codigo() {
        return numero_auxiliar_codigo;
    }

    public void setNumero_auxiliar_codigo(int numero_auxiliar_codigo) {
        this.numero_auxiliar_codigo = numero_auxiliar_codigo;
    }

    public TableRowSorter getRowSorter() {
        return rowSorter;
    }

    public void setRowSorter(TableRowSorter rowSorter) {
        this.rowSorter = rowSorter;
    }

    public JComboBox getCombo_vender_rapido() {
        return combo_vender_rapido;
    }

    public void setCombo_vender_rapido(JComboBox combo_vender_rapido) {
        this.combo_vender_rapido = combo_vender_rapido;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getRetornar_fecha_actual(boolean formato_fecha) {

        ///////Obtener la fecha////////////////////////////
        Calendar calendario = Calendar.getInstance();
        java.util.Date fecha = calendario.getTime();
        //String format_hora = "dd/MM/yyyy   hh:mm:ss";
        String format_hora = "yyyy/MM/dd";

        if (!formato_fecha) {
            format_hora += "  hh:mm:ss ";
        }
        //String format_hora = "yyyy/MM/dd  hh:mm:ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format_hora);
//        String fecha_registro = dateFormat.format(fecha);

        return dateFormat.format(fecha);
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public ArrayList getLista_productos() {
        return lista_productos;
    }

    public void setLista_productos(ArrayList lista_productos) {
        this.lista_productos = lista_productos;
    }

    public TableRowSorter getRowSorter_2() {
        return rowSorter_2;
    }

    public void setRowSorter_2(TableRowSorter rowSorter_2) {
        this.rowSorter_2 = rowSorter_2;
    }

    public String getCodigo_proveedor() {
        return codigo_proveedor;
    }

    public void setCodigo_proveedor(String codigo_proveedor) {
        this.codigo_proveedor = codigo_proveedor;
    }

    public double getGanancias() {
        return ganancias;
    }

    public void setGanancias(double ganancias) {
        this.ganancias = ganancias;
    }

    public int getCantidad_productos_proveedor_vendido() {
        return cantidad_productos_proveedor_vendido;
    }

    public void setCantidad_productos_proveedor_vendido(int cantidad_productos_proveedor_vendido) {
        this.cantidad_productos_proveedor_vendido = cantidad_productos_proveedor_vendido;
    }

    public double getIngresos_por_productos_vendidos() {
        return ingresos_por_productos_vendidos;
    }

    public void setIngresos_por_productos_vendidos(double ingresos_por_productos_vendidos) {
        this.ingresos_por_productos_vendidos = ingresos_por_productos_vendidos;
    }

    public double getEgresos() {
        return egresos;
    }

    public void setEgresos(double egresos) {
        this.egresos = egresos;
    }

    public double getEgresos_por_compras() {
        return egresos_por_compras;
    }

    public void setEgresos_por_compras(double egresos_por_comoras) {
        this.egresos_por_compras = egresos_por_comoras;
    }

    public int getCantidad_disponibles() {
        return cantidad_disponibles;
    }

    public void setCantidad_disponibles(int cantidad_disponibles) {
        this.cantidad_disponibles = cantidad_disponibles;
    }

    public double getGanancias_tabla_compras() {
        return ganancias_tabla_compras;
    }

    public void setGanancias_tabla_compras(double ganancias_tabla_compras) {
        this.ganancias_tabla_compras = ganancias_tabla_compras;
    }

    public String getEstado_Cuenta() {
        return estado_Cuenta;
    }

    public void setEstado_Cuenta(String estado_Cuenta) {
        this.estado_Cuenta = estado_Cuenta;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }

    public JTable getTabla_nueva() {
        return tabla_nueva;
    }

    public void setTabla_nueva(JTable tabla_nueva) {
        this.tabla_nueva = tabla_nueva;
    }

  
    
    

    private String usuario;
    private String contasena;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String tipo_cuenta;

    private String cliente;
    private String fecha;
    private String fecha_vendida;
    private String codigo_registro;

    private JComboBox combo_productos;
    private JComboBox combo_cliente;
    private JComboBox combo_filtar_por_categoria;
    private JTable tabla;
    private JTable tabla_nueva;
    private String producto;
    private String codigo_proveedor;

    private double precio;
    private double abono;
    private int cantidad_productos;
    private String categoria;
    private String proveedor;
    private String Descripcion;
    private String estado_Cuenta;
    private Date fecha_tipo_date;
    private Date fecha_final;

    private int cantidad_produ_cliente;
    private int numero_codigo;
    private int cantidad_disponibles;
    private int numero_auxiliar_codigo;
    private double total_cada_producto;
    private double egresos;
    private double egresos_por_compras;

    private int hora;
    private int minutos;
    private int segundos;



    /*
    tabla tabla_productos_proveedores, estas 3 varibles son para este procesp
    esta es para cuadno registre un  nuevo producto le paso a la tabla produtos de proveedor 
    le paso 0  en la columna PRODUCTOS_VENDIDOS =0, INGRESOS_POR_PROD_VENDIDOS  =0 ,GANANCIAS =0

     */
    private int cantidad_productos_proveedor_vendido;
    private double ingresos_por_productos_vendidos;
    private double ganancias;
    private double ganancias_tabla_compras;

    ///////////////////////////////////
    private double total_cobrar;
    private JComboBox combo_vender_rapido;

    private ArrayList lista_productos;

    private TableRowSorter rowSorter;
    private TableRowSorter rowSorter_2;

}
