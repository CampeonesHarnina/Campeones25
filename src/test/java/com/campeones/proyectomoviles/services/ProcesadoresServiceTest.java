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

import com.campeones.proyectomoviles.mappers.ProcesadorMapper;
import com.campeones.proyectomoviles.model.DTO.ProcesadorDTO;
import com.campeones.proyectomoviles.model.Entities.Procesador;
import com.campeones.proyectomoviles.model.specifications.ProcesadorSpecification;

@SpringBootTest
class ProcesadoresServiceTest {

	@Autowired
	ProcesadoresServiceImpl procesadoresService;
	@Qualifier("procesadorMapperImpl")
	@Autowired
	private ProcesadorMapper procesadorMapper;

	private ProcesadorDTO procesadorDTO;

	@BeforeEach
	void beforeEach() {
		procesadorDTO = procesadoresService.get().getBody().get(0);
	}

	@Test
	void testGet() {
		ResponseEntity<List<ProcesadorDTO>> responseEntity = procesadoresService.get();
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	void testPost() {
		ResponseEntity<ProcesadorDTO> post = procesadoresService.post(procesadorDTO);
		assertEquals(HttpStatus.OK, post.getStatusCode());
	}

	@Test
	void testPut() {
		Procesador procesador = procesadorMapper.mapToEntity(procesadorDTO);
		procesador.setTipo("Snapdragon 888");
		ResponseEntity<ProcesadorDTO> put = procesadoresService.put(procesadorMapper.mapToDTO(procesador));
		assertEquals(HttpStatus.OK, put.getStatusCode());
	}

	@Test
	void testDelete() {
		ResponseEntity<ProcesadorDTO> delete = procesadoresService.delete(procesadorDTO.idProcesador());
		assertEquals(HttpStatus.OK, delete.getStatusCode());
	}

	@Test
	void testFilter() {
	    Specification<Procesador> spec = Specification.where(null);
	    spec = spec.and(ProcesadorSpecification.hasTipo("Apple A15 Bionic"));
	    ResponseEntity<List<ProcesadorDTO>> byFilter = procesadoresService.getByFilter(spec);
	    assertNotNull(byFilter);
	    assertEquals(HttpStatus.OK, byFilter.getStatusCode());
	    assertFalse(byFilter.getBody().isEmpty());
	}

}
