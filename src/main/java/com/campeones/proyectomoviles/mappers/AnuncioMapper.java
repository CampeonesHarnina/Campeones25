package com.campeones.proyectomoviles.mappers;

import java.util.List;

import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;
import com.campeones.proyectomoviles.model.Entities.Anuncio;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AnuncioMapper {
	AnuncioDTO mapToDTO(Anuncio anuncio);

	Anuncio mapToEntity(AnuncioDTO anuncioDTO);

	List<AnuncioDTO> mapToDTOList(List<Anuncio> anuncios);
}
