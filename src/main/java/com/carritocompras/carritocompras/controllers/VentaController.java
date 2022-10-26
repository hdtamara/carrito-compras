package com.carritocompras.carritocompras.controllers;

import com.carritocompras.carritocompras.entities.Venta;
import com.carritocompras.carritocompras.exception.InsufficientStockException;
import com.carritocompras.carritocompras.exception.ShoppingCarEmptyException;
import com.carritocompras.carritocompras.exception.UserNotFoundException;
import com.carritocompras.carritocompras.services.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    private IVentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> getAllVentas(){
        return ResponseEntity.ok(ventaService.getAllVentas());
    }
    @GetMapping("/{idVenta}")
    public ResponseEntity<Venta> getVentaById(@PathVariable long id) throws ClassNotFoundException {
        return ResponseEntity.ok(ventaService.getVentaById(id));
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<List<Venta>> getVentaByUsuario(@PathVariable String userName) throws UserNotFoundException {
        return ResponseEntity.ok(ventaService.getVentaByUsuario(userName));
    }

    @PostMapping("/{userName}")
    public ResponseEntity<Venta> createVenta(@PathVariable String userName) throws UserNotFoundException, ShoppingCarEmptyException, InsufficientStockException {
        return new ResponseEntity<>(ventaService.createVenta(userName), HttpStatus.CREATED);
    }
}
