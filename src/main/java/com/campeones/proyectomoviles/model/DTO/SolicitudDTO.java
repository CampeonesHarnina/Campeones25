package com.campeones.proyectomoviles.model.DTOs;

import java.util.Date;

public record SolicitudDTO(int idSolicitud, int idRemitente, int idDestinatario, int idAnuncio, Date fechaSolicitud,
		boolean contestada) {

}
