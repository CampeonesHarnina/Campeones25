package com.campeones.proyectomoviles.controllers;

import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;
import com.campeones.proyectomoviles.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class UsuariosController{

    private final UsuariosService usuariosService;

    @Autowired
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping("usuarios/find")
    public ResponseEntity<List<UsuarioDTO>> get() {
        return usuariosService.get();
    }

    @PostMapping("usuarios/new")
    public ResponseEntity<UsuarioDTO> post(UsuarioDTO usuario) {
        return usuariosService.post(usuario);
    }

    @PutMapping("usuarios/update")
    public ResponseEntity<UsuarioDTO> put(UsuarioDTO usuario) {
        return usuariosService.put(usuario);
    }

    @DeleteMapping("usuarios/delete")
    public ResponseEntity<UsuarioDTO> delete(long id) {
        return usuariosService.delete(id);
    }
}
