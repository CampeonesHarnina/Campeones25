package com.campeones.proyectomoviles.repositories;

import com.campeones.proyectomoviles.model.Entities.Movil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovilRepository extends JpaRepository<Movil, Long>, JpaSpecificationExecutor<Movil> {


}
