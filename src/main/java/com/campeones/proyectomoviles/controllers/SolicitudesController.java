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

    @PreAuthorize("hasRole('ADMIN')")
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


    @GetMapping("/solicitudes/find/user/sent/{id}")
    public ResponseEntity<SolicitudDTO> getByUserSent(@RequestParam Long id, @RequestHeader("Authorization") String token) {
        return null;
    }

//    @GetMapping("/solicitudes/find/user/received/{id}")
//    @Override
//    public ResponseEntity<List<SolicitudDTO>> getByUser(@RequestParam Long id, @RequestHeader("Authorization") String token) {
//        return null;
//    }
//
//    @PostMapping("/solicitudes/new/user/{id}")
//    @Override
//    public ResponseEntity<SolicitudDTO> addToUser(SolicitudDTO add, @RequestParam Long id, @RequestHeader("Authorization") String token) {
//        return null;
//    }
//
//    @PutMapping("/solicitudes/update/user/{id}")
//    @Override
//    public ResponseEntity<SolicitudDTO> updateByUser(SolicitudDTO put, @RequestParam Long id, @RequestHeader("Authorization") String token) {
//        return null;
//    }
//
//    @DeleteMapping(value = "/solicitudes/delete/user/{id}")
//    @Override
//    public ResponseEntity<SolicitudDTO> deleteByUser(SolicitudDTO erase, @RequestParam Long id, @RequestHeader("Authorization") String token) {
//        return null;
//    }

    @Override
    public ResponseEntity<List<SolicitudDTO>> getByUser(String token) {
        return null;
    }

    @Override
    public ResponseEntity<SolicitudDTO> addToUser(SolicitudDTO add, String token) {
        return null;
    }

    @Override
    public ResponseEntity<SolicitudDTO> updateByUser(SolicitudDTO put, String token) {
        return null;
    }

    @Override
    public ResponseEntity<SolicitudDTO> deleteByUser(Long erase, String token) {
        return null;
    }
}
