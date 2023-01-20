package Diseno;

import Atxy2k.CustomTextField.RestrictedTextField;
import Logica.*;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;
import javax.swing.*;

import javax.swing.border.LineBorder;
import ventana_Dialogos.*;


public class Menu extends javax.swing.JFrame {
     
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
       
        this.setIconImage( Toolkit.getDefaultToolkit().getImage("src/Imagenes/icono_proyecto.png"));
        datos = new Intruccion_sql();
        validar = new Validacion_txt();
        colores= new Logica_Colores();
            
       Asignar_Colores_Inicio();/// colores 
      estados_Iniciales_Invisibles();

        Restricciones();
      /// setEnabled();
        transpa_Panel_clave();
         Bloquear_Slider();
        menu_pop();
        menu_autos_cane(); //llamar tabla_cancelada
                   
        /// Intruccion_sql horas_label = new Intruccion_sql(label_hora);
      label_color_name_regi.setVisible(false);
       label_fecha.setText( "" +  datos.getRetornar_fecha_actual("")); ///retorna fecha_actual
       panel_principal.setFocusable(true);
       panel_cambiar_clave.setFocusable(true);
       
       
//        Timer tiempo = new Timer(100, new Menu.Horas_actual());
//       tiempo.start();

            
    }
//    
//       class Horas_actual implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            java.util.Date sistHora = new java.util.Date();
//            String pmAm = "hh:mm:ss a";
//            SimpleDateFormat format = new SimpleDateFormat(pmAm);
//            Calendar hoy = Calendar.getInstance();
//            label_hora.setText((String.format(format.format(sistHora), hoy)));
//
//        }
//    }
    
    
    
    private void Cerrar_Programa(){
        
               if (!panel_cambiar_clave.isVisible() &&  panel_colores.getY()>200) {
            String opciones[] = new String[2];

            if (label_salir.isVisible()) {
                opciones[0] = "Finalizar Sesión y Salir";
                opciones[1] = "Cancelar";

                int con = JOptionPane.showOptionDialog(this, "¡Finaliza Sesión antes de salir!", "Sistema  de Parqueo", 1, 1,new ImageIcon("src/Image_Sms/salir_pre_2.png"), opciones, opciones[1]);
                if (con == 0) {
                    System.exit(0);
                }

            } else {

                opciones[0] = "Salir";
                opciones[1] = "Permanecer";
                int con = JOptionPane.showOptionDialog(this, "¿Seguro desea salir?", "Sistema  de Parqueo", 1, 1,  new ImageIcon("src/Image_Sms/salir_pre_2.png"), opciones, opciones[1]);
                if (con == 0) {

                    System.exit(0);

                }

            }
        } else {
            panel_cambiar_clave.setRequestFocusEnabled(true);
        }
        
        
    }
    
    
    
    private void pasar (int elegir ){
        
        switch (elegir) {
            case 1:
                {
                    Tabla_Usuarios pasar = new Tabla_Usuarios(this, true);
                    pasar.setVisible(true);
                    break;
                }
            case 2:
                {
                    Graficos_estadisticos pasar = new Graficos_estadisticos(this, true);
                    pasar.setLocation(10,60);
                    pasar.setVisible(true);
                    break;
                }
            case 3:
                {
                datos.Actualizar_Tipo_Usuario(label_tipo_usu.getText(),true,0); //actualizo el tipo_usuario en la tabla  tipo_usuario para    

                    
                    Tabla_Auto_Cancelados pasar = new Tabla_Auto_Cancelados(this, true);
                    pasar.setLocationRelativeTo(null);
                    pasar.setVisible(true);
                    break;
                }
                
               
            default:
                break;
        }
         
             
    }
            
    private void menu_pop(){
        
        JPopupMenu Objeto_menu = new JPopupMenu();
        JMenuItem ver_usuarios = new JMenuItem("Gestionar Usuarios", new ImageIcon("src/Image_2/icono_usuarios.png"));
        JMenuItem  barra = new JMenuItem("Graficar  Estadisticas", new ImageIcon("src/Image_2/esta_2.png"));
         JMenuItem ingresos_cancelados = new JMenuItem("Ingresos Cancelados", new ImageIcon("src/Imagenes/cancelar.png"));

         ver_usuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             pasar (1);
                

            }
        });
         
            barra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             pasar (2);
                

            }
        });
            
         ingresos_cancelados.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 pasar (3);

            }
        });
        
    
        Objeto_menu.add( ver_usuarios);
           Objeto_menu.add(barra);
           Objeto_menu.add(ingresos_cancelados);
        
     
        btn_registrar.setComponentPopupMenu(Objeto_menu);
        
    }
    
    
    private void menu_autos_cane(){
             JPopupMenu Objeto_menu = new JPopupMenu();
        JMenuItem tabla_cancelada = new JMenuItem("Ingresos Cancelados", new ImageIcon("src/Imagenes/cancelar.png"));
       

          tabla_cancelada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                                
             pasar (3);
                

            }
            });

        
    
        Objeto_menu.add(  tabla_cancelada);
         
        
     
        btn_listar.setComponentPopupMenu(Objeto_menu);
        
    }
    
    public void  Bloquear_Slider(){
        
        slider_rojo.setEnabled(false);
        slider_verde.setEnabled(false);
        slider_azul.setEnabled(false);
        txt_nombre_color.setEditable(false);    
        btn_guardar_color.setEnabled(false);
         
        
        
    }
    
    private void Bloquear_combos_colores(){
        
        combo_colores_borde.setEnabled(false);
        combo_colores_fondo.setEnabled(false);
        combo_colores_fondo_itulos.setEnabled(false);
        combo_colores_letra.setEnabled(false);
        combo_colores_letra_titulos.setEnabled(false);
        
    }
    
    private void desblquear_combos_colores(){
        
        combo_colores_borde.setEnabled(true);
        combo_colores_fondo.setEnabled(true);
        combo_colores_fondo_itulos.setEnabled(true);
        combo_colores_letra.setEnabled(true);
        combo_colores_letra_titulos.setEnabled(true);
        
    }
       
    private void Poner_curso_index_0_colore(){
        
        
        combo_colores_borde.setSelectedIndex(0);
        combo_colores_fondo.setSelectedIndex(0);
        combo_colores_fondo_itulos.setSelectedIndex(0);
        combo_colores_letra.setSelectedIndex(0);
        combo_colores_letra_titulos.setSelectedIndex(0);
        
    }  
    
    
    
    private void Restablecer(){
         String color_fondo ="";///
        String color_letra_titulos="";////
        String color_letra_funciones="";////
        String color_borde="";//
        String color_fondo_titulos="";
        
        
        int recibir = colores.nombres_Color_funciones(true, "","","","","");
        
        if (recibir!=0){
            
            color_borde = colores.getColor_borde();
            color_fondo= colores.getColor_fondo();
            color_letra_funciones = colores.getColor_letra_funciones();
            color_letra_titulos = colores.getColor_letra_titulos();
            color_fondo_titulos = colores.getColor_fondo_titulos();
            
           //////////////////////////////////////////////////////////////////////////////////////
            colores.get_Colores(color_borde,true,0,0,0);
            Color color_1 = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
            label_dar_color_border.setForeground(color_1);
            
            LineBorder border = new LineBorder(color_1,3, true);
            ///label_borde_fino.setBackground(color_1);
            panel_principal.setBorder(border);
            panel_cambiar_clave.setBorder(border);
           
            panel_colores.setBorder(border);
            panel_login.setBorder(border);
            //////////////////////
                           
             btn_listar.setBorder(border);
               btn_listar_salida.setBorder(border);

             btn_ing_vehi.setBorder(border );
             btn_registrar.setBorder(border );
             btn_sacar_vehi.setBorder(border);
             btn_editar_vehiculo.setBorder(border );
             btn_configuracion.setBorder(border );
             btn_cambiar_clave.setBorder(border );
             btn_apariencia.setBorder(border );
             btn_colores_aplicar.setBorder(border );
             btn_colores_cancelar.setBorder(border );
            
             btn_update_clave.setBorder(border );
             btn_Ingresar.setBorder(border );
              btn_agg_color.setBorder(border);
            
              ////bordes titulos//////////////////////////////
              
              
                 label_titulo_confi_clave.setBorder(border);
                 label_titulo_confi_colores.setBorder(border);
                
                 label_titulo_principal.setBorder(border);
                 label_titulo_login.setBorder(border);
              
           
            
            
            /////////////////////////////////////////////////////////////////////////////////////////
              
            colores.get_Colores(color_fondo,true,0,0,0);
            Color color_2 = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
            
            panel_principal.setBackground(color_2);
            panel_botones.setBackground(color_2);
            panel_login.setBackground(color_2);
            panel_colores.setBackground(color_2);
            panel_cambiar_clave.setBackground(color_2);
            
            /////////////////////////////////////////////////////////////////////////////////////////
            
             colores.get_Colores( color_letra_funciones,true,0,0,0);
             Color color_3 = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
            
                           
             btn_listar.setForeground(color_3);
             btn_listar_salida.setForeground(color_3);
             btn_ing_vehi.setForeground(color_3 );
             btn_registrar.setForeground(color_3 );
             btn_sacar_vehi.setForeground(color_3 );
             btn_editar_vehiculo.setForeground(color_3 );
             btn_configuracion.setForeground(color_3 );
             btn_cambiar_clave.setForeground(color_3 );
             btn_apariencia.setForeground(color_3 );
             btn_colores_aplicar.setForeground(color_3 );
             btn_colores_cancelar.setForeground(color_3 );
            
             btn_update_clave.setForeground(color_3 );
             btn_Ingresar.setForeground(color_3 );
              btn_agg_color.setForeground(color_3);
            
             /////////////////////////////////////////////////////////////////////////////////////////
            
                colores.get_Colores( color_letra_titulos,true,0,0,0);
                Color color_4 = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
                 label_titulo_confi_clave.setForeground(color_4);
                 label_titulo_confi_colores.setForeground(color_4);
                
                 label_titulo_principal.setForeground(color_4);
                 label_titulo_login.setForeground(color_4);
            
             /////////////////////////////////////////////////////////////////////////////////////////
            
                    colores.get_Colores(  color_fondo_titulos,true,0,0,0);
                    Color color_5 = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
                    label_titulo_confi_clave.setBackground(color_5);
                     label_titulo_confi_colores.setBackground(color_5);
                   
                     label_titulo_principal.setBackground(color_5);
                     label_titulo_login.setBackground(color_5);
            
         
        }  
        
    }
       
      
    
    
    private void estados_Iniciales_Invisibles(){
        
        /// panel_principal.setBackground(Color.white);
        btn_Ingresar.setEnabled(false);
        label_inc.setVisible(false);
        label_salir.setVisible(false);
       
        label_dar_color_border.setVisible(false);/// este toma el color de los border para luego tomar ese color y poner el mosue exited de los botones

        ////////////////////////////////////////////////////
        /////boton configuracion y demas
        btn_configuracion.setVisible(false);
     btn_editar_vehiculo.setVisible(false);
        btn_cambiar_clave.setVisible(false);
        btn_apariencia.setVisible(false);
        
                
       //////////////////////////////////////////////////////////////
       /////Panel Cambiar clace///////////////////////////////
        panel_cambiar_clave.setVisible(false);
       
        label_pass_NO_coincide.setVisible(false);
        label_parametros.setVisible(false);
          label_confirma.setVisible(false);
          btn_update_clave.setEnabled(false);
          ///////////////Panel_Operaciones////////////////////
         
    }
    
    private void Volver_estado_inicial(){
         txt_clave_actual.setText("");
         txt_clave_nueva.setText("");
          txt_confir_clave.setText("");
             btn_update_clave.setEnabled(false);
            label_confirma.setText("Contraseñas no coinciden");
            label_confirma.setVisible(false);
         panel_cambiar_clave.setVisible(false);
         
        
    }
    private void boton_x_confi_vehi_cambi_clav(){
           btn_configuracion.setEnabled(true);
            btn_cambiar_clave.setEnabled(true);
            btn_editar_vehiculo.setEnabled(true);           
            btn_apariencia.setEnabled(true);
           ///btn_listar_Usuarios.setEnabled(true);
            label_salir.setEnabled(true);
            
             
    }
    
    private void Label_Cerrar_Session( boolean estado){
        
        
        if (panel_cambiar_clave.isVisible() == estado && panel_colores.getY()>200) {
            label_tipo_usu.setText("Sin Especificar");
            label_activo.setText("Inactivo");
            label_tipo_usu.setForeground(color.red);
            label_activo.setForeground(color.red);
            txtx_usuario.setText("");
            txt_pass.setText("");
            txtx_usuario.setEditable(true);
            txt_pass.setEditable(true);
            btn_configuracion.setVisible(false);
            txtx_usuario.requestFocus();           
            label_salir.setVisible(false);
            panel_botones.setVisible(false);
            btn_cambiar_clave.setVisible(false);
            btn_editar_vehiculo.setVisible(false);
            btn_apariencia.setVisible(false);
            jchec_admin.setEnabled(true);
             btn_configuracion.setText("Configuración");           
               btn_configuracion.setIcon( new ImageIcon("src/Image_2/congi_sinfondo.png"));

               Volver_estado_inicial();//  estos componente tienen q volver a tu estado inicial
               boton_x_confi_vehi_cambi_clav();
               
        }
 

    }
          

    private void transpa_Panel_clave() {

        Trasparente clave_actual = new Trasparente("Digita tu clave actual", txt_clave_actual, Trasparente.Show.ALWAYS);
        Trasparente clave_nueva = new Trasparente("Digita clave nueva", txt_clave_nueva, Trasparente.Show.ALWAYS);
        Trasparente clave_confir = new Trasparente("Digita  clave nuevamente", txt_confir_clave, Trasparente.Show.ALWAYS);
           Trasparente txt_agg_color = new Trasparente("Nombre del Color", txt_nombre_color, Trasparente.Show.ALWAYS);
        

    }

    private void setBloquear_Usuario_erro() {
        label_inc.setVisible(true);
        txtx_usuario.setText("");
        txt_pass.setText("");

        btn_Ingresar.setEnabled(false);
        Animacion.Animacion.mover_derecha(360, 360, 4, 2, btn_esconder);
        Animacion.Animacion.mover_derecha(10, 10, 4, 2, panel_login);
    }

    private void setEditable_Usu_corre() {
       
        
         if (label_tipo_usu.getText().equals("Empleado")){
               jchec_admin.setEnabled(false);
         }else{
              jchec_empleado.setEnabled(false);
         }
             
        txt_pass.setEditable(false);
        
        label_inc.setVisible(false);
        btn_Ingresar.setEnabled(false);
        txtx_usuario.setEditable(false);
        setEnabled_true();

        Animacion.Animacion.mover_izquierda(370, 10, 2, 2, btn_esconder);
        Animacion.Animacion.mover_izquierda(10, -350, 2, 2, panel_login);
        //////////////////////////////////////////////////////////////////////////////////////////
        // Animacion.Animacion.bajar(-90, 110, 15, 4, panel_botones); // Bajar panel si el login es correcto

    }

    private void setEnabled_true() {
        btn_ing_vehi.setEnabled(true);
        btn_listar.setEnabled(true);
        btn_sacar_vehi.setEnabled(true);
        btn_registrar.setEnabled(true);
    }

    private void Restricciones() {

        buttonGroup1.add(jchec_empleado);
        buttonGroup1.add(jchec_admin);
        jchec_empleado.setSelected(true);

        //////////////////////////////////////////////////////////////////////////////////
        RestrictedTextField usuario_2 = new RestrictedTextField(txtx_usuario);
        usuario_2.setLimit(30);
        usuario_2.setOnlyAlphaNumeric(true);

        RestrictedTextField pass = new RestrictedTextField(txt_pass);
        pass.setLimit(30);
        pass.setOnlyAlphaNumeric(true);
        /////////////////////////////////////////////////////////////////////////////////////

        Trasparente usuario = new Trasparente("Usuario", txtx_usuario, Trasparente.Show.ALWAYS);
        Trasparente con = new Trasparente("Contraseña", txt_pass, Trasparente.Show.ALWAYS);

    }
    
    private void Asignar_Colores_Inicio(){
        
       
        
        
           // datos.sql_Tabla_Tipo_Vehiculos(combo_cargar_vehiculos, "", 0, true, 0);
        String color_fondo ="";///
        String color_letra_titulos="";////
        String color_letra_funciones="";////
        String color_borde="";//
        String color_fondo_titulos="";
        
  
            
    
        
        colores.consulta_Colores(combo_colores_fondo);
        colores.consulta_Colores(combo_colores_borde);
        colores.consulta_Colores(combo_colores_fondo_itulos);
        colores.consulta_Colores(combo_colores_letra_titulos);
        colores.consulta_Colores(combo_colores_letra);
        
        
      
        int recibir = colores.nombres_Color_funciones(true, "","","","","");
        
        if (recibir!=0){
            
            color_borde = colores.getColor_borde();
            color_fondo= colores.getColor_fondo();
            color_letra_funciones = colores.getColor_letra_funciones();
            color_letra_titulos = colores.getColor_letra_titulos();
            color_fondo_titulos = colores.getColor_fondo_titulos();
            
           //////////////////////////////////////////////////////////////////////////////////////
            colores.get_Colores(color_borde,true,0,0,0);
            Color color_1 = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
            
                  label_dar_color_border.setForeground(color_1); /// este es una auxiliar para luego tomar su color y ponerlo en el evento mouse exited de  todos los tbn
                LineBorder border = new LineBorder(color_1,3, true);
              ///  label_borde_fino.setBackground(color_1);
                panel_principal.setBorder(border);
                panel_cambiar_clave.setBorder(border);
               
                panel_colores.setBorder(border);
                panel_login.setBorder(border);
                ////////Bordes de los titulos
                  label_titulo_confi_clave.setBorder(border);
                 label_titulo_confi_colores.setBorder(border);
                
                 label_titulo_principal.setBorder(border);
                 label_titulo_login.setBorder(border);
                 ////////Borde  botones btn  funciones
                 
                 
                btn_listar.setBorder(border);
                 btn_ing_vehi.setBorder(border );
                btn_registrar.setBorder(border );
                btn_sacar_vehi.setBorder(border);
               btn_editar_vehiculo.setBorder(border);
                btn_configuracion.setBorder(border );
                btn_cambiar_clave.setBorder(border );
                 btn_apariencia.setBorder(border);
                 btn_colores_aplicar.setBorder(border);
                btn_colores_cancelar.setBorder(border );
              
                btn_update_clave.setBorder(border );
                btn_Ingresar.setBorder(border);
                btn_agg_color.setBorder(border);
                btn_listar_salida.setBorder(border);
            
                 
                 
                 
                 
            
            /////////////////////////////////////////////////////////////////////////////////////////
              
            colores.get_Colores(color_fondo,true,0,0,0);
            Color color_2 = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
            
           panel_principal.setBackground(color_2);
            panel_botones.setBackground(color_2);
            panel_login.setBackground(color_2);
            panel_cambiar_clave.setBackground(color_2);
            panel_colores.setBackground(color_2);
           
            
            
            /////////////////////////////////////////////////////////////////////////////////////////
            
              colores.get_Colores( color_letra_funciones,true,0,0,0);
            Color color_3 = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
            
                           
             btn_listar.setForeground(color_3);
             btn_ing_vehi.setForeground(color_3 );
             btn_registrar.setForeground(color_3 );
             btn_sacar_vehi.setForeground(color_3 );
             btn_editar_vehiculo.setForeground(color_3 );
             btn_configuracion.setForeground(color_3 );
             btn_cambiar_clave.setForeground(color_3 );
             btn_apariencia.setForeground(color_3 );
             btn_colores_aplicar.setForeground(color_3 );
             btn_colores_cancelar.setForeground(color_3 );
            
             btn_update_clave.setForeground(color_3 );
             btn_Ingresar.setForeground(color_3 );
              btn_agg_color.setForeground(color_3);
              btn_listar_salida.setForeground(color_3);
            
             /////////////////////////////////////////////////////////////////////////////////////////
            
                 colores.get_Colores( color_letra_titulos,true,0,0,0);
                Color color_4 = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
                    label_titulo_confi_clave.setForeground(color_4);
                    label_titulo_confi_colores.setForeground(color_4);
                  
                    label_titulo_principal.setForeground(color_4);
                    label_titulo_login.setForeground(color_4);
            
             /////////////////////////////////////////////////////////////////////////////////////////
            
                  colores.get_Colores(  color_fondo_titulos,true,0,0,0);
                  Color color_5 = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
                 label_titulo_confi_clave.setBackground(color_5);
                label_titulo_confi_colores.setBackground(color_5);
               
                label_titulo_principal.setBackground(color_5);
                label_titulo_login.setBackground(color_5);
            
         
        }     
         
    }
    
    
    private void Bloquear_Aplastar_bnt_colore_clave(){
        label_salir.setEnabled(false);
        btn_cambiar_clave.setEnabled(false);
        btn_editar_vehiculo.setEnabled(false);
        btn_configuracion.setEnabled(false);
        btn_apariencia.setEnabled(false);
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel_principal = new javax.swing.JPanel();
        label_titulo_principal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_esconder = new javax.swing.JButton();
        panel_login = new javax.swing.JPanel();
        label_titulo_login = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtx_usuario = new javax.swing.JTextField();
        txt_pass = new javax.swing.JPasswordField();
        btn_Ingresar = new javax.swing.JButton();
        jchec_empleado = new javax.swing.JCheckBox();
        jchec_admin = new javax.swing.JCheckBox();
        label_inc = new javax.swing.JLabel();
        label_recupe_pass = new javax.swing.JLabel();
        panel_botones = new javax.swing.JPanel();
        btn_ing_vehi = new javax.swing.JButton();
        btn_listar = new javax.swing.JButton();
        btn_sacar_vehi = new javax.swing.JButton();
        btn_registrar = new javax.swing.JButton();
        btn_listar_salida = new javax.swing.JButton();
        label_salir = new javax.swing.JLabel();
        label_tipo_usuario = new javax.swing.JLabel();
        label_estado = new javax.swing.JLabel();
        label_tipo_usu = new javax.swing.JLabel();
        label_activo = new javax.swing.JLabel();
        btn_configuracion = new javax.swing.JButton();
        btn_cambiar_clave = new javax.swing.JButton();
        btn_editar_vehiculo = new javax.swing.JButton();
        panel_cambiar_clave = new javax.swing.JPanel();
        btn_update_clave = new javax.swing.JButton();
        txt_clave_actual = new javax.swing.JTextField();
        txt_clave_nueva = new javax.swing.JTextField();
        label_titulo_confi_clave = new javax.swing.JLabel();
        txt_confir_clave = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        label_pass_NO_coincide = new javax.swing.JLabel();
        label_parametros = new javax.swing.JLabel();
        label_confirma = new javax.swing.JLabel();
        btn_apariencia = new javax.swing.JButton();
        panel_colores = new javax.swing.JPanel();
        label_titulo_confi_colores = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        combo_colores_fondo = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        combo_colores_letra = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        combo_colores_borde = new javax.swing.JComboBox<>();
        btn_colores_aplicar = new javax.swing.JButton();
        btn_colores_cancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        combo_colores_letra_titulos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        combo_colores_fondo_itulos = new javax.swing.JComboBox<>();
        btn_guardar_color = new javax.swing.JButton();
        slider_rojo = new javax.swing.JSlider();
        slider_verde = new javax.swing.JSlider();
        slider_azul = new javax.swing.JSlider();
        label_color_generadp = new javax.swing.JLabel();
        txt_nombre_color = new javax.swing.JTextField();
        btn_agg_color = new javax.swing.JButton();
        label_color_name_regi = new javax.swing.JLabel();
        label_dar_color_border = new javax.swing.JLabel();
        label_minimar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        label_fecha = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        panel_principal.setBackground(java.awt.Color.white);
        panel_principal.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.green, 3));
        panel_principal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panel_principalMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panel_principalMouseMoved(evt);
            }
        });
        panel_principal.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                panel_principalMouseWheelMoved(evt);
            }
        });
        panel_principal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_principalMouseEntered(evt);
            }
        });
        panel_principal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panel_principalKeyPressed(evt);
            }
        });
        panel_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_titulo_principal.setBackground(new java.awt.Color(0, 204, 0));
        label_titulo_principal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_titulo_principal.setForeground(new java.awt.Color(255, 255, 255));
        label_titulo_principal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo_principal.setText("SISTEMA DE PARQUEO");
        label_titulo_principal.setOpaque(true);
        panel_principal.add(label_titulo_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 1020, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("X");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });
        panel_principal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 2, 20, 30));

        btn_esconder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_2/linea_22.png"))); // NOI18N
        btn_esconder.setContentAreaFilled(false);
        btn_esconder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_esconder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_esconderMouseEntered(evt);
            }
        });
        btn_esconder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_esconderActionPerformed(evt);
            }
        });
        panel_principal.add(btn_esconder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 66, 60));

        panel_login.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.green, 3));
        panel_login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_titulo_login.setBackground(java.awt.Color.green);
        label_titulo_login.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_titulo_login.setForeground(java.awt.Color.white);
        label_titulo_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo_login.setText("Inicio de Sesión");
        label_titulo_login.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        label_titulo_login.setOpaque(true);
        panel_login.add(label_titulo_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_2/icono-iniciar-sesion_2.png"))); // NOI18N
        panel_login.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 42, 42));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_2/icono-password_2.png"))); // NOI18N
        panel_login.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 42, 42));

        txtx_usuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtx_usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtx_usuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtx_usuarioFocusGained(evt);
            }
        });
        txtx_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtx_usuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtx_usuarioKeyReleased(evt);
            }
        });
        panel_login.add(txtx_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 200, 30));

        txt_pass.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_passKeyReleased(evt);
            }
        });
        panel_login.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 200, 30));

        btn_Ingresar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btn_Ingresar.setText("Ingresar");
        btn_Ingresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 0), 3));
        btn_Ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_IngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_IngresarMouseExited(evt);
            }
        });
        btn_Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IngresarActionPerformed(evt);
            }
        });
        panel_login.add(btn_Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 152, 50));

        jchec_empleado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jchec_empleado.setText("Empleado");
        jchec_empleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel_login.add(jchec_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 125, -1));

        jchec_admin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jchec_admin.setText("Admin");
        jchec_admin.setContentAreaFilled(false);
        jchec_admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel_login.add(jchec_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 122, -1));

        label_inc.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        label_inc.setForeground(new java.awt.Color(255, 0, 0));
        label_inc.setText("Usuario Incorrecto");
        panel_login.add(label_inc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 175, -1));

        label_recupe_pass.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        label_recupe_pass.setText("¿Olvidaste tu contraseña?");
        label_recupe_pass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_recupe_pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_recupe_passMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_recupe_passMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_recupe_passMouseExited(evt);
            }
        });
        panel_login.add(label_recupe_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 180, -1));

        panel_principal.add(panel_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(-350, 208, 350, 382));

        panel_botones.setBackground(java.awt.Color.white);
        panel_botones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_ing_vehi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_ing_vehi.setForeground(java.awt.Color.black);
        btn_ing_vehi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carro_ingreso_1.png"))); // NOI18N
        btn_ing_vehi.setText("Ingresar");
        btn_ing_vehi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btn_ing_vehi.setContentAreaFilled(false);
        btn_ing_vehi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ing_vehi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_ing_vehi.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_ing_vehi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ing_vehiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ing_vehiMouseExited(evt);
            }
        });
        btn_ing_vehi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ing_vehiActionPerformed(evt);
            }
        });
        panel_botones.add(btn_ing_vehi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 6, 150, 70));

        btn_listar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_listar.setForeground(java.awt.Color.black);
        btn_listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/listar_ingre.png"))); // NOI18N
        btn_listar.setText("Listar Ingresos");
        btn_listar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btn_listar.setContentAreaFilled(false);
        btn_listar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_listar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_listar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_listar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_listarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_listarMouseExited(evt);
            }
        });
        btn_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listarActionPerformed(evt);
            }
        });
        panel_botones.add(btn_listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 6, 180, 70));

        btn_sacar_vehi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_sacar_vehi.setForeground(java.awt.Color.black);
        btn_sacar_vehi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vehi_saliaaa.png"))); // NOI18N
        btn_sacar_vehi.setText("Retirar");
        btn_sacar_vehi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btn_sacar_vehi.setContentAreaFilled(false);
        btn_sacar_vehi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_sacar_vehi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_sacar_vehi.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_sacar_vehi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_sacar_vehiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_sacar_vehiMouseExited(evt);
            }
        });
        btn_sacar_vehi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sacar_vehiActionPerformed(evt);
            }
        });
        panel_botones.add(btn_sacar_vehi, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 6, 150, 70));

        btn_registrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_registrar.setForeground(java.awt.Color.black);
        btn_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regi_usua.png"))); // NOI18N
        btn_registrar.setText("Registrar");
        btn_registrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        btn_registrar.setContentAreaFilled(false);
        btn_registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_registrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_registrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_registrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_registrarMouseExited(evt);
            }
        });
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });
        panel_botones.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 6, 150, 70));

        btn_listar_salida.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_listar_salida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/listar_ingre.png"))); // NOI18N
        btn_listar_salida.setText("Listar Salidas");
        btn_listar_salida.setContentAreaFilled(false);
        btn_listar_salida.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_listar_salida.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_listar_salida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_listar_salidaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_listar_salidaMouseExited(evt);
            }
        });
        btn_listar_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listar_salidaActionPerformed(evt);
            }
        });
        panel_botones.add(btn_listar_salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 6, 180, 70));

        panel_principal.add(panel_botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, -90, 970, 80));

        label_salir.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label_salir.setForeground(new java.awt.Color(102, 102, 0));
        label_salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_2/salir.png"))); // NOI18N
        label_salir.setText("Cerrar Sesión");
        label_salir.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        label_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_salir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        label_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_salirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_salirMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label_salirMousePressed(evt);
            }
        });
        label_salir.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                label_salirVetoableChange(evt);
            }
        });
        panel_principal.add(label_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, 230, 50));

        label_tipo_usuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_tipo_usuario.setText("Tipo Usuario: ");
        panel_principal.add(label_tipo_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 120, 30));

        label_estado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_estado.setText("Estado: ");
        panel_principal.add(label_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 110, 30));

        label_tipo_usu.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label_tipo_usu.setForeground(new java.awt.Color(255, 0, 0));
        label_tipo_usu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_tipo_usu.setText("Sin Especificar");
        panel_principal.add(label_tipo_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 140, 30));

        label_activo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label_activo.setForeground(new java.awt.Color(255, 0, 0));
        label_activo.setText("Inactivo");
        panel_principal.add(label_activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 98, 30));

        btn_configuracion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_configuracion.setForeground(java.awt.Color.black);
        btn_configuracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_2/congi_sinfondo.png"))); // NOI18N
        btn_configuracion.setText("Configuración");
        btn_configuracion.setContentAreaFilled(false);
        btn_configuracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_configuracion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_configuracion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_configuracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_configuracionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_configuracionMouseExited(evt);
            }
        });
        btn_configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_configuracionActionPerformed(evt);
            }
        });
        panel_principal.add(btn_configuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 230, 210, 70));

        btn_cambiar_clave.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_cambiar_clave.setForeground(java.awt.Color.black);
        btn_cambiar_clave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cambia_contrase.png"))); // NOI18N
        btn_cambiar_clave.setText("Cambiar Clave");
        btn_cambiar_clave.setContentAreaFilled(false);
        btn_cambiar_clave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cambiar_clave.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cambiar_clave.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_cambiar_clave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cambiar_claveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cambiar_claveMouseExited(evt);
            }
        });
        btn_cambiar_clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cambiar_claveActionPerformed(evt);
            }
        });
        panel_principal.add(btn_cambiar_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 320, 190, 50));

        btn_editar_vehiculo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_editar_vehiculo.setForeground(java.awt.Color.black);
        btn_editar_vehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuraci_vehiculos.png"))); // NOI18N
        btn_editar_vehiculo.setContentAreaFilled(false);
        btn_editar_vehiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_editar_vehiculo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_editar_vehiculo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_editar_vehiculo.setLabel("Vehiculos");
        btn_editar_vehiculo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_editar_vehiculoMouseMoved(evt);
            }
        });
        btn_editar_vehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_editar_vehiculoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_editar_vehiculoMouseExited(evt);
            }
        });
        btn_editar_vehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar_vehiculoActionPerformed(evt);
            }
        });
        panel_principal.add(btn_editar_vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 400, 190, 50));

        panel_cambiar_clave.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.green, 3));
        panel_cambiar_clave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_cambiar_claveMouseEntered(evt);
            }
        });
        panel_cambiar_clave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panel_cambiar_claveKeyPressed(evt);
            }
        });
        panel_cambiar_clave.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_update_clave.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_update_clave.setForeground(new java.awt.Color(0, 0, 0));
        btn_update_clave.setText("Actualizar Clave");
        btn_update_clave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_update_clave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_update_claveFocusGained(evt);
            }
        });
        btn_update_clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_claveActionPerformed(evt);
            }
        });
        panel_cambiar_clave.add(btn_update_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 210, 44));

        txt_clave_actual.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_clave_actual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_clave_actual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_clave_actualFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_clave_actualFocusLost(evt);
            }
        });
        txt_clave_actual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_clave_actualKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_clave_actualKeyReleased(evt);
            }
        });
        panel_cambiar_clave.add(txt_clave_actual, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 250, 30));

        txt_clave_nueva.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_clave_nueva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_clave_nueva.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_clave_nuevaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_clave_nuevaFocusLost(evt);
            }
        });
        txt_clave_nueva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_clave_nuevaKeyPressed(evt);
            }
        });
        panel_cambiar_clave.add(txt_clave_nueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 250, 30));

        label_titulo_confi_clave.setBackground(new java.awt.Color(0, 204, 0));
        label_titulo_confi_clave.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label_titulo_confi_clave.setForeground(new java.awt.Color(255, 255, 255));
        label_titulo_confi_clave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo_confi_clave.setText("Cambiar Clave");
        label_titulo_confi_clave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 2));
        label_titulo_confi_clave.setOpaque(true);
        panel_cambiar_clave.add(label_titulo_confi_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 28));

        txt_confir_clave.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_confir_clave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_confir_clave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_confir_claveFocusGained(evt);
            }
        });
        txt_confir_clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_confir_claveActionPerformed(evt);
            }
        });
        txt_confir_clave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_confir_claveKeyReleased(evt);
            }
        });
        panel_cambiar_clave.add(txt_confir_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 250, 30));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("X");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        panel_cambiar_clave.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, -1, -1));

        label_pass_NO_coincide.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        label_pass_NO_coincide.setForeground(new java.awt.Color(204, 0, 0));
        label_pass_NO_coincide.setText("Contraseña incorrecta");
        panel_cambiar_clave.add(label_pass_NO_coincide, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 170, -1));

        label_parametros.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        label_parametros.setForeground(new java.awt.Color(204, 0, 0));
        label_parametros.setText("No cumple los parametros establecidos");
        panel_cambiar_clave.add(label_parametros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 250, -1));

        label_confirma.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        label_confirma.setForeground(new java.awt.Color(204, 0, 0));
        label_confirma.setText("Contraseñas no coinciden");
        panel_cambiar_clave.add(label_confirma, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 220, -1));

        panel_principal.add(panel_cambiar_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 310, 350));

        btn_apariencia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_apariencia.setForeground(java.awt.Color.black);
        btn_apariencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vista_apa.png"))); // NOI18N
        btn_apariencia.setText("Apariencia");
        btn_apariencia.setContentAreaFilled(false);
        btn_apariencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_apariencia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_apariencia.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_apariencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_aparienciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_aparienciaMouseExited(evt);
            }
        });
        btn_apariencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aparienciaActionPerformed(evt);
            }
        });
        panel_principal.add(btn_apariencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 480, 190, 50));

        panel_colores.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.green, 3));
        panel_colores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_coloresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_coloresMouseExited(evt);
            }
        });
        panel_colores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_titulo_confi_colores.setBackground(java.awt.Color.green);
        label_titulo_confi_colores.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label_titulo_confi_colores.setForeground(java.awt.Color.white);
        label_titulo_confi_colores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo_confi_colores.setText("Configuración Apariencia");
        label_titulo_confi_colores.setOpaque(true);
        panel_colores.add(label_titulo_confi_colores, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 690, 25));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("Color de Fondo");
        panel_colores.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 140, -1));

        combo_colores_fondo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        combo_colores_fondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_colores_fondoMouseClicked(evt);
            }
        });
        combo_colores_fondo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_colores_fondoActionPerformed(evt);
            }
        });
        panel_colores.add(combo_colores_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 193, -1));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setText("Color Letra Funciones");
        panel_colores.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 160, -1));

        combo_colores_letra.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        combo_colores_letra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_colores_letraActionPerformed(evt);
            }
        });
        panel_colores.add(combo_colores_letra, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 193, -1));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setText("Color de Border");
        panel_colores.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 140, -1));

        combo_colores_borde.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        combo_colores_borde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_colores_bordeActionPerformed(evt);
            }
        });
        panel_colores.add(combo_colores_borde, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 193, -1));

        btn_colores_aplicar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btn_colores_aplicar.setForeground(java.awt.Color.black);
        btn_colores_aplicar.setText("Aplicar Cambios");
        btn_colores_aplicar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_colores_aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_colores_aplicarActionPerformed(evt);
            }
        });
        panel_colores.add(btn_colores_aplicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 180, -1));

        btn_colores_cancelar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btn_colores_cancelar.setForeground(java.awt.Color.black);
        btn_colores_cancelar.setText("Restablecer ");
        btn_colores_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_colores_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_colores_cancelarActionPerformed(evt);
            }
        });
        panel_colores.add(btn_colores_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 180, 40));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 27)); // NOI18N
        jLabel3.setForeground(java.awt.Color.red);
        jLabel3.setText("X");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        panel_colores.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 0, 20, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Color Letra Titulos");
        panel_colores.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 140, -1));

        combo_colores_letra_titulos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        combo_colores_letra_titulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_colores_letra_titulosActionPerformed(evt);
            }
        });
        panel_colores.add(combo_colores_letra_titulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 193, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Color Fondo Titulos");
        panel_colores.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, -1));

        combo_colores_fondo_itulos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        combo_colores_fondo_itulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_colores_fondo_itulosActionPerformed(evt);
            }
        });
        panel_colores.add(combo_colores_fondo_itulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 193, -1));

        btn_guardar_color.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_guardar_color.setText("Guardar Color");
        btn_guardar_color.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_guardar_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_colorActionPerformed(evt);
            }
        });
        panel_colores.add(btn_guardar_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 150, 40));

        slider_rojo.setForeground(java.awt.Color.red);
        slider_rojo.setMajorTickSpacing(50);
        slider_rojo.setMaximum(255);
        slider_rojo.setMinorTickSpacing(2);
        slider_rojo.setPaintLabels(true);
        slider_rojo.setPaintTicks(true);
        slider_rojo.setSnapToTicks(true);
        slider_rojo.setValue(0);
        slider_rojo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slider_rojo.setOpaque(false);
        slider_rojo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_rojoStateChanged(evt);
            }
        });
        slider_rojo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                slider_rojoPropertyChange(evt);
            }
        });
        slider_rojo.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                slider_rojoVetoableChange(evt);
            }
        });
        panel_colores.add(slider_rojo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 700, 50));

        slider_verde.setForeground(java.awt.Color.green);
        slider_verde.setMajorTickSpacing(50);
        slider_verde.setMaximum(255);
        slider_verde.setMinorTickSpacing(3);
        slider_verde.setPaintLabels(true);
        slider_verde.setPaintTicks(true);
        slider_verde.setSnapToTicks(true);
        slider_verde.setValue(0);
        slider_verde.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slider_verde.setOpaque(false);
        slider_verde.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_verdeStateChanged(evt);
            }
        });
        panel_colores.add(slider_verde, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 700, 50));

        slider_azul.setForeground(java.awt.Color.blue);
        slider_azul.setMajorTickSpacing(50);
        slider_azul.setMaximum(255);
        slider_azul.setMinorTickSpacing(3);
        slider_azul.setPaintLabels(true);
        slider_azul.setPaintTicks(true);
        slider_azul.setValue(0);
        slider_azul.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        slider_azul.setOpaque(false);
        slider_azul.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_azulStateChanged(evt);
            }
        });
        panel_colores.add(slider_azul, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 700, 50));

        label_color_generadp.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label_color_generadp.setText("Color generado");
        label_color_generadp.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panel_colores.add(label_color_generadp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 200, 30));

        txt_nombre_color.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_nombre_color.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre_color.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nombre_colorFocusGained(evt);
            }
        });
        panel_colores.add(txt_nombre_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 220, 40));

        btn_agg_color.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btn_agg_color.setText("Agregar Color");
        btn_agg_color.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_agg_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agg_colorActionPerformed(evt);
            }
        });
        panel_colores.add(btn_agg_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 180, -1));

        label_color_name_regi.setForeground(new java.awt.Color(204, 0, 0));
        label_color_name_regi.setText("Nombre color ya esta registrado");
        panel_colores.add(label_color_name_regi, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 475, 200, -1));

        panel_principal.add(panel_colores, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 750, 720, 495));

        label_dar_color_border.setText("color bordes para tomar y dar el color del evento mouse exited de los botones");
        panel_principal.add(label_dar_color_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, -1, -1));

        label_minimar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_2/mini.png"))); // NOI18N
        label_minimar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_minimar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_minimarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label_minimarMousePressed(evt);
            }
        });
        panel_principal.add(label_minimar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1025, 2, -1, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Fecha Actual: ");
        panel_principal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, 100, 30));

        label_fecha.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        label_fecha.setText("gfdg");
        panel_principal.add(label_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 660, 160, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Ronny Chamba");
        panel_principal.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 660, 250, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 1087, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 703, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_esconderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_esconderActionPerformed
        // TODO add your handling code here:


        if (!panel_cambiar_clave.isVisible() &&  panel_colores.getY()>200) {

            int posicion = btn_esconder.getX();
            /// System.out.println(posicion + "*************************");
            if (posicion > 10) {
                Animacion.Animacion.mover_izquierda(370, 10, 2, 2, btn_esconder);
                Animacion.Animacion.mover_izquierda(10, -350, 2, 2, panel_login);
            } else {
                Animacion.Animacion.mover_derecha(10, 360, 2, 2, btn_esconder);
                Animacion.Animacion.mover_derecha(-350, 10, 2, 2, panel_login);

            }

        }

    }//GEN-LAST:event_btn_esconderActionPerformed

    private void txtx_usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtx_usuarioKeyReleased
        // TODO add your handling code here:
        if (!txtx_usuario.getText().isEmpty() && !txt_pass.getText().isEmpty()) {
            btn_Ingresar.setEnabled(true);
        } else {
            btn_Ingresar.setEnabled(false);
        }
    }//GEN-LAST:event_txtx_usuarioKeyReleased

    private void txt_passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyReleased
        // TODO add your handling code here:
        if (!txtx_usuario.getText().isEmpty() && !txt_pass.getText().isEmpty()) {
            btn_Ingresar.setEnabled(true);
        } else {
            btn_Ingresar.setEnabled(false);
        }
    }//GEN-LAST:event_txt_passKeyReleased

    private void btn_IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IngresarActionPerformed
        // TODO add your handling code here:

       String Tipo_Usuario ="Empleado";
        if (jchec_admin.isSelected()) {
            Tipo_Usuario ="Admin";
        }
        
        int r = datos.Ingresar(txtx_usuario.getText(), txt_pass.getText() ,Tipo_Usuario );
            if (r == 1 && btn_esconder.getX() > 10) {
                label_tipo_usu.setText(Tipo_Usuario);
                label_activo.setText("Activo");
                label_tipo_usu.setForeground(color);
                label_activo.setForeground(color);
                label_salir.setVisible(true);
                panel_botones.setVisible(true);
                setEditable_Usu_corre();
                btn_configuracion.setVisible(true);
                /*
                Si el  text del label es difennte de admin que el boton de registrar lo
                haga invisible, solo cuando el extto del label diga Admin va ser visible 
                */
                
                 if (!label_tipo_usu.getText().equals("Admin")){
                  btn_registrar.setVisible(false); 
                  //btn_listar_Usuarios.setVisible(false);
              
                 }else{
                       btn_registrar.setVisible(true); 
                       /// btn_listar_Usuarios.setVisible(true);
                 }
                 
                 label_recupe_pass.setVisible(false);//cuando ingrese la opcion de recuperar contraseña ya no se vea
                
                
                if (i == 0) { /// para que  solo para primera vez bajara el panel botones, de hay solo lo hace visible
                    
                    
                    Animacion.Animacion.bajar(-90, 110, 15, 4, panel_botones); // Bajar panel si el login es correcto
                } else {
                    panel_botones.setVisible(true);
                }

                i = i + 1;

            } else if (r == 0 && btn_esconder.getX() > 10) {
                setBloquear_Usuario_erro();

            }
       // }


    }//GEN-LAST:event_btn_IngresarActionPerformed

    private void btn_ing_vehiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ing_vehiActionPerformed
        // TODO add your handling code here:

        if (!panel_cambiar_clave.isVisible() &&  panel_colores.getY()>200) {
            Ingreso pasar = new Ingreso(this, true);
            
          
            pasar.show();

        }


    }//GEN-LAST:event_btn_ing_vehiActionPerformed

    private void btn_sacar_vehiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sacar_vehiActionPerformed
        // TODO add your handling code here:

        if (!panel_cambiar_clave.isVisible()  &&  panel_colores.getY()>200) {
            Salida pasar = new Salida(this, true);
            pasar.show();

        }


    }//GEN-LAST:event_btn_sacar_vehiActionPerformed

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        /// TODO add your handling code here:

        if (!panel_cambiar_clave.isVisible()  &&panel_colores.getY()>200) {
            Registrarse pasar = new Registrarse(this, true);
            pasar.show();
        }



    }//GEN-LAST:event_btn_registrarActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:

       Cerrar_Programa();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtx_usuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtx_usuarioFocusGained
        // TODO add your handling code here:
        Animacion.Animacion.mover_derecha(360, 360, 4, 2, btn_esconder);
        Animacion.Animacion.mover_derecha(10, 10, 4, 2, panel_login);

        label_inc.setVisible(false);

    }//GEN-LAST:event_txtx_usuarioFocusGained

    private void txt_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passKeyPressed

    private void txtx_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtx_usuarioKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {

            txt_pass.requestFocus();
        }

    }//GEN-LAST:event_txtx_usuarioKeyPressed

    private void label_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_salirMouseEntered
        // TODO add your handling code here:

        
        
        int posicion = btn_esconder.getX();
        if (posicion > 10) {

            Animacion.Animacion.mover_derecha(360, 360, 2, 2, btn_esconder);
            Animacion.Animacion.mover_derecha(10, 10, 2, 2, panel_login);

        } else {
            Animacion.Animacion.mover_izquierda(10, 10, 2, 2, btn_esconder);
            Animacion.Animacion.mover_izquierda(-350, 10, 2, 2, panel_login);

        }
