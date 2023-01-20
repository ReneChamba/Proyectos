package Diseno;

import Atxy2k.CustomTextField.RestrictedTextField;
import Logica.*;
import Logica.Trasparente;
import java.awt.*;

import java.awt.event.KeyEvent;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

import javax.swing.plaf.basic.BasicProgressBarUI;

public class Registrarse extends javax.swing.JDialog {

    Validacion_txt pasar;
    Intruccion_sql control;

    public Registrarse(java.awt.Frame parent, boolean modal) { // cuando lo llame desde el frame
        super(parent, modal);
        Estado_Contructor();

    }

    public Registrarse(JDialog parent, boolean modal) { // cuando lo llame desde un Jdialogo (Listar usuarios)
        super(parent, modal);
        Estado_Contructor();
    }

    private void Estado_Contructor() {
        initComponents();
        setLocationRelativeTo(null);
        pasar = new Validacion_txt();
        control = new Intruccion_sql();
        panel_principal.setFocusable(true);

        buttonGroup1.add(chec_admin);
        buttonGroup1.add(chec_empleado);

        btn_crear_cuenta.setEnabled(false);
        Restricciones();
        Trasnparente();
        jl_correo.setVisible(false);
        jl_cedula.setVisible(false);
        jl_usu.setVisible(false);
        jl_con.setVisible(false);
        jl_con_pas.setVisible(false);
        jl_tele.setVisible(false);
        Jl_dato.setVisible(false);
        jl_porciento.setVisible(false);
        label_Selec_chec.setVisible(true);
        label_Selec_chec.setVisible(false);
        No_border();

    }

    public void No_border() {

        barra_progreso.setUI(new BasicProgressBarUI() {
            @Override
            protected void paintDeterminate(Graphics g, JComponent c) {

            }
        });

    }

    private void setEditable_False() {

        panel_datos.setEnabled(false);
        txt_apellidos.setEditable(false);
        txt_correo.setEditable(false);
        txt_domicilio.setEditable(false);
        txt_nombres.setEditable(false);
        txt_tele.setEditable(false);

        txtcedula.setEditable(false);
        chec_admin.setEnabled(false);
        chec_empleado.setEnabled(false);
        panel_datos.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        btn_continuar.setEnabled(false);

    }

    private void setEditable_false_cuenta() {

        txt_usuario.setEditable(false);
        txt_pass.setEditable(false);
        txt_confir_pass.setEditable(false);
        btn_crear_cuenta.setEnabled(false);

    }

    private void Restricciones() {

        RestrictedTextField cedula = new RestrictedTextField(txtcedula);
        cedula.setLimit(10);
        cedula.setOnlyNums(true);

        RestrictedTextField nombre = new RestrictedTextField(txt_nombres);
        nombre.setLimit(40);
        nombre.setOnlyText(true);
        nombre.setAcceptSpace(true);

        RestrictedTextField apellido = new RestrictedTextField(txt_apellidos);
        apellido.setLimit(40);
        apellido.setOnlyText(true);
        apellido.setAcceptSpace(true);

        RestrictedTextField telefono = new RestrictedTextField(txt_tele);
        telefono.setLimit(10);
        telefono.setOnlyNums(true);

        RestrictedTextField domicilio = new RestrictedTextField(txt_domicilio);
        domicilio.setLimit(40);
        domicilio.setOnlyText(true);
        domicilio.setAcceptSpace(true);

        RestrictedTextField correo = new RestrictedTextField(txt_correo);
        correo.setLimit(40);

        RestrictedTextField usuario = new RestrictedTextField(txt_usuario);
        usuario.setLimit(30);
        usuario.setOnlyAlphaNumeric(true);

        RestrictedTextField pass = new RestrictedTextField(txt_pass);
        pass.setLimit(30);
        pass.setOnlyAlphaNumeric(true);

        RestrictedTextField confi_pass = new RestrictedTextField(txt_confir_pass);
        confi_pass.setLimit(30);
        confi_pass.setOnlyAlphaNumeric(true);

    }

