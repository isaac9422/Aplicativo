/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depro.dao;

import depro.modelo.Plu;

/**
 *
 * @author Jhunior
 */
public class PluDAOImpl extends HibernateDAOImpl<Plu, Integer> {

    public PluDAOImpl() {
        super(Plu.class);
    }
    
    public void limpiarTabla(){
        getCurrentSession().createSQLQuery("TRUNCATE 'plu'");
    }
    
    
}
