package com.campeones.proyectomoviles.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.campeones.proyectomoviles.services.UserDetailsServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@EnableMethodSecurity
public class SecurityConfig {

	private final UserDetailsServiceImpl userDetailsServiceImpl;
	private final JwtUtils jwtUtils;
	private final JwtAuthorizationFilter jwtAuthorizationFilter;

	@Autowired
	public SecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl, JwtUtils jwtUtils,
			JwtAuthorizationFilter jwtAuthorizationFilter) {
		this.userDetailsServiceImpl = userDetailsServiceImpl;
		this.jwtUtils = jwtUtils;
		this.jwtAuthorizationFilter = jwtAuthorizationFilter;
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager)
			throws Exception {
		JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtUtils, authenticationManager);
		jwtAuthenticationFilter.setFilterProcessesUrl("/login");

		return httpSecurity.csrf(csrf -> csrf.disable())
				.cors(cors -> cors.configurationSource(corsConfigurationSource())) // Configuración CORS global
				.authorizeHttpRequests(auth -> {
					auth.requestMatchers("/anuncios/find").permitAll();
					auth.requestMatchers("/anuncios/filter").permitAll();
					auth.requestMatchers("/moviles/find").permitAll();
					auth.requestMatchers("/moviles/filter").permitAll();
					auth.requestMatchers("/procesadores/find").permitAll();
					auth.requestMatchers("/procesadores/filter").permitAll();
					auth.requestMatchers("/login").permitAll(); // Asegurar que /login sea público
					auth.requestMatchers("/usuarios/register").permitAll(); // Asegurar que /register sea público
					auth.anyRequest().authenticated();
				}).sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilter(jwtAuthenticationFilter)
				.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class).build();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(List.of("http://localhost:4200")); // Origen del frontend
		configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Métodos permitidos
		configuration.setAllowedHeaders(List.of("*")); // Permitir todos los encabezados
		configuration.setAllowCredentials(true); // Permitir credenciales si es necesario
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration); // Aplicar a todas las rutas
		return source;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder)
			throws Exception {
		AuthenticationManagerBuilder authBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
		authBuilder.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
		return authBuilder.build();
	}
}