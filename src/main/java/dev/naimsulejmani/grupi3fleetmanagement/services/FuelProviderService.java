package dev.naimsulejmani.grupi3fleetmanagement.services;

import dev.naimsulejmani.grupi3fleetmanagement.models.FuelProvider;
import dev.naimsulejmani.grupi3fleetmanagement.repositories.FuelProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelProviderService {
    private final FuelProviderRepository fuelProviderRepository;

    public FuelProviderService(FuelProviderRepository fuelProviderRepository) {
        this.fuelProviderRepository = fuelProviderRepository;
        save(new FuelProvider(0,
                "Shell",
                "Rruga e Kavajes",
                "Tirane",
                "Albania",
                "1001",
                "0691234567",
                "ZP8lE@example.com",
                "1111","1112","1113"));
    }

    public List<FuelProvider> findAll() {
        return fuelProviderRepository.findAll(); // SELECT * FROM fuel_providers;
    }

    public FuelProvider findById(Long id) {
        return fuelProviderRepository.findById(id).orElse(null);
        // SELECT * FROM fuel_providers WHERE id = ?;
    }

    public FuelProvider save(FuelProvider fuelProvider) {
        return fuelProviderRepository.save(fuelProvider);
        // INSERT INTO fuel_providers
        // (name, address, city, country, postal_code, phone_number, email, active)
        // VALUES (?, ?, ?, ?, ?, ?, ?, ?);
    }
    public void deleteById(Long id) {
        fuelProviderRepository.deleteById(id);
        // DELETE FROM fuel_providers WHERE id = ?;
    }
}
