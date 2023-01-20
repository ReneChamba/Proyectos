package modelo;

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JComboBox;

public class Modelo_Colores {

    public Modelo_Colores() {

    }

    public void Valor_Colores(int rojo, int verde, int azul) {

        this.rojo = rojo;
        this.verde = verde;
        this.azul = azul;

    }

    public String getNombre_Color() {
        return Nombre_Color;
    }

    public void setNombre_Color(String Nombre_Color) {
        this.Nombre_Color = Nombre_Color;
    }
    
    

    public Color getColor() {

        Color color = new Color(rojo, verde, azul);
        return color;
    }
    
    //================================

    public JComboBox getCombo_fondo_pantalla() {
        return combo_fondo_pantalla;
    }

    public void setCombo_fondo_pantalla(JComboBox combo_fondo_pantalla) {
        this.combo_fondo_pantalla = combo_fondo_pantalla;
    }

    public JComboBox getCombo_fondo_menu() {
        return combo_fondo_menu;
    }

    public void setCombo_fondo_menu(JComboBox combo_fondo_menu) {
        this.combo_fondo_menu = combo_fondo_menu;
    }

    public JComboBox getCombo_fondo_herramientas() {
        return combo_fondo_herramientas;
    }

    public void setCombo_fondo_herramientas(JComboBox combo_fondo_herramientas) {
        this.combo_fondo_herramientas = combo_fondo_herramientas;
    }

    public JComboBox getCombo_fondo_estado() {
        return combo_fondo_estado;
    }

    public void setCombo_fondo_estado(JComboBox combo_fondo_estado) {
        this.combo_fondo_estado = combo_fondo_estado;
    }

    public JComboBox getCombo_fondo_func_herramientas() {
        return combo_fondo_func_herramientas;
    }

    public void setCombo_fondo_func_herramientas(JComboBox combo_fondo_func_herramientas) {
        this.combo_fondo_func_herramientas = combo_fondo_func_herramientas;
    }

    public JComboBox getCombo_fondo_func_estado() {
        return combo_fondo_func_estado;
    }

    public void setCombo_fondo_func_estado(JComboBox combo_fondo_func_estado) {
        this.combo_fondo_func_estado = combo_fondo_func_estado;
    }

    public JComboBox getCombo_borde_herramientas() {
        return combo_borde_herramientas;
    }

    public void setCombo_borde_herramientas(JComboBox combo_borde_herramientas) {
        this.combo_borde_herramientas = combo_borde_herramientas;
    }

    public JComboBox getCombo_borde_estado() {
        return combo_borde_estado;
    }

    public void setCombo_borde_estado(JComboBox combo_borde_estado) {
        this.combo_borde_estado = combo_borde_estado;
    }

    public JComboBox getCombo_text_menu() {
        return combo_text_menu;
    }

    public void setCombo_text_menu(JComboBox combo_text_menu) {
        this.combo_text_menu = combo_text_menu;
    }

    public JComboBox getCombo_text_subMenu() {
        return combo_text_subMenu;
    }

    public void setCombo_text_subMenu(JComboBox combo_text_subMenu) {
        this.combo_text_subMenu = combo_text_subMenu;
    }

    public JComboBox getCombo_text_Empresa() {
        return combo_text_Empresa;
    }

    public void setCombo_text_Empresa(JComboBox combo_text_Empresa) {
        this.combo_text_Empresa = combo_text_Empresa;
    }

    public void setResultado_Colores(ResultSet resultado, int elegir) {

        this.resultado = resultado;
        if (elegir == 1) {
            Llenar_Combos();
        }
        if (elegir == 2) {
            Inicializar_Variables_Colores();

        }

    }

    public void Llenar_Combos() {

        try {

            while (resultado.next()) {

                combo_text_menu.addItem(resultado.getString("Nombre_Color"));
                combo_text_subMenu.addItem(resultado.getString("Nombre_Color"));
                combo_text_Empresa.addItem(resultado.getString("Nombre_Color"));

                combo_fondo_pantalla.addItem(resultado.getString("Nombre_Color"));
                combo_fondo_menu.addItem(resultado.getString("Nombre_Color"));
                combo_fondo_herramientas.addItem(resultado.getString("Nombre_Color"));
                combo_fondo_estado.addItem(resultado.getString("Nombre_Color"));
                combo_fondo_func_herramientas.addItem(resultado.getString("Nombre_Color"));
                combo_fondo_func_estado.addItem(resultado.getString("Nombre_Color"));

                combo_borde_herramientas.addItem(resultado.getString("Nombre_Color"));
                combo_borde_estado.addItem(resultado.getString("Nombre_Color"));

            }

        } catch (Exception e) {
            System.out.println("error la agregar los items al los combos colores , modelo colores ");
        }

    }

