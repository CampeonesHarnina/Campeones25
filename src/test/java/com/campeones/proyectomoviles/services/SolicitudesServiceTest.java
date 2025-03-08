package com.campeones.proyectomoviles.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.mappers.SolicitudMapper;
import com.campeones.proyectomoviles.model.DTO.SolicitudDTO;
import com.campeones.proyectomoviles.model.Entities.Solicitud;
import com.campeones.proyectomoviles.model.specifications.SolicitudSpecification;
import com.campeones.proyectomoviles.repositories.SolicitudRepository;

@SpringBootTest
class SolicitudesServiceTest {

	@Autowired
	SolicitudesServiceImpl solicitudesService;

	@Qualifier("solicitudMapperImpl")
	@Autowired
	private SolicitudMapper solicitudMapper;

	@Autowired
	private SolicitudRepository solicitudRepository;

	private SolicitudDTO solicitudDTO;

	@BeforeEach
	void beforeEach() {
		solicitudDTO = solicitudesService.get().getBody().get(0);
	}

	@Test
	void testGet() {
		ResponseEntity<List<SolicitudDTO>> responseEntity = solicitudesService.get();
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	void testPost() {
		ResponseEntity<SolicitudDTO> post = solicitudesService.post(solicitudDTO);
		assertEquals(HttpStatus.OK, post.getStatusCode());
	}

	@Test
	void testPut() {
		Solicitud solicitud = solicitudRepository.findById(solicitudDTO.id()).orElseThrow();
		solicitud.setContestada(true);
		ResponseEntity<SolicitudDTO> put = solicitudesService.put(solicitudMapper.mapToDTO(solicitud));
		assertEquals(HttpStatus.OK, put.getStatusCode());
	}

	@Test
	void testDelete() {
		ResponseEntity<SolicitudDTO> delete = solicitudesService.delete(solicitudDTO.id());
		assertEquals(HttpStatus.OK, delete.getStatusCode());
	}

	@Test
	void testFilter() {
		Specification<Solicitud> spec = Specification.where(null);
		spec = spec.and(SolicitudSpecification.hasContestada(true));
		ResponseEntity<List<SolicitudDTO>> byFilter = solicitudesService.getByFilter(spec);
		assertNotNull(byFilter);
		assertEquals(HttpStatus.OK, byFilter.getStatusCode());
		assertFalse(byFilter.getBody().isEmpty());
	}
}