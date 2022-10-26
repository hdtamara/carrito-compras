package com.carritocompras.carritocompras.repositories;

import com.carritocompras.carritocompras.entities.Rol;
import com.carritocompras.carritocompras.entities.RolesList;
import com.carritocompras.carritocompras.entities.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UsuarioRepositoryTest {
    @Autowired
    private  UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    private Usuario usuario1;
    private  Usuario usuario2;

    @BeforeEach
    void setUp() {
        Set<Rol> rolesUser= new HashSet<>();
        Rol rol = Rol.builder().id(1L).roleName(RolesList.ROL_ADMIN).build();
        rolesUser.add(rol);
        rolRepository.save(rol);
        //given
        usuario1 = Usuario.builder()
                .nombre("Hernan")
                .apellido("Tamara")
                .email("hernan@correo.com")
                .direccion("cll 1 cr 2")
                .password("123456")
                .userName("hernan")
                .telefono("3004005602")
                .roles(rolesUser)
                .build();
        usuario2 = Usuario.builder()
                .nombre("Tayni")
                .apellido("Caro")
                .email("Caro@correo.com")
                .direccion("cll 1 cr 2")
                .password("123456")
                .userName("caro")
                .telefono("3004005602")
                .roles(rolesUser)
                .build();
        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);
    }

    @AfterEach
    void tearDown() {
        usuarioRepository.deleteAll();
    }
    @DisplayName("Test para buscar usuarios por username")
    @Test
    void findByUserName() {


        //when
        Optional<Usuario> usuario = usuarioRepository.findByUserName(usuario1.getUserName());
        //then
        assertThat(usuario).isNotNull();
        assertThat(usuario.get()).isEqualTo(usuario1);
    }
    @DisplayName("Test para cuando un usuario existe")
    @Test
    void existsByUserName() {
        //when
        boolean usuarioExist = usuarioRepository.existsByUserName(usuario2.getUserName());
        //then
        assertThat(usuarioExist).isTrue();
    }

    @DisplayName("Test para cuando un usuario  no existe")
    @Test
    void notExistsByUserName() {
        //when
        boolean usuarioExist = usuarioRepository.existsByUserName("usuario");
        //then
        assertThat(usuarioExist).isFalse();
    }
}