package modelo;

import java.sql.Date;
import javax.swing.*;
import javax.swing.table.TableRowSorter;

public class Modelo_Nuevo {

    public Modelo_Nuevo() {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTlf_fijo() {
        return tlf_fijo;
    }

    public void setTlf_fijo(String tlf_fijo) {
        this.tlf_fijo = tlf_fijo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public String getEstado_cuenta() {
        return estado_cuenta;
    }

    public void setEstado_cuenta(String estado_cuenta) {
        this.estado_cuenta = estado_cuenta;
    }

    public double getSaldo_pendiente() {
        return saldo_pendiente;
    }

    public void setSaldo_pendiente(double saldo_pendiente) {
        this.saldo_pendiente = saldo_pendiente;
    }

    public TableRowSorter getRowSorter() {
        return rowSorter;
    }

    public void setRowSorter(TableRowSorter rowSorter) {
        this.rowSorter = rowSorter;
    }

    public double getTotal_cobrar() {
        return total_cobrar;
    }

    public void setTotal_cobrar(double total_cobrar) {
        this.total_cobrar = total_cobrar;
    }

    public int getCantidad_productos() {
        return cantidad_productos;
    }

    public void setCantidad_productos(int cantidad_productos) {
        this.cantidad_productos = cantidad_productos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public JPanel getJpanel() {
        return Jpanel;
    }

    public void setJpanel(JPanel Jpanel) {
        this.Jpanel = Jpanel;
    }

    public int getParametro() {
        return parametro;
    }

    public void setParametro(int parametro) {
        this.parametro = parametro;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getRojo() {
        return rojo;
    }

    public void setRojo(int rojo) {
        this.rojo = rojo;
    }

    public int getVerde() {
        return verde;
    }

    public void setVerde(int verde) {
        this.verde = verde;
    }

    public int getAzul() {
        return azul;
    }

    public void setAzul(int azul) {
        this.azul = azul;
    }

    public String getNombre_color() {
        return nombre_color;
    }

    public void setNombre_color(String nombre_color) {
        this.nombre_color = nombre_color;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public JComboBox getCombo_color_item_padre() {
        return combo_color_item_padre;
    }

    public void setCombo_color_item_padre(JComboBox combo_color_item_padre) {
        this.combo_color_item_padre = combo_color_item_padre;
    }

    public JComboBox getCombo_color_item_hijo() {
        return combo_color_item_hijo;
    }

    public void setCombo_color_item_hijo(JComboBox combo_color_item_hijo) {
        this.combo_color_item_hijo = combo_color_item_hijo;
    }

    public JComboBox getCombo_color_fondo() {
        return combo_color_fondo;
    }

    public void setCombo_color_fondo(JComboBox combo_color_fondo) {
        this.combo_color_fondo = combo_color_fondo;
    }

    public JComboBox getCombo_color_barra() {
        return combo_color_barra;
    }

    public void setCombo_color_barra(JComboBox combo_color_barra) {
        this.combo_color_barra = combo_color_barra;
    }

    public String getNombre_color_items_padre() {
        return nombre_color_items_padre;
    }

    public void setNombre_color_items_padre(String nombre_color_items_padre) {
        this.nombre_color_items_padre = nombre_color_items_padre;
    }

    public String getNombre_color_items_hijos() {
        return nombre_color_items_hijos;
    }

    public void setNombre_color_items_hijos(String nombre_color_items_hijos) {
        this.nombre_color_items_hijos = nombre_color_items_hijos;
    }

    public String getNombre_color_fondo() {
        return nombre_color_fondo;
    }

    public void setNombre_color_fondo(String nombre_color_fondo) {
        this.nombre_color_fondo = nombre_color_fondo;
    }

    public String getNombre_color_barra_menul() {
        return nombre_color_barra_menul;
    }

    public void setNombre_color_barra_menul(String nombre_color_barra_menul) {
        this.nombre_color_barra_menul = nombre_color_barra_menul;
    }

    public int getId_funciones() {
        return id_funciones;
    }

    public void setId_funciones(int id_funciones) {
        this.id_funciones = id_funciones;
    }
    
    

    private String codigo;
    private String cedula;
    private String nombre_proveedor;
    private String empresa;
    private String direccion;
    private String provincia;
    private String correo;
    private String tlf_fijo;
    private String celular;
    private String tipo_cuenta;
    private String fecha;
    private String fecha_final;

    private double saldo_pendiente;
    private double total_cobrar;
    private JPanel Jpanel;
    private int cantidad_productos;

    private JComboBox combo_color_item_padre;
    private JComboBox combo_color_item_hijo;
    private JComboBox combo_color_fondo;
    private JComboBox combo_color_barra;

    private String estado_cuenta;

    private Date fecha_registro;

    private int parametro;
    private int tipo;
    private int modelo;
    private int rojo;
    private int verde;
    private int azul;
    private String nombre_color;

    private String nombre_color_items_padre;
    private String nombre_color_items_hijos;
    private String nombre_color_fondo;
    private String nombre_color_barra_menul;
    private int id_funciones;

    private JTable tabla;
    private TableRowSorter rowSorter;

}
