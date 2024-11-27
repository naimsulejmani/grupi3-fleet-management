package dev.naimsulejmani.grupi3fleetmanagement.repositories;

import dev.naimsulejmani.grupi3fleetmanagement.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

}
