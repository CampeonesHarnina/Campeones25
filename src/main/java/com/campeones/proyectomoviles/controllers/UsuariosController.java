package com.campeones.proyectomoviles.controllers;

import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;
import com.campeones.proyectomoviles.model.Entities.Usuario;
import com.campeones.proyectomoviles.mappers.UsuarioMapper;
import com.campeones.proyectomoviles.repositories.UsuarioRepository;
import com.campeones.proyectomoviles.services.UsuariosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/usuarios")
@RestController
public class UsuariosController implements GenericController<UsuarioDTO, Void, Long> {

    private final UsuariosServiceImpl usuariosService;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuariosController(UsuariosServiceImpl usuariosService, UsuarioRepository usuarioRepository,
                              UsuarioMapper usuarioMapper, PasswordEncoder passwordEncoder) {
        this.usuariosService = usuariosService;
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    // Obtener todos los usuarios
    @GetMapping("/find")
    @Override
    public ResponseEntity<List<UsuarioDTO>> get() {
        return usuariosService.get();
    }

    // Registrar un nuevo usuario (público)
    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> register(@RequestBody UsuarioDTO usuarioDTO) {
        // Encriptar la contraseña
        String encryptedPassword = passwordEncoder.encode(usuarioDTO.password());

        // Mapear DTO a entidad y establecer contraseña encriptada
        Usuario usuario = usuarioMapper.mapToEntity(usuarioDTO);
        usuario.setPassword(encryptedPassword);
        usuario.setAnuncios(new ArrayList<>());
        usuario.setSolicitudesEnviadas(new ArrayList<>());

        // Guardar en la base de datos
        Usuario savedUsuario = usuarioRepository.save(usuario);

        // Mapear a DTO para la respuesta
        UsuarioDTO savedUsuarioDTO = usuarioMapper.mapToDTO(savedUsuario);
        return ResponseEntity.status(201).body(savedUsuarioDTO);
    }

    // Crear un usuario (restringido a ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    @Override
    public ResponseEntity<UsuarioDTO> post(@RequestBody UsuarioDTO usuarioDTO) {
        return usuariosService.post(usuarioDTO);
    }

    // Actualizar un usuario (restringido a ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    @Override
    public ResponseEntity<UsuarioDTO> put(@RequestBody UsuarioDTO usuarioDTO) {
        return usuariosService.put(usuarioDTO);
    }

    // Eliminar un usuario (restringido a ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<UsuarioDTO> delete(@PathVariable Long id) {
        return usuariosService.delete(id);
    }

    // Método de filtrado no implementado
    @GetMapping("/filter")
    @Override
    public ResponseEntity<List<UsuarioDTO>> getByFilter(Void spec) {
        return ResponseEntity.status(501).build(); // 501 Not Implemented
    }
}
