package com.campeones.proyectomoviles.services;

import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;

import java.util.List;

public interface UsuariosService {
	ResponseEntity<List<UsuarioDTO>> get();

	ResponseEntity<UsuarioDTO> post(UsuarioDTO usuario);

	ResponseEntity<UsuarioDTO> put(UsuarioDTO usuario);

	ResponseEntity<UsuarioDTO> delete(long id);

}
