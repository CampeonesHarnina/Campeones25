package com.campeones.proyectomoviles.model.POJO;

public enum Estado {
	INTACTO("Intacto"), EXPERIMENTADO("Experimentado"), SUPERVIVIENTE("Superviviente"), HEROE_DE_GUERRA("Héroe de guerra");

	private String value;

	Estado(String value) {
		this.value = value;
	}
}
