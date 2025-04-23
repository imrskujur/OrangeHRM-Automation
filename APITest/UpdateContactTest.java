package com.APITest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.*;

public class UpdateContactTest {

    private static ExtentReports extent;
    private static ExtentTest test;
    private String token;
    private String contactId;

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("UpdateContactReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
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
        Assert.assertEquals(response.getStatusCode(), 200, "Login failed");
    }

    @Test(priority = 1)
    public void createContact() {
        test = extent.createTest("Create Contact");

        String createPayload = "{\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"birthdate\": \"1980-01-01\",\n" +
                "  \"email\": \"john.doe@example.com\",\n" +
                "  \"phone\": \"1234567890\",\n" +
                "  \"street1\": \"100 Main St\",\n" +
                "  \"street2\": \"\",\n" +
                "  \"city\": \"Anytown\",\n" +
                "  \"stateProvince\": \"CA\",\n" +
                "  \"postalCode\": \"12345\",\n" +
                "  \"country\": \"USA\"\n" +
                "}";

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(createPayload)
                .post("/contacts");

        contactId = response.jsonPath().getString("_id");

        test.info("Created Contact ID: " + contactId);
        Assert.assertEquals(response.getStatusCode(), 201, "Contact creation failed");
    }

    @Test(priority = 2, dependsOnMethods = "createContact")
    public void updateContact() {
        test = extent.createTest("Update Contact");

        String updatePayload = "{\n" +
                "  \"firstName\": \"Amy\",\n" +
                "  \"lastName\": \"Miller\",\n" +
                "  \"birthdate\": \"1992-02-02\",\n" +
                "  \"email\": \"amiller@fake.com\",\n" +
                "  \"phone\": \"8005554242\",\n" +
                "  \"street1\": \"13 School St.\",\n" +
                "  \"street2\": \"Apt. 5\",\n" +
                "  \"city\": \"Washington\",\n" +
                "  \"stateProvince\": \"QC\",\n" +
                "  \"postalCode\": \"A1A1A1\",\n" +
                "  \"country\": \"Canada\"\n" +
                "}";

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(updatePayload)
                .put("/contacts/" + contactId);

        System.out.println("Update Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        test.info("Update Status: " + response.getStatusCode());
        test.info("Response: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200, "Update failed");
        Assert.assertEquals(response.jsonPath().getString("email"), "amiller@fake.com", "Email not updated correctly");

        test.pass("Contact updated successfully.");
    }

    @AfterSuite
    public void tearDown() {
        extent.flush();
    }
}