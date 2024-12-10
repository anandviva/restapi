package RequestBody;


import static io.restassured.RestAssured.*; // These 3 packages static for the rest assured
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

/* 
 * Different ways to create POST request body
 * 
 * 1) Using Hashmap POST req. body
 * 2) USing org.JSON 
 * 3) POJO Class 
 * 4) External JSON file data
 * 
 * 
 */

public class PostRequestBody {
	
	//@Test
	
	void postRequestBodyHashMap()
	{
		
		// https://stackoverflow.com/questions/20117148/how-to-create-json-object-using-string
		
		/*
		 * Post equest Body
		 * 
		 * {
   "name": "Apple MacBook Pro 16",
   "data": {
      "year": 2019,
      "price": 1849.99,
      "CPU model": "Intel Core i9",
      "Hard disk size": "1 TB"
   }
}
		 * 
		 * 
		 * 
		 */
	
	
	HashMap da = new HashMap();
	da.put("name", "Apple MacBook Pro 16");
	
	HashMap dat = new HashMap(); // data key has multiple values (JSON Object) so we create new object and add it to old object
	dat.put("year", 2019);
	dat.put("price", 1849.99);
	dat.put("CPU model", "Intel Core i9");
	dat.put("Hard disk size", "1 TB");
	
	da.put("data", dat);

			
	
	given()
	  .contentType("application/json")
	  .body(da)
	.when()
	  .post("https://api.restful-api.dev/objects")
	  
	 .then()
	   .statusCode(200)
	   .log().all();
	
	
	   
	
	}
	
	@Test(priority=1)
	
	void postRequestBodyJSONObject() {
		
		
		JSONObject da1 = new JSONObject();
		da1.put("name", "Apple MacBook Pro 16");
		
		JSONObject dat1 = new JSONObject();// data key has multiple values (JSON Object) so we create new object and add it to old object
		dat1.put("year", 2019);
		dat1.put("price", 1849.99);
		dat1.put("CPU model", "Intel Core i9");
		dat1.put("Hard disk size", "1 TB");
		
		da1.put("data", dat1);
		
		String reqbody = da1.toString(); // For JSON object class we need to change toString 

				
		
		given()
		  .contentType("application/json")
		  .body(reqbody)
		.when()
		  .post("https://api.restful-api.dev/objects")
		  
		 .then()
		   .statusCode(200)
		   //.body("id", equalTo("ff80818192925da7019300b7ea246fd4"))
		   .log().all();
		
		
	}
	
	

	
	
	
	
	

}
