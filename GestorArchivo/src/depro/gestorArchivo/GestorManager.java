/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depro.gestorArchivo;

import depro.dao.DAOManager;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.NonUniqueObjectException;

/**
 *
 * @author jhunior
 */
public class GestorManager {

    private DAOManager dAOManager;
    public static int tienda;

    public void GestionarArchivoPlu(String ruta) throws IOException, Exception, NumberFormatException, NonUniqueObjectException {
            ProcesadorArchivo procesadorArchivo = new ProcesadorArchivo(dAOManager);
            procesadorArchivo.ProcesarArchivo(ruta);
            copiarArchivoCarga(ruta);
    }

    /**
     * @param dAOManager the ventaDAOImpl to set
     */
    public void setDAOManager(DAOManager dAOManager) {
        this.dAOManager = dAOManager;
    }

    private void copiarArchivoCarga(String ruta) {
        File source = new File(ruta);
        String y = "..\\archivosCargados\\Movimiento";
        Calendar c = Calendar.getInstance();
        y += c.getTime().toString();
        y += ".txt";
        y = y.replaceAll("\\:", "-");
        File dest = new File(y);
        CopyOption[] options = new CopyOption[]{
            StandardCopyOption.REPLACE_EXISTING,
            StandardCopyOption.COPY_ATTRIBUTES
        };
        try {
            Files.copy(source.toPath(), dest.toPath(), options);
        } catch (IOException ex) {
            Logger.getLogger(GestorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
