package com.campeones.proyectomoviles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.campeones.proyectomoviles.model.Entities.Movil;

@Repository
public interface MovilRepository extends JpaRepository<Movil, Long>, JpaSpecificationExecutor<Movil> {

}
