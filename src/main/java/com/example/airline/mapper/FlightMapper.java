package com.example.airline.mapper;

import com.example.airline.dto.FlightDTO;
import com.example.airline.models.Flight;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
    AirlineMapper.class,
    AirportMapper.class
})
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    @Mappings({
        @Mapping(target = "idFlight", source = "idFlight"),
        @Mapping(target = "airline", source = "airline"),
        @Mapping(target = "origin", source = "origin"),
        @Mapping(target = "destination", source = "destination"),
        @Mapping(target = "departureDate", source = "departureDate"),
        @Mapping(target = "departureTime", source = "departureTime"),
        @Mapping(target = "duration", source = "duration"),
        @Mapping(target = "capacity", source = "capacity"),
    })
    FlightDTO toFlightDto(Flight flight);

    @InheritInverseConfiguration
    Flight fromFlightDto(FlightDTO flightDTO);

}
