package com.APITest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginUserTest {

    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-login-report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @Test
    public void testLoginUser() {
        test = extent.createTest("Log In User API Test");

        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

        // Login Payload
        String loginPayload = "{\n" +
                "  \"email\": \"imrskujur@gmail.com\",\n" +
                "  \"password\": \"Apple.123\"\n" +
                "}";

        RequestSpecification request = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(loginPayload)
                .log().all();

        Response response = request.post("/users/login");

        // Log response
        response.then().log().all();

        int statusCode = response.getStatusCode();
        String statusLine = response.getStatusLine();

        test.info("Status Code: " + statusCode);
        test.info("Status Line: " + statusLine);

        try {
            Assert.assertEquals(statusCode, 200, "Expected status code 200");
            Assert.assertTrue(statusLine.contains("OK"), "Expected status line to contain 'OK'");
            test.pass("Login successful. Status 200 OK.");
        } catch (AssertionError e) {
            test.fail("Login failed: " + e.getMessage());
            throw e;
        }
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}