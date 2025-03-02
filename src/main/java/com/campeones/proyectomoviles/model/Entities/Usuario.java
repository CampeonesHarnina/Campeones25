package com.campeones.proyectomoviles.model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    @Column(unique = true)
    private String email;
    private String password;
    private boolean esAdmin;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private List<Anuncio> anuncios;

    @OneToMany(mappedBy = "remitente", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private List<Solicitud> solicitudesEnviadas;

    @OneToMany(mappedBy = "destinatario", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private List<Solicitud> solicitudesRecibidas;
}
