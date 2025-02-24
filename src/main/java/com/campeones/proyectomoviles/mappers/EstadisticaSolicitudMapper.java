package com.campeones.proyectomoviles.mappers;

import org.mapstruct.Mapper;

import com.campeones.proyectomoviles.model.DTOs.EstadisticaSolicitudDTO;
import com.campeones.proyectomoviles.model.entities.EstadisticaSolicitud;

@Mapper(componentModel = "spring")
public interface EstadisticaSolicitudMapper {
	EstadisticaSolicitudDTO mapToDTO(EstadisticaSolicitud estadisticaSolicitud);

	EstadisticaSolicitud mapToEntity(EstadisticaSolicitudDTO estadisticaSolicitudDTO);
}