package com.campeones.proyectomoviles.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import com.campeones.proyectomoviles.model.DTO.MovilDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


@SpringBootTest
class MovilesServiceTest {

	@MockitoBean
	MovilesServiceImpl movilesService;

	@Test
	void testPost() {

		MovilDTO movilDTO = new MovilDTO(1l, "Samsung", "Galaxy S21", 128, 6.2f, null,  8, 169.0f, 12, 4000, true, 849.0f, LocalDate.now(), 0, 20, 9, null, null, "151.7 x 71.2 x 7.9 mm", null);
		when(movilesService.post(movilDTO)).thenReturn(ResponseEntity.ok(movilDTO));
		ResponseEntity<MovilDTO> response = movilesService.post(movilDTO);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}



	@Test
	void testGetByFilter() {
		when(movilesService.getByFilter(null)).thenReturn(ResponseEntity.ok().build());
		ResponseEntity<?> response = movilesService.getByFilter(null);
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());

	}
}
