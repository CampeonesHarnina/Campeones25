package com.campeones.proyectomoviles.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


@SpringBootTest
class UsuariosServiceTest {

	@MockitoBean
	UsuariosServiceImpl usuariosService;

	@Test
	void testPost() {
		UsuarioDTO usuarioDTO = new UsuarioDTO(1l, "Prueba", "prueba@gmail.com", "aa@gmail.com", true);

		when(usuariosService.post(usuarioDTO)).thenReturn(ResponseEntity.ok(usuarioDTO));

		ResponseEntity<UsuarioDTO> response = usuariosService.post(usuarioDTO);

		assertNotNull(response);
		assertEquals("200 OK", response.getStatusCode().toString());

	}

}
