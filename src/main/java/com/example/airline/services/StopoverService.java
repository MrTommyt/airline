package com.example.airline.services;

import java.util.List;
import java.util.Optional;

import com.example.airline.models.Stopover;
import org.springframework.stereotype.Service;

import com.example.airline.dto.StopoverDTO;

@Service
public interface StopoverService {
    List<StopoverDTO> findAll();
    Optional<StopoverDTO> findStopoverById(Stopover.StopoverKey id);
    StopoverDTO createStopover(StopoverDTO stopover);
    Optional<StopoverDTO> updateStopover(Stopover.StopoverKey id, StopoverDTO newStopover);
    void deleteStopover(Stopover.StopoverKey id);
    
}