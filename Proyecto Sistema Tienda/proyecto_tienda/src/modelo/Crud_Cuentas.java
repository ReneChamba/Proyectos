package modelo;

import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.Level;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class Crud_Cuentas extends Coneccion_tienda {

    public Crud_Cuentas() {
    }
    public boolean Iniciar_Sesion(Modelo modelo) {

        boolean retorno = false;
        try {
            String tipo_cuenta = "";
            PreparedStatement pr = null;
            ResultSet resultado = null;
            pr = getConnection().prepareStatement("SELECT  *  FROM cuenta_usuarios WHERE USUARIO =? && CONTRASENA=?");

            pr.setString(1, modelo.getUsuario());
            pr.setString(2, modelo.getContasena());
          
            String cedula = "";
            String estado = "";
            String nombre = "";
            String apellido = "";
            String cuenta = "";
            String contrasena = "";
            String correo = "";

            resultado = pr.executeQuery();
            if (resultado.next()) {

                cuenta = resultado.getString("USUARIO");
                contrasena = resultado.getString("CONTRASENA");
                if (cuenta.equals(modelo.getUsuario()) && contrasena.equals(modelo.getContasena())) {
                    retorno = true;
                }

                tipo_cuenta = resultado.getString("TIPO_CUENTA");
                cedula = resultado.getString("CEDULA");
                estado = resultado.getString("ESTADO");
                nombre = resultado.getString("NOMBRE");
                apellido = resultado.getString("APELLIDO");
                correo = resultado.getString("CORREO");

            }

            modelo.setTipo_cuenta(tipo_cuenta);
            modelo.setCedula(cedula);
            modelo.setEstado_Cuenta(estado);
            modelo.setNombre(nombre);
            modelo.setApellido(apellido);
            modelo.setCorreo(correo);

        } catch (SQLException ex) {
            System.out.println("error al iniciar sesion " + ex.getMessage());

        } finally {

            getDesconectar();
        }

        return retorno;
    }

    public boolean Registrar(Modelo modelo) {

        boolean retorno = false;
        try {
            PreparedStatement pr = null;
            pr = getConnection().prepareStatement("INSERT INTO cuenta_usuarios VALUES (NULL,?,?,?,?,?,?,?,?) ");
            pr.setString(1, modelo.getCedula());
            pr.setString(2, modelo.getNombre());
            pr.setString(3, modelo.getApellido());
            pr.setString(4, modelo.getCorreo());
            pr.setString(5, modelo.getTipo_cuenta());
            pr.setString(6, modelo.getUsuario());
            pr.setString(7, modelo.getContasena());
            pr.setString(8, modelo.getEstado_Cuenta());
            pr.executeUpdate();
            retorno = true;

        } catch (SQLException ex) {
            System.out.println("error al iniciar sesion " + ex.getMessage());

        } finally {

            getDesconectar();
        }

        return retorno;
    }
    
        public boolean  Insertar_Tabla_Nuevo_Ingresos(Modelo modelo) {

        boolean retorno = false;
        try {
            PreparedStatement pr = null;
            pr = getConnection().prepareStatement("INSERT INTO  tabla_nuevo_ingresos VALUES (NULL,?,?,?,?,?,?,?) ");
              pr.setString(1, modelo.getFecha_vendida());
            pr.setString(2, modelo.getFecha());
            pr.setString(3, modelo.getCodigo_registro());
            pr.setString(4, modelo.getProducto());
            pr.setInt(5, modelo.getCantidad_productos());
            pr.setDouble(6, modelo.getPrecio());
            pr.setDouble(7, modelo.getTotal_cada_producto());  
            pr.executeUpdate();
            retorno = true;

        } catch (SQLException ex) {
            System.out.println("error al insertar en  tabla_nuevo_ingresos  " + ex.getMessage());

        } finally {

            getDesconectar();
        }

        return retorno;
    }
    
  
    public boolean Insertar_tabla_listar_ventas(Modelo modelo ,boolean elegir,int delet) { // esta es desde el contralador vender producto

        boolean retorno = false;
        try {
            PreparedStatement pr = null;
            String sql_query ="INSERT INTO tabla_listar_venta VALUES (NULL,?,?,?,?,?,?)";
           
            if (!elegir){
                sql_query ="DELETE FROM  tabla_listar_venta ";
                if (delet==2){
                    sql_query +=" WHERE ID_LISTA =?";
                }
                
                
            }
            
            
            pr = getConnection().prepareStatement(sql_query);
          
            if (elegir){
                  pr.setString(1, modelo.getCodigo_registro());
                 pr.setString(2, modelo.getCodigo_proveedor());
            pr.setString(3, modelo.getProducto());
            pr.setInt(4, modelo.getCantidad_productos());
            pr.setDouble(5, modelo.getPrecio());
            pr.setDouble(6, modelo.getTotal_cada_producto());

            }
            if (!elegir && delet ==2){
                pr.setString(1, modelo.getCodigo_registro());
                
            }
           
            pr.executeUpdate();
            retorno = true;

        } catch (SQLException ex) {
            System.out.println("error al cargar tabla listar ventas " + ex.getMessage());

        } finally {

            getDesconectar();
        }

        return retorno;
    }
    
     public boolean Actulizar_Saldo_Pendiente (Modelo modelo){
         boolean retornas = false;        
         try {
         
              PreparedStatement pr = null;
               pr = getConnection().prepareStatement("UPDATE tabla_clientes SET SALDO_PENDIENTE = '"+modelo.getAbono()+"' WHERE CEDULA =?");
               pr.setString(1, modelo.getCedula());
             pr.executeUpdate();
             retornas = true;
             
         } catch (Exception e) {
             System.out.println("erro al actualizar el saldo pendiente " + e.getMessage());
         }
         
         return  retornas;
     }
    
  
        public boolean Llenar_Combo_Categoria(Modelo modelo ) {
        boolean retorno = false;
        try {

            PreparedStatement pr = null;
            ResultSet resultado = null;

            pr = getConnection().prepareStatement("SELECT  CATEGORIA  FROM proveedor_categoria WHERE CATEGORIA !='DESCONOCIDO' ORDER BY CATEGORIA");

            resultado = pr.executeQuery();

            while (resultado.next()) {
                modelo.getCombo_cliente().addItem(resultado.getString("CATEGORIA"));
            }

            retorno = true;

        } catch (SQLException ex) {
            System.out.println("error al CARGAR EL COMBO categoria " + ex.getMessage());

        } finally {

            getDesconectar();
        }

        return retorno;

    }
      

    public boolean Llenar_Combo_Producto(Modelo modelo, boolean elegir) {
        boolean retorno = false;
        try {
            String sql_select = "SELECT  PRODUCTO,PRECIO,DISPONIBLES,CODIGO_REGISTRO  FROM tablas_ventas";
            PreparedStatement pr = null;
            ResultSet resultado = null;
            String verificar_Vacio = "";
            if (!elegir) {
                sql_select += "  WHERE CATEGORIA = ? AND DISPONIBLES > 0";

            }

            // pr = getConnection().prepareStatement("SELECT  PRODUCTO,PRECIO  FROM tablas_ventas");
            pr = getConnection().prepareStatement(sql_select);

            if (!elegir) {
                pr.setString(1, modelo.getCategoria());
            }

            resultado = pr.executeQuery();
            while (resultado.next()) {
                modelo.getCombo_productos().addItem(resultado.getString("PRODUCTO") + ":  " + resultado.getString("PRECIO") + " $  /  Cantidad: "
                        + resultado.getString("DISPONIBLES") + " U /  " + resultado.getString("CODIGO_REGISTRO"));

                //3 espacios despues del /
                if (!elegir) {
                    verificar_Vacio = (resultado.getString("PRODUCTO"));
                }

            }
            if (!elegir) {

                if (verificar_Vacio.equals("")) {
                    modelo.getCombo_productos().addItem("SIN PRODUCTOS");
                }

            }

            retorno = true;

        } catch (SQLException ex) {
            System.out.println("error al CARGAR EL COMBO " + ex.getMessage());

        } finally {

            getDesconectar();
        }

        return retorno;

    }

    public boolean Ver_Cantidad_Disponible_Tabla_Productos(Modelo modelo) {
        boolean retorno = false;
        try {
            /*
             retorno cantidad_disponible  egreso,disponible, ingresos, ganancias
             */

            int cantidad_disponible = 0;
            double ingresos = 0;
            double ganancias = 0; // esta solo la utilizo cuando cancelo un ingresa en la tabla ventas, el label nueva lista
            double egresos_compras = 0;
            String sql_select = "SELECT  EGRESOS_COMPRAS,INGRESOS,DISPONIBLES,GANANCIAS  FROM tablas_ventas WHERE  PRODUCTO=? AND CODIGO_REGISTRO=?";
            PreparedStatement pr = null;
            ResultSet resultado = null;

            pr = getConnection().prepareStatement(sql_select);

            pr.setString(1, modelo.getProducto());
            pr.setString(2, modelo.getCodigo_registro());
            resultado = pr.executeQuery();
            while (resultado.next()) {
                cantidad_disponible = resultado.getInt("DISPONIBLES");
                ingresos = resultado.getDouble("INGRESOS");
                ganancias = resultado.getInt("GANANCIAS");
                egresos_compras = resultado.getDouble("EGRESOS_COMPRAS");

            }
            modelo.setEgresos_por_compras(egresos_compras);
            modelo.setCantidad_disponibles(cantidad_disponible); /// cantidad_disponible de un producto que pertenece a  una categoria
            modelo.setTotal_cobrar(ingresos);
            modelo.setGanancias_tabla_compras(ganancias);

            retorno = true;

        } catch (SQLException ex) {
            System.out.println("error al  obtener la cantidad  q hay de un producto " + ex.getMessage());

        } finally {

            getDesconectar();
        }

        return retorno;

    }

    public boolean Actualizar_Cantidad_Productos(Modelo modelo) { 
        boolean retorno = false;
        try {
            PreparedStatement pr = null;
            pr = getConnection().prepareStatement("UPDATE   tablas_ventas SET DISPONIBLES = '" + modelo.getCantidad_productos() + "' , INGRESOS = '" + modelo.getTotal_cobrar() + "',GANANCIAS = '" + modelo.getGanancias_tabla_compras() + "' WHERE PRODUCTO=?  AND CODIGO_REGISTRO=?");

            pr.setString(1, modelo.getProducto());
            pr.setString(2, modelo.getCodigo_registro());
            pr.executeUpdate();
            retorno = true;

        } catch (Exception e) {
            System.out.println("error  al actulizar  la cantidad y ingresos de la tabla ventas");
        }
        return retorno;
    }



    public boolean Agregar_Cliente(Modelo modelo) {
        boolean retorno = false;
        try {
            PreparedStatement pr = null;
            pr = getConnection().prepareStatement("INSERT INTO nombre_clientes VALUES (NULL,?)");
            pr.setString(1, modelo.getCliente());
            pr.executeUpdate();
            retorno = true;

        } catch (Exception e) {
            System.out.println("error insertar cliente");
        }
        return retorno;
    }

    public boolean Agregar_Cliente_Producto(Modelo modelo) {

        boolean retorno = false;
        try {
            PreparedStatement pr = null;

            pr = getConnection().prepareStatement("INSERT INTO cliente VALUES (NULL,?,?,?,?,?,?,?)");
            pr.setString(1, modelo.getCodigo_registro());
            pr.setString(2, modelo.getCliente());
            pr.setString(3, modelo.getFecha());
            pr.setString(4, modelo.getProducto());
            pr.setDouble(5, modelo.getPrecio());
            pr.setInt(6, modelo.getCantidad_productos());
            pr.setDouble(7, modelo.getTotal_cada_producto());
            pr.executeUpdate();
            retorno = true;

        } catch (Exception e) {
            System.out.println("erro  insertar un nuevo producto");
        }

        return retorno;
    }


   

    public boolean Actualizar_Tabla_Deudas(Modelo modelo, boolean elegir) {

        boolean retorno = false;
        PreparedStatement pr = null;

        // true es actualizar 
        //false es eliminar tood los registro de una cliente . hjos y padres
        String sql_quey = "UPDATE deudas SET ABONO = '" + modelo.getAbono() + "' , TOTAL ='" + modelo.getTotal_cobrar() + "'   WHERE CLIENTE =? AND DESCRIPCION ='PADRE'";

        if (!elegir) {

            sql_quey = "DELETE FROM deudas WHERE CLIENTE =?";
        }

        try {
            pr = getConnection().prepareStatement(sql_quey);
            pr.setString(1, modelo.getCliente());
            pr.executeUpdate();

            retorno = true;

        } catch (SQLException ex) {
        }
        return retorno;

    }

    public boolean Modelo_Tabla_Filtrar_Deudas(Modelo modelo) {
        boolean retorno = false;

        try {

            String parametro = "SELECT * FROM deudas WHERE CLIENTE =? AND DESCRIPCION !='PADRE'";

            PreparedStatement pr = null;
            ResultSet resultado = null;

            pr = getConnection().prepareStatement(parametro);

            pr.setString(1, modelo.getCliente());
            resultado = pr.executeQuery();

            DefaultTableModel dt = new DefaultTableModel() {
                public boolean isCellEditable(int filas, int columnas) {

                    return false;
                }

            };
            dt.addColumn("#");
            dt.addColumn("Fecha");
            dt.addColumn("Cliente");
            dt.addColumn("Producto");
            dt.addColumn("Cantidad");
            dt.addColumn("Precio");
            dt.addColumn("Total");

            JTableHeader encabezado = modelo.getTabla().getTableHeader();
            encabezado.setDefaultRenderer(new Render_Encabezado());
            modelo.getTabla().setTableHeader(encabezado);
            modelo.getTabla().getTableHeader().setReorderingAllowed(false);
            modelo.getTabla().setDefaultRenderer(Object.class, new Renderizar_Tablas(7, "tabla_deudas"));

            modelo.getTabla().setModel(dt);
//
//            try {/// NO ES NECEARIO ,  LO PUSE PARA ENCONTRAR UN ERROR QUE TENIA  ,PERO YA LO ENCONTRE
//                rowSorter_tabla_ventas = new TableRowSorter(dt);
//                modelo.getTabla().setRowSorter(rowSorter_tabla_ventas);
//                modelo.setRowSorter(rowSorter_tabla_ventas);
//
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Surguio un problema  en el rowsirte ,intentalo mas tarde de la tabla  " + "\nVentas DESCONOCIDO");
//                // System.out.println("erro filtrar_ " + e.getMessage());
//
//            }

            int contador = 1;
            double total_cobrar = 0;
            int cantidad_produ_cliente = 0;
            while (resultado.next()) {
                Object datos[] = new Object[7];

                datos[0] = contador;
                datos[1] = resultado.getString("FECHA_VENDIDA");
                datos[2] = resultado.getString("CLIENTE");
                datos[3] = resultado.getString("PRODUCTO");
                datos[4] = resultado.getString("CANTIDAD");
                datos[5] = resultado.getString("PRECIO");
                datos[6] = resultado.getString("TOTAL");

                contador++;

                dt.addRow(datos);

            }

            modelo.setTotal_cobrar(total_cobrar);
            modelo.setCantidad_produ_cliente(cantidad_produ_cliente);

            retorno = true;

        } catch (Exception e) {
            System.out.println("erro al poner el modelo a la tabla ventas" + e.getMessage());
        }

        return retorno;
    }





  

  

    public boolean Insertar_Proveedor(Modelo modelo, int elegir_campo) {

        boolean retorno = false;
        try {
            PreparedStatement pr = null;
            pr = getConnection().prepareStatement("INSERT INTO proveedor_categoria VALUES (NULL,?,?)");

            if (elegir_campo == 1) {
                pr.setString(1, modelo.getCliente());/// va a servir como categoria el usuario cuando lo llamde desde Compras   
                pr.setString(2, "DESCONOCIDO");///   
            } else if (elegir_campo == 2) {
                pr.setString(1, "DESCONOCIDO");//
                pr.setString(2, modelo.getCliente());/// va a servir como proveedor el usuario cuando lo llamde desde Compras   
            }

            pr.executeUpdate();
            retorno = true;

        } catch (SQLException ex) {
            System.out.println("error  no se pudo insertar en la tabla proveedor_categoria" + ex.getMessage());

        } finally {

            getDesconectar();
        }

        return retorno;
    }

 

    public boolean Llenar_Combo_Proveedor(Modelo modelo) {
        boolean retorno = false;
        try {
            PreparedStatement pr = null;
            ResultSet resultado = null;
            //pr = getConnection().prepareStatement("SELECT  PROVEEDOR  FROM proveedor_categoria WHERE PROVEEDOR !='DESCONOCIDO'");

            pr = getConnection().prepareStatement("SELECT  EMPRESA,CODIGO  FROM tabla_proveedor");

            resultado = pr.executeQuery();
            while (resultado.next()) {
                modelo.getCombo_productos().addItem(resultado.getString("EMPRESA") + "  :" + resultado.getString("CODIGO"));
            }
            retorno = true;

        } catch (SQLException ex) {
            System.out.println("error al CARGAR EL COMBO proveedor " + ex.getMessage());

        } finally {

            getDesconectar();
        }

        return retorno;

    }

    public boolean Modelo_Tabla_Compras(Modelo modelo) {
        boolean retorno = false;
        try {
            PreparedStatement pr = null;
            ResultSet resultado = null;
            pr = getConnection().prepareStatement("SELECT * FROM tablas_ventas ORDER BY  CATEGORIA");

            ///pr.setString(1, modelo.getCliente());
            resultado = pr.executeQuery();
            DefaultTableModel dt = new DefaultTableModel() {
                public boolean isCellEditable(int filas, int columnas) {

                    return false;
                }

            };
            dt.addColumn("#");
            dt.addColumn("COD");
            dt.addColumn("Fecha Registro");
            dt.addColumn("Categoria");
            dt.addColumn("Proveedor");
            dt.addColumn("Co_Pro");
            dt.addColumn("Producto");
            dt.addColumn("Canti");
            dt.addColumn("Egresos");
            dt.addColumn("Precio");
            dt.addColumn("#Disp");
            dt.addColumn("Ingresos");
            dt.addColumn("Ganancia");
            dt.addColumn("E");

            JTableHeader encabezado = modelo.getTabla().getTableHeader();
            encabezado.setDefaultRenderer(new Render_Encabezado());
            modelo.getTabla().setTableHeader(encabezado);
            modelo.getTabla().getTableHeader().setReorderingAllowed(false);
            modelo.getTabla().setDefaultRenderer(Object.class, new Renderizar_Tablas(14, "hola"));
            modelo.getTabla().setModel(dt);

            try {/// NO ES NECEARIO ,  LO PUSE PARA ENCONTRAR UN ERROR QUE TENIA  ,PERO YA LO ENCONTRE
                rowSorter = new TableRowSorter(dt);
                modelo.getTabla().setRowSorter(rowSorter);
                modelo.setRowSorter(rowSorter);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Surguio un problema ,intentalo mas tarde");
                // System.out.println("erro filtrar_ " + e.getMessage());

            }

            int contador = 1;
//            double total_cobrar = 0;
            int cantidad_produ_cliente = 0;
            while (resultado.next()) {
                Object datos[] = new Object[14];

                JButton btn_guardar = new JButton(new ImageIcon("src/Image_2/ELIMINAR.png"));
                datos[0] = contador;
                datos[1] = resultado.getString("CODIGO_REGISTRO");
                datos[2] = resultado.getString("FECHA");
                datos[3] = resultado.getString("CATEGORIA");
                datos[4] = resultado.getString("PROVEEDOR");
                datos[5] = resultado.getString("CODIGO_PROVEEDOR");
                datos[6] = resultado.getString("PRODUCTO");
                datos[7] = resultado.getInt("CANTIDAD");
                datos[8] = resultado.getInt("EGRESOS_COMPRAS");
                datos[9] = resultado.getString("PRECIO");

                cantidad_produ_cliente = resultado.getInt("DISPONIBLES");
                if (cantidad_produ_cliente != 0) {
                    datos[10] = resultado.getInt("DISPONIBLES");
                } else {
                    datos[10] = "VACIA";
                }
                datos[11] = resultado.getString("INGRESOS");
                datos[12] = resultado.getDouble("GANANCIAS");
                datos[13] = btn_guardar;
//                total_cobrar += resultado.getDouble("TOTAL");
//                cantidad_produ_cliente += resultado.getInt("CANTIDAD");
                contador++;

                dt.addRow(datos);

            }

            /*
            
             */
            ///////////////////////////////////////////////////////////////////
            retorno = true;

        } catch (Exception e) {
            System.out.println("erro al poner el modelo a la tabla " + e.getMessage());
        }
        return retorno;
    }

    public boolean Insertar_Tabla_Ventas(Modelo modelo, boolean elegir) {

        boolean retorno = false;
        try {
            String sql_query = "INSERT INTO tablas_ventas VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            if (!elegir) {
                sql_query = "UPDATE  tablas_ventas  SET CATEGORIA = '" + modelo.getCategoria() + "' ,  PROVEEDOR = '" + modelo.getProveedor() + "'"
                        + ",CODIGO_PROVEEDOR = '" + modelo.getCodigo_proveedor() + "' , PRODUCTO = '" + modelo.getProducto() + "'   WHERE CODIGO_REGISTRO = ? ";
            }

            PreparedStatement pr = null;

            pr = getConnection().prepareStatement(sql_query);
            if (!elegir) {
                pr.setString(1, modelo.getCodigo_registro());

            }

            if (elegir) {
                pr.setString(1, modelo.getFecha());
                pr.setDate(2, modelo.getFecha_tipo_date());
                pr.setString(3, modelo.getCodigo_registro());
                pr.setString(4, modelo.getCategoria());
                pr.setString(5, modelo.getProveedor());
                pr.setString(6, modelo.getCodigo_proveedor());
                pr.setString(7, modelo.getProducto());
                pr.setInt(8, modelo.getCantidad_productos());
                pr.setDouble(9, modelo.getEgresos_por_compras());
                pr.setDouble(10, modelo.getPrecio());
                pr.setDouble(11, modelo.getTotal_cobrar()); //el dinero que  se generara con los productos ingresados
                pr.setInt(12, modelo.getCantidad_disponibles());
                pr.setDouble(13, modelo.getGanancias_tabla_compras());
            }

            pr.executeUpdate();
            retorno = true;

        } catch (Exception e) {
            System.out.println("error  insertar un nuevo producto  o actualizar " + e.getMessage());
        }

        return retorno;
    }

