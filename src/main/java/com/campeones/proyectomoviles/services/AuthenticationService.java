package com.campeones.proyectomoviles.services;

import com.campeones.proyectomoviles.model.DTO.UsuarioDTO;
import com.campeones.proyectomoviles.model.Entities.Usuario;
import com.campeones.proyectomoviles.repositories.UsuarioRepository;
import com.campeones.proyectomoviles.security.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthenticationService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils, AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    public String login(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return jwtUtils.generateAccessToken(usuario.getEmail());
    }

    public UsuarioDTO register(UsuarioDTO usuarioDTO) {
        Optional<Usuario> existingUser = usuarioRepository.findByEmail(usuarioDTO.email());
        if (existingUser.isPresent()) {
            throw new RuntimeException("El email ya está en uso");
        }
        Usuario usuario = new Usuario(usuarioDTO.nombre(), usuarioDTO.email(), passwordEncoder.encode(usuarioDTO.password()), usuarioDTO.esAdmin(), null, null);
        usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario.getId(), usuario.getNombre(), null, usuario.getEmail(), usuario.getEsAdmin());
    }
}