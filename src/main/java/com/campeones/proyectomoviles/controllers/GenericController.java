package com.campeones.proyectomoviles.controllers;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenericController<K, V> {
    ResponseEntity<List<K>> get();

    ResponseEntity<K> post(K k);

    ResponseEntity<K> put(K k);

    ResponseEntity<K> delete(V v);
}
