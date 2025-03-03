package com.campeones.proyectomoviles.services;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;
import com.campeones.proyectomoviles.model.Entities.Anuncio;

public interface AnunciosService {
	ResponseEntity<List<AnuncioDTO>> get();

	ResponseEntity<AnuncioDTO> post(AnuncioDTO anuncio);

	ResponseEntity<AnuncioDTO> put(AnuncioDTO anuncio);

	ResponseEntity<AnuncioDTO> delete(long id);

	ResponseEntity<AnuncioDTO> deleteAnuncioUsuario(long id);

	ResponseEntity<List<AnuncioDTO>> getByFilter(Specification<Anuncio> spec);
}
