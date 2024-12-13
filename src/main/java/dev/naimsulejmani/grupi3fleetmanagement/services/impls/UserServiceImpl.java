package dev.naimsulejmani.grupi3fleetmanagement.services.impls;

import dev.naimsulejmani.grupi3fleetmanagement.dtos.UserDto;
import dev.naimsulejmani.grupi3fleetmanagement.dtos.UserRegistrationRequestDto;
import dev.naimsulejmani.grupi3fleetmanagement.exceptions.EmailExistException;
import dev.naimsulejmani.grupi3fleetmanagement.exceptions.UserNameExistException;
import dev.naimsulejmani.grupi3fleetmanagement.mappers.UserMapper;
import dev.naimsulejmani.grupi3fleetmanagement.models.User;
import dev.naimsulejmani.grupi3fleetmanagement.repositories.UserRepository;
import dev.naimsulejmani.grupi3fleetmanagement.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto register(UserRegistrationRequestDto userRegDto) {
        User user = userMapper.fromUserRegistrationDto(userRegDto);

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserNameExistException();
        }

        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailExistException();
        }

        //TODO: implement the logic to encrypt/encode the password

        //kur e ruan na kthen User-in e ruajtur se bashku me ID-ne e gjeneruar
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);

    }
}










