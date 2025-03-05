package com.campeones.proyectomoviles.model.DTO;

import java.time.LocalDate;

public record SolicitudDTO(Long id, LocalDate fechaSolicitud, int contestada, UsuarioDTO destinatario, UsuarioDTO remitente,
                           AnuncioDTO anuncio) {
}