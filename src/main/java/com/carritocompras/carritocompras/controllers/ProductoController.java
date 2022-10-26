package com.carritocompras.carritocompras.controllers;

import com.carritocompras.carritocompras.dtos.ProductoDto;
import com.carritocompras.carritocompras.entities.Producto;
import com.carritocompras.carritocompras.services.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {
    private final IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProducts(){
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable long id) throws ClassNotFoundException {
        return ResponseEntity.ok(productoService.findProductoById(id));
    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@Valid @RequestBody ProductoDto productoDto){
        Producto newProducto = Producto.builder()
                .nombre(productoDto.getNombre())
                .descripcion(productoDto.getDescripcion())
                .valor(productoDto.getValor())
                .stock(productoDto.getStock())
                .image(productoDto.getImage())
                .build();
        return new ResponseEntity<>(productoService.crearProducto(newProducto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable long id,@Valid @RequestBody ProductoDto productoDto) throws ClassNotFoundException {
        return ResponseEntity.ok(productoService.updateProducto(id,productoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable long id) throws ClassNotFoundException {
        productoService.deleteProducto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
