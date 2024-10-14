package com.example.airline.mapper;

import com.example.airline.dto.CustomerDTO;
import com.example.airline.models.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mappings({
        @Mapping(source = "idCustomer", target = "idCustomer"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "lastName", target = "lastName"),
        @Mapping(source = "address", target = "address"),
        @Mapping(source = "phone", target = "phone"),
        @Mapping(source = "email", target = "email"),
    })
    CustomerDTO toCustomerDto(Customer customer);

    @InheritInverseConfiguration
    Customer fromCustomerDto(CustomerDTO customerDTO);

}
