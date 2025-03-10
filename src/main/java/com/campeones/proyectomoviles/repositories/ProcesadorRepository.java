package com.campeones.proyectomoviles.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.campeones.proyectomoviles.model.Entities.Procesador;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcesadorRepository extends JpaRepository<Procesador, Long>, JpaSpecificationExecutor<Procesador> {

	List<Procesador> findByTipo(String tipo);

	List<Procesador> findByVelocidadMaximaBetween(float min, float max);
}
