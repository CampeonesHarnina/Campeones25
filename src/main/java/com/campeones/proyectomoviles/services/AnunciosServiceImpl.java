package com.campeones.proyectomoviles.services;

import java.util.List;
import java.util.Optional;

import com.campeones.proyectomoviles.services.unimplemented.AnunciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.campeones.proyectomoviles.mappers.AnuncioMapper;
import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;
import com.campeones.proyectomoviles.model.Entities.Anuncio;
import com.campeones.proyectomoviles.model.Entities.Usuario;
import com.campeones.proyectomoviles.model.specifications.AnuncioSpecification;
import com.campeones.proyectomoviles.repositories.AnuncioRepository;
import com.campeones.proyectomoviles.repositories.UsuarioRepository;
import com.campeones.proyectomoviles.security.JwtUtils;

import jakarta.transaction.Transactional;

@Service
public class AnunciosServiceImpl implements AnunciosService {

    private final AnuncioRepository repository;
    private final AnuncioMapper mapper;
    private final UsuarioRepository usuarioRepository;
    private JwtUtils jwtUtils;

    @Autowired
    public AnunciosServiceImpl(UsuarioRepository usuarioRepository,
                               @Qualifier("anuncioMapperImpl") AnuncioMapper mapper, AnuncioRepository repository, JwtUtils jwtUtils) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
        this.repository = repository;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public ResponseEntity<List<AnuncioDTO>> get() {
        return ResponseEntity.ok(repository.findAll().stream().map(mapper::mapToDTO).toList());
    }

    @Transactional
    @Override
    public ResponseEntity<AnuncioDTO> post(AnuncioDTO anuncio) {
        Anuncio entity = mapper.mapToEntity(anuncio);
        entity.setId(null);
        Anuncio save = repository.save(entity);

        return ResponseEntity.ok(mapper.mapToDTO(save));
    }

    @Transactional
    @Override
    public ResponseEntity<AnuncioDTO> put(AnuncioDTO anuncio) {
        if (repository.existsById(anuncio.id())) {
            Anuncio save = repository.save(mapper.mapToEntity(anuncio));
            return ResponseEntity.ok(mapper.mapToDTO(save));
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    @Override
    public ResponseEntity<AnuncioDTO> delete(long id) {
        if (repository.existsById(id)) {
            Anuncio anuncio = repository.findById(id).get();
            repository.delete(anuncio);
            return ResponseEntity.ok(mapper.mapToDTO(anuncio));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<AnuncioDTO>> getByFilter(Specification<Anuncio> spec) {
        return ResponseEntity.ok(repository.findAll(spec).stream().map(mapper::mapToDTO).toList());
    }

    @Override
    public ResponseEntity<List<AnuncioDTO>> getAnunciosUsuario(String token) {
        String newToken = token.replace("Bearer ", "").strip();
        String emailFromToken = jwtUtils.getEmailFromToken(newToken);
        Usuario usuario = usuarioRepository.findByEmail(emailFromToken).get();
        return getByFilter(AnuncioSpecification.hasUsuarioId(usuario.getId()));
    }

    @Transactional
    @Override
    public ResponseEntity<AnuncioDTO> agregarAnuncioUsuario(AnuncioDTO add, String token) {
        String newToken = token.replace("Bearer ", "").strip();
        String emailFromToken = jwtUtils.getEmailFromToken(newToken);
        Usuario usuario = usuarioRepository.findByEmail(emailFromToken).get();
        Anuncio anuncio = mapper.mapToEntity(add);
        anuncio.setId(null);
        anuncio.setUsuario(usuario);
        Anuncio save = repository.save(anuncio);
        return ResponseEntity.ok(mapper.mapToDTO(save));
    }

    @Transactional
    @Override
    public ResponseEntity<AnuncioDTO> borrarAnuncioUsuario(Long id, String token) {
        String newToken = token.replace("Bearer ", "").strip();
        String emailFromToken = jwtUtils.getEmailFromToken(newToken);
        Usuario usuario = usuarioRepository.findByEmail(emailFromToken).get();
        if (!repository.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        Anuncio anuncio = repository.findById(id).get();
        if (!anuncio.getUsuario().equals(usuario)) {
            return ResponseEntity.badRequest().build();
        }

        repository.delete(anuncio);
        repository.flush();
        return ResponseEntity.ok(mapper.mapToDTO(anuncio));
    }

    @Override
    public ResponseEntity<AnuncioDTO> actualizarAnuncioUsuario(AnuncioDTO put, String token) {
        String newToken = token.replace("Bearer ", "").strip();
        String emailFromToken = jwtUtils.getEmailFromToken(newToken);
        Usuario usuario = usuarioRepository.findByEmail(emailFromToken).get();
        if (!repository.existsById(put.id())) {
            return ResponseEntity.badRequest().build();
        }
        Anuncio anuncio = repository.findById(put.id()).get();
        if (!anuncio.getUsuario().equals(usuario)) {
            return ResponseEntity.badRequest().build();
        }
        Anuncio save = repository.save(mapper.mapToEntity(put));
        return ResponseEntity.ok(mapper.mapToDTO(save));
    }


}
