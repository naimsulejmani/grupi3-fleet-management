package dev.naimsulejmani.grupi3fleetmanagement.models;

import dev.naimsulejmani.grupi3fleetmanagement.enums.FuelType;
import dev.naimsulejmani.grupi3fleetmanagement.enums.TransmissionType;
import dev.naimsulejmani.grupi3fleetmanagement.enums.VehicleType;
import jakarta.persistence.*;
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
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String plate;
    private String model;
    private String brand;
    private int year;
    private String color;
    private VehicleType type;
    private FuelType fuelType;
    private TransmissionType transmission;
    private float engine;
    private int power;
    private double mileage;
    private double currentPrice;
    private boolean registered;
    private LocalDate registeredTill;
    private String createdBy;
    private LocalDate createdAt;
    private String modifiedBy;
    private LocalDate modifiedAt;
    private String deletedBy;
    private LocalDate deletedAt;


    @OneToMany()
    private List<FuelTransaction> fuelTransactionList;


    @OneToOne()
    @JoinColumn(name="driver_id", nullable = true)
    private Driver driver;

}
