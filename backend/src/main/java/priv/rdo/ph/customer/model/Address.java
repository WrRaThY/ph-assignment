package priv.rdo.ph.customer.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Address {
    private final String country;
    private final String city;
    private final String street;
    private final String buildingNumber;
    private final String flatNumber;

    public Address(String country, String city, String street, String buildingNumber, String flatNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.flatNumber = flatNumber;
    }
}
