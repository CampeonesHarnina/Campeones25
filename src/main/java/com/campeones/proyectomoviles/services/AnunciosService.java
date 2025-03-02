package com.campeones.proyectomoviles.services;

import com.campeones.proyectomoviles.model.Entities.Anuncio;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;

import java.util.List;

public interface AnunciosService {
    ResponseEntity<List<AnuncioDTO>> get();
    ResponseEntity<AnuncioDTO> post(AnuncioDTO anuncio);
    ResponseEntity<AnuncioDTO> put(AnuncioDTO anuncio);
    ResponseEntity<AnuncioDTO> delete(long id);
    ResponseEntity<List<AnuncioDTO>> getAnunciosUsuario(long id);
    ResponseEntity<List<AnuncioDTO>> getByFilter(Specification<Anuncio> spec);
}
