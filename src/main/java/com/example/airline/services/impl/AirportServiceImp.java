package com.example.airline.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airline.models.Airport;
import com.example.airline.repositories.AirportRepository;
import com.example.airline.services.AirportService;

@Service
public class AirportServiceImp implements AirportService{
    
    @Autowired 
    private AirportRepository airportRepository;

    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    @Override
    public Optional<Airport> findAirportById(Long id) {
        return airportRepository.findById(id);
    }

    @Override
    public List<Airport> findAirportByName(String name) {
       return airportRepository.findAirportByName(name);
    }

    @Override
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);    
    }

    @Override
    public Optional<Airport> updateAirport(Long id, Airport newAirport) {
        return airportRepository.findById(id)
        .map(airportInDB -> {
            airportInDB.setIdAirport(newAirport.getIdAirport());
            airportInDB.setName(newAirport.getName());
            airportInDB.setCountry(newAirport.getCountry());
            airportInDB.setCity(newAirport.getCity());

            return airportRepository.save(airportInDB);
        });    
    }

    @Override
    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}
