package uibank;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UiBank {

	public static String authID;
	@BeforeMethod
	public void login() {
		
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api";
		RequestSpecification inputRequest = RestAssured.given().contentType("application/json");
		Response response = inputRequest.when().body("{\r\n"
				+ "    \"username\": \"darshanr\",\r\n"
				+ "    \"password\": \"Leaf@1234\"\r\n"
				+ "}").post("/users/login");
		response.prettyPrint();
		 authID = response.jsonPath().get("id");
		System.out.println(authID);
	}
	
	@Test
	public void createAccounts() {
		
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api";
		RequestSpecification inputRequest = RestAssured.given().contentType("application/json")
				.header("authorization",authID);
		Response response = inputRequest.when().body("{\r\n"
				+ "    \"friendlyName\": \"testacc\",\r\n"
				+ "    \"type\": \"savings\",\r\n"
				+ "    \"userId\": \"612ad502f6518100401b5217\",\r\n"
				+ "    \"balance\": 100,\r\n"
				+ "    \"accountNumber\": 15640114\r\n"
				+ "}").post("/accounts");
		response.prettyPrint();
	}
	
	
	
}
