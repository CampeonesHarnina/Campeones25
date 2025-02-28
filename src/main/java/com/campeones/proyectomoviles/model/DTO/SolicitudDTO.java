package com.campeones.proyectomoviles.model.DTO;

import java.time.LocalDate;
import java.util.Date;

public record SolicitudDTO(Long idSolicitud, LocalDate fechaSolicitud, int contestada) {
}