/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import depro.dao.VentaDAOImpl;
import depro.dao.core.DAOManager;
import depro.gestor.GestorManager;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jhunior
 */
public class PruebaGestorPlu {
        
    GestorManager gestorPluManager;
    @Before
    public void iniciar() {
        DAOManager dAOManager = new DAOManager();
        //pluDAOImpl.limpiarTabla();
        this.gestorPluManager = new GestorManager();
        this.gestorPluManager.setDAOManager(dAOManager);
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void gestionarArchivo() throws IOException {
//        gestorPluManager.GestionarArchivoPlu("/home/jhunior/NetBeansProjects/Carnes/PLUTOTAL(TRANSACTIONTYPE)FILE.txt");
        gestorPluManager.GestionarArchivoPlu("D:\\Proyecto\\Carnes\\PLUTOTAL(TRANSACTIONTYPE)FILE.txt");
         
     }
}
