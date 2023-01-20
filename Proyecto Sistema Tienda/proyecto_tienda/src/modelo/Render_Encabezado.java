package modelo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author mayra
 */
public class Render_Encabezado implements TableCellRenderer {

    String elegir = "";

    public Render_Encabezado(String elegir) {

        this.elegir = elegir;
    }

    public Render_Encabezado() {

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JComponent jcomponent = null;

        if (value instanceof String) {
            jcomponent = new JLabel((String) value);
            ((JLabel) jcomponent).setHorizontalAlignment(SwingConstants.CENTER);
            ((JLabel) jcomponent).setSize(30, jcomponent.getWidth());
            ((JLabel) jcomponent).setPreferredSize(new Dimension(6, jcomponent.getWidth()));
        }

        //   jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(255, 255, 255)));
        jcomponent.setOpaque(true);
        if (elegir.equalsIgnoreCase("cambia_color")) {
            jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));

            jcomponent.setBackground(new Color(255, 228, 196));
            jcomponent.setForeground(Color.BLACK);

        } else {
            jcomponent.setBackground(new Color(65, 65, 65));
            jcomponent.setForeground(Color.white);
            jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(255, 255, 255)));

        }

        jcomponent.setToolTipText("Tabla Seguimiento");

        jcomponent.setFont(new Font("Verdana", Font.BOLD, 13));

        return jcomponent;

    }

}
