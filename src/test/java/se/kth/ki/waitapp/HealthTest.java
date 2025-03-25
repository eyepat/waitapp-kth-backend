package se.kth.ki.waitapp;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class HealthTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/healthz")
          .then()
             .statusCode(200)
             .body(is("Healthy :)"));
    }

}