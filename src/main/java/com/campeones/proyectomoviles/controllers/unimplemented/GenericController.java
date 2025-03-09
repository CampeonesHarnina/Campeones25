package com.campeones.proyectomoviles.controllers.unimplemented;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface GenericController<K, V> {
	ResponseEntity<List<K>> get();

	ResponseEntity<K> post(K k);

	ResponseEntity<K> put(K k);

	ResponseEntity<K> delete(V v);
}
