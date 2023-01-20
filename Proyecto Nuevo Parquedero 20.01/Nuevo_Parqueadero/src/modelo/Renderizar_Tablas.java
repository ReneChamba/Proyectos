package modelo;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import javax.swing.table.DefaultTableCellRenderer;

public class Renderizar_Tablas extends DefaultTableCellRenderer {

    private boolean color_seleccion;

    public Renderizar_Tablas() {

    }

    public void Seleccionar_Tabla(String tabla) {
        this.pregunta = tabla;

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        table.setSelectionBackground(Color.gray);/// este es para el cursor que navega en la tabla
        table.setSelectionForeground(Color.pink);//// este pone el color de la letra a la fila selccionada 

        if (hasFocus) {

            table.setVerifyInputWhenFocusTarget(true);
            //table.setRowSelectionAllowed(true);

        } else {

            table.setVerifyInputWhenFocusTarget(false);
            // table.setRowSelectionAllowed(false);
        }

        if (value instanceof JButton) {

            JButton btn = (JButton) value;
//        
            return btn;
        }
        if (value instanceof JLabel) {

            JLabel label = (JLabel) value;

            return label;
        }

        if (value instanceof JCheckBox) {

            JCheckBox chek = (JCheckBox) value;

            return chek;
        }

        /// EVITAR REDIMENSIONAR LAS COLUMNAS
        for (int i = 0; i < table.getColumnCount(); i++) {

            table.getColumnModel().getColumn(i).setResizable(false);
        }

        //PERMITIR O EVITAR QUE EL LAS COLUMNAS SE PUEDAN REORDENAR , TRUE: ORDENAR : FALSE: NO PERMITIR
        table.getTableHeader().setReorderingAllowed(false);

        if (pregunta.equalsIgnoreCase("tb_ingresados")) {

            table.getColumnModel().getColumn(0).setPreferredWidth(10);
            table.getColumnModel().getColumn(1).setPreferredWidth(130);
            table.getColumnModel().getColumn(2).setPreferredWidth(125);

//            //inzquier = 2
//            int horientcion = 2;
//
//            if (column == 5) {
//                horientcion = 0;
//                setForeground(Color.red);
//
//            }
//            setHorizontalAlignment(horientcion);
        }

        if (pregunta.equalsIgnoreCase("tb_salidos")) {

            table.getColumnModel().getColumn(0).setPreferredWidth(140);
            table.getColumnModel().getColumn(1).setPreferredWidth(140);
            table.getColumnModel().getColumn(2).setPreferredWidth(80);
            table.getColumnModel().getColumn(3).setPreferredWidth(130);

            int horientacion = 2;
            if (column > 3) { // columnas que almacenan numeros

                horientacion = 0;
            }
            setHorizontalAlignment(horientacion);
        }

        if (pregunta.equalsIgnoreCase("tb_salidos")) {

            table.getColumnModel().getColumn(0).setPreferredWidth(140);
            table.getColumnModel().getColumn(1).setPreferredWidth(140);
            table.getColumnModel().getColumn(2).setPreferredWidth(80);
            table.getColumnModel().getColumn(3).setPreferredWidth(130);

            int horientacion = 2;
            if (column > 3) { // columnas que almacenan numeros

                horientacion = 0;
            }
            setHorizontalAlignment(horientacion);
        }

        if (pregunta.equalsIgnoreCase("tb_salidos_lavado_parqueo")) {

            table.getColumnModel().getColumn(0).setPreferredWidth(130);
            table.getColumnModel().getColumn(1).setPreferredWidth(130);
            table.getColumnModel().getColumn(4).setPreferredWidth(30);
            table.getColumnModel().getColumn(5).setPreferredWidth(30);
            table.getColumnModel().getColumn(6).setPreferredWidth(30);

            // table.getColumnModel().getColumn(1).setPreferredWidth(140);
            //table.getColumnModel().getColumn(2).setPreferredWidth(80);
            ///table.getColumnModel().getColumn(3).setPreferredWidth(130);
        }

        if (pregunta.equalsIgnoreCase("tb_confi_vehiculos")) {

            table.getColumnModel().getColumn(0).setPreferredWidth(10);
            table.getColumnModel().getColumn(1).setPreferredWidth(80);
            table.getColumnModel().getColumn(2).setPreferredWidth(80);
            table.getColumnModel().getColumn(2).setPreferredWidth(80);

        }

        if (pregunta.equalsIgnoreCase("tb_admin_usuarios")) {

            table.getColumnModel().getColumn(0).setPreferredWidth(10);
            table.getColumnModel().getColumn(1).setPreferredWidth(80);
            table.getColumnModel().getColumn(2).setPreferredWidth(80);
            table.getColumnModel().getColumn(2).setPreferredWidth(120);

        }

        //DETERMINAR QUE FILAS SERAN DE UN COLO ESPECIFICO
        if (row % 2 == 0) {

            //CELDAS PARES
            setBackground(Color.white);
            setForeground(Color.BLACK);

        } else {
            //CELDAS IMPARES

            setBackground(Color.lightGray);
            setForeground(Color.BLACK);
        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.

    }

    private String pregunta = "";
    private String tabla_cancelar = "";

}
