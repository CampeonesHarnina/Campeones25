package com.campeones.proyectomoviles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campeones.proyectomoviles.model.entities.Usuario;

public interface UsuarioRepositoty extends JpaRepository<Usuario, Long> {

}
