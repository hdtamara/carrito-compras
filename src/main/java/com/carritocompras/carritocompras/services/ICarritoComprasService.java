package com.carritocompras.carritocompras.services;

import com.carritocompras.carritocompras.entities.CarritoCompra;
import com.carritocompras.carritocompras.exception.UserNotFoundException;

import java.util.List;

public interface ICarritoComprasService {
    CarritoCompra addProducto(CarritoCompra carritoCompra);
    List<CarritoCompra> getCarritoByUser(String userName) throws UserNotFoundException;
    void cleanCarriroCompras(String userName) throws UserNotFoundException;
    void removeProducto(long id) throws ClassNotFoundException;
}
