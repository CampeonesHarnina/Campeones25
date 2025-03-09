package com.campeones.proyectomoviles.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.campeones.proyectomoviles.mappers.UsuarioMapper;
import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;
import com.campeones.proyectomoviles.model.Entities.Usuario;

@SpringBootTest
class UsuariosServiceTest {

	@Autowired
	UsuariosServiceImpl usuariosService;
	@Autowired
	private UsuarioMapper usuarioMapper;

	private UsuarioDTO usuarioDTO;

	@BeforeEach
	void beforeEach() {
		usuarioDTO = usuariosService.get().getBody().get(0);
	}

	@Test
	void testGet() {
		ResponseEntity<List<UsuarioDTO>> response = usuariosService.get();
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testPost() {
		ResponseEntity<UsuarioDTO> response = usuariosService.post(usuarioDTO);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	void testPut() {
		Usuario usuario = usuarioMapper.mapToEntity(usuarioDTO);
		usuario.setEmail("ana@gmail.com");
		usuario.setPassword("prueba123123#");
		ResponseEntity<UsuarioDTO> response2 = usuariosService.put(usuarioMapper.mapToDTO(usuario));
		assertEquals(HttpStatus.OK, response2.getStatusCode());
	}

	@Test
	void testDelete() {
		ResponseEntity<UsuarioDTO> response2 = usuariosService.delete(usuarioDTO.id());
		assertEquals(HttpStatus.OK, response2.getStatusCode());
	}

}
