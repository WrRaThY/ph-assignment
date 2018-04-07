package priv.rdo.ph.customer.model;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static priv.rdo.ph.common.IdProvider.id;
import static priv.rdo.ph.common.TimeProvider.nowAsString;

@Getter
@ToString
@TypeAlias("customer")
public class Customer {
    @Id
    private final String id;
    private final CustomerStatus status;

    private final PersonalInformation personalInfo;
    private final Address address;

    private final String creationTimestamp;

    private final List<Note> notes;

    private Customer(String id, CustomerStatus status, PersonalInformation personalInfo, Address address, String creationTimestamp, List<Note> notes) {
        this.id = id;
        this.status = status;
        this.personalInfo = personalInfo;
        this.address = address;
        this.creationTimestamp = creationTimestamp;
        this.notes = notes;
    }

    public static Customer of(PersonalInformation personalInfo, Address address, String creationTimestamp) {
        return new Customer(id(), CustomerStatus.PROSPECTIVE, personalInfo, address, creationTimestamp, new ArrayList<>());
    }

    public static Customer of(PersonalInformation personalInfo, Address address) {
        return of(personalInfo, address, nowAsString());
    }

    public Customer updateStatus(CustomerStatus newStatus) {
        return new Customer(
                this.id,
                newStatus,
                this.personalInfo,
                this.address,
                this.creationTimestamp,
                this.notes);
    }

    public Customer addNote(Note note) {
        notes.add(note);
        return this;
    }

    public Customer addNotes(List<Note> notes) {
        this.notes.addAll(notes);
        return this;
    }

    public Customer removeNote(String noteId) {
        Optional<Note> noteToBeDeleted = notes.stream().filter(note -> note.getId().equals(noteId)).findFirst();
        noteToBeDeleted.ifPresent(notes::remove);
        return this;
    }

    public Customer editNote(String noteId, Note note) {
        for (Note existingNote : notes) {
            if (existingNote.getId().equals(noteId)) {
                existingNote.updateNote(note);
            }
        }
        return this;
    }
}


