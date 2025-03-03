package com.campeones.proyectomoviles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.campeones.proyectomoviles.model.DTO.ProcesadorDTO;
import com.campeones.proyectomoviles.model.Entities.Procesador;
import com.campeones.proyectomoviles.repositories.ProcesadorRepository;

@Service
public class ProcesadoresServiceImpl implements ProcesadoresService {

	private ProcesadorRepository repository;

	@Autowired
	public ProcesadoresServiceImpl(ProcesadorRepository repository) {
		this.repository = repository;
	}

	@Override
	public ResponseEntity<ProcesadorDTO> get() {
		return null;
	}

	@Override
	public ResponseEntity<ProcesadorDTO> post(ProcesadorDTO procesador) {
		return null;
	}

	@Override
	public ResponseEntity<ProcesadorDTO> put(ProcesadorDTO procesador) {
		return null;
	}

	@Override
	public ResponseEntity<ProcesadorDTO> delete(long id) {
		return null;
	}

	@Override
	public ResponseEntity<List<ProcesadorDTO>> getByFilter(Specification<Procesador> spec) {
		return null;
	}

}
