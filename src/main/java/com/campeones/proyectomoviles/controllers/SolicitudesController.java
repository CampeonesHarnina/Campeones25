package com.campeones.proyectomoviles.controllers;

import java.util.List;

import com.campeones.proyectomoviles.model.specifications.SolicitudSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.SolicitudDTO;
import com.campeones.proyectomoviles.model.Entities.Solicitud;
import com.campeones.proyectomoviles.model.filtros.SolicitudFiltro;
import com.campeones.proyectomoviles.services.SolicitudesServiceImpl;

public class SolicitudesController implements GenericController<SolicitudDTO, SolicitudFiltro, Long> {
	  private final SolicitudesServiceImpl solicitudesService;

	    @Autowired
	    public SolicitudesController(SolicitudesServiceImpl solicitudesService) {
	        this.solicitudesService = solicitudesService;
	    }

	    @Override
	    public ResponseEntity<List<SolicitudDTO>> get() {
	        return solicitudesService.get();
	    }

	    @Override
	    public ResponseEntity<SolicitudDTO> post(SolicitudDTO solicitudDTO) {
	        return solicitudesService.post(solicitudDTO);
	    }

	    @Override
	    public ResponseEntity<SolicitudDTO> put(SolicitudDTO solicitudDTO) {
	        return solicitudesService.put(solicitudDTO);
	    }

	    @Override
	    public ResponseEntity<SolicitudDTO> delete(Long id) {
	        return solicitudesService.delete(id);
	    }

	    @Override
	    public ResponseEntity<List<SolicitudDTO>> getByFilter(SolicitudFiltro spec) {
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
	        if (spec.getRemitente() != null) {
	            specification = specification.and(SolicitudSpecification.hasRemitente(spec.getRemitente()));
	        }
	        if (spec.getDestinatario() != null) {
	            specification = specification.and(SolicitudSpecification.hasDestinatario(spec.getDestinatario()));
	        }
	        if (spec.getAnuncio() != null) {
	            specification = specification.and(SolicitudSpecification.hasAnuncio(spec.getAnuncio()));
	        }

	        return solicitudesService.getByFilter(specification);
	    }
}
