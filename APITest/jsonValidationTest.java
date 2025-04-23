package com.APITest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class jsonValidationTest {

	@Test
	public void singleUserTest() {

		Response res = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println("print pretty json response " + res.asPrettyString());

		// to validate json path
		int id = res.jsonPath().getInt("data.id");
		Assert.assertEquals(id, 2, "id is not matched");
		System.out.println("Json path id matched");
		
		
		String firstname = res.jsonPath().getString("data.first_name");
		Assert.assertEquals(firstname, "Janet");
		
		System.out.println("firstname is matched");
		
		
		String supportText = res.jsonPath().getString("support.text");
		Assert.assertTrue(supportText.contains("endless"),"not matched, please verify");
		
		
		
		
		
	}
}