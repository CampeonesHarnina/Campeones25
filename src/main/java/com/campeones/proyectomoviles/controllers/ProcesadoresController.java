package com.campeones.proyectomoviles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.ProcesadorDTO;
import com.campeones.proyectomoviles.model.Entities.Procesador;
import com.campeones.proyectomoviles.model.filtros.ProcesadorFiltro;
import com.campeones.proyectomoviles.model.specifications.ProcesadorSpecification;
import com.campeones.proyectomoviles.services.ProcesadoresServiceImpl;

public class ProcesadoresController implements GenericController<ProcesadorDTO, ProcesadorFiltro, Long> {
	private final ProcesadoresServiceImpl procesadoresService;
	
	@Autowired 
	public ProcesadoresController(ProcesadoresServiceImpl procesadoresService){
		this.procesadoresService = procesadoresService;
	}
	
	
	@Override
	public ResponseEntity<List<ProcesadorDTO>> get() {
		return procesadoresService.get();
	}

	@Override
	public ResponseEntity<ProcesadorDTO> post(ProcesadorDTO procesadorDTO) {
		return procesadoresService.post(procesadorDTO);
	}

	@Override
	public ResponseEntity<ProcesadorDTO> put(ProcesadorDTO procesadorDTO) {
		return procesadoresService.put(procesadorDTO);
	}

	@Override
	public ResponseEntity<ProcesadorDTO> delete(Long id) {
		return procesadoresService.delete(id);
	}

	@Override
	public ResponseEntity<List<ProcesadorDTO>> getByFilter(ProcesadorFiltro spec) {
		Specification<Procesador> specification = Specification.where(null);

	    if (spec.getTipo() != null) {
	        specification = specification.and(ProcesadorSpecification.hasTipo(spec.getTipo()));
	    }
	    if (spec.getNucleo() != null) {  
	        specification = specification.and(ProcesadorSpecification.hasNucleo(spec.getNucleo()));
	    }
	    if (spec.getVelocidadMaxima()  != null) {  
	        specification = specification.and(ProcesadorSpecification.hasVelocidadMaxima(spec.getVelocidadMaxima()));
	    }

	    return procesadoresService.getByFilter(specification);
	}
}
