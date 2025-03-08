package com.campeones.proyectomoviles.model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    public Usuario(String nombre, String email, String password, Boolean esAdmin, List<Anuncio> anuncios, List<Solicitud> solicitudesEnviadas) {
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
