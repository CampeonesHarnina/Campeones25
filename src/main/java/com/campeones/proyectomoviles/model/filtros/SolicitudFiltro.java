package com.campeones.proyectomoviles.model.filtros;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudFiltro {
	private LocalDate fechaMin;
	private LocalDate fechaMax;
	private Boolean contestada;
	private Long anuncio;
}
