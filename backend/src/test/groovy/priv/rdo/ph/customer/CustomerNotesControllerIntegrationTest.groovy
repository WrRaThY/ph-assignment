package priv.rdo.ph.customer

import org.springframework.beans.factory.annotation.Autowired
import priv.rdo.ph.IntegrationTestBase
import priv.rdo.ph.customer.model.Customer
import priv.rdo.ph.customer.model.Note
import priv.rdo.ph.customer.model.NoteBuilder

import static org.springframework.http.HttpHeaders.CONTENT_TYPE
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import static priv.rdo.ph.customer.model.CustomerBuilder.aCustomer

class CustomerNotesControllerIntegrationTest extends IntegrationTestBase {
    @Autowired
    CustomersRepository customersRepository

    void setup() {
        customersRepository.deleteAll()
    }

    def "should add a note to an existing customer"() {
        given:
            Note note = NoteBuilder.aNote().build()
            Customer customer = customersRepository.save(aCustomer().build())

        and:
            def request = given()
                    .pathParam("id", customer.id)
                    .body(note)
                    .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)

        when:
            def response = request.when()
                    .post("customers/{id}/notes")

        then:
            response.then()
                    .log().ifValidationFails()
                    .assertThat()
                    .statusCode(200)

        and:
            def foundCustomer = customersRepository.findById(customer.id).get()
            foundCustomer.notes.size() == 1
    }

    def "should remove a note from an existing customer"() {
        given:
            Note note = NoteBuilder.aNote().build()
            Customer customer = customersRepository.save(aCustomer().withNote(note).build())

        and:
            def request = given()
                    .pathParam("id", customer.getId())
                    .pathParam("noteId", note.getId())

        when:
            def response = request.when()
                    .delete("customers/{id}/notes/{noteId}")

        then:
            response.then()
                    .log().ifValidationFails()
                    .assertThat()
                    .statusCode(200)

        and:
            def foundCustomer = customersRepository.findById(customer.id).get()
            foundCustomer.notes.size() == 0
    }

    def "should not do anything special if noteId in the DELETE operation was wrong"() {
        given:
            Note note = NoteBuilder.aNote().build()
            Customer customer = customersRepository.save(aCustomer().withNote(note).build())

        and:
            def request = given()
                    .pathParam("id", customer.getId())
                    .pathParam("noteId", "wrong_ID")

        when:
            def response = request.when()
                    .delete("customers/{id}/notes/{noteId}")

        then:
            response.then()
                    .log().ifValidationFails()
                    .assertThat()
                    .statusCode(200)

        and:
            def foundCustomer = customersRepository.findById(customer.id).get()
            foundCustomer.notes.size() == 1
            foundCustomer.notes[0].title == note.title
    }
}
