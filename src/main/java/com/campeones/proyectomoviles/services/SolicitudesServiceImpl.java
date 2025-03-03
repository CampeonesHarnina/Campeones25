package com.campeones.proyectomoviles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.campeones.proyectomoviles.model.DTO.SolicitudDTO;
import com.campeones.proyectomoviles.model.Entities.Solicitud;
import com.campeones.proyectomoviles.repositories.SolicitudRepository;

@Service
public class SolicitudesServiceImpl implements SolicitudesService {

	private SolicitudRepository repository;

	@Autowired
	public SolicitudesServiceImpl(SolicitudRepository repository) {
		this.repository = repository;
	}

	@Override
	public ResponseEntity<SolicitudDTO> get() {
		return null;
	}

	@Override
	public ResponseEntity<SolicitudDTO> post(SolicitudDTO solicitud) {
		return null;
	}

	@Override
	public ResponseEntity<SolicitudDTO> put(SolicitudDTO solicitud) {
		return null;
	}

	@Override
	public ResponseEntity<SolicitudDTO> delete(long id) {
		return null;
	}

	@Override
	public ResponseEntity<List<SolicitudDTO>> getByFilter(Specification<Solicitud> spec) {
		return null;
	}

}
