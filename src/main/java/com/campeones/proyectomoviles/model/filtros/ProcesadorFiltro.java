package com.campeones.proyectomoviles.model.filtros;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcesadorFiltro {

	private String tipo;
	private int nucleo;
	private float velocidadMaxima;
	
}
