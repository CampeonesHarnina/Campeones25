package com.campeones.proyectomoviles.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campeones.proyectomoviles.model.Entities.Procesador;

public interface ProcesadorRepository extends JpaRepository<Procesador, Long> {

	List<Procesador> findByTipo(String tipo);

	List<Procesador> findByVelocidadMaximaBetween(float min, float max);
}
