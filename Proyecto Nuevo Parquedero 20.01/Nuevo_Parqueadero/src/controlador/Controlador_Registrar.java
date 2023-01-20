package controlador;

import java.awt.Color;
import vista.Registrar;
import modelo.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import mensajes.Joption;

public class Controlador_Registrar implements ActionListener, KeyListener, FocusListener {
    
    private Registrar registrar;
    private Modelo_Nuevo modelo_nuevo;
    private Crud_Primero crud_primero;
    private Validacion_txt validacion_txt;
    private Iconos iconos;
    private Joption mensajes;
    private Fuentes_Y_Mas fuentes_Y_mas;
    private boolean validar_cuenta;
    private boolean validar_pass;
    private Controlador_Sms controlador_sms;
    
    public Controlador_Registrar() {
        
    }
    
    public void setRegistrar(Registrar registrar) {
        this.registrar = registrar;
    }
    
    public void setModelo_nuevo(Modelo_Nuevo modelo_nuevo) {
        this.modelo_nuevo = modelo_nuevo;
    }
    
    public void setCrud_Primero(Crud_Primero crud_primero) {
        this.crud_primero = crud_primero;
    }
    
    public void setValidacion_Txt(Validacion_txt validacion_txt) {
        this.validacion_txt = validacion_txt;
    }
    
    public void setIconos(Iconos iconos) {
        this.iconos = iconos;
    }
    
    public void setMensajes(Joption mensajes_2) {
        this.mensajes = mensajes_2;
    }
    
    public void setFuentes_Y_Mas(Fuentes_Y_Mas fuentes_Y_Mas) {
        this.fuentes_Y_mas = fuentes_Y_Mas;
    }
    
    public void setLanzar_Mensaje(Controlador_Sms controlador_sms) {
        this.controlador_sms = controlador_sms;
    }
    
    public void Estados_Constructor() {
        
        Diseno();
        opciones = new String[2];
        opciones[0] = "Crear Cuenta";
        opciones[1] = "Cancelar";

        //###################################################################################################
        registrar.btn_crear_cuenta.addActionListener(this);
        
        registrar.txt_cedula.addKeyListener(this);
        registrar.txt_nombre.addKeyListener(this);
        registrar.txt_cuenta.addKeyListener(this);
        registrar.txt_contrasena.addKeyListener(this);
        
        registrar.txt_cuenta.addFocusListener(this);
        registrar.txt_contrasena.addFocusListener(this);

        //#####################################################################################################
        Evento_Ventana();
        Estados_Textos(false);
        registrar.lb_cedula.setVisible(false);
        registrar.lb_cuenta.setVisible(false);
        registrar.lb_pass.setVisible(false);
        registrar.btn_crear_cuenta.setEnabled(false);
        
    }
    //========================================================================

    private void Diseno() {
        
        registrar.lb_titulo.setFont(fuentes_Y_mas.getLetra_Titulos());
        
        registrar.lb_name_cedula.setFont(fuentes_Y_mas.getLetra_label());
        registrar.lb_name_cuenta.setFont(fuentes_Y_mas.getLetra_label());
        registrar.lb_name_nombre.setFont(fuentes_Y_mas.getLetra_label());
        registrar.lb_name_pass.setFont(fuentes_Y_mas.getLetra_label());
        registrar.lb_name_tipo_cuenta.setFont(fuentes_Y_mas.getLetra_label());

        //=========================================================
        registrar.txt_cedula.setFont(fuentes_Y_mas.getLetra_Txt());
        registrar.txt_cuenta.setFont(fuentes_Y_mas.getLetra_Txt());
        registrar.txt_contrasena.setFont(fuentes_Y_mas.getLetra_Txt());
        registrar.txt_nombre.setFont(fuentes_Y_mas.getLetra_Txt());
        registrar.combo_tipos.setFont(fuentes_Y_mas.getLetra_Txt());

        //======================================================
        registrar.txt_cedula.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        registrar.txt_contrasena.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        registrar.txt_cuenta.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        registrar.txt_nombre.setHorizontalAlignment(fuentes_Y_mas.getHorientacion());
        //=======================================================

        registrar.btn_crear_cuenta.setCursor(fuentes_Y_mas.getCursor());
        registrar.combo_tipos.setCursor(fuentes_Y_mas.getCursor());
        
        registrar.btn_crear_cuenta.setFont(fuentes_Y_mas.getLetra_btn());
        
        registrar.lb_titulo.setForeground(fuentes_Y_mas.getColor_titulo());
        registrar.btn_crear_cuenta.setBackground(fuentes_Y_mas.getColor_Fondo_btn());
        registrar.btn_crear_cuenta.setForeground(fuentes_Y_mas.getColor_letra_btn());
        
    }
    