//      public boolean Actualizar_Tabla_Ventas(Modelo modelo) {
//
//        boolean retorno = false;
//        try {
//            String sql_query = "INSERT INTO tablas_ventas VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//          
//                sql_query = "UPDATE  tablas_ventas  SET CATEGORIA = '" + modelo.getCategoria() + "' ,  PROVEEDOR = '" + modelo.getProveedor() + "'"
//                        + ",CODIGO_PROVEEDOR = '" + modelo.getCodigo_proveedor() + "' , PRODUCTO = '" + modelo.getProducto() + "'   WHERE CODIGO_REGISTRO = ? ";
//          
//
//            PreparedStatement pr = null;
//
//            pr = getConnection().prepareStatement(sql_query);
//       
//          
//
//            pr.executeUpdate();
//            retorno = true;
//
//        } catch (Exception e) {
//            System.out.println("error  insertar un nuevo producto  o actualizar " + e.getMessage());
//        }
//
//        return retorno;
//    }
//    
    public boolean Insertar_Tabla_Productos_Proveedor(Modelo modelo, boolean elegir) {

        boolean retorno = false;
        try {

            /*
            true hace un insert 
            false hace un update
             */
            String sql_query = "INSERT INTO tabla_productos_proveedores VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?)";
            if (!elegir) {
                sql_query = "UPDATE  tabla_productos_proveedores  SET CATEGORIA = '" + modelo.getCategoria() + "' ,  CODIGO_PROVEEDOR = '" + modelo.getCodigo_proveedor() + "'"
                        + " , PRODUCTO = '" + modelo.getProducto() + "' , CANTIDAD = '" + modelo.getCantidad_productos() + "' , PRECIO = '" + modelo.getPrecio() + "' "
                        + " ,EGRESOS = '" + modelo.getTotal_cobrar() + "'  WHERE CODIGO_REGI_PRODUCTO = ? ";
            }

            PreparedStatement pr = null;

            pr = getConnection().prepareStatement(sql_query);
            if (!elegir) {
                pr.setString(1, modelo.getCodigo_registro());

            }

            if (elegir) {
                pr.setString(1, modelo.getCodigo_proveedor());
                pr.setString(2, modelo.getCategoria());
                pr.setString(3, modelo.getProducto());
                pr.setString(4, modelo.getCodigo_registro());
                pr.setString(5, modelo.getFecha());
                pr.setDouble(6, modelo.getPrecio());
                pr.setInt(7, modelo.getCantidad_productos());
                pr.setDouble(8, modelo.getTotal_cobrar()); //el dinero que  se generara con los productos ingresados
                pr.setInt(9, modelo.getCantidad_productos_proveedor_vendido());
                pr.setDouble(10, modelo.getIngresos_por_productos_vendidos());
                pr.setDouble(11, modelo.getGanancias());
            }

            pr.executeUpdate();
            retorno = true;

        } catch (Exception e) {
            System.out.println("error  insertar un nuevo producto   en la tabla productos proveedores " + e.getMessage());
        }

        return retorno;
    }

    public boolean Actualizar_Tabla_Productos_Proveedor_P_Ven_Ingresos(Modelo modelo) {
        /*
        
        este metodo solo actuliza el numero de productos de un proveedor vendido y los ingreos
         */

        boolean retorno = false;
        try {
            PreparedStatement pr = null;
            String sql_query = "UPDATE  tabla_productos_proveedores  SET PRODUCTOS_VENDIDOS = '" + modelo.getCantidad_productos() + "' ,  INGRESOS_POR_PROD_VENDIDOS = '" + modelo.getTotal_cada_producto() + "'"
                    + " , GANANCIAS = '" + modelo.getGanancias() + "'  WHERE CODIGO_REGI_PRODUCTO = ? ";

            pr = getConnection().prepareStatement(sql_query);
            pr.setString(1, modelo.getCodigo_registro());

            pr.executeUpdate();
            retorno = true;

        } catch (Exception e) {
            System.out.println("error  al actualizar el numero de productos de un proveedor vendido, tabla productos proveedorres " + e.getMessage());
        }

        return retorno;
    }

    public boolean Eliminar_Tabla_Ventas(Modelo modelo) {
        boolean retorno = false;
        try {
            PreparedStatement pr = null;
            pr = getConnection().prepareStatement("DELETE  FROM  tablas_ventas WHERE CODIGO_REGISTRO =? ");

            pr.setString(1, modelo.getCodigo_registro());

            pr.executeUpdate();
            retorno = true;

        } catch (Exception e) {
            System.out.println("Erro no se pudo borrar  el producto vacio de la tabla_ventas");
        }
        return retorno;
    }

    public boolean Agregar_Actuali_Elminar_tb_cate_provee(Modelo modelo, boolean campo, int elegir) {
        boolean retorno = false;
        try {
            String sql_quey = "";

            if (campo) {

                switch (elegir) {
                    case 1:
                        sql_quey = "INSERT INTO  proveedor_categoria VALUES (null,?,?)";
                        break;
                    case 2:
                        sql_quey = "UPDATE  proveedor_categoria SET CATEGORIA =  '" + modelo.getCliente() + "' , PROVEEDOR = 'DESCONOCIDO'   WHERE CATEGORIA =?";
                        break;
                    case 3:
                        sql_quey = "DELETE FROM proveedor_categoria  WHERE CATEGORIA = ? ";
                        break;
                    default:
                        break;
                }

            } else {
                switch (elegir) {
                    case 1:
                        sql_quey = "INSERT INTO proveedor_categoria VALUES (null,?,?)";
                        break;
                    case 2:
                        sql_quey = "UPDATE  proveedor_categoria SET CATEGORIA = 'DESCONOCIDO' , PROVEEDOR =  '" + modelo.getCliente() + "' WHERE PROVEEDOR =? ";
                        break;
                    case 3:
                        sql_quey = "DELETE FROM proveedor_categoria  WHERE PROVEEDOR = ? ";
                        break;
                    default:
                        break;
                }

            }

            PreparedStatement pr = null;
            pr = getConnection().prepareStatement(sql_quey);

            if (elegir == 1) {

                if (campo) {
                    pr.setString(1, modelo.getCliente());
                    pr.setString(2, "DESCONOCIDO");
                } else {
                    pr.setString(1, "DESCONOCIDO");
                    pr.setString(2, modelo.getCliente());
                }

            } else {
                pr.setString(1, modelo.getProveedor());

            }

            pr.executeUpdate();
            retorno = true;

        } catch (Exception e) {
            System.out.println("Erro no se pudo agregar_actualizaR_eliminar");
        }
        return retorno;
    }

    public boolean Verificar_No_Repetir_Catego_Pro(Modelo modelo, boolean elegir) {
        boolean retorno = false;
        try {
            PreparedStatement pr = null;
            ResultSet resultado = null;
            String nombre_parametro = "CATEGORIA";

            String sql_consulta = "SELECT CATEGORIA FROM proveedor_categoria"; // true categoria
            if (!elegir) { // false proveedor
                sql_consulta = "SELECT PROVEEDOR FROM proveedor_categoria";
                nombre_parametro = "PROVEEDOR";
            }

            pr = getConnection().prepareStatement(sql_consulta);
            sql_consulta = "";

            resultado = pr.executeQuery();

            while (resultado.next()) {

                sql_consulta = resultado.getString(nombre_parametro);

                if (sql_consulta.equals(modelo.getCliente())) { // a categoria y proveedor le paso la varible Cliente

                    retorno = true;
                }
            }

        } catch (SQLException ex) {
            System.out.println("error al verificar si categoria o proveedor existen " + ex.getMessage());

        } finally {

            getDesconectar();
        }

        return retorno;

    }

    public boolean Modelo_Tabla_Venta_Productos(Modelo modelo) {
        boolean retorno = false;
        try {
            PreparedStatement pr = null;
            ResultSet resultado = null;
            pr = getConnection().prepareStatement("SELECT * FROM tablas_ventas ORDER BY  CATEGORIA");

            ///pr.setString(1, modelo.getCliente());
            resultado = pr.executeQuery();
            DefaultTableModel dt = new DefaultTableModel() {
                public boolean isCellEditable(int filas, int columnas) {

                    return false;
                }

            };
            dt.addColumn("Indice");
            dt.addColumn("Codigo Registro");
            // dt.addColumn("Fecha Registro");
            dt.addColumn("Categoria");
            /// dt.addColumn("Proveedor");
            dt.addColumn("Codigo Provedor");
            dt.addColumn("Producto");
            ///dt.addColumn("Canti");
            ///dt.addColumn("Egresos");
            dt.addColumn("Precio");
            dt.addColumn("# Disponible");
            // dt.addColumn("Ingresos");
            //dt.addColumn("Ganancia");
            //dt.addColumn("E");

            JTableHeader encabezado = modelo.getTabla().getTableHeader();
            encabezado.setDefaultRenderer(new Render_Encabezado(""));
            modelo.getTabla().setTableHeader(encabezado);
            modelo.getTabla().getTableHeader().setReorderingAllowed(false);
            modelo.getTabla().setDefaultRenderer(Object.class, new Renderizar_Tablas(7, ""));
            modelo.getTabla().setModel(dt);

            try {/// NO ES NECEARIO ,  LO PUSE PARA ENCONTRAR UN ERROR QUE TENIA  ,PERO YA LO ENCONTRE
                rowSorter = new TableRowSorter(dt);
                modelo.getTabla().setRowSorter(rowSorter);
                modelo.setRowSorter(rowSorter);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Surguio un problema ,intentalo mas tarde");
                // System.out.println("erro filtrar_ " + e.getMessage());

            }

            int contador = 1;
//            double total_cobrar = 0;
            int cantidad_produ_cliente = 0;
            while (resultado.next()) {
                Object datos[] = new Object[7];

                //  JButton btn_guardar = new JButton(new ImageIcon("src/Image_2/ELIMINAR.png"));
                datos[0] = contador;
                datos[1] = resultado.getString("CODIGO_REGISTRO");
                // datos[2] = resultado.getString("FECHA");
                datos[2] = resultado.getString("CATEGORIA");
                // datos[4] = resultado.getString("PROVEEDOR");
                datos[3] = resultado.getString("CODIGO_PROVEEDOR");
                datos[4] = resultado.getString("PRODUCTO").toUpperCase();
                //datos[7] = resultado.getInt("CANTIDAD");
                //datos[8] = resultado.getInt("EGRESOS_COMPRAS");
                datos[5] = resultado.getString("PRECIO");

                cantidad_produ_cliente = resultado.getInt("DISPONIBLES");
                if (cantidad_produ_cliente != 0) {
                    datos[6] = resultado.getInt("DISPONIBLES");
                } else {
                    datos[6] = "VACIA";
                }
                // datos[11] = resultado.getString("INGRESOS");
                //datos[12] = resultado.getDouble("GANANCIAS");
                //datos[13] = btn_guardar;
//                total_cobrar += resultado.getDouble("TOTAL");
//                cantidad_produ_cliente += resultado.getInt("CANTIDAD");
                contador++;

                dt.addRow(datos);

            }

            /*
            
             */
            ///////////////////////////////////////////////////////////////////
            retorno = true;

        } catch (Exception e) {
            System.out.println("error al poner el modelo a la tabla ventas_productos " + e.getMessage());
        }
        return retorno;
    }

    public String getCodigo_Registro_Compras() {
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
                sms_con_codigo = resultado.getString("CODIGO") + numero_codigo;

            }

            //////////Actualizar el valor del numero
            pr = getConnection().prepareStatement("UPDATE tabla_codigo SET NUMERO = '" + numero_codigo + "' WHERE CODIGO = 'COD:0'");
            pr.executeUpdate();

        } catch (Exception e) {
            System.out.println("erro al generar el codigo " + e.getMessage());
        }

        return sms_con_codigo;

    }  



    public void Llenar_text(Modelo modelo) { /// METODO SIN UTLIZAR , PLZ

        try {
            String sql_select = "SELECT PRODUCTO FROM tablas_ventas";
            PreparedStatement pr = null;
            ResultSet resultado = null;
            pr = getConnection().prepareStatement(sql_select);
            resultado = pr.executeQuery();
            while (resultado.next()) {

                modelo.getLista_productos().add(resultado.getString("PRODUCTO"));

            }

        } catch (SQLException ex) {
            System.out.println("erro al llenar la lista " + ex.getMessage());
        }

    }

    public void Traer_Precio_Cantidad_Producto(Modelo modelo) { // ESTE METODO ES LLAMADO DESDE EL CONTROLADOR _VENDER_PRODUCTO

        try {
            String sql_select = "SELECT CANTIDAD,PRECIO FROM tablas_ventas WHERE PRODUCTO =?";
            PreparedStatement pr = null;
            ResultSet resultado = null;
            pr = getConnection().prepareStatement(sql_select);
            pr.setString(1, modelo.getProducto());
            resultado = pr.executeQuery();

            while (resultado.next()) {

                modelo.setPrecio(resultado.getDouble("PRECIO"));
                modelo.setCantidad_productos(resultado.getInt("CANTIDAD"));

            }

        } catch (SQLException ex) {
            System.out.println("erro al traer  la cantidad y precio " + ex.getMessage());
        }

    }

    public boolean Modelo_Tabla_Listar_Ventas(Modelo modelo) { // select desde el controlador de VENDER PRODUCTO
        boolean retorno = false;
        try {

            PreparedStatement pr = null;
            ResultSet resultado = null;

            pr = getConnection().prepareStatement("SELECT * FROM  tabla_listar_venta ");

            resultado = pr.executeQuery();
            DefaultTableModel dt = new DefaultTableModel() {
                public boolean isCellEditable(int filas, int columnas) {

                    return false ;
                }

            };
              dt.addColumn("ID");
            dt.addColumn("Codigo");
            dt.addColumn("Producto");
            dt.addColumn("Cantidad");
            dt.addColumn("Precio");
            dt.addColumn("Subtotal");
            dt.addColumn("Cancelar");

            JTableHeader encabezado = modelo.getTabla().getTableHeader();
            encabezado.setDefaultRenderer(new Render_Encabezado("cambia_color"));
            modelo.getTabla().setTableHeader(encabezado);
            modelo.getTabla().getTableHeader().setReorderingAllowed(false);
            modelo.getTabla().setDefaultRenderer(Object.class, new Renderizar_Tablas(7, "fewfwef"));
            //table.setColumnSelectionAllowed(true);//// selecciona una columna mo maz

        //    modelo.getTabla().setColumnSelectionAllowed(true);
            modelo.getTabla().setModel(dt);

            try {/// NO ES NECEARIO ,  LO PUSE PARA ENCONTRAR UN ERROR QUE TENIA  ,PERO YA LO ENCONTRE
                rowSorter_tabla_ventas = new TableRowSorter(dt);
                modelo.getTabla().setRowSorter(rowSorter_tabla_ventas);
                modelo.setRowSorter_2(rowSorter_tabla_ventas);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Surguio un problema  en el rowsirte ,intentalo mas tarde de la tabla  " + "\nVentas DESCONOCIDO");
                // System.out.println("erro filtrar_ " + e.getMessage());

            }

          
            double total_cobrar = 0;
            int cantidad_produ_cliente = 0;
            JButton btn_eliminar = new JButton(new ImageIcon("src/Image_2/ELIMINAR.png"));

            btn_eliminar.setName("Elimnar_solo");
            while (resultado.next()) {
                Object datos[] = new Object[7];

                 datos[0] = resultado.getString("ID_LISTA");
                datos[1] = resultado.getString("CODIGO_REGISTRO");
                datos[2] = resultado.getString("PRODUCTO");
                datos[3] = resultado.getString("CANTIDAD");

                datos[4] = resultado.getDouble("PRECIO");

                datos[5] = resultado.getDouble("TOTAL");
                datos[6] = btn_eliminar;

                total_cobrar += resultado.getDouble("TOTAL");
                cantidad_produ_cliente += resultado.getInt("CANTIDAD");
              

                dt.addRow(datos);

            }

            modelo.setTotal_cobrar(total_cobrar);
            modelo.setCantidad_produ_cliente(cantidad_produ_cliente);

            retorno = true;

        } catch (Exception e) {
            System.out.println("erro al poner el modelo a la tabla ventas" + e.getMessage());
        }
        return retorno;
    }
    
    
      
    
    
    
    

    private TableRowSorter rowSorter;
    private TableRowSorter rowSorter_tabla_ventas;

}
