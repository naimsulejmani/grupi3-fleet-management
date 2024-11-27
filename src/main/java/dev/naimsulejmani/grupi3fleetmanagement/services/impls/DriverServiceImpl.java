package dev.naimsulejmani.grupi3fleetmanagement.services.impls;

import dev.naimsulejmani.grupi3fleetmanagement.models.Driver;
import dev.naimsulejmani.grupi3fleetmanagement.repositories.DriverRepository;
import dev.naimsulejmani.grupi3fleetmanagement.services.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return repository.findById(id).orElse(null);
    }

    @Override
    public Driver add(Driver driver) {
        //kontrollo a ekziston nje driver me kete id
        var existingDriver = findById(driver.getId());

        if (existingDriver != null) {
            System.out.println("Driver me kete id ekziston: " + driver.getId());
            return null;
        }

        return repository.save(driver);
    }

    @Override
    public Driver modify(Driver driver) {

        var existingDriver = findById(driver.getId());
        if (existingDriver == null) {
            System.out.println("Driver me kete id nuk ekziston: " + driver.getId());
            return null;
        }
        return repository.save(driver);
    }

    @Override
    public void deleteById(Long id) {
        var existingDriver = findById(id);
        if (existingDriver == null) {
            System.out.println("Driver me kete id nuk ekziston: " + id);
            return;
        }
        repository.deleteById(id);
//        repository.delete(existingDriver);
    }

    @Override
    public List<Driver> findAllByDriverLicenseCategory(String driverLicenseCategory) {
        return List.of();
    }
}
