/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depro.dao;

import depro.modelo.Venta;
import java.math.BigDecimal;
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
        getCurrentSession().createSQLQuery("TRUNCATE `venta`").executeUpdate();
    }

    public List<Venta> listarVentasPorRangoFechas(String rangoA, String rangoB) {
        return getCurrentSession().createSQLQuery("select * from venta where fecha <= '" + rangoA
                + "' and fecha >= '" + rangoB + "'").list();
    }

    public long cantidadVendidaPorNumeroPlu(int numeroPlu) {
        BigDecimal bd = (BigDecimal) getCurrentSession().createSQLQuery("select sum(pesoVenta) from venta where plu_idPlu = '" + numeroPlu + "'").uniqueResult();
        return bd.longValue();
    }

    public long cantidadVendidaPorNumeroEscala(int numeroEscala) {
        BigDecimal bd = (BigDecimal) getCurrentSession().createSQLQuery("select sum(peso) from venta where numeroEscala = '" + numeroEscala + "'").uniqueResult();
        return bd.longValue();
    }

    public long cantidadVendidaPorRangoFecha(String rangoA, String rangoB) {
        BigDecimal bd = (BigDecimal) getCurrentSession().createSQLQuery("select sum(peso) from venta where fecha >= '" + rangoA
                + "' and fecha<= '" + rangoB + "'").uniqueResult();
        return bd.longValue();
    }

    public long plataObtenidaPorRangoFecha(String rangoA, String rangoB) {
        BigDecimal bd = (BigDecimal) getCurrentSession().createSQLQuery("select sum(precioVenta) from venta where fecha >= '" + rangoA
                + "' and fecha<= '" + rangoB + "'").uniqueResult();
        return bd.longValue();
    }

}
