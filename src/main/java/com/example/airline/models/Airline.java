package com.example.airline.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "airlines")
public class Airline {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_airline")
    private Long idAirline;

    @Column(name = "name")
    private String name;

    @Column(name = "airline_code")
    private String airlineCode;

    @Column(name = "country_of_origin")
    private String countryOfOrigin;

    // GETTERS AND SETTERS

    public Long getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(Long idAirline) {
        this.idAirline = idAirline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    // ID_Aerolínea (Clave Primaria)
    // Nombre
    // Código de aerolínea
    // País de origen


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airline airline)) return false;
        return Objects.equals(getIdAirline(), airline.getIdAirline()) && Objects.equals(getName(),
            airline.getName()) && Objects.equals(getAirlineCode(),
            airline.getAirlineCode()) && Objects.equals(getCountryOfOrigin(), airline.getCountryOfOrigin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAirline(), getName(), getAirlineCode(), getCountryOfOrigin());
    }
}