    private void Trasnparente() {

        Trasparente cedula_2 = new Trasparente("Cedula sin el guion (-)", txtcedula, Trasparente.Show.ALWAYS);
        Trasparente nom = new Trasparente("Nombres completos", txt_nombres, Trasparente.Show.ALWAYS);
        Trasparente apell = new Trasparente("Apellidos completos ", txt_apellidos, Trasparente.Show.ALWAYS);
        Trasparente telefo = new Trasparente("Digita  10 números", txt_tele, Trasparente.Show.ALWAYS);
        Trasparente dire = new Trasparente("Digita   dirección especifica", txt_domicilio, Trasparente.Show.ALWAYS);
        Trasparente correo = new Trasparente("Digita  tu correo electronico", txt_correo, Trasparente.Show.ALWAYS);
        Trasparente usuario = new Trasparente("Minimo  10 caracteres", txt_usuario, Trasparente.Show.ALWAYS);
        Trasparente pass = new Trasparente("Minimo 10 caracteres", txt_pass, Trasparente.Show.ALWAYS);
        Trasparente conf_pass = new Trasparente("Nuevamente la contraseña", txt_confir_pass, Trasparente.Show.ALWAYS);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel_principal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        panel_datos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        txt_nombres = new javax.swing.JTextField();
        txt_apellidos = new javax.swing.JTextField();
        txt_tele = new javax.swing.JTextField();
        txt_domicilio = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_continuar = new javax.swing.JButton();
        jl_correo = new javax.swing.JLabel();
        jl_cedula = new javax.swing.JLabel();
        jl_tele = new javax.swing.JLabel();
        chec_empleado = new javax.swing.JCheckBox();
        chec_admin = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        label_Selec_chec = new javax.swing.JLabel();
        panel_cuenta = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_crear_cuenta = new javax.swing.JButton();
        txt_usuario = new javax.swing.JTextField();
        txt_pass = new javax.swing.JTextField();
        txt_confir_pass = new javax.swing.JTextField();
        jl_usu = new javax.swing.JLabel();
        jl_con = new javax.swing.JLabel();
        jl_con_pas = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        barra_progreso = new javax.swing.JProgressBar();
        Jl_dato = new javax.swing.JLabel();
        jl_porciento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panel_principal.setBackground(java.awt.Color.white);
        panel_principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0), 3));
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

        jLabel1.setBackground(new java.awt.Color(153, 153, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crear Nuevo Usuario");
        jLabel1.setOpaque(true);
        panel_principal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 882, 38));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("X");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        panel_principal.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(891, 3, 28, 38));

        panel_datos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0), 2), "Datos Personales", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        panel_datos.setForeground(new java.awt.Color(0, 0, 0));
        panel_datos.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cédula:");
        panel_datos.add(jLabel2);
        jLabel2.setBounds(12, 105, 80, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombres:");
        panel_datos.add(jLabel3);
        jLabel3.setBounds(12, 160, 100, 30);

        txtcedula.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        txtcedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 0), 2));
        txtcedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcedulaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcedulaFocusLost(evt);
            }
        });
        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcedulaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcedulaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });
        panel_datos.add(txtcedula);
        txtcedula.setBounds(170, 105, 225, 25);

        txt_nombres.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        txt_nombres.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 0), 2));
        txt_nombres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nombresFocusGained(evt);
            }
        });
        txt_nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nombresKeyPressed(evt);
            }
        });
        panel_datos.add(txt_nombres);
        txt_nombres.setBounds(170, 160, 225, 25);

        txt_apellidos.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        txt_apellidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_apellidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 0), 2));
        txt_apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_apellidosKeyPressed(evt);
            }
        });
        panel_datos.add(txt_apellidos);
        txt_apellidos.setBounds(170, 210, 225, 25);

        txt_tele.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        txt_tele.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tele.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 0), 2));
        txt_tele.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_teleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_teleFocusLost(evt);
            }
        });
        txt_tele.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_teleKeyPressed(evt);
            }
        });
        panel_datos.add(txt_tele);
        txt_tele.setBounds(170, 260, 225, 25);

        txt_domicilio.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        txt_domicilio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_domicilio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 0), 2));
        txt_domicilio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_domicilioKeyPressed(evt);
            }
        });
        panel_datos.add(txt_domicilio);
        txt_domicilio.setBounds(170, 310, 225, 25);

        txt_correo.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        txt_correo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_correo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 0), 2));
        txt_correo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_correoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_correoFocusLost(evt);
            }
        });
        txt_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_correoActionPerformed(evt);
            }
        });
        txt_correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_correoKeyReleased(evt);
            }
        });
        panel_datos.add(txt_correo);
        txt_correo.setBounds(170, 360, 225, 25);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Apellidos:");
        panel_datos.add(jLabel4);
        jLabel4.setBounds(12, 210, 100, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Teléfono");
        panel_datos.add(jLabel5);
        jLabel5.setBounds(12, 260, 85, 30);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Dirección Domicilio:");
        panel_datos.add(jLabel6);
        jLabel6.setBounds(12, 310, 163, 30);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Correo electronico:");
        panel_datos.add(jLabel7);
        jLabel7.setBounds(12, 360, 152, 30);

        btn_continuar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_continuar.setText("CONTINUAR");
        btn_continuar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0), 4));
        btn_continuar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_continuarActionPerformed(evt);
            }
        });
        panel_datos.add(btn_continuar);
        btn_continuar.setBounds(100, 425, 195, 50);

        jl_correo.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jl_correo.setForeground(new java.awt.Color(255, 0, 0));
        jl_correo.setText("Correo incorrecto");
        panel_datos.add(jl_correo);
        jl_correo.setBounds(170, 390, 196, 14);

        jl_cedula.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jl_cedula.setForeground(new java.awt.Color(255, 0, 0));
        jl_cedula.setText("Cedula Incorrecta");
        panel_datos.add(jl_cedula);
        jl_cedula.setBounds(170, 135, 220, 14);

        jl_tele.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jl_tele.setForeground(new java.awt.Color(204, 0, 0));
        jl_tele.setText("Teléfono incorrecto");
        panel_datos.add(jl_tele);
        jl_tele.setBounds(170, 290, 128, 14);

        chec_empleado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        chec_empleado.setText("Empleado");
        chec_empleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                chec_empleadoFocusGained(evt);
            }
        });
        chec_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chec_empleadoActionPerformed(evt);
            }
        });
        panel_datos.add(chec_empleado);
        chec_empleado.setBounds(170, 50, 97, 24);

        chec_admin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        chec_admin.setText("Admin");
        chec_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chec_adminActionPerformed(evt);
            }
        });
        panel_datos.add(chec_admin);
        chec_admin.setBounds(300, 50, 80, 24);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Tipo de Usuario: ");
        panel_datos.add(jLabel11);
        jLabel11.setBounds(10, 50, 130, 19);

        label_Selec_chec.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        label_Selec_chec.setForeground(new java.awt.Color(204, 0, 0));
        label_Selec_chec.setText("Selecciona   una opción");
        panel_datos.add(label_Selec_chec);
        label_Selec_chec.setBounds(170, 75, 190, 14);

        panel_principal.add(panel_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 59, 421, 491));

        panel_cuenta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0), 2), "Datos Cuenta", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        panel_cuenta.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Crear Usuario:");
        panel_cuenta.add(jLabel8);
        jLabel8.setBounds(30, 41, 101, 30);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Crear Contraseña:");
        panel_cuenta.add(jLabel9);
        jLabel9.setBounds(30, 100, 128, 30);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Confirmar Contraseña:");
        panel_cuenta.add(jLabel10);
        jLabel10.setBounds(30, 160, 158, 30);

        btn_crear_cuenta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_crear_cuenta.setText("CREAR  CUENTA");
        btn_crear_cuenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 0), 4));
        btn_crear_cuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_crear_cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crear_cuentaActionPerformed(evt);
            }
        });
        panel_cuenta.add(btn_crear_cuenta);
        btn_crear_cuenta.setBounds(200, 230, 175, 50);

        txt_usuario.setEditable(false);
        txt_usuario.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        txt_usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_usuario.setToolTipText("<html>\n<head>\n<style>\n#selector{\ncolor:red;\nbackground:rgb(0,255,0);\n}\nbody {\nbackground:rgb(187,70,139);\nborder: 2px solid blue;\n\n\n}\nh3 {\nwidth:80%;\nbackground-color:green;\nborder-radius : 20px;\nbox-shadow: rgb(187,70,139)  5px 10px 10px; \npadding: 5px  5px 5px 5px ;\n}\n\n#letra_titulo {\ntext-align: center ;\nborder-radius : 20px;\n}\n\n</style>\n</head>\n<body >\n<header>\n<h3 id =\"letra_titulo\">Parametros de Usuario</h3>\n</header>\n<p >1: Usuario no puede comenzar con un digito </p><br>\n<p >2: Tiene que tener almenos 3 letras y 3 números</p><br>\n<p >3: Debe contener minimo 10 caracteres </p>\n</body>\n</html>");
        txt_usuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 0), 2));
        txt_usuario.setFocusCycleRoot(true);
        txt_usuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_usuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usuarioFocusLost(evt);
            }
        });
        txt_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_usuarioMouseEntered(evt);
            }
        });
        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyReleased(evt);
            }
        });
        panel_cuenta.add(txt_usuario);
        txt_usuario.setBounds(227, 42, 225, 30);

        txt_pass.setEditable(false);
        txt_pass.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        txt_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pass.setToolTipText("<html>\n<head>\n</head>\n<body>\n<h3 align=\"center\"> Parametros  de Contraseña </h3>\n<p >1: Contraseña no puede comenzar con un digito </p><br>\n<p >2: Tiene que tener almenos 3 letras y 3 números</p><br>\n<p >3: Debe contener minimo 10 caracteres </p>\n</body>\n</html>");
        txt_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 0), 2));
        txt_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_passFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_passFocusLost(evt);
            }
        });
        txt_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_passKeyReleased(evt);
            }
        });
        panel_cuenta.add(txt_pass);
        txt_pass.setBounds(230, 100, 225, 30);

        txt_confir_pass.setEditable(false);
        txt_confir_pass.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        txt_confir_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_confir_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 0), 2));
        txt_confir_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_confir_passFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_confir_passFocusLost(evt);
            }
        });
        txt_confir_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_confir_passActionPerformed(evt);
            }
        });
        txt_confir_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_confir_passKeyReleased(evt);
            }
        });
        panel_cuenta.add(txt_confir_pass);
        txt_confir_pass.setBounds(230, 160, 225, 30);

        jl_usu.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jl_usu.setForeground(new java.awt.Color(255, 0, 0));
        jl_usu.setText("No cumple con los parametros ");
        panel_cuenta.add(jl_usu);
        jl_usu.setBounds(227, 78, 153, 14);

        jl_con.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jl_con.setForeground(new java.awt.Color(204, 0, 0));
        jl_con.setText("No cumple con los parametros");
        panel_cuenta.add(jl_con);
        jl_con.setBounds(230, 140, 150, 20);

        jl_con_pas.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jl_con_pas.setForeground(new java.awt.Color(204, 0, 0));
        jl_con_pas.setText("Contraseñas no coinciden");
        panel_cuenta.add(jl_con_pas);
        jl_con_pas.setBounds(230, 200, 160, 14);

        jLabel13.setForeground(new java.awt.Color(187, 170, 139));
        jLabel13.setText("jLabel13");
        panel_cuenta.add(jLabel13);
        jLabel13.setBounds(60, 240, 48, 16);

        panel_principal.add(panel_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 59, 467, 299));

        barra_progreso.setBackground(java.awt.Color.white);
        barra_progreso.setBorder(null);
        barra_progreso.setBorderPainted(false);
        panel_principal.add(barra_progreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 409, 467, 86));

        Jl_dato.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Jl_dato.setForeground(new java.awt.Color(0, 0, 0));
        Jl_dato.setText("r");
        panel_principal.add(Jl_dato, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 505, 265, -1));

        jl_porciento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jl_porciento.setForeground(new java.awt.Color(0, 0, 0));
        jl_porciento.setText("0%");
        panel_principal.add(jl_porciento, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 501, 50, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 912, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_correoActionPerformed

    private void btn_continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_continuarActionPerformed
        // TODO add your handling code here:

        String nombre = txt_nombres.getText().trim();
        String apellido = txt_apellidos.getText().trim();
        String cedula = txtcedula.getText().trim();
        String telefono = txt_tele.getText().trim();
        String domicilio = txt_domicilio.getText().trim();
        String correo = txt_correo.getText().trim();
        boolean t = false;

        String opciones[] = {"ACEPTAR", "CANCELAR"};

        if (!nombre.isEmpty() && !apellido.isEmpty() && !cedula.isEmpty() && !telefono.isEmpty()
                && !domicilio.isEmpty() && !correo.isEmpty() && (chec_admin.isSelected() || chec_empleado.isSelected())) {

            t = pasar.validar_correo(txt_correo.getText());
            if (t) {
                // falta el icono
                int res = showOptionDialog(this, "          Esta seguro de CONTINUAR?" + "\n\nNota:" + "\nUna vez que de click en ACEPTAR no podra"
                        + "\nvolver a modificar los datos registrados", "Sistema de Registro", 1, 1, null, opciones, opciones[1]);

                if (res == 0) {
                    // btn_continuar.setEnabled(false);
                    setEditable_False();
                    Jl_dato.setVisible(true);
                    jl_porciento.setVisible(true);
                    pasar.getBarra_progres(barra_progreso, jl_porciento, Jl_dato, this, txt_usuario, txt_pass, txt_confir_pass);
                    btn_crear_cuenta.setEnabled(true);

                }

            }

        } else if (!chec_admin.isSelected() && !chec_empleado.isSelected()) {
            label_Selec_chec.setVisible(true);

        } else {
            showMessageDialog(this, "Existen campos vacios");
        }


    }//GEN-LAST:event_btn_continuarActionPerformed

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
        // TODO add your handling code here:

