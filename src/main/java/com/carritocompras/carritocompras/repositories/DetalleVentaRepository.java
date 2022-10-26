package com.carritocompras.carritocompras.repositories;

import com.carritocompras.carritocompras.entities.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Long> {
    List<DetalleVenta> findByVenta_Id(long id);
}
