package com.campeones.proyectomoviles.controllers;

import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;
import com.campeones.proyectomoviles.model.Entities.Anuncio;
import com.campeones.proyectomoviles.model.filtros.AnuncioFiltro;
import com.campeones.proyectomoviles.model.specifications.AnuncioSpecification;
import com.campeones.proyectomoviles.services.AnunciosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnunciosController implements GenericController<AnuncioDTO, AnuncioFiltro, Long> {

    private AnunciosServiceImpl service;

    public AnunciosController(AnunciosServiceImpl service) {
        this.service = service;
    }


    @GetMapping("/anuncios")
    @Override
    public ResponseEntity<List<AnuncioDTO>> get() {
        return service.get();
    }

    @Override
    public ResponseEntity<AnuncioDTO> post(AnuncioDTO anuncioDTO) {
        return service.post(anuncioDTO);
    }

    @Override
    public ResponseEntity<AnuncioDTO> put(AnuncioDTO anuncioDTO) {
        return service.put(anuncioDTO);
    }

    @Override
    public ResponseEntity<AnuncioDTO> delete(Long id) {
        return null;
    }

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


}

