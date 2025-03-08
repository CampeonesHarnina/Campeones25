package com.campeones.proyectomoviles.services;

import java.util.List;
import java.util.stream.Collectors;

import com.campeones.proyectomoviles.controllers.UserCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campeones.proyectomoviles.mappers.SolicitudMapper;
import com.campeones.proyectomoviles.model.DTO.SolicitudDTO;
import com.campeones.proyectomoviles.model.Entities.Anuncio;
import com.campeones.proyectomoviles.model.Entities.Solicitud;
import com.campeones.proyectomoviles.model.Entities.Usuario;
import com.campeones.proyectomoviles.repositories.AnuncioRepository;
import com.campeones.proyectomoviles.repositories.SolicitudRepository;
import com.campeones.proyectomoviles.repositories.UsuarioRepository;

@Service
public class SolicitudesServiceImpl implements SolicitudesService{

	private final SolicitudRepository solicitudRepository;
	private final SolicitudMapper solicitudMapper;
	private final UsuarioRepository usuarioRepository;
	private final AnuncioRepository anuncioRepository;

	@Autowired
	public SolicitudesServiceImpl(SolicitudRepository solicitudRepository,
			@Qualifier("solicitudMapperImpl") SolicitudMapper solicitudMapper, UsuarioRepository usuarioRepository,
			AnuncioRepository anuncioRepository) {
		this.solicitudRepository = solicitudRepository;
		this.solicitudMapper = solicitudMapper;
		this.usuarioRepository = usuarioRepository;
		this.anuncioRepository = anuncioRepository;
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
		solicitud.setFechaSolicitud(solicitudDTO.getFechaSolicitud());
		solicitud.setContestada(solicitudDTO.getContestada());
		// Reutilizar entidades existentes para evitar duplicados
		Usuario remitente = usuarioRepository.findById(solicitudDTO.getRemitenteId())
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		Anuncio anuncio = anuncioRepository.findById(solicitudDTO.getAnuncioId())
				.orElseThrow(() -> new RuntimeException("Anuncio no encontrado"));
		solicitud.setRemitente(remitente);
		solicitud.setAnuncio(anuncio);

		Solicitud saved = solicitudRepository.save(solicitud);
		return ResponseEntity.ok(solicitudMapper.mapToDTO(saved));
	}

	@Transactional
	@Override
	public ResponseEntity<SolicitudDTO> put(SolicitudDTO solicitudDTO) {
		if (solicitudRepository.existsById(solicitudDTO.getId())) {
			// Obtener la entidad existente
			Solicitud solicitud = solicitudRepository.findById(solicitudDTO.getId())
					.orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
			// Actualizar solo los campos necesarios
			solicitud.setFechaSolicitud(solicitudDTO.getFechaSolicitud());
			solicitud.setContestada(solicitudDTO.getContestada());
			// Reutilizar entidades existentes
			Usuario remitente = usuarioRepository.findById(solicitudDTO.getRemitenteId())
					.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
			Anuncio anuncio = anuncioRepository.findById(solicitudDTO.getAnuncioId())
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


	public ResponseEntity<SolicitudDTO> getByUser(Long id) {
		return null;
	}

	public ResponseEntity<SolicitudDTO> addToUser(SolicitudDTO add, Long id) {
		return null;
	}

	public ResponseEntity<SolicitudDTO> updateByUser(SolicitudDTO put, Long id) {
		return null;
	}

	public ResponseEntity<SolicitudDTO> deleteByUser(SolicitudDTO erase, Long id) {
		return null;
	}
}
