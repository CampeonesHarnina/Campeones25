package com.campeones.proyectomoviles.model.specifications;

import java.time.LocalDate;

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

	public static Specification<Solicitud> hasRemitente(Long remitente) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("remitente_id"),
				remitente);
	}
	public static Specification<Solicitud> hasDestinatario(Long destinatario) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("destinatario_id"),
				destinatario);
	}
	public static Specification<Solicitud> hasAnuncio(Long anuncio) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("anuncio_id"),
				anuncio);
	}
}
