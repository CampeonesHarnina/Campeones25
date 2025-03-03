package com.campeones.proyectomoviles.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campeones.proyectomoviles.model.Entities.Movil;

public interface MovilRepository extends JpaRepository<Movil, Long> {

	List<Movil> findByMarca(String marca);

	List<Movil> findByRamBetween(int min, int max);

	List<Movil> findByPrecioActualBetween(float min, float max);

	List<Movil> findByNfc(int nfc);

}
