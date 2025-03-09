package com.campeones.proyectomoviles.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.campeones.proyectomoviles.model.Entities.Usuario;
import com.campeones.proyectomoviles.repositories.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UsuarioRepository userRepository;

	@Autowired
	public UserDetailsServiceImpl(UsuarioRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Busca el usuario por email (username es el email en este contexto)
		Usuario user = userRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario inexistente"));

		// Define los roles basados en el campo esAdmin
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER")); // Todos los usuarios tienen el rol USER
		if (user.getEsAdmin()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN")); // Solo los administradores tienen el rol ADMIN
		}

		log.debug("UserDetailsServiceImpl: Usuario cargado: " + user.getEmail());
		return new User(user.getEmail(), user.getPassword(), authorities);
	}
}