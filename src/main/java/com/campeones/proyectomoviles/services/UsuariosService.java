package com.campeones.proyectomoviles.services;

import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;

public interface UsuariosService {
	ResponseEntity<UsuarioDTO> get();

	ResponseEntity<UsuarioDTO> post(UsuarioDTO usuario);

	ResponseEntity<UsuarioDTO> put(UsuarioDTO usuario);

	ResponseEntity<UsuarioDTO> delete(long id);

}
