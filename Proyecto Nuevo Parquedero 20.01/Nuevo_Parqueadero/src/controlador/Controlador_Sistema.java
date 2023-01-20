package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import mensajes.Joption;
import modelo.Crud_Primero;
import modelo.Fuentes_Y_Mas;
import modelo.Iconos;
import modelo.Modelo_Sistema;
import vista.Sistemas;

public class Controlador_Sistema implements ActionListener, KeyListener, DocumentListener, ItemListener {
    
    private Sistemas sistema;
    private Crud_Primero crud_primero;
    private Modelo_Sistema modelo_sistema;
    private Controlador_Menu_Principal controlador_menu_principal;
    private Fuentes_Y_Mas fuentes_Y_mas;
    private Joption mensajes;
    private Iconos iconos;
    private Controlador_Sms controlador_sms;
    
    public Controlador_Sistema() {
        
    }
    
    public void setControlador_Menu_Principal(Controlador_Menu_Principal controlador_Menu_Principal) {
        
        this.controlador_menu_principal = controlador_Menu_Principal;
        
    }
    
    public void setSistema(Sistemas sistemas) {
        this.sistema = sistemas;
    }
    
    public void setModelo_Sistema(Modelo_Sistema modelo_sistema) {
        
        this.modelo_sistema = modelo_sistema;
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
        sistema.btn_aplicar.addActionListener(this);
        sistema.btn_cancelar.addActionListener(this);
        
        sistema.txt_inicio.addKeyListener(this);
        sistema.txt_funciones.addKeyListener(this);
        sistema.txt_configuracion.addKeyListener(this);
        sistema.txt_sistema.addKeyListener(this);
        sistema.txt_respaldos.addKeyListener(this);
        sistema.txt_titulo.addKeyListener(this);

        //===========================================
        sistema.txt_titulo.getDocument().addDocumentListener(this);
        sistema.txt_configuracion.getDocument().addDocumentListener(this);
        sistema.txt_funciones.getDocument().addDocumentListener(this);
        sistema.txt_inicio.getDocument().addDocumentListener(this);
        sistema.txt_respaldos.getDocument().addDocumentListener(this);
        sistema.txt_sistema.getDocument().addDocumentListener(this);
        
        sistema.combo_estilo.addItemListener(this);
        sistema.combo_fuente.addItemListener(this);
        sistema.combo_tamano.addItemListener(this);
        
        sistema.setResizable(false);
        sistema.setTitle(fuentes_Y_mas.getTitulo());
        
        tipo_letra = "Dialog";
        estilo_letra = 0;
        tamano_letra = 12;
        validacio = false;
        Evento_Ventana();
        Diseno();
        sistema.btn_aplicar.setEnabled(false);//  interactura con el key releades , x eseguridad

    }
    
    public void Iniciar_Componentes() {
        sistema.setLocation(fuentes_Y_mas.centrar_Pantalla(sistema.getWidth()), 130);
        
        validacio = true;
        sistema.setVisible(true);
        
    }
    
