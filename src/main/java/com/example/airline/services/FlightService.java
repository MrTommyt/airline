package com.example.airline.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.airline.dto.FlightDTO;

@Service
public interface FlightService {
    List<FlightDTO> findAll();
    Optional<FlightDTO> findFlightById(Long id);
    FlightDTO createFlight(FlightDTO flight);
    Optional<FlightDTO> updateFlight(Long id, FlightDTO newFlight);
    void deleteFlight(Long id);
}
