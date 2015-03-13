select fecha, escala, NombreTienda, plu, nombrePlu, sum(pesoVenta) as Kilos, sum(cantidad) as Transacciones, precioKilo, sum(precioVenta) as NetoVentas from (select fecha, cantidad, escala, plu, pesoVenta, precioVenta, Movimiento.nombre as nombrePlu, PuntoVenta.nombre as NombreTienda, precioKilo from movimiento inner join PuntoVenta on escala = idPuntoVenta) as joins group by fecha, plu, nombreTienda, escala, nombrePlu, precioKilo order by fecha, plu, escala