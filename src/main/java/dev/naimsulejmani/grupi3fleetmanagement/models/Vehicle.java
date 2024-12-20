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
@Entity(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 17)
    private String vin;
    @Column(unique = true, nullable = false, length = 20)
    private String plate;
    @Column(nullable = false, length = 50)
    private String model;
    @Column(nullable = false, length = 50)
    private String brand;
    @Column(nullable = false)
    private int year;
    @Column(nullable = false, length = 50)
    private String color;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private VehicleType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private FuelType fuelType;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private TransmissionType transmission;
    @Column(nullable = false)
    private float engine;
    @Column(nullable = false)
    private int power;
    @Column(nullable = false)
    private double mileage;

    private double currentPrice;
    @Column(nullable = false)
    private boolean registered;
    private LocalDate registeredAt;
    private LocalDate registrationExpiresAt;
    @Column(nullable = false, length = 50)
    private String createdBy;
    @Column(nullable = false)
    private LocalDate createdAt;
    private String modifiedBy;
    private LocalDate modifiedAt;

    @OneToMany(mappedBy = "vehicle")
    private List<FuelTransaction> fuelTransactionList;


    @OneToOne()
    @JoinColumn(name="driver_id")
    private Driver driver;

}
