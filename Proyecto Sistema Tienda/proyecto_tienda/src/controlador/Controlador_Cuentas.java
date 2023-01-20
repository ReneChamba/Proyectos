package controlador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import modelo.*;
import vistas.Cuentas_Usuarios;
import static javax.swing.JOptionPane.*;

public class Controlador_Cuentas implements ActionListener, MouseListener, KeyListener {

    private Modelo_Nuevo modelo_nuevo;
    private Crud_Nuevo crud_nuevo;
    private Cuentas_Usuarios cuentas_usuarios;

    public Controlador_Cuentas(Modelo_Nuevo modelo_nuevo, Crud_Nuevo crud_nuevo, Cuentas_Usuarios cuentas_usuarios) {
        this.modelo_nuevo = modelo_nuevo;
        this.crud_nuevo = crud_nuevo;
        this.cuentas_usuarios = cuentas_usuarios;
        this.cuentas_usuarios.combo_cuentas_usuarios.addActionListener(this);
        this.cuentas_usuarios.tabla_cuentas_usuarios.addMouseListener(this);
        this.cuentas_usuarios.txt_buscar_usuario.addKeyListener(this);
        Trasparente txt_cedula = new Trasparente("Ingrese Cedula ", this.cuentas_usuarios.txt_buscar_usuario, Trasparente.Show.ALWAYS);
        this.cuentas_usuarios.setResizable(false);
        this.cuentas_usuarios.setTitle("Sistema de Ventas");
        icono_prod_vacio = new ImageIcon("src/Image_Sms/admiracion_nueva.png");
        Pop_Menu();
        Asignar_Tipo_letra();

    }

    public void Iniciar_Componentes() {
        cuentas_usuarios.setLocationRelativeTo(null);
        Cargar_Modelo(true, ""); // solo si le paso false, tengo que pasarle el tipo de cuenta que va  a filtrar

        cuentas_usuarios.txt_buscar_usuario.setText("");
        cuentas_usuarios.combo_cuentas_usuarios.setSelectedIndex(0);
        cuentas_usuarios.setVisible(true);

    }

