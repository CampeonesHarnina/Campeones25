package com.campeones.proyectomoviles.repositories;

import com.campeones.proyectomoviles.model.Entities.Anuncio;
import com.campeones.proyectomoviles.model.POJO.Estado;
import com.campeones.proyectomoviles.model.POJO.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

    List<Anuncio> findByEstado(Estado estado);
    List<Anuncio> findByTipoCambio(TipoCambio tipoCambio);
    List<Anuncio> findByUsuarioId(Long id);
}
