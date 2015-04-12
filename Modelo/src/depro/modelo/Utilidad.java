/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depro.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jhunior
 */
@Entity
@Table(name="Util")
public class Utilidad implements Serializable {
    
    private int idPuntoVenta;
    private String rutaPorDefecto;

    /**
     * @return the idPuntoVenta
     */
    @Id
    public int getIdPuntoVenta() {
        return idPuntoVenta;
    }

    /**
     * @param idPuntoVenta the idPuntoVenta to set
     */
    public void setIdPuntoVenta(int idPuntoVenta) {
        this.idPuntoVenta = idPuntoVenta;
    }

    /**
     * @return the rutaPorDefecto
     */
    public String getRutaPorDefecto() {
        return rutaPorDefecto;
    }

    /**
     * @param rutaPorDefecto the rutaPorDefecto to set
     */
    public void setRutaPorDefecto(String rutaPorDefecto) {
        this.rutaPorDefecto = rutaPorDefecto;
    }
    
}
