package dev.naimsulejmani.grupi3fleetmanagement.models;

import dev.naimsulejmani.grupi3fleetmanagement.infrastructure.AtLeast18YearsOld;
import dev.naimsulejmani.grupi3fleetmanagement.infrastructure.GreaterThanInYears;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PositiveOrZero(message = "ID must be a positive number")
    private long id;

    @Column(unique = true, nullable = false, length = 10)
    @Size(min = 10, max = 10, message = "Personal number must be 10 characters long")
    @NotBlank(message = "Personal number should not be empty or blank")
    private String personalNo;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "First name should not be empty or blank")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters long")
    private String firstName;


    @Column(nullable = false, length = 50)
    @NotBlank(message = "Last name should not be empty or blank")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters long")
    private String lastName;

    @Column(nullable = false)
    @NotNull(message = "Birth date should not be null")
    @Past(message = "Birth date should be in the past")
    //@GreaterThan18Year() // kete e krijojme vet!
    //@AtLeast18YearsOld(message = "Driver should be at least 18 years old")
    //@AtLeastYearsOld(value = 18, message = "Driver should be at least 18 years old")
//    @AtLeast18YearsOld(message = "Nuk guxon te jete me i vogel se 18 vjet!")
    @GreaterThanInYears(value = 16, message = "Driver should be at least 16 years old")
    private LocalDate birthDate;


    private char gender;

    @Column(unique = true, nullable = false, length = 50)
    @Size(min = 5, max = 50, message = "Email must be between 5 and 50 characters long")
    @Email(message = "Email should be valid")
//    @Pattern(regexp = "^(.+)@(.+)$", message = "Email should be valid")
    private String email;

    @Column(unique = true, nullable = false, length = 25)
    @Size(min = 9, max = 25, message = "Phone number must be between 9 and 25 characters long")
    @NotBlank(message = "Phone number should not be empty or blank")
    private String phoneNumber;

//    @Min(value = 350, message = "Salary should be at least 350")
//    @Max(value = 10000, message = "Salary should not be more than 10000")
//    private int salary;


    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String drivingLicenseNo;
    private boolean active;
    private String photo;
    private String notes;

    @OneToMany()
    private List<FuelTransaction> fuelTransactions;
    // new Driver()

}
