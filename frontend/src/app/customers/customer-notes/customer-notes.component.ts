import {Component, OnInit} from '@angular/core';
import {CustomersService} from "../customers.service";
import {Customer, Note} from "../customers.models";
import {ErrorHandlerService} from "../../common/util/error-handler.service";
import {ActivatedRoute} from "@angular/router";

@Component({
    selector: 'ph-customer-notes',
    templateUrl: './customer-notes.component.html',
    styleUrls: ['./customer-notes.component.scss'],
    providers: [CustomersService]
})
export class CustomerNotesComponent implements OnInit {
    protected customer: Customer;
    protected showNewNote = false;
    protected showViewNote = false;
    protected selectedNote: Note;

    constructor(private customersService: CustomersService,
                private route: ActivatedRoute,
                private errorHandler: ErrorHandlerService) {
    }

    ngOnInit() {
        const id = this.route.snapshot.paramMap.get('id');
        this.findById(id);
    }

    newNote() {
        this.showNewNote = true;
        this.selectedNote = new Note();
    }

    viewNote(note: Note) {
        this.selectedNote = note;
        this.showViewNote = true;
    }

    saveNote(note: Note, editExisting: boolean = false) {
        if (editExisting){
            this.customersService.editNote(this.customer.id, note)
                .subscribe(
                    () => this.findById(this.customer.id),
                    error => this.errorHandler.handleHttpError(error)
                );
        } else {
            this.customersService.addNote(this.customer.id, note)
                .subscribe(
                    () => this.findById(this.customer.id),
                    error => this.errorHandler.handleHttpError(error)
                );
        }

        this.hideNotes();
    }

    removeNote(note: Note) {
        this.customersService.removeNote(this.customer.id, note.id)
            .subscribe(
                () => this.findById(this.customer.id),
                error => this.errorHandler.handleHttpError(error)
            );
        this.hideNotes();
    }

    private findById(id) {
        this.customersService.findById(id)
            .subscribe(
                success => this.customer = success,
                error => this.errorHandler.handleHttpError(error)
            )
    }

    hideNotes() {
        this.showNewNote = false;
        this.showViewNote = false;
    }

}
