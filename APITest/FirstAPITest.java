package com.APITest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstAPITest {

	@Test
	public void testSingleListUser() {

		// RestAssured is class in RestAssured library
		// Response is an interface in library.

		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		// System.out.println("Response asString " + res.asString()); // this function
		// return the request response in from
		// of string

		//System.out.println("response code/ status " + res.statusCode());// return status code 200/201/500/400
		//System.out.println("header type " + res.getHeader("Content-Type"));

		//System.out.println("Pretty print or json format --" + res.asPrettyString());

		// validate status code
		int actualstatusCode = res.getStatusCode();
		Assert.assertEquals(actualstatusCode, 200, "Actual status code is not matched with expected, please verify");
		System.out.println("testcases passed!");
	}
}