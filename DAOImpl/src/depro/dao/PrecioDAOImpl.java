/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depro.dao;

import depro.modelo.Plu;
import depro.modelo.Precio;
import depro.modelo.PuntoVenta;
import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Jhunior
 */
public class PrecioDAOImpl extends HibernateDAOImpl<Precio, Integer> {

    public PrecioDAOImpl() {
        super(Precio.class);
    }

    public Precio cargarPrecioPorPluYTienda(int idPlu, int idPuntoVenta) {
        Plu plu = new Plu();
        plu.setIdPlu(idPlu);
        PuntoVenta tienda = new PuntoVenta();
        tienda.setIdPuntoVenta(idPuntoVenta);
        return findByAttributes(Restrictions.and(Restrictions.eq("plu", plu), Restrictions.eq("puntoVenta", tienda)));
    }

    public long cargarPrecioPorPlu(int idPlu) {
        Double d = (Double) getCurrentSession().createQuery("select avg(precioPorKilo) from Precio where plu_idPlu = '"+idPlu+"'").uniqueResult();
        return d.longValue();
    }

    public List<Precio> listarTodo(int tienda) {
        if (tienda < 1) {
            return findByCriteria(Restrictions.ge("precioPorKilo", 0));
        } else {
            return findByCriteria(Restrictions.and(Restrictions.ge("precioPorKilo", 0), Restrictions.ge("puntoVenta", tienda)));
        }
    }
}
