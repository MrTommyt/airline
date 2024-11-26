package com.example.airline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airline.models.Stopover;

public interface StopoverRepository extends JpaRepository<Stopover, Stopover.StopoverKey>{
} 