package com.example.airline.dto;

import java.time.Duration;
import java.util.Objects;

public class StopoverDTO {

    private FlightDTO flight;
    private AirportDTO airport;
    private Duration stopoverTime;

    public StopoverDTO(FlightDTO flight, AirportDTO airport, Duration stopoverTime) {
        this.flight = flight;
        this.airport = airport;
        this.stopoverTime = stopoverTime;
    }

    public FlightDTO getFlight() {
        return flight;
    }

    public void setFlight(FlightDTO flight) {
        this.flight = flight;
    }

    public AirportDTO getAirport() {
        return airport;
    }

    public void setAirport(AirportDTO airport) {
        this.airport = airport;
    }

    public Duration getStopoverTime() {
        return stopoverTime;
    }

    public void setStopoverTime(Duration stopoverTime) {
        this.stopoverTime = stopoverTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StopoverDTO that)) return false;
        return Objects.equals(getFlight(), that.getFlight()) && Objects.equals(getAirport(),
            that.getAirport()) && Objects.equals(getStopoverTime(), that.getStopoverTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlight(), getAirport(), getStopoverTime());
    }
}
