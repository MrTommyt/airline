package com.example.airline.models;

import java.io.Serializable;
import java.time.Duration;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "stopovers")
public class Stopover {
    @Embeddable
    public static class StopoverKey implements Serializable {
        @Column(name = "id_flight")
        private Long idFlight;

        @Column(name = "id_airport")
        private Long idAirport;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof StopoverKey that)) return false;
            return Objects.equals(idFlight, that.idFlight) && Objects.equals(idAirport, that.idAirport);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idFlight, idAirport);
        }
    }

    @EmbeddedId
    private StopoverKey stopoverKey;

    @ManyToOne
    @MapsId("idFlight")
    @JoinColumn(name = "id_flight", nullable = false)
    private Flight flight;

    @ManyToOne
    @MapsId("idAirport")
    @JoinColumn(name = "id_airport", nullable = false)
    private Airport airport;

    @Column(name = "stopover_time")
    private Duration stopoverTime;

    // GETTERS AND SETTERS

    public StopoverKey getStopoverKey() {
        return stopoverKey;
    }

    public void setStopoverKey(StopoverKey stopoverKey) {
        this.stopoverKey = stopoverKey;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
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
        if (!(o instanceof Stopover stopover)) return false;
        return Objects.equals(getStopoverKey(), stopover.getStopoverKey()) && Objects.equals(
            getFlight(), stopover.getFlight()) && Objects.equals(getAirport(),
            stopover.getAirport()) && Objects.equals(getStopoverTime(), stopover.getStopoverTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStopoverKey(), getFlight(), getAirport(), getStopoverTime());
    }
}
