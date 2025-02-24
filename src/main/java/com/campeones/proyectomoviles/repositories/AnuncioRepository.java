package com.campeones.proyectomoviles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campeones.proyectomoviles.model.entities.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

}
