import {AfterViewInit, Component, OnInit} from '@angular/core';
import {CustomersService} from "./customers.service";
import {Customer} from "./customers.models";
import {ErrorHandlerService} from "../common/util/error-handler.service";
import {SortDirection, SortType} from "./pipes/SortByPipe";

@Component({
    selector: 'ph-customers',
    templateUrl: './customers.component.html',
    styleUrls: ['./customers.component.scss'],
    providers: [CustomersService]
})
export class CustomersComponent implements OnInit, AfterViewInit {
    protected sortTypes = SortType;
    protected sortDirections = SortDirection;

    protected customers: Customer[];
    protected firstnameOrLastnameSearch: string;
    protected sortByWhat: SortType = SortType.STATUS;
    protected sortDirection: SortDirection = SortDirection.ASC;

    constructor(private customersService: CustomersService,
                private errorHandler: ErrorHandlerService) {
    }

    ngOnInit() {
        this.findAllCustomers();
    }

    ngAfterViewInit(): void {
        this.findAllCustomers();
    }

    deleteCustomer(customer: Customer) {
        this.customersService.deleteCustomer(customer.id)
            .subscribe(
                () => this.findAllCustomers(),
                error => this.errorHandler.handleHttpError(error)
            )
    }

    private findAllCustomers() {
        this.customersService.findAllCustomers()
            .subscribe(
                success => this.customers = success,
                error => this.errorHandler.handleHttpError(error)
            )
    }

}
