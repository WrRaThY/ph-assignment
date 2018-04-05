package priv.rdo.ph.customer.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

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

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("country", country)
                .append("city", city)
                .append("street", street)
                .append("buildingNumber", buildingNumber)
                .append("flatNumber", flatNumber)
                .toString();
    }
}
