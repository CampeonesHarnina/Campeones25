package com.campeones.proyectomoviles.services;

import com.campeones.proyectomoviles.mappers.SolicitudMapper;
import com.campeones.proyectomoviles.model.DTO.SolicitudDTO;
import com.campeones.proyectomoviles.model.Entities.Solicitud;
import com.campeones.proyectomoviles.repositories.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudesServiceImpl implements SolicitudesService {

    @Autowired
    private SolicitudRepository repository;

    @Autowired
    private SolicitudMapper mapper;

    public SolicitudesServiceImpl(SolicitudRepository repository, SolicitudMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
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
