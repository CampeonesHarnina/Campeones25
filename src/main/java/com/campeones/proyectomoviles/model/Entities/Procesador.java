package com.campeones.proyectomoviles.model.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Procesador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String tipo;
	@NonNull
	private Integer nucleo;
	@NonNull
	private Float velocidadMaxima;

	@OneToMany(mappedBy = "procesador")
	@JsonIgnore
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@NonNull
	private List<Movil> moviles;
}
