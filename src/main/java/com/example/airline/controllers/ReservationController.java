package com.example.airline.controllers;

import com.example.airline.dto.ReservationDTO;
import com.example.airline.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> findAll() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<ReservationDTO> findReservationById(@PathVariable long id) {
        return reservationService.findReservationById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservation) {
        return ResponseEntity.ok(reservationService.createReservation(reservation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDTO> updateReservation(@PathVariable long id, @RequestBody ReservationDTO newReservation) {
        return reservationService.updateReservation(id, newReservation)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
