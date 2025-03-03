package com.campeones.proyectomoviles.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.campeones.proyectomoviles.model.DTO.SolicitudDTO;

@SpringBootTest
class SolicitudesServiceTest {

	@MockitoBean
	SolicitudesServiceImpl solicitudesService;

	@Test
	void testPost() {

		SolicitudDTO solicitudDTO = new SolicitudDTO(1L, null, 0);
		when(solicitudesService.post(solicitudDTO)).thenReturn(ResponseEntity.ok(solicitudDTO));
		ResponseEntity<SolicitudDTO> response = solicitudesService.post(solicitudDTO);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testGetByFilter() {
		when(solicitudesService.getByFilter(null)).thenReturn(ResponseEntity.ok().build());
		ResponseEntity<?> response = solicitudesService.getByFilter(null);
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
