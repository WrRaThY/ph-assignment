package priv.rdo.ph.customer.model

final class NoteBuilder {
    private String title = "Test title"
    private String content = "Test content"

    private NoteBuilder() {
    }

    static NoteBuilder aNote() {
        return new NoteBuilder()
    }

    NoteBuilder withTitle(String title) {
        this.title = title
        return this
    }

    NoteBuilder withContent(String content) {
        this.content = content
        return this
    }

    Note build() {
        return new Note(title, content)
    }
}
