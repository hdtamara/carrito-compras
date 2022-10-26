package com.carritocompras.carritocompras.dtos;

import com.carritocompras.carritocompras.entities.Rol;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDto {
    @NotBlank(message = "Username no puede estar vacio")
    private  String userName;
    @NotBlank(message = "Nombre no puede estar vacio")
    private String nombre;
    private String apellido;
    @Email(message = "Dirección de correo incorrecta")
    @NotBlank(message = "Email no puede estar vacio")
    private String email;
    @NotBlank(message = "La contraseña no puede estar vacia")
    @Size(min = 6, message = "La contraseña debe tener más de 6 caracteres")
    private String password;
    private String direccion;
    private String telefono;

}
