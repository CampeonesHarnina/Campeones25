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

import com.campeones.proyectomoviles.mappers.MovilMapper;
import com.campeones.proyectomoviles.model.DTO.MovilDTO;
import com.campeones.proyectomoviles.model.Entities.Movil;
import com.campeones.proyectomoviles.model.specifications.MovilSpecification;

@SpringBootTest
class MovilesServiceTest {

	@Autowired
	MovilesServiceImpl movilesService;
	@Qualifier("movilMapperImpl")
	@Autowired
	private MovilMapper movilMapper;

	private MovilDTO movilDTO;

	@BeforeEach
	void beforeEach() {
		movilDTO = movilesService.get().getBody().get(0);
	}

	@Test
	void testGet() {
		ResponseEntity<List<MovilDTO>> response = movilesService.get();
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testPost() {
		ResponseEntity<MovilDTO> response = movilesService.post(movilDTO);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testPut() {
		Movil movil = movilMapper.mapToEntity(movilDTO);
		movil.setModelo("Galaxy S24 Ultra");
		ResponseEntity<MovilDTO> response2 = movilesService.put(movilMapper.mapToDTO(movil));
		assertEquals(HttpStatus.OK, response2.getStatusCode());
	}

	@Test
	void testDelete() {
		ResponseEntity<MovilDTO> response2 = movilesService.delete(movilDTO.id());
		assertEquals(HttpStatus.OK, response2.getStatusCode());
	}

	@Test
	void testFilter() {
		Specification<Movil> spec = Specification.where(null);
		spec = spec.and(MovilSpecification.hasMarca("Apple"));
		ResponseEntity<List<MovilDTO>> response = movilesService.getByFilter(spec);
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertFalse(response.getBody().isEmpty());

	}
}