//        char letra = evt.getKeyChar();
//        if (letra < '0' || letra > '9') {
//            evt.consume();
//        }

    }//GEN-LAST:event_txtcedulaKeyTyped

    private void btn_crear_cuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crear_cuentaActionPerformed
        // TODO add your handling code here:
        String usuario = txt_usuario.getText();
        String pass = txt_pass.getText();
        String con_pass = txt_confir_pass.getText();
        String nombre = txt_nombres.getText().trim();
        String apellido = txt_apellidos.getText().trim();
        String cedula = txtcedula.getText().trim();
        String telefono = txt_tele.getText().trim();
        String domicilio = txt_domicilio.getText().trim();
        String correo = txt_correo.getText().trim();
        int r = txt_pass.getText().length();
        int r2 = txt_confir_pass.getText().length();

        if (!usuario.isEmpty() && !pass.isEmpty() && !con_pass.isEmpty()) {

            if (!jl_usu.isVisible() && !jl_con.isVisible() && !jl_con_pas.isVisible() && r == r2) {

                String opciones[] = {"ACEPTAR", "CANCELAR"};
                int con = showOptionDialog(this, "          Esta seguro de  Crear la Cuenta?" + "\n\nNota:" + "\nUna vez que de click en ACEPTAR no podra"
                        + "\nvolver a modificar los datos registrados", "Sistema de Registro", 1, 1, null, opciones, opciones[1]);
                if (con == 0) {
                    String tipo_usuario = chec_empleado.getText();
                    if (chec_admin.isSelected()) {
                        tipo_usuario = chec_admin.getText();
                    }

                    int pro = control.setInsertar(cedula, nombre, apellido, telefono, domicilio, correo, usuario, pass, tipo_usuario, 2, "", "");

                    if (pro == 1) {
                        pasar.getBarra_progres(barra_progreso, jl_porciento, Jl_dato, this, txt_usuario, txt_pass, txt_confir_pass);

                        setEditable_false_cuenta();

                        panel_cuenta.setCursor(new Cursor(Cursor.WAIT_CURSOR));

                        // this.dispose();
                    }

                }

            }

        } else {

            showMessageDialog(null, "Existen campos vacios");
        }

    }//GEN-LAST:event_btn_crear_cuentaActionPerformed

    private void txt_correoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_correoFocusGained
        // TODO add your handling code here:

        jl_correo.setVisible(false);


    }//GEN-LAST:event_txt_correoFocusGained

    private void txt_correoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_correoFocusLost
        // TODO add your handling code here:

        if (!txt_correo.getText().isEmpty()) {
            boolean t = pasar.validar_correo(txt_correo.getText());

            if (!t) {
                jl_correo.setVisible(true);
            }
        }


    }//GEN-LAST:event_txt_correoFocusLost

    private void txtcedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcedulaFocusLost
