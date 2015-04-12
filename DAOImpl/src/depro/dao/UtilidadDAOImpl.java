/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depro.dao;

import depro.modelo.Utilidad;

/**
 *
 * @author Jhunior
 */
public class UtilidadDAOImpl extends HibernateDAOImpl<Utilidad, Integer> {

    public UtilidadDAOImpl() {
        super(Utilidad.class);
    }
    
    public String rutaPorTienda(int idPuntoVenta){
        String query = "SELECT rutaPorDefecto FROM Util WHERE idPuntoVenta = '"+idPuntoVenta+"'";
        String ruta = (String) getCurrentSession().createSQLQuery(query).uniqueResult();
        return ruta;
    }
    
}
