/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depro.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jhunior
 */
@Entity
@Table(name="Precio")
//@IdClass(PrecioCk.class)
public class Precio implements Serializable {
    private Plu plu;
    private PuntoVenta puntoVenta;
    private int precioPorKilo;


    /**
     * @return the plu
     */
    @Id
    @ManyToOne
    public Plu getPlu() {
        return plu;
    }

    /**
     * @param Plu the plu to set
     */
    public void setPlu(Plu Plu) {
        this.plu = Plu;
    }

    /**
     * @return the puntoVenta
     */
    @Id
    @ManyToOne
    public PuntoVenta getPuntoVenta() {
        return puntoVenta;
    }

    /**
     * @param PuntoVenta the puntoVenta to set
     */
    public void setPuntoVenta(PuntoVenta PuntoVenta) {
        this.puntoVenta = PuntoVenta;
    }

    /**
     * @return the precioPorKilo
     */
    public int getPrecioPorKilo() {
        return precioPorKilo;
    }

    /**
     * @param precioPorKilo the precioPorKilo to set
     */
    public void setPrecioPorKilo(int precioPorKilo) {
        this.precioPorKilo = precioPorKilo;
    }
}

class PrecioCk implements Serializable{
    private Plu plu;
    private PuntoVenta puntoVenta;

    /**
     * @return the plu
     */
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
     * @return the puntoVenta
     */
    public PuntoVenta getPuntoVenta() {
        return puntoVenta;
    }

    /**
     * @param puntoVenta the puntoVenta to set
     */
    public void setPuntoVenta(PuntoVenta puntoVenta) {
        this.puntoVenta = puntoVenta;
    }
}