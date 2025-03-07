package com.campeones.proyectomoviles.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.campeones.proyectomoviles.controllers.GenericController;
import com.campeones.proyectomoviles.mappers.UsuarioMapper;
import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;
import com.campeones.proyectomoviles.model.Entities.Usuario;
import com.campeones.proyectomoviles.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuariosServiceImpl implements GenericController<UsuarioDTO, Void, Long> {

	private final UsuarioRepository repository;
	private final UsuarioMapper mapper;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UsuariosServiceImpl(UsuarioRepository repository, UsuarioMapper mapper, PasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.mapper = mapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public ResponseEntity<List<UsuarioDTO>> get() {
		return ResponseEntity.ok(repository.findAll().stream().map(mapper::mapToDTO).collect(Collectors.toList()));
	}

	@Transactional
	@Override
	public ResponseEntity<UsuarioDTO> post(UsuarioDTO usuarioDTO) {
		// Mapear DTO a entidad
		Usuario usuario = mapper.mapToEntity(usuarioDTO);
		// Encriptar la contraseña
		usuario.setPassword(passwordEncoder.encode(usuarioDTO.password()));
		// Inicializar listas para evitar problemas con JPA
		usuario.setAnuncios(new ArrayList<>());
		usuario.setSolicitudesEnviadas(new ArrayList<>());
		// Guardar en la base de datos
		Usuario savedUsuario = repository.save(usuario);
		return ResponseEntity.status(201).body(mapper.mapToDTO(savedUsuario));
	}

	@Transactional
	@Override
	public ResponseEntity<UsuarioDTO> put(UsuarioDTO usuarioDTO) {
		if (repository.existsById(usuarioDTO.id())) {
			// Mapear DTO a entidad
			Usuario usuario = mapper.mapToEntity(usuarioDTO);
			// Encriptar la contraseña si se proporciona una nueva
			usuario.setPassword(passwordEncoder.encode(usuarioDTO.password()));
			// Conservar las listas existentes (anuncios y solicitudes)
			Usuario existingUsuario = repository.findById(usuarioDTO.id()).get();
			usuario.setAnuncios(existingUsuario.getAnuncios());
			usuario.setSolicitudesEnviadas(existingUsuario.getSolicitudesEnviadas());
			// Guardar los cambios
			repository.save(usuario);
			return ResponseEntity.ok(mapper.mapToDTO(usuario));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Transactional
	@Override
	public ResponseEntity<UsuarioDTO> delete(Long id) {
		if (repository.existsById(id)) {
			Usuario usuario = repository.findById(id).get();
			repository.deleteById(id);
			return ResponseEntity.ok(mapper.mapToDTO(usuario));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<List<UsuarioDTO>> getByFilter(Void spec) {
		// No hay especificación de filtro por ahora, devolver todos los usuarios
		return ResponseEntity.ok(repository.findAll().stream().map(mapper::mapToDTO).collect(Collectors.toList()));
	}
}