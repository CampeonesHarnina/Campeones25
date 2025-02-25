package com.campeones.proyectomoviles.model.DTO;

public record UsuarioDTO(Long id, String nombre, String password, String email, boolean esAdmin) {
}
