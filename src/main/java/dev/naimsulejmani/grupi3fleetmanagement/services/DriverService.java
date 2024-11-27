package dev.naimsulejmani.grupi3fleetmanagement.services;

import dev.naimsulejmani.grupi3fleetmanagement.models.Driver;

import java.util.List;

public interface DriverService {
    List<Driver> findAll();

    Driver findById(Long id);

    Driver add(Driver driver);

    Driver modify(Driver driver);

    void deleteById(Long id);

    List<Driver> findAllByDriverLicenseCategory(String driverLicenseCategory);

}
