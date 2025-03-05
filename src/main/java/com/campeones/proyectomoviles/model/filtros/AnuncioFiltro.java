package com.campeones.proyectomoviles.model.filtros;

import com.campeones.proyectomoviles.model.POJO.Estado;
import com.campeones.proyectomoviles.model.POJO.TipoCambio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnuncioFiltro {
	private Estado estado;
	private TipoCambio tipoCambio;
}
