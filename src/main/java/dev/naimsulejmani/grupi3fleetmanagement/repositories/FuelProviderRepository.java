package dev.naimsulejmani.grupi3fleetmanagement.repositories;

import dev.naimsulejmani.grupi3fleetmanagement.models.FuelProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelProviderRepository extends JpaRepository<FuelProvider, Long> {

}
