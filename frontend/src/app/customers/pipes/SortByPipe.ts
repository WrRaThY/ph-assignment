import {Pipe, PipeTransform} from "@angular/core";
import * as _ from 'lodash';
import {Customer} from "../customers.models";

@Pipe({
    name: "sortBy"
})

export class SortByPipe  implements PipeTransform {
    transform(customers: Customer[], args: string[]): Customer[] {
        if (!customers) return [];
        if (typeof args === 'undefined' || args.length !== 2) {
            return customers;
        }

        const [key, direction] = args;

        return _.orderBy(customers, (item:Customer) => this.getItemElement(item, key), direction);
    }

    private getItemElement(customer: Customer, chosenSort: string) {
        let item = customer[chosenSort];
        if(item == undefined){
            const personalInfo = customer['personalInfo'];
            return personalInfo[chosenSort];
        } else {
            return item;
        }

    }
}

export enum SortType {
    STATUS = "status",
    FIRST_NAME = "firstname",
    LAST_NAME = "lastame",
    AGE = "age"
}

export enum SortDirection {
    ASC = "asc",
    DESC = "desc"
}
