package com.campeones.proyectomoviles.mappers;

import org.mapstruct.Mapper;

import com.campeones.proyectomoviles.model.DTO.EstadisticaSolicitudDTO;
import com.campeones.proyectomoviles.model.Entities.EstadisticaSolicitud;

@Mapper(componentModel = "spring")
public interface EstadisticaSolicitudMapper {
	EstadisticaSolicitudDTO mapToDTO(EstadisticaSolicitud estadisticaSolicitud);

	EstadisticaSolicitud mapToEntity(EstadisticaSolicitudDTO estadisticaSolicitudDTO);
}