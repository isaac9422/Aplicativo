/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depro.gestorArchivo;

import depro.dao.PluDAOImpl;
import depro.dao.PrecioDAOImpl;
import depro.dao.PuntoVentaDAOImpl;
import depro.dao.VentaDAOImpl;
import depro.dao.DAOManager;
import depro.dao.DuplicadoDAOImpl;
import depro.dao.MovimientoDAOImpl;
import depro.modelo.Duplicado;
import depro.modelo.Movimiento;
import depro.modelo.Plu;
import depro.modelo.Precio;
import depro.modelo.PuntoVenta;
import depro.modelo.Venta;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author jhunior
 */
public class ProcesadorArchivo {

    private DAOManager dao;
    private List<Venta> ventas;
    private List<PuntoVenta> puntoVentas;
    private List<Plu> plus;
    private List<Precio> precios;
    private List<Movimiento> duplicados;

    public ProcesadorArchivo(DAOManager dAOManager) {
        this.dao = dAOManager;
        this.ventas = new ArrayList<>();
        this.plus = new ArrayList<>();
        this.precios = new ArrayList<>();
        this.puntoVentas = new ArrayList<>();
        this.duplicados = new ArrayList<>();
    }

    public long procesarArchivo(String ruta) throws IOException, Exception, NumberFormatException {
        long registros = 0;
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String linea;
        VentaDAOImpl ventaDAOImpl = dao.getVentaDAOImpl();
        PluDAOImpl pluDAOImpl = dao.getPluDAOImpl();
        PuntoVentaDAOImpl puntoVentaDAOImpl = dao.getPuntoVentaDAOImpl();
        PrecioDAOImpl precioDAOImpl = dao.getPrecioDAOImpl();
        MovimientoDAOImpl movimientoDAOImpl = dao.getMovimientoDAOImpl();
        DuplicadoDAOImpl duplicadoDAOImpl = dao.getDuplicadoDAOImpl();
        br.readLine();
        movimientoDAOImpl.iniciarTransaccion();
        while ((linea = br.readLine()) != null) {
            registros++;
            StringTokenizer token = new StringTokenizer(linea);
            Venta venta = new Venta();
            Plu plu = new Plu();
            PuntoVenta puntoVenta = new PuntoVenta();
            Precio precio = new Precio();
            Movimiento movimiento = new Movimiento();
            int dia = 1;
            int mes = 1;
            int anio = 2000;
            int hora;
            int minuto;
            int numeroColumna = 0;
            boolean crearPlu = false;
            while (token.hasMoreTokens()) {
                numeroColumna++;
                String campo = token.nextToken();
                switch (numeroColumna) {
                    case 1:
                        int idTrans = Integer.parseInt(campo);
                        movimiento.setIdMovimiento(idTrans);
                        venta.setIdVenta(idTrans);
                        break;
                    case 3:
                        int idPlu = Integer.parseInt(campo);
                        movimiento.setPlu(idPlu);
                        Plu p = pluDAOImpl.cargar(idPlu);
                        if (p != null) {
                            precio.setPlu(p);
                            venta.setPlu(p);
                        } else {
                            plu.setIdPlu(idPlu);
                            crearPlu = true;
                        }
                        break;
                    case 4:
                        campo = campo.replaceAll("\\.", "");
                        precio.setPrecioPorKilo(Integer.parseInt(campo));
                        movimiento.setPrecioKilo(Integer.parseInt(campo));
                        break;
                    case 5:
                        campo = campo.replaceAll("\\.", "");
                        venta.setPesoVenta(Integer.parseInt(campo));
                        movimiento.setPesoVenta(Integer.parseInt(campo));
                        break;
                    case 6:
                        movimiento.setCantidad(Integer.parseInt(campo));
                        break;
                    case 7:
                        campo = campo.replaceAll("\\.", "");
                        movimiento.setPrecioVenta(Integer.parseInt(campo));
                        break;
                    case 8:
                        dia = Integer.parseInt(campo.substring(0, 2));
                        mes = Integer.parseInt(campo.substring(2, 4));
                        anio = Integer.parseInt(campo.substring(4, 6));
                        anio += 2000;
                        movimiento.setFecha(new Date(anio - 1900, mes - 1, dia));
                        break;
                    case 9:
                        hora = Integer.parseInt(campo.substring(0, 2));
                        minuto = Integer.parseInt(campo.substring(2, 4));
                        Date d = new Date(anio - 1900, mes - 1, dia, hora - 1, minuto);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd hh:mm");
                        sdf.format(d);
                        venta.setFecha(d);
                        movimiento.setHora((hora * 100) + minuto);
                        break;
//                      Case para asociar la información capturada con la escala de la sesión actual  
                    case 12:
                        int idPuntoVenta = GestorManager.tienda;
                        int tienda = Integer.parseInt(campo);
                        movimiento.setEscala(tienda);
                        movimiento.setTienda(idPuntoVenta);
                        PuntoVenta pv = puntoVentaDAOImpl.cargar(idPuntoVenta);
                        if (pv != null) {
                            puntoVenta.setIdPuntoVenta(idPuntoVenta);
                            precio.setPuntoVenta(pv);
                            venta.setPuntoVenta(pv);
                        } else {
                            puntoVenta.setIdPuntoVenta(idPuntoVenta);
                            precio.setPuntoVenta(puntoVenta);
                            venta.setPuntoVenta(puntoVenta);
                            puntoVentas.add(puntoVenta);
                        }
                        break;
                    case 15:
                        plu.setCodigoBarras(campo);
                        movimiento.setCodigoBarra(campo);
                        break;
                    case 16:
                        plu.setNombreHex(campo);
                        String hexValue = campo;
                        StringBuilder output = new StringBuilder("");
                        for (int i = 4; i < hexValue.length(); i += 2) {
                            String str = hexValue.substring(i, i + 2);
                            output.append((char) Integer.parseInt(str, 16));
                        }
                        String ascii = output.toString();
                        ascii = ascii.trim();
                        plu.setNombreTextual(ascii);
                        movimiento.setNombre(ascii);
                        break;
                    default:
                        break;
                }
            }
            if (crearPlu) {
                plus.add(plu);
                venta.setPlu(plu);
                precio.setPlu(plu);
            }
            ventas.add(venta);
            precios.add(precio);

            Movimiento m = movimientoDAOImpl.cargar(movimiento.getIdMovimiento());
            if (m == null) {
                movimientoDAOImpl.guardar(movimiento);
            } else {
                if (m.getCantidad() == 0) {
                    m.setCantidad(movimiento.getCantidad());
                    movimientoDAOImpl.actualizar(m);
                } else if (m.getPesoVenta() == 0) {
                    m.setPesoVenta(movimiento.getPrecioVenta());
                    movimientoDAOImpl.actualizar(m);
                } else if (m.getFecha().getTime()!=movimiento.getFecha().getTime()) {
                    boolean flag = true;
                    int idM = movimiento.getIdMovimiento();
                    do {
                        idM += 9999;
                        flag = (movimientoDAOImpl.cargar(idM) != null);
                    } while (flag);
                    movimiento.setIdMovimiento(idM);
                    movimientoDAOImpl.guardar(movimiento);
                } else if(m.getHora()!=movimiento.getHora()){
                    boolean flag = true;
                    int idM = movimiento.getIdMovimiento();
                    do {
                        idM += 9999;
                        flag = (movimientoDAOImpl.cargar(idM) != null);
                    } while (flag);
                    movimiento.setIdMovimiento(idM);
                    movimientoDAOImpl.guardar(movimiento);
                }else{
                    duplicados.add(movimiento);
                }
            }
        }
        movimientoDAOImpl.commit();
        movimientoDAOImpl.cerrarSession();

        puntoVentaDAOImpl.iniciarTransaccion();
        for (PuntoVenta pv : puntoVentas) {
            PuntoVenta pl = puntoVentaDAOImpl.cargar(pv.getIdPuntoVenta());
            if (pl == null) {
                puntoVentaDAOImpl.guardar(pv);
            }
        }
        puntoVentaDAOImpl.commit();
        puntoVentaDAOImpl.cerrarSession();

        pluDAOImpl.iniciarTransaccion();
        for (Plu p : plus) {
            Plu pl = pluDAOImpl.cargar(p.getIdPlu());
            if (pl == null) {
                pluDAOImpl.guardar(p);
            }
        }
        pluDAOImpl.commit();
        pluDAOImpl.cerrarSession();

        ventaDAOImpl.iniciarTransaccion();
        for (Venta v : ventas) {
            Venta va = ventaDAOImpl.cargar(v.getIdVenta());
            if (va == null) {
                ventaDAOImpl.guardar(v);
            } else {
                if (!va.getFecha().equals(v.getFecha())) {
                    boolean flag = true;
                    int idV = v.getIdVenta();
                    do {
                        idV += 9999;
                        flag = (ventaDAOImpl.cargar(idV) != null);
                    } while (flag);
                    v.setIdVenta(idV);
                    ventaDAOImpl.guardar(v);
                }
            }
        }
        ventaDAOImpl.commit();
        ventaDAOImpl.cerrarSession();

        precioDAOImpl.iniciarTransaccion();
        for (Precio pr : precios) {
            Precio po = precioDAOImpl.cargarPrecioPorPluYTienda(pr.getPlu().getIdPlu(), pr.getPuntoVenta().getIdPuntoVenta());
            if (po == null) {
                precioDAOImpl.guardar(pr);
            }
        }
        precioDAOImpl.commit();
        precioDAOImpl.cerrarSession();
        
        duplicadoDAOImpl.iniciarTransaccion();
        for(Movimiento m:duplicados){
            Duplicado dup = duplicadoDAOImpl.cargar(m.getIdMovimiento());
            if(dup == null){
                duplicadoDAOImpl.guardar(new Duplicado(m));
            }
        }
        duplicadoDAOImpl.commit();
        duplicadoDAOImpl.cerrarSession();
        return registros;
    }

    public long contarDuplicados() {
        DuplicadoDAOImpl duplicadoDAOImpl = dao.getDuplicadoDAOImpl();
        return duplicadoDAOImpl.cuantos();
    }
}
