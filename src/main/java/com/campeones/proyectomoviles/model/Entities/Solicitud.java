package com.campeones.proyectomoviles.model.Entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private LocalDate fechaSolicitud;
    @NonNull
    private Boolean contestada;

    @NonNull
    @ManyToOne(cascade = CascadeType.MERGE)
    private Usuario remitente;

    @NonNull
    @ManyToOne(cascade = CascadeType.MERGE)
    private Usuario destinatario;

    @NonNull
    @ManyToOne(cascade = CascadeType.MERGE)
    private Anuncio anuncio;

}
