package com.aluracursos.forohub;

import com.aluracursos.forohub.domain.usuario.Usuario;
import com.aluracursos.forohub.domain.usuario.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class ForohubApplicationTests {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void crearUsuario() {
        // Usamos el constructor directamente en lugar de los setters
        var usuario = new Usuario(null, "brayan.camargo", passwordEncoder.encode("123456"));

        repository.save(usuario);
        System.out.println("Usuario creado con éxito!");
    }
}