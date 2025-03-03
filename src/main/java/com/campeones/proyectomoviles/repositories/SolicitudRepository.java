package com.campeones.proyectomoviles.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campeones.proyectomoviles.model.Entities.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

	List<Solicitud> findByDestinatarioId(Long id);

	List<Solicitud> findByRemitenteId(Long id);
}
