package com.carritocompras.carritocompras.services;

import com.carritocompras.carritocompras.entities.Rol;
import com.carritocompras.carritocompras.entities.RolesList;
import com.carritocompras.carritocompras.repositories.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolServiceImp implements  IRolService{
    @Autowired
    RolRepository rolRepository;

    @Override
    public Optional<Rol> getByRoleName(RolesList rolName) {
        return rolRepository.findByRoleName(rolName);
    }
}
