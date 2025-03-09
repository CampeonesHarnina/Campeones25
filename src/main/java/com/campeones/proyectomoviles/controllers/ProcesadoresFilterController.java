package com.campeones.proyectomoviles.controllers;

import java.util.List;

import com.campeones.proyectomoviles.controllers.unimplemented.GenericFilterController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.campeones.proyectomoviles.model.DTO.ProcesadorDTO;
import com.campeones.proyectomoviles.model.Entities.Procesador;
import com.campeones.proyectomoviles.model.filtros.ProcesadorFiltro;
import com.campeones.proyectomoviles.model.specifications.ProcesadorSpecification;
import com.campeones.proyectomoviles.services.ProcesadoresServiceImpl;

@CrossOrigin("*")
@RestController
public class ProcesadoresFilterController implements GenericFilterController<ProcesadorDTO, ProcesadorFiltro, Long> {
	private final ProcesadoresServiceImpl procesadoresService;

	@Autowired
	public ProcesadoresFilterController(ProcesadoresServiceImpl procesadoresService) {
		this.procesadoresService = procesadoresService;
	}

	@GetMapping("/procesadores/find")
	@Override
	public ResponseEntity<List<ProcesadorDTO>> get() {
		return procesadoresService.get();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/procesadores/new")
	@Override
	public ResponseEntity<ProcesadorDTO> post(ProcesadorDTO procesadorDTO) {
		return procesadoresService.post(procesadorDTO);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/procesadores/update")
	@Override
	public ResponseEntity<ProcesadorDTO> put(ProcesadorDTO procesadorDTO) {
		return procesadoresService.put(procesadorDTO);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/procesadores/delete/{id}")
	@Override
	public ResponseEntity<ProcesadorDTO> delete(Long id) {
		return procesadoresService.delete(id);
	}

	@GetMapping("/procesadores/filter")
	@Override
	public ResponseEntity<List<ProcesadorDTO>> getByFilter(@RequestBody ProcesadorFiltro spec) {
		Specification<Procesador> specification = Specification.where(null);

		if (spec.getTipo() != null) {
			specification = specification.and(ProcesadorSpecification.hasTipo(spec.getTipo()));
		}
		if (spec.getNucleo() != null) {
			specification = specification.and(ProcesadorSpecification.hasNucleo(spec.getNucleo()));
		}
		if (spec.getVelocidadMin() != null) {
			specification = specification.and(ProcesadorSpecification.hasVelocidadMaxima(spec.getVelocidadMin()));
		}
		if (spec.getVelocidadMax() != null) {
			specification = specification.and(ProcesadorSpecification.hasVelocidadMaxima(spec.getVelocidadMax()));
		}

		return procesadoresService.getByFilter(specification);
	}
}
