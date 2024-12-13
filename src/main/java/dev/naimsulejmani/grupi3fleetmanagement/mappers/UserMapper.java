package dev.naimsulejmani.grupi3fleetmanagement.mappers;

import dev.naimsulejmani.grupi3fleetmanagement.dtos.UserDto;
import dev.naimsulejmani.grupi3fleetmanagement.dtos.UserRegistrationRequestDto;
import dev.naimsulejmani.grupi3fleetmanagement.infrastructure.mapping.SimpleMapper;
import dev.naimsulejmani.grupi3fleetmanagement.models.User;


public interface UserMapper extends SimpleMapper<User, UserDto> {
    User fromUserRegistrationDto(UserRegistrationRequestDto userRegDto);
}
