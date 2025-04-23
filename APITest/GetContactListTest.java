package com.APITest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.*;

public class GetContactListTest {

    private static ExtentReports extent;
    private static ExtentTest test;
    private String token;

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-get-contact-list-report.html");
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

        Assert.assertEquals(response.getStatusCode(), 200, "Login failed. Could not retrieve token.");
    }

    @Test
    public void testGetContactList() {
        test = extent.createTest("Get Contact List API Test");

        RequestSpecification request = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .log().all();

        Response response = request.get("/contacts");

        // Log response
        response.then().log().all();

        int statusCode = response.getStatusCode();
        String statusLine = response.getStatusLine();

        test.info("Status Code: " + statusCode);
        test.info("Status Line: " + statusLine);

        try {
            Assert.assertEquals(statusCode, 200, "Expected status code 200 for contact list");
            Assert.assertTrue(statusLine.contains("OK"), "Expected 'OK' in status line");
            test.pass("Contact list fetched successfully. Status 200 OK.");
        } catch (AssertionError e) {
            test.fail("Contact list retrieval failed: " + e.getMessage());
            throw e;
        }
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}
