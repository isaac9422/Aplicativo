/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depro.dao;

/**
 *
 * @author Jhunior
 */
public class DAOManager {
    private PrecioDAOImpl precioDAOImpl;
    private PluDAOImpl pluDAOImpl;
    private PuntoVentaDAOImpl puntoVentaDAOImpl;
    private VentaDAOImpl ventaDAOImpl;
    private UsuarioDAOImpl usuarioDAOImpl;
    private MovimientoDAOImpl movimientoDAOImpl;
    
    public DAOManager(){
        this.pluDAOImpl = new PluDAOImpl();
        this.puntoVentaDAOImpl = new PuntoVentaDAOImpl();
        this.usuarioDAOImpl = new UsuarioDAOImpl();
        this.ventaDAOImpl = new VentaDAOImpl();
        this.precioDAOImpl = new PrecioDAOImpl();
        this.movimientoDAOImpl = new MovimientoDAOImpl();
    }

    /**
     * @return the pluDAOImpl
     */
    public PluDAOImpl getPluDAOImpl() {
        return pluDAOImpl;
    }

    /**
     * @return the puntoVentaDAOImpl
     */
    public PuntoVentaDAOImpl getPuntoVentaDAOImpl() {
        return puntoVentaDAOImpl;
    }

    /**
     * @return the ventaDAOImpl
     */
    public VentaDAOImpl getVentaDAOImpl() {
        return ventaDAOImpl;
    }

    /**
     * @return the usuarioDAOImpl
     */
    public UsuarioDAOImpl getUsuarioDAOImpl() {
        return usuarioDAOImpl;
    }

    /**
     * @return the precioDAOImpl
     */
    public PrecioDAOImpl getPrecioDAOImpl() {
        return precioDAOImpl;
    }    

    /**
     * @return the movimientoDAOImpl
     */
    public MovimientoDAOImpl getMovimientoDAOImpl() {
        return movimientoDAOImpl;
    }
}
