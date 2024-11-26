package com.example.airline.services.impl;

import java.util.List;
import java.util.Optional;

import com.example.airline.mapper.CustomerMapper;
import com.example.airline.mapper.FlightMapper;
import com.example.airline.mapper.ReservationMapper;
import com.example.airline.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airline.dto.ReservationDTO;
import com.example.airline.repositories.ReservationRepository;
import com.example.airline.services.ReservationService;

@Service
public class ReservationServiceImp implements ReservationService {

    @Autowired 
    private ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper = ReservationMapper.INSTANCE;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    private final FlightMapper flightMapper = FlightMapper.INSTANCE;

    @Override
    public List<ReservationDTO> findAll() {
        return reservationRepository.findAll().stream()
            .map(reservationMapper::toReservationDTO)
            .toList();
    }

    public Optional<ReservationDTO> findReservationById(Reservation.ReservationKey id) {
        return reservationRepository.findById(id)
            .map(reservationMapper::toReservationDTO);
    }

    @Override
    public ReservationDTO createReservation(ReservationDTO reservation) {
        return reservationMapper.toReservationDTO(reservationRepository.save(reservationMapper.toReservation(reservation)));
    }

    @Override
    public Optional<ReservationDTO> updateReservation(Reservation.ReservationKey id, ReservationDTO newReservation) {
       return reservationRepository.findById(id)
       .map(reservationInDB -> {
            reservationInDB.setReservationKey(new Reservation.ReservationKey(
                newReservation.getCustomer().getIdCustomer(),
                newReservation.getFlight().getIdFlight()
            ));
            reservationInDB.setCustomer(customerMapper.fromCustomerDto(newReservation.getCustomer()));
            reservationInDB.setFlight(flightMapper.fromFlightDto(newReservation.getFlight()));
            reservationInDB.setNumberOfPassengers(newReservation.getNumberOfPassengers());
            reservationInDB.setReservationDate(newReservation.getReservationDate());

            return reservationMapper.toReservationDTO(reservationRepository.save(reservationInDB));
       });
    }

    @Override
    public void deleteReservation(Reservation.ReservationKey id) {
       reservationRepository.deleteById(id);
    }
}
