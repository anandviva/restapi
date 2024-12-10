package ParseJSONResponse;


import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*; // These 3 packages static for the rest assured
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

// https://restful-api.dev/
//https://reqres.in/

public class ResponseValidation {
	
	//@Test
	
	void responsebodyApproach1()
	
	{
		
		
		
		given()
		.contentType("application/json")
		
		.when()
	      .get("https://api.restful-api.dev/objects?id=3&id=5&id=10")
		.then()
		 .statusCode(200)
		 .body("[2].data.Capacity", equalTo("64 GB")) // JSON Path finder site - https://www.site24x7.com/tools/jsonpath-finder-validator.html
		 .log().body();
		
	}
	
	//@Test
    void responsebodyApproach2()
	
	{
		
		
		
		Response res = given()
		.contentType("application/json")
		
		.when()
	      .get("https://api.restful-api.dev/objects?id=3&id=5&id=10");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.jsonPath().get("[2].data.Capacity").toString(), "64 GB");
	      
	      
	}
	
	@Test
	 void responsebodyApproach3()
		
		{
			
			
			
			Response res = given()
			.contentType("application/json")
			
			.when()
		      .get("https://reqres.in/api/users?page=2");
			

		   /*  //Convert to string
			
			  JSONObject jo = new JSONObject(res.toString());
			  
			  for(int i=0; i<jo.getJSONArray("data").length(); i++)
				 
			  {
				  
				  String message = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
				  System.out.println(message);
				  
			  }
			  */
			
			
			//https://www.tutorialspoint.com/how-to-iterate-through-and-access-the-json-array-elements-using-rest-assured
			
			
			 //convert JSON to string
		      JsonPath j = new JsonPath(res.asString());
		      
		   

		      //get values of JSON array after getting array size
		      int s = j.getInt("data.size()");
		      for(int i = 0; i < s; i++) {
		         String state = j.getString("data["+i+"].email");
		         
		         if (state.equals("michael.lawson@reqres.in")) 
		         {
		        	 
		        	 System.out.println(state);
		         }
		        
		      }
			  
			  Assert.assertEquals(res.getStatusCode(), 200);

		      
		      
		}
		
	
	

	
}
