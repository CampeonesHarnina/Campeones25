package com.campeones.proyectomoviles.services;

import com.campeones.proyectomoviles.model.Entities.Movil;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.MovilDTO;

import java.util.List;

public interface MovilesService {

    ResponseEntity<MovilDTO> get();
    ResponseEntity<MovilDTO> post(MovilDTO movil);
    ResponseEntity<MovilDTO> put(MovilDTO movil);
    ResponseEntity<MovilDTO> delete(long id);
    ResponseEntity<List<MovilDTO>> getByFilter(Specification<Movil> spec);
}