//         TODO add your handling code here:
//        int cantidad = txtcedula.getText().length();
//
//        if (!txtcedula.getText().isEmpty() && cantidad<10) {
//            if (cantidad < 10) {
//                jl_cedula.setVisible(true);
//                btn_continuar.setEnabled(false);
//            }
//        }

        /////////////////////////////////////////////////////////////////////////////////////
        if (panel_datos.isEnabled()) {

            try {
                ///esto estaba antes en el evento key released

                if (txtcedula.getText().length() >= 10) {
                    String txt_cedula_nue = txtcedula.getText();

                    String nombre = "";
                    //boolean bloquear = false;
                    boolean estado = control.getCedula_Existe(txt_cedula_nue, 1,""); //conxion base de datos

                    boolean reci = pasar.Validar_cedula(txtcedula.getText());

                    if (estado && reci) {// si la cedula  ya  esta registrada y esta bien 
                        nombre = "Cedula registrada";
                        ///  bloquear = true;

                    } else if (!estado && !reci) { // si la cedula es nueva pero esta mal 
                        nombre = "Cedula Incorrecta";

                    } else if (!estado && reci) { // si la cedula es nueva  y ademas esta bien
                        ///bloquear = true;

                    }

                    // btn_continuar.setEnabled(bloquear);
                    jl_cedula.setText(nombre);
                    jl_cedula.setVisible(true);

                } else {
                    jl_cedula.setVisible(false);
                    jl_cedula.setText("Digita 10 números");
                    // btn_continuar.setEnabled(false);

                }
            } catch (Exception e) {
                System.out.println("callo " + e.getMessage());
            }

        }


    }//GEN-LAST:event_txtcedulaFocusLost

    private void txtcedulaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcedulaFocusGained
        // TODO add your handling code here:
        jl_cedula.setVisible(false);

        if (txt_usuario.isEditable()) { // tomo como referencioa ese campo ya que si es editable ya no sebe hablitarse el boton
            btn_continuar.setEnabled(false);
        }


    }//GEN-LAST:event_txtcedulaFocusGained

    private void txt_usuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usuarioFocusLost
        // TODO add your handling code here:

        if (!txt_usuario.getText().isEmpty()) {
            int re = pasar.Validar_Usuario_contrase(txt_usuario.getText());

            if (re == 0) {
                jl_usu.setVisible(true);

            }
        }


    }//GEN-LAST:event_txt_usuarioFocusLost

    private void txt_usuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usuarioFocusGained
        // TODO add your handling code here:
        jl_usu.setVisible(false);
    }//GEN-LAST:event_txt_usuarioFocusGained

    private void txt_passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passFocusLost
        // TODO add your handling code here:

        if (!txt_pass.getText().isEmpty()) {

            int re = pasar.Validar_Usuario_contrase(txt_pass.getText());

            if (re == 0) {
                jl_con.setVisible(true);
            }
        }

    }//GEN-LAST:event_txt_passFocusLost

    private void txt_passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passFocusGained
        // TODO add your handling code here:
        jl_con.setVisible(false);
    }//GEN-LAST:event_txt_passFocusGained

    private void txt_confir_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_confir_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_confir_passActionPerformed

    private void txt_passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_txt_passKeyReleased

    private void txt_confir_passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_confir_passFocusLost
        // TODO add your handling code here:

        if (!txt_confir_pass.getText().isEmpty()) {
            if (!txt_pass.getText().equals(txt_confir_pass.getText())) {
                jl_con_pas.setVisible(true);
            } else {
                jl_con_pas.setVisible(false);
            }
        }


    }//GEN-LAST:event_txt_confir_passFocusLost

    private void txt_confir_passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_confir_passFocusGained
        // TODO add your handling code here:
        jl_con_pas.setVisible(false);
    }//GEN-LAST:event_txt_confir_passFocusGained

    private void txt_teleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_teleFocusLost
        // TODO add your handling code here:
        int cantidad = txt_tele.getText().length();

        if (!txt_tele.getText().isEmpty()) {
            if (cantidad < 10) {
                jl_tele.setVisible(true);
            }
        }


    }//GEN-LAST:event_txt_teleFocusLost

    private void txt_teleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_teleFocusGained
        // TODO add your handling code here:
        jl_tele.setVisible(false);
    }//GEN-LAST:event_txt_teleFocusGained

    private void txt_usuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_usuarioMouseEntered
        // TODO add your handling code here:
        ///  txt_usuario.setToolTipText("Parametros " + "\nUsuario: 10 caracteres minimo" + "\nNo puedo iniciar con un  digito");
    }//GEN-LAST:event_txt_usuarioMouseEntered

    private void txtcedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txt_nombres.requestFocus();

        }
    }//GEN-LAST:event_txtcedulaKeyPressed

    private void txt_nombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombresKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txt_apellidos.requestFocus();

        }
    }//GEN-LAST:event_txt_nombresKeyPressed

    private void txt_apellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidosKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txt_tele.requestFocus();

        }
    }//GEN-LAST:event_txt_apellidosKeyPressed

    private void txt_teleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_teleKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txt_domicilio.requestFocus();

        }
    }//GEN-LAST:event_txt_teleKeyPressed

    private void txt_domicilioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_domicilioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txt_correo.requestFocus();

        }
    }//GEN-LAST:event_txt_domicilioKeyPressed

    private void txt_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txt_pass.requestFocus();

        }
    }//GEN-LAST:event_txt_usuarioKeyPressed

    private void txt_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txt_confir_pass.requestFocus();

        }
    }//GEN-LAST:event_txt_passKeyPressed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_jLabel12MouseClicked

    private void txtcedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyReleased
        // TODO add your handling code here:
