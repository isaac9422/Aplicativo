/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depro.gestor;

import depro.dao.PluDAOImpl;
import depro.dao.PrecioDAOImpl;
import depro.dao.PuntoVentaDAOImpl;
import depro.dao.VentaDAOImpl;
import depro.dao.core.DAOManager;
import depro.modelo.Plu;
import depro.modelo.Precio;
import depro.modelo.PuntoVenta;
import depro.modelo.Venta;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author jhunior
 */
public class ProcesadorArchivo {

    private DAOManager dAOManager;
    private List<Venta> ventas;
    private List<PuntoVenta> puntoVentas;
    private List<Plu> plus;
    private List<Precio> precios;

    public ProcesadorArchivo(DAOManager dAOManager) {
        this.dAOManager = dAOManager;
        this.ventas = new ArrayList<>();
        this.plus = new ArrayList<>();
        this.precios = new ArrayList<>();
        this.puntoVentas = new ArrayList<>();
    }

    public void ProcesarArchivo(String ruta) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String linea;
        VentaDAOImpl ventaDAOImpl = dAOManager.getVentaDAOImpl();
        PluDAOImpl pluDAOImpl = dAOManager.getPluDAOImpl();
        PuntoVentaDAOImpl puntoVentaDAOImpl = dAOManager.getPuntoVentaDAOImpl();
        PrecioDAOImpl precioDAOImpl = dAOManager.getPrecioDAOImpl();
        br.readLine();
        while ((linea = br.readLine()) != null) {
            StringTokenizer token = new StringTokenizer(linea);
            Venta venta = new Venta();
            Plu plu = new Plu();
            PuntoVenta puntoVenta = new PuntoVenta();
            Precio precio = new Precio();
            int dia = 1;
            int mes = 1;
            int anio = 2000;
            int hora;
            int minuto;
            int numeroColumna = 0;
            boolean crearPlu = false;
            boolean crearPuntoVenta = false;
            while (token.hasMoreTokens()) {
                numeroColumna++;
                String campo = token.nextToken();
                switch (numeroColumna) {
                    case 1:
                        venta.setIdVenta(Integer.parseInt(campo));
                        break;
                    case 3:
                        int idPlu = Integer.parseInt(campo);
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
                        break;
                    case 5:
                        campo = campo.replaceAll("\\.", "");
                        venta.setPesoVenta(Integer.parseInt(campo));
                        break;
                    case 8:
                        dia = Integer.parseInt(campo.substring(0, 2));
                        mes = Integer.parseInt(campo.substring(2, 4));
                        anio = Integer.parseInt(campo.substring(4, 6));
                        anio += 2000;
                        break;
                    case 9:
                        hora = Integer.parseInt(campo.substring(0, 2));
                        minuto = Integer.parseInt(campo.substring(2, 4));
                        Date d = new Date(anio - 1900, mes - 1, dia, hora - 1, minuto);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd hh:mm");
                        sdf.format(d);
                        venta.setFecha(d);
                        break;
                    case 12:
                        int idPuntoVenta = Integer.parseInt(campo);
                        PuntoVenta pv = puntoVentaDAOImpl.cargar(idPuntoVenta);
                        if (pv != null) {
                            precio.setPuntoVenta(pv);
                            venta.setPuntoVenta(pv);
                        } else {
                            puntoVenta.setIdPuntoVenta(idPuntoVenta);
                            crearPuntoVenta = true;
                        }
                        break;
                    case 15:
                        plu.setCodigoBarras(campo);
                        break;
                    case 16:
                        plu.setNombreHex(campo);
                        String hexValue = campo;
                        StringBuilder output = new StringBuilder("");
                        for (int i = 4; i < hexValue.length(); i += 2) {
                            String str = hexValue.substring(i, i + 2);
                            output.append((char) Integer.parseInt(str, 16));
                        }
                        plu.setNombreTextual(output.toString());
                        break;
                    default:
                        venta.setPuntoVenta(null);
                        break;
                }
            }
            if (crearPuntoVenta) {
                puntoVentas.add(puntoVenta);
                venta.setPuntoVenta(puntoVenta);
                precio.setPuntoVenta(puntoVenta);
            }
            if (crearPlu) {
                plus.add(plu);
                venta.setPlu(plu);
                precio.setPlu(plu);
            }
            ventas.add(venta);
            precios.add(precio);
        }
        puntoVentaDAOImpl.iniciarTransaccion();
        for (PuntoVenta pv : puntoVentas) {
            PuntoVenta p = puntoVentaDAOImpl.cargar(pv.getIdPuntoVenta());
            if (p == null) {
                puntoVentaDAOImpl.guardar(pv);
            } else {
                continue;
            }
        }
        puntoVentaDAOImpl.commit();
        puntoVentaDAOImpl.cerrarSession();

        pluDAOImpl.iniciarTransaccion();
        for (Plu p : plus) {
            Plu pl = pluDAOImpl.cargar(p.getIdPlu());
            if (pl == null) {
                pluDAOImpl.guardar(p);
            } else {
                continue;
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
                continue;
            }
        }
        ventaDAOImpl.commit();
        ventaDAOImpl.cerrarSession();

        precioDAOImpl.iniciarTransaccion();
        for (Precio pr : precios) {
            Precio po = precioDAOImpl.cargarPrecioPorPluYTienda(pr.getPlu().getIdPlu(), pr.getPuntoVenta().getIdPuntoVenta());
            if (po == null) {
                precioDAOImpl.guardar(pr);
            } else {
                continue;
            }
        }
        precioDAOImpl.commit();
        precioDAOImpl.cerrarSession();
    }
}
