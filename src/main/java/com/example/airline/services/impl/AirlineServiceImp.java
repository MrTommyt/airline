package com.example.airline.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airline.models.Airline;
import com.example.airline.repositories.AirlineRepository;
import com.example.airline.services.AirlineService;

@Service
public class AirlineServiceImp implements AirlineService{

    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public List<Airline> findAll() {
        return airlineRepository.findAll();
    }

    @Override
    public Optional<Airline> findAirlineById(Long id) {
        return airlineRepository.findById(id);
    }

    @Override
    public List<Airline> findAirlineByName(String name) {
        return airlineRepository.findAirlineByName(name);
    }

    @Override
    public Airline createAirline(Airline airline) {
       return airlineRepository.save(airline);
    }

    @Override
    public Optional<Airline> updateAirline(Long id, Airline newAirline) {
       return airlineRepository.findById(id)
       .map(airlineInDB -> {
            airlineInDB.setIdAirline(newAirline.getIdAirline());
            airlineInDB.setName(newAirline.getName());
            airlineInDB.setAirlineCode(newAirline.getAirlineCode());
            airlineInDB.setCountryOfOrigin(newAirline.getCountryOfOrigin());
        
            return airlineRepository.save(airlineInDB);
        });
    }

    @Override
    public void deleteAirline(Long id) {
      airlineRepository.deleteById(id);
    }
    // ID_Aerolínea (Clave Primaria)
    // Nombre
    // Código de aerolínea
    // País de origen
}
