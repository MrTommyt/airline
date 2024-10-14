package com.example.airline.dto;

import java.util.Objects;

public class AirlineDTO {
    
    private Long idAirline;
    private String name;
    private String airlineCode;
    private String country;

    public AirlineDTO(Long idAirline, String name, String airlineCode, String country) {
        this.idAirline = idAirline;
        this.name = name;
        this.airlineCode = airlineCode;
        this.country = country;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String countryOfOrigin) {
        this.country = countryOfOrigin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirlineDTO that)) return false;
        return Objects.equals(getIdAirline(), that.getIdAirline()) && Objects.equals(getName(),
            that.getName()) && Objects.equals(getAirlineCode(),
            that.getAirlineCode()) && Objects.equals(getCountry(), that.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAirline(), getName(), getAirlineCode(), getCountry());
    }

}
