package com.campeones.proyectomoviles.model.filtros;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovilFiltro {

	private String marca;
	private Integer minRam;
	private Integer maxRam;
	private Float minPrecio;
	private Float maxPrecio;
	private Boolean hasNfc;

}
