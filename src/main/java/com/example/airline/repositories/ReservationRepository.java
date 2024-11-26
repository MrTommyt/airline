package com.example.airline.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airline.models.Reservation;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Optional;
import java.util.function.Function;

public interface ReservationRepository extends JpaRepository<Reservation, Reservation.ReservationKey>{
}
