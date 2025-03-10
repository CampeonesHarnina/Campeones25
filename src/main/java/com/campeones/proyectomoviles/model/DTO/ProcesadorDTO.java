package com.campeones.proyectomoviles.model.DTO;

import jakarta.validation.constraints.Pattern;

public record ProcesadorDTO(Long idProcesador, @Pattern(regexp = "^[a-zA-Z0-9_!?¿¡'/.,\\sáéíóúÁÉÍÓÚñÑ]*$") String tipo,
		int nucleo, float velocidadMaxima) {
}
