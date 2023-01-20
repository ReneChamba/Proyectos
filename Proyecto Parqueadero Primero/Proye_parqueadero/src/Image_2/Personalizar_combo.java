package Image_2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.text.StyleConstants;

public class Personalizar_combo extends BasicComboBoxUI {
 JButton btnFecha = null;
    
 
    @Override
    protected JButton createArrowButton() {
        

       btnFecha = new JButton(new ImageIcon("src/Image_2/fecha_combo.png"));
       
         /// btnFecha = new JButton(new ImageIcon("src/Image_2/fecha_combo.png"));
        btnFecha.setContentAreaFilled(false);
       btnFecha.setOpaque(true);
        btnFecha.setBackground(Color.GREEN);
        btnFecha.setCursor(  new Cursor ( Cursor.HAND_CURSOR));
        btnFecha.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));

        return btnFecha;

    }

    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
        g.setColor(Color.green);
    
        
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

              
                list.setSelectionForeground(Color.DARK_GRAY);
                list.setFont( new Font ("Arial" ,Font.BOLD,13));
                if (index == 1) {

                    setIcon(new ImageIcon("src/Image_2/nuevo.png"));
                   
                } else if (index == 2) {
                    setIcon(new ImageIcon("src/Image_2/actualizar.png"));
                }else if (index==3){
                      setIcon(new ImageIcon("src/Image_2/elimina_1.png"));
                }
            
                
                

                return this;
            }

        };
    }
//    

}
