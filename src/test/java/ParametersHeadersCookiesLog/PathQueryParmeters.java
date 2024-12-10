package ParametersHeadersCookiesLog;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*; // These 3 packages static for the rest assured
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathQueryParmeters {
	
	//https://reqres.in/api/users?page=2&id=5
	
	
	@Test
	
	void pathQueryParameters()
	{
		
		given()
		  .pathParam("path of API 1", "api")
		  .pathParam("path of API 2", "users")
		  .queryParam("page", 2)
		   .queryParam("id", 7)
		  
		
		
		.when()
		    .get("https://reqres.in/{path of API 1}/{path of API 2}") // No need to pass query param but have to pass path param
		.then()
		.statusCode(200)
		  .log().body()
		  .log().status();
		  
		
		
	}

}
