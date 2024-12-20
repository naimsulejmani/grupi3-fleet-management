package dev.naimsulejmani.grupi3fleetmanagement.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuelProviderDto {
    private long id;

    @NotNull(message = "Name should not be null")
    @NotBlank(message = "Name should not be empty or blank")
    @Size(min=3,max = 50, message = "Name must be between 3 and 50 characters long")
    private String name;

    @Size(max = 200, message = "Address must be less than 200 characters long")
    private String address;

    @Size(max = 50, message = "City must be less than 50 characters long")
    private String city;

    @Size(max = 50, message = "Country must be less than 50 characters long")
    private String country;

    @Size(max = 10, message = "Postal code must be less than 10 characters long")
    private String postalCode;

    @Size(max = 20, message = "Phone number must be less than 20 characters long")
    private String phoneNumber;

    @Email(message = "Email should be valid")
    @Size(max = 50, message = "Email must be less than 50 characters long")
    private String email;

    @NotNull(message = "Fiscal number should not be null")
    @NotBlank(message = "Fiscal number should not be empty or blank")
    @Size(max = 20, message = "Fiscal number must be less than 255 characters long")
    private String fiscalNo;

    @NotNull(message = "VAT number should not be null")
    @NotBlank(message = "VAT number should not be empty or blank")
    @Size(max = 20, message = "VAT number must be less than 255 characters long")
    private String vatNo;

    @NotNull(message = "Business number should not be null")
    @NotBlank(message = "Business number should not be empty or blank")
    @Size(max = 20, message = "Business number must be less than 255 characters long")
    private String businessNo;
}