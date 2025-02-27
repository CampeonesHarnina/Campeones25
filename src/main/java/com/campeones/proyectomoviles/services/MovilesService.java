package com.campeones.proyectomoviles.services;

import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.MovilDTO;

import java.util.List;

public interface MovilesService {

    ResponseEntity<MovilDTO> get();
    ResponseEntity<MovilDTO> post(MovilDTO movil);
    ResponseEntity<MovilDTO> put(MovilDTO movil);
    ResponseEntity<MovilDTO> delete(long id);
    ResponseEntity<List<MovilDTO>> filterByMarca(String marca);
    ResponseEntity<List<MovilDTO>> filterByRamBetween(int min, int max);
    ResponseEntity<List<MovilDTO>> filterByPrecioActualBetween(float min, float max);
    ResponseEntity<List<MovilDTO>> filterByNfc(int nfc);
}
