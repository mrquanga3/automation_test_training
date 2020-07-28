package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleGetTest {

	@Test
	public void testWrongUserPassword() {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://giamsatkholanh.com";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.POST, "/rest/login/");
		String responseBody = response.getBody().asString();

		System.out.println("Response Body is =>  " + responseBody);
		// System.out.println("Size of list => " + jsonResponse.size());
		String error_code = response.jsonPath().getString("error_code");
		Assert.assertEquals(error_code, "-1");

	}

}
