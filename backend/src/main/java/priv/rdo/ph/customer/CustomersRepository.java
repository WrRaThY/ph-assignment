package priv.rdo.ph.customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import priv.rdo.ph.customer.model.Customer;

@Repository
interface CustomersRepository extends MongoRepository<Customer, String> {

}
