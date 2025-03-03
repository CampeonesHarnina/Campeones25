package com.campeones.proyectomoviles.model.DTO;

import java.time.LocalDate;

import com.campeones.proyectomoviles.model.POJO.Estado;
import com.campeones.proyectomoviles.model.POJO.TipoCambio;

public record AnuncioDTO(Long id, Estado estado, TipoCambio tipoCambio, LocalDate fechaPublicacion) {
}
