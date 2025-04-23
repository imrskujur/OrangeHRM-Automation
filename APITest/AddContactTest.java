package com.APITest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddContactTest {

    private static ExtentReports extent;
    private static ExtentTest test;
    private String token;

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-add-contact-report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @BeforeClass
    public void loginAndGetToken() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

        String loginPayload = "{\n" +
                "  \"email\": \"imrskujur@gmail.com\",\n" +
                "  \"password\": \"Apple.123\"\n" +
                "}";

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(loginPayload)
                .post("/users/login");

        token = response.jsonPath().getString("token");

        Assert.assertEquals(response.getStatusCode(), 200, "Login failed, cannot fetch token.");
    }

    @Test
    public void testAddContact() {
        test = extent.createTest("Add Contact API Test");

        // Payload for new contact
        String contactPayload = "{\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"birthdate\": \"1970-01-01\",\n" +
                "  \"email\": \"jdoe" + System.currentTimeMillis() + "@fake.com\",\n" +  // Make email unique
                "  \"phone\": \"8005555555\",\n" +
                "  \"street1\": \"1 Main St.\",\n" +
                "  \"street2\": \"Apartment A\",\n" +
                "  \"city\": \"Anytown\",\n" +
                "  \"stateProvince\": \"KS\",\n" +
                "  \"postalCode\": \"12345\",\n" +
                "  \"country\": \"USA\"\n" +
                "}";

        RequestSpecification request = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(contactPayload)
                .log().all();

        Response response = request.post("/contacts");

        // Log response
        response.then().log().all();

        int statusCode = response.getStatusCode();
        String statusLine = response.getStatusLine();

        test.info("Status Code: " + statusCode);
        test.info("Status Line: " + statusLine);

        try {
            Assert.assertEquals(statusCode, 201, "Expected status code 201 for created contact");
            Assert.assertTrue(statusLine.contains("Created"), "Expected 'Created' in status line");
            test.pass("Contact created successfully. Status 201 Created.");
        } catch (AssertionError e) {
            test.fail("Contact creation failed: " + e.getMessage());
            throw e;
        }
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}