package com.carritocompras.carritocompras.controllers;

import com.carritocompras.carritocompras.dtos.CarritoCompraDto;
import com.carritocompras.carritocompras.entities.CarritoCompra;
import com.carritocompras.carritocompras.exception.UserNotFoundException;
import com.carritocompras.carritocompras.services.ICarritoComprasService;
import com.carritocompras.carritocompras.services.IProductoService;
import com.carritocompras.carritocompras.services.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carrito")
public class CarritoCompraController {
    private  final ICarritoComprasService carritoComprasService;
    private  final IProductoService productoService;
    private  final IUsuarioService usuarioService;

    @GetMapping("/{userName}")
    public ResponseEntity<List<CarritoCompra>> getCarritoByUserName(@PathVariable String userName) throws UserNotFoundException {
        return ResponseEntity.ok(carritoComprasService.getCarritoByUser(userName));
    }

    @PostMapping
    public ResponseEntity<CarritoCompra> addProducto(@Valid @RequestBody CarritoCompraDto carritoCompraDto) throws ClassNotFoundException, UserNotFoundException {
        CarritoCompra carritoCompra = CarritoCompra.builder()
                .producto(productoService.findProductoById(carritoCompraDto.getProductoId()))
                .usuario(usuarioService.findUserById(carritoCompraDto.getUsuarioId()))
                .cantidad(carritoCompraDto.getCantidad())
                .build();
        return new ResponseEntity<>(carritoComprasService.addProducto(carritoCompra), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeProducto(@PathVariable Long id) throws ClassNotFoundException {
        carritoComprasService.removeProducto(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/clean/{userName}")
    public ResponseEntity<Void> cleanCarrito(@PathVariable String userName) throws UserNotFoundException {
        carritoComprasService.cleanCarriroCompras(userName);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
