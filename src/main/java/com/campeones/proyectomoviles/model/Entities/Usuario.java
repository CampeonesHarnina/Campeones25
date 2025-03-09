package com.campeones.proyectomoviles.model.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@Column(unique = true)
	private String email;
	private String password;
	private Boolean esAdmin;

	@OneToMany(mappedBy = "usuario", orphanRemoval = true, cascade = CascadeType.REMOVE)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private List<Anuncio> anuncios;

	@OneToMany(mappedBy = "remitente", orphanRemoval = true, cascade = CascadeType.REMOVE)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private List<Solicitud> solicitudesEnviadas;

	public Usuario(String nombre, String email, String password, Boolean esAdmin, List<Anuncio> anuncios,
			List<Solicitud> solicitudesEnviadas) {
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.esAdmin = esAdmin;
		this.anuncios = anuncios;
		this.solicitudesEnviadas = solicitudesEnviadas;
	}

	public void removeAnuncio(Anuncio anuncio) {
		anuncios.remove(anuncio);
	}
}
