package com.campeones.proyectomoviles.repositories;

import com.campeones.proyectomoviles.model.Entities.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

    List<Solicitud> findByDestinatarioId(Long id);

    List<Solicitud> findByRemitenteId(Long id);
}
