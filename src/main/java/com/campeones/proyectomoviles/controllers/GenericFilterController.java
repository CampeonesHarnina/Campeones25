package com.campeones.proyectomoviles.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface GenericFilterController<R, S, I> {

	ResponseEntity<List<R>> get();

	ResponseEntity<R> post(R r);

	ResponseEntity<R> put(R r);

	ResponseEntity<R> delete(I id);

	// Make abstract method with variable number of parameters and generic type
	ResponseEntity<List<R>> getByFilter(S spec);
}
