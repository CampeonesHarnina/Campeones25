package com.campeones.proyectomoviles.model.Entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Anuncio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAnuncio;
	private Estado estado;
	private TipoCambio tipoCambio;
	private LocalDate fechaPublicacion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Movil movil;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
}
