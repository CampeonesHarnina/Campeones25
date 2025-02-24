package com.campeones.proyectomoviles.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import com.campeones.proyectomoviles.model.DTO.ProcesadorDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


@SpringBootTest
class ProcesadoresServiceTest {

	@MockitoBean
	ProcesadoresService procesadoresService;

	@Test
	void testPost() {
		ProcesadorDTO procesadorDTO = new ProcesadorDTO(1, "Prueba", 10, new BigDecimal(10));

		when(procesadoresService.post(procesadorDTO)).thenReturn(ResponseEntity.ok(procesadorDTO));

		ResponseEntity<ProcesadorDTO> response = procesadoresService.post(procesadorDTO);

		assertNotNull(response);
		assertEquals("200 OK", response.getStatusCode().toString());

	}

}
