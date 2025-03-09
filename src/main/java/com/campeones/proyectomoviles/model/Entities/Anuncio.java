package com.campeones.proyectomoviles.model.Entities;

import java.time.LocalDate;
import java.util.List;

import com.campeones.proyectomoviles.model.POJO.Estado;
import com.campeones.proyectomoviles.model.POJO.TipoCambio;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
public class Anuncio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private Estado estado;
	@Enumerated(EnumType.STRING)
	private TipoCambio tipoCambio;
	private LocalDate fechaPublicacion;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "movil_id")
	private Movil movil;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@OneToMany(mappedBy = "anuncio", cascade = CascadeType.REMOVE)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private List<Solicitud> solicitud;

	public Anuncio(Estado estado, TipoCambio tipoCambio, LocalDate fechaPublicacion, Movil movil, Usuario usuario,
			List<Solicitud> solicitud) {
		this.estado = estado;
		this.tipoCambio = tipoCambio;
		this.fechaPublicacion = fechaPublicacion;
		this.movil = movil;
		this.usuario = usuario;
		this.solicitud = solicitud;
	}

}
