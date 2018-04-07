import {Pipe, PipeTransform} from "@angular/core";
import {Customer} from "../customers.models";

@Pipe({
    name: 'filterByFirstnameAndLastname'
})

export class FilterByFirstnameAndLastnamePipe implements PipeTransform {
    transform(items: Customer[], searchText: string): Customer[] {
        if (!items) return [];
        if (!searchText) return items;

        searchText = searchText.toLowerCase();

        return items
            .filter(it => {
                    return this.fullName(it).toLowerCase().includes(searchText);
                }
            );
    }

    fullName(customer: Customer): string {
        return customer.personalInfo.firstname + " " + customer.personalInfo.lastname;
    }

}
