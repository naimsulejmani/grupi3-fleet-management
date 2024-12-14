package dev.naimsulejmani.grupi3fleetmanagement.models;

import dev.naimsulejmani.grupi3fleetmanagement.enums.FuelType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuelTransaction {
    private long id;
    private String receiptNumber;
    private long fuelStationId;
    private String fuelStationNumber;
    private String location;
    private long vehicleId;

    @ManyToOne()
    private Driver driver;
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
