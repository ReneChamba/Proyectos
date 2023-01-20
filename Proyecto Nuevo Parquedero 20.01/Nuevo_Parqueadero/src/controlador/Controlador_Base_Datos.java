package controlador;

import java.awt.Color;
import vista.Exportar_Base;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import modelo.Constantes;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import mensajes.Joption;
import modelo.Fuentes_Y_Mas;
import modelo.Iconos;
import modelo.Transparente;

public class Controlador_Base_Datos implements ActionListener {
    
    private Exportar_Base exportar_base;
    private Constantes constantes;
    private Fuentes_Y_Mas fuentes_Y_Mas;
    private Joption mensaje;
    private Iconos iconos;
    private Controlador_Sms controlador_sms;
    
    public Controlador_Base_Datos(Exportar_Base exportar_base) {
        
    }
    
    public void setExportar_Base(Exportar_Base exportar_base) {
        this.exportar_base = exportar_base;
    }
    
    public void setFuentes_Y_Mas(Fuentes_Y_Mas fuentes_Y_Mas) {
        this.fuentes_Y_Mas = fuentes_Y_Mas;
    }
    
    public void setMensajes(Joption mensajes_2) {
        this.mensaje = mensajes_2;
    }
    
    public void setIconos(Iconos iconos) {
        this.iconos = iconos;
    }
    
    public void setConstantes(Constantes constantes) {
        
        this.constantes = constantes;
        
    }
    
    public void setLanzar_Mensaje(Controlador_Sms controlador_sms) {
        this.controlador_sms = controlador_sms;
    }
    
    public void Estado_Contructor() {
        
        exportar_base.txt_ruta.setEditable(false);
        exportar_base.btn_guardar_base.setEnabled(false);
        exportar_base.btn_seleccion_ruta.addActionListener(this);
        exportar_base.btn_guardar_base.addActionListener(this);
        exportar_base.btn_habilitar.addActionListener(this);
        exportar_base.btn_habilitar.setEnabled(false);
        
        exportar_base.ch_Tabla_vehi_retirados.addActionListener(this);
        exportar_base.ch_Tabla_conf_sistema.addActionListener(this);
        exportar_base.ch_Tabla_colores.addActionListener(this);
        exportar_base.ch_Tabla_name_funciones.addActionListener(this);
        exportar_base.ch_Tabla_tipo_vehiculo.addActionListener(this);
        exportar_base.ch_Tabla_usuarios.addActionListener(this);
        exportar_base.ch_Tabla_veh_ingresados.addActionListener(this);
        
        exportar_base.check_tabla_lavado.addActionListener(this);
        exportar_base.check_tabla_parqueo_mas_lavado.addActionListener(this);

        //===========================================================
        exportar_base.setResizable(false);
        exportar_base.setTitle(fuentes_Y_Mas.getTitulo());
        fileElegir = new JFileChooser(); // cre un objeto
        //metodo para indicar que solo se permita elegir o solo muestre directorios
        // carpetas, hay mas valores para elegir : constante 1
        fileElegir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        numero_tablas = 9;
        exportar_base.num_tablas.setText("" + numero_tablas);
        
        Diseno();
        Evento_Ventana();
        Seleccionar_Check(true);
        
    }
    
