package com.campeones.proyectomoviles.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.campeones.proyectomoviles.model.DTOs.ProcesadorDTO;
import com.campeones.proyectomoviles.model.entities.Procesador;

@Mapper(componentModel = "spring")
public interface ProcesadorMapper {
	ProcesadorDTO mapToDTO(Procesador procesador);

	Procesador mapToEntity(ProcesadorDTO procesadorDTO);

	List<ProcesadorDTO> mapToDTOList(List<Procesador> procesadores);
}