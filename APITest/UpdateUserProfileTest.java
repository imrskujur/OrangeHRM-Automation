package com.APITest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.*;

public class UpdateUserProfileTest {

    private static ExtentReports extent;
    private static ExtentTest test;
    private String token;

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-update-user-report.html");
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
        Assert.assertEquals(response.getStatusCode(), 200, "Login failed. Check credentials.");
    }

    @Test
    public void testUpdateUserProfile() {
        test = extent.createTest("Update User Profile API Test");

        // Request Payload
        String email = "test" + System.currentTimeMillis() + "@fake.com";
        String updatePayload = "{\n" +
            "  \"firstName\": \"Updated\",\n" +
            "  \"lastName\": \"Username\",\n" +
            "  \"email\": \"" + email + "\",\n" +
            "  \"password\": \"myNewPassword\"\n" +
            "}";

        RequestSpecification request = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(updatePayload)
                .log().all();

        Response response = request.patch("/users/me");

        // Log response
        response.then().log().all();

        int statusCode = response.getStatusCode();
        String statusLine = response.getStatusLine();

        test.info("Status Code: " + statusCode);
        test.info("Status Line: " + statusLine);

        try {
            Assert.assertEquals(statusCode, 200, "Expected status code 200");
            Assert.assertTrue(statusLine.contains("OK"), "Expected status line to contain 'OK'");
            test.pass("User profile updated successfully and validated.");
        } catch (AssertionError e) {
            test.fail("Update failed: " + e.getMessage());
            throw e;
        }
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}