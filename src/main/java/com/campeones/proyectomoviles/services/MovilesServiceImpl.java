package com.campeones.proyectomoviles.services;

import java.util.List;
import java.util.stream.Collectors;

import com.campeones.proyectomoviles.mappers.MovilMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.campeones.proyectomoviles.model.DTO.MovilDTO;
import com.campeones.proyectomoviles.model.Entities.Movil;
import com.campeones.proyectomoviles.repositories.MovilRepository;

@Service
public class MovilesServiceImpl implements MovilesService {

    private MovilRepository repository;
    private MovilMapper mapper;

    @Autowired
    public MovilesServiceImpl(MovilRepository repository, @Qualifier("movilMapperImpl") MovilMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<List<MovilDTO>> get() {
        return ResponseEntity.ok(repository.findAll().stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList()));
    }

    @Transactional
    @Override
    public ResponseEntity<MovilDTO> post(MovilDTO movil) {
        Movil save = repository.save(mapper.mapToEntity(movil));
        return ResponseEntity.ok(mapper.mapToDTO(save));
    }
	
    @Transactional
    @Override
    public ResponseEntity<MovilDTO> put(MovilDTO movil) {
        if (repository.existsById(movil.id())) {
            repository.save(mapper.mapToEntity(movil));
            return ResponseEntity.ok(movil);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @Override
    public ResponseEntity<MovilDTO> delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<MovilDTO>> getByFilter(Specification<Movil> spec) {
        return ResponseEntity.ok(repository.findAll(spec).stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList()));
    }

}
