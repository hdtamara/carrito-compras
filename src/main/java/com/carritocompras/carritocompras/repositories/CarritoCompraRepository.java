package com.carritocompras.carritocompras.repositories;

import com.carritocompras.carritocompras.entities.CarritoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarritoCompraRepository  extends JpaRepository<CarritoCompra,Long> {
    List<CarritoCompra> findByUsuario_UserName(String userName);
    void deleteByUsuario_UserName(String userName);
}
