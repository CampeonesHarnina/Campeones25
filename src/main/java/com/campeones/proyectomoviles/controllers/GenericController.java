package com.campeones.proyectomoviles.controllers;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenericController<R,S,I> {

    ResponseEntity<List<R>> get();
    ResponseEntity<R> post(R r);
    ResponseEntity<R> put (R r);
    ResponseEntity<R> delete(I id);
    //Make abstract method with variable number of parameters and generic type
    ResponseEntity<List<R>> getByFilter(S spec);
}
