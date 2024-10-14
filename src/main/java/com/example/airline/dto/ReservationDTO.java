package com.example.airline.dto;

import java.time.LocalDate;
import java.util.Objects;

public class ReservationDTO {

    private CustomerDTO customer;
    private FlightDTO flight;
    private LocalDate reservationDate;
    private int numberOfPassengers;

    public ReservationDTO(CustomerDTO customer, FlightDTO flight, LocalDate reservationDate, int numberOfPassengers) {
        this.customer = customer;
        this.flight = flight;
        this.reservationDate = reservationDate;
        this.numberOfPassengers = numberOfPassengers;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public FlightDTO getFlight() {
        return flight;
    }

    public void setFlight(FlightDTO flight) {
        this.flight = flight;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservationDTO that)) return false;
        return getNumberOfPassengers() == that.getNumberOfPassengers() && Objects.equals(getCustomer(),
            that.getCustomer()) && Objects.equals(getFlight(), that.getFlight()) && Objects.equals(
            getReservationDate(), that.getReservationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer(), getFlight(), getReservationDate(), getNumberOfPassengers());
    }
}
