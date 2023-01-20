package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import mensajes.Joption;
import modelo.Crud_Primero;
import modelo.Fuentes_Y_Mas;
import modelo.Iconos;
import modelo.Modelo_Nuevo;
import modelo.Transparente;
import vista.Editar_Ingreso;
import vista.Listar_Vehiculos_Ingresados;

public class Controlador_Listar_Ingresos implements ActionListener, KeyListener, DocumentListener, ItemListener {

    private Crud_Primero crud_primero;
    private Listar_Vehiculos_Ingresados listar_vehiculos_ingresados;
    private Modelo_Nuevo modelo_nuevo;
    private Controlador_Retirar_Vehiculo controlador_retirar_vehiculo;
    private Editar_Ingreso editar_ingreso;
    private Fuentes_Y_Mas fuentes_Y_mas;
    private Joption mensajes;
    private Iconos iconos;
    private Controlador_Sms controlador_sms;
    private Controlador_Menu_Principal controlador_menu_principal;
    private Controlador_Sms_Pregunta controlador_sms_pregunta;

    public Controlador_Listar_Ingresos() {

    }

    public void setListar_Vehiculos(Listar_Vehiculos_Ingresados listar_vehiculos_ingresados) {
        this.listar_vehiculos_ingresados = listar_vehiculos_ingresados;
    }

    public void setModelo_nuevo(Modelo_Nuevo modelo_nuevo) {
        this.modelo_nuevo = modelo_nuevo;
    }

    public void setCrud_Primero(Crud_Primero crud_primero) {
        this.crud_primero = crud_primero;
    }

    public void setControlador_Retirar_Vehiculo(Controlador_Retirar_Vehiculo controlador_retirar_vehiculo) {
        this.controlador_retirar_vehiculo = controlador_retirar_vehiculo;
    }

    public void setEditar_Ingreso(Editar_Ingreso editar_ingreso) {

        this.editar_ingreso = editar_ingreso;
    }

    public void setFuentes_Y_Mas(Fuentes_Y_Mas fuentes_Y_Mas) {
        this.fuentes_Y_mas = fuentes_Y_Mas;
    }

    public void setMensajes(Joption mensajes_2) {
        this.mensajes = mensajes_2;
    }

    public void setIconos(Iconos iconos) {
        this.iconos = iconos;
    }

    public void setLanzar_Mensaje(Controlador_Sms controlador_sms) {
        this.controlador_sms = controlador_sms;
    }

    public void setControlador_Menu_Principal(Controlador_Menu_Principal controlador_menu_principal) {
        this.controlador_menu_principal = controlador_menu_principal;
    }

    public void setControlador_Sms_Pregunta(Controlador_Sms_Pregunta controlador_sms_pregunta) {
        this.controlador_sms_pregunta = controlador_sms_pregunta;
    }

    public void Estados_Constructor() {
        editar_ingreso.txt_codigo.setEditable(false);

        editar_ingreso.btn_actualizar_vehiculo.addActionListener(this);
        editar_ingreso.btn_regresar.addActionListener(this);
        editar_ingreso.txt_propietario.addKeyListener(this);
        editar_ingreso.txt_placa.addKeyListener(this);
        editar_ingreso.txt_precio_lavado.addKeyListener(this);

        /*
        Poner a la escucha (DocumentListener)
        
        1:forma 1
        // Crear un objeto Document , obteniendo  el getDocument() del txt que se desea poner a la escucha
          Document  docume_1 =   editar_ingreso.txt_placa.getDocument();
        // A ese objeto Document  , se  lo pone a la  escucha  
        docume_1.addDocumentListener(this);
        
        2: forma 2
        //Poner directamente al txt
          editar_ingreso.txt_placa.getDocument().addDocumentListener(this);
         */
        editar_ingreso.txt_placa.getDocument().addDocumentListener(this);
        editar_ingreso.txt_propietario.getDocument().addDocumentListener(this);
        editar_ingreso.txt_precio_lavado.getDocument().addDocumentListener(this);
        //=====================================================================

        editar_ingreso.combo_vehiculos.addItemListener(this);
        editar_ingreso.combo_motivo.addItemListener(this);

        listar_vehiculos_ingresados.txt_listar.addKeyListener(this);
        listar_vehiculos_ingresados.tabla.addKeyListener(this);
        listar_vehiculos_ingresados.btn_filtrar.addActionListener(this);
        listar_vehiculos_ingresados.btn_reiniciar.addActionListener(this);

        listar_vehiculos_ingresados.setResizable(false);
        listar_vehiculos_ingresados.setTitle(fuentes_Y_mas.getTitulo());
        editar_ingreso.setTitle(fuentes_Y_mas.getTitulo());

        Evento_Click();
        Diseno();
        Diseno_Ventana_Editar();
        Poner_Horas();
    }

