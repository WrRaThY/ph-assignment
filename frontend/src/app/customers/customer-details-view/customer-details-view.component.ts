import {Component, OnInit} from '@angular/core';
import {Customer, CustomerStatus} from "../customers.models";
import {ActivatedRoute} from "@angular/router";
import {CustomersService} from "../customers.service";
import {ErrorHandlerService} from "../../common/util/error-handler.service";

@Component({
    selector: 'ph-customer-details-view',
    templateUrl: './customer-details-view.component.html',
    styleUrls: ['./customer-details-view.component.scss'],
    providers: [CustomersService]
})
export class CustomerDetailsViewComponent implements OnInit {
    protected customer: Customer;
    protected customerStatus = CustomerStatus;

    constructor(private customersService: CustomersService,
                private route: ActivatedRoute,
                private errorHandler: ErrorHandlerService) {
    }

    ngOnInit() {
        const id = this.route.snapshot.paramMap.get('id');
        this.findById(id);
    }

    selectStatus(newStatus: CustomerStatus) {
        this.customersService.updateStatus(this.customer.id, newStatus)
            .subscribe(
                () => {this.findById(this.customer.id)},
                error => this.errorHandler.handleHttpError(error)
            )
    }

    private findById(id) {
        this.customersService.findById(id)
            .subscribe(
                success => this.customer = success,
                error => this.errorHandler.handleHttpError(error)
            )
    }

}
