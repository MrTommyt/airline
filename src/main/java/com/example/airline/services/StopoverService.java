package com.example.airline.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.airline.dto.StopoverDTO;

@Service
public interface StopoverService {
    List<StopoverDTO> findAll();
    Optional<StopoverDTO> findStopoverById(Long id);
    StopoverDTO createStopover(StopoverDTO stopover);
    Optional<StopoverDTO> updateStopover(Long id, StopoverDTO newStopover);
    void deleteStopover(Long id);
    
}