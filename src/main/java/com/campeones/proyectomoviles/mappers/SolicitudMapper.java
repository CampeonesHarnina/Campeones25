package com.campeones.proyectomoviles.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.campeones.proyectomoviles.model.DTO.SolicitudDTO;
import com.campeones.proyectomoviles.model.Entities.Solicitud;

@Mapper(componentModel = "spring")
public interface SolicitudMapper {
	SolicitudDTO mapToDTO(Solicitud solicitud);

	Solicitud mapToEntity(SolicitudDTO solicitudDTO);

	List<SolicitudDTO> mapToDTOList(List<Solicitud> solicitudes);
}
