package com.campeones.proyectomoviles.controllers;

import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;
import com.campeones.proyectomoviles.model.Entities.Anuncio;
import com.campeones.proyectomoviles.model.filtros.AnuncioFiltro;
import com.campeones.proyectomoviles.model.specifications.AnuncioSpecification;
import com.campeones.proyectomoviles.security.JwtUtils;
import com.campeones.proyectomoviles.services.AnunciosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class AnunciosController implements GenericController<AnuncioDTO, AnuncioFiltro, Long>, UserCrudController<AnuncioDTO, Long> {

    private AnunciosServiceImpl service;

    @Autowired
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
    public ResponseEntity<List<AnuncioDTO>> getByFilter(@RequestBody AnuncioFiltro spec) {
        Specification<Anuncio> specification = Specification.where(null);
        if (spec.getEstado() != null) {
            specification = specification.and(AnuncioSpecification.hasEstado(spec.getEstado()));
        }
        if (spec.getTipoCambio() != null) {
            specification = specification.and(AnuncioSpecification.hasTipoCambio(spec.getTipoCambio()));
        }
        return service.getByFilter(specification);
    }

    @GetMapping("/anuncios/find/user")
    @Override
    public ResponseEntity<List<AnuncioDTO>> getByUser(@RequestHeader("Authorization") String token) {
        return service.getAnunciosUsuario(token);
    }
    @PostMapping("/anuncios/new/user")
    @Override
    public ResponseEntity<AnuncioDTO> addToUser(AnuncioDTO add, @RequestHeader("Authorization") String token) {
        return service.agregarAnuncioUsuario(add,token);
    }
    @PutMapping("/anuncios/update/user")
    @Override
    public ResponseEntity<AnuncioDTO> updateByUser(AnuncioDTO put, @RequestHeader("Authorization") String token) {
        return service.actualizarAnuncioUsuario(put,token);
    }
    @DeleteMapping("/anuncios/delete/{id}/user")
    @Override
    public ResponseEntity<AnuncioDTO> deleteByUser(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        return service.borrarAnuncioUsuario(id,token);
    }
}

