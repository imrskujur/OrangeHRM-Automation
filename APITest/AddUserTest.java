package com.APITest;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddUserTest {

    ExtentReports extent;
    ExtentTest test;

    @BeforeSuite
    public void setupExtentReport() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport_" + timestamp + ".html");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Project", "com.APITest");
        extent.setSystemInfo("Tester", "Rashmi");
    }

    @Test
    public void addUserTest() {
        test = extent.createTest("Add User API Test")
                .assignCategory("API Test")
                .assignAuthor("Rashmi");

        try {
            RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

            String uniqueEmail = "test" + System.currentTimeMillis() + "@fake.com";

            String payload = "{"
                    + "\"firstName\": \"Test\","
                    + "\"lastName\": \"User\","
                    + "\"email\": \"" + uniqueEmail + "\","
                    + "\"password\": \"myPassword\""
                    + "}";

            Response response = RestAssured
                    .given()
                    .header("Content-Type", "application/json")
                    .body(payload)
                    .when()
                    .post("/users");

            test.info("Request sent to create user with email: " + uniqueEmail);
            test.info("Response Body:\n" + response.asPrettyString());

            Assert.assertEquals(response.statusCode(), 201);
            test.pass("Status code is 201 - Created");

            Assert.assertTrue(response.statusLine().contains("Created"));
            test.pass("Status line contains 'Created'");

        } catch (AssertionError e) {
            test.fail("Test failed with AssertionError: " + e.getMessage());
            Assert.fail(e.getMessage());
        } catch (Exception e) {
            test.fail("Test failed with Exception: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @AfterSuite
    public void tearDownExtentReport() {
        extent.flush();
    }
}
