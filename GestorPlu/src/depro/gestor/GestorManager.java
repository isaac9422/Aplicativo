/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package depro.gestor;

import depro.dao.PluDAOImpl;
import depro.dao.PuntoVentaDAOImpl;
import depro.dao.VentaDAOImpl;
import depro.dao.core.DAOManager;
import depro.modelo.PuntoVenta;
import depro.modelo.Venta;
import java.io.IOException;
import java.util.List;

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
