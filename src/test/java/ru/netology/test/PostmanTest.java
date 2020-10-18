package ru.netology.test;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class PostmanTest {

    @Test
    public void shouldPostData() {
        given()
                .baseUri("https://postman-echo.com")
                .body("Postman data")
                .contentType("text/plain; charset=UTF-8")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("Postman data"))
        ;
    }
}