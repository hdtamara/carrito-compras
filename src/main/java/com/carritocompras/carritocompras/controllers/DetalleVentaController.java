package com.carritocompras.carritocompras.controllers;

import com.carritocompras.carritocompras.entities.DetalleVenta;
import com.carritocompras.carritocompras.services.IDetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detalle")
public class DetalleVentaController {
    @Autowired
    private IDetalleVentaService detalleVentaService;

    @GetMapping("/{idVenta}")
    public ResponseEntity<List<DetalleVenta>> getDetalleByVenta(@PathVariable long idVenta){
        return  ResponseEntity.ok(detalleVentaService.getDetalleByVenta(idVenta));

    }
}
