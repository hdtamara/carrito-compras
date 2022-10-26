package com.carritocompras.carritocompras.repositories;

import com.carritocompras.carritocompras.entities.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {

}
