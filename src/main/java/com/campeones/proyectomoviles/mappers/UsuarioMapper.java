package com.campeones.proyectomoviles.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;
import com.campeones.proyectomoviles.model.Entities.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	@Mapping(target = "password", ignore = true)
	Usuario mapToEntity(UsuarioDTO usuarioDTO);

	UsuarioDTO mapToDTO(Usuario usuario);

	List<UsuarioDTO> mapToDTOList(List<Usuario> usuarios);
}