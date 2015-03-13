/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depro.gestorArchivo;

import depro.dao.DAOManager;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Jhunior
 */
public class GestorManagerTest {

    GestorManager instance;
    DAOManager dAOManager;
    
    @Before
    public void setUp() {
        dAOManager = new DAOManager();
        instance = new GestorManager();
        instance.setDAOManager(dAOManager);

    }
    
    /**
     * Test of GestionarArchivoPlu method, of class GestorManager.
     */
    @Test
    public void testGestionarArchivoPlu() throws Exception {
        System.out.println("GestionarArchivoPlu");
        String ruta = "D:\\Proyecto\\Carnes\\3(TRANSACTIONTYPE)FILE.txt";
        System.out.println("BD: #99");
        System.out.println(dAOManager.getPuntoVentaDAOImpl().listaId());
        System.out.println("BD: #89");
        System.out.println(dAOManager.getPuntoVentaDAOImpl().listaId());
        GestorManager.tienda = 52;
        instance.GestionarArchivoPlu(ruta);
//         TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setDAOManager method, of class GestorManager.
     */
    @Test
    public void testSetDAOManager() {
        System.out.println("setDAOManager");
        DAOManager dAOManager = null;
        GestorManager instance = new GestorManager();
        instance.setDAOManager(dAOManager);
//         TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
