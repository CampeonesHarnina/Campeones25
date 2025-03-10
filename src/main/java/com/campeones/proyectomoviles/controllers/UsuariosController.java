package com.campeones.proyectomoviles.controllers;

import java.util.List;

import com.campeones.proyectomoviles.controllers.unimplemented.GenericController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;
import com.campeones.proyectomoviles.services.UsuariosServiceImpl;

@CrossOrigin("*")
@RequestMapping("/usuarios")
@RestController
public class UsuariosController implements GenericController<UsuarioDTO, Long> {

	private final UsuariosServiceImpl usuariosService;

	@Autowired
	public UsuariosController(UsuariosServiceImpl usuariosService) {
		this.usuariosService = usuariosService;
	}

	@GetMapping("/find")
	@Override
	public ResponseEntity<List<UsuarioDTO>> get() {
		return usuariosService.get();
	}

	@PostMapping("/register")
	public ResponseEntity<UsuarioDTO> register(@Valid @RequestBody UsuarioDTO usuarioDTO) {
		return usuariosService.register(usuarioDTO);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/new")
	@Override
	public ResponseEntity<UsuarioDTO> post(@Valid @RequestBody UsuarioDTO usuarioDTO) {
		return usuariosService.post(usuarioDTO);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update")
	@Override
	public ResponseEntity<UsuarioDTO> put(@Valid @RequestBody UsuarioDTO usuarioDTO) {
		return usuariosService.put(usuarioDTO);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	@Override
	public ResponseEntity<UsuarioDTO> delete(@PathVariable Long id) {
		return usuariosService.delete(id);
	}

}
