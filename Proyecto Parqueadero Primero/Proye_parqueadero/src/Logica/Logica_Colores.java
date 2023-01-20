package Logica;

import Conexion.Conectar_base;
import java.sql.*;
import javax.swing.JComboBox;
import static javax.swing.JOptionPane.*;

public class Logica_Colores {

    public Logica_Colores() {

        cn = new Conectar_base();
        pr = null;
        resultado = null;

    }

    public void consulta_Colores(JComboBox combo) {

        try {

            pr = cn.getConnection().prepareStatement(consu_colores);
            resultado = pr.executeQuery();

            combo.addItem(("Seleccionar"));
            while (resultado.next()) {

                combo.addItem(resultado.getString("Nombre_Color"));
            }

        } catch (Exception e) {
            showMessageDialog(null, "No se pudo cargar  colores, combo " + e.getMessage());
           /// System.out.println("No se pudo cargar  colore, combo " + e.getMessage());
        } finally {
            cn.getDesconectar();
            pr = null;
        }

    }

    public void get_Colores(String nombre_color, boolean operacion, int rojo_2, int verde_2, int azul_2) {
        String consu = "";

        if (operacion) {
            consu = "SELECT  *  FROM colores  WHERE Nombre_Color =?";
        } else {
            consu = "INSERT INTO  colores  VALUES(?,?,?,?)";
        }

        try {

            pr = cn.getConnection().prepareStatement(consu);

            if (operacion) {
                pr.setString(1, nombre_color);
                resultado = pr.executeQuery();

                while (resultado.next()) {
                    nombre_color_traer = resultado.getString("Nombre_Color");
                    rojo = resultado.getInt("Rojo");
                    verde = resultado.getInt("Verde");
                    azul = resultado.getInt("Azul");

                }
            } else {

                pr.setString(1, nombre_color);
                pr.setInt(2, rojo_2);
                pr.setInt(3, verde_2);
                pr.setInt(4, azul_2);
                pr.executeUpdate();
            }

        } catch (Exception e) {
            showMessageDialog(null, "No se pudo cargar  color  " + e.getMessage());
           // System.out.println("No se pudo cargar  color  " + e.getMessage());
        } finally {
            cn.getDesconectar();
            pr = null;
        }

    }

    public int nombres_Color_funciones(boolean estado, String color_fondos, String color_border, String color_fondo_titulos_2, String color_letra_titulos_2, String color_leta_funci) {
        int retornar = 0;
        String color_funciones = "";

        if (estado) {
            color_funciones = "SELECT * FROM colores_nombres_funciones ";
        } else {

            color_funciones = "UPDATE colores_nombres_funciones SET Color_Fondo = '" + color_fondos + "'  , Color_Bordes= '" + color_border + "' , Color_Fondo_Titulos ='" + color_fondo_titulos_2 + "',"
                    + "Color_Letra_Titulos = '" + color_letra_titulos_2 + "' ,Color_Letra_Funciones = '" + color_leta_funci + "'  ";

        }

        try {

            pr = cn.getConnection().prepareStatement(color_funciones);

            if (estado) {
                resultado = pr.executeQuery();

                while (resultado.next()) {

                    color_borde = resultado.getString("Color_Bordes");
                    color_fondo = resultado.getString("Color_Fondo");
                    color_fondo_titulos = resultado.getString("Color_Fondo_Titulos");
                    color_letra_titulos = resultado.getString("Color_Letra_Titulos");
                    color_letra_funciones = resultado.getString("Color_Letra_Funciones");

                }
            } else {

                pr.executeUpdate();

            }
            retornar = 1;

        } catch (Exception e) {
            showMessageDialog(null, "No se pudo traer el  nombre_color funciones " + e.getMessage());
            //System.out.println("No se pudo traer el  nombre_color funciones " + e.getMessage());
        } finally {
            cn.getDesconectar();
            pr = null;
        }

        return retornar;
    }

    public int GetRojo() {
        return rojo;
    }

    public String getNombre_color() {
        return nombre_color_traer;
    }

    public int getVerde() {
        return verde;
    }

    public int getAzul() {

        return azul;
    }

    public String getColor_fondo() {
        return color_fondo;
    }

    public String getColor_letra_titulos() {
        return color_letra_titulos;
    }

    public String getColor_letra_funciones() {
        return color_letra_funciones;
    }

    public String getColor_borde() {
        return color_borde;
    }

    public String getColor_fondo_titulos() {
        return color_fondo_titulos;
    }

    private Conectar_base cn;
    private PreparedStatement pr;
    private ResultSet resultado;
    private final String consu_colores = "SELECT  Nombre_Color FROM colores";

    private int rojo;
    private int verde;
    private int azul;
    private String nombre_color_traer;
    private String color_fondo;
    private String color_letra_titulos;
    private String color_letra_funciones;
    private String color_borde;
    private String color_fondo_titulos;

}
