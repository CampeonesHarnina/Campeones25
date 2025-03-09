package com.campeones.proyectomoviles.model.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
public class Procesador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	private Integer nucleo;
	private Float velocidadMaxima;

	@OneToMany(mappedBy = "procesador", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Movil> moviles;

	public Procesador(String tipo, Integer nucleo, Float velocidadMaxima, List<Movil> moviles) {
		this.tipo = tipo;
		this.nucleo = nucleo;
		this.velocidadMaxima = velocidadMaxima;
		this.moviles = moviles;
	}
}
