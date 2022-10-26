package com.carritocompras.carritocompras.repositories;

import com.carritocompras.carritocompras.entities.Venta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Long> {
    List<Venta> findByUsuario_UserName(String userName);
}
