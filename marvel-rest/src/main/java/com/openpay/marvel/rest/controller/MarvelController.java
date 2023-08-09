package com.openpay.marvel.rest.controller;

import com.openpay.service.model.MarvelResponse;
import com.openpay.service.service.MarvelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/marvel")
@RequiredArgsConstructor
public class MarvelController {

    private final MarvelService service;

    @GetMapping("/characters")
    public ResponseEntity<MarvelResponse> list(@RequestParam int offset) {
        return ResponseEntity.ok(service.get(null, offset));
    }

    @GetMapping("/characters/{id}")
    public ResponseEntity<MarvelResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id, 0));
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<MarvelResponse> getEvent(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEvent(id));
    }

    @GetMapping("/stories/{id}")
    public ResponseEntity<MarvelResponse> getStory(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStory(id));
    }

    @GetMapping("/series/{id}")
    public ResponseEntity<MarvelResponse> getSerie(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSerie(id));
    }

    @GetMapping("/comics/{id}")
    public ResponseEntity<MarvelResponse> getComic(@PathVariable Long id) {
        return ResponseEntity.ok(service.getComic(id));
    }
}
