import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Customer} from "../customers.models";

@Component({
    selector: 'ph-customer-general-view',
    templateUrl: './customer-general-view.component.html',
    styleUrls: ['./customer-general-view.component.scss']
})
export class CustomerGeneralViewComponent implements OnInit {
    @Input() customer: Customer;
    @Output() onDelete: EventEmitter<Customer> = new EventEmitter<Customer>();

    constructor() {
    }

    ngOnInit() {
    }

    deleteCustomer() {
        this.onDelete.emit(this.customer)
    }
}
