package com.campeones.proyectomoviles.services;

import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;

import java.util.function.Predicate;

public interface UsuariosService {
	ResponseEntity<UsuarioDTO> get();
	ResponseEntity<UsuarioDTO> post(UsuarioDTO usuario);
	ResponseEntity<UsuarioDTO> put(UsuarioDTO usuario);
	ResponseEntity<UsuarioDTO> delete(long id);
	ResponseEntity<UsuarioDTO> getByFilter(Predicate<UsuarioDTO> filter);
}
