package com.campeones.proyectomoviles.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.campeones.proyectomoviles.model.DTO.ProcesadorDTO;
import com.campeones.proyectomoviles.model.Entities.Procesador;

//@Mapper(componentModel = "spring")
//public interface ProcesadorMapper {
//	ProcesadorDTO mapToDTO(Procesador procesador);
//
//	Procesador mapToEntity(ProcesadorDTO procesadorDTO);
//
//	List<ProcesadorDTO> mapToDTOList(List<Procesador> procesadores);
//}

@Mapper(componentModel = "spring")
public interface ProcesadorMapper {
	@Mapping(source = "id", target = "idProcesador")
	ProcesadorDTO mapToDTO(Procesador procesador);

	@Mapping(source = "idProcesador", target = "id")
	Procesador mapToEntity(ProcesadorDTO procesadorDTO);

	List<ProcesadorDTO> mapToDTOList(List<Procesador> procesadores);
}