    public void Inicializar_Variables_Colores() {

        try {

            if (resultado.next()) {

                color_txt_menu = resultado.getString("TEXTO_MENU");
                color_text_submenu = resultado.getString("TEXTO_SUBMENU");
                color_text_empresa = resultado.getString("TEXTO_EMPRESA");

                color_fondo_pantalla = resultado.getString("FONDO_PANTALLA");
                color_fondo_barra_menu = resultado.getString("FONDO_BARRA_MENU");
                color_fondo_barra_herramientas = resultado.getString("FONDO_BARRA_HERRAMIENTAS");
                color_fondo_barra_estado = resultado.getString("FONDO_BARRA_ESTADO");
                color_fun_barra_herramientas = resultado.getString("FONDO_FUN_BTN_HERRAMIENTAS");
                color_fun_barra_estado = resultado.getString("FONDO_FUN_BTN_ESTADO");

                color_borde_barra_herramientas = resultado.getString("BORDE_HERRAMIENTAS");
                color_borde_barra_estado = resultado.getString("BORDE_ESTADO");

            }

        } catch (Exception e) {
            System.out.println("error modelo colores , inicializar nombre funciones");
        }

    }

    //=======METODOS PARA LOS NOMBRES DE LAS FUNCIONES COLORES===========0
    public String getColor_txt_menu() {
        return color_txt_menu;
    }

    public String getColor_text_submenu() {
        return color_text_submenu;
    }

    public String getColor_text_empresa() {
        return color_text_empresa;
    }

    public String getColor_fondo_pantalla() {
        return color_fondo_pantalla;
    }

    public String getColor_fondo_barra_menu() {
        return color_fondo_barra_menu;
    }

    public String getColor_fondo_barra_herramientas() {
        return color_fondo_barra_herramientas;
    }

    public String getColor_fondo_barra_estado() {
        return color_fondo_barra_estado;
    }

    public String getColor_fun_barra_herramientas() {
        return color_fun_barra_herramientas;
    }

    public String getColor_fun_barra_estado() {
        return color_fun_barra_estado;
    }

    public String getColor_borde_barra_herramientas() {
        return color_borde_barra_herramientas;
    }

    public String getColor_borde_barra_estado() {
        return color_borde_barra_estado;
    }
    //===================SET MOMBRES FUNCIONES====================

    public void setColor_txt_menu(String color_txt_menu) {
        this.color_txt_menu = color_txt_menu;
    }

    public void setColor_text_submenu(String color_text_submenu) {
        this.color_text_submenu = color_text_submenu;
    }

    public void setColor_text_empresa(String color_text_empresa) {
        this.color_text_empresa = color_text_empresa;
    }

    public void setColor_fondo_pantalla(String color_fondo_pantalla) {
        this.color_fondo_pantalla = color_fondo_pantalla;
    }

    public void setColor_fondo_barra_menu(String color_fondo_barra_menu) {
        this.color_fondo_barra_menu = color_fondo_barra_menu;
    }

    public void setColor_fondo_barra_herramientas(String color_fondo_barra_herramientas) {
        this.color_fondo_barra_herramientas = color_fondo_barra_herramientas;
    }

    public void setColor_fondo_barra_estado(String color_fondo_barra_estado) {
        this.color_fondo_barra_estado = color_fondo_barra_estado;
    }

    public void setColor_fun_barra_herramientas(String color_fun_barra_herramientas) {
        this.color_fun_barra_herramientas = color_fun_barra_herramientas;
    }

    public void setColor_fun_barra_estado(String color_fun_barra_estado) {
        this.color_fun_barra_estado = color_fun_barra_estado;
    }

    public void setColor_borde_barra_herramientas(String color_borde_barra_herramientas) {
        this.color_borde_barra_herramientas = color_borde_barra_herramientas;
    }

    public void setColor_borde_barra_estado(String color_borde_barra_estado) {
        this.color_borde_barra_estado = color_borde_barra_estado;
    }

    private ResultSet resultado;
    private JComboBox combo_text_menu;
    private JComboBox combo_text_subMenu;
    private JComboBox combo_text_Empresa;

    private JComboBox combo_fondo_pantalla;
    private JComboBox combo_fondo_menu;
    private JComboBox combo_fondo_herramientas;
    private JComboBox combo_fondo_estado;
    private JComboBox combo_fondo_func_herramientas;
    private JComboBox combo_fondo_func_estado;

    private JComboBox combo_borde_herramientas;
    private JComboBox combo_borde_estado;
    
    private String Nombre_Color;

    private String color_txt_menu;
    private String color_text_submenu;
    private String color_text_empresa;

    private String color_fondo_pantalla;
    private String color_fondo_barra_menu;
    private String color_fondo_barra_herramientas;
    private String color_fondo_barra_estado;
    private String color_fun_barra_herramientas;
    private String color_fun_barra_estado;

    private String color_borde_barra_herramientas;
    private String color_borde_barra_estado;

    private int rojo;
    private int verde;
    private int azul;

}
