package com.example.airline.controllers;

import com.example.airline.dto.AirlineDTO;
import com.example.airline.services.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airlines")
public class AirlineController {
    private final AirlineService airlineService;

    @Autowired
    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
        System.out.println("instancing AirlineController...\n\n\n");
    }

    @GetMapping
    public ResponseEntity<List<AirlineDTO>> findAll() {
        System.out.println("Finding all airlines");
        return ResponseEntity.ok(airlineService.findAll());
    }

    @GetMapping("/find/name/{name}")
    public ResponseEntity<List<AirlineDTO>> findAirlineByName(@PathVariable String name) {
        return ResponseEntity.ok(airlineService.findAirlineByName(name));
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<AirlineDTO> findAirlineById(@PathVariable Long id) {
        return ResponseEntity.ok(airlineService.findAirlineById(id).orElse(null));
    }


    @PostMapping()
    public ResponseEntity<AirlineDTO> createAirline(@RequestBody AirlineDTO airline) {
        return ResponseEntity.ok(airlineService.createAirline(airline));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirlineDTO> updateAirline(@PathVariable Long id, @RequestBody AirlineDTO newAirline) {
        return ResponseEntity.ok(airlineService.updateAirline(id, newAirline).orElse(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirline(@PathVariable Long id) {
        airlineService.deleteAirline(id);
        return ResponseEntity.noContent().build();
    }
}
