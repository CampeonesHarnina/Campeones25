package com.campeones.proyectomoviles.services;

import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.SolicitudDTO;

public interface SolicitudesService {
	public ResponseEntity<SolicitudDTO> get();

	public ResponseEntity<SolicitudDTO> post(SolicitudDTO solicitud);

	public ResponseEntity<SolicitudDTO> put(SolicitudDTO solicitud);

	public ResponseEntity<SolicitudDTO> delete(int id);
}
