package priv.rdo.ph.customer;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.rdo.ph.customer.model.Note;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("customers/{id}/notes")
class CustomerNotesController {
    private static final XLogger LOG = XLoggerFactory.getXLogger(CustomerNotesController.class);

    private final CustomersService customersService;

    CustomerNotesController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping
    List<Note> listAllNotes(@PathVariable String id) {
        LOG.entry(id);

        return customersService.findById(id).getNotes();
    }

    @PostMapping
    void addNote(@PathVariable String id, @RequestBody @Valid Note note) {
        LOG.entry(id, note);

        customersService.addNote(id, note);
    }

    @DeleteMapping("{noteId}")
    void removeNote(@PathVariable String id, @PathVariable String noteId) {
        LOG.entry(id, noteId);

        customersService.removeNote(id, noteId);
    }

    @PutMapping("{noteId}")
    void editNote(@PathVariable String id, @PathVariable String noteId, @RequestBody @Valid Note note) {
        LOG.entry(id, noteId);

        customersService.editNote(id, noteId, note);
    }


}
