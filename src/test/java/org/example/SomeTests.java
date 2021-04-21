package org.example;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SomeTests {

    @BeforeClass
    public void setUp(){
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured.filters(new ResponseLoggingFilter());
    }

    @Test
    public void someTest(){
        given()
                .pathParam("id", 64)
                .when()
                .get("/pet/{id}")
                .then()
                .statusCode(200);
    }
}
