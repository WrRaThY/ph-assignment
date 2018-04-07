import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {Page404Component} from "./page404/page404.component";
import {CustomersComponent} from "./customers/customers.component";
import {CustomerDetailsViewComponent} from "./customers/customer-details-view/customer-details-view.component";
import {CustomerNotesComponent} from "./customers/customer-notes/customer-notes.component";

const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    }, {
        path: 'customers/:id/notes',
        component: CustomerNotesComponent
    }, {
        path: 'customers/:id',
        component: CustomerDetailsViewComponent
    }, {
        path: 'customers',
        component: CustomersComponent
    }, {
        path: '**',
        component: Page404Component
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
