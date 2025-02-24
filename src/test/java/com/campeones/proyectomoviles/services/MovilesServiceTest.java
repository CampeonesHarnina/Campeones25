package com.campeones.proyectomoviles.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Date;

import com.campeones.proyectomoviles.model.DTO.MovilDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


@SpringBootTest
class MovilesServiceTest {

	@MockitoBean
	MovilesService movilesService;

	@Test
	void testPost() {
		MovilDTO movilDTO = new MovilDTO(1, "Samsung", "Galaxy S21", "Exynos", 128, new BigDecimal(6.8), "AMOLED", 8,
				new BigDecimal(200), 108, 5000, true, new BigDecimal(799.99), new Date(), "1440x3200");

		when(movilesService.post(movilDTO)).thenReturn(ResponseEntity.ok(movilDTO));

		ResponseEntity<MovilDTO> response = movilesService.post(movilDTO);

		assertNotNull(response);
		assertEquals("200 OK", response.getStatusCode().toString());
	}

}
