package com.campeones.proyectomoviles.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.campeones.proyectomoviles.model.DTOs.MovilDTO;
import com.campeones.proyectomoviles.model.entities.Movil;

@Mapper(componentModel = "spring")
public interface MovilMapper {
	MovilDTO mapToDTO(Movil movil);

	Movil mapToEntity(MovilDTO movilDTO);

	List<MovilDTO> mapToDTOList(List<Movil> moviles);
}
