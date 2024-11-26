package com.example.airline.repositories;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airline.models.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long>{

    List<Airport> findAirportByName(String name);

    Optional<Airport> findByIataCode(String id);
}
