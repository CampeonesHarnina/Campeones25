package com.campeones.proyectomoviles.services;

import com.campeones.proyectomoviles.mappers.UsuarioMapper;
import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;
import com.campeones.proyectomoviles.repositories.AnuncioRepository;
import com.campeones.proyectomoviles.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    private UsuarioRepository repository;

    @Autowired
    public UsuariosServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<UsuarioDTO> get() {
        return null;
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
