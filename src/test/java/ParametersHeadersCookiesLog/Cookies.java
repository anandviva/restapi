package ParametersHeadersCookiesLog;

import static io.restassured.RestAssured.*; // These 3 packages static for the rest assured
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookies {
	

	
	
//@Test (priority=2)
	
	void testCookies()
	{
		
		given()	
		
		.when()
		
		   .get("https://www.google.com/")
		    
		.then()
		.cookie("AEC", "w2AWtcG4V6UQcNh6fbLcG-im5yAtLBk") //Cookies keep changing every time if this case failed then it's passed
		.log().cookies();
		
	}

@Test (priority=1)

void getCookiesInfo()
{
	
	Response res = given()	// get the response in res variable  response class
	
	.when()
	
	   .get("https://www.google.com/");
	
	//get a single cookie
	
   String cookiee_value = res.getCookie("AEC");
   System.out.println("Cookie value of AEC is"+ cookiee_value);
	
	//get all cookies
	
	Map<String, String> cookies_values =res.getCookies();
	
	for(String k :cookies_values.keySet())
	{
	
		String cookie_value = res.getCookie(k);
		System.out.println("Cookie value of is" + k +" "+cookie_value);
	}
	
}
	
	
	   
	   
	   
	    




	
	
	
}
