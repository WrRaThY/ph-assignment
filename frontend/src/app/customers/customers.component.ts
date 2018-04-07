import {AfterViewInit, Component, OnInit} from '@angular/core';
import {CustomersService} from "./customers.service";
import {Customer} from "./customers.models";
import {ErrorHandlerService} from "../common/util/error-handler.service";

@Component({
    selector: 'ph-customers',
    templateUrl: './customers.component.html',
    styleUrls: ['./customers.component.scss'],
    providers: [CustomersService]
})
export class CustomersComponent implements OnInit, AfterViewInit {
    protected customers: Customer[];
    protected firstnameOrLastnameSearch: string;

    constructor(private customersService: CustomersService,
                private errorHandler: ErrorHandlerService) {
    }

    ngOnInit() {
        this.findAllCustomers();
    }

    ngAfterViewInit(): void {
        this.findAllCustomers();
    }

    private findAllCustomers() {
        this.customersService.findAllCustomers()
            .subscribe(
                success => this.customers = success,
                error => this.errorHandler.handleHttpError(error)
            )
    }

}
