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
public class Movil {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMovil;
	private String marca;
	private String modelo;
	private int almacenamiento;
	private float tamanioPantalla;
	private String tecnologiaPantalla;
	private int ram;
	private float peso;
	private int camara;
	private int bateria;
	private int nfc;
	private float precioActual;
	private LocalDate fechaLanzamiento;
	private int consultas;
	private String resolucion;
	private String dimensionesMovil;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Procesador procesador;
}
