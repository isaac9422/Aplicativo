/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depro.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Jhunior
 */
@Entity
@Table(name="Plu")
public class Plu implements Serializable {
    private int idPlu;
    private String codigoBarras;
    private String nombreTextual;
    private String nombreHex;
    private List<Venta> ventas;
    private List<Precio> preciosTienda;

    /**
     * @return the idPlu
     */
    @Id
    public int getIdPlu() {
        return idPlu;
    }

    /**
     * @param idPlu the idPlu to set
     */
    public void setIdPlu(int idPlu) {
        this.idPlu = idPlu;
    }

    /**
     * @return the codigoBarras
     */
    public String getCodigoBarras() {
        return codigoBarras;
    }

    /**
     * @param codigoBarras the codigoBarras to set
     */
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    /**
     * @return the nombreTextual
     */
    public String getNombreTextual() {
        return nombreTextual;
    }

    /**
     * @param nombreTextual the nombreTextual to set
     */
    public void setNombreTextual(String nombreTextual) {
        this.nombreTextual = nombreTextual;
    }

    /**
     * @return the nombreHex
     */
    public String getNombreHex() {
        return nombreHex;
    }

    /**
     * @param nombreHex the nombreHex to set
     */
    public void setNombreHex(String nombreHex) {
        this.nombreHex = nombreHex;
    }

    /**
     * @return the ventas
     */
    @OneToMany(mappedBy = "plu")
    @Cascade({CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Venta> getVentas() {
        return ventas;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    /**
     * @return the preciosTienda
     */
    @OneToMany(mappedBy = "plu")
    @Cascade({CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Precio> getPreciosTienda() {
        return preciosTienda;
    }

    /**
     * @param preciosTienda the preciosTienda to set
     */
    public void setPreciosTienda(List<Precio> preciosTienda) {
        this.preciosTienda = preciosTienda;
    }
    
}
