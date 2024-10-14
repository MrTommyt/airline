package com.example.airline.mapper;

import com.example.airline.dto.ReservationDTO;
import com.example.airline.models.Reservation;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
    CustomerMapper.class,
    FlightMapper.class
})
public interface ReservationMapper {

    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mappings({
        @Mapping(target = "customer", source = "customer"),
        @Mapping(target = "flight", source = "flight"),
        @Mapping(target = "reservationDate", source = "reservationDate"),
        @Mapping(target = "numberOfPassengers", source = "numberOfPassengers"),
    })
    ReservationDTO toReservationDTO(Reservation reservation);

    @InheritInverseConfiguration
    Reservation toReservation(ReservationDTO reservationDTO);

}
