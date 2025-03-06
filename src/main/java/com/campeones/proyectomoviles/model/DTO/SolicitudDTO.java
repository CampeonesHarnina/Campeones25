package com.campeones.proyectomoviles.model.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SolicitudDTO {
    private Long id;
    private LocalDate fechaSolicitud;
    private Boolean contestada;
    private Long remitenteId; // ID del usuario remitente
    private Long anuncioId;   // ID del anuncio

    // Métodos necesarios para el servicio
    public Long getRemitenteId() {
        return remitenteId;
    }

    public Long getAnuncioId() {
        return anuncioId;
    }
}