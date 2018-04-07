import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Note} from "../../customers.models";

@Component({
    selector: 'ph-view-note',
    templateUrl: './view-note.component.html',
    styleUrls: ['./view-note.component.scss']
})
export class ViewNoteComponent implements OnInit {
    @Input() protected note: Note;
    @Output() onClose: EventEmitter<any> = new EventEmitter<any>();
    @Output() onDelete: EventEmitter<Note> = new EventEmitter<Note>();
    @Output() onSave: EventEmitter<Note> = new EventEmitter<Note>();

    @Input() isReadOnly: boolean = true;

    constructor() {
    }

    ngOnInit() {
    }

    closeNote() {
        this.onClose.emit(null);
        this.note = new Note();
    }

    deleteNote() {
        this.onDelete.emit(this.note);
        this.note = new Note();
    }

    saveNote() {
        this.onSave.emit(this.note);
        this.note = new Note();
    }

    editNote() {
        this.isReadOnly = false;
    }

}
