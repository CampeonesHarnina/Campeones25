package com.campeones.proyectomoviles.services;

import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;

import java.util.function.Predicate;

public interface UsuariosService {
	public ResponseEntity<UsuarioDTO> get();

	public ResponseEntity<UsuarioDTO> post(UsuarioDTO usuario);

	public ResponseEntity<UsuarioDTO> put(UsuarioDTO usuario);

	public ResponseEntity<UsuarioDTO> delete(long id);

	public ResponseEntity<UsuarioDTO> getByFilter(Predicate<UsuarioDTO> filter);
}
