package com.campeones.proyectomoviles.services;

import java.util.List;
import java.util.stream.Collectors;

import com.campeones.proyectomoviles.services.unimplemented.ProcesadoresService;
import com.campeones.proyectomoviles.utiles.StringValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.campeones.proyectomoviles.mappers.ProcesadorMapper;
import com.campeones.proyectomoviles.model.DTO.ProcesadorDTO;
import com.campeones.proyectomoviles.model.Entities.Procesador;
import com.campeones.proyectomoviles.repositories.ProcesadorRepository;

import jakarta.transaction.Transactional;

@Service
public class ProcesadoresServiceImpl implements ProcesadoresService {

	private ProcesadorRepository repository;
	private ProcesadorMapper mapper;
	private StringValidator validator;

	@Autowired
	public ProcesadoresServiceImpl(ProcesadorRepository repository,
			@Qualifier("procesadorMapperImpl") ProcesadorMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
		this.validator = new StringValidator();
	}

	@Override
	public ResponseEntity<List<ProcesadorDTO>> get() {
		return ResponseEntity.ok(repository.findAll().stream().map(mapper::mapToDTO).collect(Collectors.toList()));
	}

	@Transactional
	@Override
	public ResponseEntity<ProcesadorDTO> post(ProcesadorDTO procesador) {
		if (!validator.isValid(procesador.tipo())){
			return ResponseEntity.badRequest().build();
		}
		Procesador save = repository.save(mapper.mapToEntity(procesador));
		return ResponseEntity.ok(mapper.mapToDTO(save));
	}

	@Transactional
	@Override
	public ResponseEntity<ProcesadorDTO> put(ProcesadorDTO procesador) {
		if (repository.existsById(procesador.idProcesador())) {
			if (!validator.isValid(procesador.tipo())){
				return ResponseEntity.badRequest().build();
			}
			repository.save(mapper.mapToEntity(procesador));
			return ResponseEntity.ok(procesador);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Transactional
	@Override
	public ResponseEntity<ProcesadorDTO> delete(long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<List<ProcesadorDTO>> getByFilter(Specification<Procesador> spec) {
		return ResponseEntity.ok(repository.findAll(spec).stream().map(mapper::mapToDTO).collect(Collectors.toList()));
	}


}
