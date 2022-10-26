package com.carritocompras.carritocompras.dtos;

import com.carritocompras.carritocompras.entities.Producto;
import com.carritocompras.carritocompras.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarritoCompraDto {
   @NotNull(message = "El usuario no puede esta vacio")
    private long usuarioId;
    @NotNull(message = "El producto no puede ser nulo")
    private long productoId;
    @NotNull(message = "La cantidad no puede ser nulo")
    private  int cantidad;
}
