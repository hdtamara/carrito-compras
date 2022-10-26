package com.carritocompras.carritocompras.services;

import com.carritocompras.carritocompras.entities.Usuario;
import com.carritocompras.carritocompras.exception.UserAlreadyExistsException;
import com.carritocompras.carritocompras.exception.UserNotFoundException;


import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    Usuario crearUsuario(Usuario usuario) throws UserAlreadyExistsException;

    Optional<Usuario> findByUserName(String userName) throws UserNotFoundException;

    List<Usuario> findAll();

    Usuario findUserById(Long id) throws UserNotFoundException;

    void deleteUserById(Long id) throws UserNotFoundException;

    Usuario updateUser(Usuario usuario) throws UserNotFoundException;


}
