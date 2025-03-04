package com.campeones.proyectomoviles.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import com.campeones.proyectomoviles.mappers.MovilMapper;
import com.campeones.proyectomoviles.model.DTO.MovilDTO;
import com.campeones.proyectomoviles.model.Entities.Movil;
import com.campeones.proyectomoviles.model.specifications.MovilSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


@SpringBootTest
class MovilesServiceTest {

//	@MockitoBean
	@Autowired
	MovilesServiceImpl movilesService;
	@Autowired
	private MovilMapper movilMapper;

	private MovilDTO movilDTO;

	@BeforeEach
	void beforeEach(){
		Movil movil = new Movil();
		movil.setMarca("Samsung");
		movil.setModelo("Galaxy S21");
		movilDTO = movilMapper.mapToDTO(movil);
	}

	@Test
	void testGet() {
		ResponseEntity<List<MovilDTO>> response = movilesService.get();
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testPost() {
//		when(movilesService.post(movilDTO)).thenReturn(ResponseEntity.ok(movilDTO));
		ResponseEntity<MovilDTO> response = movilesService.post(movilDTO);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testPostThenPut() {
		ResponseEntity<MovilDTO> response = movilesService.post(movilDTO);
		assertEquals(HttpStatus.OK, response.getStatusCode());

		Movil movil = movilMapper.mapToEntity(response.getBody());
		movil.setModelo("Galaxy S22");
		ResponseEntity<MovilDTO> response2 = movilesService.put(movilMapper.mapToDTO(movil));
		assertEquals(HttpStatus.OK, response2.getStatusCode());
	}

	@Test
	void testPostThenDelete(){
		ResponseEntity<MovilDTO> response = movilesService.post(movilDTO);
		assertEquals(HttpStatus.OK, response.getStatusCode());

		ResponseEntity<MovilDTO> response2 = movilesService.delete(response.getBody().id());
		assertEquals(HttpStatus.OK, response2.getStatusCode());
	}

	@Test
	void testPostThenFilter() {
//		when(movilesService.getByFilter(null)).thenReturn(ResponseEntity.ok().build());
		ResponseEntity<MovilDTO> response = movilesService.post(movilDTO);
		assertEquals(HttpStatus.OK, response.getStatusCode());

		Specification<Movil> spec = Specification.where(null);
		spec = spec.and(MovilSpecification.hasMarca("Samsung"));
		ResponseEntity<List<MovilDTO>> response2 = movilesService.getByFilter(spec);
		assertNotNull(response2);
		assertEquals(HttpStatus.OK, response2.getStatusCode());
		assertFalse(response2.getBody().isEmpty());

	}
}
