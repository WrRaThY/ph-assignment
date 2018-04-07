package priv.rdo.ph.customer;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.stereotype.Service;
import priv.rdo.ph.common.errors.EntityNotFoundException;
import priv.rdo.ph.customer.model.Address;
import priv.rdo.ph.customer.model.Customer;
import priv.rdo.ph.customer.model.CustomerStatus;
import priv.rdo.ph.customer.model.Note;
import priv.rdo.ph.customer.model.PersonalInformation;

import java.util.List;

@Service
class CustomersService {
    private static final XLogger LOG = XLoggerFactory.getXLogger(CustomersService.class);

    private final CustomersRepository customersRepository;

    CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    Customer addCustomer(Address address, PersonalInformation info) {
        LOG.entry(address, info);

        return customersRepository.save(Customer.of(info, address));
    }

    Customer findById(String id) {
        LOG.entry(id);

        return customersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Customer.class, id));
    }

    List<Customer> findAll() {
        LOG.entry();

        return customersRepository.findAll();
    }

    Customer updateStatus(String id, CustomerStatus newStatus) {
        LOG.entry(id, newStatus);

        Customer customer = findById(id);

        return customersRepository.save(customer.updateStatus(newStatus));
    }

    void addNote(String id, Note note) {
        LOG.entry(id, note);

        Customer customer = findById(id);

        customersRepository.save(customer.addNote(note));
    }

    void removeNote(String customerId, String noteId) {
        LOG.entry(customerId, noteId);

        Customer customer = findById(customerId);

        customersRepository.save(customer.removeNote(noteId));
    }

    void editNote(String customerId, String noteId, Note note) {
        LOG.entry(customerId, noteId, note);

        Customer customer = findById(customerId);

        customersRepository.save(customer.editNote(noteId, note));
    }
}
