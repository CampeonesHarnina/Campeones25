package com.campeones.proyectomoviles.services;

import com.campeones.proyectomoviles.model.Entities.Anuncio;
import com.campeones.proyectomoviles.model.POJO.Estado;
import com.campeones.proyectomoviles.model.POJO.TipoCambio;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;

import java.util.List;

public interface AnunciosService {
    ResponseEntity<AnuncioDTO> get();
    ResponseEntity<AnuncioDTO> post(AnuncioDTO anuncio);
    ResponseEntity<AnuncioDTO> put(AnuncioDTO anuncio);
    ResponseEntity<AnuncioDTO> delete(long id);
    ResponseEntity<AnuncioDTO> deleteAnuncioUsuario(long id);
    ResponseEntity<List<AnuncioDTO>> filterByEstado(Estado estado);
    ResponseEntity<List<Anuncio>> filterByTipoCambio(TipoCambio tipoCambio);
    ResponseEntity<List<Anuncio>> filterByUsuarioId(Long id);
}
