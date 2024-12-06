package dev.naimsulejmani.grupi3fleetmanagement.services;

import dev.naimsulejmani.grupi3fleetmanagement.models.User;

public interface UserService {
    User login(String username, String password);

    User findById(Long id);

    User findByUsername(String username);
}
