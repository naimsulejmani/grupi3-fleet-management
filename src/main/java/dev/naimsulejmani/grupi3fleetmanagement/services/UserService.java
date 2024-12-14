package dev.naimsulejmani.grupi3fleetmanagement.services;

import dev.naimsulejmani.grupi3fleetmanagement.dtos.UserDto;
import dev.naimsulejmani.grupi3fleetmanagement.dtos.UserRegistrationRequestDto;

public interface UserService {
    UserDto register(UserRegistrationRequestDto userRegDto);

    UserDto login(String username, String password);
}
