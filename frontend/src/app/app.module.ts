import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {HomeComponent} from './home/home.component';
import {AppRoutingModule} from "./app-routing.module";
import {Page404Component} from './page404/page404.component';
import {FormsModule} from "@angular/forms";


@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        Page404Component,
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        AppRoutingModule,
        FormsModule,
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
