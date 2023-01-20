package modelo;

import java.sql.ResultSet;

public class Modelo_Sistema {

    public Modelo_Sistema() {

    }

    public void setResultado_Datos(ResultSet resulado) {
        this.resultado = resulado;
        Asignar_Valores();

    }

    public void Asignar_Valores() {

        try {

            if (resultado.next()) {

                setMenu_inicio(resultado.getString("MENU_INICIO"));
                setMenu_funciones(resultado.getString("MENU_FUNCIONES"));
                setMenu_configuracion(resultado.getString("MENU_CONFIGURACION"));
                setMenu_sistema(resultado.getString("MENU_SISTEMA"));
                setMenu_respaldos(resultado.getString("MENU_RESPALDOS"));
                setTitulo(resultado.getString("TITULO"));
                setTipo_letra(resultado.getString("LETRA_FAMILIA"));
                setEstilo_fuente(resultado.getString("ESTILO"));
                setTamano_fuente(resultado.getString("TAMANO"));

            }

        } catch (Exception e) {
            System.out.println("error al tarer los nombres de los menus");
        }

    }

    public String getMenu_inicio() {
        return menu_inicio;
    }

    public void setMenu_inicio(String menu_inicio) {
        this.menu_inicio = menu_inicio;
    }

    public String getMenu_funciones() {
        return menu_funciones;
    }

    public void setMenu_funciones(String menu_funciones) {
        this.menu_funciones = menu_funciones;
    }

    public String getMenu_configuracion() {
        return menu_configuracion;
    }

    public void setMenu_configuracion(String menu_configuracion) {
        this.menu_configuracion = menu_configuracion;
    }

    public String getMenu_sistema() {
        return menu_sistema;
    }

    public void setMenu_sistema(String menu_sistema) {
        this.menu_sistema = menu_sistema;
    }

    public String getMenu_respaldos() {
        return menu_respaldos;
    }

    public void setMenu_respaldos(String menu_respaldos) {
        this.menu_respaldos = menu_respaldos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo_letra() {
        return tipo_letra;
    }

    public void setTipo_letra(String tipo_letra) {
        this.tipo_letra = tipo_letra;
    }

    public int getEstilo_fuente() {
        int retorno = 0;
        //0 es estilo normal

        switch (estilo_fuente) {

            case "Negrita":
                retorno = 1;
                break;
            case "Cursiva":
                retorno = 2;
                break;
            case "Negrita + Cursiva":
                retorno = 3;
                break;

        }

        return retorno;
    }

    public void setEstilo_fuente(String estilo_fuente) {
        this.estilo_fuente = estilo_fuente;

        ///esta es para cuando recupere desde el crud , ya qye el metodo get de este metodo retorna un int
        this.estilo_fuente2 = estilo_fuente;
    }

    public int getTamano_fuente() {

        return Integer.parseInt(tamano_fuente);
    }

    public void setTamano_fuente(String tamano_fuente) {
        this.tamano_fuente = tamano_fuente;
    }

    public String getEstilo_Crud_Apoyo() {

        return estilo_fuente2;
    }

    private String menu_inicio;
    private String menu_funciones;
    private String menu_configuracion;
    private String menu_sistema;
    private String menu_respaldos;
    private String titulo;
    private String tipo_letra;
    private String estilo_fuente;

    private String estilo_fuente2;
    private String tamano_fuente;
    private ResultSet resultado;

}
