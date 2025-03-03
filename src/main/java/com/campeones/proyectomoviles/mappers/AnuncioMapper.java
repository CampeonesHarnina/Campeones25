package com.campeones.proyectomoviles.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;
import com.campeones.proyectomoviles.model.Entities.Anuncio;

@Mapper(componentModel = "spring")
public interface AnuncioMapper {
	AnuncioDTO mapToDTO(Anuncio anuncio);

	Anuncio mapToEntity(AnuncioDTO anuncioDTO);

	List<AnuncioDTO> mapToDTOList(List<Anuncio> anuncios);
}
