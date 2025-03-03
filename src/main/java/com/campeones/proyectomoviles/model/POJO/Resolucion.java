package com.campeones.proyectomoviles.model.POJO;

import jakarta.persistence.Embeddable;

@Embeddable
public class Resolucion {

	private int resolucionAlto;
	private int resolucionAncho;

	public Resolucion(int proporcionAlto, int proporcionAncho, ResolucionTarget target) {
		this.resolucionAlto = proporcionAlto * target.getCalculo();
		this.resolucionAncho = proporcionAncho * target.getCalculo();
	}

	public Resolucion() {

	}
}