///////////////////////////////////////////////////////////////

        if ( panel_botones.getY()>100){
               Animacion.Animacion.bajar(110, 110, 15, 0, panel_botones); // Bajar panel si el login es correcto
        }
        
     
        
  
        if ( label_salir.isEnabled()){ // solo si el label esta activo haga el evento de la linea
             Font font = label_salir.getFont();

             Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();

            map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            font = font.deriveFont(map);

            label_salir.setFont(font);
        }

           
      
        
        
           
          if ( !btn_configuracion.isEnabled() && panel_colores.getY()==200) {
            Animacion.Animacion.subir(200, 200, 2, 2, panel_colores);  
              
        }
        
        


    }//GEN-LAST:event_label_salirMouseEntered

    private void label_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_salirMouseExited
        // TODO add your handling code here:

        int posicion = btn_esconder.getX();
        if (posicion > 10) {

            Animacion.Animacion.mover_derecha(360, 360, 2, 2, btn_esconder);
            Animacion.Animacion.mover_derecha(10, 10, 2, 2, panel_login);

        } else {
            Animacion.Animacion.mover_izquierda(10, 10, 2, 2, btn_esconder);
            Animacion.Animacion.mover_izquierda(-350, 10, 2, 2, panel_login);

        }

         if ( panel_botones.getY()>100){
               Animacion.Animacion.bajar(110, 110, 15, 0, panel_botones); // Bajar panel si el login es correcto
        }
        
       
         
            if ( label_salir.isEnabled()){
                Font font = label_salir.getFont();

             Hashtable<TextAttribute, Object> map= new Hashtable<TextAttribute, Object>();

             map.put(TextAttribute.UNDERLINE, -1);
             font = font.deriveFont(map);

            label_salir.setFont(font);
            }
     
           
          if ( !btn_configuracion.isEnabled() && panel_colores.getY()==200) {
            Animacion.Animacion.subir(200, 200, 2, 2, panel_colores);  
              
        }


    }//GEN-LAST:event_label_salirMouseExited

    private void label_salirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_salirMousePressed

    }//GEN-LAST:event_label_salirMousePressed

    private void label_salirVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_label_salirVetoableChange
        // TODO add your handling code here:


    }//GEN-LAST:event_label_salirVetoableChange

    private void label_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_salirMouseClicked
        // TODO add your handling code here:
        
        Label_Cerrar_Session( false);
        jchec_empleado.setSelected(true);
        jchec_empleado.setEnabled(true);
        jchec_admin.setEnabled(true);
         label_recupe_pass.setVisible(true);
        


    }//GEN-LAST:event_label_salirMouseClicked

    private void btn_configuracionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_configuracionMouseEntered
        // TODO add your handling code here:

        int posicion = btn_esconder.getX();
        if (posicion > 10) {

            Animacion.Animacion.mover_derecha(360, 360, 2, 2, btn_esconder);
            Animacion.Animacion.mover_derecha(10, 10, 2, 2, panel_login);

        } else {
            Animacion.Animacion.mover_izquierda(10, 10, 2, 2, btn_esconder);
            Animacion.Animacion.mover_izquierda(-350, 10, 2, 2, panel_login);

        }
        Animacion.Animacion.bajar(110, 110, 15, 0, panel_botones); // Bajar panel si el login es correcto

        
       if (btn_configuracion.isEnabled()){
                
            Font font = btn_configuracion.getFont();

            Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
            map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            font = font.deriveFont(map);

            font = font.deriveFont(map);

            btn_configuracion.setFont(font);
        
          }
        
      
        
       
        
        
          if ( !btn_configuracion.isEnabled() && panel_colores.getY()==200) {
            Animacion.Animacion.subir(200, 200, 2, 2, panel_colores);  
              
        }
        
        


    }//GEN-LAST:event_btn_configuracionMouseEntered

    private void btn_configuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_configuracionActionPerformed
        // TODO add your handling code here:

  
        
        
        String nombre = btn_configuracion.getText();

        if (nombre.equals("Configuración")) {
            btn_configuracion.setIcon(new ImageIcon("src/Image_2/fecha_arriba.png"));
            btn_configuracion.setText("Ver menos");
            btn_cambiar_clave.setVisible(true);
            btn_editar_vehiculo.setVisible(true);
              btn_apariencia.setVisible(true);
              
           
             

        } else if (nombre.equals("Ver menos")) {
            btn_configuracion.setIcon(new ImageIcon("src/Image_2/congi_sinfondo.png"));
            btn_configuracion.setText("Configuración");
            btn_cambiar_clave.setVisible(false);
            btn_editar_vehiculo.setVisible(false);
             btn_apariencia.setVisible(false);
              
             
              
        }


    }//GEN-LAST:event_btn_configuracionActionPerformed

    private void btn_configuracionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_configuracionMouseExited
        // TODO add your handling code here:

      
        
        
        
        int posicion = btn_esconder.getX();
        if (posicion > 10) {

            Animacion.Animacion.mover_derecha(360, 360, 2, 2, btn_esconder);
            Animacion.Animacion.mover_derecha(10, 10, 2, 2, panel_login);

        } else {
            Animacion.Animacion.mover_izquierda(10, 10, 2, 2, btn_esconder);
            Animacion.Animacion.mover_izquierda(-350, 10, 2, 2, panel_login);

        }

        Animacion.Animacion.bajar(110, 110, 15, 0, panel_botones); // Bajar panel si el login es correcto

        
         if (btn_configuracion.isEnabled()){
               
            Font font = btn_configuracion.getFont();

            Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
            map.put(TextAttribute.UNDERLINE, -1);
            font = font.deriveFont(map);

             font = font.deriveFont(map);
        
            btn_configuracion.setFont(font);
         }
      
        
        

        
              
          if ( !btn_configuracion.isEnabled() && panel_colores.getY()==200) {
            Animacion.Animacion.subir(200, 200, 2, 2, panel_colores);  
              
        }
           
           
    }//GEN-LAST:event_btn_configuracionMouseExited

    private void txt_confir_claveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_confir_claveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_confir_claveActionPerformed

    private void btn_cambiar_claveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cambiar_claveActionPerformed
        // TODO add your handling code here:
    
           Bloquear_Aplastar_bnt_colore_clave(); ///OJOOJJO
           
           
           panel_cambiar_clave.setVisible(true);
           
           
           
        
        
        

    }//GEN-LAST:event_btn_cambiar_claveActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked

    Volver_estado_inicial();
     boton_x_confi_vehi_cambi_clav();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void btn_esconderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_esconderMouseEntered
        // TODO add your handling code here:
        
        
        if (panel_cambiar_clave.isVisible() ||  panel_colores.getY()==200) {
            btn_esconder.setCursor(cursor_espera);
        } else {
            btn_esconder.setCursor(cursor_mano);
            
        }
    }//GEN-LAST:event_btn_esconderMouseEntered

    private void btn_ing_vehiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ing_vehiMouseEntered
        // TODO add your handling code here:

        if (!panel_cambiar_clave.isVisible() && panel_colores.getY()>200) {
            btn_ing_vehi.setCursor(cursor_mano);
           
            
          LineBorder border = new LineBorder(label_titulo_principal.getBackground(),3, true);
             btn_ing_vehi.setBorder(border);
        
        } else {
            btn_ing_vehi.setCursor(cursor_espera);
        }
    }//GEN-LAST:event_btn_ing_vehiMouseEntered

    private void btn_listarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_listarMouseEntered
        // TODO add your handling code here:

        if (!panel_cambiar_clave.isVisible() &&  panel_colores.getY()>200) {
            btn_listar.setCursor(cursor_mano);
            LineBorder border = new LineBorder(label_titulo_principal.getBackground(),3, true);
              btn_listar.setBorder(border);

        } else {
            btn_listar.setCursor(cursor_espera);
        }


    }//GEN-LAST:event_btn_listarMouseEntered

    private void btn_sacar_vehiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sacar_vehiMouseEntered
        // TODO add your handling code here:
        if (!panel_cambiar_clave.isVisible() &&  panel_colores.getY()>200) {
            btn_sacar_vehi.setCursor(cursor_mano);
             LineBorder border = new LineBorder(label_titulo_principal.getBackground(),3, true);
              btn_sacar_vehi.setBorder(border);

        } else {
            btn_sacar_vehi.setCursor(cursor_espera);
        }


    }//GEN-LAST:event_btn_sacar_vehiMouseEntered

    private void btn_registrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registrarMouseEntered
        // TODO add your handling code here:
        if (!panel_cambiar_clave.isVisible() &&  panel_colores.getY()>200) {
            btn_registrar.setCursor(cursor_mano);
             LineBorder border = new LineBorder(label_titulo_principal.getBackground(),3, true);
              btn_registrar.setBorder(border);

        } else {
            btn_registrar.setCursor(cursor_espera);
        }


    }//GEN-LAST:event_btn_registrarMouseEntered

    private void btn_listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listarActionPerformed
        // TODO add your handling code here:

        if (!panel_cambiar_clave.isVisible()  &&  panel_colores.getY()>200 ){
                  
        tabla_ingreso pasar = new tabla_ingreso(this,true);
        pasar.show();
        }
  
        
        
    }//GEN-LAST:event_btn_listarActionPerformed

    private void txt_clave_actualFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clave_actualFocusLost
        // TODO add your handling code here:
        
       //boton actulizar_clave esta bloqueado desde las propiedades

       if (!txt_clave_actual.getText().isEmpty()){
            String con_actual = txt_pass.getText();   
        String con_tomar = txt_clave_actual.getText();
        

        if (con_actual.equals(con_tomar)) {

            label_pass_NO_coincide.setVisible(false);
        } else {
            label_pass_NO_coincide.setVisible(true);
            txt_clave_actual.setText("");
        
        }
       } 
       
      
    }//GEN-LAST:event_txt_clave_actualFocusLost

    private void txt_clave_actualFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clave_actualFocusGained
        // TODO add your handling code here:

        label_pass_NO_coincide.setVisible(false);
    }//GEN-LAST:event_txt_clave_actualFocusGained

    private void txt_clave_nuevaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clave_nuevaFocusLost
        // TODO add your handling code here:
        
        
        if (!txt_clave_nueva.getText().isEmpty()){
            int datos = validar.Validar_Usuario_contrase(txt_clave_nueva.getText());
        
        if (datos!=2){
            label_parametros.setVisible(true);
            txt_confir_clave.setEditable(false);
        }else{
              txt_confir_clave.setEditable(true);
        }
        }
        
        
        
        
        
    }//GEN-LAST:event_txt_clave_nuevaFocusLost

    private void txt_clave_nuevaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_clave_nuevaFocusGained
        // TODO add your handling code here:
         label_parametros.setVisible(false);
    }//GEN-LAST:event_txt_clave_nuevaFocusGained

    private void txt_confir_claveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_confir_claveKeyReleased
        // TODO add your handling code here:
        
        int longi = txt_clave_nueva.getText().length();
        int long2 = txt_confir_clave.getText().length();
      
           String nombre = "";
        Color color  = null;
        if (long2 ==longi &&  txt_clave_nueva.getText().equals(txt_confir_clave.getText())){
             label_confirma.setVisible(true); 
            nombre ="Contraseñas Iguales"; 
             btn_update_clave.setEnabled(true);
             color = Color.blue;
             
            
            
        }else if ((long2 ==longi || long2>longi)  &&  !txt_clave_nueva.getText().equals(txt_confir_clave.getText())){
              nombre = "Contraseñas no coinciden"; 
              label_confirma.setVisible(true);
             
              btn_update_clave.setEnabled(false);   
               color = Color.red;
            
        }else if (long2<longi){
             btn_update_clave.setEnabled(false);   
            
        }
        label_confirma.setText(nombre);
        label_confirma.setForeground(color);
    }//GEN-LAST:event_txt_confir_claveKeyReleased

    private void txt_confir_claveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_confir_claveFocusGained
        // TODO add your handling code here:
         label_confirma.setVisible(false);
    }//GEN-LAST:event_txt_confir_claveFocusGained

    private void btn_update_claveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_update_claveFocusGained
        // TODO add your handling code here:
        
        
        if (!txt_clave_nueva.getText().equals(txt_confir_clave.getText()) || (!txt_clave_actual.getText().equals(txt_pass.getText()))){
            label_confirma.setVisible(true);
            btn_update_clave.setEnabled(false);
        }else{
             label_confirma.setVisible(false);
            btn_update_clave.setEnabled(true);
        }
        
        
        
    }//GEN-LAST:event_btn_update_claveFocusGained

    private void txt_clave_actualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_clave_actualKeyReleased
        // TODO add your handling code here:
      
        if (txt_clave_actual.getText().equals(txt_pass.getText())  &&  label_confirma.getText().equals("Contraseñas Iguales") ){
            btn_update_clave.setEnabled(true);
        }else{
             btn_update_clave.setEnabled(false); 
        }
        
        
        
        
    }//GEN-LAST:event_txt_clave_actualKeyReleased

    private void txt_clave_actualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_clave_actualKeyPressed
        // TODO add your handling code here:
        char letra = evt.getKeyChar();
        if (letra ==KeyEvent.VK_ENTER){
            txt_clave_nueva.requestFocus();
        }
    }//GEN-LAST:event_txt_clave_actualKeyPressed

    private void txt_clave_nuevaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_clave_nuevaKeyPressed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_txt_clave_nuevaKeyPressed

    private void btn_update_claveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_claveActionPerformed
        // TODO add your handling code here:
        
       
        
        if (!txt_clave_actual.getText().isEmpty() && !txt_clave_nueva.getText().isEmpty() && !txt_confir_clave.getText().isEmpty()){
            String opciones[]= {"Actualizar","Cancelar"};
                
               int con = JOptionPane.showOptionDialog(panel_cambiar_clave, "      ¿Seguro de Actulizar contraseña?", "Sistema  de Parqueo", 1, 1, null, opciones, opciones[1]);
                if (con == 0) {
                   
                 int t=   datos .setActualizar_estado_ingreso(txtx_usuario.getText(), txt_confir_clave.getText(), 0,2,null,"","","","",0,0,0);
                   
                 if (t!=0){

                       JOptionPane.showMessageDialog(panel_cambiar_clave, "    Datos Guardados correctamente");
                     ///  Enabled_campos_Pan_Clave();
                       Label_Cerrar_Session(true);
                                             
                 }
                    
                }
                   
        }else{
            JOptionPane.showMessageDialog(this, "     Hay campos Vacios");
                    
                    
        }
        
        
    }//GEN-LAST:event_btn_update_claveActionPerformed

    private void btn_ing_vehiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ing_vehiMouseExited
        // TODO add your handling code here:
          if (!panel_cambiar_clave.isVisible()) { 
              
                  LineBorder border_salida = new LineBorder( label_dar_color_border.getForeground(),3, true);
              btn_ing_vehi.setBorder(border_salida);
        }
        
    }//GEN-LAST:event_btn_ing_vehiMouseExited

    private void btn_listarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_listarMouseExited
        // TODO add your handling code here:
            if (!panel_cambiar_clave.isVisible()) {   
                  LineBorder border_salida = new LineBorder( label_dar_color_border.getForeground(),3, true);
              btn_listar.setBorder(border_salida);
        }
        
    }//GEN-LAST:event_btn_listarMouseExited

    private void btn_sacar_vehiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sacar_vehiMouseExited
        // TODO add your handling code here:.
            if (!panel_cambiar_clave.isVisible()) {   
              LineBorder border_salida = new LineBorder( label_dar_color_border.getForeground(),3, true);
              btn_sacar_vehi.setBorder(border_salida);
        }
        
    }//GEN-LAST:event_btn_sacar_vehiMouseExited

    private void btn_registrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registrarMouseExited
        // TODO add your handling code here:
            if (!panel_cambiar_clave.isVisible()) {  
               LineBorder border_salida = new LineBorder( label_dar_color_border.getForeground(),3, true);
              btn_registrar.setBorder(border_salida);
        }
        
    }//GEN-LAST:event_btn_registrarMouseExited

    private void btn_editar_vehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar_vehiculoActionPerformed
        // TODO add your 
         
        /*
        combo_cargar_vehiculos.removeAllItems();
         datos.sql_Tabla_Tipo_Vehiculos(combo_cargar_vehiculos, "", 0, true, 0);
             Bloquear_Aplastar_bnt_colore_clave();
 
            if (Panel_actualizar.getX() > 200) {
            Animacion.Animacion.mover_izquierda(1100, 290, 2, 2, Panel_actualizar);
            ///btn_ingresar.setEnabled(false);

        }
            
       */
        
        Agregar_Vehiculo pasar_for= new Agregar_Vehiculo(this, true);
        
        pasar_for.setLocation(420, 250);
        
        //pasar_for.setLocationRelativeTo(null);
        pasar_for.setVisible(true);
        
     
       
    }//GEN-LAST:event_btn_editar_vehiculoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowOpened

    private void panel_principalMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_principalMouseMoved
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_panel_principalMouseMoved

    private void panel_principalMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_principalMouseDragged
        // TODO add your handling code here:


    }//GEN-LAST:event_panel_principalMouseDragged

    private void panel_principalMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_panel_principalMouseWheelMoved
        // TODO add your handling code here:
  
    }//GEN-LAST:event_panel_principalMouseWheelMoved

    private void btn_editar_vehiculoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editar_vehiculoMouseMoved
        // TODO add your handling code here:
        
  
    }//GEN-LAST:event_btn_editar_vehiculoMouseMoved

    private void panel_principalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_principalMouseEntered
        // TODO add your handling code here:
        panel_principal.requestFocusInWindow();

    }//GEN-LAST:event_panel_principalMouseEntered

    private void combo_colores_fondoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_colores_fondoActionPerformed
        // TODO add your handling code here:

        String nombre_color =  (String ) combo_colores_fondo.getSelectedItem();
    
        if (!nombre_color .equals("Seleccionar")){
            colores.get_Colores(nombre_color,true,0,0,0);
             Color color =  new Color (colores.GetRojo(),colores.getVerde(),colores.getAzul());
        
            panel_principal.setBackground(color);
            panel_botones.setBackground(color);
            panel_login.setBackground(color);
            panel_colores.setBackground(color);
            panel_cambiar_clave.setBackground(color);
            
        }
             
    }//GEN-LAST:event_combo_colores_fondoActionPerformed

    private void combo_colores_letraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_colores_letraActionPerformed
   
        
           String nombre_color =  (String ) combo_colores_letra.getSelectedItem();
    
        if (!nombre_color .equals("Seleccionar")){
            colores.get_Colores(nombre_color,true,0,0,0);
             Color color =  new Color (colores.GetRojo(),colores.getVerde(),colores.getAzul());
                      
         btn_listar.setForeground(color);
           btn_ing_vehi.setForeground(color );
           btn_registrar.setForeground(color );
           btn_sacar_vehi.setForeground(color );
           btn_editar_vehiculo.setForeground(color );
           btn_configuracion.setForeground(color );
           btn_cambiar_clave.setForeground(color );
           btn_apariencia.setForeground(color );
           btn_colores_aplicar.setForeground(color );
           btn_colores_cancelar.setForeground(color );
          
           btn_update_clave.setForeground(color );
           btn_Ingresar.setForeground(color );
           btn_agg_color.setForeground(color);
           btn_listar_salida.setForeground(color);
             
            
        }


    }//GEN-LAST:event_combo_colores_letraActionPerformed

    private void combo_colores_bordeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_colores_bordeActionPerformed
        // TODO add your handling code here:
        
        
             String nombre_color =  (String ) combo_colores_borde.getSelectedItem();
    
        if (!nombre_color .equals("Seleccionar")){
            colores.get_Colores(nombre_color,true,0,0,0);
             Color color =  new Color (colores.GetRojo(),colores.getVerde(),colores.getAzul());
             label_dar_color_border.setForeground(color);
                LineBorder border = new LineBorder(color,3, true);
               /// label_borde_fino.setBackground(establecer_color);
                panel_principal.setBorder(border);
                panel_cambiar_clave.setBorder(border);
              
                panel_colores.setBorder(border);
                panel_login.setBorder(border);
                ///Color border de los titulos
                 label_titulo_confi_clave.setBorder(border);
                 label_titulo_confi_colores.setBorder(border);
               
                 label_titulo_principal.setBorder(border);
                 label_titulo_login.setBorder(border);
                 
                 ////////////Color botones bordess
                  btn_listar.setBorder(border);
                 btn_ing_vehi.setBorder(border );
                btn_registrar.setBorder(border );
                btn_sacar_vehi.setBorder(border);
                btn_editar_vehiculo.setBorder(border);
                btn_configuracion.setBorder(border );
                btn_cambiar_clave.setBorder(border );
                 btn_apariencia.setBorder(border);
                 btn_colores_aplicar.setBorder(border);
                btn_colores_cancelar.setBorder(border );
              
                btn_update_clave.setBorder(border );
                btn_Ingresar.setBorder(border);
                btn_agg_color.setBorder(border);
                btn_listar_salida.setBorder(border);
                
            
        }

        
    }//GEN-LAST:event_combo_colores_bordeActionPerformed

    private void btn_colores_aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_colores_aplicarActionPerformed
        // TODO add your handling code here:
       
    int pos_1 =combo_colores_borde.getSelectedIndex();
    int pos_2 = combo_colores_fondo.getSelectedIndex();
    int pos_3 = combo_colores_fondo_itulos.getSelectedIndex();
    int pos_4 = combo_colores_letra.getSelectedIndex();
    int pos_5 = combo_colores_letra_titulos.getSelectedIndex();
    
    
    if (pos_1 ==0 || pos_2 ==0 || pos_3 ==0 || pos_4 ==0 ||pos_5 ==0){
        
        
        JOptionPane.showMessageDialog(this, "Tienes colores sin seleccionar , " + "\nNota: Si deseas mantener el mismo color, elije nuevamente el color ");
    }else{
        
        
        String opciones []  = {"Aplicar"," Cancelar"};
        
        
       
        int re = JOptionPane.showOptionDialog(panel_colores, "Conservar Cambios", "Sistema de Parqueo", 0, 0, null, opciones, opciones[1]);
        
        if (re==0){
   
            String color_fondo =combo_colores_fondo.getSelectedItem().toString();
            String color_letra_titulos=combo_colores_letra_titulos.getSelectedItem().toString();
        
            String color_letra_funciones=combo_colores_letra.getSelectedItem().toString();
            String color_borde=  combo_colores_borde.getSelectedItem().toString();
            String color_fondo_titulos= combo_colores_fondo_itulos.getSelectedItem().toString();
            
           
            
           int tr = colores.nombres_Color_funciones(false,  color_fondo,color_borde,color_fondo_titulos, color_letra_titulos,color_letra_funciones);

            if (tr!=0){
                JOptionPane.showMessageDialog(this, "Cambio exitosos");
                Poner_curso_index_0_colore();
            }
            
          
        }
    }
        
        
        
    }//GEN-LAST:event_btn_colores_aplicarActionPerformed

    private void combo_colores_letra_titulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_colores_letra_titulosActionPerformed
        // TODO add your handling code here:
           String nombre_color =  (String ) combo_colores_letra_titulos.getSelectedItem();
        
           if (!nombre_color .equals("Seleccionar")){
                colores.get_Colores(nombre_color,true,0,0,0);
                 Color color =  new Color (colores.GetRojo(),colores.getVerde(),colores.getAzul());
                     label_titulo_confi_clave.setForeground(color);
                    label_titulo_confi_colores.setForeground(color);
                   
                    label_titulo_principal.setForeground(color);
                    label_titulo_login.setForeground(color);
     
            
        }

    }//GEN-LAST:event_combo_colores_letra_titulosActionPerformed

    private void combo_colores_fondo_itulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_colores_fondo_itulosActionPerformed
        // TODO add your handling code here:
        
          String nombre_color =  (String ) combo_colores_fondo_itulos.getSelectedItem();
        
           if (!nombre_color .equals("Seleccionar")){
                colores.get_Colores(nombre_color,true,0,0,0);
                Color color =  new Color (colores.GetRojo(),colores.getVerde(),colores.getAzul());
                     
         
                 label_titulo_confi_clave.setBackground(color);
                label_titulo_confi_colores.setBackground(color);
              
                label_titulo_principal.setBackground(color);
               label_titulo_login.setBackground(color);
            
        }
 
    }//GEN-LAST:event_combo_colores_fondo_itulosActionPerformed

    private void btn_colores_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_colores_cancelarActionPerformed
  
   
    Restablecer();
     Poner_curso_index_0_colore();
        
        
        
    }//GEN-LAST:event_btn_colores_cancelarActionPerformed

    private void combo_colores_fondoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_colores_fondoMouseClicked
        // TODO add your handling code here:
        
 
    }//GEN-LAST:event_combo_colores_fondoMouseClicked

    private void btn_guardar_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_colorActionPerformed
        // TODO add your handling code here:
        
          if (panel_colores.getY()==200){
              Animacion.Animacion.subir(200, 200, 2, 2, panel_colores);  
        }
        
        int r = slider_rojo.getValue();
        int v= slider_verde.getValue();
        int a = slider_azul.getValue();
        if ( r==0 && v==0 && a==0){
            
            
            JOptionPane.showMessageDialog(panel_colores, "Genera un color porfavor , desliza las barras");
        }else{
          
                colores.get_Colores(txt_nombre_color.getText(),true,0,0,0);
            if (txt_nombre_color.getText().equals("")){
                label_color_name_regi.setText("Ingresa un nombre para el color");
                  label_color_name_regi.setVisible(true);
                
                
            }else if (colores.getNombre_color().equalsIgnoreCase(txt_nombre_color.getText())){
                   label_color_name_regi.setVisible(true);
                
            }
            else  if (!colores.getNombre_color().equals(txt_nombre_color.getText())){
                
                colores.get_Colores(txt_nombre_color.getText(), false, slider_rojo.getValue(),slider_verde.getValue(), slider_azul.getValue());
                
                  JOptionPane.showMessageDialog(panel_colores, "Color guardado Correctamente"  + "\nNota Importante: " + 
                          "\nLos colores creados se actualizaran en la  barra " + "\nde colores , despues de reiniciar el sistema.");
                  slider_rojo.setValue(0);
                  slider_verde.setValue(0);
                  slider_azul.setValue(0);
                  txt_nombre_color.setText("");
            }
            
        }
           if (panel_colores.getY()==200){
              Animacion.Animacion.subir(200, 200, 2, 2, panel_colores);  
        }
        
        
     
    }//GEN-LAST:event_btn_guardar_colorActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
               


   
    }//GEN-LAST:event_formWindowActivated

    private void slider_rojoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_slider_rojoPropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_slider_rojoPropertyChange

    private void slider_rojoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_rojoStateChanged
        // TODO add your handling code here:
        
        
        label_color_generadp.setForeground( new Color (slider_rojo.getValue(), slider_verde.getValue(), slider_azul.getValue()));
    }//GEN-LAST:event_slider_rojoStateChanged

    private void slider_rojoVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_slider_rojoVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_slider_rojoVetoableChange

    private void slider_verdeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_verdeStateChanged
        // TODO add your handling code here:
                label_color_generadp.setForeground( new Color (slider_rojo.getValue(), slider_verde.getValue(), slider_azul.getValue()));

    }//GEN-LAST:event_slider_verdeStateChanged

    private void slider_azulStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_azulStateChanged
        // TODO add your handling code here:
                label_color_generadp.setForeground( new Color (slider_rojo.getValue(), slider_verde.getValue(), slider_azul.getValue()));

    }//GEN-LAST:event_slider_azulStateChanged

    private void btn_agg_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agg_colorActionPerformed
        // TODO add your handling code here:
        
          if (panel_colores.getY()==200){
              Animacion.Animacion.subir(200, 200, 2, 2, panel_colores);  
        }
       
        
          
        
           String nombre = btn_agg_color.getText();
         
         if (nombre.equals("Agregar Color")){
             
             
               slider_rojo.setEnabled(true);
            slider_verde.setEnabled(true);
            slider_azul.setEnabled(true);
            txt_nombre_color.setEditable(true);    
            btn_guardar_color.setEnabled(true);
            btn_colores_aplicar.setEnabled(false);
            btn_colores_cancelar.setEnabled(false);
            btn_agg_color.setText("Cancelar Color");
            jLabel3.setEnabled(false);
           
            Bloquear_combos_colores();
         }else if (nombre.equals("Cancelar Color")){
      
             txt_nombre_color.setText("");
             
             
              Bloquear_Slider();
              btn_colores_aplicar.setEnabled(true);
              btn_colores_cancelar.setEnabled(true);
                jLabel3.setEnabled(true);
              btn_agg_color.setText("Agregar Color");
              slider_rojo.setValue(0);
             slider_verde.setValue(0);
             slider_azul.setValue(0);
               desblquear_combos_colores();
             
         }
                   if (panel_colores.getY()==200){
              Animacion.Animacion.subir(200, 200, 2, 2, panel_colores);  
        }
             
        
    }//GEN-LAST:event_btn_agg_colorActionPerformed

    private void txt_nombre_colorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nombre_colorFocusGained
        // TODO add your handling code here:
        
          if (panel_colores.getY()==200){
              Animacion.Animacion.subir(200, 200, 2, 2, panel_colores);  
        }      
       
          label_color_name_regi.setText("Nombre color ya esta registrado");
          label_color_name_regi.setVisible(false);
    }//GEN-LAST:event_txt_nombre_colorFocusGained

    private void btn_aparienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aparienciaActionPerformed
        // TODO add your handling code here:
        
         Bloquear_Aplastar_bnt_colore_clave();
         int posicion_actual = panel_colores.getY();

        if (posicion_actual >250) {
            Animacion.Animacion.subir(750, 200, 2, 2, panel_colores);  
              
        }
        
    }//GEN-LAST:event_btn_aparienciaActionPerformed

    private void panel_coloresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_coloresMouseEntered
        // TODO add your handling code here:
          if (panel_colores.getY()==200){
              Animacion.Animacion.subir(200, 200, 2, 2, panel_colores);  
        }
    }//GEN-LAST:event_panel_coloresMouseEntered

    private void panel_coloresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_coloresMouseExited
        // TODO add your handling code here:
          if (panel_colores.getY()==200){
              Animacion.Animacion.subir(200, 200, 2, 2, panel_colores);  
        }
    }//GEN-LAST:event_panel_coloresMouseExited

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        // TODO add your handling code here:
        
         if (jLabel3.isEnabled()){
              if (combo_colores_borde.getSelectedIndex()==0 && combo_colores_fondo.getSelectedIndex()==0  
                && combo_colores_fondo_itulos.getSelectedIndex()==0 && combo_colores_letra_titulos.getSelectedIndex()==0 && combo_colores_letra.getSelectedIndex()==0  ){
         Animacion.Animacion.bajar(200, 750, 2, 2, panel_colores);  
         Poner_curso_index_0_colore();
         boton_x_confi_vehi_cambi_clav();
        }else{
            
            String [] opciones ={"Salir sin guardar cambios","Permanecer"};
            int  elegir =9;
      
             elegir  =  JOptionPane.showOptionDialog(panel_colores,"¿Ah realizado Cambios Que Actualmente No se Han Guardado" , "Sistema  de Parqueo", 0, 0, null, opciones, opciones[1]);
                 
             if (elegir==0){
                 Poner_curso_index_0_colore();
                 Restablecer();
                 boton_x_confi_vehi_cambi_clav();
                 Animacion.Animacion.bajar(200, 750, 2, 2, panel_colores); 
             }
          
              
        }  
         }
            
    }//GEN-LAST:event_jLabel3MousePressed

    private void btn_listar_salidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_listar_salidaMouseEntered
        // TODO add your handling code here:
          if (!panel_cambiar_clave.isVisible()   && panel_colores.getY()>200) {
            btn_listar_salida.setCursor(cursor_mano);
           
            
          LineBorder border = new LineBorder(label_titulo_principal.getBackground(),3, true);
             btn_listar_salida.setBorder(border);
        
        } else {
            btn_listar_salida.setCursor(cursor_espera);
        }
    }//GEN-LAST:event_btn_listar_salidaMouseEntered

    private void btn_listar_salidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_listar_salidaMouseExited
        // TODO add your handling code here:
             if (!panel_cambiar_clave.isVisible()) { 
              
                  LineBorder border_salida = new LineBorder( label_dar_color_border.getForeground(),3, true);
              btn_listar_salida.setBorder(border_salida);
        }
    }//GEN-LAST:event_btn_listar_salidaMouseExited

    private void btn_listar_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listar_salidaActionPerformed
        // TODO add your handling code here:
       
          if (!panel_cambiar_clave.isVisible()   && panel_colores.getY()>200 ){
                     
             // Intruccion_sql pasar_tipo_usuario = new Intruccion_sql();        
          
             datos.Actualizar_Tipo_Usuario(label_tipo_usu.getText(),true,0); //actualizo el tipo_usuario en la tabla  tipo_usuario para 
             //si es admin cree una tabla con el boton eliminar o si no lo cree
             tabla_salida pasar = new tabla_salida(this, true);
            pasar.show();
        }
  
         
        
        
       
    }//GEN-LAST:event_btn_listar_salidaActionPerformed

    private void btn_cambiar_claveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cambiar_claveMouseEntered
        // TODO add your handling code here:
        
        LineBorder border = new LineBorder(label_titulo_principal.getBackground(),3, true);
             btn_cambiar_clave.setBorder(border);
        
         
      
       
    }//GEN-LAST:event_btn_cambiar_claveMouseEntered

    private void btn_editar_vehiculoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editar_vehiculoMouseEntered
        // TODO add your handling code here:
         LineBorder border = new LineBorder(label_titulo_principal.getBackground(),3, true);
             btn_editar_vehiculo.setBorder(border);
  
       
    }//GEN-LAST:event_btn_editar_vehiculoMouseEntered

    private void btn_aparienciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_aparienciaMouseEntered
        // TODO add your handling code here:
              LineBorder border = new LineBorder(label_titulo_principal.getBackground(),3, true);
             btn_apariencia.setBorder(border);
    
          
    }//GEN-LAST:event_btn_aparienciaMouseEntered

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        
        if (!label_salir.isEnabled()){ //si el label  salir esta bloquead quiere decir que el panel clave o panel colores esta en la pantalla
            jLabel2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }else{
            jLabel2.setCursor(cursor_mano);
        }
    }//GEN-LAST:event_jLabel2MouseEntered

    private void label_minimarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_minimarMouseClicked
        // TODO add your handling code here:
        
        if (label_salir.isEnabled()){
              this.setExtendedState( ICONIFIED);
        }
       
        
   
    }//GEN-LAST:event_label_minimarMouseClicked

    private void label_minimarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_minimarMousePressed
        // TODO add your handling code here:
          
    }//GEN-LAST:event_label_minimarMousePressed

    private void btn_IngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_IngresarMouseEntered
        // TODO add your handling code here:
        
        btn_Ingresar.setBorder(  new LineBorder(label_titulo_principal.getBackground(),3,true));
         
    }//GEN-LAST:event_btn_IngresarMouseEntered

    private void btn_IngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_IngresarMouseExited
        // TODO add your handling code here:
        btn_Ingresar.setBorder(panel_login.getBorder());
    }//GEN-LAST:event_btn_IngresarMouseExited

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_formKeyPressed

    private void panel_principalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panel_principalKeyPressed
        // TODO add your handling code here:
       
        if (evt.getKeyChar() ==KeyEvent.VK_ESCAPE){
            Cerrar_Programa();
            
        }
         if (panel_botones.isVisible() &&  panel_botones.getY()>=110){
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_F1:
                    {
                        Ingreso pasar = new Ingreso(this, true);
                        pasar.setVisible(true);
                        break;
                    }
                case KeyEvent.VK_F2:
                    {
                        tabla_ingreso pasar = new tabla_ingreso(this, true);
                        pasar.setVisible(true);
                        break;
                    }
                case KeyEvent.VK_F3:
                    {
                        tabla_salida pasar = new tabla_salida(this, true);
                        pasar.setVisible(true);
                        break;
                    }
                    case KeyEvent.VK_F4:
                    {
                        Salida pasar = new Salida(this, true);
                        pasar.setVisible(true);
                        break;
                    }
                    case KeyEvent.VK_F5:
                    {
                        Registrarse pasar = new Registrarse(this, true);
                        pasar.setVisible(true);
                        break;
                    }
                    
                    
                default:
                    break;
            }
         }
        
        
    
            
            
    }//GEN-LAST:event_panel_principalKeyPressed

    private void btn_cambiar_claveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cambiar_claveMouseExited
        // TODO add your handling code here:
            LineBorder border_salida = new LineBorder( label_dar_color_border.getForeground(),3, true);
              btn_cambiar_clave.setBorder(border_salida);
    }//GEN-LAST:event_btn_cambiar_claveMouseExited

    private void btn_editar_vehiculoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editar_vehiculoMouseExited
        // TODO add your handling code here:
       LineBorder border_salida = new LineBorder( label_dar_color_border.getForeground(),3, true);
              btn_editar_vehiculo.setBorder(border_salida);
    }//GEN-LAST:event_btn_editar_vehiculoMouseExited

    private void btn_aparienciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_aparienciaMouseExited
        // TODO add your handling code here:
       LineBorder border_salida = new LineBorder( label_dar_color_border.getForeground(),3, true);
             btn_apariencia.setBorder(border_salida);
    }//GEN-LAST:event_btn_aparienciaMouseExited

    private void panel_cambiar_claveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_cambiar_claveMouseEntered
        // TODO add your handling code here:
        panel_cambiar_clave.requestFocusInWindow();
    }//GEN-LAST:event_panel_cambiar_claveMouseEntered

    private void panel_cambiar_claveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panel_cambiar_claveKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() ==KeyEvent.VK_ESCAPE){
             Volver_estado_inicial();
             boton_x_confi_vehi_cambi_clav();
            panel_cambiar_clave.setVisible(false);
            label_pass_NO_coincide.setVisible(false);
            label_parametros.setVisible(false);
            label_confirma.setVisible(false);
        }
    }//GEN-LAST:event_panel_cambiar_claveKeyPressed

    private void label_recupe_passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_recupe_passMouseClicked
        // TODO add your handling code here:
        Recupe_Pass pasar  = new Recupe_Pass(this,  true);
        pasar.setLocationRelativeTo(null);
        pasar.setVisible(true);
    }//GEN-LAST:event_label_recupe_passMouseClicked

    private void label_recupe_passMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_recupe_passMouseEntered
        // TODO add your handling code here:
        
       label_recupe_pass.setForeground(Color.GREEN);
    }//GEN-LAST:event_label_recupe_passMouseEntered

    private void label_recupe_passMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_recupe_passMouseExited
        // TODO add your handling code here:
    label_recupe_pass.setForeground(Color.BLACK);
    }//GEN-LAST:event_label_recupe_passMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Ingresar;
    private javax.swing.JButton btn_agg_color;
    private javax.swing.JButton btn_apariencia;
    private javax.swing.JButton btn_cambiar_clave;
    private javax.swing.JButton btn_colores_aplicar;
    private javax.swing.JButton btn_colores_cancelar;
    private javax.swing.JButton btn_configuracion;
    private javax.swing.JButton btn_editar_vehiculo;
    private javax.swing.JButton btn_esconder;
    private javax.swing.JButton btn_guardar_color;
    private javax.swing.JButton btn_ing_vehi;
    private javax.swing.JButton btn_listar;
    private javax.swing.JButton btn_listar_salida;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JButton btn_sacar_vehi;
    private javax.swing.JButton btn_update_clave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combo_colores_borde;
    private javax.swing.JComboBox<String> combo_colores_fondo;
    private javax.swing.JComboBox<String> combo_colores_fondo_itulos;
    private javax.swing.JComboBox<String> combo_colores_letra;
    private javax.swing.JComboBox<String> combo_colores_letra_titulos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JCheckBox jchec_admin;
    private javax.swing.JCheckBox jchec_empleado;
    private javax.swing.JLabel label_activo;
    private javax.swing.JLabel label_color_generadp;
    private javax.swing.JLabel label_color_name_regi;
    private javax.swing.JLabel label_confirma;
    private javax.swing.JLabel label_dar_color_border;
    private javax.swing.JLabel label_estado;
    private javax.swing.JLabel label_fecha;
    private javax.swing.JLabel label_inc;
    private javax.swing.JLabel label_minimar;
    private javax.swing.JLabel label_parametros;
    private javax.swing.JLabel label_pass_NO_coincide;
    private javax.swing.JLabel label_recupe_pass;
    private javax.swing.JLabel label_salir;
    private javax.swing.JLabel label_tipo_usu;
    private javax.swing.JLabel label_tipo_usuario;
    private javax.swing.JLabel label_titulo_confi_clave;
    private javax.swing.JLabel label_titulo_confi_colores;
    private javax.swing.JLabel label_titulo_login;
    private javax.swing.JLabel label_titulo_principal;
    private javax.swing.JPanel panel_botones;
    private javax.swing.JPanel panel_cambiar_clave;
    private javax.swing.JPanel panel_colores;
    private javax.swing.JPanel panel_login;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JSlider slider_azul;
    private javax.swing.JSlider slider_rojo;
    private javax.swing.JSlider slider_verde;
    private javax.swing.JTextField txt_clave_actual;
    private javax.swing.JTextField txt_clave_nueva;
    private javax.swing.JTextField txt_confir_clave;
    private javax.swing.JTextField txt_nombre_color;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txtx_usuario;
    // End of variables declaration//GEN-END:variables

    
    ///Variables
     int b =0;
    private Intruccion_sql datos;
    private  Logica_Colores colores ;
  
    int i = 0;
    private Color color = new Color(51, 51, 0);
    private Color color_border = new Color(0,204,0); 
       private Color color_bor = new Color(0,153,153); 
       ////////////////////////////////////////////////////////////////////
    
    private Cursor cursor_espera = new Cursor(Cursor.WAIT_CURSOR);
    private Cursor cursor_mano = new Cursor(Cursor.HAND_CURSOR);
    private Validacion_txt validar; 
    Color establecer_color = null;
   
}
