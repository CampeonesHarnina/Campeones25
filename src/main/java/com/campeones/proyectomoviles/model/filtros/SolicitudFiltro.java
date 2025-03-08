package com.campeones.proyectomoviles.model.filtros;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudFiltro {
	 private LocalDate fechaMin;
	 private LocalDate fechaMax;
	 private Boolean contestada;
	 private Long anuncio;
}
