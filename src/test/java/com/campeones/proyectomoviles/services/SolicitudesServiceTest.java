package com.campeones.proyectomoviles.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.campeones.proyectomoviles.mappers.AnuncioMapper;
import com.campeones.proyectomoviles.mappers.UsuarioMapper;
import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;
import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;
import com.campeones.proyectomoviles.model.Entities.Anuncio;
import com.campeones.proyectomoviles.model.Entities.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.campeones.proyectomoviles.model.DTO.SolicitudDTO;

@SpringBootTest
class SolicitudesServiceTest {

	@MockitoBean
	SolicitudesServiceImpl solicitudesService;
	@Autowired
	private UsuarioMapper usuarioMapper;
	@Autowired
	private AnuncioMapper anuncioMapper;

	private SolicitudDTO solicitudDTO;

	@BeforeEach
	void beforeEach(){
		Usuario user = new Usuario();
		Anuncio anuncio = new Anuncio();
		UsuarioDTO usuarioDTO = usuarioMapper.mapToDTO(user);
		AnuncioDTO anuncioDTO = anuncioMapper.mapToDTO(anuncio);
		solicitudDTO = new SolicitudDTO(1L, null, 0, usuarioDTO, usuarioDTO, anuncioDTO);
	}
	@Test
	void testPost() {
		when(solicitudesService.post(solicitudDTO)).thenReturn(ResponseEntity.ok(solicitudDTO));
		ResponseEntity<SolicitudDTO> response = solicitudesService.post(solicitudDTO);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testGetByFilter() {
		when(solicitudesService.getByFilter(null)).thenReturn(ResponseEntity.ok().build());
		ResponseEntity<?> response = solicitudesService.getByFilter(null);
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
