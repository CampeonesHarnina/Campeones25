package com.campeones.proyectomoviles.mappers;

import java.util.List;

import com.campeones.proyectomoviles.model.DTO.ProcesadorDTO;
import com.campeones.proyectomoviles.model.Entities.Procesador;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProcesadorMapper {
	ProcesadorDTO mapToDTO(Procesador procesador);

	Procesador mapToEntity(ProcesadorDTO procesadorDTO);

	List<ProcesadorDTO> mapToDTOList(List<Procesador> procesadores);
}