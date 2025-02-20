package com.campeones.proyectomoviles.services;

import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;

public interface UsuariosService {
	public ResponseEntity<UsuarioDTO> get();

	public ResponseEntity<UsuarioDTO> post(UsuarioDTO usuario);

	public ResponseEntity<UsuarioDTO> put(UsuarioDTO usuario);

	public ResponseEntity<UsuarioDTO> delete(int id);
}
