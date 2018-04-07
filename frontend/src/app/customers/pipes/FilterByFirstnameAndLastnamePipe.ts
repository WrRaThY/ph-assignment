import {Pipe, PipeTransform} from "@angular/core";
import {Customer} from "../customers.models";

@Pipe({
    name: 'filterByFirstnameAndLastname'
})

export class FilterByFirstnameAndLastnamePipe implements PipeTransform {
    transform(customers: Customer[], searchText: string): Customer[] {
        if (!customers) return [];
        if (!searchText) return customers;

        searchText = searchText.toLowerCase();

        return customers
            .filter(it => {
                    return this.fullName(it).toLowerCase().includes(searchText);
                }
            );
    }

    fullName(customer: Customer): string {
        return customer.personalInfo.firstname + " " + customer.personalInfo.lastname;
    }

}
