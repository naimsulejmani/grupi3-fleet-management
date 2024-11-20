package dev.naimsulejmani.grupi3fleetmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuelStation {
    private long id;
    private String name;
    private String address;
    private String city;
    private String country;
    private String postalCode;
}








