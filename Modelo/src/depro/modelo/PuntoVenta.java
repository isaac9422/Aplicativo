/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package depro.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author jhunior
 */
@Entity
@Table(name="PuntoVenta")
public class PuntoVenta implements Serializable {
    private int idPuntoVenta;
    private String direccion;
    private List<Venta> ventasPlu;
    private String nombre;
    private List<Usuario> usuarios;
    private String ciudad;
    private List<Precio> preciosTienda;
    private String telefono;
    private String celular;
    private String directorioDefecto;

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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the ventasPlu
     */
    
    @OneToMany(mappedBy = "puntoVenta")
    @Cascade({CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Venta> getVentasPlu() {
        return ventasPlu;
    }

    /**
     * @param ventasPlu the ventasPlu to set
     */
    public void setVentasPlu(List<Venta> ventasPlu) {
        this.ventasPlu = ventasPlu;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the usuarios
     */
    @OneToMany(mappedBy = "puntoVenta")
    @Cascade({CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the preciosTienda
     */
    @OneToMany(mappedBy = "puntoVenta")
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

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the directorioDefecto
     */
    public String getDirectorioDefecto() {
        return directorioDefecto;
    }

    /**
     * @param directorioDefecto the directorioDefecto to set
     */
    public void setDirectorioDefecto(String directorioDefecto) {
        this.directorioDefecto = directorioDefecto;
    }
    
}
