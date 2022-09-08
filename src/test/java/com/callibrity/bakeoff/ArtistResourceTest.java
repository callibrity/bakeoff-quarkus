package com.callibrity.bakeoff;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ArtistResourceTest {

    @Test
    public void listShouldReturnEmptyList() {
        given()
          .when().get("/api/artists")
          .then()
             .statusCode(200)
             .body(is("[]"));
    }

}