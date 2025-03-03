package com.campeones.proyectomoviles.model.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.campeones.proyectomoviles.model.Entities.Anuncio;
import com.campeones.proyectomoviles.model.POJO.Estado;
import com.campeones.proyectomoviles.model.POJO.TipoCambio;

public class AnuncioSpecification {

	public static Specification<Anuncio> hasEstado(Estado estado) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("estado"), estado);
	}

	public static Specification<Anuncio> hasTipoCambio(TipoCambio tipoCambio) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("tipoCambio"), tipoCambio);
	}

	public static Specification<Anuncio> hasUsuarioId(Long id) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("usuario").get("id"), id);
	}
}
