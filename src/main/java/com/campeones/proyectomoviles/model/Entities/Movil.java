package com.campeones.proyectomoviles.model.Entities;

import java.time.LocalDate;
import java.util.List;

import com.campeones.proyectomoviles.model.POJO.Resolucion;
import com.campeones.proyectomoviles.model.POJO.ResolucionTarget;
import com.campeones.proyectomoviles.model.POJO.TecnologiaPantalla;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String modelo;
	private int almacenamiento;
	private float tamanioPantalla;
	private TecnologiaPantalla tecnologiaPantalla;
	private int ram;
	private float peso;
	private int camara;
	private int bateria;
	private boolean nfc;
	private float precioActual;
	private LocalDate fechaLanzamiento;
	private int consultas;
	private int proporcionAlto;
	private int proporcionAncho;
	private ResolucionTarget resolucionTarget;
	private Resolucion resolucion;
	private String dimensionesMovil;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "procesador_id")
	private Procesador procesador;

	@OneToMany(mappedBy = "movil", cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private List<Anuncio> anuncios;
}
