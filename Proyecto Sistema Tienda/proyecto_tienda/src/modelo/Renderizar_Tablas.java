package modelo;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.table.DefaultTableCellRenderer;

public class Renderizar_Tablas extends DefaultTableCellRenderer {

//    public Renderizar_Tablas(boolean elegir_tabla, int op_tabla_salida, String pregunta, String tabla_cancelar) {
//        this.elegir_tabla = elegir_tabla;
//        this.pregunta = pregunta;
//        this.tabla_cancelar = tabla_cancelar;
//
//        this.num_colum_tabla_salida = op_tabla_salida; 
//
//    }
    public Renderizar_Tablas(int columnas, String pregunta) {
        this.num_colum_tabla_salida = columnas;
        this.pregunta = pregunta;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        table.setSelectionBackground(Color.gray);/// este es para el cursor que navega en la tabla
        table.setSelectionForeground(Color.pink);//// este pone el color de la letra a la fila selccionada 
        table.setRowSelectionAllowed(true);

        //////////////////////////////////////////////////////////////////////////////////////////////
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

        if (value instanceof JSpinner) {

            JSpinner spinner = (JSpinner) value;

            return spinner;
        }

        if (value instanceof JTextField) {

            JTextField textfield = (JTextField) value;

            return textfield;
        }
        for (int i = 0; i < num_colum_tabla_salida; i++) {

            table.getColumnModel().getColumn(i).setResizable(false);

        }

        this.setHorizontalAlignment(SwingConstants.CENTER);


        /*
        if (pregunta.equals("")) {

            table.getColumnModel().getColumn(0).setPreferredWidth(5);
            table.getColumnModel().getColumn(1).setPreferredWidth(60);
            table.getColumnModel().getColumn(2).setPreferredWidth(20);
            table.getColumnModel().getColumn(3).setPreferredWidth(20);

            table.getColumnModel().getColumn(4).setPreferredWidth(90);

            table.getColumnModel().getColumn(5).setPreferredWidth(10);
            //table.getColumnModel().getColumn(6).setPreferredWidth(10);

            table.getColumnModel().getColumn(6).setPreferredWidth(10);
            table.getColumnModel().getColumn(7).setPreferredWidth(10);

            table.getColumnModel().getColumn(8).setPreferredWidth(30);
            table.getColumnModel().getColumn(9).setPreferredWidth(30);
            if (column == 0 || column == 5 || column == 6 || column == 7) {
                this.setHorizontalAlignment(SwingConstants.CENTER);
            } else {
                this.setHorizontalAlignment(SwingConstants.LEFT);
            }

            for (int i = 0; i < num_colum_tabla_salida; i++) {

                table.getColumnModel().getColumn(i).setResizable(false);

            }
        } else if (pregunta.equalsIgnoreCase("Tabla_ventas")) {
            table.getColumnModel().getColumn(0).setPreferredWidth(5);
            table.getColumnModel().getColumn(1).setPreferredWidth(130);
            table.getColumnModel().getColumn(2).setPreferredWidth(130);
            table.getColumnModel().getColumn(3).setPreferredWidth(20);

            table.getColumnModel().getColumn(4).setPreferredWidth(20);

            table.getColumnModel().getColumn(5).setPreferredWidth(10);
            this.setHorizontalAlignment(SwingConstants.CENTER);

            //table.getColumnModel().getColumn(6).setPreferredWidth(10);
        } else if (pregunta.equals("tabla_lista_sistema")) {
            table.getColumnModel().getColumn(0).setPreferredWidth(5);
            table.getColumnModel().getColumn(1).setPreferredWidth(60);
            table.getColumnModel().getColumn(2).setPreferredWidth(20);
            table.getColumnModel().getColumn(3).setPreferredWidth(20);

            table.getColumnModel().getColumn(4).setPreferredWidth(90);

            table.getColumnModel().getColumn(5).setPreferredWidth(10);
            table.getColumnModel().getColumn(6).setPreferredWidth(10);
            table.getColumnModel().getColumn(7).setPreferredWidth(10);

            table.getColumnModel().getColumn(8).setPreferredWidth(30);

        } else if (pregunta.equalsIgnoreCase("Tabla_proveedor")) {

        } else if (pregunta.equalsIgnoreCase("hola")) { //tabla compras

            table.getColumnModel().getColumn(0).setPreferredWidth(5);
            table.getColumnModel().getColumn(1).setPreferredWidth(5);
            table.getColumnModel().getColumn(2).setPreferredWidth(60);
            table.getColumnModel().getColumn(3).setPreferredWidth(40);
            table.getColumnModel().getColumn(4).setPreferredWidth(70);

            table.getColumnModel().getColumn(5).setPreferredWidth(5);

            table.getColumnModel().getColumn(6).setPreferredWidth(35);

            table.getColumnModel().getColumn(7).setPreferredWidth(10);
            table.getColumnModel().getColumn(8).setPreferredWidth(10);
            table.getColumnModel().getColumn(9).setPreferredWidth(20);
            table.getColumnModel().getColumn(10).setPreferredWidth(10);
            if (column == 0 || column == 6 || column == 7 || column == 8) {
                this.setHorizontalAlignment(SwingConstants.CENTER);
            } else {
                this.setHorizontalAlignment(SwingConstants.LEFT);
            }
            for (int i = 0; i < num_colum_tabla_salida; i++) {

                table.getColumnModel().getColumn(i).setResizable(true);

            }

        } else if (pregunta.equalsIgnoreCase("tabla_deudas")) {

            for (int i = 0; i < num_colum_tabla_salida; i++) {

                table.getColumnModel().getColumn(i).setResizable(true);

            }

        
         */
        if (row % 2 == 0) {

            setBackground(Color.white);
            setForeground(Color.BLACK);

        } else {

            setBackground(Color.lightGray);
            setForeground(Color.BLACK);
        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.

    }
    private boolean elegir_tabla;
    private int num_colum_tabla_salida;
    private boolean estado;
    private String pregunta;
    private String tabla_cancelar = "";

}
