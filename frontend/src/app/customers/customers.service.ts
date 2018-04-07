import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {Customer, CustomerStatus, Note, StatusUpdateRequest} from "./customers.models";
import {environment} from "../../environments/environment";

@Injectable()
export class CustomersService {

    constructor(private http: HttpClient) {

    }

    findAllCustomers(): Observable<Customer[]> {
        return this.http.get<Customer[]>(environment.url);
    }

    updateStatus(customerId: string, newStatus: CustomerStatus): Observable<any> {
        const request = new StatusUpdateRequest(newStatus);
        const url = `${environment.url}/${customerId}`;
        return this.http.patch<Customer>(url, request)
    }

    findById(customerId: string): Observable<Customer> {
        const url = `${environment.url}/${customerId}`;
        return this.http.get<Customer>(url)
    }

    addNote(customerId: string, note: Note): Observable<any> {
        const url = `${environment.url}/${customerId}/notes`;
        return this.http.post<Customer>(url, note)
    }

    removeNote(customerId: string, noteId: string): Observable<any> {
        const url = `${environment.url}/${customerId}/notes/${noteId}`;
        return this.http.delete<Customer>(url)
    }
}