    public void Iniciar_Componentes() {
        
        registrar.setLocation(fuentes_Y_mas.centrar_Pantalla(registrar.getWidth()), 130);
        registrar.setTitle(fuentes_Y_mas.getTitulo());
        registrar.setResizable(false);
        validar_cuenta = false;
        validar_pass = false;
        registrar.setVisible(true);
    }
    
    private void Limpiar_Cajas(boolean limpiar_cedula) {
        
        if (limpiar_cedula) {
            registrar.txt_cedula.setText("");
        }
        
        registrar.txt_nombre.setText("");
        registrar.txt_cuenta.setText("");
        registrar.txt_contrasena.setText("");
        registrar.combo_tipos.setSelectedIndex(0);
        
    }
    
    private void Estados_Textos(boolean estado) {
        
        registrar.txt_nombre.setEditable(estado);
        registrar.txt_cuenta.setEditable(estado);
        registrar.txt_contrasena.setEditable(estado);
        
    }
    
    private void Validar_Cedula() {
        
        try {
            
            String cedula = registrar.txt_cedula.getText();
            
            if (!cedula.isEmpty()) {
                String sms = "Digita  cédula completa";
                boolean visible = true;
                if (cedula.length() == 10) {
                    
                    sms = "Cédula incorrecta";
                    if (validacion_txt.Validar_cedula(cedula)) {//valida la cedula sea correcta

                        sms = "Cedúla ya esta registrada!";
                        
                        modelo_nuevo.setCedula(cedula);
                        if (crud_primero.Consultar_Cedula(modelo_nuevo) == false) { // si retorna true , la cedula ya esta registrada en una cuenta
                            //si retorna false ,  es una nueva cedula

                            registrar.txt_nombre.requestFocus();
                            Estados_Textos(true);
                            visible = false;
                            
                        }
                        
                    }
                    
                }
                
                registrar.lb_cedula.setText(sms);
                registrar.lb_cedula.setVisible(visible);
                
            }
            
        } catch (Exception e) {
            
            System.out.println("error " + e.getMessage());
        }
        
    }
    
    private void Registrar_Cuenta() {
        
        String sms = "Contraseña/Cuenta no cumple con los parametros establecidos";
        Color color = fuentes_Y_mas.getColor_Mal();
        
        if (validar_cuenta == false && validar_pass == false) {
            String cedula = registrar.txt_cedula.getText().trim();
            String nombre = registrar.txt_nombre.getText().trim();
            String cuenta = registrar.txt_cuenta.getText().trim();
            String contrasena = registrar.txt_contrasena.getText().trim();
            String tipo_cuenta = registrar.combo_tipos.getSelectedItem().toString();

            //==========METODO QUE HACE EL INSERT==================== 
            sms = "Ocurrio un error, intentelo de nuevo";
            
            if (Insertar_Datos(cedula, nombre, cuenta, contrasena, tipo_cuenta)) {
                
                sms = "Cuenta registrada con exito";
                color = fuentes_Y_mas.getColor_Bien();
                
            }
            Limpiar_Cajas(true);
            
        }
        controlador_sms.Iniciar_Componentes(sms, color);
        
    }
    
    private boolean Insertar_Datos(String cedula, String nombre, String cuenta, String constrasena, String tipo_cuenta) {
        
        int respuesta = mensajes.getOptionDialog(registrar, "Seguro desea registrar la cuenta?", iconos.getIcono_pregunta(), opciones);
        
        boolean retornar = true;
        if (respuesta == 0) {
            
            modelo_nuevo.setCedula(cedula);
            modelo_nuevo.setNombre(nombre);
            modelo_nuevo.setUsuario(cuenta);
            modelo_nuevo.setContrasena(constrasena);
            modelo_nuevo.setTipo_cuenta(tipo_cuenta);

            //TRUE: CORRECTO 
            //FALSE: INCORRECTO
            retornar = crud_primero.Registrar_Cuenta(modelo_nuevo);
            
        }
        return retornar;
        
    }
    
