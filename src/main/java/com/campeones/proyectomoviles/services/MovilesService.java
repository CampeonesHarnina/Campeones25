package com.campeones.proyectomoviles.services;

import com.campeones.proyectomoviles.model.Entities.Movil;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.MovilDTO;

import java.util.function.Predicate;

public interface MovilesService {
	
	public ResponseEntity<MovilDTO> get();

	public ResponseEntity<MovilDTO> post(MovilDTO movil);

	public ResponseEntity<MovilDTO> put(MovilDTO movil);

	public ResponseEntity<MovilDTO> delete(long id);

	public ResponseEntity<MovilDTO> getByFilter(Predicate<MovilDTO> filter);
}
