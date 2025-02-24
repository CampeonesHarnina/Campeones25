package com.campeones.proyectomoviles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campeones.proyectomoviles.entity.Usuario;

public interface UsuarioRepositoty extends JpaRepository<Usuario, Long> {

}
