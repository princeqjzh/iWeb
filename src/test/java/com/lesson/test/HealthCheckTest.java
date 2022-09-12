package com.lesson.test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;
import java.util.Calendar;

public class HealthCheckTest {
    String baseURL = "http://localhost:8111";
    String ep = "/healthCheck";

    @Test
    public void check() throws InterruptedException {

        String fullURL = baseURL + ep;
        Response resp = null;

        int timeout = 120; //秒
        long end = System.currentTimeMillis() + timeout * 1000;
        int status = 404;

        while(System.currentTimeMillis() < end && status != 200 ) {
            try{
                System.out.println("Polling check the health endpoint!");
                Thread.sleep(2000);
                resp = RestAssured
                        .given()
                        .config((RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation())))
                        .get(fullURL);
                status = resp.statusCode();
            }catch (Exception ce){
                Thread.sleep(2000);
            }
        }
        //Check the response
        Assertions.assertEquals("Good", resp.asString());
    }
}
