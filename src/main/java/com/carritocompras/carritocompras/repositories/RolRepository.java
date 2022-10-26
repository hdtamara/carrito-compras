package com.carritocompras.carritocompras.repositories;

import com.carritocompras.carritocompras.entities.Rol;

import com.carritocompras.carritocompras.entities.RolesList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RolRepository extends JpaRepository<Rol,Long> {
    Optional<Rol> findByRoleName(RolesList roleName);
}
