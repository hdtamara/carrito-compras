package com.carritocompras.carritocompras.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDto {
    @NotBlank(message = "El nombre del producto no puede estar vacio")
    private String nombre;
    private String descripcion;
    @NotNull(message = "El valor del producto no puede estar vacio")
    @Min(value = 0,message = "El valor producto no puede ser menor a 0")
    private  Double valor;
    @NotNull(message = "El stock del producto no puede estar vacio")
    @Min(value = 0,message = "El stock del producto no puede ser menor a 0")
    private long stock;
    private String image;
}
