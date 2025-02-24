package com.campeones.proyectomoviles.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.campeones.proyectomoviles.model.DTOs.UsuarioDTO;

@SpringBootTest
class UsuariosServiceTest {

	@MockitoBean
	UsuariosService usuariosService;

	@Test
	void testPost() {
		UsuarioDTO usuarioDTO = new UsuarioDTO(1, "Prueba", "prueba@gmail.com", false);

		when(usuariosService.post(usuarioDTO)).thenReturn(ResponseEntity.ok(usuarioDTO));

		ResponseEntity<UsuarioDTO> response = usuariosService.post(usuarioDTO);

		assertNotNull(response);
		assertEquals("200 OK", response.getStatusCode().toString());

	}

}
