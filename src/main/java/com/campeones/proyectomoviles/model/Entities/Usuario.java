package com.campeones.proyectomoviles.model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Usuario {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nombre;
    @NonNull
    @Column(unique = true)
    private String email;
    @NonNull
    private String password;
    @NonNull
    private Boolean esAdmin;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.MERGE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @NonNull
    private List<Anuncio> anuncios;

    @OneToMany(mappedBy = "remitente", cascade = CascadeType.MERGE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @NonNull
    private List<Solicitud> solicitudesEnviadas;

}
