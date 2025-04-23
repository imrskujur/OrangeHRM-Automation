package com.APITest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.*;

public class PatchUpdateContactTest {

    private static ExtentReports extent;
    private static ExtentTest test;
    private String token;
    private String contactId;

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("PatchUpdateContactReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @BeforeClass
    public void loginAndCreateContact() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

        // Login
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

        // Create a contact to patch
        String createPayload = "{\n" +
                "  \"firstName\": \"Initial\",\n" +
                "  \"lastName\": \"User\",\n" +
                "  \"birthdate\": \"1990-01-01\",\n" +
                "  \"email\": \"initial.user@fake.com\",\n" +
                "  \"phone\": \"1234567890\",\n" +
                "  \"street1\": \"10 Downing St\",\n" +
                "  \"street2\": \"\",\n" +
                "  \"city\": \"London\",\n" +
                "  \"stateProvince\": \"LDN\",\n" +
                "  \"postalCode\": \"SW1A 2AA\",\n" +
                "  \"country\": \"UK\"\n" +
                "}";

        Response createResponse = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(createPayload)
                .post("/contacts");

        contactId = createResponse.jsonPath().getString("_id");
        Assert.assertEquals(createResponse.getStatusCode(), 201, "Contact creation failed");
    }

    @Test
    public void patchUpdateFirstName() {
        test = extent.createTest("PATCH Update Contact First Name");

        String patchPayload = "{ \"firstName\": \"Anna\" }";

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(patchPayload)
                .patch("/contacts/" + contactId);

        // Debug logs
        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        test.info("PATCH Response Code: " + response.getStatusCode());
        test.info("PATCH Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 OK for PATCH");
        Assert.assertEquals(response.jsonPath().getString("firstName"), "Anna", "First name not updated");

        test.pass("PATCH update successful and validated.");
    }

    @AfterSuite
    public void teardown() {
        extent.flush();
    }
}