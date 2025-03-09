package com.campeones.proyectomoviles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.campeones.proyectomoviles.model.DTO.SolicitudDTO;
import com.campeones.proyectomoviles.model.Entities.Solicitud;
import com.campeones.proyectomoviles.model.filtros.SolicitudFiltro;
import com.campeones.proyectomoviles.model.specifications.SolicitudSpecification;
import com.campeones.proyectomoviles.services.SolicitudesServiceImpl;

@CrossOrigin("*")
@RestController
public class SolicitudesFilterController implements GenericFilterController<SolicitudDTO, SolicitudFiltro, Long>,
		UserCrudController<SolicitudDTO, Long> {
	private final SolicitudesServiceImpl solicitudesService;

	@Autowired
	public SolicitudesFilterController(SolicitudesServiceImpl solicitudesService) {
		this.solicitudesService = solicitudesService;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/solicitudes/find")
	@Override
	public ResponseEntity<List<SolicitudDTO>> get() {
		return solicitudesService.get();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/solicitudes/new")
	@Override
	public ResponseEntity<SolicitudDTO> post(SolicitudDTO solicitudDTO) {
		return solicitudesService.post(solicitudDTO);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/solicitudes/update")
	@Override
	public ResponseEntity<SolicitudDTO> put(SolicitudDTO solicitudDTO) {
		return solicitudesService.put(solicitudDTO);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/solicitudes/delete/{id}")
	@Override
	public ResponseEntity<SolicitudDTO> delete(Long id) {
		return solicitudesService.delete(id);
	}

	@GetMapping("solicitudes/filter")
	@Override
	public ResponseEntity<List<SolicitudDTO>> getByFilter(@RequestBody SolicitudFiltro spec) {
		Specification<Solicitud> specification = Specification.where(null);

		if (spec.getFechaMin() != null) {
			specification = specification.and(SolicitudSpecification.hasFechaMinima(spec.getFechaMin()));
		}
		if (spec.getFechaMax() != null) {
			specification = specification.and(SolicitudSpecification.hasFechaMaxima(spec.getFechaMax()));
		}
		if (spec.getContestada() != null) {
			specification = specification.and(SolicitudSpecification.hasContestada(spec.getContestada()));
		}
		if (spec.getAnuncio() != null) {
			specification = specification.and(SolicitudSpecification.hasAnuncio(spec.getAnuncio()));
		}

		return solicitudesService.getByFilter(specification);
	}

	@GetMapping("/solicitudes/find/user/received")
	@Override
	public ResponseEntity<List<SolicitudDTO>> getByUser(@RequestHeader("Authorization") String token) {
		return solicitudesService.getByUser(token);
	}

	@GetMapping("/solicitudes/find/user/sent")
	public ResponseEntity<List<SolicitudDTO>> getByUserSent(@RequestHeader("Authorization") String token) {
		return solicitudesService.getEnviadasByUser(token);
	}

	@PostMapping("/solicitudes/new/user")
	@Override
	public ResponseEntity<SolicitudDTO> addToUser(@RequestBody SolicitudDTO add,
			@RequestHeader("Authorization") String token) {
		return solicitudesService.addToUser(add, token);
	}

	@PutMapping("/solicitudes/update/user")
	@Override
	public ResponseEntity<SolicitudDTO> updateByUser(@RequestBody SolicitudDTO put,
			@RequestHeader("Authorization") String token) {
		return solicitudesService.updateByUser(put, token);
	}

	@DeleteMapping(value = "/solicitudes/delete/{id}/user")
	@Override
	public ResponseEntity<SolicitudDTO> deleteByUser(@PathVariable Long id,
			@RequestHeader("Authorization") String token) {
		return solicitudesService.deleteByUser(id, token);
	}
}
