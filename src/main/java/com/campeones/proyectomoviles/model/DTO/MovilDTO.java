package com.campeones.proyectomoviles.model.DTO;

import java.time.LocalDate;

import com.campeones.proyectomoviles.model.POJO.Resolucion;
import com.campeones.proyectomoviles.model.POJO.ResolucionTarget;
import com.campeones.proyectomoviles.model.POJO.TecnologiaPantalla;

public record MovilDTO(Long id, String marca, String modelo, int almacenamiento, float tamanioPantalla,
		TecnologiaPantalla tecnologiaPantalla, int ram, float peso, int camara, int bateria, boolean nfc,
		float precioActual, LocalDate fechaLanzamiento, int consultas, int proporcionAlto, int proporcionAncho,
		ResolucionTarget resolucionTarget, Resolucion resolucion, String dimensionesMovil, ProcesadorDTO procesador) {
}
