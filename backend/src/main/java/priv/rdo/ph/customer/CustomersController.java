package priv.rdo.ph.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import priv.rdo.ph.customer.model.Customer;
import priv.rdo.ph.customer.model.StatusUpdateRequest;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("customers")
class CustomersController {
    private final CustomersService customersService;

    CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping("{id}")
    Customer getById(@PathVariable String id) {
        return customersService.findById(id);
    }

    @GetMapping
    List<Customer> findAllCustomers() {
        return customersService.findAll();
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updateStatus(@PathVariable String id,
                      @RequestBody @Valid StatusUpdateRequest request) {
        customersService.updateStatus(id, request.getNewStatus());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteCustomer(@PathVariable String id) {
        customersService.deleteById(id);
    }
}
