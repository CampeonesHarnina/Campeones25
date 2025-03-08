package com.campeones.proyectomoviles.model.specifications;

import java.time.LocalDate;

import com.campeones.proyectomoviles.model.Entities.Usuario;
import org.springframework.data.jpa.domain.Specification;

import com.campeones.proyectomoviles.model.Entities.Solicitud;

public class SolicitudSpecification {
	public static Specification<Solicitud> hasFechaMinima(LocalDate fechaMin) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("fechaSolicitud"),
				fechaMin);
	}

	public static Specification<Solicitud> hasFechaMaxima(LocalDate fechaMax) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("fechaSolicitud"),
				fechaMax);
	}

	public static Specification<Solicitud> hasContestada(Boolean contestada) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("contestada"),
				contestada);
	}

	public static Specification<Solicitud> hasRemitente(Usuario remitente) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("remitente"),
				remitente);
	}
	public static Specification<Solicitud> hasAnuncio(Long anuncio) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("anuncio_id"),
				anuncio);
	}
}
