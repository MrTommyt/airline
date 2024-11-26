package com.example.airline.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.airline.dto.ReservationDTO;

@Service

public interface ReservationService {
    List<ReservationDTO> findAll();
    Optional<ReservationDTO> findReservationById(Long id);
    ReservationDTO createReservation(ReservationDTO reservation);
    Optional<ReservationDTO> updateReservation(Long id, ReservationDTO newReservation);
    void deleteReservation(Long id);
}
