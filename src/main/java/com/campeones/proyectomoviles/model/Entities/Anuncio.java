package com.campeones.proyectomoviles.model.Entities;

import java.time.LocalDate;
import java.util.List;

import com.campeones.proyectomoviles.model.POJO.Estado;
import com.campeones.proyectomoviles.model.POJO.TipoCambio;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Anuncio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	@Enumerated(EnumType.STRING)
	private Estado estado;
	@NonNull
	@Enumerated(EnumType.STRING)
	private TipoCambio tipoCambio;
	@NonNull
	private LocalDate fechaPublicacion;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "movil_id")
	@NonNull
	private Movil movil;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "usuario_id")
	@NonNull
	private Usuario usuario;

	@OneToMany(mappedBy = "anuncio", cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	@NonNull
	private List<Solicitud> solicitud;
}
