package com.campeones.proyectomoviles.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.campeones.proyectomoviles.model.DTO.MovilDTO;
import com.campeones.proyectomoviles.model.Entities.Movil;

@Mapper(componentModel = "spring")
public interface MovilMapper {
	MovilDTO mapToDTO(Movil movil);

	Movil mapToEntity(MovilDTO movilDTO);

	List<MovilDTO> mapToDTOList(List<Movil> moviles);
}
