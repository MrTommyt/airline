package com.example.airline.mapper;

import com.example.airline.dto.AirportDTO;
import com.example.airline.models.Airport;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AirportMapper {
    AirportMapper INSTANCE = Mappers.getMapper(AirportMapper.class);

    @Mappings({
        @Mapping(target = "idAirport", source = "idAirport"),
        @Mapping(target = "name", source = "name"),
        @Mapping(target = "city", source = "city"),
        @Mapping(target = "country", source = "country"),
    })
    AirportDTO toAirportDto(Airport airport);

    @InheritConfiguration
    Airport fromAirportDto(AirportDTO airportDTO);
}
