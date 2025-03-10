package com.campeones.proyectomoviles.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.campeones.proyectomoviles.model.DTO.LoginRequestDTO;
import com.campeones.proyectomoviles.services.AuthenticationService;

import jakarta.validation.Valid;

@RestController
public class AuthenticationController {
	private final AuthenticationService authenticationService;

	public AuthenticationController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody LoginRequestDTO loginRequest) {
		String token = authenticationService.login(loginRequest.email(), loginRequest.password());
		return ResponseEntity.ok(token);
	}

}