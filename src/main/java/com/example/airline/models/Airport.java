package com.example.airline.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "airports")
public class Airport {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_airport")
    private Long idAirport;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "iataCode")
    private String iataCode;

    // GETTERS AND SETTERS
    
    public Long getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(Long idAirport) {
        this.idAirport = idAirport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // ID_Aeropuerto (Clave Primaria)
    // Nombre
    // Ciudad
    // País


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport airport)) return false;
        return Objects.equals(getIdAirport(), airport.getIdAirport()) && Objects.equals(getName(),
            airport.getName()) && Objects.equals(getCity(), airport.getCity()) && Objects.equals(
            getCountry(), airport.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAirport(), getName(), getCity(), getCountry());
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }
}
