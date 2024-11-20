package dev.naimsulejmani.grupi3fleetmanagement.models;

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
public class Driver {
    private long id;
    private String personalNo;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private char geneder;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private List<DriverLicenseCategory> licenseCategories;
    private boolean active;

}
