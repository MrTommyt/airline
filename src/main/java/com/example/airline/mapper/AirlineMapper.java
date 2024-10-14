package com.example.airline.mapper;

import com.example.airline.dto.AirlineDTO;
import com.example.airline.models.Airline;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AirlineMapper {
    AirlineMapper INSTANCE = Mappers.getMapper(AirlineMapper.class);

    @Mappings({
        @Mapping(source = "idAirline", target = "idAirline"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "airlineCode", target = "airlineCode"),
        @Mapping(source = "countryOfOrigin", target = "country"),
    })
    AirlineDTO toAirlineDto(Airline airline);

    @InheritInverseConfiguration
    Airline fromAirlineDto(AirlineDTO airlineDTO);
}
