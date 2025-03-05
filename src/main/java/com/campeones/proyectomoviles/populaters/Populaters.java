package com.campeones.proyectomoviles.populaters;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
@ConditionalOnProperty(name="spring.jpa.hibernate.ddl-auto",havingValue = "create",matchIfMissing = false)
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
	
	@PostConstruct
	public void populate() {
		List<Anuncio> anuncios = new ArrayList<>(List.of(
			    new Anuncio(1L, Estado.INTACTO, TipoCambio.VENTA, LocalDate.now(), null, null, new ArrayList<>()),
			    new Anuncio(2L, Estado.INTACTO, TipoCambio.INTERCAMBIO, LocalDate.now().minusDays(5), null, null, new ArrayList<>()),
			    new Anuncio(3L, Estado.EXPERIMENTADO, TipoCambio.VENTA, LocalDate.now().minusDays(10), null, null, new ArrayList<>()),
			    new Anuncio(4L, Estado.HEROE_DE_GUERRA, TipoCambio.INTERCAMBIO, LocalDate.now().minusDays(15), null, null, new ArrayList<>()),
			    new Anuncio(5L, Estado.SUPERVIVIENTE, TipoCambio.VENTA, LocalDate.now().minusDays(20), null, null, new ArrayList<>()),
			    new Anuncio(6L, Estado.EXPERIMENTADO, TipoCambio.INTERCAMBIO, LocalDate.now().minusDays(25), null, null, new ArrayList<>()),
			    new Anuncio(7L, Estado.INTACTO, TipoCambio.VENTA, LocalDate.now().minusDays(30), null, null, new ArrayList<>()),
			    new Anuncio(8L, Estado.SUPERVIVIENTE, TipoCambio.INTERCAMBIO, LocalDate.now().minusDays(35), null, null, new ArrayList<>()),
			    new Anuncio(9L, Estado.HEROE_DE_GUERRA, TipoCambio.VENTA, LocalDate.now().minusDays(40), null, null, new ArrayList<>()),
			    new Anuncio(10L, Estado.EXPERIMENTADO, TipoCambio.INTERCAMBIO, LocalDate.now().minusDays(45), null, null, new ArrayList<>())
			));
		List<Movil> moviles = new ArrayList<>(List.of(
			    new Movil(1L, "Samsung", "Galaxy S21", 128, 6.2f, null, 8, 169.0f, 64, 4000, true, 799.99f, LocalDate.of(2021, 1, 29), 50, 20, 9, null, null, "151.7 x 71.2 x 7.9 mm", null, new ArrayList<>()),
			    new Movil(2L, "Apple", "iPhone 13", 256, 6.1f, null, 6, 174.0f, 12, 3240, false, 999.99f, LocalDate.of(2021, 9, 24), 70, 19, 9, null, null, "146.7 x 71.5 x 7.7 mm", null, new ArrayList<>()),
			    new Movil(3L, "Google", "Pixel 6", 128, 6.4f, null, 8, 207.0f, 50, 4614, true, 599.99f, LocalDate.of(2021, 10, 28), 60, 20, 9, null, null, "158.6 x 74.8 x 8.9 mm", null, new ArrayList<>()),
			    new Movil(4L, "OnePlus", "9 Pro", 256, 6.7f, null, 12, 197.0f, 48, 4500, false, 899.99f, LocalDate.of(2021, 3, 23), 40, 20, 9, null, null, "163.2 x 73.6 x 8.7 mm", null, new ArrayList<>()),
			    new Movil(5L, "Xiaomi", "Mi 11", 128, 6.81f, null, 8, 196.0f, 108, 4600, true, 749.99f, LocalDate.of(2021, 1, 1), 30, 20, 9, null, null, "164.3 x 74.6 x 8.1 mm", null, new ArrayList<>()),
			    new Movil(6L, "Sony", "Xperia 5 III", 256, 6.1f, null, 8, 168.0f, 12, 4500, false, 999.99f, LocalDate.of(2021, 4, 14), 25, 20, 9, null, null, "157 x 68 x 8.2 mm", null, new ArrayList<>()),
			    new Movil(7L, "Realme", "GT 2 Pro", 128, 6.7f, null, 12, 189.0f, 50, 5000, true, 699.99f, LocalDate.of(2022, 2, 28), 35, 20, 9, null, null, "163.2 x 74.7 x 8.2 mm", null, new ArrayList<>()),
			    new Movil(8L, "Motorola", "Edge 20", 256, 6.7f, null, 8, 163.0f, 108, 4000, false, 499.99f, LocalDate.of(2021, 8, 15), 20, 20, 9, null, null, "163 x 76 x 7 mm", null, new ArrayList<>()),
			    new Movil(9L, "Huawei", "P50 Pro", 128, 6.6f, null, 8, 195.0f, 50, 4360, true, 799.99f, LocalDate.of(2021, 7, 29), 45, 20, 9, null, null, "158.8 x 72.8 x 8.5 mm", null, new ArrayList<>()),
			    new Movil(10L, "Asus", "ROG Phone 5", 512, 6.78f, null, 16, 239.0f, 64, 6000, false, 1099.99f, LocalDate.of(2021, 3, 10), 60, 20, 9, null, null, "172.8 x 77.3 x 10.3 mm", null, new ArrayList<>())
			));
		List<Procesador> procesadores = new ArrayList<>(List.of(
			    new Procesador(1L, "Snapdragon 888", 8, 2.84f, new ArrayList<>()),
			    new Procesador(2L, "Apple A15 Bionic", 6, 3.23f, new ArrayList<>()),
			    new Procesador(3L, "Google Tensor", 8, 2.80f, new ArrayList<>()),
			    new Procesador(4L, "Exynos 2100", 8, 2.90f, new ArrayList<>()),
			    new Procesador(5L, "Dimensity 1200", 8, 3.00f, new ArrayList<>()),
			    new Procesador(6L, "Kirin 9000", 8, 3.13f, new ArrayList<>()),
			    new Procesador(7L, "Snapdragon 8 Gen 1", 8, 3.00f, new ArrayList<>()),
			    new Procesador(8L, "Apple M1", 8, 3.20f, new ArrayList<>()),
			    new Procesador(9L, "Helio G95", 8, 2.05f, new ArrayList<>()),
			    new Procesador(10L, "Exynos 2200", 8, 3.00f, new ArrayList<>())
			));
		List<Solicitud> solicitudes = new ArrayList<>(List.of(
			    new Solicitud(1L, LocalDate.now().minusDays(5), 1, null, null, null),
			    new Solicitud(2L, LocalDate.now().minusDays(10), 0, null, null, null),
			    new Solicitud(3L, LocalDate.now().minusDays(15), 1, null, null, null),
			    new Solicitud(4L, LocalDate.now().minusDays(20), 0, null, null, null),
			    new Solicitud(5L, LocalDate.now().minusDays(25), 1, null, null, null),
			    new Solicitud(6L, LocalDate.now().minusDays(30), 0, null, null, null),
			    new Solicitud(7L, LocalDate.now().minusDays(35), 1, null, null, null),
			    new Solicitud(8L, LocalDate.now().minusDays(40), 0, null, null, null),
			    new Solicitud(9L, LocalDate.now().minusDays(45), 1, null, null, null),
			    new Solicitud(10L, LocalDate.now().minusDays(50), 0, null, null, null)
			));
		List<Usuario> usuarios = new ArrayList<>(List.of(
			    new Usuario(1L, "Juan Pérez", "juan@example.com", "password123", false, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
			    new Usuario(2L, "María Gómez", "maria@example.com", "securePass", true, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
			    new Usuario(3L, "Carlos Rodríguez", "carlos@example.com", "passCarlos", false, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
			    new Usuario(4L, "Ana Torres", "ana@example.com", "torres123", true, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
			    new Usuario(5L, "Luis Méndez", "luis@example.com", "luispass", false, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
			    new Usuario(6L, "Laura Sánchez", "laura@example.com", "laura2022", true, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
			    new Usuario(7L, "Pedro Fernández", "pedro@example.com", "pedroPass", false, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
			    new Usuario(8L, "Sofía Martínez", "sofia@example.com", "sofiaPass", true, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
			    new Usuario(9L, "Elena Ríos", "elena@example.com", "elena123", false, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
			    new Usuario(10L, "Ricardo Morales", "ricardo@example.com", "ricardoPass", true, new ArrayList<>(), new ArrayList<>(), new ArrayList<>())
			));
	}
}