package Logica;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import javax.swing.table.DefaultTableCellRenderer;

public class renderizar_tablas extends DefaultTableCellRenderer {

    public renderizar_tablas(boolean elegir_tabla, int op_tabla_salida, String pregunta, String tabla_cancelar) {
        this.elegir_tabla = elegir_tabla;
        this.pregunta = pregunta;
        this.tabla_cancelar = tabla_cancelar;

        this.num_colum_tabla_salida = op_tabla_salida;

    }

    public renderizar_tablas(int columnas, String pregunta) {
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

        ///////////////////////////////////////////////////////////////////
//        for (int i = 0; i < num_colum_tabla_salida; i++) {
//
//            table.getColumnModel().getColumn(i).setResizable(false);
//
//        }
        if (pregunta.equalsIgnoreCase("dale")) { //tabla usuario_administrador

            ///////////////// Tabla  Usuario y administrador///////////////////////////////////
            table.getColumnModel().getColumn(0).setPreferredWidth(5);

            table.getColumnModel().getColumn(1).setPreferredWidth(10);

            table.getColumnModel().getColumn(2).setPreferredWidth(10);
            table.getColumnModel().getColumn(3).setPreferredWidth(25);
            table.getColumnModel().getColumn(4).setPreferredWidth(15);
            table.getColumnModel().getColumn(5).setPreferredWidth(20);
            table.getColumnModel().getColumn(6).setPreferredWidth(60);
            table.getColumnModel().getColumn(7).setPreferredWidth(20);
            table.getColumnModel().getColumn(8).setPreferredWidth(35);
            table.getColumnModel().getColumn(9).setPreferredWidth(10);
            table.getColumnModel().getColumn(10).setPreferredWidth(5);
            if (column == 0 || column == 9) {
                this.setHorizontalAlignment(0);
            } else {
                this.setHorizontalAlignment(SwingConstants.LEFT);
            }

        } else if (pregunta.equalsIgnoreCase("vamos_tablas")) { ///tablas ingreso y salida de vehiculos

            ////las tablas ingreso y salidas de vehiculos no se podran redimensionar
            for (int i = 0; i < num_colum_tabla_salida; i++) {

                table.getColumnModel().getColumn(i).setResizable(false);

            }

            ///////////////// Tablas entrada y salida de vehiculos///////////////////////////////////
            table.getColumnModel().getColumn(0).setPreferredWidth(5);
            table.getColumnModel().getColumn(1).setPreferredWidth(20);

            table.getColumnModel().getColumn(2).setPreferredWidth(20);
            table.getColumnModel().getColumn(3).setPreferredWidth(45);

            if (elegir_tabla) {

                //si le llega true es la tabla de autos ingresados
                /// table.getColumnModel().getColumn(3).setPreferredWidth(80);///
                table.getColumnModel().getColumn(4).setPreferredWidth(80);

                if (tabla_cancelar.equals("")) {//tabla ingreso
                    table.getColumnModel().getColumn(5).setPreferredWidth(20);
                    table.getColumnModel().getColumn(6).setPreferredWidth(10);
                    table.getColumnModel().getColumn(7).setPreferredWidth(10);
                } else { //tabla autos cancelados
                    table.getColumnModel().getColumn(5).setPreferredWidth(80);
                }

            } else {
                //si le llega false es la tabla de autos salidos
                //table.getColumnModel().getColumn(3).setPreferredWidth(15);
                table.getColumnModel().getColumn(4).setPreferredWidth(22);
                table.getColumnModel().getColumn(5).setPreferredWidth(80);
                table.getColumnModel().getColumn(6).setPreferredWidth(80);

                for (int i = 7; i < num_colum_tabla_salida; i++) {
                    table.getColumnModel().getColumn(i).setPreferredWidth(10);
                }

            }

            this.setHorizontalAlignment(0);
        } else if (pregunta.equalsIgnoreCase("tabla_vehiculos")) {
            table.getColumnModel().getColumn(0).setPreferredWidth(20);
            table.getColumnModel().getColumn(1).setPreferredWidth(10);

            if (column == 1) {
                this.setHorizontalAlignment(0);
            }else{
                this.setHorizontalAlignment( 2);//izquierda
            }
            table.getColumnModel().getColumn(0).setResizable(false);

            table.getColumnModel().getColumn(1).setResizable(false);
        }
        /// this.setHorizontalAlignment(0);

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
