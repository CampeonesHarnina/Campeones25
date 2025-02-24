package com.campeones.proyectomoviles.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;

import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


@SpringBootTest
class AnunciosServiceTest {

	@MockitoBean
	AnunciosService anunciosService;

	@Test
	void testPost() {
		AnuncioDTO anuncioDTO = new AnuncioDTO(1, 1, 1, "Nuevo", "Pruebas", new Date());

		when(anunciosService.post(anuncioDTO)).thenReturn(ResponseEntity.ok(anuncioDTO));

		ResponseEntity<AnuncioDTO> response = anunciosService.post(anuncioDTO);

		assertNotNull(response);
		assertEquals("200 OK", response.getStatusCode().toString());
	}

}
