package com.campeones.proyectomoviles.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import com.campeones.proyectomoviles.model.DTO.ProcesadorDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


@SpringBootTest
class ProcesadoresServiceTest {

	@MockitoBean
	ProcesadoresService procesadoresService;

	@Test
	void testPost() {

		ProcesadorDTO procesadorDTO = new ProcesadorDTO(1l, "Qualcomm", 8, 2.84f);

		when(procesadoresService.post(procesadorDTO)).thenReturn(ResponseEntity.ok(procesadorDTO));

		ResponseEntity<ProcesadorDTO> response = procesadoresService.post(procesadorDTO);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
