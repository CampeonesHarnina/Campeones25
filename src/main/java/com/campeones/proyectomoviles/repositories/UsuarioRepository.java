package com.campeones.proyectomoviles.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campeones.proyectomoviles.model.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByEmail(String email);
}