import {Component, Input, OnInit} from '@angular/core';
import {Customer, CustomerStatus} from "../../customers.models";

@Component({
    selector: 'ph-full-name-with-status',
    templateUrl: './full-name-with-status.component.html',
    styleUrls: ['./full-name-with-status.component.scss']
})
export class FullNameWithStatusComponent implements OnInit {
    @Input() protected customer: Customer;
    protected customerStatus = CustomerStatus;

    constructor() {
    }

    ngOnInit() {
    }

}
