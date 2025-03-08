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

import com.campeones.proyectomoviles.mappers.AnuncioMapper;
import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;
import com.campeones.proyectomoviles.model.Entities.Anuncio;
import com.campeones.proyectomoviles.model.POJO.Estado;
import com.campeones.proyectomoviles.model.specifications.AnuncioSpecification;

@SpringBootTest
class AnunciosServiceTest {

	@Autowired
	AnunciosServiceImpl anunciosService;
	@Qualifier("anuncioMapperImpl")
	@Autowired
	private AnuncioMapper anuncioMapper;

	private AnuncioDTO anuncioDTO;

	@BeforeEach
	void beforeEach() {
		anuncioDTO = anunciosService.get().getBody().get(0);
	}

	@Test
	void testGet() {
		ResponseEntity<List<AnuncioDTO>> response = anunciosService.get();
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testPost() {
		ResponseEntity<AnuncioDTO> response = anunciosService.post(anuncioDTO);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testPut() {
		Anuncio anuncio = anuncioMapper.mapToEntity(anuncioDTO);
		anuncio.setEstado(Estado.EXPERIMENTADO);
		ResponseEntity<AnuncioDTO> response = anunciosService.put(anuncioMapper.mapToDTO(anuncio));
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testDelete() {
		ResponseEntity<AnuncioDTO> response = anunciosService.delete(anuncioDTO.id());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testFilter() {
		Specification<Anuncio> spec = Specification.where(null);
		spec = spec.and(AnuncioSpecification.hasEstado(Estado.EXPERIMENTADO));
		ResponseEntity<List<AnuncioDTO>> byFilter = anunciosService.getByFilter(spec);
		assertNotNull(byFilter);
		assertEquals(HttpStatus.OK, byFilter.getStatusCode());
		assertFalse(byFilter.getBody().isEmpty());
	}

}
