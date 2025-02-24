package com.campeones.proyectomoviles.mappers;

import com.campeones.proyectomoviles.model.DTO.EstadisticaSolicitudDTO;
import com.campeones.proyectomoviles.model.Entities.EstadisticaSolicitud;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EstadisticaSolicitudMapper {
	EstadisticaSolicitudDTO mapToDTO(EstadisticaSolicitud estadisticaSolicitud);

	EstadisticaSolicitud mapToEntity(EstadisticaSolicitudDTO estadisticaSolicitudDTO);
}