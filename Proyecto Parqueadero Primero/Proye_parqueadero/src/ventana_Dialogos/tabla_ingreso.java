package ventana_Dialogos;

import Logica.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.sql.Date.*;
import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showOptionDialog;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;

public class tabla_ingreso extends javax.swing.JDialog {

    private Tabla_Listar tabla_listar;
    private Intruccion_sql datos_sql;
    private Logica_Colores colores;
    private String placa_joption = "";
    private String total_pagar_joption = "";

    public tabla_ingreso(java.awt.Frame parent, boolean modal) { // 
        super(parent, modal);
        Estado_Constructor();

    }

    private void Estado_Constructor() {
        initComponents();
        this.setLocationRelativeTo(null);
        Asignar_Modelo_tabla(2, null);
        Cargar_Colores();
        label_registros_fecha.setVisible(false); // Label de la fecha_si no existe
        Trasparentes();
        panel_principal.setFocusable(true);
        label_hola.setVisible(false);
        
      Actualizar_Fecha();
    }

    private void Asignar_Modelo_tabla(int operacion, java.sql.Date sql_fecha) { ///ver en  el metodo cobrar vehiculo
        ArrayList datos_text = new ArrayList();
        tabla_listar = new Tabla_Listar(tabla_lista, true, datos_text, operacion, sql_fecha,null, "si", txt_placa, "");

        int numero_filas_traidas = tabla_listar.getNumero_filas_regi();

        if (numero_filas_traidas > 0) {
            label_registros_fecha.setVisible(false);
            labe_total_cobrar.setText("" + tabla_listar.getTotal_tabla_ing_salida()); // valor por cobrar
            la_num_vehicul.setText("" + tabla_listar.getNumero_filas_regi()); //cantidad  de registros de filas

        } else {
            label_registros_fecha.setVisible(true);
            labe_total_cobrar.setText("0.00");
            la_num_vehicul.setText("0.00");

        }

        AutoCompleteDecorator.decorate(txt_placa, datos_text, false);

        JPopupMenu Objeto_menu = new JPopupMenu();
        /// Objeto_menu.setBackground(Color.GREEN);

        JMenuItem item1 = new JMenuItem("Cancelar Ingreso", new ImageIcon("src/Imagenes/cancelar.png"));
        //JMenuItem estado = new JMenuItem("ES", new ImageIcon("src/Image_2/ELIMINAR.png"));

        // item1.setBackground(Color.red);
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cancelar_Ingreso();

            }
        });

        Objeto_menu.add(item1);

        tabla_lista.setComponentPopupMenu(Objeto_menu);

    }

    private void Cancelar_Ingreso() {

        String[] opciones = {"Si,Cancelar ", "Olvidar"};

        int pregunta = JOptionPane.showOptionDialog(this, "¿Seguro Desea Cancelar Ingreso?"
                + "\n\nPlaca: " + tabla_lista.getValueAt(tabla_lista.getSelectedRow(), 1) + "\nTipo: " + tabla_lista.getValueAt(tabla_lista.getSelectedRow(), 3), "Sistema de Parqueo", 0, 0,  new ImageIcon("src/Image_Sms/cancelar_vehiculo.png"), opciones, opciones[1]);

        if (pregunta == 0) {
            int row_select = tabla_lista.getSelectedRow();

            String placa = (String) tabla_lista.getValueAt(row_select, 1);
            String tomar_propietario = tabla_lista.getValueAt(row_select, 2).toString();
            String tomar_tipo_vehiculo = tabla_lista.getValueAt(row_select, 3).toString();
            String tomar_fecha_ingreso = tabla_lista.getValueAt(row_select, 4).toString();

            datos_sql = new Intruccion_sql();
            /////////  Llenar Tabla  autos_salida

            /////Construir un objeto tipo date para pasarle a la tabla ingreso/////////////
            /*
            esta fecha es la fecha en la que se cancelo el ingreso
            
             */
            Calendar calendario = Calendar.getInstance();
            int anno = (calendario.get(Calendar.YEAR) - 1900);
            int mes = calendario.get(Calendar.MONTH);
            int dia = calendario.get(Calendar.DATE);

            /////HORA DE CANCELACION  ESTO ME AYUDA  AORDENARLO BIEN 
            int hora_cancelada = calendario.get(Calendar.HOUR_OF_DAY);
            int minutos_cancelada = calendario.get(Calendar.MINUTE);
            int segundo_cancelada = calendario.get(Calendar.SECOND);

            java.sql.Date fecha_enviar_cance = new java.sql.Date(anno, mes, dia); //crear fecha cancelada

            //INSERTAR LOS DATOS EN LA TABLA AUTOS CANCELADOS
            int ret = datos_sql.setActualizar_estado_ingreso(placa, "", 0, 3, fecha_enviar_cance, datos_sql.getRetornar_fecha_actual("fecha_actual"), tomar_fecha_ingreso, tomar_tipo_vehiculo, tomar_propietario,hora_cancelada,minutos_cancelada,segundo_cancelada);

            //ACTUALIZAR EL ESTADO DEL VEHICULO EN LA TABLA INGRESO
            int actu_2 = datos_sql.setActualizar_estado_ingreso(placa, "SI", 0.1, 1, null, "", "", "", "",0,0,0);

            /*
        
          
          
             */
            if (ret != 0 && actu_2 != 0) {

                JOptionPane.showMessageDialog(this, "Registro Cancelado Correctamente", "Sistema de Parqueo", JOptionPane.QUESTION_MESSAGE);
                Asignar_Modelo_tabla(2, null);// CUANDO  SE CANCELA UN REGISTRO ACTULIZA LA TABLA, EL REGISTRO QUE FUE CANCELADO YA NO APARECERA E

            }

        }
    }

    private void Limpiar_caja() {

        txt_dias.setText("");
        txt_horas.setText("");
        txt_minutos.setText("");
        txt_total_horas.setText("");
        label_total_cobrar.setText("0.00");
        label_costo_vehiculo.setText("0.00");
        txt_placa.setText("");
        txt_placa.requestFocus();
    }

    private void evento_Click_Tabla() {

        int row = tabla_lista.getSelectedRow();

        String placa = tabla_lista.getValueAt(row, 1).toString();

        datos_sql = new Intruccion_sql();
        datos_sql.Retirar_Vehiculo(placa);
        placa_joption = placa;
        total_pagar_joption = String.valueOf(datos_sql.getTotal_cobrar() + " $");
        txt_placa.setText(placa);
        label_costo_vehiculo.setText("" + datos_sql.getCosto_vehiculo());
        txt_dias.setText("" + datos_sql.getDias());
        txt_horas.setText("" + datos_sql.getHoras());
        txt_minutos.setText("" + datos_sql.getMinutos());
        txt_total_horas.setText("" + datos_sql.getTotal_en_horas());
        label_total_cobrar.setText("" + datos_sql.getTotal_cobrar());

    }

    private void Cobrar_vehiculo() {

        String placa = txt_placa.getText();

        double cobrar = Double.parseDouble(label_total_cobrar.getText());
        String Estado = "SI";
        datos_sql = new Intruccion_sql();
        datos_sql.setActualizar_estado_ingreso(placa, Estado, cobrar, 1, null, "", "", "", "",0,0,0);
        /// solo le paso esos datos, solo cambio el ESTADO = SI , PAARA QUE AL LISTAR LOS AUTOS INGRESADOS, SOLO LISTA LOS QUE TIENEN ESTADO NO

//         
        /////////////////////////////////////////////////////////////
        double costo = Double.parseDouble(label_costo_vehiculo.getText());
        int dias = Integer.parseInt(txt_dias.getText());
        int horas = Integer.parseInt(txt_horas.getText());
        int minu = Integer.parseInt(txt_minutos.getText());
        int to_horas = Integer.parseInt(txt_total_horas.getText());
        double total = Double.parseDouble(label_total_cobrar.getText());
        ///////////////////////////////////////////////////////////////////////////////
        datos_sql.Retirar_Vehiculo(placa);

        String nombre_pro = datos_sql.getNombre_propietario();
        String tipo_vehic = datos_sql.getTipo_vehi();
        String fecha_ingreso = datos_sql.getFecha_in();

        ///////  Llenar Tabla  autos_salida
        Calendar calendario = Calendar.getInstance();
        Date fecha = calendario.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy   hh:mm:ss a");
        String fecha_salida = dateFormat.format(fecha);

        ////Crear un objeto tipo date de la hora de salida///////////////
        /////Construir un objeto tipo date para pasarle a la tabla salida/////////////
        int anno = (calendario.get(Calendar.YEAR) - 1900);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DATE);
        int hora_salida = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos_salida = calendario.get(Calendar.MINUTE);
        int segundo_salida = calendario.get(Calendar.SECOND);
        java.sql.Date fecha_enviar = new java.sql.Date(anno, mes, dia);

        int r = datos_sql.setIngresar_vehiculo_Adminis(false, fecha_enviar, hora_salida, minutos_salida, segundo_salida, 0, placa, nombre_pro, tipo_vehic, costo, fecha_ingreso, fecha_salida, dias, horas, minu, to_horas, total);

        JOptionPane.showMessageDialog(this, "Vehiculo retirado correctamente","Sistema de Parqueo",-1, new ImageIcon("src/Image_Sms/vehiculo_ingresado_cor.png"));
        if (r == 0) {
            JOptionPane.showMessageDialog(this, "Surgio un error en la tabla salida de autos , no se pudo agregar" + "\nel registro del auto retirado");
        }

        Limpiar_caja();

        Asignar_Modelo_tabla(2, null); // para que cargue nuevamente todos los datos despues de cobrar un vehivulo

    }

    private void Trasparentes() {

        Trasparente pl = new Trasparente("Ingresa placa a buscar", txt_placa, Trasparente.Show.ALWAYS);
        Trasparente p2 = new Trasparente("NA", txt_dias, Trasparente.Show.ALWAYS);
        Trasparente p3 = new Trasparente("NA", txt_horas, Trasparente.Show.ALWAYS);
        Trasparente p4 = new Trasparente("NA", txt_minutos, Trasparente.Show.ALWAYS);
        Trasparente p5 = new Trasparente("NA", txt_total_horas, Trasparente.Show.ALWAYS);

    }

    private void Actualizar_Fecha() {

        ////////restablece la fecha actual al calendario/////////////////////
        Calendar fecha = Calendar.getInstance();

        calendario.setDate(new java.sql.Date((fecha.get(Calendar.YEAR) - 1900), fecha.get(Calendar.MONTH), fecha.get(Calendar.DATE)));

    }

    private void Cargar_Colores() {

        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*
       Manejo de Colores
         */
        colores = new Logica_Colores();/////////////////////
        colores.nombres_Color_funciones(true, "", "", "", "", "");
        String borde = colores.getColor_borde();
        String fondo = colores.getColor_fondo();
        String letra_titulos = colores.getColor_letra_titulos();
        String fondo_titulos = colores.getColor_fondo_titulos();

        ////////////////////Color del borde///////////////////////////////////////
        colores.get_Colores(borde, true, 0, 0, 0);
        LineBorder color_bordes = new LineBorder(new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul()), 3, true);
        panel_principal.setBorder(color_bordes);
        label_titulo.setBorder(color_bordes);
        ///////////////////Color de fondo///////////////////////////////////////////////
        colores.get_Colores(fondo, true, 0, 0, 0);
        Color color_fondo = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        panel_principal.setBackground(color_fondo);
        ////////////////Color letra titulos///////////////////////////////////////////
        colores.get_Colores(letra_titulos, true, 0, 0, 0);
        Color color_letra_titulos = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        label_titulo.setForeground(color_letra_titulos);

        ////////////////Color fondo titulos///////////////////////////////////////////
        colores.get_Colores(fondo_titulos, true, 0, 0, 0);
        Color color_fondo_titulos = new Color(colores.GetRojo(), colores.getVerde(), colores.getAzul());
        label_titulo.setBackground(color_fondo_titulos);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        label_costo_vehiculo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_dias = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_horas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_minutos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        label_total_cobrar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_lista = new javax.swing.JTable();
        label_titulo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_total_horas = new javax.swing.JTextField();
        txt_placa = new javax.swing.JTextField();
        label_agg_vehiculo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_restablecer = new javax.swing.JButton();
        label_registros_fecha = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labe_total_cobrar = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        la_num_vehicul = new javax.swing.JLabel();
        label_hola = new javax.swing.JLabel();
        calendario = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panel_principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
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

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Costo Vehiculo: ");
        panel_principal.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 80, -1, 30));

        label_costo_vehiculo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label_costo_vehiculo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_costo_vehiculo.setText("0.00 ");
        panel_principal.add(label_costo_vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 51, 30));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setText("$");
        panel_principal.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 83, 25, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Dias: ");
        panel_principal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 120, 71, 30));

        txt_dias.setEditable(false);
        txt_dias.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        txt_dias.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panel_principal.add(txt_dias, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 95, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Horas:");
        panel_principal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 170, 71, 30));

        txt_horas.setEditable(false);
        txt_horas.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        txt_horas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panel_principal.add(txt_horas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 95, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Minutos");
        panel_principal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 220, 71, 30));

        txt_minutos.setEditable(false);
        txt_minutos.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        txt_minutos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panel_principal.add(txt_minutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 95, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Total  a Cobrar");
        panel_principal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 120, 30));

        label_total_cobrar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label_total_cobrar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_total_cobrar.setText("0.00 ");
        panel_principal.add(label_total_cobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 55, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel8.setText("$");
        panel_principal.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 125, 25, -1));

        tabla_lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_lista.setRowHeight(40);
        tabla_lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_listaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_listaMousePressed(evt);
            }
        });
        tabla_lista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabla_listaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabla_listaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_lista);

        panel_principal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 970, 310));

        label_titulo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo.setText("Autos Ingresados Actualmente");
        label_titulo.setOpaque(true);
        panel_principal.add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 33));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Total en Horas: ");
        panel_principal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 110, 30));

        txt_total_horas.setEditable(false);
        txt_total_horas.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        txt_total_horas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_total_horas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_horasActionPerformed(evt);
            }
        });
        txt_total_horas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_total_horasKeyReleased(evt);
            }
        });
        panel_principal.add(txt_total_horas, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 86, 30));

        txt_placa.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_placa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_placa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_placaActionPerformed(evt);
            }
        });
        txt_placa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_placaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_placaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_placaKeyTyped(evt);
            }
        });
        panel_principal.add(txt_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, 270, 35));

        label_agg_vehiculo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_agg_vehiculo.setText("Ingresar Nuevo Vehiculo");
        label_agg_vehiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_agg_vehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_agg_vehiculoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_agg_vehiculoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label_agg_vehiculoMousePressed(evt);
            }
        });
        panel_principal.add(label_agg_vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 190, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("X");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });
        panel_principal.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(952, 0, -1, 28));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_2/buscar_salidapng.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_principal.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 60, 60));

        btn_restablecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_2/cargar_Tabla_2.png"))); // NOI18N
        btn_restablecer.setContentAreaFilled(false);
        btn_restablecer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_restablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restablecerActionPerformed(evt);
            }
        });
        panel_principal.add(btn_restablecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 60, 60));

        label_registros_fecha.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        label_registros_fecha.setForeground(new java.awt.Color(255, 0, 0));
        label_registros_fecha.setText("No hay registros en la fecha especificada");
        panel_principal.add(label_registros_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 300, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Por Cobrar: ");
        panel_principal.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 100, 30));

        labe_total_cobrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labe_total_cobrar.setText("0.00");
        panel_principal.add(labe_total_cobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 180, 70, 30));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("#Vehiculos: ");
        panel_principal.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 110, 30));

        la_num_vehicul.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        la_num_vehicul.setText("0.00");
        panel_principal.add(la_num_vehicul, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 220, 70, 30));

        label_hola.setText("hola");
        panel_principal.add(label_hola, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        calendario.setForeground(new java.awt.Color(0, 0, 0));
        calendario.setDateFormatString("MMMMM d,yyyy");
        calendario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        panel_principal.add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 310, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_placaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaKeyPressed
        // TODO add your handling code here:

        if (!txt_placa.getText().isEmpty() && tabla_lista.getRowCount() >= 0) {

            if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
                String nombre = txt_placa.getText();
                boolean es = true;
                int to_fil = tabla_lista.getRowCount();
                while (es) {
                    to_fil--;
                    String nombre_placa = tabla_lista.getValueAt(to_fil, 1).toString();

                    if (nombre.equals(nombre_placa)) {

                        datos_sql = new Intruccion_sql();
                        datos_sql.Retirar_Vehiculo(nombre);
                        txt_dias.setText("" + datos_sql.getDias());
                        txt_horas.setText("" + datos_sql.getHoras());
                        txt_minutos.setText("" + datos_sql.getMinutos());
                        txt_total_horas.setText("" + datos_sql.getTotal_en_horas());
                        label_total_cobrar.setText("" + datos_sql.getTotal_cobrar());
                        label_costo_vehiculo.setText("" + datos_sql.getCosto_vehiculo());
                        tabla_lista.setRowSelectionInterval(to_fil, to_fil);///

                        es = false;
                    }

                    if (to_fil == 0 && es) {
                        es = false;
                    }
                }
            }

        }


    }//GEN-LAST:event_txt_placaKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        //tabla_lista.setRowSelectionInterval(0, 0);///
    }//GEN-LAST:event_formWindowOpened

    private void txt_total_horasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_horasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_horasActionPerformed

    private void txt_placaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaKeyReleased
        // TODO add your handling code here:

        try {
            if (txt_placa.getText().isEmpty()) {
                Limpiar_caja();
                txt_placa.setText("");
                txt_placa.requestFocus();

            }

        } catch (Exception e) {
            System.out.println("gfd " + e.getMessage());
        }


    }//GEN-LAST:event_txt_placaKeyReleased

    private void txt_placaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_placaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placaActionPerformed

    private void tabla_listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_listaMouseClicked
        // TODO add your handling code here:

        evento_Click_Tabla();

        if (evt.getClickCount() == 2) {
            //JOptionPane.showMessageDialog(this, "doblee");
            Ingreso pasar = new Ingreso(this, true, tabla_lista.getValueAt(tabla_lista.getSelectedRow(), 1).toString());

            label_hola.setText("chao");
            pasar.setLocation(690, 180);
            pasar.setVisible(true);
        }


    }//GEN-LAST:event_tabla_listaMouseClicked

    private void txt_total_horasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_total_horasKeyReleased


    }//GEN-LAST:event_txt_total_horasKeyReleased

    private void label_agg_vehiculoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_agg_vehiculoMousePressed
        // TODO add your handling code here:
        Ingreso pasar = new Ingreso(this, true, "");
        pasar.show();
    }//GEN-LAST:event_label_agg_vehiculoMousePressed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_formFocusGained

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:

        int retorno_filas = tabla_listar.total_filas(true);
        tabla_listar = new Tabla_Listar(null, true, null, 0, null,null, "no", txt_placa, ""); // le paso el string no paras que no me acarge la tabla , xq solo quiero sabe las filas de la tabla de l base dae datos

        /// solo es importante pasarle al String "no"  q es la pregunta de control
        if (tabla_lista.getRowCount() != retorno_filas || label_hola.getText().equals("chao")) {
            Asignar_Modelo_tabla(2, null);

        }
        label_hola.setText("hola");


    }//GEN-LAST:event_formWindowActivated

    private void label_agg_vehiculoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_agg_vehiculoMouseEntered
        // TODO add your handling code here:

        Font font = label_agg_vehiculo.getFont();

        Hashtable<TextAttribute, Object> map
                = new Hashtable<TextAttribute, Object>();

        map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        font = font.deriveFont(map);

        label_agg_vehiculo.setFont(font);

    }//GEN-LAST:event_label_agg_vehiculoMouseEntered

    private void label_agg_vehiculoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_agg_vehiculoMouseExited
        // TODO add your handling code here:

        Font font = label_agg_vehiculo.getFont();

        Hashtable<TextAttribute, Object> map
                = new Hashtable<TextAttribute, Object>();

        map.put(TextAttribute.UNDERLINE, -1);
        font = font.deriveFont(map);

        label_agg_vehiculo.setFont(font);

    }//GEN-LAST:event_label_agg_vehiculoMouseExited

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel9MousePressed

    private void txt_placaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaKeyTyped
        // TODO add your handling code here:
        char tecla = evt.getKeyChar();

        if (Character.isLowerCase(tecla)) {
            String mayuscula = ("" + tecla).toUpperCase();
            tecla = mayuscula.charAt(0);
            evt.setKeyChar(tecla);

        }
    }//GEN-LAST:event_txt_placaKeyTyped

    private void tabla_listaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_listaMousePressed
        // TODO add your handling code here:
        /*
        Cobrar 
         */
        int columnas = tabla_lista.getColumnModel().getColumnIndexAtX(evt.getX());

        if (tabla_lista.getRowCount() >= 0) {
            int filas = evt.getY() / tabla_lista.getRowHeight();
            if (filas < tabla_lista.getRowCount() && filas >= 0 && columnas < tabla_lista.getColumnModel().getColumnCount() && columnas >= 0) {
                Object value = tabla_lista.getValueAt(filas, columnas);

                if (value instanceof JButton) {
                    ((JButton) value).doClick();
                    JButton boton = (JButton) value;
                    boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    evento_Click_Tabla();
                    String opciones[] = {"COBRAR", "CANCELAR"};
                    int con = showOptionDialog(this, " COBRAR PARQUEADERO?" + "\n\nPlaca: " + placa_joption + "\nCobrar: " + total_pagar_joption, "Sistema de Registro", 1, 1, new ImageIcon("src/Imagenes/vehi_saliaaa.png"), opciones, opciones[1]);

                    if (con == 0) {
                        Cobrar_vehiculo();//metodo
                    } else {

                        Limpiar_caja();

                    }

                }

            }
        }
    }//GEN-LAST:event_tabla_listaMousePressed

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        label_registros_fecha.setVisible(false);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        long fecha_calen = calendario.getDate().getTime();
        java.sql.Date fecha_sql_enviar = new java.sql.Date(fecha_calen);

        /// HAY Q TRATAR QUE EL TXT SOLO BUSQUE LAS PLACAS QUE SE VEN EN LA TABLA EN ESE MOMENTOS
        /////////////////////////////////////////////////////////////
        ///String fecha_cale = formato.format(fecha_sql_enviar);
        ///Comparo si la fecha de hoy con la fecha del calendar , si son iguales no hago nada , si son diferentes hay si hago q busque
        Asignar_Modelo_tabla(1, fecha_sql_enviar);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_restablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restablecerActionPerformed
        // TODO add your handling code here:

        tabla_listar = new Tabla_Listar(null, true, null, 0, null,null, "no", txt_placa, ""); // le paso el string no paras que no me acarge la tabla , xq solo quiero sabe las filas de la tabla de l base dae datos

        /// solo es importante pasarle al String "no"  q es la pregunta de control
        int retorno_filas = tabla_listar.total_filas(true);

        if (tabla_lista.getRowCount() != retorno_filas) {
            Asignar_Modelo_tabla(2, null);

        }
        Actualizar_Fecha();
    }//GEN-LAST:event_btn_restablecerActionPerformed

    private void tabla_listaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_listaKeyReleased
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP) {

            evento_Click_Tabla(); //cuando aplaste la tecla abajo o arriba tambien se dispara el evento
        }

    }//GEN-LAST:event_tabla_listaKeyReleased

    private void tabla_listaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_listaKeyPressed
        // TODO add your handling code here:

        ///System.out.println(evt.getKeyChar());

    }//GEN-LAST:event_tabla_listaKeyPressed

    private void panel_principalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_principalMouseEntered
        // TODO add your handling code here:
        panel_principal.requestFocusInWindow();
    }//GEN-LAST:event_panel_principalMouseEntered

    private void panel_principalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panel_principalKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            this.dispose();

        }
    }//GEN-LAST:event_panel_principalKeyPressed

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
            java.util.logging.Logger.getLogger(tabla_ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tabla_ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tabla_ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tabla_ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tabla_ingreso dialog = new tabla_ingreso(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_restablecer;
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel la_num_vehicul;
    private javax.swing.JLabel labe_total_cobrar;
    private javax.swing.JLabel label_agg_vehiculo;
    private javax.swing.JLabel label_costo_vehiculo;
    private javax.swing.JLabel label_hola;
    private javax.swing.JLabel label_registros_fecha;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel label_total_cobrar;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JTable tabla_lista;
    private javax.swing.JTextField txt_dias;
    private javax.swing.JTextField txt_horas;
    private javax.swing.JTextField txt_minutos;
    private javax.swing.JTextField txt_placa;
    private javax.swing.JTextField txt_total_horas;
    // End of variables declaration//GEN-END:variables
}