    private void Diseno() {
        
        sistema.lb_titulo.setFont(fuentes_Y_mas.getLetra_Titulos());
        sistema.jLabel2.setFont(fuentes_Y_mas.getLetra_label());
        sistema.jLabel3.setFont(fuentes_Y_mas.getLetra_label());
        sistema.jLabel4.setFont(fuentes_Y_mas.getLetra_label());
        sistema.jLabel5.setFont(fuentes_Y_mas.getLetra_label());
        sistema.jLabel6.setFont(fuentes_Y_mas.getLetra_label());
        sistema.jLabel8.setFont(fuentes_Y_mas.getLetra_label());
        sistema.jLabel9.setFont(fuentes_Y_mas.getLetra_label());
        sistema.jLabel10.setFont(fuentes_Y_mas.getLetra_label());
        sistema.jLabel7.setFont(fuentes_Y_mas.getLetra_label());
        //=================================================================

        sistema.txt_configuracion.setFont(fuentes_Y_mas.getLetra_Txt());
        sistema.txt_funciones.setFont(fuentes_Y_mas.getLetra_Txt());
        sistema.txt_inicio.setFont(fuentes_Y_mas.getLetra_Txt());
        sistema.txt_respaldos.setFont(fuentes_Y_mas.getLetra_Txt());
        sistema.txt_sistema.setFont(fuentes_Y_mas.getLetra_Txt());
        sistema.txt_titulo.setFont(fuentes_Y_mas.getLetra_Txt());
        
        sistema.txt_configuracion.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        sistema.txt_funciones.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        sistema.txt_inicio.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        sistema.txt_respaldos.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        sistema.txt_sistema.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        sistema.txt_titulo.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        
        sistema.combo_estilo.setFont(fuentes_Y_mas.getLetra_Txt());
        sistema.combo_fuente.setFont(fuentes_Y_mas.getLetra_Txt());
        sistema.combo_tamano.setFont(fuentes_Y_mas.getLetra_Txt());
        
        sistema.btn_aplicar.setFont(fuentes_Y_mas.getLetra_btn());
        sistema.btn_cancelar.setFont(fuentes_Y_mas.getLetra_btn());
        
        sistema.btn_aplicar.setCursor(fuentes_Y_mas.getCursor());
        sistema.btn_cancelar.setCursor(fuentes_Y_mas.getCursor());
        sistema.btn_aplicar.setIcon(iconos.getIcono_guardar());
        sistema.btn_cancelar.setIcon(iconos.getIcono_cancelar());
        //===========================================================
        sistema.lb_titulo.setForeground(fuentes_Y_mas.getColor_titulo());
        sistema.btn_aplicar.setForeground(fuentes_Y_mas.getColor_letra_btn());
        sistema.btn_cancelar.setForeground(fuentes_Y_mas.getColor_letra_btn());
        sistema.btn_aplicar.setBackground(fuentes_Y_mas.getColor_Fondo_btn());
        sistema.btn_cancelar.setBackground(fuentes_Y_mas.getColor_Fondo_btn());
        
        sistema.panel_nombres_menu.setBorder(fuentes_Y_mas.getBorder("Nombres Menús", Color.BLACK));
        sistema.panel_editar_fuente.setBorder(fuentes_Y_mas.getBorder("Editar Fuente", Color.BLACK));
        sistema.panel_muestra_letra.setBorder(fuentes_Y_mas.getBorderlinea(Color.DARK_GRAY));
        
    }
    
    private void Evento_Ventana() {
        
        WindowAdapter evento = new WindowAdapter() {
            
            public void windowClosing(WindowEvent e) {
                
                sistema.btn_aplicar.setEnabled(false);
                validacio = false;
            }
            
        };
        sistema.addWindowListener(evento);
        
    }
    
    public void Poner_Nombre_Txt(String menu_inicio, String menu_funciones, String menu_configuracion,
            String menu_sistema, String menu_respaldos, String titulo, String tipo_letra, int estilo, int tamano) {
        
        sistema.txt_inicio.setText(menu_inicio);
        sistema.txt_funciones.setText(menu_funciones);
        sistema.txt_configuracion.setText(menu_configuracion);
        sistema.txt_sistema.setText(menu_sistema);
        sistema.txt_respaldos.setText(menu_respaldos);
        sistema.txt_titulo.setText(titulo);
        sistema.combo_fuente.setSelectedItem(tipo_letra);
        sistema.combo_estilo.setSelectedIndex(estilo);
        sistema.combo_tamano.setSelectedItem(String.valueOf(tamano));
        
    }
    
