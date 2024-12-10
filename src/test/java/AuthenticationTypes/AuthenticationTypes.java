package AuthenticationTypes;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*; // These 3 packages static for the rest assured
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
/*
Authentication - user valid or not

Authorization - Check the access/permission


Authentication Types

1. Basic
2. Digest
3. Preemptive
4. Bearer Token
5. Auth 1.O 2.O
6. API Key



*/


// Sample API -https://postman-echo.com/


public class AuthenticationTypes {
	
	@Test (priority =1)
	void basicAuthentication()
	{
		given()
		   .auth().basic("postman", "password") // username and password
		.when()
		   .get("https://postman-echo.com/basic-auth")
		.then()
		   .statusCode(200)
		   .log().all()
		   .body("authenticated", equalTo(true));
		  
		
	}
	
	@Test (priority =2)
	void digetAuthentication()
	{
		given()
		   .auth().digest("postman", "password") // username and password
		.when()
		   .get("https://postman-echo.com/basic-auth")
		.then()
		   .statusCode(200)
		   .log().all()
		   .body("authenticated", equalTo(true));
		  
		
	}
	
	@Test (priority =3)
	void preemptiveAuthentication()
	{
		given()
		   .auth().preemptive().basic("postman", "password") // username and password
		.when()
		   .get("https://postman-echo.com/basic-auth")
		.then()
		   .statusCode(200)
		   .log().all()
		   .body("authenticated", equalTo(true));
		  
		
	}
	
	@Test (priority =4)
	void bearerAuthentication()
	{
		
		String bearert = "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"; // access the git hubrepos 
		given()
		  .headers("Authorization", "Bearer "+ bearert)
		.when()
		   .get("https://api.github.com/user/repos")
		.then()
		   .statusCode(200)
		   .log().all();  
		  
		
	}
	
	
	
	@Test (priority =5)
	void apiKeyAuthentication()
	{
		
		//For testing API key we used weather API to generate key first and use the API 
		
		
		given()
		  .queryParam("appid", "44abaa2f022223168adb2e331ef1a724") // sometimes authentication passed in header/ query param too.
		 .pathParam("mypath", "data/2.5/weather")
		 .queryParam("lat", 44.34)
		 .queryParam("lon", 10.99)
		 
		.when()
		   .get("https://api.openweathermap.org/{mypath}")
		.then()
		   .statusCode(200)
		   .log().all();  
		  
		
	}
	
	
	
	
	

}
