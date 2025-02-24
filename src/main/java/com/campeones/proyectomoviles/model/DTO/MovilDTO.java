package com.campeones.proyectomoviles.model.DTO;

import java.math.BigDecimal;
import java.util.Date;

public record MovilDTO(int idMovil, String marca, String modelo, String procesador, int almacenamiento,
		BigDecimal tamanoPantalla, String tecnologiaPantalla, int ram, BigDecimal peso, int camara, int bateria,
		boolean nfc, BigDecimal precioActual, Date fechaLanzamiento, String resolucion) {

}
