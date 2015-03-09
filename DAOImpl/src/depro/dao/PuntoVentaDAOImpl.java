/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package depro.dao;

import depro.modelo.PuntoVenta;
import java.util.List;

/**
 *
 * @author jhunior
 */
public class PuntoVentaDAOImpl extends HibernateDAOImpl<PuntoVenta, Integer>{
    public PuntoVentaDAOImpl() {
        super(PuntoVenta.class);
    }
    
    public void limpiarTabla(){
        getCurrentSession().createSQLQuery("TRUNCATE 'PuntoVenta'").executeUpdate();
    }
    
    public List<Integer> listaId(){
        return (List<Integer>) getCurrentSession().createQuery("select idPuntoVenta from PuntoVenta").list();
    }
}