    private void Diseno() {
        
        exportar_base.lb_titulo.setFont(fuentes_Y_Mas.getLetra_Titulos());
        
        exportar_base.ch_Tabla_colores.setFont(fuentes_Y_Mas.getLetra_label());
        exportar_base.ch_Tabla_conf_sistema.setFont(fuentes_Y_Mas.getLetra_label());
        exportar_base.ch_Tabla_name_funciones.setFont(fuentes_Y_Mas.getLetra_label());
        exportar_base.ch_Tabla_tipo_vehiculo.setFont(fuentes_Y_Mas.getLetra_label());
        exportar_base.ch_Tabla_usuarios.setFont(fuentes_Y_Mas.getLetra_label());
        exportar_base.ch_Tabla_veh_ingresados.setFont(fuentes_Y_Mas.getLetra_label());
        exportar_base.ch_Tabla_vehi_retirados.setFont(fuentes_Y_Mas.getLetra_label());
        exportar_base.check_tabla_lavado.setFont(fuentes_Y_Mas.getLetra_label());
        exportar_base.check_tabla_parqueo_mas_lavado.setFont(fuentes_Y_Mas.getLetra_label());
        exportar_base.num_tablas.setFont(fuentes_Y_Mas.getLetra_Txt());
        exportar_base.lb_name_tablas.setFont(fuentes_Y_Mas.getLetra_Txt());
        
        Transparente tx_ruta = new Transparente("Selecciona una ruta --->", exportar_base.txt_ruta, Transparente.Show.ALWAYS);
        
        exportar_base.txt_ruta.setFont(fuentes_Y_Mas.getLetra_Txt());
        
        exportar_base.btn_guardar_base.setFont(fuentes_Y_Mas.getLetra_btn());
        
        exportar_base.btn_seleccion_ruta.setIcon(iconos.getIcono_ruta());
        exportar_base.btn_guardar_base.setIcon(iconos.getIcono_guardar_archivo());
        exportar_base.btn_guardar_base.setCursor(fuentes_Y_Mas.getCursor());
        exportar_base.btn_habilitar.setCursor(fuentes_Y_Mas.getCursor());
        exportar_base.btn_seleccion_ruta.setCursor(fuentes_Y_Mas.getCursor());
        
        exportar_base.lb_titulo.setForeground(fuentes_Y_Mas.getColor_titulo());
        exportar_base.btn_guardar_base.setForeground(fuentes_Y_Mas.getColor_letra_btn());
        exportar_base.btn_habilitar.setForeground(fuentes_Y_Mas.getColor_letra_btn());
        exportar_base.btn_guardar_base.setBackground(fuentes_Y_Mas.getColor_Fondo_btn());
        exportar_base.btn_habilitar.setBackground(fuentes_Y_Mas.getColor_Fondo_btn());
        exportar_base.lb_name_tablas.setBorder(fuentes_Y_Mas.getBorderlinea(fuentes_Y_Mas.getColor_Bien()));
    }
    
    public void Iniciar_Componentes() {
        
        exportar_base.setLocation(fuentes_Y_Mas.centrar_Pantalla(exportar_base.getWidth()), 130);
        
        exportar_base.setVisible(true);
        
    }
    
    private String getNameTables() {
        
        String nameTablas = "";
        
        if (Integer.parseInt(exportar_base.num_tablas.getText()) < 9) {
            
            nameTablas += " --tables ";
            if (exportar_base.ch_Tabla_usuarios.isSelected()) {
                
                nameTablas += constantes.getTabla_usuarios() + " ";
            }
            
            if (exportar_base.ch_Tabla_tipo_vehiculo.isSelected()) {
                
                nameTablas += constantes.getTabla_tipo_vehiculos() + " ";
            }
            
            if (exportar_base.ch_Tabla_conf_sistema.isSelected()) {
                
                nameTablas += constantes.getTabla_sistema() + " ";
            }
            if (exportar_base.ch_Tabla_veh_ingresados.isSelected()) {
                
                nameTablas += constantes.getTabla_autos_ingresos() + " ";
            }
            
            if (exportar_base.ch_Tabla_vehi_retirados.isSelected()) {
                
                nameTablas += constantes.getTabla_autos_salidos() + " ";
            }
            
            if (exportar_base.check_tabla_lavado.isSelected()) {
                
                nameTablas += constantes.getTabla_lavado() + " ";
            }
            
            if (exportar_base.check_tabla_parqueo_mas_lavado.isSelected()) {
                
                nameTablas += constantes.getTabla_lavado_Mas_Parqueo() + " ";
            }
            
            if (exportar_base.ch_Tabla_name_funciones.isSelected()) {
                
                nameTablas += constantes.getColores_nombres_funciones() + " ";
            }
            
            if (exportar_base.ch_Tabla_colores.isSelected()) {
                
                nameTablas += constantes.getColores();
            }
            
        }
        
        return nameTablas;
    }
    
