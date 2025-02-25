package com.campeones.proyectomoviles.services;

import com.campeones.proyectomoviles.model.Entities.Anuncio;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;

import java.util.List;
import java.util.function.Predicate;

public interface AnunciosService {
	public ResponseEntity<AnuncioDTO> get();

	public ResponseEntity<AnuncioDTO> post(AnuncioDTO anuncio);

	public ResponseEntity<AnuncioDTO> put(AnuncioDTO anuncio);

	public ResponseEntity<AnuncioDTO> delete(long id);

	public ResponseEntity<AnuncioDTO> getAnunciosUsuario(long id);

	public ResponseEntity<AnuncioDTO> deleteAnuncioUsuario(long id);

	public ResponseEntity<List<AnuncioDTO>> getByFilter(Predicate<Anuncio> filtro);
}