/*
        try {

            if (txtcedula.getText().length() >= 10) {
                String txt_cedula_nue = txtcedula.getText();

                String nombre = "";
                boolean bloquear = false;
                boolean estado = control.getCedula_Existe(txt_cedula_nue, 1); //conxion base de datos

                boolean reci = pasar.Validar_cedula(txtcedula.getText());

                if (estado && reci) {// si la cedula  ya  esta registrada y esta bien 
                    nombre = "Cedula registrada";

                } else if (!estado && !reci) { // si la cedula es nueva pero esta mal 
                    nombre = "Cedula Incorrecta";

                } else if (!estado && reci) { // si la cedula es nueva  y ademas esta bien
                    bloquear = true;

                }
                btn_continuar.setEnabled(bloquear);
                jl_cedula.setText(nombre);
                jl_cedula.setVisible(true);

            } else {
                jl_cedula.setVisible(false);
                jl_cedula.setText("Digita 10 números");
                btn_continuar.setEnabled(true);

            }
        } catch (Exception e) {
            System.out.println("callo " + e.getMessage());
        }

         */
    }//GEN-LAST:event_txtcedulaKeyReleased

    private void txt_correoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_correoKeyReleased
        // TODO add your handling code here:

        if (txt_correo.getText().length() >= 17) {

            boolean reci = control.getCedula_Existe(txt_correo.getText(), 2,"");
            if (reci) {
                jl_correo.setText("Correo ya esta registrado");
                jl_correo.setVisible(true);

            }
        } else {
            jl_correo.setText("Correo Incorrecto");
            jl_correo.setVisible(false);
        }
    }//GEN-LAST:event_txt_correoKeyReleased

    private void txt_usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyReleased
        // TODO add your handling code here:

        if (txt_usuario.getText().length() >= 10) {

            boolean reci = control.getCedula_Existe(txt_usuario.getText(), 3,"");

            if (reci) {

                jl_usu.setText("Nombre usuario ya existe");
                jl_usu.setVisible(true);
            } else {
                jl_usu.setText("No cumple con los parametros");
                jl_usu.setVisible(false);

            }

        } else {
            jl_usu.setText("No cumple con los parametros ");
            jl_usu.setVisible(false);
        }
    }//GEN-LAST:event_txt_usuarioKeyReleased

    private void txt_confir_passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_confir_passKeyReleased
        // TODO add your handling code here:}
        int r = txt_pass.getText().length();
        int r2 = txt_confir_pass.getText().length();

        if (r2 > r) {
            jl_con_pas.setVisible(true);

        } else {
            jl_con_pas.setVisible(false);
        }
    }//GEN-LAST:event_txt_confir_passKeyReleased

    private void chec_empleadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_chec_empleadoFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_chec_empleadoFocusGained

    private void chec_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chec_empleadoActionPerformed
        // TODO add your handling code here:
        label_Selec_chec.setVisible(false);
    }//GEN-LAST:event_chec_empleadoActionPerformed

    private void chec_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chec_adminActionPerformed
        // TODO add your handling code here:
        label_Selec_chec.setVisible(false);
    }//GEN-LAST:event_chec_adminActionPerformed

    private void txt_nombresFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nombresFocusGained
        // TODO add your handling code here:
        int cantidad = txtcedula.getText().length();

        if (!txtcedula.getText().isEmpty()) {
            if (cantidad < 10) {
                jl_cedula.setVisible(true);
                btn_continuar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_txt_nombresFocusGained

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
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Registrarse dialog = new Registrarse(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel Jl_dato;
    private javax.swing.JProgressBar barra_progreso;
    private javax.swing.JButton btn_continuar;
    private javax.swing.JButton btn_crear_cuenta;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chec_admin;
    private javax.swing.JCheckBox chec_empleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jl_cedula;
    private javax.swing.JLabel jl_con;
    private javax.swing.JLabel jl_con_pas;
    private javax.swing.JLabel jl_correo;
    private javax.swing.JLabel jl_porciento;
    private javax.swing.JLabel jl_tele;
    private javax.swing.JLabel jl_usu;
    private javax.swing.JLabel label_Selec_chec;
    private javax.swing.JPanel panel_cuenta;
    private javax.swing.JPanel panel_datos;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_confir_pass;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_domicilio;
    private javax.swing.JTextField txt_nombres;
    private javax.swing.JTextField txt_pass;
    private javax.swing.JTextField txt_tele;
    private javax.swing.JTextField txt_usuario;
    private javax.swing.JTextField txtcedula;
    // End of variables declaration//GEN-END:variables
}
