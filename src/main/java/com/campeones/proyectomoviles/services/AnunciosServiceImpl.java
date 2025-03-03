package com.campeones.proyectomoviles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.campeones.proyectomoviles.mappers.AnuncioMapper;
import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;
import com.campeones.proyectomoviles.model.Entities.Anuncio;
import com.campeones.proyectomoviles.repositories.AnuncioRepository;

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
		return null;
	}

	@Override
	public ResponseEntity<AnuncioDTO> post(AnuncioDTO anuncio) {
		return null;
	}

	@Override
	public ResponseEntity<AnuncioDTO> put(AnuncioDTO anuncio) {
		return null;
	}

	@Override
	public ResponseEntity<AnuncioDTO> delete(long id) {
		return null;
	}

	@Override
	public ResponseEntity<AnuncioDTO> deleteAnuncioUsuario(long id) {
		return null;
	}

	@Override
	public ResponseEntity<List<AnuncioDTO>> getByFilter(Specification<Anuncio> spec) {
		return ResponseEntity.ok(repository.findAll(spec).stream().map(mapper::mapToDTO).toList());
	}

}
