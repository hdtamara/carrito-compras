package com.carritocompras.carritocompras.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder @Entity @Table(name = "USUARIOS_TBL")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name", nullable = false,unique = true)
    private  String userName;
    @Column(nullable = false)
    private String nombre;
    private String apellido;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String direccion;
    private String telefono;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER) //quitar la primera vez que se ejecute
    @JoinTable(name="USER_ROLE_TBL", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private  Set<Rol> roles = new HashSet<>();

}
