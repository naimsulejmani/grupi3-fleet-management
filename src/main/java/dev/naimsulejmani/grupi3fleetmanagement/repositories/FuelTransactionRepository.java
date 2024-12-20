package dev.naimsulejmani.grupi3fleetmanagement.repositories;

import dev.naimsulejmani.grupi3fleetmanagement.models.FuelTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelTransactionRepository extends JpaRepository<FuelTransaction, Long> {
}
