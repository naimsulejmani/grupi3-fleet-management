package dev.naimsulejmani.grupi3fleetmanagement.services.impls;

import dev.naimsulejmani.grupi3fleetmanagement.models.User;
import dev.naimsulejmani.grupi3fleetmanagement.repositories.UserRepository;
import dev.naimsulejmani.grupi3fleetmanagement.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
//        User user = new User();
//        user.setUsername("admin");
//        user.setPassword("Admin123!");
//        user.setEmail("admin@admin.com");
//        user.setName("Naim");
//        user.setSurname("Sulejmani");
//        user.setRole("ROLE_ADMIN");
//        user.setPhone("044123456");
//        repository.save(user);
    }

    @Override
    public User login(String username, String password) {
        var user = repository.findByUsername(username);
        if (user.isEmpty()) {
            System.out.println("User not found");
            return null;
        }
        if (!user.get().getPassword().equals(password)) {
            System.out.println("Password is incorrect");
            return null;
        }
        return user.get();
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }
}