    private void Aplicar_Cambios() {
        
        String inicio = sistema.txt_inicio.getText().trim();
        String funciones = sistema.txt_funciones.getText().trim();
        String configuracion = sistema.txt_configuracion.getText().trim();
        String confi_sis = sistema.txt_sistema.getText().trim();
        String reportes = sistema.txt_respaldos.getText().trim();
        String titulo = sistema.txt_titulo.getText().trim();
        
        String tipo_fuente = sistema.combo_fuente.getSelectedItem().toString();
        String estilo = sistema.combo_estilo.getSelectedItem().toString();
        String tamano = sistema.combo_tamano.getSelectedItem().toString();
        
        modelo_sistema.setMenu_inicio(inicio);
        modelo_sistema.setMenu_funciones(funciones);
        modelo_sistema.setMenu_configuracion(configuracion);
        modelo_sistema.setMenu_sistema(confi_sis);
        modelo_sistema.setMenu_respaldos(reportes);
        modelo_sistema.setTitulo(titulo);
        modelo_sistema.setTipo_letra(tipo_fuente);
        modelo_sistema.setEstilo_fuente(estilo);
        modelo_sistema.setTamano_fuente(tamano);
        
        String sms = "Surguio un error, no se aplicarón los cambios";
        
        Color color = fuentes_Y_mas.getColor_Mal();
        
        if (crud_primero.Actualizar_Datos_Sistema(modelo_sistema)) {
            
            sms = "Cambios Aplicados con exito";
            controlador_menu_principal.Consulta_Nombres_Menus();
            color = fuentes_Y_mas.getColor_Bien();
            
        }
        controlador_sms.Iniciar_Componentes(sms, color);
        sistema.btn_aplicar.setEnabled(false);
        sistema.dispose();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object control = e.getSource();
        if (control == sistema.btn_aplicar) {
            
            Aplicar_Cambios();
        }
        
        if (control == sistema.btn_cancelar) {
            // 
            sistema.btn_aplicar.setEnabled(false);
            validacio = false;
            sistema.dispose();
            
        }
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DOWN) {
            
            Object control = e.getSource();
            if (control == sistema.txt_inicio) {
                
                sistema.txt_funciones.requestFocus();
            }
            
            if (control == sistema.txt_funciones) {
                
                sistema.txt_configuracion.requestFocus();
            }
            
            if (control == sistema.txt_configuracion) {
                
                sistema.txt_sistema.requestFocus();
            }
            
            if (control == sistema.txt_sistema) {
                
                sistema.txt_respaldos.requestFocus();
            }
            if (control == sistema.txt_respaldos) {
                
                sistema.txt_titulo.requestFocus();
            }
            
        }
        
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            
            Object control = e.getSource();
            
            if (control == sistema.txt_funciones) {
                
                sistema.txt_inicio.requestFocus();
            }
            
            if (control == sistema.txt_configuracion) {
                
                sistema.txt_funciones.requestFocus();
            }
            
            if (control == sistema.txt_sistema) {
                
                sistema.txt_configuracion.requestFocus();
            }
            if (control == sistema.txt_respaldos) {
                
                sistema.txt_sistema.requestFocus();
            }
            
            if (control == sistema.txt_titulo) {
                
                sistema.txt_respaldos.requestFocus();
            }
            
        }
        
    }
    
    private boolean Validar_Vacio() {

        //RETORNA TRUE SI TODO ES DIFERENTE DE VACIO
        return !sistema.txt_inicio.getText().isEmpty() && !sistema.txt_funciones.getText().isEmpty() && !sistema.txt_configuracion.getText().isEmpty()
                && !sistema.txt_sistema.getText().isEmpty() && !sistema.txt_respaldos.getText().isEmpty() && !sistema.txt_titulo.getText().isEmpty();
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
        sistema.btn_aplicar.setEnabled(Validar_Vacio());
        
    }
    
    private String tipo_letra;
    private int tamano_letra;
    private int estilo_letra;
    private Font letra = null;
    
    @Override
    public void insertUpdate(DocumentEvent e) {
    }
    
    @Override
    public void removeUpdate(DocumentEvent e) {
    }
    
    @Override
    public void changedUpdate(DocumentEvent e) {
        
        if (validacio) {
            
            sistema.btn_aplicar.setEnabled(true);
        }
        
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        
        if (validacio) {
            
            Object control = e.getSource();
            if (control == sistema.combo_fuente) {
                
                tipo_letra = sistema.combo_fuente.getSelectedItem().toString();
            }
            
            if (control == sistema.combo_estilo) {
                
                estilo_letra = sistema.combo_estilo.getSelectedIndex();
            }
            
            if (control == sistema.combo_tamano) {
                
                tamano_letra = Integer.parseInt(sistema.combo_tamano.getSelectedItem().toString());
            }
            letra = new Font(tipo_letra, estilo_letra, tamano_letra);
            sistema.lb_texto_prueba.setFont(letra);
            
            sistema.btn_aplicar.setEnabled(true);
        }
        
    }
    private boolean validacio;
    
}
