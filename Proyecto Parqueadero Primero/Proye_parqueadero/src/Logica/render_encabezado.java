package Logica;

import Conexion.Conectar_base;
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
public class render_encabezado implements TableCellRenderer {

    public render_encabezado(boolean elegir) {
        colores = new Logica_Colores();

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

        } else {
            
           /*
            Esto solo aplica para la tabla que esta en el JDialog Agregar_Vehiculo
            */
                  
            colores.nombres_Color_funciones(true, "", "", "", "", "");
            String fondo_encabezado = colores.getColor_fondo_titulos();
            String letra_encabezado = colores.getColor_letra_titulos();
            ///COLOR DE FONDO DEL ENCABEZADO
            colores.get_Colores(fondo_encabezado, true, 0, 0, 0);
            Color color_encabezado = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
            jcomponent.setBackground(color_encabezado);

            //////////////COLOR LETRA DE ENCABEZADO// 
            colores.get_Colores(letra_encabezado, true, 0, 0, 0);

            Color color_letra = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
            jcomponent.setForeground(color_letra);
        }

        jcomponent.setToolTipText("Tabla Seguimiento");

        jcomponent.setFont(new Font("Verdana", Font.BOLD, 13));

        return jcomponent;

    }
    private Logica_Colores colores;
    private boolean elegir;

}
