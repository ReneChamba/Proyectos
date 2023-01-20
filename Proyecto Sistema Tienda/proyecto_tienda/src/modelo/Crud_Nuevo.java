package modelo;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Crud_Nuevo extends Coneccion_tienda {

    public Crud_Nuevo() {
        icono_editar = new ImageIcon("src/Image_2/actualizar_nuevo.png");
        icono_eliminar = new ImageIcon("src/Image_2/ELIMINAR.png");

    }

    public boolean Ingresar_Nuevo_Proveedor(Modelo_Nuevo modelo_nuevo) {

        boolean retorno = false;
        PreparedStatement pr = null;
        try {

            pr = getConnection().prepareStatement("INSERT INTO tabla_proveedor VALUES (null,?,?,?,?,?,?,?,?,?,?)");
            pr.setDate(1, modelo_nuevo.getFecha_registro());
            pr.setString(2, modelo_nuevo.getCodigo());
            pr.setString(3, modelo_nuevo.getCedula());
            pr.setString(4, modelo_nuevo.getNombre_proveedor());
            pr.setString(5, modelo_nuevo.getEmpresa());
            pr.setString(6, modelo_nuevo.getDireccion());
            pr.setString(7, modelo_nuevo.getProvincia());
            pr.setString(8, modelo_nuevo.getCorreo());
            pr.setString(9, modelo_nuevo.getTlf_fijo());
            pr.setString(10, modelo_nuevo.getCelular());
            pr.execute();
            retorno = true;

        } catch (Exception e) {

            System.out.println("erro al registrar proveedor " + e.getMessage());
        } finally {
            getDesconectar();
        }

        return retorno;

    }

    public boolean Actualizar_Proveedor(Modelo_Nuevo modelo_nuevo) {

        boolean retorno = false;
        PreparedStatement pr = null;
        try {

            pr = getConnection().prepareStatement("UPDATE tabla_proveedor SET CEDULA ='" + modelo_nuevo.getCedula() + "' , NOMBRE = '"
                    + modelo_nuevo.getNombre_proveedor() + "' , EMPRESA ='" + modelo_nuevo.getEmpresa() + "' ,DIRECCION ='" + modelo_nuevo.getDireccion() + "'"
                    + " ,PROVINCIA = '" + modelo_nuevo.getProvincia() + "' ,CORREO ='" + modelo_nuevo.getCorreo() + "' ,  TLF_FIJO = '" + modelo_nuevo.getTlf_fijo() + "'"
                    + ",CELULAR ='" + modelo_nuevo.getCelular() + "' WHERE CODIGO =?");

            pr.setString(1, modelo_nuevo.getCodigo());
            pr.execute();
            retorno = true;

        } catch (Exception e) {

            System.out.println("erro al actualizar el proveedor " + e.getMessage());
        } finally {
            getDesconectar();
        }

        return retorno;

    }

    public boolean Actualizar_Sistema(Modelo_Nuevo modelo_nuevo, int elegir) {

        boolean retorno = false;
        PreparedStatement pr = null;
        try {

            /*
            1)actualizar todo
            2)actualizar estado de id_sistema 2
             */
            String sql = "";
            if (elegir == 1) {
                sql = "UPDATE restablecer SET TITULO ='" + modelo_nuevo.getCedula() + "' , TIENDA = '"
                        + modelo_nuevo.getNombre_proveedor() + "' , INICIO ='" + modelo_nuevo.getEmpresa() + "' ,CONFIGURACION='" + modelo_nuevo.getDireccion() + "'"
                        + " ,ESTADISTICA = '" + modelo_nuevo.getProvincia() + "'  , ESTADO = '" + modelo_nuevo.getEstado_cuenta() + "' WHERE ID_SISTEMA =2";

            }

            if (elegir == 2) {
                sql = "UPDATE  restablecer SET ESTADO = '" + modelo_nuevo.getEstado_cuenta() + "' WHERE ID_SISTEMA =2";

            }

            pr = getConnection().prepareStatement(sql);
            pr.execute();

            String otra_consulta = "";

            if (elegir == 1) {
                otra_consulta = "UPDATE  restablecer SET ESTADO ='DESACTIVADO' WHERE ID_SISTEMA =1 ";
            }

            if (elegir == 2) {
                otra_consulta = "UPDATE  restablecer SET ESTADO ='ACTIVO' WHERE ID_SISTEMA =1 ";
            }

            pr = getConnection().prepareStatement(otra_consulta);

            pr.execute();
            retorno = true;

        } catch (Exception e) {

            System.out.println("erro al actualizar datos del sistema " + e.getMessage());
        } finally {
            getDesconectar();
        }

        return retorno;

    }

    public boolean Traer_Datos_Sistema(Modelo_Nuevo modelo_nuevo) {

        boolean retorno = false;
        PreparedStatement pr = null;
        ResultSet resultado = null;

        try {

            pr = getConnection().prepareStatement("SELECT * FROM restablecer WHERE ESTADO ='ACTIVO'");
            resultado = pr.executeQuery();

            if (resultado.next()) {

                /*
                 
                     menu_principal.setTitle(modelo_nuevo.getCedula());
        menu_principal.item_Inicio.setText(modelo_nuevo.getEmpresa());
        menu_principal.item_tienda.setText(modelo_nuevo.getNombre_proveedor());
        menu_principal.item_configuracion.setText(modelo_nuevo.getDireccion());
        menu_principal.item_menu_estadisticas.setText(modelo_nuevo.getProvincia());
                 */
                modelo_nuevo.setCedula(resultado.getString("TITULO"));
                modelo_nuevo.setEmpresa(resultado.getString("INICIO"));
                modelo_nuevo.setNombre_proveedor(resultado.getString("TIENDA"));
                modelo_nuevo.setDireccion(resultado.getString("CONFIGURACION"));
                modelo_nuevo.setProvincia(resultado.getString("ESTADISTICA"));

            }

            retorno = true;

        } catch (Exception e) {

            System.out.println("erro al actualizar el proveedor " + e.getMessage());
        } finally {
            getDesconectar();
        }

        return retorno;

    }

    public boolean Eliminar_Proveedor(Modelo_Nuevo modelo_nuevo) {

        boolean retorno = false;
        PreparedStatement pr = null;
        try {

            pr = getConnection().prepareStatement("DELETE FROM tabla_proveedor  WHERE CODIGO =?");

            pr.setString(1, modelo_nuevo.getCodigo());
            pr.execute();
            retorno = true;

        } catch (Exception e) {

            System.out.println("erro al eliminar el proveedor " + e.getMessage());
        } finally {
            getDesconectar();
        }

        return retorno;

    }

    public boolean Cargar_Combo_Colores(Modelo_Nuevo modelo_nuevo) {

        boolean retorno = false;
        PreparedStatement pr = null;
        ResultSet resultado = null;
        try {

            pr = getConnection().prepareStatement("SELECT  * FROM  colores");

            resultado = pr.executeQuery();
            while (resultado.next()) {
                modelo_nuevo.getCombo_color_item_padre().addItem(resultado.getString("Nombre_Color"));
                modelo_nuevo.getCombo_color_item_hijo().addItem(resultado.getString("Nombre_Color"));
                modelo_nuevo.getCombo_color_fondo().addItem(resultado.getString("Nombre_Color"));
                modelo_nuevo.getCombo_color_barra().addItem(resultado.getString("Nombre_Color"));

            }

            retorno = true;

        } catch (Exception e) {

            System.out.println("erro al cargar los nombre de los colores " + e.getMessage());
        } finally {
            getDesconectar();
        }

        return retorno;

    }

    public boolean Seleccionar_Color(Modelo_Nuevo modelo_nuevo) {

        boolean retorno = false;
        PreparedStatement pr = null;
        ResultSet resultado = null;
        try {

            pr = getConnection().prepareStatement("SELECT * FROM  colores WHERE Nombre_Color =?");
            pr.setString(1, modelo_nuevo.getNombre_color());
            resultado = pr.executeQuery();
            if (resultado.next()) {

                modelo_nuevo.setRojo(resultado.getInt("Rojo"));
                modelo_nuevo.setVerde(resultado.getInt("Verde"));
                modelo_nuevo.setAzul(resultado.getInt("Azul"));
            }

            retorno = true;

        } catch (Exception e) {

            System.out.println("erro al seleccionar y crear el color " + e.getMessage());
        } finally {
            getDesconectar();
        }

        return retorno;

    }

    public boolean Aplicar_Cambios_Color(Modelo_Nuevo modelo_nuevo, boolean elegir) {

        boolean retorno = false;
        PreparedStatement pr = null;
        // ResultSet resultado = null;
        try {

            if (elegir) {
                pr = getConnection().prepareStatement("UPDATE  nombre_funciones SET COLOR_ITEMS_PADRE = ?, COLOR_ITEMS_HIJOS =?"
                        + ", COLOR_FONDO=?, COLOR_BARRA=? , ESTADO =? WHERE ID_FUNCIONES=2");
                pr.setString(1, modelo_nuevo.getNombre_color_items_padre());
                pr.setString(2, modelo_nuevo.getNombre_color_items_hijos());
                pr.setString(3, modelo_nuevo.getNombre_color_fondo());
                pr.setString(4, modelo_nuevo.getNombre_color_barra_menul());
                pr.setString(5, modelo_nuevo.getEstado_cuenta());
                pr.executeUpdate();

                String otra_update = "UPDATE  nombre_funciones SET ESTADO ='DESACTIVADO' WHERE ID_FUNCIONES=1";
                pr = getConnection().prepareStatement(otra_update);
                pr.executeUpdate();
            } else {
                String otra_update = "UPDATE  nombre_funciones SET ESTADO ='DESACTIVADO' WHERE ID_FUNCIONES=2";
                pr = getConnection().prepareStatement(otra_update);
                pr.executeUpdate();

                otra_update = "UPDATE  nombre_funciones SET ESTADO ='ACTIVADO' WHERE ID_FUNCIONES=1";
                pr = getConnection().prepareStatement(otra_update);
                pr.executeUpdate();

            }

            retorno = true;

        } catch (Exception e) {

            System.out.println("erro al  poner el color " + e.getMessage());
        } finally {
            getDesconectar();
        }

        return retorno;

    }

    public boolean Retornar_Nombre_COlor_Funciones(Modelo_Nuevo modelo_nuevo) {
        boolean retorno = false;
        PreparedStatement pr = null;
        ResultSet resultado = null;
        try {
            String otra_update = "SELECT * FROM  nombre_funciones WHERE ESTADO ='ACTIVADO'";
            pr = getConnection().prepareStatement(otra_update);
            resultado = pr.executeQuery();

            if (resultado.next()) {
                modelo_nuevo.setId_funciones(resultado.getInt("ID_FUNCIONES"));
                modelo_nuevo.setNombre_color_items_padre(resultado.getString("COLOR_ITEMS_PADRE"));
                modelo_nuevo.setNombre_color_items_hijos(resultado.getString("COLOR_ITEMS_HIJOS"));
                modelo_nuevo.setNombre_color_fondo(resultado.getString("COLOR_FONDO"));
                modelo_nuevo.setNombre_color_barra_menul(resultado.getString("COLOR_BARRA"));

            }

            retorno = true;

        } catch (Exception e) {

            System.out.println("error al traer los nombre de los colores" + e.getMessage());
        } finally {
            getDesconectar();
        }

        return retorno;

    }

    public boolean Crear_Cliente_Nuevo(Modelo_Nuevo modelo_nuevo) {
        boolean retorno = false;

        PreparedStatement pr = null;
        try {

            pr = getConnection().prepareStatement("INSERT INTO tabla_clientes VALUES (null,?,?,?,?,?)");

            pr.setString(1, modelo_nuevo.getCodigo());
            pr.setString(2, modelo_nuevo.getNombre_proveedor());
            pr.setString(3, modelo_nuevo.getCedula());
            pr.setString(4, modelo_nuevo.getCelular());
            pr.setDouble(5, modelo_nuevo.getSaldo_pendiente());
            pr.execute();
            retorno = true;

        } catch (Exception e) {

            System.out.println("error al registrar un nuevo cliente " + e.getMessage());
        } finally {
            getDesconectar();
        }

        return retorno;
    }

    public boolean Actualizar_Cliente(Modelo_Nuevo modelo_nuevo) {
        boolean retorno = false;

        PreparedStatement pr = null;
        try {

            pr = getConnection().prepareStatement("UPDATE  tabla_clientes SET NOMBRE = '" + modelo_nuevo.getNombre_proveedor() + "' , CELULAR"
                    + "= '" + modelo_nuevo.getCelular() + "' , SALDO_PENDIENTE = '" + modelo_nuevo.getSaldo_pendiente() + "'  WHERE CODIGO"
                    + " = '" + modelo_nuevo.getCodigo() + "'");

            pr.execute();
            retorno = true;

        } catch (Exception e) {

            System.out.println("error al registrar un nuevo cliente " + e.getMessage());
        } finally {
            getDesconectar();
        }

        return retorno;
    }

    public boolean Retornar_Datos_Clientes(Modelo_Nuevo modelo_nuevo) {
        boolean retornar = false;

        PreparedStatement pr = null;
        ResultSet resultaado = null;
        try {
            pr = getConnection().prepareStatement("SELECT CEDULA FROM  tabla_clientes WHERE CEDULA =?");

            pr.setString(1, modelo_nuevo.getCedula());
            resultaado = pr.executeQuery();

            while (resultaado.next()) {
                retornar = true;

            }

        } catch (Exception e) {
        }

        return retornar;

    }

    public boolean Actualizar_Datos_Clientes(Modelo_Nuevo modelo_nuevo, boolean elegir_consulta) {
        boolean retornar = false;

        PreparedStatement pr = null;

        try {

            String query = "DELETE FROM  tabla_clientes WHERE CODIGO =? ";

            if (!elegir_consulta) {

                //aqui va actualizar
            }

            pr = getConnection().prepareStatement(query);

            pr.setString(1, modelo_nuevo.getCodigo());
            pr.executeUpdate();
            retornar = true;

        } catch (Exception e) {
        }

        return retornar;

    }

    public boolean Actualizar_Datos_Personales(Modelo_Nuevo modelo_nuevo, String campo_actualizar) { // actualiza correo, la cuenta, la contraseña

        boolean retorno = false;

        try {

            PreparedStatement pr = null;

            String sq_queryn = "UPDATE  cuenta_usuarios SET " + campo_actualizar + "  =  '" + modelo_nuevo.getTipo_cuenta() + "'     WHERE CEDULA =? ";

            /// modelo_nuevo.getTipo_cuenta() este utlizo para actualizar lso 3 campos
            pr = getConnection().prepareStatement(sq_queryn);

            pr.setString(1, modelo_nuevo.getCedula());

            pr.executeUpdate();
            retorno = true;

        } catch (Exception e) {
        }

        return retorno;
    }

    public String getCodigo_Registro_Proveedor(boolean elegir_campo) {
        String sms_con_codigo = "";

        try {
            String sql_query = "SELECT * FROM tabla_codigo";
            PreparedStatement pr = null;
            ResultSet resultado = null;

            pr = getConnection().prepareStatement(sql_query);
            resultado = pr.executeQuery();

            int numero_codigo = 0;

            while (resultado.next()) {

                numero_codigo = resultado.getInt("NUMERO") + 1;
                if (elegir_campo) {
                    sms_con_codigo = resultado.getString("CODIGO_PROVEEDOR") + numero_codigo;
                } else {
                    sms_con_codigo = resultado.getString("CODIGO_CLIENTE") + numero_codigo;
                }

            }

            //////////Actualizar el valor del numero
            pr = getConnection().prepareStatement("UPDATE tabla_codigo SET NUMERO = '" + numero_codigo + "' WHERE CODIGO_PROVEEDOR = 'PROVE:0'");
            pr.executeUpdate();

        } catch (Exception e) {
            System.out.println("erro al generar el codigo " + e.getMessage());
        }

        return sms_con_codigo;

    }

    public int Retornar_Correo(Modelo_Nuevo modelo_nuevo) {

        int retornar = 0;

        try {
            PreparedStatement pr = null;
            ResultSet resultado = null;
            String sq_queryn = "SELECT CORREO,ESTADO,USUARIO,CONTRASENA   FROM cuenta_usuarios WHERE  CORREO =? ";

            pr = getConnection().prepareStatement(sq_queryn);

            pr.setString(1, modelo_nuevo.getCorreo());
            resultado = pr.executeQuery();

            if (resultado.next()) {

                if (resultado.getString("ESTADO").equals("AC")) {
                    retornar = 1;
                    modelo_nuevo.setCedula(resultado.getString("USUARIO")); // setCedula utilizo paraa pasar el usuario
                    modelo_nuevo.setCodigo(resultado.getString("CONTRASENA")); // setCedula utilizo paraa pasar la pass
                } else {
                    retornar = 2;// el correo si existe pero la cuenta esta deshabilitada
                }

            }
            ///  0 quiere decir que el correo no esta registrado

        } catch (Exception e) {

        }

        return retornar;
    }

    public boolean Activar_Desativar_Usuarios(Modelo_Nuevo modelo_nuevo, boolean elegir_accion) {//tambien elimina una cuenta si le lleg false
        boolean retorno = false;
        //true actualizar  estado
        //false eliminar cuenta

        try {
            PreparedStatement pr = null;
            String sq_queryn = "UPDATE  cuenta_usuarios SET ESTADO = '" + modelo_nuevo.getEstado_cuenta() + "' WHERE  CEDULA =? ";

            if (!elegir_accion) {
                sq_queryn = "DELETE FROM  cuenta_usuarios  WHERE  CEDULA =? ";
            }

            pr = getConnection().prepareStatement(sq_queryn);

            pr.setString(1, modelo_nuevo.getCedula());

            pr.executeUpdate();
            retorno = true;

        } catch (Exception e) {

        }

        return retorno;
    }

    public boolean Buscar_Proveedor(Modelo_Nuevo modelo_nuevo) {

        boolean retorno = false;
        PreparedStatement pr = null;
        ResultSet resultado = null;
        try {
            pr = getConnection().prepareStatement("SELECT * FROM tabla_proveedor WHERE CODIGO =?");
            pr.setString(1, modelo_nuevo.getCodigo());
            resultado = pr.executeQuery();

            while (resultado.next()) {

                modelo_nuevo.setCedula(resultado.getString("CEDULA"));
                modelo_nuevo.setNombre_proveedor(resultado.getString("NOMBRE"));
                modelo_nuevo.setEmpresa(resultado.getString("EMPRESA"));
                modelo_nuevo.setDireccion(resultado.getString("DIRECCION"));
                modelo_nuevo.setProvincia(resultado.getString("PROVINCIA"));
                modelo_nuevo.setCorreo(resultado.getString("CORREO"));
                modelo_nuevo.setTlf_fijo(resultado.getString("TLF_FIJO"));
                modelo_nuevo.setCelular(resultado.getString("CELULAR"));
                retorno = true;
            }

        } catch (Exception e) {

            System.out.println("error al buscar un cliente " + e.getMessage());
        } finally {
            getDesconectar();
        }

        return retorno;

    }

    //////////////////////////GENERAR TABLAS //////////////////////////////////////////////////////////////////////////////////////7
    public boolean Tabla_Proveedor(Modelo_Nuevo modelo_nuevo) {

        boolean retorno = false;

        try {

            PreparedStatement pr = null;
            ResultSet resultado = null;

            DefaultTableModel dt = new DefaultTableModel() {

                public boolean isCellEditable(int filas, int columnas) {

                    return false;
                }
            };

            dt.addColumn("#");
            dt.addColumn("Registro");
            dt.addColumn("Codigo");
            dt.addColumn("Cédula");
            dt.addColumn("Nombre");
            dt.addColumn("Empresa");
            dt.addColumn("Dirección");
            dt.addColumn("Provincia");
            dt.addColumn("Correo");
            dt.addColumn("Tlf_Fijo");
            dt.addColumn("Celular");
            dt.addColumn("Productos");
            pr = getConnection().prepareStatement("SELECT * FROM tabla_proveedor ORDER BY FECHA_REGISTRO DESC");
            resultado = pr.executeQuery();

            JTableHeader encabezado = modelo_nuevo.getTabla().getTableHeader();
            encabezado.setDefaultRenderer(new Render_Encabezado("cambia_color"));
            modelo_nuevo.getTabla().setTableHeader(encabezado);
            modelo_nuevo.getTabla().getTableHeader().setReorderingAllowed(false);
            modelo_nuevo.getTabla().setDefaultRenderer(Object.class, new Renderizar_Tablas(12, "Tabla_proveedor"));

            int contador = 1;
            while (resultado.next()) {
                JButton btn_ver_productos = new JButton("Ver");

                Object datos[] = new Object[12];
                datos[0] = contador;
                for (int i = 1; i < datos.length - 1; i++) {
                    datos[i] = resultado.getString(i + 1);

                }
                datos[datos.length - 1] = btn_ver_productos;
                contador++;
                dt.addRow(datos);

            }
            modelo_nuevo.getTabla().setModel(dt);
            retorno = true;

        } catch (Exception e) {
            System.out.println("error al poner el modelo de la tabla proveedores " + e.getMessage());
        }

        return retorno;
    }

    public boolean Modelo_Tabla_Productos_Proveedores(Modelo_Nuevo modelo_nuevo) { // esta es la misma tabla pero en otr crud ,  de la tabla compras
        boolean retorno = false;
        try {
            PreparedStatement pr = null;
            ResultSet resultado = null;
            pr = getConnection().prepareStatement("SELECT * FROM tablas_ventas WHERE CODIGO_PROVEEDOR =?  ORDER BY  CATEGORIA ");

            pr.setString(1, modelo_nuevo.getCodigo());
            resultado = pr.executeQuery();
            DefaultTableModel dt = new DefaultTableModel() {
                public boolean isCellEditable(int filas, int columnas) {

                    return false;
                }

            };
            dt.addColumn("#");
            dt.addColumn("Codigo");
            dt.addColumn("Fecha Registro");
            dt.addColumn("Categoria");
            //dt.addColumn("Proveedor");
            //dt.addColumn("Co_Pro");
            dt.addColumn("Producto");
            dt.addColumn("Cantidad");
            dt.addColumn("Egresos");
            dt.addColumn("Precio_X_U");
            dt.addColumn("#Disponibles");
            dt.addColumn("Ingresos");

            dt.addColumn("Ganancia");

            JTableHeader encabezado = modelo_nuevo.getTabla().getTableHeader();
            encabezado.setDefaultRenderer(new Render_Encabezado("cambia_color"));
            modelo_nuevo.getTabla().setTableHeader(encabezado);
            modelo_nuevo.getTabla().getTableHeader().setReorderingAllowed(false);
            //modelo_nuevo.getTabla().setDefaultRenderer(Object.class, new Renderizar_Tablas(14, "hola"));
            modelo_nuevo.getTabla().setModel(dt);

            try {/// NO ES NECEARIO ,  LO PUSE PARA ENCONTRAR UN ERROR QUE TENIA  ,PERO YA LO ENCONTRE
                rowSorter = new TableRowSorter(dt);
                modelo_nuevo.getTabla().setRowSorter(rowSorter);
                modelo_nuevo.setRowSorter(rowSorter);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Surguio un problema ,intentalo mas tarde");
                // System.out.println("erro filtrar_ " + e.getMessage());

            }
            modelo_nuevo.getTabla().setModel(dt);
            int contador = 1;
//            double total_cobrar = 0;
            int cantidad_produ_cliente = 0;
            while (resultado.next()) {
                Object datos[] = new Object[11];

//                JButton btn_guardar = new JButton(new ImageIcon("src/Image_2/ELIMINAR.png"));
                datos[0] = contador;
                datos[1] = resultado.getString("CODIGO_REGISTRO");
                datos[2] = resultado.getString("FECHA");
                datos[3] = resultado.getString("CATEGORIA");
//                datos[4] = resultado.getString("PROVEEDOR");
//                datos[5] = resultado.getString("CODIGO_PROVEEDOR");
                datos[4] = resultado.getString("PRODUCTO");
                datos[5] = resultado.getInt("CANTIDAD");
                datos[6] = resultado.getInt("EGRESOS_COMPRAS");
                datos[7] = resultado.getString("PRECIO");

                cantidad_produ_cliente = resultado.getInt("DISPONIBLES");
                if (cantidad_produ_cliente != 0) {
                    datos[8] = resultado.getInt("DISPONIBLES");
                } else {
                    datos[8] = "VACIA";
                }

                datos[9] = resultado.getString("INGRESOS");
                datos[10] = resultado.getDouble("GANANCIAS");

                contador++;

                dt.addRow(datos);

            }

            retorno = true;

        } catch (Exception e) {
            System.out.println("erro al poner el modelo a la tabla productos proveedores " + e.getMessage());
        }
        return retorno;
    }

    public boolean Tabla_Cuentas_Usuarios(Modelo_Nuevo modelo_nuevo, boolean filtrar) {

        boolean retorno = false;
        try {

            PreparedStatement pr = null;
            ResultSet resultado = null;

            DefaultTableModel dt = new DefaultTableModel() {
                public boolean isCellEditable(int filas, int columnas) {

                    return false;
                }

            };

            dt.addColumn("#");
            dt.addColumn("Cedula");
            dt.addColumn("Nombre");
            dt.addColumn("Apellido");
            dt.addColumn("Correo");
            dt.addColumn("Cuenta");
            dt.addColumn("Usuario");
            dt.addColumn("Contraseña");
            dt.addColumn("Estado");

            JTableHeader encabezado = modelo_nuevo.getTabla().getTableHeader();
            encabezado.setDefaultRenderer(new Render_Encabezado());
            modelo_nuevo.getTabla().setTableHeader(encabezado);
            modelo_nuevo.getTabla().getTableHeader().setReorderingAllowed(false);

            modelo_nuevo.getTabla().setDefaultRenderer(Object.class, new Renderizar_Tablas(9, "grkfjgritgm"));

            modelo_nuevo.getTabla().setModel(dt);

            try { /// NO ES NECEARIO ,  LO PUSE PARA ENCONTRAR UN ERROR QUE TENIA  ,PERO YA LO ENCONTRE
                TableRowSorter rowSorter = new TableRowSorter(dt);
                modelo_nuevo.getTabla().setRowSorter(rowSorter);
                modelo_nuevo.setRowSorter(rowSorter);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Surguio un problema ,intentalo mas tarde");
                // System.out.println("erro filtrar_ " + e.getMessage());

            }

            String sql_query = "SELECT * FROM  cuenta_usuarios ";

            if (!filtrar) {
                sql_query += "  WHERE TIPO_CUENTA =?";
            }

            pr = getConnection().prepareStatement(sql_query);

            if (!filtrar) {

                pr.setString(1, modelo_nuevo.getTipo_cuenta());
            }
            resultado = pr.executeQuery();

            int contador = 1;
            while (resultado.next()) {
                JCheckBox chec_estado = new JCheckBox("Activa");
                Object datos[] = new Object[9];

                datos[0] = contador;

                for (int i = 1; i < 9 - 1; i++) {

                    datos[i] = resultado.getString(i + 1);

                }
                boolean selecionar = true;
                if (!resultado.getString("ESTADO").equalsIgnoreCase("AC")) {
                    selecionar = false;
                    chec_estado.setText("Desactivada");

                }

                chec_estado.setSelected(selecionar);

                datos[datos.length - 1] = chec_estado;
                contador++;
                dt.addRow(datos);

            }
            retorno = true;

        } catch (Exception e) {
            System.out.println("error tabla cuenta usuarios   " + e.getMessage());

        }

        return retorno;
    }

    public boolean Tabla_Clientes(Modelo_Nuevo modelo_nuevo) {
        boolean retornar = false;
        try {

            PreparedStatement pr = null;
            ResultSet resultado;

            DefaultTableModel dt = new DefaultTableModel() {
                public boolean isCellEditable(int filas, int columnas) {

                    return false;
                }

            };

            dt.addColumn("#");
            dt.addColumn("Codigo");
            dt.addColumn("Nombre");
            dt.addColumn("Cédula");
            dt.addColumn("Teléfono");
            dt.addColumn("Saldo");
            dt.addColumn("Actualizar");
            dt.addColumn("Eliminar");

            JTableHeader encabezado = modelo_nuevo.getTabla().getTableHeader();
            encabezado.setDefaultRenderer(new Render_Encabezado());
            modelo_nuevo.getTabla().setTableHeader(encabezado);
            modelo_nuevo.getTabla().getTableHeader().setReorderingAllowed(false);

            modelo_nuevo.getTabla().setDefaultRenderer(Object.class, new Renderizar_Tablas(8, " mmmmm"));

            modelo_nuevo.getTabla().setModel(dt);

            try { /// NO ES NECEARIO ,  LO PUSE PARA ENCONTRAR UN ERROR QUE TENIA  ,PERO YA LO ENCONTRE
                TableRowSorter rowSorter = new TableRowSorter(dt);
                modelo_nuevo.getTabla().setRowSorter(rowSorter);
                modelo_nuevo.setRowSorter(rowSorter);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Surguio un problema ,intentalo mas tarde");
                // System.out.println("erro filtrar_ " + e.getMessage());

            }

            pr = getConnection().prepareStatement("SELECT * FROM tabla_clientes ");

            resultado = pr.executeQuery();

            int contador = 1;
            JButton btn_eliminar = new JButton(icono_eliminar);
            btn_eliminar.setName("Eliminar");
            JButton btn_actualizar = new JButton(icono_editar);
            btn_actualizar.setName("Actualizar");

            while (resultado.next()) {

                Object datos[] = new Object[8];
                datos[0] = contador;
                for (int i = 1; i < 8 - 2; i++) {

                    datos[i] = resultado.getString(i + 1);

                }

                datos[datos.length - 2] = btn_actualizar;
                datos[datos.length - 1] = btn_eliminar;
                dt.addRow(datos);
                contador++;

            }
            retornar = true;

        } catch (HeadlessException | SQLException e) {
            System.out.println("erro " + e.getMessage());
        }

        return retornar;
    }

    public boolean Modelo_Tabla_Ventas(Modelo_Nuevo modelo_nuevo, boolean elegir_query) { ///este metodo lo copie en el curd nuevo  lo puedo borrar
        boolean retorno = false;
        try {

            String parametro = "";

            if (!elegir_query) {
                parametro += "  WHERE DATE  BETWEEN  '" + modelo_nuevo.getFecha() + "' AND  '" + modelo_nuevo.getFecha_final() + "' ";

            }
            PreparedStatement pr = null;
            ResultSet resultado = null;

            pr = getConnection().prepareStatement("SELECT * FROM tabla_nuevo_ingresos  " + parametro + " ORDER BY  FECHA_DATE DESC");

            // pr.setString(1, modelo.getCliente());
            resultado = pr.executeQuery();
            DefaultTableModel dt = new DefaultTableModel() {
                public boolean isCellEditable(int filas, int columnas) {

                    return false;
                }

            };
            dt.addColumn("#");
            dt.addColumn("Fecha");
            dt.addColumn("Producto");
            dt.addColumn("Precio");
            dt.addColumn("Cantidad");

            dt.addColumn("Cobrado");

            JTableHeader encabezado = modelo_nuevo.getTabla().getTableHeader();
            encabezado.setDefaultRenderer(new Render_Encabezado());
            modelo_nuevo.getTabla().setTableHeader(encabezado);
            modelo_nuevo.getTabla().getTableHeader().setReorderingAllowed(false);
            //  modelo.getTabla().setDefaultRenderer(Object.class, new Renderizar_Tablas(6, "Tabla_ventas"));

            modelo_nuevo.getTabla().setModel(dt);

            try {/// NO ES NECEARIO ,  LO PUSE PARA ENCONTRAR UN ERROR QUE TENIA  ,PERO YA LO ENCONTRE
                rowSorter = new TableRowSorter(dt);
                modelo_nuevo.getTabla().setRowSorter(rowSorter);
                modelo_nuevo.setRowSorter(rowSorter);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Surguio un problema  en el rowsirte ,intentalo mas tarde de la tabla  " + "\nVentas DESCONOCIDO");
                System.out.println("erro filtrar_ " + e.getMessage());

            }
            int contador = 1;
            double total_cobrar = 0;
            int cantidad_produ_cliente = 0;
            while (resultado.next()) {
                Object datos[] = new Object[6];

                datos[0] = contador;
                datos[1] = resultado.getString("FECHA_DATE");
                datos[2] = resultado.getString("PRODUCTO");
                datos[3] = resultado.getDouble("PRECIO");
                datos[4] = resultado.getInt("CANTIDAD");
                datos[5] = resultado.getDouble("TOTAL");
                total_cobrar += resultado.getDouble("TOTAL");
                cantidad_produ_cliente += resultado.getInt("CANTIDAD");
                contador++;

                dt.addRow(datos);

            }

            modelo_nuevo.setTotal_cobrar(total_cobrar);
            modelo_nuevo.setCantidad_productos(cantidad_produ_cliente);

            retorno = true;

        } catch (Exception e) {
            System.out.println("erro al poner el modelo a latabla_nuevo_ingresos" + e.getMessage());
        }
        return retorno;
    }

    public boolean tabla_Saldo_Cliente(Modelo_Nuevo modelo_nuevo) {
        boolean retornar = false;
        try {
            PreparedStatement pr = null;
            ResultSet resultado = null;

            DefaultTableModel dt = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int filas, int columnas) {
                    return false;
                }
            };

            dt.addColumn("#");
            dt.addColumn("Codigo");
            dt.addColumn("Nombre");
            dt.addColumn("Cedula");
            dt.addColumn("Teléfono");
            dt.addColumn("Saldo Pendiente");

            JTableHeader encabezado = modelo_nuevo.getTabla().getTableHeader();
            encabezado.setDefaultRenderer(new Render_Encabezado());
            modelo_nuevo.getTabla().setTableHeader(encabezado);
            modelo_nuevo.getTabla().getTableHeader().setReorderingAllowed(false);

            modelo_nuevo.getTabla().setModel(dt);
            pr = getConnection().prepareStatement("SELECT * FROM tabla_clientes");
            resultado = pr.executeQuery();

            int contador = 1;
            double saldos_pendientes = 0;
            int cantidad_productos = 0;
            while (resultado.next()) {

                Object datos[] = new Object[6];

                datos[0] = contador;
                datos[1] = resultado.getString("CODIGO");
                datos[2] = resultado.getString("NOMBRE");
                datos[3] = resultado.getString("CEDULA");
                datos[4] = resultado.getString("CELULAR");
                datos[5] = resultado.getString("SALDO_PENDIENTE");
                saldos_pendientes += resultado.getDouble("SALDO_PENDIENTE");

                dt.addRow(datos);
                contador++;

            }
            modelo_nuevo.setTotal_cobrar(saldos_pendientes);
            retornar = true;

        } catch (Exception e) {

            System.out.println("erro al poner el modelo de saldo pendiente " + e.getMessage());
        }

        return retornar;
    }

    public void Graficar(Modelo_Nuevo modelo_nuevo, boolean filtrar_fecha) {

        //true filtrar por fecha
        try {
            PreparedStatement pr = null;
            ResultSet resultado = null;
            String sql_query = "SELECT";
            String sql_filtrar_x_fecha = " ";
            String elegir_tipo_y_modelo = "";
            String titulo = "Dolares Ingresdos    $";
            String subtitulo_debajo_del_titulo = "Rango de Dinero $";

            if (filtrar_fecha) { //true filtra por la fecha
                sql_filtrar_x_fecha = " WHERE DATE  BETWEEN  '" + modelo_nuevo.getFecha() + "' AND  '" + modelo_nuevo.getFecha_final() + "'  ";

            }

            int parametro = modelo_nuevo.getParametro(); //tabla

            int tipo = modelo_nuevo.getTipo(); // barra o pastel
            int modelo = modelo_nuevo.getModelo(); //horizontal ,vertical, 3d , normal

            if (parametro == 0 || parametro == 1) {//parametro ingresos y tambien # productos vendidos , utilizo el mismo query
                sql_query += " PRODUCTO,SUM(TOTAL) AS SUMA_TOTAL_COBRAR ,SUM(CANTIDAD) AS CANTIDAD_PRODUCTO FROM tabla_nuevo_ingresos " + sql_filtrar_x_fecha + " GROUP BY PRODUCTO";
            }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (tipo == 0) {//pastel

                switch (modelo) {
                    case 0:
                        elegir_tipo_y_modelo = "PASTEL,NORMAL";
                        break;
                    case 1:
                        elegir_tipo_y_modelo = "PASTEL,3D";
                        break;

                }

            }
            if (tipo == 1) {//barra

                switch (modelo) {
                    case 0:
                        elegir_tipo_y_modelo = "BARRA,HORIZONTAL";
                        break;
                    case 1:
                        elegir_tipo_y_modelo = "BARRA,VERTICAL";
                        break;

                }

            }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            DefaultPieDataset modelo_pastel = new DefaultPieDataset();///grafico pastel
            DefaultCategoryDataset modelo_barra = new DefaultCategoryDataset(); ///grafico de barras

            pr = getConnection().prepareStatement(sql_query);
            resultado = pr.executeQuery();
            double ingresos_totales = 0;

            while (resultado.next()) {

                switch (parametro) {

                    case 0://INGRESOS POR PRODCUTOS VENDIDOS

                        if (tipo == 0) { //pastel

                            modelo_pastel.setValue(resultado.getString("PRODUCTO") + " :$ " + resultado.getInt("SUMA_TOTAL_COBRAR"), resultado.getInt("SUMA_TOTAL_COBRAR"));

                        }
                        if (tipo == 1) { //barra
                            modelo_barra.setValue(resultado.getInt("SUMA_TOTAL_COBRAR"), resultado.getString("PRODUCTO") + " # " + resultado.getInt("CANTIDAD_PRODUCTO"), resultado.getString("PRODUCTO") + " $ " + resultado.getInt("SUMA_TOTAL_COBRAR"));

                        }
                        ingresos_totales += resultado.getDouble("SUMA_TOTAL_COBRAR");

                        break;

                    case 1://CANTIDAD PRODUCTOS VENDIDOS
                        titulo = " Cantidad Productos Vendidos   #";
                        subtitulo_debajo_del_titulo = "Rango de Número de Productos";
                        if (tipo == 0) { //pastel

                            modelo_pastel.setValue(resultado.getString("PRODUCTO") + " # " + resultado.getInt("CANTIDAD_PRODUCTO"), resultado.getInt("CANTIDAD_PRODUCTO"));

                        }
                        if (tipo == 1) { //barra
                            modelo_barra.setValue(resultado.getInt("CANTIDAD_PRODUCTO"), resultado.getString("PRODUCTO"), resultado.getString("PRODUCTO") + " # " + resultado.getInt("CANTIDAD_PRODUCTO"));

                        }
                        ingresos_totales += resultado.getInt("CANTIDAD_PRODUCTO");

                        break;

                }
                JFreeChart chart_grafico = null;

                if (tipo == 0) { ///pastel

                    switch (elegir_tipo_y_modelo) {

                        case "PASTEL,NORMAL":
                            chart_grafico = ChartFactory.createPieChart(titulo + ingresos_totales, modelo_pastel, true, true, true);

                            break;
                        case "PASTEL,3D":
                            chart_grafico = ChartFactory.createPieChart3D(titulo + ingresos_totales, modelo_pastel, true, true, true);

                            break;

                    }

                }

                if (tipo == 1) { //barra

                    switch (elegir_tipo_y_modelo) {

                        case "BARRA,HORIZONTAL":
                            chart_grafico = ChartFactory.createBarChart3D(titulo + ingresos_totales, "Nombre Productos", subtitulo_debajo_del_titulo, modelo_barra, PlotOrientation.HORIZONTAL, true, true, true);

                            break;
                        case "BARRA,VERTICAL":
                            chart_grafico = ChartFactory.createBarChart3D(titulo + ingresos_totales, "Nombre Productos", subtitulo_debajo_del_titulo, modelo_barra, PlotOrientation.VERTICAL, true, true, true);

                            break;

                    }

                }

                ChartPanel panel = new ChartPanel(chart_grafico, true);
                modelo_nuevo.setJpanel(panel);

            }

        } catch (Exception e) {
            System.out.println("erro " + e.getMessage());
        }

    }

    private TableRowSorter rowSorter;
    private final ImageIcon icono_editar;
    private final ImageIcon icono_eliminar;

}
