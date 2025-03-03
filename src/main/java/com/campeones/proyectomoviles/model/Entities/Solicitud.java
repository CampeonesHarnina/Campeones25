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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDate fechaSolicitud;
	private int contestada;

	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario remitente;

	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario destinatario;

	@ManyToOne(cascade = CascadeType.ALL)
	private Anuncio anuncio;

}