    private void Diseno() {

        listar_vehiculos_ingresados.lb_titulo.setFont(fuentes_Y_mas.getLetra_Titulos());
        listar_vehiculos_ingresados.txt_listar.setFont(fuentes_Y_mas.getLetra_Txt());
        Transparente txt_listar = new Transparente("Ingresa una placa a buscar", listar_vehiculos_ingresados.txt_listar, Transparente.Show.ALWAYS);
        Transparente txt_ingresar_lavado = new Transparente("Precio Lavado", editar_ingreso.txt_precio_lavado, Transparente.Show.ALWAYS);

        listar_vehiculos_ingresados.txt_listar.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        listar_vehiculos_ingresados.lb_name_registros.setFont(fuentes_Y_mas.getLetra_label());
        listar_vehiculos_ingresados.lb_poner_numero.setFont(fuentes_Y_mas.getLetra_Txt());
        listar_vehiculos_ingresados.btn_filtrar.setCursor(fuentes_Y_mas.getCursor());
        listar_vehiculos_ingresados.btn_reiniciar.setCursor(fuentes_Y_mas.getCursor());
        listar_vehiculos_ingresados.btn_filtrar.setIcon(iconos.getIcono_buscar_vehicu());
        listar_vehiculos_ingresados.btn_reiniciar.setIcon(iconos.getIcono_actualizar());
        listar_vehiculos_ingresados.txt_listar.setBorder(fuentes_Y_mas.getBorderlinea(fuentes_Y_mas.getColor_Bien()));
        listar_vehiculos_ingresados.lb_titulo.setForeground(fuentes_Y_mas.getColor_titulo());

        listar_vehiculos_ingresados.panel_funciones.setBorder(fuentes_Y_mas.getBorder("Sistema", Color.BLACK));

    }

    private void Diseno_Ventana_Editar() {

        editar_ingreso.lb_titulo.setFont(fuentes_Y_mas.getLetra_Titulos());

        editar_ingreso.lb_codigo.setFont(fuentes_Y_mas.getLetra_label());
        editar_ingreso.lb_placa.setFont(fuentes_Y_mas.getLetra_label());
        editar_ingreso.lb_propietario.setFont(fuentes_Y_mas.getLetra_label());
        editar_ingreso.lb_tipo.setFont(fuentes_Y_mas.getLetra_label());
        editar_ingreso.lb_motivo.setFont(fuentes_Y_mas.getLetra_label());
        //=================================================================
        editar_ingreso.txt_codigo.setFont(fuentes_Y_mas.getLetra_Titulos());
        editar_ingreso.txt_placa.setFont(fuentes_Y_mas.getLetra_Txt());
        editar_ingreso.txt_propietario.setFont(fuentes_Y_mas.getLetra_Txt());
        editar_ingreso.txt_precio_lavado.setFont(fuentes_Y_mas.getLetra_Txt());
        editar_ingreso.combo_vehiculos.setFont(fuentes_Y_mas.getLetra_Txt());
        editar_ingreso.combo_motivo.setFont(fuentes_Y_mas.getLetra_Txt());

        editar_ingreso.txt_codigo.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        editar_ingreso.txt_placa.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        editar_ingreso.txt_propietario.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        editar_ingreso.txt_precio_lavado.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());

