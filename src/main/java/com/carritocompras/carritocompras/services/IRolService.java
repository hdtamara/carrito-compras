package com.carritocompras.carritocompras.services;

import com.carritocompras.carritocompras.entities.Rol;
import com.carritocompras.carritocompras.entities.RolesList;


import java.util.Optional;

public interface IRolService {

   Optional<Rol> getByRoleName(RolesList rolName);

}