    private void Estados_Btn(String texto, boolean estado) {
        
        exportar_base.txt_ruta.setText(texto);
        exportar_base.btn_guardar_base.setEnabled(estado);
        exportar_base.btn_habilitar.setEnabled(estado);
    }
    
    private void Evento_Ventana() {
        
        WindowAdapter evento = new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
                
                Estados_Btn("", false);
                numero_tablas = 9;
                exportar_base.num_tablas.setText("" + numero_tablas);
                Seleccionar_Check(true);
                
            }
            
        };
        exportar_base.addWindowListener(evento);
        
    }
    
    private void Seleccionar_Check(boolean seleccion) {
        
        exportar_base.ch_Tabla_vehi_retirados.setSelected(seleccion);
        exportar_base.ch_Tabla_veh_ingresados.setSelected(seleccion);
        exportar_base.ch_Tabla_usuarios.setSelected(seleccion);
        exportar_base.ch_Tabla_tipo_vehiculo.setSelected(seleccion);
        exportar_base.ch_Tabla_name_funciones.setSelected(seleccion);
        exportar_base.ch_Tabla_conf_sistema.setSelected(seleccion);
        exportar_base.ch_Tabla_colores.setSelected(seleccion);
        exportar_base.check_tabla_lavado.setSelected(seleccion);
        exportar_base.check_tabla_parqueo_mas_lavado.setSelected(seleccion);
        
    }
    
    private void Evento_Check(ActionEvent e) {
        Object check = e.getSource();
        
        if (check == exportar_base.ch_Tabla_usuarios) {
            
            if (exportar_base.ch_Tabla_usuarios.isSelected()) {
                
                numero_tablas++;
            } else {
                numero_tablas--;
            }
            
        }
        
        if (check == exportar_base.ch_Tabla_tipo_vehiculo) {
            
            if (exportar_base.ch_Tabla_tipo_vehiculo.isSelected()) {
                
                numero_tablas++;
            } else {
                numero_tablas--;
            }
            
        }
        
        if (check == exportar_base.ch_Tabla_conf_sistema) {
            
            if (exportar_base.ch_Tabla_conf_sistema.isSelected()) {
                
                numero_tablas++;
            } else {
                numero_tablas--;
            }
            
        }
        
        if (check == exportar_base.ch_Tabla_veh_ingresados) {
            
            if (exportar_base.ch_Tabla_veh_ingresados.isSelected()) {
                
                numero_tablas++;
            } else {
                numero_tablas--;
            }
        }
        
        if (check == exportar_base.ch_Tabla_vehi_retirados) {
            
            if (exportar_base.ch_Tabla_vehi_retirados.isSelected()) {
                
                numero_tablas++;
            } else {
                numero_tablas--;
            }
        }
        
        if (check == exportar_base.check_tabla_lavado) {
            
            if (exportar_base.check_tabla_lavado.isSelected()) {
                
                numero_tablas++;
            } else {
                numero_tablas--;
            }
        }
        
        if (check == exportar_base.check_tabla_parqueo_mas_lavado) {
            
            if (exportar_base.check_tabla_parqueo_mas_lavado.isSelected()) {
                
                numero_tablas++;
            } else {
                numero_tablas--;
            }
        }
        
        if (check == exportar_base.ch_Tabla_name_funciones) {
            
            if (exportar_base.ch_Tabla_name_funciones.isSelected()) {
                
                numero_tablas++;
            } else {
                numero_tablas--;
            }
            
        }
        
        if (check == exportar_base.ch_Tabla_colores) {
            
            if (exportar_base.ch_Tabla_colores.isSelected()) {
                
                numero_tablas++;
            } else {
                numero_tablas--;
            }
            
        }
        
        boolean estado = true;
        
        if (!exportar_base.txt_ruta.getText().trim().isEmpty()) {
            
            if (numero_tablas < 1) {
                estado = false;
                
            }
            exportar_base.btn_guardar_base.setEnabled(estado);
        }
        
        estado = false;
        if (numero_tablas < 9) {
            estado = true;
            
        }
        exportar_base.btn_habilitar.setEnabled(estado);
        
    }
    
    private void Seleccionar_Ruta() {

        //metodo para manejar los botones del JFileChooser  y mostrarlo
        //parametro el parent
        int aceptar = fileElegir.showSaveDialog(exportar_base);

        //si da click en boton aceptar del JFile chosoer, // hay mas valores para cancelar y asi
        if (aceptar == JFileChooser.APPROVE_OPTION) {

            //Obtiene el directorio  seleccionado  
            String obtenerRuta = fileElegir.getSelectedFile().getPath();

            //Habilitar el btn Guardar Base
            exportar_base.btn_guardar_base.setEnabled(true);

            //Poner la ruta en el JTextField
            exportar_base.txt_ruta.setText(obtenerRuta);
        }
        
    }
    
    private void Guardar_Base_Datos() {

        //Obtener la ruta de la caja de texto
        String recuperarRuta = exportar_base.txt_ruta.getText().trim();

        //Validar que no este vacio 
        if (!recuperarRuta.isEmpty()) {

            //Nombre con el que vamos a guardar la base.sql
            String nombreGuardar = "\\BaseParqueadero.sql";
            //variable que gardara el nameTablas a ejecutar
            String comando = "";
            Color color = fuentes_Y_Mas.getColor_Mal();
            
            try {

                //=============================================================
                // ruta donde esta instalado el xampp
                //comando mysqldump permite exportar base de datos
                //-u: es de usuario
                //-p:constrasena
                // -B : base de datos/ importante dejar un espacio antes y despues
                //--tables : este es opcional si no le pasamos nada restaurara todas las tablas , y si le pasamos una tabla especifica solo restaurara esa tabla
                // OJO, si no le vamos a pasar ninguna tabla , eliminnamos  esto: --tables 
                // -r : ruta que es = a ruta donde se guardara el archivo generado y el nombre que tendra se archivo/ dejar un espacio antes y despues
                //NOTA: es importante que servidor tenga una contrasena, si esta vacia no generara el archivo, o generara pero vacio, x eso yo le agrege un pass a mi xampp
                //
                comando = "C:\\xampp\\mysql\\bin\\mysqldump --opt --host=localhost  -u" + constantes.getUsuarioServidor() + " -p"
                        + constantes.getContrasena_Servidor() + " -B " + constantes.getBaseDatos() + getNameTables()
                        + " -r " + recuperarRuta + nombreGuardar;

                //Permite ejecutar comandos de consolas, es como ejecutaramos ese comadno desde el cmd e igual nos  generaria el respaldo de las base de datos
                Runtime rt = Runtime.getRuntime();

                //ejecuto el comando 
                rt.exec(comando);
                color = fuentes_Y_Mas.getColor_Bien();
                
                comando = "Backup realizada con exito";
                
            } catch (Exception e) {
                comando = "Surguio un problema, intentelo mas tarde " + e.getMessage();
            }
            
            controlador_sms.Iniciar_Componentes(comando, color);
            
            Seleccionar_Check(true);
            Estados_Btn("", false);
            numero_tablas = 9;
            exportar_base.num_tablas.setText("" + numero_tablas);
            
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == exportar_base.btn_seleccion_ruta) {
            
            Seleccionar_Ruta();
        } else if (e.getSource() == exportar_base.btn_guardar_base) {
            
            Guardar_Base_Datos();
        } else if (e.getSource() == exportar_base.btn_habilitar) {

            //SELECCIONA TODOS LOS CHECK
            Seleccionar_Check(true);
            
            if (!exportar_base.txt_ruta.getText().trim().isEmpty()) {
                
                exportar_base.btn_guardar_base.setEnabled(true);
                
            }
            
            exportar_base.btn_habilitar.setEnabled(false);
            numero_tablas = 9;
            
        } else {
            
            Evento_Check(e);
        }
        exportar_base.num_tablas.setText("" + numero_tablas);
        
    }
    private JFileChooser fileElegir;
    
    private int numero_tablas;
    
}
