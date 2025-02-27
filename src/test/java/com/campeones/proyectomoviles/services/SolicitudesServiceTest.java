package com.campeones.proyectomoviles.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.campeones.proyectomoviles.model.DTO.SolicitudDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


@SpringBootTest
class SolicitudesServiceTest {

	@MockitoBean
	SolicitudesService solicitudesService;

	@Test
	void testPost() {

		SolicitudDTO solicitudDTO = new SolicitudDTO(1L, null, null, null, null, 0);
		when(solicitudesService.post(solicitudDTO)).thenReturn(ResponseEntity.ok(solicitudDTO));
		ResponseEntity<SolicitudDTO> response = solicitudesService.post(solicitudDTO);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testFilterByRemitente(){
		when(solicitudesService.filterByRemitenteId(1L)).thenReturn(ResponseEntity.ok().build());
		ResponseEntity<?> response = solicitudesService.filterByRemitenteId(1L);
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testFilterByDestinatario(){
		when(solicitudesService.filterByDestinatarioId(1L)).thenReturn(ResponseEntity.ok().build());
		ResponseEntity<?> response = solicitudesService.filterByDestinatarioId(1L);
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
