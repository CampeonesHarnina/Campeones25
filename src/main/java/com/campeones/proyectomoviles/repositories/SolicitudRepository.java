package com.campeones.proyectomoviles.repositories;

import com.campeones.proyectomoviles.model.Entities.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

}
