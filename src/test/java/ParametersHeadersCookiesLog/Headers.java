package ParametersHeadersCookiesLog;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*; // These 3 packages static for the rest assured
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Headers {
	
	
	@Test (priority=1)
	
		void testCookies()
		{
			
			given()	
			
			.when()
			
			   .get("https://www.google.com/")
			    
			.then()
			.cookie("AEC", "w2AWtcG4V6UQcNh6fbLcG-im5yAtLBk") //Cookies keep changing every time if this case failed then it's passed
			.log().cookies();
			
		}

}
