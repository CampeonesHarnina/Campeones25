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
public class Solicitud {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate fechaSolicitud;
	private Boolean contestada;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Usuario remitente;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Anuncio anuncio;

	public Solicitud(LocalDate fechaSolicitud, Boolean contestada, Usuario remitente, Anuncio anuncio) {
		this.fechaSolicitud = fechaSolicitud;
		this.contestada = contestada;
		this.remitente = remitente;
		this.anuncio = anuncio;
	}
}
