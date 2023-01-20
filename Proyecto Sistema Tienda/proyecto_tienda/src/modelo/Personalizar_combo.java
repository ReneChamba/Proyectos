package modelo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class Personalizar_combo extends BasicComboBoxUI {

    //private Logica_Colores colores;
    private int elegir;
   

    public Personalizar_combo() {
        // Cargar_Colores();

    }

    public void Iniciar_Parametro (int elegir ){
        this.elegir = elegir;
      
        
    }
    
    private void Cargar_Colores() {

        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*
       Manejo de Colores
         */
//        colores = new Logica_Colores();/////////////////////
//        colores.nombres_Color_funciones(true, "", "", "", "", "");
//        String fondo = colores.getColor_fondo();
//        String color_borde = colores.getColor_borde();//
//        String color_fondo_titulos = colores.getColor_fondo_titulos();
//
//        ///////////////////Color de fondo///////////////////////////////////////////////
//        colores.get_Colores(fondo, true, 0, 0, 0);
//        color_fondo = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
//        ///////////////COLOR DE BORDER///////////////////////////////////////////
//        colores.get_Colores(color_borde, true, 0, 0, 0);
//        Color color_1 = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
//
//        color_fondo_btn = color_1;
//        border = new LineBorder(color_1, 3, true);
//        ////////COLOR FONDO SELECCION COMBO/////////////////////////////////////////////////////
//        colores.get_Colores(color_fondo_titulos, true, 0, 0, 0);
//       color_selecc_combo= new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
    }

    @Override
    protected JButton createArrowButton() {

      //  btnFlecha = new JButton(new ImageIcon("src/Image_2/flecha_abajo_2.png"));

        btnFlecha = new JButton(new ImageIcon("src/Image_2/fecha_combo.png"));
        btnFlecha.setContentAreaFilled(false);
        btnFlecha.setOpaque(true);
        btnFlecha.setBackground(color_fondo_btn);
        btnFlecha.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnFlecha.setBorder(border);

        return btnFlecha;

    }

    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
        g.setColor(color_fondo);

        ////g.setFont( new Font ("Algerial",Font.ITALIC,16));
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        //// super.paintCurrentValueBackground(g, bounds, hasFocus); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected ListCellRenderer createRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.

                list.setSelectionForeground(color_selecc_combo);
                list.setFont(new Font("Arial", Font.BOLD, 13));

                if (elegir == 1 ) {

                    switch (index) {
                        case 0:
                            setIcon(new ImageIcon("src/Image_2/pastel_nueva.png"));
                            break;
                        case 1 :
                            setIcon(new ImageIcon("src/Image_2/barra_nueva.png"));
                            break;
                     
                        default:
                            break;
                    }
                 
                }
                 return this;

              
            }

        };
    }
    private JButton btnFlecha = null;
    private Color color_fondo = null;
    private Color color_fondo_btn = null;
    private Color color_selecc_combo = null;
    private LineBorder border = null;

}
