package com.campeones.proyectomoviles.model.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.campeones.proyectomoviles.model.Entities.Procesador;

public class ProcesadorSpecification {

	public static Specification<Procesador> hasTipo(String tipo) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("tipo"), tipo);
	}

	public static Specification<Procesador> hasNucleo(int nucleo) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("nucleos"), nucleo);
	}

	public static Specification<Procesador> hasVelocidadMinima(float velocidadMin) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("velocidadMaxima"),
				velocidadMin);
	}

	public static Specification<Procesador> hasVelocidadMaxima(float velocidadMax) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("velocidadMaxima"),
				velocidadMax);
	}
}
