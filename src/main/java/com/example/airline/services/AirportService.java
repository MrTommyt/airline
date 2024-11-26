package com.example.airline.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.airline.dto.AirportDTO;

@Service
public interface AirportService {
    List<AirportDTO> findAll();
    Optional<AirportDTO> findAirportById(Long id);
    List<AirportDTO> findAirportByName(String name);
    AirportDTO createAirport(AirportDTO airport);
    Optional<AirportDTO> updateAirport(Long id, AirportDTO newAirport);
    void deleteAirport(Long id);
}
