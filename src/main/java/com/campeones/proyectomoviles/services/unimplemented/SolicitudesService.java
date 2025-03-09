package com.campeones.proyectomoviles.services.unimplemented;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.SolicitudDTO;
import com.campeones.proyectomoviles.model.Entities.Solicitud;

public interface SolicitudesService {
	ResponseEntity<List<SolicitudDTO>> get();

	ResponseEntity<SolicitudDTO> post(SolicitudDTO solicitud);

	ResponseEntity<SolicitudDTO> put(SolicitudDTO solicitud);

	ResponseEntity<SolicitudDTO> delete(long id);

	ResponseEntity<List<SolicitudDTO>> getByFilter(Specification<Solicitud> spec);

}
