import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {HomeComponent} from './home/home.component';
import {AppRoutingModule} from "./app-routing.module";
import {Page404Component} from './page404/page404.component';
import {CustomersComponent} from './customers/customers.component';
import {CustomerGeneralViewComponent} from './customers/customer-general-view/customer-general-view.component';
import {CustomersService} from "./customers/customers.service";
import {CustomerDetailsViewComponent} from './customers/customer-details-view/customer-details-view.component';
import {CustomerNotesComponent} from './customers/customer-notes/customer-notes.component';
import {FilterByFirstnameAndLastnamePipe} from "./customers/pipes/FilterByFirstnameAndLastnamePipe";
import {FormsModule} from "@angular/forms";
import {LoadingComponent} from './common/loading/loading.component';
import {ErrorHandlerService} from "./common/util/error-handler.service";
import {FullNameWithStatusComponent} from './customers/common/full-name-with-status/full-name-with-status.component';
import {NewNoteComponent} from './customers/customer-notes/new-note/new-note.component';
import {ViewNoteComponent} from './customers/customer-notes/view-note/view-note.component';


@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        Page404Component,
        CustomersComponent,
        CustomerGeneralViewComponent,
        CustomerDetailsViewComponent,
        CustomerNotesComponent,
        FilterByFirstnameAndLastnamePipe,
        LoadingComponent,
        FullNameWithStatusComponent,
        NewNoteComponent,
        ViewNoteComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        AppRoutingModule,
        FormsModule,
    ],
    providers: [
        CustomersService,
        ErrorHandlerService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
