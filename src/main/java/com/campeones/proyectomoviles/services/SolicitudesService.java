package com.campeones.proyectomoviles.services;

import com.campeones.proyectomoviles.model.Entities.Solicitud;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.SolicitudDTO;

import java.util.List;

public interface SolicitudesService {
	ResponseEntity<SolicitudDTO> get();
	ResponseEntity<SolicitudDTO> post(SolicitudDTO solicitud);
	ResponseEntity<SolicitudDTO> put(SolicitudDTO solicitud);
	ResponseEntity<SolicitudDTO> delete(long id);
	ResponseEntity<List<Solicitud>> filterByDestinatarioId(long id);
	ResponseEntity<List<SolicitudDTO>> filterByRemitenteId(long id);
}
