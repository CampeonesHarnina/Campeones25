package com.campeones.proyectomoviles.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.campeones.proyectomoviles.services.unimplemented.SolicitudesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campeones.proyectomoviles.mappers.SolicitudMapper;
import com.campeones.proyectomoviles.model.DTO.SolicitudDTO;
import com.campeones.proyectomoviles.model.Entities.Anuncio;
import com.campeones.proyectomoviles.model.Entities.Solicitud;
import com.campeones.proyectomoviles.model.Entities.Usuario;
import com.campeones.proyectomoviles.model.specifications.AnuncioSpecification;
import com.campeones.proyectomoviles.model.specifications.SolicitudSpecification;
import com.campeones.proyectomoviles.repositories.AnuncioRepository;
import com.campeones.proyectomoviles.repositories.SolicitudRepository;
import com.campeones.proyectomoviles.repositories.UsuarioRepository;
import com.campeones.proyectomoviles.security.JwtUtils;

@Service
public class SolicitudesServiceImpl implements SolicitudesService {

    private final SolicitudRepository solicitudRepository;
    private final SolicitudMapper solicitudMapper;
    private final UsuarioRepository usuarioRepository;
    private final AnuncioRepository anuncioRepository;
    private final JwtUtils jwtUtils;

    @Autowired
    public SolicitudesServiceImpl(SolicitudRepository solicitudRepository, SolicitudMapper solicitudMapper,
                                  UsuarioRepository usuarioRepository, AnuncioRepository anuncioRepository, JwtUtils jwtUtils) {
        this.solicitudRepository = solicitudRepository;
        this.solicitudMapper = solicitudMapper;
        this.usuarioRepository = usuarioRepository;
        this.anuncioRepository = anuncioRepository;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public ResponseEntity<List<SolicitudDTO>> get() {
        return ResponseEntity
                .ok(solicitudRepository.findAll().stream().map(solicitudMapper::mapToDTO).collect(Collectors.toList()));
    }

    @Transactional
    @Override
    public ResponseEntity<SolicitudDTO> post(SolicitudDTO solicitudDTO) {
        Solicitud solicitud = new Solicitud();
        // Mapear solo los campos simples
        solicitud.setFechaSolicitud(solicitudDTO.fechaSolicitud());
        solicitud.setContestada(solicitudDTO.contestada());
        // Reutilizar entidades existentes para evitar duplicados
        Usuario remitente = usuarioRepository.findById(solicitudDTO.remitente().id())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Anuncio anuncio = anuncioRepository.findById(solicitudDTO.anuncio().id())
                .orElseThrow(() -> new RuntimeException("Anuncio no encontrado"));
        solicitud.setRemitente(remitente);
        solicitud.setAnuncio(anuncio);

        Solicitud saved = solicitudRepository.save(solicitud);
        return ResponseEntity.ok(solicitudMapper.mapToDTO(saved));
    }

    @Transactional
    @Override
    public ResponseEntity<SolicitudDTO> put(SolicitudDTO solicitudDTO) {
        if (solicitudRepository.existsById(solicitudDTO.id())) {
            Solicitud solicitud = solicitudRepository.findById(solicitudDTO.id())
                    .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
            solicitud.setFechaSolicitud(solicitudDTO.fechaSolicitud());
            solicitud.setContestada(solicitudDTO.contestada());
            Usuario remitente = usuarioRepository.findById(solicitudDTO.remitente().id())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            Anuncio anuncio = anuncioRepository.findById(solicitudDTO.anuncio().id())
                    .orElseThrow(() -> new RuntimeException("Anuncio no encontrado"));
            solicitud.setRemitente(remitente);
            solicitud.setAnuncio(anuncio);

            Solicitud updated = solicitudRepository.save(solicitud);
            return ResponseEntity.ok(solicitudMapper.mapToDTO(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @Override
    public ResponseEntity<SolicitudDTO> delete(long id) {
        if (solicitudRepository.existsById(id)) {
            solicitudRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<SolicitudDTO>> getByFilter(Specification<Solicitud> spec) {
        return ResponseEntity.ok(
                solicitudRepository.findAll(spec).stream().map(solicitudMapper::mapToDTO).collect(Collectors.toList()));
    }

    public ResponseEntity<List<SolicitudDTO>> getByUser(String token) {
        String newToken = token.replace("Bearer ", "").strip();
        String emailFromToken = jwtUtils.getEmailFromToken(newToken);
        Usuario usuario = usuarioRepository.findByEmail(emailFromToken).get();
        List<Anuncio> anunciosUser = anuncioRepository.findAll(AnuncioSpecification.hasUsuarioId(usuario.getId()))
                .stream().toList();
        return ResponseEntity.ok(solicitudRepository.findAll().stream()
                .filter(s -> anunciosUser.contains(s.getAnuncio()))
                .map(solicitudMapper::mapToDTO)
                .toList());
    }

    public ResponseEntity<List<SolicitudDTO>> getEnviadasByUser(String token) {
        String newToken = token.replace("Bearer ", "").strip();
        String emailFromToken = jwtUtils.getEmailFromToken(newToken);
        Usuario usuario = usuarioRepository.findByEmail(emailFromToken).get();
        return getByFilter(SolicitudSpecification.hasRemitente(usuario));
    }

    @Transactional
    public ResponseEntity<SolicitudDTO> addToUser(SolicitudDTO add, String token) {
        String newToken = token.replace("Bearer ", "").strip();
        String emailFromToken = jwtUtils.getEmailFromToken(newToken);
        Usuario usuario = usuarioRepository.findByEmail(emailFromToken).get();
        Solicitud solicitud = solicitudMapper.mapToEntity(add);
        solicitud.setId(null);
        solicitud.setRemitente(usuario);
        Solicitud save = solicitudRepository.save(solicitud);
        return ResponseEntity.ok(solicitudMapper.mapToDTO(save));
    }

    public ResponseEntity<SolicitudDTO> updateByUser(SolicitudDTO put, String token) {
        String newToken = token.replace("Bearer ", "").strip();
        String emailFromToken = jwtUtils.getEmailFromToken(newToken);
        Usuario usuario = usuarioRepository.findByEmail(emailFromToken).get();
        Solicitud solicitud = solicitudMapper.mapToEntity(put);
        if (solicitudRepository.existsById(solicitud.getId())) {
            if (solicitud.getRemitente().getId().equals(usuario.getId())) {
                Solicitud save = solicitudRepository.save(solicitud);
                return ResponseEntity.ok(solicitudMapper.mapToDTO(save));
            }
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<SolicitudDTO> deleteByUser(Long id, String token) {
        String newToken = token.replace("Bearer ", "").strip();
        String emailFromToken = jwtUtils.getEmailFromToken(newToken);
        Usuario usuario = usuarioRepository.findByEmail(emailFromToken).get();
        if (solicitudRepository.existsById(id)) {
            Solicitud solicitud = solicitudRepository.findById(id).get();
            if (solicitud.getRemitente().getId().equals(usuario.getId())) {
                solicitudRepository.delete(solicitud);
                solicitudRepository.flush();
                return ResponseEntity.ok(solicitudMapper.mapToDTO(solicitud));
            }
        }
        return ResponseEntity.badRequest().build();
    }


}
