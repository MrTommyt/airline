package com.example.airline.mapper;

import com.example.airline.dto.StopoverDTO;
import com.example.airline.models.Stopover;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
    FlightMapper.class,
    AirportMapper.class
})
public interface StopoverMapper {

    StopoverMapper INSTANCE = Mappers.getMapper(StopoverMapper.class);

    @Mappings({
        @Mapping(target = "flight", source = "stopover.flight"),
        @Mapping(target = "airport", source = "stopover.airport"),
        @Mapping(target = "stopoverTime", source = "stopoverTime"),
    })
    StopoverDTO toStopoverDto(Stopover stopover);

    @InheritInverseConfiguration
    Stopover toStopover(StopoverDTO stopoverDto);
}
