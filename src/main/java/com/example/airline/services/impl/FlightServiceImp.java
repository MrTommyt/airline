package com.example.airline.services.impl;

import java.util.List;
import java.util.Optional;

import com.example.airline.mapper.AirlineMapper;
import com.example.airline.mapper.AirportMapper;
import com.example.airline.mapper.FlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airline.dto.FlightDTO;
import com.example.airline.repositories.FlightRepository;
import com.example.airline.services.FlightService;

@Service
public class FlightServiceImp implements FlightService{

    @Autowired 
    private FlightRepository flightRepository;
    private final FlightMapper flightMapper = FlightMapper.INSTANCE;
    private final AirlineMapper airlineMapper = AirlineMapper.INSTANCE;
    private final AirportMapper airportMapper = AirportMapper.INSTANCE;

    @Override
    public List<FlightDTO> findAll() {
        return flightRepository.findAll().stream().map(flightMapper::toFlightDto).toList();
    }

    @Override
    public Optional<FlightDTO> findFlightById(Long id) {
       return flightRepository.findById(id).map(flightMapper::toFlightDto);
    }

    @Override
    public FlightDTO createFlight(FlightDTO flight) {
        return flightMapper.toFlightDto(flightRepository.save(flightMapper.fromFlightDto(flight)));
    }

    @Override
    public Optional<FlightDTO> updateFlight(Long id, FlightDTO newFlight) {
        return flightRepository.findById(id)
        .map(flightInDB -> {

            flightInDB.setIdFlight(newFlight.getIdFlight());
            flightInDB.setAirline(airlineMapper.fromAirlineDto(newFlight.getAirline()));
            flightInDB.setOrigin(airportMapper.fromAirportDto(newFlight.getOrigin()));
            flightInDB.setCapacity(newFlight.getCapacity());
            flightInDB.setDepartureDate(newFlight.getDepartureDate());
            flightInDB.setDepartureTime(newFlight.getDepartureTime());
            flightInDB.setDestination(airportMapper.fromAirportDto(newFlight.getDestination()));

            return flightMapper.toFlightDto(flightRepository.save(flightInDB));
        });
    }

    @Override
    public void deleteFlight(Long id) {
       flightRepository.deleteById(id);
    }
    
}
