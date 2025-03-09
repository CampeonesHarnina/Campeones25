package com.campeones.proyectomoviles.services.unimplemented;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;

public interface UsuariosService {
	ResponseEntity<List<UsuarioDTO>> get();

	ResponseEntity<UsuarioDTO> post(UsuarioDTO usuario);

	ResponseEntity<UsuarioDTO> put(UsuarioDTO usuario);

	ResponseEntity<UsuarioDTO> delete(long id);

}
