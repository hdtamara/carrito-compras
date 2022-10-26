package com.carritocompras.carritocompras.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "DETALLE_VENTA_TBL")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;
    @Column(nullable = false)
    private  int cantidad;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Venta venta;
    @Column(nullable = false)
    private  Double total;

}
