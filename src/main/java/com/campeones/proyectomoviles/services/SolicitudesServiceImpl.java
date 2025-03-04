package com.campeones.proyectomoviles.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campeones.proyectomoviles.mappers.SolicitudMapper;
import com.campeones.proyectomoviles.model.DTO.SolicitudDTO;
import com.campeones.proyectomoviles.model.Entities.Solicitud;
import com.campeones.proyectomoviles.repositories.SolicitudRepository;

@Service
public class SolicitudesServiceImpl implements SolicitudesService {
	 private final SolicitudRepository repository;
	    private final SolicitudMapper mapper;

	    @Autowired
	    public SolicitudesServiceImpl(SolicitudRepository repository, SolicitudMapper mapper) {
	        this.repository = repository;
	        this.mapper = mapper;
	    }

	    @Override
	    public ResponseEntity<List<SolicitudDTO>> get() {
	        return ResponseEntity.ok(repository.findAll().stream()
	                .map(mapper::mapToDTO)
	                .collect(Collectors.toList()));
	    }

	    @Transactional
	    @Override
	    public ResponseEntity<SolicitudDTO> post(SolicitudDTO solicitud) {
	        Solicitud save = repository.save(mapper.mapToEntity(solicitud));
	        return ResponseEntity.ok(mapper.mapToDTO(save));
	    }

	    @Transactional
	    @Override
	    public ResponseEntity<SolicitudDTO> put(SolicitudDTO solicitud) {
	        if (repository.existsById(solicitud.idSolicitud())) {
	            repository.save(mapper.mapToEntity(solicitud));
	            return ResponseEntity.ok(solicitud);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @Transactional
	    @Override
	    public ResponseEntity<SolicitudDTO> delete(long id) {
	        if (repository.existsById(id)) {
	            repository.deleteById(id);
	            return ResponseEntity.ok().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @Override
	    public ResponseEntity<List<SolicitudDTO>> getByFilter(Specification<Solicitud> spec) {
	        return ResponseEntity.ok(repository.findAll(spec).stream()
	                .map(mapper::mapToDTO)
	                .collect(Collectors.toList()));
	    }

}
