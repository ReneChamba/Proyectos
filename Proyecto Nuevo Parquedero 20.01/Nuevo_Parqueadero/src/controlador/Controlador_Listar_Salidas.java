package controlador;

import java.awt.Color;
import modelo.Crud_Primero;
import modelo.Modelo_Nuevo;
import vista.Listar_Vehiculos_Retirados;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import mensajes.Joption;
import modelo.Fuentes_Y_Mas;
import modelo.Iconos;

public class Controlador_Listar_Salidas implements ActionListener {
    
    private Modelo_Nuevo modelo_nuevo;
    private Crud_Primero crud_primero;
    private Listar_Vehiculos_Retirados listar_vehiculos_retirados;
    private Fuentes_Y_Mas fuentes_Y_mas;
    private Joption mensajes;
    private Iconos iconos;
    
    public Controlador_Listar_Salidas() {
        
    }
    
    public void setModelo_nuevo(Modelo_Nuevo modelo_nuevo) {
        this.modelo_nuevo = modelo_nuevo;
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
    
    public void setListar_Vehiculos_Salida(Listar_Vehiculos_Retirados listar_vehiculos_retirados) {
        this.listar_vehiculos_retirados = listar_vehiculos_retirados;
        
    }
    
    public void Estados_Constructor() {
        
        listar_vehiculos_retirados.btn_filtrar.addActionListener(this);
        listar_vehiculos_retirados.btn_reiniciar.addActionListener(this);
        listar_vehiculos_retirados.btn_parqueo.addActionListener(this);
        listar_vehiculos_retirados.btn_lavado.addActionListener(this);
        listar_vehiculos_retirados.btn_lavado_mas_parqueo.addActionListener(this);
        listar_vehiculos_retirados.setResizable(false);
        listar_vehiculos_retirados.setTitle(fuentes_Y_mas.getTitulo());
        seleccion_tabla = 3;
        Aplicar_Colores(Color.GREEN, Color.GRAY, Color.GRAY);
        Diseno();
        
        Poner_Horas();
        Evento_Ventana();
        
    }
    
    private void Diseno() {
        listar_vehiculos_retirados.lb_titulo.setFont(fuentes_Y_mas.getLetra_Titulos());
        listar_vehiculos_retirados.lb_name_registros.setFont(fuentes_Y_mas.getLetra_label());
        listar_vehiculos_retirados.lb_poner_numero.setFont(fuentes_Y_mas.getLetra_Titulos());
        listar_vehiculos_retirados.lb_name_dolares.setFont(fuentes_Y_mas.getLetra_Txt());
        listar_vehiculos_retirados.lb_dolares.setFont(fuentes_Y_mas.getLetra_Titulos());
        
        listar_vehiculos_retirados.btn_filtrar.setIcon(iconos.getIcono_buscar_vehicu());
        listar_vehiculos_retirados.btn_reiniciar.setIcon(iconos.getIcono_actualizar());
        
        listar_vehiculos_retirados.btn_filtrar.setCursor(fuentes_Y_mas.getCursor());
        listar_vehiculos_retirados.btn_reiniciar.setCursor(fuentes_Y_mas.getCursor());
        listar_vehiculos_retirados.btn_lavado.setCursor(fuentes_Y_mas.getCursor());
        listar_vehiculos_retirados.btn_parqueo.setCursor(fuentes_Y_mas.getCursor());
        listar_vehiculos_retirados.btn_lavado_mas_parqueo.setCursor(fuentes_Y_mas.getCursor());
        
        listar_vehiculos_retirados.lb_titulo.setForeground(fuentes_Y_mas.getColor_titulo());
        listar_vehiculos_retirados.panel_funciones.setBorder(fuentes_Y_mas.getBorder("Funciones", Color.BLACK));
        listar_vehiculos_retirados.panel_botones.setBorder(fuentes_Y_mas.getBorderlinea(Color.BLACK));
        
    }
    
    public void Iniciar_Componentes() {
        
        listar_vehiculos_retirados.setLocation(fuentes_Y_mas.centrar_Pantalla(listar_vehiculos_retirados.getWidth()), 130);
        
        seleccion_tabla = 3;
        Cargar_Tabla(seleccion_tabla, false);
        
        listar_vehiculos_retirados.setVisible(true);
    }
    
    private void Cargar_Tabla(int selectAabla, boolean filtrar) {
        
        modelo_nuevo.setTabla(listar_vehiculos_retirados.tabla);
        
        if (crud_primero.Cargar_Tabla_Lavado(modelo_nuevo, filtrar, selectAabla)) {
            
        }
        
        listar_vehiculos_retirados.lb_poner_numero.setText(modelo_nuevo.getContador_Registros() + " Vehiculos");
        listar_vehiculos_retirados.lb_dolares.setText("" + modelo_nuevo.getDolares_ingresados());
        
    }
    
    private void Evento_Ventana() {
        
        WindowAdapter evento = new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
                
                Aplicar_Colores(Color.GREEN, Color.GRAY, Color.GRAY);
                
                Poner_Horas();
            }
            
        };
        listar_vehiculos_retirados.addWindowListener(evento);
        
    }
    
    private void Aplicar_Colores(Color parqueo, Color lavado, Color parqueo_mas_lavado) {
        
        listar_vehiculos_retirados.btn_parqueo.setBackground(parqueo);
        listar_vehiculos_retirados.btn_lavado.setBackground(lavado);
        listar_vehiculos_retirados.btn_lavado_mas_parqueo.setBackground(parqueo_mas_lavado);
        
    }
    
    private void Poner_Horas() {
        
        listar_vehiculos_retirados.calendario_inicio.setDate(modelo_nuevo.getFecha_Date());
        listar_vehiculos_retirados.calendario_final.setDate(modelo_nuevo.getFecha_Date_2());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            
            Object boton = e.getSource();
            boolean filtrar = false;
            
            Color color_lavado = Color.GREEN;
            Color colo_parqueo = Color.GREEN;
            Color colo_parqueo_mas_lavado = Color.GREEN;

            //fitrar False: filtrar todo
            //filtrar true: filtrar por fecha
            if (boton == listar_vehiculos_retirados.btn_filtrar) {
                
                modelo_nuevo.setFecha__Date(listar_vehiculos_retirados.calendario_inicio.getDate());
                modelo_nuevo.setFecha__Date_Final(listar_vehiculos_retirados.calendario_final.getDate());
                filtrar = true;
                
            }
            
            if (boton == listar_vehiculos_retirados.btn_reiniciar) {

                //actualiza los calendario
                Poner_Horas();
                //carga de neuvo todos los datos de la tabla que esta cargada , eso lo determina  dependiendo el valor de seleccion_tabla

            }
            
            if (boton != listar_vehiculos_retirados.btn_filtrar && boton != listar_vehiculos_retirados.btn_reiniciar) {
                
                if (boton == listar_vehiculos_retirados.btn_lavado) {
                    colo_parqueo = Color.gray;
                    colo_parqueo_mas_lavado = Color.gray;
                    seleccion_tabla = 6;
                    
                }
                
                if (boton == listar_vehiculos_retirados.btn_parqueo) {
                    color_lavado = Color.gray;
                    colo_parqueo_mas_lavado = Color.gray;
                    seleccion_tabla = 3;
                    
                }
                
                if (boton == listar_vehiculos_retirados.btn_lavado_mas_parqueo) {
                    color_lavado = Color.gray;
                    colo_parqueo = Color.gray;
                    seleccion_tabla = 7;
                }
                
                Aplicar_Colores(colo_parqueo, color_lavado, colo_parqueo_mas_lavado);
                
            }
            
            Cargar_Tabla(seleccion_tabla, filtrar);
            
        } catch (Exception ex) {
            System.out.println("error  en actionPerformed " + ex.getMessage());
            
        }
        
    }
    private int seleccion_tabla;
    
}
