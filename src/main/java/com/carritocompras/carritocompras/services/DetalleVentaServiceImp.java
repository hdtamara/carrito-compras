package com.carritocompras.carritocompras.services;

import com.carritocompras.carritocompras.entities.DetalleVenta;
import com.carritocompras.carritocompras.repositories.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DetalleVentaServiceImp implements  IDetalleVentaService{

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Override
    public DetalleVenta crearDetalle(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public List<DetalleVenta> getDetalleByVenta(long ventaId) {
        return detalleVentaRepository.findByVenta_Id(ventaId);
    }
}
