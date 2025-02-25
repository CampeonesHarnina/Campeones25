package com.campeones.proyectomoviles.model.Entities;

import java.time.LocalDate;

import com.campeones.proyectomoviles.model.POJO.Estado;
import com.campeones.proyectomoviles.model.POJO.TipoCambio;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EstadisticaSolicitud {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private TipoCambio tipoCambio;
    private Estado estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int totalSolicitudes;
    private int contestadas; 

  //  @ManyToOne(cascade = CascadeType.ALL)
   // private Movil movil;

   // @ManyToOne(cascade = CascadeType.ALL)
   // private Usuario usuario;
}
