package com.campeones.proyectomoviles.model.DTO;

import java.time.LocalDate;

public record SolicitudDTO(Long idSolicitud, LocalDate fechaSolicitud, int contestada) {
}