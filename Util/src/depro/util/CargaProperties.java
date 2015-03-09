/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depro.util;

/**
 * Clase encargada de cargar las propiedades del proyecto a través de
 * ISAMantenimiento.properties
 *
 * @author Jhunior
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargaProperties {

    private final static String ESCALA_PUNTO_VENTA = "escala";
    private static int escala = 99;
    private static final String RUTA_PROPERTIES = "config/depro.properties";

    /**
     * Obtiene la propiedad del archivo de properties
     * ISAMantenimiento.properties
     *
     * @param nombrePropiedad
     * @return
     */
    private Properties getProperties() throws Exception {
        Properties propiedades = new Properties();
        File archivoProperties = new File(RUTA_PROPERTIES);

        //Si el archivo de properties no existe, crearlo
        if (!archivoProperties.exists()) {
            archivoProperties.createNewFile();
        }

        //Se carga el archivo de propiedades
        propiedades.load(new FileReader(archivoProperties));

        //Si el archivo de propiedades está vacio se crea la propiedad vacia
        if (propiedades.isEmpty() || !(propiedades.containsKey(ESCALA_PUNTO_VENTA))) {
            propiedades.setProperty(ESCALA_PUNTO_VENTA, "99");
        }

        return propiedades;
    }

    /**
     * *
     * Obtener la duración mínima para los intervalos libres para generar una
     * posible programación
     *
     * @return
     */
    public int obtenerBaseDeDatos() {
        try {
            Properties properties = this.getProperties();
            if (properties.getProperty(ESCALA_PUNTO_VENTA, "99") != null) {
                escala = Integer.parseInt(properties.getProperty(ESCALA_PUNTO_VENTA, "99"));
                setEscala(escala);
            }
            return escala;
        } catch (Exception ex) {
            Logger.getLogger(CargaProperties.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    /**
     * *
     * Método para modificar la duración mínima de los intervalos libres de
     * programación
     *
     * @param escala
     * @throws java.io.FileNotFoundException
     */
    public void setEscala(int escala) throws Exception {
        FileInputStream in = new FileInputStream(RUTA_PROPERTIES);
        Properties properties = this.getProperties();
        properties.load(in);
        in.close();

        FileOutputStream out = new FileOutputStream(RUTA_PROPERTIES);
        if ((properties.containsKey(ESCALA_PUNTO_VENTA))) {
            properties.setProperty(ESCALA_PUNTO_VENTA, String.valueOf(escala));

        } else {
            properties.setProperty(ESCALA_PUNTO_VENTA, "99");
        }
        properties.store(out, "Base de datos");
        out.close();
        CargaProperties.escala = escala;
    }

}
