package controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Controlador_Propiedades {

    private Properties propiedades;
    

    public Controlador_Propiedades() {
        propiedades = new Properties();
    }

    public Properties getPropiedades() {

        //if (propiedades == null) {
        // propiedades = new Properties();
        try {

            //utlizar el metodo load, para leer el archivo que contiene
            //las propiedades , / es xq este en la misma jerarquia de paquetes, son hermanos
            propiedades.load(propiedades.getClass().getResourceAsStream("/modelo/Propiedades.properties"));

        } catch (FileNotFoundException e) {
            System.out.println("no encontro la ruta");

        } catch (IOException ex) {
            System.out.println("no hay permisos");

        } catch (Exception e) {

            System.out.println("erro  + " + e.getMessage());
        }

        // }
        return propiedades;

    }

    public String nombre_propiedad(String nombre) {

        return propiedades.getProperty(nombre);

    }

    public void getArrayPropiedades() {

        String propiedades[] = new String[7];

        try {
            for (Enumeration e = getPropiedades().keys(); e.hasMoreElements();) {
            

                Object elementos = e.nextElement();
                //System.out.println("propiedades: " + getPropiedades().getProperty(elementos.toString())); forma 1

                System.out.println("propiedades: " + nombre_propiedad(elementos.toString()));//forma 2
                
                
                

            }
        } catch (Exception e) {

            System.out.println("erro  " + e);
        }

    }

}
