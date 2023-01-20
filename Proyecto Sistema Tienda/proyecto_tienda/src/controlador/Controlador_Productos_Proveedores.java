package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import modelo.Crud_Nuevo;
import modelo.Modelo_Nuevo;
import vistas.Productos_Proveedores;
import static javax.swing.JOptionPane.*;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import modelo.Trasparente;

public class Controlador_Productos_Proveedores implements KeyListener {

    private Productos_Proveedores productos_proveedores;
    private Modelo_Nuevo modelo_nuevo;
    private Crud_Nuevo crud_nuevo;

    public Controlador_Productos_Proveedores(Productos_Proveedores productos_proveedores, Modelo_Nuevo modelo_nuevo, Crud_Nuevo crud_nuevo) {

        this.productos_proveedores = productos_proveedores;
        this.crud_nuevo = crud_nuevo;
        this.modelo_nuevo = modelo_nuevo;
        //////////////////////////////////////////////////////////////////////////////
        this.productos_proveedores.txt_buscar.addKeyListener(this);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        color_botones = new Color(30, 138, 137);//color de los botones y del titulo
        letras_label = new Font("Dialog", Font.BOLD, 14);
        letra_txt = new Font("Dialog", Font.BOLD + Font.ITALIC, 13);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        this.productos_proveedores.setResizable(false);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Asignar_Letra();
    }

    public void Iniciar_Componentes(String codigo, String nombre_proveedor, String empresa) {
        this.codigo = codigo;
        this.nombre_proveedor = nombre_proveedor;
        this.empresa = empresa;

        productos_proveedores.txt_nombre_proveedor.setText(nombre_proveedor);
        productos_proveedores.txt_codigo_proveedor.setText(codigo);
        productos_proveedores.txt_empresa.setText(empresa);
        Graficar_Productos_Proveedores();

        productos_proveedores.setLocationRelativeTo(null);
        // productos_proveedores.setTitle("Tabla Proveedor: " + this.nombre_proveedor + "     CODIGO: " + this.codigo);

        productos_proveedores.setVisible(true);

    }

    private void Asignar_Letra() {
        productos_proveedores.label_titulo.setFont(new Font("Dialog", Font.BOLD, 20));
        productos_proveedores.label_nombre_proveedor.setFont(letras_label);
        productos_proveedores.label_codigo.setFont(letras_label);
        productos_proveedores.label_empresa.setFont(letras_label);

        productos_proveedores.txt_codigo_proveedor.setFont(letra_txt);
        productos_proveedores.txt_nombre_proveedor.setFont(letra_txt);
        productos_proveedores.txt_buscar.setFont(letra_txt);
        productos_proveedores.txt_empresa.setFont(letra_txt);

        productos_proveedores.txt_codigo_proveedor.setHorizontalAlignment(0);
        productos_proveedores.txt_nombre_proveedor.setHorizontalAlignment(0);
        productos_proveedores.txt_buscar.setHorizontalAlignment(0);
        productos_proveedores.txt_empresa.setHorizontalAlignment(0);
        productos_proveedores.txt_codigo_proveedor.setEditable(false);
        productos_proveedores.txt_nombre_proveedor.setEditable(false);
        productos_proveedores.txt_empresa.setEditable(false);
        Trasparente txt_buscar = new Trasparente("Buscar Producto", productos_proveedores.txt_buscar, Trasparente.Show.ALWAYS);

        LineBorder linea = new LineBorder(color_botones, 2, true);
        productos_proveedores.txt_buscar.setBorder(linea);
        productos_proveedores.label_titulo.setForeground(color_botones);

    }

    public void Graficar_Productos_Proveedores() {

        modelo_nuevo.setTabla(productos_proveedores.tabla_productos_proveedores);
        modelo_nuevo.setCodigo(codigo);

        if (!crud_nuevo.Modelo_Tabla_Productos_Proveedores(modelo_nuevo)) {

            showMessageDialog(productos_proveedores, "No se pudo cargar los productos del proveedor : " + nombre_proveedor);

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == productos_proveedores.txt_buscar) {
            char letra = e.getKeyChar();

            if (Character.isLowerCase(letra)) {

                String convertir = ("" + letra).toUpperCase();
                letra = convertir.charAt(0);
                e.setKeyChar(letra);
            }

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        modelo_nuevo.getRowSorter().setRowFilter(RowFilter.regexFilter(productos_proveedores.txt_buscar.getText(), 4));

    }
    private String codigo;
    private String nombre_proveedor;
    private String empresa;
    private final Font letras_label;
    private final Color color_botones;
    private final Font letra_txt;

}
