package com.carritocompras.carritocompras.repositories;

import com.carritocompras.carritocompras.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByUserName(String userName);
    boolean existsByUserName(String userName);
}
