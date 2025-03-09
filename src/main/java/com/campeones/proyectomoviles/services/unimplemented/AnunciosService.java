package com.campeones.proyectomoviles.services.unimplemented;

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

	ResponseEntity<List<AnuncioDTO>> getByFilter(Specification<Anuncio> spec);

	ResponseEntity<List<AnuncioDTO>> getAnunciosUsuario(String token);

	ResponseEntity<AnuncioDTO> agregarAnuncioUsuario(AnuncioDTO add, String token);

	ResponseEntity<AnuncioDTO> borrarAnuncioUsuario(Long id, String token);

	ResponseEntity<AnuncioDTO> actualizarAnuncioUsuario(AnuncioDTO put, String token);
}
