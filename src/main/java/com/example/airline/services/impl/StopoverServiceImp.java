package com.example.airline.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airline.models.Stopover;
import com.example.airline.repositories.StopoverRepository;
import com.example.airline.services.StopoverService;

@Service
public class StopoverServiceImp implements StopoverService{

    @Autowired 
    private StopoverRepository stopoverRepository;

    @Override
    public List<Stopover> findAll() {
       return stopoverRepository.findAll();
    }

    @Override
    public Optional<Stopover> findStopoverById(Long id) {
        return stopoverRepository.findById(id);
    }

    @Override
    public Stopover createStopover(Stopover stopover) {
        return stopoverRepository.save(stopover);
    }

    @Override
    public Optional<Stopover> updateStopover(Long id, Stopover newStopover) {
        return stopoverRepository.findById(id)
        .map(stopoverInDB -> {
            stopoverInDB.setStopoverKey(newStopover.getStopoverKey());
            stopoverInDB.setAirport(newStopover.getAirport());
            stopoverInDB.setFlight(newStopover.getFlight());
            stopoverInDB.setStopoverTime(newStopover.getStopoverTime());

            return stopoverRepository.save(stopoverInDB);
        });
    }

    @Override
    public void deleteStopover(Long id) {
        stopoverRepository.deleteById(id);
    }
    
}
