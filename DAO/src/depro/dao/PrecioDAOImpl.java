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
    
    public Precio cargarPrecioPorPluYTienda(int idPlu, int idPuntoVenta){
        Plu plu = new Plu();
        plu.setIdPlu(idPlu);
        PuntoVenta tienda = new PuntoVenta();
        tienda.setIdPuntoVenta(idPuntoVenta);
        return findByAttributes(Restrictions.and(Restrictions.eq("plu", plu), Restrictions.eq("puntoVenta", tienda)));
    }
    
    public List<Precio> listarTodo(){
        return findByCriteria(Restrictions.ge("precioPorKilo", 0));
    }
}
