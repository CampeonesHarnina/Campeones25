package com.campeones.proyectomoviles.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import com.campeones.proyectomoviles.mappers.AnuncioMapper;
import com.campeones.proyectomoviles.mappers.AnuncioMapperImpl;
import com.campeones.proyectomoviles.model.DTO.AnuncioDTO;
import com.campeones.proyectomoviles.model.DTO.MovilDTO;
import com.campeones.proyectomoviles.model.DTO.ProcesadorDTO;
import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;
import com.campeones.proyectomoviles.model.Entities.Anuncio;
import com.campeones.proyectomoviles.model.Entities.Movil;
import com.campeones.proyectomoviles.model.Entities.Procesador;
import com.campeones.proyectomoviles.model.Entities.Usuario;
import com.campeones.proyectomoviles.model.POJO.*;
import com.campeones.proyectomoviles.model.specifications.AnuncioSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest
class AnunciosServiceTest {

    @Autowired
    AnunciosServiceImpl anunciosService;
    @Qualifier("anuncioMapperImpl")
    @Autowired
    AnuncioMapper mapper;

    AnuncioDTO anuncioDTO;
    @BeforeEach
    void beforeEach(){
        Movil movil = new Movil();
        movil.setModelo("Redmi Note");
        Usuario usuario = new Usuario();
        usuario.setNombre("admin");
        Anuncio anuncio = new Anuncio();
        anuncio.setUsuario(usuario);
        anuncio.setMovil(movil);
        anuncio.setFechaPublicacion(LocalDate.now());
        anuncioDTO = mapper.mapToDTO(anuncio);

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
    void testPostThenPut() {
        ResponseEntity<AnuncioDTO> response = anunciosService.post(anuncioDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        
        Anuncio anuncio = mapper.mapToEntity(anuncioDTO);
        anuncio.setEstado(Estado.HEROE_DE_GUERRA);
        AnuncioDTO modificar = mapper.mapToDTO(anuncio);
        
        ResponseEntity<AnuncioDTO> response = anunciosService.put(modificar);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testPostThenDelete() {
        ResponseEntity<AnuncioDTO> response = anunciosService.post(anuncioDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        
        ResponseEntity<AnuncioDTO> response = anunciosService.delete(anuncioDTO.id());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testGetByFilter() {
        ResponseEntity<List<AnuncioDTO>> response = anunciosService.getByFilter(AnuncioSpecification.hasUsuarioId(1L));
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testGetAnuncioUsuario() {
        ResponseEntity<List<AnuncioDTO>> response = anunciosService.getAnunciosUsuario(1L);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
