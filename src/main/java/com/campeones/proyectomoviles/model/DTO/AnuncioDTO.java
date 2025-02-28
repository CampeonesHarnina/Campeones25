package com.campeones.proyectomoviles.model.DTO;

import com.campeones.proyectomoviles.model.POJO.Estado;
import com.campeones.proyectomoviles.model.POJO.TipoCambio;

import java.time.LocalDate;

public record AnuncioDTO(Long id, Estado estado, TipoCambio tipoCambio, LocalDate fechaPublicacion) {
}
