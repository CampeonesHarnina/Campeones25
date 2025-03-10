package com.campeones.proyectomoviles.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.campeones.proyectomoviles.model.Entities.Usuario;
import com.campeones.proyectomoviles.repositories.UsuarioRepository;
import com.campeones.proyectomoviles.security.JwtUtils;

@Service
public class AuthenticationService {
	private final UsuarioRepository usuarioRepository;
	private final JwtUtils jwtUtils;
	private final AuthenticationManager authenticationManager;

	public AuthenticationService(UsuarioRepository usuarioRepository, JwtUtils jwtUtils,
			AuthenticationManager authenticationManager) {
		this.usuarioRepository = usuarioRepository;
		this.jwtUtils = jwtUtils;
		this.authenticationManager = authenticationManager;
	}

	public String login(String email, String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		Usuario usuario = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		return jwtUtils.generateAccessToken(usuario.getEmail());
	}
}