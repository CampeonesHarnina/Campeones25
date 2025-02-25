package com.campeones.proyectomoviles.model.DTO;

import com.campeones.proyectomoviles.model.POJO.Estado;
import com.campeones.proyectomoviles.model.POJO.TipoCambio;

import java.time.LocalDate;

public record EstadisticaSolicitudDTO(Long idEstadistica, TipoCambio tipoCambio, Estado estado, LocalDate fechaInicio, LocalDate fechaFin, int totalSolicitudes, int contestadas) {
}
