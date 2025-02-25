package com.campeones.proyectomoviles.model.DTO;

import com.campeones.proyectomoviles.model.Entities.Procesador;
import com.campeones.proyectomoviles.model.POJO.AspectRatio;
import com.campeones.proyectomoviles.model.POJO.Resolucion;
import com.campeones.proyectomoviles.model.POJO.ResolucionTarget;
import com.campeones.proyectomoviles.model.POJO.TecnologiaPantalla;

import java.time.LocalDate;

public record MovilDTO(
        Long id,
        String marca,
        String modelo,
        int almacenamiento,
        float tamanioPantalla,
        AspectRatio aspectRatio,
        TecnologiaPantalla tecnologiaPantalla,
        int ram,
        float peso,
        int camara,
        int bateria,
        int nfc,
        float precioActual,
        LocalDate fechaLanzamiento,
        int consultas,
        int proporcionAlto,
        int proporcionAncho,
        ResolucionTarget resolucionTarget,
        Resolucion resolucion,
        String dimensionesMovil,
        Procesador procesador
) {
}
