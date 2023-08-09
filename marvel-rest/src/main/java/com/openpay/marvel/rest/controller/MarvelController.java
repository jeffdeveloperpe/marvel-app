package com.openpay.marvel.rest.controller;

import com.openpay.service.model.MarvelResponse;
import com.openpay.service.service.MarvelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/marvel/characters")
@RequiredArgsConstructor
public class MarvelController {

    private final MarvelService service;

    @GetMapping
    public ResponseEntity<MarvelResponse> list() {
        return ResponseEntity.ok(service.get(null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarvelResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}
