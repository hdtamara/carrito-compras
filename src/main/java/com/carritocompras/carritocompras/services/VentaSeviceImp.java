package com.carritocompras.carritocompras.services;

import com.carritocompras.carritocompras.entities.*;
import com.carritocompras.carritocompras.exception.InsufficientStockException;
import com.carritocompras.carritocompras.exception.ShoppingCarEmptyException;
import com.carritocompras.carritocompras.exception.UserNotFoundException;
import com.carritocompras.carritocompras.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class VentaSeviceImp implements IVentaService{
    private  final VentaRepository ventaRepository;
    private  final ICarritoComprasService carritoComprasService;
    private  final DetalleVentaRepository detalleVentaRepository;
    private  final IUsuarioService usuarioService;
    private  final ProductoRepository productoRepository;


    @Override
    public Venta createVenta(String userName) throws UserNotFoundException, ShoppingCarEmptyException, InsufficientStockException {
        Usuario usuario = usuarioService.findByUserName(userName).get();
        List<CarritoCompra> carritoCompraList = carritoComprasService.getCarritoByUser(usuario.getUserName());
        if(carritoCompraList.isEmpty())
            throw new ShoppingCarEmptyException("No hay productos en el carrito para el usuario: "+userName);
        List<DetalleVenta> detalleVentaList = new ArrayList<>();
        List<Producto> productoList = new ArrayList<>();
        Double total = 0.0;
        for(CarritoCompra carritoCompra: carritoCompraList){
            Producto producto = carritoCompra.getProducto();
            if (producto.getStock()-carritoCompra.getCantidad()<0){
                throw  new InsufficientStockException("Stock insuficiente del produco: "+producto.getNombre());
            }
            producto.setStock(producto.getStock()-carritoCompra.getCantidad());
            productoList.add(producto);
            DetalleVenta detalleVenta = DetalleVenta.builder()
                    .producto(carritoCompra.getProducto())
                    .cantidad(carritoCompra.getCantidad())
                    .total(carritoCompra.getProducto().getValor()*carritoCompra.getCantidad())
                    .build();
            detalleVentaList.add(detalleVenta);
            total += detalleVenta.getTotal();
        }
        Venta venta = Venta.builder()
                .fecha(new Date())
                .usuario(usuario)
                .total(total)
                .build();
        Venta ventaSave = ventaRepository.save(venta);

        for (DetalleVenta detalleVenta : detalleVentaList){
            detalleVenta.setVenta(ventaSave);
        }
        detalleVentaRepository.saveAll(detalleVentaList);
        productoRepository.saveAll(productoList);
        carritoComprasService.cleanCarriroCompras(userName);
        return  venta;

    }

    @Override
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta getVentaById(long id) throws ClassNotFoundException {
        Optional<Venta> venta = ventaRepository.findById(id);
        if(venta.isEmpty())
            throw  new ClassNotFoundException("Venta no encontrado con id: "+id);
        return venta.get();
    }

    @Override
    public List<Venta> getVentaByUsuario(String userName) throws UserNotFoundException {
        Optional<Usuario> usuario = usuarioService.findByUserName(userName);
        return ventaRepository.findByUsuario_UserName(usuario.get().getUserName());
    }
}
