package com.example.airline.services.impl;

import java.util.List;
import java.util.Optional;

import com.example.airline.mapper.AirportMapper;
import com.example.airline.mapper.FlightMapper;
import com.example.airline.mapper.StopoverMapper;
import com.example.airline.models.Stopover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airline.dto.StopoverDTO;
import com.example.airline.repositories.StopoverRepository;
import com.example.airline.services.StopoverService;

@Service
public class StopoverServiceImp implements StopoverService{

    @Autowired 
    private StopoverRepository stopoverRepository;
    private final StopoverMapper stopoverMapper = StopoverMapper.INSTANCE;
    private final FlightMapper flightMapper = FlightMapper.INSTANCE;
    private final AirportMapper airportMapper = AirportMapper.INSTANCE;

    @Override
    public List<StopoverDTO> findAll() {
       return stopoverRepository.findAll().stream().map(stopoverMapper::toStopoverDto).toList();
    }

    @Override
    public Optional<StopoverDTO> findStopoverById(Long id) {
        return stopoverRepository.findById(id).map(stopoverMapper::toStopoverDto);
    }

    @Override
    public StopoverDTO createStopover(StopoverDTO stopover) {
        return stopoverMapper.toStopoverDto(stopoverRepository.save(stopoverMapper.toStopover(stopover)));
    }

    @Override
    public Optional<StopoverDTO> updateStopover(Long id, StopoverDTO newStopover) {
        return stopoverRepository.findById(id)
        .map(stopoverInDB -> {
            stopoverInDB.setStopoverKey(new Stopover.StopoverKey(
                newStopover.getFlight().getIdFlight(),
                newStopover.getAirport().getIdAirport()
            ));
            stopoverInDB.setAirport(airportMapper.fromAirportDto(newStopover.getAirport()));
            stopoverInDB.setFlight(flightMapper.fromFlightDto(newStopover.getFlight()));
            stopoverInDB.setStopoverTime(newStopover.getStopoverTime());

            return stopoverMapper.toStopoverDto(stopoverRepository.save(stopoverInDB));
        });
    }

    @Override
    public void deleteStopover(Long id) {
        stopoverRepository.deleteById(id);
    }
    
}
