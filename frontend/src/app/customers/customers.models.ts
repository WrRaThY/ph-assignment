export class Customer {
    id: string;
    status: CustomerStatus;
    personalInfo: PersonalInfo;
    address: Address;
    creationTimestamp: string;
    notes: Note[];
}

export enum CustomerStatus {
    PROSPECTIVE = "PROSPECTIVE",
    CURRENT = "CURRENT",
    NON_ACTIVE = "NON_ACTIVE"
}

export class PersonalInfo {
    firstname: string;
    lastname: string;
    age: number;
}

export class Address {
    country: string;
    city: string;
    street: string;
    buildingNumber: string;
    flatNumber: string;
}

export class Note {
    id: string;
    title: string;
    content: string;
}

export class StatusUpdateRequest {
    constructor(public newStatus: CustomerStatus) {

    }
}