        //===================================================================
        editar_ingreso.btn_actualizar_vehiculo.setIcon(iconos.getIcono_actualizar());
        editar_ingreso.btn_regresar.setIcon(iconos.getIcono_retornar());

        editar_ingreso.btn_actualizar_vehiculo.setFont(fuentes_Y_mas.getLetra_btn());
        editar_ingreso.btn_regresar.setFont(fuentes_Y_mas.getLetra_btn());
        editar_ingreso.btn_actualizar_vehiculo.setCursor(fuentes_Y_mas.getCursor());
        editar_ingreso.btn_regresar.setCursor(fuentes_Y_mas.getCursor());

        editar_ingreso.lb_titulo.setForeground(fuentes_Y_mas.getColor_titulo());

        editar_ingreso.txt_precio_lavado.setVisible(false);

    }

    public void Iniciar_Componentes() {

        listar_vehiculos_ingresados.setLocation(fuentes_Y_mas.centrar_Pantalla(listar_vehiculos_ingresados.getWidth()), 130);
        //1: cargar todo los datos
        Cargar_Tabla(1);
        Poner_Horas();
        listar_vehiculos_ingresados.setVisible(true);
    }

    private void Poner_Horas() {

        listar_vehiculos_ingresados.calendario_inicio.setDate(modelo_nuevo.getFecha_Date());
        listar_vehiculos_ingresados.calendario_final.setDate(modelo_nuevo.getFecha_Date_2());

    }

    private void Tomar_Fecha() {

        modelo_nuevo.setFecha__Date(listar_vehiculos_ingresados.calendario_inicio.getDate());
        modelo_nuevo.setFecha__Date_Final(listar_vehiculos_ingresados.calendario_final.getDate());
    }

    private void Cargar_Tabla(int parametro) {
        listar_vehiculos_ingresados.txt_listar.setText("");

        modelo_nuevo.setTabla(listar_vehiculos_ingresados.tabla);
        // 0 : para filtrar por fecha
        //1: restablecer todo
        if (!crud_primero.Cargar_Tabla_Ingresos(modelo_nuevo, parametro)) {
            controlador_sms.Iniciar_Componentes("No se pudo cargar los datos ", Color.ORANGE);
        }
        //pone el numero de registro listados, metodo que retorna un entero
        int numero = modelo_nuevo.getContador_Registros();
        listar_vehiculos_ingresados.lb_poner_numero.setText(numero + "  Registros");

        //Poner el numero de ingreados el btn de la barra  de estado del menu principal
        controlador_menu_principal.Poner_Cantidad_Vehiculos("" + numero);
    }

    private void Cancelar_Ingreso() {

        String placa = listar_vehiculos_ingresados.tabla.getValueAt(listar_vehiculos_ingresados.tabla.getSelectedRow(), 3).toString();

        String sms = "¿Cancelar Ingreso  Placa: " + placa + " ? ";
        controlador_sms_pregunta.Iniciar_Componenentes(sms, "Retirar", "Cancelar", iconos.getIcono_eliminar_pregunta(), iconos.getIcono_actualizar());

        if (controlador_sms_pregunta.getAccion() == 0) {

            sms = "Error , Intentalo nuevamente";
            Color color = Color.ORANGE;
            modelo_nuevo.setPlaca(placa);
            if (crud_primero.Eliminar_Ingreso(modelo_nuevo)) {
                sms = "Vehiculo Eliminado con exito";
                color = Color.GREEN;
                Cargar_Tabla(1);

            }
            controlador_sms.Iniciar_Componentes(sms, color);
        }

    }

    private boolean Cargar_Combo_Y_Estados() {

        editar_ingreso.combo_vehiculos.removeAllItems();
        modelo_nuevo.setCombo_tipo(editar_ingreso.combo_vehiculos);

        if (!crud_primero.Llenar_Combo_tipo_Vehiculo(modelo_nuevo)) {
            ///showMessageDialog(editar_ingreso, "Surguio un error llenar el combo");
            mensajes.getAceptar(editar_ingreso, "Surguio un error llenar el combo", iconos.getIcono_alerta());

            return false;
        }
        return true;

    }

    private void Editar() {

        //primero valido que Sí, el combo carga correctmaente , hago lo demas
        int fila = listar_vehiculos_ingresados.tabla.getSelectedRow();
        if (Cargar_Combo_Y_Estados()) {
            String codigo = listar_vehiculos_ingresados.tabla.getValueAt(fila, 0).toString();
            String propietario = listar_vehiculos_ingresados.tabla.getValueAt(fila, 2).toString();
            String placa = listar_vehiculos_ingresados.tabla.getValueAt(fila, 3).toString();
            String tipo = listar_vehiculos_ingresados.tabla.getValueAt(fila, 4).toString();
            String motivo = listar_vehiculos_ingresados.tabla.getValueAt(fila, 5).toString();
            String precio_lavado = listar_vehiculos_ingresados.tabla.getValueAt(fila, 6).toString();

            editar_ingreso.txt_codigo.setText(codigo);
            editar_ingreso.txt_propietario.setText(propietario);
            editar_ingreso.txt_placa.setText(placa);
            editar_ingreso.combo_vehiculos.setSelectedItem(tipo);
            editar_ingreso.combo_motivo.setSelectedItem(motivo);

            boolean visible = true;
            if (motivo.equalsIgnoreCase("Parqueo")) {

                visible = false;
                precio_lavado = "";
            }
            editar_ingreso.txt_precio_lavado.setText(precio_lavado);
            editar_ingreso.txt_precio_lavado.setVisible(visible);

            ///editar_ingreso.btn_actualizar_vehiculo.setEnabled(true); //x seguridad , 
            listar_vehiculos_ingresados.dispose();

            editar_ingreso.setLocationRelativeTo(null);

            editar_ingreso.setLocation(fuentes_Y_mas.centrar_Pantalla(editar_ingreso.getWidth()), 130);
            editar_ingreso.btn_actualizar_vehiculo.setEnabled(false);
            editar_ingreso.setVisible(true);

        }

    }

    private void Actualizar_Ingreso() {

        String codigo = editar_ingreso.txt_codigo.getText();
        String propietario = editar_ingreso.txt_propietario.getText().trim();
        String placa = editar_ingreso.txt_placa.getText().trim();
        String tipo = editar_ingreso.combo_vehiculos.getSelectedItem().toString();
        String motivo = editar_ingreso.combo_motivo.getSelectedItem().toString().trim();
        String precio_lavado = editar_ingreso.txt_precio_lavado.getText().trim();
        String precio_parqueo = "Por definir";

        switch (motivo) {

            case "Parqueo":
                precio_lavado = "Ninguna";

                break;
            case "Lavado":
                precio_parqueo = "Ninguna";

                break;

        }
        modelo_nuevo.setCodigo(codigo);
        modelo_nuevo.setPropietario(propietario);
        modelo_nuevo.setPlaca(placa);
        modelo_nuevo.setTipo_vehiculo(tipo);
        modelo_nuevo.setMotivo_Ingreso(motivo);
        modelo_nuevo.setPrecio_lavado(precio_lavado);
        modelo_nuevo.setPrecio_parqueo(precio_parqueo);

        Color color = Color.ORANGE;
        String sms = "Error ,Intentelo mas Tarde";
        // ImageIcon icon = iconos.getIcono_alerta();

        boolean estado = true;
        if (!motivo.equalsIgnoreCase("Parqueo")) {

            if (editar_ingreso.txt_precio_lavado.getText().trim().isEmpty()) {
                //PARA ASEGURAR QUE EL TXT DEL PRECIO DEL LAVADO ESTE LLEVNO
                estado = false;
                sms = "Ingresa el precio para el lavado";
            }

        }

        if (estado) {

            if (crud_primero.Actulizar_Datos_Ingreso_Vehiculo(modelo_nuevo)) {
                sms = "Datos Actualizados con exito";
                color = Color.GREEN;
                ///   icon = iconos.getIcono_visto();

            }
            ///mensajes.getAceptar(editar_ingreso, sms, icon);

        }
        controlador_sms.Iniciar_Componentes(sms, color);

        if (estado) {
            editar_ingreso.dispose();
            Iniciar_Componentes();
        }

    }

    private void Evento_Click() {

        MouseListener evento_mouse = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int columnas = listar_vehiculos_ingresados.tabla.getColumnModel().getColumnIndexAtX(e.getX());

                if (listar_vehiculos_ingresados.tabla.getRowCount() >= 0) {
                    int filas = e.getY() / listar_vehiculos_ingresados.tabla.getRowHeight();
                    if (filas < listar_vehiculos_ingresados.tabla.getRowCount() && filas >= 0 && columnas < listar_vehiculos_ingresados.tabla.getColumnModel().getColumnCount() && columnas >= 0) {
                        Object value = listar_vehiculos_ingresados.tabla.getValueAt(filas, columnas);

                        if (value instanceof JButton) {
                            ((JButton) value).doClick();
                            JButton boton = (JButton) value;

                            if (boton.getName().equalsIgnoreCase("Cancelar")) {

                                Cancelar_Ingreso();
                            }
                            if (boton.getName().equalsIgnoreCase("Editar")) {
                                Editar();

                            }

                        } else {

                            int click = e.getClickCount();

                            if (click == 2) {

                                String placa = listar_vehiculos_ingresados.tabla.getValueAt(listar_vehiculos_ingresados.tabla.getSelectedRow(), 3).toString();

                                listar_vehiculos_ingresados.dispose();
                                controlador_retirar_vehiculo.Iniciar_Componentes(false, placa);

                            }

                        }

                    }

                }

            }

        };
        listar_vehiculos_ingresados.tabla.addMouseListener(evento_mouse);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == editar_ingreso.btn_regresar) {

            editar_ingreso.dispose();
            Iniciar_Componentes();

        } else if (e.getSource() == editar_ingreso.btn_actualizar_vehiculo) {

            Actualizar_Ingreso();

        } else if (e.getSource() != editar_ingreso.btn_regresar && e.getSource() != editar_ingreso.btn_actualizar_vehiculo) {

            //0: filtrar
            //1: restablecer datos
            int filtrar = 1;

            if (e.getSource() == listar_vehiculos_ingresados.btn_filtrar) {
                filtrar = 0;

                //tomo las fechas de los calendarios y le paso a unos metodos del modelo
                Tomar_Fecha();

            }
            Cargar_Tabla(filtrar);

            if (filtrar == 1) {

                Poner_Horas();
            }

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

        if (e.getSource() == editar_ingreso.txt_placa || e.getSource() == listar_vehiculos_ingresados.txt_listar) {

            if (e.getKeyChar() == ' ') {
                e.consume();
            }

        }

        char letra = e.getKeyChar();

        if (Character.isLowerCase(letra) && Character.isAlphabetic(letra)) {

            String mayusculas = ("" + letra).toUpperCase();

            letra = mayusculas.charAt(0);
            e.setKeyChar(letra);

        }

        if (e.getSource() == editar_ingreso.txt_propietario) {

            if ((letra < 'A' || letra > 'Z') && (letra != ' ')) {

                e.consume();
            }

        }

        if (e.getSource() == editar_ingreso.txt_precio_lavado) {

            letra = e.getKeyChar();
            //PARA QUE EL PRIMER CARACTER ESE TEXT NO SEA UN PUNTO
            if (editar_ingreso.txt_precio_lavado.getText().length() == 0 && letra == '.') {

                e.consume();
            }

            if ((letra < '0' || letra > '9') && (letra != '.')) {
                e.consume();
            }

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyChar() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DOWN) {

            if (e.getSource() == editar_ingreso.txt_placa) {
                editar_ingreso.txt_propietario.requestFocus();

            }

            if (e.getSource() == listar_vehiculos_ingresados.txt_listar) {

                if (listar_vehiculos_ingresados.tabla.getRowCount() > 0) {

                    listar_vehiculos_ingresados.tabla.requestFocus();

                    listar_vehiculos_ingresados.tabla.setRowSelectionInterval(0, 0);

                }

            }

        }

        if (e.getSource() == editar_ingreso.txt_propietario) {

            if (e.getKeyCode() == KeyEvent.VK_UP) {

                editar_ingreso.txt_placa.requestFocus();
            }

        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

            if (e.getSource() == listar_vehiculos_ingresados.tabla) {

                String texto = listar_vehiculos_ingresados.txt_listar.getText().trim(); // si la caj de texto esta vacia quiere decir que la tabla esta cargafa
                //no es necesrio cargarla nuevamente

                if (!texto.isEmpty()) {
                    listar_vehiculos_ingresados.txt_listar.setText("");

                    // foco del reder , para que se deseleccionadoo
                    Cargar_Tabla(1);

                }
                Cargar_Tabla(1);

                listar_vehiculos_ingresados.txt_listar.requestFocus();

            }

        }

        if (e.getSource() == listar_vehiculos_ingresados.tabla) {

            if (e.getKeyChar() == KeyEvent.VK_ENTER) {

                Editar();

            }

            if (e.getKeyCode() == 127 || e.getKeyCode() == 8) {
                Cancelar_Ingreso();

            }

            if (e.getKeyCode() == KeyEvent.VK_C) {

                String placa = listar_vehiculos_ingresados.tabla.getValueAt(listar_vehiculos_ingresados.tabla.getSelectedRow(), 3).toString();

                listar_vehiculos_ingresados.dispose();
                controlador_retirar_vehiculo.Iniciar_Componentes(false, placa);

            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getSource() == listar_vehiculos_ingresados.txt_listar) {

            modelo_nuevo.getFiltrar_filas().setRowFilter(RowFilter.regexFilter(listar_vehiculos_ingresados.txt_listar.getText(), 3));
        }

        if (e.getSource() == editar_ingreso.txt_propietario || e.getSource() == editar_ingreso.txt_placa) {

            boolean estado = getLongitud();

            editar_ingreso.btn_actualizar_vehiculo.setEnabled(estado);

        }

        if (e.getSource() == editar_ingreso.txt_precio_lavado) {

            boolean estado = false;
            if (!editar_ingreso.txt_precio_lavado.getText().isEmpty() && getLongitud()) {
                estado = true;

            }
            editar_ingreso.btn_actualizar_vehiculo.setEnabled(estado);

        }

    }

    private boolean getLongitud() {

        int txt_placa = editar_ingreso.txt_placa.getText().trim().length();
        int txt_propietario = editar_ingreso.txt_propietario.getText().trim().length();

        return txt_placa > 3 && txt_propietario > 1;

    }

    @Override
    public void insertUpdate(DocumentEvent e) {
//        boolean estado = getLongitud();
//
//        editar_ingreso.btn_actualizar_vehiculo.setEnabled(estado);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
////        boolean estado = getLongitud();
////
////        editar_ingreso.btn_actualizar_vehiculo.setEnabled(estado);

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

        boolean estado = getLongitud();

        editar_ingreso.btn_actualizar_vehiculo.setEnabled(estado);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        ///Tenia esa duda con el combo , xq pensaba que 
        //hiba a tener ese problema  como cuando es el actionListener, cuando remuevo 
        //todos los items ,pero no fue asi
        if (e.getSource() == editar_ingreso.combo_motivo) {
            boolean visible = true;
            if (editar_ingreso.combo_motivo.getSelectedIndex() == 0) {
                visible = false;

            }
            editar_ingreso.txt_precio_lavado.setVisible(visible);

        }
        boolean estado = getLongitud();

        editar_ingreso.btn_actualizar_vehiculo.setEnabled(estado);

    }

}
