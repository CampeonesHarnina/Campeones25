package com.campeones.proyectomoviles.services;

import com.campeones.proyectomoviles.mappers.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;
import com.campeones.proyectomoviles.repositories.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    private UsuarioRepository repository;
    private final UsuarioMapper usuarioMapper;

    @Autowired
    public UsuariosServiceImpl(UsuarioRepository repository,
                               UsuarioMapper usuarioMapper) {
        this.repository = repository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public ResponseEntity<List<UsuarioDTO>> get() {
        return ResponseEntity.ok(repository.findAll().stream()
                .map(usuarioMapper::mapToDTO)
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<UsuarioDTO> post(UsuarioDTO usuario) {
        return null;
    }

    @Override
    public ResponseEntity<UsuarioDTO> put(UsuarioDTO usuario) {
        return null;
    }

    @Override
    public ResponseEntity<UsuarioDTO> delete(long id) {
        return null;
    }
}