    private void Pop_Menu() {

        JPopupMenu Objeto_menu = new JPopupMenu();

        JMenuItem item1 = new JMenuItem("Eliminar Cuenta", new ImageIcon("src/Image_2/eliminar_rcuenta.png"));
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Eliminar_Usuario();

            }
        });

        Objeto_menu.add(item1);

        cuentas_usuarios.tabla_cuentas_usuarios.setComponentPopupMenu(Objeto_menu);

    }

    private void Asignar_Tipo_letra() {

        cuentas_usuarios.label_titulo.setFont(letras_titulo);
        cuentas_usuarios.label_buscar_usuario.setFont(letras_txt_label);
        cuentas_usuarios.txt_buscar_usuario.setFont(letras_txt_label);
        cuentas_usuarios.combo_cuentas_usuarios.setFont(letras_txt_label);
        cuentas_usuarios.txt_buscar_usuario.setHorizontalAlignment(0);
        cuentas_usuarios.label_titulo.setHorizontalAlignment(0);
        //////////////////////////////////////////////////////
        cuentas_usuarios.label_titulo.setForeground(color_label);
        cuentas_usuarios.label_buscar_usuario.setForeground(color_label);
        //////////////////////////////////////////////////////////////////////77
        cuentas_usuarios.combo_cuentas_usuarios.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    private void Eliminar_Usuario() {

        String cedula = cuentas_usuarios.tabla_cuentas_usuarios.getValueAt(cuentas_usuarios.tabla_cuentas_usuarios.getSelectedRow(), 1).toString();
        String tipo_cuenta = cuentas_usuarios.tabla_cuentas_usuarios.getValueAt(cuentas_usuarios.tabla_cuentas_usuarios.getSelectedRow(), 5).toString();
        String nombre_cuenta = cuentas_usuarios.tabla_cuentas_usuarios.getValueAt(cuentas_usuarios.tabla_cuentas_usuarios.getSelectedRow(), 6).toString();

        if (tipo_cuenta.equalsIgnoreCase("Administrador")) {

            showMessageDialog(cuentas_usuarios, "Operacion no permitida  para " + tipo_cuenta, "Sistema de Ventas", 0, icono_prod_vacio);
        } else {

            String opciones[] = {"Eliminar", "Cancelar"};

            int resp = showOptionDialog(cuentas_usuarios.tabla_cuentas_usuarios, "     Eliminar Cuenta" + "\n\nCuenta:   " + nombre_cuenta + "\nTipo de Cuenta:   " + tipo_cuenta, "Sistema de Ventas", 0, 0, new ImageIcon("src/Image_2/eliminar_rcuenta.png"), opciones, opciones[1]);

            if (resp == 0) {
                String sms = "   Cuenta Elminada Correctamente";
                boolean actualizar_tabla = true;
                modelo_nuevo.setCedula(cedula);
                if (!crud_nuevo.Activar_Desativar_Usuarios(modelo_nuevo, false)) {
                    sms = "    Surgio un problema al intentar eliminar la cuenta \nintentalo mas tarde. ";
                    actualizar_tabla = false;
                }

                JOptionPane.showMessageDialog(cuentas_usuarios.tabla_cuentas_usuarios, sms, "Sistema de Ventas", -1, new ImageIcon("src/Image_Sms/visto_bien.png"));

                if (actualizar_tabla) { // solo si elimina correctamente la cuenta que actualize la tabla 
                    Cargar_Modelo(true, ""); // solo si le paso false, tengo que pasarle el tipo de cuenta que va  a filtrar
                }

            }
        }

    }

    public void Cargar_Modelo(boolean elegir_filtrar, String tipo_cuenta) {

        modelo_nuevo.setTabla(cuentas_usuarios.tabla_cuentas_usuarios);

        if (!elegir_filtrar) { // va a filtar por categoria

            modelo_nuevo.setTipo_cuenta(tipo_cuenta);
        }

        if (!crud_nuevo.Tabla_Cuentas_Usuarios(modelo_nuevo, elegir_filtrar)) {
            showMessageDialog(cuentas_usuarios, "No se pudo cargar el modelo");

        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == cuentas_usuarios.combo_cuentas_usuarios) {

            String tipo_cuenta = cuentas_usuarios.combo_cuentas_usuarios.getSelectedItem().toString();
            boolean elegir = true;

            if (!tipo_cuenta.equalsIgnoreCase("Todas")) {

                elegir = false;

            }

            Cargar_Modelo(elegir, tipo_cuenta);

        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == cuentas_usuarios.tabla_cuentas_usuarios) {

            int columnas = cuentas_usuarios.tabla_cuentas_usuarios.getColumnModel().getColumnIndexAtX(e.getX());
            if (cuentas_usuarios.tabla_cuentas_usuarios.getRowCount() >= 0) {
                int filas = e.getY() / (cuentas_usuarios.tabla_cuentas_usuarios.getRowHeight());
                if (filas < cuentas_usuarios.tabla_cuentas_usuarios.getRowCount() && filas >= 0 && columnas < cuentas_usuarios.tabla_cuentas_usuarios.getColumnModel().getColumnCount() && columnas >= 0) {
                    Object value = cuentas_usuarios.tabla_cuentas_usuarios.getValueAt(filas, columnas);

                    if (value instanceof JCheckBox) {
                        ((JCheckBox) value).doClick();
                        ImageIcon icono = null;
                        JCheckBox checc = (JCheckBox) value;

                        String activar = "";
                        String palabra = "";
                        if (checc.isSelected()) {
                            activar = "Activar Cuenta";
                            palabra = "AC";
                            icono = new ImageIcon("src/Image_Sms/cuenta_habilitar.png");
                        } else {
                            activar = "Desactivar  Cuenta";
                            palabra = "DC";
                            icono = new ImageIcon("src/Image_Sms/cuenta_desabili.png");
                        }
                        String opciones[] = {activar, "Cancelar"};

                        int res = JOptionPane.showOptionDialog(cuentas_usuarios, "Seguro (a) desea " + activar, "Sistema de Parqueo", 0, 0, icono, opciones, opciones[1]);

                        if (res == 0) {

                            String cedula = cuentas_usuarios.tabla_cuentas_usuarios.getValueAt(cuentas_usuarios.tabla_cuentas_usuarios.getSelectedRow(), 1).toString();

                            modelo_nuevo.setEstado_cuenta(palabra);
                            modelo_nuevo.setCedula(cedula);
                            if (!crud_nuevo.Activar_Desativar_Usuarios(modelo_nuevo, true)) {
                                showMessageDialog(cuentas_usuarios, "Surguio  un problema de red , intentalo en otro momento");

                            } else {
                                Cargar_Modelo(true, "");
                            }

                        } else if (res == 1) {

                            if (activar.equals("Activar Cuenta")) {
                                checc.setSelected(false);
                            } else {
                                checc.setSelected(true);
                            }
                        }

                    }

                }

            }

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

        modelo_nuevo.getRowSorter().setRowFilter(RowFilter.regexFilter(cuentas_usuarios.txt_buscar_usuario.getText(), 1));

    }

    Font letras_titulo = new Font("Arial Black", Font.BOLD, 20);
    Font letras_txt_label = new Font("Dialog", Font.BOLD, 13);
    Color color_label = new Color(30, 138, 137);
    private final ImageIcon icono_prod_vacio;

   

}
