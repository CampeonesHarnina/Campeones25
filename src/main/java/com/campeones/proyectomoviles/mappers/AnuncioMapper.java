package com.campeones.proyectomoviles.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.campeones.proyectomoviles.model.DTOs.AnuncioDTO;
import com.campeones.proyectomoviles.model.entities.Anuncio;

@Mapper(componentModel = "spring")
public interface AnuncioMapper {
	AnuncioDTO mapToDTO(Anuncio anuncio);

	Anuncio mapToEntity(AnuncioDTO anuncioDTO);

	List<AnuncioDTO> mapToDTOList(List<Anuncio> anuncios);
}
