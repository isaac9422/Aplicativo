/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depro.dao;

import depro.modelo.Venta;
import java.util.List;

/**
 *
 * @author jhunior
 */
public class VentaDAOImpl extends HibernateDAOImpl<Venta, Integer> {

    public VentaDAOImpl() {
        super(Venta.class);
    }

    public void limpiarTabla() {
        getCurrentSession().createSQLQuery("TRUNCATE `Venta`").executeUpdate();
    }

    public List<Venta> listarVentasPorRangoFechas(String rangoA, String rangoB) {
        return getCurrentSession().createSQLQuery("select * from Venta where fecha >= '" + rangoA
                + "' and fecha <= '" + rangoB + "'").list();
    }

    public long cantidadVendidaPorNumeroPlu(int numeroPlu) {
        return (long) getCurrentSession().createQuery("select sum(pesoVenta) from Venta where plu_idPlu = '" + numeroPlu + "'").uniqueResult();
//        return bd.longValue();
    }

    public long cantidadVendidaPorNumeroPluYFecha(int numeroPlu, String rangoA, String rangoB) {
        return (long) getCurrentSession().createQuery("select sum(pesoVenta) from Venta where plu_idPlu = '" + numeroPlu + 
                "' and fecha >= '" + rangoA + "' and fecha <= '" + rangoB + "'").uniqueResult();
//        return bd.longValue();
    }

    public long cantidadVendidaPorNumeroEscala(int numeroEscala) {
        return (long) getCurrentSession().createQuery("select sum(peso) from Venta where puntoVenta_idPuntoVenta = '" + numeroEscala + "'").uniqueResult();
//        return bd.longValue();
    }

    public long cantidadVendidaPorNumeroEscalaYFecha(int numeroEscala, String rangoA, String rangoB) {
        return (long) getCurrentSession().createQuery("select sum(peso) from Venta where puntoVenta_idPuntoVenta = '" + numeroEscala + 
                "' AND fecha >= '" + rangoA + "' and fecha <= '" + rangoB + "'").uniqueResult();
//        return bd.longValue();
    }

    public long cantidadVendidaPorRangoFecha(String rangoA, String rangoB) {
        return (long) getCurrentSession().createQuery("select sum(peso) from Venta where fecha >= '" + rangoA
                + "' and fecha<= '" + rangoB + "'").uniqueResult();
//        return bd.longValue();
    }

    public long plataObtenidaPorRangoFecha(String rangoA, String rangoB) {
        return (long) getCurrentSession().createQuery("select sum(precioVenta) from Venta where fecha >= '" + rangoA
                + "' and fecha<= '" + rangoB + "'").uniqueResult();
//        return bd.longValue();
    }

}
