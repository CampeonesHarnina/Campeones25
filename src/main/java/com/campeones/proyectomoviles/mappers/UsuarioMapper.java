package com.campeones.proyectomoviles.mappers;

import java.util.List;

import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;
import com.campeones.proyectomoviles.model.Entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	@Mapping(target = "password", ignore = true)
	Usuario mapToEntity(UsuarioDTO usuarioDTO);

	UsuarioDTO mapToDTO(Usuario usuario);

	List<UsuarioDTO> mapToDTOList(List<Usuario> usuarios);
}