package com.carritocompras.carritocompras.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "VENTAS_TBL")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "DATE")
    private Date fecha;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;
    @Column(nullable = false)
    private Double total;

}
