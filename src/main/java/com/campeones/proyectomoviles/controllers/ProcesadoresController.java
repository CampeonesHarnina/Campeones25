package com.campeones.proyectomoviles.controllers;

import com.campeones.proyectomoviles.model.DTO.ProcesadorDTO;
import com.campeones.proyectomoviles.model.filtros.ProcesadorFiltro;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ProcesadoresController implements GenericController<ProcesadorDTO, ProcesadorFiltro, Long> {
    @Override
    public ResponseEntity<List<ProcesadorDTO>> get() {
        return null;
    }

    @Override
    public ResponseEntity<ProcesadorDTO> post(ProcesadorDTO procesadorDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ProcesadorDTO> put(ProcesadorDTO procesadorDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ProcesadorDTO> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProcesadorDTO>> getByFilter(ProcesadorFiltro spec) {
        return null;
    }
}
