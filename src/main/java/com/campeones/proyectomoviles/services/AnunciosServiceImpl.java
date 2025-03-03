package com.campeones.proyectomoviles.services;

import com.campeones.proyectomoviles.mappers.AnuncioMapper;
import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;
import com.campeones.proyectomoviles.model.Entities.Anuncio;
import com.campeones.proyectomoviles.model.filtros.AnuncioFiltro;
import com.campeones.proyectomoviles.model.specifications.AnuncioSpecification;
import com.campeones.proyectomoviles.repositories.AnuncioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnunciosServiceImpl implements AnunciosService {

    private final AnuncioRepository repository;
    private final AnuncioMapper mapper;

    @Autowired
    public AnunciosServiceImpl(AnuncioRepository repository, @Qualifier("anuncioMapperImpl") AnuncioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<List<AnuncioDTO>> get() {
        return ResponseEntity.ok(repository.findAll().stream()
                .map(mapper::mapToDTO)
                .toList());
    }

    @Transactional
    @Override
    public ResponseEntity<AnuncioDTO> post(AnuncioDTO anuncio) {
        Anuncio entity = mapper.mapToEntity(anuncio);
        entity.setId(null);
        Anuncio save = repository.save(entity);
        return ResponseEntity.ok(mapper.mapToDTO(save));
    }

    @Transactional
    @Override
    public ResponseEntity<AnuncioDTO> put(AnuncioDTO anuncio) {
        if (repository.existsById(anuncio.id())) {
            Anuncio save = repository.save(mapper.mapToEntity(anuncio));
            return ResponseEntity.ok(mapper.mapToDTO(save));
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    @Override
    public ResponseEntity<AnuncioDTO> delete(long id) {
        if (repository.existsById(id)) {
            Anuncio anuncio = repository.findById(id).get();
            repository.delete(anuncio);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<AnuncioDTO>> getAnunciosUsuario(long id) {
        return getByFilter(AnuncioSpecification.hasUsuarioId(id));
    }

    @Override
    public ResponseEntity<List<AnuncioDTO>> getByFilter(Specification<Anuncio> spec) {
        return ResponseEntity.ok(repository.findAll(spec).stream().map(mapper::mapToDTO).toList());
    }

}
