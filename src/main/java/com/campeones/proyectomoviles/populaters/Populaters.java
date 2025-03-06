package com.campeones.proyectomoviles.populaters;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.campeones.proyectomoviles.model.POJO.ResolucionTarget;
import com.campeones.proyectomoviles.model.POJO.TecnologiaPantalla;
import jakarta.transaction.Transactional;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.campeones.proyectomoviles.model.Entities.Anuncio;
import com.campeones.proyectomoviles.model.Entities.Movil;
import com.campeones.proyectomoviles.model.Entities.Procesador;
import com.campeones.proyectomoviles.model.Entities.Solicitud;
import com.campeones.proyectomoviles.model.Entities.Usuario;
import com.campeones.proyectomoviles.model.POJO.Estado;
import com.campeones.proyectomoviles.model.POJO.TipoCambio;
import com.campeones.proyectomoviles.repositories.AnuncioRepository;
import com.campeones.proyectomoviles.repositories.MovilRepository;
import com.campeones.proyectomoviles.repositories.ProcesadorRepository;
import com.campeones.proyectomoviles.repositories.SolicitudRepository;
import com.campeones.proyectomoviles.repositories.UsuarioRepository;

import jakarta.annotation.PostConstruct;

@Component
@ConditionalOnProperty(name = "spring.jpa.hibernate.ddl-auto", havingValue = "create", matchIfMissing = false)
public class Populaters {
    private final AnuncioRepository anuncioRepository;
    private final MovilRepository movilRepository;
    private final ProcesadorRepository procesadorRepository;
    private final SolicitudRepository solicitudRepository;
    private final UsuarioRepository usuarioRepositoty;

    public Populaters(AnuncioRepository anuncioRepository, MovilRepository movilRepository,
                      ProcesadorRepository procesadorRepository, SolicitudRepository solicitudRepository,
                      UsuarioRepository usuarioRepositoty) {
        super();
        this.anuncioRepository = anuncioRepository;
        this.movilRepository = movilRepository;
        this.procesadorRepository = procesadorRepository;
        this.solicitudRepository = solicitudRepository;
        this.usuarioRepositoty = usuarioRepositoty;
    }

