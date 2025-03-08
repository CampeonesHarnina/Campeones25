package com.campeones.proyectomoviles.services;

import java.util.List;
import java.util.stream.Collectors;

import com.campeones.proyectomoviles.services.unimplemented.MovilesService;
import com.campeones.proyectomoviles.utiles.StringValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.campeones.proyectomoviles.mappers.MovilMapper;
import com.campeones.proyectomoviles.model.DTO.MovilDTO;
import com.campeones.proyectomoviles.model.Entities.Movil;
import com.campeones.proyectomoviles.repositories.MovilRepository;

import jakarta.transaction.Transactional;

@Service
public class MovilesServiceImpl implements MovilesService {

	private MovilRepository repository;
	private MovilMapper mapper;
	private StringValidator validator;
	@Autowired
	public MovilesServiceImpl(MovilRepository repository, @Qualifier("movilMapperImpl") MovilMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
		this.validator = new StringValidator();
	}

	@Override
	public ResponseEntity<List<MovilDTO>> get() {
		return ResponseEntity.ok(repository.findAll().stream().map(mapper::mapToDTO).collect(Collectors.toList()));
	}

	@Transactional
	@Override
	public ResponseEntity<MovilDTO> post(MovilDTO movil) {
		if (!validate(movil)){
			return ResponseEntity.badRequest().build();
		}
		Movil save = repository.save(mapper.mapToEntity(movil));
		return ResponseEntity.ok(mapper.mapToDTO(save));
	}

	@Transactional
	@Override
	public ResponseEntity<MovilDTO> put(MovilDTO movil) {
		if (repository.existsById(movil.id())) {
			if (!validate(movil)){
				return ResponseEntity.badRequest().build();
			}
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
		if (spec == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(repository.findAll(spec).stream().map(mapper::mapToDTO).collect(Collectors.toList()));
	}

	private boolean validate(MovilDTO movilDTO){
		if (!validator.isValid(movilDTO.marca())){
			return false;
		}
		if (!validator.isValid(movilDTO.modelo())){
			return false;
		}
		return true;
	}

}
