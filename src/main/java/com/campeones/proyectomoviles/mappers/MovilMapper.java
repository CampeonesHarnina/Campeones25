package com.campeones.proyectomoviles.mappers;

import java.util.List;

import com.campeones.proyectomoviles.model.DTO.MovilDTO;
import com.campeones.proyectomoviles.model.Entities.Movil;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MovilMapper {
	MovilDTO mapToDTO(Movil movil);

	Movil mapToEntity(MovilDTO movilDTO);

	List<MovilDTO> mapToDTOList(List<Movil> moviles);
}
