package com.campeones.proyectomoviles.repositories;

import com.campeones.proyectomoviles.model.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepositoty extends JpaRepository<Usuario, Long> {

}
