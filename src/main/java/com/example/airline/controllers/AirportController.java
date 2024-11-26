package com.example.airline.controllers;

import com.example.airline.dto.AirportDTO;
import com.example.airline.services.AirportService;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1/airports")
public class AirportController {
    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public ResponseEntity<List<AirportDTO>> findAll() {
        return ResponseEntity.ok(airportService.findAll());
    }

    @GetMapping("/find/name/{name}")
    public ResponseEntity<List<AirportDTO>> findAirportByName(@PathVariable String name) {
        return ResponseEntity.ok(airportService.findAirportByName(name));
    }

    @GetMapping("/find/name/{id}")
    public ResponseEntity<AirportDTO> findAirportById(@PathVariable Long id) {
        return ResponseEntity.ok(airportService.findAirportById(id).orElse(null));
    }

    @PostMapping
    public ResponseEntity<AirportDTO> createAirport(@RequestBody AirportDTO airport) {
        return ResponseEntity.ok(airportService.createAirport(airport));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportDTO> updateAirport(@PathVariable Long id, @RequestBody AirportDTO newAirport) {
        return airportService.updateAirport(id, newAirport)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
        return ResponseEntity.noContent().build();
    }
}
