package com.campeones.proyectomoviles.entity;

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
	  private Long idSolicitud;
	  @ManyToOne(cascade = CascadeType.ALL)
	  private Usuario idRemitente;
	  @ManyToOne(cascade = CascadeType.ALL)
	  private Usuario idDestinatario;
	  @ManyToOne(cascade = CascadeType.ALL)
	  private Anuncio idAnuncio;
	  private LocalDate fechaSolicitud;
	  private int contestada; 
	  
}
