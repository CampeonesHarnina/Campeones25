package com.campeones.proyectomoviles.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.campeones.proyectomoviles.model.DTOs.SolicitudDTO;
import com.campeones.proyectomoviles.model.entities.Solicitud;

@Mapper(componentModel = "spring")
public interface SolicitudMapper {
	SolicitudDTO mapToDTO(Solicitud solicitud);

	Solicitud mapToEntity(SolicitudDTO solicitudDTO);

	List<SolicitudDTO> mapToDTOList(List<Solicitud> solicitudes);
}
