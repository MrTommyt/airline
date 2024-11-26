package com.example.airline.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airline.models.Reservation;
import com.example.airline.repositories.ReservationRepository;
import com.example.airline.services.ReservationService;

@Service
public class ReservationServiceImp implements ReservationService {

    @Autowired 
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Optional<Reservation> updateReservation(Long id, Reservation newReservation) {
       return reservationRepository.findById(id)
       .map(reservationInDB -> {
            reservationInDB.setReservationKey(newReservation.getReservationKey());    
            reservationInDB.setCustomer(newReservation.getCustomer());
            reservationInDB.setFlight(newReservation.getFlight());
            reservationInDB.setNumberOfPassengers(newReservation.getNumberOfPassengers());
            reservationInDB.setReservationDate(newReservation.getReservationDate());

            return reservationRepository.save(reservationInDB);
       });
    }

    @Override
    public void deleteReservation(Long id) {
       reservationRepository.deleteById(id);
    }
}
