package com.campeones.proyectomoviles.services;

import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.ProcesadorDTO;


public interface ProcesadoresService {
	public ResponseEntity<ProcesadorDTO> get();

	public ResponseEntity<ProcesadorDTO> post(ProcesadorDTO procesador);

	public ResponseEntity<ProcesadorDTO> put(ProcesadorDTO procesador);

	public ResponseEntity<ProcesadorDTO> delete(int id);
}
