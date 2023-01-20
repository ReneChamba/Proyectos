package controlador;

import java.awt.Color;
import vista.Apariencia;
import modelo.Modelo_Colores;
import modelo.Crud_Primero;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import mensajes.Joption;
import modelo.Fuentes_Y_Mas;
import modelo.Iconos;

public class Controlador_Apariencia implements MouseListener, WindowListener, ItemListener {

    private Apariencia apariencia;
    private Modelo_Colores modelo_colores;
    private Crud_Primero crud_primero;
    private Controlador_Menu_Principal controlador_menu_principal;
    private Fuentes_Y_Mas fuentes_Y_mas;
    private Joption mensajes;
    private Iconos iconos;
    private Controlador_Sms controlador_sms;

    public Controlador_Apariencia() {

    }

    public void setApariencia(Apariencia apariencia) {
        this.apariencia = apariencia;
    }

    public void setModelo_Colores(Modelo_Colores modelo_colores) {
        this.modelo_colores = modelo_colores;
    }

    public void setCrud_Primero(Crud_Primero crud_primero) {
        this.crud_primero = crud_primero;
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

    public void Estados_Contructor() {

        apariencia.btn_texto.addMouseListener(this);
        apariencia.btn_fondos.addMouseListener(this);
        apariencia.btn_bordes.addMouseListener(this);
        apariencia.btn_aplicar_cambios.addMouseListener(this);
        apariencia.btn_cancelar.addMouseListener(this);
        apariencia.btn_resetear.addMouseListener(this);

        //////////////////
        apariencia.combo_txt_menu.addItemListener(this);
        apariencia.combo_txt_submenu.addItemListener(this);
        apariencia.combo_txt_empresa.addItemListener(this);

        apariencia.combo_fondo_pantalla.addItemListener(this);
        apariencia.combo_fondo_menu.addItemListener(this);
        apariencia.combo_fondo_herramientas.addItemListener(this);
        apariencia.combo_fondo_estado.addItemListener(this);
        apariencia.combo_fondo_fun_herramientas.addItemListener(this);
        apariencia.combo_fondo_fun_estado.addItemListener(this);

        apariencia.combo_borde_herramientas.addItemListener(this);
        apariencia.combo_borde_estado.addItemListener(this);

        apariencia.addWindowListener(this);

        validacion = false;

        //==================================================================
        operacion = 0;

        Diseno();
        Llenar_Combos();
        Enabled_Funciones(false);
        Enabled_text(false);
        Enabled_Combos_Fondos(false);
        Enabled_Combos_Bordes(false);
        apariencia.btn_aplicar_cambios.setEnabled(false);
        apariencia.setResizable(false);
        apariencia.setTitle(fuentes_Y_mas.getTitulo());

    }

    private void Diseno() {

        apariencia.lb_titulo.setFont(fuentes_Y_mas.getLetra_Titulos());

        apariencia.jLabel10.setFont(fuentes_Y_mas.getLetra_label());
        apariencia.jLabel11.setFont(fuentes_Y_mas.getLetra_label());
        apariencia.jLabel12.setFont(fuentes_Y_mas.getLetra_label());
        apariencia.jLabel13.setFont(fuentes_Y_mas.getLetra_label());
        apariencia.jLabel2.setFont(fuentes_Y_mas.getLetra_label());
        apariencia.jLabel3.setFont(fuentes_Y_mas.getLetra_label());
        apariencia.jLabel4.setFont(fuentes_Y_mas.getLetra_label());
        apariencia.jLabel5.setFont(fuentes_Y_mas.getLetra_label());
        apariencia.jLabel6.setFont(fuentes_Y_mas.getLetra_label());
        apariencia.jLabel8.setFont(fuentes_Y_mas.getLetra_label());
        apariencia.jLabel9.setFont(fuentes_Y_mas.getLetra_label());

        //================================================================
        apariencia.combo_borde_estado.setFont(fuentes_Y_mas.getLetra_Txt());
        apariencia.combo_borde_estado.setFont(fuentes_Y_mas.getLetra_Txt());
        apariencia.combo_fondo_estado.setFont(fuentes_Y_mas.getLetra_Txt());
        apariencia.combo_fondo_fun_estado.setFont(fuentes_Y_mas.getLetra_Txt());
        apariencia.combo_fondo_fun_herramientas.setFont(fuentes_Y_mas.getLetra_Txt());
        apariencia.combo_fondo_herramientas.setFont(fuentes_Y_mas.getLetra_Txt());
        apariencia.combo_fondo_menu.setFont(fuentes_Y_mas.getLetra_Txt());
        apariencia.combo_fondo_pantalla.setFont(fuentes_Y_mas.getLetra_Txt());
        apariencia.combo_txt_empresa.setFont(fuentes_Y_mas.getLetra_Txt());
        apariencia.combo_txt_menu.setFont(fuentes_Y_mas.getLetra_Txt());
        apariencia.combo_txt_submenu.setFont(fuentes_Y_mas.getLetra_Txt());

        apariencia.combo_borde_estado.setCursor(fuentes_Y_mas.getCursor());
        apariencia.combo_borde_estado.setCursor(fuentes_Y_mas.getCursor());
        apariencia.combo_fondo_estado.setCursor(fuentes_Y_mas.getCursor());
        apariencia.combo_fondo_fun_estado.setCursor(fuentes_Y_mas.getCursor());
        apariencia.combo_fondo_fun_herramientas.setCursor(fuentes_Y_mas.getCursor());
        apariencia.combo_fondo_herramientas.setCursor(fuentes_Y_mas.getCursor());
        apariencia.combo_fondo_menu.setCursor(fuentes_Y_mas.getCursor());
        apariencia.combo_fondo_pantalla.setCursor(fuentes_Y_mas.getCursor());
        apariencia.combo_txt_empresa.setCursor(fuentes_Y_mas.getCursor());
        apariencia.combo_txt_menu.setCursor(fuentes_Y_mas.getCursor());
        apariencia.combo_txt_submenu.setCursor(fuentes_Y_mas.getCursor());

        //===================================================================0
        apariencia.btn_aplicar_cambios.setFont(fuentes_Y_mas.getLetra_btn());
        apariencia.btn_bordes.setFont(fuentes_Y_mas.getLetra_btn());
        apariencia.btn_cancelar.setFont(fuentes_Y_mas.getLetra_btn());
        apariencia.btn_fondos.setFont(fuentes_Y_mas.getLetra_btn());
        apariencia.btn_resetear.setFont(fuentes_Y_mas.getLetra_btn());
        apariencia.btn_texto.setFont(fuentes_Y_mas.getLetra_btn());

        apariencia.btn_aplicar_cambios.setCursor(fuentes_Y_mas.getCursor());
        apariencia.btn_bordes.setCursor(fuentes_Y_mas.getCursor());
        apariencia.btn_cancelar.setCursor(fuentes_Y_mas.getCursor());
        apariencia.btn_fondos.setCursor(fuentes_Y_mas.getCursor());
        apariencia.btn_resetear.setCursor(fuentes_Y_mas.getCursor());
        apariencia.btn_texto.setCursor(fuentes_Y_mas.getCursor());

        apariencia.btn_aplicar_cambios.setIcon(iconos.getIcono_guardar());
        apariencia.btn_bordes.setIcon(iconos.getIcono_editar());
        apariencia.btn_cancelar.setIcon(iconos.getIcono_cancelar());
        apariencia.btn_fondos.setIcon(iconos.getIcono_editar());
        apariencia.btn_resetear.setIcon(iconos.getIcono_actualizar());
        apariencia.btn_texto.setIcon(iconos.getIcono_editar());

        //==================================================
        apariencia.lb_titulo.setForeground(fuentes_Y_mas.getColor_titulo());
        apariencia.btn_aplicar_cambios.setForeground(fuentes_Y_mas.getColor_letra_btn());
        apariencia.btn_cancelar.setForeground(fuentes_Y_mas.getColor_letra_btn());
        apariencia.btn_resetear.setForeground(fuentes_Y_mas.getColor_letra_btn());

        apariencia.btn_aplicar_cambios.setBackground(fuentes_Y_mas.getColor_Fondo_btn());
        apariencia.btn_bordes.setBackground(fuentes_Y_mas.getColor_Fondo_btn());
        apariencia.btn_cancelar.setBackground(fuentes_Y_mas.getColor_Fondo_btn());
        apariencia.btn_fondos.setBackground(fuentes_Y_mas.getColor_Fondo_btn());
        apariencia.btn_resetear.setBackground(fuentes_Y_mas.getColor_Fondo_btn());
        apariencia.btn_texto.setBackground(fuentes_Y_mas.getColor_Fondo_btn());

        //==============================================================
        apariencia.panel_TextoColores.setBorder(fuentes_Y_mas.getBorder("Color Texto", Color.BLACK));
        apariencia.panel_fondos.setBorder(fuentes_Y_mas.getBorder("Color Fondos", Color.BLACK));
        apariencia.panel_bordes.setBorder(fuentes_Y_mas.getBorder("Color Bordes", Color.BLACK));

    }

    public void Iniciar_Componentes() {

        apariencia.setLocation(fuentes_Y_mas.centrar_Pantalla(apariencia.getWidth()), 130);
        apariencia.setVisible(true);
    }

    public void setControlador_Menu_Principal(Controlador_Menu_Principal controlador_menu_principal) {
        this.controlador_menu_principal = controlador_menu_principal;

    }

    private void Llenar_Combos() {

        //CARGAR COLORES DE LOS COMBOS
        modelo_colores.setCombo_text_menu(apariencia.combo_txt_menu);
        modelo_colores.setCombo_text_subMenu(apariencia.combo_txt_submenu);
        modelo_colores.setCombo_text_Empresa(apariencia.combo_txt_empresa);

        modelo_colores.setCombo_fondo_pantalla(apariencia.combo_fondo_pantalla);
        modelo_colores.setCombo_fondo_menu(apariencia.combo_fondo_menu);
        modelo_colores.setCombo_fondo_herramientas(apariencia.combo_fondo_herramientas);
        modelo_colores.setCombo_fondo_estado(apariencia.combo_fondo_estado);
        modelo_colores.setCombo_fondo_func_herramientas(apariencia.combo_fondo_fun_herramientas);
        modelo_colores.setCombo_fondo_func_estado(apariencia.combo_fondo_fun_estado);

        modelo_colores.setCombo_borde_herramientas(apariencia.combo_borde_herramientas);
        modelo_colores.setCombo_borde_estado(apariencia.combo_borde_estado);

        crud_primero.Cargar_Combos_Colores(modelo_colores);

    }

    private void Enabled_text(boolean estado) {

        apariencia.combo_txt_submenu.setEnabled(estado);
        apariencia.combo_txt_menu.setEnabled(estado);
        apariencia.combo_txt_empresa.setEnabled(estado);
    }

    private void Enabled_Funciones(boolean estado) {

        apariencia.btn_cancelar.setEnabled(estado);
        apariencia.btn_resetear.setEnabled(estado);

    }

    private void Botones_Editar(boolean estado) {

        apariencia.btn_texto.setEnabled(estado);
        apariencia.btn_fondos.setEnabled(estado);
        apariencia.btn_bordes.setEnabled(estado);

    }

    private void Enabled_Combos_Fondos(boolean estado) {

        apariencia.combo_fondo_pantalla.setEnabled(estado);
        apariencia.combo_fondo_menu.setEnabled(estado);
        apariencia.combo_fondo_herramientas.setEnabled(estado);
        apariencia.combo_fondo_estado.setEnabled(estado);
        apariencia.combo_fondo_fun_herramientas.setEnabled(estado);
        apariencia.combo_fondo_fun_estado.setEnabled(estado);

    }

    private void Enabled_Combos_Bordes(boolean estado) {

        apariencia.combo_borde_herramientas.setEnabled(estado);
        apariencia.combo_borde_estado.setEnabled(estado);

    }

    private void Resetear() {

        if (apariencia.btn_resetear.isEnabled()) {

            Aplicar_Cambios(true);

        }

    }

    private void Cancelar(boolean restablece_color) {

        boolean texto = false;
        boolean fondo = false;
        boolean bordes = false;

        if (apariencia.btn_cancelar.isEnabled()) { // solo si esta habilitaod que haga eso , tenia el problema de que asi este 
            //bloqueado el boton ejecutaba el evento
            switch (operacion) {
                case 0:
                    Enabled_text(false);
                    texto = true;
                    break;
                case 1:
                    Enabled_Combos_Fondos(false);
                    fondo = true;
                    break;
                case 2:
                    Enabled_Combos_Bordes(false);
                    bordes = true;
                    break;
                default:
                    break;
            }

            if (restablece_color) { //Cuando ejecuto el metodo aplicar Cambiso llamo a este metodo Cancelar, pero no es cesariio restablecer
                // los colores , x eso esta validacio, solo cuando sea llamdo desde el boton cancelar o desde la X del formulario le paso true
                // a este metodo y hay si ingresa aki y restablece los colores del panel activado , combos que fueron habilitados

                // esto es metedo que determina que valore colorear , siempre y cuado su valor sea tru
                controlador_menu_principal.Poner_Colores(texto, fondo, bordes);
            }

            Enabled_Funciones(false);
            Botones_Editar(true);

            //este metodo es importante cuando lo llame desde el boton de cancelar , xq ocultara la ventana,
            //pero cuando sea llamado desde el evento windowClosing() , no pasa nada va a tomar prioridad el evento dispose
            // de la ventanaa
            apariencia.dispose();

        }

    }

    private void Aplicar_Cambios(boolean resetear) {

        Color color = fuentes_Y_mas.getColor_Mal();
        if (apariencia.btn_resetear.isEnabled()) { // solo cuando este habilotado, xq respondia a el evetno asi este bloqueado
            //por eso esta validacion, pero tomo como referencia ese boton, x el evetno itemchange
            String sms = "No se pudo actualizar ,intentelo mas tarde";
            switch (operacion) {
                case 0:
                    //editar texto

                    //resetear true, para resetear , false para aplicar cambios
                    if (resetear) {

                        color_txt_menu = "Predeterminado";
                        color_text_submenu = "Predeterminado";
                        color_text_empresa = "Predeterminado";

                    } else {

                        color_txt_menu = apariencia.combo_txt_menu.getSelectedItem().toString();
                        color_text_submenu = apariencia.combo_txt_submenu.getSelectedItem().toString();
                        color_text_empresa = apariencia.combo_txt_empresa.getSelectedItem().toString();
                    }

                    modelo_colores.setColor_txt_menu(color_txt_menu);
                    modelo_colores.setColor_text_submenu(color_text_submenu);
                    modelo_colores.setColor_text_empresa(color_text_empresa);
                    break;
                case 1:
                    //editar fondo

                    if (resetear) {

                        color_fondo_pantalla = "Predeterminado";
                        color_fondo_barra_menu = "Predeterminado";
                        color_fondo_barra_herramientas = "Predeterminado";
                        color_fondo_barra_estado = "Predeterminado";
                        color_fun_barra_herramientas = "Predeterminado";
                        color_fun_barra_estado = "Predeterminado";

                    } else {

                        color_fondo_pantalla = apariencia.combo_fondo_pantalla.getSelectedItem().toString();
                        color_fondo_barra_menu = apariencia.combo_fondo_menu.getSelectedItem().toString();
                        color_fondo_barra_herramientas = apariencia.combo_fondo_herramientas.getSelectedItem().toString();
                        color_fondo_barra_estado = apariencia.combo_fondo_estado.getSelectedItem().toString();
                        color_fun_barra_herramientas = apariencia.combo_fondo_fun_herramientas.getSelectedItem().toString();
                        color_fun_barra_estado = apariencia.combo_fondo_fun_estado.getSelectedItem().toString();

                    }

                    modelo_colores.setColor_fondo_pantalla(color_fondo_pantalla);
                    modelo_colores.setColor_fondo_barra_menu(color_fondo_barra_menu);
                    modelo_colores.setColor_fondo_barra_herramientas(color_fondo_barra_herramientas);
                    modelo_colores.setColor_fondo_barra_estado(color_fondo_barra_estado);
                    modelo_colores.setColor_fun_barra_herramientas(color_fun_barra_herramientas);
                    modelo_colores.setColor_fun_barra_estado(color_fun_barra_estado);
                    break;
                case 2:
                    // editar bordes

                    if (resetear) {
                        color_borde_barra_herramientas = "Predeterminado";
                        color_borde_barra_estado = "Predeterminado";

                    } else {

                        color_borde_barra_herramientas = apariencia.combo_borde_herramientas.getSelectedItem().toString();
                        color_borde_barra_estado = apariencia.combo_borde_estado.getSelectedItem().toString();
                    }

                    modelo_colores.setColor_borde_barra_herramientas(color_borde_barra_herramientas);
                    modelo_colores.setColor_borde_barra_estado(color_borde_barra_estado);
                    break;
                default:
                    break;
            }

            if (crud_primero.Actualizar_Colores_Nombres_Funciones(modelo_colores, operacion)) {

                color = fuentes_Y_mas.getColor_Bien();
                sms = "Operación realizada con exito";

                //actalizo el valor de las varibale de los nombre , para que cuando abria esta ventana, seleccione el item dl nuevo color actualizado
                controlador_menu_principal.Inicializar_Variables_Color_Funciones();

            }

            controlador_sms.Iniciar_Componentes(sms, color);

            Cancelar(resetear); /// bloqueara los combos respectivos pero no sera necesario carga los colores, ver la explicacion en ese metodo
            //pero cuando le paso resetear = false, osea lo llamo desde el btn resetear hay si que aplica los colores en los controles
        }

    }

    public void Asignar_Nombre_Color_Funciones(String color_txt_menu, String color_text_submenu, String color_text_empresa, String color_fondo_pantalla,
            String color_fondo_barra_menu, String color_fondo_barra_herramientas, String color_fondo_barra_estado,
            String color_fun_barra_herramientas, String color_fun_barra_estado, String color_borde_barra_herramientas,
            String color_borde_barra_estado) {

        apariencia.combo_txt_menu.setSelectedItem(color_txt_menu);

        apariencia.combo_txt_submenu.setSelectedItem(color_text_submenu);

        apariencia.combo_txt_empresa.setSelectedItem(color_text_empresa);

        apariencia.combo_fondo_pantalla.setSelectedItem(color_fondo_pantalla);
        apariencia.combo_fondo_menu.setSelectedItem(color_fondo_barra_menu);
        apariencia.combo_fondo_herramientas.setSelectedItem(color_fondo_barra_herramientas);
        apariencia.combo_fondo_estado.setSelectedItem(color_fondo_barra_estado);
        apariencia.combo_fondo_fun_herramientas.setSelectedItem(color_fun_barra_herramientas);
        apariencia.combo_fondo_fun_estado.setSelectedItem(color_fun_barra_estado);

        apariencia.combo_borde_herramientas.setSelectedItem(color_borde_barra_herramientas);
        apariencia.combo_borde_estado.setSelectedItem(color_borde_barra_estado);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        /*
        
        Voy a tomar como referencia un boton de editar , que va servir para la validacionde los 3 botones
        si esta habilitado desecandeno el evento en cualquiera de los 3 botones que esta asociados a este evento mouseClicked
         */
        Object control = e.getSource();

        if (control == apariencia.btn_texto || control == apariencia.btn_fondos || control == apariencia.btn_bordes) {

            if (apariencia.btn_aplicar_cambios.isEnabled() == false) { //cuando este bloqueados los botones de funciones , que haga esto 

                if (control == apariencia.btn_texto) {
                    operacion = 0;
                    Enabled_text(true);

                }
                if (control == apariencia.btn_fondos) {
                    operacion = 1;
                    Enabled_Combos_Fondos(true);
                }
                if (control == apariencia.btn_bordes) {
                    operacion = 2;
                    Enabled_Combos_Bordes(true);
                }
                //Metodos compartidos por los 3 botones
                Botones_Editar(false);

                Enabled_Funciones(true);
            }

        }

        //====================================================================
        if (control == apariencia.btn_aplicar_cambios) {

            if (apariencia.btn_aplicar_cambios.isEnabled()) {
                Aplicar_Cambios(false);
                apariencia.btn_aplicar_cambios.setEnabled(false);

            }

        }
        //================================================================

        if (control == apariencia.btn_cancelar) {

            Cancelar(true);
            apariencia.btn_aplicar_cambios.setEnabled(false);

        }

        if (control == apariencia.btn_resetear) {

            Resetear();

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

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {

        Cancelar(true);
        apariencia.btn_aplicar_cambios.setEnabled(false);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {

        validacion = true;
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        validacion = false;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        /*
        Cuando se ejecuta el constructor de esta clase , se ejecuta un metodo que 
        llena los combos con los colores ,  me voy al crud y le paso el resultado de esa consulta 
        al modelo que se encarga de rrecore el resulset y llenar los combo , previamente le paso los combos al modelo
        ,al momento que en el modelo utilzo el metood addItem() , se ejecuta automaticamente este metodo,
        es por eso que hago esta validacion, la variable validacion la inicio como falso , cuando este activa la ventana  cambia  true y cuando
        se desactiva la ventana cambia a false
         */
        if (validacion) {

            Object control = e.getSource();

            if (control == apariencia.combo_txt_menu) {

                controlador_menu_principal.Color_Texto_Menu(apariencia.combo_txt_menu.getSelectedItem().toString());
            } else if (control == apariencia.combo_txt_submenu) {

                controlador_menu_principal.Color_texto_SubMenu(apariencia.combo_txt_submenu.getSelectedItem().toString());
            } else if (control == apariencia.combo_txt_empresa) {

                controlador_menu_principal.Color_texto_Titulo(apariencia.combo_txt_empresa.getSelectedItem().toString());
            } //================================================
            else if (control == apariencia.combo_fondo_pantalla) {

                controlador_menu_principal.Color_FondoPantalla(apariencia.combo_fondo_pantalla.getSelectedItem().toString());
            } else if (control == apariencia.combo_fondo_menu) {

                controlador_menu_principal.Color_Fondo_Barra_Menu(apariencia.combo_fondo_menu.getSelectedItem().toString());
            } else if (control == apariencia.combo_fondo_herramientas) {

                controlador_menu_principal.Color_Fondo_Barra_Herramientas(apariencia.combo_fondo_herramientas.getSelectedItem().toString());
            } else if (control == apariencia.combo_fondo_estado) {

                controlador_menu_principal.Color_Fondo_Barra_Estado(apariencia.combo_fondo_estado.getSelectedItem().toString());
            } else if (control == apariencia.combo_fondo_fun_herramientas) {

                controlador_menu_principal.Color_Botones_Funciones_Herramienras(apariencia.combo_fondo_fun_herramientas.getSelectedItem().toString());
            } else if (control == apariencia.combo_fondo_fun_estado) {

                controlador_menu_principal.Color_Botones_Funciones_Estado(apariencia.combo_fondo_fun_estado.getSelectedItem().toString());

            } else if (control == apariencia.combo_borde_herramientas) {

                controlador_menu_principal.Color_Borde_Herramientas(apariencia.combo_borde_herramientas.getSelectedItem().toString());

            } else if (control == apariencia.combo_borde_estado) {

                controlador_menu_principal.COlor_Borde_Estado(apariencia.combo_borde_estado.getSelectedItem().toString());

            }

            apariencia.btn_aplicar_cambios.setEnabled(true);
        }

    }

    private int operacion;

    private String color_txt_menu;
    private String color_text_submenu;
    private String color_text_empresa;

    private String color_fondo_pantalla;
    private String color_fondo_barra_menu;
    private String color_fondo_barra_herramientas;
    private String color_fondo_barra_estado;
    private String color_fun_barra_herramientas;
    private String color_fun_barra_estado;

    private String color_borde_barra_herramientas;
    private String color_borde_barra_estado;

    private boolean validacion;

}
