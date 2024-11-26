package com.example.airline.controllers;

import com.example.airline.dto.ReservationDTO;
import com.example.airline.models.Reservation;
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

    @GetMapping("/customer/{customerId}/flight/{flightId}")
    public ResponseEntity<ReservationDTO> findReservationById(@PathVariable Long customerId, @PathVariable Long flightId) {
        return reservationService.findReservationById(new Reservation.ReservationKey(customerId, flightId))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservation) {
        return ResponseEntity.ok(reservationService.createReservation(reservation));
    }

    @PutMapping("/customer/{customerId}/flight/{flightId}")
    public ResponseEntity<ReservationDTO> updateReservation(@PathVariable Long customerId, @PathVariable Long flightId, @RequestBody ReservationDTO newReservation) {
        return reservationService.updateReservation(new Reservation.ReservationKey(customerId, flightId), newReservation)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/customer/{customerId}/flight/{flightId}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long customerId, @PathVariable Long flightId) {
        reservationService.deleteReservation(new Reservation.ReservationKey(customerId, flightId));
        return ResponseEntity.noContent().build();
    }
}
