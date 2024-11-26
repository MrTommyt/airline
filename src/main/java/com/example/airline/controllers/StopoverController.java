package com.example.airline.controllers;

import com.example.airline.dto.StopoverDTO;
import com.example.airline.models.Stopover;
import com.example.airline.services.StopoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stopovers")
public class StopoverController {
    private final StopoverService stopoverService;

    @Autowired
    public StopoverController(StopoverService stopoverService) {this.stopoverService = stopoverService;}

    @GetMapping("/find/flight/{flightId}/airport/{airportId}")
    public ResponseEntity<StopoverDTO> findStopoverById(@PathVariable Long flightId, @PathVariable Long airportId) {
        return ResponseEntity.ok(stopoverService.findStopoverById(new Stopover.StopoverKey(flightId, airportId))
            .orElse(null));
    }

    @PostMapping
    public ResponseEntity<StopoverDTO> createStopover(@RequestBody StopoverDTO stopover) {
        return ResponseEntity.status(HttpStatus.CREATED).body(stopoverService.createStopover(stopover));
    }

    @PutMapping("/flight/{flightId}/airport/{airportId}")
    public ResponseEntity<StopoverDTO> updateStopover(@PathVariable Long flightId, @PathVariable Long airportId, @RequestBody StopoverDTO stopover) {
        return stopoverService.updateStopover(new Stopover.StopoverKey(flightId, airportId), stopover)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/flight/{flightId}/airport/{airportId}")
    public ResponseEntity<Void> deleteStopover(@PathVariable Long flightId, @PathVariable Long airportId) {
        stopoverService.deleteStopover(new Stopover.StopoverKey(flightId, airportId));
        return ResponseEntity.noContent().build();
    }
}
