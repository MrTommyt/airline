package com.example.airline.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.airline.mapper.AirportMapper;
import com.example.airline.models.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airline.dto.AirportDTO;
import com.example.airline.repositories.AirportRepository;
import com.example.airline.services.AirportService;

@Service
public class AirportServiceImp implements AirportService{
    
    @Autowired 
    private AirportRepository airportRepository;
    private final AirportMapper airportMapper = AirportMapper.INSTANCE;

    @Override
    public List<AirportDTO> findAll() {
        return airportRepository.findAll().stream().map(airportMapper::toAirportDto).toList();
    }

    @Override
    public Optional<AirportDTO> findAirportById(Long id) {
        return airportRepository.findById(id).map(airportMapper::toAirportDto);
    }

    @Override
    public List<AirportDTO> findAirportByName(String name) {
       return airportRepository.findAirportByName(name).stream().map(airportMapper::toAirportDto).toList();
    }

    @Override
    public AirportDTO createAirport(AirportDTO airport) {
        Airport ap = airportMapper.fromAirportDto(airport);
        return airportMapper.toAirportDto(airportRepository.save(ap));
    }

    @Override
    public Optional<AirportDTO> updateAirport(Long id, AirportDTO newAirport) {
        return airportRepository.findById(id)
        .map(airportInDB -> {
            airportInDB.setIdAirport(newAirport.getIdAirport());
            airportInDB.setName(newAirport.getName());
            airportInDB.setCountry(newAirport.getCountry());
            airportInDB.setCity(newAirport.getCity());

            return airportMapper.toAirportDto(airportRepository.save(airportMapper.fromAirportDto(newAirport)));
        });    
    }

    @Override
    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}
