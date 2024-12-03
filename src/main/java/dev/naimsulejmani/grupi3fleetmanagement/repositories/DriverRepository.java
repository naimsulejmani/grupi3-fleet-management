package dev.naimsulejmani.grupi3fleetmanagement.repositories;

import dev.naimsulejmani.grupi3fleetmanagement.models.Driver;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByPersonalNo(String personalNo); // SELECT * FROM drivers WHERE personal_no = ?
    List<Driver> findAllByCityAndGender(String city, char gender); // SELECT * FROM drivers WHERE city = ? AND gender = ?

    List<Driver> findAllByFirstNameContaining(String firstName); // SELECT * FROM drivers WHERE first_name LIKE %?%

    List<Driver> findAllByBirthDateBetweenOrderByBirthDate(LocalDate from, LocalDate to);

    List<Driver> findAllByActive(boolean active, Limit limit);

    List<Driver> findAllByFirstNameOrLastNameOrCityOrBirthDate(String firstName, String lastName, String city, LocalDate birthDate);
    // SELECT * FROM drivers WHERE first_name = ? OR last_name = ? OR city = ? OR birth_date = ?


}
