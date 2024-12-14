package dev.naimsulejmani.grupi3fleetmanagement.models;

import dev.naimsulejmani.grupi3fleetmanagement.enums.FuelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FuelTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String receiptNumber;

    @ManyToOne()
    @JoinColumn(name="fuel_provider_id")
    private FuelProvider fuelProvider;

    private String fuelStationNumber;
    private String location;

    @ManyToOne()
    @JoinColumn(name="vehicle_id")
    private Vehicle vehicle;


    //driver_id INT NOT NULL REFERENCES drivers(id),
    @ManyToOne()
    @JoinColumn(name="driver_id")
    private Driver driver;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

//    private long driverId;
    private double quantity;
    private double pricePerQuantity;
    private double totalPrice;
    private FuelType fuelType;
    private LocalDate date;
    private String comment;
    private String createdBy;
    private LocalDate createdAt;
    private String modifiedBy;
    private LocalDate modifiedAt;
    private String deletedBy;
    private LocalDate deletedAt;

}
