package com.APITest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.*;

public class LogoutUserTest {

    private static ExtentReports extent;
    private static ExtentTest test;
    private String token;

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("LogoutUserExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeClass
    public void loginAndGetToken() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

        String loginPayload = "{\n" +
                "  \"email\": \"imrskujur@gmail.com\",\n" +
                "  \"password\": \"Apple.123\"\n" +
                "}";

        Response loginResponse = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(loginPayload)
                .post("/users/login");

        token = loginResponse.jsonPath().getString("token");
        Assert.assertEquals(loginResponse.getStatusCode(), 200, "Login failed");
    }

    @Test
    public void testLogoutUser() {
        test = extent.createTest("Logout User Test");

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .post("/users/logout");

        test.info("Status Code: " + response.getStatusCode());
        test.info("Response: " + response.getBody().asString());

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200, "Logout failed - expected 200 OK");
        test.pass("Logout was successful and returned 200 OK.");
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}