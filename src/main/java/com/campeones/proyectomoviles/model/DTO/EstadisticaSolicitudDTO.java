package com.campeones.proyectomoviles.model.DTO;

import java.util.Date;

public record EstadisticaSolicitudDTO(int idEstadistica, String tipoCambio, String estado, Date fechaInicio,
		Date fechaFin, int totalSolicitudes, int contestadas) {

}
