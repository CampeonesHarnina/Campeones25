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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class SolicitudesController implements GenericController<SolicitudDTO, SolicitudFiltro, Long>, UserCrudController<SolicitudDTO, Long> {
    private final SolicitudesServiceImpl solicitudesService;

    @Autowired
    public SolicitudesController(SolicitudesServiceImpl solicitudesService) {
        this.solicitudesService = solicitudesService;
    }

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

    @PostMapping("/solicitudes/new/user/{id}")
    @Override
    public ResponseEntity<SolicitudDTO> addToUser(SolicitudDTO add, Long id) {
        return null;
    }

    @PutMapping("/solicitudes/update/user/{id}")
    @Override
    public ResponseEntity<SolicitudDTO> updateByUser(SolicitudDTO put, Long id) {
        return null;
    }

    @DeleteMapping(value = "/solicitudes/delete/user/{id}")
    @Override
    public ResponseEntity<SolicitudDTO> deleteByUser(SolicitudDTO erase, Long id) {
        return null;
    }
}
