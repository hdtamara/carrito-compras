package com.carritocompras.carritocompras.controllers;


import com.carritocompras.carritocompras.dtos.UsuarioDto;
import com.carritocompras.carritocompras.entities.Usuario;
import com.carritocompras.carritocompras.exception.UserAlreadyExistsException;
import com.carritocompras.carritocompras.exception.UserNotFoundException;
import com.carritocompras.carritocompras.services.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private  final IUsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable long id) throws UserNotFoundException {
        return  ResponseEntity.ok(usuarioService.findUserById(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> createUser(@Valid @RequestBody UsuarioDto usuarioDto) throws UserAlreadyExistsException {
        Usuario usuario = Usuario.builder()
                .email(usuarioDto.getEmail())
                .userName(usuarioDto.getUserName())
                .nombre(usuarioDto.getNombre())
                .apellido(usuarioDto.getApellido())
                .password(usuarioDto.getPassword())
                .direccion(usuarioDto.getDireccion())
                .telefono(usuarioDto.getTelefono())
                .build();

        return new ResponseEntity<>(usuarioService.crearUsuario(usuario), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUSer(@PathVariable long id,@RequestBody @Valid UsuarioDto usuarioDto) throws UserNotFoundException {
        Usuario usuarioToUpdate = usuarioService.findUserById(id);
        usuarioToUpdate.setEmail(usuarioDto.getEmail());
        usuarioToUpdate.setUserName(usuarioDto.getUserName());
        usuarioToUpdate.setNombre(usuarioDto.getNombre());
        usuarioToUpdate.setApellido(usuarioDto.getApellido());
        usuarioToUpdate.setPassword(usuarioDto.getPassword());
        usuarioToUpdate.setDireccion(usuarioDto.getDireccion());
        usuarioToUpdate.setTelefono(usuarioDto.getTelefono());
        return ResponseEntity.ok(usuarioService.updateUser(usuarioToUpdate));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable long id) throws UserNotFoundException {
        usuarioService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
