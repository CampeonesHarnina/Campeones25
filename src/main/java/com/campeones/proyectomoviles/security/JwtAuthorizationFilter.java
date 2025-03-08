package com.campeones.proyectomoviles.security;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.campeones.proyectomoviles.services.UserDetailsServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {
	private final JwtUtils jwtUtils;
	private final UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	public JwtAuthorizationFilter(JwtUtils jwtUtils, UserDetailsServiceImpl userDetailsServiceImpl) {
		this.jwtUtils = jwtUtils;
		this.userDetailsServiceImpl = userDetailsServiceImpl;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header = request.getHeader("Authorization");
		log.debug("JwtAuthorizationFilter: Header recibido: " + header);

		isValidBearerHeader(header).ifPresent(token -> {
			if (jwtUtils.isTokenValid(token)) {
				String username = jwtUtils.getEmailFromToken(token); // username es email aquí
				UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authToken);
				log.debug("JwtAuthorizationFilter: Token válido, usuario autenticado: " + username);
			} else {
				log.warn("JwtAuthorizationFilter: Token inválido: " + token);
			}
		});

		filterChain.doFilter(request, response);
	}

	private Optional<String> isValidBearerHeader(String header) {
		String prefix = "Bearer ";
		return header != null && header.startsWith(prefix) ? Optional.of(header.substring(prefix.length()))
				: Optional.empty();
	}
}