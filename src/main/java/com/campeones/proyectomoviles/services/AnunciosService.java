package com.campeones.proyectomoviles.services;

import com.campeones.proyectomoviles.model.Entities.Anuncio;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
