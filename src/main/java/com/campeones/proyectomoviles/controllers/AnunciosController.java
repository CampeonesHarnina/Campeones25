package com.campeones.proyectomoviles.controllers;

import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;
import com.campeones.proyectomoviles.model.Entities.Anuncio;
import com.campeones.proyectomoviles.model.filtros.AnuncioFiltro;
import com.campeones.proyectomoviles.model.specifications.AnuncioSpecification;
import com.campeones.proyectomoviles.services.AnunciosServiceImpl;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class AnunciosController implements GenericController<AnuncioDTO, AnuncioFiltro, Long>, UserCrudController<AnuncioDTO, Long> {

    private AnunciosServiceImpl service;

    public AnunciosController(AnunciosServiceImpl service) {
        this.service = service;
    }


    @GetMapping("/anuncios/find")
    @Override
    public ResponseEntity<List<AnuncioDTO>> get() {
        return service.get();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/anuncios/new")
    @Override
    public ResponseEntity<AnuncioDTO> post(@RequestBody AnuncioDTO anuncioDTO) {
        return service.post(anuncioDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/anuncios/update")
    @Override
    public ResponseEntity<AnuncioDTO> put(@RequestBody AnuncioDTO anuncioDTO) {
        return service.put(anuncioDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/anuncios/delete/{id}")
    @Override
    public ResponseEntity<AnuncioDTO> delete(@RequestParam Long id) {
        return service.delete(id);
    }

    @GetMapping("/anuncios/filter")
    @Override
    public ResponseEntity<List<AnuncioDTO>> getByFilter(AnuncioFiltro spec) {
        Specification<Anuncio> specification = Specification.where(null);
        if (spec.getEstado() != null) {
            specification = specification.and(AnuncioSpecification.hasEstado(spec.getEstado()));
        }
        if (spec.getTipoCambio() != null) {
            specification = specification.and(AnuncioSpecification.hasTipoCambio(spec.getTipoCambio()));
        }

        if (spec.getUsuarioId() != null) {
            specification = specification.and(AnuncioSpecification.hasUsuarioId(spec.getUsuarioId()));
        }

        return service.getByFilter(specification);
    }


    @PostMapping("/anuncios/new/user/{id}")
    @Override
    public ResponseEntity<AnuncioDTO> addToUser(AnuncioDTO add, Long id) {
        return null;
    }

    @PutMapping("/anuncios/update/user/{id}")
    @Override
    public ResponseEntity<AnuncioDTO> updateByUser(AnuncioDTO put, Long id) {
        return null;
    }

    @DeleteMapping("/anuncios/delete/user/{id}")
    @Override
    public ResponseEntity<AnuncioDTO> deleteByUser(AnuncioDTO erase, Long id) {
        return null;
    }
}

