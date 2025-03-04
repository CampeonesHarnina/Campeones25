package com.campeones.proyectomoviles.controllers;

import java.util.List;

import com.campeones.proyectomoviles.model.Entities.Anuncio;
import com.campeones.proyectomoviles.model.Entities.Movil;
import com.campeones.proyectomoviles.model.specifications.AnuncioSpecification;
import com.campeones.proyectomoviles.model.specifications.MovilSpecification;
import com.campeones.proyectomoviles.services.MovilesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.MovilDTO;
import com.campeones.proyectomoviles.model.filtros.MovilFiltro;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovilesController implements GenericController<MovilDTO, MovilFiltro, Long> {

	private final MovilesServiceImpl movilesService;

	@Autowired
	public MovilesController(MovilesServiceImpl movilesService) {
		this.movilesService = movilesService;
	}

	@Override
	public ResponseEntity<List<MovilDTO>> get() {
		return movilesService.get();
	}

	@Override
	public ResponseEntity<MovilDTO> post(MovilDTO movilDTO) {
		return movilesService.post(movilDTO);
	}

	@Override
	public ResponseEntity<MovilDTO> put(MovilDTO movilDTO) {
		return movilesService.put(movilDTO);
	}

	@Override
	public ResponseEntity<MovilDTO> delete(Long id) {
		return movilesService.delete(id);
	}

	@Override
	public ResponseEntity<List<MovilDTO>> getByFilter(MovilFiltro spec) {
		Specification<Movil> specification = Specification.where(null);
		if (spec.getMarca() != null) {
			specification = specification.and(MovilSpecification.hasMarca(spec.getMarca()));
		}
		if (spec.getMinRam() != null) {
			specification = specification.and(MovilSpecification.hasMinRam(spec.getMinRam()));
		}
		if (spec.getMaxRam() != null) {
			specification = specification.and(MovilSpecification.hasMaxRam(spec.getMaxRam()));
		}
		if (spec.getMinPrecio() != null) {
			specification = specification.and(MovilSpecification.hasMinPrecio(spec.getMinPrecio()));
		}
		if (spec.getMaxPrecio() != null) {
			specification = specification.and(MovilSpecification.hasMaxPrecio(spec.getMaxPrecio()));
		}
		if (spec.getHasNfc() != null) {
			specification = specification.and(MovilSpecification.hasNfc(spec.getHasNfc()));
		}

		return movilesService.getByFilter(specification);
	}
}
