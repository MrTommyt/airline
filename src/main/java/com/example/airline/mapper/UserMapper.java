package com.example.airline.mapper;

import com.example.airline.dto.UserDto;
import com.example.airline.models.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {RoleMapper.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
        @Mapping(target = "id", source = "user.id"),
        @Mapping(target = "username", source = "user.username"),
        @Mapping(target = "email", source = "user.email"),
        @Mapping(target = "password", source = "user.password"),
        @Mapping(target = "roles", source = "user.roles")
    })
    UserDto toUserDto(User user);

    @InheritInverseConfiguration
    User fromUserDto(UserDto userDto);
}
