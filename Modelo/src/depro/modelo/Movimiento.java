/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depro.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jhunior
 */
@Entity
@Table(name="Movimiento")
public class Movimiento implements Serializable {
    
    private int idMovimiento;
    private int plu;
    private int precioKilo;
    private int pesoVenta;
    private int cantidad;
    private int precioVenta;
    private Date fecha;
    private int hora;
    private int escala;
    private String codigoBarra;
    private String nombre;
    private int tienda;

    /**
     * @return the idMovimiento
     */
    @Id
    public int getIdMovimiento() {
        return idMovimiento;
    }

    /**
     * @param idMovimiento the idMovimiento to set
     */
    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    /**
     * @return the plu
     */
    public int getPlu() {
        return plu;
    }

    /**
     * @param plu the plu to set
     */
    public void setPlu(int plu) {
        this.plu = plu;
    }

    /**
     * @return the precioKilo
     */
    public int getPrecioKilo() {
        return precioKilo;
    }

    /**
     * @param precioKilo the precioKilo to set
     */
    public void setPrecioKilo(int precioKilo) {
        this.precioKilo = precioKilo;
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
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precioVenta
     */
    public int getPrecioVenta() {
        return precioVenta;
    }

    /**
     * @param precioVenta the precioVenta to set
     */
    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * @return the escala
     */
    public int getEscala() {
        return escala;
    }

    /**
     * @param escala the escala to set
     */
    public void setEscala(int escala) {
        this.escala = escala;
    }

    /**
     * @return the codigoBarra
     */
    public String getCodigoBarra() {
        return codigoBarra;
    }

    /**
     * @param codigoBarra the codigoBarra to set
     */
    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
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
     * @return the tienda
     */
    public int getTienda() {
        return tienda;
    }

    /**
     * @param tienda the tienda to set
     */
    public void setTienda(int tienda) {
        this.tienda = tienda;
    }
    
    
    
}
