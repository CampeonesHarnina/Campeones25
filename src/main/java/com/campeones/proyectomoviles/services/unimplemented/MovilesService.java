package com.campeones.proyectomoviles.services.unimplemented;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.MovilDTO;
import com.campeones.proyectomoviles.model.Entities.Movil;

public interface MovilesService {

	ResponseEntity<List<MovilDTO>> get();

	ResponseEntity<MovilDTO> post(MovilDTO movil);

	ResponseEntity<MovilDTO> put(MovilDTO movil);

	ResponseEntity<MovilDTO> delete(long id);

	ResponseEntity<List<MovilDTO>> getByFilter(Specification<Movil> spec);
}
