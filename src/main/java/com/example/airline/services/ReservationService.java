package com.example.airline.services;

import java.util.List;
import java.util.Optional;

import com.example.airline.models.Reservation;
import org.springframework.stereotype.Service;

import com.example.airline.dto.ReservationDTO;

@Service

public interface ReservationService {
    List<ReservationDTO> findAll();
    Optional<ReservationDTO> findReservationById(Reservation.ReservationKey id);
    ReservationDTO createReservation(ReservationDTO reservation);
    Optional<ReservationDTO> updateReservation(Reservation.ReservationKey id, ReservationDTO newReservation);
    void deleteReservation(Reservation.ReservationKey id);
}
