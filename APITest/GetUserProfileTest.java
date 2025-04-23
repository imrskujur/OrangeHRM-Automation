package com.APITest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.*;

public class GetUserProfileTest {

    private static ExtentReports extent;
    private static ExtentTest test;
    private String token; // Token will be fetched at runtime

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @BeforeClass
    public void loginAndGetToken() {
        // Set base URI
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

        // Login payload
        String loginPayload = "{\n" +
                "  \"email\": \"imrskujur@gmail.com\",\n" +
                "  \"password\": \"Apple.123\"\n" +
                "}";

        // Send login request
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(loginPayload)
                .post("/users/login");

        // Extract token
        token = response.jsonPath().getString("token");

        // Optional log
        System.out.println("Fetched Token: " + token);

        // Check login success
        Assert.assertEquals(response.getStatusCode(), 200, "Login failed. Check credentials.");
    }

    @Test
    public void testGetUserProfile() {
        test = extent.createTest("Get User Profile API Test");

        RequestSpecification request = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .log().all();

        Response response = request.get("/users/me");

        // Log response for debugging
        response.then().log().all();

        int statusCode = response.getStatusCode();
        String statusLine = response.getStatusLine();

        test.info("Status Code: " + statusCode);
        test.info("Status Line: " + statusLine);

        try {
            Assert.assertEquals(statusCode, 200, "Expected status code 200");
            Assert.assertTrue(statusLine.contains("OK"), "Expected status line to contain 'OK'");
            test.pass("Status Code and Status Message Validation Passed");
        } catch (AssertionError e) {
            test.fail("Validation failed: " + e.getMessage());
            throw e;
        }
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}