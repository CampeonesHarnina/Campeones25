package com.campeones.proyectomoviles.services;

import com.campeones.proyectomoviles.model.DTO.MovilDTO;
import com.campeones.proyectomoviles.model.Entities.Movil;
import com.campeones.proyectomoviles.repositories.MovilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovilesServiceImpl implements MovilesService {

    @Autowired
    private MovilRepository repository;

    public MovilesServiceImpl(MovilRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<MovilDTO> get() {
        return null;
    }

    @Override
    public ResponseEntity<MovilDTO> post(MovilDTO movil) {
        return null;
    }

    @Override
    public ResponseEntity<MovilDTO> put(MovilDTO movil) {
        return null;
    }

    @Override
    public ResponseEntity<MovilDTO> delete(long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<MovilDTO>> getByFilter(Specification<Movil> spec) {
        return null;
    }

}
