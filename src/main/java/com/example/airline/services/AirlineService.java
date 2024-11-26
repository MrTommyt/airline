package com.example.airline.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.airline.dto.AirlineDTO;

@Service
public interface AirlineService {
    List<AirlineDTO> findAll();
    Optional<AirlineDTO> findAirlineById(Long id);
    List<AirlineDTO> findAirlineByName(String name);
    AirlineDTO createAirline(AirlineDTO airline);
    Optional<AirlineDTO> updateAirline(Long id, AirlineDTO newAirline);
    void deleteAirline(Long id);
    
}
