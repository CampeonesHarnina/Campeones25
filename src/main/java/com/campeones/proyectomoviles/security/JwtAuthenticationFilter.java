package com.campeones.proyectomoviles.security;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public JwtAuthenticationFilter(JwtUtils jwtUtils, AuthenticationManager authenticationManager) {
        super();
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        // Manejar solicitudes OPTIONS (preflight)
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            log.debug("JwtAuthenticationFilter: Ignorando solicitud OPTIONS");
            return null; // No procesar autenticación para OPTIONS
        }

        String email;
        String password;
        try {
            if (request.getContentLength() <= 0) {
                log.error("JwtAuthenticationFilter: No se proporcionó cuerpo en la solicitud");
                throw new AuthenticationException("No se proporcionó cuerpo en la solicitud") {
                    private static final long serialVersionUID = 1L;
                };
            }

            HashMap<String, String> credentials = new ObjectMapper().readValue(request.getInputStream(), HashMap.class);
            email = credentials.get("email");
            password = credentials.get("password");

            if (email == null || password == null) {
                throw new AuthenticationException("Email o contraseña no proporcionados") {
                    private static final long serialVersionUID = 1L;
                };
            }

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(email, password);
            log.info("JwtAuthenticationFilter: Intentando autenticar a " + email);
            return getAuthenticationManager().authenticate(authToken);
        } catch (IOException e) {
            log.error("JwtAuthenticationFilter: Error al procesar las credenciales", e);
            throw new AuthenticationException("Error al procesar las credenciales: " + e.getMessage()) {
                private static final long serialVersionUID = 1L;
            };
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();
        String accessToken = jwtUtils.generateAccessToken(user.getUsername());
        String refreshToken = jwtUtils.generateRefreshToken(user);

        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("access_token", accessToken);
        responseBody.put("refresh_token", refreshToken);
        responseBody.put("message", "Autenticación correcta");
        responseBody.put("usuario", user.getUsername());

        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getWriter(), responseBody);
        log.info("JwtAuthenticationFilter: Usuario autenticado: " + user.getUsername());
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {
        HashMap<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Autenticación fallida: " + failed.getMessage());

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getWriter(), errorResponse);
        log.warn("JwtAuthenticationFilter: Fallo de autenticación: " + failed.getMessage());
    }
}