    private void Evento_Ventana() {
        
        WindowListener evento = new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
                
                Limpiar_Cajas(true);
                Estados_Textos(false);
                registrar.lb_cedula.setVisible(false);
                registrar.btn_crear_cuenta.setEnabled(false);
                registrar.lb_cuenta.setVisible(false);
                registrar.lb_pass.setVisible(false);
                
            }
            
        };
        registrar.addWindowListener(evento);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Registrar_Cuenta();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        
        try {
            int letra = e.getKeyCode();
            
            if (letra == KeyEvent.VK_ENTER) {
                Object control = e.getSource();
                if (control == registrar.txt_cedula) {
                    
                    Validar_Cedula();
                    //registrar.txt_nombre.requestFocus();
                }
                if (control == registrar.txt_nombre) {
                    
                    registrar.txt_cuenta.requestFocus();
                }
                if (control == registrar.txt_cuenta) {
                    
                    registrar.txt_contrasena.requestFocus();
                }
                
            }
            
            if (e.getSource() == registrar.txt_cedula) {
                
                if (e.getKeyCode() == 127 || e.getKeyCode() == 8) { //8 es de eliminar la fecha , 127 es de suprimir

                    Limpiar_Cajas(false);
                    Estados_Textos(false);
                    registrar.lb_cedula.setVisible(false);
                    registrar.btn_crear_cuenta.setEnabled(false);
                    
                }
                
            }
        } catch (Exception ex) {
            System.out.println("errr " + ex.getMessage());
        }
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
        if (registrar.txt_cuenta.getText().length() > 9 && registrar.txt_contrasena.getText().length() > 9 && registrar.txt_nombre.getText().length() > 1) {
            
            registrar.btn_crear_cuenta.setEnabled(true);
        } else {
            registrar.btn_crear_cuenta.setEnabled(false);
        }

        //es para que cuadno aplaaste el de borrar o enter  no salga el sms
        if (e.getSource() == registrar.txt_cedula) {
            char letra = e.getKeyChar();
            if (letra < '0' || letra > '9') {
                
                if (e.getKeyCode() != 8 && e.getKeyCode() != 10) { // 10 enter , 8 borrar
                    controlador_sms.Iniciar_Componentes("Caracter no admitido", fuentes_Y_mas.getColor_Mal());
                }
                
            }
        }
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
        char letra = e.getKeyChar();
        
        if (e.getSource() == registrar.txt_cedula) {
            if (letra < '0' || letra > '9') {
                e.consume();
                
            }
            
            if (registrar.txt_cedula.getText().length() > 9) {
                
                e.consume();
                
            }
            
        }
        
        if (e.getSource() == registrar.txt_cuenta || e.getSource() == registrar.txt_contrasena) {
            
            if (e.getKeyChar() == ' ') {
                e.consume();
            }
            
        }
        
        if (e.getSource() == registrar.txt_nombre) {
            
            if (Character.isLowerCase(letra) && Character.isAlphabetic(letra)) {
                
                String mayuscula = ("" + letra).toUpperCase();
                
                letra = mayuscula.charAt(0);
                e.setKeyChar(letra);
                
            }
            
            if ((letra < 'A' || letra > 'Z') && letra != ' ') {
                e.consume();
                
            }
            
        }
        
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        
        if (e.getSource() == registrar.txt_cuenta) {
            registrar.lb_cuenta.setVisible(false);
        }
        
        if (e.getSource() == registrar.txt_contrasena) {
            
            registrar.lb_pass.setVisible(false);
        }
        
    }
    
    @Override
    public void focusLost(FocusEvent e) {
        
        Object evento = e.getSource();
        
        if (evento == registrar.txt_cuenta) {
            
            String cuenta = registrar.txt_cuenta.getText();
            
            if (!cuenta.isEmpty()) {
                
                if (validacion_txt.Validar_Usuario_contrase(cuenta) == 2) {
                    registrar.lb_cuenta.setVisible(false);
                    validar_cuenta = false;
                    
                } else {
                    registrar.lb_cuenta.setVisible(true);
                    validar_cuenta = true;
                    
                }
                
            }
            
        }
        
        if (evento == registrar.txt_contrasena) {
            
            String cuenta = registrar.txt_contrasena.getText();
            
            if (!cuenta.isEmpty()) {
                
                if (validacion_txt.Validar_Usuario_contrase(cuenta) == 2) {
                    registrar.lb_pass.setVisible(false);
                    validar_pass = false;
                    
                } else {
                    registrar.lb_pass.setVisible(true);
                    
                    validar_pass = true;
                }
                
            }
            
        }
        
    }
    
    private String opciones[];
    
}
