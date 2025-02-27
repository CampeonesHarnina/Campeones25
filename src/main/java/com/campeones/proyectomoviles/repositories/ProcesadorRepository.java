package com.campeones.proyectomoviles.repositories;

import com.campeones.proyectomoviles.model.Entities.Procesador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProcesadorRepository extends JpaRepository<Procesador, Long> {

    List<Procesador> findByTipo(String tipo);
    List<Procesador> findByVelocidadMaximaBetween(float min, float max);
}
