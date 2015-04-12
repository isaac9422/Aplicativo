/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depro.dao;

import depro.modelo.Duplicado;
import depro.modelo.Movimiento;

/**
 *
 * @author Jhunior
 */
public class DuplicadoDAOImpl extends HibernateDAOImpl<Duplicado, Integer>{

    public DuplicadoDAOImpl() {
        super(Duplicado.class);
    }
    
    public long cuantos() {
        return (long) getCurrentSession().createQuery("select count(*) from Duplicado").uniqueResult();
//        return bd.longValue();
    }
}
