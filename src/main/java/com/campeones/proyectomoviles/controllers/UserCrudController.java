package com.campeones.proyectomoviles.controllers;

import org.springframework.http.ResponseEntity;

public interface UserCrudController<T, T1> {

    ResponseEntity<T> addToUser(T add, T1 id);

    ResponseEntity<T> updateByUser(T put, T1 id);

    ResponseEntity<T> deleteByUser(T erase, T1 id);
}
