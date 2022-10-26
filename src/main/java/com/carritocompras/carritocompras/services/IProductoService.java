package com.carritocompras.carritocompras.services;

import com.carritocompras.carritocompras.dtos.ProductoDto;
import com.carritocompras.carritocompras.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    Producto crearProducto(Producto producto);
    List<Producto> findAll();
    Producto findProductoById(long id) throws ClassNotFoundException;
    Producto updateProducto(long id, ProductoDto producto) throws ClassNotFoundException;
    void  deleteProducto(long id) throws ClassNotFoundException;
}
