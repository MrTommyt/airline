package com.example.airline.dto;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class FlightDTO {

    private Long idFlight;
    private AirlineDTO airline;
    private AirportDTO origin;
    private AirportDTO destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private Duration duration;
    private int capacity;

    public FlightDTO(Long idFlight, AirlineDTO airline, AirportDTO origin, AirportDTO destination, LocalDate departureDate, LocalTime departureTime, Duration duration, int capacity) {
        this.idFlight = idFlight;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.duration = duration;
        this.capacity = capacity;
    }

    public Long getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(Long idFlight) {
        this.idFlight = idFlight;
    }

    public AirlineDTO getAirline() {
        return airline;
    }

    public void setAirline(AirlineDTO airline) {
        this.airline = airline;
    }

    public AirportDTO getOrigin() {
        return origin;
    }

    public void setOrigin(AirportDTO origin) {
        this.origin = origin;
    }

    public AirportDTO getDestination() {
        return destination;
    }

    public void setDestination(AirportDTO destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightDTO flightDTO)) return false;
        return getCapacity() == flightDTO.getCapacity() && Objects.equals(getIdFlight(),
            flightDTO.getIdFlight()) && Objects.equals(getAirline(),
            flightDTO.getAirline()) && Objects.equals(getOrigin(),
            flightDTO.getOrigin()) && Objects.equals(getDestination(),
            flightDTO.getDestination()) && Objects.equals(getDepartureDate(),
            flightDTO.getDepartureDate()) && Objects.equals(getDepartureTime(),
            flightDTO.getDepartureTime()) && Objects.equals(getDuration(), flightDTO.getDuration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdFlight(), getAirline(), getOrigin(), getDestination(), getDepartureDate(),
            getDepartureTime(), getDuration(), getCapacity());
    }
}
