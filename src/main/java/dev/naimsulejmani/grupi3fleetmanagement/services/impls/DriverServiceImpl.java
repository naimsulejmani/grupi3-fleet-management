package dev.naimsulejmani.grupi3fleetmanagement.services.impls;

import dev.naimsulejmani.grupi3fleetmanagement.models.Driver;
import dev.naimsulejmani.grupi3fleetmanagement.repositories.DriverRepository;
import dev.naimsulejmani.grupi3fleetmanagement.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DriverServiceImpl implements DriverService {


    private final DriverRepository repository;

    public DriverServiceImpl(DriverRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Driver> findAll() {
        return repository.findAll();
    }

    @Override
    public Driver findById(Long id) {
        return null;
    }

    @Override
    public Driver add(Driver driver) {
        return null;
    }

    @Override
    public Driver modify(Driver driver) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Driver> findAllByDriverLicenseCategory(String driverLicenseCategory) {
        return List.of();
    }
}
