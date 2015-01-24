/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package depro.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author jhunior
 */
@Entity
@Table(name="Venta")
public class Venta implements Serializable {
    private int idVenta;
    private Plu plu;
    private int pesoVenta;
    private Date fecha;
    private PuntoVenta puntoVenta;
    
    /**
     * @return the idVenta
     */
    @Id
    public int getIdVenta() {
        return idVenta;
    }

    /**
     * @param idVenta the idVenta to set
     */
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    /**
     * @return the plu
     */
    @ManyToOne
    public Plu getPlu() {
        return plu;
    }

    /**
     * @param plu the plu to set
     */
    public void setPlu(Plu plu) {
        this.plu = plu;
    }

    /**
     * @return the pesoVenta
     */
    public int getPesoVenta() {
        return pesoVenta;
    }

    /**
     * @param pesoVenta the pesoVenta to set
     */
    public void setPesoVenta(int pesoVenta) {
        this.pesoVenta = pesoVenta;
    }

    /**
     * @return the fecha
     */
    @Type(type="date")
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @ManyToOne
    public PuntoVenta getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(PuntoVenta puntoVenta) {
        this.puntoVenta = puntoVenta;
    }
}
