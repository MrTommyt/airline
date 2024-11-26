package com.example.airline.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airline.models.Flight;
import com.example.airline.repositories.FlightRepository;
import com.example.airline.services.FlightService;

@Service
public class FlightServiceImp implements FlightService{

    @Autowired 
    private FlightRepository flightRepository;

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<Flight> findFlightById(Long id) {
       return flightRepository.findById(id);
    }

    @Override
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Optional<Flight> updateFlight(Long id, Flight newFlight) {
        return flightRepository.findById(id)
        .map(flightInDB -> {
            flightInDB.setIdFlight(newFlight.getIdFlight());
            flightInDB.setAirline(newFlight.getAirline());
            flightInDB.setOrigin(newFlight.getOrigin());
            flightInDB.setCapacity(newFlight.getCapacity());
            flightInDB.setDepartureDate(newFlight.getDepartureDate());
            flightInDB.setDepartureTime(newFlight.getDepartureTime());
            flightInDB.setDestination(newFlight.getDestination());

            return flightRepository.save(flightInDB);
        });
    }

    @Override
    public void deleteFlight(Long id) {
       flightRepository.deleteById(id);
    }
    
}
