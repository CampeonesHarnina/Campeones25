package com.campeones.proyectomoviles.model.DTO;

import java.time.LocalDate;

public record SolicitudDTO(Long id, LocalDate fechaSolicitud, Boolean contestada, UsuarioDTO remitente,
		AnuncioDTO anuncio) {
}