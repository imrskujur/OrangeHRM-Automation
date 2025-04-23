package com.APITest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.*;

public class GetContactByIdTest {

    private static ExtentReports extent;
    private static ExtentTest test;
    private String token;

    @BeforeSuite
    public void setupReport() {
        // Initialize ExtentReports with a Spark reporter to generate HTML report
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-get-contact-report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @BeforeClass
    public void loginAndGetToken() {
        // Base URI for all API requests
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

        // Replace with your valid login details
        String loginPayload = "{\n" +
                "  \"email\": \"imrskujur@gmail.com\",\n" +
                "  \"password\": \"Apple.123\"\n" +
                "}";

        // Login to get the Bearer token
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(loginPayload)
                .post("/users/login");

        token = response.jsonPath().getString("token");

        // Assert if token is fetched successfully
        Assert.assertEquals(response.getStatusCode(), 200, "Login failed. Couldn't fetch token.");
    }

    @Test
    public void testGetContacts() {
        test = extent.createTest("Get Contact API Test");

        // Prepare request with Bearer token
        RequestSpecification request = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .log().all();  // Log request details for debugging

        // Send GET request to fetch contacts
        Response response = request.get("/contacts");

        // Log the entire response for debugging
        response.then().log().all();

        // Capture status code and status line
        int statusCode = response.getStatusCode();
        String statusLine = response.getStatusLine();

        // Log response details into ExtentReport
        test.info("Status Code: " + statusCode);
        test.info("Status Line: " + statusLine);

        try {
            // Validate status code
            Assert.assertEquals(statusCode, 200, "Expected status code 200 for contact list");
            Assert.assertTrue(statusLine.contains("OK"), "Expected 'OK' in status line");

            // If passed, mark test as successful
            test.pass("Contact list fetched successfully. Status 200 OK.");
        } catch (AssertionError e) {
            // If failed, mark the test as failed and log error message
            test.fail("Contact list retrieval failed: " + e.getMessage());
            throw e;
        }
    }

    @AfterSuite
    public void tearDownReport() {
        // Generate Extent report after all tests are completed
        extent.flush();
    }
}