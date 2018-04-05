package priv.rdo.ph

import io.restassured.RestAssured
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
class IntegrationTestBase extends Specification {

    @LocalServerPort
    Integer port

    def given() {
        return RestAssured.given()
                .log().ifValidationFails()
                .port(port)
    }
}
