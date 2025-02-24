package com.campeones.proyectomoviles.model.DTO;

import java.util.Date;

public record AnuncioDTO(int idAnuncio, int idUsuario, int idMovil, String estado, String tipoCambio,
		Date fechaPublicacion) {

}
