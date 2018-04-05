package priv.rdo.ph.customer.model

final class AddressBuilder {
    private String country = "New Zealand"
    private String city = "Auckland"
    private String street = "Drake"
    private String buildingNumber = "34"
    private String flatNumber = ""

    private AddressBuilder() {
    }

    static AddressBuilder anAddress() {
        return new AddressBuilder()
    }

    def withCountry(String country) {
        this.country = country
        return this
    }

    def withCity(String city) {
        this.city = city
        return this
    }

    def withStreet(String street) {
        this.street = street
        return this
    }

    def withBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber
        return this
    }

    def withFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber
        return this
    }

    def build() {
        return new Address(country, city, street, buildingNumber, flatNumber)
    }
}
