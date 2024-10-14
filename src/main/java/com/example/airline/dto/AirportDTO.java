package com.example.airline.dto;

import java.util.Objects;

public class AirportDTO {
    
    private Long idAirport;
    private String name;
    private String city;
    private String country;

    public AirportDTO(Long idAirport, String name, String city, String country) {
        this.idAirport = idAirport;
        this.name = name;
        this.city = city;
        this.country = country;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirportDTO that)) return false;
        return Objects.equals(getIdAirport(), that.getIdAirport()) && Objects.equals(getName(),
            that.getName()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getCountry(),
            that.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAirport(), getName(), getCity(), getCountry());
    }
}
