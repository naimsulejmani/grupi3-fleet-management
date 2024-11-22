package dev.naimsulejmani.grupi3fleetmanagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "fuel_providers")
public class FuelProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String phoneNumber;
    private String email;
    @Column(unique = true)
    private String fiscalNo;
    private String vatNo;
    private String businessNo;

}








