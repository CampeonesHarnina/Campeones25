package com.campeones.proyectomoviles.model.DTO;

import java.time.LocalDate;

import com.campeones.proyectomoviles.model.POJO.Resolucion;
import com.campeones.proyectomoviles.model.POJO.ResolucionTarget;
import com.campeones.proyectomoviles.model.POJO.TecnologiaPantalla;
import jakarta.validation.constraints.Pattern;

public record MovilDTO(Long id,
					   @Pattern(regexp = "^[a-zA-Z0-9_!?¿¡'/.,\\sáéíóúÁÉÍÓÚñÑ]*$")
					   String marca,
					   @Pattern(regexp = "^[a-zA-Z0-9_!?¿¡'/.,\\sáéíóúÁÉÍÓÚñÑ]*$")
					   String modelo, int almacenamiento, float tamanioPantalla,
		TecnologiaPantalla tecnologiaPantalla, int ram, float peso, int camara, int bateria, boolean nfc,
		float precioActual, LocalDate fechaLanzamiento, int consultas, int proporcionAlto, int proporcionAncho,
		ResolucionTarget resolucionTarget, Resolucion resolucion, String dimensionesMovil, ProcesadorDTO procesador) {
}
