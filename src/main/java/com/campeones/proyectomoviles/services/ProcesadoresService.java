package com.campeones.proyectomoviles.services;

import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.ProcesadorDTO;

import java.util.function.Predicate;


public interface ProcesadoresService {
	ResponseEntity<ProcesadorDTO> get();
	ResponseEntity<ProcesadorDTO> post(ProcesadorDTO procesador);
	ResponseEntity<ProcesadorDTO> put(ProcesadorDTO procesador);
	ResponseEntity<ProcesadorDTO> delete(long id);
	ResponseEntity<ProcesadorDTO> getByFilter(Predicate<ProcesadorDTO> filter);
}
