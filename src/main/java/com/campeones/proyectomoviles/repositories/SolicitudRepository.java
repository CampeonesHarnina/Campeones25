package com.campeones.proyectomoviles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campeones.proyectomoviles.model.entities.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

}
