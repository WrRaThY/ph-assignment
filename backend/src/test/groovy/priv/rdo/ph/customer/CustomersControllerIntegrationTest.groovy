package priv.rdo.ph.customer

import org.hamcrest.CoreMatchers
import org.springframework.beans.factory.annotation.Autowired
import priv.rdo.ph.IntegrationTestBase
import priv.rdo.ph.customer.model.Customer

import static priv.rdo.ph.customer.model.CustomerBuilder.aCustomer

class CustomersControllerIntegrationTest extends IntegrationTestBase {
    @Autowired
    CustomersRepository customersRepository

    void setup() {
        customersRepository.deleteAll()
    }

    def "should not get a customer by bad id - 404 expected"() {
        given:
            def request = given()
                    .pathParam("id", "wrong_id")

        when:
            def response = request.when()
                    .get("customers/{id}")

        then:
            response.then()
                    .log().ifValidationFails()
                    .assertThat()
                    .statusCode(404)
    }

    def "should get a customer by id"() {
        given:
            Customer customer = customersRepository.save(aCustomer().build())

        and:
            def request = given()
                    .pathParam("id", customer.getId())

        when:
            def response = request.when()
                    .get("customers/{id}")

        then:
            response.then()
                    .log().ifValidationFails()
                    .assertThat()
                    .statusCode(200)
                    .body("id", CoreMatchers.is(customer.id))
                    .body("address.street", CoreMatchers.is(customer.address.street))
    }

    def "should list two customers"() {
        given:
            customersRepository.save(aCustomer().build())
            customersRepository.save(aCustomer().build())

        and:
            def request = given()

        when:
            def response = request.when()
                    .get("customers")

        then:
            response.then()
                    .log().ifValidationFails()
                    .assertThat()
                    .statusCode(200)
                    .body("size()", CoreMatchers.is(2))
    }
}
