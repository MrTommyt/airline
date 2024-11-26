package com.example.airline.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.airline.mapper.AirlineMapper;
import com.example.airline.models.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airline.dto.AirlineDTO;
import com.example.airline.repositories.AirlineRepository;
import com.example.airline.services.AirlineService;

@Service
public class AirlineServiceImp implements AirlineService{

    @Autowired
    private AirlineRepository airlineRepository;
    private final AirlineMapper airlineMapper = AirlineMapper.INSTANCE;

    @Override
    public List<AirlineDTO> findAll() {
        return airlineRepository.findAll().stream().map(airlineMapper::toAirlineDto).toList();
    }

    @Override
    public Optional<AirlineDTO> findAirlineById(Long id) {
        return airlineRepository.findById(id).map(airlineMapper::toAirlineDto);
    }

    @Override
    public List<AirlineDTO> findAirlineByName(String name) {
        List<AirlineDTO> airlines = new ArrayList<>();
        airlineRepository.findAirlineByName(name).forEach(airline -> airlines.add(airlineMapper.toAirlineDto(airline)));
        return airlines;
    }

    @Override
    public AirlineDTO createAirline(AirlineDTO airline) {
        Airline al = airlineMapper.fromAirlineDto(airline);
        return airlineMapper.toAirlineDto(airlineRepository.save(al));
    }

    @Override
    public Optional<AirlineDTO> updateAirline(Long id, AirlineDTO newAirline) {
       return airlineRepository.findById(id)
       .map(airlineInDB -> {
            airlineInDB.setIdAirline(newAirline.getIdAirline());
            airlineInDB.setName(newAirline.getName());
            airlineInDB.setAirlineCode(newAirline.getAirlineCode());
            airlineInDB.setCountryOfOrigin(newAirline.getCountry());
        
            return airlineMapper.toAirlineDto(airlineRepository.save(airlineInDB));
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
