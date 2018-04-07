import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Note} from "../../customers.models";

@Component({
    selector: 'ph-new-note',
    templateUrl: './new-note.component.html',
    styleUrls: ['./new-note.component.scss']
})
export class NewNoteComponent implements OnInit {
    @Output() onClose: EventEmitter<any> = new EventEmitter<any>();
    @Output() onSave: EventEmitter<Note> = new EventEmitter<Note>();

    protected note: Note = new Note();

    constructor() {
    }

    ngOnInit() {
    }

    closeNote() {
        this.note = new Note();
        this.onClose.emit(null);
    }

    saveNote() {
        this.onSave.emit(this.note);
        this.note = new Note();
    }
}
