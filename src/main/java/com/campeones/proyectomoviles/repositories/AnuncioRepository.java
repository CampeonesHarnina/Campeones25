package com.campeones.proyectomoviles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.campeones.proyectomoviles.model.Entities.Anuncio;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long>, JpaSpecificationExecutor<Anuncio> {

}
