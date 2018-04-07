package priv.rdo.ph.customer;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import priv.rdo.ph.customer.model.Address;
import priv.rdo.ph.customer.model.Customer;
import priv.rdo.ph.customer.model.PersonalInformation;

import java.util.stream.IntStream;

import static priv.rdo.ph.common.TimeProvider.nowAsStringPlusMinutes;

@Component
class SampleDataInitializer {
    private static final XLogger LOG = XLoggerFactory.getXLogger(SampleDataInitializer.class);

    private final CustomersRepository customersRepository;

    SampleDataInitializer(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        LOG.entry();

        addCustomers(7);

        LOG.exit();
    }

    private void addCustomers(int numberOfCustomers) {
        IntStream.range(0, numberOfCustomers)
                .forEach(customerNumber -> customersRepository.save(buildSampleCustomer(customerNumber)));
    }

    private Customer buildSampleCustomer(int customerNumber) {
        return Customer.of(
                        new PersonalInformation(
                                "TestFirstName" + customerNumber,
                                "TestLastName" + customerNumber,
                                20 + customerNumber
                        ),
                        new Address(
                                "New Zealand",
                                "Auckland",
                                "Drake",
                                "34",
                                String.valueOf(customerNumber)
                        ),
                        nowAsStringPlusMinutes(customerNumber)
                );
    }
}
