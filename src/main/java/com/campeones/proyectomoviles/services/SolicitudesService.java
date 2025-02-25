package com.campeones.proyectomoviles.services;

import com.campeones.proyectomoviles.model.Entities.Solicitud;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.SolicitudDTO;

import java.util.function.Predicate;

public interface SolicitudesService {
	public ResponseEntity<SolicitudDTO> get();

	public ResponseEntity<SolicitudDTO> post(SolicitudDTO solicitud);

	public ResponseEntity<SolicitudDTO> put(SolicitudDTO solicitud);

	public ResponseEntity<SolicitudDTO> delete(long id);

	public ResponseEntity<SolicitudDTO> getByFilter(Predicate<Solicitud> filter);

}
