package com.campeones.proyectomoviles.model.specifications;

import com.campeones.proyectomoviles.model.Entities.Movil;
import org.springframework.data.jpa.domain.Specification;

public class MovilSpecification {

    public static Specification<Movil> hasMarca(String marca) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("marca"), marca);
    }

    public static Specification<Movil> hasMinRam(int min) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("ram"), min);
    }

    public static Specification<Movil> hasMaxRam(int max) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("ram"), max);
    }

    public static Specification<Movil> hasMinPrecio(float min) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("precioActual"), min);
    }

    public static Specification<Movil> hasMaxPrecio(float max) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("precioActual"), max);
    }

    public static Specification<Movil> hasNfc(boolean nfc) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("nfc"), nfc);
    }
}
