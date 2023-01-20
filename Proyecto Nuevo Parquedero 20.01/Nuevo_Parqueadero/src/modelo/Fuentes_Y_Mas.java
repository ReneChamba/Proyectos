package modelo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Fuentes_Y_Mas {

    public Fuentes_Y_Mas() {

        letra_titulo = new Font("Dialog", Font.BOLD, 22);
        letra_txt = new Font("Consolas", Font.BOLD, 15);
        letra_label = new Font("Arial", Font.BOLD, 14);
        letra_btn = new Font("Dialog", Font.BOLD, 18);
        cursor = new Cursor(Cursor.HAND_CURSOR);
        borde = null;
       borde_Linea =null;
       color_titulo =  new Color(0, 139, 139);   
       color_letra_btn = new Color(128, 128, 0);
       color_fondo_btn = new Color (224, 255, 255);
       titulo="RR 20.01";
       
       

    }

    public String getTitulo(){
        
        return titulo;
    }
    public Font getLetra_Titulos() {

        return letra_titulo;
    }

    public Font getLetra_Txt() {

        return letra_txt;
    }

    public Font getLetra_btn() {

        return letra_btn;
    }

    public Font getLetra_label() {
        return letra_label;
    }
    public int getHorientacion(){
        
        return 0;
    }

    public Cursor getCursor() {
        return cursor;
    }
    
    public Color getColor_Bien (){
        
        return Color.GREEN;
    }
    
     public Color getColor_Mal(){
        
        return Color.ORANGE;
    }

    public Color getColor_titulo() {
        return color_titulo;
    }

    public Color getColor_letra_btn() {
        return color_letra_btn;
    }
    public Color getColor_Fondo_btn(){
        
        return  color_fondo_btn;
    }
    
     
     
     public Border getBorderlinea(Color color_linea){
         
          borde_Linea = BorderFactory.createLineBorder(color_linea, 2, true);
          return  borde_Linea;
         
     }
     
     public Border getBorder(String titulo, Color color){
         
         borde = BorderFactory.createTitledBorder(getBorderlinea(Color.DARK_GRAY), titulo, 0, 0, getLetra_Txt(), color);
         
         return  borde;
         
     }
     
 

    public int centrar_Pantalla(int ancho_formulario) {

        //La clase toolkit es abstracta
        //1) Almacenamos nuestro sistema nativo de ventanas, en una variable, esto quiere decir que tenemos
        //acceso a ciertas propiedades de la pantalla del sistema donde se esta ejecutando la aplicacion
        Toolkit miPantalla = Toolkit.getDefaultToolkit();

        //2) utlizamos el metodo .getScreenSize() (Retona un objeto tipo Dimension) , el metodo .getScreenSize() 
        //que pertenece a la clase Toolkit, como toolkit es una  clase abtracta , accedo al metodo con el objeto toolkit
        // miPantalla que cree;
        // 3) Obtengo la resolucion de la pantalla de mi pc 
        Dimension dimension = miPantalla.getScreenSize();
        
        //4) obtengo el ancho, y alto getWidth  y getheight son  campos de clase del Objeto Dimension
        
       // int alto = (int)dimension.height;
        int ancho_patalla = (int) dimension.getWidth();
        
        

        //Esta formula la hice en un cuaderno , que tiene un carro como portada
        return (ancho_patalla-ancho_formulario)/2;
        
    }

    private Font letra_titulo;
    private Font letra_txt;
    private Font letra_label;
    private Font letra_btn;
    private Cursor cursor;
    private Border borde;
    private Border borde_Linea;
    private Color color_titulo;
    private Color color_letra_btn;
    private Color color_fondo_btn;
    private  final String titulo;
    

}
