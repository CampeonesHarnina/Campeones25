package com.campeones.proyectomoviles.services;

import com.campeones.proyectomoviles.model.Entities.Procesador;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.ProcesadorDTO;

import java.util.List;

public interface ProcesadoresService {
    ResponseEntity<ProcesadorDTO> get();

    ResponseEntity<ProcesadorDTO> post(ProcesadorDTO procesador);

    ResponseEntity<ProcesadorDTO> put(ProcesadorDTO procesador);

    ResponseEntity<ProcesadorDTO> delete(long id);

    ResponseEntity<List<ProcesadorDTO>> getByFilter(Specification<Procesador> spec);

}
