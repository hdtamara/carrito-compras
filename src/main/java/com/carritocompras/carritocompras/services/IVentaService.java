package com.carritocompras.carritocompras.services;

import com.carritocompras.carritocompras.entities.Venta;
import com.carritocompras.carritocompras.exception.InsufficientStockException;
import com.carritocompras.carritocompras.exception.ShoppingCarEmptyException;
import com.carritocompras.carritocompras.exception.UserNotFoundException;

import java.util.List;

public interface IVentaService {
    Venta createVenta(String userName) throws UserNotFoundException, ShoppingCarEmptyException, InsufficientStockException;
    List<Venta> getAllVentas();
    Venta getVentaById(long id) throws ClassNotFoundException;
    List<Venta> getVentaByUsuario(String userName) throws UserNotFoundException;

}
