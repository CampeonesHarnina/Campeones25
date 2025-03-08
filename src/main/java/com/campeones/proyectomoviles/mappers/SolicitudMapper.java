package com.campeones.proyectomoviles.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.campeones.proyectomoviles.model.DTO.SolicitudDTO;
import com.campeones.proyectomoviles.model.Entities.Solicitud;

@Mapper(componentModel = "spring")
public interface SolicitudMapper {
    @Mapping(source = "remitente.id", target = "remitenteId")
    @Mapping(source = "anuncio.id", target = "anuncioId")
    SolicitudDTO mapToDTO(Solicitud solicitud);

    Solicitud mapToEntity(SolicitudDTO solicitudDTO);

    List<SolicitudDTO> mapToDTOList(List<Solicitud> solicitudes);
}