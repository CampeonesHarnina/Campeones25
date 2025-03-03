package com.campeones.proyectomoviles.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.MovilDTO;
import com.campeones.proyectomoviles.model.filtros.MovilFiltro;

public class MovilesController implements GenericController<MovilDTO, MovilFiltro, Long> {
	@Override
	public ResponseEntity<List<MovilDTO>> get() {
		return null;
	}

	@Override
	public ResponseEntity<MovilDTO> post(MovilDTO movilDTO) {
		return null;
	}

	@Override
	public ResponseEntity<MovilDTO> put(MovilDTO movilDTO) {
		return null;
	}

	@Override
	public ResponseEntity<MovilDTO> delete(Long id) {
		return null;
	}

	@Override
	public ResponseEntity<List<MovilDTO>> getByFilter(MovilFiltro spec) {
		return null;
	}
}
