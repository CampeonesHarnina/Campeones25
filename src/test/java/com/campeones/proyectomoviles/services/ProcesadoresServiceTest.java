package com.campeones.proyectomoviles.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import com.campeones.proyectomoviles.model.DTO.ProcesadorDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;


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

	@Test
	void testGetByFilter(){
		when(procesadoresService.getByFilter(null)).thenReturn(ResponseEntity.ok(List.of(new ProcesadorDTO(1l, "Qualcomm", 8, 2.84f))));
		ResponseEntity<List<ProcesadorDTO>> response = procesadoresService.getByFilter(null);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(1, response.getBody().size());
		assertEquals("Qualcomm", response.getBody().get(0).tipo());
	}

}
