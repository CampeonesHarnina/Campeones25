package com.campeones.proyectomoviles.services;

import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;

public interface AnunciosService {
	public ResponseEntity<AnuncioDTO> get();

	public ResponseEntity<AnuncioDTO> post(AnuncioDTO anuncio);

	public ResponseEntity<AnuncioDTO> put(AnuncioDTO anuncio);

	public ResponseEntity<AnuncioDTO> delete(int id);
}
