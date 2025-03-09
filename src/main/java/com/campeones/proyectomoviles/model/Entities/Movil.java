package com.campeones.proyectomoviles.model.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.campeones.proyectomoviles.model.POJO.Resolucion;
import com.campeones.proyectomoviles.model.POJO.ResolucionTarget;
import com.campeones.proyectomoviles.model.POJO.TecnologiaPantalla;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
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
public class Movil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String modelo;
	private int almacenamiento;
	private float tamanioPantalla;
	@Enumerated(EnumType.STRING)
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
	@Enumerated(EnumType.ORDINAL)
	private ResolucionTarget resolucionTarget;
	@Embedded
	private Resolucion resolucion;
	private String dimensionesMovil;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "procesador_id")
	private Procesador procesador;

	@OneToMany(mappedBy = "movil", cascade = CascadeType.REMOVE)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private List<Anuncio> anuncios;

	public Movil(String marca, String modelo, int almacenamiento, float tamanioPantalla,
			TecnologiaPantalla tecnologiaPantalla, int ram, float peso, int camara, int bateria, boolean nfc,
			float precioActual, LocalDate fechaLanzamiento, int consultas, int proporcionAlto, int proporcionAncho,
			ResolucionTarget resolucionTarget, String dimensionesMovil, Procesador procesador) {
		this.marca = marca;
		this.modelo = modelo;
		this.almacenamiento = almacenamiento;
		this.tamanioPantalla = tamanioPantalla;
		this.tecnologiaPantalla = tecnologiaPantalla;
		this.ram = ram;
		this.peso = peso;
		this.camara = camara;
		this.bateria = bateria;
		this.nfc = nfc;
		this.precioActual = precioActual;
		this.fechaLanzamiento = fechaLanzamiento;
		this.consultas = consultas;
		this.proporcionAlto = proporcionAlto;
		this.proporcionAncho = proporcionAncho;
		this.resolucionTarget = resolucionTarget;
		this.dimensionesMovil = dimensionesMovil;
		this.procesador = procesador;
		this.resolucion = new Resolucion(proporcionAlto, proporcionAncho, resolucionTarget);
		this.anuncios = new ArrayList<>();
	}
}
