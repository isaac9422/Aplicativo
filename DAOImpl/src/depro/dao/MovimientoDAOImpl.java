/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depro.dao;

import depro.modelo.Movimiento;

/**
 *
 * @author Jhunior
 */
public class MovimientoDAOImpl extends HibernateDAOImpl<Movimiento, Integer>{

    public MovimientoDAOImpl() {
        super(Movimiento.class);
    }
    
    public long cantidadVendidaPorNumeroPlu(int numeroPlu) {
        return (long) getCurrentSession().createQuery("select sum(pesoVenta) from Movimiento where plu = '" + numeroPlu + "'").uniqueResult();
//        return bd.longValue();
    }

    public long cantidadVendidaPorNumeroEscala(int numeroEscala) {
        return (long) getCurrentSession().createQuery("select sum(peso) from Movimiento where escala = '" + numeroEscala + "'").uniqueResult();
//        return bd.longValue();
    }

    public long cantidadVendidaPorRangoFecha(String rangoA, String rangoB) {
        return (long) getCurrentSession().createQuery("select sum(peso) from Movimiento where fecha >= '" + rangoA
                + "' and fecha<= '" + rangoB + "'").uniqueResult();
//        return bd.longValue();
    }

    public long plataObtenidaPorNumeroEscalaYFecha(int numeroEscala, String rangoA, String rangoB) {
        return (long) getCurrentSession().createQuery("select sum(precioVenta) from Movimiento where escala = '" +
                numeroEscala + "and fecha >= '" + rangoA + "' and fecha<= '" + rangoB + "'").uniqueResult();
//        return bd.longValue();
    }

    public long plataObtenidaPorNumeroEscala(int numeroEscala) {
        return (long) getCurrentSession().createQuery("select sum(precioVenta) from Movimiento where escala = '" +
                numeroEscala+ "'").uniqueResult();
//        return bd.longValue();
    }
    
}
