package com.campeones.proyectomoviles.controllers;

import java.util.List;

import com.campeones.proyectomoviles.model.Entities.Movil;
import com.campeones.proyectomoviles.model.specifications.MovilSpecification;
import com.campeones.proyectomoviles.services.MovilesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.MovilDTO;
import com.campeones.proyectomoviles.model.filtros.MovilFiltro;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class MovilesFilterController implements GenericFilterController<MovilDTO, MovilFiltro, Long> {

	private final MovilesServiceImpl movilesService;

	@Autowired
	public MovilesFilterController(MovilesServiceImpl movilesService) {
		this.movilesService = movilesService;
	}

	@GetMapping("/moviles/find")
	@Override
	public ResponseEntity<List<MovilDTO>> get() {
		return movilesService.get();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/moviles/new")
	@Override
	public ResponseEntity<MovilDTO> post(@RequestBody MovilDTO movilDTO) {
		return movilesService.post(movilDTO);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/moviles/update")
	@Override
	public ResponseEntity<MovilDTO> put(@RequestBody MovilDTO movilDTO) {
		return movilesService.put(movilDTO);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/moviles/delete/{id}")
	@Override
	public ResponseEntity<MovilDTO> delete(@RequestParam Long id) {
		return movilesService.delete(id);
	}

	@GetMapping("/moviles/filter")
	@Override
	public ResponseEntity<List<MovilDTO>> getByFilter(@RequestBody MovilFiltro spec) {
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
