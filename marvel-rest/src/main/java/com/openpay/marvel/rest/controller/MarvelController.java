package com.openpay.marvel.rest.controller;

import com.openpay.service.model.MarvelResponse;
import com.openpay.service.service.MarvelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/marvel/characters")
@RequiredArgsConstructor
public class MarvelController {

    private final MarvelService service;

    @GetMapping
    public ResponseEntity<MarvelResponse> list(@RequestParam int offset) {
        return ResponseEntity.ok(service.get(null, offset));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarvelResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id, 0));
    }
}
