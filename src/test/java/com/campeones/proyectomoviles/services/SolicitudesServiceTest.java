package com.campeones.proyectomoviles.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.campeones.proyectomoviles.model.DTOs.SolicitudDTO;

@SpringBootTest
class SolicitudesServiceTest {

	@MockitoBean
	SolicitudesService solicitudesService;

	@Test
	void testPost() {
		SolicitudDTO solicitudDTO = new SolicitudDTO(1, 1, 1, 1, new Date(), true);

		when(solicitudesService.post(solicitudDTO)).thenReturn(ResponseEntity.ok(solicitudDTO));

		ResponseEntity<SolicitudDTO> response = solicitudesService.post(solicitudDTO);

		assertNotNull(response);
		assertEquals("200 OK", response.getStatusCode().toString());
	}

}
