package dev.naimsulejmani.grupi3fleetmanagement.dtos;

import dev.naimsulejmani.grupi3fleetmanagement.enums.FuelType;
import dev.naimsulejmani.grupi3fleetmanagement.models.Driver;
import dev.naimsulejmani.grupi3fleetmanagement.models.FuelProvider;
import dev.naimsulejmani.grupi3fleetmanagement.models.User;
import dev.naimsulejmani.grupi3fleetmanagement.models.Vehicle;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuelTransactionDto {
    @PositiveOrZero(message = "Id must be positive or zero")
    private long id;

    @Size(max = 25, message = "Receipt number must be maximum 25 characters")
    @NotNull(message = "Receipt number is required")
    @NotBlank(message = "Receipt number is required")
    private String receiptNumber;

    @Positive(message = "Fuel provider id must be positive")
    private long fuelProviderId;

    @Size(max=100, message = "Fuel station number must be maximum 100 characters")
    @NotNull(message = "Fuel station number is required")
    @NotBlank(message = "Fuel station number is required")
    private String fuelStationNumber;

    @Size(max=100, message = "Location number must be maximum 100 characters")
    @NotNull(message = "Location number is required")
    @NotBlank(message = "Location number is required")
    private String location;

    @Positive(message = "Vehicle id must be positive")
    private long vehicleId;


    @Positive(message = "Driver id must be positive")
    private long driverId;

    @Positive(message = "User id must be positive")
    private long userId;

    @Positive(message = "Quantity must be positive")
    private double quantity;
    @PositiveOrZero(message = "Price per quantity must be positive or zero")
    private double pricePerQuantity;

    @PositiveOrZero(message = "Total price must be positive or zero")
    private double totalPrice;


    private FuelType fuelType;

    @PastOrPresent(message = "Date must be in the past or present")
    @NotNull(message = "Date is required")
    private LocalDate date;

    @Size(max=1000, message = "Comment must be maximum 1000 characters")
    private String comment;


    private String createdBy;

    private LocalDateTime createdAt = LocalDateTime.now();

    private String modifiedBy;

    private LocalDateTime modifiedAt;
}

















