package com.campeones.proyectomoviles.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserCrudController<T, T1> {

    ResponseEntity<List<T>> getByUser(@RequestHeader("Authorization") String token);
    ResponseEntity<T> addToUser(@RequestBody T add, @RequestHeader("Authorization") String token);

    ResponseEntity<T> updateByUser(@RequestBody T put,@RequestHeader("Authorization") String token);

    ResponseEntity<T> deleteByUser(@PathVariable T1 erase,@RequestHeader("Authorization") String token);
}
