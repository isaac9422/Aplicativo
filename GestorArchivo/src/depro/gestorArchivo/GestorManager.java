/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package depro.gestorArchivo;

import depro.dao.DAOManager;
import java.io.IOException;

/**
 *
 * @author jhunior
 */
public class GestorManager {
    private DAOManager dAOManager;
    
    
    public void GestionarArchivoPlu(String ruta) throws IOException    {
        ProcesadorArchivo procesadorArchivo = new ProcesadorArchivo(dAOManager);
        procesadorArchivo.ProcesarArchivo(ruta);
        
    }
    /**
     * @param dAOManager the ventaDAOImpl to set
     */
    public void setDAOManager(DAOManager dAOManager) {
        this.dAOManager = dAOManager;
    }
}
