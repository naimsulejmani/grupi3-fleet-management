package dev.naimsulejmani.grupi3fleetmanagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "fuel_providers")
public class FuelProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(length = 200)
    private String address;
    @Column(length = 50)
    private String city;
    @Column(length = 50)
    private String country;
    @Column(length = 10)
    private String postalCode;
    @Column(length = 20)
    private String phoneNumber;
    @Column(length = 50)
    private String email;
    @Column(unique = true, length = 20)
    private String fiscalNo;
    @Column(unique = true, length = 20)
    private String vatNo;
    @Column(unique = true, length = 20)
    private String businessNo;

    @OneToMany(mappedBy = "fuelProvider")
    private List<FuelTransaction> fuelTransactionList; // one to many>

}








