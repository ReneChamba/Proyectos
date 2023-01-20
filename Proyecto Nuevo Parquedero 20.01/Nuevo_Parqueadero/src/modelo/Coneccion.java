package modelo;

import java.sql.Connection;
import java.sql.DriverManager;


public class Coneccion {

    private Connection cn;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String USSER = "root";
    private final String PASS = "losmaspepas23";
    private final String URL = "jdbc:mysql://localhost:3306/nuevo_parqueadero";
            
            

    public Coneccion() {
        cn = null;
    }

    public Connection getConnection() {
        try {
            Class.forName(DRIVER);

            cn = DriverManager.getConnection(URL, USSER, PASS);
            ///System.out.println("Connecion extiosa");

        } catch (Exception e) {
            System.out.println("no se pudo conectar " + e.getMessage());
        }

        return cn;
    }

    public void getDesconectar() {
        try {
            cn.close();
            //System.out.println("Base de datos desconectada");

        } catch (Exception e) {
            System.out.println("No se pudo desconectar " + e.getMessage());
        }

    }
    
   
}
