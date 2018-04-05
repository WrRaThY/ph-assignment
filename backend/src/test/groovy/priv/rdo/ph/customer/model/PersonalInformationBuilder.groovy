package priv.rdo.ph.customer.model

final class PersonalInformationBuilder {
    private String firstname = "David"
    private String lastname = "Test"
    private int age = 21

    private PersonalInformationBuilder() {
    }

    static PersonalInformationBuilder aPersonalInformation() {
        return new PersonalInformationBuilder()
    }

    PersonalInformationBuilder withFirstname(String firstname) {
        this.firstname = firstname
        return this
    }

    PersonalInformationBuilder withLastname(String lastname) {
        this.lastname = lastname
        return this
    }

    PersonalInformationBuilder withAge(int age) {
        this.age = age
        return this
    }

    PersonalInformation build() {
        return new PersonalInformation(firstname, lastname, age)
    }
}
