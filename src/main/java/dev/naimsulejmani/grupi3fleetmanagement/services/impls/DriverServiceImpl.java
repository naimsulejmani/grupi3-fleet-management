package dev.naimsulejmani.grupi3fleetmanagement.services.impls;

import dev.naimsulejmani.grupi3fleetmanagement.models.Driver;
import dev.naimsulejmani.grupi3fleetmanagement.repositories.DriverRepository;
import dev.naimsulejmani.grupi3fleetmanagement.services.DriverService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
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
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Driver me kete id nuk ekziston: " + id));
    }

    @Override
    public Driver add(Driver driver) {


        if (driver.getId() != 0) {
            var existingDriver = repository.findById(driver.getId());

            if (existingDriver.isPresent()) {
                throw new EntityExistsException("Driver me kete id ekziston: " + driver.getId());
            }
        }


        long totalDrivers = repository.countAllByPersonalNoOrEmail(driver.getPersonalNo(), driver.getEmail());
        if (totalDrivers > 0) {
            throw new EntityExistsException("Driver me kete personal number ose email ekziston: " + driver.getPersonalNo() + " ose " + driver.getEmail());
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
