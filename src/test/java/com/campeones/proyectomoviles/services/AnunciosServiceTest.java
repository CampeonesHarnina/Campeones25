package com.campeones.proyectomoviles.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.function.Predicate;

import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;
import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;
import com.campeones.proyectomoviles.model.Entities.Anuncio;
import com.campeones.proyectomoviles.model.POJO.Estado;
import com.campeones.proyectomoviles.model.POJO.TipoCambio;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


@SpringBootTest
class AnunciosServiceTest {

    @MockitoBean
    AnunciosService anunciosService;

    @Test
    void testGet() {
        when(anunciosService.get()).thenReturn(ResponseEntity.ok().build());

        ResponseEntity<?> response = anunciosService.get();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testPost() {

        AnuncioDTO anuncioDTO = new AnuncioDTO(1l, Estado.INTACTO, TipoCambio.VENTA, LocalDate.now(), null, null);

        when(anunciosService.post(anuncioDTO)).thenReturn(ResponseEntity.ok(anuncioDTO));

        ResponseEntity<AnuncioDTO> response = anunciosService.post(anuncioDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testPut() {
        AnuncioDTO anuncioDTO = new AnuncioDTO(1l, Estado.INTACTO, TipoCambio.INTERCAMBIO, LocalDate.now(), null, null);

        when(anunciosService.put(anuncioDTO)).thenReturn(ResponseEntity.ok(anuncioDTO));

        ResponseEntity<AnuncioDTO> response = anunciosService.put(anuncioDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testDelete() {
        AnuncioDTO anuncioDTO = new AnuncioDTO(1l, Estado.INTACTO, TipoCambio.INTERCAMBIO, LocalDate.now(), null, null);

        when(anunciosService.delete(anuncioDTO.id())).thenReturn(ResponseEntity.ok(anuncioDTO));

        ResponseEntity<AnuncioDTO> response = anunciosService.delete(anuncioDTO.id());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    @Test
    void testGetAnunciosUsuario() {
        UsuarioDTO usuarioDTO = new UsuarioDTO(1l, "pepe", "1234", "a@gmail.com", true);

        when(anunciosService.getAnunciosUsuario(usuarioDTO.id())).thenReturn(ResponseEntity.ok().build());

        ResponseEntity<?> response = anunciosService.getAnunciosUsuario(usuarioDTO.id());

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testDeleteAnuncioUsuario() {
        UsuarioDTO usuarioDTO = new UsuarioDTO(1l, "pepe", "1234", "a@gmail.com", true);

        when(anunciosService.deleteAnuncioUsuario(usuarioDTO.id())).thenReturn(ResponseEntity.ok().build());
        ResponseEntity<?> response = anunciosService.deleteAnuncioUsuario(usuarioDTO.id());
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    @Test
    void testGetAnunciosFiltrados() {
        Predicate<AnuncioDTO> filtro = t -> t.estado().equals(Estado.INTACTO);
		when(anunciosService.getByFilter(filtro)).thenReturn(ResponseEntity.ok().build());

		ResponseEntity<?> response = anunciosService.getByFilter(filtro);

		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}




}
