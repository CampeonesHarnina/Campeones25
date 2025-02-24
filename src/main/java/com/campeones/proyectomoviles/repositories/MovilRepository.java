package com.campeones.proyectomoviles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campeones.proyectomoviles.model.entities.Movil;

public interface MovilRepository extends JpaRepository<Movil, Long> {

}
