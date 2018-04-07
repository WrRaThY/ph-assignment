package priv.rdo.ph.customer.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

import static priv.rdo.ph.common.IdProvider.id;

@NoArgsConstructor(access = AccessLevel.PRIVATE) //jackson
@Getter
@ToString
@EqualsAndHashCode(of = {"id"})
public class Note {
    private String id = id();

    @NotBlank
    private String title;

    private String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    void updateNote(Note note) {
        this.title = note.title;
        this.content = note.content;
    }
}
