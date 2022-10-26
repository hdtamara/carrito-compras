package com.carritocompras.carritocompras.services;

import com.carritocompras.carritocompras.entities.DetalleVenta;

import java.util.List;

public interface IDetalleVentaService {

    DetalleVenta crearDetalle(DetalleVenta detalleVenta);

    List<DetalleVenta> getDetalleByVenta(long ventaId);
}