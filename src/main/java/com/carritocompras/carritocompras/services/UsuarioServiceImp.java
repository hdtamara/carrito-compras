package com.carritocompras.carritocompras.services;


import com.carritocompras.carritocompras.entities.Rol;
import com.carritocompras.carritocompras.entities.RolesList;
import com.carritocompras.carritocompras.entities.Usuario;
import com.carritocompras.carritocompras.exception.UserAlreadyExistsException;
import com.carritocompras.carritocompras.exception.UserNotFoundException;
import com.carritocompras.carritocompras.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UsuarioServiceImp implements IUsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    RolServiceImp rolServiceImp;

    @Override
    public Usuario crearUsuario(Usuario usuario) throws UserAlreadyExistsException {
        if (usuarioRepository.existsByUserName(usuario.getUserName())){
            throw  new UserAlreadyExistsException("Ya existe un usuario con el username: "+usuario.getUserName());
        }
        Set<Rol> role = new HashSet<>();
        role.add(rolServiceImp.getByRoleName(RolesList.ROL_USER).get());
        usuario.setRoles(role);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findByUserName(String userName) throws UserNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByUserName(userName);
        if(usuario.isEmpty())
            throw new UserNotFoundException("Usuario no encontrado con el username: "+userName);
        return usuario;
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findUserById(Long id) throws UserNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty())
            throw new UserNotFoundException("Usuario no encontrado con el id: "+id);
        return usuario.get();
    }

    @Override
    public void deleteUserById(Long id) throws UserNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty())
            throw new UserNotFoundException("Usuario no encontrado con el id: "+id);
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario updateUser(Usuario usuario) throws UserNotFoundException {
        if (!usuarioRepository.existsByUserName(usuario.getUserName())){
            throw new UserNotFoundException("Usuario no encontrado con el id: "+usuario.getId());
        }
        return usuarioRepository.save(usuario);
    }


}