    @Transactional
    @PostConstruct
    public void populate() {
        List<Usuario> usuarios = new ArrayList<>(List.of(
                new Usuario("Juan Pérez", "juan@example.com", "password123", false, new ArrayList<>(), new ArrayList<>()),
                new Usuario("María Gómez", "maria@example.com", "securePass", true, new ArrayList<>(), new ArrayList<>()),
                new Usuario("Carlos Rodríguez", "carlos@example.com", "passCarlos", false, new ArrayList<>(), new ArrayList<>()),
                new Usuario("Ana Torres", "ana@example.com", "torres123", true, new ArrayList<>(), new ArrayList<>()),
                new Usuario("Luis Méndez", "luis@example.com", "luispass", false, new ArrayList<>(), new ArrayList<>()),
                new Usuario("Laura Sánchez", "laura@example.com", "laura2022", true, new ArrayList<>(), new ArrayList<>()),
                new Usuario("Pedro Fernández", "pedro@example.com", "pedroPass", false, new ArrayList<>(), new ArrayList<>()),
                new Usuario("Sofía Martínez", "sofia@example.com", "sofiaPass", true, new ArrayList<>(), new ArrayList<>()),
                new Usuario("Elena Ríos", "elena@example.com", "elena123", false, new ArrayList<>(), new ArrayList<>()),
                new Usuario("Ricardo Morales", "ricardo@example.com", "ricardoPass", true, new ArrayList<>(), new ArrayList<>())
        ));
        List<Procesador> procesadores = new ArrayList<>(List.of(
                new Procesador("Snapdragon 888", 8, 2.84f, new ArrayList<>()),
                new Procesador("Apple A15 Bionic", 6, 3.23f, new ArrayList<>()),
                new Procesador("Google Tensor", 8, 2.80f, new ArrayList<>()),
                new Procesador("Exynos 2100", 8, 2.90f, new ArrayList<>()),
                new Procesador("Dimensity 1200", 8, 3.00f, new ArrayList<>()),
                new Procesador("Kirin 9000", 8, 3.13f, new ArrayList<>()),
                new Procesador("Snapdragon 8 Gen 1", 8, 3.00f, new ArrayList<>()),
                new Procesador("Apple M1", 8, 3.20f, new ArrayList<>()),
                new Procesador("Helio G95", 8, 2.05f, new ArrayList<>()),
                new Procesador( "Exynos 2200", 8, 3.00f, new ArrayList<>())
        ));
        List<Movil> moviles = new ArrayList<>(List.of(
                new Movil("Samsung", "Galaxy S21", 128, 6.2f, TecnologiaPantalla.OLED, 8, 169.0f, 64, 4000, true, 799.99f, LocalDate.of(2021, 1, 29), 50, 20, 9, ResolucionTarget.FULLHD, "151.7 x 71.2 x 7.9 mm", procesadores.get(0)),
                new Movil("Apple", "iPhone 13", 256, 6.1f, TecnologiaPantalla.LCD, 6, 174.0f, 12, 3240, false, 999.99f, LocalDate.of(2021, 9, 24), 70, 19, 9, ResolucionTarget.FULLHDPLUS, "146.7 x 71.5 x 7.7 mm", procesadores.get(1)),
                new Movil("Google", "Pixel 6", 128, 6.4f, TecnologiaPantalla.AMOLED, 8, 207.0f, 50, 4614, true, 599.99f, LocalDate.of(2021, 10, 28), 60, 16, 9, ResolucionTarget.QHD, "158.6 x 74.8 x 8.9 mm", procesadores.get(8)),
                new Movil("OnePlus", "9 Pro", 256, 6.7f, TecnologiaPantalla.AMOLED, 12, 197.0f, 48, 4500, false, 899.99f, LocalDate.of(2021, 3, 23), 40, 16, 9, ResolucionTarget.HD, "163.2 x 73.6 x 8.7 mm", procesadores.get(9)),
                new Movil("Xiaomi", "Mi 11", 128, 6.81f, TecnologiaPantalla.OLED, 8, 196.0f, 108, 4600, true, 749.99f, LocalDate.of(2021, 1, 1), 30, 20, 9, ResolucionTarget.FULLHD, "164.3 x 74.6 x 8.1 mm", procesadores.get(6)),
                new Movil("Sony", "Xperia 5 III", 256, 6.1f, TecnologiaPantalla.OLED, 8, 168.0f, 12, 4500, false, 999.99f, LocalDate.of(2021, 4, 14), 25, 21, 9, ResolucionTarget.QHD, "157 x 68 x 8.2 mm", procesadores.get(3)),
                new Movil("Realme", "GT 2 Pro", 128, 6.7f, TecnologiaPantalla.LCD, 12, 189.0f, 50, 5000, true, 699.99f, LocalDate.of(2022, 2, 28), 35, 20, 9, ResolucionTarget.FULLHDPLUS, "163.2 x 74.7 x 8.2 mm", procesadores.get(7)),
                new Movil("Motorola", "Edge 20", 256, 6.7f, TecnologiaPantalla.OLED, 8, 163.0f, 108, 4000, false, 499.99f, LocalDate.of(2021, 8, 15), 20, 20, 9, ResolucionTarget.FULLHD, "163 x 76 x 7 mm", procesadores.get(4)),
                new Movil("Huawei", "P50 Pro", 128, 6.6f, TecnologiaPantalla.LCD, 8, 195.0f, 50, 4360, true, 799.99f, LocalDate.of(2021, 7, 29), 45, 21, 9, ResolucionTarget.UHD, "158.8 x 72.8 x 8.5 mm", procesadores.get(5)),
                new Movil( "Asus", "ROG Phone 5", 512, 6.78f, TecnologiaPantalla.LCD, 16, 239.0f, 64, 6000, false, 1099.99f, LocalDate.of(2021, 3, 10), 60, 20, 9, ResolucionTarget.HD, "172.8 x 77.3 x 10.3 mm", procesadores.get(2))
        ));
        List<Anuncio> anuncios = new ArrayList<>(List.of(
                new Anuncio(Estado.INTACTO, TipoCambio.VENTA, LocalDate.now(), moviles.get(0), usuarios.get(1), new ArrayList<>()),
                new Anuncio(Estado.INTACTO, TipoCambio.INTERCAMBIO, LocalDate.now().minusDays(5), moviles.get(1), usuarios.get(0), new ArrayList<>()),
                new Anuncio(Estado.EXPERIMENTADO, TipoCambio.VENTA, LocalDate.now().minusDays(10), moviles.get(2), usuarios.get(1), new ArrayList<>()),
                new Anuncio(Estado.HEROE_DE_GUERRA, TipoCambio.INTERCAMBIO, LocalDate.now().minusDays(15), moviles.get(3), usuarios.get(0), new ArrayList<>()),
                new Anuncio(Estado.SUPERVIVIENTE, TipoCambio.VENTA, LocalDate.now().minusDays(20), moviles.get(4), usuarios.get(2), new ArrayList<>()),
                new Anuncio(Estado.EXPERIMENTADO, TipoCambio.INTERCAMBIO, LocalDate.now().minusDays(25), moviles.get(5), usuarios.get(3), new ArrayList<>()),
                new Anuncio(Estado.INTACTO, TipoCambio.VENTA, LocalDate.now().minusDays(30), moviles.get(6), usuarios.get(6), new ArrayList<>()),
                new Anuncio(Estado.SUPERVIVIENTE, TipoCambio.INTERCAMBIO, LocalDate.now().minusDays(35), moviles.get(7), usuarios.get(2), new ArrayList<>()),
                new Anuncio(Estado.HEROE_DE_GUERRA, TipoCambio.VENTA, LocalDate.now().minusDays(40), moviles.get(8), usuarios.get(7), new ArrayList<>()),
                new Anuncio( Estado.EXPERIMENTADO, TipoCambio.INTERCAMBIO, LocalDate.now().minusDays(45), moviles.get(9), usuarios.get(9), new ArrayList<>())

        ));
        List<Solicitud> solicitudes = new ArrayList<>(List.of(
                new Solicitud(LocalDate.now().minusDays(5), true, usuarios.get(1), anuncios.get(0)),
                new Solicitud(LocalDate.now().minusDays(10), false, usuarios.get(0), anuncios.get(1)),
                new Solicitud(LocalDate.now().minusDays(15), true, usuarios.get(3), anuncios.get(5)),
                new Solicitud(LocalDate.now().minusDays(20), false, usuarios.get(7), anuncios.get(8)),
                new Solicitud(LocalDate.now().minusDays(25), true, usuarios.get(7), anuncios.get(8)),
                new Solicitud(LocalDate.now().minusDays(30), false, usuarios.get(9), anuncios.get(9)),
                new Solicitud(LocalDate.now().minusDays(35), true, usuarios.get(2), anuncios.get(4)),
                new Solicitud(LocalDate.now().minusDays(40), false, usuarios.get(9), anuncios.get(9)),
                new Solicitud(LocalDate.now().minusDays(45), true, usuarios.get(3), anuncios.get(5)),
                new Solicitud( LocalDate.now().minusDays(50), false, usuarios.get(1), anuncios.get(2))
        ));

        usuarios.forEach(usuarioRepositoty::saveAndFlush);
        procesadores.forEach(procesadorRepository::saveAndFlush);
        moviles.forEach(movilRepository::saveAndFlush);
        anuncios.forEach(anuncioRepository::saveAndFlush);
        solicitudes.forEach(solicitudRepository::saveAndFlush);
    }
}