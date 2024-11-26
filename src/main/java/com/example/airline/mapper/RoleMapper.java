package com.example.airline.mapper;

import com.example.airline.dto.RoleDTO;
import com.example.airline.models.Role;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Mappings({
        @Mapping(target = "id", source = "idRole"),
        @Mapping(target = "role", source = "role")
    })
    RoleDTO toRoleDto(Role role);

    @InheritInverseConfiguration
    Role fromRoleDto(RoleDTO roleDTO);
}
