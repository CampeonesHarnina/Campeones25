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
@AllArgsConstructor
@Data
public class Anuncio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Estado estado;
	private TipoCambio tipoCambio;
	private LocalDate fechaPublicacion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Movil movil;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario usuario;

	@OneToMany(mappedBy = "anuncio", cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private List<Solicitud> solicitud;
}
