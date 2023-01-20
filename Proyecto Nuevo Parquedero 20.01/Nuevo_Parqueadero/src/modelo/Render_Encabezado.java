package modelo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author mayra
 */
public class Render_Encabezado implements TableCellRenderer {

 
    public Render_Encabezado() {

    }
    public void Ejegir_tabla(boolean  elegir){
        this.elegir = elegir;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JComponent jcomponent = null;

        if (value instanceof String) {
            jcomponent = new JLabel((String) value);
            ((JLabel) jcomponent).setHorizontalAlignment(SwingConstants.CENTER);
            ((JLabel) jcomponent).setSize(40, jcomponent.getWidth());
            ((JLabel) jcomponent).setPreferredSize(new Dimension(6, jcomponent.getWidth()));
        }

        jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(255, 255, 255)));

        jcomponent.setOpaque(true);

        if (elegir) {
            jcomponent.setBackground(new Color(65, 65, 65));
            jcomponent.setForeground(Color.white);

        }
 
        
        
        
        
        
        
        jcomponent.setToolTipText("Tabla Seguimiento");

        jcomponent.setFont(new Font("Verdana", Font.BOLD, 13));

        return jcomponent;

    }

    private boolean elegir;

}
