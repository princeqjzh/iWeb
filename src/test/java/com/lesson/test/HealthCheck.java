package com.lesson.test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HealthCheck {
    String baseURL = "http://localhost:8071";
    String ep = "/healthCheck";

    @Test
    public void check() {

        String fullURL = baseURL + ep;
        Response resp = RestAssured
                .given()
                .config((RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation())))
                .get(fullURL);
        //Check the response
        Assertions.assertEquals(200, resp.statusCode());
        Assertions.assertEquals("Good", resp.asString());
    }
}
