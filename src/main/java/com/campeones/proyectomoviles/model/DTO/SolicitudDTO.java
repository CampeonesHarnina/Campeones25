package com.campeones.proyectomoviles.model.DTO;

import java.time.LocalDate;
import java.util.Date;

public record SolicitudDTO(Long idSolicitud, UsuarioDTO idRemitente, UsuarioDTO idDestinatario, AnuncioDTO idAnuncio, LocalDate fechaSolicitud, int contestada) {
}