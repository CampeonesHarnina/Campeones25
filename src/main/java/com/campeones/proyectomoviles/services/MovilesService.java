package com.campeones.proyectomoviles.services;

import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.MovilDTO;

public interface MovilesService {
	
	public ResponseEntity<MovilDTO> get();

	public ResponseEntity<MovilDTO> post(MovilDTO movil);

	public ResponseEntity<MovilDTO> put(MovilDTO movil);

	public ResponseEntity<MovilDTO> delete(int id);

}
