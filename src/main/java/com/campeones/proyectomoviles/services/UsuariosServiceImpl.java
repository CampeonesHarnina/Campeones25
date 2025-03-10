package com.campeones.proyectomoviles.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.campeones.proyectomoviles.mappers.UsuarioMapper;
import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;
import com.campeones.proyectomoviles.model.Entities.Usuario;
import com.campeones.proyectomoviles.repositories.UsuarioRepository;
import com.campeones.proyectomoviles.services.unimplemented.UsuariosService;

import jakarta.transaction.Transactional;

@Service
public class UsuariosServiceImpl implements UsuariosService {

	private final UsuarioRepository repository;
	private final UsuarioMapper mapper;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UsuariosServiceImpl(UsuarioRepository repository, @Qualifier("usuarioMapperImpl") UsuarioMapper mapper,
			PasswordEncoder passwordEncoder) {
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
		Usuario usuario = mapper.mapToEntity(usuarioDTO);
		usuario.setPassword(passwordEncoder.encode(usuarioDTO.password()));
		usuario.setAnuncios(new ArrayList<>());
		usuario.setSolicitudesEnviadas(new ArrayList<>());
		Usuario savedUsuario = repository.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(mapper.mapToDTO(savedUsuario));
	}

	@Transactional
	@Override
	public ResponseEntity<UsuarioDTO> put(UsuarioDTO usuarioDTO) {
		if (repository.existsById(usuarioDTO.id())) {
			Usuario usuario = mapper.mapToEntity(usuarioDTO);
			usuario.setPassword(passwordEncoder.encode(usuarioDTO.password()));
			Usuario existingUsuario = repository.findById(usuarioDTO.id()).get();
			usuario.setAnuncios(existingUsuario.getAnuncios());
			usuario.setSolicitudesEnviadas(existingUsuario.getSolicitudesEnviadas());
			repository.save(usuario);
			return ResponseEntity.ok(mapper.mapToDTO(usuario));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Transactional
	@Override
	public ResponseEntity<UsuarioDTO> delete(long id) {
		if (repository.existsById(id)) {
			Usuario usuario = repository.findById(id).get();
			repository.deleteById(id);
			return ResponseEntity.ok(mapper.mapToDTO(usuario));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	public ResponseEntity<UsuarioDTO> register(UsuarioDTO usuarioDTO) {
		String encryptedPassword = passwordEncoder.encode(usuarioDTO.password());
		Usuario usuario = mapper.mapToEntity(usuarioDTO);
		usuario.setPassword(encryptedPassword);
		usuario.setAnuncios(new ArrayList<>());
		usuario.setSolicitudesEnviadas(new ArrayList<>());
		Usuario savedUsuario = repository.save(usuario);
		UsuarioDTO savedUsuarioDTO = mapper.mapToDTO(savedUsuario);
		return ResponseEntity.status(201).body(savedUsuarioDTO);
	}
}
