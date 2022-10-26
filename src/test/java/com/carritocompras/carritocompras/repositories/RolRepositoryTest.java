package com.carritocompras.carritocompras.repositories;

import com.carritocompras.carritocompras.entities.Rol;
import com.carritocompras.carritocompras.entities.RolesList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RolRepositoryTest {
    @Autowired
    private  RolRepository rolRepository;

    private  Rol rol1;
    private  Rol rol2;


    @BeforeEach
    void setUp() {
        //given

        rol1 = Rol.builder().id(1L).roleName(RolesList.ROL_ADMIN).build();
        rol2 = Rol.builder().id(2L).roleName(RolesList.ROL_USER).build();


    }




    @AfterEach
    void tearDown() {
        rolRepository.deleteAll();
    }

    @Test
    void findByRoleName() {
        //given
        rolRepository.save(rol1);
        rolRepository.save(rol2);
        //when
        Optional<Rol> findRol = rolRepository.findByRoleName(RolesList.ROL_USER);
        Optional<Rol> findRol2 = rolRepository.findByRoleName(RolesList.ROL_ADMIN);
        //then
        assertThat(findRol).isNotNull();
        assertThat(findRol.get()).isEqualTo(rol2);
        assertThat(findRol2.get()).isEqualTo(rol1);

    }
}