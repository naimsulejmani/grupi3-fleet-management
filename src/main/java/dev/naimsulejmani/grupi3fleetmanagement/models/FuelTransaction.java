package dev.naimsulejmani.grupi3fleetmanagement.models;

import dev.naimsulejmani.grupi3fleetmanagement.enums.FuelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "fuel_transactions")
public class FuelTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "receipt_number", length = 25, nullable = false)
    private String receiptNumber;

    @ManyToOne()
    @JoinColumn(name="fuel_provider_id")
    private FuelProvider fuelProvider;

    @Column(length = 100, nullable = false)
    private String fuelStationNumber;

    @Column(length = 100)
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
    @Column(nullable = false, columnDefinition = "DOUBLE")
    private double quantity;
    @Column(nullable = false, columnDefinition = "DOUBLE")
    private double pricePerQuantity;
    @Column(nullable = false, columnDefinition = "DOUBLE")
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private FuelType fuelType;

    @Column(nullable = false)
    private LocalDate date;

    @Column(length = 1000)
    private String comment;

    @Column(nullable = false, length = 50)
    private String createdBy;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(length = 50)
    private String modifiedBy;

    private LocalDateTime modifiedAt;

}
