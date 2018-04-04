import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Component({
    selector: 'app-testtest',
    templateUrl: './testtest.component.html',
    styleUrls: ['./testtest.component.css']
})
export class TesttestComponent implements OnInit {
    protected dummies$: Observable<DummyObject>;

    constructor(private http: HttpClient) {

    }

    ngOnInit(): void {
        this.dummies$ = this.dummySearch();
    }

    dummySearch(): Observable<DummyObject> {
        const url = 'http://localhost:8080/test';
        return this.http.get<DummyObject>(url)
    }

}
