package dev.naimsulejmani.grupi3fleetmanagement.mappers.impls;

import dev.naimsulejmani.grupi3fleetmanagement.dtos.UserDto;
import dev.naimsulejmani.grupi3fleetmanagement.dtos.UserRegistrationRequestDto;
import dev.naimsulejmani.grupi3fleetmanagement.mappers.UserMapper;
import dev.naimsulejmani.grupi3fleetmanagement.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User toEntity(UserDto userDto) {
        User user =  new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setRole(userDto.getRole());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        return user;
    }

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setRole(user.getRole());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        return userDto;
    }

    @Override
    public User fromUserRegistrationDto(UserRegistrationRequestDto userRegDto) {
        User user = new User();
        user.setUsername(userRegDto.getUsername());
        user.setPassword(userRegDto.getPassword());
        user.setEmail(userRegDto.getEmail());
        user.setName(userRegDto.getName());
        user.setSurname(userRegDto.getSurname());
        user.setRole(userRegDto.getRole());
        user.setPhone(userRegDto.getPhone());
        return user;
    }
}
