package priv.rdo.ph.customer.model

import static priv.rdo.ph.common.TimeProvider.nowAsString

final class CustomerBuilder {
    private PersonalInformation personalInfo = PersonalInformationBuilder.aPersonalInformation().build()
    private Address address = AddressBuilder.anAddress().build()
    private String creationTimestamp = nowAsString()
    private List<Note> notes = new ArrayList<>()

    private CustomerBuilder() {
    }

    static CustomerBuilder aCustomer() {
        return new CustomerBuilder()
    }

    CustomerBuilder withPersonalInfo(PersonalInformation personalInfo) {
        this.personalInfo = personalInfo
        return this
    }

    CustomerBuilder withAddress(Address address) {
        this.address = address
        return this
    }

    CustomerBuilder withCreationTimestamp(String creationTimestamp) {
        this.creationTimestamp = creationTimestamp
        return this
    }

    CustomerBuilder withNote(Note note) {
        this.notes.add(note)
        return this
    }

    Customer build() {
        return Customer.of(personalInfo, address, creationTimestamp).addNotes(notes)
    }
}
