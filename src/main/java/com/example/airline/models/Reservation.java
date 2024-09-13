package com.example.airline.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Embeddable
    public static class ReservationKey implements Serializable {

        @Column(name = "id_customer")
        private Long customer;

        @Column(name = "id_flight")
        private Long flight;

    }

    @EmbeddedId
    private ReservationKey reservationKey;

    @ManyToOne
    @MapsId("customer")
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer")
    private Customer customer;

    @ManyToOne
    @MapsId("flight")
    @JoinColumn(name = "id_flight", referencedColumnName = "id_flight")
    private Flight flight;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @Column(name = "number_of_passengers")
    private int numberOfPassengers;

    // GETTERS AND SETTERS
    
    public ReservationKey getReservationKey() {
        return reservationKey;
    }

    public void setReservationKey(ReservationKey reservationKey) {
        this.reservationKey = reservationKey;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
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

}
